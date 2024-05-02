/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WSInquiryBC.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
**@LastVersion : 1.1
* 2006-11-10 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see ESD_WS_019EventResponse 참조
 * @since J2EE 1.4
 */
public interface WorkOrderMainBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap0005Event
	 * @return EventResponse ExpPap0005EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWorkOrderMainList(Event e) throws EventException;
	
	/**
	 * count 가져오기.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchWorkOrderMainKnt(Event e) throws EventException;

}