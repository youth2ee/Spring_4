package com.naver.s4.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@PostMapping("/testAjax")
	public void testAjax(Model model, int num) throws Exception {
		Random r = new Random();
		num = r.nextInt(num);
		model.addAttribute("num", num);
	}
	
	@GetMapping("/selectAnimal")
	public void testAjax(Model model, String animal) throws Exception {
		if(animal.equals("dog")) {
			String [] kind = {"강아지1", "강아지2", "강아지3"};
			model.addAttribute("kind", kind);
		} else if(animal.equals("cat")) {
			String [] kind = {"고양이1", "고양이2", "고양이3"};
			model.addAttribute("kind", kind);
		} else {
			String [] kind = {"새1", "새2", "새3"};
			model.addAttribute("kind", kind);
		}
		
	}
	
	
}
