/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommApprovalBC.java
*@FileTitle : AGNCommApprovalBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.09 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommAsaNoVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommInfoPrintMasterVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.AGNCommVendorVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRDetailVO;
import com.clt.apps.opus.esm.acm.acmapproval.agncommapproval.vo.ReturnCSRMasterVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.irep.enis.FNS0080003Document;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;

/**
 * OPUS-ACMApproval Business Logic Command Interface<br>
 * - OPUS-ACMApproval에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM YOUNG-OH
 * @see Esm_Acm_0009EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGNCommApprovalBC {
	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation 목록을 조회<br>
	 *
	 * @param AGNCommApprovalMasterVO agnCommApprovalMasterVO
	 * @return List<AGNCommApprovalMasterVO>
	 * @exception EventException
	 */
	public List<AGNCommApprovalMasterVO> searchAGNCommApprovalMaster(AGNCommApprovalMasterVO agnCommApprovalMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation 하단 Detail 조회<br>
	 *
	 * @param AGNCommApprovalDetailVO angCommApprovalDetailVO
	 * @return List<AGNCommApprovalDetailVO>
	 * @exception EventException
	 */
	public List<AGNCommApprovalDetailVO> searchAGNCommApprovalDetail(AGNCommApprovalDetailVO angCommApprovalDetailVO) throws EventException;

	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * Agent Commission CSR Creation 목록을 Interface 한다.<br>
	 *
	 * @param AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs
	 * @param AGNCommApprovalMasterVO agnCommApprovalMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approvalAGNCommApproval(AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs, AGNCommApprovalMasterVO agnCommApprovalMasterVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 화면에 대한 보고서 출력(Master)<br>
	 *
	 * @param AGNCommInfoPrintMasterVO acmCommInfoPrintMasterVO
	 * @return List<AGNCommInfoPrintMasterVO>
	 * @exception EventException
	 */
	public List<AGNCommInfoPrintMasterVO> searchACMCommInfoPrintMaster(AGNCommInfoPrintMasterVO acmCommInfoPrintMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 화면에 대한 보고서 출력(Detail)<br>
	 *
	 * @param AGNCommInfoPrintDetailVO acmCommInfoPrintDetailVO
	 * @return List<AGNCommInfoPrintDetailVO>
	 * @exception EventException
	 */
	public List<AGNCommInfoPrintDetailVO> searchACMCommInfoPrintDetail(AGNCommInfoPrintDetailVO acmCommInfoPrintDetailVO) throws EventException;

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 화면 조회조건 ASA No 조회<br>
	 *
	 * @param AGNCommAsaNoVO agnCommAsaNoVO
	 * @return List<AGNCommAsaNoVO>
	 * @exception EventException
	 */
	public List<AGNCommAsaNoVO> getAsaNoList(AGNCommAsaNoVO agnCommAsaNoVO) throws EventException;

	/**
	 * [ESM_ACM_0009]
	 * Agent Commission CSR Creation ESM_ACM_0009 화면 조회조건 Vendor 조회<br>
	 *
	 * @param AGNCommVendorVO angCommVendorVO
	 * @return List<AGNCommVendorVO>
	 * @exception EventException
	 */
	public List<AGNCommVendorVO> getVendorInfo(AGNCommVendorVO angCommVendorVO) throws EventException;

	/**
	 * [ESM_ACM_0013] Retrieve<br>
	 * Returned CSR Master 목록을 조회<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @return List<ReturnCSRMasterVO>
	 * @exception EventException
	 */
	public List<ReturnCSRMasterVO> searchReturnCSRMaster(ReturnCSRMasterVO returnCSRMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0013] Retrieve<br>
	 * Returned CSR Detail 목록을 조회<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @return List<ReturnCSRDetailVO>
	 * @exception EventException
	 */
	public List<ReturnCSRDetailVO> searchReturnCSRDetail(ReturnCSRMasterVO returnCSRMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0013] Reprocess to Audit Confirm<br>
	 * Returned CSR의 재처리<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @param SignOnUserAccount account
	 * @return List<ReturnCSRDetailVO>
	 * @exception EventException
	 */
	public List<ReturnCSRDetailVO> reprocessReturnCSRAuditConfirm(ReturnCSRMasterVO returnCSRMasterVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0013] CSR Cancel<br>
	 * Interface Cancel 처리<br>
	 *
	 * @param ReturnCSRMasterVO returnCSRMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAGNCommCSRCancel(ReturnCSRMasterVO returnCSRMasterVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_ACM_0009] Approval Request<br>
	 * Agent Commission CSR Creation화면의 Audit Reject기능을 수행한다.<br>
	 *
	 * @param AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approvalAGNCommAuditReject(AGNCommApprovalMasterVO[] agnCommApprovalMasterVOs, SignOnUserAccount account) throws EventException;
	/**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F<br>
     *
     * @param String result
     * @param String csrNo
     * @throws EventException
     */
	public void acmUpdateCSRSTSFlag(String result, String csrNo) throws EventException;

}