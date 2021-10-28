package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//xml문서의 엘리먼트(노드,태그)의 속성을 추출
public class DomParserTest03 {
	public static void main(String[] args) {
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document =  builder.parse("src/xml/dept.xml");
			Element root = document.getDocumentElement();
			NodeList deptlist = root.getElementsByTagName("dept");
			//각각의 dept노드를 탐색하면서 속성과 속성값을 출력하기
			for(int i=0; i<deptlist.getLength();i++) {
				//NodeList안에서 item하나씩 추출
				Node deptnode = deptlist.item(i);
				System.out.print((i+1)+"번 노드,");
				System.out.print("노드명:"+deptnode.getNodeName());
				
				//dept엘리먼트의 속성을 추출 - 노드로 관리
				//속성은 속성명과 속성값을 같이 저장해야 하므로 Map관리
				//deptnode의 모든 속성을 추출 - NameNodeMap관리
				NamedNodeMap attr_list = deptnode.getAttributes();
				System.out.print(", dept노드의 속성 갯수=> "+attr_list.getLength());
				for (int j = 0; j < attr_list.getLength(); j++) {
					Node attribute = attr_list.item(j);
					System.out.print(",속성명: "+attribute.getNodeName()+"("+attribute.getNodeValue()+")");
				}//속성에 대한 탐색 완료
				System.out.println();
				
				
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
