package main.java.ru.work_xml.convert;

import java.io.File;

import main.java.ru.work_xml.convert.schem.Schema;

public interface Converter {
	Schema getSchemeConvert();
	File getConvertFile();
	String getOutDir();
	String getNameOutFile();
} 
	

