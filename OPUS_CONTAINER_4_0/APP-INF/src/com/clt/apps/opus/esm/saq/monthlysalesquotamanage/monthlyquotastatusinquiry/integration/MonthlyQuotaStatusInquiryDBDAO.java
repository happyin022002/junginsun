/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MonthlyQuotaStatusInquiryDBDAO.java
*@FileTitle : Process Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2009.09.24 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.basic.MonthlyQuotaStatusInquiryBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotastatusinquiry.vo.SearchMonthlyQuotaStatusInquiry0153List01VO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * MonthlyQuotaStatusInquiryDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ju Sun Young
 * @see MonthlyQuotaStatusInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaStatusInquiryDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @param SignOnUserAccount account
	 * @return ReturnVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyQuotaStatusInquiry0153List01(QuotaConditionVO quotaConditionVO ,SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaStatusInquiry0153List01VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		ReturnVO returnVO = new ReturnVO();		

		try{
			if(quotaConditionVO != null){
				Map<String, String> mapVO = quotaConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("ofc_cd" ,account.getOfc_cd());
			
			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MonthlyQuotaStatusInquiryDBDAOSearchMonthlyQuotaStatusInquiry0153List01RSQL(), param, velParam);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaStatusInquiry0153List01VO.class);
				
				returnVO.setConditionVO(quotaConditionVO);
				returnVO.addList(list);
			} //소스 품질 수정 요청건
			
		} catch(SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
}