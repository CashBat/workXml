package main.java.ru.work_xml.impl;

import java.io.File;

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
		String nameOutFile = nameResultFile + "_from_" + convertFile.getName();
		result = new File(outDir + "/" + nameOutFile).getAbsoluteFile();
		return result;
	}

}
