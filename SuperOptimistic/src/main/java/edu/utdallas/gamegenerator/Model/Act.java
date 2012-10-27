package edu.utdallas.gamegenerator.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Act {

	private String actTitle;
	private String actId;
	private List<Scene> sceneList;
	private int noOfScenes;
	private String defaultStyle = "";
	
	public Act()
	{
		
	}
	
	public Act(String actId) {
		super();
		this.actId = actId;
	}
	
	public Act(String actId,String actTitle) {
		super();
		this.actId = actId;
		this.actTitle = actTitle;
	}
	/**
	 * @return the actTitle
	 */
	public String getActTitle() {
		return actTitle;
	}
	/**
	 * @param actTitle the actTitle to set
	 */
	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
	}
	/**
	 * @return the sceneList
	 */
	public List<Scene> getSceneList() {
		return sceneList;
	}
	/**
	 * @param sceneList the sceneList to set
	 */
	@XmlElement(name="scenes")
	public void setSceneList(List<Scene> sceneList) {
		this.sceneList = sceneList;
	}
	/**
	 * @return the actId
	 */
	public String getActId() {
		return actId;
	}
	/**
	 * @param actId the actId to set
	 */
	public void setActId(String actId) {
		this.actId = actId;
	}
	/**
	 * @return the noOfScenes
	 */
	public int getNoOfScenes() {
		return noOfScenes;
	}
	/**
	 * @param noOfScenes the noOfScenes to set
	 */
	public void setNoOfScenes(int noOfScenes) {
		this.noOfScenes = noOfScenes;
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
