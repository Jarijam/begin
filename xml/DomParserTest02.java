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

public class DomParserTest02 {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document =  builder.parse("src/xml/dept.xml");
			
			//1.root 엘리먼트 구하기
			Element root = document.getDocumentElement();
			System.out.println("root엘리먼트의 태그명 => "+root.getTagName());
			
			//2. root엘리먼트에서 dept태그에 해당하는 엘리먼트만 추출하기
			NodeList deptlist = root.getElementsByTagName("dept");
			System.out.println("dept노드의 갯수=>"+deptlist.getLength());
			for(int i=0; i<deptlist.getLength();i++) {
				//NodeList안에서 item하나씩 추출
				Node deptnode = deptlist.item(i);
				System.out.println("노드명:"+deptnode.getNodeName());
				//3.dept노드의 하위 노드를 추출
				NodeList deptnodeChildelist = deptnode.getChildNodes();
				for (int j = 0; j < deptnodeChildelist.getLength(); j++) {
					Node deptnoChildNode = deptnodeChildelist.item(j);
					if(!deptnoChildNode.getNodeName().equals("#text")) { //공백노드강 아니면 출력한다
						System.out.println("dept하위 노드명: "+deptnoChildNode.getNodeName());
						System.out.println("dept하위 텍스트 노드명: "+deptnoChildNode.getTextContent());
					}
				}//dept 차일드노드 검색 완료 지점
				System.out.println("===================================");
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
