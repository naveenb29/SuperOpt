package edu.utdallas.gamegenerator.controller;

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

import edu.utdallas.gamegenerator.Model.Act;
import edu.utdallas.gamegenerator.Model.GameGeneratorInfo;
import edu.utdallas.gamegenerator.Model.QuestionInfo;
import edu.utdallas.gamegenerator.Model.Scene;
import edu.utdallas.gamegenerator.Model.Screen;
import edu.utdallas.gamegenerator.constants.ApplicationConstants;
import edu.utdallas.gamegenerator.constants.ScreenType;
import edu.utdallas.gamegenerator.service.ManageGameGeneratorService;
import edu.utdallas.gamegenerator.util.Utility;

@Controller
public class ManageGameElementConfigController {

	
	private static final Logger LOG = Logger.getLogger(ManageGameElementConfigController.class);
	
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
	@RequestMapping(value = "/actInfo.htm", method = RequestMethod.GET)
	public ModelAndView manageGameProfile(HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		List<Act> populateAct = Utility.populateAct();
		session.setAttribute("ActList", populateAct);
		
		return new ModelAndView("ConfigureActDetails");
	}
	
	
	/**
	 * 
	 * This method redirects the control to number of act configuration
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/configureActs.htm", method = RequestMethod.GET)
	public ModelAndView getActInfo(HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		GameGeneratorInfo gameGeneratorInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		if(null == gameGeneratorInfo)
		{
			gameGeneratorInfo = new GameGeneratorInfo();
			session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, gameGeneratorInfo);
		}	
		
		return new ModelAndView("ActsConfig",ApplicationConstants.GAME_GENERATOR_INFO,gameGeneratorInfo);
	}
	
	
	/**
	 * 
	 * This method receives number of acts from the view
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/submitActsInfo.htm", method = RequestMethod.POST)
	public ModelAndView submitActInfo(@ModelAttribute(ApplicationConstants.GAME_GENERATOR_INFO) GameGeneratorInfo gameGeneratorInfo,HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		List<Act> actList = null;
		
		if(null != gameGeneratorInfo)
		{
			
			String noOfActs = gameGeneratorInfo.getNoOfActs();
			if(null != noOfActs && !"".equals(noOfActs.trim()))
			{
				actList = new ArrayList<Act>();
				Act act = null;
				int iNoOfActs = Integer.parseInt(noOfActs);
				if(iNoOfActs > 0)
				{
					for (int i = 1; i<=iNoOfActs; i++) 
					{
						act = new Act("act"+i, "Act "+i);
						actList.add(act);					
					}
				}
			}
		}
		GameGeneratorInfo currentgameGeneratorInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		if(null != currentgameGeneratorInfo)
		{
			currentgameGeneratorInfo.setActList(actList);
			session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, currentgameGeneratorInfo);
		}
		else
		{
			gameGeneratorInfo.setActList(actList);
			session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, gameGeneratorInfo);
		}
	
		return new ModelAndView("ListActs");
	}
	
	

	/**
	 * 
	 * This method redirects the control to number of act configuration
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/getSceneConfigForAct.htm", method = RequestMethod.GET)
	public ModelAndView getSceneConfig(@ModelAttribute(ApplicationConstants.GAME_GENERATOR_INFO) GameGeneratorInfo gameGeneratorInfo, HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		Act act = null;
		if(null != gameGeneratorInfo)
		{
			String actId = gameGeneratorInfo.getSelElement();
			System.out.println("From get method :" + actId);
			
			GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
			if(null != currentGameGenInfo)
			{
				List<Act> actList = currentGameGenInfo.getActList();
				if(null != actList && actList.size() > 0)
				{
					for (Act act1 : actList) 
					{
						if(act1.getActId().equalsIgnoreCase(actId))
						{
							act = act1;
						}
						else
						{	
							act1.setDefaultStyle(null);						
						}
					}
				}
			}
		}
		if(null == act)
		{
			act = new Act();
		}
		act.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
		return new ModelAndView("GetSceneCountConfig","Act",act);
	}
	

	
	
	/**
	 * 
	 * This method redirects the control to number of act configuration
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/submitScenesInfo.htm", method = RequestMethod.POST)
	public ModelAndView submitSceneConfig(@ModelAttribute("Act") Act act,HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		GameGeneratorInfo gameGeneratorInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		List<Scene> sceneList = null;
		if(null != act)
		{
			
			int noOfScenes = act.getNoOfScenes();
			if(noOfScenes > 0)
			{
				System.out.println("Selected Scene count : + "+ noOfScenes);
				System.out.println("Selected Act Id 1 : + "+ act.getActId());
				sceneList = new ArrayList<Scene>();
				StringBuffer sceneId = null; // Combination of Actid and count
							
				for (int i = 1; i <= noOfScenes; i++) 
				{
					sceneId = new StringBuffer(); 
					sceneId.append(act.getActId());
					sceneId.append("_");	
					sceneId.append("scene"+i);
					Scene scene = new Scene(sceneId.toString(),"Scene "+i);
					sceneList.add(scene);
					
				}
				gameGeneratorInfo = populateActWithConfigDetails(act,gameGeneratorInfo, sceneList, noOfScenes);
			}
			else
			{
				gameGeneratorInfo = populateActWithConfigDetails(act,gameGeneratorInfo, null, noOfScenes);
			}
		}
		session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, gameGeneratorInfo);
		return new ModelAndView("ListActs",ApplicationConstants.GAME_GENERATOR_INFO, gameGeneratorInfo);
	}


	/**
	 * @param act
	 * @param gameGeneratorInfo
	 * @param sceneList
	 * @param noOfScenes
	 * @return
	 */
	private GameGeneratorInfo populateActWithConfigDetails(Act act,
			GameGeneratorInfo gameGeneratorInfo, List<Scene> sceneList,
			int noOfScenes) {
		if(null != gameGeneratorInfo)
		{
			List<Act> actList = gameGeneratorInfo.getActList();
			for (Act act2 : actList) {
				if(act2.getActId().equalsIgnoreCase(act.getActId()))
				{
					act2.setNoOfScenes(noOfScenes);
					act2.setSceneList(sceneList);
				}
			}
		}
		else{
			gameGeneratorInfo = new GameGeneratorInfo();
			List<Act> actList = new ArrayList<Act>();
			act.setSceneList(sceneList);
			actList.add(act);
			gameGeneratorInfo.setActList(actList);
		}
		return gameGeneratorInfo;
	}
	
	
	/**
	 * 
	 * This method redirects the control to number of act configuration
	 * 
	 * @param request
	 * @param session
	 * @param model
	 * @param session1
	 * @return
	 */
	@RequestMapping(value = "/getScreenCountConfig.htm", method = RequestMethod.GET)
	public ModelAndView getScreenCountConfig(@ModelAttribute(ApplicationConstants.GAME_GENERATOR_INFO) GameGeneratorInfo gameGeneratorInfo, HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		Scene scene = null;
		if(null != gameGeneratorInfo)
		{
			String selectedSceneId = gameGeneratorInfo.getSelElement();
			System.out.println("From getScreenCountConfig :" + selectedSceneId);
			String[] idArr = selectedSceneId.split("_");
			String currentActId = idArr[0];
			
			GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
			if(null != currentGameGenInfo)
			{
				List<Act> actList = currentGameGenInfo.getActList();
				if(null != actList && actList.size() > 0)
				{
					for (Act act : actList) {
						if(act.getActId().equalsIgnoreCase(currentActId))
						{
							for (Scene currentScene : act.getSceneList()) 
							{
								if(currentScene.getSceneId().equalsIgnoreCase(selectedSceneId))
								{
									scene = currentScene;
									act.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
									scene.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
								}else
								{									
									currentScene.setDefaultStyle(null);
								}
							}
						}
						else{
							act.setDefaultStyle(null);
						}
					}
				}
			}
		}
		if(null == scene)
		{
			scene = new Scene();
		}
		return new ModelAndView("GetSceneBackDropScreenCountConfig","Scene",scene);
	}
	

	@RequestMapping(value = "/submitScreenCountConfig.htm", method = RequestMethod.POST)
	public ModelAndView submitScreenCountConfig(@ModelAttribute("Scene") Scene scene, HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{

		GameGeneratorInfo gameGeneratorInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		List<Screen> screenList = null;
		System.out.println("Scene Id :" + scene.getSceneId());
		if(null != scene)
		{
			String sceneId = scene.getSceneId();
			String[] idArr = sceneId.split("_");
			String currentActId = idArr[0];
			int noOfScreens = scene.getNoOfScreens();
			if(noOfScreens > 0)
			{
				System.out.println("Selected Scene count : + "+ noOfScreens);
				System.out.println("Selected Scene Id : + "+ scene.getSceneId());
				screenList = new ArrayList<Screen>();
				StringBuffer screenId = null;
				for (int i = 1; i <= noOfScreens; i++) 
				{
					screenId = new StringBuffer(); 
					screenId.append(sceneId);
					screenId.append("_");
					screenId.append("screen"+i);
					Screen screen = new Screen(screenId.toString(),"Screen "+i);
					screenList.add(screen);
				}
				gameGeneratorInfo = populateSceneWithConfigDetails(scene, gameGeneratorInfo, screenList, sceneId, currentActId,	noOfScreens);
			}
			else
			{
				gameGeneratorInfo = populateSceneWithConfigDetails(scene, gameGeneratorInfo, null, sceneId, currentActId,	noOfScreens);
			}
		}
		session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, gameGeneratorInfo);
		return new ModelAndView("ListActs",ApplicationConstants.GAME_GENERATOR_INFO, gameGeneratorInfo);
	
	}


	/**
	 * @param scene
	 * @param gameGeneratorInfo
	 * @param screenList
	 * @param sceneId
	 * @param currentActId
	 * @param noOfScreens
	 * @return
	 */
	private GameGeneratorInfo populateSceneWithConfigDetails(Scene scene, GameGeneratorInfo gameGeneratorInfo, List<Screen> screenList,	String sceneId, String currentActId, int noOfScreens) 
	{
		List<Scene> sceneList;
		if(null != currentActId && !"".equals(currentActId.trim()))
		{
			if(null != gameGeneratorInfo)
			{
				List<Act> actList = gameGeneratorInfo.getActList();
				for (Act act : actList) {
					if(act.getActId().equalsIgnoreCase(currentActId))
					{
						sceneList = act.getSceneList();
						for (Scene currentScene : sceneList) {
							if(currentScene.getSceneId().equalsIgnoreCase(sceneId))
							{
								currentScene.setBackdrop(scene.getBackdrop());
								currentScene.setNoOfScreens(noOfScreens);
								currentScene.setScreenList(screenList);
							}
						}
					}
				}
			}
			else{
				gameGeneratorInfo = new GameGeneratorInfo();
				Act act = new Act(currentActId,currentActId);
				Scene scene1 = new Scene(scene.getSceneId(),scene.getSceneName());
				List<Act> actList = new ArrayList<Act>();
				sceneList = new ArrayList<Scene>();
				scene1.setScreenList(screenList);
				sceneList.add(scene1);
				act.setSceneList(sceneList);
				actList.add(act);
				gameGeneratorInfo.setActList(actList);
			}
		}
		return gameGeneratorInfo;
	}
	
	@RequestMapping(value = "/getScreenConfig.htm", method = RequestMethod.GET)
	public ModelAndView getScreenTypeConfig(@ModelAttribute(ApplicationConstants.GAME_GENERATOR_INFO) GameGeneratorInfo gameGeneratorInfo,HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		Screen screen = null;
		GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		if(null != gameGeneratorInfo)
		{
			String selectedScreenId = gameGeneratorInfo.getSelElement();
			System.out.println("From getScreenCountConfig :" + selectedScreenId);
			String[] idArr = selectedScreenId.split("_");
			String currentActId = idArr[0];
			String currentSceneId = idArr[1];
			
			if(null != currentGameGenInfo)
			{
				List<Act> actList = currentGameGenInfo.getActList();
				if(null != actList && actList.size() > 0)
				{
					for (Act act : actList) {
						if(act.getActId().equalsIgnoreCase(currentActId))
						{
							for (Scene currentScene : act.getSceneList()) 
							{
								if(currentScene.getSceneId().equalsIgnoreCase(currentActId+"_"+currentSceneId))
								{
									for (Screen screen1 : currentScene.getScreenList()) 
									{
										if(screen1.getScreenId().equalsIgnoreCase(selectedScreenId))
										{
											act.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
											currentScene.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
											screen1.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
											screen = screen1;	
										}
										else
										{
											screen1.setDefaultStyle(null);
										}
									}
								}
								else
								{
									currentScene.setDefaultStyle(null);
								}
							}
						}
						else
						{
							act.setDefaultStyle(null);
						}
					}
				}
			}
		}
		if(null == screen)
		{
			screen = new Screen();
		}
		String viewName = "ScreenConfig";
		if(null != screen)
		{
			String screenType = screen.getScreenType();
			System.out.println("ScreenType :" + screenType);
			if(null != screenType && !"".equals(screenType))
			{
				if(screenType.equalsIgnoreCase(ScreenType.DIFFICULTYLEVEL.toString()))
				{
					viewName = "DifficultyLevelConfig";
				}
				if(screenType.equalsIgnoreCase(ScreenType.LISTOFQUESTIONS.toString()))
				{
					viewName = "ListOfQuestionsConfig";
				}
				if(screenType.equalsIgnoreCase(ScreenType.NOOFQUESTIONS.toString()))
				{
					viewName = "GetQuestionCountConfig";
				}
			}
		}
		session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, currentGameGenInfo);
		System.out.println("Screen Id :" + screen.getScreenId());
		return new ModelAndView(viewName,"Screen", screen);
	}
	
	
	@RequestMapping(value = "/getDiffConfigLevel.htm", method = RequestMethod.GET)
	public ModelAndView getDifficultyConfig(@ModelAttribute("Screen") Screen selectedScreen, HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		Screen screen = null;
		GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		
		screen = getScreenForConfig(selectedScreen, screen, currentGameGenInfo,ScreenType.DIFFICULTYLEVEL.toString(),session);
		
		Map<String,Object> mapObj = new HashMap<String, Object>();
		mapObj.put("Screen", screen);
		mapObj.put(ApplicationConstants.GAME_GENERATOR_INFO, currentGameGenInfo);
		
		return new ModelAndView("DifficultyLevelConfig",mapObj);
	}


	/**
	 * @param selectedScreen
	 * @param screen
	 * @param currentGameGenInfo
	 * @return
	 */
	private Screen getScreenForConfig(Screen selectedScreen, Screen screen,	GameGeneratorInfo currentGameGenInfo, String screenType, HttpSession session) 
	{
		if(null != selectedScreen)
		{
			String selectedScreenId = selectedScreen.getScreenId();
			System.out.println("From getScreenCountConfig :" + selectedScreenId);
			String[] idArr = selectedScreenId.split("_");
			String currentActId = idArr[0];
			String currentSceneId = idArr[1];
			
			
			if(null != currentGameGenInfo)
			{
				List<Act> actList = currentGameGenInfo.getActList();
				if(null != actList && actList.size() > 0)
				{
					for (Act act : actList) {
						if(act.getActId().equalsIgnoreCase(currentActId))
						{
							for (Scene currentScene : act.getSceneList()) {
								if(currentScene.getSceneId().equalsIgnoreCase(currentActId+"_"+currentSceneId))
								{
									for (Screen currentScreen : currentScene.getScreenList()) 
									{
										if(currentScreen.getScreenId().equalsIgnoreCase(selectedScreenId))
										{
											currentScreen.setScreenType(screenType);											
											act.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
											currentScene.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
											currentScreen.setDefaultStyle(ApplicationConstants.DEFAULT_STYLE);
											screen = currentScreen;
										}
										else
										{
											currentScreen.setDefaultStyle(null);
										}
									}
								}
								else
								{
									currentScene.setDefaultStyle(null);
								}
							}
						}
						else
						{
							act.setDefaultStyle(null);
						}
					}
				}
			}
		}
		if(null == screen)
		{
			screen = new Screen();
			screen.setScreenType(screenType);
		}
		session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, currentGameGenInfo);	
		return screen;
	}
	
	@RequestMapping(value = "/submitDiffConfigLevel.htm", method = RequestMethod.POST)
	public ModelAndView submitDifficultyConfig(@ModelAttribute("Screen") Screen selectedScreen, HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		currentGameGenInfo = addConfiguredScreenToGameGenInfo(selectedScreen, session, currentGameGenInfo,ScreenType.DIFFICULTYLEVEL.toString());
		return new ModelAndView("ListActs",ApplicationConstants.GAME_GENERATOR_INFO, currentGameGenInfo);
	}


	/**
	 * @param selectedScreen
	 * @param session
	 * @param currentGameGenInfo
	 * @return
	 */
	private GameGeneratorInfo addConfiguredScreenToGameGenInfo(
			Screen selectedScreen, HttpSession session,
			GameGeneratorInfo currentGameGenInfo, String screenType) {
		if(null != selectedScreen)
		{
			String selectedScreenId = selectedScreen.getScreenId();
			System.out.println("From getScreenCountConfig :" + selectedScreenId);
			String[] idArr = selectedScreenId.split("_");
			String currentActId = idArr[0];
			String currentSceneId = idArr[0]+"_"+idArr[1];
			
			
			if(null != currentGameGenInfo)
			{
				List<Act> actList = currentGameGenInfo.getActList();
				if(null != actList && actList.size() > 0)
				{
					for (Act act : actList) {
						if(act.getActId().equalsIgnoreCase(currentActId))
						{
							for (Scene currentScene : act.getSceneList()) {
								if(currentScene.getSceneId().equalsIgnoreCase(currentSceneId))
								{
									for (Screen screen1 : currentScene.getScreenList()) 
									{
										if(screen1.getScreenId().equalsIgnoreCase(selectedScreenId))
										{
											if(null != screenType && !"".equals(screenType.trim()))
											{
												screen1.setScreenType(screenType);
												if(screenType.equalsIgnoreCase(ScreenType.DIFFICULTYLEVEL.toString()))
												{
													screen1.setDifficultySetting(selectedScreen.getDifficultySetting());
												}
												else if(screenType.equalsIgnoreCase(ScreenType.NOOFQUESTIONS.toString()))
												{
													screen1.setNoOfQuestions(selectedScreen.getNoOfQuestions());
													screen1.setQuestionLocation(selectedScreen.getQuestionLocation());
													//chooseRandomQuestionSelection(screen1);
												}
												else if(screenType.equalsIgnoreCase(ScreenType.LISTOFQUESTIONS.toString()))
												{
													//TODO: Add code for list of questions 
												}
																
											}
											
										}
									}
								}
							}
						}
					}
				}
			}
			else
			{
				currentGameGenInfo = new GameGeneratorInfo();
				Act act = new Act(currentActId,currentActId);
				Scene scene1 = new Scene(currentSceneId,idArr[1]);
				List<Act> actList = new ArrayList<Act>();
				List<Scene> sceneList = new ArrayList<Scene>();
				List<Screen> screenList = new ArrayList<Screen>();
				Screen screen1 = new Screen(selectedScreenId, idArr[2]);
				screen1.setScreenType(ScreenType.DIFFICULTYLEVEL.toString());
				screen1.setDifficultySetting(selectedScreen.getDifficultySetting());
				screenList.add(screen1);
				scene1.setScreenList(screenList);
				sceneList.add(scene1);
				act.setSceneList(sceneList);
				actList.add(act);
				currentGameGenInfo.setActList(actList);
				session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, currentGameGenInfo);	
			}
		}
		return currentGameGenInfo;
	}
	
	private void chooseRandomQuestionSelection(Screen screen1) 
	{
		List<QuestionInfo> questionInfoList = null;
		int noOfQuestions = screen1.getNoOfQuestions();
		if(noOfQuestions > 0)
		{
			questionInfoList = new ArrayList<QuestionInfo>();
			QuestionInfo questionInfo = null;
			for (int i = 1; i <= noOfQuestions; i++) 
			{
				questionInfo.setQuestionId("question"+i);
				questionInfo.setStatement("");
			}
		}
			
	}


	@RequestMapping(value = "/getQuestionCountConfig.htm", method = RequestMethod.GET)
	public ModelAndView getQuestionCountConfig(@ModelAttribute("Screen") Screen selectedScreen, HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		Screen screen = null;
		GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		
		screen = getScreenForConfig(selectedScreen, screen, currentGameGenInfo,ScreenType.NOOFQUESTIONS.toString(),session);
		
		Map<String,Object> mapObj = new HashMap<String, Object>();
		mapObj.put("Screen", screen);
		mapObj.put(ApplicationConstants.GAME_GENERATOR_INFO, currentGameGenInfo);
		session.setAttribute(ApplicationConstants.GAME_GENERATOR_INFO, currentGameGenInfo);	
		return new ModelAndView("GetQuestionCountConfig",mapObj);
	}
	
	@RequestMapping(value = "/submitQuestionCountConfig.htm", method = RequestMethod.POST)
	public ModelAndView submitQuestionCountConfig(@ModelAttribute("Screen") Screen selectedScreen, HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		currentGameGenInfo = addConfiguredScreenToGameGenInfo(selectedScreen, session, currentGameGenInfo,ScreenType.NOOFQUESTIONS.toString());
		return new ModelAndView("ListActs",ApplicationConstants.GAME_GENERATOR_INFO, currentGameGenInfo);
	}
	
	
	@RequestMapping(value = "/generateGameConfig.htm", method = RequestMethod.GET)
	public ModelAndView generateGameConfig(HttpServletRequest request, HttpSession session, ModelMap model, HttpSession session1)			
	{
		GameGeneratorInfo currentGameGenInfo = (GameGeneratorInfo)session.getAttribute(ApplicationConstants.GAME_GENERATOR_INFO);
		if(null != currentGameGenInfo)
		{
			manageGameGeneratorService.generateXML(currentGameGenInfo);
		}
		return new ModelAndView("welcomepage");
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
	public void setManageGameGeneratorService(ManageGameGeneratorService manageGameGeneratorService) {
		this.manageGameGeneratorService = manageGameGeneratorService;
	}


	
	
}
