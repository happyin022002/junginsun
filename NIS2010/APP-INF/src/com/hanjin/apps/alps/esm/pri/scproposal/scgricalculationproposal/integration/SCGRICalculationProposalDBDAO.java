/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGRICalculationProposalDBDAO.java
 *@FileTitle : SCGRICalculationProposalDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.23
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.06.23 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.basic.SCGRICalculationProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgCombo1VO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLAllListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLArbitraryListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLSubListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcActCustListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcDestPntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcDestViaListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcOrgPntListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcOrgViaListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcRateActualCustListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.RsltGriCalcRtListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpArbGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpGriActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpGriCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpGriRtVO;
import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;

/**
 * NIS2010 SCRateProposalDBDAO <br>
 * - NIS2010-SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sungsoo, Park
 * @see SCGRICalculationProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class SCGRICalculationProposalDBDAO extends DBDAOSupport {

	/**
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriSpScpGriGrpVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcGrpListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL(), param, velParam);
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
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcCmdtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcCmdtListVO> searchGRICalculationCommodityList(PriSpScpGriGrpVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcCmdtListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL(), param, velParam);
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
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcActCustListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcActCustListVO> searchGRICalculationActualCustomerList(PriSpScpGriGrpVO vo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcActCustListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcActCustListVORSQL(), param, velParam);
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
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcRtListVO> searchGRICalculationRateList(PriSpScpGriGrpVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcRtListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcRtListVORSQL(), param, velParam);
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
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcOrgPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcOrgPntListVO> searchGRICalculationRouteOriginPointList(PriSpScpGriGrpVO vo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcOrgPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcOrgPntListVORSQL(), param, velParam);
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
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcOrgViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcOrgViaListVO> searchGRICalculationRouteOriginViaList(PriSpScpGriGrpVO vo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcOrgViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcOrgViaListVORSQL(), param, velParam);
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
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcDestViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcDestViaListVO> searchGRICalculationRouteDestinationViaList(PriSpScpGriGrpVO vo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcDestViaListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcDestViaListVORSQL(), param, velParam);
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
	 * @param PriSpScpGriGrpVO vo
	 * @return List<RsltGriCalcDestPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcDestPntListVO> searchGRICalculationRouteDestinationPointList(PriSpScpGriGrpVO vo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGriCalcDestPntListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcDestPntListVORSQL(), param, velParam);
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
	 * GRI Calculation - Rate 데이터를 생성합니다.<br>
	 * 
	 * @param List<PriSpScpGriRtVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationRate(List<PriSpScpGriRtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtVOCSQL(),
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
	 * GRI Calculation - Rate 데이터를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpGriRtVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationRate(List<PriSpScpGriRtVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtVOUSQL(),
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
	 * GRI Calculation - Rate 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriRtVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationRate(List<PriSpScpGriRtVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtVODSQL(),
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
	 * GRI Calculation - Actual Customer 데이터를 생성합니다.<br>
	 * 
	 * @param List<PriSpScpGriActCustVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationActualCustomer(List<PriSpScpGriActCustVO> insModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch(
						(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustVOCSQL(), insModels, null);
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
	 * GRI Calculation - Actual Customer 데이터를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpGriActCustVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationActualCustomer(List<PriSpScpGriActCustVO> updModels) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustVOUSQL(),
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
	 * GRI Calculation - Actual Customer 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriActCustVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationActualCustomer(List<PriSpScpGriActCustVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustVODSQL(),
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
	 * GRI Calculation - Commodity 데이터를 생성합니다.<br>
	 * 
	 * @param List<PriSpScpGriCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationCommodity(List<PriSpScpGriCmdtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtVOCSQL(),
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
	 * GRI Calculation - Commodity 데이터를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpGriCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationCommodity(List<PriSpScpGriCmdtVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtVOUSQL(),
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
	 * GRI Calculation - Commodity 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationCommodity(List<PriSpScpGriCmdtVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtVODSQL(),
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
	 * GRI Calculation - Header 데이터를 생성합니다.<br>
	 * 
	 * @param List<PriSpScpGriGrpVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationGroup(List<PriSpScpGriGrpVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpVOCSQL(),
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
	 * GRI Calculation - Header 데이터를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpGriGrpVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationGroup(List<PriSpScpGriGrpVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpVOUSQL(),
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
	 * GRI Calculation - Header 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroup(List<PriSpScpGriGrpVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpVODSQL(),
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
	 * GRI Calculation - Header 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeCmdt(List<PriSpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtVODSQL(),
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
	 * GRI Calculation - Header 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeActCust(List<PriSpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustVODSQL(),
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
	 * GRI Calculation - Header 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRoutPnt(List<PriSpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntVODSQL(),
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
	 * GRI Calculation - Header 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRoutVia(List<PriSpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaVODSQL(),
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
	 * GRI Calculation - Header 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRt(List<PriSpScpGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtVODSQL(),
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
	 * GRI Calculation - Route Point 데이터를 생성합니다.<br>
	 * 
	 * @param List<PriSpScpGriRoutPntVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationRoutePoint(List<PriSpScpGriRoutPntVO> insModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch(
						(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntVOCSQL(), insModels, null);
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
	 * GRI Calculation - Route Point 데이터를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpGriRoutPntVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationRoutePoint(List<PriSpScpGriRoutPntVO> updModels) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntVOUSQL(),
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
	 * GRI Calculation - Route Point 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriRoutPntVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationRoutePoint(List<PriSpScpGriRoutPntVO> delModels) throws DAOException,
			Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntVODSQL(),
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
	 * GRI Calculation - Route Via. 데이터를 생성합니다.<br>
	 * 
	 * @param List<PriSpScpGriRoutViaVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationRouteVia(List<PriSpScpGriRoutViaVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch(
						(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaVOCSQL(), insModels, null);
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
	 * GRI Calculation - Route Via. 데이터를 갱신합니다.<br>
	 * 
	 * @param List<PriSpScpGriRoutViaVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationRouteVia(List<PriSpScpGriRoutViaVO> updModels) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaVOUSQL(),
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
	 * GRI Calculation - Route Via. 데이터를 삭제합니다.<br>
	 * 
	 * @param List<PriSpScpGriRoutViaVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationRouteVia(List<PriSpScpGriRoutViaVO> delModels) throws DAOException,
			Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe
						.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaVODSQL(),
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

	/************************************** ESM_PRI_0109 Start *******************************************/
	/**
	 * GRI Calculation - Arbitrary 화면에서 콤보 필터를 위해 전체 콤보 데이터를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgCombo1VO vo
	 * @return List<PriSpScpTrspAddChgCombo1VO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSpScpTrspAddChgCombo1VO> searchPriSpScpTrspAddChgCombo1VOs(PriSpScpTrspAddChgCombo1VO vo)
			throws DAOException {

		DBRowSet dbRowset = null;
		List<PriSpScpTrspAddChgCombo1VO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpTrspAddChgCombo1VORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpTrspAddChgCombo1VO.class);

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
	 * GRI Calculation - Arbitrary 화면에서의 적용 GRI(상단그리드)를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSpScpTrspAddChgGriArbOKCLListVO> searchPriSpScpTrspAddChgGriArbOKCLList(
			PriSpScpTrspAddChgGriArbOKCLListVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		List<PriSpScpTrspAddChgGriArbOKCLListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLListVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpTrspAddChgGriArbOKCLListVO.class);

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
	 * GRI Calculation - Arbitrary 화면에서의 적용 GRI 옵션(하단그리드)를 조회한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLSubListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLSubListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSpScpTrspAddChgGriArbOKCLSubListVO> searchPriSpScpTrspAddChgGriArbOKCLSubList(
			PriSpScpTrspAddChgGriArbOKCLSubListVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		List<PriSpScpTrspAddChgGriArbOKCLSubListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLSubListVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpTrspAddChgGriArbOKCLSubListVO.class);

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
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용시 적용할 모든 GRI 와 옵션을 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLAllListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLAllListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSpScpTrspAddChgGriArbOKCLAllListVO> searchPriSpScpTrspAddChgGriArbOKCLAllList(
			PriSpScpTrspAddChgGriArbOKCLAllListVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		List<PriSpScpTrspAddChgGriArbOKCLAllListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLAllListVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpTrspAddChgGriArbOKCLAllListVO.class);

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
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용시 모든 Arbitrary 항목을 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLArbitraryListVO vo
	 * @return List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO> searchPriSpScpTrspAddChgGriArbOKCLArbitraryList(
			PriSpScpTrspAddChgGriArbOKCLArbitraryListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSpScpTrspAddChgGriArbOKCLArbitraryListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpTrspAddChgGriArbOKCLArbitraryListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSpScpTrspAddChgGriArbOKCLArbitraryListVO.class);
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 항목을 생성한다. <br>
	 * 
	 * @param List<PriSpScpArbGriGrpVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationArbGroup(List<PriSpScpArbGriGrpVO> insModels) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt[] = null;
		try {
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriGrpVOCSQL(),
						insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addProposalGRICalculationArbGroup insert No" + i + " SQL");
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 항목을 수정한다. <br>
	 * 
	 * @param List<PriSpScpArbGriGrpVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationArbGroup(List<PriSpScpArbGriGrpVO> updModels) throws DAOException {
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		int updCnt[] = null;
		try {
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriGrpVOUSQL(),
						updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyProposalGRICalculationArbGroup No" + i + " SQL");
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 항목을 삭제한다. <br>
	 * 
	 * @param List<PriSpScpArbGriGrpVO> delModels
	 * @param String level
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationArbGroup(List<PriSpScpArbGriGrpVO> delModels, String level)
			throws DAOException, Exception {
		HashMap<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		int delCnt[] = null;
		try {
			velParam.put("CASCADE_LEVEL", level);
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriGrpVODSQL(),
						delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeProposalGRICalculationArbGroup No" + i + " SQL");
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 옵션 항목을 삭제한다. <br>
	 * 
	 * @param List<PriSpScpArbGriGrpVO> delModels
	 * @param String level
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationArbRt(List<PriSpScpArbGriGrpVO> delModels, String level)
			throws DAOException {
		HashMap<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		int delCnt[] = null;
		try {
			if (delModels.size() > 0) {
				velParam.put("CASCADE_LEVEL", level);
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriRtVODSQL(),
						delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeProposalGRICalculationArbRt No" + i + " SQL");
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 옵션 항목 저장시 GRI 해당 항목 옵션상태를 수정한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLSubListVO pVO
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationArbGroupOption(PriSpScpTrspAddChgGriArbOKCLSubListVO pVO)
			throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = pVO.getColumnValues();
		SQLExecuter sqlExe = new SQLExecuter("");
		int result = 0;
		try {
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriGrpOptionVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modifyProposalGRICalculationArbGroupOption SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 옵션 항목 저장시 GRI 항목 옵션을 생성한다. <br>
	 * 
	 * @param List<PriSpScpTrspAddChgGriArbOKCLSubListVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationArbRt(List<PriSpScpTrspAddChgGriArbOKCLSubListVO> insModels)
			throws DAOException, Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		int insCnt[] = null;
		try {
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriRtVOCSQL(),
						insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " addProposalGRICalculationArbRt SQL");
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 옵션 항목 저장시 GRI 항목 옵션을 수정한다. <br>
	 * 
	 * @param List<PriSpScpTrspAddChgGriArbOKCLSubListVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationArbRt(List<PriSpScpTrspAddChgGriArbOKCLSubListVO> updModels)
			throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		int updCnt[] = null;
		try {
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriRtVOUSQL(),
						updModels, velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyProposalGRICalculationArbRt No" + i + " SQL");
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
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용한다. <br>
	 * GRI 항목에 GRI 적용여부를 수정한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO pVO
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationArbGroupStatus(PriSpScpTrspAddChgGriArbOKCLListVO pVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		SQLExecuter sqlExe = new SQLExecuter("");
		int result = 0;
		try {
			Map<String, String> mapVO = pVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriGrpStatusVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to modifyProposalGRICalculationArbGroupStatus SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용 취소를 한다. <br>
	 * GRI 항목을 삭제한다. <br>
	 * 
	 * @param List<PriSpScpTrspAddChgGriArbOKCLListVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationArbGroup44(List<PriSpScpTrspAddChgGriArbOKCLListVO> delModels)
			throws DAOException, Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		int delCnt[] = null;
		try {
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriGrpVODSQL(),
						delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeProposalGRICalculationArbGroup44 No" + i + " SQL");
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

	/************************************** ESM_PRI_0109 End *******************************************/
	/**
	 * PRI_SP_SCP_GRI_ACT_CUST PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalActCust(PriSpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_SP_SCP_GRI_ACT_CUST
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustCancelVODSQL(), param, velParam);
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
	 * PRI_SP_SCP_GRI_CMDT PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalCmdt(PriSpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_SP_SCP_GRI_CMDT
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtCancelVODSQL(), param, velParam);
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
	 * PRI_SP_SCP_GRI_ROUT_PNT PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalRoutPnt(PriSpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_SP_SCP_GRI_ROUT_PNT
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntCancelVODSQL(), param, velParam);
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
	 * PRI_SP_SCP_GRI_ROUT_VIA PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalRoutVia(PriSpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_SP_SCP_GRI_ROUT_VIA
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaCancelVODSQL(), param, velParam);
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
	 * PRI_SP_SCP_GRI_RT PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalRt(PriSpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_SP_SCP_GRI_RT
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtCancelVODSQL(), param, velParam);
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
	 * PRI_SP_SCP_GRI_GRP PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalGrp(PriSpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_SP_SCP_GRI_GRP
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpCancelVODSQL(), param, velParam);
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
	 * PRI_SP_SCP_ARB_GRI_GRP PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalArbGrp(PriSpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_SP_SCP_ARB_GRI_GRP
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriGrpCancelVODSQL(), param, velParam);
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
	 * PRI_SP_SCP_ARB_GRI_RT PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpMnVO vo
	 * @exception DAOException
	 */
	public void removeProposalArbRt(PriSpMnVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);

			// PRI_SP_SCP_ARB_GRI_RT
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpArbGriRtCancelVODSQL(), param, velParam);
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
     * GRI Calculation -   Apply flag를 변경한다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> updModels
     * @exception DAOException
     */
    public void modifyProposalGRICalculationGroupApplyFlg(PriSpScpGriGrpVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpApplFlgVOUSQL(), param, velParam);
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
     * GRI Calculation - Actual Customer List을 조회한다. <br>
     * 
     * @param PriSpScpRtActCustVO vo
     * @return List<RsltGriCalcRateActualCustListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltGriCalcRateActualCustListVO> searchGriCalcRateActualCustList(PriSpScpRtActCustVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltGriCalcRateActualCustListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (vo != null) {
                Map<String, String> mapVO = vo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new SCGRICalculationProposalDBDAORsltGriCalcRateActualCustListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGriCalcRateActualCustListVO.class);
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
     * GRI Calculation - GRI Group 데이터를 COPY합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void copyProposalGRICalculationGrp(List<PriSpScpGriGrpVO> copyModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (copyModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpCpyVOCSQL(),
                                copyModels, velParam);
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
     * GRI Calculation - Route Via. 데이터를 COPY합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void copyProposalGRICalculationRouteVia(List<PriSpScpGriGrpVO> copyModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (copyModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaCpyVOCSQL(),
                                copyModels, velParam);
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
     * GRI Calculation - Route Pnt. 데이터를 COPY합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void copyProposalGRICalculationRoutePnt(List<PriSpScpGriGrpVO> copyModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (copyModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntCpyVOCSQL(),
                                copyModels, velParam);
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
     * GRI Calculation - Commodity. 데이터를 COPY합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void copyProposalGRICalculationCmdt(List<PriSpScpGriGrpVO> copyModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (copyModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtCpyVOCSQL(),
                                copyModels, velParam);
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
     * GRI Calculation - Actual Customer. 데이터를 COPY합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void copyProposalGRICalculationActCust(List<PriSpScpGriGrpVO> copyModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (copyModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustCpyVOCSQL(),
                                copyModels, velParam);
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
     * GRI Calculation - Rate 데이터를 COPY합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void copyProposalGRICalculationRt(List<PriSpScpGriGrpVO> copyModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (copyModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtCpyVOCSQL(),
                                copyModels, velParam);
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
    
    
    
////////////////////////////////////////////////////////////////////////////////////////
//
//////////////////////////////////////////////////////////////////////////////////////////

    /**
     * GRI Calculation - GRI Group 데이터를 remove합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void removeProposalGRICalculationGrpCpy(List<PriSpScpGriGrpVO> removeModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (removeModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpCpyVODSQL(),
                                removeModels, velParam);
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
     * GRI Calculation - Route Via. 데이터를 remove합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void removeProposalGRICalculationRouteViaCpy(List<PriSpScpGriGrpVO> removeModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (removeModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaCpyVODSQL(),
                                removeModels, velParam);
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
     * GRI Calculation - Route Pnt. 데이터를 remove합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void removeProposalGRICalculationRoutePntCpy(List<PriSpScpGriGrpVO> removeModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (removeModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntCpyVODSQL(),
                                removeModels, velParam);
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
     * GRI Calculation - Commodity. 데이터를 remove합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void removeProposalGRICalculationCmdtCpy(List<PriSpScpGriGrpVO> removeModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (removeModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtCpyVODSQL(),
                                removeModels, velParam);
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
     * GRI Calculation - Actual Customer. 데이터를 remove합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void removeProposalGRICalculationActCustCpy(List<PriSpScpGriGrpVO> removeModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (removeModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustCpyVODSQL(),
                                removeModels, velParam);
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
     * GRI Calculation - Rate 데이터를 remove합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void removeProposalGRICalculationRtCpy(List<PriSpScpGriGrpVO> removeModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (removeModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtCpyVODSQL(),
                                removeModels, velParam);
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
    
    
    
////////////////////////////////////////////////////////////////////////////////////////
//
//////////////////////////////////////////////////////////////////////////////////////////

    /**
     * GRI Calculation - GRI Group 데이터를 paste합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void pasteProposalGRICalculationGrp(List<PriSpScpGriGrpVO> pasteModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (pasteModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpPasteVOCSQL(),
                                pasteModels, velParam);
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
     * GRI Calculation - Route Via. 데이터를 paste합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void pasteProposalGRICalculationRouteVia(List<PriSpScpGriGrpVO> pasteModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (pasteModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaPasteVOCSQL(),
                                pasteModels, velParam);
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
     * GRI Calculation - Route Pnt. 데이터를 paste합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void pasteProposalGRICalculationRoutePnt(List<PriSpScpGriGrpVO> pasteModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (pasteModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntPasteVOCSQL(),
                                pasteModels, velParam);
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
     * GRI Calculation - Commodity. 데이터를 paste합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void pasteProposalGRICalculationCmdt(List<PriSpScpGriGrpVO> pasteModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (pasteModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtPasteVOCSQL(),
                                pasteModels, velParam);
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
     * GRI Calculation - Actual Customer. 데이터를 paste합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void pasteProposalGRICalculationActCust(List<PriSpScpGriGrpVO> pasteModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (pasteModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustPasteVOCSQL(),
                                pasteModels, velParam);
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
     * GRI Calculation - Rate 데이터를 paste합니다.<br>
     * 
     * @param List<PriSpScpGriGrpVO> delModels
     * @exception DAOException
     */
    public void pasteProposalGRICalculationRt(List<PriSpScpGriGrpVO> pasteModels) throws DAOException,
            Exception {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
 
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (pasteModels.size() > 0) {
                delCnt = sqlExe
                        .executeBatch((ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtPasteVOCSQL(),
                                pasteModels, velParam);
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
    
    /*
     *  Copy & Paste에서 사용하기 위해 Scope, General Special 별로 삭제
     */
    /**
     * PRI_SP_SCP_GRI_ACT_CUST PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpGriGrpVO vo
     * @exception DAOException
     */
    public void removeProposalGRIActCustAll(PriSpScpGriGrpVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            // PRI_SP_SCP_GRI_ACT_CUST
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriActCustAllVODSQL(), param, velParam);
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
     * PRI_SP_SCP_GRI_CMDT PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpGriGrpVO vo
     * @exception DAOException
     */
    public void removeProposalGRICmdtAll(PriSpScpGriGrpVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            // PRI_SP_SCP_GRI_CMDT
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriCmdtAllVODSQL(), param, velParam);
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
     * PRI_SP_SCP_GRI_ROUT_PNT PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpGriGrpVO vo
     * @exception DAOException
     */
    public void removeProposalGRIRoutPntAll(PriSpScpGriGrpVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            // PRI_SP_SCP_GRI_ROUT_PNT
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutPntAllVODSQL(), param, velParam);
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
     * PRI_SP_SCP_GRI_ROUT_VIA PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpGriGrpVO vo
     * @exception DAOException
     */
    public void removeProposalGRIRoutViaAll(PriSpScpGriGrpVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            // PRI_SP_SCP_GRI_ROUT_VIA
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRoutViaAllVODSQL(), param, velParam);
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
     * PRI_SP_SCP_GRI_RT PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpGriGrpVO vo
     * @exception DAOException
     */
    public void removeProposalGRIRtAll(PriSpScpGriGrpVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            // PRI_SP_SCP_GRI_RT
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriRtAllVODSQL(), param, velParam);
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
     * PRI_SP_SCP_GRI_GRP PropNo, AmdtSeq의 모든 데이터를 삭제처리한다.<br>
     * 
     * @param PriSpScpGriGrpVO vo
     * @exception DAOException
     */
    public void removeProposalGRIGrpAll(PriSpScpGriGrpVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);

            // PRI_SP_SCP_GRI_GRP
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate(
                    (ISQLTemplate) new SCGRICalculationProposalDBDAOPriSpScpGriGrpAllVODSQL(), param, velParam);
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
