/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaAdjustmentTradeBC.java
 *@FileTitle : Monthly Sales Quota Adjustment Trade Group
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0048Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0147Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0176Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Monthlysalesquotamanage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0048EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaAdjustmentTradeBC {

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTrade0048List01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTabTargetGroup0048Tab01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTabTrade0048Tab01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTabTrade0048Tab02(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTabTrade0048Tab03(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeRMK0048List01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0048Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentTrade0048(EsmSaq0048Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param EsmSaq0048Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMonthlyAdjustmentTradeInfo0048(EsmSaq0048Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param EsmSaq0048Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentFinal0048(EsmSaq0048Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeCancelCurrentVersion0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @exception EventException
	 */
	public void procAdjustmentFinalCancelCurrentVersion0048(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeConfirmDraft0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeCancelConfirmation0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentFinalConfirmDraft0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentFinalCancelConfirmation0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeNotifyDraft0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeCancelNotification0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentFinalNotifyDraft0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentFinalCancelNotification0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentTradeLoadZero0048List(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentTradeMonthLoadZero0048List(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeModify0147List(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0147Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyQuotaAdjustmentTradeModify0147(EsmSaq0147Event event, SignOnUserAccount account) throws EventException;

	/**
	 * calling function SAQ_MON_QTA_ADJ_CRE_PRC() <br>
	 * 
	 * @param String mqtaStepCd
	 * @param String bseYr
	 * @param String bse_qtr_cd
	 * @param String trdCd
	 * @param String dirCd
	 * @param String mqtaVerNo
	 * @param String usrId
	 * @exception EventException
	 */
	public void createQtaAdjSmry(String mqtaStepCd, String bseYr, String bse_qtr_cd, String trdCd, String dirCd, String mqtaVerNo, String usrId) throws EventException;

	/**
	 * searchMonthlyQuotaAdjustmentTradeForExcel0176List 조회 <br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeForExcel0176List(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * updateMonthlyQuotaAdjustmentTradeForExcel0176 <br>
	 * 
	 * @param EsmSaq0176Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyQuotaAdjustmentTradeForExcel0176(EsmSaq0176Event event, SignOnUserAccount account) throws EventException;

}