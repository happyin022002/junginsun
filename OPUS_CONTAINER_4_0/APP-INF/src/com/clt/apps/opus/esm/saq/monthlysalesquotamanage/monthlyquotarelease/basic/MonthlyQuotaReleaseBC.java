/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaReleaseBC.java
 *@FileTitle : Confirmation and Distribution
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.basic;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.SaqMonQtaRlseTrdVO;
import com.clt.syscommon.common.table.SaqMonQtaRlseVO;

/**
 * Monthlysalesquotamanage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0052EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaReleaseBC {

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param String ofcCd
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaRelease0052List01(QuotaConditionVO conditionVO, String ofcCd) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param String is_new_version
	 * @param String mqta_rlse_ver_no
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaRelease0052ListSub01(QuotaConditionVO conditionVO, String is_new_version, String mqta_rlse_ver_no) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO appendMonthlyQuotaRelease0052(QuotaConditionVO conditionVO) throws EventException;

	/**
	 * 
	 * @param String mqta_rlse_ver_no
	 * @param String year
	 * @param String quarter
	 * @param String is_new_version
	 * @param SaqMonQtaRlseVO saqMonQtaRlseVO
	 * @param SaqMonQtaRlseTrdVO[] saqMonQtaRlseTrdVOs
	 * @param String user_id
	 * @exception EventException
	 */

	public void distributeMonthlyQuota0052(String mqta_rlse_ver_no, String year, String quarter, String is_new_version, SaqMonQtaRlseVO saqMonQtaRlseVO,
			SaqMonQtaRlseTrdVO[] saqMonQtaRlseTrdVOs, String user_id) throws EventException;

	/**
	 * 
	 * @param String year
	 * @param String quarter
	 * @param String mqta_rlse_ver_no
	 * @param String user_id
	 * @exception EventException
	 */

	public void transferSaqMonQtaCrePrc(String year, String quarter, String mqta_rlse_ver_no, String user_id) throws EventException;

}