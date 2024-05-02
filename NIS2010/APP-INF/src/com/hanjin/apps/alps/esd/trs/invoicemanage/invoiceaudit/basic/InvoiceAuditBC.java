/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : invoiceauditBC.java
*@FileTitle : invoice Audit Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Lee_SangWoo
*@LastVersion : 1.0
* 2006-12-06 Lee_SangWoo
* 1.0 최초 생성
* 2013.02.26 조인영 [CHM-201323086] Invoice Audit시 validation 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic;

import java.util.ArrayList;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-invoicemanage Business Logic Command Interface<br>
 * - ESD-invoicemanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee_SangWoo
 * @see EsdTrs0910EventResponse 참조
 * @since J2EE 1.4
 */
public interface InvoiceAuditBC  {
 
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdmOrganization(Event e) throws EventException;
	
	/**
	 * Reject Invoice<br>
	 * Reject 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse rejectInvoice(Event e) throws EventException;
	
	
	/**
	 * import 할 Invoice List<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse saveInvoiceAudit(Event e) throws EventException;
	
	/**
	 * import 할 Invoice List<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_910EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoiceAudit(Event e) throws EventException;
	
	/**
	 * container file import popup의 verify<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyEqNo(Event e) throws EventException;
	
	/**
	 * invoice 리스트 가져오기<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0033Event
	 * @return EventResponse ESD_TRS_0033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceAuditListByInvoiceNo(Event e) throws EventException;
	
	/**
	 * invoice 리스트 가져오기<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_0033Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchInvoiceAuditList(Event e) throws EventException;
	
	/**
	 * invoice 중복 체크<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_910Event
	 * @return EventResponse ESD_TRS_910EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDupChkInvoice(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_910Event
	 * @return EventResponse ESD_TRS_910EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentSP(Event e) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TRS_040 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse multiInvoiceAuditRefund(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvOfcCd(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoiceaudit화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentVnder(Event e) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * invoiceaudit화면에 invoice 유효성 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceNo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Refund Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRefundList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Refund Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateExchangeRate(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Refund Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportSO(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Refund Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportWO(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Refund Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportEmptyWO(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Refund Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param eqNo
	 * @return
	 * @throws EventException
	 */
	public String verifyEqNo(String eqNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * Refund Audit 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTruckInvoiceFileImport(Event e) throws EventException;
	
	/**
	 * bkg_no와 EQ가 mapping이 되어있는 컨테이너를 조회<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param rsValue
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet rsValue, TrsTrspSvcOrdVO model) throws EventException;
	
	/**
	 * bkg_no와 EQ가 mapping이 되어있는 컨테이너를 조회<br>
	 * 조회 이벤트 처리<br>
	 * 
	 * @param svcModel
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public String searchInvoiceImportBkgBkgCntr2(TrsTrspSvcOrdVO svcModel, TrsTrspSvcOrdVO model) throws EventException;
	
	/**
	 * searchPaymentChildVnder<br>
	 * select 이벤트 처리<br>
	 * 
	 * @param vndrSeq
	 * @return
	 * @throws EventException
	 */
	public ArrayList searchPaymentChildVnder(String vndrSeq) throws EventException;
	
	/**
	 * searchInvoiceImportDuplicateCheckByDate<br>
	 * data에 의한 중복체크 처리 +- 2일 <br>
	 * 
	 * @param model TrsTrspSvcOrdVO
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportDuplicateCheckByDate(TrsTrspSvcOrdVO model) throws EventException;
	
	
	/**
	 * S/O Creation 날짜 기준으로 Invoice 중복여부를 조회<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceImportDuplicateCheckByDate2(Event e) throws EventException;
	
	/**
	 * SO의 Suchargy를 가지고 온다.<br>
	 * 
	 * @param event
	 * 
	 * @return ArrayList
	 * @throws EventException
	 */
	public ArrayList searchWoSurcharge(EsdTrs0033Event event) throws EventException;
	
	/**
	 * WO issue , Invoice 처리 안된 데이터인지 체크.<br>
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void checkConfirmInvoice(EsdTrs0033Event event) throws EventException;
	
	/**
	 * Invoice confirm 생성 및 수정
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public EventResponse confirmInvoiceAuditForMain(EsdTrs0033Event event) throws EventException;
	
	/**
	 * Invoice Confirm 처리한다<br>
	 * 
	 * @param event
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse confirmInvoiceAuditForSvcOrd(EsdTrs0033Event event, int row) throws EventException;
	
	/**
	 * Invoice 상태를 Save 상태로 Rollback.<br>
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void rollbackInvoiceAuditForMain(EsdTrs0033Event event) throws EventException;
	
	/**
	 * 기존 저장된 3rd party billing currency를 가져온다.<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchN3ptyCurrCd(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WO SP의 PARENTS SP를 가져온다<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendor(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * SO Amt 일치 여부를 검사한다.<br>
	 * 
	 * @param model TrsTrspSvcOrdVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchSOAmt(TrsTrspSvcOrdVO model) throws EventException;

	public EventResponse searchIdaTaxRto(Event e) throws EventException;
	public EventResponse verifySacNo(Event e) throws EventException;
}