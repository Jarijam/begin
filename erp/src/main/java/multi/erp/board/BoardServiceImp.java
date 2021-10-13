package multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO dao;
	@Override
	public List<BoardVO> boardList() {
		return dao.boardList();
	}
	
	@Override
	public List<BoardVO> findByCategory(String category) {
		List<BoardVO> boardlist = null;
		if (category!=null) {
			if(category.equals("all")) {
				System.out.println("all");
				boardlist = dao.boardList(); //카테고리없이 전체 조회 dao 메소드
			}else {
				boardlist = dao.categorySearch(category); //카테고리 값따라 조회
			}
		}
		return boardlist;
	}


	@Override
	public int txinsert(BoardVO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(BoardVO board)  {
		System.out.println("board서비스단 insert =>"+board);
		return dao.insert(board);
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

	/*
	 * @Override public boolean idCheck(String id) { return dao.idCheck(id); }
	 */
	
	
	/*
	 * @Override public List<BoardVO> findByCategory(String category) { // TODO
	 * Auto-generated method stub return null; }
	 */
}
