package main.java.ru.work_xml.convert.schem;

public interface Schema {

	public Class getTypeTo();

	public Class getTypePost();

	public Object transformAndReturn(Object objectTo);

}