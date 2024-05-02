/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CostAccrualDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sac.costaccrual.costaccrual.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration.AccountPayableInvoiceDBDAORemoveInvoicePayScheduleDSQL;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.APManualInvoiceAccuralCondVO;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * CostAccrualDBDAO <br>
 * - CostAccrual system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see CostAccrualBCImpl 참조
 * @since J2EE 1.4
 */

@SuppressWarnings("serial")
public class CostAccrualDBDAO extends DBDAOSupport {
	
	/**
	 * [STM_SAP_0150]
	 * AP Manaul Accrual을 생성하는데 해당월의 Max ESTM_SEQ_NO VALUE SEARCH<br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0150
	 * @category SearchInvoiceAccrualNumberCheck
	 * @param String gl_yymm
	 * @return String
	 * @throws DAOException
	 */	 
	public String searchInvoiceAccrualNumberCheck(String gl_yymm) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (gl_yymm != null) {
				param.put("gl_yymm", gl_yymm);	
				velParam.put("gl_yymm", gl_yymm);	
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostAccrualDBDAOSearchInvoiceAccrualNumberCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("ESTM_SEQ_NO");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [STM_SAP_0150] 
	 * AP MANUAL ACCRUAL INTERFACE(addAPManualInvoiceAccrual) <br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0150
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @throws DAOException
	*/ 
	public void addAPManulInvoiceAccrual(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = aPManualInvoiceAccuralCondVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new CostAccrualDBDAOAddAPManualInvoiceAccrualCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [STM_SAP_0150] 
	 * AP MANUAL ACCRUAL Cancel (removeAPManulInvoiceAccrual) <br>
	 * 
	 * @author KSJO
	 * @category STM_SAP_0150
	 * @param APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO
	 * @throws DAOException
	*/ 
	public void removeAPManulInvoiceAccrual(APManualInvoiceAccuralCondVO aPManualInvoiceAccuralCondVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
							
			Map<String, String> mapVO = aPManualInvoiceAccuralCondVO.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new CostAccrualDBDAORemoveAPManualInvoiceAccrualDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}