/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaCfmAdjustmentBC.java
 *@FileTitle : Sales. Rep
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0164Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0165Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0167Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Business Logic Command Interface<br>
 * 
 * @author
 * @see ESM_SAQ_0164EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaCfmAdjustmentBC {

	/**
	 * search
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyTargetVVDMapping0164List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * save<br>
	 * 
	 * @param EsmSaq0164Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyTargetVVD0164(EsmSaq0164Event event, SignOnUserAccount account) throws EventException;

	/**
	 * search<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQtaEdit0165List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0165Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyQtaEdit0165(EsmSaq0165Event event, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyVVD0166List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaEditOfficeAdd0167List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaEditOfficeAddNew0167List(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * 
	 * @param EsmSaq0167Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyQuotaEditOfficeAdd0167(EsmSaq0167Event event, SignOnUserAccount account) throws EventException;

}