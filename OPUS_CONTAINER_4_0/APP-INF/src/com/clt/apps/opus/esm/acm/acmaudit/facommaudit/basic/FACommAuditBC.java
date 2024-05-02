/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAuditBC.java
*@FileTitle : FACommAuditBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.26 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.facommaudit.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmaudit.facommaudit.vo.FACCommListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ACMRequest Business Logic Command Interface<br>
 * - OPUS-ACMRequest에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0028EventResponse 참조
 * @since J2EE 1.6
 */

public interface FACommAuditBC {

	/**
	 * [ESM_ACM_0028]
	 * FAC Audit 목록을 조회<br>
	 *
	 * @param FACCommListVO facCommListVO
	 * @return List<FACCommListVO>
	 * @exception EventException
	 */
	public List<FACCommListVO> searchFACommAudit(FACCommListVO facCommListVO) throws EventException;

//	/**
//	 * [ESM_ACM_0028]
//	 * FAC Audit Re Calculate 버튼 클릭 시 처리 한다.<br>
//	 *
//	 * @param String bkg_no
//	 * @param SignOnUserAccount account
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse reCalculateFACAudit(String bkg_no, SignOnUserAccount account) throws EventException;

}