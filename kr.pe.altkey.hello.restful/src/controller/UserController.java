package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.User;
import service.UserService;

@Controller
public class UserController{
	
	private UserService service;
	
	@Autowired
	public UserController(UserService userServiceImpl) {
		this.service = userServiceImpl;
	}
	
	/**
	 * User 생성
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ModelAndView create(User user) {
		//
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/join.jsp");
		service.create(user);
		System.out.println("/user" + " | " + "수행");
		return mav;
	}
	
	/**
	 * 전체 리스트 출력
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listAll(Model model) {
		//
		model.addAttribute("listAll",service.readAll());
		
		System.out.println("/list" + " | " + "수행");
		
		//applicationContext.xml 에 보면 prefix 등 설정해두었기 때문에 제외하고 작성
		return "list";
	}
	
	
	/**
	 * 읽기
	 * @param model
	 * @param id
	 * @return
	 */
	// {[변수명]} 과 @PathVariable 의 [변수명]은 일치해야한다.
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public String read(Model model, @PathVariable int id) {
		//
		User user = service.read(id);
		
		ObjectMapper jsonMapper = new ObjectMapper();
		
		String jsonString = null;
		
		try {
			jsonString = jsonMapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			//
			e.printStackTrace();
		}
		
		System.out.println("/user/" + id + " GET | " + "수행");
		
		model.addAttribute("user", user);
		return "detail";
	}
	
	/**
	 * 업데이트시에 사용
	 * @param user
	 * @param id
	 * @return
	 */
	//	 * RequestMethod.PATCH 도 있긴하나 잘 쓰이진 않음. PATCH의 사용용도는 단건에 대한 업데이트 PUT은 여러건이라고 한다.
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public String update(@RequestBody User user, @PathVariable int id) {
		//
		user.setId(id);
		service.modify(user);
		
		System.out.println("/user/" + id + " PUT | " + "수행");
		return "redirect:/user/"+id;
	}
	
	/**
	 * 삭제시 사용
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		//
		System.out.println("/user/" + id + " DELETE | " + "수행");
		
		service.delete(id);
		return "/list";
	}

}
