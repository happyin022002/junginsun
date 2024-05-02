/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTClosingDBDAO.java
*@FileTitle : Monthly Target VVD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.07 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.basic.AGTClosingBCImpl;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.EstmPerfRptListVO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRInquiryDetailVO;
import com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.vo.SearchCSRInquiryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.GlEstmRevVvdVO;


/**
 * ALPS AGTClosingDBDAO <br>
 * - ALPS-AGTClosing system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyung-won Chu
 * @see AGTClosingBCImpl 참조
 * @since J2EE 1.6
 */
public class AGTClosingDBDAO extends DBDAOSupport {

	/**
	 * ESM_AGT_0019 : [이벤트]<br>
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param GlEstmRevVvdVO glEstmRevVvdVO
	 * @return List<GlEstmRevVvdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<GlEstmRevVvdVO> searchCommTargetVVD(GlEstmRevVvdVO glEstmRevVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GlEstmRevVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(glEstmRevVvdVO != null){
				Map<String, String> mapVO = glEstmRevVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTClosingDBDAOGlEstmRevVvdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GlEstmRevVvdVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * ESM_AGT_0032 : [이벤트]<br>
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param GlEstmRevVvdVO glEstmRevVvdVO
	 * @return List<GlEstmRevVvdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<GlEstmRevVvdVO> searchAfterClosingList(GlEstmRevVvdVO glEstmRevVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GlEstmRevVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			try{
			if(glEstmRevVvdVO != null){
				Map<String, String> mapVO = glEstmRevVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTClosingDBDAOGlEstmRevVvdVO1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GlEstmRevVvdVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * ESM_AGT_0052 : [이벤트]<br>
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchCSRInquiryVO searchCSRInquiryVO
	 * @return List<SearchCSRInquiryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCSRInquiryVO> searchCSRIquiry(SearchCSRInquiryVO searchCSRInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCSRInquiryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchCSRInquiryVO != null){
				Map<String, String> mapVO = searchCSRInquiryVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTClosingDBDAOSearchCSRInquiryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCSRInquiryVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		/**
		 * ESM_AGT_0053 : [이벤트]<br>
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param SearchCSRInquiryDetailVO searchCSRInquiryDetailVO
		 * @return List<SearchCSRInquiryDetailVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchCSRInquiryDetailVO> searchCSRIquiryDetail(SearchCSRInquiryDetailVO searchCSRInquiryDetailVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchCSRInquiryDetailVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(searchCSRInquiryDetailVO != null){
					Map<String, String> mapVO = searchCSRInquiryDetailVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTClosingDBDAOSearchCSRInquiryDetailRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCSRInquiryDetailVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
			/**
			 * ESM_AGT_0055 : [Retrieve]<br>
			 * [AGT commission의 추정실적]을 [조회]합니다.<br>
			 * 
			 * @param EstmPerfRptListVO estmPerfRptListVO
			 * @return List<EstmPerfRptListVO>
			 * @exception EventException
			 */
			 @SuppressWarnings("unchecked")
			public List<EstmPerfRptListVO> searchEstmPerfRptByRvvd(EstmPerfRptListVO estmPerfRptListVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<EstmPerfRptListVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(estmPerfRptListVO != null){
						Map<String, String> mapVO = estmPerfRptListVO .getColumnValues();
					
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTClosingDBDAOEstmPerfRptListVORSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstmPerfRptListVO .class);
				} catch(SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
			}		 
	 
}