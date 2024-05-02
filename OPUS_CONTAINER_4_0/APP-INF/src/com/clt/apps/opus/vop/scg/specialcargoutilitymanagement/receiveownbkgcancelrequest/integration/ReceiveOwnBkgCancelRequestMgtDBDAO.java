/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDAO.java
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.04.30 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.basic.ReceiveOwnBkgCancelRequestMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.CxlRqstVO;
import com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo.ScgVvdDgCgoCxlRqstVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/** 
 * ReceiveOwnBkgCancelRequestMgtDBDAO <br>
 *  system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * BKG에서 위험화물에 대한 G6선사의 EDI취소시 SCG의 SCG_VVD_DG_CGO_CXL_RQST에 저장한다. 
 * @author DONG SOO YANG
 * @see ReceiveOwnBkgCancelRequestMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class ReceiveOwnBkgCancelRequestMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * SCG_VVD_DCGO_CXL_RQST_SEQ.NEXTVAL
	 * 
	 * @return int
	 * @throws DAOException
	 */
	public int searchSequence() throws DAOException {
		DBRowSet dbRowset = null;
		int sequence = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveOwnBkgCancelRequestMgtDBDAOSearchSequenceRSQL(), param, velParam);
			if(dbRowset.next()) sequence = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return sequence;
	}
	
	/**
	 * SCG_VVD_DG_CGO_CXL_RQST 데이터를 생성한다.<br>
	 * 
	 * @param ScgVvdDgCgoCxlRqstVO scgVvdDgCgoCxlRqstVO
	 * @exception DAOException
	 */
	public void addScgVvdDgCgoCxlRqst(ScgVvdDgCgoCxlRqstVO scgVvdDgCgoCxlRqstVO) throws DAOException {
		
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = scgVvdDgCgoCxlRqstVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveOwnBkgCancelRequestMgtDBDAOAddScgVvdDgCgoCxlRqstCSQL(), mapVO, velParam);
				
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		//velocity parameter
			
	}
	
	/**
	 * searchDgCgoCnt
	 * 
	 * @param Map<String, String> mapVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchDgCgoCnt(Map<String, String> mapVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		String 		strResult  	= "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.putAll(mapVO);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveOwnBkgCancelRequestMgtDBDAOSearchBkgDgCgoCntRSQL(), param, null);
	    	
			if(dbRowset.next()) {
				strResult = dbRowset.getString(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * searchScgVvdKey
	 * 
	 * @param ScgVvdDgCgoCxlRqstVO scgVvdDgCgoCxlRqstVO
	 * @return List<CxlRqstVO>
	 * @exception DAOException
	 */
	public List<CxlRqstVO> searchScgVvdKey(ScgVvdDgCgoCxlRqstVO scgVvdDgCgoCxlRqstVO) throws DAOException {
		
		DBRowSet 			dbRowset 		= null;
		List<CxlRqstVO> 	rtnCxlRqstVOs	= new ArrayList<CxlRqstVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = scgVvdDgCgoCxlRqstVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveOwnBkgCancelRequestMgtDBDAOSearchScgVvdKeyRSQL(), param, velParam);
	    	rtnCxlRqstVOs	=	(List)RowSetUtil.rowSetToVOs(dbRowset, CxlRqstVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnCxlRqstVOs;
	}
	
	/**
	 * modifyScgVvdDgCgoCxlRqst
	 * 
	 * @param Map<String, String> mapVO
	 * @exception DAOException
	 */
	public void modifyScgVvdDgCgoCxlRqst(Map<String, String> mapVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveOwnBkgCancelRequestMgtDBDAOModifyScgVvdDgCgoCxlRqstCSQL(), mapVO, velParam);
				
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		//velocity parameter
			
	}
	
	/**
	 * modifyScgVvdAproRqst
	 * 
	 * @param CxlRqstVO cxlRqstVO
	 * @exception DAOException
	 */
	public void modifyScgVvdAproRqst(CxlRqstVO cxlRqstVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			SQLExecuter sqlExe 		= new SQLExecuter("");
			int 		result 		= 0;
			
			Map<String, String> mapVO = cxlRqstVO.getColumnValues();
			
			param.putAll(mapVO);
			
			if(cxlRqstVO != null){
				result = sqlExe.executeUpdate((ISQLTemplate)new ReceiveOwnBkgCancelRequestMgtDBDAOModifyScgVvdAproRqstCSQL(), mapVO, null);
			}
			
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
