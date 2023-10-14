package in.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MsgController {

     
    @GetMapping("/welcome")
	public ModelAndView getWelcomeMsg() {
		ModelAndView mvc = new ModelAndView();
		mvc.addObject("msg", "Welcome To Pusad");
		mvc.setViewName("message");
		return mvc;
	}
    
    @GetMapping("/greet")
    public ModelAndView getGreetMsg() {
    	ModelAndView mvc1 = new ModelAndView();
    	mvc1.addObject("msg", "Good Morning Guys...");
    	mvc1.setViewName("message");
    	return mvc1;
    }
}
