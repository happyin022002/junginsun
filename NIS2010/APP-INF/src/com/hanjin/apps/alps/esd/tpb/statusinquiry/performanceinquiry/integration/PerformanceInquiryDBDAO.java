/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceInquiryDBDAO.java
*@FileTitle : PerformanceInquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009.07.17 변종건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.basic.PerformanceInquiryBCImpl;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchClosingTPBListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchEACIssuanceListVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.performanceinquiry.vo.SearchNonTPBListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS PerformanceInquiryDBDAO <br>
 * - ALPS-PerformanceInquiryManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jong-Geon Byeon
 * @see PerformanceInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class PerformanceInquiryDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchClosingTPBListVO searchClosingTPBListVO
	 * @return List<SearchClosingTPBListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchClosingTPBListVO> searchClosingTPBList(SearchClosingTPBListVO searchClosingTPBListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchClosingTPBListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchClosingTPBListVO != null){
				Map<String, String> mapVO = searchClosingTPBListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceInquiryDBDAOSearchClosingTPBListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchClosingTPBListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 /**
	  * [처리대상] 정보를 [행위] 합니다.<br>
	  * 
	  * @param SearchNonTPBListVO searchNonTPBListVO
	  * @return List<SearchNonTPBListVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchNonTPBListVO> searchNonTPBList(SearchNonTPBListVO searchNonTPBListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchNonTPBListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchNonTPBListVO != null){
				 Map<String, String> mapVO = searchNonTPBListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceInquiryDBDAOSearchNonTPBListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNonTPBListVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 /**
	  * [처리대상] 정보를 [행위] 합니다.<br>
	  * 
	  * @param SearchEACIssuanceListVO searchEACIssuanceListVO
	  * @return List<SearchEACIssuanceListVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchEACIssuanceListVO> searchEACIssuanceList(SearchEACIssuanceListVO searchEACIssuanceListVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchEACIssuanceListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchEACIssuanceListVO != null){
				 Map<String, String> mapVO = searchEACIssuanceListVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PerformanceInquiryDBDAOSearchEACIssuanceListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEACIssuanceListVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
}