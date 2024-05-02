/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditBC.java
*@FileTitle : AGNCommAuditBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.02 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditConfirmVO;
import com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ACMRequest Business Logic Command Interface<br>
 * - OPUS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0008EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGNCommAuditBC {

	/**
	 * [ESM_ACM_0008]
	 * Agent Commission Audit 목록을 조회<br>
	 *
	 * @param AGNCommAuditVO agnCommAuditVO
	 * @return List<AGNCommAuditVO>
	 * @exception EventException
	 */
	public List<AGNCommAuditVO> searchAGNCommAudit(AGNCommAuditVO agnCommAuditVO) throws EventException;

	/**
	 * [ESM_ACM_0107]
	 * Audit Confirm 팝업 화면 목록 조회(Audit Number) <br>
	 *
	 * @param AGNCommAuditConfirmVO agnCommAuditConfirmVO
	 * @return List<AGNCommAuditVO>
	 * @exception EventException
	 */
	public List<AGNCommAuditConfirmVO> searchAGNCommAuditNoConfirmNo(AGNCommAuditConfirmVO agnCommAuditConfirmVO) throws EventException;


	/**
	 * [ESM_ACM_0008] Retrive<br>
	 * Agent Commission Audit 저장 Audit 버튼<br>
	 *
	 * @param AGNCommAuditVO agnCommAuditVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void manageAGNCommAudit(AGNCommAuditVO agnCommAuditVO, SignOnUserAccount account) throws EventException;


	/**
	 * [ESM_ACM_0008] Reject<br>
	 * Agent Commission Audit 화면의 Reject 저장<br>
	 *
	 * @param AGNCommAuditVO[] agnCommAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void rejectAGNCommAudit(AGNCommAuditVO[] agnCommAuditVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0008] Audit Cancel<br>
	 * Agent Commission Audit 화면의 Audit Cancel  <br>
	 *
	 * @param AGNCommAuditVO[] agnCommAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void auditCancelAGNCommAudit(AGNCommAuditVO[] agnCommAuditVOs, SignOnUserAccount account) throws EventException;
}