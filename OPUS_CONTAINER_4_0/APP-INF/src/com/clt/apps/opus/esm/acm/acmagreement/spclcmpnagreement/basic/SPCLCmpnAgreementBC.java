/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnAgreementBC.java
*@FileTitle : SPCLCmpnAgreementBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmagreement.spclcmpnagreement.vo.SCompAgreementVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ACMAgreement Business Logic Command Interface<br>
 * - OPUS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0025EventResponse 참조
 * @since J2EE 1.6
 */

public interface SPCLCmpnAgreementBC {

	/**
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 목록을 조회<br>
	 *
	 * @param SCompAgreementVO scompAgreementVO
	 * @return List<SCompAgreementVO>
	 * @exception EventException
	 */
	public List<SCompAgreementVO> searchSCompAgreement(SCompAgreementVO scompAgreementVO) throws EventException;

	/**
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 중복 조회<br>
	 *
	 * @param SCompAgreementVO[] scompAgreementVOs
	 * @return List<SCompAgreementVO>
	 * @exception EventException
	 */
	public List<SCompAgreementVO> searchSCompAgreementDup(SCompAgreementVO[] scompAgreementVOs) throws EventException;


	/**
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 목록을 저장<br>
	 *
	 * @param SCompAgreementVO[] scompAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSCompAgreement(SCompAgreementVO[] scompAgreementVOs,SignOnUserAccount account) throws EventException;

}