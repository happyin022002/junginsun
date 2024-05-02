/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueArFincDirConvDBDAO.java
 *@FileTitle : NIS2010 Table AR FIN DIR CONV Interface
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
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.common.tableSync.jms.vo.CreateArFincDirConvVO;
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
public class ReceiveQueueArFincDirConvDBDAO extends DBDAOSupport{
	/**
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public int addArFincDirConv(CreateArFincDirConvVO model) throws DAOException {
		int insCnt = 0;
		
		String s_rlane_dir_cd = model.getRlaneDirCd().substring(1,2);
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );
//				mapVO.remove("rlane_dir_cd"); // rlane_dir_cd 처리
				param.put("rlane_dir_cd", s_rlane_dir_cd); // rlane_dir_cd 처리
				velParam.put("rlane_dir_cd", s_rlane_dir_cd);
			}
//			log.info("==============s_rlane_dir_cd================>"+s_rlane_dir_cd);
//			log.info("addArFincDirConv_model================>"+model);
//			log.info("addArFincDirConv_param================>"+param);
//			log.info("addArFincDirConv_velParam================>"+velParam);
			
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArFincDirConvDBDAOCreateArFincDirConvCSQL(),  param, velParam);
				
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
	 * 기존 데이타 유무 검색
	 * @param pk
	 * @return
	 * @throws DAOException
	 */
	public boolean searchArFincDirConv(String slan_cd, String sconti_cd, String slan_dir_cd, String rlane_dir_cd) throws DAOException{			
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("slan_cd", slan_cd);
			param.put("sconti_cd", sconti_cd);
			param.put("slan_dir_cd", slan_dir_cd);
			param.put("rlane_dir_cd", rlane_dir_cd);
			
//			log.info("searchArFincDirConv_slan_cd================>"+slan_cd);
//			log.info("searchArFincDirConv_sconti_cd================>"+param);
//			log.info("searchArFincDirConv_slan_dir_cd================>"+slan_dir_cd);
//			log.info("searchArFincDirConv_rlane_dir_cd================>"+rlane_dir_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueArFincDirConvDBDAOSearchArFincDirConvRSQL(), param, null);

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
	 * Delete
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public int removeArFincDirConv(CreateArFincDirConvVO model) throws DAOException{
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
//			log.info("removeArFincDirConv_model================>"+model);
//			log.info("removeArFincDirConv_param================>"+param);
//			log.info("removeArFincDirConv_velParam================>"+velParam);
			
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArFincDirConvDBDAODeleteArFincDirConvUSQL(),  param, velParam);

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
	 * Delete All
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean removeAllArFincDirConv() throws DAOException{
//		log.info("removeAllArFincDirConv_model================>"+model);
		boolean isSuccessful = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
//			Map<String, String> mapVO = model.getColumnValues();
//			if ( mapVO != null ) {
//				param.putAll( mapVO );
//				velParam.putAll( mapVO );	 
//			}
			param.put("delt_flg", "Y");
			
//			log.info("removeAllArFincDirConv_param================>"+param);
//			log.info("removeAllArFincDirConv_velParam================>"+velParam);
			
//			int delAllCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArFincDirConvDBDAODeleteAllArFincDirConvDSQL(),  param, velParam);
			int delAllCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueArFincDirConvDBDAODeleteAllArFincDirConvDSQL(),  param, null);
			
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
