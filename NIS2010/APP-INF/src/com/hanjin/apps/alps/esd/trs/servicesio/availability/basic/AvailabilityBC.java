/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WSInquiryBC.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-10 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.availability.basic;

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
public interface AvailabilityBC  {

	/**  
	 * 조회 이벤트 처리<br> 
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ExpPap004Event
	 * @return EventResponse ExpPap004EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAvailabilityPeriodList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response ExpPap004EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAvailabilityNoList(Event e) throws EventException;		
	
	/**
	 * 조회 이벤트 처리<br>
	 * WSInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EXP_PAP_004EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEmptyAvailabilityList(Event e) throws EventException;
}