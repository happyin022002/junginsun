/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIProposalDBDAO.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.13
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.11.13 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.triproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.vo.PriPrsInCalculateVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.basic.TRIProposalBCImpl;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.PriTriRouteCaseNotFoundOthersVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPriTriNoteConvVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltPrsSurchargeDetailVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropInquiryListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriRoutDestPntVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriRoutDestViaVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriRoutOrgPntVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriRoutOrgViaVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.RsltTriRtListVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.hanjin.apps.alps.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriTriMnVO;
import com.hanjin.syscommon.common.table.PriTriRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriTriRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriTriRtScgVO;
import com.hanjin.syscommon.common.table.PriTriRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriTriRtVO;

/**
 * ALPS TRIProposalDBDAO <br>
 * - ALPS-TRIProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sungsoo Park
 * @see TRIProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class TRIProposalDBDAO extends DBDAOSupport {

	/**
	 * TRI Proposal List를 조회합니다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return List<RsltTriPropListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriPropListVO> searchTRIProposalList(TriPropParamVO triPropParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriPropListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (triPropParamVO != null) {
				Map<String, String> mapVO = triPropParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAORsltTriPropListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriPropListVO.class);
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
	 * TRI Proposal - Rate List를 조회합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return List<RsltTriRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriRtListVO> searchTRIRateProposalList(PriTriMnVO priTriMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriRtListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriMnVO != null) {
				Map<String, String> mapVO = priTriMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAORsltTriRtListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriRtListVO.class);
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
	 * TRI Proposal - Route Origin Point List를 조회합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return List<RsltTriRoutOrgPntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriRoutOrgPntVO> searchTRIRouteOriginPointList(PriTriMnVO priTriMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriRoutOrgPntVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriMnVO != null) {
				Map<String, String> mapVO = priTriMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAORsltTriRoutOrgPntVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriRoutOrgPntVO.class);
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
	 * TRI Proposal - Route Origin Via List를 조회합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return List<RsltTriRoutOrgViaVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriRoutOrgViaVO> searchTRIRouteOriginViaList(PriTriMnVO priTriMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriRoutOrgViaVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriMnVO != null) {
				Map<String, String> mapVO = priTriMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAORsltTriRoutOrgViaVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriRoutOrgViaVO.class);
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
	 * TRI Proposal - Route Destination Via List를 조회합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return List<RsltTriRoutDestViaVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriRoutDestViaVO> searchTRIRouteDestinationViaList(PriTriMnVO priTriMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriRoutDestViaVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriMnVO != null) {
				Map<String, String> mapVO = priTriMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAORsltTriRoutDestViaVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriRoutDestViaVO.class);
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
	 * TRI Proposal - Route Desination Point List를 조회합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return List<RsltTriRoutDestPntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriRoutDestPntVO> searchTRIRouteDestinationPointList(PriTriMnVO priTriMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriRoutDestPntVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriMnVO != null) {
				Map<String, String> mapVO = priTriMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAORsltTriRoutDestPntVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriRoutDestPntVO.class);
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
	 * TRI Note List를 조회합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriTriNoteConvVO> searchNoteConversionList(PriTriMnVO priTriMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTriNoteConvVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriMnVO != null) {
				Map<String, String> mapVO = priTriMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAOPriTriNoteConvVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriTriNoteConvVO.class);
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
	 * TRI Proposal - 새로운 Proposal No.를 가져옵니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchNextTRIPropNo(PriTriMnVO priTriMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		String newPropNo = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriMnVO != null) {
				Map<String, String> mapVO = priTriMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAOPriTriMnVOTriPropNoRSQL(),
					param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				newPropNo = dbRowset.getString("next_tri_prop_no");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return newPropNo;
	}

	/**
	 * TRI Proposal - Rate의 중복을 체크한다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCheckRateDuplicate(TriPropParamVO triPropParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dupPropNo = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (triPropParamVO != null) {
				Map<String, String> mapVO = triPropParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAOCheckTRIRateDupRSQL(),
					param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				dupPropNo = dbRowset.getString("tri_prop_no");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dupPropNo;
	}

	/**
	 * Rate 데이터를 생성한다.<br>
	 * 
	 * @param List<PriTriRtVO> insModels
	 * @exception DAOException
	 */
	public void addRate(List<PriTriRtVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtVOCSQL(), insModels, null);
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
	 * @param List<PriTriRtVO> updModels
	 * @exception DAOException
	 */
	public void modifyRate(List<PriTriRtVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtVOUSQL(), updModels, velParam);
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
	 * @param List<PriTriRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRate(List<PriTriRtVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtVODSQL(), delModels, velParam);
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
	 * @param List<PriTriRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeScg(List<PriTriRtVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgVODSQL(), delModels,
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeScgRout(List<PriTriRtVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgRoutVODSQL(), delModels,
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
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeUsdRoutCs(List<PriTriRtVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtUsdRoutCsVODSQL(), delModels,
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
	 * TRI Main 데이터를 생성한다.<br>
	 * 
	 * @param List<PriTriMnVO> insModels
	 * @exception DAOException
	 */
	public void addTriMain(List<PriTriMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriMnVOCSQL(), insModels, null);
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
	 * TRI Main 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriTriMnVO> updModels
	 * @exception DAOException
	 */
	public void modifyTriMain(List<PriTriMnVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriMnVOUSQL(), updModels, velParam);
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
	 * TRI Main 데이터를 갱신한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void modifyTriMainPrsCalcFlagOnAmend(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriMnPrsCalcFlgOnAmendUSQL(), param, velParam);
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
	 * TRI Main 데이터를 갱신한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void modifyTriMainPrsCalcFlagOnCOffer(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriMnPrsCalcFlgOnCOfferUSQL(), param, velParam);
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
	 * TRI Main 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriMnVO> delModels
	 * @exception DAOException
	 */
	public void removeTriMain(List<PriTriMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriMnVODSQL(), delModels, velParam);
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
	 * TRI Main 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriMnVO> delModels
	 * @exception DAOException
	 */
	public void removeTriMainCascadeRoutPnt(List<PriTriMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtRoutPntVODSQL(), delModels,
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
	 * TRI Main 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriMnVO> delModels
	 * @exception DAOException
	 */
	public void removeTriMainCascadeRoutVia(List<PriTriMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtRoutViaVODSQL(), delModels,
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
	 * TRI Main 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriMnVO> delModels
	 * @exception DAOException
	 */
	public void removeTriMainCascadeRt(List<PriTriMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtVODSQL(), delModels, velParam);
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
	 * TRI Main 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriMnVO> delModels
	 * @exception DAOException
	 */
	public void removeTriMainCascadeScg(List<PriTriMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgVODSQL(), delModels,
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
	 * TRI Main 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriMnVO> delModels
	 * @exception DAOException
	 */
	public void removeTriMainCascadeScgRout(List<PriTriMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgRoutVODSQL(), delModels,
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
	 * TRI Main 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriMnVO> delModels
	 * @exception DAOException
	 */
	public void removeTriMainCascadeUsdRoutCs(List<PriTriMnVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtUsdRoutCsVODSQL(), delModels,
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
	 * Route Point 데이터를 생성한다.<br>
	 * 
	 * @param List<PriTriRtRoutPntVO> insModels
	 * @exception DAOException
	 */
	public void addRateRoutePoint(List<PriTriRtRoutPntVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtRoutPntVOCSQL(), insModels,
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
	 * Route Point 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriTriRtRoutPntVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateRoutePoint(List<PriTriRtRoutPntVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtRoutPntVOUSQL(), updModels,
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
	 * @param List<PriTriRtRoutPntVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRoutePoint(List<PriTriRtRoutPntVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtRoutPntVODSQL(), delModels,
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
	 * @param List<PriTriRtRoutViaVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteVia(List<PriTriRtRoutViaVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtRoutViaVOCSQL(), insModels,
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
	 * Route Via. 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriTriRtRoutViaVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateRouteVia(List<PriTriRtRoutViaVO> updModels) throws DAOException, Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtRoutViaVOUSQL(), updModels,
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
	 * @param List<PriTriRtRoutViaVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRouteVia(List<PriTriRtRoutViaVO> delModels) throws DAOException, Exception {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "2");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtRoutViaVODSQL(), delModels,
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
	 * TRI Proposal 데이터를 Request한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void modifyRateRequestProposal(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtVORequestUSQL(), param,
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
	 * TRI Rate 데이터를 Amend한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void addRateAmendProposal(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe
					.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtVOAmendCSQL(), param, velParam);
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
	 * TRI Rate 데이터를 C/Offer한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void modifyRateCofferProposal(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtVOCofferUSQL(), param,
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
	 * TRI Rate 데이터를 승인한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void modifyRateApproveProposal(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtVOApproveUSQL(), param,
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
	 * Rate 데이터를 Publish한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void modifyRatePublishProposal(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtVOPublishUSQL(), param,
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
	 * Rate 데이터를 Publish한 후, 이전 AmdtSeq의 Exp Date를 Close해준다. <br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void modifyRateClosePrevExpDtPostPublish(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtVOClosePrevExpDtUSQL(), param,
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
	 * Proposal에 TRI No.를 Assign합니다.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @exception DAOException
	 */
	public void modifyTriMainAssignTRINo(PriTriMnVO priTriMnVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriMnVOAssignTriNoUSQL(), param,
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
	 * Assign된 TRI No.를 Clear합니다.(Cancel시)<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void modifyTriMainClearTRINo(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriMnVOClearTriNoUSQL(), param,
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
	 * TRI GRI Apply<br>
	 * TRI 내에서 GRI 대상에 해당하는 Rate 에 대하여 GRI 반영한다.
	 * @param TriPropGRIVO triPropGRIVO
	 * @exception DAOException
	 */
	public void addRateGRIApply(TriPropGRIVO triPropGRIVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = triPropGRIVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtGRIApplyVOCSQL(), param,
					velParam);
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
	 * TRI GRI Cancel<br>
	 * TRI Rate 에 적용되어 있는 GRI 를 Cancel 하여 원복한다
	 * @param TriPropGRIVO triPropGRIVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeRateGRICancel(TriPropGRIVO triPropGRIVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = -1;

		try {
			Map<String, String> mapVO = triPropGRIVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtGRICancelVODSQL(), param,
					velParam);
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
		
		return result;
	}
	
	/**
	 * TRI GRI Cancel시 SCG 테이블삭제<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @exception DAOException
	 */
	public void removeRateScgOnGRICancel(TriPropGRIVO triPropGRIVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = triPropGRIVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgOnGRICancelDSQL(), param,
					velParam);
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
	 * TRI GRI Cancel시 SCG_ROUT 테이블삭제<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @exception DAOException
	 */
	public void removeRateScgRoutOnGRICancel(TriPropGRIVO triPropGRIVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = triPropGRIVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgRoutOnGRICancelDSQL(), param,
					velParam);
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
	 * TRI GRI Cancel시 USD_ROUT_CS 테이블삭제<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @exception DAOException
	 */
	public void removeRateUsdRoutCsOnGRICancel(TriPropGRIVO triPropGRIVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = triPropGRIVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtUsdRoutCsOnGRICancelDSQL(), param,
					velParam);
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
	 * GRI 진행중인 데이터가 존재하는지 체크한다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchCheckGRIApplicable(TriPropGRIVO triPropGRIVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dupTriNo = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (triPropGRIVO != null) {
				Map<String, String> mapVO = triPropGRIVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAOCheckGRIApplicableRSQL(),
					param, velParam);
			if (dbRowset != null && dbRowset.next()) {
				dupTriNo = dbRowset.getString("tri_no");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dupTriNo;
	}

	/**
	 * TRI Note Content 정보를 갱신합니다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void manageNote(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtNoteCtntVOUSQL(), param,
					velParam);
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
	 * PRS- Cost Detail List 조회 처리<br>
	 * 
	 * @param RsltTriPrsCostListVO rsltTriPrsCostListVO
	 * @return List<RsltTriPrsCostListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriPrsCostListVO> searchCostDetailList(RsltTriPrsCostListVO rsltTriPrsCostListVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriPrsCostListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltTriPrsCostListVO != null) {
				Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAORsltTriPrsCostListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriPrsCostListVO.class);
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
	 * @param RsltTriPrsCostDetailVO rsltTriPrsCostDetailVO
	 * @return List<RsltTriPrsCostDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriPrsCostDetailVO> searchCostDetailInquiryList(RsltTriPrsCostDetailVO rsltTriPrsCostDetailVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriPrsCostDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltTriPrsCostDetailVO != null) {
				Map<String, String> mapVO = rsltTriPrsCostDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TRIProposalDBDAORsltTriPrsCostDetailVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriPrsCostDetailVO.class);
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
	 * 사용자가 해당 값의 선택여부를(PRI_TRI_RT_USD_ROUT_CS) 수정처리.<br>
	 * 
	 * @param List<RsltTriPrsCostListVO> updModels
	 * @exception DAOException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltTriPrsCostListVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
 
			int updCnt[] = null;
			if (updModels.size() > 0) {

				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtUsdRoutCsFlagVOUSQL(),
						updModels, null);
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
	 * @param List<RsltTriPrsCostListVO> updModels
	 * @exception DAOException
	 */
	public void modifyPrsRate(List<RsltTriPrsCostListVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			Map<String, Object> velParam = new HashMap<String, Object>();
			if (updModels.size() > 0) {
				velParam.put("cost_tp", (updModels.get(0)).getCostTp());

				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtCostVOUSQL(), updModels,
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
	 * CM/OP 산출 이후, Rout별 적용된 Surcharge 상세정보 확인하는 Surcharge Detail 데이터<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
	 * @return List<RsltPrsSurchargeDetailVO>
	 * @exception DAOException
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
					(ISQLTemplate) new TRIProposalDBDAORsltPrsSurchargeDetailRSQL(), param, velParam);
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
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPrsSurchargeDetailApplicableRouteVO> searchSurchargeList(
			InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TRIProposalDBDAORsltPrsSurchargeDetailApplicableRouteRSQL(), param, velParam);
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
	 * Surchage값을 (pri_tri_rt_scg) 추가합니다.<br>
	 * 
	 * @param List<PriTriRtScgVO> insModels
	 * @exception DAOException
	 */
	public void addRateSurcharge(List<PriTriRtScgVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgVOCSQL(), insModels, null);
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
	 * Surchage값을 (pri_sp_scp_rt_scg) 수정합니다.<br>
	 * 
	 * @param List<PriTriRtScgVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateSurcharge(List<PriTriRtScgVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgVOUSQL(), updModels, null);
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
	 * Surchage값을 (pri_sp_scp_rt_scg) 삭제합니다.<br>
	 * 
	 * @param List<PriTriRtScgVO> delModels
	 * @exception DAOException
	 */
	public void removeRateSurcharge(List<PriTriRtScgVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			if (delModels.size() > 0) {
				velParam.put("CASCADE_LEVEL", "99");
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtScgVODSQL(), delModels,
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
	 * 수정된 Surchage값을 RATE의 CMPB에 반영하기 위해 PRI_SP_SCP_RT를 수정합니다.<br>
	 * 
	 * @param PriTriRtScgVO updModels
	 * @exception DAOException
	 */
	public void modifyPrsRateSurchargeCmpb(PriTriRtScgVO updModels) throws DAOException, Exception {
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

				updCnt = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtRateSurchageCmpbScgVOUSQL(),
						param, velParam);

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
	 * TRI Proposal List를 조회합니다.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return List<RsltTriPropListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltTriPropInquiryListVO> searchTRIProposalInquiryList(TriPropParamVO triPropParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltTriPropInquiryListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (triPropParamVO != null) {
				Map<String, String> mapVO = triPropParamVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAORsltTriPropInquiryListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriPropInquiryListVO.class);
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
	 * @param List<PriTriRtUsdRoutCsVO> insModels
	 * @exception DAOException
	 */
	public void addPriTriRateUsedRouteCase(List<PriTriRtUsdRoutCsVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			 
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRIProposalDBDAOPriTriRtUsdRoutCsPreSimulationCSQL(), insModels, null);
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
	 *  Route Case 에 해당하는 Surcharge Data 배치에서 선택 하기 위해 삭제
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void removePriTriRtScgRoutCostDetail(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtScgRoutCostDetailVODSQL(), param, velParam);
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
	 * @param RsltTriPrsCostListVO rsltTriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriTriRtScgRoutCostDetail(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtScgRoutCostDetailVOCSQL(), param, velParam);
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
	public void removePriTriRtScgCostDetail(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtScgCostDetailVODSQL(), param, velParam);
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
	public void addPriTriRtScgCostDetail(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtScgCostDetailVOCSQL(), param, velParam);
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
	 * @param RsltTriPrsCostListVO rsltTriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriRtSurchargeCostDetail(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtSurchargeCostDetailVOUSQL(), param, velParam);
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
	 * @param RsltTriPrsCostListVO rsltTriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriRtCMPBCostDetail(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtCMPBCostDetailVOUSQL(), param, velParam);
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
	 * @param RsltTriPrsCostListVO rsltTriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriRtSvcLaneCostDetail(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtSvcLaneCostDetailVOUSQL(), param, velParam);
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
	 * @param RsltTriPrsCostListVO rsltTriPrsCostListVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriRtGlineMappingCostDetail(RsltTriPrsCostListVO rsltTriPrsCostListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltTriPrsCostListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtGlineMappingCostDetailVOUSQL(), param, velParam);
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
					(ISQLTemplate) new TRIProposalDBDAORsltPriCostSimulationCheckRouteVORSQL(), param, velParam);
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
     * TRI Proposal Publish 시 메일 보내는 대상을 조회합니다.<br>
     *
     * @param PriTriRtVO priTriRtVO
     * @return String[] 대상 이메일 주소 목록
     * @exception DAOException
     */
    public String[] searchTRIPublishTargetMail(PriTriRtVO priTriRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        String[] emails = null;
        ArrayList<String> list = new ArrayList<String>();

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priTriRtVO != null) {
                Map<String, String> mapVO = priTriRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAOTriPropPublishTargetMailRSQL(),
                    param, velParam);
            while (dbRowset.next()) {
                list.add(dbRowset.getString(1));
            }
            emails = new String[list.size()];
            list.toArray(emails);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return emails;
    }

    /**
     * TRI Proposal Publish 시 메일내용에 포함되는 데이터를 조회합니다.<br>
     *
     * @param PriTriRtVO priTriRtVO
     * @return List<RsltTriPropListVO> 메일 데이터
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltTriPropListVO> searchTRIPublishMailContent(PriTriRtVO priTriRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltTriPropListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priTriRtVO != null) {
                Map<String, String> mapVO = priTriRtVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRIProposalDBDAOTriPropPublishRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltTriPropListVO.class);
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
	 *   "pri/TRICalculate", "updatePRI_TRI_RT_NULL"
	 * TRI Rate 에 대하여 Calculate ( PRS )  를 수행한다.
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriRtNullCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtNullCalculateVOUSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "deletePRI_TRI_RT_USD_ROUT_CS_AMDT"
	 *  1.Route Case Cost - KEY DATA DELETE 
	 * PRI_TRIUSD_ROUT_CS 에 대하여, Calculate 내역을 삭제한다.
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void removePriTriUsdRoutCsAmdtCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriUsdRoutCsAmdtCalculateVODSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "insertPRI_TRI_RT_USD_ROUT_CS_OTHERS"
	 *  1.Route Case Cost - KEY DATA INSERT
	 * PRI_TRI_USD_ROUT_CS 에 대하여 Calulate 내역을 반영한다
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriTriUsdRoutCsOthersCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriUsdRoutCsOthersCalculateVOCSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "insertPRI_TRI_RT_USD_ROUT_CS_OTHERS"
	 *  1.Route Case Cost - KEY DATA INSERT 2
	 *   : RATE에 잘못된 OVIA, DVIA가 존재하는 경우 위에서 한번 걸러준 ROUTE 를 기준으로 ORG/DST 만을 기준으로 삼아 INSERT 로직 추가한다.  
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriTriUsdRoutCsOthers2Calculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriUsdRoutCsOthers2CalculateVOCSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "insertPRI_PRS_USD_ROUT_CS_INFO_OTHERS"
	 *  2.USED ROUTE CASE COST INSERT
	 * PRI_TRI_USD_ROUT_CS Calucalate 관련 데이터 생성
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriTriUsdRoutCsInfoOthersCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriUsdRoutCsInfoOthersCalculateVOCSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "insertPRI_PRS_USD_ROUT_ACT_COST_OTHERS"
	 *  2.USED ROUTE CASE COST INSERT
	 * PRI_TRI_USD_ROUT_ACT_COST 관련하여 calculate 데이터 입력
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriTriUsdRoutActCostOthersCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriUsdRoutActCostOthersCalculateVOCSQL(), param, velParam);
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
	 * "pri/TRICalculate", "ROUTECASE_NOT_FOUND_OTHERS" <br>
	 * Calculate 중 route 가 발견되지 않는 케이스를 반환
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @return List<PriTriRouteCaseNotFoundOthersVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriTriRouteCaseNotFoundOthersVO> searchRouteCaseNotFoundOthersCalculateList(
			PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriTriRouteCaseNotFoundOthersVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priPrsInCalculateVO != null) {
				Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new TRIProposalDBDAOPriTriRouteCaseNotFoundOthersVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriTriRouteCaseNotFoundOthersVO.class);
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
	 *  "pri/TRICalculate", "insertPRI_TRI_RT_USD_ROUT_CS"
	 *  2.USED ROUTE CASE COST INSERT
	 * Calucalte 대상 Route 에 대하여 관련 데이터 입력
	 * 
	 * @param PriTriRouteCaseNotFoundOthersVO priTriRouteCaseNotFoundOthersVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void addPriTriRtUsdRoutCsCalculate(PriTriRouteCaseNotFoundOthersVO priTriRouteCaseNotFoundOthersVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTriRouteCaseNotFoundOthersVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtUsdRoutCsCalculateCSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "updatePRI_TRI_RT_USD_ROUT_CS_TransitTime"
	 * Caluculate 중 USD ROUT Transit Time 관련 데이터를 update
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriRtUsdRoutCsTransitTimeCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtUsdRoutCsTransitTimeCalculateUSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "updateCM_OP_PRI_TRI_RT_TransitTime"
	 * Caluculate 중 Transit Time 관련 데이터를 update
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriRtTransitTimeCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriRtTransitTimeCalculateUSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "updatePRI_TRI_MN_PRS_XCH_RT_YRMON"
	 * TRI Calculate 중 PRI_TRI_MN_PRS_XCH_RT_YRMON 관련 데이터를 update
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriMnPrsXchRtYrMonCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriMnPrsXchRtYrMonCalculateUSQL(), param, velParam);
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
	 *  "pri/TRICalculate", "updateCM_OP_PRI_TRI_RT_TransitTime"
	 * TRI MN 에 대하여 해당 Proposal 의 PRS 적용 여부를 update
	 * 
	 * @param PriPrsInCalculateVO priPrsInCalculateVO
	 * @exception DAOException
	 * @throws Exception
	 */
	public void modifyPriTriMnCalcFlgCalculate(PriPrsInCalculateVO priPrsInCalculateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priPrsInCalculateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRIProposalDBDAOPriTriMnCalcFlgCalculateUSQL(), param, velParam);
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
     * TRI Proposal Rate 의 Send Date 를 수정합니다.<br>
     * 
     * @param PriTriRtVO priTriRtVO
     * @exception DAOException
     */
    public void modifyPriTriRtSendDate(PriTriRtVO priTriRtVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priTriRtVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new TRIProposalDBDAOPriTriRtSendDateUSQL(), param, velParam);
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

}
