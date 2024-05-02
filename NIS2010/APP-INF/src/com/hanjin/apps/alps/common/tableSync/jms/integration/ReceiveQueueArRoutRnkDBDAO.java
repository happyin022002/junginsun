/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueArFinDirConvDBDAO.java
 *@FileTitle : ENIS Interface 연동
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-25
 *@LastModifier : Ho-Jin Lee
 *@LastVersion : 1.0
 * 2009-09-25 Ho-Jin Lee
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ArRoutRnkVO;


public class ReceiveQueueArRoutRnkDBDAO extends DBDAOSupport{
	/**
	 * insert,update
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public int addArRoutRnk(ArRoutRnkVO model) throws DAOException {
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
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArRoutRnkDBDAOAddArRoutRnkCSQL(),  param, velParam);
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
	
	/**
	 * 기존 데이타 유무 확인
	 * @param pk1
	 * @param pk2
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchArRoutRnkList(String rlane_cd,String rnk_seq) throws DAOException{
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("rlane_cd", rlane_cd);
			param.put("rnk_seq", rnk_seq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueArRoutRnkDBDAOSearchArRoutRnkRSQL(), param, null);

			if(dbRowset.next()){
				if(dbRowset.getRowCount() <= 0) isSuccessful = true;
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
	public int removeArRoutRnk(ArRoutRnkVO model) throws DAOException{
		int delCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArRoutRnkDBDAOModifyArRoutRnkUSQL(),  param, velParam);
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
	
	/**
	 * delete all
	 * @return
	 * @throws DAOException
	 */
	public boolean removeallArRoutRnk() throws DAOException{
		boolean isSuccessful = false;
		
		try {
			int delAllCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArRoutRnkDBDAOModifyArRoutRnkDSQL(),  null, null);
			if(delAllCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to update SQL");
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
