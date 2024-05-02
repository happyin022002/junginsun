/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ITurnTimePerformanceFinderBCDAO.java
 *@FileTitle : Turn Time by Port
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.04.24 박광석
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.basic.TurnTimePerformanceMgtBCImpl;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTMonthlyWeeklyPeriodVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TTSearchOptionInGereralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeInGeneralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnAroundTimeSearchOptionVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMonthlyWeeklyTrendVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByTypeSizeVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.vo.TurnTimeByMvmtCntrListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS TurnTimePerformanceMgtDBDAO <br>
 * - ALPS-CNTROperatioNPerformanceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Prak Kwang Seok
 * @see TurnTimePerformanceMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class TurnTimePerformanceMgtDBDAO extends DBDAOSupport {

	/**
	 * PortTurnTimeListByPort Detail Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByPortDetail(
			TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnTimeByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionIngereralVo != null) {
				Map<String, String> mapVO = tTSearchOptionIngereralVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceFinderBCDAOTTSearchOptionInGereralVODetailRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnTimeByTypeSizeVO.class);
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
	 * PortTurnTimeListByPort Summary Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByPortSummary(
			TTSearchOptionInGereralVO tTSearchOptionIngereralVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnTimeByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionIngereralVo != null) {
				Map<String, String> mapVO = tTSearchOptionIngereralVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceFinderBCDAOTTSearchOptionInGereralVOSummaryRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnTimeByTypeSizeVO.class);
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
	 * TurnTimeListByLaneVVD Summary Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByLaneVVDSummary(
			TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnTimeByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = tTSearchOptionInGereralVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOsearchPortTurnTimeListByLaneVVDSummaryRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnTimeByTypeSizeVO.class);
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
	 * TurnTimeListByLaneVVD Detail Tab을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO
	 * @return List<TurnTimeByTypeSizeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnTimeByTypeSizeVO> searchPortTurnTimeListByLaneVVDDetail(
			TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnTimeByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = tTSearchOptionInGereralVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOsearchPortTurnTimeListByLaneVVDDetailRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnTimeByTypeSizeVO.class);
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
	 * PortTurnTimeVVD List을 조회합니다.<br>
	 * 
	 * @param period
	 * @param from
	 * @param to
	 * @param pol
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchPortTurnTimeLaneList(String period, String from, String to, String pol) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrLane = null;
		try {
			param.put("from", from);
			param.put("to", to);
			param.put("pol", pol);
			velParam.put("period", period);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOsearchPortTurnTimeLaneListRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {

					arrLane = new String[dbRowset.getRowCount()];
				}
				arrLane[i] = dbRowset.getString(1);
				i++;
			}
			// if(arrLane == null){
			// throw new DAOException(new
			// ErrorHandler("CIM21030").getMessage());
			// }

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrLane;
	}

	/**
	 * Yard List을 조회합니다.<br>
	 * 
	 * @param pol
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchYardList(String pol) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrLane = null;
		try {
			param.put("pol", pol);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDDAOsearchYardListRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {

					arrLane = new String[dbRowset.getRowCount()];
				}
				arrLane[i] = dbRowset.getString(1);
				i++;
			}
			// if(arrLane == null){
			// throw new DAOException(new
			// ErrorHandler("CIM21030").getMessage());
			// }

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrLane;
	}
	
	/**
	 * PortTurnTimeVVD List을 조회합니다.<br>
	 * 
	 * @param period
	 * @param from
	 * @param to
	 * @param pol
	 * @param lane
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchPortTurnTimeVVDList(String period, String from, String to, String pol, String lane)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrVvd = null;
		try {
			param.put("from", from);
			param.put("to", to);
			param.put("pol", pol);
			param.put("lane", lane);
			velParam.put("period", period);
			velParam.put("lane", lane);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAODAOsearchPortTurnTimeVVDListRSQL(), param, velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {

					arrVvd = new String[dbRowset.getRowCount()];
				}
				arrVvd[i] = dbRowset.getString(1);
				i++;
			}
			if (arrVvd == null) {
				throw new DAOException(new ErrorHandler("CIM21030").getMessage());
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return arrVvd;
	}

	/**
	 * LocationTurnTime Detail Tab 을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO
	 * @return TurnTimeByMonthlyWeeklyTrendSetVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public TurnTimeByMonthlyWeeklyTrendSetVO searchLocationTurnTimeDetail(
			TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws DAOException {
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;

		TurnTimeByMonthlyWeeklyTrendSetVO list = new TurnTimeByMonthlyWeeklyTrendSetVO();
		List<TurnTimeByMonthlyWeeklyTrendVO> list1 = null;
		List<TTMonthlyWeeklyPeriodVO> list2 = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = tTSearchOptionInGereralVO.getColumnValues();
				String sTpsz = tTSearchOptionInGereralVO.getTpsz();

				List<String> tpszCdList = new ArrayList();
				StringTokenizer st = new StringTokenizer(sTpsz, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}

			dbRowset1 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOsearchLocationTurnTimeDetailRSQL(), param, velParam);
			list1 = (List) RowSetUtil.rowSetToVOs(dbRowset1, TurnTimeByMonthlyWeeklyTrendVO.class);

			dbRowset2 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDAOTTMonthlyWeeklyPeriodRSQL(), param, velParam);
			list2 = (List) RowSetUtil.rowSetToVOs(dbRowset2, TTMonthlyWeeklyPeriodVO.class);

			list.setTurntimebymonthlyweeklytrendvo(list1);
			list.setTtmonthlyweeklyperiodvo(list2);

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
	 * LocationTurnTime Summary Tab 을 조회합니다.<br>
	 * 
	 * @param tTSearchOptionInGereralVO
	 * @return TurnTimeByMonthlyWeeklyTrendSetVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public TurnTimeByMonthlyWeeklyTrendSetVO searchLocationTurnTimeSummary(
			TTSearchOptionInGereralVO tTSearchOptionInGereralVO) throws DAOException {
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;

		TurnTimeByMonthlyWeeklyTrendSetVO list = new TurnTimeByMonthlyWeeklyTrendSetVO();
		List<TurnTimeByMonthlyWeeklyTrendVO> list1 = null;
		List<TTMonthlyWeeklyPeriodVO> list2 = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = tTSearchOptionInGereralVO.getColumnValues();
				String sTpsz = tTSearchOptionInGereralVO.getTpsz();
				List<String> tpszCdList = new ArrayList();
				StringTokenizer st = new StringTokenizer(sTpsz, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}

			dbRowset1 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOsearchLocationTurnTimeSummaryRSQL(), param, velParam);
			list1 = (List) RowSetUtil.rowSetToVOs(dbRowset1, TurnTimeByMonthlyWeeklyTrendVO.class);

			dbRowset2 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDAOTTMonthlyWeeklyPeriodRSQL(), param, velParam);
			list2 = (List) RowSetUtil.rowSetToVOs(dbRowset2, TTMonthlyWeeklyPeriodVO.class);

			list.setTurntimebymonthlyweeklytrendvo(list1);
			list.setTtmonthlyweeklyperiodvo(list2);

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
	 * TurnAroundTimeByTradeLane Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByTradeLane(
			TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnAroundTimeInGeneralVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (turnAroundTimeSearchOptionVO != null) {
				Map<String, String> mapVO = turnAroundTimeSearchOptionVO.getColumnValues();
				String sTpsz = turnAroundTimeSearchOptionVO.getTpsz();

				List<String> tpszCdList = new ArrayList();
				StringTokenizer st = new StringTokenizer(sTpsz, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOTurnAroundTimeInGeneralVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnAroundTimeInGeneralVO.class);
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
	 * TurnAroundTimeByTPSZTrade Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByTPSZTrade(
			TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnAroundTimeInGeneralVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (turnAroundTimeSearchOptionVO != null) {
				Map<String, String> mapVO = turnAroundTimeSearchOptionVO.getColumnValues();
				String sTpsz = turnAroundTimeSearchOptionVO.getTpsz();

				List<String> tpszCdList = new ArrayList();
				StringTokenizer st = new StringTokenizer(sTpsz, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOTurnAroundTimeInGeneral2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnAroundTimeInGeneralVO.class);
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
	 * TurnAroundTimeByLocation Tab 을 조회합니다.<br>
	 * 
	 * @param turnAroundTimeSearchOptionVO
	 * @return List<TurnAroundTimeInGeneralVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnAroundTimeInGeneralVO> searchTurnAroundTimeByLocation(
			TurnAroundTimeSearchOptionVO turnAroundTimeSearchOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnAroundTimeInGeneralVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (turnAroundTimeSearchOptionVO != null) {
				Map<String, String> mapVO = turnAroundTimeSearchOptionVO.getColumnValues();
				String sTpsz = turnAroundTimeSearchOptionVO.getTpsz();

				List<String> tpszCdList = new ArrayList();
				StringTokenizer st = new StringTokenizer(sTpsz, ",");

				while (st.hasMoreTokens()) {
					tpszCdList.add(st.nextToken());
				}

				velParam.put("vel_tpsz_cd", tpszCdList);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOTurnAroundTimeInGeneral3RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnAroundTimeInGeneralVO.class);
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
	 * TurnTimeByMovement 를 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnTimeByTypeSizeVO> searchTurnTimeByMovement(TTSearchOptionInGereralVO tTSearchOptionIngereralVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnTimeByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionIngereralVo != null) {
				Map<String, String> mapVO = tTSearchOptionIngereralVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOTTSearchOptionInGereralVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnTimeByTypeSizeVO.class);
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
	 * TurnTimeByMovementDetail 를 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnTimeByTypeSizeVO> searchTurnTimeByMovementDetail(TTSearchOptionInGereralVO tTSearchOptionIngereralVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnTimeByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionIngereralVo != null) {
				Map<String, String> mapVO = tTSearchOptionIngereralVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOTurnTimeByTypeSizeDetailVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnTimeByTypeSizeVO.class);
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
	 * TurnTimeByMovementDetail 를 조회합니다.<br>
	 * 
	 * @param tTSearchOptionIngereralVo
	 * @return List<TurnTimeByTypeSizeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TurnTimeByMvmtCntrListVO> searchTurnTimeByMvmtCntrList(TTSearchOptionInGereralVO tTSearchOptionIngereralVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<TurnTimeByMvmtCntrListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tTSearchOptionIngereralVo != null) {
				Map<String, String> mapVO = tTSearchOptionIngereralVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TurnTimePerformanceMgtDBDAOsearchTurnTimeByMvmtCntrListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TurnTimeByMvmtCntrListVO.class);
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
