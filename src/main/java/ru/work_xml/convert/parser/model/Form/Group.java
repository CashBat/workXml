package main.java.ru.work_xml.convert.parser.model.Form;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "fields", "groups" })
@XmlAccessorType(XmlAccessType.NONE)
public class Group {
	@XmlElement
	private String name;

	@XmlElement(name = "Field")
	@XmlElementWrapper(name = "Fields")
	private List<Field> fields = new ArrayList<>();

	@XmlElement(name = "Group")
	@XmlElementWrapper(name = "Groups")
	private List<Group> groups;

	public Group() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Field> getFields() {

		return fields;
	}

	public List<Group> getGroups() {
		if (groups == null) {
			groups = new ArrayList<>();
		}
		return groups;
	}
}
