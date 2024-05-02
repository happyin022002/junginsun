/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateProposalDBDAO.java
 *@FileTitle : RFARateProposalDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.19
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.19 박성수
 * 1.0 Creation
=========================================================
 * History
 * 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
 * 2014.03.11 서미진 [CHM-201429293] Route 중에 term이 빠진 Location check
 * 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
 * 2015.11.26 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVOCSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVODSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvDSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvSeqVODSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvUSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvVOCSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvVOMSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvVORSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvVOUSQL;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic.RFARateProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.CheckGRICalculationValidationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicRateLoadExcelGuidelineCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicRouteGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltActCustListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltAllRtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltCnoteNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicGuidelineRateForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicGuidelineRateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicRateByRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmpbOpbViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpMnCalcVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpScpRtCgoSpecVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPrsSurchargeDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRnoteNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCheckDuplicateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtHdrListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtRnoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCnoteListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelForAeeAewVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelForAeeAewVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutDestPntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutDestViaListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrInquiryListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutOrgPntListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutOrgViaListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRouteMBListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCgoSpecVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtScgVO;
import com.hanjin.syscommon.common.table.PriRpScpRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;
import com.hanjin.syscommon.common.table.PriRpScpScgAdjVO;

/**
 * NIS2010 RFARateProposalDBDAO <br>
 * - NIS2010-RFAProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sungsoo, Park
 * @see RFARateProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class RFARateProposalDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	// /////////////////////////// 박성수 수정 시작 ///////////////////////////////////////

	/**
	 * Rate CMDT Header의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
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
	 * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
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
	 * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderHistoryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrHistoryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
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
	 * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderStyleList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				velParam.put("IS_STYLE", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
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
	 * Rate CMDT Detail의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCmdtDtlListVO> searchRateCommodityDetailList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtDtlListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtDtlListVO.class);
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
	 * Rate Guideline CMDT Detail의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCmdtDtlListVO> searchRateCommodityDetailInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtDtlInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtDtlListVO.class);
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
	 * Rate Actual Customer의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltActCustListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltActCustListVO> searchActualCustomerList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltActCustListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltActCustListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltActCustListVO.class);
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
	 * Rate Guideline CMDT Detail의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltActCustListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltActCustListVO> searchActualCustomerInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltActCustListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltActCustInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltActCustListVO.class);
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
	 * Rate Commodity Note 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCnoteListVO> searchRateCnoteList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCnoteListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCnoteListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCnoteListVO.class);
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
	 * Rate Guideline CMDT Detail의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCnoteListVO> searchRateCnoteInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCnoteListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCnoteInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCnoteListVO.class);
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
	 * Rate Commodity Note Conversion 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltCnoteNoteConvListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltCnoteNoteConvListVO> searchRateCnoteNoteConvList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCnoteNoteConvListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltCnoteNoteConvListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCnoteNoteConvListVO.class);
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
	 * Guideline MQC의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutHdrListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
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
	 * Master RFA의 Route & Summary 정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRoutHdrSmryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRoutHdrSmryListVO> searchRouteSummaryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRoutHdrSmryListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRoutHdrSmryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRoutHdrSmryListVO.class);
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
	 * Rate Inquiry - Route 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrInquiryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutHdrInquiryListVO> searchRateRouteInquiryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrInquiryListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutHdrInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrInquiryListVO.class);
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
	 * Rate History - Route 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutHdrHistoryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
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
	 * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutHdrListVO> searchRateRouteStyleList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				velParam.put("IS_STYLE", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutHdrListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
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
	 * Rate 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtDtlListVO> searchRateDetailList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtDtlListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtDtlListVO.class);
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
	 * Rate Inquiry - Rate 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtDtlListVO> searchRateDetailInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtDtlInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtDtlListVO.class);
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
	 * Origin Point 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param boolean addOnFlag
	 * @return List<RsltRtRoutOrgPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutOrgPntListVO> searchRateRouteOriginPointList(PriRpScpRtVO priRpScpRtVO, boolean addOnFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutOrgPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("add_on_flag", addOnFlag ? "Y" : "N");

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutOrgPntListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutOrgPntListVO.class);
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
	 * Rate Inquiry - Origin Point 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtRoutOrgPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutOrgPntListVO> searchRateRouteOriginPointInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutOrgPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutOrgPntInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutOrgPntListVO.class);
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
	 * Origin Via. 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtRoutOrgViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutOrgViaListVO> searchRateRouteOriginViaList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutOrgViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutOrgViaListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutOrgViaListVO.class);
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
	 * Rate Inquiry - Origin Via. 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtRoutOrgViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutOrgViaListVO> searchRateRouteOriginViaInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutOrgViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutOrgViaInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutOrgViaListVO.class);
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
	 * Destination Via. 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtRoutDestViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutDestViaListVO> searchRateRouteDestinationViaList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDestViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutDestViaListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDestViaListVO.class);
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
	 * Rate Inquiry - Destination Via. 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtRoutDestViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutDestViaListVO> searchRateRouteDestinationViaInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDestViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutDestViaInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDestViaListVO.class);
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
	 * Destination Point 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param boolean addOnFlag
	 * @return List<RsltRtRoutDestPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutDestPntListVO> searchRateRouteDestinationPointList(PriRpScpRtVO priRpScpRtVO, boolean addOnFlag) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDestPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("add_on_flag", addOnFlag ? "Y" : "N");
		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutDestPntListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDestPntListVO.class);
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
	 * Rate Inquiry - Destination Point 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtRoutDestPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRoutDestPntListVO> searchRateRouteDestinationPointInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDestPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRoutDestPntInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDestPntListVO.class);
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
	 * Route Note 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtCmdtRnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCmdtRnoteListVO> searchRateCommodityRnoteList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtRnoteListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtRnoteListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtRnoteListVO.class);
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
	 * Rate Inquiry - Route Note 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRtCmdtRnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCmdtRnoteListVO> searchRateCommodityRnoteInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtRnoteListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtRnoteInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtRnoteListVO.class);
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
	 * Route Note Conversion 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRnoteNoteConvListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRnoteNoteConvListVO> searchRateCommodityRnoteNoteConvList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRnoteNoteConvListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRnoteNoteConvListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRnoteNoteConvListVO.class);
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
	 * Master RFA에서 Route Note Conversion 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return List<RsltRnoteNoteConvListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRnoteNoteConvListVO> searchMstRateCommodityRnoteNoteConvList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRnoteNoteConvListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOMstRsltRnoteNoteConvListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRnoteNoteConvListVO.class);
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
	 * Rate Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVerticalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtListVerticalExcelVORSQL(), param, velParam);
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
	 * Rate Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtListHorizontalExcelVORSQL(), param, velParam);
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
	 * Check Duplicate화면 리스트를 조회합니다. <br>
	 * 데이터 내역 중 중복된 데이터 내역을 조회하여 화면에 반환합니다.
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCheckDuplicateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtCheckDuplicateVO> searchRateCheckDuplicate(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCheckDuplicateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCheckDuplicateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCheckDuplicateVO.class);
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
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltAllRtListVO> searchAllRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAllRtListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltAllRtListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAllRtListVO.class);
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
	 * Spot Accept All 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltAllRtListVO> searchAllSpotRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAllRtListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltAllRtSpotListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAllRtListVO.class);
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
	 * Max Bullet No. 구하기<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxBulletDispSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetMaxBletDpSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				cnt = dbRowset.getString("max_blet_dp_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * Max Bullet No. 구하기<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxOldBulletDispSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				velParam.put("IS_OLD", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetMaxBletDpSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				cnt = dbRowset.getString("max_blet_dp_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * Max Bullet No. 구하기<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxNoteDispSeq(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetMaxNoteDpSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				cnt = dbRowset.getString("max_note_dp_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}

	/**
	 * Rate 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> insModels
	 * @exception DAOException
	 */
	public void addRate(List<PriRpScpRtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOCSQL(), insModels, null);
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
	 * Master RFA Rate 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> insModels
	 * @exception DAOException
	 */
	public void addMstRate(List<PriRpScpRtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOMSQL(), insModels, null);
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
	 * Rate 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> insModels
	 * @exception DAOException
	 */
	public void addRateForAddOnTariff(List<PriRpScpRtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOAddRateForAddOnTariffCSQLCSQL(), insModels, null);
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
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @return int
	 * @exception DAOException
	 */
	public int addRateGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGlineCpVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRate(List<PriRpScpRtVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				velParam.putAll(updModels.get(0).getColumnValues());
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOUSQL(), updModels, velParam);
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRate(List<PriRpScpRtVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), delModels, velParam);
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeScg(List<PriRpScpRtVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVODSQL(), delModels, velParam);
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeScgRout(List<PriRpScpRtVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutVODSQL(), delModels, velParam);
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeUsdRoutCs(List<PriRpScpRtVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsVODSQL(), delModels, velParam);
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeCgoSpec(List<PriRpScpRtVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), delModels, velParam);
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
	 * Actual Customer 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtActCustVO> insModels
	 * @exception DAOException
	 */
	public void addRateActualCustomer(List<PriRpScpRtActCustVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVOCSQL(), insModels, null);
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
	 * Actual Customer 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtActCustVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateActualCustomer(List<PriRpScpRtActCustVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVOUSQL(), updModels, velParam);
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
	 * Actual Customer 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtActCustVO> delModels
	 * @exception DAOException
	 */
	public void removeRateActualCustomer(List<PriRpScpRtActCustVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVODSQL(), delModels, velParam);
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
	 * Commodity 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCnoteVO> insModels
	 * @exception DAOException
	 */
	public void addRateCnote(List<PriRpScpRtCnoteVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVOCSQL(), insModels, null);
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
	 * Commodity Note 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtCnoteVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCnote(List<PriRpScpRtCnoteVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVOUSQL(), updModels, velParam);
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
	 * Commodity Note 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCnoteVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCnote(List<PriRpScpRtCnoteVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVODSQL(), delModels, velParam);
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
	 * Commodity 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodity(List<PriRpScpRtCmdtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOCSQL(), insModels, null);
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
	 * Master RFA Commodity 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addMstRateCommodity(List<PriRpScpRtCmdtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOMSQL(), insModels, null);
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
	 * Commodity Guideline을 Copy한다.
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateCommodityGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtGlineCpVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Commodity 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCommodity(List<PriRpScpRtCmdtVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOUSQL(), updModels, velParam);
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
	 * Commodity 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodity(List<PriRpScpRtCmdtVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityHeader(List<PriRpScpRtCmdtHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVOCSQL(), insModels, null);
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
	 * Master RFA Commodity Header 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> insModels
	 * @exception DAOException
	 */
	public void addMstRateCommodityHeader(List<PriRpScpRtCmdtHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVOMSQL(), insModels, null);
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
	 * Commodity Header Guideline을 Copy한다.
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateCommodityHeaderGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrGlineCpVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Commodity Header 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCommodityHeader(List<PriRpScpRtCmdtHdrVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVOUSQL(), updModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeader(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCmdt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeActCust(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCnote(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCmdtRout(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutPnt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutVia(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRnote(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeScg(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeScgRout(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeUsdRoutCs(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCgoSpec(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), delModels, velParam);
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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendCmdt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}

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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendActCust(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}

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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendCnote(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}

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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRoutPnt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}

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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRoutVia(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}

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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRnote(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}

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
	 * Commodity Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}

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
	 * Route Note 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRnoteVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRnote(List<PriRpScpRtCmdtRnoteVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOCSQL(), insModels, null);
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
	 * Master RFA Route Note 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRnoteVO> insModels
	 * @exception DAOException
	 */
	public void addMstRateCommodityRnote(List<PriRpScpRtCmdtRnoteVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;			
			if (insModels.size() > 0) {				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOMSQL(), insModels, null);				
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
	 * Master RFA Route Note Conversion Mapping ID 데이터를 검색한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO priRpScpRtCmdtRnoteVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMstRateCommodityRnoteMapgId(PriRpScpRtCmdtRnoteVO priRpScpRtCmdtRnoteVO) throws DAOException {		
		String noteConvMapgId = "";
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRnoteVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRnoteVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVORSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				noteConvMapgId = dbRowset.getString("note_conv_mapg_id");
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return noteConvMapgId;
	}

	/**
	 * Master RFA Note Conversion 데이터를 삭제한다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeMstNoteConversion(PriRfaNoteConvVO priRfaNoteConvVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {			
			Map<String, String> mapVO = priRfaNoteConvVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvDSQL(), param, velParam);
			
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
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
	 * Route Note 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRnoteVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCommodityRnote(List<PriRpScpRtCmdtRnoteVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOUSQL(), updModels, velParam);
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
	 * Route Note 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRnoteVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRnote(List<PriRpScpRtCmdtRnoteVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(), delModels, velParam);
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
	 * Route 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRoute(List<PriRpScpRtCmdtRoutVO> insModels) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVOCSQL(), insModels, velParam);
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
	 * Master RFA에서 Route 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRouteMst(List<PriRpScpRtCmdtRoutVO> insModels) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				velParam.put("IS_MASTER", "Y");
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVOCSQL(), insModels, velParam);
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
	 * Master RFA Route 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> insModels
	 * @exception DAOException
	 */
	public void addMstRateCommodityRoute(List<PriRpScpRtCmdtRoutVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVOMSQL(), insModels, null);
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
	 * Route Guideline을 Copy한다.<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateCommodityRouteGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutGlineCpVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Route 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCommodityRoute(List<PriRpScpRtCmdtRoutVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVOUSQL(), updModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRoute(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVODSQL(), delModels, velParam);

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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRoutPnt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(), delModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRoutVia(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(), delModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRnote(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(), delModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), delModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeScg(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVODSQL(), delModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeScgRout(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutVODSQL(), delModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeUsdRoutCs(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsVODSQL(), delModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeCgoSpec(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), delModels, velParam);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRoutPnt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRoutVia(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRnote(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}

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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOUSQL(), delModels, velParam);
					for (int i = 0; i < delCnt.length; i++) {
						if (delCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
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
	 * Route Point 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtRoutPntVO> insModels
	 * @exception DAOException
	 */
	public void addRateRoutePoint(List<PriRpScpRtRoutPntVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOCSQL(), insModels, null);
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
	 * Master RFA Route Point 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtRoutPntVO> insModels
	 * @exception DAOException
	 */
	public void addMstRateRoutePoint(List<PriRpScpRtRoutPntVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOMSQL(), insModels, null);
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
	 * Route Point Guideline을 Copy한다.
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateRoutePointGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntGlineCpVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Route Point 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtRoutPntVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateRoutePoint(List<PriRpScpRtRoutPntVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOUSQL(), updModels, velParam);
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
	 * Route Point 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtRoutPntVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRoutePoint(List<PriRpScpRtRoutPntVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(), delModels, velParam);
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
	 * Route Via. 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtRoutViaVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteVia(List<PriRpScpRtRoutViaVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOCSQL(), insModels, null);
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
	 * Master RFA의 Route Via. 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpRtRoutViaVO> insModels
	 * @exception DAOException
	 */
	public void addMstRateRouteVia(List<PriRpScpRtRoutViaVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOMSQL(), insModels, null);
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
	 * Route Via. Guideline을 Copy한다.
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateRouteViaGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaGlineCpVOCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Route Via. 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtRoutViaVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateRouteVia(List<PriRpScpRtRoutViaVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOUSQL(), updModels, velParam);
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
	 * Route Via. 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtRoutViaVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRouteVia(List<PriRpScpRtRoutViaVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(), delModels, velParam);
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
	 * CUD후 Route Note의 Display Sequence를 재배열한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @param String cascadeLevel
	 * @exception DAOException
	 */
	public void modifyRouteNoteDispSeq(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO, String cascadeLevel) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		HashMap<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();
			param.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", cascadeLevel);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOReorderRouteNoteDpSeqUSQL(), param, velParam);
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
	 * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	public RsltCdListVO searchGlineCopyGroupCodeExist(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
		DBRowSet dbRowset = null;
		RsltCdListVO rsltVO = new RsltCdListVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rfaGlineCopyVO != null) {
				Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGlineCpChkGrpLocExistRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				rsltVO.setEtc1(dbRowset.getString("cnt"));
			}

			dbRowset = null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGlineCpChkGrpCmdtExistRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				rsltVO.setEtc2(dbRowset.getString("cnt"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsltVO;
	}

	/**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateCmdt(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);
			param.put("fic_rt_tp_cd", ficRtTpCd);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("fic_rt_tp_cd", ficRtTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOUSQL(), param, velParam);
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
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateActCust(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);
			param.put("fic_rt_tp_cd", ficRtTpCd);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("fic_rt_tp_cd", ficRtTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVOUSQL(), param, velParam);
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
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateCnote(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);
			param.put("fic_rt_tp_cd", ficRtTpCd);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("fic_rt_tp_cd", ficRtTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVOUSQL(), param, velParam);
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
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRoutPnt(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);
			param.put("fic_rt_tp_cd", ficRtTpCd);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("fic_rt_tp_cd", ficRtTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOUSQL(), param, velParam);
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
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRoutVia(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);
			param.put("fic_rt_tp_cd", ficRtTpCd);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("fic_rt_tp_cd", ficRtTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOUSQL(), param, velParam);
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
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRnote(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);
			param.put("fic_rt_tp_cd", ficRtTpCd);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("fic_rt_tp_cd", ficRtTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOUSQL(), param, velParam);
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
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllMstNoteConv(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);
			param.put("fic_rt_tp_cd", ficRtTpCd);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("fic_rt_tp_cd", ficRtTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriMstRfaPropConvVOUSQL(), param, velParam);
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
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRt(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);
			param.put("fic_rt_tp_cd", ficRtTpCd);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("fic_rt_tp_cd", ficRtTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOUSQL(), param, velParam);
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
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @exception DAOException
	 */
	public void modifyProposalScopeRateGRIApply(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGRIApplyVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			if (se.getErrorCode() == 30926) {
				throw new DAOException(new ErrorHandler("PRI01999").getMessage());
			} else {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * GRI Apply<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyProposalScopeRateGRICancel(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGRICancelVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
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
	 * GRI Cancel시 SCG 테이블삭제<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @exception DAOException
	 */
	public void removeRateScgOnGRICancel(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgOnGRICancelDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
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
	 * GRI Cancel시 SCG_ROUT 테이블삭제<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @exception DAOException
	 */
	public void removeRateScgRoutOnGRICancel(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutOnGRICancelDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
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
	 * GRI Cancel시 USD_ROUT_CS 테이블삭제<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @exception DAOException
	 */
	public void removeRateUsdRoutCsOnGRICancel(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsOnGRICancelDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
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
	 * GRI Cancel시 SCG 데이터 복사<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @exception DAOException
	 */
	public void addCopyPrevRateScgOnGRICancel(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgCpGRICancelCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
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
	 * GRI Cancel시 SCG_ROUT 데이터 복사<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @exception DAOException
	 */
	public void addCopyPrevRateScgRoutOnGRICancel(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutCpGRICancelCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
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
	 * GRI Cancel시 USD_ROUT_CS 데이터 복사<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @exception DAOException
	 */
	public void addCopyPrevRateUsdRoutCsOnGRICancel(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsCpGRICancelCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtScg(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtScgRout(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtScgUsdRout(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtCgoSpec(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRt(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtRoutVia(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtRoutPnt(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtCmdtRnote(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtCmdtRout(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtCnote(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtActCust(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtCmdt(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalMainRtCmdtHdr(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");

			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");

			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	// /**
	// * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	// *
	// * @param PriRpScpMnVO priRpScpMnVO
	// * @exception DAOException
	// */
	// public void removeProposalMain(PriRpScpMnVO priRpScpMnVO) throws DAOException {
	// // query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	// // velocity parameter
	// Map<String, Object> velParam = new HashMap<String, Object>();
	// try {
	// Map<String, String> mapVO = priRpScpMnVO.getColumnValues();
	//
	// param.putAll(mapVO);
	// velParam.putAll(mapVO);
	//
	// velParam.put("CASCADE_LEVEL", "0");
	// velParam.put("IS_ACCEPT", "N");
	//
	// int result = -1;
	// SQLExecuter sqlExe = new SQLExecuter("");
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVODSQL(), param, velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutVODSQL(), param, velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), param, velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), param, velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(), param,
	// velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(), param,
	// velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(), param,
	// velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVODSQL(), param,
	// velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVODSQL(), param,
	// velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVODSQL(), param,
	// velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe
	// .executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVODSQL(), param, velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVODSQL(), param,
	// velParam);
	// if (result == Statement.EXECUTE_FAILED) {
	// throw new DAOException("Fail to insert SQL");
	// }
	//
	// } catch (SQLException se) {
	// log.error(se.getMessage(), se);
	// throw new DAOException(new ErrorHandler(se).getMessage(), se);
	// } catch (Exception ex) {
	// log.error(ex.getMessage(), ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	// }
	// }

	/**
	 * Excel Upload Check시 실제로 코드가 존재하는지 점검한다.
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RsltCdListVO searchActualCustomerExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckActCustRSQL(), param, null);
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
	 * Excel Upload Check시 실제로 코드가 존재하는지 점검한다.
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RsltCdListVO searchCommodityCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);

			if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckGrpCmdtRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 4) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckRepCmdtRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 6) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckCmdtRSQL(), param, null);
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
	 * Excel Upload Check시 실제로 코드가 존재하는지 점검한다.
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RsltCdListVO searchLocationCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);

			if (rsltCdListVO.getCd().length() == 4) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckGrpLocRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckLocRSQL(), param, null);
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
	 * SCSalesGuidelineDAO 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNextCmdtHdrSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		int nextSeq = -1;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();
			param.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetNextCmdtHdrSeqRSQL(), param, null);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				nextSeq = dbRowset.getInt("next_seq");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return nextSeq;
	}

	// /////////////////////////// 박성수 수정 종료 ///////////////////////////////////////

	// ///////////////공백진수정 시작////////////////////////////////////////////////////

	/**
	 * Actual Customer의 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateActualCustomerAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustAmdVOCSQL(), insModels, null);
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
	 * Rate Cnote의 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCnoteAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteAmdVOCSQL(), insModels, null);
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
	 * Rate Commodity 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtAmdVOCSQL(), insModels, null);
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
	 * Rate Commodity Header 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityHeaderAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrAmdVOCSQL(), insModels, null);
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
	 * Rate Commodity Route 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRouteAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutAmdVOCSQL(), insModels, null);
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
	 * Rate 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtAmdVOCSQL(), insModels, null);
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
	 * Master RFA에서 가져온 Rate 데이터를 Basic에 AMEND SEQ +1로  넣는다.<br>
	 * 
	 * @param List<RsltRoutHdrSmryListVO> copyMasterVoList
	 * @exception DAOException
	 */
	public void addRateAmendBasic(List<RsltRoutHdrSmryListVO> copyMasterVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (copyMasterVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtAmdBasicVOCSQL(), copyMasterVoList, null);
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
	 * Rate Commodity Rnote 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRnoteAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteAmdVOCSQL(), insModels, null);
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
	 * Master RFA에서 가져온 Rate Commodity Rnote 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<RsltRoutHdrSmryListVO> copyMasterVoList
	 * @exception DAOException
	 */
	public void addRateCommodityRnoteAmendBasic(List<RsltRoutHdrSmryListVO> copyMasterVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (copyMasterVoList.size() > 0) {
				// TODO test
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteAmdBasicVOCSQL(), copyMasterVoList, null);
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
	 * Rate Route Point 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateRoutePointAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntAmdVOCSQL(), insModels, null);
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
	 * Master RFA에서 가져온 Rate Route Point 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param @param List<RsltRoutHdrSmryListVO> copyMasterVoList
	 * @exception DAOException
	 */
	public void addRateRoutePointAmendBasic(List<RsltRoutHdrSmryListVO> copyMasterVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (copyMasterVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntAmdBasicVOCSQL(), copyMasterVoList, null);
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
	 * Rate Route Via 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteViaAmend(List<PriRpMnVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaAmdVOCSQL(), insModels, null);
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
	 * Master RFA에서 가져온 Rate Route Via 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<RsltRoutHdrSmryListVO> copyMasterVoList
	 * @exception DAOException
	 */
	public void addRateRouteViaAmendBasic(List<RsltRoutHdrSmryListVO> copyMasterVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (copyMasterVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaAmdBasicVOCSQL(), copyMasterVoList, null);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRtActCustReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustRequestCancelVOUSQL(), updModels, null);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRtCmdtReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRequestCancelVOUSQL(), updModels, null);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRtCmdtRnoteReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteRequestCancelVOUSQL(), updModels, null);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRtCnoteReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteRequestCancelVOUSQL(), updModels, null);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRtReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRequestCancelVOUSQL(), updModels, null);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRtRoutePntReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutePntRequestCancelVOUSQL(), updModels, null);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param List<PriRpScpMnVO> updModels
	 * @exception EventException
	 */
	public void modifyProposalRtRouteViaReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRouteViaRequestCancelVOUSQL(), updModels, null);
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

	//
	// /**
	// * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	// *
	// * @param List<PriRpScpMnVO> updModels
	// * @exception EventException
	// */
	// public void modifyProposalRequestCancel(List<PriRpScpMnVO> updModels) throws DAOException {
	// try {
	//
	// SQLExecuter sqlExe = new SQLExecuter("");
	// int updCnt[] = null;
	//
	// if(updModels.size() > 0){
	// updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtActCustRequestCancelVOUSQL(), updModels,null);
	// for(int i = 0; i < updCnt.length; i++){
	// if(updCnt[i]== Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert No"+ i + " SQL");
	// }
	//
	// updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtCmdtRequestCancelVOUSQL(), updModels,null);
	// for(int i = 0; i < updCnt.length; i++){
	// if(updCnt[i]== Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert No"+ i + " SQL");
	// }
	//
	// updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtCmdtRnoteRequestCancelVOUSQL(), updModels,null);
	// for(int i = 0; i < updCnt.length; i++){
	// if(updCnt[i]== Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert No"+ i + " SQL");
	// }
	//
	// updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtCnoteRequestCancelVOUSQL(), updModels,null);
	// for(int i = 0; i < updCnt.length; i++){
	// if(updCnt[i]== Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert No"+ i + " SQL");
	// }
	//
	// updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtRequestCancelVOUSQL(), updModels,null);
	// for(int i = 0; i < updCnt.length; i++){
	// if(updCnt[i]== Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert No"+ i + " SQL");
	// }
	//
	// updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtRoutePntRequestCancelVOUSQL(), updModels,null);
	// for(int i = 0; i < updCnt.length; i++){
	// if(updCnt[i]== Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert No"+ i + " SQL");
	// }
	//
	// updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtRouteViaRequestCancelVOUSQL(), updModels,null);
	// for(int i = 0; i < updCnt.length; i++){
	// if(updCnt[i]== Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to insert No"+ i + " SQL");
	// }
	// }
	//
	// } catch (SQLException se) {
	// log.error(se.getMessage(), se);
	// throw new DAOException(new ErrorHandler(se).getMessage(), se);
	// } catch (Exception ex) {
	// log.error(ex.getMessage(), ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	// }
	// }

	// ///////////////공백진수정 종료////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////////////
	// 송민석 변경내용 시작

	/**
	 * CM/OP 산출 이후, Rout별 적용된 Surcharge 상세정보 확인하는 Surcharge Detail 데이터<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO rsltPriRpScpRtScgVO
	 * @return List<RsltPrsSurchargeDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPrsSurchargeDetailVO> searchSurchargeDetailList(InpPrsSurchargeDetailApplicableRouteVO rsltPriRpScpRtScgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPrsSurchargeDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriRpScpRtScgVO != null) {
				Map<String, String> mapVO = rsltPriRpScpRtScgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPrsSurchargeDetailRSQL(), param, velParam);
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
	 * @param InpPrsSurchargeDetailApplicableRouteVO rsltPriRpScpRtScgVO
	 * @return List<RsltPrsSurchargeDetailApplicableRouteVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPrsSurchargeDetailApplicableRouteVO> searchSurchargeList(InpPrsSurchargeDetailApplicableRouteVO rsltPriRpScpRtScgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPrsSurchargeDetailApplicableRouteVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriRpScpRtScgVO != null) {
				Map<String, String> mapVO = rsltPriRpScpRtScgVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL(), param, velParam);
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
	 * RFA Surchage값을 (pri_rp_scp_rt_scg) 추가합니다.<br>
	 * 
	 * @param List<PriRpScpRtScgVO> insModels
	 * @exception DAOException
	 */
	public void addRateSurcharge(List<PriRpScpRtScgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVOCSQL(), insModels, null);
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
	 * Master RFA Surchage값을 (pri_rp_scp_rt_scg) 추가합니다.<br>
	 * 
	 * @param List<PriRpScpRtScgVO> insModels
	 * @exception DAOException
	 */
	public void addMstRateSurcharge(List<PriRpScpRtScgVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVOCSQL(), insModels, null);
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
	 * RFA Surchage값을 (pri_rp_scp_rt_scg) 수정합니다.<br>
	 * 
	 * @param List<PriRpScpRtScgVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateSurcharge(List<PriRpScpRtScgVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVOUSQL(), updModels, null);
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
	 * RFA Surchage값을 (pri_rp_scp_rt_scg) 삭제합니다.<br>
	 * 
	 * @param List<PriRpScpRtScgVO> delModels
	 * @exception DAOException
	 */
	public void removeRateSurcharge(List<PriRpScpRtScgVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			if (delModels.size() > 0) {
				velParam.put("CASCADE_LEVEL", "99");
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVODSQL(), delModels, velParam);
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
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriPrsCostListVORSQL(), param, velParam);
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
	 * PRS- Cost 상세 정보의 상세 정보 조회 처리<br>
	 * 
	 * @param RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriPrsCostDetailVORSQL(), param, velParam);
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
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriSurchargeAdjustListVORSQL(), param, velParam);
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
	 * @param List<PriRpScpScgAdjVO> insModels
	 * @exception DAOException
	 */
	public void addSurchargeAdjust(List<PriRpScpScgAdjVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpScgAdjVOCSQL(), insModels, null);
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
	 * @param List<PriRpScpScgAdjVO> updModels
	 * @exception DAOException
	 */
	public void modifySurchargeAdjust(List<PriRpScpScgAdjVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpScgAdjVOUSQL(), updModels, null);
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
	 * @param List<PriRpScpScgAdjVO> delModels
	 * @exception DAOException
	 */
	public void removeSurchargeAdjust(List<PriRpScpScgAdjVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpScgAdjVODSQL(), delModels, null);
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
	 * Surcharge Adjust-Commodity 데이터 조회
	 * 
	 * @param RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriSurchargeAdjustCommodityVORSQL(), param, velParam);
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
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriSurchargeAdjustCommodityDetailVORSQL(), param, velParam);
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
	 * @param RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeAdjustLocationGroupVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSurchargeAdjustLocationVO != null) {
				Map<String, String> mapVO = rsltPriSurchargeAdjustLocationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriSurchargeAdjustLocationGroupVORSQL(), param, velParam);
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
	 * Surcharge Adjust-Location 상세 데이터 조회
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeAdjustLocationGroupDetailVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriSurchargeAdjustLocationVO != null) {
				Map<String, String> mapVO = rsltPriSurchargeAdjustLocationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriSurchargeAdjustLocationGroupDetailVORSQL(), param, velParam);
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
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCostDetailByTransModeListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriCostDetailByTransModeListVO != null) {
				Map<String, String> mapVO = rsltPriCostDetailByTransModeListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriCostDetailByTransModeListVORSQL(), param, velParam);
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
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRateCmViewAllVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriRateCmViewAllVO != null) {
				Map<String, String> mapVO = rsltPriRateCmViewAllVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriRateCmViewAllVORSQL(), param, velParam);
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
	 * RFA RATE(PRI_RP_SCP_RT_CMDT_ROUT)의 load 값을 갱신처리 합니다.
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> updModels
	 * @param String pfmcUnit
	 * @exception DAOException
	 */
	public void modifyPrsPfmc(List<PriRpScpRtCmdtRoutVO> updModels, String pfmcUnit) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("pfmc_unit", pfmcUnit);
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutPfmcVOUSQL(), updModels, velParam);
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
	 * RFA Amendment CM/OP View 내용 조회<br>
	 * 
	 * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
	 * @return List<RsltPriAmdCmViewAllVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriAmdCmViewAllVO> searchAmdtRateCmViewAllList(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriAmdCmViewAllVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriAmdCmViewAllVO != null) {
				Map<String, String> mapVO = rsltPriAmdCmViewAllVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriAmdCmViewAllVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriAmdCmViewAllVO.class);
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
	 * CM/OP화면의 CMPB/OPB를 1건 조회한다..<br>
	 * 
	 * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
	 * @return List<RsltPriAmdCmpbOpbViewAllVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriAmdCmpbOpbViewAllVO> searchAmdtRateCmpbAndOpbViewAll(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriAmdCmpbOpbViewAllVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriAmdCmViewAllVO != null) {
				Map<String, String> mapVO = rsltPriAmdCmViewAllVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriAmdCmpbOpbViewAllVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriAmdCmpbOpbViewAllVO.class);
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
	 * RFA RATE(PRI_RP_SCP_RT_CMDT_ROUT)의 Remaining load 값을 갱신처리 합니다.<BR>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> updModels
	 * @param String pfmcUnit
	 * @exception DAOException
	 */
	public void modifyAmdtPrsPfmc(List<PriRpScpRtCmdtRoutVO> updModels, String pfmcUnit) throws DAOException {
		try {
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("pfmc_unit", pfmcUnit);
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutAmdLodQtyVOUSQL(), updModels, velParam);
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
	 * RFA Proposal/Amendment CMPB 또는 OPB 조회 처리<br>
	 * 
	 * @param RsltPriRateCmpbViewAllListVO rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriRateCmpbViewAllListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriRateCmpbViewAllListVO> searchRateCmpbViewAllList(RsltPriRateCmpbViewAllListVO rsltPriCostDetailByTransModeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRateCmpbViewAllListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriCostDetailByTransModeListVO != null) {
				Map<String, String> mapVO = rsltPriCostDetailByTransModeListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriRateCmpbViewAllListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRateCmpbViewAllListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	// 송민석 변경내용 종료
	// /////////////////////////////////////////////////////////////////////////////////

	/**
	 * Rating Unit을 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	public RsltCdListVO checkRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws DAOException {
		DBRowSet dbRowset = null;
		RsltCdListVO rsltVO = new RsltCdListVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCgoSpecVO != null) {
				Map<String, String> mapVO = priRpScpRtCgoSpecVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				rsltVO.setEtc2(dbRowset.getString("cnt"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rsltVO;
	}

	/**
	 * Rate Cargo Specification 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @return List<RsltPriRpScpRtCgoSpecVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriRpScpRtCgoSpecVO> searchRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpScpRtCgoSpecVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCgoSpecVO != null) {
				Map<String, String> mapVO = priRpScpRtCgoSpecVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriRpScpRtCgoSpecVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpScpRtCgoSpecVO.class);
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
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @exception DAOException
	 */
	public void addRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpRtCgoSpecVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecCSQL(), param, velParam);
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
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @exception DAOException
	 */
	public void modifyRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtCgoSpecVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return;
	}

	/**
	 * 사용자가 해당 값의 선택여부를(PRI_RP_SCP_RT_USD_ROUT_CS) 수정처리.<br>
	 * 
	 * @param List<RsltPriPrsCostListVO> updModels
	 * @exception DAOException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			int updCnt[] = null;
			if (updModels.size() > 0) {

				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsFlagVOUSQL(), updModels, null);
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
	 * RATE관련 Cost, CMPB,OPB 값을 갱신한다.<br>
	 * 
	 * @param List<RsltPriPrsCostListVO> updModels
	 * @exception DAOException
	 */
	public void modifyRate(List<RsltPriPrsCostListVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (updModels.size() > 0) {
				velParam.put("cost_tp", (updModels.get(0)).getCostTp());

				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCostVOUSQL(), updModels, velParam);
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
	 * [Special Note Conversion ] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteConvVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRfaNoteConvVO != null) {
				Map<String, String> mapVO = priRfaNoteConvVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltNoteConvVO.class);
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
	 * [Special Note Conversion] 정보를 [붙여넣기] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltNoteConvVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRfaNoteConvVO != null) {
				Map<String, String> mapVO = priRfaNoteConvVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltNoteConvVO.class);
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
	 * [Special Note Conversion] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<PriRfaNoteConvVO> insModels
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] addNoteConversion(List<PriRfaNoteConvVO> insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVOCSQL(), insModels, null);
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
	 * Master RFA 의 [Special Note Conversion] 정보를 [추가] 합니다.<br>
	 * 
	 * @param List<PriRfaNoteConvVO> insModels
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] addMstNoteConversion(List<PriRfaNoteConvVO> insModels) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVOMSQL(), insModels, null);
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
	 * [Special Note Conversion] 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<PriRfaNoteConvVO> updModels
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] modifyNoteConversion(List<PriRfaNoteConvVO> updModels) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvVOUSQL(), updModels, null);
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
	 * [Special Note Conversion] 정보를 [삭제] 합니다.<br>
	 * 
	 * @param List<PriRfaNoteConvVO> delModels
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] removeNoteConversion(List<PriRfaNoteConvVO> delModels) throws DAOException {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvSeqVODSQL(), delModels, null);
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
	 * COPY된 데이터를 아이디별로 삭제한다.<br>
	 * 
	 * @param PriRfaNoteConvListVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeNoteConversionCopy(PriRfaNoteConvListVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVODSQL(), param, velParam);
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
	 * Standard Note Conversion Creation 의 SHEET 데이터를 일괄적으로 COPY 한다.<br>
	 * 
	 * @param List<PriRfaNoteConvListVO> insModels
	 * @exception DAOException
	 */
	public void addNoteConversionCopy(List<PriRfaNoteConvListVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVOCSQL(), insModels, null);
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
	 * Rate Surcharge데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> insModels
	 * @exception DAOException
	 */
	public void addCopyRateSurchargeAmendCancel(List<PriRpScpRtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgCpAmendCancelCSQL(), insModels, null);
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
	 * Rate Surcharge Route데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> insModels
	 * @exception DAOException
	 */
	public void addCopyRateSurchargeRouteAmendCancel(List<PriRpScpRtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutCpAmendCancelCSQL(), insModels, null);
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
	 * Rate Surcharge USCRoute데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> insModels
	 * @exception DAOException
	 */
	public void addCopyRateUsdRouteCsAmendCancel(List<PriRpScpRtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsCpAmendCancelCSQL(), insModels, null);
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
	 * RFA Proposal Scope Rate Commodity Header 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtCmdtHdr(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtHdrCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA Proposal Scope Rate Actual Customer 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtActCust(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtActCustCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA Proposal Scope Rate Commodity 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtCmdt(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Master RFA Proposal Scope Rate Commodity 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtCmdtMst(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("IS_MASTER_COPY", "Y"); // Master RFA에서 Copy 시 사용

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA Proposal Scope Rate Commodity Note 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtCnote(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCnoteCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA Proposal Scope Rate Commodity Route 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtCmdtRout(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtRoutCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Master RFA Proposal Scope Rate Commodity Route 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRoutHdrSmryListVO vo
	 * @param List<String> routSeqList
	 * @param String rfaTypeCode
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtCmdtRoutMst(RsltRoutHdrSmryListVO vo, List<String> routSeqList, String rfaTypeCode) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("rfa_ctrt_tp_cd", rfaTypeCode); // Copy 되는 대상이 Master(신규)인가 Basic(복사)인가에 따라 MST_ROUT_ID 가 결정된다.
			velParam.put("rout_seq_list", routSeqList);
			velParam.put("IS_MASTER_COPY", "Y"); // Master에서 Copy 시
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtRoutCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA Proposal Scope Rate Route Point 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtRoutPnt(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtRoutPntCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Master RFA Proposal Scope Rate Route Point 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRoutHdrSmryListVO vo
	 * @param List<String> routSeqList
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtRoutPntMst(RsltRoutHdrSmryListVO vo, List<String> routSeqList) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rout_seq_list", routSeqList);
			velParam.put("IS_MASTER_COPY", "Y");

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtRoutPntCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA Proposal Scope Rate Route Via 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtRoutVia(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtRoutViaCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Master RFA Proposal Scope Rate Route Via 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRoutHdrSmryListVO vo
	 * @param List<String> routSeqList
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtRoutViaMst(RsltRoutHdrSmryListVO vo, List<String> routSeqList) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rout_seq_list", routSeqList);
			velParam.put("IS_MASTER_COPY", "Y");

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtRoutViaCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA Proposal Scope Rate 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRt(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Master RFA Proposal Scope Rate 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRoutHdrSmryListVO vo
	 * @param List<String> routSeqList
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtMst(RsltRoutHdrSmryListVO vo, List<String> routSeqList) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rout_seq_list", routSeqList);
			velParam.put("IS_MASTER_COPY", "Y");

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA Proposal Scope Rate Commodity Route Note 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtCmdtRnote(RsltRfaPropCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtRnoteCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Master RFA Proposal Scope Rate Commodity Route Note 정보를 Copy 하여 생성합니다.<br>
	 * 
	 * @param RsltRoutHdrSmryListVO vo
	 * @param List<String> routSeqList
	 * @exception DAOException
	 */
	public void addCopyProposalScopeRtCmdtRnoteMst(RsltRoutHdrSmryListVO vo, List<String> routSeqList) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			velParam.put("rout_seq_list", routSeqList);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtRnoteMstCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Guideline Rate Commodity Header 를 Proposal Scope 에 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateCmdtHdr(RpScpGlineCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtCmdtHdrCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Guideline Rate Commodity 를 Proposal Scope 에 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateCmdt(RpScpGlineCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtCmdtCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Guideline Rate Commodity Route 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateCmdtRout(RpScpGlineCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtCmdtRoutCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Guideline Rate Route Point 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateRoutPnt(RpScpGlineCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtRoutPntCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Guideline Rate Route Via 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateRoutVia(RpScpGlineCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtRoutViaCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * SP Scope Rate 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRate(RpScpGlineCopyVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * PRS 정보를 Copy 하여 PriRpScpRtCmdt 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @exception DAOException
	 */
	public void addCopyRfaQuotationPriRpScpRtCmdt(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAORqCpPriRpScpRtCmdtCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * PRS 정보를 Copy 하여 PriRpScpRtCmdtHdr 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @exception DAOException
	 */
	public void addCopyRfaQuotationPriRpScpRtCmdtHdr(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAORqCpPriRpScpRtCmdtHdrCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * PRS 정보를 Copy 하여 PriRpScpRtCmdtRout 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @exception DAOException
	 */
	public void addCopyRfaQuotationPriRpScpRtCmdtRout(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAORqCpPriRpScpRtCmdtRoutCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * PRS 정보를 Copy 하여 PriRpScpRt 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @exception DAOException
	 */
	public void addCopyRfaQuotationPriRpScpRt(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAORqCpPriRpScpRtCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * PRS 정보를 Copy 하여 PriRpScpRtRoutPnt 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @exception DAOException
	 */
	public void addCopyRfaQuotationPriRpScpRtRoutPnt(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAORqCpPriRpScpRtRoutPntCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * PRS 정보를 Copy 하여 PriRpScpRtRoutVia 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @exception DAOException
	 */
	public void addCopyRfaQuotationPriRpScpRtRoutVia(RsltCopyToProposalVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAORqCpPriRpScpRtRoutViaCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * RFA rate View All
	 * 
	 * @param RsltPriRpMnCalcVO rsltPriRpMnCalcVO
	 * @return List<RsltPriRpMnCalcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriRpMnCalcVO> searchPriRpMnCalc(RsltPriRpMnCalcVO rsltPriRpMnCalcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpMnCalcVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriRpMnCalcVO != null) {
				Map<String, String> mapVO = rsltPriRpMnCalcVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriRpMnCalcVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpMnCalcVO.class);
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
	 * 수정된 Surchage값을 RATE의 CMPB에 반영하기 위해 PRI_RP_SCP_RT를 수정합니다.<br>
	 * 
	 * @param PriRpScpRtScgVO updModels
	 * @param String updateLevel
	 * @exception DAOException
	 */
	public void modifyPrsRateSurchargeCmpb(PriRpScpRtScgVO updModels, String updateLevel) throws DAOException, Exception {
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
				updCnt = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRateSurchageCmpbScgVOUSQL(), param, velParam);

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
	 * 수정된 RATE TABLE의 CMPB 값을 CMDT_ROUT TABLE에 적용하기 위해 PRI_RP_SCP_RT_CMDT_ROUT를 수정합니다.<br>
	 * 
	 * @param PriRpScpRtScgVO updModels
	 * @param String updateLevel
	 * @exception DAOException
	 */
	public void modifyPrsRateCmdtRoutCmpb(PriRpScpRtScgVO updModels, String updateLevel) throws DAOException, Exception {
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

				updCnt = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRouteCmpbVOUSQL(), param, velParam);

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

	// ------------------------------------------------------

	/**
	 * Route Case 에 해당하는 Surcharge Data 배치에서 선택 하기 위해 삭제
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void removePriRpScpRtScgRoutCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutCostDetailVODSQL(), param, velParam);
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
	public void addPriRpScpRtScgRoutCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutCostDetailVOCSQL(), param, velParam);
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
	public void removePriRpScpRtScgCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgCostDetailVODSQL(), param, velParam);
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
	public void addPriRpScpRtScgCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgCostDetailVOCSQL(), param, velParam);
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
	public void addPriRpScpRtScgAmtCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO, String updateLevel) throws DAOException, Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgAmtCostDetailVOCSQL(), param, velParam);
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
	public void modifyPriRpScpRtSurchargeCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtSurchargeCostDetailVOUSQL(), param, velParam);
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
	public void modifyPriRpScpRtCMPBCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCMPBCostDetailVOUSQL(), param, velParam);
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
	public void modifyPriRpScpRtSvcLaneCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtSvcLaneCostDetailVOUSQL(), param, velParam);
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
	public void modifyPriRpScpRtGlineMappingCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGlineMappingCostDetailVOUSQL(), param, velParam);
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
	public void modifyPriRpScpRtCmdtRoutEstmCostDetail(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriPrsCostListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutEstmCostDetailVOUSQL(), param, velParam);
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
	 * @param List<PriRpScpRtUsdRoutCsVO> insModels
	 * @exception DAOException
	 */
	public void addPriRateUsedRouteCase(List<PriRpScpRtUsdRoutCsVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtUsdRoutCsPreSimulationCSQL(), insModels, null);
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
	 * Rate Surcharge데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateSurchargeAmend(List<PriRpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgAmdVOCSQL(), insModels, null);
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
	 * Rate Surcharge Route데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateSurchargeRouteAmend(List<PriRpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutAmdVOCSQL(), insModels, null);
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
	 * Rate Surcharge USCRoute데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateSurchargeUSCRouteAmend(List<PriRpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgUSDRoutCsAmdVOCSQL(), insModels, null);
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
	 * Rate Cargo Spec 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCargoSpecAmend(List<PriRpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecAmdVOCSQL(), insModels, null);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriCostSimulationCheckRouteVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (inCostSimulationCheckRouteVO != null) {
				Map<String, String> mapVO = inCostSimulationCheckRouteVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriCostSimulationCheckRouteVORSQL(), param, velParam);
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
	 * Init Cancel시 Surchage 조정값을 삭제한다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception DAOException
	 */
	public void removeSurchargeAdjustInitCancel(PriRpScpMnVO priRpScpMnVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpScgAdjAllDelVODSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
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
	 * Surcharge View All 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeViewAllVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriSurchargeViewAllVORSQL(), param, velParam);
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
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSurchargeLastAccessDateVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltPriSurchargeLastAccessDateVORSQL(), param, velParam);
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
	 * 이전 AMDT_SEQ에 해당하는 메인의 EXPIRE DATE정보를 조회한다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBeforeExpireDate(PriRpScpMnVO priRpScpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		String sExpDt = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpMnVO != null) {
				Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetBeforeExpDtRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				sExpDt = dbRowset.getString("EXP_DT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sExpDt;
	}

	/**
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<ChkFontStyleVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ChkFontStyleVO> searchFontStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChkFontStyleVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOChkFontStyleVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChkFontStyleVO.class);
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
	 * 조건에 일치하는 최대 Commmodity Header Sequence를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<PriRpScpRtCmdtHdrVO>
	 * @exception DAOException
	 */
	public String searchMaxCmdtHdrSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cmdtHdrSeq = "1";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOMaxCmdtHdrSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				cmdtHdrSeq = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cmdtHdrSeq;
	}

	/**
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param FicRouteGroupVO ficRouteGroupVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGLineVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOFicRouteGroupVORSQL(), param, velParam);
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
	 * Local FIC Guide Line RT Amount 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalFicGlineRtAmt(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String localAmt = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLocalFicGlineRtAmtRSQL(), param, velParam);
			if (dbRowset.next()) {
				localAmt = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return localAmt;
	}

	/**
	 * AEE/AEW용 Rate Route Via 를 삭제한다.
	 * 
	 * @param PriRpScpRtRoutViaVO priRpScpRtRoutViaVO
	 * @exception DAOException
	 */
	public void removeRateRouteViaAll(PriRpScpRtRoutViaVO priRpScpRtRoutViaVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpRtRoutViaVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
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
	 * location code또는 group location code에 CY가 포함돼 있는 확인한다.<br>
	 * 
	 * @param FicCheckCYPortLocationVO ficCheckCYPortLocationVO
	 * @return List<RsltFicCheckCYPortLocationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltFicCheckCYPortLocationVORSQL(), param, velParam);
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
	 * Route Via. 데이터를 갱신한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO priRpScpRtRoutViaVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyRateRouteViaAllStatus(PriRpScpRtRoutViaVO priRpScpRtRoutViaVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtRoutViaVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.putAll(velParam);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaStatusVOUSQL(), param, velParam);
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
	 * AEE.AEW를 위한 Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelForAeeAewVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtListVerticalExcelForAeeAewVO> searchRateListVerticalExcelForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVerticalExcelForAeeAewVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtListVerticalExcelForAeeAewVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListVerticalExcelForAeeAewVO.class);
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
	 * AEE.AEW를 위한 Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelForAeeAewVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtListHorizontalExcelForAeeAewVO> searchRateListHorizontalExcelForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelForAeeAewVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtListHorizontalExcelForAeeAewVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListHorizontalExcelForAeeAewVO.class);
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
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. (History) <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<ChkFontStyleVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ChkFontStyleVO> searchHistoryFontStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChkFontStyleVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOChkHistoryFontStyleVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChkFontStyleVO.class);
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
	 * ROUTE에 대한 ADDON-IHC 값을 조회 한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param boolean addOnFlag
	 * @param String inOrgDestTpCd
	 * @return List<RsltFicRateByRouteVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltFicRateByRouteVO> searchAddOnIhcRateList(PriRpScpRtVO priRpScpRtVO, boolean addOnFlag, String inOrgDestTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltFicRateByRouteVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("add_on_flag", addOnFlag ? "Y" : "N");
		try {
			if (priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("in_out_bound", inOrgDestTpCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltFicRateByRouteRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltFicRateByRouteVO.class);
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
	 * Rate 데이터에 GRI Calculation Validation 처리.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<CheckGRICalculationValidationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CheckGRICalculationValidationVO> checkGRICalculationValidation(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckGRICalculationValidationVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOCheckGRICalculationValidationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckGRICalculationValidationVO.class);
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
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @exception DAOException
	 */
	public void modifyProposalScopeRateGRIApplyForIHC(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs)
			throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			List<String> sparam = new ArrayList<String>();
			if (checkGRICalculationValidationVOs != null) {
				for (int i = 0; i < checkGRICalculationValidationVOs.length; i++) {
					CheckGRICalculationValidationVO c = checkGRICalculationValidationVOs[i];
					sparam.add(c.getPropNo() + "|" + c.getAmdtSeq() + "|" + c.getSvcScpCd() + "|" + c.getCmdtHdrSeq() + "|" + c.getRoutSeq() + "|" + c.getRtSeq());
				}
				if (sparam.size() > 0) {
					velParam.put("v_param", sparam);
				}
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGRIApplyForIHCUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			if (se.getErrorCode() == 30926) {
				throw new DAOException(new ErrorHandler("PRI01999").getMessage());
			} else {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * GRI Cancel<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @return int
	 * @exception DAOException
	 */
	public int modifyProposalScopeRateGRICancelForIHC(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs)
			throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			List<String> sparam = new ArrayList<String>();
			if (checkGRICalculationValidationVOs != null) {
				for (int i = 0; i < checkGRICalculationValidationVOs.length; i++) {
					CheckGRICalculationValidationVO c = checkGRICalculationValidationVOs[i];
					sparam.add(c.getPropNo() + "|" + c.getAmdtSeq() + "|" + c.getSvcScpCd() + "|" + c.getCmdtHdrSeq() + "|" + c.getRoutSeq() + "|" + c.getRtSeq());
				}
				if (sparam.size() > 0) {
					velParam.put("v_param", sparam);
				}
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGRICancelVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
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
	 * Load된 엑셀 데이터의 FIC Rate를 조회한다.
	 * 
	 * @param FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO
	 * @param FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs
	 * @return List<RsltFicGuidelineRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltFicGuidelineRateVO> searchFicGuidelineRateForAeeAew(FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO,
			FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltFicGuidelineRateVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ficRateLoadExcelGuidelineCheckVO != null) {
				Map<String, String> mapVO = ficRateLoadExcelGuidelineCheckVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			velParam.put("route_list", ficRateLoadExcelGuidelineCheckVOs);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltFicGuidelineRateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltFicGuidelineRateVO.class);
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
	 * AEE.AEW를 위한 Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelForAeeAewVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtListVerticalExcelForAddOnTariffVO> searchRateListVerticalExcelForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVerticalExcelForAddOnTariffVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtListVerticalExcelForAddOnTariffVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListVerticalExcelForAddOnTariffVO.class);
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
	 * AEE.AEW를 위한 Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelForAddOnTariffVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtListHorizontalExcelForAddOnTariffVO> searchRateListHorizontalExcelForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelForAddOnTariffVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtListHorizontalExcelForAddOnTariffVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListHorizontalExcelForAddOnTariffVO.class);
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
	 * @param FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO
	 * @param FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs
	 * @param String inOrgDestTpCd
	 * @return List<RsltFicGuidelineRateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltFicGuidelineRateVO> searchFicGuidelineRateForAddOnTariff(FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO,
			FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs, String inOrgDestTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltFicGuidelineRateVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		param.put("in_org_dest_tp_cd", inOrgDestTpCd);
		velParam.put("in_org_dest_tp_cd", inOrgDestTpCd);
		try {
			if (ficRateLoadExcelGuidelineCheckVO != null) {
				Map<String, String> mapVO = ficRateLoadExcelGuidelineCheckVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
			velParam.put("route_list", ficRateLoadExcelGuidelineCheckVOs);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltFicGuidelineRateForAddOnTariffVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltFicGuidelineRateForAddOnTariffVO.class);
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
	 * Rate 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpRtVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateForAddOnTariff(List<PriRpScpRtVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				velParam.putAll(updModels.get(0).getColumnValues());
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOModifyRateForAddOnTariffUSQL(), updModels, velParam);
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
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @exception DAOException
	 */
	public void modifyApplyGRICalculationForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs)
			throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			List<String> sparam = new ArrayList<String>();
			if (checkGRICalculationValidationVOs != null) {
				for (int i = 0; i < checkGRICalculationValidationVOs.length; i++) {
					CheckGRICalculationValidationVO c = checkGRICalculationValidationVOs[i];
					sparam.add(c.getPropNo() + "|" + c.getAmdtSeq() + "|" + c.getSvcScpCd() + "|" + c.getCmdtHdrSeq() + "|" + c.getRoutSeq() + "|" + c.getRtSeq());
				}
				if (sparam.size() > 0) {
					velParam.put("v_param", sparam);
				}
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOModifyApplyGRICalculationForAddOnTariffUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			if (se.getErrorCode() == 30926) {
				throw new DAOException(new ErrorHandler("PRI01999").getMessage());
			} else {
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * GRI Cancel<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @return int
	 * @exception DAOException
	 */
	public int modifyProposalScopeRateGRICancelForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs)
			throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = -1;

		try {
			Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			List<String> sparam = new ArrayList<String>();
			if (checkGRICalculationValidationVOs != null) {
				for (int i = 0; i < checkGRICalculationValidationVOs.length; i++) {
					CheckGRICalculationValidationVO c = checkGRICalculationValidationVOs[i];
					sparam.add(c.getPropNo() + "|" + c.getAmdtSeq() + "|" + c.getSvcScpCd() + "|" + c.getCmdtHdrSeq() + "|" + c.getRoutSeq() + "|" + c.getRtSeq());
				}
				if (sparam.size() > 0) {
					velParam.put("v_param", sparam);
				}
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOModifyProposalScopeRateGRICancelForAddOnTariffUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
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
	 * Rate 데이터에 GRI Calculation Validation 처리.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<CheckGRICalculationValidationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CheckGRICalculationValidationVO> checkGRICalculationValidationForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckGRICalculationValidationVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOCheckGRICalculationValidationRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckGRICalculationValidationVO.class);
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
	 * RFA Type이 Contract 일때, actual customer check<br>
	 * 
	 * @param PriRpScpRtActCustVO priRpScpRtActCustVO
	 * @return List<PriRpScpRtActCustVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PriRpScpRtActCustVO> checkActualCustomer(PriRpScpRtActCustVO priRpScpRtActCustVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpRtActCustVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priRpScpRtActCustVO != null) {
				Map<String, String> mapVO = priRpScpRtActCustVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOCheckActualCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpRtActCustVO.class);
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
	 * Route 중에 term이 빠진 Location check<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpScpRtRoutPntVO>
	 * @exception DAOException
	 */
	public List<PriRpScpRtRoutPntVO> checkRouteTermMissing(PriRpMnVO priRpMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriRpScpRtRoutPntVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priRpMnVO != null) {
				Map<String, String> mapVO = priRpMnVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOCheckRouteTermMissingRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpRtRoutPntVO.class);
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
	 * Rate tab의 Route Detail에 해당하는 모든 Origin/Dest의 장비상태.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String orgDestTpCd
	 * @param String cntrTpszCd
	 * @return List<RsltRtRouteMBListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRouteMBListVO> searchRateRouteMBList(PriRpScpRtVO priRpScpRtVO, String orgDestTpCd, String cntrTpszCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRouteMBListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("org_dest_tp_cd", orgDestTpCd);
		param.put("cntr_tpsz_cd", cntrTpszCd);
		
		try {
			if( priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("org_dest_tp_cd", orgDestTpCd);
				velParam.put("cntr_tpsz_cd", cntrTpszCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRouteMBListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRouteMBListVO.class);
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
	 * Origin/Dest 선택 시 장비 타입 사이즈 별 상태 리스트 조회 이벤트 처리<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String orgDestTpCd
	 * @param String fcntrEccCd
	 * @return List<RsltRtRouteMBListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRtRouteMBListVO> searchRatePortMBList(PriRpScpRtVO priRpScpRtVO, String orgDestTpCd, String fcntrEccCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRouteMBListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		param.put("org_dest_tp_cd", orgDestTpCd);
		param.put("fcntr_ecc_cd", fcntrEccCd);
		
		try {
			if( priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("org_dest_tp_cd", orgDestTpCd);
				velParam.put("fcntr_ecc_cd", fcntrEccCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtRouteMBListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRouteMBListVO.class);
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
	 * Rate M/B 조회 시 플래그 변경 이벤트 처리<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String usrId
	 * @exception DAOException
	 */
	public void modifyPrsMBFlgOnChangeStatus(PriRpScpRtVO priRpScpRtVO, String usrId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			if( priRpScpRtVO != null) {
				Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
				mapVO.put("upd_usr_id", usrId);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpMnPrsMBFlgOnRtUSQL() , param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * Master RFA에서 Note 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRfaNoteConvListVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyMstNoteConv(List<PriRfaNoteConvListVO> updModels, String isAccept) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				velParam.putAll(updModels.get(0).getColumnValues());
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriMstRfaPropConvVOUSQL(), updModels, velParam);
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
	 * [Special Note Conversion] APP 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<RsltNoteConvVO> updateVoList
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] modifyNoteConversionApp(List<RsltNoteConvVO> updateVoList) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (updateVoList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFANoteConversionProposalDBDAOPriRfaNoteConvUSQL(), updateVoList, null);
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
	 * [Route & Summary ] 정보를 [조회] 합니다.<br>
	 * 
	 * @param RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO
	 * @return List<RsltNoteConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<RsltRoutHdrSmryListVO> searchRoutHdrSmryList(RsltRoutHdrSmryListVO rsltRoutHdrSmryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRoutHdrSmryListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRoutHdrSmryListVO != null) {
				Map<String, String> mapVO = rsltRoutHdrSmryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORoutHdrSmryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRoutHdrSmryListVO.class);
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
	 * [Route Max Sequence ] 정보를 [조회] 합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltNoteConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String searchCmdtRoutMaxSeq(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
		String cmdtRoutMaxSeq = "";
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOCmdtRoutMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				cmdtRoutMaxSeq = dbRowset.getString("rout_seq");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cmdtRoutMaxSeq;
	}

	/**
	 * Basic RFA가 상속한 Master RFA의 Route Summary를 조회한다.<br>
	 * isExists가 Y일경우 Basic이 가지고 있는 Route를 N일경우 Basic이 없는 Route를 조회한다.<br> 
	 * (CHM-201642287) <br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @param String mstRfaNo
	 * @param String isExists
	 * @return List<RsltRoutHdrSmryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRoutHdrSmryListVO> searchMstRouteSummaryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO, String mstRfaNo, String isExists) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRoutHdrSmryListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("mst_rfa_no", mstRfaNo);
				velParam.put("is_exists", isExists);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOMstRoutSmryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRoutHdrSmryListVO.class);
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
     * Max Route Seq 구하기<br>
     * 
     * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
     * @return String
     * @exception DAOException
     */
    public String searchMaxCmdtRoutSeq(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
        DBRowSet dbRowset = null;
        String cnt = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtRoutVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetMaxCmdtRouteSeqRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.next()) {
                cnt = dbRowset.getString("max_rout_seq");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cnt;
    }	
    

    /**
     * Master RFA Proposal Scope Rate Commodity Route 정보를 Amend하여 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRoutHdrSmryListVO vo
     * @param List<String> routSeqList
     * @param String rfaTypeCode
     * @exception DAOException
     */
    public void addAmendCopyProposalScopeRtCmdtRoutMst(RsltRoutHdrSmryListVO vo ) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
             
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRoutCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
     * Master RFA Proposal Scope Rate Route Point 정보를 Amend Copy 하여 생성합니다.<br>
     * 
     * @param RsltRoutHdrSmryListVO vo
     * @param List<String> routSeqList
     * @exception DAOException
     */
    public void addAmendCopyProposalScopeRtRoutPntMst(RsltRoutHdrSmryListVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropAmendCpPriRpScpRtRoutPntCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
     * Master RFA Proposal Scope Rate Route Via 정보를 Copy 하여 생성합니다.<br>
     * 
     * @param RsltRoutHdrSmryListVO vo
     * @param List<String> routSeqList
     * @exception DAOException
     */
    public void addAmendCopyProposalScopeRtRoutViaMst(RsltRoutHdrSmryListVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropAmendCpPriRpScpRtRoutViaCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
     * Master RFA Proposal Scope Rate 정보를 Amend Copy 하여 생성합니다.<br>
     * 
     * @param RsltRoutHdrSmryListVO vo
     * @param List<String> routSeqList
     * @exception DAOException
     */
    public void addAmendCopyProposalScopeRtMst(RsltRoutHdrSmryListVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
 

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropAmendCpPriRpScpRtCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
     * Master RFA Proposal Scope Rate Commodity Route Note 정보를 Amend Copy 하여 생성합니다.<br>
     * 
     * @param RsltRoutHdrSmryListVO vo
     * @param List<String> routSeqList
     * @exception DAOException
     */
    public void addAmendCopyProposalScopeRtCmdtRnoteMst(RsltRoutHdrSmryListVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropAmendCpPriRpScpRtCmdtRnoteMstCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
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
     * Master RFA Proposal Scope Rate Commodity Route Note Conversion 정보를 Amend Copy 하여 생성합니다.<br>
     * 
     * @param RsltRoutHdrSmryListVO vo
     * @param List<String> routSeqList
     * @exception DAOException
     */
    public void addAmendCopyProposalRfaNoteConvMst(RsltRoutHdrSmryListVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropAmendCpPriRfaNoteConvMstCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
}