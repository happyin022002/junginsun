/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceDBDAO
*@FileTitle : PerformanceDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
* 
* History
* 2015.01.23 이병훈 [CHM-201430612] Fuel Consumption Master table 개발
=========================================================*/
package com.clt.apps.opus.vop.fcm.performance.performance.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.fcm.performance.performance.vo.FcmMasterTableInquiryVO;
import com.clt.apps.opus.vop.fcm.performance.performance.vo.FcmMonFoilSavCostVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.basic.TrendLineBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS PerformanceDBDAO<br>
 * ALPS FCM Performance Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Maria Chin
 * @see TrendLineBCImpl 참조
 * @since J2EE 1.6
 */

public class PerformanceDBDAO extends DBDAOSupport {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Fuel Consumption Master Table Inquiry 정보를 조회합니다.<br>
	 * [CHM-201430612] Fuel Consumption Master table 개발
	 * 
	 * @param FcmMonFoilSavCostVO fcmMonFoilSavCostVO
	 * @return List<FcmMasterTableInquiryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FcmMasterTableInquiryVO> searchFcmMasterTableInquiry(FcmMonFoilSavCostVO fcmMonFoilSavCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FcmMasterTableInquiryVO> fcmMasterTableInquiryVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (fcmMonFoilSavCostVO != null) {
				Map<String, String> mapVO = fcmMonFoilSavCostVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceDBDAOSearchFcmMasterTableInquiryRSQL(), param, velParam);
			fcmMasterTableInquiryVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, FcmMasterTableInquiryVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fcmMasterTableInquiryVOs;
	}
	
}
