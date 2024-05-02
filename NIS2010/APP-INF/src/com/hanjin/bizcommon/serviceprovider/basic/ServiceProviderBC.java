/*=========================================================
*	Copyright(c) 2006 CyberLogitec
*	@FileName 			: ServiceProviderBC.java
*	@FileTitle 			: ServiceProvider정보조회(공통 Popup)
*	Open Issues 		:
*	Change history 		:
*	@LastModifyDate 	: 2006-08-18
*	@LastModifier 		: sungseok,choi
*	@LastVersion 		: 1.0
*	2006-08-08 sungseok, choi
*	1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.serviceprovider.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;

import com.hanjin.bizcommon.serviceprovider.vo.SpListVO;

/**
 *	ENIS-BIZCOMMON Business Logic Command Interface<br>
 *	ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 *	@author 	sungseok, choi
 *  @modifier	sungseok, choi	
 *	@see 		ComEns0C1EventResponse 참조
 *	@since 		J2EE 1.4
 */
public interface ServiceProviderBC  {
	
        /**
         * Service Provider 리스트 조회<br>
         * @param SpListVO spListVO
		 * @param int iPage
         * @return List<SpListVO>
         * @throws EventException
         */
        public List<SpListVO> searchServiceProviderList(SpListVO spListVO, int iPage) throws EventException;

}

