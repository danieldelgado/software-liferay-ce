package com.vst.spring.demo;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vst.spring.jpa.Order;
import com.vst.spring.jpa.Product;
import com.vst.spring.service.OrderService;
import com.vst.spring.service.OrderServiceImpl;
import com.vst.spring.service.ProductService;
import com.vst.spring.service.ProductServiceImpl;

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
//	@Autowired
//	@BeanReference(name = "com.vst.spring.service.OrderServiceImpl")
	private OrderService orderService = new OrderServiceImpl();
	
//	@Autowired
//	@BeanReference(name = "com.vst.spring.service.ProductServiceImpl")
	private ProductService productService = new ProductServiceImpl();
	
	@RenderMapping
	public String defaultview(RenderRequest request,RenderResponse response,Model model){
		log.info(" SpringDemoController defaultview demoService");
		
		Order o = new Order();
		o.setDescription("asdsadsa");
		
//		Product product = new Product();
//		product.setDescription("asdsad");
//		product.setPrice(5345);
//		product.setQtaAvailable(345);
		
		orderService.insertOrder(o);
		
		model.addAttribute("msg", "holaaaa");
		return "view";
	}
	
	
}
