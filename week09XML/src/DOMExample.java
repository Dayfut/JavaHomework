import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @param args
 * @throws ParserConfigurationException
 * @throwsIOException
 * @throwsSAXException
 * @author David
 *
 */

public class DOMExample {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//instantiate requred classes
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document d = null;
		//read xml tree intro memory
		d = dBuilder.parse("query.xml");
		
		// getDocumentElement () gets us the root node (root element)
		//Node.getNodeName() gets us the name of the node (element)
		System.out.println("Root element is: " + d.getDocumentElement().getNodeName());
		
		//Document.getElementsByTagName(String name) searches the tree for partiular elements
		NodeList nodes =d.getElementsByTagName("URL");
		//Nodelist has a familar API
		for (int i = 0; i < nodes.getLength(); i++){
			//item returns a Node, Node represents one element
			Node aNode = nodes.item(i);
			//use Node.getTextContent to get the text inside the element
			System.out.println(aNode.getTextContent());
		}
		
		Node anotherNode = d.getElementsByTagName("ReferenceClinVarAssertion").item(0);
		System.out.println("my node name is: " + anotherNode.getNodeName());
		//get anotherNode's parent
		Node parentNode = anotherNode.getParentNode();
		System.out.println("my parent's node name is " + parentNode.getNodeName());
		
		//ge child nodes o the ReferenceClinVarAssertion node
		NodeList children = anotherNode.getChildNodes();
		//print out the names of the child nodes
		System.out.println("child nodes of the ReferenceClinVarAssertion are:");
		for (int i = 0; i < children.getLength(); i++){
			Node aNode = children.item(i);
			System.out.println(aNode.getNodeName());
		}
		//add a child node
		Element aNewChild = d.createElement("Lunch");
		//use Node.apprendChild to actually add the child to the tree
		anotherNode.appendChild(aNewChild);
		
		//add a new attribute to the existing element
		Attr attr = d.createAttribute("sandwich");
		//change value of the attribute since it's blank righ tnow
		attr.setNodeValue("subway");
		//associate this new attribute with an element
		aNewChild.setAttributeNode(attr);
		//display an element's attributes
		//NamedNodeMap is a class for storing nodes such as Attribute nodes
		NamedNodeMap attributes = aNewChild.getAttributes();
		System.out.println("the attributes of my new child node are: ");
		for (int i = 0; i < attributes.getLength(); i++){
			System.out.println(attributes.item(i));
		}
	}
}
