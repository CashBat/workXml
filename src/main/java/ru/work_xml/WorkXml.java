package main.java.ru.work_xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import main.java.ru.work_xml.convert.AbstractConverter;
import main.java.ru.work_xml.convert.Converter;
import main.java.ru.work_xml.convert.XmlConvector;
import main.java.ru.work_xml.convert.schem.FormToDate;
import main.java.ru.work_xml.convert.schem.Schema;
import main.java.ru.work_xml.scan.DirScaner;
import main.java.ru.work_xml.scan.Scaner;
import main.java.ru.work_xml.workweb.Web;
import main.java.ru.work_xml.workweb.WorkWeb;

public class WorkXml implements Converter, Web, Scaner {

	private DirScaner scaner = new DirScaner();
	private AbstractConverter converter = new XmlConvector();
	private WorkWeb web = new WorkWeb();

	private String scanDir;
	private List<File> xmlFiles;

	private String outDir;
	private Schema schema;
	private File initXml;
	private String nameOutFile;
	private File newXml;

	public WorkXml() {

		scanDirAndSearchXml();
		for (Object xml : xmlFiles) {
			startedWorkXml((File) xml);
		}

	}

	private void scanDirAndSearchXml() {
		scanDir = "inFile";
		scaner.scan(this);
		xmlFiles = new ArrayList<>();
		List<Object> foundObjects = scaner.getFoundObjects();

		for (Object object : foundObjects) {
			File file = (File) object;
			if (checXmlkFile(file))
				xmlFiles.add(file);
		}
	}

	private boolean checXmlkFile(File file) {
		Boolean result = false;
		String typeCheck = "xml";
		String extension;
		extension = getFileExtension(file);
		if (extension.equals(typeCheck)) {
			result = true;
		}
		return result;
	}

	private void startedWorkXml(File xml) {
		convertFile(xml);
		sendNewFile();
	}

	private void sendNewFile() {
		newXml = (File) converter.getNewObject();
		web.post(this);
	}

	private void convertFile(File file) {
		initConvertter(file);
		converter.convert(this);

	}

	private void initConvertter(File file) {
		initXml = file;
		schema = getSchem();
		outDir = "outFile";
		createNameOutFile();
	}

	private void createNameOutFile() {
		nameOutFile = "dst" + "_from_" + initXml.getName();
	}

	private Schema getSchem() {
		Schema result = null;
		String typeSchem = "FormToDate";// String
										// typeSchem=getTypeSchem(inFileXml);
										// -//нужно разобраться как связать
										// файлы с типами.
		switch (typeSchem) {
		case "FormToDate":
			result = new FormToDate();
			break;

		default:
			break;
		}

		return result;
	}

	private static String getFileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	@Override
	public Schema getSchemeConvert() {
		// TODO Auto-generated method stub
		return schema;
	}

	@Override
	public File getConvertFile() {
		// TODO Auto-generated method stub
		return initXml;
	}

	@Override
	public String getOutDir() {
		// TODO Auto-generated method stub
		return outDir;
	}

	@Override
	public String getNameOutFile() {

		return nameOutFile;
	}

	@Override
	public Object getObjectForPost() {
		// TODO Auto-generated method stub
		return newXml;
	}

	@Override
	public Object getScanArea() {
		// TODO Auto-generated method stub
		return scanDir;
	}

}
