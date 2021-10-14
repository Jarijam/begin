package exam.ano01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		ApplicationContext container = 
				new GenericXmlApplicationContext("/config/exam.xml");
		
		IWriteArticleMgr mgr = (IWriteArticleMgr)container.getBean("mgr");

		mgr.write(new ArticleDTO());
		
	}

}
