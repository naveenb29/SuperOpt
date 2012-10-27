package edu.utdallas.gamegenerator.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class Screen 
{
	private String screenName;
	private String screenId;
	private List<QuestionInfo> questionList;
	private Prop button;
	private String screenType;
	private int noOfQuestions;
	private String difficultySetting;
	private String questionLocation;
	private String defaultStyle = "";
	
	public Screen() {
		
	}
	
	
	public Screen(String screenId,String screenName) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
	}
	/**
	 * @return the screenName
	 */
	public String getScreenName() {
		return screenName;
	}
	/**
	 * @param screenName the screenName to set
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	/**
	 * @return the button
	 */
	public Prop getButton() {
		return button;
	}
	/**
	 * @param button the button to set
	 */
	@XmlElement
	public void setButton(Prop button) {
		this.button = button;
	}
	/**
	 * @return the screenId
	 */
	public String getScreenId() {
		return screenId;
	}
	/**
	 * @param screenId the screenId to set
	 */
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	/**
	 * @return the screenType
	 */
	public String getScreenType() {
		return screenType;
	}
	/**
	 * @param screenType the screenType to set
	 */
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	/**
	 * @return the noOfQuestions
	 */
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	/**
	 * @param noOfQuestions the noOfQuestions to set
	 */
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	/**
	 * @return the difficultySetting
	 */
	public String getDifficultySetting() {
		return difficultySetting;
	}
	/**
	 * @param difficultySetting the difficultySetting to set
	 */
	@XmlElement
	public void setDifficultySetting(String difficultySetting) {
		this.difficultySetting = difficultySetting;
	}
	/**
	 * @return the questionList
	 */
	public List<QuestionInfo> getQuestionList() {
		return questionList;
	}
	/**
	 * @param questionList the questionList to set
	 */
	@XmlElement
	public void setQuestionList(List<QuestionInfo> questionList) {
		this.questionList = questionList;
	}


	/**
	 * @return the questionLocation
	 */
	public String getQuestionLocation() {
		return questionLocation;
	}


	/**
	 * @param questionLocation the questionLocation to set
	 */
	@XmlElement
	public void setQuestionLocation(String questionLocation) {
		this.questionLocation = questionLocation;
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
