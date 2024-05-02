/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalBC.java
*@FileTitle : SPCLCmpnApprovalBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.03 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintDetailVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo.SPCLCmpnApprovalPrintMasterVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMApproval Business Logic Command Interface<br>
 * - ALPS-ACMApproval에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM YOUNG-OH
 * @see Esm_Acm_0031EventResponse 참조
 * @since J2EE 1.6
 */

public interface SPCLCmpnApprovalBC {

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation 목록을 조회<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @return List<SPCLCmpnApprovalMasterVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalMasterVO> searchSPCLCmpnApprovalMaster(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation 목록을 조회(Detail)<br>
	 *
	 * @param SPCLCmpnApprovalDetailVO spCLCmpnApprovalDetailVO
	 * @return List<SPCLCmpnApprovalDetailVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalDetailVO> searchSPCLCmpnApprovalDetail(SPCLCmpnApprovalDetailVO spCLCmpnApprovalDetailVO) throws EventException;

	/**
	 * [ESM_ACM_0031] Approval Request<br>
	 * Special Compensation CSR Creation Approval Request<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approvalSPCLCmpnApproval(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation 엑셀다운 목록을 조회(Excel)<br>
	 *
	 * @param SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO
	 * @return List<SPCLCmpnApprovalMasterVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalMasterVO> searchSPCLCmpnApprovalExcelDown(SPCLCmpnApprovalMasterVO spCLCmpnApprovalMasterVO) throws EventException;


	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation RD프린트 목록을 조회(Master)<br>
	 *
	 * @param SPCLCmpnApprovalPrintMasterVO spCLCmpnApprovalPrintMasterVO
	 * @return List<SPCLCmpnApprovalPrintMasterVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalPrintMasterVO> searchSPCLCmpnApprovalPrintMaster(SPCLCmpnApprovalPrintMasterVO spCLCmpnApprovalPrintMasterVO) throws EventException;

	/**
	 * [ESM_ACM_0031]
	 * Special Compensation CSR Creation RD프린트 목록을 조회(Detail)<br>
	 *
	 * @param SPCLCmpnApprovalPrintDetailVO spCLCmpnApprovalPrintDetailVO
	 * @return List<SPCLCmpnApprovalPrintDetailVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnApprovalPrintDetailVO> searchSPCLCmpnApprovalPrintDetail(SPCLCmpnApprovalPrintDetailVO spCLCmpnApprovalPrintDetailVO) throws EventException;



}