/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMdmLseCoYdDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 * No.	Ver.		Modifier           					modifier date    explanation
 * 1		1.0		Kim Jung-Jae					2007-02-26		1.0 최초 생성
 * 2      	1.0      	Lee Byoung Hun				2009.09.09		New Framework 적용 Renewal
 *
 *@LastModifyDate : 2009.09.09
 *@LastModifier : Lee Byoung Hun
 *@LastVersion : 1.0
 * 2009.09.09 Lee Byoung Hun
 * New Framework 적용 Renewal
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
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
public class ReceiveQueueMdmLseCoYdDBDAO extends DBDAOSupport{
	
	/**
	 * insert 처리
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean addMdmLseCoYd(Collection models) throws DAOException {
		boolean isSuccessful = false; 
		int cnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				cnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmLseCoYdDBDAOAddMdmLseCoYdCSQL(), models,null);
				for(int i = 0; i < cnt.length; i++){
					if(cnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			isSuccessful = true;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return isSuccessful;
	}
	
	/**
	 * update 처리
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean modifyMdmLseCoYd(Collection models) throws DAOException {
		boolean isSuccessful = false; 
		int cnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				cnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmLseCoYdDBDAOModifyMdmLseCoYdUSQL(), models,null);
				for(int i = 0; i < cnt.length; i++){
					if(cnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			isSuccessful = true;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return isSuccessful;
	}
	
	/**
	 * 기존 DB에 데이타 유무 확인
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMDM_LSE_CO_YDList(String pk) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("lse_co_yd_cd", pk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmLseCoYdDBDAOSearchMdmLseCoYdRSQL(), param, velParam);
			
			if(dbRowset.getRowCount() <= 0)
				isSuccessful = true;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return isSuccessful;
	}
	
	/**
	 * delete 처리
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean removeMdmLseCoYd(Collection models) throws DAOException{
		boolean isSuccessful = false; 
		int cnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size() > 0){
				cnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmLseCoYdDBDAORemoveMdmLseCoYdDSQL(), models,null);
				for(int i = 0; i < cnt.length; i++){
					if(cnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			isSuccessful = true;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return isSuccessful;
	}
}