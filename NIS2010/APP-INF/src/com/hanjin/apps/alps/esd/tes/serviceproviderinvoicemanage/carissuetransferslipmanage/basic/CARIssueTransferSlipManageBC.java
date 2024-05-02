/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CARIssueTransferSlipManageBC.java
*@FileTitle : Terminal invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-18
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-18 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic;

import java.util.List;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.LeaRevVvdCngVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ENIS-ESD Business Logic Command Interface<br>
 * - ENIS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jongbaemoon
 * @see ESD_TES_024EventResponse 참조
 * @since J2EE 1.4
 */
public interface CARIssueTransferSlipManageBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param model LeaRevVvdCngVO
	 * @param session_usr_info SignOnUserAccount
	 * @return String 
	 * @exception EventException
	 */
	public String chgLEARevVVD(LeaRevVvdCngVO model, SignOnUserAccount session_usr_info) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSoIfCd(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary1(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsdTes0080Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail2(Event e) throws EventException;	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail1(Event e) throws EventException;		
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] getAutoRevVVDList(Event e) throws EventException;		
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] getManualRevVVDList(Event e) throws EventException;	
	  
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void modifyAutoRevVVD(Event e) throws EventException;

    /**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @exception EventException
	 */
	public void modifyManualRevVVD(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] searchApInvDTRBIn(Event e) throws EventException;		

	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] searchApInvDTRBOut(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPreVeiw(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse tmpSearchCSRSummary(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse tmpSearchPreVeiw(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchTAXInfo(Event e, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApEviNo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXCode(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */
	public EventResponse approvalRequest(Event e) throws EventException;		
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String flag
	 * @param String csr_no
	 * @param ComAproRqstRoutVO model
	 * 
	 * @return FNS0080003Document[] 
	 * @exception EventException
	 */
	public FNS0080003Document[] approvalRequestAccount1(String flag, String csr_no, ComAproRqstRoutVO model) throws EventException;	

	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String flag
	 * @param String csr_no
	 * @param ComAproRqstRoutVO model
	 * @return String
	 * @exception EventException
	 */
	public String approvalRequestAccount2(String flag, String csr_no, ComAproRqstRoutVO model) throws EventException;	

	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
     *
	 * @param String csr_no
	 * @return FNS0080003Document[]
	 * @exception EventException
	 */
	public FNS0080003Document[] approvalRequestAccountLEA1(String csr_no) throws EventException;	

	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String csr_no
	 * @param FNS0080003Document doc
	 * 
	 * @return String 
	 * @exception EventException
	 */
	public String approvalRequestAccountLEA2(String csr_no, FNS0080003Document doc) throws EventException;	
	
	/** YOO. 시작 **/
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */	
	public EventResponse searchCSRSOlist(Event e) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCSRSOlist2(Event e) throws EventException;	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCSRSOhdr(Event e) throws EventException;	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiRejectedCSRCancellation(Event e) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiConfirmCSR(Event e) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_024Event
	 * @return EventResponse ESD_TES_024EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelCSR(Event e) throws EventException;
	/** YOO. 끝 **/	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CARIssueTransferSlipManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TES_100Event
	 * @return EventResponse ESD_TES_100EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCSRAPiflist(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Header Info
	 * @param csrNo
	 * @return ComCsrRequestHeaderVO
	 */
	public ComCsrRequestHeaderVO printComCsrHeaderInfo(String csrNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Body Info List
	 * @param csrNo
	 * @return List<ComCsrRequestBodyVO>
	 */
	public List<ComCsrRequestBodyVO> printComCsrBodyInfo(String csrNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement Info List
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo(String csrNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement Info List
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException;
	
	/** getCancelledBkgNoList 자동계산된 재무항차 리스트를 가져온다.
	 * 
	 * @param Event EsdTes0024Event
	 * @return DBRowSet[]
	 * @throws EventException
	 */
	public DBRowSet[] getCancelledBkgNoList(Event e) throws EventException;
	
	/**
	 * modifyCancelledBkgNo
	 * 
	 * @param e
	 * @throws EventException
	 */	
	public void modifyCancelledBkgNo(Event e) throws EventException;
	
}