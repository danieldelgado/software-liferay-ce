package com.vst.spring.service;

import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class SpringDemoController
 */

@Service("SpringDemoService")
public class SpringDemoServiceImpl implements SpringDemoService {

	private static Log log = LogFactoryUtil.getLog(SpringDemoServiceImpl.class);

	@Override
	public String hello() {
		log.info(" SpringDemoServiceImpl ");
		return "holaaaaa :D";
	}
	
	
	
	
}
