/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_REP_CMDTDBDAO.java
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmRepCmdtVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmRepCmdtDBDAO extends DBDAOSupport{
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public void addMdmRepCmdt(MdmRepCmdtVO model) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
			
		try {
			
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			
			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmRepCmdtDBDAOAddMdmRepCmdtCSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * insert, update
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public void modifyMdmRepCmdt(MdmRepCmdtVO model) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			
			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmRepCmdtDBDAOModifyMdmRepCmdtUSQL(), param, param);
			if(insCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmRepCmdtList(String pk) throws DAOException{
		
		boolean isSuccessful = false; 
		DBRowSet dRs = null;

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", pk);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueMdmRepCmdtDBDAOSearchMdmRepCmdtListRSQL(), param, param);
			
			if(dRs.getRowCount() > 0){
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
	 * delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public void removeMdmRepCmdt(MdmRepCmdtVO model) throws DAOException{

		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.putAll(model.getColumnValues());
			
			int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmRepCmdtDBDAORemoveMdmRepCmdtUSQL(), param, param);
			if(updCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to update SQL");
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 		
	}
}

