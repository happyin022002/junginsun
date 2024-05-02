/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMDM_CNTR_TYPEDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-08
 *@LastModifier : ChungEunHo
 *@LastVersion : 1.0
 * 2009-09-08 ChungEunHo / EQR	1.0
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
public class ReceiveQueueMdmCntrTpDBDAO extends DBDAOSupport{
	private String JNDINAME = "";
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean addMdmCntrTp(List insModels) throws DAOException {
		boolean isSuccessful = false; 
		int insCnt[] = null;
		
		try {
			insCnt = new SQLExecuter(JNDINAME).executeBatch((ISQLTemplate)new ReceiveQueueMdmCntrTpDBDAOAddMdmCntrTpCSQL(), insModels,null);
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
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean addMdmCntrTpEtc(List uptModels) throws DAOException {
		boolean isSuccessful = false; 
		int uptCnt[] = null;
		
		try {
			uptCnt = new SQLExecuter(JNDINAME).executeBatch((ISQLTemplate)new ReceiveQueueMdmCntrTpDBDAOAddMdmCntrTpEtcUSQL(), uptModels,null);
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
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean SearchMdmCntrTpList(String cntr_tp_cd) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cntr_tp_cd", cntr_tp_cd);
			dbRowset = new SQLExecuter(JNDINAME).executeQuery((ISQLTemplate)new ReceiveQueueMdmCntrTpDBDAOSearchMdmCntrTpListRSQL(), param, null);
			if(dbRowset.next()){
				if(dbRowset.getDouble("CNTR_TP_CNT") < 1){
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
	public boolean removeMdmCntrTp(List delModels) throws DAOException{
		boolean isSuccessful = false; 
		int delCnt[] = null;
		
		try {
			delCnt = new SQLExecuter(JNDINAME).executeBatch((ISQLTemplate)new ReceiveQueueMdmCntrTpDBDAORemoveMdmCntrTpUSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
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
}
