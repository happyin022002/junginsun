/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : MonthlyCustomizedConditionBC.java
*@FileTitle      : Customized Conditions
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.saq.basicdatamanage.monthlycustomizedcondition.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonDirConvVO;
import com.clt.syscommon.common.table.SaqMonLodTgtOfcVO;

/**
 * Basicdatamanage Business Logic Command Interface<br>
 * - Basicdatamanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author taeho, Kim
 * @see Esm_saq_0163EventResponse 참조
 * @since J2EE 1.6
 */

public interface MonthlyCustomizedConditionBC {

	/**
	 * MonthlyCustomizedCondition화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param QuotaConditionVO	conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyCustomizedConditionTabLoadTarget0163Tab01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * [1tab Status]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO	conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String getMonthlyCustomizedConditionLodTargetStatus(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * [2tab Status]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO	conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String getMonthlyCustomizedConditionLaneBoundStatus(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * [2tab]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO	conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyCustomizedConditionTabLaneBound0163Tab02(QuotaConditionVO conditionVO) throws EventException;
	
	/**
	 * [2tab]을 [confirm, confirm cancel] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyCustomizedConditionTabLaneBound0163Tab02(QuotaConditionVO conditionVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [2tab]을 [저장] 합니다.<br>
	 * 
	 * @param SaqMonDirConvVO[] saqMonDirConvVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyCustomizedConditionTabLaneBoundSave0163Tab02(SaqMonDirConvVO[] saqMonDirConvVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [1tab]을 [Initial Data생성] 합니다.<br>
	 * 
	 * @param QuotaConditionVO coditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiMonthlyCustomizedConditionTabLoadTargetCopy0163Tab01(QuotaConditionVO coditionVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [2tab]을 [Initial Data생성] 합니다.<br>
	 * 
	 * @param QuotaConditionVO coditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiMonthlyCustomizedConditionTabLaneBoundCopy0163Tab02(QuotaConditionVO coditionVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [1tab]을 [저장] 합니다.<br>
	 * 
	 * @param SaqMonLodTgtOfcVO[] saqMonLodTgtOfcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyCustomizedConditionTabLoadTargetSave0163Tab01(SaqMonLodTgtOfcVO[] saqMonLodTgtOfcVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * [1tab]을 [confirm, confirm cancel] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyCustomizedConditionTabLoadTarget0163Tab01(QuotaConditionVO conditionVO,SignOnUserAccount account) throws EventException;

	
}