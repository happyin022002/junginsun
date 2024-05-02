/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmCustRepDBDAO.java
 *@FileTitle : NIS2010 MDM CREDIT CUSTOMER Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-07-05
 *@LastModifier : Sun, Choi
 *@LastVersion : 1.1
 * 2009-09-21 Sun, Choi		1.0 ALPS Migration
 * 2010-07-05 Sun, Choi		1.1 CHM-201004319: EAI_IF_ID 컬럼 추가 요청 처리
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.CreateMdmCustRepVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * @author Sun, Choi
 * @see  
 * @since J2EE 1.6
 */
public class ReceiveQueueMdmCustRepDBDAO extends DBDAOSupport{
	/**
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public int addMdmCustRep(CreateMdmCustRepVO model) throws DAOException {
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
//			log.info("param=============>" + param);
//			log.info("velParam=============>" + velParam);
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCustRepDBDAOCreateMdmCustRepCSQL(),  param, velParam);		
				
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
		
		return insCnt;
	}
	/**
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public int modifyMdmCustRep(CreateMdmCustRepVO model) throws DAOException {
		int uptCnt = 0;
		
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
//			log.info("param=============>" + param);
//			log.info("velParam=============>" + velParam);
			uptCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCustRepDBDAOModifyMdmCustRepUSQL(),  param, velParam);		

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
		
		return uptCnt; 
	}
	
	/**
	 * 기존 데이타 유무 검색
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmCustRep(String cust_cnt_cd, String cust_seq, String ofc_cd, String io_bnd_cd) throws DAOException{
		boolean isSuccessful = false; 		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("cust_cnt_cd", cust_cnt_cd);
			param.put("cust_seq", cust_seq);
			param.put("ofc_cd", ofc_cd);
			param.put("io_bnd_cd", io_bnd_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmCustRepDBDAOSearchMdmCustRepRSQL(), param, null);
			
//			if(dbRowset.next()){
				if(dbRowset.getRowCount() <= 0) isSuccessful = true;
//			}
				
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
	public int removeMdmCustRep(CreateMdmCustRepVO model) throws DAOException{
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
//			log.info("param=============>" + param);
//			log.info("velParam=============>" + velParam);
				
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCustRepDBDAODeleteMdmCustRepUSQL(),  param, velParam);			

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
