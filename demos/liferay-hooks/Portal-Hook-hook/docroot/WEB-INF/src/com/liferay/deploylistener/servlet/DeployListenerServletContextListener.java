/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.deploylistener.servlet;

import com.liferay.deploylistener.hook.deploy.DeployListenerDeployManagerImpl;
import com.liferay.portal.kernel.deploy.DeployManager;
import com.liferay.portal.kernel.deploy.DeployManagerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.BasePortalLifecycle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Brian Wing Shun Chan
 */
public class DeployListenerServletContextListener
	extends BasePortalLifecycle implements ServletContextListener {

	private static Log log = LogFactoryUtil.getLog(DeployListenerServletContextListener.class);
	
	public DeployListenerServletContextListener() {
		System.out.println("DeployListenerServletContextListener");
		log.info("no pinta");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("contextDestroyed");
		portalDestroy();
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("contextInitialized");
		registerPortalLifecycle();
	}

	@Override
	protected void doPortalDestroy() throws Exception {
		System.out.println("doPortalDestroy");
		DeployManager deployManager = DeployManagerUtil.getDeployManager();

		if (deployManager instanceof DeployListenerDeployManagerImpl) {
			DeployManagerUtil deployManagerUtil = new DeployManagerUtil();

			DeployListenerDeployManagerImpl deployListenerDeployManagerImpl =
				(DeployListenerDeployManagerImpl)deployManager;

			deployManagerUtil.setDeployManager(
				deployListenerDeployManagerImpl.getWrappedDeployManager());
		}
	}

	@Override
	protected void doPortalInit() {
		System.out.println("doPortalInit");
		DeployManagerUtil deployManagerUtil = new DeployManagerUtil();

		DeployListenerDeployManagerImpl deployListenerDeployManagerImpl =
			new DeployListenerDeployManagerImpl(
				DeployManagerUtil.getDeployManager());

		deployManagerUtil.setDeployManager(deployListenerDeployManagerImpl);
	}

}