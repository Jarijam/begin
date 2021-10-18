package test.annotation;

import org.springframework.stereotype.Repository;

//빈등록 - DAO역할을 하는 빈 (지금은 아니지만)(<bean.엘리먼트를 설정파일에 등록하는 것과 동일)
@Repository
public class LogicImpl implements Logic {

	@Override
	public void testLogic() {
		System.out.println("db연동,xml파싱, json파싱, 연산등을 수행하는 비지니스메소드");
	}

}
