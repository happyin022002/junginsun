/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationDBDAO.java
*@FileTitle : FACCommCalculationDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.05
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.05 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.batchcalculationmgmt.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBCImpl;
import com.hanjin.apps.alps.esm.acm.acmcalculation.faccommcalculation.vo.SearchAgnBookingInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS CmcostCalculationnDBDAO <br>
 * - ALPS-ACMCalculation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kim Young-Oh
 * @see FACCommCalculationBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class BatchcalculationmgmtDBDAO extends DBDAOSupport {
	 
	/**
	 * [ACM_COMM_UT_COST_PRC 프로시져 호출]<br>
	 * ACM_COMM_UT_COST_PRC 프로시져 호출.<br>
	 *
	 * @param String bkg_no
	 * @param String usr_id
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public SearchAgnBookingInfoVO addCalculationBatchList(String bkg_no, String usr_id) throws DAOException {
		SearchAgnBookingInfoVO bkgInfo = new SearchAgnBookingInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
	
		try{
			if (bkg_no != null) {	
				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			if (usr_id != null) {
				param.put("usr_id", usr_id);
				velParam.put("usr_id", usr_id);
			}
			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new BatchcalculationmgmtDBDAOAddCalculationBatchListCSQL(), param, velParam);
            log.debug("---------------------------------------------------------");
            log.debug("rtnMap:" + rtnMap);
			
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgInfo;
	}
	

}