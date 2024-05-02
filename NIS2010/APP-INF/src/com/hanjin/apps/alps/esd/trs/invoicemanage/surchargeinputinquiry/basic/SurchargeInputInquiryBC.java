/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SurchargeInputInquiryBC.java
*@FileTitle : surcharge 입력/수정/삭제화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-17
*@LastModifier : Bong-jun
*@LastVersion : 1.8
* 2006-11-21 poong_yeon
* 1.0 최초 생성
* 1.13 N200902240180 [TRS] TPB 대상 건 I/F 가능 시점 추가 요청 (09.03.17)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-InvoiceManage Business Logic Command Interface<br>
 * - ESD-InvoiceManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author poong_yeon
 * @see EsdTrs0918EventResponse 참조
 * @since J2EE 1.4
 */
public interface SurchargeInputInquiryBC  {

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_918 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_918Event
	 * @return EventResponse ESD_TRS_918EventResponse
	 * @exception EventException
	 */
//	public EventResponse multiSurchargeInputInquiry(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTPBIfFlag(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSurchargeInputInquiryList(Event e) throws EventException;

	
	/**
	 * insert 처리<br>
	 * Surcharge Temp Table에 insert 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse addTempSurchargeList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SurchargeInputInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSurchargeCodeNameList(Event e) throws EventException;

}