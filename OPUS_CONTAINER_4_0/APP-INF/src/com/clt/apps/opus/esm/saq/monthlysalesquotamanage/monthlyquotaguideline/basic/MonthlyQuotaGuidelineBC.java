/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaGuidelineBC.java
 *@FileTitle : Master Version Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Monthlysalesquotamanage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0076EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaGuidelineBC {

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyGuidelineTargetGroup0076Tab01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyGuidelineSubTrade0076Tab02(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineCancelCurrentVersion0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineConfirmDraft0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineCancelConfirmation0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineNotifyDraft0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineCancelNotification0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineConfirmAsFinalVersion0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineCancelFinalVersion0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}