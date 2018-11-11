package main.java.ru.work_xml.convert;

import main.java.ru.work_xml.convert.schem.Schema;

public abstract class AbstractConverter {

	protected Schema scheme;
	protected Object inObject;
	protected Object newObject;
	protected Converter conObject;

	
	
	public Object getNewObject() {
		return newObject;
	}




	public abstract void convert(Converter conObject) ;

	

	

}
