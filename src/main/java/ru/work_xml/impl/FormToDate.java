package main.java.ru.work_xml.impl;

import main.java.ru.work_xml.api.Schema;
import main.java.ru.work_xml.model.Form.*;
import main.java.ru.work_xml.model.Data.*;

public class FormToDate implements Schema {

	private final Class FORM = Form.class;
	private final Class DATE = Date.class;
	private Form form;
	private Date date;
	private Object transformObject;

	@Override
	public Class getTypeTo() {
		return FORM;
	}

	@Override
	public Class getTypePost() {
		return DATE;
	}

	@Override
	public Object transformAndReturn(Object objectTo) {
		createForm(objectTo);
		createDate();
		setTransformObject();
		return transformObject;
	}

	private void createForm(Object objectTo) {
		form = (Form) objectTo;

	}

	private void createDate() {

		date = new Date();
		for (Group group : form.getGroups()) {
			for (Field fil : group.getFields()) {
				System.out.println(fil.toString());
				addTegDate(fil);
			}
			checkInerGroup(group);
		}

	}

	private void checkInerGroup(Group parentGroup) {
		for (Group childGroup : parentGroup.getGroups()) {
			for (Field fil : childGroup.getFields()) {
				System.out.println(fil.toString());
				addTegDate(fil);
			}
			if (childGroup.getGroups().size() > 0)
				checkInerGroup(childGroup);
		}
	}

	private void addTegDate(Field field) {
		AbstractTegData tegDate;

		switch (field.getType()) {
		case "Account": {
			tegDate = new Account();
			tegDate.setFieldsValue(field);
			date.setAcc((Account) tegDate);
			break;
		}

		case "Fio": {
			tegDate = new Fio();
			tegDate.setFieldsValue(field);
			date.setFio((Fio) tegDate);

			break;

		}

		case "Address": {
			tegDate = new Address();
			tegDate.setFieldsValue(field);
			date.setAdr((Address) tegDate);
			break;
		}

		case "Counter": {
			tegDate = new Counter();
			tegDate.setFieldsValue(field);
			date.getCoun().add((Counter) tegDate);
			break;
		}

		case "Sum": {
			tegDate = new Sum();
			tegDate.setFieldsValue(field);
			date.getSum().add((Sum) tegDate);

			break;

		}

		default:
			break;

		}

	}

	private void setTransformObject() {
		transformObject = date;

	}

}
