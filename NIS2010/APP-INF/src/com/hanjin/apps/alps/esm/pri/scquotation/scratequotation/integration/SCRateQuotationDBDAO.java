/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateQuotationDBDAO.java
*@FileTitle : S/C Quotation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.29 송민석
* 1.0 Creation
=========================================================
* History
* 2011.06.29 김민아 [CHM-201111837] Split 20-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건 : DUAL Table을 부적절하게 사용한 DBDAO의 SQL을 .Query로 이동
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltPriSqMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.basic.SCRateQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.InPriLocationViaListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtAllViewVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtCmdtRoutVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtCmdtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtRoutPntVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtRoutViaVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSqRtVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltPrsSurchargeDetailVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSqHdrVO;
import com.hanjin.syscommon.common.table.PriSqMnVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSqRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSqRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSqRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSqRtScgVO;
import com.hanjin.syscommon.common.table.PriSqRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriSqRtVO;
import com.hanjin.syscommon.common.table.PriSqScgAdjVO;


/**
 * ALPS SCRateQuotationDBDAO <br>
 * - ALPS-SCQuotation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SONG MIN SEOK
 * @see SCRateQuotationBCImpl 참조
 * @since J2EE 1.6
 */
public class SCRateQuotationDBDAO extends DBDAOSupport {
 

	/**
	 * CM/OP 산출 이후, Rout별 적용된 Surcharge 상세정보 확인하는 Surcharge Detail 데이터<br>
	 * 
	 * @param inpPrsSurchargeDetailApplicableRouteVO InpPrsSurchargeDetailApplicableRouteVO
	 * @return List<RsltPrsSurchargeDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPrsSurchargeDetailVO> searchSurchargeDetailList(
			InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPrsSurchargeDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inpPrsSurchargeDetailApplicableRouteVO != null) {
				Map<String, String> mapVO = inpPrsSurchargeDetailApplicableRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPrsSurchargeDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPrsSurchargeDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * CM/OP 산출 이후, Rout별 적용된 Surcharge 상세정보 확인하는 Applicable Route 데이터<br>
	 * 
	 * @param rsltPriSqRtScgVO InpPrsSurchargeDetailApplicableRouteVO
	 * @return List<RsltPrsSurchargeDetailApplicableRouteVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPrsSurchargeDetailApplicableRouteVO> searchSurchargeList(
			InpPrsSurchargeDetailApplicableRouteVO rsltPriSqRtScgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPrsSurchargeDetailApplicableRouteVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSqRtScgVO != null) {
				Map<String, String> mapVO = rsltPriSqRtScgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPrsSurchargeDetailApplicableRouteRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPrsSurchargeDetailApplicableRouteVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	

	/**
	 * RFA Surchage값을 (pri_sq_rt_scg) 추가합니다.<br>
	 * 
	 * @param insModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void addRateSurcharge(List<PriSqRtScgVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtScgVOCSQL(), insModels,	null);                                  
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Surchage값을 (pri_sq_rt_scg) 수정합니다.<br>
	 * 
	 * @param updModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void modifyRateSurcharge(List<PriSqRtScgVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtScgVOUSQL(), updModels,
						null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RFA Surchage값을 (pri_sq_rt_scg) 삭제합니다.<br>
	 * 
	 * @param delModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void removeRateSurcharge(List<PriSqRtScgVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtScgVODSQL(), delModels,
						null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	


	/**
	 * PRS- Cost Detail List 조회 처리<br>
	 * 
	 * @param rsltPriPrsCostListVO RsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriPrsCostListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriPrsCostListVO != null) {
				Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriPrsCostListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriPrsCostListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * PRS- Cost Detail 상세 조회 처리<br>
	 * 
	 * @param rsltPriPrsCostDetailVO RsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriPrsCostDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriPrsCostDetailVO != null) {
				Map<String, String> mapVO = rsltPriPrsCostDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriPrsCostDetailVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriPrsCostDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 

	/**
	 * CM/OP 산출 이후, Rout별 적용된 Surcharge 상세정보 확인하는 Applicable Route 데이터<br>
	 * 
	 * @param rsltPriSurchargeAdjustListVO RsltPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(
			RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeAdjustListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSurchargeAdjustListVO != null) {
				Map<String, String> mapVO = rsltPriSurchargeAdjustListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriSurchargeAdjustListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSurchargeAdjustListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * S/C Surchage 조정값을 추가한다.<br>
	 * 
	 * @param insModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void addSurchargeAdjust(List<PriSqScgAdjVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqScgAdjVOCSQL(), insModels,
						null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * S/C Surchage 조정값을 수정한다.<br>
	 * 
	 * @param updModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void modifySurchargeAdjust(List<PriSqScgAdjVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqScgAdjVOUSQL(), updModels,
						null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * S/C Surchage 조정값을 삭제한다.<br>
	 * 
	 * @param delModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void removeSurchargeAdjust(List<PriSqScgAdjVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqScgAdjVODSQL(), delModels,
						null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Surcharge Adjust-Commodity Group 데이터 조회
	 * 
	 * @param rsltPriSurchargeAdjustCommodityVO RsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(
			RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeAdjustCommodityVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSurchargeAdjustCommodityVO != null) {
				Map<String, String> mapVO = rsltPriSurchargeAdjustCommodityVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriSurchargeAdjustCommodityVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSurchargeAdjustCommodityVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회
	 * 
	 * @param rsltPriSurchargeAdjustCommodityVO RsltPriSurchargeAdjustCommodityDetailVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(
			RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeAdjustCommodityDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSurchargeAdjustCommodityVO != null) {
				Map<String, String> mapVO = rsltPriSurchargeAdjustCommodityVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriSurchargeAdjustCommodityDetailVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSurchargeAdjustCommodityDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Surcharge Adjust-Location 데이터
	 * 
	 * @param rsltPriSurchargeAdjustLocationVO RsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(
			RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeAdjustLocationGroupVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSurchargeAdjustLocationVO != null) {
				Map<String, String> mapVO = rsltPriSurchargeAdjustLocationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriSurchargeAdjustLocationGroupVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSurchargeAdjustLocationGroupVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Surcharge Adjust-Location 데이터
	 * 
	 * @param rsltPriSurchargeAdjustLocationVO RsltPriSurchargeAdjustLocationGroupDetailVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeAdjustLocationGroupDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSurchargeAdjustLocationVO != null) {
				Map<String, String> mapVO = rsltPriSurchargeAdjustLocationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriSurchargeAdjustLocationGroupDetailVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSurchargeAdjustLocationGroupDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}


	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * 
	 * @param rsltPriRateCmViewAllVO RsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @throws DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRateCmViewAllVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(rsltPriRateCmViewAllVO != null){
				Map<String, String> mapVO = rsltPriRateCmViewAllVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriRateCmViewAllVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRateCmViewAllVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}			
	/**
	 * S/C RATE(PRI_SQ_RT_CMDT_ROUT)의 load 값을  갱신처리 합니다.
	 * 
	 * @param updModels List<PriSqRtCmdtRoutVO> 데이터객체 배열
	 * @param pfmcUnit String
	 * @throws DAOException
	 */
	public void modifyPrsPfmc(List<PriSqRtCmdtRoutVO> updModels,String pfmcUnit) throws DAOException, Exception {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("pfmc_unit", pfmcUnit);			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtCmdtRoutPfmcVOUSQL(), updModels,
						velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	

	/**
	 * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
	 * 
	 * @param rsltPriCostDetailByTransModeListVO RsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @throws DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCostDetailByTransModeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(rsltPriCostDetailByTransModeListVO != null){
				Map<String, String> mapVO = rsltPriCostDetailByTransModeListVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriCostDetailByTransModeListVORSQL(), param, velParam);		
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriCostDetailByTransModeListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		
	
	
	
	
/////////////////////////////////////////////////////SQ RATE MAIN//////////////////////////////////////////////////////////////
	
	/**
	 * PRI_SQ_RT_CMDT_HDR SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriSqRtCmdtHdrMaxSeq(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtHdrVO != null){
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriSqRtCmdtMaxSeq(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtHdrVO != null){
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriSqRtCmdtRoutMaxSeq(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtHdrVO != null){
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_PNT SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqRtRoutPntVO priSqRtRoutOrgPntVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriSqRtRoutPntMaxSeq(PriSqRtRoutPntVO priSqRtRoutOrgPntVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtRoutOrgPntVO != null){
				Map<String, String> mapVO = priSqRtRoutOrgPntVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_VIA SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqRtRoutViaVO priSqRtRoutOrgViaVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriSqRtRoutViaMaxSeq(PriSqRtRoutViaVO priSqRtRoutOrgViaVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtRoutOrgViaVO != null){
				Map<String, String> mapVO = priSqRtRoutOrgViaVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}
	
	
	/**
	 * PRI_SQ_RT SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriSqRtMaxSeq(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priSqRtCmdtRoutVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}
	
	
	/**
	 * CMDT_HDR_SEQ 별 Cmdt Grp 한줄로 합해서 조회.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqRtCmdtVO> searchPriSqRtCmdtGrpList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtHdrVO != null){
				Map<String, String> mapVO = priSqRtCmdtHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtGrpListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtCmdtVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * Rate 정보를 조회 합니다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return List<RsltPriSqRtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqRtVO> searchPriSqRtVOList(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriSqRtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * [PRI_SQ_RT_ROUT_PNT 테이블을 조회한다.(ORIGIN별)<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return List<RsltPriSqRtRoutPntVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqRtRoutPntVO> searchPriSqRtRoutOrgPntVOList(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtRoutPntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriSqRtRoutOrgPntVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtRoutPntVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 /**
	 * PRI_SQ_RT_ROUT_PNT 테이블을 조회한다.(DEST별)<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return List<RsltPriSqRtRoutPntVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqRtRoutPntVO> searchPriSqRtRoutDestPntVOList(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtRoutPntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriSqRtRoutDestPntVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtRoutPntVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * PRI_SQ_RT_CMDT 테이블을 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return List<RsltPriSqRtCmdtVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqRtCmdtVO> searchPriSqRtCmdtVOList(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtCmdtVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriSqRtCmdtVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtCmdtVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블을 조회한다(ORIGIN별).<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return List<RsltPriSqRtRoutViaVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqRtRoutViaVO> searchPriSqRtRoutOrgViaVOList(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtRoutViaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriSqRtRoutOrgViaVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtRoutViaVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 /**
	 * PRI_SQ_RT_ROUT_VIA 테이블을 조회한다(DEST별).<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return List<RsltPriSqRtRoutViaVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqRtRoutViaVO> searchPriSqRtRoutDestViaVOList(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtRoutViaVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtRoutVO != null){
				Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriSqRtRoutDestViaVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtRoutViaVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	/**
	 * ROUTE LIST 별 PRI_SQ_RT_ROUT_PNT, PRI_SQ_RT_ROUT_VIA 정보를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtCmdtRoutVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RsltPriSqRtCmdtRoutVO> searchPriSqRtCmdtRoutVOList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtCmdtRoutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSqRtCmdtHdrVO != null){
				Map<String, String> mapVO = priSqRtCmdtHdrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCRateQuotationDBDAORsltPriSqRtCmdtRoutVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtCmdtRoutVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * PRI_SQ_RT_CMDT 테이블을 등록한다.<br>
	 * 
	 * @param PriSqRtCmdtVO priSqRtCmdtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScQuotationCommodity(PriSqRtCmdtVO priSqRtCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSqRtCmdtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_SQ_RT_CMDT 테이블에 Gline 정보를 copy한다.t<br>
	 * 
	 * @param rsltPriSqMnVO RsltPriSqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyScQuotationCommodity(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVOAddGlineCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_SQ_RT_CMDT 테이블을 수정한다.<br>
	 * 
	 * @param PriSqRtCmdtVO priSqRtCmdtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationCommodity(PriSqRtCmdtVO priSqRtCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_RT_CMDT 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtVO priSqRtCmdtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationCommodity(PriSqRtCmdtVO priSqRtCmdtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT 테이블 cmdt hdr seq별 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationCommodity(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * PRI_SQ_RT_CMDT 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqRtCmdtVO> priSqRtCmdtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScQuotationCommodityS(List<PriSqRtCmdtVO> priSqRtCmdtVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVOCSQL(), priSqRtCmdtVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_SQ_RT_CMDT 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqRtCmdtVO> priSqRtCmdtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScQuotationCommodityS(List<PriSqRtCmdtVO> priSqRtCmdtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVOUSQL(), priSqRtCmdtVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_SQ_RT_CMDT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqRtCmdtVO> priSqRtCmdtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScQuotationCommodityS(List<PriSqRtCmdtVO> priSqRtCmdtVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVODSQL(), priSqRtCmdtVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_HDR 테이블을 등록한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScQuotationCommodityHeader(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSqRtCmdtHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_HDR 테이블에 Gline 정보를 copy 한다.<br>
	 * 
	 * @param rsltPriSqMnVO RsltPriSqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyScQuotationCommodityHeader(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVOAddGlineCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_HDR 테이블을 수정한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationCommodityHeader(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_RT_CMDT_HDR 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationCommodityHeader(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_SQ_RT_CMDT_HDR 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqRtCmdtHdrVO> priSqRtCmdtHdrVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScQuotationCommodityHeaderS(List<PriSqRtCmdtHdrVO> priSqRtCmdtHdrVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtHdrVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVOCSQL(), priSqRtCmdtHdrVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_SQ_RT_CMDT_HDR 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqRtCmdtHdrVO> priSqRtCmdtHdrVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScQuotationCommodityHeaderS(List<PriSqRtCmdtHdrVO> priSqRtCmdtHdrVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtHdrVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVOUSQL(), priSqRtCmdtHdrVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_SQ_RT_CMDT_HDR 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqRtCmdtHdrVO> priSqRtCmdtHdrVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScQuotationCommodityHeaderS(List<PriSqRtCmdtHdrVO> priSqRtCmdtHdrVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtHdrVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVODSQL(), priSqRtCmdtHdrVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	
	
	/**
	 * PRI_SQ_RT 테이블을 등록한다.<br>
	 * 
	 * @param PriSqRtVO priSqRtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScQuotationRate(PriSqRtVO priSqRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSqRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_SQ_RT 테이블을 수정한다.<br>
	 * 
	 * @param PriSqRtVO priSqRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationRate(PriSqRtVO priSqRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_RT 테이블을 삭제한다.<br>
	 * 
	 * @param priSqRtVO PriSqRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRate(PriSqRtVO priSqRtVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT 테이블 Rout seq별 또는 Cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRate(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_USD_ROUT_CS 테이블 Rout seq별 또는 Cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRateUsedRouteCase(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtUsdRoutCsAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_SCG 테이블 Rout seq별 또는 Cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRateSurcharge(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_SCG_ROUT 테이블 Rout seq별 또는 Cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRateSurchargeRoute(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgRoutAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * PRI_SQ_RT 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqRtVO> priSqRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScQuotationRateS(List<PriSqRtVO> priSqRtVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVOCSQL(), priSqRtVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_SQ_RT 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqRtVO> priSqRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScQuotationRateS(List<PriSqRtVO> priSqRtVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVOUSQL(), priSqRtVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_SQ_RT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqRtVO> priSqRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScQuotationRateS(List<PriSqRtVO> priSqRtVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVODSQL(), priSqRtVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블을 등록한다.<br>
	 * 
	 * @param PriSqRtRoutViaVO priSqRtRoutViaVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScQuotationRouteVia(PriSqRtRoutViaVO priSqRtRoutViaVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSqRtRoutViaVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블을 수정한다.<br>
	 * 
	 * @param PriSqRtRoutViaVO priSqRtRoutViaVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationRouteVia(PriSqRtRoutViaVO priSqRtRoutViaVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtRoutViaVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqRtRoutViaVO priSqRtRoutViaVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRouteVia(PriSqRtRoutViaVO priSqRtRoutViaVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtRoutViaVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블 Rout seq or cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRouteVia(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	

	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqRtRoutViaVO> priSqRtRoutViaVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScQuotationRouteViaS(List<PriSqRtRoutViaVO> priSqRtRoutViaVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtRoutViaVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVOCSQL(), priSqRtRoutViaVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqRtRoutViaVO> priSqRtRoutViaVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScQuotationRouteViaS(List<PriSqRtRoutViaVO> priSqRtRoutViaVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtRoutViaVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVOUSQL(), priSqRtRoutViaVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqRtRoutViaVO> priSqRtRoutViaVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScQuotationRouteViaS(List<PriSqRtRoutViaVO> priSqRtRoutViaVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtRoutViaVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVODSQL(), priSqRtRoutViaVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_PNT 테이블을 등록한다..<br>
	 * 
	 * @param PriSqRtRoutPntVO priSqRtRoutPntVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScQuotationRoutePoint(PriSqRtRoutPntVO priSqRtRoutPntVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSqRtRoutPntVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_SQ_RT_ROUT_PNT 테이블을 수정한다.<br>
	 * 
	 * @param PriSqRtRoutPntVO priSqRtRoutPntVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationRoutePoint(PriSqRtRoutPntVO priSqRtRoutPntVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtRoutPntVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_RT_ROUT_PNT 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqRtRoutPntVO priSqRtRoutPntVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRoutePoint(PriSqRtRoutPntVO priSqRtRoutPntVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtRoutPntVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_PNT 테이블 Rout seq or cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRoutePoint(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_SQ_RT_ROUT_PNT 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqRtRoutPntVO> priSqRtRoutPntVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScQuotationRoutePointS(List<PriSqRtRoutPntVO> priSqRtRoutPntVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtRoutPntVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntVOCSQL(), priSqRtRoutPntVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_SQ_RT_ROUT_PNT 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqRtRoutPntVO> priSqRtRoutPntVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScQuotationRoutePointS(List<PriSqRtRoutPntVO> priSqRtRoutPntVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtRoutPntVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntVOUSQL(), priSqRtRoutPntVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_SQ_RT_ROUT_PNT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqRtRoutPntVO> priSqRtRoutPntVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScQuotationRoutePointS(List<PriSqRtRoutPntVO> priSqRtRoutPntVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtRoutPntVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntVODSQL(), priSqRtRoutPntVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT 테이블을 등록한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addScQuotationCommodityRoute(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT 테이블을 수정한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyScQuotationCommodityRoute(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT 테이블을 삭제한다.<br>
	 * 
	 * @param PriSqRtCmdtRoutVO priSqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationCommodityRoute(PriSqRtCmdtRoutVO priSqRtCmdtRoutVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqRtCmdtRoutVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_SQ_RT_CMDT_ROUT 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriSqRtCmdtRoutVO> priSqRtCmdtRoutVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addScQuotationCommodityRouteS(List<PriSqRtCmdtRoutVO> priSqRtCmdtRoutVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtRoutVO .size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutVOCSQL(), priSqRtCmdtRoutVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	/**
	 * PRI_SQ_RT_CMDT_ROUT 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriSqRtCmdtRoutVO> priSqRtCmdtRoutVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyScQuotationCommodityRouteS(List<PriSqRtCmdtRoutVO> priSqRtCmdtRoutVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtRoutVO .size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutVOUSQL(), priSqRtCmdtRoutVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriSqRtCmdtRoutVO> priSqRtCmdtRoutVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeScQuotationCommodityRouteS(List<PriSqRtCmdtRoutVO> priSqRtCmdtRoutVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(priSqRtCmdtRoutVO .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutVODSQL(), priSqRtCmdtRoutVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	
	/**
	 * Quotaion의 route 리스트 데이터 를 조회한다.<br>
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCommodityRoutePntAreaList(
			InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriCommodityRouteVO != null) {
				Map<String, String> mapVO = inPriCommodityRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriCommodityRoutePntAreaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	

	/**
	 * Quotaion의 route 리스트 데이터 
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCommodityRouteTermAreaList(
			InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriCommodityRouteVO != null) {
				Map<String, String> mapVO = inPriCommodityRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriCommodityRouteTermAreaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	/**
	 * Quotaion의 route 리스트 데이터 
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCommodityRouteViaAreaList(
			InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriCommodityRouteVO != null) {
				Map<String, String> mapVO = inPriCommodityRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriCommodityRouteViaAreaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * Quotaion의 route 리스트 데이터 
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltPriCommodityRouteVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriCommodityRouteVO> searchCommodityRouteList(
			InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCommodityRouteVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriCommodityRouteVO != null) {
				Map<String, String> mapVO = inPriCommodityRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriCommodityRouteVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriCommodityRouteVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}		
	
	/**
	 * Quotaion의 route 리스트 데이터 
	 * 
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSCQuotationCreationDate(
			InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inPriCommodityRouteVO != null) {
				Map<String, String> mapVO = inPriCommodityRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriQuotationCreationDateVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT 테이블에 Gline 정보를 copy한다.<br>
	 * 
	 * @param rsltPriSqMnVO RsltPriSqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyScQuotationCommodityRoute(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutVOAddGlineCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_PNT 테이블에 Gline 정보를 copy 한다.<br>
	 * 
	 * @param rsltPriSqMnVO RsltPriSqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyScQuotationRoutePoint(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntVOAddGlineCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블에 Gline 정보를 COPY 한다.<br>
	 * 
	 * @param rsltPriSqMnVO RsltPriSqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyScQuotationRouteVia(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVOAddGlineCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_RT 테이블에 Gline 정보를 COPY 한다.<br>
	 * 
	 * @param rsltPriSqMnVO RsltPriSqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyScQuotationRate(RsltPriSqMnVO rsltPriSqMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSqMnVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVOAddGlineCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_RT_CMDT_HDR<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScQuotationCommodityHeader(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_RT_CMDT<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScQuotationCommodity(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_RT_CMDT_ROUT<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScQuotationCommodityRoute(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_RT_ROUT_PNT<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScQuotationRoutePoint(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_RT_ROUT_VIA<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScQuotationRouteVia(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * COPY TO QUOTATION PRI_SQ_RT<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationScQuotationRate(RsltCopyToQuotationVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVOAddCopyToQuotationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	
	/**
	 * Rate Quotation(PRI_SQ_RT)의 Rate값을 매칭 룰에 의해 매칭된 row에 대해 갱신하고<BR>
	 * 그 갱신 여부를 마크 해 둔다.<BR>
	 * 
	 * @param updModels 데이터객체 배열
	 * @param inPriCommodityRouteVO InPriCommodityRouteVO
	 * @throws DAOException
	 */
	public void modifyRateScQuotation(List<InPriLocationViaListVO>  updModels,InPriCommodityRouteVO inPriCommodityRouteVO ) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			velParam.put("list_obj", updModels);
			
			if (inPriCommodityRouteVO != null) {
				Map<String, String> mapVO = inPriCommodityRouteVO.getColumnValues();
				param.putAll(mapVO);
				
			}
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtAdjustUSQL(), param,
					velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No" + 1 + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Quotaion rate View All LIST를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSqRtAllViewVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSqRtAllViewVO> searchViewAllSCRateQuotationList(
			PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSqRtAllViewVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriSqRtAllViewRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSqRtAllViewVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	
	
	/**
	 * Quotaion rate View All LIST를 조회한다.<br>
	 * 
	 * @param PriSqMnVO priSqMnVO
	 * @return List<RsltPriSqRtAllViewVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSqMnVO> searchPriSqMn(
			PriSqMnVO priSqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSqMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSqMnVO != null) {
				Map<String, String> mapVO = priSqMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriSqMnVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSqMnVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * 사용자가 해당 값의 선택여부를(PRI_RQ_RT_USD_ROUT_CS) 수정처리.<br>
	 * 
	 * @param updModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
	 
			int updCnt[] = null;
			if (updModels.size() > 0) {
				
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtUsdRoutCsFlagVOUSQL(), updModels,
						null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 * CMPB,OPB값을 수정한다.
	 * 
	 * @param updModels 데이터객체 배열
	 * @throws DAOException
	 */
	public void modifyRate(List<RsltPriPrsCostListVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (updModels.size() > 0) {
				velParam.put("cost_tp",(updModels.get(0)).getCostTp());
				
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtCostVOUSQL(), updModels,
						velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_HDR 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationCommodityHeader(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtHdrVODeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationCommodity(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtDeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_CMDT_ROUT 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationCommodityRoute(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutDeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_PNT 태아블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param priSqHdrVO PriSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRoutPnt(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutPntDeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_ROUT_VIA 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param priSqHdrVO PriSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRoutVia(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtRoutViaVODeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param priSqHdrVO PriSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationRate(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtVODeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_SCG_ROUT 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationSchgRout(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgRoutDeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_SCG 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationSchg(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgDeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_RT_USD_ROUT_CS 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationUsdRoutCs(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtUsdRoutCsDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * PRI_SQ_SCG_ADJ 테이블 Qttn No 별 전체 삭제<br>
	 * 
	 * @param PriSqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeScQuotationScgAdj(PriSqHdrVO priSqHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO .getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqScgAdjDeleteByQttnVerNoDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * SC Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVerticalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (priSqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAORsltRtListVerticalExcelVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListVerticalExcelVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * SC Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (priSqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAORsltRtListHorizontalExcelVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListHorizontalExcelVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
	/**
	 * SC Rate CMPB VIEW ALL (ESM_PRI_6074) 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCmpbViewAllListVO> searchRateCmpbViewAllList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCmpbViewAllListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (priSqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAORsltCmpbViewAllListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCmpbViewAllListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * LOAD EXCEL 시 cmdt cd CHECK.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return RsltCdListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchCheckCommodityCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);
			
			if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAOLoadExcelCheckGrpCmdtRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 6) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAOLoadExcelCheckCmdtRSQL(), param, null);
			} else {
				return null;
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	/**
	 * LOAD EXCEL 시 loc cd CHECK.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return RsltCdListVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchCheckLocationCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);
			
			if (rsltCdListVO.getCd().length() == 4) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAOLoadExcelCheckGrpLocRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAOLoadExcelCheckLocRSQL(), param, null);
			} else {
				return null;
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		if (list == null || list.size() <= 0) {
			return null;
		} else {
			return list.get(0);
		}
	}
	
	
	
	/**
	 * 수정된 Surchage값을 RATE의 CMPB에 반영하기 위해 PRI_SQ_RT를 수정합니다.<br>
	 * 
	 * @param PriSqRtScgVO updModels
	 * @param String updateLevel
	 * @exception DAOException
	 */
	public void modifyPrsRateSurchargeCmpb(PriSqRtScgVO updModels,String updateLevel) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(updModels != null ) {
				Map<String, String> mapVO = updModels.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("UPDATE_LEVEL",updateLevel);
				updCnt = sqlExe.executeUpdate((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtRateSurchageCmpbScgVOUSQL(), param,
						velParam);
			 
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 수정된 RATE TABLE의 CMPB 값을 CMDT_ROUT TABLE에 적용하기 위해 PRI_SQ_RT_CMDT_ROUT를 수정합니다.<br>
	 * 
	 * @param PriSqRtScgVO updModels
	 * @param String updateLevel
	 * @exception DAOException
	 */
	public void modifyPrsRateCmdtRoutCmpb(PriSqRtScgVO updModels,String updateLevel) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(updModels != null ) {
				Map<String, String> mapVO = updModels.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("UPDATE_LEVEL",updateLevel);
				updCnt = sqlExe.executeUpdate((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtCmdtRouteCmpbVOUSQL(), param,
						velParam);
			 
				if (updCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
				 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	//------------------------------------------------------------------------------------
	/**
	 *  Route Case 에 해당하는 Surcharge Data 배치에서 선택 하기 위해 삭제
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void removePriSqRtScgRoutCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgRoutCostDetailVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	

	/**
	 *  SURCHARGE DETAIL의 ROUTE 정보를 INSERT 한다
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriSqRtScgRoutCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgRoutCostDetailVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
	/**
	 *  사용자 입력 건은 제외하고 데이터 삭제한다.
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void removePriSqRtScgCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgCostDetailVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	

	/**
	 *  SURCHARGE RATING 수행 -MAERGE 문 이용하여 INSERT & UPDATE
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriSqRtScgCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgCostDetailVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 *  ADJUST DATA 로 UPDATE
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @param String updateLevel
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriSqRtScgAmtCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO,String updateLevel) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("UPDATE_LEVEL",updateLevel);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtScgAmtCostDetailVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	/**
	 *  RATE 에 SURCHARGE SUM DATA UPDATE
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriSqRtSurchargeCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtSurchargeCostDetailVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 *  PROPOSAL RATE + SURCHARGE - COST = CMPB 
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriSqRtCMPBCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCMPBCostDetailVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	 
	
	/**
	 *  RATE별 SVC LANE UPDATE 및  CMPB GUIDELINE MATCHING 
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriSqRtSvcLaneCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtSvcLaneCostDetailVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
		
	 
	
	/**
	 *   RATE별 SVC LANE UPDATE 및  CMPB GUIDELINE MATCHING 
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriSqRtGlineMappingCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtGlineMappingCostDetailVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
 
	/**
	 *  Rate 별 대표 Unit Code를 선정하여 Route별 Estimated 계산용으로 사용한다.
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriSqRtCmdtRoutEstmCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCRateQuotationDBDAOPriSqRtCmdtRoutEstmCostDetailVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Rate 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSqRtUsdRoutCsVO> insModels
	 * @exception DAOException
	 */
	public void addPriRateUsedRouteCase(List<PriSqRtUsdRoutCsVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateQuotationDBDAOPriSqRtUsdRoutCsPreSimulationCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
	
	
	
	/**
	 * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(
			InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCostSimulationCheckRouteVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inCostSimulationCheckRouteVO != null) {
				Map<String, String> mapVO = inCostSimulationCheckRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateQuotationDBDAORsltPriCostSimulationCheckRouteVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriCostSimulationCheckRouteVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	
	


	/**
	 * Surcharge View All 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeViewAllVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAORsltPriSurchargeViewAllVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSurchargeViewAllVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	
	
	
	
	
    

	/**
	 * Accept All 리스트를 조회한다.<br>
	 * 
	 * @param PriSqRtCmdtHdrVO priSqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriSqRtCmdtHdrVO priSqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeLastAccessDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateQuotationDBDAORsltPriSurchargeLastAccessDateVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSurchargeLastAccessDateVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
}