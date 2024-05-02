/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMdmCntrSzDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-08
 *@LastModifier : ChungEunHo
 *@LastVersion : 1.0
 * 2009-09-08 ChungEunHo / EQR	2.0
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
 * @author ChungEunHo
 * @see 
 * @since J2EE 1.6
 */
public class ReceiveQueueMdmCntrSzDBDAO extends DBDAOSupport{
	private String JNDINAME = "";
	/**
	 * insert
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean addMdmCntrSz(List insModels) throws DAOException {
		boolean isSuccessful = false; 
		int insCnt[] = null;
		
		try {
			insCnt = new SQLExecuter(JNDINAME).executeBatch((ISQLTemplate)new ReceiveQueueMdmCntrSzDBDAOAddMdmCntrSzCSQL(), insModels,null);
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
	 * update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean addMdmCntrSzEtc(List uptModels) throws DAOException {
		boolean isSuccessful = false; 
		int uptCnt[] = null;
		
		try {
			uptCnt = new SQLExecuter(JNDINAME).executeBatch((ISQLTemplate)new ReceiveQueueMdmCntrSzDBDAOAddMdmCntrSzEtcUSQL(), uptModels,null);
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
	 * 기존 데이타 유무 검색
	 * @param cntr_sz_cd
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmCntrSzList(String cntr_sz_cd) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cntr_sz_cd", cntr_sz_cd);
			dbRowset = new SQLExecuter(JNDINAME).executeQuery((ISQLTemplate)new ReceiveQueueMdmCntrSzDBDAOSearchMdmCntrSzListRSQL(), param, null);
			if(dbRowset.next()){
				if(dbRowset.getDouble("CNTR_SZ_CNT") < 1){
					isSuccessful = true; 
				}
			}
				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
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
	public boolean removeMdmCntrSz(List delModels) throws DAOException{
		boolean isSuccessful = false; 
		int delCnt[] = null;
		
		try {
			delCnt = new SQLExecuter(JNDINAME).executeBatch((ISQLTemplate)new ReceiveQueueMdmCntrSzDBDAORemoveMdmCntrSzUSQL(), delModels,null);
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

