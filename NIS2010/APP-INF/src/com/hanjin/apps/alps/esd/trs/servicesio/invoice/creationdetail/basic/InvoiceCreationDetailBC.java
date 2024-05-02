/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDetailBC.java
*@FileTitle : SPP TRS Invoice Creation Submit Basic Command
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-04 sunghwan cho : Submit 기능을 PI eNIS모듈 호출방식으로 변경하여, 관련 루틴 삭제
* 2007-04-04 sunghwan cho : getParentVendorCode, getReceiveDate 추가
* 2007-04-10 sunghwan cho : getCreateOfficeCode 추가
* 2007-04-23 sunghwan cho : Invoice Office 취득 SQL 변경
*@LastModifyDate : 2007-04-23
*@LastModifier : sunghwan cho
*@LastVersion : 1.4
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.basic;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.MultiInvoiceCreationDetailList;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * Basic Command<br>
 * - SPP TRS Invoice Creation Submit Basic Command<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public interface InvoiceCreationDetailBC  {

	/**
	 * searchInvoiceCreationDetailList<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response InvoiceNoticeInquiry[]
	 * @exception EventException
	 */
	public InvoiceCreationInquiry[] searchInvoiceCreationDetailList(Event e) throws EventException;

	/**
	 * getParentVendorCode<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param vendorCode int
	 * @return response int
	 * @exception EventException
	 */
	public int getParentVendorCode(int vendorCode) throws EventException;

	/**
	 * getCreateOfficeCode<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param officeCode String
	 * @return response String
	 * @exception EventException
	 */
	public String getCreateOfficeCode(String officeCode) throws EventException;
	
	/**
	 * getReceiveDate<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param officeCode String
	 * @return response String
	 * @exception EventException
	 */
	public String getReceiveDate(String officeCode) throws EventException;
	
	/**
	 * checkMultiInvoiceValue<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response InvoiceNoticeInquiry
	 * @exception EventException
	 */
	public MultiInvoiceCreationDetailList checkMultiInvoiceValue(Event e) throws EventException;
	
	/**
	 * checkMultiInvoiceValue<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response int
	 * @exception EventException
	 */
	public int saveMultiInvoice(Event e) throws EventException;
	
}