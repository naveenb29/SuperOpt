package edu.utdallas.gamegenerator.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Scene {
	private String sceneName;
	private String sceneId;
	private String backdrop;
	private List<Screen> screenList;
	private int noOfScreens;
	private String defaultStyle = "";
	
	
	
	public Scene(String sceneId , String sceneName) {
		super();
		this.sceneId = sceneId;
		this.sceneName = sceneName;
	}
	public Scene() {
	}
	/**
	 * @return the backdrop
	 */
	public String getBackdrop() {
		return backdrop;
	}
	/**
	 * @param backdrop the backdrop to set
	 */
	@XmlElement(name="screen")
	public void setBackdrop(String backdrop) {
		this.backdrop = backdrop;
	}
	/**
	 * @return the screenList
	 */
	public List<Screen> getScreenList() {
		return screenList;
	}
	/**
	 * @param screenList the screenList to set
	 */
	@XmlElement
	public void setScreenList(List<Screen> screenList) {
		this.screenList = screenList;
	}
	
	/**
	 * @return the sceneId
	 */
	public String getSceneId() {
		return sceneId;
	}
	/**
	 * @param sceneId the sceneId to set
	 */
	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}
	/**
	 * @return the sceneName
	 */
	public String getSceneName() {
		return sceneName;
	}
	/**
	 * @param sceneName the sceneName to set
	 */
	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}
	/**
	 * @return the noOfScreens
	 */
	public int getNoOfScreens() {
		return noOfScreens;
	}
	/**
	 * @param noOfScreens the noOfScreens to set
	 */
	public void setNoOfScreens(int noOfScreens) {
		this.noOfScreens = noOfScreens;
	}
	/**
	 * @return the defaultStyle
	 */
	public String getDefaultStyle() {
		return defaultStyle;
	}
	/**
	 * @param defaultStyle the defaultStyle to set
	 */
	public void setDefaultStyle(String defaultStyle) {
		this.defaultStyle = defaultStyle;
	}

}
