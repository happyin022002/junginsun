/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CSRIssueTransferSlipManageBC.java
 *@FileTitle : BTransportation invoice CSR Creation - Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.component.rowset.DBRowSet;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 * 
 * @author kimjin
 * @see EsdTrs0032EventResponse
 * @since J2EE 1.6
 */
public interface CSRIssueTransferSlipManageBC {

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_031Event
	 * @return EventResponse ESD_TRS_031EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary(Event e) throws EventException;

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail(Event e) throws EventException;

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage ASA code related<br>
	 * 
	 * @param e ESD_TRS_031Event
	 * @return EventResponse ESD_TRS_031EventResponse
	 * @exception EventException
	 */
	public EventResponse checkASANO(Event e) throws EventException;

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse correctCsrAmt(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public String generateNewCsrNo(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 */
	public EventResponse createApInvHdrDtrb(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void createApInvIF(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @throws EventException
	 */
	public void checkApInvDtrbValidation(String sCsrNo) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @throws EventException
	 */
	public void updateApInvDtrbLineNo(String sCsrNo) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void updateCntrFincVVD(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @param sPreviewIndicator
	 * @return
	 * @throws EventException
	 */
	public EventResponse selectApInvHdrDtrbList(String sCsrNo, String sPreviewIndicator) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @throws EventException
	 */
	public void deleteInvHdrDtrbList(String sCsrNo) throws EventException;

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_034Event
	 * @return EventResponse ESD_TRS_034EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXInfo(Event e) throws EventException;

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApEviNo(Event e) throws EventException;

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_034Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXCode(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_0048Event
	 * @return EventResponse ESD_TRS_0048EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceListInquiry(Event e) throws EventException;

	/**
	 * Payment -> TRS TEMP
	 * 
	 * @param flag
	 * @param csr_no
	 * @exception EventException
	 */
	public void trsUpdateCSRSTSFlag(String flag, String csr_no) throws EventException;

	/**
	 * AP Interface - > TRS
	 * 
	 * @param o
	 * @throws EventException
	 */
	public void modifyTrsInvHdr(Object o) throws EventException;

	/**
	 * AP Interface - > TRS
	 * 
	 * @param csr_no
	 * @throws EventException
	 */
	public void approvalSuccess(String csr_no) throws EventException;

	/**
	 * AP Interface - > TRS
	 * 
	 * @param csr_no
	 * @throws EventException
	 */
	public void approvalReject(String csr_no) throws EventException;

	/**
	 * Service Management > Trans S/O > CSR > CSR I/F Status Inquiry : get main list
	 * 
	 * @param e ESD_TRS_047Event
	 * @return EventResponse ESD_TRS_047EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRAPiflist(Event e) throws EventException;

	/**
	 * CSR cancel
	 * 
	 * @param e ESD_TRS_047Event
	 * @return EventResponse ESD_TRS_047EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelCSRAPifError(Event e) throws EventException;

	/**
	 * CSR cancel
	 * 
	 * @param e ESD_TRS_048Event
	 * @return EventResponse ESD_TRS_048EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelCSRAPif(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCsrPreVeiw(String sCsrNo) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_0048Event
	 * @return EventResponse ESD_TRS_0048EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCsrCancel(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TES_0047Event
	 * @return EventResponse ESD_TES_0047EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] generateApInvDTRB(Event e) throws EventException;

	/**
	 * Office Change City changed the country code lookup N200905040013 2009-05-11: Office Change of the concept applied modules
	 * 
	 * @param sOfficeCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeChangedCntCd(String sOfficeCd) throws EventException;

	/**
	 * Hold Invoice No is checked for.
	 * 
	 * 
	 * @param Event e
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckHoldInvoice(Event e) throws EventException;

	/**
	 * Search the AP Office of invoice office
	 * 
	 * 
	 * @param Event e
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckAPoffice(Event e) throws EventException;

	/**
	 * Payment(AP) -> TRS [PD / RJ / IF] TEMP
	 * 
	 * @param sCsrNo
	 * @param sTrspInvAudStsCd
	 * @param sDate
	 * @param sInvPayMzdCd
	 * @throws EventException
	 */
	public void trsUpdateCSRInvAudSts(String sCsrNo, String sTrspInvAudStsCd, String sDate, String sInvPayMzdCd) throws EventException;
}
