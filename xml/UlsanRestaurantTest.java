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

//울산광역시_음식점 현황를 파싱하기
//xml 파일을 -- X
//url을 통해서 접속하고 xml정보를 가져온 후 parser로 원하는 정보를 추출
public class UlsanRestaurantTest {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			//파싱할 InputStream 생성
			//1. 웹서비스를 제공하는 url에 연결해서 데이터를 가져오기
			//1) 접속할 url의 정보를 정의
			StringBuffer urlBuilder = new StringBuffer(); 
			urlBuilder.append("http://data.ulsan.go.kr/rest/ulsanexamplerestaurant/getUlsanExampleRestaurantList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=%2BnD89OSBMpWrvxggSdEHOAisR8tpw57WnzvAnyDd193Sip982MRgmoJmRhw554VdeZnOqmGzSLJ3Awy7sjED6w%3D%3D"); /*Service Key*/
	        //urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*서비스키*/
//	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("220", "UTF-8")); /*한 페이지 결과 수*/
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
			NodeList title = root.getElementsByTagName("title");
			NodeList address = root.getElementsByTagName("address");
			NodeList business = root.getElementsByTagName("business");
			NodeList tel = root.getElementsByTagName("tel");
			NodeList mainMenu = root.getElementsByTagName("mainMenu");
			System.out.println(title.getLength());
			for(int i=0;i<title.getLength();i++) {
				Node node1 = title.item(i);
				Node node2 = address.item(i);
				Node node3 = business.item(i);
				Node node4 = tel.item(i);
				Node node5 = mainMenu.item(i);
				NodeList item_childlist1 = node1.getChildNodes();
				NodeList item_childlist2 = node2.getChildNodes();
				NodeList item_childlist3 = node3.getChildNodes();
				NodeList item_childlist4 = node4.getChildNodes();
				NodeList item_childlist5 = node5.getChildNodes();
				for(int j=0;j<item_childlist1.getLength();j++) {
					Node item_child1 = item_childlist1.item(j);
					Node item_child2 = item_childlist2.item(j);
					Node item_child3 = item_childlist3.item(j);
					Node item_child4 = item_childlist4.item(j);
					Node item_child5 = item_childlist5.item(j);
					
					//System.out.println(item_child.getNodeName()+":"+ item_child.getTextContent());
					String data1 = item_child1.getTextContent();
					String data2 = item_child2.getTextContent();
					String data3 = item_child3.getTextContent();
					String data4 = item_child4.getTextContent();
					String data5 = item_child5.getTextContent();
					System.out.print("insert into restaurant_data values('"+data1+"','"+data2+"','"+data3+"','"+data4+"','"+data5+"');");
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
