/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BATManagementBC.java
*@FileTitle : Batch Management
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.25
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.25 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.batmanagement.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.vo.BATManagementVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-BATManagement Business Logic Command Interface<br>
 * - OPUS-BATManagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM BONG-GYOON
 * @see Esm_Acm_0032EventResponse 참조
 * @since J2EE 1.6
 */

public interface BATManagementBC {

	/**
	 * [ESM_ACM_0032]
	 * Mass Calculation Batch List 조회<br>
	 *
	 * @param BATManagementVO batManagementVO
	 * @return List<BATManagementVO>
	 * @exception EventException
	 */
	public List<BATManagementVO> searchBatchManagement(BATManagementVO batManagementVO) throws EventException;

	/**
	 * [ESM_ACM_0032]
	 * Simulation Batch List 조회<br>
	 *
	 * @param BATManagementVO batManagementVO
	 * @return List<BATManagementVO>
	 * @exception EventException
	 */
	public List<BATManagementVO> searchSimBatchManagement(BATManagementVO batManagementVO) throws EventException;

	/**
	 * [ESM_ACM_0032] Cancel Batch<br>
	 * 현재 진행되고 있지 않은 Batch Cancel<br>
	 *
	 * @param BATManagementVO[] batManagementVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void deleteBatchManagement(BATManagementVO[] batManagementVOs, SignOnUserAccount account) throws EventException;

}