package main.java.ru.work_xml.convert.parser;

import java.io.File;

import javax.xml.bind.JAXBException;

public interface Parser {

	Object getObject(Class typeReturnObject, File inFile);

	void saveObject(Object completeObject, File outFile);

}
