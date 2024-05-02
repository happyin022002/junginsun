/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SOInquiryBC.java
*@FileTitle : SO Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.30
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.11.10 juhyun
* 1.0 최초 생성
* --------------------------------------------------------
* History
* 2010.09.30 최 선  1.1 [] SO Inquiry 엑셀 다운로드 수정
* 2011.06.28 손은주 [CHM-201111573-01]	[TRS] S/O history function 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.soinquiry.basic;

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author juhyun
 * @see EsdTrs0019EventResponse 참조
 * @since J2EE 1.4
 */
public interface SOInquiryBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * SOInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @param soffice_cd
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSOInquiry(Event e, String soffice_cd) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * SOInquiry화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse search_office(Event e) throws EventException;

	/**
	 * 
	 * USA404EDIStatusInquiry화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_028Event
	 * @return DBRowSet DBRowSet
	 * @exception EventException
	 */
	DBRowSet getRowSet(Event e, String soffice_cd) throws EventException ;
	
	/**
	 * 
	 * USA404EDIStatusInquiry화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return String[]
	 * @exception 
	 */
	String[] getTitle(Event e);

	/**
	 * 
	 * USA404EDIStatusInquiry화면에 대한 Down Excel 이벤트 처리<br>
	 * 
	 * @param e 
	 * @return String[]
	 * @exception 
	 */
	String[] getColumns(Event e);
	
	/**
	 * 조회 이벤트 처리<br>
	 * SOHistory화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchSOHistory(Event e) throws EventException;

}