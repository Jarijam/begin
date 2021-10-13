package multi.erp.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	SqlSession sqlSession;
	@Override
	public int insert(BoardVO board) {
		System.out.println("board테이블에 insert:"+board);
		
		return sqlSession.insert("erp.board.insert",board);
		
	}
	@Override
	public List<BoardVO> boardList() { // 전체목록 조회하는 부분.
		System.out.println("boardList 호출");
		return sqlSession.selectList("erp.board.list"); //board.xml에 id불러오기
	}


	@Override
	public List<BoardVO> searchList(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> searchList(String tag, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> pageList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO read(String board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//게시글에서 카테고리별로 검색하기 위한 메소드
	@Override
	public List<BoardVO> categorySearch(String category) {
		// TODO Auto-generated method stub
		//sql받아서 category조회할 수 잇도록
		return sqlSession.selectList("erp.board.category", category);
	}
	
	
}
