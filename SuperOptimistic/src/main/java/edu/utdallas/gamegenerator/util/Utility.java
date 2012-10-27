package edu.utdallas.gamegenerator.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.utdallas.gamegenerator.Model.Act;
import edu.utdallas.gamegenerator.Model.Prop;
import edu.utdallas.gamegenerator.Model.QuestionInfo;
import edu.utdallas.gamegenerator.Model.Scene;
import edu.utdallas.gamegenerator.Model.Screen;

public class Utility {

	private static final Logger LOG = Logger.getLogger(Utility.class);
	
	
	public static List<Act> populateAct()
	{
		List<Act> actList = new ArrayList<Act>();
		
		for (int i = 1; i <=2; i++) {
			actList.add(populateActDetails("act"+i , "Act"+i));
		}
		
		
		return actList;
		
	}


	/**
	 * @param act1
	 */
	private static Act populateActDetails(String actId, String actTitle) 
	{
		Act act1 = new Act(actId, actTitle);
		List<Scene> sceneList = new ArrayList<Scene>();		
		for (int i = 1; i <=2 ; i++) {
			sceneList.add(populateSceneDetails("scene"+i , "Scene"+i));
		}	
		act1.setSceneList(sceneList);
		
		return act1;
	}
	
	/**
	 * @param act1
	 */
	private static Scene populateSceneDetails(String sceneId, String sceneTitle) 
	{
		List<Screen> screenList = new ArrayList<Screen>();
		Scene scene = new Scene(sceneId, sceneTitle);
		for (int i = 1; i <=2 ; i++) 
		{
			screenList.add(populateScreenDetails("screen"+i,"Screen"+i, "question"+i));	
		}
		scene.setScreenList(screenList);
		
		return scene;
	}
	

	/**
	 * @param act1
	 */
	private static Screen populateScreenDetails(String screenId,String screenTitle, String questionId) 
	{
		Screen screen = new Screen(screenId,screenTitle);		
		QuestionInfo question = new QuestionInfo(questionId);
		Prop button =  new Prop();
		//screen.setQuestion(question);
		screen.setButton(button);
		return screen;
	}
	
	
	
	
	
	
}
