/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateQuotationDBDAO.java
 *@FileTitle : RFA Quotation
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
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltPriRqMnVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.basic.RFARateQuotationBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.FicRouteGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.InPriLocationViaListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.PriRqRtLoadExcelGuidelineCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltFicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCommodityRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtCmdtRoutVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtDuplicateCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtGuidelineRateVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtListHorizontalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtListVerticalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtRoutDestPntVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtRoutOrgPntVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtRoutViaVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriRqRtVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPrsSurchargeDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelForIHCVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltRtListVerticalExcelVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRqHdrVO;
import com.hanjin.syscommon.common.table.PriRqMnVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRqRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRqRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRqRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRqRtScgVO;
import com.hanjin.syscommon.common.table.PriRqRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriRqRtVO;
import com.hanjin.syscommon.common.table.PriRqScgAdjVO;

/**
 * ALPS RFARateQuotationDBDAO <br>
 * - ALPS-RFAQuotation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SONG MIN SEOK
 * @see RFARateQuotationBCImpl 참조
 * @since J2EE 1.6
 */
public class RFARateQuotationDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * CM/OP 산출 이후, Rout별 적용된 Surcharge 상세정보 확인하는 Surcharge Detail 데이터<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
	 * @return List<RsltPrsSurchargeDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPrsSurchargeDetailVO> searchSurchargeDetailList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPrsSurchargeDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inpPrsSurchargeDetailApplicableRouteVO != null) {
				Map<String, String> mapVO = inpPrsSurchargeDetailApplicableRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPrsSurchargeDetailRSQL(), param, velParam);
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
	 * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
	 * @return List<RsltPrsSurchargeDetailApplicableRouteVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPrsSurchargeDetailApplicableRouteVO> searchSurchargeList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPrsSurchargeDetailApplicableRouteVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPrsSurchargeDetailApplicableRouteRSQL(), param, velParam);
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
	 * RFA Surchage값을 (pri_rq_rt_scg) 추가합니다.<br>
	 * 
	 * @param List<PriRqRtScgVO> insModels
	 * @throws DAOException
	 */
	public void addRateSurcharge(List<PriRqRtScgVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgVOCSQL(), insModels, null);
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
	 * RFA Surchage값을 (pri_rq_rt_scg) 수정합니다.<br>
	 * 
	 * @param List<PriRqRtScgVO> updModels
	 * @throws DAOException
	 */
	public void modifyRateSurcharge(List<PriRqRtScgVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgVOUSQL(), updModels, null);
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
	 * RFA Surchage값을 (pri_rq_rt_scg) 삭제합니다.<br>
	 * 
	 * @param List<PriRqRtScgVO> delModels
	 * @throws DAOException
	 */
	public void removeRateSurcharge(List<PriRqRtScgVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgVODSQL(), delModels, null);
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
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriPrsCostListVORSQL(), param, velParam);
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
	 * @param RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriPrsCostDetailVORSQL(), param, velParam);
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
	 * @param RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriSurchargeAdjustListVORSQL(), param, velParam);
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
	 * RFA Surchage 조정값을 추가한다.<br>
	 * 
	 * @param List<PriRqScgAdjVO> insModels
	 * @throws DAOException
	 */
	public void addSurchargeAdjust(List<PriRqScgAdjVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqScgAdjVOCSQL(), insModels, null);
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
	 * RFA Surchage 조정값을 수정한다.<br>
	 * 
	 * @param List<PriRqScgAdjVO> updModels
	 * @throws DAOException
	 */
	public void modifySurchargeAdjust(List<PriRqScgAdjVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqScgAdjVOUSQL(), updModels, null);
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
	 * RFA Surchage 조정값을 삭제한다.<br>
	 * 
	 * @param List<PriRqScgAdjVO> delModels
	 * @throws DAOException
	 */
	public void removeSurchargeAdjust(List<PriRqScgAdjVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqScgAdjVODSQL(), delModels, null);
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
	 * @param RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityVORSQL(), param, velParam);
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
	 * @param RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityVO)
			throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriSurchargeAdjustCommodityDetailVORSQL(), param, velParam);
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
	 * Surcharge Adjust-Location Group 데이터 조회
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationVO)
			throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriSurchargeAdjustLocationGroupVORSQL(), param, velParam);
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
	 * Surcharge Adjust-Location Group에 상세 정보
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupDetailVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeAdjustLocationGroupDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSurchargeAdjustLocationGroupDetailVO != null) {
				Map<String, String> mapVO = rsltPriSurchargeAdjustLocationGroupDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriSurchargeAdjustLocationGroupDetailVORSQL(), param, velParam);
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
	 * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
	 * 
	 * @param RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCostDetailByTransModeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriCostDetailByTransModeListVO != null) {
				Map<String, String> mapVO = rsltPriCostDetailByTransModeListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriCostDetailByTransModeListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriCostDetailByTransModeListVO.class);
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
	 * CM/OP View 조회 처리
	 * 
	 * @param RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRateCmViewAllVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriRateCmViewAllVO != null) {
				Map<String, String> mapVO = rsltPriRateCmViewAllVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRateCmViewAllVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRateCmViewAllVO.class);
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
	 * RFA RATE(PRI_RQ_RT_CMDT_ROUT)의 load 값을 갱신처리 합니다.
	 * 
	 * @param updModels List<PriRqRtCmdtRoutVO>
	 * @param pfmcUnit String
	 * @throws DAOException
	 */
	public void modifyPrsPfmc(List<PriRqRtCmdtRoutVO> updModels, String pfmcUnit) throws DAOException, Exception {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("pfmc_unit", pfmcUnit);
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutPfmcVOUSQL(), updModels, velParam);
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
	 * 사용자가 해당 값의 선택여부를(PRI_RQ_RT_USD_ROUT_CS) 수정처리.<br>
	 * 
	 * @param List<RsltPriPrsCostListVO> updModels
	 * @throws DAOException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			int updCnt[] = null;
			if (updModels.size() > 0) {

				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtUsdRoutCsFlagVOUSQL(), updModels, null);
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
	 * @param List<RsltPriPrsCostListVO> updModels
	 * @throws DAOException
	 */
	public void modifyRate(List<RsltPriPrsCostListVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (updModels.size() > 0) {
				velParam.put("cost_tp", (updModels.get(0)).getCostTp());

				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCostVOUSQL(), updModels, velParam);
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
	 * Quotaion의 route 리스트 데이터
	 * 
	 * @param String ficRtTpCd
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltPriCommodityRouteVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriCommodityRouteVO> searchCommodityRouteList(String ficRtTpCd, InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCommodityRouteVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (inPriCommodityRouteVO != null) {
				Map<String, String> mapVO = inPriCommodityRouteVO.getColumnValues();
				mapVO.put("fic_rt_tp_cd", ficRtTpCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriCommodityRouteVORSQL(), param, velParam);
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
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSCQuotationCreationDate(InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriQuotationCreationDateVORSQL(), param, velParam);
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
	 * Quotaion의 route 리스트 조회 데이터 <BR>
	 * 
	 * 
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCommodityRoutePntAreaList(InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriCommodityRoutePntAreaVORSQL(), param, velParam);
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
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCommodityRouteTermAreaList(InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriCommodityRouteTermAreaVORSQL(), param, velParam);
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
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCommodityRouteViaAreaList(InPriCommodityRouteVO inPriCommodityRouteVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriCommodityRouteViaAreaVORSQL(), param, velParam);
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
	 * Rate Quotation(PRI_RQ_RT)의 Rate값을 매칭 룰에 의해 매칭된 row에 대해 갱신하고<BR>
	 * 그 갱신 여부를 마크 해 둔다.<BR>
	 * 
	 * @param List<InPriLocationViaListVO> updModels
	 * @param InPriCommodityRouteVO inPriCommodityRouteVO
	 * @param String ficRtpTpCd
	 * @throws DAOException
	 */
	public void modifyRateRfaQuotation(List<InPriLocationViaListVO> updModels, InPriCommodityRouteVO inPriCommodityRouteVO, String ficRtpTpCd) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			velParam.put("list_obj", updModels);

			if (inPriCommodityRouteVO != null) {
				Map<String, String> mapVO = inPriCommodityRouteVO.getColumnValues();
				param.putAll(mapVO);
				param.put("fic_rt_tp_cd", ficRtpTpCd);
			}
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtAdjustUSQL(), param, velParam);
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

	// ///////////////////////////////////////////////////RQ RATE
	// MAIN//////////////////////////////////////////////////////////////

	/**
	 * PRI_RQ_RT_CMDT_HDR SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriRqRtCmdtHdrMaxSeq(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}

	/**
	 * PRI_RQ_RT_CMDT SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriRqRtCmdtMaxSeq(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriRqRtCmdtRoutMaxSeq(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriRqRtRoutPntVO priRqRtRoutOrgPntVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriRqRtRoutPntMaxSeq(PriRqRtRoutPntVO priRqRtRoutOrgPntVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtRoutOrgPntVO != null) {
				Map<String, String> mapVO = priRqRtRoutOrgPntVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriRqRtRoutViaVO priRqRtRoutOrgViaVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriRqRtRoutViaMaxSeq(PriRqRtRoutViaVO priRqRtRoutOrgViaVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtRoutOrgViaVO != null) {
				Map<String, String> mapVO = priRqRtRoutOrgViaVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}

	/**
	 * PRI_RQ_RT SEQ 맥스값을 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPriRqRtMaxSeq(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException {
		int max_seq = -1;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				max_seq = dbRowset.getInt("MAX_SEQ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return max_seq;
	}

	/**
	 * CMDT_HDR_SEQ 별 Cmdt Grp 한줄로 합해서 조회.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriRqRtCmdtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtCmdtVO> searchPriRqRtCmdtGrpList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtCmdtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtGrpListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtCmdtVO.class);
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
	 * Rate 정보를 조회 합니다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return List<RsltPriRqRtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriRqRtVO> searchPriRqRtVOList(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priRqRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtVO.class);
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
	 * PRI_RQ_RT_ROUT_PNT 테이블을 조회한다.(ORIGIN별)<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return List<RsltPriRqRtRoutOrgPntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtRoutOrgPntVO> searchPriRqRtRoutOrgPntVOList(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtRoutOrgPntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtRoutOrgPntVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtRoutOrgPntVO.class);
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
	 * PRI_RQ_RT_ROUT_PNT 테이블을 조회한다.(DESTINATION별)<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return List<PriRqRtRoutDestPntVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtRoutDestPntVO> searchPriRqRtRoutDestPntVOList(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtRoutDestPntVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtRoutDestPntVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtRoutDestPntVO.class);
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
	 * PRI_RQ_RT_CMDT 테이블을 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @param String ficRtTpCd
	 * @return List<RsltPriRqRtCmdtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtCmdtVO> searchPriRqRtCmdtVOList(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO, String ficRtTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtCmdtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();
				mapVO.put("fic_rt_tp_cd", ficRtTpCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtCmdtVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtCmdtVO.class);
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
	 * PRI_RQ_RT_ROUT_VIA 테이블을 조회한다(ORIGIN 별).<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return List<RsltPriRqRtRoutViaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtRoutViaVO> searchPriRqRtRoutOrgViaVOList(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtRoutViaVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtRoutOrgViaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtRoutViaVO.class);
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
	 * PRI_RQ_RT_ROUT_VIA 테이블을 조회한다(DEST 별).<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return List<RsltPriRqRtRoutViaVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtRoutViaVO> searchPriRqRtRoutDestViaVOList(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtRoutViaVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtRoutDestViaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtRoutViaVO.class);
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
	 * ROUTE LIST 별 PRI_RQ_RT_ROUT_VIA,PRI_RQ_RT_ROUT_PNT를 한줄로 합해서 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriRqRtCmdtRoutVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtCmdtRoutVO> searchPriRqRtCmdtRoutVOList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtCmdtRoutVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtCmdtRoutVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtCmdtRoutVO.class);
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
	 * PRI_RQ_RT_CMDT 테이블을 등록한다.<br>
	 * 
	 * @param PriRqRtCmdtVO priRqRtCmdtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRfaQuotationCommodity(PriRqRtCmdtVO priRqRtCmdtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRqRtCmdtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Gline copy PRI_RQ_RT_CMDT<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyRfaQuotationCommodity(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVOAddGlineCopyCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRI_RQ_RT_CMDT 테이블을 갱신한다.<br>
	 * 
	 * @param PriRqRtCmdtVO priRqRtCmdtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRfaQuotationCommodity(PriRqRtCmdtVO priRqRtCmdtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT 테이블을 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtVO priRqRtCmdtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationCommodity(PriRqRtCmdtVO priRqRtCmdtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT 테이블 hdr seq별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationCommodity(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVOAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT 테이브을 일괄 등록한다.<br>
	 * 
	 * @param List<PriRqRtCmdtVO> priRqRtCmdtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRfaQuotationCommodityS(List<PriRqRtCmdtVO> priRqRtCmdtVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVOCSQL(), priRqRtCmdtVO, null);
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
		return insCnt;
	}

	/**
	 * PRI_RQ_RT_CMDT 테이블을 일괄 갱신한다.<br>
	 * 
	 * @param List<PriRqRtCmdtVO> priRqRtCmdtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyRfaQuotationCommodityS(List<PriRqRtCmdtVO> priRqRtCmdtVO) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVOUSQL(), priRqRtCmdtVO, null);
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
		return updCnt;
	}

	/**
	 * PRI_RQ_RT_CMDT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriRqRtCmdtVO> priRqRtCmdtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeRfaQuotationCommodityS(List<PriRqRtCmdtVO> priRqRtCmdtVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVODSQL(), priRqRtCmdtVO, null);
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
		return delCnt;
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR 테이블을 일괄 등록한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRfaQuotationCommodityHeader(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Gline을 copy하여 PRI_RQ_RT_CMDT_HDR로 등록한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyRfaQuotationCommodityHeader(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrVOAddGlineCopyCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR 테이블을 갱신한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRfaQuotationCommodityHeader(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR 테이블을 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationCommodityHeader(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriRqRtCmdtHdrVO> priRqRtCmdtHdrVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRfaQuotationCommodityHeaderS(List<PriRqRtCmdtHdrVO> priRqRtCmdtHdrVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtHdrVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrVOCSQL(), priRqRtCmdtHdrVO, null);
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
		return insCnt;
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR 테이블을 일괄 갱신한다.<br>
	 * 
	 * @param List<PriRqRtCmdtHdrVO> priRqRtCmdtHdrVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyRfaQuotationCommodityHeaderS(List<PriRqRtCmdtHdrVO> priRqRtCmdtHdrVO) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtHdrVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrVOUSQL(), priRqRtCmdtHdrVO, null);
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
		return updCnt;
	}

	/**
	 * PRI_RQ_RT_CMDT_HDR 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriRqRtCmdtHdrVO> priRqRtCmdtHdrVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeRfaQuotationCommodityHeaderS(List<PriRqRtCmdtHdrVO> priRqRtCmdtHdrVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtHdrVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrVODSQL(), priRqRtCmdtHdrVO, null);
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
		return delCnt;
	}

	/**
	 * PRI_RQ_RT 테이블을 등록한다.<br>
	 * 
	 * @param PriRqRtVO priRqRtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRfaQuotationRate(PriRqRtVO priRqRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRqRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRI_RQ_RT 테이블을 갱신한다.<br>
	 * 
	 * @param PriRqRtVO priRqRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRfaQuotationRate(PriRqRtVO priRqRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT 테이블을 삭제한다.<br>
	 * 
	 * @param PriRqRtVO priRqRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRate(PriRqRtVO priRqRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT 테이블을 Rout seq별 또는 Cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRate(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_USD_ROUT_CS 테이블을 Rout seq별 또는 Cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRateUsedRouteCase(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtUsdRoutCsAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_SCG 테이블을 Rout seq별 또는 Cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRateSurcharge(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_SCG_ROUT 테이블을 Rout seq별 또는 Cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRateSurchargeRoute(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgRoutAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriRqRtVO> priRqRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRfaQuotationRateS(List<PriRqRtVO> priRqRtVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtVOCSQL(), priRqRtVO, null);
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
		return insCnt;
	}

	/**
	 * PRI_RQ_RT 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriRqRtVO> priRqRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyRfaQuotationRateS(List<PriRqRtVO> priRqRtVO) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtVOUSQL(), priRqRtVO, null);
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
		return updCnt;
	}

	/**
	 * PRI_RQ_RT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriRqRtVO> priRqRtVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeRfaQuotationRateS(List<PriRqRtVO> priRqRtVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtVODSQL(), priRqRtVO, null);
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
		return delCnt;
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA 테이블을 등록한다.<br>
	 * 
	 * @param PriRqRtRoutViaVO priRqRtRoutViaVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRfaQuotationRouteVia(PriRqRtRoutViaVO priRqRtRoutViaVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRqRtRoutViaVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA 테이블을 갱신한다.<br>
	 * 
	 * @param PriRqRtRoutViaVO priRqRtRoutViaVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRfaQuotationRouteVia(PriRqRtRoutViaVO priRqRtRoutViaVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtRoutViaVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA 테이블을 삭제한다.<br>
	 * 
	 * @param PriRqRtRoutViaVO priRqRtRoutViaVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRouteVia(PriRqRtRoutViaVO priRqRtRoutViaVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtRoutViaVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA 테이블을 Rout seq or cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRouteVia(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriRqRtRoutViaVO> priRqRtRoutViaVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRfaQuotationRouteViaS(List<PriRqRtRoutViaVO> priRqRtRoutViaVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtRoutViaVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaVOCSQL(), priRqRtRoutViaVO, null);
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
		return insCnt;
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA 테이블을 일괄 갱신한다.<br>
	 * 
	 * @param List<PriRqRtRoutViaVO> priRqRtRoutViaVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyRfaQuotationRouteViaS(List<PriRqRtRoutViaVO> priRqRtRoutViaVO) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtRoutViaVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaVOUSQL(), priRqRtRoutViaVO, null);
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
		return updCnt;
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriRqRtRoutViaVO> priRqRtRoutViaVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeRfaQuotationRouteViaS(List<PriRqRtRoutViaVO> priRqRtRoutViaVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtRoutViaVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaVODSQL(), priRqRtRoutViaVO, null);
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
		return delCnt;
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT 테이블을 등록한다.<br>
	 * 
	 * @param PriRqRtRoutPntVO priRqRtRoutPntVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRfaQuotationRoutePoint(PriRqRtRoutPntVO priRqRtRoutPntVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRqRtRoutPntVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT 테이블을 수정한다.<br>
	 * 
	 * @param PriRqRtRoutPntVO priRqRtRoutPntVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRfaQuotationRoutePoint(PriRqRtRoutPntVO priRqRtRoutPntVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtRoutPntVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT 테이블을 삭제한다.<br>
	 * 
	 * @param PriRqRtRoutPntVO priRqRtRoutPntVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRoutePoint(PriRqRtRoutPntVO priRqRtRoutPntVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtRoutPntVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT 테이블을 Rout seq or cmdt_hdr_seq 별 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRoutePoint(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriRqRtRoutPntVO> priRqRtRoutPntVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRfaQuotationRoutePointS(List<PriRqRtRoutPntVO> priRqRtRoutPntVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtRoutPntVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntVOCSQL(), priRqRtRoutPntVO, null);
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
		return insCnt;
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT 테이블을 일괄 갱신한다.<br>
	 * 
	 * @param List<PriRqRtRoutPntVO> priRqRtRoutPntVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyRfaQuotationRoutePointS(List<PriRqRtRoutPntVO> priRqRtRoutPntVO) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtRoutPntVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntVOUSQL(), priRqRtRoutPntVO, null);
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
		return updCnt;
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriRqRtRoutPntVO> priRqRtRoutPntVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeRfaQuotationRoutePointS(List<PriRqRtRoutPntVO> priRqRtRoutPntVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtRoutPntVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntVODSQL(), priRqRtRoutPntVO, null);
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
		return delCnt;
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT 테이블을 등록한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRfaQuotationCommodityRoute(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT 테이블을 수정한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyRfaQuotationCommodityRoute(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT 테이블을 삭제한다.<br>
	 * 
	 * @param PriRqRtCmdtRoutVO priRqRtCmdtRoutVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationCommodityRoute(PriRqRtCmdtRoutVO priRqRtCmdtRoutVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqRtCmdtRoutVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT 테이블을 일괄 등록한다.<br>
	 * 
	 * @param List<PriRqRtCmdtRoutVO> priRqRtCmdtRoutVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addRfaQuotationCommodityRouteS(List<PriRqRtCmdtRoutVO> priRqRtCmdtRoutVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtRoutVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutVOCSQL(), priRqRtCmdtRoutVO, null);
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
		return insCnt;
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT 테이블을 일괄 수정한다.<br>
	 * 
	 * @param List<PriRqRtCmdtRoutVO> priRqRtCmdtRoutVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyRfaQuotationCommodityRouteS(List<PriRqRtCmdtRoutVO> priRqRtCmdtRoutVO) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtRoutVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutVOUSQL(), priRqRtCmdtRoutVO, null);
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
		return updCnt;
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT 테이블을 일괄 삭제한다.<br>
	 * 
	 * @param List<PriRqRtCmdtRoutVO> priRqRtCmdtRoutVO
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeRfaQuotationCommodityRouteS(List<PriRqRtCmdtRoutVO> priRqRtCmdtRoutVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (priRqRtCmdtRoutVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutVODSQL(), priRqRtCmdtRoutVO, null);
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
		return delCnt;
	}

	/**
	 * Gline정보를 copy하여 PRI_RQ_RT_CMDT_ROUT에 등록한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyRfaQuotationCommodityRoute(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutVOAddGlineCopyCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Gline정보를 copy하여 PRI_RQ_RT_ROUT_PNT에 등록한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyRfaQuotationRoutePoint(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntVOAddGlineCopyCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Gline정보를 copy하여 PRI_RQ_RT_ROUT_VIA에 등록한다.<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyRfaQuotationRouteVia(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaVOAddGlineCopyCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Gline정보를 copy하여 PRI_RQ_RT에 등록한다<br>
	 * 
	 * @param RsltPriRqMnVO rsltPriRqMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGlineCopyRfaQuotationRate(RsltPriRqMnVO rsltPriRqMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriRqMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtVOAddGlineCopyCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * COPY TO QUOTATION PRI_RQ_RT_CMDT_HDR<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationRfaQuotationCommodityHeader(RsltCopyToQuotationVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrVOAddCopyToQuotationCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * COPY TO QUOTATION PRI_RQ_RT_CMDT<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationRfaQuotationCommodity(RsltCopyToQuotationVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtVOAddCopyToQuotationCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * COPY TO QUOTATION PRI_RQ_RT_CMDT_ROUT<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationRfaQuotationCommodityRoute(RsltCopyToQuotationVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutVOAddCopyToQuotationCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * COPY TO QUOTATION PRI_RQ_RT_ROUT_PNT<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationRfaQuotationRoutePoint(RsltCopyToQuotationVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntVOAddCopyToQuotationCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * COPY TO QUOTATION PRI_RQ_RT_ROUT_VIA<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationRfaQuotationRouteVia(RsltCopyToQuotationVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaVOAddCopyToQuotationCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * COPY TO QUOTATION PRI_RQ_RT<br>
	 * 
	 * @param RsltCopyToQuotationVO vo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCopyToQuotationRfaQuotationRate(RsltCopyToQuotationVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtVOAddCopyToQuotationCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Quotaion의 Duplicate 리스트를 조회한다.<br>
	 * 
	 * @param String ficRtTpCd
	 * @param PriRqMnVO priRqMnVO
	 * @return List<RsltPriRqRtDuplicateCheckVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtDuplicateCheckVO> searchRateDuplicateList(String ficRtTpCd, PriRqMnVO priRqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtDuplicateCheckVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqMnVO != null) {
				Map<String, String> mapVO = priRqMnVO.getColumnValues();
				mapVO.put("fic_rt_tp_cd", ficRtTpCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtDuplicateCheckRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtDuplicateCheckVO.class);
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
	 * PRI_RQ_RT_CMDT_HDR 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationCommodityHeader(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT 테이을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationCommodity(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_CMDT_ROUT 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationCommodityRoute(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_ROUT_PNT 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRoutPnt(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutPntDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_ROUT_VIA 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRoutVia(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRoutViaDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priSqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationRate(PriRqHdrVO priSqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRateDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_SCG_ROUT 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationSchgRout(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgRoutDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_SCG 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationSchg(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_RT_USD_ROUT_CS 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationUsdRoutCs(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtUsdRoutCsDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * PRI_RQ_SCG_ADJ 테이블을 Qttn No 별 전체 삭제한다.<br>
	 * 
	 * @param PriRqHdrVO priRqHdrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeRfaQuotationScgAdj(PriRqHdrVO priRqHdrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRqHdrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqScgAdjDeleteByQttnNoDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVerticalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltRtListVerticalExcelVORSQL(), param, velParam);
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
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltRtListHorizontalExcelVORSQL(), param, velParam);
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
	 * RFA Rate CMPB VIEW ALL (ESM_PRI_6076) 리스트를 조회한다.<br>
	 * 
	 * @param PriRqMnVO priRqMnVO
	 * @return List<RsltCmpbViewAllListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCmpbViewAllListVO> searchRateCmpbViewAllList(PriRqMnVO priRqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCmpbViewAllListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqMnVO != null) {
				Map<String, String> mapVO = priRqMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltCmpbViewAllListVORSQL(), param, velParam);
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOLoadExcelCheckGrpCmdtRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 6) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOLoadExcelCheckCmdtRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 4) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOLoadExcelCheckRepCmdtRSQL(), param, null);
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOLoadExcelCheckGrpLocRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOLoadExcelCheckLocRSQL(), param, null);
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
	 * Quotaion rate View All
	 * 
	 * @param PriRqMnVO priRqMnVO
	 * @return List<PriRqMnVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriRqMnVO> searchPriRqMn(PriRqMnVO priRqMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRqMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqMnVO != null) {
				Map<String, String> mapVO = priRqMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqMnVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRqMnVO.class);
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
	 * 수정된 Surchage값을 RATE의 CMPB에 반영하기 위해 PRI_RQ_RT를 수정합니다.<br>
	 * 
	 * @param PriRqRtScgVO updModels
	 * @param String updateLevel
	 * @exception DAOException
	 */
	public void modifyPrsRateSurchargeCmpb(PriRqRtScgVO updModels, String updateLevel) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (updModels != null) {
				Map<String, String> mapVO = updModels.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("UPDATE_LEVEL", updateLevel);
				updCnt = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtRateSurchageCmpbScgVOUSQL(), param, velParam);

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
	 * @param PriRqRtScgVO updModels
	 * @param String updateLevel
	 * @exception DAOException
	 */
	public void modifyPrsRateCmdtRoutCmpb(PriRqRtScgVO updModels, String updateLevel) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (updModels != null) {
				Map<String, String> mapVO = updModels.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("UPDATE_LEVEL", updateLevel);
				updCnt = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRouteCmpbVOUSQL(), param, velParam);

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

	// ------------------------------------------------------------------------------------
	/**
	 * Route Case 에 해당하는 Surcharge Data 배치에서 선택 하기 위해 삭제
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void removePriRqRtScgRoutCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgRoutCostDetailVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SURCHARGE DETAIL의 ROUTE 정보를 INSERT 한다
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriRqRtScgRoutCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgRoutCostDetailVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 사용자 입력 건은 제외하고 데이터 삭제한다.
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void removePriRqRtScgCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgCostDetailVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * SURCHARGE RATING 수행 -MAERGE 문 이용하여 INSERT & UPDATE
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriRqRtScgCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgCostDetailVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ADJUST DATA 로 UPDATE
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @param String updateLevel
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriRqRtScgAmtCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO, String updateLevel) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("UPDATE_LEVEL", updateLevel);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtScgAmtCostDetailVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RATE 에 SURCHARGE SUM DATA UPDATE
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriRqRtSurchargeCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtSurchargeCostDetailVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PROPOSAL RATE + SURCHARGE - COST = CMPB
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriRqRtCMPBCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCMPBCostDetailVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RATE별 SVC LANE UPDATE 및 CMPB GUIDELINE MATCHING
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriRqRtSvcLaneCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtSvcLaneCostDetailVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * RATE별 SVC LANE UPDATE 및 CMPB GUIDELINE MATCHING
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriRqRtGlineMappingCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtGlineMappingCostDetailVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Rate 별 대표 Unit Code를 선정하여 Route별 Estimated 계산용으로 사용한다.
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriRqRtCmdtRoutEstmCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtRoutEstmCostDetailVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRqRtUsdRoutCsVO> insModels
	 * @exception DAOException
	 */
	public void addPriRateUsedRouteCase(List<PriRqRtUsdRoutCsVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtUsdRoutCsPreSimulationCSQL(), insModels, null);
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
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriCostSimulationCheckRouteVORSQL(), param, velParam);
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
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeViewAllVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriSurchargeViewAllVORSQL(), param, velParam);
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
	 * All 리스트를 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeLastAccessDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriSurchargeLastAccessDateVORSQL(), param, velParam);
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

	/**
	 * All 리스트를 조회한다.<br>
	 * 
	 * @param PriRqRtCmdtHdrVO priRqRtCmdtHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public int searchRateCommoditySequence(PriRqRtCmdtHdrVO priRqRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rslt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOPriRqRtCmdtHdrSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				rslt = dbRowset.getInt(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rslt;
	}

	/**
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param FicRouteGroupVO ficRouteGroupVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGLineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FicRouteGroupVO> searchFicRouteGroup(FicRouteGroupVO ficRouteGroupVO, boolean addOnFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<FicRouteGroupVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("add_on_flag", addOnFlag ? "Y" : "N");
		try {
			if (ficRouteGroupVO != null) {
				Map<String, String> mapVO = ficRouteGroupVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOFicRouteGroupVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FicRouteGroupVO.class);
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
	 * location code또는 group location code에 CY가 포함돼 있는 확인한다.<br>
	 * 
	 * @param FicCheckCYPortLocationVO ficCheckCYPortLocationVO
	 * @return List<RsltFicCheckCYPortLocationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltFicCheckCYPortLocationVO> searchCYPortLocationCode(FicCheckCYPortLocationVO ficCheckCYPortLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltFicCheckCYPortLocationVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (ficCheckCYPortLocationVO != null) {
				Map<String, String> mapVO = ficCheckCYPortLocationVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltFicCheckCYPortLocationVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltFicCheckCYPortLocationVO.class);
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
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltRtListVerticalExcelForIHCVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListVerticalExcelForIHCVO> searchRateListVerticalExcelForIHC(RFARateQuotationVO rfaRateQuotationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVerticalExcelForIHCVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rfaRateQuotationVO.getPriRqRtCmdtHdrVO();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();
				mapVO.put("svc_scp_cd", rfaRateQuotationVO.getSvcScpCd());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltRtListVerticalExcelForIHCVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListVerticalExcelForIHCVO.class);
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
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltRtListHorizontalExcelForIHCVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListHorizontalExcelForIHCVO> searchRateListHorizontalExcelForIHC(RFARateQuotationVO rfaRateQuotationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelForIHCVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rfaRateQuotationVO.getPriRqRtCmdtHdrVO();
		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();
				mapVO.put("svc_scp_cd", rfaRateQuotationVO.getSvcScpCd());
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltRtListHorizontalExcelForIHCVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListHorizontalExcelForIHCVO.class);
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
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltPriRqRtListVerticalExcelForAddOnTariffVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriRqRtListVerticalExcelForAddOnTariffVO> searchRateListVerticalExcelForAddOnTariff(RFARateQuotationVO rfaRateQuotationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtListVerticalExcelForAddOnTariffVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rfaRateQuotationVO.getPriRqRtCmdtHdrVO();

		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtListVerticalExcelForAddOnTariffVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtListVerticalExcelForAddOnTariffVO.class);
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
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @return List<RsltPriRqRtListHorizontalExcelForAddOnTariffVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriRqRtListHorizontalExcelForAddOnTariffVO> searchRateListHorizontalExcelForAddOnTariff(RFARateQuotationVO rfaRateQuotationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtListHorizontalExcelForAddOnTariffVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		PriRqRtCmdtHdrVO priRqRtCmdtHdrVO = rfaRateQuotationVO.getPriRqRtCmdtHdrVO();
		try {
			if (priRqRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRqRtCmdtHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAORsltPriRqRtListHorizontalExcelForAddOnTariffVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtListHorizontalExcelForAddOnTariffVO.class);
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
	 * Load된 엑셀 데이터의 FIC Rate를 조회한다.
	 * 
	 * @param RFARateQuotationVO rfaRateQuotationVO
	 * @param boolean addOnFlag
	 * @return List<RsltPriRqRtGuidelineRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriRqRtGuidelineRateVO> searchFicGuidelineRateForLoadExcel(RFARateQuotationVO rfaRateQuotationVO, boolean addOnFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRqRtGuidelineRateVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			PriRqRtLoadExcelGuidelineCheckVO priRqRtLoadExcelGuidelineCheckVO = rfaRateQuotationVO.getPriRqRtLoadExcelGuidelineCheckVO();
			velParam.put("route_list", rfaRateQuotationVO.getPriRqRtLoadExcelGuidelineCheckVOs());
			param.put("in_org_dest_tp_cd", rfaRateQuotationVO.getInOrgDestTpCd());
			velParam.put("in_org_dest_tp_cd", rfaRateQuotationVO.getInOrgDestTpCd());
			param.put("svc_scp_cd", rfaRateQuotationVO.getSvcScpCd());
			velParam.put("svc_scp_cd", rfaRateQuotationVO.getSvcScpCd());
			velParam.put("add_on_flag", addOnFlag ? "Y" : "N");

			if (priRqRtLoadExcelGuidelineCheckVO != null) {
				Map<String, String> mapVO = priRqRtLoadExcelGuidelineCheckVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateQuotationDBDAOSearchFicGuidelineRateForLoadExcelRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRqRtGuidelineRateVO.class);
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