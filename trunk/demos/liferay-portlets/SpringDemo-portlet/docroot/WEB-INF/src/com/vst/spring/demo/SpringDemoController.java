package com.vst.spring.demo;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class SpringDemoController
 */
@Controller
@RequestMapping("VIEW")
public class SpringDemoController  {

	private static Log log = LogFactoryUtil.getLog(SpringDemoController.class);
	/*
	 * maps the incoming portlet request to this method
	 * Since no request parameters are specified, therefore the default
	 * render method will always be this method
	 */
	@RenderMapping
	public String defaultview(RenderRequest request,RenderResponse response,Model model){
		log.info(" SpringDemoController defaultview ");
		model.addAttribute("msg", "holaaaa");
		
//		HolaMundo a = new HolaMundo();
//		a.ejectuta();
		return "view";
	}
	
	
}