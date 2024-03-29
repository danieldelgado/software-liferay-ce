package com.vst.spring.demo;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.vst.spring.service.SpringDemoService;

/**
 * Portlet implementation class SpringDemoController
 */

//http://www.opensource-techblog.com/2012/11/how-to-create-friendly-url-for-liferay.html
//http://loongest.com/liferay/liferay-friendly-url-mapper/


@Controller
@RequestMapping("VIEW")
public class SpringDemoController {

	private static Log log = LogFactoryUtil.getLog(SpringDemoController.class);
	/*
	 * maps the incoming portlet request to this method Since no request
	 * parameters are specified, therefore the default render method will always
	 * be this method
	 */

	@Autowired
	private SpringDemoService demoService;

	
	
	@RenderMapping
	public String defaultview(RenderRequest request, RenderResponse response, Model model) {
		log.info(" SpringDemoController defaultview demoService");
		model.addAttribute("msg", "holaaaa");
		System.out.println(demoService.hello());
//		 HolaMundo a = new HolaMundo();
		// a.ejectuta();
		return "view";
	}

	@ActionMapping(params = "action=addUserName")   
	 public void addUserName(ActionRequest request, ActionResponse response) {  
	  String userName=ParamUtil.get(request, "userName", "");  
	  log.info("userName is==>"+userName);  
	 }  
	   
	 @RenderMapping(params ="action=viewUser")  
	 public String viewUser(RenderRequest request,RenderResponse response,Model model){  
	    
	  return "viewUser";  
	 }  
	 @RenderMapping(params ="action=editUser")  
	 public String editUser(RenderRequest request,RenderResponse response,Model model){  
	    
	  return "editUser";  
	 }  
}
