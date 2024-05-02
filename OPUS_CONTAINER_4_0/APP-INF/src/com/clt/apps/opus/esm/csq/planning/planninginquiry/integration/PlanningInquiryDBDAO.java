/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : PlanningInquiryDBDAO.java
*@FileTitle      : PlanningInquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.29
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.29 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.planninginquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.basic.PlanningInquiryBCImpl;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.vo.SearchPlanningQtaIasSectorVO;
import com.clt.apps.opus.esm.csq.planning.planninginquiry.vo.SearchQtaInquiryListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS QtaInquiryDBDAO <br>
 * - ALPS-QtaInquiry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CSQ USER
 * @see PlanningInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class PlanningInquiryDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_CSQ_0037 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Planning]을 [조회] 합니다
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaInquiryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaInquiryListVO> searchQtaInquiryList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaInquiryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningInquiryDBDAOSearchQtaInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaInquiryListVO .class);
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
	 * ESM_CSQ_0217 : [Retrieve]<br>
 	 * [Planning QTA Inquiry_Yearly Planning_IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPlanningQtaIasSectorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPlanningQtaIasSectorVO> searchPlanningQtaYrIasSector(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPlanningQtaIasSectorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningInquiryDBDAOSearchPlanningQtaIasSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPlanningQtaIasSectorVO .class);
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
	 * ESM_CSQ_0218 : [Retrieve]<br>
	 * [Planning QTA Inquiry_Quarterly Planning_IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPlanningQtaIasSectorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPlanningQtaIasSectorVO> searchPlanningQtaQtrIasSector(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPlanningQtaIasSectorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PlanningInquiryDBDAOSearchPlanningQtaIasSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPlanningQtaIasSectorVO .class);
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