/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FillInEquipmentNoBC.java
*@FileTitle : WO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-22
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-11-10 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * EXP_PAP Business Logic Command Interface<br>
 * - EXP_PAP에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see ExpPap0003EventResponse 참조
 * @since J2EE 1.4
 */
public interface FillInEquipmentNoBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap0003Event
	 * @return EventResponse ExpPap0003EventResponse
	 * @exception EventException
	 */
	public EventResponse searchFillInEquipmentNoList(Event e) throws EventException;


	
	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap0003Event
	 * @return EventResponse ExpPap0003EventResponse
	 * @exception EventException
	 */
	
	public EventResponse searchFillInEquipmentNoExcelPrint(Event e) throws EventException;
		
}