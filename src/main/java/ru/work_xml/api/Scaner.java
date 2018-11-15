package main.java.ru.work_xml.api;

import java.io.File;
import java.util.List;

public interface Scaner {

	List<File> searchFilesByType(String dir, String Type);

}
