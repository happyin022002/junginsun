/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageBC.java
*@FileTitle : Transportation invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.26
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2009.10.01 kimjin
* -------------------------------------------------------
* history
* 2009.05.11 1.1 N200905040013 2009-05-11: Office Change 개념의 모듈적용 요청
* 2010.12.26 최 선     1.2 [CHM-201115241] [TRS] Hold invoice 관련 메세지 추가요청
* 2014.11.26 최종혁 김현화[CHM-201432901]Split 01-비용지급 전표 결재건
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic;

import java.util.List;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.LeaRevVvdCngVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ENIS-ESD Business Logic Command Interface<br>
 * - ENIS-ESD�� ���� ����Ͻ� ���� ���� �������̽�<br>
 *
 * @author kimjin
 * @see EsdTrs0032EventResponse ��v
 * @since J2EE 1.6
 */
public interface CSRIssueTransferSlipManageBC  {

	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 *
	 * @param e ESD_TRS_0032Event
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary(Event e) throws EventException;

	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 *
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail(Event e) throws EventException;
	
	/** ASA NO 체크
	 * @param e  ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @throws EventException
	 */
	public EventResponse checkASANO(Event e) throws EventException;

	/**
	 * <br>
	 * CSRIssueTransferSlipManageȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 *
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 */
	public EventResponse correctCsrAmt(Event e) throws EventException;
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
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
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 */
//	public EventResponse createApInvKRDtrb(Event e) throws EventException;
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 */
//	public EventResponse createApInvHdrDtrbASA(Event e) throws EventException;
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 */
//	public EventResponse createApInvHdr(Event e) throws EventException;
	
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
	 * @param String sCsrNo
	 * @param String ofcCd
	 * @throws EventException
	 */
	public void updateApInvDtrbLineNo(String sCsrNo, String ofcCd) throws EventException;
	
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
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 *
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 */
	//-- public EventResponse searchPreVeiw(Event e) throws EventException;

	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 *
	 * @param e ESD_TRS_0031Event
	 * @return EventResponse ESD_TRS_0031EventResponse
	 * @exception EventException
	 * @throws Exception 
	 */
	//-- public EventResponse createApInv(Event e) throws EventException;

	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 *
	 * @param e ESD_TRS_0032Event
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXInfo(Event e) throws EventException;

	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 *
	 * @param e ESD_TRS_0032Event
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApEviNo(Event e) throws EventException;

	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 *
	 * @param e ESD_TRS_0032Event
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXCode(Event e) throws EventException;
	
	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * InvoiceListInquiryȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 *
	 * @param e ESD_TRS_0960Event
	 * @return EventResponse ESD_TRS_0960EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceListInquiry(Event e) throws EventException;
	
	/**
	 * EP - > TRS 호출
	 * 
	 * @param flag
	 * @param csr_no
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public FNS0080003Document[] approvalRequestAccount1(String flag, String csr_no, ComAproRqstRoutVO model) throws EventException; 

	/**
	 * EP - > TRS 호출
	 * 
	 * @param flag
	 * @param csr_no
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public String approvalRequestAccount2(String flag, String csr_no, ComAproRqstRoutVO model) throws EventException;
	
	/**
	 *  AP Interface - > TRS 
	 *  
	 * @param o
	 * @throws EventException
	 */
	public void modifyTrsInvHdr(Object o ) throws EventException ;

	/**
	 *  AP Interface - > TRS 
	 *  
	 * @param csr_no
	 * @throws EventException
	 */
	public void approvalSuccess(String csr_no) throws EventException;
	
	/**
	 *  AP Interface - > TRS 
	 *  
	 * @param csr_no
	 * @throws EventException
	 */
	public void approvalReject(String csr_no ) throws EventException;
	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡 ���� vȸ �̺�Ʈ ó��<br>
	 * 
	 * @param e ESD_TES_0047Event
	 * @return EventResponse ESD_TES_0047EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCSRAPiflist(Event e) throws EventException;

	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡�� CSR cancel ó��<br>
	 * 
	 * @param e ESD_TES_0048Event
	 * @return EventResponse ESD_TES_0048EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelCSRAPifError(Event e) throws EventException;
	
	/**
	 * @param e ESD_TRS_0047Event
	 * @return EventResponse ESD_TRS_0047EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelCSRApprovalRequest(Event e) throws EventException;
	
	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡�� CSR cancel ó��<br>
	 * 
	 * @param e ESD_TES_0047Event
	 * @return EventResponse ESD_TES_0047EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelCSRAPif(Event e) throws EventException;
	
	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡�� CSR cancel ó��<br>
	 * 
	 * @param sCsrNo
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCsrPreVeiw(String sCsrNo) throws EventException;
	
	/**
	 * vȸ �̺�Ʈ ó��<br>
	 * CSRIssueTransferSlipManageȭ�鿡�� CSR cancel ó��<br>
	 * 
	 * @param e ESD_TES_0047Event
	 * @return EventResponse ESD_TES_0047EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchCsrCancel(Event e) throws EventException;
	
	/**
	 * <br>
	 * CSRIssueTransferSlipManage鿡�� R.VVD Change<br>
	 * 
	 * @param model
	 * @param userAccount
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse applyChgRevenueVVD(LeaRevVvdCngVO model, SignOnUserAccount userAccount) throws EventException;
	
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
	 * Office Change시 변경된 국가코드를 조회
	 * N200905040013 2009-05-11: Office Change 개념의 모듈적용
	 * 
	 * @param sOfficeCd
	 * @return String
	 * @throws EventException
	 */
	public String searchOfficeChangedCntCd(String sOfficeCd) throws EventException;
	
	/**
	 * Hold Invoice No에 대하여 체크 한다.
	 * 
	 * 
	 * @param e ESD_TRS_0032Event
	 * @return EventResponse ESD_TES_0032EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCheckHoldInvoice(Event e) throws EventException;
	
	/**
	 * G/L month와 ASA month일치 여부에 대하여 체크 한다.
	 * 
	 * 
	 * @param e Event
	 * @return EventResponse ESD_TES_0032EventResponse
	 * @throws EventException
	 */
	public EventResponse searchCheckGLMonth(Event e) throws EventException;
	
	/**
	 * MASTER INVOICE PDF 파일을 생성한다.
	 * 
	 * 
	 * @param String csrNo 
	 * @param String vndrSeq
	 * @param String usrId
	 * @return String
	 * @throws EventException
	 */
	public String createInvPdfFile(String csrNo, String vndrSeq, String usrId) throws EventException;

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
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo(String csrNo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement Info List2
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException;

	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR File Info List
	 * @param String csrNo
	 * @return List<ComCsrRequestFileVO>
	 */
	public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws EventException;

}