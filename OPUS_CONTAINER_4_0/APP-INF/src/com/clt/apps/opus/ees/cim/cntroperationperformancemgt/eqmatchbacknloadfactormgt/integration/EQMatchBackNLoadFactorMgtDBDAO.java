/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EQMatchBackNLoadFactorMgtDBDAO.java
 *@FileTitle : Location M/B by Logistics-Wise
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2009.05.20 박광석
 * 1.0 Creation
 * =====================================================
 * 2010.08.27 남궁진호 Ticket ID :Ticket ID : CHM-201005533-01
 *            조회 조건 추가 (Loc_Loc),searchCargoFlowMapLoc 생성 
 * 2010.09.15 이병훈 [CHM-201005967-01] Match-Back by Vessel의 신규 Trade 및 노선 추가
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.CargoFlowMapSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.LoadFactorByTradeLaneVvdVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBMonthlyWeeklyPeriodVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MatchBackByMonthlyWeeklyTrendSetVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchBatchJobStatusVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchMBByVesselVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByTradeLaneVvdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS- EQMatchBackNLoadFactorFinderDAO <br>
 * - OPUS--CNTROperatioNPerformanceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Myeong Jong Beum
 * @see EQMatchBackNLoadFactorFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class EQMatchBackNLoadFactorMgtDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [Terminal MatchBack By Logistic Wise] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchTMLMBByLogisticWiseSummary(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchTMLMBByLogisticWiseSummary 1023 시작");
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorFinderDAOMBSearchOptionInGereralVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
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
	 * [Terminal MatchBack By Logistic Wise Detail] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchTMLMBByLogisticWiseDetail(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorFinderDAOQuantityByTypeSizeDetailVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
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
	 * [Lane MatchBack By Logistic Wise] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchLaneMBByLogisticWise(MBSearchOptionInGereralVO mBSearchOptionInGereralVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorFinderDAOQuantityByTypeSizeLaneRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);

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
	 * [Location MatchBack By Logistic Wise Summary] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchLocationMBByLogisticWiseInSummary(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByLogisticWiseInSummary 시작");
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchLocationMBByLogisticRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByLogisticWiseInSummary 끝");
		return list;
	}

	// @SuppressWarnings("unchecked")
	// public List<QuantityByTypeSizeVO>
	// searchTPSZViewYN(MBSearchOptionInGereralVO mBSearchOptionInGereralVO)
	// throws DAOException {
	// log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchTPSZViewYN 시작");
	// DBRowSet dbRowset = null;
	// List<QuantityByTypeSizeVO> list = null;
	// //query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	// //velocity parameter
	// Map<String, Object> velParam = new HashMap<String, Object>();
	//
	// try{
	// if(mBSearchOptionInGereralVO != null){
	// Map<String, String> mapVO = mBSearchOptionInGereralVO .getColumnValues();
	//
	// param.putAll(mapVO);
	// velParam.putAll(mapVO);
	// }
	// dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new
	// EQMatchBackNLoadFactorMgtDBDAOsearchTPSZViewYNRSQL(), param, velParam);
	// list = (List)RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO
	// .class);
	// }catch(SQLException se){
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage());
	// }catch(Exception ex){
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage());
	// }
	// log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchTPSZViewYN 끝");
	// return list;
	// }

	/**
	 * [Location MatchBack By Logistic Wise Detail] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchLocationMBByLogisticWiseInDetail(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByLogisticWiseInDetail 시작");
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByLogisticWiseInSummaryRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByLogisticWiseInSummary 끝");
		return list;
	}

	/**
	 * [Load Factory By Trade] 정보를 [조회] 합니다.<br>
	 * 
	 * @param searchOptionByTradeLaneVvdVO
	 * @return List<LoadFactorByTradeLaneVvdVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<LoadFactorByTradeLaneVvdVO> searchLoadFactorByTrade(
			SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LoadFactorByTradeLaneVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchOptionByTradeLaneVvdVO != null) {
				Map<String, String> mapVO = searchOptionByTradeLaneVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LoadFactorByTradeLaneVvdVO.class);

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
	 * [Load Factory By Trade BSA] 정보를 [조회] 합니다.<br>
	 * 
	 * @param vvd
	 * @param company
	 * @param trade
	 * @param lane
	 * @param fromregion
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public DBRowSet searchLoadFactorByTradeBSA(String vvd, String company, String trade, String lane, String fromregion)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			// param.put("port", port);
			param.put("company", company);
			param.put("trade", trade);
			param.put("lane", lane);
			param.put("fromregion", fromregion);
			velParam.put("gubun", "1");

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdBSAVORSQL(), param,
					velParam);

			if (!dbRowset.next()) {
				velParam.put("gubun", "2");

				dbRowset = new SQLExecuter("").executeQuery(
						(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdBSAVORSQL(), param,
						velParam);
			} else {
				dbRowset.beforeFirst();
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [Load Factory By Trade QTY] 정보를 [조회] 합니다.<br>
	 * 
	 * @param vvd
	 * @param company
	 * @param fromRegion
	 * @param callSeq
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public DBRowSet searchLoadFactorByTradeQTY(String vvd, String company, String fromRegion, String callSeq)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("fromregion", fromRegion);
			param.put("company", company);
			param.put("callSeq", callSeq);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdQTYVORSQL(), param,
					velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [Load Factory By Trade BsaRdr DeadSlot] 정보를 [조회] 합니다.<br>
	 * 
	 * @param vvd
	 * @param company
	 * @param port
	 * @param fromregion
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public DBRowSet searchLoadFactorByTradeBsaRdrDeadSlot(String vvd, String company, String port, String fromregion)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("port", port);
			param.put("company", company);
			param.put("fromregion", fromregion);
			velParam.put("gubun", "1"); // deadSlot을 구함
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdDeadSlotRSQL(), param,
					velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [Load Factory By Trade BsaRdr Teu/Weight] 정보를 [조회] 합니다.<br>
	 * 
	 * @param vvd
	 * @param company
	 * @param port
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public DBRowSet searchLoadFactorByTradeBsaRdrTeu(String vvd, String company, String port) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vvd", vvd);
			param.put("port", port);
			param.put("company", company);
			velParam.put("gubun", "2"); // Teu/Weight를 구함
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOLoadFactorByTradeLaneVvdDeadSlotRSQL(), param,
					velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [Location MatchBack By Logistic Wise By Trend] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return MatchBackByMonthlyWeeklyTrendSetVO
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public MatchBackByMonthlyWeeklyTrendSetVO searchLocationMBByLogisticWiseByTrend(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByLogisticWiseByTrend 시작");

		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;

		MatchBackByMonthlyWeeklyTrendSetVO list = new MatchBackByMonthlyWeeklyTrendSetVO();
		List<QuantityByTypeSizeVO> list1 = null;
		List<MBMonthlyWeeklyPeriodVO> list2 = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();
				String sTpsz = mBSearchOptionInGereralVO.getTpsz();

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
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByLogisticWiseByTrendRSQL(),
					param, velParam);
			list1 = (List) RowSetUtil.rowSetToVOs(dbRowset1, QuantityByTypeSizeVO.class);

			dbRowset2 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOMonthlyWeeklyPeriodRSQL(), param, velParam);
			list2 = (List) RowSetUtil.rowSetToVOs(dbRowset2, MBMonthlyWeeklyPeriodVO.class);

			list.setQuantitybytypesizevo(list1);
			list.setMbmonthlyweeklyperiodvo(list2);

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
	 * [Service Mode MatchBack] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchMBByServiceMode(MBSearchOptionInGereralVO mBSearchOptionInGereralVO)
			throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchMBByServiceMode 시작");
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchMBByServiceModeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchMBByServiceMode 끝");
		return list;
	}

	/**
	 * [Location MatchBack By Booking Wise Summary] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchLocationMBByBKGWiseInSummary(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByBKGWiseInSummary 1027 시작");
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchLocationMBByBKGWiseInSummaryRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByBKGWiseInSummary 1027 끝");
		return list;
	}

	/**
	 * [Location MatchBack By Booking Wise Detail] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchLocationMBByBKGWiseInDetail(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByBKGWiseInDetail 1027 시작");
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchLocationMBByBKGWiseInDetailRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByBKGWiseInDetail 1027 끝");
		return list;
	}

	/**
	 * [Location MatchBack By Booking Wise Trend] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return MatchBackByMonthlyWeeklyTrendSetVO
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public MatchBackByMonthlyWeeklyTrendSetVO searchLocationMBByBKGWiseByTrend(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByBKGWiseByTrend 1027 시작");
		DBRowSet dbRowset1 = null;
		DBRowSet dbRowset2 = null;
		MatchBackByMonthlyWeeklyTrendSetVO list = new MatchBackByMonthlyWeeklyTrendSetVO();
		List<QuantityByTypeSizeVO> list1 = null;
		List<MBMonthlyWeeklyPeriodVO> list2 = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (mBSearchOptionInGereralVO != null) {
				Map<String, String> mapVO = mBSearchOptionInGereralVO.getColumnValues();
				String sTpsz = mBSearchOptionInGereralVO.getTpsz();
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
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByBKGWiseByTrendRSQL(), param,
					velParam);
			list1 = (List) RowSetUtil.rowSetToVOs(dbRowset1, QuantityByTypeSizeVO.class);
			dbRowset2 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOMonthlyWeeklyPeriodRSQL(), param, velParam);
			list2 = (List) RowSetUtil.rowSetToVOs(dbRowset2, MBMonthlyWeeklyPeriodVO.class);
			list.setQuantitybytypesizevo(list1);
			list.setMbmonthlyweeklyperiodvo(list2);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchLocationMBByBKGWiseByTrend 1027 끝");
		return list;
	}

	/**
	 * [Cargo Flow Map] 정보를 [조회] 합니다.<br>
	 * 
	 * @param searchOptionByFromToVO
	 * @return CargoFlowMapSetVO
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public CargoFlowMapSetVO searchCargoFlowMap(SearchOptionByFromToVO searchOptionByFromToVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMap 1029 시작");
		DBRowSet dbRowset = null;
		DBRowSet dbRowset2 = null;
		List<QuantityByTypeSizeVO> list = null;
		List<QuantityByTypeSizeVO> list2 = null;
		CargoFlowMapSetVO list3 = new CargoFlowMapSetVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchOptionByFromToVO != null) {
				Map<String, String> mapVO = searchOptionByFromToVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
			dbRowset2 = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapSumRSQL(), param, velParam);
			list2 = (List) RowSetUtil.rowSetToVOs(dbRowset2, QuantityByTypeSizeVO.class);
			log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMap 1029 list  [" + list.size() + "]");
			log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMap 1029 list2 [" + list2.size() + "]");
			list3.setQuantitybytypesizevo(list);
			list3.setQuantitybytypesizevo2(list2);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMap 1029 끝");
		return list3;
	}
	
	/**
	 * [Cargo Flow Map Loc] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchOptionByFromToVO searchOptionByFromToVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchCargoFlowMapLoc(SearchOptionByFromToVO searchOptionByFromToVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMap 1029 시작");
		DBRowSet dbRowset = null;
		List<QuantityByTypeSizeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchOptionByFromToVO != null) {
				List itemlist = new ArrayList();
				List itemlist2 = new ArrayList();
				
				String[] arrLocFr =searchOptionByFromToVO.getLocation().split("[,]");
				String[] arrLocTo =searchOptionByFromToVO.getLocation2().split("[,]");
				
				for ( int i = 0; i < arrLocFr.length; i++){
					//if (arrLocFr[i]!="")
					if (!"".equals(arrLocFr[i]))
					itemlist.add(arrLocFr[i].toUpperCase());		  
				} 
				
				for ( int i = 0; i < arrLocTo.length; i++){
					//if (arrLocTo[i]!="")
					if (!"".equals(arrLocTo[i]))
					itemlist2.add(arrLocTo[i].toUpperCase());		  
				}
				
				Map<String, String> mapVO = searchOptionByFromToVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrLocFr",itemlist);
				velParam.put("arrLocTo",itemlist2);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
			
			log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMap 1029 list  [" + list.size() + "]");
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMap 1029 끝");
		return list;
	}
	
	/**
	 * [Previous Weeks] 정보를 [조회] 합니다.<br>
	 * 
	 * @param searchOptionByFromToVO
	 * @return List<SearchBatchJobStatusVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBatchJobStatusVO> searchPreviousWeeks(SearchOptionByFromToVO searchOptionByFromToVO)
			throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchPreviousWeeks 1053 시작");
		DBRowSet dbRowset = null;
		List<SearchBatchJobStatusVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchOptionByFromToVO != null) {
				Map<String, String> mapVO = searchOptionByFromToVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchPreviousWeeksRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBatchJobStatusVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchPreviousWeeks 1053 끝");
		return list;
	}

	/**
	 * [Batch Job Status] 정보를 [조회] 합니다.<br>
	 * 
	 * @param searchOptionByFromToVO
	 * @return List<SearchBatchJobStatusVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBatchJobStatusVO> searchBatchJobStatus(SearchOptionByFromToVO searchOptionByFromToVO)
			throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchBatchJobStatus 1053 시작");
		DBRowSet dbRowset = null;
		List<SearchBatchJobStatusVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchOptionByFromToVO != null) {
				Map<String, String> mapVO = searchOptionByFromToVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchBatchJobStatusRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBatchJobStatusVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchBatchJobStatus 1053 끝");
		return list;
	}

	/**
	 * [Vessel MatchBack] 정보를 [조회] 합니다.<br>
	 * 
	 * @param searchOptionByTradeLaneVvdVO
	 * @return List<SearchMBByVessel01VO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMBByVesselVO> searchMBByVessel(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO)
			throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchMBByVessel 1050 시작");
		DBRowSet dbRowset = null;
		List<SearchMBByVesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchOptionByTradeLaneVvdVO != null) {
				Map<String, String> mapVO = searchOptionByTradeLaneVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel01RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchMBByVesselVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchMBByVessel 1050 끝");
		return list;
	}

	/**
	 * [Vessel MatchBack] 정보를 [조회] 합니다.<br>
	 * 
	 * @param trade
	 * @param lane
	 * @param vvd
	 * @param company
	 * @param todate
	 * @param fromdate
	 * @param cltpSeq
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public DBRowSet searchMBByVessel01(String trade, String lane, String vvd, String company, String todate,
			String fromdate, String cltpSeq) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("trade", trade);
			param.put("lane", lane);
			param.put("vvd", vvd); 
			param.put("company", company);
			param.put("todate", todate);
			param.put("fromdate", fromdate);
			param.put("cltpseq", cltpSeq);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel02RSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [Vessel MatchBack] 정보를 [조회] 합니다.<br>
	 * 
	 * @param lane
	 * @param fromdate
	 * @param todate
	 * @param fromrgn
	 * @param torgn
	 * @param company
	 * @return List<SearchMBByVesselVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMBByVesselVO> searchMBByVessel02(String lane, String fromdate, String todate, String fromrgn,
			String torgn, String company) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMBByVesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("fromrgn", fromrgn);
			param.put("lane", lane);
			param.put("torgn", torgn);
			param.put("todate", todate);
			param.put("fromdate", fromdate);
			param.put("company", company);
			velParam.put("lane", lane);

			// dbRowset = new
			// SQLExecuter("").executeQuery((ISQLTemplate)new
			// EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel03RSQL(), param,
			// velParam);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel03RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchMBByVesselVO.class);
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
	 * [Vessel MatchBack BAY] 정보를 [조회] 합니다.<br>
	 * 
	 * @param trade
	 * @param fromdate
	 * @param todate
	 * @param company
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public DBRowSet searchMBByVessel03(String trade, String fromdate, String todate, String company)
			throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchMBByVessel03 1050 시작");
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("trade", trade);
			param.put("fromdate", fromdate);
			param.put("todate", todate);
			param.put("company", company);
			velParam.put("company", company);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel04RSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchMBByVessel03 1050 끝");
		return dbRowset;
	}

	/**
	 * [Vessel MatchBack BKG] 정보를 [조회] 합니다.<br>
	 * 
	 * @param trade
	 * @param clptSeq
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public DBRowSet searchMBByVessel04(String trade, String clptSeq) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchMBByVessel04 1050 시작");
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("trade", trade);
			param.put("lane", Integer.parseInt(clptSeq));

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel05RSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchMBByVessel04 1050 끝");
		return dbRowset;
	}

	/**
	 * [Vessel MatchBack RDR] 정보를 [조회] 합니다.<br>
	 * 
	 * @param vvd
	 * @param port
	 * @param company
	 * @return DBRowSet
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public DBRowSet searchMBByVessel05(String vvd, String port, String company) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchMBByVessel04 1050 시작");
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("vvd", vvd);
			param.put("port", port);
			param.put("company", company);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchMBByVessel06RSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchMBByVessel04 1050 끝");
		return dbRowset;
	}

	/**
	 * [Vessel MatchBack Lane Combo] 정보를 [조회] 합니다.<br>
	 * 
	 * @param searchOptionByTradeLaneVvdVO
	 * @return String[]
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public String[] searchMBByVesselLaneListByTrade(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrLane = null;
		try {
			if (searchOptionByTradeLaneVvdVO != null) {
				Map<String, String> mapVO = searchOptionByTradeLaneVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorFinderDAOSearchMBByVesselLaneListByTradeRSQL(), param,
					velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrLane = new String[dbRowset.getRowCount()];
				}
				arrLane[i] = dbRowset.getString(1);
				i++;
			}
			if (arrLane == null) {
				arrLane = new String[1];
				arrLane[0] = "noData";
			}
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
	 * [Vessel MatchBack VVD Combo] 정보를 [조회] 합니다.<br>
	 * 
	 * @param searchOptionByTradeLaneVvdVO
	 * @return String[]
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public String[] searchMBByVesselVvdListByTradeLane(SearchOptionByTradeLaneVvdVO searchOptionByTradeLaneVvdVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] arrVvd = null;
		try {
			if (searchOptionByTradeLaneVvdVO != null) {
				Map<String, String> mapVO = searchOptionByTradeLaneVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new EQMatchBackNLoadFactorFinderDAOSearchMBByVesselVvdListByTradeLaneRSQL(), param,
					velParam);
			int i = 0;
			while (dbRowset.next()) {
				if (i == 0) {
					arrVvd = new String[dbRowset.getRowCount()];
				}
				arrVvd[i] = dbRowset.getString(1);
				i++;
			}
			if (arrVvd == null) {
				arrVvd = new String[1];
				arrVvd[0] = "noData";
				// throw new DAOException(new
				// ErrorHandler("CIM21030").getMessage());
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
	 * PortMBVVD List을 조회합니다.<br>
	 * 
	 * @param period
	 * @param from
	 * @param to
	 * @param pol
	 * @param lane
	 * @return String[]
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public String[] searchPortMBVVDList(String period, String from, String to, String pol, String lane)
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
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchPortMBVVDListRSQL(), param, velParam);
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
}