/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueDebitNoteBC.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.05.19 이승준
* 1.0 Creation
* 2013.02.12 김진주 [CHM-201322816] [BKG/DOC - Revenue Audit System] RDN Status 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.AttachmentVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesPerformanceVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusSummaryVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.UnStlRdnReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Revenueaudit Business Logic Command Interface<br>
 * - NIS2010-Revenueaudit에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung Jun Lee
 * @see Esm_bkg_0426EventResponse 참조
 * @since J2EE 1.4
 */

public interface RevenueDebitNoteBC {
	/**
	 *  RDN Issuance by Regional Group 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNote
	 * @return RevDrNoteVO
	 * @exception EventException
	 */
	public RevDrNoteVO searchRDNList(RevDrNoteVO revDrNote) throws EventException;
	
	
	/**
	 *  RDN Status 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO
	 * @return List<RsltBkgRevDrNotesStatusVO>
	 * @exception EventException
	 */
	public List<RsltBkgRevDrNotesStatusVO> searchRDNStatusList(RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO) throws EventException;

	
	/**
	 *  RDN Status 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO
	 * @return List<RsltBkgRevDrNotesStatusSummaryVO>
	 * @exception EventException
	 */
	public List<RsltBkgRevDrNotesStatusSummaryVO> searchRDNStatusSummaryList(RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO) throws EventException;
	
	/**
	 *  RDN Performance Report 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO
	 * @return List<RsltBkgRevDrNotesPerformanceVO>
	 * @exception EventException
	 */
	public List<RsltBkgRevDrNotesPerformanceVO> searchRDNPerformanceList(RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO) throws EventException;

	/**
	 * 진행중인 RDN No 를 조회한다.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExistRevDrNote(RevDrNoteVO revDrNoteVO) throws EventException;

	/**
	 * RDN Issuance by Regional Group 화면에 대한 등록 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String createRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * RDN Issuance by Regional Group 화면에 대한 수정 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * RDN Receipt by Office 화면에 대한 수정 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group issue 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void issueRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group reissue 처리
	 * rvis_seq를 신규로 따서 등록후 각 디테일의 최근 값을 복사하여 신규로 등록한다.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reissueRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * RDN Issuance by Regional Group revise 처리
	 * rvis_seq를 신규로 따서 등록후 각 디테일의 최근 값을 복사하여 신규로 등록한다.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reviseRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group cancel 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group cancel(Valid) 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void validCancelRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group settle 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Receipt by Office Accept 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void acceptRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Receipt by Office Revise Request 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reviseRequestRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Receipt by Office Cancel Request 처리<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelRequestRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * RDN Issuance by Auditor Issue 발생시 메일 대상자를 조회한다.<br>
	 * 
	 * @param RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO
	 * @param SignOnUserAccount account  
	 * @return List<RsltSearchRDNIssueMailingListVO>
	 * @exception EventException
	 */
	public List<RsltSearchRDNIssueMailingListVO> searchRDNIssueMailingList(RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * RDN Issuance by Auditor 메일대상자에게 메일을 일괄 발송한다. <br>
	 *
	 * @param RsltSearchRDNIssueMailingListVO[] pVOS
	 * @param RsltSearchRDNIssueMailingListVO vo
	 * @exception MailerAppException
	 */
	public void doMailRDNIssue(RsltSearchRDNIssueMailingListVO[] pVOS, RsltSearchRDNIssueMailingListVO vo) throws EventException;
	
	/** 
	 * Non-Charged B/L에 대한 RDN 자동발행
	 * @param autoRdnInfoVO AutoRdnInfoVO
	 * @param modParamVo UnmatchBLVO
	 * @param account SignOnUserAccount
	 * @throws Exception
	 */
	public void autoMailRDNIssue(AutoRdnInfoVO autoRdnInfoVO, UnmatchBLVO modParamVo, SignOnUserAccount account) throws Exception;
	
	/**
	 * Re-issue 기능을 사용 가능한 ID인지 체크한다.
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String checkReissueAvailableUser(SignOnUserAccount account) throws EventException;
	
	/**
	 *  Attachment File 목록 조회<br>
	 * 
	 * @param AttachmentVO vo
	 * @return List<AttachmentVO>
	 * @exception EventException
	 */
	public List<AttachmentVO> searchAttachmentList(AttachmentVO vo) throws EventException;

	/**
	 * ESM_BKG_0207 멀티 이벤트 처리<br>
	 * ESM_BKG_0207 화면에 대한 멀티 이벤트 처리<br>
	 * //1.UPDATE 상태를 확인한다.
	 * //1-1 delete List 추가
	 * //1-1-1 UpdateFileMetaInfo
	 * file_meta 정보 삭제 (FILE_SAVE_ID)
	 * //1-2 insert List 추가
	 * //2. DELETE 상태를 확인
	 * //2-1 delete List 추가
	 * //2-1-1 UpdateFileMetaInfo file_meta 정보 삭제
	 * (FILE_SAVE_ID)
	 * //3. INSERT 상태를 확인
	 * //3-1 insert List 추가
	 * //4. 삭제먼저 수행하고 추가를수행한다.
	 * //5. 맨마지막에 일괄 com_upload 테이블과 동기화 쿼리
	 * @author Lee Jin Seo
	 * @param AttachmentVO[] vos
	 * @param String[] fileSavId
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAttachment(AttachmentVO[] vos, String[] fileSavId, SignOnUserAccount account) throws EventException;
	
	 /**
	  * unsettled rdn aging list를 조회한다.
	 * @param UnStlRdnReportVO vo
	 * @return List<UnStlRdnReportVO>
	 * @throws EventException
	 */
	public List<UnStlRdnReportVO> searchUnSettledRdnAgingList(UnStlRdnReportVO vo) throws EventException;
}