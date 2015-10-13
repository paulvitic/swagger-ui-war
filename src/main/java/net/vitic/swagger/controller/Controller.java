package net.vitic.swagger.controller;


import net.vitic.swagger.SwaggerUiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private MessageSource messages;
	
	@RequestMapping(value="/{sessionId}/termsofuse", method=RequestMethod.GET)
	public ModelAndView termsOfUse(
			@PathVariable(value = "sessionId") String sessionId
			) throws SwaggerUiException {

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
        model.addObject("accounts", "");
        return model;
	}

}
