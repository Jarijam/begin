package multi.erp.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController { //컨트롤러->서비스임플->dao임플 순으로 사용하려함
	@Autowired
	BoardService service;
	@RequestMapping("/board/insert.do")
	//스프링 mvc의 DispatcherServlet이 넘겨주는 VO객체를 서비스단의 메소드를 호출하면서 넘겨준다
	public String insert(BoardVO command) { //VO객체를 command객체라 한다.
		System.out.println("========="+command);
		//service.insert(command);
		String url = "";
		int result = service.insert(command);
		//insert가 성공한 경우 실패한경우 뷰를 다르게 넘겨주고 싶다면 insert처리 결과를 이용해서 아래와 같이 작업
		if (result >=1) {
			url = "redirect:/board/list.do?category=all";
		}else {
			url = "redirect:/board/insertPage.do"; //redirect: 안해주면 그냥 view로 인식해버림.
		}
		return url;
	}
	
	@RequestMapping("/board/list.do")
	public ModelAndView boardlist(String category) {
		System.out.println("===========>"+category);
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardVO> boardlist = service.findByCategory(category);
		//dao에서 결과가 넘어오는 경우 디버깅 작업은 넘어오는 데이터 sysout으로 컨트롤러 단까지 모두 출력해보기
		//tiles에 등록한 뷰의 이름
//		 mav.setViewName("board/list"); 
		mav.addObject("boardlist", boardlist);
		mav.addObject("category", category);
		return mav;
	}
	
	//Ajax로 카테고리별 게시판 데이터를 요청하는 메소드
	//=> 컨트롤러 메소드처럼 ModealAndView를 리턴하지 ㅇ낳고 일반메소드 처럼 ArrayList<BoardVO>를 리턴하며
	//	jackson json라이브러리가 자동으로 ArrayList<BoardVO>를 json으로 변환해서 리턴해준다.
	@RequestMapping(value = "/board/ajax_list.do", method = RequestMethod.GET, 
			produces = "application/json;charset=utf-8")
	public @ResponseBody ArrayList<BoardVO> categoryList(String category){
		ArrayList<BoardVO> boardlist = (ArrayList<BoardVO>)service.findByCategory(category);
		System.out.println("ajax통신 확인"+boardlist.size());
		return boardlist;
	}
}
