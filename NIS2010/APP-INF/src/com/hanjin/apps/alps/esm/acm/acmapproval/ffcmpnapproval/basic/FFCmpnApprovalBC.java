/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalBC.java
*@FileTitle : FFCmpnApprovalBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.03 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo.FFCmpnApprovalPrintMasterVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * ALPS-ACMApproval Business Logic Command Interface<br>
 * - ALPS-ACMApproval에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM YOUNG-OH
 * @see Esm_Acm_0030EventResponse 참조
 * @since J2EE 1.6
 */

public interface FFCmpnApprovalBC {

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation 목록을 조회(Master)<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @return List<FFCmpnApprovalMasterVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalMasterVO> searchFFCmpnApprovalMaster(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation 목록을 조회(Detail)<br>
	 *
	 * @param FFCmpnApprovalDetailVO ffCmpnApprovalDetailVO
	 * @return List<FFCmpnApprovalDetailVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalDetailVO> searchFFCmpnApprovalDetail(FFCmpnApprovalDetailVO ffCmpnApprovalDetailVO) throws EventException;

	/**
	 * [ESM_ACM_0030] Approval Request<br>
	 * FF Compensation CSR Creation Approval Request<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approvalFFCmpnApproval(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO, SignOnUserAccount account) throws EventException;


	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation 엑셀다운 목록을 조회(Excel)<br>
	 *
	 * @param FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO
	 * @return List<FFCmpnApprovalMasterVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalMasterVO> searchFFCmpnApprovalExcelDown(FFCmpnApprovalMasterVO ffCmpnApprovalMasterVO) throws EventException;


	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation RD프린트 목록을 조회(Master)<br>
	 *
	 * @param FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO
	 * @return List<FFCmpnApprovalPrintMasterVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalPrintMasterVO> searchFFCmpnApprovalPrint(FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO) throws EventException;


	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation CSR_RD프린트 목록을 조회(Master)<br>
	 *
	 * @param FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO
	 * @return List<FFCmpnApprovalPrintMasterVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalPrintMasterVO> searchFFCmpnApprovalPrintMaster(FFCmpnApprovalPrintMasterVO ffCmpnApprovalPrintMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0030]
	 * FF Compensation CSR Creation CSR_RD프린트 목록을 조회(Detail)<br>
	 *
	 * @param FFCmpnApprovalPrintDetailVO ffCmpnApprovalPrintDetailVO
	 * @return List<FFCmpnApprovalPrintDetailVO>
	 * @exception EventException
	 */
	public List<FFCmpnApprovalPrintDetailVO> searchFFCmpnApprovalPrintDetail(FFCmpnApprovalPrintDetailVO ffCmpnApprovalPrintDetailVO) throws EventException;

	/**
	 * ESM_AGT_0018 화면에 대한 인터페이스 이벤트 처리(1) : EP결재 수신 + CSR I/F<br>
	 * @param String result
	 * @param String csrNo
	 * @param ComAproRqstRoutVO model
	 * @return FNS0080003Document[]
	 * @throws EventException
	 */
	public FNS0080003Document[] transferFFActualINFtoAP1(String result,
			String csrNo, ComAproRqstRoutVO model) throws EventException;
	/**
	 * ESM_AGT_0018 화면에 대한 인터페이스 이벤트 처리(2) : EP결재 수신 + CSR I/F<br>
	 * @param String result
	 * @param String csrNo
	 * @param ComAproRqstRoutVO model
	 * @return String
	 * @throws EventException
	 * @throws DAOException 
	 */
	public String transferFFActualINFtoAP2(String result, String csrNo,
			ComAproRqstRoutVO model) throws EventException;
}