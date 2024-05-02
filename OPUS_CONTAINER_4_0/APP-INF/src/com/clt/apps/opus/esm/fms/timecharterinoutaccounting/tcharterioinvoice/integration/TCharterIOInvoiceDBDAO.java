/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TCharterIOInvoiceDAO.java
 *@FileTitle : Invoice
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.13
 *@LastModifier : 정윤태
 *@LastVersion : 1.0
 * 2009.04.13 정윤태
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCharterInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchCalPrepaymentInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceAutoMatchVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOwnerInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomManHrChgVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOwnrAcctSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchChaterInvoiceSdmsListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceAutoMatchListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListSumVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByCharterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByOffHireVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchInvoiceListByRevenueSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterListByPaymentSlipVO;

/**
 * OPUS TCharterIOInvoiceDAO <br>
 * - OPUS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jung Yoon-Tae
 * @see TCharterIOInvoiceBCImpl 참조
 * @since J2EE 1.5
 */
@SuppressWarnings("serial")
public class TCharterIOInvoiceDBDAO extends DBDAOSupport {

	/**
	 * Charterer's Account 화면에서 조회조건에 해당되는 값을 불러온다.<br>
	 * 용선주 비용에 관련된 계정을 조회한다
	 * 
	 * @param condCharterInvoiceVO
	 *            CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCharterInvoiceListVO> searchCharterInvoiceList(CondCharterInvoiceVO condCharterInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCharterInvoiceListVO> searchCharterInvoiceListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condCharterInvoiceVO != null) {
				Map<String, String> mapVO = condCharterInvoiceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULTXA").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCharterInvoiceListRSQL(), param, velParam);
			searchCharterInvoiceListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCharterInvoiceListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchCharterInvoiceListVO;
	}

	/**
	 * Charterer's Account 화면에서 조회조건에 해당되는 값을 불러온다.<br>
	 * 용선주 비용에 관련된 계정을 조회한다
	 * 
	 * @param condCharterInvoiceVO
	 *            CondCharterInvoiceVO
	 * @return List<SearchCharterInvoiceSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCharterInvoiceSumVO> searchCharterInvoiceSum(CondCharterInvoiceVO condCharterInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCharterInvoiceSumVO> searchCharterInvoiceSumVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condCharterInvoiceVO != null) {
				Map<String, String> mapVO = condCharterInvoiceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("DEFAULTXA").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCharterInvoiceSumRSQL(), param, velParam);
			searchCharterInvoiceSumVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCharterInvoiceSumVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchCharterInvoiceSumVO;
	}

	/**
	 * fletCtrtNo와 bnkYrmon에 해당하는 항차 가져오기<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param revYrmon
	 *            String
	 * @return List<SearchVvdListByCharterVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVvdListByCharterVO> searchVvdListByCharter(String fletCtrtNo, String revYrmon) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchVvdListByCharterVO> searchVvdListByCharterVO = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("rev_yrmon", revYrmon);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchVvdListByCharterRSQL(), param, null);
			searchVvdListByCharterVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchVvdListByCharterVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchVvdListByCharterVO;
	}

	/**
	 * 용선주 비용을 입력한다<br>
	 * 
	 * @param customInvoiceVO
	 *            CustomInvoiceVO
	 * @throws DAOException
	 *             , Exception
	 */
	public void addCharterInvoice(CustomInvoiceVO customInvoiceVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = customInvoiceVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("DEFAULTXA");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAOAddCharterInvoiceCSQL(), param, null);
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
	 * 용선주 비용을 입력한다<br>
	 * 
	 * @param customInvDtlVO
	 *            List<CustomInvDtlVO> 데이터객체 배열
	 * @throws DAOException
	 *             , Exception
	 */
	public void addCharterInvDtls(List<CustomInvDtlVO> customInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULTXA");
			int insCnt[] = null;
			if (customInvDtlVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAOAddCharterInvDtlsCSQL(), customInvDtlVO, null);
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
	 * 용선주 비용을 변경한다<br>
	 * 
	 * @param customInvDtlVO
	 *            List<CustomInvDtlVO> 데이터객체 배열
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifytCharterInvDtls(List<CustomInvDtlVO> customInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULTXA");
			int updCnt[] = null;
			if (customInvDtlVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAOModifytCharterInvDtlsUSQL(), customInvDtlVO, null);
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
	 * 용선주 비용을 삭제한다<br>
	 * 
	 * @param customInvDtlVO
	 *            List<CustomInvDtlVO> 데이터객체 배열
	 * @throws DAOException
	 *             , Exception
	 */
	public void removeCharterInvDtls(List<CustomInvDtlVO> customInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DEFAULTXA");
			int delCnt[] = null;
			if (customInvDtlVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAORemoveCharterInvDtlsDSQL(), customInvDtlVO, null);
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
	 * Owner Accout 정보를 조회한다<br>
	 * 
	 * @param condSearchOwnerInvoiceVO
	 *            CondSearchOwnerInvoiceVO
	 * @return List<SearchOwnerInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOwnerInvoiceListVO> searchOwnerInvoiceList(CondSearchOwnerInvoiceVO condSearchOwnerInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condSearchOwnerInvoiceVO != null) {
				Map<String, String> mapVO = condSearchOwnerInvoiceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpRSQL(), param, velParam);
			searchOwnerInvoiceListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerInvoiceListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOwnerInvoiceListVO;
	}

	/**
	 * Owner Accout 정보를 변경한다<br>
	 * 
	 * @param customOwnrAcctSlpVO
	 *            List<CustomOwnrAcctSlpVO> 데이터객체 배열
	 * @throws DAOException
	 */
	public void modifyOwnerInvoices(List<CustomOwnrAcctSlpVO> customOwnrAcctSlpVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (customOwnrAcctSlpVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpUSQL(), customOwnrAcctSlpVO, null);
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
	 * Owner's Account 비용에 관련된 차변/대변 금액을 기준으로 자동으로 Matching 하도록 조회를 한다<br>
	 * 
	 * @param condSearchOwnerInvoiceAutoMatchVO
	 *            CondSearchOwnerInvoiceAutoMatchVO
	 * @return List<SearchOwnerInvoiceAutoMatchListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchList(CondSearchOwnerInvoiceAutoMatchVO condSearchOwnerInvoiceAutoMatchVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchListVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condSearchOwnerInvoiceAutoMatchVO != null) {
				Map<String, String> mapVO = condSearchOwnerInvoiceAutoMatchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpAutoFilterRSQL(), param, velParam);
			searchOwnerInvoiceAutoMatchListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerInvoiceAutoMatchListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOwnerInvoiceAutoMatchListVO;
	}

	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO
	 *            CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceList(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condCalOffhireInvoiceVO != null) {
				Map<String, String> mapVO = condCalOffhireInvoiceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalOffhireInvoiceListRSQL(), param, velParam);
			searchCalOffhireInvoiceListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalOffhireInvoiceListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalOffhireInvoiceListVO;
	}

	/**
	 * Off-Hire Expenses 화면에서 SUM 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO
	 *            CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSum(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condCalOffhireInvoiceVO != null) {
				Map<String, String> mapVO = condCalOffhireInvoiceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalOffhireInvoiceListSumRSQL(), param, velParam);
			searchCalOffhireInvoiceListSumVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalOffhireInvoiceListSumVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalOffhireInvoiceListSumVO;
	}

	/**
	 * CtrtNo와 Duration 에 해당하는 항차 가져오기<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param effDt
	 *            String
	 * @param expDt
	 *            String
	 * @param vslCd
	 *            String
	 * @return List<SearchVvdListByOffHireVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchVvdListByOffHireVO> searchVvdListByOffHire(String fletCtrtNo, String effDt, String expDt, String vslCd) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchVvdListByOffHireVO> searchVvdListByOffHireVO = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("eff_dt", effDt);
			param.put("exp_dt", expDt);
			param.put("vsl_cd", vslCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchVvdListByOffHireRSQL(), param, null);
			searchVvdListByOffHireVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchVvdListByOffHireVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchVvdListByOffHireVO;
	}

	/**
	 * Offhire Expenses 정보를 입력한다<br>
	 * 
	 * @param customOffInvoiceVO
	 *            CustomOffInvoiceVO
	 * @throws DAOException
	 *             , Exception
	 */
	public void addOffInvoice(CustomOffInvoiceVO customOffInvoiceVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = customOffInvoiceVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAOAddOffInvoiceCSQL(), param, null);
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
	 * Offhire Expenses 정보를 변경한다<br>
	 * 
	 * @param customOffInvoiceVO
	 *            CustomOffInvoiceVO
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifyOffInvoice(CustomOffInvoiceVO customOffInvoiceVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = customOffInvoiceVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAOModifyOffInvoiceUSQL(), param, null);
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
	 * Offhire Expenses 정보를 입력한다<br>
	 * 
	 * @param customOffInvDtlVO
	 *            List<CustomOffInvDtlVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void addOffInvDtls(List<CustomOffInvDtlVO> customOffInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customOffInvDtlVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAOAddOffInvDtlsCSQL(), customOffInvDtlVO, null);
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
	 * Offhire Expenses 정보를 입력한다(단건)<br>
	 * 
	 * @param customOffInvDtlVO CustomOffInvDtlVO
	 * @throws DAOException, Exception
	 */
	public void addOffInvDtlInfo(CustomOffInvDtlVO customOffInvDtlVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = customOffInvDtlVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAOAddOffInvDtlsCSQL(), param, null);
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
	 * InvDtlSeq 값을 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param invSeq String
	 * @return int dtlSeq
	 * @throws DAOException
	 */
	public int searchInvDtlSeq(String fletCtrtNo, String invSeq) throws DAOException {
		DBRowSet dbRowset = null;
		int dtlSeq = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			dbRowset = new SQLExecuter("DEFAULTXA").executeQuery((ISQLTemplate) new TCharterIOInvoiceDBDAOSearchInvDtlSeqRSQL(), param, null);
			if (dbRowset.next()) {
				dtlSeq = dbRowset.getInt("inv_dtl_seq");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dtlSeq;
	}

	/**
	 * Offhire Expenses 정보를 변경한다<br>
	 * 
	 * @param customOffInvDtlVO
	 *            List<CustomOffInvDtlVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifytOffInvDtls(List<CustomOffInvDtlVO> customOffInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (customOffInvDtlVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAOModifytOffInvDtlsUSQL(), customOffInvDtlVO, null);
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
	 * Offhire Expenses 정보를 삭제한다<br>
	 * 
	 * @param customOffInvDtlVO
	 *            List<CustomOffInvDtlVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void removeOffInvDtls(List<CustomOffInvDtlVO> customOffInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (customOffInvDtlVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAORemoveOffInvDtlsDSQL(), customOffInvDtlVO, null);
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
	 * Man Hour Item Charge를 등록한다<br>
	 * 
	 * @param customManHrChgVO
	 *            List<CustomManHrChgVO>
	 * @throws DAOException
	 */
	public void addManHrChgs(List<CustomManHrChgVO> customManHrChgVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customManHrChgVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsManHrChgCSQL(), customManHrChgVO, null);
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
	 * Man Hour Item Charge를 변경한다<br>
	 * 
	 * @param customManHrChgVO
	 *            List<CustomManHrChgVO>
	 * @throws DAOException
	 */
	public void modifyManHrChgs(List<CustomManHrChgVO> customManHrChgVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (customManHrChgVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsManHrChgUSQL(), customManHrChgVO, null);
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
	 * Man Hour Item Charge를 삭제한다<br>
	 * 
	 * @param customManHrChgVO
	 *            List<CustomManHrChgVO>
	 * @throws DAOException
	 */
	public void removeManhrChgs(List<CustomManHrChgVO> customManHrChgVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (customManHrChgVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsManHrChgDSQL(), customManHrChgVO, null);
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
	 * Han Hour Charge 에서 생성 되면 FMS_OWNR_ACCT_SLP.MAN_HR_FLG = 'Y' Update 한다<br>
	 * 
	 * @param customManHrChgVO
	 *            List<CustomManHrChgVO>
	 * @throws DAOException
	 */
	public void modifyOwnrAcctSlpManHrChgs(List<CustomManHrChgVO> customManHrChgVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (customManHrChgVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsOwnrAcctSlpManHrFlgUSQL(), customManHrChgVO, null);
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
	 * Off-Hire Expenses 화면에서 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param invSeq
	 *            String
	 * @return List<SearchOffhireInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOffhireInvoiceListVO> searchOffhireInvoiceList(String fletCtrtNo, String invSeq) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchOffhireInvoiceListVO> searchOffhireInvoiceListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchOffhireInvoiceListRSQL(), param, null);
			searchOffhireInvoiceListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOffhireInvoiceListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchOffhireInvoiceListVO;
	}

	/**
	 * Off-Hire Expenses 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param invSeq
	 *            String
	 * @return List<SearchCalOffhireInvoiceListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalOffhireInvoiceListSumVO> searchOffhireInvoiceListSum(String fletCtrtNo, String invSeq) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchOffhireInvoiceListSumRSQL(), param, null);
			searchCalOffhireInvoiceListSumVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalOffhireInvoiceListSumVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalOffhireInvoiceListSumVO;
	}

	/**
	 * Offhire Selection 화면에서 Offhire 데이타 조회(POPUP)<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @return List<SearchOffhireSelectionListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOffhireSelectionListVO> searchOffhireSelectionList(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchOffhireSelectionListVO> searchOffhireSelectionListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchOffhireSelectionListRSQL(), param, null);
			searchOffhireSelectionListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOffhireSelectionListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchOffhireSelectionListVO;
	}

	/**
	 * Offhire Expenses 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param invSeq
	 *            String
	 * @throws DAOException
	 *             , Exception
	 */
	public void removeOffhireInvDtls(String fletCtrtNo, String invSeq) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAORemoveOffhireInvDtlsDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Offhire Expenses 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param invSeq
	 *            String
	 * @throws DAOException
	 *             , Exception
	 */
	public void removeOffhireInvoice(String fletCtrtNo, String invSeq) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAORemoveOffhireInvoiceDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Prepayments 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceList(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condSearchCalPrepaymentInvoiceListVO != null) {
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListRSQL(), param, velParam);
			searchCalPrepaymentInvoiceListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalPrepaymentInvoiceListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalPrepaymentInvoiceListVO;
	}

	/**
	 * Prepayments 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * [2015.11.09] TI Create
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceByTIList(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condSearchCalPrepaymentInvoiceListVO != null) {
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceByTIListRSQL(), param, velParam);
			searchCalPrepaymentInvoiceListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalPrepaymentInvoiceListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalPrepaymentInvoiceListVO;
	}

	/**
	 * Prepayments 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * [2015.11.09] TO Create
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceByTOList(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condSearchCalPrepaymentInvoiceListVO != null) {
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceByTOListRSQL(), param, velParam);
			searchCalPrepaymentInvoiceListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalPrepaymentInvoiceListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalPrepaymentInvoiceListVO;
	}

	/**
	 * Prepayments 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSum(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSumVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condSearchCalPrepaymentInvoiceListVO != null) {
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceListSumRSQL(), param, velParam);
			searchCalPrepaymentInvoiceListSumVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalPrepaymentInvoiceListSumVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalPrepaymentInvoiceListSumVO;
	}

	/**
	 * Prepayments 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * [2015.11.09] TI Create
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceByTIListSum(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSumVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condSearchCalPrepaymentInvoiceListVO != null) {
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceByTIListSumRSQL(), param, velParam);
			searchCalPrepaymentInvoiceListSumVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalPrepaymentInvoiceListSumVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalPrepaymentInvoiceListSumVO;
	}

	/**
	 * Prepayments 화면에서 SUM 데이타 조회(Inquery 버튼 클릭 시)<br>
	 * [2015.11.09] TO Create
	 * 
	 * @param condSearchCalPrepaymentInvoiceListVO CondSearchCalPrepaymentInvoiceListVO
	 * @return List<SearchCalPrepaymentInvoiceListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceByTOListSum(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSumVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condSearchCalPrepaymentInvoiceListVO != null) {
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceByTOListSumRSQL(), param, velParam);
			searchCalPrepaymentInvoiceListSumVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalPrepaymentInvoiceListSumVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalPrepaymentInvoiceListSumVO;
	}

	/**
	 * Prepayments 정보를 입력한다<br>
	 * 
	 * @param customPreInvoiceVO
	 *            CustomPreInvoiceVO
	 * @throws DAOException
	 *             , Exception
	 */
	public void addPreInvoice(CustomPreInvoiceVO customPreInvoiceVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = customPreInvoiceVO.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAOAddPreInvoiceCSQL(), param, null);
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
	 * Prepayments 정보를 입력한다<br>
	 * 
	 * @param customPreInvDtlVO
	 *            List<CustomPreInvDtlVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void addPreInvDtls(List<CustomPreInvDtlVO> customPreInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customPreInvDtlVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAOAddPreInvDtlsCSQL(), customPreInvDtlVO, null);
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
	 * Prepayments 정보를 변경한다<br>
	 * 
	 * @param customPreInvDtlVO
	 *            List<CustomPreInvDtlVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifytPreInvDtls(List<CustomPreInvDtlVO> customPreInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (customPreInvDtlVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAOModifyPreInvDtlsUSQL(), customPreInvDtlVO, null);
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
	 * Prepayments 정보를 삭제한다<br>
	 * 
	 * @param customPreInvDtlVO
	 *            List<CustomPreInvDtlVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void removePreInvDtls(List<CustomPreInvDtlVO> customPreInvDtlVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (customPreInvDtlVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAORemovePreInvDtlsDSQL(), customPreInvDtlVO, null);
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
	 * Prepayments 화면에서 사선/용선/대선 정보를 가져온다(FMS_CONTRACT)<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param ppayHirNo
	 *            String
	 * @return searchPrepaymentInvoiceVO SearchPrepaymentInvoiceVO
	 * @throws DAOException
	 */
	public SearchPrepaymentInvoiceVO searchPrepaymentInvoice(String fletCtrtNo, String ppayHirNo) throws DAOException {

		SearchPrepaymentInvoiceVO searchPrepaymentInvoiceVO = null;

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("ppay_hir_no", ppayHirNo);

			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOInvoiceDAOSearchPrepaymentInvoiceRSQL(), param, null);
			searchPrepaymentInvoiceVO = (SearchPrepaymentInvoiceVO) RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentInvoiceVO.class).get(0);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchPrepaymentInvoiceVO;
	}

	/**
	 * Prepayments 화면에서 HireNo에 해당하는 Invoice 정보를 가져온다(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param ppayHirNo
	 *            String
	 * @return List<SearchPrepaymentHireNoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoList(String fletCtrtNo, String ppayHirNo) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("ppay_hir_no", ppayHirNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchPrepaymentHireNoListRSQL(), param, null);
			searchPrepaymentHireNoListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentHireNoListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchPrepaymentHireNoListVO;
	}

	/**
	 * Prepayments 화면에서 HireNo에 해당하는 Invoice Sum 정보를 가져온다(Inquery 버튼 클릭 시)<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param ppayHirNo
	 *            String
	 * @return List<SearchPrepaymentHireNoListSumVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSum(String fletCtrtNo, String ppayHirNo) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSumVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("ppay_hir_no", ppayHirNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchPrepaymentHireNoListSumRSQL(), param, null);
			searchPrepaymentHireNoListSumVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentHireNoListSumVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchPrepaymentHireNoListSumVO;
	}

	/**
	 * Prepayments 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param invSeq
	 *            String
	 * @throws DAOException
	 *             , Exception
	 */
	public void removePrepaymentInvDtls(String fletCtrtNo, String invSeq) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAORemovePrepaymentInvDtlsDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Prepayment의 Invoice 정보를 삭제한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param invSeq
	 *            String
	 * @throws DAOException
	 *             , Exception
	 */
	public void removePrepaymentInvoice(String fletCtrtNo, String invSeq) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("inv_seq", invSeq);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDAORemovePrepaymentInvoiceDSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Owner Owner's Accout 정보를 변경한다<br>
	 * 
	 * @param customCSulSlpVO
	 *            List<CustomCSulSlpVO>
	 * @throws DAOException
	 */
	public void modifyOwnerAccountExpenses(List<CustomCsulSlpVO> customCSulSlpVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (customCSulSlpVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOCustomCSulSlpVOUSQL(), customCSulSlpVO, null);
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
	 * Manual 전표 생성 시 Broker 관련 Invoice 계정에 수정한다<br>
	 * 
	 * @param customCsulSlpVO
	 *            List<CustomCsulSlpVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifyManualSlip(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsModifyManualSlipUSQL(), customCsulSlpVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
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
	 * 전표 생성 완료 후 Invoice 테이블을 업데이트한다.<br>
	 * 
	 * @param customPamCsulSlpVO
	 *            List<CustomPamCsulSlpVO>
	 * @throws DAOException
	 */
	public void modifyPaymentSlipInvoices(List<CustomPamCsulSlpVO> customPamCsulSlpVO) throws DAOException, Exception {

		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (customPamCsulSlpVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAOModifyPaymentSlipInvoicesUSQL(), customPamCsulSlpVO, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("FMS01201", new String[] {}).getUserMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 전표 생성 완료 후 Owner's Account 테이블을 업데이트한다.<br>
	 * 
	 * @param customPamCsulSlpVO
	 *            List<CustomPamCsulSlpVO>
	 * @throws DAOException
	 */
	public void modifyPaymentSlipOwnerAccounts(List<CustomPamCsulSlpVO> customPamCsulSlpVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (customPamCsulSlpVO.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDAOModifyPaymentSlipOwnerAccountsUSQL(), customPamCsulSlpVO, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("FMS01201", new String[] {}).getUserMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 선주 지불 예정 비용 중 하역 실수로 발생한 비용에 대한 지불 처리 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param fromPayDt
	 *            String
	 * @param toPayDt
	 *            String
	 * @param appFlg
	 *            String
	 * @return List<SearchChaterInvoiceSdmsListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsList(String fletCtrtNo, String fromPayDt, String toPayDt, String appFlg) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("from_pay_dt", fromPayDt);
			param.put("to_pay_dt", toPayDt);

			velParam.put("app_flg", appFlg);
			velParam.put("from_pay_dt", fromPayDt);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchChaterInvoiceSdmsListRSQL(), param, velParam);
			searchChaterInvoiceSdmsListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchChaterInvoiceSdmsListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchChaterInvoiceSdmsListVO;
	}

	/**
	 * 입력한 Invoice No 가 맞는지 체크한다.<br>
	 * INV No. 를 가져온다
	 * 
	 * @param invNo
	 *            String
	 * @return sdmsInvNo String
	 * @throws DAOException
	 */

	public String searchCheckSdmsInvoiceNo(String invNo) throws DAOException {

		DBRowSet dbRowset = null;

		String sdmsInvNo = "";

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("to_inv_no", invNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCheckSdmsInvoiceNoRSQL(), param, null);

			if (dbRowset.next()) {
				sdmsInvNo = dbRowset.getString("to_inv_no");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return sdmsInvNo;
	}

	/**
	 * 입력한 Hire No 가 존재하는지 체크한다.<br>
	 * Hire No. 를 가져온다
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param hireNo
	 *            String
	 * @return String hireNo
	 * @throws DAOException
	 */

	public String searchCheckHireNo(String fletCtrtNo, String hireNo) throws DAOException {

		DBRowSet dbRowset = null;

		String ppayHireNo = "";

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("ppay_hire_no", hireNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDBDAOSearchCheckHireNoRSQL(), param, null);

			if (dbRowset.next()) {
				ppayHireNo = dbRowset.getString("ppay_hir_no");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return ppayHireNo;
	}

	/**
	 * Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다.<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceByPaymentSlipVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			param.put("flet_ctrt_no", fletCtrtNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipVORSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceByPaymentSlipVO.class);

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
	 * Payment Slip화면에서 계약번호 선택 후 정산 관련 기본 정보를 조회한다.<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @return List<SearchInvoiceByPaymentSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlip2(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInvoiceByPaymentSlipVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			param.put("flet_ctrt_no", fletCtrtNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDBDAOSearchInvoiceByPaymentSlipOwVORSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceByPaymentSlipVO.class);

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
	 * 품의되지 않은 선급금 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param ofcCd
	 *            String
	 * @param csrCurrCd
	 *            String
	 * @return List<SearchBunkerPriceInterfaceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlipVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("csr_curr_cd", csrCurrCd);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchPrepaymentListByPaymentSlipRSQL(), param, null);
			searchPrepaymentListByPaymentSlipVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentListByPaymentSlipVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchPrepaymentListByPaymentSlipVO;
	}

	/**
	 * 대선 전표가 생성되면 정산 테이블에 변경된다<br>
	 * 
	 * @param customCsulSlpVO
	 *            List<CustomCsulSlpVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifySubletRevenueSlips(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsSubletRevenueSlipUSQL(), customCsulSlpVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
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
	 * 대선 전표가 생성되면 정산 테이블의 Address Commission 계정에 변경된다<br>
	 * 
	 * @param customCsulSlpVO
	 *            List<CustomCsulSlpVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifySubletRevenueSlipCommission(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsSubletRevenueSlipCommissionUSQL(), customCsulSlpVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
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
	 * 용선 전표가 취소 되면 Account Account 에 전표번호가 Null 로 변경된다<br>
	 * 
	 * @param csrNo
	 *            String
	 * @param usrId
	 *            String
	 * @throws DAOException
	 *             , Exception
	 */
	// public void modifySlipApprovalCancelOwnerAccount(String csrNo, String
	// usrId) throws DAOException,Exception {
	// //query parameter
	// Map<String, Object> param = new HashMap<String, Object>();
	//
	// try {
	// param.put("csr_no", csrNo);
	// param.put("upd_usr_id", usrId);
	//
	// SQLExecuter sqlExe = new SQLExecuter("");
	// int result = sqlExe.executeUpdate((ISQLTemplate)new
	// TCharterIOInvoiceDBDAOSlipApprovalCancelOwnerAccountUSQL(), param, null);
	// if(result == Statement.EXECUTE_FAILED)
	// throw new DAOException("Fail to delete SQL");
	// } catch(SQLException se) {
	// log.error(se.getMessage(),se);
	// throw new DAOException(new ErrorHandler(se).getMessage(), se);
	// } catch(Exception ex) {
	// log.error(ex.getMessage(),ex);
	// throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	// }
	// }

	/**
	 * 용선/대선 전표가 취소 되면 Invoice 에 전표번호가 Null 로 변경된다<br>
	 * 
	 * @param csrNo
	 *            String
	 * @param usrId
	 *            String
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifySlipApprovalCancelInvoice(String csrNo, String usrId) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TCharterIOInvoiceDBDAOSlipApprovalCancelInvoiceUSQL(), param, null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 대선 전표가 승인 되면 Invoice 에 IF NO를 업데이트한다<br>
	 * 
	 * @param searchArSlipDetailListVO
	 *            List<SearchArSlipDetailListVO>
	 * @throws DAOException
	 *             , Exception
	 */
	public void modifySlipApprovalInvoice(List<SearchArSlipDetailListVO> searchArSlipDetailListVO) throws DAOException, Exception {

		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (searchArSlipDetailListVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TCharterIOInvoiceDBDAOSlipApprovalInvoiceUSQL(), searchArSlipDetailListVO, null);
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
	 * 대선 수입 채권 발생 시 기존 생성해놓은 Hire 정보 중 당 월 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param currCd
	 *            String
	 * @param slpOfcCd
	 *            String
	 * @return List<SearchInvoiceListByRevenueSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchInvoiceListByRevenueSlipVO> searchPrepaymentByRevenueSlipList(String fletCtrtNo, String currCd, String slpOfcCd) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchInvoiceListByRevenueSlipVO> searchInvoiceListByRevenueSlipVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("curr_cd", currCd);
			param.put("slp_ofc_cd", slpOfcCd);

			velParam.put("flet_ctrt_no", fletCtrtNo);
			velParam.put("curr_cd", currCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDBDAOFmsInvoiceListByRevenueSlipRSQL(), param, velParam);
			searchInvoiceListByRevenueSlipVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchInvoiceListByRevenueSlipVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchInvoiceListByRevenueSlipVO;
	}

	/**
	 * 기 작성된 Offhire Expenses / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param ofcCd
	 *            String
	 * @param csrCurrCd
	 *            String
	 * @return List<SearchCharterListByPaymentSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlipVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("csr_curr_cd", csrCurrCd);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchOffhireListByPaymentSlipRSQL(), param, null);
			searchOffhireListByPaymentSlipVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOffhireListByPaymentSlipVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchOffhireListByPaymentSlipVO;
	}

	/**
	 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param ofcCd
	 *            String
	 * @param csrCurrCd
	 *            String
	 * @return List<SearchOwnerListByPaymentSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlipVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("csr_curr_cd", csrCurrCd);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchOwnerListByPaymentSlipRSQL(), param, null);
			searchOwnerListByPaymentSlipVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerListByPaymentSlipVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchOwnerListByPaymentSlipVO;
	}

	/**
	 * 품의되지 않은 Charterer's Account 대상 자료를 조회한다<br>
	 * 
	 * @param fletCtrtNo
	 *            String
	 * @param ofcCd
	 *            String
	 * @param csrCurrCd
	 *            String
	 * @return List<SearchCharterListByPaymentSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlip(String fletCtrtNo, String ofcCd, String csrCurrCd) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlipVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("csr_curr_cd", csrCurrCd);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCharterListByPaymentSlipRSQL(), param, null);
			searchCharterListByPaymentSlipVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCharterListByPaymentSlipVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCharterListByPaymentSlipVO;
	}

	/**
	 * Off-Hire Expenses 화면에서 데이타 조회(Creation 버튼 클릭 시)<br>
	 * 
	 * @param condCalOffhireInvoiceVO
	 *            CondCalOffhireInvoiceVO
	 * @return List<SearchCalOffhireInvoiceListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceCheck(CondCalOffhireInvoiceVO condCalOffhireInvoiceVO) throws DAOException {
		DBRowSet dbRowset = null;

		List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVO = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (condCalOffhireInvoiceVO != null) {
				Map<String, String> mapVO = condCalOffhireInvoiceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalOffhireInvoiceCheckRSQL(), param, velParam);
			searchCalOffhireInvoiceListVO = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCalOffhireInvoiceListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return searchCalOffhireInvoiceListVO;
	}
	
	/**
	 * fms invoice 존재 유무 조회.<br>
	 * 
	 * @param fletCtrtNo String
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean searchCharterInvoiceExist(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		boolean bExist = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			param.put("flet_ctrt_no", fletCtrtNo);

			dbRowset = new SQLExecuter("DEFAULTXA").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCharterInvoiceExistRSQL(), param, null);
			if (dbRowset.next()) {
				if(StringUtils.isNotEmpty(dbRowset.getString("FLET_CTRT_NO"))){
					bExist = true;
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bExist;
	}

	/**
	 * FMS_INV_DTL inv_dtl_seq 조회한다.<br>
	 * max(inv_dtl_seq) + 1  를 가져온다
	 * 
	 * @param fletCtrtNo String
	 * @param fletIssTpCd String
	 * @param invSeq String
	 * @return String inv_dtl_seq
	 * @throws DAOException
	 */
	public String searchInvoiceDetailNewSeqInfo(String fletCtrtNo, String fletIssTpCd, String invSeq) throws DAOException {

		DBRowSet dbRowset = null;

		String strNewInvDtlSeq = "1";

		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("flet_iss_tp_cd", fletIssTpCd);
			param.put("inv_seq", invSeq);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchInvoiceDetailNewSeqInfoRSQL(), param, null);

			if (dbRowset.next()) {
				strNewInvDtlSeq = dbRowset.getString("NEW_INV_DTL_SEQ");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strNewInvDtlSeq;
	}

	/**
	 * 입력한 Duration이 유효한지 체크한다.<br>
	 * 
	 * @param CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO
	 * @return String chkFlag
	 * @throws DAOException
	 */
	public String searchCalPrepaymentInvoiceCheckDuration(CondSearchCalPrepaymentInvoiceListVO condSearchCalPrepaymentInvoiceListVO) throws DAOException {

		DBRowSet dbRowset = null;
		String chkFlag = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (condSearchCalPrepaymentInvoiceListVO != null) {
				Map<String, String> mapVO = condSearchCalPrepaymentInvoiceListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TCharterIOInvoiceDAOSearchCalPrepaymentInvoiceCheckDurationRSQL(), param, velParam);

			if (dbRowset.next()) {
				chkFlag = dbRowset.getString("CHK_FLG");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return chkFlag;
	}
}
