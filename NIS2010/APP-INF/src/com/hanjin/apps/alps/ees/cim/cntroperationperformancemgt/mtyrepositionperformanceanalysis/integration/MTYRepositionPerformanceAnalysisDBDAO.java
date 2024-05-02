/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MTYRepositionPerformanceAnalysisDBDAO.java
 *@FileTitle : Repo Result by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.26
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.26 박광석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.basic.MTYRepositionPerformanceAnalysisBCImpl;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFInDailyTrendVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFInDetailVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSearchOptionVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYCNTRPERFSummaryVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYMonthlyWeeklyPeriodVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.MTYMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultInGeneralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo.REPOResultSearchOptionByPortVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS MTYRepositionPerformanceAnalysisDBDAO <br>
 * - ALPS-CNTROperatioNPerformanceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Prak Kwang Seok
 * @see MTYRepositionPerformanceAnalysisBCImpl 참조
 * @since J2EE 1.6
 */
public class MTYRepositionPerformanceAnalysisDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * REPOResultByPort 을 조회 합니다. <br>
	 * 
	 * @param rEPOResultSearchOptionByPortVO
	 * @return List<REPOResultInGeneralVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<REPOResultInGeneralVO> searchREPOResultByPort(
			REPOResultSearchOptionByPortVO rEPOResultSearchOptionByPortVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<REPOResultInGeneralVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rEPOResultSearchOptionByPortVO != null) {
				Map<String, String> mapVO = rEPOResultSearchOptionByPortVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if (rEPOResultSearchOptionByPortVO != null) {
				String directionwise = rEPOResultSearchOptionByPortVO.getDirectionwise();

				if(directionwise.equals("T")) {
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new MTYRepositionPerformanceAnalysisDBDAOREPOResultInGeneralRSQL(), param, velParam);
				}
				else {
					dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new MTYRepositionPerformanceAnalysisDBDAOREPOResultInGeneralFromRSQLRSQL(), param, velParam);
				}
		   }
		 
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, REPOResultInGeneralVO.class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * REPOResultByLocation 을 조회 합니다. <br>
	 * 
	 * @param rEPOResultSearchOptionByLocation
	 * @return List<REPOResultInGeneralVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<REPOResultInGeneralVO> searchREPOResultByLocation(
			REPOResultSearchOptionByLocationVO rEPOResultSearchOptionByLocation) throws DAOException {
		DBRowSet dbRowset = null;
		List<REPOResultInGeneralVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rEPOResultSearchOptionByLocation != null) {
				Map<String, String> mapVO = rEPOResultSearchOptionByLocation.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MTYRepositionPerformanceAnalysisDBDAOsearchREPOResultByLocationRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, REPOResultInGeneralVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * MTYCNTRPERFByMovementSMRY Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @return List<MTYCNTRPERFSummaryVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MTYCNTRPERFSummaryVO> searchMTYCNTRPERFByMovementSMRY(
			MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MTYCNTRPERFSummaryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mTYCNTRPERFSearchOptionVO != null) {
				Map<String, String> mapVO = mTYCNTRPERFSearchOptionVO.getColumnValues();

				String sTpsz = mTYCNTRPERFSearchOptionVO.getTpsz();
				String sLstmcd = mTYCNTRPERFSearchOptionVO.getLstmcd();

				List<String> tpszCdList = new ArrayList();
				List<String> lstmCdList = new ArrayList();
				
				StringTokenizer st = new StringTokenizer(sTpsz, ",");
				StringTokenizer st2 = new StringTokenizer(sLstmcd, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}
				while (st2.hasMoreTokens()) {
					lstmCdList.add(st2.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);
				velParam.put("vel_lstm_cd", lstmCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery((ISQLTemplate) new MTYRepositionPerformanceAnalysisDBDAOMTYCNTRPERFSummaryVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MTYCNTRPERFSummaryVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * MTYCNTRPERFByMovementDTL Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @return List<MTYCNTRPERFInDetailVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MTYCNTRPERFInDetailVO> searchMTYCNTRPERFByMovementDTL(
			MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MTYCNTRPERFInDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mTYCNTRPERFSearchOptionVO != null) {
				Map<String, String> mapVO = mTYCNTRPERFSearchOptionVO.getColumnValues();
				String sTpsz = mTYCNTRPERFSearchOptionVO.getTpsz();
				String sLstmcd = mTYCNTRPERFSearchOptionVO.getLstmcd();

				List<String> tpszCdList = new ArrayList();
				List<String> lstmCdList = new ArrayList();
				
				StringTokenizer st = new StringTokenizer(sTpsz, ",");
				StringTokenizer st2 = new StringTokenizer(sLstmcd, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}
				while (st2.hasMoreTokens()) {
					lstmCdList.add(st2.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);
				velParam.put("vel_lstm_cd", lstmCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MTYRepositionPerformanceAnalysisDBDAOMTYCNTRPERFInDetailVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MTYCNTRPERFInDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * MTYCNTRPERFByMovementTrend Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @return MTYMonthlyWeeklyTrendSetVO
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MTYMonthlyWeeklyTrendSetVO> searchMTYCNTRPERFByMovementTrend(
			MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO) throws DAOException {
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;
		MTYMonthlyWeeklyTrendSetVO list3 = new MTYMonthlyWeeklyTrendSetVO();
		List<MTYMonthlyWeeklyTrendSetVO> list = new ArrayList();

		List<MTYCNTRPERFSummaryVO> list1 = null;
		List<MTYMonthlyWeeklyPeriodVO> list2 = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mTYCNTRPERFSearchOptionVO != null) {
				Map<String, String> mapVO = mTYCNTRPERFSearchOptionVO.getColumnValues();
				String sTpsz = mTYCNTRPERFSearchOptionVO.getTpsz();
				String sLstmcd = mTYCNTRPERFSearchOptionVO.getLstmcd();

				List<String> tpszCdList = new ArrayList();
				List<String> lstmCdList = new ArrayList();
				
				StringTokenizer st = new StringTokenizer(sTpsz, ",");
				StringTokenizer st2 = new StringTokenizer(sLstmcd, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}
				while (st2.hasMoreTokens()) {
					lstmCdList.add(st2.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);
				velParam.put("vel_lstm_cd", lstmCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			dbRowset1 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MTYRepositionPerformanceAnalysisDBDAOMTYMonthlyWeeklyTrendSetVORSQL(), param,
					velParam);
			list1 = (List) RowSetUtil.rowSetToVOs(dbRowset1, MTYCNTRPERFSummaryVO.class);

			dbRowset2 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new MTYRepositionPerformanceAnalysisDBDAOMTYMonthlyWeeklyPeriodVORSQL(), param,
					velParam);
			list2 = (List) RowSetUtil.rowSetToVOs(dbRowset2, MTYMonthlyWeeklyPeriodVO.class);

			list3.setMtycntrperfsummaryvo(list1);
			list3.setMtymonthlyweeklyperiodvo(list2);
			list.add(list3);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * MTYCNTRPERFByMovementDailyTrend Tab 을 조회 합니다. <br>
	 * 
	 * @param mTYCNTRPERFSearchOptionVO
	 * @return List<MTYCNTRPERFInDailyTrendVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MTYCNTRPERFInDailyTrendVO> searchMTYCNTRPERFByMovementDailyTrend(
			MTYCNTRPERFSearchOptionVO mTYCNTRPERFSearchOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MTYCNTRPERFInDailyTrendVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mTYCNTRPERFSearchOptionVO != null) {
				Map<String, String> mapVO = mTYCNTRPERFSearchOptionVO.getColumnValues();

				String sTpsz = mTYCNTRPERFSearchOptionVO.getDtlTpsz();
				String sLstmcd = mTYCNTRPERFSearchOptionVO.getLstmcd();

				List<String> tpszCdList = new ArrayList();
				List<String> lstmCdList = new ArrayList();
				
				StringTokenizer st = new StringTokenizer(sTpsz, ",");
				StringTokenizer st2 = new StringTokenizer(sLstmcd, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}
				while (st2.hasMoreTokens()) {
					lstmCdList.add(st2.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);
				velParam.put("vel_lstm_cd", lstmCdList);

				String sDay = mTYCNTRPERFSearchOptionVO.getDay();
				List<String> dayList = new ArrayList();
				StringTokenizer stt = new StringTokenizer(sDay, ",");

				while (stt.hasMoreTokens()) {
					dayList.add(stt.nextToken());
				}
				
				velParam.put("vDay", dayList);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery((ISQLTemplate) new MTYRepositionPerformanceAnalysisDBDAOMTYCNTRPERFInDailyTrendVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MTYCNTRPERFInDailyTrendVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
}