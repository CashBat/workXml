package main.java.ru.work_xml.model.Form;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "type", "value", "required", "digitOnly", "readOnly" })
@XmlAccessorType(XmlAccessType.NONE)
public class Field {
	@XmlElement
	private String name;
	@XmlElement
	private String type;
	@XmlElement
	private String value;
	@XmlElement
	private Integer required;
	@XmlElement
	private Integer digitOnly;
	@XmlElement
	private Integer readOnly;

	public Field() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getRequired() {
		return required;
	}

	public void setRequired(Integer required) {
		this.required = required;
	}

	public Integer getDigitOnly() {
		return digitOnly;
	}

	public void setDigitOnly(Integer digitOnly) {
		this.digitOnly = digitOnly;
	}

	public Integer getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Integer readOnly) {
		this.readOnly = readOnly;
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", type=" + type + ", value=" + value + ", required=" + required + ", digitOnly="
				+ digitOnly + ", readOnly=" + readOnly + "]";
	}

}
