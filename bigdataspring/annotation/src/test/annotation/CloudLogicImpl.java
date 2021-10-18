package test.annotation;

import org.springframework.stereotype.Repository;

@Repository
public class CloudLogicImpl implements Logic {

	@Override
	public void testLogic() {
		System.out.println("AWS클라우드 서비스 이용하기");
	}

}
