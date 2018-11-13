package main.java.ru.work_xml.convert.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbParser implements Parser {

	@Override
	public Object getObject(Class typeReturnObject, File inFile) {

		Object object = null;
		try {
			JAXBContext context;
			context = JAXBContext.newInstance(typeReturnObject);

			Unmarshaller unmarshaller = context.createUnmarshaller();
			object = unmarshaller.unmarshal(inFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public void saveObject(Object completeObject, File outFile) {
		try {
			JAXBContext context = JAXBContext.newInstance(completeObject.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(completeObject, outFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
