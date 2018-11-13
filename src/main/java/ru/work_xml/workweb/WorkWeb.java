package main.java.ru.work_xml.workweb;

import java.io.File;

public class WorkWeb {
	File fileToSend;

	public void post(Web webObject) {
		fileToSend = (File) webObject.getObjectForPost();

	}

}
