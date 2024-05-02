/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaStatusInquiryBC.java
 *@FileTitle : Process Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * MonthlyQuotaStatusInquiryBC Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0513EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaStatusInquiryBC {

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaStatusInquiry0153List01(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException;
}