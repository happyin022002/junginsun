/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OTRCommAuditBC.java
*@FileTitle : OTRCommAuditBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.12 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.vo.OTRCommAuditVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0015EventResponse 참조
 * @since J2EE 1.6
 */

public interface OTRCommAuditBC {

	/**
	 * [ESM_ACM_0015]
	 * Other Commission Audit 목록을 조회<br>
	 *
	 * @param OTRCommAuditVO otrCommAuditVO
	 * @return List<OTRCommAuditVO>
	 * @exception EventException
	 */
	public List<OTRCommAuditVO> searchOTRCommAudit(OTRCommAuditVO otrCommAuditVO) throws EventException;


	/**
	 * [ESM_ACM_0015] Audit<br>
	 * Other Commission Audit 저장 Audit 버튼<br>
	 * 
	 * @param OTRCommAuditVO otrCommAuditVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageAGNCommAudit(OTRCommAuditVO otrCommAuditVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * [ESM_ACM_0015] Reject<br>
	 * Other Commission Audit 화면의 Reject 저장<br>
	 *
	 * @param OTRCommAuditVO[] otrCommAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void rejectOtrAGNCommAudit(OTRCommAuditVO[] otrCommAuditVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0015] Reject<br>
	 * Other Commission Audit 화면의 Audit Cancel <br>
	 *
	 * @param OTRCommAuditVO[] otrCommAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void auditCancelOtrAGNCommAudit(OTRCommAuditVO[] otrCommAuditVOs, SignOnUserAccount account) throws EventException;
}