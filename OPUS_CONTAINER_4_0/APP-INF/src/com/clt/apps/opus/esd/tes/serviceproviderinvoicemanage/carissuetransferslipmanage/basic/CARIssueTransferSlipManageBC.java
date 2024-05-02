/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CARIssueTransferSlipManageBC.java
*@FileTitle : Terminal invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;
import com.clt.syscommon.common.table.LeaRevVvdCngVO;

/**
 * ENIS-ESD Business Logic Command Interface<br>
 *
 * @author jongbaemoon
 * @see CARIssueTransferSlipManageBC
 * @since J2EE 1.4
 */
public interface CARIssueTransferSlipManageBC  {

	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param model LeaRevVvdCngVO
	 * @param session_usr_info SignOnUserAccount
	 * @return String 
	 * @exception EventException
	 */
	public String chgLEARevVVD(LeaRevVvdCngVO model, SignOnUserAccount session_usr_info) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSoIfCd(Event e) throws EventException;	
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary1(Event e) throws EventException;	
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail(Event e) throws EventException;	
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e EsdTes0080Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail2(Event e) throws EventException;	
	
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail1(Event e) throws EventException;		
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] getAutoRevVVDList(Event e) throws EventException;		
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] getManualRevVVDList(Event e) throws EventException;	
	  
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void modifyAutoRevVVD(Event e) throws EventException;

    /**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void modifyManualRevVVD(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] searchApInvDTRBIn(Event e) throws EventException;		

	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] searchApInvDTRBOut(Event e) throws EventException;	
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPreVeiw(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse tmpSearchCSRSummary(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse tmpSearchPreVeiw(Event e) throws EventException;	
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event      
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXInfo(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApEviNo(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXCode(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse approvalRequest(Event e) throws EventException;		
	
	/**
	 * tesUpdateCSRSTSFlag
	 * 
	 * @param String flag
	 * @param String csr_no
	 * 
	 * @exception EventException
	 */
	public void tesUpdateCSRSTSFlag(String flag, String csr_no) throws EventException;	

	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
     *
	 * @param String csr_no
	 * @return FNS0080003Document[]
	 * @exception EventException
	 */
	public FNS0080003Document[] approvalRequestAccountLEA1(String csr_no) throws EventException;	

	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param String csr_no
	 * @param FNS0080003Document doc
	 * 
	 * @return String 
	 * @exception EventException
	 */
	public String approvalRequestAccountLEA2(String csr_no, FNS0080003Document doc) throws EventException;	
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */	
	public EventResponse searchCSRSOlist(Event e) throws EventException;
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCSRSOlist2(Event e) throws EventException;	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCSRSOhdr(Event e) throws EventException;	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiRejectedCSRCancellation(Event e) throws EventException;
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiConfirmCSR(Event e) throws EventException;
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelCSR(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage retrieve event process
	 * 
	 * @param e ESD_TES_100Event
	 * @return EventResponse ESD_TES_100EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCSRAPiflist(Event e) throws EventException;

	/**
	 * AP Interface 결과를 TES SO HDR 테이블에 반영한다. 
	 * @param String csr_no
	 * @param String sTrspInvAudStsCd
	 * @param String pay_dt
	 */
	public void modifyTESInvHdrForPay(String csr_no, String sTrspInvAudStsCd, String pay_dt)  throws EventException; 
//	/**
//	 * retrieve event process
//	 * CARIssueTransferSlipManage retrieve event process
//	 * 
//	 * @param csr_no String
//	 * @return EventResponse EventResponse
//	 * @exception EventException
//	 */	
//	public EventResponse modifyStsCdSOHDRBack(Event e) throws EventException;
	/**
	 * retrieve event process
	 * CARIssueTransferSlipManage CSR cancel Process<br>
	 * 
	 * @param e ESD_TES_100Event
	 * @return EventResponse ESD_TES_100EventResponse
	 * @exception EventException
	 */	
//	public EventResponse cancelCSRAPif(Event e) throws EventException;	
	
}