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
package com.clt.apps.opus.esm.acm.acmcalculation.cmcostcalculation.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.basic.FACCommCalculationBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS CmcostCalculationnDBDAO <br>
 * - OPUS-ACMCalculation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kim Young-Oh
 * @see FACCommCalculationBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class CmcostCalculationDBDAO extends DBDAOSupport {

	/**
	 * [ACM_COMM_UT_COST_PRC 프로시져 호출]<br>
	 * ACM_COMM_UT_COST_PRC 프로시져 호출.<br>
	 *
	 * @param String pctl_no
	 * @param String usr_id
	 * @return SearchAgnBookingInfoVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public String createCmcostCalculationnInfo(String pctl_no, String usr_id) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    Map<String, Object> rtnMap = new HashMap<String, Object>();
	    String returnNo = "";
		try {
	       Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("pctl_no", pctl_no);
			mapVO.put("usr_id", usr_id);
			mapVO.put("return_no", "");
			param.putAll(mapVO);

			if (pctl_no != null) {
				param.put("pctl_no", pctl_no);
				velParam.put("pctl_no", pctl_no);
			}
			if (usr_id != null) {
				param.put("usr_id", usr_id);
				velParam.put("usr_id", usr_id);
			}

			rtnMap = new SQLExecuter("").executeSP((ISQLTemplate)new CmcostCalculationnDBODAOCreateCmcostCalculationInfoCSQL(), param, velParam);
			returnNo = rtnMap.get("return_no")==null?"": (String)rtnMap.get("return_no");
			log.debug("---------------------------------------------------------");
			log.debug("rtnMap:" + rtnMap);
			log.debug("---------------------------------------------------------");

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnNo;
	}
}