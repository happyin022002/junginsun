/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueAP_WORKPLACEDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
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
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ApWorkplaceVO;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see
 * @since J2EE 1.4
 */
public class ReceiveQueueApWorkplaceDBDAO extends DBDAOSupport{

	/**
	 * insert
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void addApWorkplace(Object o) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ApWorkplaceVO model = (ApWorkplaceVO)o; 
			
			param.put("wkplc_nm"	, model.getWkplcNm());
			param.put("wkplc_desc"	, model.getWkplcDesc());
			param.put("inact_dt"	, model.getInactDt());
			param.put("cre_usr_id"	, model.getCreUsrId());
			param.put("cre_dt"		, model.getCreDt());
			param.put("upd_usr_id"	, model.getUpdUsrId());
			param.put("upd_dt"		, model.getUpdDt());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());

			int insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueApWorkplaceDBDAOAddApWorkplaceCSQL(), param, param);
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
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void modifyApWorkplace(Object o) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ApWorkplaceVO model = (ApWorkplaceVO)o; 
			
			param.put("wkplc_desc"	, model.getWkplcDesc());
			param.put("inact_dt"	, model.getInactDt());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			param.put("wkplc_nm"	, model.getWkplcNm());
			param.put("upd_usr_id"	, model.getUpdUsrId());
			param.put("upd_dt"		, model.getUpdDt());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			
			int updCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueApWorkplaceDBDAOModifyApWorkplaceUSQL(), param, param);
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
	 * 기존 데이타 유무 확인
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchApWorkplaceList(String pk) throws DAOException{
		
		boolean isSuccessful = false; 
		DBRowSet dRs = null;
		
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("wkplc_nm", pk);
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ReceiveQueueApWorkplaceDBDAOSearchApWorkplaceListRSQL(), param, param);
			
			if(dRs.getRowCount() <= 0){
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
	 * @param o
	 * @return
	 * @throws DAOException
	 */
	public void removeApWorkplace(Object o) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			ApWorkplaceVO model = (ApWorkplaceVO)o; 
			
			param.put("wkplc_nm"	, model.getWkplcNm());
			param.put("eai_evnt_dt"	, model.getEaiEvntDt());
			
			int delCnt = new SQLExecuter("DEFAULT").executeUpdate(new ReceiveQueueApWorkplaceDBDAORemoveApWorkplaceDSQL(), param, param);
			if(delCnt == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to delete SQL");
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