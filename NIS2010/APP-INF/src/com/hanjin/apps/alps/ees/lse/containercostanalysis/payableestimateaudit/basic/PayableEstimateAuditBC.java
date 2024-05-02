/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableEstimateAuditBC.java
*@FileTitle : Estimate expense
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.10.06 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Containercostanalysis Business Logic Command Interface<br>
 * - ALPS-Containercostanalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jin Jun Sung
 * @see Ees_lse_0018EventResponse 참조
 * @since J2EE 1.6
 */

public interface PayableEstimateAuditBC {

	/**
	 * 임차료에 대한 추정 실적 조회 합니다.<br>
	 * 
	 * @param EstimatedAuditVO	estimatedAuditVO
	 * @return List<EstimatedAuditVO>
	 * @exception EventException
	 */
	public List<EstimatedAuditVO> searchPayableEstimateAuditBasic(EstimatedAuditVO estimatedAuditVO) throws EventException;
	
	/**
	 * 임차료에 대한 추정 실적 계산 합니다.<br>
	 * 
	 * @param EstimatedAuditVO	estimatedAuditVO
	 * @return List<EstimatedAuditVO>
	 * @exception EventException
	 */
	public List<EstimatedAuditVO> calculationPayableEstimateAuditBasic(EstimatedAuditVO estimatedAuditVO ) throws EventException;

	/**
	 * 임차료에 대한 추정 실적 계산을 저장 합니다.<br>
	 * 
	 * @param EstimatedAuditVO[] estimatedAuditVOs
	 * @param String yearMonth
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void savePayableEstimateAuditBasic(EstimatedAuditVO[] estimatedAuditVOs , String yearMonth , SignOnUserAccount account) throws EventException;

	/**
	 * 임차료에 대한 추정 실적 계산 합니다 backend job.<br>
	 * 
	 * @param EstimatedAuditVO estimatedAuditVO
	 * @param SignOnUserAccount userAccount
	 * @return String 
	 * @exception EventException
	 */
	public String backEndCalculationPayableEstimateAuditBasic( EstimatedAuditVO estimatedAuditVO, SignOnUserAccount userAccount ) throws EventException ;

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;
	
}