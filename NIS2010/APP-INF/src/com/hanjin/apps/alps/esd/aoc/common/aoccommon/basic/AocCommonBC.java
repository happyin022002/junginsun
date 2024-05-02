/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocCommonBC.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* ---------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Min Jung Ho
 * @see ESD_AOC_0999EventResponse 참조
 * @since J2EE 1.6
 */

public interface AocCommonBC {	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 월,주차 검색기간 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchPeriod(Event e) throws EventException;

	/**
	 * RHQ Office 조회<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public String searchRHQOfficeCode(String ofcCd) throws EventException;
	
	/**
	 * Country Code Verify<br>
	 * 
	 * @param cntCd
	 * @return
	 * @throws EventException
	 */
	public String verifyCountryCode(String cntCd) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESD_AOC_0999 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String searchSubOfficeSOManageList(Event e) throws EventException;

}

