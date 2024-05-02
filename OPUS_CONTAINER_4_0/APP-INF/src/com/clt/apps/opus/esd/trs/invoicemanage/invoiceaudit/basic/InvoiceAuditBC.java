/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : invoiceauditBC.java
*@FileTitle : invoice Audit Manage
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * InvoiceManage Business Logic Command Interface<br>
 * An interface to the business logic for InvoiceManage<br>
 *
 * @author 
 * @see Refer to EsdTrs0910EventResponse
 * @since J2EE 1.4
 */
public interface InvoiceAuditBC  {
 
	/**
	 * retrieve Invoice<br>
	 * retrieve event process<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdmOrganization(Event e) throws EventException;
	
	/**
	 * Reject Invoice<br>
	 * Reject event process<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse rejectInvoice(Event e) throws EventException;
	
	
	/**
	 * To import Invoice List<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public List<TrsTrspSvcOrdVO> saveInvoiceAudit(Event e) throws EventException;
	
	/**
	 * to import Invoice List<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_910EventResponse
	 * @exception EventException
	 */
	public EventResponse confirmInvoiceAudit(Event e) throws EventException;
	
	/**
	 * container file import popup verify<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyEqNo(Event e) throws EventException;
	
	/**
	 * invoice list retrieve<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_0033Event
	 * @return EventResponse ESD_TRS_0033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceAuditListByInvoiceNo(Event e) throws EventException;
	
	/**
	 * invoice list retrieve<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_0033Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchInvoiceAuditList(Event e) throws EventException;
	
	/**
	 * invoice Redundancy check <br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_910Event
	 * @return EventResponse ESD_TRS_910EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDupChkInvoice(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_910Event
	 * @return EventResponse ESD_TRS_910EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentSP(Event e) throws EventException;
	
	/**
	 * multi event process<br>
	 * ESD_TRS_040  multi event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse multiInvoiceAuditRefund(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvOfcCd(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * invoiceaudit retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPaymentVendor(Event e) throws EventException;
	
	
	/**
	 * retrieve event process<br>
	 * invoiceaudit invoice validation retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceNo(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Refund Audit  retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRefundList(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Refund Audit  retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateExchangeRate(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Refund Audit  retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportSO(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Refund Audit  retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportWO(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Refund Audit  retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportEmptyWO(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Refund Audit  retrieve event process<br>
	 * 
	 * @param eqNo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet verifyEqNo(String eqNo) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Refund Audit  retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTruckInvoiceFileImport(Event e) throws EventException;
	
	/**
	 * bkg_no and EQ retrieve a container that has been mapping <br>
	 * retrieve event process<br>
	 * 
	 * @param rsValue
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet rsValue, TrsTrspSvcOrdVO model) throws EventException;
	
	/**
	 * bkg_no and EQ retrieve a container that has been mapping <br>
	 * retrieve event process<br>
	 * 
	 * @param svcModel
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public String searchInvoiceImportBkgBkgCntr2(TrsTrspSvcOrdVO svcModel, TrsTrspSvcOrdVO model) throws EventException;
	
	/**
	 * searchPaymentChildVnder<br>
	 * select event process<br>
	 * 
	 * @param vndrSeq
	 * @return
	 * @throws EventException
	 */
	public ArrayList searchPaymentChildVendor(String vndrSeq) throws EventException;
	
	/**
	 * searchInvoiceImportDuplicateCheckByDate<br>
	 * data Redundancy check +/-2 days <br>
	 * 
	 * @param model TrsTrspSvcOrdVO
	 * @return ArrayList
	 * @exception EventException
	 */
	public ArrayList searchInvoiceImportDuplicateCheckByDate(TrsTrspSvcOrdVO model) throws EventException;
	
	
	/**
	 * S/O Creation date based on whether or not duplicate Invoice Inquiry<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvoiceImportDuplicateCheckByDate2(Event e) throws EventException;
	
	/**
	 * S/O of the Suchargy .<br>
	 * 
	 * @param event
	 * 
	 * @return ArrayList
	 * @throws EventException
	 */
	public ArrayList searchWoSurcharge(EsdTrs0033Event event) throws EventException;
	
	/**
	 * WO issue, Invoice Processing check if no data<br>
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void checkConfirmInvoice(EsdTrs0033Event event) throws EventException;
	
	/**
	 * Invoice confirm create and modify
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public EventResponse confirmInvoiceAuditForMain(EsdTrs0033Event event) throws EventException;
	
	/**
	 * Invoice Confirm process<br>
	 * 
	 * @param event
	 * @param row
	 * @return
	 * @throws EventException
	 */
	public EventResponse confirmInvoiceAuditForSvcOrd(EsdTrs0033Event event, int row) throws EventException;
	
	/**
	 * Save Invoice as the state Rollback .<br>
	 * 
	 * @param event
	 * @throws EventException
	 */
	public void rollbackInvoiceAuditForMain(EsdTrs0033Event event) throws EventException;
	
	/**
	 * Brings existing 3rd party billing currency is stored .<br>
	 * 
	 * @param e ESD_TRS_033Event
	 * @return EventResponse ESD_TRS_033EventResponse
	 * @exception EventException
	 */
	public EventResponse searchN3ptyCurrCd(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * PARENTS SP that brings in WO SP<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendor(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Invoice information set in ApPayInvVO.<br>
	 * 
	 * @param invNo
	 * @param ofcCd
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO searchApPayInvMain(String invNo, String ofcCd) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Invoice information set in ApPayInvDtlVO.<br>
	 * 
	 * @param invNo String
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvDetail(String invNo) throws EventException;
	
	/**
	 * invRgstNo information set in TRS_TRSP_INV_WRK.<br>
	 * 
	 * @param ApPayInvVO apPayInvVO
	 * @exception EventException
	 */
	public void updateRgstNoInvWrk(ApPayInvVO apPayInvVO) throws EventException;

	/**
	 * retrieve event process<br>
	 * Invoice Audit for Refund Main information set in ApPayInvVO. ESD_TRS_0040<br>
	 * 
	 * @param invNo
	 * @param ofcCd
	 * @return ApPayInvVO
	 * @throws EventException
	 */
	public ApPayInvVO searchApPayInvRfndMain(String invNo, String ofcCd) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Invoice Audit for Refund Detail information set in ApPayInvDtlVO. ESD_TRS_0040<br>
	 * 
	 * @param invNo String
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] searchApPayInvRfndDetail(String invNo) throws EventException;
	
	/**
	 * 
	 * @param invVndrSeq
	 * @param refInvNo
	 * @return
	 * @throws EventException
	 */
	public DBRowSet verifyRefInvNo(String invVndrSeq, String refInvNo) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * Refund Invoice & Detail List retrieve event process<br>
	 * 
	 * @param e ESD_TRS_040Event
	 * @return EventResponse ESD_TRS_040EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRefundInvAndDetailList(Event e) throws EventException;

	
}