package test.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//빈을 등록 - 서비스단의 역할을 하는 객체를 등록
//등록할때 이름을 정의할 수 있다. - <bean>엘리먼트에서 id설정하는것과 동일
@Service("myservice")
public class MyServiceImpl implements MyService {
	String name;
	String msg;
	
	@Autowired
	@Qualifier("logicImpl")
	Logic logicObj;
	
	public MyServiceImpl() {
		System.out.println("MyServiceImpl의 기본생성자");	
		}
	
	
	public MyServiceImpl(String name) {
		super();
		this.name = name;
		System.out.println("매개변수 1개(name) 생성자");
	}


	public MyServiceImpl(String name, String msg, Logic logicobj) {
		super();
		this.name = name;
		this.msg = msg;
		this.logicObj = logicobj;
		System.out.println("매개변수 3개 생성자");
	}


	@Override
	public void testLogic() {
		System.out.println(msg+","+name);
		logicObj.testLogic();
	}

}
