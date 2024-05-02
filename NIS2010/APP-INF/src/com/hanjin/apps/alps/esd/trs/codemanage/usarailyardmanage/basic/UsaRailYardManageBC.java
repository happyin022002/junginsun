/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaRailYardManageBC.java
*@FileTitle : UsaRailYardManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-11
*@LastModifier : Jun Yong Park
*@LastVersion : 1.0
* 2009-05-11 Jun Yong Park
* 1.0 최초 생성
* N200905150040 2009-05-20 [TRS]USA RAIL YARD 정보 저장 화면 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-UsaRailYardManage Business Logic Command Interface<br>
 * - ENIS-UsaRailYardManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong yeon cho
 * @see EsdTrs0084EventResponse 참조
 * @since J2EE 1.4
 */
public interface UsaRailYardManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * UsaRailYardManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0084Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchUsaRailYardManage(Event e) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_084 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0084Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse multiUsaRailYardManage(Event e) throws EventException;

}