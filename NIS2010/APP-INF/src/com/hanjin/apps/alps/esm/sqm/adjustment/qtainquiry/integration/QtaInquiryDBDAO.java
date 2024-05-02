/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaInquiryDBDAO.java
*@FileTitle      : QtaInquiryDBDAO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2014.07.30 이혜민 [CHM-201431302] QTA Inquiry_Quarterly Current QTA Report for IAS Sector 에서 Raw Data Export 산출 로직 변경 CSR
* 2015.01.16 이혜민 [CHM-201533644] Raw data Export 보완
* 2015.07.17 김용습 [CHM-201537066] [CSR 전환건] QTA Inquiry_Yearly Current QTA Report for IAS Sector 조회 로직 변경
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.basic.QtaInquiryBCImpl;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchCurrentQtaIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchQuarterlyCurrnetQtaListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.vo.SearchYearlyCurrnetQtaListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS QtaInquiryDBDAO <br>
 * - ALPS-QtaInquiry system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SQM USER
 * @see QtaInquiryBCImpl 참조
 * @since J2EE 1.6
 */
public class QtaInquiryDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_SQM_0036 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchYearlyCurrnetQtaListRSQL(), param, velParam);
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
	 * ESM_SQM_0036 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다. (PreviousVersion)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchYearlyCurrnetQtaListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchYearlyCurrnetQtaListVO> searchYearlyCurrnetQtaListPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchYearlyCurrnetQtaListPreviousVersionRSQL(), param, velParam);
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
	 * ESM_SQM_0036 : Raw Data Export 이벤트 처리<br>
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
	 * ESM_SQM_0036 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Overall (Currently Updated)]을 [조회] 합니다. (PreviousVersion)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownYearlyCurrentQtaPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchYearlyCurrnetQtaListPreviousVersionRSQL(), param, velParam);
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
	 * ESM_SQM_0037 : Retrieve 이벤트 처리<br>
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
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchQuarterlyCurrnetQtaListRSQL(), param, velParam);
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
	 * ESM_SQM_0037 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다. (PreviousVersion)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchQuarterlyCurrnetQtaListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQuarterlyCurrnetQtaListVO> searchQuarterlyCurrnetQtaListPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			log.debug("111111111111111111111eeeeeeeeeeeeeeeeeeeeeeeee1111");
			log.debug("velParamvelParamvelParam22:"+velParam);
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchQuarterlyCurrnetQtaListPreviousVersionRSQL(), param, velParam);
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
	 * ESM_SQM_0037 : Raw Data Export 이벤트 처리<br>
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
	 * ESM_SQM_0037 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Overall]을 [조회] 합니다. (Previous Version)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownQuarterlyCurrentQtaPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchQuarterlyCurrnetQtaListPreviousVersionRSQL(), param, velParam);
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
	 * ESM_SQM_0225: Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (Initially Fixed)<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL(), param, velParam);
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
	 * ESM_SQM_0225: Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptYrIasSectorPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorPreviousVersionYearlyRSQL(), param, velParam);
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
	 * ESM_SQM_0225: Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다. (Currently Updated)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptYrIasSectorCurrentlyUpdated(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaRepIasSectorCurrentlyUpdatedRSQL(), param, velParam);
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
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.(Initially Fixed)<br>
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
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.(Currently Updated)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSectorCurrentlyUpdated(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaRepIasSectorCurrentlyUpdatedRSQL(), param, velParam);
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
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.(Initially Fixed) (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSectorPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorPreviousVersionYearlyRSQL(), param, velParam);
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
	 * ESM_SQM_0225 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Yearly Current QTA Report for IAS Sector]을 [조회] 합니다.(Currently Updated) (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownCurrQtaReptYrIasSectorCurrentlyUpdatedPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorPreviousVersionYearlyRSQL(), param, velParam);
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
	 * ESM_SQM_0226 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorRSQL(), param, velParam);
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
	 * ESM_SQM_0226 : Retrieve 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다. (Previous Version)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return List<SearchCurrentQtaIasSectorVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCurrentQtaIasSectorVO> searchCurrQtaReptQtrIasSectorPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorPreviousVersionQuarterlyRSQL(), param, velParam);
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
	 * ESM_SQM_0226 : Raw Data Export 이벤트 처리<br>
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
	
	/**
	 * ESM_SQM_0226 : Raw Data Export 이벤트 처리<br>
	 * [QTA Inquiry_Quarterly Current QTA Report for IAS Sector]을 [조회] 합니다. (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String excelFlg
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet excelDownCurrQtaReptQtrIasSectorPreviousVersion(ConditionVO conditionVO, String excelFlg) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaInquiryDBDAOSearchCurrQtaReptIasSectorPreviousVersionQuarterlyRSQL(), param, velParam);
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