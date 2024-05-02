/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMdmVndrCntcPntDBDAO.java
 *@FileTitle : NIS2010 Mdm VNDR CNTC PNT Interface
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-21
 *@LastModifier : Sun, Choi
 *@LastVersion : 1.0
 * 2009-09-21 Sun, Choi
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.SearchMdmVndrCntcPntVO;
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
public class ReceiveQueueMdmVndrCntcPntDBDAO extends DBDAOSupport{
	/**
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public int addMdmVndrCntcPnt(SearchMdmVndrCntcPntVO model) throws DAOException {
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
			
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmVndrCntcPntDBDAOCreateMdmVndrCntcPntCSQL(),  param, velParam);		
				
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
	public int modifyMdmVndrCntcPnt(SearchMdmVndrCntcPntVO model) throws DAOException {
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
			
			uptCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmVndrCntcPntDBDAOModifyMdmVndrCntcPntUSQL(),  param, velParam);		

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
	public boolean searchMdmVndrCntcPnt(String vndr_seq, String vndr_cntc_pnt_seq) throws DAOException{
		boolean isSuccessful = false; 		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("vndr_seq", vndr_seq);
			param.put("vndr_cntc_pnt_seq", vndr_cntc_pnt_seq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmVndrCntcPntDBDAOSearchMdmVndrCntcPntRSQL(), param, null);
			
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
	public int removeMdmVndrCntcPnt(SearchMdmVndrCntcPntVO model) throws DAOException{
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
				
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmVndrCntcPntDBDAODeleteMdmVndrCntcPntUSQL(),  param, velParam);			

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
