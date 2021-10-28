package xml;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//건강보험심사평가원_약국정보를 파싱하기
//xml 파일을 -- X
//url을 통해서 접속하고 xml정보를 가져온 후 parser로 원하는 정보를 추출
public class PharmacyTest {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			//파싱할 InputStream 생성
			//1. 웹서비스를 제공하는 url에 연결해서 데이터를 가져오기
			//1) 접속할 url의 정보를 정의
			StringBuffer urlBuilder = new StringBuffer(); 
			urlBuilder.append("http://apis.data.go.kr/B551182/pharmacyInfoService/getParmacyBasisList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=%2BnD89OSBMpWrvxggSdEHOAisR8tpw57WnzvAnyDd193Sip982MRgmoJmRhw554VdeZnOqmGzSLJ3Awy7sjED6w%3D%3D"); /*Service Key*/
	        //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*서비스키*/
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("30", "UTF-8")); /*한 페이지 결과 수*/
//	        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON)*/
//	        urlBuilder.append("&" + URLEncoder.encode("sidoCd","UTF-8") + "=" + URLEncoder.encode("110000", "UTF-8")); /*시도코드*/
//	        urlBuilder.append("&" + URLEncoder.encode("sgguCd","UTF-8") + "=" + URLEncoder.encode("110019", "UTF-8")); /*시군구코드*/
//	        urlBuilder.append("&" + URLEncoder.encode("emdongNm","UTF-8") + "=" + URLEncoder.encode("신내동", "UTF-8")); /*읍면동명*/
//	        urlBuilder.append("&" + URLEncoder.encode("yadmNm","UTF-8") + "=" + URLEncoder.encode("온누리건강", "UTF-8")); /*병원명*/
//	        urlBuilder.append("&" + URLEncoder.encode("xPos","UTF-8") + "=" + URLEncoder.encode("127.0965441345503", "UTF-8")); /*x좌표*/
//	        urlBuilder.append("&" + URLEncoder.encode("yPos","UTF-8") + "=" + URLEncoder.encode("37.60765568913871", "UTF-8")); /*y좌표*/
//	        urlBuilder.append("&" + URLEncoder.encode("radius","UTF-8") + "=" + URLEncoder.encode("3000", "UTF-8")); /*반경*/
	        
			
			
			
	      //2) 웹서버에 접속하기
			URL url = new URL(urlBuilder.toString());
			//System.out.println(url.openStream());
			//3) 접속해서 reponse되는 데이터를 읽어오기
			//	 읽어온 데이터를 저장 - BufferedInputStream은 InputStream의 하위
			BufferedInputStream xmldata = new BufferedInputStream(url.openStream());
			
			Document document = builder.parse(xmldata); //InputStream객체의 형태로 파싱할 정보를 넘겨준다.
			
			Element root = document.getDocumentElement();
			System.out.println(root.getTagName());
			NodeList list = root.getElementsByTagName("item");
			System.out.println(list.getLength());
			
			for(int i=0;i<list.getLength();i++) {
				Node node = list.item(i);
				NodeList item_childlist = node.getChildNodes();
				for(int j=0;j<item_childlist.getLength();j++) {
					Node item_child = item_childlist.item(j);
					System.out.println(item_child.getNodeName()+":"+ item_child.getTextContent());
				}
				System.out.println();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
