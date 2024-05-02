/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : FCMCommonDBDAO.java
*@FileTitle : FCMCommonDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.15
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.11.15 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.fcmcommon.fcmcommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.vop.fcm.fcmcommon.fcmcommon.basic.FCMCommonBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS FCMCommonDBDAO<br>
 * ALPS FCMCommon Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Ryu Hyuk
 * @see FCMCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class FCMCommonDBDAO extends DBDAOSupport {

private static final long serialVersionUID = 1L;
	
	/**
	 * MDM Vessel Class Capacity List를 조회한다.
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchVslClassCapaList() throws DAOException {
		
		DBRowSet dbRowset = null;
		String list = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FCMCommonDBDAOVslClssCapaRSQL(), param, velParam);
			if(dbRowset.next()){
				list = dbRowset.getString(1);
			}
			
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * MDM에서 Vessel(Container) Design Capacity List를 조회한다.
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchCntrDznCapaList() throws DAOException {
		
		DBRowSet dbRowset = null;
		String list = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FCMCommonDBDAOVslClssCapaRSQL(), param, velParam);
			if(dbRowset.next()){
				list = dbRowset.getString(1);
			}
			
			return list;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}
