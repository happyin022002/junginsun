/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RevenueDebitNoteBC.java
*@FileTitle : RDN Issuance by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesPerformanceVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltBkgRevDrNotesStatusVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RsltSearchRDNIssueMailingListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Revenueaudit Business Logic Command Interface<br>
 * - OPUS-Interface of Business Logic for Revenueaudit<br>
 *
 * @author Seung Jun Lee
 * @see Esm_bkg_0426EventResponse reference
 * @since J2EE 1.4
 */

public interface RevenueDebitNoteBC {
	/**
	 *  Retrieve processing for RDN Issuance by Regional Group<br>
	 * 
	 * @param RevDrNoteVO revDrNote
	 * @return RevDrNoteVO
	 * @exception EventException
	 */
	public RevDrNoteVO searchRDNList(RevDrNoteVO revDrNote) throws EventException;
	
	
	/**
	 *  retrieve event processing for RDN Status<br>
	 * 
	 * @param RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO
	 * @return List<RsltBkgRevDrNotesStatusVO>
	 * @exception EventException
	 */
	public List<RsltBkgRevDrNotesStatusVO> searchRDNStatusList(RsltBkgRevDrNotesStatusVO rsltBkgRevDrNotesStatusVO) throws EventException;
	
	
	/**
	 *  retrieve event processing for RDN Performance Report<br>
	 * 
	 * @param RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO
	 * @return List<RsltBkgRevDrNotesPerformanceVO>
	 * @exception EventException
	 */
	public List<RsltBkgRevDrNotesPerformanceVO> searchRDNPerformanceList(RsltBkgRevDrNotesPerformanceVO rsltBkgRevDrNotesPerformanceVO) throws EventException;

	/**
	 * retrieve afoot RDN No.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @return String
	 * @exception EventException
	 */
	public String searchExistRevDrNote(RevDrNoteVO revDrNoteVO) throws EventException;

	/**
	 * Add(issue) processing for RDN Issuance by Regional Group<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * modify processing for RDN Issuance by Regional Group<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * modify processing for RDN Receipt by Office<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group issue process(not use -->substitute by createRDNbyIssueOffice)<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void issueRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group reissue processing
	 * retrieve new rvis_seq and regiter and copy latest value each detail and new register.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reissueRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	
	/**
	 * RDN Issuance by Regional Group revise processing
	 * retrieve new rvis_seq and regiter and copy latest value each detail and new register.<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reviseRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group cancel processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Issuance by Regional Group settle processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleRDNbyIssueOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Receipt by Office Accept processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void acceptRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Receipt by Office Revise Request processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void reviseRequestRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * RDN Receipt by Office Cancel Request processing<br>
	 * 
	 * @param RevDrNoteVO revDrNoteVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelRequestRDNbyReceiptOffice(RevDrNoteVO revDrNoteVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieve mail receiver when RDN Issuance by Auditor Issue happen.<br>
	 * 
	 * @param RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO
	 * @param SignOnUserAccount account  
	 * @return List<RsltSearchRDNIssueMailingListVO>
	 * @exception EventException
	 */
	public List<RsltSearchRDNIssueMailingListVO> searchRDNIssueMailingList(RsltSearchRDNIssueMailingListVO rsltSearchRDNIssueMailingListVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * RDN Issuance by Auditor Mail send in a lump to mail receiver. <br>
	 *
	 * @param RsltSearchRDNIssueMailingListVO[] pVOS
	 * @param RsltSearchRDNIssueMailingListVO vo
	 * @exception MailerAppException
	 */
	public void doMailRDNIssue(RsltSearchRDNIssueMailingListVO[] pVOS, RsltSearchRDNIssueMailingListVO vo) throws EventException;
	
	/** 
	 * RDN auto issue for Non-Charged B/L
	 * @param autoRdnInfoVO AutoRdnInfoVO
	 * @param modParamVo UnmatchBLVO
	 * @param account SignOnUserAccount
	 * @throws Exception
	 */
	public void autoMailRDNIssue(AutoRdnInfoVO autoRdnInfoVO, UnmatchBLVO modParamVo, SignOnUserAccount account) throws Exception;
}