package main.java.ru.work_xml.service;

import java.io.File;
import java.util.List;
import main.java.ru.work_xml.api.Scaner;
import main.java.ru.work_xml.impl.*;
import main.java.ru.work_xml.impl.Abstract.BasicConverterFile;

public class WorkXml {
	Scaner dirScaner = new DirScaner();
	BasicConverterFile convector;

	public WorkXml() {
		List<File> xmlFiles = dirScaner.searchFilesByType("inFile", "xml");
		converctFiles(xmlFiles);
	}

	private void converctFiles(List<File> xmlFiles) {
		xmlFiles.stream().forEach(e -> convert(e));
	}

	private void convert(File e) {
		init(e);
		convector.convert();
	}

	private void init(File e) {
		convector = new XmlConvector();
		convector.setNameResultFile("dst");
		convector.setSchemeTransform(new FormToDate());
		convector.setOutDir("outFile");
		convector.setConvertFile(e);
	}

}
