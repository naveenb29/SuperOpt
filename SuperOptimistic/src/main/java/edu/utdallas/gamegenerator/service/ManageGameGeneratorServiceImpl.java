package edu.utdallas.gamegenerator.service;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import edu.utdallas.gamegenerator.Model.GameGeneratorInfo;

/**
 * @author Meyy
 *
 */
public class ManageGameGeneratorServiceImpl implements ManageGameGeneratorService {

	private static final String GAME_ENGINE_INPUT_PATH = "C:\\Users\\Meyy\\Downloads\\GameEngineInput.xml";
	
	private static final Logger LOG = Logger.getLogger(ManageGameGeneratorServiceImpl.class);

	/**
	 * This method generates an xml by marshalling the GameGeneratorInfo object
	 * 
	 */
	public void generateXML(GameGeneratorInfo gameGeneratorInfo) 
	{
		if(null != gameGeneratorInfo)
		{
			try {
				File file = new File(GAME_ENGINE_INPUT_PATH);
				if (file.exists()) {
					file.createNewFile();
				}
				JAXBContext jaxbContext = JAXBContext
						.newInstance(GameGeneratorInfo.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	
				jaxbMarshaller.marshal(gameGeneratorInfo, file);
				jaxbMarshaller.marshal(gameGeneratorInfo, System.out);
	
			} catch (JAXBException e) {
				e.printStackTrace();
				LOG.error("Error while marshalling GameGeneratorInfo", e);
			} catch (IOException e) {
				LOG.error("IO Exception", e);			
			}
		}

	}

}
