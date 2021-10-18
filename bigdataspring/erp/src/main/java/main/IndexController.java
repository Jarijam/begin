package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import multi.erp.board.BoardService;
import multi.erp.board.BoardVO;

//tiles기반 작업
@Controller
public class IndexController {
	@Autowired
	BoardService service;
	@RequestMapping("/index.do")
	public ModelAndView index() {
		System.out.println("index 실행");
		ModelAndView mav = new ModelAndView("index");
		//index부에서 게시판 카테고리의 목록을 조회해야하므로
		List<BoardVO> boardlist = service.findByCategory("게시판");
		mav.addObject("boardlist",boardlist);
		return mav; //tiles설정 파일에 등록된 view의 이름
	}
	
//	@RequestMapping("/emp/login.do")
//	public String loginView() {
//		System.out.println("loginView실행");
//		return "login"; //tiles설정 파일에 등록된 view의 이름
//	}
	
	@RequestMapping("/menu/board.do")
	public String communityView() {
		return "board/list"; //tiles설정 파일에 등록된 view의 이름
	}
	
	
	
}
