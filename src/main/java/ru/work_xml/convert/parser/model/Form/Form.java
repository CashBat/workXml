package main.java.ru.work_xml.convert.parser.model.Form;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Form")
@XmlAccessorType(XmlAccessType.NONE)
public class Form {

	@XmlElement(name = "Group")
	@XmlElementWrapper(name = "Groups")
	private List<Group> groups;

	public Form() {

	}

	public List<Group> getGroups() {
		if (groups == null) {
			groups = new ArrayList<>();
		}
		return groups;
	}

}
