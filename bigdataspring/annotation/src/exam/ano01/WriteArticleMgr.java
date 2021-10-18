package exam.ano01;
//service의 역할을 하는 클래스

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("mgr")
public class WriteArticleMgr implements IWriteArticleMgr {
	
	@Autowired
	@Qualifier("oracle")
	//@Qualifier("mysql")
	IArticleDAO articleDAO; 
	
	public WriteArticleMgr() {
		//별말 없어도 디폴트 생성자는 만들어주자.
	}
	
	public WriteArticleMgr(IArticleDAO articleDAO) {
		super();
		this.articleDAO = articleDAO;
		
	}
	@Override
	public void write(ArticleDTO article) {
		articleDAO.insert(article);
	}

}
