package com.vst.spring.friendlyUrl;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;

public class FriendlierFriendlyURLMapper  extends DefaultFriendlyURLMapper {

	@Override
	public boolean isCheckMappingWithPrefix() {
		return false;
	}

}
