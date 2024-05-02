/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAR_AGN_STMT_AGMTDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 * 2009-09-25 : Ho-Jin Lee Alps 전환
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ArAgnStmtAgmtVO;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see
 * @since J2EE 1.4
 */
public class ReceiveQueueArAgnStmtAgmtDBDAO extends DBDAOSupport{
	/**
	 * insert, update
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public int addArAgnStmtAgmt(ArAgnStmtAgmtVO model) throws DAOException {
		int insCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArAgnStmtAgmtDBDAOAddArAgnStmtAgmtListCSQL(),  param, velParam);
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
		return insCnt; 
	}
	
	public int modifyArAgnStmtAgmt(ArAgnStmtAgmtVO model) throws DAOException{
		int upCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
			upCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArAgnStmtAgmtDBDAOModifyArAgnStmtAgmtListUSQL(),  param, velParam);
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
		return upCnt; 
    }
	
	/**
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchArAgnStmtAgmtList(ArAgnStmtAgmtVO model) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowSet = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueArAgnStmtAgmtDBDAOSearchArAgnStmtAgmtListRSQL(), param, velParam);
			
				if(dbRowSet.getRowCount() <= 0){
					isSuccessful = true;
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
	 * delete
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public int removeArAgnStmtAgmt(ArAgnStmtAgmtVO model) throws DAOException{
		int delCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();							
		try {
			Map<String, String> mapVO = model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArAgnStmtAgmtDBDAODeleteArAgnStmtAgmtListDSQL(),  param, velParam);
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
		return delCnt; 	
	}

	

}