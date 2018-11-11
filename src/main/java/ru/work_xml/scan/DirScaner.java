package main.java.ru.work_xml.scan;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirScaner {
	private List<Object> foundObjects;
	
	public void scan(Scaner scan) {
		File dirFile = new File((String) scan.getScanArea()).getAbsoluteFile();
		File[] files = dirFile.listFiles();
		foundObjects = Arrays.asList(files);
		
	}

	public List<Object> getFoundObjects() {
		return foundObjects;
	}
	
	

}
