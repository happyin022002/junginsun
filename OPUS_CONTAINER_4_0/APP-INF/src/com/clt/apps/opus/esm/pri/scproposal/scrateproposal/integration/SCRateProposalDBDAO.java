/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateProposalDBDAO.java
 *@FileTitle : SCRateProposalDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.05.25 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.basic.SCRateProposalBCImpl;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.InCostSimulationCheckRouteVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltActCustListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltAllRtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRateTpVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtHdrListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtRnoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCnoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtDtlListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutDestPntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutDestViaListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutDirCallListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutOrgPntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutOrgViaListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScGlineCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListPagingVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListVO;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGriGrpVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpRtActCustVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtVO;
import com.clt.syscommon.common.table.PriSpScpRtCnoteVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutDirVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutViaVO;
import com.clt.syscommon.common.table.PriSpScpRtVO;

/**
 * SCRateProposalDBDAO <br>
 * - SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sungsoo, Park
 * @see SCRateProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class SCRateProposalDBDAO extends DBDAOSupport {

	/**
	 * Rate Type radio button스타일 처리를 위한 조회를 처리합니다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRateTpVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRateTpVO> searchRateType(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRateTpVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltRateTpRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRateTpVO.class);
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
	 * Rate Proposal CMDT Header의 리스트를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
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
	 * Rate Inquiry - Commodity Header를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderInquiryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL(), param, velParam);
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
	 * Rate History - Commodity Header를 조회한다.
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param String isConv
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderHistoryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, String isConv) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("IS_CONVERSION", isConv);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtCmdtHdrHistoryListVORSQL(), param, velParam);
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
	 * RCUD트랜잭션 처리 후, Commodity Group의 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderStyleList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("IS_STYLE", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
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
	 * Rate History - Commodity를 조회한다.
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtDtlListVO> searchRateCommodityDetailList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtCmdtDtlListVORSQL(), param, velParam);
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
	 * Rate Inquiry - Commodity를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtCmdtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtDtlListVO> searchRateCommodityDetailInquiryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtCmdtDtlInquiryListVORSQL(), param, velParam);
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
	 * Rate History - Actual Customer 조회한다.
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltActCustListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltActCustListVO> searchActualCustomerList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltActCustListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltActCustListVORSQL(),
					param, velParam);
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
	 * Rate Inquiry - Actual Customer를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltActCustListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltActCustListVO> searchActualCustomerInquiryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltActCustListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltActCustInquiryListVORSQL(),
					param, velParam);
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
	 * Rate History - Commodity Note를 조회한다.
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCnoteListVO> searchRateCnoteList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCnoteListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltRtCnoteListVORSQL(),
					param, velParam);
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
	 * Rate Inquiry - Commodity Note를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCnoteListVO> searchRateCnoteInquiryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCnoteListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltRtCnoteInquiryListVORSQL(),
					param, velParam);
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
	 * Rate의 Route 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
//			long startLap1;
//			long startLap2;
//			long endLap;

//			startLap1 = System.currentTimeMillis();
//			log.debug("Old ################################################ ExeQuery START : " + startLap1);
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutHdrListVORSQL(), param, velParam);
//			endLap = System.currentTimeMillis();
//			log.debug("Old ################################################ ExeQuery END : " + endLap);
//			log.debug("Old ################################################ ExeQuery Elapse : " + (endLap - startLap1) / 1000.0);
//			startLap2 = System.currentTimeMillis();
//			log.debug("Old ################################################ DS2VOs START : " + startLap2);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
//			endLap = System.currentTimeMillis();
//			log.debug("Old ################################################ DS2VOs END : " + endLap);
//			log.debug("Old ################################################ DS2VOs Elapse : " + (endLap - startLap2) / 1000.0);
//			log.debug("Old ################################################ Total Elapse : " + (endLap - startLap1) / 1000.0);
			
//			startLap1 = System.currentTimeMillis();
//			log.debug("New ################################################ ExeQuery START : " + startLap1);
//			dbRowset = new SQLExecuter("").executeQuery(
//					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutHdrListVO1RSQL(), param, velParam);
//			endLap = System.currentTimeMillis();
//			log.debug("New ################################################ ExeQuery END : " + endLap);
//			log.debug("New ################################################ ExeQuery Elapse : " + (endLap - startLap1) / 1000.0);
//			startLap2 = System.currentTimeMillis();
//			log.debug("New ################################################ DS2VOs START : " + startLap2);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
//			endLap = System.currentTimeMillis();
//			log.debug("New ################################################ DS2VOs END : " + endLap);
//			log.debug("New ################################################ DS2VOs Elapse : " + (endLap - startLap2) / 1000.0);
//			log.debug("New ################################################ Total Elapse : " + (endLap - startLap1) / 1000.0);
			
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
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutHdrListVO> searchRateRouteInquiryList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutHdrInquiryListVORSQL(), param, velParam);
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
	 * Rate History - Route 리스트를 조회한다.
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @param String isConv
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO, String isConv) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("IS_CONVERSION", isConv);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutHdrHistoryListVORSQL(), param, velParam);
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
	 * CUD트랜잭션 처리 후, Route 그리드의 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutHdrListVO> searchRateRouteStyleList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("IS_STYLE", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutHdrListVORSQL(), param, velParam);
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
	 * Rate정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtDtlListVO> searchRateDetailList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltRtDtlListVORSQL(),
					param, velParam);
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
	 * Rate Inquiry - Rate 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtDtlListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtDtlListVO> searchRateDetailInquiryList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltRtDtlInquiryListVORSQL(),
					param, velParam);
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
	 * Origin Point List를 조회합니다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutOrgPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutOrgPntListVO> searchRateRouteOriginPointList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutOrgPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutOrgPntListVORSQL(), param, velParam);
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
	 * Rate Inquiry - Origin Point 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutOrgPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutOrgPntListVO> searchRateRouteOriginPointInquiryList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutOrgPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutOrgPntInquiryListVORSQL(), param, velParam);
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
	 * Origin Via. List를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutOrgViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutOrgViaListVO> searchRateRouteOriginViaList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutOrgViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutOrgViaListVORSQL(), param, velParam);
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
	 * Rate Inquiry - Origin Via. 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutOrgViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutOrgViaListVO> searchRateRouteOriginViaInquiryList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutOrgViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutOrgViaInquiryListVORSQL(), param, velParam);
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
	 * Destination Via. List를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutDestViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutDestViaListVO> searchRateRouteDestinationViaList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDestViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutDestViaListVORSQL(), param, velParam);
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
	 * Rate Inquiry - Destination Via. 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutDestViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutDestViaListVO> searchRateRouteDestinationViaInquiryList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDestViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutDestViaInquiryListVORSQL(), param, velParam);
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
	 * Destination Point List를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutDestPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutDestPntListVO> searchRateRouteDestinationPointList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDestPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutDestPntListVORSQL(), param, velParam);
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
	 * Rate Inquiry - Destination Point 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutDestPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutDestPntListVO> searchRateRouteDestinationPointInquiryList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDestPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutDestPntInquiryListVORSQL(), param, velParam);
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
	 * Route Note List를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtCmdtRnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtRnoteListVO> searchRateCommodityRnoteList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtRnoteListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtCmdtRnoteListVORSQL(), param, velParam);
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
	 * Rate Inquiry - Route Note 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtCmdtRnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtRnoteListVO> searchRateCommodityRnoteInquiryList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtRnoteListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtCmdtRnoteInquiryListVORSQL(), param, velParam);
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
	 * Direct Call 리스트를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutDirCallListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutDirCallListVO> searchRateRouteDirCallList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDirCallListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutDirCallListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDirCallListVO.class);
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
	 * Rate Inquiry - Direct Call 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRtRoutDirCallListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutDirCallListVO> searchRateRouteDirCallInquiryList(PriSpScpRtVO priSpScpRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutDirCallListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtVO != null) {
				Map<String, String> mapVO = priSpScpRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRtRoutDirCallInquiryListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDirCallListVO.class);
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
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVerticalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltRtListVerticalExcelVORSQL(),
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
	 * Rate Proposal Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltRtListHorizontalExcelVORSQL(),
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
	 * Accept All 리스트를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltAllRtListVO> searchAllRateList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltAllRtListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltAllRtListVORSQL(),
					param, velParam);
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
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxBulletDispSeq(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOGetMaxBletDpSeqRSQL(),
					param, velParam);
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
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxOldBulletDispSeq(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				velParam.put("IS_OLD", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOGetMaxBletDpSeqRSQL(),
					param, velParam);
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
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxNoteDispSeq(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSpScpRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priSpScpRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOGetMaxNoteDpSeqRSQL(),
					param, velParam);
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
	 * @param List<PriSpScpRtVO> insModels
	 * @exception DAOException
	 */
	public void addRate(List<PriSpScpRtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVOCSQL(), insModels, null);
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
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @return int
	 * @exception DAOException
	 */
	public int addRateGlineCopy(ScGlineCopyVO scGlineCopyVO) throws DAOException, Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtGlineCpVOCSQL(), param,
					velParam);
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
	 * @param List<PriSpScpRtVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRate(List<PriSpScpRtVO> updModels, String isAccept) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVOUSQL(), updModels,
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRate(List<PriSpScpRtVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVODSQL(), delModels,
						velParam);
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
	 * @param List<PriSpScpRtActCustVO> insModels
	 * @exception DAOException
	 */
	public void addRateActualCustomer(List<PriSpScpRtActCustVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpScpRtActCustVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateActualCustomer(List<PriSpScpRtActCustVO> updModels, String isAccept) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVOUSQL(),
						updModels, velParam);
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
	 * @param List<PriSpScpRtActCustVO> delModels
	 * @exception DAOException
	 */
	public void removeRateActualCustomer(List<PriSpScpRtActCustVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVODSQL(),
						delModels, velParam);
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
	 * Route Note 정보를 생성한다.<br>
	 * 
	 * @param List<PriSpScpRtCnoteVO> insModels
	 * @exception DAOException
	 */
	public void addRateCnote(List<PriSpScpRtCnoteVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVOCSQL(), insModels,
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
	 * Commodity 정보를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpRtCnoteVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCnote(List<PriSpScpRtCnoteVO> updModels, String isAccept) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVOUSQL(), updModels,
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
	 * Commodity Note 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtCnoteVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCnote(List<PriSpScpRtCnoteVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVODSQL(), delModels,
						velParam);
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
	 * @param List<PriSpScpRtCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodity(List<PriSpScpRtCmdtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVOCSQL(), insModels,
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
	 * Guideline의 Commodity 정보를 Copy한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateCommodityGlineCopy(ScGlineCopyVO scGlineCopyVO) throws DAOException, Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtGlineCpVOCSQL(),
					param, velParam);
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
	 * Commodity 정보를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpRtCmdtVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCommodity(List<PriSpScpRtCmdtVO> updModels, String isAccept) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVOUSQL(), updModels,
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
	 * Commodity 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodity(List<PriSpScpRtCmdtVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVODSQL(), delModels,
						velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityHeader(List<PriSpScpRtCmdtHdrVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrVOCSQL(),
						insModels, null);
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
	 * Guideline의 Commodity Header 정보를 Copy한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateCommodityHeaderGlineCopy(ScGlineCopyVO scGlineCopyVO) throws DAOException, Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrGlineCpVOCSQL(),
					param, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCommodityHeader(List<PriSpScpRtCmdtHdrVO> updModels, String isAccept) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrVOUSQL(),
						updModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeader(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCmdt(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVODSQL(), delModels,
						velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeActCust(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCnote(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVODSQL(), delModels,
						velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCmdtRout(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRoutVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutPnt(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutVia(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutDir(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRnote(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRt(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
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
				
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVODSQL(), delModels,
						velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendCmdt(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendActCust(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendCnote(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRoutPnt(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRoutVia(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRoutDir(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRnote(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderDelAmendRt(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVOUSQL(), delModels,
							velParam);
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
	 * @param List<PriSpScpRtCmdtRnoteVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRnote(List<PriSpScpRtCmdtRnoteVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVOCSQL(),
						insModels, null);
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
	 * Guideline의 Commodity Note 정보를 Copy한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateCommodityRnoteGlineCopy(ScGlineCopyVO scGlineCopyVO) throws DAOException, Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteGlineCpVOCSQL(),
					param, velParam);
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
	 * Route Note 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpRtCmdtRnoteVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCommodityRnote(List<PriSpScpRtCmdtRnoteVO> updModels, String isAccept) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVOUSQL(),
						updModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRnoteVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRnote(List<PriSpScpRtCmdtRnoteVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRoute(List<PriSpScpRtCmdtRoutVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRoutVOCSQL(),
						insModels, null);
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
	 * Guideline의 Route 정보를 Copy한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateCommodityRouteGlineCopy(ScGlineCopyVO scGlineCopyVO) throws DAOException, Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRoutGlineCpVOCSQL(),
					param, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateCommodityRoute(List<PriSpScpRtCmdtRoutVO> updModels, String isAccept) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRoutVOUSQL(),
						updModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRoute(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRoutVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRoutPnt(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRoutVia(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRoutDir(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRnote(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteCascadeRt(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
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

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVODSQL(), delModels,
						velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRoutPnt(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRoutVia(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRoutDir(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRnote(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVOUSQL(),
							delModels, velParam);
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
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRouteDelAmendRt(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");
				if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
					velParam.put("IS_DEL_AMEND", "Y");

					delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVOUSQL(), delModels,
							velParam);
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
	 * Direct Call 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSpScpRtRoutDirVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteDirectCall(List<PriSpScpRtRoutDirVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVOCSQL(),
						insModels, null);
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
	 * Guideline의 Direct Call 정보를 Copy한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateRouteDirectCallGlineCopy(ScGlineCopyVO scGlineCopyVO) throws DAOException, Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirGlineCpVOCSQL(),
					param, velParam);
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
	 * Direct Call 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriSpScpRtRoutDirVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateRouteDirectCall(List<PriSpScpRtRoutDirVO> updModels, String isAccept) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVOUSQL(),
						updModels, velParam);
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
	 * Direct Call 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtRoutDirVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRouteDirectCall(List<PriSpScpRtRoutDirVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVODSQL(),
						delModels, velParam);
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
	 * Route Point 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSpScpRtRoutPntVO> insModels
	 * @exception DAOException
	 */
	public void addRateRoutePoint(List<PriSpScpRtRoutPntVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVOCSQL(),
						insModels, null);
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
	 * Guideline의 Route Point 정보를 Copy한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateRoutePointGlineCopy(ScGlineCopyVO scGlineCopyVO) throws DAOException, Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntGlineCpVOCSQL(),
					param, velParam);
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
	 * @param List<PriSpScpRtRoutPntVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateRoutePoint(List<PriSpScpRtRoutPntVO> updModels, String isAccept) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVOUSQL(),
						updModels, velParam);
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
	 * @param List<PriSpScpRtRoutPntVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRoutePoint(List<PriSpScpRtRoutPntVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVODSQL(),
						delModels, velParam);
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
	 * @param List<PriSpScpRtRoutViaVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteVia(List<PriSpScpRtRoutViaVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVOCSQL(),
						insModels, null);
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
	 * Guideline의 Route Via. 정보를 Copy한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @exception DAOException
	 */
	public void addRateRouteViaGlineCopy(ScGlineCopyVO scGlineCopyVO) throws DAOException, Exception {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaGlineCpVOCSQL(),
					param, velParam);
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
	 * @param List<PriSpScpRtRoutViaVO> updModels
	 * @param String isAccept
	 * @exception DAOException
	 */
	public void modifyRateRouteVia(List<PriSpScpRtRoutViaVO> updModels, String isAccept) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		velParam.put("IS_ACCEPT", isAccept);

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVOUSQL(),
						updModels, velParam);
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
	 * @param List<PriSpScpRtRoutViaVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRouteVia(List<PriSpScpRtRoutViaVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVODSQL(),
						delModels, velParam);
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
	 * Route Note의 Display Sequence를 재배열한다.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @param String cascadeLevel
	 * @exception DAOException
	 */
	public void modifyRouteNoteDispSeq(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO, String cascadeLevel) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		HashMap<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = priSpScpRtCmdtRoutVO.getColumnValues();
			param.putAll(mapVO);

			velParam.put("CASCADE_LEVEL", cascadeLevel);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOReorderRouteNoteDpSeqUSQL(), param,
					velParam);
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
	 * Guideline Copy전 Group Location, Group Commodity가 존재하는지 확인한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	public RsltCdListVO searchGlineCopyGroupCodeExist(ScGlineCopyVO scGlineCopyVO) throws DAOException {
		DBRowSet dbRowset = null;
		RsltCdListVO rsltVO = new RsltCdListVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (scGlineCopyVO != null) {
				Map<String, String> mapVO = scGlineCopyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAOGlineCpChkGrpLocExistRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				rsltVO.setEtc1(dbRowset.getString("cnt"));
			}

			dbRowset = null;
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAOGlineCpChkGrpCmdtExistRSQL(), param, velParam);
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
	 * Rate의 모든 항목을 Accept/Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateCmdt(PriSpScpRtVO priSpScpRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVOUSQL(), param, velParam);
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
	 * Rate의 모든 항목을 Accept/Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateActCust(PriSpScpRtVO priSpScpRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVOUSQL(), param,
					velParam);
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
	 * Rate의 모든 항목을 Accept/Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateCnote(PriSpScpRtVO priSpScpRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVOUSQL(), param,
					velParam);
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
	 * Rate의 모든 항목을 Accept/Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRoutPnt(PriSpScpRtVO priSpScpRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVOUSQL(), param,
					velParam);
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
	 * Rate의 모든 항목을 Accept/Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRoutVia(PriSpScpRtVO priSpScpRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVOUSQL(), param,
					velParam);
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
	 * Rate의 모든 항목을 Accept/Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRoutDir(PriSpScpRtVO priSpScpRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVOUSQL(), param,
					velParam);
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
	 * Rate의 모든 항목을 Accept/Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRnote(PriSpScpRtVO priSpScpRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVOUSQL(), param,
					velParam);
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
	 * Rate의 모든 항목을 Accept/Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRt(PriSpScpRtVO priSpScpRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVOUSQL(), param, velParam);
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
	 * Actual Customer의 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateActualCustomerAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustAmdVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCnoteAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteAmdVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtAmdVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityHeaderAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrAmdVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRouteAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRoutAmdVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtAmdVOCSQL(), insModels,
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
	 * Rate Direct 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteDirectAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirAmdVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRnoteAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteAmdVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateRoutePointAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntAmdVOCSQL(),
						insModels, null);
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
	 * @param List<PriSpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteViaAmend(List<PriSpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaAmdVOCSQL(),
						insModels, null);
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
     * S/C Proposal Scope Rate Commodity Header 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCmdtHdr(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtCmdtHdrCSQL(),
                    param, velParam);
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
     * S/C Proposal Scope Rate Actual Customer 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtActCust(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtActCustCSQL(),
                    param, velParam);
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
     * S/C Proposal Scope Rate Commodity 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCmdt(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtCmdtCSQL(), param,
                    velParam);
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
     * S/C Proposal Scope Rate Commodity Note 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCnote(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtCnoteCSQL(), param,
                    velParam);
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
     * S/C Proposal Scope Rate Commodity Route 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCmdtRout(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtCmdtRoutCSQL(),
                    param, velParam);
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
     * S/C Proposal Scope Rate Route Point 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtRoutPnt(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtRoutPntCSQL(),
                    param, velParam);
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
     * S/C Proposal Scope Rate Route Direct 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtRoutDir(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtRoutDirCSQL(),
                    param, velParam);
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
     * S/C Proposal Scope Rate Route Via 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtRoutVia(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtRoutViaCSQL(),
                    param, velParam);
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
     * S/C Proposal Scope Rate 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRt(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtCSQL(), param,
                    velParam);
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
     * S/C Proposal Scope Rate Commodity Route Note 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCmdtRnote(RsltPropCopyVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPropCpPriSpScpRtCmdtRnoteCSQL(),
                    param, velParam);
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
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO priSpScpGriGrpVO
	 * @exception DAOException
	 */
	public void modifyProposalScopeRateGRIApply(PriSpScpGriGrpVO priSpScpGriGrpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtGRIApplyVOUSQL(), param,
					velParam);
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
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO priSpScpGriGrpVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyProposalScopeRateGRICancel(PriSpScpGriGrpVO priSpScpGriGrpVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = -1;
		
		try {
			Map<String, String> mapVO = priSpScpGriGrpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtGRICancelVOUSQL(), param,
					velParam);
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
	
//
//	/**
//	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
//	 * 
//	 * @param PriSpScpMnVO priSpScpMnVO
//	 * @exception DAOException
//	 */
//	public void removeProposalMainTmp(PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();
//
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//
//			velParam.put("CASCADE_LEVEL", "0");
//			velParam.put("IS_ACCEPT", "N");
//
//			int result = -1;
//			SQLExecuter sqlExe = new SQLExecuter("");
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtScgVODSQL(), param, velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtScgRoutVODSQL(), param, velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//			
//			/*
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtUsdRoutCsVODSQL(), param, velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//			*/
//			
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVODSQL(), param, velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVODSQL(), param,
//					velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVODSQL(), param,
//					velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVODSQL(), param,
//					velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVODSQL(), param,
//					velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRoutVODSQL(), param,
//					velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVODSQL(), param,
//					velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVODSQL(), param,
//					velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe
//					.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVODSQL(), param, velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrVODSQL(), param,
//					velParam);
//			if (result == Statement.EXECUTE_FAILED) {
//				throw new DAOException("Fail to insert SQL");
//			}
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtCmdtHdr (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrVODSQL(), param,
					velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtCmdt (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe
			.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVODSQL(), param, velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtActCust (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVODSQL(), param,
					velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtCnote (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVODSQL(), param,
					velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtCmdtRout (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRoutVODSQL(), param,
					velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtCmdtRnote (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVODSQL(), param,
					velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtRoutDir (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVODSQL(), param,
					velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtRoutPnt (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVODSQL(), param,
					velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRtRoutVia (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVODSQL(), param,
					velParam);
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
	 * Main Proposal 에서 Init Cancel 시 Service Scope 이상 레벨에서의 Rate 전체를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception DAOException
	 */
	public void removeProposalRt (PriSpScpMnVO priSpScpMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSpScpMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("CASCADE_LEVEL", "0");
			velParam.put("IS_ACCEPT", "N");
			int result = -1;
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtVODSQL(), param, velParam);
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
	 * S/C Proposal을 Request 할때 자동으로 Accept를 합니다.<br>
	 * 
	 * @param PriSpScpRtVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptRateDirectCall(PriSpScpRtVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtDirectActVOUSQL(), param,
					velParam);
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
	 * Guideline Rate Commodity Header 를 Proposal Scope 에 Copy 합니다.<br>
	 * 
	 * @param SpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateCmdtHdr(SpScpGlineCopyVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOGlineCopyPriSpScpRtCmdtHdrCSQL(),
					param, velParam);
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
	 * @param SpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateCmdt(SpScpGlineCopyVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOGlineCopyPriSpScpRtCmdtCSQL(),
					param, velParam);
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
	 * @param SpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateCmdtRout(SpScpGlineCopyVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOGlineCopyPriSpScpRtCmdtRoutCSQL(),
					param, velParam);
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
	 * @param SpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateRoutPnt(SpScpGlineCopyVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOGlineCopyPriSpScpRtRoutPntCSQL(),
					param, velParam);
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
	 * Guideline Rate Route Direct 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param SpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateRoutDir(SpScpGlineCopyVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOGlineCopyPriSpScpRtRoutDirCSQL(),
					param, velParam);
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
	 * @param SpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateRoutVia(SpScpGlineCopyVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOGlineCopyPriSpScpRtRoutViaCSQL(),
					param, velParam);
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
	 * Guideline Rate Commodity RNote 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param SpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRateCmdtRnote(SpScpGlineCopyVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOGlineCopyPriSpScpRtCmdtRnoteCSQL(),
					param, velParam);
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
	 * @param SpScpGlineCopyVO vo
	 * @exception DAOException
	 */
	public void addCopyScopeGuidelineRate(SpScpGlineCopyVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOGlineCopyPriSpScpRtCSQL(), param,
					velParam);
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

//	/**
//	 * c/offer 이 있는 terms 에서 returned 인 데이터를 조회한다.<br>
//	 * 
//	 * @param priSpMnVO PriSpMnVO
//	 * @return List<RsltReturnVO>
//	 * @exception DAOException
//	 */
//	@SuppressWarnings("unchecked")
//	public List<RsltReturnVO> searchProposalReturnedList(PriSpMnVO priSpMnVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		List<RsltReturnVO> list = null;
//		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		// velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try {
//			if (priSpMnVO != null) {
//				Map<String, String> mapVO = priSpMnVO.getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltReturnVORSQL(),
//					param, velParam);
//			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltReturnVO.class);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return list;
//	}
	
	
	
	/**
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRtActCustReqCnl(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustRequestCancelVOUSQL(),
					param, velParam);
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
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRtCmdtReqCnl(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRequestCancelVOUSQL(),
					param, velParam);
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
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRtCmdtRnoteReqCnl(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteRequestCancelVOUSQL(), param, velParam);
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
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRtCnoteReqCnl(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteRequestCancelVOUSQL(),
					param, velParam);
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
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRtReqCnl(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRequestCancelVOUSQL(), param,
					velParam);
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
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRtRoutDirReqCnl(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRouteDirRequestCancelVOUSQL(), param, velParam);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRtRoutPntReqCnl(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutePntRequestCancelVOUSQL(), param, velParam);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRtRoutViaReqCnl(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRouteViaRequestCancelVOUSQL(), param, velParam);
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO vo
	 * @exception EventException
	 */
	public void modifyProposalRequestCanceltmp(PriSpScpMnVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustRequestCancelVOUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRequestCancelVOUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteRequestCancelVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteRequestCancelVOUSQL(),
					param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRequestCancelVOUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRouteDirRequestCancelVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutePntRequestCancelVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRouteViaRequestCancelVOUSQL(), param, velParam);
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
	 * 해당 코드가 실제 DB에 존재하는 값인지 확인한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchActualCustomerExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOLoadExcelCheckActCustRSQL(), param, null);
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
	 * 해당 코드가 실제 DB에 존재하는 값인지 확인한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchCommodityCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);
			
			if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOLoadExcelCheckGrpCmdtRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 6) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOLoadExcelCheckCmdtRSQL(), param, null);
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
	 * 해당 코드가 실제 DB에 존재하는 값인지 확인한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return RsltCdListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RsltCdListVO searchLocationCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = rsltCdListVO.getColumnValues();
			param.putAll(mapVO);
			
			if (rsltCdListVO.getCd().length() == 4) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOLoadExcelCheckGrpLocRSQL(), param, null);
			} else if (rsltCdListVO.getCd().length() == 5) {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOLoadExcelCheckLocRSQL(), param, null);
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
	 * SCRateProposalDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNextCmdtHdrSeq(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		int nextSeq = -1;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();
			param.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOGetNextCmdtHdrSeqRSQL(), param, null);
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
	
	/**
	 * View All Rates 리스트 Paging 조회를 위해 Total Count를 조회한다.<br>
	 * 
	 * @param ViewAllRatesListPagingVO viewAllRatesListPagingVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public int searchViewAllRatesListTotalCnt(ViewAllRatesListPagingVO viewAllRatesListPagingVO) throws DAOException {
		int cnt = 0;
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (viewAllRatesListPagingVO != null) {
				Map<String, String> mapVO = viewAllRatesListPagingVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOViewAllRatesListTotalCntVORSQL(),	param, velParam);
			if(dbRowset.next()){
				cnt = dbRowset.getInt(1);
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
	 * ScrateProposal View All Rate를 페이징 조회한다.<br>
	 * paging 조회한다.<br> 
	 * 
	 * @param ViewAllRatesListPagingVO viewAllRatesListPagingVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchViewAllRatesListPaging(ViewAllRatesListPagingVO viewAllRatesListPagingVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (viewAllRatesListPagingVO != null) {
				Map<String, String> mapVO = viewAllRatesListPagingVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOViewAllRatesListPagingVORSQL(),	param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}

	/**
	 * View All Rates 리스트를 조회한다.<br>
	 * 
	 * @param ViewAllRatesListVO viewAllRatesListVO
	 * @return List<ViewAllRatesListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ViewAllRatesListVO> searchViewAllRatesList(ViewAllRatesListVO viewAllRatesListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ViewAllRatesListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (viewAllRatesListVO != null) {
				Map<String, String> mapVO = viewAllRatesListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOViewAllRatesListVORSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ViewAllRatesListVO.class);
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
					(ISQLTemplate) new SCRateProposalDBDAORsltPriCostSimulationCheckRouteVORSQL(), param, velParam);
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
     * Conversion Update 시 Amend Seq.를 기준으로 다음 Amend Seq의 NOTE_CHG_TP_CD를 수정한다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void modifyConversionCNote(PriSpMnVO priSpMnVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOConversionCnoteUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }		
    
    /**
     * Conversion Update 시 Amend Seq.를 기준으로 다음 Amend Seq의 NOTE_CHG_TP_CD를 수정한다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @exception DAOException
     */
    public void modifyConversionRNote(PriSpMnVO priSpMnVO) throws DAOException,Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priSpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOConversionRnoteUSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to update SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }	  
    
    
    /****************************************************************************************/
	/* ESM_PRI_0099  Start*/
	/****************************************************************************************/
	
    /**
	 * Retrieving BackEndJob's status value<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws DAOException,Exception {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch (SQLException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch (InterruptedException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * check the Excel Info.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param RsltRtListHorizontalExcelVO rsltRtListHorizontalExcelVO
     * @return List<RsltRtListHorizontalExcelVO>
     * @exception DAOException
     */
    public List<RsltRtListHorizontalExcelVO> chkPriRateExl(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO rsltRtListHorizontalExcelVO) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRtListHorizontalExcelVO != null) {
				Map<String, String> mapVO = rsltRtListHorizontalExcelVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if (priSpScpRtCmdtHdrVO != null) {
				param.put("prop_no", priSpScpRtCmdtHdrVO.getPropNo());
				param.put("amdt_seq", priSpScpRtCmdtHdrVO.getAmdtSeq());
				param.put("svc_scp_cd", priSpScpRtCmdtHdrVO.getSvcScpCd());
				param.put("gen_spcl_rt_tp_cd", priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());

				
				velParam.put("prop_no", priSpScpRtCmdtHdrVO.getPropNo());
				velParam.put("amdt_seq", priSpScpRtCmdtHdrVO.getAmdtSeq());
				velParam.put("svc_scp_cd", priSpScpRtCmdtHdrVO.getSvcScpCd());
				velParam.put("gen_spcl_rt_tp_cd", priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltPriRateHorizontalExcelChkVORSQL(), param, velParam);
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
	 * rerive the max of Rout Seq<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNextRoutSeq(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
		int nextSeq = -1;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();
			param.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOGetNextRoutSeqRSQL(), param, null);
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
	
	/**
	 * rerive the count number that the CmdtHdrSeq exist<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return int
	 * @exception DAOException
	 */
//	public int searchCntCmdtHdrSeq(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws DAOException {
//		int nextSeq = -1;
//		DBRowSet dbRowset = null;
//
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		try {
//			Map<String, String> mapVO = priSpScpRtCmdtHdrVO.getColumnValues();
//			param.putAll(mapVO);
//				
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAOGetCountCmdtHdrSeqRSQL(), param, null);
//			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
//				nextSeq = dbRowset.getInt("cmdt_hdr_seq_cnt");
//			}
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return nextSeq;
//	}
    
    /**
     * search Rate Info.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO vo
     * @param String cmdtHdrSeq
     * @param String routSeq
     * @param String prcCgoTpCd
     * @return List<PriSpScpRtVO>
     * @exception DAOException
     */
    public List<PriSpScpRtVO> searchPriSpScpRtList(PriSpScpRtCmdtHdrVO vo, String cmdtHdrSeq, String routSeq, String prcCgoTpCd) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriSpScpRtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("cmdt_hdr_seq",cmdtHdrSeq);
				velParam.put("cmdt_hdr_seq",cmdtHdrSeq);
				param.put("rout_seq",routSeq);
				velParam.put("rout_seq",routSeq);
				param.put("prc_cgo_tp_cd",prcCgoTpCd);
				velParam.put("prc_cgo_tp_cd",prcCgoTpCd);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltPriSpScpRtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpRtVO.class);
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
     * search Rout Via Info.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO vo
     * @param String routViaPortTpCd
     * @param String cmdtHdrSeq
     * @param String routSeq
     * @return List<PriSpScpRtRoutViaVO>
     * @exception DAOException
     */
    public List<PriSpScpRtRoutViaVO> searchPriSpScpRtRoutViaList(PriSpScpRtCmdtHdrVO vo, String routViaPortTpCd, String cmdtHdrSeq, String routSeq ) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriSpScpRtRoutViaVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("cmdt_hdr_seq",cmdtHdrSeq);
			velParam.put("cmdt_hdr_seq",cmdtHdrSeq);
			param.put("org_dest_tp_cd", routViaPortTpCd);
			velParam.put("org_dest_tp_cd", routViaPortTpCd);
			param.put("rout_seq",routSeq);
			velParam.put("rout_seq",routSeq);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRsltPriSpScpRtRoutViaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpRtRoutViaVO.class);
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
     * search Rout Info.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO vo
     * @param String orgDestTpCd
     * @param String cmdtHdrSeq
     * @param String routSeq
     * @return List<PriSpScpRtRoutPntVO>
     * @exception DAOException
     */
    public List<PriSpScpRtRoutPntVO> searchPriSpScpRtRoutPntList(PriSpScpRtCmdtHdrVO vo, String orgDestTpCd, String cmdtHdrSeq, String routSeq ) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriSpScpRtRoutPntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("cmdt_hdr_seq",cmdtHdrSeq);
			velParam.put("cmdt_hdr_seq",cmdtHdrSeq);
			param.put("org_dest_tp_cd", orgDestTpCd);
			velParam.put("org_dest_tp_cd", orgDestTpCd);
			param.put("rout_seq",routSeq);
			velParam.put("rout_seq",routSeq);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRsltPriSpScpRtRoutPntRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpRtRoutPntVO.class);
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
     * search Rout Dir Info.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO vo
     * @param String cmdtHdrSeq
     * @param String routSeq
     * @return List<PriSpScpRtRoutDirVO>
     * @exception DAOException
     */
    public List<PriSpScpRtRoutDirVO> searchPriSpScpRtRoutDirList(PriSpScpRtCmdtHdrVO vo, String cmdtHdrSeq, String routSeq) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriSpScpRtRoutDirVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("cmdt_hdr_seq",cmdtHdrSeq);
				velParam.put("cmdt_hdr_seq",cmdtHdrSeq);
				param.put("rout_seq",routSeq);
				velParam.put("rout_seq",routSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRsltPriSpScpRoutDirRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpRtRoutDirVO.class);
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
     * search Commodity Customer Info.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO vo
     * @return List<PriSpScpRtActCustVO>
     * @exception DAOException
     */
    public List<PriSpScpRtActCustVO> searchPriSpScpRtActCustList(PriSpScpRtCmdtHdrVO vo) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriSpScpRtActCustVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateProposalDBDAORsltRsltPriSpScpRtActCustRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpRtActCustVO.class);
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
     * search Commodity Info.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO vo
     * @return List<PriSpScpRtCmdtVO>
     * @exception DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PriSpScpRtCmdtVO> searchPriSpScpRtCmdtList(PriSpScpRtCmdtHdrVO vo) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriSpScpRtCmdtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateProposalDBDAORsltRsltPriSpScpRtCmdtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpRtCmdtVO.class);
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
	 * Rout Dir 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtRoutDirVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeRoutDir(List<PriSpScpRtRoutDirVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirVODSQL(),
						delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
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
	 * @param PriSpScpRtCmdtRoutVO vo
	 * @param String cgoTpCd
	 * @exception DAOException
	 */
	public void removeRateCascadeRt(PriSpScpRtCmdtRoutVO vo, String cgoTpCd) throws DAOException, Exception {
		
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = -1;
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("prc_cgo_tp_cd", cgoTpCd);
			velParam.put("CASCADE_LEVEL", "2");
			velParam.put("IS_ACCEPT", "N");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtForExlVODSQL(), param,
					velParam);
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
	 * ROUT 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeCmdtRout(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpCmdtRoutVODSQL(), delModels,
						velParam);
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
	 * Route Via 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeRoutVia(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaVODSQL(),
						delModels, velParam);
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
	 * Route Pnt 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeRoutPnt(List<PriSpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");
				velParam.put("IS_ACCEPT", "N");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntVODSQL(),
						delModels, velParam);
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
	 * Commodity Customer 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeActCust(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustVODSQL(),
						delModels, velParam);
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
	 * Commodity 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSpScpRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeCmdt(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");
				velParam.put("IS_ACCEPT", "N");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtVODSQL(), delModels,
						velParam);
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
	
//	/**
//	 * Commodity Header 데이터를 삭제한다.<br>
//	 * 
//	 * @param List<PriSpScpRtCmdtHdrVO> delModels
//	 * @exception DAOException
//	 */
//	public void removeRateCascadeCommodityHeader(List<PriSpScpRtCmdtHdrVO> delModels) throws DAOException, Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if (delModels.size() > 0) {
//				HashMap<String, Object> velParam = new HashMap<String, Object>();
//				velParam.put("CASCADE_LEVEL", "1");
//				velParam.put("IS_ACCEPT", "N");
//
//				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrVODSQL(),
//						delModels, velParam);
//				for (int i = 0; i < delCnt.length; i++) {
//					if (delCnt[i] == Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No" + i + " SQL");
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * SC Commodity Route note정보를 PRC_PROG_STS_CD = 'I', SRC_INFO_CD = 'AD'로 수정합니다.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO vo
	 * @exception DAOException
	 */
	public void modifyProposalScopeCmdtRouteRnote(PriSpScpRtCmdtRoutVO vo) throws DAOException, Exception {	
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);


			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVOXlsUSQL(), param,
					null);
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
	 * Commodity Header 데이터를 생성한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO vo
	 * @exception DAOException
	 */
	public void addRateCommodityHeaderForExcel(PriSpScpRtCmdtHdrVO vo) throws DAOException, Exception {
		
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtHdrVOForExlCSQL(), param,
                    velParam);
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
	 * Commodity 데이터를 생성한다.<br>
	 * 
	 * @param PriSpScpRtCmdtVO vo
	 * @exception DAOException
	 */
	public void addRateCommodityForExcel(PriSpScpRtCmdtVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtForExlVOCSQL(), param,
                    velParam);
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
	 * Actual Customer 데이터를 생성한다.<br>
	 * 
	 * @param PriSpScpRtActCustVO vo
	 * @exception DAOException
	 */
	public void addRateActualCustomerForExcel(PriSpScpRtActCustVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtActCustForExlCSQL(), param,
                    velParam);
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
	 * Route Point 데이터를 생성한다.<br>
	 * 
	 * @param PriSpScpRtRoutPntVO vo
	 * @exception DAOException
	 */
	public void addRateRoutePointForExcel(PriSpScpRtRoutPntVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutPntForExlVOCSQL(), param,
                    velParam);
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
	 * Route Via. 데이터를 생성한다.<br>
	 * 
	 * @param PriSpScpRtRoutViaVO vo
	 * @exception DAOException
	 */
	public void addRateRouteViaForExcel(PriSpScpRtRoutViaVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutViaForExlVOCSQL(), param,
                    velParam);
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
	 * Direct Call 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSpScpRtRoutDirVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteDirectCallForExcel(List<PriSpScpRtRoutDirVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtRoutDirForExlVOCSQL(),
						insModels, null);
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
	 * @param PriSpScpRtVO vo
	 * @exception DAOException
	 */
	public void addRateForExcel(PriSpScpRtVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtForExlVOCSQL(), param, velParam);
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
	 * 존재하는 Commodity Note 데이터를 Copy 하여 새로 생성한다.<br>
	 * 
	 * @param PriSpScpRtCnoteVO vo
	 * @exception DAOException
	 */
	public void addRateCommodityNoteForExcel(PriSpScpRtCnoteVO vo) throws DAOException, Exception {		
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");            
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCnoteVOForExlCSQL(), param, velParam);
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
	 * 존재하는 Route Note 데이터를 Copy 하여 새로 생성한다.<br>
	 * 
	 * @param PriSpScpRtCmdtRnoteVO vo
	 * @exception DAOException
	 */
	public void addRateRouteNoteForExcel(PriSpScpRtCmdtRnoteVO vo) throws DAOException, Exception {		
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriSpScpRtCmdtRnoteVOForExlCSQL(), param, velParam);
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
	 * 존재하는 Note Conversion 데이터를 Copy 하여 새로 생성한다.<br>
	 * 
	 * @param PriSpScpRtCmdtRnoteVO vo
	 * @exception DAOException
	 */
	public void addNoteConvForExcel(PriSpScpRtCmdtRnoteVO vo) throws DAOException, Exception {		
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
            int result = 0 ;

            SQLExecuter sqlExe = new SQLExecuter("");
            if(vo.getAcptUsrId()!= null && vo.getAcptOfcCd()==null){
            	result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriScNoteConvForExlCSQL(), param, velParam);
            }else{
            	result = sqlExe.executeUpdate((ISQLTemplate) new SCRateProposalDBDAOPriScNoteConvRouteForExlCSQL(), param, velParam);
            }
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
    /****************************************************************************************/
	/* ESM_PRI_0099  End*/
	/****************************************************************************************/
	
}