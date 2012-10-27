package edu.utdallas.gamegenerator.Model;

import javax.xml.bind.annotation.XmlElement;

public class Prop {

	private String typeName;
	private String name;
	private String location;
	private String size;
	/**
	 * @return the typeName
	 */
	
	public String getTypeName() {
		return typeName;
	}
	/**
	 * @param typeName the typeName to set
	 */
	@XmlElement
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	@XmlElement
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	@XmlElement
	public void setSize(String size) {
		this.size = size;
	}
	
}
