/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : MonthlyQuotaAdjustmentInquiryBC.java
 *@FileTitle      : Trade Group
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotaadjustmentinquiry.monthlyquotaadjustmentinquiry.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Business Logic Command Interface<br>
 * 
 * @author
 * @see MonthlyQuotaAdjustmentInquiryBCImpl
 * @since J2EE 1.6
 */

public interface MonthlyQuotaAdjustmentInquiryBC {

	/**
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab01(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab02(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab03(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab03Sub(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab04(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0049Tab05(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab01(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab02(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab03(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab03Child(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab04(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0088Tab05(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0089Tab01(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0089Tab02(QuotaConditionVO conditionvo) throws EventException;

	/**
	 * @param QuotaConditionVO conditionvo
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaInquiry0089Tab04(QuotaConditionVO conditionvo) throws EventException;

}