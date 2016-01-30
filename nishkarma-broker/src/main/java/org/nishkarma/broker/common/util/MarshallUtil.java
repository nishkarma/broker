/**
 * Nishkarma EAI Project
 */
package org.nishkarma.broker.common.util;

/** <pre>
 * 
 * </pre>
 * @Company Nishkarma
 * @Author lee suk jae
 * @Date 2015. 5. 6. 오후 1:37:09
 * @since 0.3
 * @history -------------------------------------------------------------------
 *          Date____________Auther________Desc.________________________________
 *          2015. 5. 6.     lee suk jae
 *          -------------------------------------------------------------------
 */

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.MarshallerProperties;

public class MarshallUtil {

	public static <T> String marshal(T object) throws JAXBException {
		JAXBContext jAXBContext = JAXBContext.newInstance(object.getClass());
		Marshaller marshaller = jAXBContext.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);

		StringWriter stringWriter = new StringWriter();
		marshaller.marshal(object, stringWriter);

		return stringWriter.toString();
	}

	public static <T> T unMarshal(String content, Class<T> clasz) throws JAXBException {
		JAXBContext jAXBContext = JAXBContext.newInstance(clasz);
		Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
		unmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
		unmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		
		return unmarshaller.unmarshal(
				new StreamSource(new StringReader(content)), clasz).getValue();
	}
	
}
