/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmTradeDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmTradeDBDAO extends DBDAOSupport{
	
	/**
	 * Insert
	 * @param models
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean addMdmTrade(List insModels) throws DAOException {
		boolean isSuccessful = false; 
		int insCnt[] = null;
		
		try {
			insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new ReceiveQueueMdmTradeDBDAOAddMdmTradeCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
			
			isSuccessful = true;
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		
		return isSuccessful;
	}
	
	/**
	 * Update
	 * @param models
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean modifyMdmTrade(List uptModels) throws DAOException {
		boolean isSuccessful = false; 
		int uptCnt[] = null;
		
		try {
			uptCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new ReceiveQueueMdmTradeDBDAOModifyMdmTradeUSQL(), uptModels,null);
			for(int i = 0; i < uptCnt.length; i++){
				if(uptCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}
			
			isSuccessful = true;
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		
		return isSuccessful;
	}
	
	/**
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmTradeList(String pk) throws DAOException{
		boolean isSuccessful = false;
		DBRowSet dbRowset    = null;
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("pk", pk);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueMdmTradeDBDAOSearchMdmTradeListRSQL(), param, param);
			
			if(dbRowset.getRowCount() > 0){
				isSuccessful = false;
			}else{
				isSuccessful = true;
			}
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
			
		return isSuccessful;
	}
	
	/**
	 * Delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean removeMdmTrade(List delModels) throws DAOException{
		boolean isSuccessful = false; 
		int delCnt[] = null;
		
		try {
			delCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate)new ReceiveQueueMdmTradeDBDAORemoveMdmTradeDSQL(), delModels, null);;
			
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
			}
			
			isSuccessful = true;			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful;
	}
}