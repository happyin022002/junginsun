/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaInquiryDBDAO.java
*@FileTitle      : QtaInquiryDBDAO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
* 2014.07.30 이혜민 [CHM-201431302] QTA Inquiry_Quarterly Current QTA Report for IAS Sector 에서 Raw Data Export 산출 로직 변경 CSR
* 2015.01.16 이혜민 [CHM-201533644] Raw data Export 보완
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtainquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.basic.QtaInquiryBCImpl;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchCurrentQtaIasSectorVO;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchQuarterlyCurrnetQtaListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtainquiry.vo.SearchYearlyCurrnetQtaListVO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
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
 * @see QtaInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class QtaInquiryDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_CSQ_0057 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchYearlyCurrnetQtaListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchYearlyCurrnetQtaListVO> searchYearlyCurrnetQtaList(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchYearlyCurrnetQtaListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchYearlyCurrnetQtaListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYearlyCurrnetQtaListVO .class);
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
	 * ESM_CSQ_0057 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownYearlyCurrentQta(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (conditionVO != null) {
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchYearlyCurrnetQtaListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * ESM_CSQ_0058 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchQuarterlyCurrnetQtaListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQuarterlyCurrnetQtaListVO> searchQuarterlyCurrnetQtaList(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQuarterlyCurrnetQtaListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchQuarterlyCurrnetQtaListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQuarterlyCurrnetQtaListVO .class);
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
	 * ESM_CSQ_0058 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownQuarterlyCurrentQta(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (conditionVO != null) {
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchQuarterlyCurrnetQtaListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * ESM_CSQ_0223: Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptYrIasSector(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCurrentQtaIasSectorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCurrentQtaIasSectorVO .class);
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
	 * ESM_CSQ_0223 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSector(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (conditionVO != null) {
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * ESM_CSQ_0224 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptQtrIasSector(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCurrentQtaIasSectorVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCurrentQtaIasSectorVO .class);
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
	 * ESM_CSQ_0224 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownCurrQtaReptQtrIasSector(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (conditionVO != null) {
				Map<String, String> mapVO = conditionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
}