package exam.ano01;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("oracle")

public class OracleArticleDAO implements IArticleDAO {
	
	
	@Override
	public void insert(ArticleDTO article) {
		System.out.println("oracle로 insert");
	}

}
