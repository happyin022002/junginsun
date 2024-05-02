/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommCalculationDBDAO.java
*@FileTitle : AGNCommCalculationDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.16 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.basic.AGNCommCalculationBCImpl;
import com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.vo.AGNCommMassCalVO;
import com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationDetailVO;
import com.clt.apps.opus.esm.acm.acmcalculation.agncommcalculation.vo.BkgCalculationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS AGNCommCalculationDBDAO <br>
 * - OPUS-ACMCalculation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see AGNCommCalculationBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AGNCommCalculationDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0012]
	 * Target Booking 목록을 조회<br>
	 *
	 * @param AGNCommMassCalVO agnCommMassCalVO
	 * @return List<AGNCommMassCalVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AGNCommMassCalVO> searchAGNCommMassCalList(AGNCommMassCalVO agnCommMassCalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommMassCalVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommMassCalVO != null) {
				Map<String, String> mapVO= agnCommMassCalVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalculationDBDAOSearchAGNCommMassCalListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommMassCalVO.class);
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
	 * [ESM_ACM_0012] Start Mass Calculation<br>
	 * 대상 Booking 을 Batch 에 입력한다<br>
	 *
	 * @param AGNCommMassCalVO agnCommMassCalVO
	 * @exception DAOException
	 */
	public void manageAGNCommMassCalList(AGNCommMassCalVO agnCommMassCalVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agnCommMassCalVO != null) {
				Map<String, String> mapVO = agnCommMassCalVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AGNCommCalculationDBDAOManageAGNCommMassCalListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0012]
	 * 조회 결과를 Excel 파일 다운로드한다.<br>
	 *
	 * @param AGNCommMassCalVO agnCommMassCalVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAGNCommMassCalExcel(AGNCommMassCalVO agnCommMassCalVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommMassCalVO != null) {
				Map<String, String> mapVO= agnCommMassCalVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalculationDBDAOSearchAGNCommMassCalExcelListRSQL(), param, velParam);
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
	 * [ESM_ACM_9999] BKG Calculation Search<br>
	 * BKG Calculation 목록을 조회<br>
	 *
	 * @param BkgCalculationVO bkgcalculationVO
	 * @return List<BkgCalculationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCalculationVO> searchBkgCalculationList(BkgCalculationVO bkgcalculationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCalculationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkgcalculationVO != null) {
				Map<String, String> mapVO= bkgcalculationVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalculationDBDAOSearchBkgCalculationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCalculationVO.class);
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
	 * [ESM_ACM_0036] Agent Commission Calculation<br>
	 * Agent Commission Calculation Detail 목록을 조회<br>
	 *
	 * @param BkgCalculationDetailVO bkgCalculationDetailVO
	 * @return List<BkgCalculationDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCalculationDetailVO> searchBkgCalculationDetailList(BkgCalculationDetailVO bkgCalculationDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCalculationDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bkgCalculationDetailVO != null) {
				Map<String, String> mapVO= bkgCalculationDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommCalculationDBDAOSearchBkgCalculationDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCalculationDetailVO.class);
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