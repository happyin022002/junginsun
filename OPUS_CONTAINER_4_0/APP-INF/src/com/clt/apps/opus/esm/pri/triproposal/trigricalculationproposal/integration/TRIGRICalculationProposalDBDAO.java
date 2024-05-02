/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIGRICalculationProposalDBDAO.java
 *@FileTitle : TRIGRICalculationProposalDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.11
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.12.11 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.basic.TRIGRICalculationProposalBCImpl;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcCmdtListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcDestPntListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcDestViaListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcOrgPntListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcOrgViaListVO;
import com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.vo.RsltGriCalcRtListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriTriGriCmdtVO;
import com.clt.syscommon.common.table.PriTriGriGrpVO;
import com.clt.syscommon.common.table.PriTriGriRoutPntVO;
import com.clt.syscommon.common.table.PriTriGriRoutViaVO;
import com.clt.syscommon.common.table.PriTriGriRtVO;

/**
 *  TRIGRICalculationProposalDBDAO <br>
 * - SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sungsoo, Park
 * @see TRIGRICalculationProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class TRIGRICalculationProposalDBDAO extends DBDAOSupport {

	/**
	 * GRI Calculation Header 리스트를 조회합니다.<br>
	 * 
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcGrpListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcGrpListVO> searchGRICalculationHeaderList(PriTriGriGrpVO vo) throws DAOException {
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
					(ISQLTemplate) new TRIGRICalculationProposalDBDAORsltGriCalcGrpListVORSQL(), param, velParam);
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
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcCmdtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcCmdtListVO> searchGRICalculationCommodityList(PriTriGriGrpVO vo) throws DAOException {
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
					(ISQLTemplate) new TRIGRICalculationProposalDBDAORsltGriCalcCmdtListVORSQL(), param, velParam);
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
	 * GRI Calculation - Rate 리스트를 조회합니다.<br>
	 * 
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcRtListVO> searchGRICalculationRateList(PriTriGriGrpVO vo) throws DAOException {
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
					(ISQLTemplate) new TRIGRICalculationProposalDBDAORsltGriCalcRtListVORSQL(), param, velParam);
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
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcOrgPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcOrgPntListVO> searchGRICalculationRouteOriginPointList(PriTriGriGrpVO vo)
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
					(ISQLTemplate) new TRIGRICalculationProposalDBDAORsltGriCalcOrgPntListVORSQL(), param, velParam);
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
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcOrgViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcOrgViaListVO> searchGRICalculationRouteOriginViaList(PriTriGriGrpVO vo) throws DAOException {
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
					(ISQLTemplate) new TRIGRICalculationProposalDBDAORsltGriCalcOrgViaListVORSQL(), param, velParam);
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
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcDestViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcDestViaListVO> searchGRICalculationRouteDestinationViaList(PriTriGriGrpVO vo)
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
					(ISQLTemplate) new TRIGRICalculationProposalDBDAORsltGriCalcDestViaListVORSQL(), param, velParam);
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
	 * @param PriTriGriGrpVO vo
	 * @return List<RsltGriCalcDestPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGriCalcDestPntListVO> searchGRICalculationRouteDestinationPointList(PriTriGriGrpVO vo)
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
					(ISQLTemplate) new TRIGRICalculationProposalDBDAORsltGriCalcDestPntListVORSQL(), param, velParam);
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
	 * @param List<PriTriGriRtVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationRate(List<PriTriGriRtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRtVOCSQL(),
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
	 * @param List<PriTriGriRtVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationRate(List<PriTriGriRtVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRtVOUSQL(),
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
	 * @param List<PriTriGriRtVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationRate(List<PriTriGriRtVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRtVODSQL(),
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
	 * @param List<PriTriGriCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationCommodity(List<PriTriGriCmdtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriCmdtVOCSQL(),
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
	 * @param List<PriTriGriCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationCommodity(List<PriTriGriCmdtVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriCmdtVOUSQL(),
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
	 * @param List<PriTriGriCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationCommodity(List<PriTriGriCmdtVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriCmdtVODSQL(),
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
	 * @param List<PriTriGriGrpVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationGroup(List<PriTriGriGrpVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriGrpVOCSQL(),
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
	 * @param List<PriTriGriGrpVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationGroup(List<PriTriGriGrpVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriGrpVOUSQL(),
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
	 * @param List<PriTriGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroup(List<PriTriGriGrpVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriGrpVODSQL(),
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
	 * @param List<PriTriGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeCmdt(List<PriTriGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriCmdtVODSQL(),
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
	 * @param List<PriTriGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRoutPnt(List<PriTriGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRoutPntVODSQL(),
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
	 * @param List<PriTriGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRoutVia(List<PriTriGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRoutViaVODSQL(),
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
	 * @param List<PriTriGriGrpVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationGroupCascadeRt(List<PriTriGriGrpVO> delModels) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRtVODSQL(),
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
	 * @param List<PriTriGriRoutPntVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationRoutePoint(List<PriTriGriRoutPntVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRoutPntVOCSQL(),
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
	 * GRI Calculation - Route Point 데이터를 갱신합니다.<br>
	 * 
	 * @param List<PriTriGriRoutPntVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationRoutePoint(List<PriTriGriRoutPntVO> updModels) throws DAOException,
			Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRoutPntVOUSQL(),
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
	 * @param List<PriTriGriRoutPntVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationRoutePoint(List<PriTriGriRoutPntVO> delModels) throws DAOException,
			Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRoutPntVODSQL(),
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
	 * @param List<PriTriGriRoutViaVO> insModels
	 * @exception DAOException
	 */
	public void addProposalGRICalculationRouteVia(List<PriTriGriRoutViaVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRoutViaVOCSQL(),
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
	 * GRI Calculation - Route Via. 데이터를 갱신합니다.<br>
	 * 
	 * @param List<PriTriGriRoutViaVO> updModels
	 * @exception DAOException
	 */
	public void modifyProposalGRICalculationRouteVia(List<PriTriGriRoutViaVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRoutViaVOUSQL(),
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
	 * @param List<PriTriGriRoutViaVO> delModels
	 * @exception DAOException
	 */
	public void removeProposalGRICalculationRouteVia(List<PriTriGriRoutViaVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIGRICalculationProposalDBDAOPriTriGriRoutViaVODSQL(),
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

}
