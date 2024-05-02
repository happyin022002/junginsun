/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueGlMonXchRtDBDAO.java
 *@FileTitle : NIS2010 Table GL MON XCH RT Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-21
 *@LastModifier : Sun, Choi
 *@LastVersion : 1.0
 * 2009-09-21 Sun, Choi
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.tableSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.common.tableSync.jms.vo.CreateGlMonXchRtVO;
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
public class ReceiveQueueGlMonXchRtDBDAO extends DBDAOSupport{
	/**
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public int addGlMonXchRt(CreateGlMonXchRtVO model) throws DAOException {
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
			
			log.info("addGlMonXchRt_model================>"+model);
			log.info("addGlMonXchRt_param================>"+param);
			log.info("addGlMonXchRt_velParam================>"+velParam);
			
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueGlMonXchRtDBDAOCreateGlMonXchRtCSQL(),  param, velParam);
				
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
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public int modifyGlMonXchRt(CreateGlMonXchRtVO model) throws DAOException {
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
			
//			log.info("modifyGlMonXchRt_model================>"+model);
//			log.info("modifyGlMonXchRt_param================>"+param);
//			log.info("modifyGlMonXchRt_velParam================>"+velParam);
			
			uptCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueGlMonXchRtDBDAOModifyGlMonXchRtUSQL(),  param, velParam);
				
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
	public boolean searchGlMonXchRt(String acct_xch_rt_yrmon, String acct_xch_rt_lvl, String curr_cd) throws DAOException{
		boolean isSuccessful = false; 		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("acct_xch_rt_yrmon", acct_xch_rt_yrmon);
			param.put("acct_xch_rt_lvl",acct_xch_rt_lvl);
			param.put("curr_cd",curr_cd);

//			log.info("searchGlMonXchRt_acct_xch_rt_yrmon================>"+acct_xch_rt_yrmon);
//			log.info("searchGlMonXchRt_acct_xch_rt_lvl================>"+acct_xch_rt_lvl);
//			log.info("searchGlMonXchRt_curr_cd================>"+curr_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueGlMonXchRtDBDAOSearchGlMonXchRtRSQL(), param, null);
			
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
	public int removeGlMonXchRt(CreateGlMonXchRtVO model) throws DAOException{
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
			
//			log.info("searchGlMonXchRt_model================>"+model);
//			log.info("searchGlMonXchRt_param================>"+param);
//			log.info("searchGlMonXchRt_velParam================>"+velParam);
			
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueGlMonXchRtDBDAODeleteGlMonXchRtUSQL(),  param, velParam);

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
