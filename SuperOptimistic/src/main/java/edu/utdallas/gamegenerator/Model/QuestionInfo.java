package edu.utdallas.gamegenerator.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class QuestionInfo extends Prop{

	private String subjectName;
	private String questionId;
	private String grade;
	private String statement;
	private String noOfImages;
	private List<String> imagePathList;
	private List<String> optionList;
	private String noOfOptions;
	private String answer;
	private String awardPts;
	
	
	
	public QuestionInfo(String questionId) {
		super();
		this.questionId = questionId;
	}
	
	private String penaltyPts;
	
	
	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * @param subjectName the subjectName to set
	 */
	@XmlElement
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	@XmlElement
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the statement
	 */
	public String getStatement() {
		return statement;
	}
	/**
	 * @param statement the statement to set
	 */
	@XmlElement
	public void setStatement(String statement) {
		this.statement = statement;
	}
	/**
	 * @return the noOfImages
	 */
	public String getNoOfImages() {
		return noOfImages;
	}
	/**
	 * @param noOfImages the noOfImages to set
	 */
	public void setNoOfImages(String noOfImages) {
		this.noOfImages = noOfImages;
	}
	/**
	 * @return the imagePathList
	 */
	public List<String> getImagePathList() {
		return imagePathList;
	}
	/**
	 * @param imagePathList the imagePathList to set
	 */
	@XmlElement
	public void setImagePathList(List<String> imagePathList) {
		this.imagePathList = imagePathList;
	}
	/**
	 * @return the optionList
	 */
	public List<String> getOptionList() {
		return optionList;
	}
	/**
	 * @param optionList the optionList to set
	 */
	@XmlElement
	public void setOptionList(List<String> optionList) {
		this.optionList = optionList;
	}
	/**
	 * @return the noOfOptions
	 */
	public String getNoOfOptions() {
		return noOfOptions;
	}
	/**
	 * @param noOfOptions the noOfOptions to set
	 */
	public void setNoOfOptions(String noOfOptions) {
		this.noOfOptions = noOfOptions;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	@XmlElement
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * @return the awardPts
	 */
	public String getAwardPts() {
		return awardPts;
	}
	/**
	 * @param awardPts the awardPts to set
	 */
	@XmlElement
	public void setAwardPts(String awardPts) {
		this.awardPts = awardPts;
	}
	/**
	 * @return the penaltyPts
	 */
	public String getPenaltyPts() {
		return penaltyPts;
	}
	/**
	 * @param penaltyPts the penaltyPts to set
	 */
	@XmlElement
	public void setPenaltyPts(String penaltyPts) {
		this.penaltyPts = penaltyPts;
	}
	/**
	 * @return the questionId
	 */
	public String getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	
	
}
