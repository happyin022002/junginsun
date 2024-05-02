/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaAdjustmentRHQBC.java
 *@FileTitle : Monthly Sales Quota Adjustment RHQ
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0075Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0149Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0161Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentrhq.event.EsmSaq0162Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0075EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaAdjustmentRHQBC {

	/**
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentRhq0075Tab01Sub01List01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentRHQTabTargetGroup0075Tab01List01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentRHQTabTrade0075Tab01List02(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentRHQTabSubTrade0075Tab02List01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentRHQTabRhqLane0075Tab03List01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentRHQRMK0075Tab01Sub01List01(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * @param EsmSaq0075Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentRhqFinal0075(EsmSaq0075Event event, SignOnUserAccount account) throws EventException;

	/**
	 * @param EsmSaq0075Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMonthlyAdjustmentRhqInfo0075(EsmSaq0075Event event, SignOnUserAccount account) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentRhqCancelCurrentVersion0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String procAdjustmentRhqFinalConfirmDraft0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentRhqFinalCancelConfirmation0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentRhqFinalNotifyDraft0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentRhqFinalCancelNotification0075(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentRhqLoadZero0075List(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaForExcel0161List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * updateMonthlyQuotaForExcelList <br>
	 * 
	 * @param EsmSaq0161Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyQuotaForExcel0161(EsmSaq0161Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaOfficeAdd0162List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0162Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void insertMonthlyQuotaOfficeAdd0162(EsmSaq0162Event event, SignOnUserAccount account) throws EventException;

	/**
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentRhqModify0149List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * @param EsmSaq0149Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyQuotaAdjustmentRhqModify0149(EsmSaq0149Event event, SignOnUserAccount account) throws EventException;

	/**
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

}
