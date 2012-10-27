/**
 * 
 */
package edu.utdallas.gamegenerator.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Meyy
 *
 */
@XmlRootElement
public class UserProfileConfiguration {

	private boolean name;
	private boolean fullName;
	private boolean nickName;
	private boolean profilePicture;
	private boolean age;
	private boolean country;
	private boolean languagePreference;
	private List<String> existingPlayerCharacter;
	
	
	/**
	 * @return the name
	 */
	public boolean isName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setName(boolean name) {
		this.name = name;
	}
	/**
	 * @return the fullName
	 */
	public boolean isFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	@XmlElement
	public void setFullName(boolean fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the nickName
	 */
	public boolean isNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	@XmlElement
	public void setNickName(boolean nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the profilePicture
	 */
	public boolean isProfilePicture() {
		return profilePicture;
	}
	/**
	 * @param profilePicture the profilePicture to set
	 */
	@XmlElement
	public void setProfilePicture(boolean profilePicture) {
		this.profilePicture = profilePicture;
	}
	/**
	 * @return the age
	 */
	public boolean isAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	@XmlElement
	public void setAge(boolean age) {
		this.age = age;
	}
	/**
	 * @return the country
	 */
	public boolean isCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	@XmlElement
	public void setCountry(boolean country) {
		this.country = country;
	}
	/**
	 * @return the languagePreference
	 */
	public boolean isLanguagePreference() {
		return languagePreference;
	}
	/**
	 * @param languagePreference the languagePreference to set
	 */
	@XmlElement
	public void setLanguagePreference(boolean languagePreference) {
		this.languagePreference = languagePreference;
	}
	/**
	 * @return the existingPlayerCharacter
	 */
	public List<String> getExistingPlayerCharacter() {
		return existingPlayerCharacter;
	}
	/**
	 * @param existingPlayerCharacter the existingPlayerCharacter to set
	 */
	@XmlElement
	public void setExistingPlayerCharacter(List<String> existingPlayerCharacter) {
		this.existingPlayerCharacter = existingPlayerCharacter;
	}
	
	
}
