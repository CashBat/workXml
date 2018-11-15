package main.java.ru.work_xml.api;

import java.io.File;

public interface Parser {

	Object getObject(Class typeReturnObject, File inFile);

	void saveObject(Object completeObject, File outFile);

}
