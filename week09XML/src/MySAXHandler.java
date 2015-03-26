import java.io.File;

import javax.xml.parsers.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/*
 * DefaultHandler is a "stub" class that does nothing
 * provided by Oracle
 * implements all necessary interfaces to work with SAX
 */
public class MySAXHandler extends DefaultHandler{
	
	private int elementCount = 0;
	//used to accumulate the text encountered between element tags
	private StringBuffer elementText = new StringBuffer();
	
	
	/*
	 * this method will be called by the reader when the
	 * start of the document is reached
	 */
	@Override
	public void startDocument() throws SAXException{
		System.out.println("reached the start of the document");
	}
	/*
	 * this method will be called by the reader when the
	 * end of the document is reached
	 */
	@Override
	public void endDocument() throws SAXException{
		System.out.println("reached the end of the document");
	}
	
	
	
	/*
	 * this method will be called whenever the reader encounters the beginning of an element
	 */
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts){
		elementCount++;
		elementText.setLength(0);  //discards string stored in string buffer
		System.out.println(localName + "is the" + elementCount + "th element\n");	//print out the name of the element
		System.out.println("this element has the following attributes:");	
		
		for (int i = 0; i < atts.getLength(); i++){									//print out the types and names of attributes in the element
			System.out.println(atts.getLocalName(i)+ "=" + atts.getValue(i));
		}
	}
	
	/*
	 * this method will handle ordinary text encountered between element tags
	 */
	public void characters(char[] text, int begin, int length){
		//handle any characters read
		elementText.append(text, begin, length);
	}
	
	/*
	 * this method will be called whenever the reader encounters the end of an element
	 */
	@Override
	public void endElement(String uri, String localName, String qName){
		//do additional processing if element contained any text
		//here we print out, but you can do whatever you want
		if (elementText.length() >0){
			System.out.println("element text: " + elementText.toString());
			elementText.setLength(0);
		}
	}
	
	public static void main(String[] args) throws Exception{
		//this is the file we will parse
		String filename = "query.xml";
		System.out.println("starting to parse~!");
		//first we need an instance of the factory!
		SAXParserFactory spf = SAXParserFactory.newInstance();
		//set namespace awareness
		spf.setNamespaceAware(true);
		//use the factory to create a new SAX parser
		SAXParser saxParser = spf.newSAXParser();
		//create an XML Reader for use with the parser and our handler
		XMLReader xmlReader = saxParser.getXMLReader();
		//set a content handler to "interpret" or "do something"
		//with the XML document
		MySAXHandler handler = new MySAXHandler();
		xmlReader.setContentHandler(handler);
		
		xmlReader.parse(formatFileName(filename));
		
				
	}
	/*
	 * clean up the filename in case there are operating system
	 * specific differences
	 */
	private static String formatFileName(String filename){
		String path = new File(filename).getAbsolutePath();
		if(File.separatorChar != '/'){
			path = path.replace(File.separatorChar, '/');
		}
		if(!path.startsWith("/")){
			path = "/" + path;					
		}
		return "file:"+path;
	}

}


