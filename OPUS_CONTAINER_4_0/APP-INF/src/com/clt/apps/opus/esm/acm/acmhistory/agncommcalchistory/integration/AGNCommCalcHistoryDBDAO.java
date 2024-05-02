/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalcHistoryDBDAO.java
*@FileTitle : AGNCommCalcHistoryDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.24 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.basic.AGNCommCalcHistoryBCImpl;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo.AGNCommCalcHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.vo.CalcDtlHistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS AGNCommCalcHistoryDBDAO <br>
 * - OPUS-ACMHistory system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see AGNCommCalcHistoryBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AGNCommCalcHistoryDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0016]
	 * Agent Commission Calculation History 목록을 조회<br>
	 *
	 * @param AGNCommCalcHistoryVO agnCommCalcHistoryVO
	 * @return List<AGNCommCalcHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AGNCommCalcHistoryVO> searchAGNCommCalcHistory(AGNCommCalcHistoryVO agnCommCalcHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommCalcHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommCalcHistoryVO != null) {
				Map<String, String> mapVO= agnCommCalcHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchAGNCommCalcHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommCalcHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0116] Retrive<br>
	 * Calculation Detail from History의 Booking Revenue 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlHistoryVO> searchCalcDtlBkgRevenue(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlHistoryVO != null) {
				Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlBkgRevenueListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0116] Retrive<br>
	 * Calculation Detail from History의 Booking Q'ty 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlHistoryVO> searchCalcDtlBkgQty(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlHistoryVO != null) {
				Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlBkgQtyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0116] Retrive<br>
	 * Calculation Detail from History의 Booking Route 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlHistoryVO> searchCalcDtlBkgRoute(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlHistoryVO != null) {
				Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlBkgRouteListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0116] Retrive<br>
	 * Calculation Detail from History의 Charge Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlHistoryVO> searchCalcDtlChgDeduction(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlHistoryVO != null) {
				Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlChgDeductionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0116] Retrive<br>
	 * Calculation Detail from History의 Transportation Cost Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlHistoryVO> searchCalcDtlTrsCstDeduction(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlHistoryVO != null) {
				Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlTrsCstDeductionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0116] Retrive<br>
	 * Calculation Detail from History의 General Commission 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlHistoryVO> searchCalcDtlGeneralComm(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlHistoryVO != null) {
				Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlGeneralCommListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0116] Retrive<br>
	 * Calculation Detail from History의 Container Handling Fee (CHF) 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlHistoryVO> searchCalcDtlCntrHandlingFee(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlHistoryVO != null) {
				Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlCntrHandlingFeeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0116] Retrive<br>
	 * Calculation Detail from History의 T/S Commission 목록을 조회<br>
	 *
	 * @param CalcDtlHistoryVO calcDtlHistoryVO
	 * @return List<CalcDtlHistoryVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlHistoryVO> searchCalcDtlTSCommission(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlHistoryVO != null) {
				Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlTSCommissionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	  * [ESM_ACM_0116] Retrieve<br>
	  * Calculation Detail from History의 T/S Commission 목록을 조회<br>
	  *
	  * @param CalcDtlHistoryVO calcDtlHistoryVO
	  * @return List<CalcDtlHistoryVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CalcDtlHistoryVO> searchCalcDtlCommissionDtl(CalcDtlHistoryVO calcDtlHistoryVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CalcDtlHistoryVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if (calcDtlHistoryVO != null) {
				 Map<String, String> mapVO= calcDtlHistoryVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalcHistoryDBDAOSearchCalcDtlCommissionDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlHistoryVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
}