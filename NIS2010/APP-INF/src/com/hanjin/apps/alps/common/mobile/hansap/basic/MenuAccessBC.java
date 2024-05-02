/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : MenuAccessBC.java
 * @FileTitle : Menu별 접근 권한 추가, 삭제
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.12.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 2013.12.17 1.0 Sang-Hyun Kim Creation.
 */
package com.hanjin.apps.alps.common.mobile.hansap.basic;

import com.hanjin.apps.alps.common.mobile.hansap.vo.MobAuthorityVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * Menu별 접근 권한 추가, 삭제
 * @author Sang-Hyun Kim
 * @see 
 * @since J2EE 1.4
 */
public interface MenuAccessBC {

	/**
	 * Menu별 접근 권한 추가.
	 * @param mobAuthorityVOs
	 * @return Integer
	 * @throws EventException
	 */
	public Integer addAuth(MobAuthorityVO mobAuthorityVOs[]) throws EventException;

	/**
	 * Menu별 접근 권한 삭제.
	 * @param mobAuthorityVOs
	 * @return Integer
	 * @throws EventException
	 */
	public Integer removeAuth(MobAuthorityVO mobAuthorityVOs[]) throws EventException;
}
