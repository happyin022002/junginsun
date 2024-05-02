/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAuditBC.java
*@FileTitle : AGNCommAuditBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.23 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.vo.SPCLCmpnAuditVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMRequest Business Logic Command Interface<br>
 * - ALPS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0028EventResponse 참조
 * @since J2EE 1.6
 */

public interface SPCLCmpnAuditBC {

	/**
	 * [ESM_ACM_0029]
	 * Special Compensation Audit 목록을 조회<br>
	 *
	 * @param SPCLCmpnAuditVO spcLCmpnAuditVO
	 * @return List<SPCLCmpnAuditVO>
	 * @exception EventException
	 */
	public List<SPCLCmpnAuditVO> searchSPCLCmpnAudit(SPCLCmpnAuditVO spcLCmpnAuditVO) throws EventException;
	
	
	/**
	 * [ESM_ACM_0029]
	 * Special Compensation Audit 목록을 저장<br>
	 * [pay chk]가 PAY_CHK_FLG --->Y 또는 Null 로 업데이트
	 * 
	 * @param SPCLCmpnAuditVO[] spcLCmpnAuditVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	
	public void manageSPCLCmpnAudit(SPCLCmpnAuditVO[] spcLCmpnAuditVOs,SignOnUserAccount account) throws EventException;

}