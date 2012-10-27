package edu.utdallas.gamegenerator.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.utdallas.gamegenerator.Model.GameGeneratorInfo;
import edu.utdallas.gamegenerator.Model.UserProfileConfiguration;
import edu.utdallas.gamegenerator.constants.ApplicationConstants;
import edu.utdallas.gamegenerator.service.ManageGameGeneratorService;

/**
 * @author Meyy
 *
 */
@Controller
public class ManageUserProfileController  {
	
	
	private static final String PLAYER_CHARACTERS = "Player Characters";
	
	private static final Logger LOG = Logger.getLogger(ManageUserProfileController.class);
	
	private ManageGameGeneratorService manageGameGeneratorService;
	
	
	/**
	 * 
	 * This method redirects the control to homepage 
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/gameGen.htm", method = RequestMethod.GET)
	public ModelAndView manageHomePage(HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		return new ModelAndView("welcomepage");
	}
	
	
	/**
	 * 
	 * This method redirects the control to user page 
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/userProfile.htm", method = RequestMethod.GET)
	public ModelAndView manageUserProfile(HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		return new ModelAndView("homepage");
	}
	
	/**
	 * 
	 * This method redirects the control to configure user profile screen
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/configureProfile.htm", method = RequestMethod.GET)
	public ModelAndView configureUserProfile(HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		UserProfileConfiguration userProfileConfig = (UserProfileConfiguration) session.getAttribute("userProfileConfiguration");
		if(null == currentGameGenInfo)
		{
			currentGameGenInfo =  new GameGeneratorInfo();
		}
		if(null == userProfileConfig)
		{
			userProfileConfig = new UserProfileConfiguration();
		}
		currentGameGenInfo.setUserProfileConfiguration(userProfileConfig);
		return new ModelAndView("customprofile","UserProfileConfiguration", userProfileConfig  );
	}
	
	
	
	/**
	 * 
	 * This method fetches existing player characters from game asset repository and displays it on the page
	 * 
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/selectProfile.htm", method = RequestMethod.GET)
	public ModelAndView selectUserProfile(HttpServletRequest request, HttpSession session, ModelMap model)			
	{
		Map<String, String> fileList = (Map<String, String>) session.getAttribute("playerCharacters");
		if(null == fileList)
		{
			final File folder = new File("C:\\Users\\Meyy\\Downloads\\GameAssetRepository\\GameAssetRepository\\Office, Classroom\\Visual\\Characters\\Player Characters");
			fileList = new HashMap<String, String>();
			try 
			{
				listFilesForFolder(folder,fileList,true);
			} catch (IOException e) {
				LOG.error("IO Exception while accesing game asset repository", e);
			}
			if(fileList.size() > 0)
			{
				session.setAttribute("playerCharacters", fileList);
			}
		}
		return new ModelAndView("existingprofiles");
	}
	
	/**
	 * 
	 * This method displays the summary page of selected player characters before submission
	 * 
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectProfile.htm", method = RequestMethod.POST)
	public ModelAndView previewPlayerCharProfile(HttpServletRequest request, HttpSession session, ModelMap model)			
	{
		session.setAttribute("selectedPlayerCharacters", null);
		String strSelectedProfiles = request.getParameter("selectedProfiles");
		if(null != strSelectedProfiles && !"".equals(strSelectedProfiles.trim()))
		{
			String[] selProfiles = strSelectedProfiles.split(":");
			List<String> existingPlayerCharacter = null;
			if(selProfiles.length > 0)
			{
				existingPlayerCharacter = new ArrayList<String>();
				for (String profile : selProfiles) {
					existingPlayerCharacter.add(profile);
				}
				session.setAttribute("selectedPlayerCharacters", existingPlayerCharacter);
			}
		}
		return new ModelAndView("playerCharacterSummary");
	}
	
	
	
	/**
	 * 
	 * This method submits the selected player characters and generates XML 
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/submitPlayerCharProfile.htm", method = RequestMethod.POST)
	public ModelAndView submitPreSelectedProfile(HttpServletRequest request, HttpSession session, ModelMap model)			
	{
		
		@SuppressWarnings("unchecked")
		List<String> selPlayersList = (List<String>) session.getAttribute("selectedPlayerCharacters");
		GameGeneratorInfo gameGeneratorInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		if(null == gameGeneratorInfo)
		{
			gameGeneratorInfo = new GameGeneratorInfo();	
		}
		if(null != selPlayersList && selPlayersList.size() > 0)
		{
			UserProfileConfiguration userProfileConfig = new UserProfileConfiguration();				
			userProfileConfig.setExistingPlayerCharacter(selPlayersList);
			gameGeneratorInfo.setUserProfileConfiguration(userProfileConfig);
			manageGameGeneratorService.generateXML(gameGeneratorInfo);
			
		}
		session.setAttribute("selectedPlayerCharacters", null);
		session.setAttribute("userProfileConfiguration", null);
		session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO,gameGeneratorInfo);
		return new ModelAndView("welcomepage");
		
	}
	
	
	/**
	 * This method displays the skip profile page
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/noProfile.htm", method = RequestMethod.GET)
	public ModelAndView noProfile(HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		return new ModelAndView("skipprofile");
	}
	
	
	/**
	 * 
	 * This method retrieves the user profile configuration from the view and displays the summary page
	 * 
	 * @param userProfileConfiguration
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/configureProfile.htm", method = RequestMethod.POST)
	public ModelAndView submitUserProfileConfig(@ModelAttribute("UserProfileConfiguration") UserProfileConfiguration userProfileConfiguration,HttpServletRequest request, HttpSession session, ModelMap model)			
	{
		LOG.info("Name : " + userProfileConfiguration.isName());
		LOG.info("Full Name : " + userProfileConfiguration.isFullName());
		LOG.info("Nick Name : " + userProfileConfiguration.isNickName());
		LOG.info("Age : " + userProfileConfiguration.isAge());
		LOG.info("Country : " + userProfileConfiguration.isCountry());
		LOG.info("Profile Picture : " + userProfileConfiguration.isProfilePicture());
		LOG.info("Language Preference  : " + userProfileConfiguration.isLanguagePreference());
		
		//manageUserProfileService.generateXML(userProfileConfiguration);
		session.setAttribute("userProfileConfiguration", userProfileConfiguration);
		
		return new ModelAndView("profilesummary");
	}
	
	
	
	/**
	 * This method retrieves the user profile configuration from the view and generates the game engine input xml
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/confirmProfileConfig.htm", method = RequestMethod.POST)
	public ModelAndView confirmUserProfileConfig(HttpServletRequest request, HttpSession session, ModelMap model)			
	{
		LOG.info("Inside confirmUserProfileConfig method!!");
		UserProfileConfiguration userProfileConfig = (UserProfileConfiguration) session.getAttribute("userProfileConfiguration");
		GameGeneratorInfo gameGeneratorInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		if(null == gameGeneratorInfo)
		{
			gameGeneratorInfo = new GameGeneratorInfo();	
		}
		
		if(null != userProfileConfig)
		{
			gameGeneratorInfo.setUserProfileConfiguration(userProfileConfig);
			manageGameGeneratorService.generateXML(gameGeneratorInfo);
		}
		session.setAttribute("userProfileConfiguration", null);
		session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO,gameGeneratorInfo);
		return new ModelAndView("welcomepage");
	}
	
	
	
	/**
	 * 
	 * This method retrieves the player character details from the game asset repository
	 * 
	 * @param folder
	 * @param fileList
	 * @param flag
	 * @throws IOException
	 */
	
	public static void listFilesForFolder(final File folder, Map<String, String> fileList, boolean flag) throws IOException 
	{
	    
	    String parentFolderName = null;
		for (final File fileEntry : folder.listFiles()) 
		{
	        if (fileEntry.isDirectory()) 
	        {
	        	if(flag)
	        	{
		        	LOG.info(fileEntry.getName());	
		        	fileList.put(fileEntry.getName(), null);
		        	parentFolderName = fileEntry.getParentFile().getName();
		        	if(parentFolderName.equalsIgnoreCase(PLAYER_CHARACTERS))
		        	{	        		
			            listFilesForFolder(fileEntry, fileList,false);		          
		        	}
	        	}
	        } 
	        else 
	        {
	            LOG.info(fileEntry.getName());
	            String absolutePath = fileEntry.getAbsolutePath();
	            absolutePath.replaceAll("\\\\", "/");
				fileList.put(fileEntry.getParentFile().getName(), absolutePath);
	            break;
	        }	       
	   }
	}


	/**
	 * @return the manageGameGeneratorService
	 */
	public ManageGameGeneratorService getManageGameGeneratorService() {
		return manageGameGeneratorService;
	}


	/**
	 * @param manageGameGeneratorService the manageGameGeneratorService to set
	 */
	public void setManageGameGeneratorService(
			ManageGameGeneratorService manageGameGeneratorService) {
		this.manageGameGeneratorService = manageGameGeneratorService;
	}

	

}
