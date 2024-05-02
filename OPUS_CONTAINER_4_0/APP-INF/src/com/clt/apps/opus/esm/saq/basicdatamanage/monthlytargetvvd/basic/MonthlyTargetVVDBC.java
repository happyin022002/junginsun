/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : MonthlyTargetVVDBC.java
*@FileTitle      : Target VVD/Supply Inquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlytargetvvd.basic;

import java.util.HashMap;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonTgtVvdVO;

/**
 * Basicdatamanage Business Logic Command Interface<br>
 * - Basicdatamanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author taeho, Kim
 * @see Esm_saq_0154EventResponse 참조
 * @since J2EE 1.6
 */

public interface MonthlyTargetVVDBC {

	/** 
	 * ESM_SAQ_0154 : [이벤트]<br>
	 * [MonthlyTargetVVDInquiry]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyTargetVVDInquiry0154List01(QuotaConditionVO conditionVO) throws EventException;

	/** 
	 * ESM_SAQ_0040 : [이벤트]<br>
	 * [Target VVD/Supply Management 1tab Information]을 [조회]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyTargetVVD0040Tab01(QuotaConditionVO conditionVO) throws EventException;

	/** 
	 * ESM_SAQ_0040 : [이벤트]<br>
	 * [Target VVD/Supply Management 2tab Group]을 [조회]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyTargetVVDGroup0040Tab02(QuotaConditionVO conditionVO) throws EventException;

	/** 
	 * ESM_SAQ_0040 : [Save]<br>
	 * [Target VVD/Supply Management ]을 [저장]합니다.<br>
	 * 
	 * @param SaqMonTgtVvdVO[] saqMonTgtVvdVOs
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO multiMonthlyTargetVVD0040(SaqMonTgtVvdVO[] saqMonTgtVvdVOs,SignOnUserAccount account) throws EventException;

	/** 
	 * ESM_SAQ_0040 : [SKD Copy]<br>
	 * [Target VVD/Supply Management ]을 [SKD Copy]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO processSKDCopy0040(QuotaConditionVO conditionVO,SignOnUserAccount account) throws EventException;

	/** 
	 * ESM_SAQ_0040 : [Confirm]<br>
	 * [Target VVD/Supply Management]을 [Confirm]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO processConfirm0040(QuotaConditionVO conditionVO,SignOnUserAccount account) throws EventException;

	/** 
	 * ESM_SAQ_0040 : [Cancel Confirmation]<br>
	 * [Target VVD/Supply Management]을 [Cancel Confirmation]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO processCancelConfirm0040(QuotaConditionVO conditionVO,SignOnUserAccount account) throws EventException;

	/** 
	 * ESM_SAQ_0040 : [이벤트]<br>
	 * [Target VVD/Supply Management 2tab Group]을 [조회]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public HashMap searchSKDCopyMessage0040(QuotaConditionVO conditionVO) throws EventException;

	
}