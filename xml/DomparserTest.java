package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomparserTest {
	public static void main(String[] args) {
		//parser를 만들어주눈 Factory 객체를 생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			//xml문서를 파싱할 수 있는 dom parser를 생성
			DocumentBuilder builder = factory.newDocumentBuilder();
			//xml문서를 파싱해서 자바에서 쓸 수 있는 객체로 리턴해준다
			Document document =  builder.parse("src/xml/dept.xml");
			System.out.println(document.toString());
			Element root = document.getDocumentElement();
			System.out.println(root);
			System.out.println(root.getTagName());
			System.out.println(root.getFirstChild());
			System.out.println(root.getLastChild());
			NodeList list = root.getChildNodes();
			System.out.println("deptlist의 child갯수=>"+list.getLength());
			for(int i=0;i<list.getLength();i++) {
				Node node = list.item(i);
				System.out.println("노드의 이름:"+node.getNodeName());
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
