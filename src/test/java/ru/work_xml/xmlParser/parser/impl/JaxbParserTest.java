/**
 * 
 */
package test.java.ru.work_xml.xmlParser.parser.impl;

import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import main.java.ru.work_xml.convert.parser.JaxbParser;
import main.java.ru.work_xml.convert.parser.Parser;
import main.java.ru.work_xml.convert.parser.model.Form.Form;



/**
 * @author pachkovsky
 *
 */
public class JaxbParserTest {
	private Parser parser;
    private File file;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	      parser = new JaxbParser();
	      
	 
		 
	
		 String path = getClass().getResource("/test/resources/groups.xml").getPath();
		 
	       file = new File(path);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link main.java.ru.work_xml.xmlParser.parser.impl.JaxbParser#getObject(java.lang.Class, java.io.File)}.
	 * @throws JAXBException 
	 */
	@Test
	public void testGetObject() throws JAXBException {
		Form form = (Form) parser.getObject(Form.class, file);
        System.out.println(form);
	}

	/**
	 * Test method for {@link main.java.ru.work_xml.xmlParser.parser.impl.JaxbParser#saveObject(java.lang.Object, java.io.File)}.
	 */
	@Ignore
	@Test
	public void testSaveObject() {
		fail("Not yet implemented");
	}

}
