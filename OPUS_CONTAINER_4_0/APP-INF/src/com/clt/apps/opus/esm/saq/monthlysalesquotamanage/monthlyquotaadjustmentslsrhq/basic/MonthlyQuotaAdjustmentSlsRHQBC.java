/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaAdjustmentSlsRHQBC.java
 *@FileTitle : Monthly Sales Quota Adjustment RHQ
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event.EsmSaq0156Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event.EsmSaq0158Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Monthlysalesquotamanage Business Logic Command Interface<br>
 * 
 * @author ChoiI.M.C
 * @see Esm_saq_0156EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaAdjustmentSlsRHQBC {

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentSlsRhq0156List01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentSlsRHQTabTrade0156Tab01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentSlsRHQTabTrade0156Tab02(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentSlsRHQTabTrade0156Tab03(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentSlsRHQRMK0156List01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0156Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentSlsRhq0156(EsmSaq0156Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param EsmSaq0156Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMonthlyAdjustmentSlsRhqInfo0156(EsmSaq0156Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentSlsRhqCancelCurrentVersion0156(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String procAdjustmentSlsRhqConfirmDraft0156(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentSlsRhqCancelConfirmation0156(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentSlsRhqNotifyDraft0156(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentSlsRhqCancelNotification0156(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentSlsRhqLoadZero0156List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentSlsRhqModify0158List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0158Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyQuotaAdjustmentSlsRhqModify0158(EsmSaq0158Event event, SignOnUserAccount account) throws EventException;

}