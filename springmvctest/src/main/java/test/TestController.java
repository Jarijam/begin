package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class TestController {
	
	@RequestMapping("/index.do")
	public String main() {
		System.out.println("어노테이션 기반 컨트롤러");
		//
		return "jsp/index"; // view에 대한 정보 - WEB_INF폴더 빼고 확장자뺀 정보
	}
	
	@RequestMapping("/test.do")
	public ModelAndView test() {
		ModelAndView gugu = new ModelAndView();
		System.out.println("ModelAndView test() 실행 ");
		String result = "";
		
		for (int i = 1; i <10 ; i++) {
			result=result+("9*"+i+"="+9*i)+"<br/>";
		}
		gugu.addObject("result", gugu);
		gugu.addObject("result", result);
		gugu.setViewName("jsp/result");
		
		
		
		return gugu;
	}
	
	
}
