/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_VSL_CNTRDBDAO.java
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
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmVslCntrDBDAO extends DBDAOSupport{
	/**
	 * insert
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public void addMdmVslCntrInsert(MdmVslCntrVO model) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);

			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmVslCntrDBDAOAddMdmVslCntrInsertCSQL(), param, param);
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
	 * update
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public void addMdmVslCntrUpdate(MdmVslCntrVO model) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> paramVo = model.getColumnValues();
			param.putAll(paramVo);
			log.debug("MDM025 update=="+model.getVslCd()+"::"+model.getVslLoclNm());	
			int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmVslCntrDBDAOAddMdmVslCntrUpdateUSQL(), param, param);
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
	
	
	
	/**
	 * 기존 데이타 확인 유무
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmVslCntrList(String pk) throws DAOException{
		
		boolean isSuccessful = false; 
		DBRowSet dRs = null;
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", pk);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueMdmVslCntrDBDAOSearchMdmVslCntrListRSQL(), param, param);
			
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
	public void removeMdmVslCntr(MdmVslCntrVO model) throws DAOException{
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			
			param.put("upd_usr_id"	, model.getUpdUsrId());
			param.put("upd_dt"		, model.getUpdDt());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			param.put("eai_if_id"	, model.getEaiIfId());
			param.put("vsl_cd"		, model.getVslCd());
			
			int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueMdmVslCntrDBDAORemoveMdmVslCntrUSQL(), param, param);
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
