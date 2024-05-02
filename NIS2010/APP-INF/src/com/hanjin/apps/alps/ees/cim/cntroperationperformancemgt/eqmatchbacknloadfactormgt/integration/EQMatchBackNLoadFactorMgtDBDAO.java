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
 * 2010.08.27 남궁진호  [CHM-201005533-01] 조회 조건 추가 (Loc_Loc),searchCargoFlowMapLoc 생성
 * 2010.09.15 이병훈       [CHM-201005967-01] Match-Back by Vessel의 신규 Trade 및 노선 추가
 * 2011.03.17 박명신       [CHM-201109610-01] CIM Location M/B By COA BKG 화면 개발 요청 searchLocationMBByCOABKGData 추가
 * 2012.03.26 신자영 [CHM-201216788-01] M/B 기능 보완 요청
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.CargoFlowMapSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.LoadFactorByTradeLaneVvdVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBDResultCOABKGVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBMonthlyWeeklyPeriodVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionCOABKGVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBTResultCOABKGVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MatchBackByMonthlyWeeklyTrendSetVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MonthToWeekVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.QuantityByTypeSizeVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.ResultByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchBatchJobStatusVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchCargoFlowMapDetailVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchMBByVesselVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByLocationVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByOTRVO;
import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByTradeLaneVvdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS EQMatchBackNLoadFactorFinderDAO <br>
 * - ALPS-CNTROperatioNPerformanceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Myeong Jong Beum
 * @see EQMatchBackNLoadFactorFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class EQMatchBackNLoadFactorMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID 
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
	 * [TMNL M/B By Logistics-Wise By Trend] 정보를 [조회] 합니다.<br>
	 * 
	 * @param mBSearchOptionInGereralVO
	 * @return MatchBackByMonthlyWeeklyTrendSetVO
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public MatchBackByMonthlyWeeklyTrendSetVO searchTmnlMBByLogiticWiseByTrend(
			MBSearchOptionInGereralVO mBSearchOptionInGereralVO) throws DAOException {
		//log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchTmnlMBByLogiticWiseByTrend 시작");

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
					(ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchTmnlMBByLogiticWiseByTrendRSQL(),
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
					if (!arrLocFr[i].equals(""))
					itemlist.add(arrLocFr[i].toUpperCase());		  
				} 
				
				for ( int i = 0; i < arrLocTo.length; i++){
					//if (arrLocTo[i]!="")
					if (!arrLocTo[i].equals(""))
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
	 * [Cargo Flow Map Loc] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchOptionByFromToVO searchOptionByFromToVO
	 * @return List<QuantityByTypeSizeVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<QuantityByTypeSizeVO> searchCargoFlowMapTrend(SearchOptionByFromToVO searchOptionByFromToVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMapTrend 1029 시작");
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
					if (!arrLocFr[i].equals(""))
					itemlist.add(arrLocFr[i].toUpperCase());		  
				} 
				
				for ( int i = 0; i < arrLocTo.length; i++){
					//if (arrLocTo[i]!="")
					if (!arrLocTo[i].equals(""))
					itemlist2.add(arrLocTo[i].toUpperCase());		  
				}
				
				Map<String, String> mapVO = searchOptionByFromToVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrLocFr",itemlist);
				velParam.put("arrLocTo",itemlist2);
				
				//-----------------------------------------------------------------------												
				if (searchOptionByFromToVO.getWeekList() != null && searchOptionByFromToVO.getWeekList().trim().length() > 0) {
					List<String> weekLists = new ArrayList<String>(); 
					 String[] arrayWeeks =  searchOptionByFromToVO.getWeekList().split(",");
					 for(int i = 0; i < arrayWeeks.length; i ++){
						 weekLists.add(arrayWeeks[i]);																			      
					 }
					 param.put("first_wk",arrayWeeks[0]);	
					 param.put("last_wk",arrayWeeks[(arrayWeeks.length - 1)]);		
					 
					 param.put("weekLists",weekLists);  	  	                    
					 velParam.put("weekLists",weekLists); 
				}
				//-----------------------------------------------------------------------
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapLocTrendRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, QuantityByTypeSizeVO.class);
			
			log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMapTrend 1029 list  [" + list.size() + "]");
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMapTrend 1029 끝");
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
	
	/**
	 *  [EES_CIM_1061] Location M/B by COA BKG 를 조회합니다.<br>
	 * 	MBD탭
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return List<MBDResultCOABKGVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception	
	 */			
	@SuppressWarnings("unchecked")
	public List<MBDResultCOABKGVO> searchLocationMBByCOABKGData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MBDResultCOABKGVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if (mBSearchOptionCOABKGVO.getTradeCd() != null && mBSearchOptionCOABKGVO.getTradeCd().trim().length() > 0) {
				List<String> tradeCds = new ArrayList<String>(); 
				 String[] arrayTradeCd =  mBSearchOptionCOABKGVO.getTradeCd().split(",");
				 for(int i = 0; i < arrayTradeCd.length; i ++){	      
					 tradeCds.add(arrayTradeCd[i]);			      
				 }			 			
				 
				 param.put("tradeCds",tradeCds);  	  	                    
				 velParam.put("tradeCds",tradeCds); 
			}
			
			if (mBSearchOptionCOABKGVO.getTpszList() != null && mBSearchOptionCOABKGVO.getTpszList().trim().length() > 0) {
				 List<String> tpSzs = new ArrayList<String>();
				 String[] arrayTpszs =  mBSearchOptionCOABKGVO.getTpszList().split(",");
				 for(int i = 0; i < arrayTpszs.length; i ++){     
					 tpSzs.add(arrayTpszs[i]);		      
				 } 		
				 	
				 param.put("tpSzs",tpSzs);  	  	                    
				 velParam.put("tpSzs",tpSzs);  
			}				
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByCOABKGDataRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MBDResultCOABKGVO.class);
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
	 *  [EES_CIM_1061] Location M/B by COA BKG 를 조회합니다.<br>
	 * 	MBD탭
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return List<MBDResultCOABKGVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception	
	 */			
	@SuppressWarnings("unchecked")
	public List<MBDResultCOABKGVO> searchLocationMBByCOABKGALLData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MBDResultCOABKGVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if (mBSearchOptionCOABKGVO.getTradeCd() != null && mBSearchOptionCOABKGVO.getTradeCd().trim().length() > 0) {
				List<String> tradeCds = new ArrayList<String>(); 
				 String[] arrayTradeCd =  mBSearchOptionCOABKGVO.getTradeCd().split(",");
				 for(int i = 0; i < arrayTradeCd.length; i ++){	      
					 tradeCds.add(arrayTradeCd[i]);			      
				 }			 			
				 
				 param.put("tradeCds",tradeCds);  	  	                    
				 velParam.put("tradeCds",tradeCds); 
			}
			
			if (mBSearchOptionCOABKGVO.getTpszList() != null && mBSearchOptionCOABKGVO.getTpszList().trim().length() > 0) {
				 List<String> tpSzs = new ArrayList<String>();
				 String[] arrayTpszs =  mBSearchOptionCOABKGVO.getTpszList().split(",");
				 for(int i = 0; i < arrayTpszs.length; i ++){     
					 tpSzs.add(arrayTpszs[i]);		      
				 } 		
				 	
				 param.put("tpSzs",tpSzs);  	  	                    
				 velParam.put("tpSzs",tpSzs);  
			}		
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBByCOABKGALLDataRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MBDResultCOABKGVO.class);
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
	 *  [EES_CIM_1061] Location M/B by COA BKG 를 조회합니다.<br>
	 * 	탭별 헤더 리스트 조회		
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return List<MonthToWeekVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception	
	 */			
	@SuppressWarnings("unchecked")	
	public List<MonthToWeekVO> searchMBTPeriodListData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MonthToWeekVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {		
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
				
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchMBTPeriodListDataRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MonthToWeekVO.class);
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
	 *  [EES_CIM_1061] Location M/B by COA BKG 를 조회합니다.<br>
	 * 	MBT탭 	
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return List<MBTResultCOABKGVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception	
	 */			
	@SuppressWarnings("unchecked")
	public List<MBTResultCOABKGVO> searchLocationMBTByCOABKGData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		DBRowSet dbRowset = null;	
		List<MBTResultCOABKGVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if (mBSearchOptionCOABKGVO.getWeekList() != null && mBSearchOptionCOABKGVO.getWeekList().trim().length() > 0) {
				List<String> weekLists = new ArrayList<String>(); 
				 String[] arrayWeeks =  mBSearchOptionCOABKGVO.getWeekList().split(",");
				 for(int i = 0; i < arrayWeeks.length; i ++){
					 weekLists.add(arrayWeeks[i]);																			      
				 }
				 param.put("first_wk",arrayWeeks[0]);	
				 param.put("last_wk",arrayWeeks[(arrayWeeks.length - 1)]);		
				 
				 param.put("weekLists",weekLists);  	  	                    
				 velParam.put("weekLists",weekLists); 
			}
				
			if (mBSearchOptionCOABKGVO.getTpszList() != null && mBSearchOptionCOABKGVO.getTpszList().trim().length() > 0) {
				 List<String> tpSzs = new ArrayList<String>();
				 String[] arrayTpszs =  mBSearchOptionCOABKGVO.getTpszList().split(",");
				 for(int i = 0; i < arrayTpszs.length; i ++){     
					 tpSzs.add(arrayTpszs[i]);		      
				 }	 		
				 
				 param.put("tpSzs",tpSzs);  	  	                    
				 velParam.put("tpSzs",tpSzs);  
			}						
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchLocationMBTByCOABKGDataRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MBTResultCOABKGVO.class);
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
	 * [EES_CIM_1062,EES_CIM_1061] Location POP 데이타 존제여부 체크 <br>
	 *			
	 * @param String userId
	 * @param String searchOption
	 * @return int
	 * @exception DAOException
	 */
	 public int checkLocationPOPData(String userId,String searchOption) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(userId != null){
				 param.put("rqst_user_id", userId);	
				 velParam.put("rqst_user_id", userId); 	
			 }
			 
			 if(!searchOption.equals("ALL")){
				 param.put("use_flg", "Y");
				 velParam.put("use_flg", "Y");  
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOcheckLocationPOPDataRSQL(), param, velParam);
			 		
			 if(dbRowset.next()){
				 cnt = dbRowset.getInt(1); 
			 }
			 	
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cnt;
	 }
	 
	/**
	 *  [EES_CIM_1062] Location POP에서 처음 조회시 데이타를 미리 insert함<br>
	 * @param SearchOptionByLocationVO searchOptionByLocationVO
	 * @return int
	 * @exception DAOException
	 */					
	public int addLocationPOPData(SearchOptionByLocationVO searchOptionByLocationVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = searchOptionByLocationVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);    
				
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOaddLocationPOPDataCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to addLocationPOPData"); 
		} catch (SQLException se) {	 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){	 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return result;	
	}
	
	/**
	 *  [EES_CIM_1062] Location POP에서 처음 조회시 MDM에서 데이타 조회.<br>
	 * @param SearchOptionByLocationVO searchOptionByLocationVO
	 * @return List<ResultByLocationVO>	
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception	
	 */				
	@SuppressWarnings("unchecked")
	public List<ResultByLocationVO> searchLocationFirstPOPData(SearchOptionByLocationVO searchOptionByLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ResultByLocationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			Map<String, String> mapVO = searchOptionByLocationVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchLocationFirstPOPDataRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ResultByLocationVO.class);
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
	 * [EES_CIM_1062] Location POP 에서 데이타 조회<br>
	 * @param SearchOptionByLocationVO searchOptionByLocationVO
	 * @return List<ResultByLocationVO>
	 * @throws DAOException	
	 * @throws SQLException
	 * @throws Exception		
	 */				
	@SuppressWarnings("unchecked")
	public List<ResultByLocationVO> searchLocationPOPData(SearchOptionByLocationVO searchOptionByLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ResultByLocationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {			
			Map<String, String> mapVO = searchOptionByLocationVO.getColumnValues();
				
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchLocationPOPDataRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ResultByLocationVO.class);
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
	 * [EES_CIM_1062] Location POP 데이타를 수정 합니다. <br>
	 *	
	 * @param List<ResultByLocationVO> resultByLocationVOS
	 * @exception DAOException
	 */
	public void modifyLocationPOPData(List<ResultByLocationVO> resultByLocationVOS) throws DAOException,Exception {
		try { 	
			SQLExecuter sqlExe = new SQLExecuter("");  
			int updCnt[] = null;  
			if(resultByLocationVOS.size() > 0){        
				updCnt = sqlExe.executeBatch((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOmodifyLocationPOPDataUSQL(), resultByLocationVOS,null);
				
				for(int i = 0; i < updCnt.length; i++){  
					if(updCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to modify No"+ i + " SQL"); 
				}			  	       
			}		
		} catch (SQLException se) {	
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  [EES_CIM_1061] Location POP을 클리어함 COMMAND02(IBCLEAR) <br><br>
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return int
	 * @exception DAOException
	 */					
	public int clearLocationPOPData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 	
		
		try {	 
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
				
			param.putAll(mapVO); 	  
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOclearLocationPOPDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to clearLocationPOPData"); 
		} catch (SQLException se) {	 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){	 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return result;	
	}
	
	/**
	 * [EES_CIM_1061] 사용자별 조회 옵션을 저장한다. COMMAND04(SaveFormat) <br><br>
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return int
	 * @exception DAOException
	 */					
	public int addFormatMBByCOABKGData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;	 	
			
		try {	 
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
			
			param.putAll(mapVO); 	  
			velParam.putAll(mapVO);	    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOaddFormatMBByCOABKGDataCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to addFormatMBByCOABKGData"); 
		} catch (SQLException se) {		 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){	 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return result;	
	}
	
	/**
	 * [EES_CIM_1061] 사용자별 조회 옵션을 삭제한다. COMMAND04(SaveFormat) <br><br>
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return int
	 * @exception DAOException
	 */					
	public int clearFormatMBByCOABKGData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		//query parameter				
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter			
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;				 		
		
		try {		 
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
				
			param.putAll(mapVO); 	  
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOclearFormatMBByCOABKGDataDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to clearFormatMBByCOABKGData"); 
		} catch (SQLException se) {	 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){	 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return result;	
	}
	
	/**
	 * [EES_CIM_1061] Format저장을 위해 Location을 Copy한다. COMMAND04(SaveFormat) <br><br>
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return int
	 * @exception DAOException
	 */					
	public int copyLocationPOPData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		//query parameter						
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter			
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;				 		
		
		try {		 
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
				
			param.putAll(mapVO); 	  
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOcopyLocationPOPDataCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to copyLocationPOPData"); 
		} catch (SQLException se) {	 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){	 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return result;	
	}
	
	/**
	 * [EES_CIM_1061] Format저장을 위해 Location을 Clear 한다. COMMAND04(SaveFormat) <br><br>
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return int	
	 * @exception DAOException	
	 */					
	public int clearFormatLocationPOPData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		//query parameter						
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter			
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;				 		
		
		try {			 
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
				
			param.putAll(mapVO); 	  
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOclearFormatLocationPOPDataDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to clearFormatLocationPOPData"); 
		} catch (SQLException se) {	 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){	 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return result;	
	}
	
	/**
	 * [EES_CIM_1061] Format저장된 Location을 다시 Copy한다. COMMAND05(RecallFormat) <br><br>
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return int
	 * @exception DAOException
	 */					
	public int copyFORMATLocationPOPData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		//query parameter						
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter			
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;				 		
		
		try {			 
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
			
			param.putAll(mapVO); 	  
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new EQMatchBackNLoadFactorMgtDBDAOcopyFORMATLocationPOPDataCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to copyFORMATLocationPOPData"); 
		} catch (SQLException se) {	 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){	 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return result;	
	}
	
	/**
	 *  [EES_CIM_1061] COMMAND05,RecallFormat<br>
	 * Location M/B by COA-BKG <br>
	 * FORMAT SAVE한 데이타를 조회해온다.	
	 * @param MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO
	 * @return SearchOptionByOTRVO
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception	
	 */			
	@SuppressWarnings("unchecked")
	public SearchOptionByOTRVO searchFormatMBByCOABKGData(MBSearchOptionCOABKGVO mBSearchOptionCOABKGVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchOptionByOTRVO searchOptionByOTRVO = null;
		List<SearchOptionByOTRVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
			Map<String, String> mapVO = mBSearchOptionCOABKGVO.getColumnValues();
			
			param.putAll(mapVO);			
			velParam.putAll(mapVO);		
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOsearchFormatMBByCOABKGDataRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOptionByOTRVO.class);
			
			if(list.size() > 0){
				searchOptionByOTRVO = list.get(0);
			}	
		} catch (SQLException se) {	
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return searchOptionByOTRVO;
	}
	
	/**
	 * [Cargo Flow Map Detail] 정보를 [조회] 합니다.<br>
	 * 
	 * @param SearchOptionByFromToVO searchOptionByFromToVO
	 * @return List<SearchCargoFlowMapDetailVO>
	 * @throws DAOException
	 * @throws SQLException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCargoFlowMapDetailVO> searchCargoFlowMapDetail(SearchOptionByFromToVO searchOptionByFromToVO) throws DAOException {
		log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMapDetail 1030 시작");
		DBRowSet dbRowset = null;
		List<SearchCargoFlowMapDetailVO> list = null;
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
					if (!arrLocFr[i].equals(""))
					itemlist.add(arrLocFr[i].toUpperCase());		  
				} 
				
				for ( int i = 0; i < arrLocTo.length; i++){
					//if (arrLocTo[i]!="")
					if (!arrLocTo[i].equals(""))
					itemlist2.add(arrLocTo[i].toUpperCase());		  
				}
				
				Map<String, String> mapVO = searchOptionByFromToVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("arrLocFr",itemlist);
				velParam.put("arrLocTo",itemlist2);
				
				log.debug("getTpSzLoc = "+searchOptionByFromToVO.getTpSzLoc());
				log.debug("getToLoc = "+searchOptionByFromToVO.getToLoc());
				log.debug("getFromLoc = "+searchOptionByFromToVO.getFromLoc());

				velParam.put("tp_sz_loc",searchOptionByFromToVO.getTpSzLoc());				
				velParam.put("from_loc",searchOptionByFromToVO.getFromLoc());
				velParam.put("to_loc",searchOptionByFromToVO.getToLoc());				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCargoFlowMapDetailVO.class);
			
			log.debug("####### EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMap 1030 list  [" + list.size() + "]");
		
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		log.debug("@@@@@@@ EQMatchBackNLoadFactorMgtDBDAO.searchCargoFlowMapDetail 1030 끝");
		return list;
	}
}