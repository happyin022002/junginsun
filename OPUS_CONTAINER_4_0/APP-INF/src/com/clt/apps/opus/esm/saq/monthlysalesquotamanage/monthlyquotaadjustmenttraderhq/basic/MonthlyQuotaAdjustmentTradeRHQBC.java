/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaAdjustmentTradeRHQBC.java
 *@FileTitle : Monthly Sales Quota Adjustment Trade - RHQ
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event.EsmSaq0085Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event.EsmSaq0148Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Monthlysalesquotamanage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0085EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaAdjustmentTradeRHQBC {

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeRhq0085List01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTradeRhq0085Tab03(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0085Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentTradeRhq0085(EsmSaq0085Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param EsmSaq0085Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMonthlyAdjustmentTradeRhqInfo0085(EsmSaq0085Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqCancelCurrentVersion0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqConfirmDraft0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqCancelConfirmation0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqFinalConfirmDraft0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqNotifyDraft0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqCancelNotification0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentTradeRhqLoadZero0085List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeRhqModify0148List(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0148Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyQuotaAdjustmentTradeRhqModify0148(EsmSaq0148Event event, SignOnUserAccount account) throws EventException;

}