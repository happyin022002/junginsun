/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAgreementBC.java
*@FileTitle : FAC Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.03 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmagreement.facommagreement.vo.FACAgreementVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMAgreement Business Logic Command Interface<br>
 * - ALPS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Bong-Gyoon
 * @see Esm_Acm_0024EventResponse 참조
 * @since J2EE 1.6
 */

public interface FACommAgreementBC {

	/**
	 * [ESM_ACM_0024]
	 * FAC Agreement Creation 목록을 조회<br>
	 *
	 * @param FACAgreementVO facAgreementVO
	 * @return List<FACAgreementVO>
	 * @exception EventException
	 */
	public List<FACAgreementVO> searchFACAgreement(FACAgreementVO facAgreementVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_0024 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param FACAgreementVO[] facAgreementVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFACAgreement(FACAgreementVO[] facAgreementVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Request 이벤트 처리<br>
	 * ESM_ACM_0024 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestFACAgreement(FACAgreementVO[] facAgreementVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Approval 이벤트 처리<br>
	 * ESM_ACM_0024 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveFACAgreement(FACAgreementVO[] facAgreementVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Reject 이벤트 처리<br>
	 * ESM_ACM_0024 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param FACAgreementVO[] facAgreementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void rejectFACAgreement(FACAgreementVO[] facAgreementVOs, SignOnUserAccount account) throws EventException;
	
}