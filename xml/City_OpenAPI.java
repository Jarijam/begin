package OpenApiController;

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

//기상청_관광코스별 관광지 상세 날씨 조회서비스를 파싱하기
//xml 파일을 -- X
//url을 통해서 접속하고 xml정보를 가져온 후 parser로 원하는 정보를 추출
public class City_OpenAPI {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			//파싱할 InputStream 생성
			//1. 웹서비스를 제공하는 url에 연결해서 데이터를 가져오기
			//1) 접속할 url의 정보를 정의
			StringBuilder weather_url = new StringBuilder("http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst"); /*URL*/
			weather_url.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=ZkoRqV6G9PkOxORxIxHL8XTmRko%2FP2fSTHqjMRAR7QcrreyETtxifr3dkk3rI8qugmw%2Fgk9etscSONG2YOWe5Q%3D%3D"); /*Service Key*/
			weather_url.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
			weather_url.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
			weather_url.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML", "UTF-8")); /*요청자료형식(XML/JSON)*/
			weather_url.append("&" + URLEncoder.encode("CURRENT_DATE","UTF-8") + "=" + URLEncoder.encode("2021101301", "UTF-8")); /*해당날짜부터 조회*/
			weather_url.append("&" + URLEncoder.encode("HOUR","UTF-8") + "=" + URLEncoder.encode("24", "UTF-8")); /*CURRENT_DATE부터 24시간 후까지의 자료 호출*/
			weather_url.append("&" + URLEncoder.encode("COURSE_ID","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*관광 코스ID*/
			
			
			
			//2) 웹서버에 접속하기
			URL url = new URL(weather_url.toString());
			
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
