/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGRICalculationProposalDBDAO.java
 *@FileTitle : RFAGRICalculationProposalDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.25 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.basic.RFAGRICalculationProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcActCustListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcDestPntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcDestViaListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcOrgPntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcOrgViaListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcRtListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGriActCustVO;
import com.clt.syscommon.common.table.PriRpScpGriCmdtVO;
import com.clt.syscommon.common.table.PriRpScpGriGrpVO;
import com.clt.syscommon.common.table.PriRpScpGriRoutPntVO;
import com.clt.syscommon.common.table.PriRpScpGriRoutViaVO;
import com.clt.syscommon.common.table.PriRpScpGriRtVO;

/**
 *  SCRateProposalDBDAO <br>
 * - SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sungsoo, Park
 * @see RFAGRICalculationProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class RFAGRICalculationProposalDBDAO extends DBDAOSupport {

	/**
	 * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcGrpListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcGrpListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcGrpListVO.class);
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
	 * GRI Calculation - Commodity 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcCmdtListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcCmdtListVO> searchGRICalculationCommodityList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcCmdtListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcCmdtListVO.class);
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
	 * GRI Calculation - Actual Customer 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcActCustListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcActCustListVO> searchGRICalculationActualCustomerList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcActCustListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAORsltGriCalcActCustListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcActCustListVO.class);
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
	 * GRI Calculation - Rate 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcRtListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcRtListVO> searchGRICalculationRateList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcRtListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAORsltGriCalcRtListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcRtListVO.class);
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
	 * GRI Calculation - Origin Point 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcOrgPntListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcOrgPntListVO> searchGRICalculationRouteOriginPointList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcOrgPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAORsltGriCalcOrgPntListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcOrgPntListVO.class);
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
	 * GRI Calculation - Origin Via. 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcOrgViaListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcOrgViaListVO> searchGRICalculationRouteOriginViaList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcOrgViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAORsltGriCalcOrgViaListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcOrgViaListVO.class);
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
	 * GRI Calculation - Destination Via. 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcDestViaListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcDestViaListVO> searchGRICalculationRouteDestinationViaList(PriRpScpGriGrpVO priRpScpGriGrpVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcDestViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAORsltGriCalcDestViaListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcDestViaListVO.class);
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
	 * GRI Calculation - Destination Point 리스트를 조회합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @return List<RsltGriCalcDestPntListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcDestPntListVO> searchGRICalculationRouteDestinationPointList(
			PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcDestPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRpScpGriGrpVO != null) {
				Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAORsltGriCalcDestPntListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcDestPntListVO.class);
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
	 * Rate 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpGriRtVO> insModels
	 * @throws DAOException
	 */
	public void addProposalGRICalculationRate(List<PriRpScpGriRtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRtVOCSQL(),
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
	 * Rate 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpGriRtVO> updModels
	 * @throws DAOException
	 */
	public void modifyProposalGRICalculationRate(List<PriRpScpGriRtVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRtVOUSQL(),
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriRtVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationRate(List<PriRpScpGriRtVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRtVODSQL(),
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
	 * Actual Customer 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpGriActCustVO> insModels
	 * @throws DAOException
	 */
	public void addProposalGRICalculationActualCustomer(List<PriRpScpGriActCustVO> insModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriActCustVOCSQL(), insModels, null);
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
	 * @param List<PriRpScpGriActCustVO> updModels
	 * @throws DAOException
	 */
	public void modifyProposalGRICalculationActualCustomer(List<PriRpScpGriActCustVO> updModels) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriActCustVOUSQL(), updModels,
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
	 * Actual Customer 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriActCustVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationActualCustomer(List<PriRpScpGriActCustVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriActCustVODSQL(), delModels,
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
	 * @param List<PriRpScpGriCmdtVO> insModels
	 * @throws DAOException
	 */
	public void addProposalGRICalculationCommodity(List<PriRpScpGriCmdtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriCmdtVOCSQL(),
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
	 * Commodity 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpGriCmdtVO> updModels
	 * @throws DAOException
	 */
	public void modifyProposalGRICalculationCommodity(List<PriRpScpGriCmdtVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriCmdtVOUSQL(),
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
	 * Commodity 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriCmdtVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationCommodity(List<PriRpScpGriCmdtVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriCmdtVODSQL(),
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
	 * Header 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpGriGrpVO> insModels
	 * @throws DAOException
	 */
	public void addProposalGRICalculationGroup(List<PriRpScpGriGrpVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriGrpVOCSQL(),
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
	 * Header 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpGriGrpVO> updModels
	 * @throws DAOException
	 */
	public void modifyProposalGRICalculationGroup(List<PriRpScpGriGrpVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriGrpVOUSQL(),
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
	 * GRI Calculation Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriGrpVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationGroup(List<PriRpScpGriGrpVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriGrpVODSQL(),
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
	 * GRI Calculation Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriGrpVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeCmdt(List<PriRpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriCmdtVODSQL(),
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
	 * GRI Calculation Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriGrpVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeActCust(List<PriRpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriActCustVODSQL(), delModels,
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
	 * GRI Calculation Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriGrpVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRoutPnt(List<PriRpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutPntVODSQL(), delModels,
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
	 * GRI Calculation Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriGrpVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRoutVia(List<PriRpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutViaVODSQL(), delModels,
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
	 * GRI Calculation Header 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriGrpVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRt(List<PriRpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRtVODSQL(),
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
	 * @param List<PriRpScpGriRoutPntVO> insModels
	 * @throws DAOException
	 */
	public void addProposalGRICalculationRoutePoint(List<PriRpScpGriRoutPntVO> insModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutPntVOCSQL(), insModels, null);
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
	 * Route Point 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpGriRoutPntVO> updModels
	 * @throws DAOException
	 */
	public void modifyProposalGRICalculationRoutePoint(List<PriRpScpGriRoutPntVO> updModels) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutPntVOUSQL(), updModels,
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
	 * Route Point 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriRoutPntVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationRoutePoint(List<PriRpScpGriRoutPntVO> delModels) throws DAOException,
			Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutPntVODSQL(), delModels,
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
	 * Route Via. 데이터를 생성한다.<br>
	 * 
	 * @param List<PriRpScpGriRoutViaVO> insModels
	 * @throws DAOException
	 */
	public void addProposalGRICalculationRouteVia(List<PriRpScpGriRoutViaVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutViaVOCSQL(), insModels, null);
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
	 * Route Via. 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriRpScpGriRoutViaVO> updModels
	 * @throws DAOException
	 */
	public void modifyProposalGRICalculationRouteVia(List<PriRpScpGriRoutViaVO> updModels) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutViaVOUSQL(), updModels,
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
	 * Route Via. 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpGriRoutViaVO> delModels
	 * @throws DAOException
	 */
	public void removeProposalGRICalculationRouteVia(List<PriRpScpGriRoutViaVO> delModels) throws DAOException,
			Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch(
						(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutViaVODSQL(), delModels,
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
	 * PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @throws DAOException
	 */
	public void removeProposalGriActCust(PriRpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_RP_SCP_GRI_ACT_CUST
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriActCustCancelVODSQL(), param, velParam);
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
	 * PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @throws DAOException
	 */
	public void removeProposalGriCmdt(PriRpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_RP_SCP_GRI_CMDT
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriCmdtCancelVODSQL(), param, velParam);
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
	 * PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @throws DAOException
	 */
	public void removeProposalGriRoutPnt(PriRpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_RP_SCP_GRI_ROUT_PNT
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutPntCancelVODSQL(), param, velParam);
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
	 * PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @throws DAOException
	 */
	public void removeProposalGriRoutVia(PriRpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			// PRI_RP_SCP_GRI_ROUT_VIA

			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRoutViaCancelVODSQL(), param, velParam);
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
	 * PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @throws DAOException
	 */
	public void removeProposalGriRt(PriRpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			// PRI_RP_SCP_GRI_RT
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriRtCancelVODSQL(), param, velParam);
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
	 * PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpMnVO vo
	 * @throws DAOException
	 */
	public void removeProposalGriGrp(PriRpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			// PRI_RP_SCP_GRI_GRP
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new RFAGRICalculationProposalDBDAOPriRpScpGriGrpCancelVODSQL(), param, velParam);
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
