package net.vitic.swagger.controller;


import net.vitic.swagger.SwaggerUiException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/doc")
public class SwaggerController {
	
	@RequestMapping(value = "/*", method=RequestMethod.GET)
	public ModelAndView getSwagger(HttpServletRequest request
			) throws SwaggerUiException {

		String path = request.getServletPath();
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
        model.addObject("path", path);
        return model;
	}

}
