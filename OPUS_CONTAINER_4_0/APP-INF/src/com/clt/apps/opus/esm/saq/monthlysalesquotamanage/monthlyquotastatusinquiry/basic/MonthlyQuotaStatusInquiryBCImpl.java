/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaStatusInquiryBCImpl.java
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
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.integration.MonthlyQuotaStatusInquiryDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * MonthlySalesQuotaManage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0153EventResponse,MonthlyQuotaStatusInquiryBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaStatusInquiryBCImpl extends BasicCommandSupport implements MonthlyQuotaStatusInquiryBC {

	// Database Access Object
	private transient MonthlyQuotaStatusInquiryDBDAO dbDao = null;

	public MonthlyQuotaStatusInquiryBCImpl() {
		dbDao = new MonthlyQuotaStatusInquiryDBDAO();
	}

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaStatusInquiry0153List01(QuotaConditionVO quotaConditionVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaStatusInquiry0153List01(quotaConditionVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

}