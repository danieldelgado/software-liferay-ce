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

package com.liferay.compat.hook.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class CompatHttpServletRequest extends HttpServletRequestWrapper {

	private static Log log = LogFactoryUtil.getLog(
			CompatHttpServletRequest.class);
	public CompatHttpServletRequest(
		HttpServletRequest request, String pathInfo) {
		super(request);

		log.info("CompatHttpServletRequest");
		_pathInfo = pathInfo;
	}

	public String getPathInfo() {
		return _pathInfo;
	}

	private String _pathInfo;

}