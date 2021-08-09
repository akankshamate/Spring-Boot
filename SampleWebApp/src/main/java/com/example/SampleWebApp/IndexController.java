package com.example.SampleWebApp;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IndexController{
	
	@RequestMapping("/regform")
	public ModelAndView register() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/userDetail")
	public ModelAndView userInfo(UserRegistration reg) {
		
		ModelMap model=new ModelMap();
		model.addAttribute("name",reg.getUName());
		model.addAttribute("email",reg.getEmailId());
		model.addAttribute("gender",reg.getGender()==Integer.parseInt("1")?"Male":"Female");
		model.addAttribute("hobbies",reg.getHobby());
		
		ModelAndView mv=new ModelAndView("user-Detail") ;
		mv.addObject("regObj",model);
		return mv;
	}
}
