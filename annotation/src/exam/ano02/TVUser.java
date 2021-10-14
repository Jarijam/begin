package exam.ano02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		/*
		 * 스프링컨테이너에 의해 생성해서 객체를 전달 받아 사용할 수 있도록 수정하기
		 * Dependency Lookup적용
		 * 설정파일:config/bean.xml
		 * 빈 등록 :
		 *     SamsungTV => tv
		 *     LgTV => tv
		 *     
		   테스트 => SamsungTV로 작업하는 겨우 LgTV를 주석처리하고 작업하기
		   			speaker도 sonyspeaker를 작업하는 동안은 applespeaker는 주석처리하고 테스트
		 * getBean으로 얻어와서 작업하도록 코드 수정하기    
		 */
		AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("/config/exam.xml");
		TV tv = factory.getBean("lg",TV.class);
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	
	}

}
