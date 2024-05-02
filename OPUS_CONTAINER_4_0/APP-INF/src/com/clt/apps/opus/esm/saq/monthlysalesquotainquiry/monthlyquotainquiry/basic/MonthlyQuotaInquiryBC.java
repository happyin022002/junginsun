/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName       : MonthlyQuotaInquiryBC.java
 *@FileTitle      : Monthly Quota Inquiry
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.basic;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab02VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab03HRVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab03Sub01HRVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab03Sub01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab03VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab04VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0126Tab05VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0127Tab10VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0128Tab03VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0128Tab10VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0139Tab01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0139Tab02VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0139Tab03Sub01VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotainquiry.monthlyquotainquiry.vo.SearchMonthlyQuotaInquiry0139Tab03VO;
import com.clt.framework.core.layer.event.EventException;

/**
 * 
 * @author
 * @see Esm_saq_0139EventResponse
 * @since J2EE 1.6
 */

public interface MonthlyQuotaInquiryBC {

	/**
	 * [ESM_SAQ_0139] COMMAND ID : SEARCHLIST01.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0139Tab01VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0139Tab01VO> searchMonthlyQuotaInquiry0139Tab01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0139] COMMAND ID : SEARCHLIST02
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0139Tab02VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0139Tab02VO> searchMonthlyQuotaInquiry0139Tab02(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0139] COMMAND ID : SEARCHLIST03
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0139Tab03VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0139Tab03VO> searchMonthlyQuotaInquiry0139Tab03(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0139] COMMAND ID : SEARCHLIST13
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0139Tab03Sub01VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0139Tab03Sub01VO> searchMonthlyQuotaInquiry0139Tab03Sub01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0126] COMMAND ID : SEARCHLIST01
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab01VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab01VO> searchMonthlyQuotaInquiry0126Tab01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0126] COMMAND ID : SEARCHLIST02
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab02VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab02VO> searchMonthlyQuotaInquiry0126Tab02(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0126] COMMAND ID : SEARCHLIST03
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab03HRVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab03HRVO> searchMonthlyQuotaInquiry0126Tab03HR(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0126] COMMAND ID : SEARCHLIST13
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab03Sub01HRVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab03Sub01HRVO> searchMonthlyQuotaInquiry0126Tab03Sub01HR(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0126] COMMAND ID : SEARCHLIST04
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab04VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab04VO> searchMonthlyQuotaInquiry0126Tab04(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0126] COMMAND ID : SEARCHLIST05
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab05VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab05VO> searchMonthlyQuotaInquiry0126Tab05(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0127] COMMAND ID : SEARCHLIST01
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab01VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab01VO> searchMonthlyQuotaInquiry0127Tab01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0127] COMMAND ID : SEARCHLIST02
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab02VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab02VO> searchMonthlyQuotaInquiry0127Tab02(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0127] COMMAND ID : SEARCHLIST03
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab03VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab03VO> searchMonthlyQuotaInquiry0127Tab03(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0127] COMMAND ID : SEARCHLIST13
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab03Sub01VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab03Sub01VO> searchMonthlyQuotaInquiry0127Tab03Sub01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0127] COMMAND ID : SEARCHLIST04
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab04VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab04VO> searchMonthlyQuotaInquiry0127Tab04(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0127] COMMAND ID : SEARCHLIST05
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab05VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab05VO> searchMonthlyQuotaInquiry0127Tab05(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0127] COMMAND ID : SEARCHLIST10
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0127Tab10VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0127Tab10VO> searchMonthlyQuotaInquiry0127Tab10(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0128] COMMAND ID : SEARCHLIST01
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab01VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab01VO> searchMonthlyQuotaInquiry0128Tab01(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0128] COMMAND ID : SEARCHLIST02
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0126Tab02VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0126Tab02VO> searchMonthlyQuotaInquiry0128Tab02(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0128] COMMAND ID : SEARCHLIST03
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0128Tab03VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0128Tab03VO> searchMonthlyQuotaInquiry0128Tab03(QuotaConditionVO quotaConditionVO) throws EventException;

	/**
	 * [ESM_SAQ_0128] COMMAND ID : SEARCHLIST10
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaInquiry0128Tab10VO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaInquiry0128Tab10VO> searchMonthlyQuotaInquiry0128Tab10(QuotaConditionVO quotaConditionVO) throws EventException;
}
