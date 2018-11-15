package main.java.ru.work_xml.impl.Abstract;

import java.io.File;

import main.java.ru.work_xml.api.*;

public abstract class BasicConverterFile implements Convector {

	protected Schema schemeTransform;
	protected String outDir;
	protected File convertFile;
	protected String nameResultFile;

	public String getNameResultFile() {
		return nameResultFile;
	}

	public void setNameResultFile(String nameResultFile) {
		this.nameResultFile = nameResultFile;
		nameResultFile = nameResultFile;
	}

	public Schema getSchemeTransform() {
		return schemeTransform;
	}

	public void setSchemeTransform(Schema schemeTransform) {
		this.schemeTransform = schemeTransform;
	}

	public String getOutDir() {
		return outDir;
	}

	public void setOutDir(String outDir) {
		this.outDir = outDir;
	}

	public File getConvertFile() {
		return convertFile;
	}

	public void setConvertFile(File convertFile) {
		this.convertFile = convertFile;
	}

}
