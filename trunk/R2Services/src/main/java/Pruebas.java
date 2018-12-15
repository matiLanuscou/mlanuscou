import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class Pruebas {

	public static void main(String[] args) {
		Pruebas p = new Pruebas();
		try {
			p.testHtml();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testHtml() throws Exception {
		Document doc = this.getDocument(null);
		Element complete = doc.createElement("options");
		doc.appendChild(complete);
		// response.setContentType("text/xml");
		Element noneOption = doc.createElement("option");
		complete.appendChild(noneOption);
		noneOption.setAttribute("value", "value");
//		noneOption.setAttribute("text", "Camilo Gay");
		noneOption.setAttribute("class", "global_menu");
//		noneOption.setTextContent("<img src='1.jpg'> test de contenido");
		noneOption.setTextContent("Camiloo Gay");
		
		Element img = doc.createElement("img");
		
		noneOption.appendChild(img);
		img.setAttribute("src", "1.jpg");
		
		// noneOption.setAttribute("onclick", "clearRole('" + htmlID + "');");
		
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		
		DOMSource ds = new DOMSource(doc);
		
		StreamResult sr = new StreamResult("C:\\Users\\mlanuscou\\Desktop\\test.txt");
		t.transform(ds, sr);
	}

	public Document getDocument(InputSource is) {
		Document doc = null;
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			if (is != null) {
				doc = builder.parse(is);
			} else {
				doc = builder.newDocument();
			}
		} catch (Exception e) {
		}

		return doc;
	}
}
