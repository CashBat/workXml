package main.java.ru.work_xml.model.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import main.java.ru.work_xml.model.Form.Field;

@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = { "name", "type", "value", "required", "digitOnly", "readOnly" })

public class AbstractTegData {
	protected Field field;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String type;
	@XmlAttribute
	private String value;
	@XmlAttribute
	private Boolean required;
	@XmlAttribute
	private Boolean digitOnly;
	@XmlAttribute
	private Boolean readOnly;

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

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Boolean getDigitOnly() {
		return digitOnly;
	}

	public void setDigitOnly(Boolean digitOnly) {
		this.digitOnly = digitOnly;
	}

	public Boolean getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}

	public void setFieldsValue(Field field) {
		this.field = field;
		if (field.getName() != null)
			name = field.getName();
		if (field.getType() != null)
			type = field.getType();
		if (field.getValue() != null)
			value = field.getValue();
		if (field.getRequired() != null)
			required = intToBool(field.getRequired());
		if (field.getDigitOnly() != null)
			digitOnly = intToBool(field.getDigitOnly());
		if (field.getReadOnly() != null)
			readOnly = intToBool(field.getReadOnly());
	}

	private boolean intToBool(int intParam) {
		return intParam == 1 ? true : false;
	}

}
