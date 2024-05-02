/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainDAO.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.apps.opus.esm.pri.scguideline.scsalesguideline.basic.SCSalesGuidelineBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriSgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSgGrpLocVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * SCSalesGuidelineDAO <br>
 * - SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Sungsoo
 * @see SCSalesGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class SCGroupLocationGuidelineDBDAO extends DBDAOSupport {

	/**
	 * Guideline - GroupLocation을 조회한다.<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSgGrpLocVO> searchGroupLocationList(PriSgGrpLocVO priSgGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSgGrpLocVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgGrpLocVO != null) {
				Map<String, String> mapVO = priSgGrpLocVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGroupLocationGuidelineDBDAORsltPriSgGrpLocVORSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSgGrpLocVO.class);

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
	 * SCSalesGuidelineDAO 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSgGrpLocDtlVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSgGrpLocDtlVO> searchGroupLocationDetailList(PriSgGrpLocDtlVO priSgGrpLocVO) throws DAOException {
		DBRowSet dbRowsetDtl = null;
		List<RsltPriSgGrpLocDtlVO> listDtl = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgGrpLocVO != null) {
				Map<String, String> mapVO = priSgGrpLocVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowsetDtl = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGroupLocationGuidelineDBDAORsltPriSgGrpLocDtlVORSQL(), param, velParam);

			listDtl = (List) RowSetUtil.rowSetToVOs(dbRowsetDtl, RsltPriSgGrpLocDtlVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return listDtl;
	}

	/**
	 * Group Location삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchGroupLocationInUse(PriSgGrpLocVO priSgGrpLocVO) throws DAOException {
		DBRowSet dbRowsetDtl = null;
		List<RsltCdListVO> listDtl = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgGrpLocVO != null) {
				Map<String, String> mapVO = priSgGrpLocVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowsetDtl = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGroupLocationGuidelineDBDAOCheckGroupLocationInUseVORSQL(), param, velParam);

			listDtl = (List) RowSetUtil.rowSetToVOs(dbRowsetDtl, RsltCdListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return listDtl;
	}

	/**
	 * Excel Download를 위해 Group Location을 조회한다.<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSgGrpLocExcelVO> searchGroupLocationListExcel(PriSgGrpLocVO priSgGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSgGrpLocExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgGrpLocVO != null) {
				Map<String, String> mapVO = priSgGrpLocVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGroupLocationGuidelineDBDAORsltPriSgGrpLocExcelRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriSgGrpLocExcelVO.class);

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
	 * Group Location 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSgGrpLocVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocation(List<PriSgGrpLocVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocVOCSQL(),
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
	 * Group Location 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriSgGrpLocVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocation(List<PriSgGrpLocVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocVOUSQL(),
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
	 * Group Location 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSgGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocation(List<PriSgGrpLocVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocVODSQL(),
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
	 * Group Location 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSgGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocationCascadeDetail(List<PriSgGrpLocVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "Y");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocDtlVODSQL(),
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
	 * Group Location Detail 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSgGrpLocDtlVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationDetail(List<PriSgGrpLocDtlVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocDtlVOCSQL(),
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
	 * Group Location Detail 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriSgGrpLocDtlVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocationDetail(List<PriSgGrpLocDtlVO> updModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocDtlVOUSQL(),
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
	 * Group Location Detail 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSgGrpLocDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocationDetail(List<PriSgGrpLocDtlVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("IS_CASCADE", "N");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocDtlVODSQL(),
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
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainGroupLocation(PriSgMnVO priSgMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgMnVODSQL(), param,
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
	 * Guideline Main에서 Guideline을 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMainGroupLocationDetail(PriSgMnVO priSgMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgMnDtlVODSQL(), param,
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
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * guideline 을 Copy 를 통해서 신규 생성한다.
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainGroupLocationCopy(GlineMnCpVO glineMnCpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = glineMnCpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocGlineMainCopyCSQL(), param, velParam);
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
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * guideline 을 Copy 를 통해서 신규 생성한다.
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainGroupLocationDetailCopy(GlineMnCpVO glineMnCpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = glineMnCpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate(
					(ISQLTemplate) new SCGroupLocationGuidelineDBDAOPriSgGrpLocDtlGlineMainCopyCSQL(), param, velParam);
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
}
