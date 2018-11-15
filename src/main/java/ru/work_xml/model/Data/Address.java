package main.java.ru.work_xml.model.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import main.java.ru.work_xml.model.Form.Field;

@XmlAccessorType(XmlAccessType.NONE)
public class Address extends AbstractTegData {

	String[] addressParts;
	@XmlAttribute
	private String street;
	@XmlAttribute
	private String house;
	@XmlAttribute
	private String flat;

	public Address() {

	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	@Override
	public void setFieldsValue(Field field) {

		super.setFieldsValue(field);

		splitAddress();

		street = addressParts[0];

		house = addressParts[1];

		flat = addressParts[2];

	}

	private void splitAddress() {
		addressParts = field.getValue().split(",");
	}

}
