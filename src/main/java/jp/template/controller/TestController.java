package jp.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	// �����I�[�v�����B
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(ModelAndView modelAndView) throws Exception {



		return "test";
	}
}
