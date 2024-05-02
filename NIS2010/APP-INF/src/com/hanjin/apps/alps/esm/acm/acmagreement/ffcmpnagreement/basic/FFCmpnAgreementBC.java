/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAgreementBC.java
*@FileTitle : FFCmpnAgreementBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.vo.FFAgreementVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMAgreement Business Logic Command Interface<br>
 * - ALPS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0023EventResponse 참조
 * @since J2EE 1.6
 */

public interface FFCmpnAgreementBC {

	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 목록을 조회<br>
	 *
	 * @param FFAgreementVO ffagreementVO
	 * @return List<FFAgreementVO>
	 * @exception EventException
	 */
	public List<FFAgreementVO> searchFFAgreement(FFAgreementVO ffagreementVO) throws EventException;

	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 목록을 저장<br>
	 *
	 * @param FFAgreementVO[] ffagreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFFAgreement(FFAgreementVO[] ffagreementVOs, SignOnUserAccount account) throws EventException;

}