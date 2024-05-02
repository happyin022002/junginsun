/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EdiHoldStatusReceiveDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-25
*@LastModifier : Y
*@LastVersion : 1.0
* 2013-06-25
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/**
 * ALPS-SCE에 대한 DB 처리를 담당<br>
 * - ALPS-SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sang-Jun Kwon 
 * @see  
 * @since J2EE 1.4
 */
public class EdiHoldStatusReceiveDBDAO extends DBDAOSupport {

	/**
	 * search Hold Status MSG Data
	 *    
	 * @param  String bkg_no
	 * @param  String cntr_no
	 * @return int
	 * @throws DAOException
	 */
	public int searchHoldStatusData(String bkg_no, String cntr_no) throws DAOException {

		DBRowSet dbRowset = null;
		int rowCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		

	    /*파라미터 입력*/ 	
		
		try {
			
			Map<String, String> mapVO = new HashMap();
			mapVO.put("bkg_no",bkg_no); 
			mapVO.put("cntr_no",cntr_no);
			
	    	param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EdiHoldStatusReceiveDBDAOGetCountRSQL(), param, velParam);
			
			if (dbRowset != null && dbRowset.next()) {
				rowCnt = dbRowset.getInt(1);
			}
			
			return rowCnt;

		} catch (SQLException se) {
			//log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * @param HashMap<String, String> mapVO
	 * @throws DAOException
	 */
	public void updateHoldStatusData(HashMap<String, String> mapVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		/*파라미터 입력*/ 	
		Map<String, Object> param = new HashMap<String, Object> ();
		Map<String, Object> velParam = new HashMap<String, Object> ();
		
				
		try {
			
	    	param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			sqlExe.executeUpdate(new EdiHoldStatusReceiveDAOModifyHoldStatusUSQL(), param, velParam);
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * @param HashMap<String, String> mapVO
	 * @throws DAOException
	 */
	public void createHoldStatusData(HashMap<String, String> mapVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		/*파라미터 입력*/ 	
		Map<String, Object> param = new HashMap<String, Object> ();
		Map<String, Object> velParam = new HashMap<String, Object> ();
		
		try {

	    	param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			sqlExe.executeUpdate(new EdiHoldStatusReceiveDAOAddHoldStatusCSQL(), param, velParam);
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
	/**
	 * @param HashMap<String, String> mapVO
	 * @throws DAOException
	 */
	public void createHoldStatusHistoryData(HashMap<String, String> mapVO) throws DAOException {

		SQLExecuter sqlExe = new SQLExecuter("");
		
		/*파라미터 입력*/ 	
		Map<String, Object> param = new HashMap<String, Object> ();
		Map<String, Object> velParam = new HashMap<String, Object> ();
		
		try {

	    	param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			sqlExe.executeUpdate(new EdiHoldStatusReceiveDAOAddHoldStatusHistoryCSQL(), param, velParam);
	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}
	
}
