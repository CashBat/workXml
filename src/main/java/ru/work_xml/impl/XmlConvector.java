package main.java.ru.work_xml.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import main.java.ru.work_xml.impl.JaxbParser;
import main.java.ru.work_xml.api.Parser;
import main.java.ru.work_xml.impl.Abstract.BasicConverterFile;

public class XmlConvector extends BasicConverterFile {

	private Parser parser = new JaxbParser();

	private Object unmarshObject;

	private Object transformObject;

	@Override
	public void convert() {
		unmarshal();
		transform();
		marshal();
	}

	private void unmarshal() {
		unmarshObject = parser.getObject(schemeTransform.getTypeTo(), convertFile);
	}

	private void transform() {
		transformObject = schemeTransform.transformAndReturn(unmarshObject);
	}

	private void marshal() {
		parser.saveObject(transformObject, createOutFile());
	}

	private File createOutFile() {

		File result = null;
		try {
			String nameOutFile = nameResultFile + "_from_" + convertFile.getName();
			Path dirPath = Paths.get(outDir);
			if (!Files.exists(dirPath)) {
				Files.createDirectories(dirPath);		
			}
			result = new File(outDir + "/" + nameOutFile).getAbsoluteFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
