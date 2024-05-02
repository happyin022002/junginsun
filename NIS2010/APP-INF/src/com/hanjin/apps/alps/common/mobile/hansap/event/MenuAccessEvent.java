/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : MenuAccessEvent.java
 * @FileTitle : 입력 Parameter 저장.
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.12.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 2013.12.17 1.0 Sang-Hyun Kim Creation
 */
package com.hanjin.apps.alps.common.mobile.hansap.event;

import com.hanjin.apps.alps.common.mobile.hansap.vo.MobAuthorityVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * Parameter Value Object.
 * @author Sang-Hyun Kim
 * @since J2EE 1.6
 * @see
 */
public class MenuAccessEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	private MobAuthorityVO mobAuthorityVO = null;
	private MobAuthorityVO mobAuthorityVOs[] = null;

	/**
	 * @return the mobAuthorityVO
	 */
	public MobAuthorityVO getMobAuthorityVO() {
		return mobAuthorityVO;
	}

	/**
	 * @param mobAuthorityVO the mobAuthorityVO to set
	 */
	public void setMobAuthorityVO(MobAuthorityVO mobAuthorityVO) {
		this.mobAuthorityVO = mobAuthorityVO;
	}

	/**
	 * @return the mobAuthorityVOs
	 */
	public MobAuthorityVO[] getMobAuthorityVOs() {
		return mobAuthorityVOs;
	}

	/**
	 * @param mobAuthorityVOs the mobAuthorityVOs to set
	 */
	public void setMobAuthorityVOs(MobAuthorityVO[] mobAuthorityVOs) {
		this.mobAuthorityVOs = mobAuthorityVOs;
	}
}
