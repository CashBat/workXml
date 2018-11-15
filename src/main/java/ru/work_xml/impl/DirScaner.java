package main.java.ru.work_xml.impl;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import main.java.ru.work_xml.api.Scaner;

public class DirScaner implements Scaner {

	@Override
	public List<File> searchFilesByType(String dir, String type) {
		File dirFile = new File(dir).getAbsoluteFile();
		List<File> foundFiles = Arrays.asList(dirFile.listFiles());

		List<File> needFiles = foundFiles.stream().filter(xxx -> checFileType(xxx, type)).collect(Collectors.toList());

		return needFiles;
	}

	private boolean checFileType(File file, String type) {
		boolean result = false;
		String typeCheck = type;
		String extension;
		extension = getFileExtension(file);
		if (extension.equals(typeCheck)) {
			result = true;
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

}
