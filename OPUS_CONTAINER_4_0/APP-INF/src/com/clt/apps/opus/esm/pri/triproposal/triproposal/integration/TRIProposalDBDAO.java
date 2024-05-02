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
package com.clt.apps.opus.esm.pri.triproposal.triproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.triproposal.triproposal.basic.TRIProposalBCImpl;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltPriTriNoteConvVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropInquiryListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriRoutDestPntVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriRoutDestViaVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriRoutOrgPntVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriRoutOrgViaVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriRtListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriTriMnVO;
import com.clt.syscommon.common.table.PriTriRtRoutPntVO;
import com.clt.syscommon.common.table.PriTriRtRoutViaVO;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * TRIProposalDBDAO <br>
 * - TRIProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
 

}
