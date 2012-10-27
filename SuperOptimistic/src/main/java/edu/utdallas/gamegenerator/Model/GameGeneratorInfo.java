package edu.utdallas.gamegenerator.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Meyy
 *
 */

@XmlRootElement
public class GameGeneratorInfo {

	private UserProfileConfiguration userProfileConfiguration;
	
	private List<Act> actList;
	
	private String noOfActs;
	
	private String selElement;

	/**
	 * @return the userProfileConfiguration
	 */
	public UserProfileConfiguration getUserProfileConfiguration() {
		return userProfileConfiguration;
	}

	/**
	 * @param userProfileConfiguration the userProfileConfiguration to set
	 */
	@XmlElement
	public void setUserProfileConfiguration(
			UserProfileConfiguration userProfileConfiguration) {
		this.userProfileConfiguration = userProfileConfiguration;
	}

	/**
	 * @return the actList
	 */
	public List<Act> getActList() {
		return actList;
	}

	/**
	 * @param actList the actList to set
	 */
	@XmlElement(name="acts")
	public void setActList(List<Act> actList) {
		this.actList = actList;
	}

	/**
	 * @return the noOfActs
	 */
	public String getNoOfActs() {
		return noOfActs;
	}

	/**
	 * @param noOfActs the noOfActs to set
	 */
	public void setNoOfActs(String noOfActs) {
		this.noOfActs = noOfActs;
	}

	/**
	 * @return the selElement
	 */
	public String getSelElement() {
		return selElement;
	}

	/**
	 * @param selElement the selElement to set
	 */
	public void setSelElement(String selElement) {
		this.selElement = selElement;
	}
	
}
