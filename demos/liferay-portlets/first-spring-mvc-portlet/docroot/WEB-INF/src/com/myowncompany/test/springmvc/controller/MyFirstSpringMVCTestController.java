package com.myowncompany.test.springmvc.controller;

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
import com.vst.dao.UsuarioDAO;
@Controller(value = "MyFirstSpringMVCTestController")
@RequestMapping("VIEW")
public class MyFirstSpringMVCTestController {

	private static Log log = LogFactoryUtil.getLog(MyFirstSpringMVCTestController.class);
	/*
	 * maps the incoming portlet request to this method
	 * Since no request parameters are specified, therefore the default
	 * render method will always be this method
	 */
			
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RenderMapping
	public String handleRenderRequest(RenderRequest request,RenderResponse response,Model model){
		log.info("getTodos");
		log.info(usuarioDAO.getTodos());		
		return "defaultRender";
	}
	
	@RenderMapping(params = "action=renderOne")
	public String openSaveSearchPopup(RenderRequest request, RenderResponse response, Model model){
		return "render1";
	}
	
	@RenderMapping(params = "action=renderTwo") 
	public String openDeeplinkForInfoI(RenderRequest request, RenderResponse response){
		return "render2";
	}
	
	@RenderMapping(params = "action=renderAfterAction") 
	public String testRenderMethod(RenderRequest request, RenderResponse response){
		log.info("In renderAfterAction method");
		return "renderAfterAction";
	}
	
	@ActionMapping(params = "action=actionOne") 
	public void actionOneMethod(ActionRequest request, ActionResponse response) {
		String userName=ParamUtil.get(request, "userName", "");
		log.info("userName is==>"+userName);
		response.setRenderParameter("action", "renderAfterAction");
	}
	
	@ActionMapping(params = "action=actionTwo")
	public String addMyChannelAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		return "action2";
	}
	
}
