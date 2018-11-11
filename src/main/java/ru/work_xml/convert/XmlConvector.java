package main.java.ru.work_xml.convert;

import java.io.File;

import main.java.ru.work_xml.convert.parser.JaxbParser;
import main.java.ru.work_xml.convert.parser.Parser;



public class XmlConvector extends AbstractConverter {
	private Parser parser=new JaxbParser();
	private Object unmarshObject;
	private Object transformObject;

	
	public void convert(Converter conObject) {
		this.conObject=conObject;
		initConvector();
		unmarshal();
		transform();
		marshal();
		
	}

	private void initConvector() {
		inObject=conObject.getConvertFile();
		scheme=conObject.getSchemeConvert();
		createOutObject();
	
	}

	private void createOutObject() {
		String outDir= conObject.getOutDir();
		String nameOutFile = conObject.getNameOutFile();
		newObject= new File(outDir+"/"+nameOutFile).getAbsoluteFile();	
	}

	private void unmarshal() {
		unmarshObject = parser.getObject(scheme.getTypeTo(), (File)inObject);
	}

	private void transform() {
		transformObject = scheme.transformAndReturn(unmarshObject);
	}

	private void marshal() {
		parser.saveObject(transformObject,(File) newObject);
	}

}
