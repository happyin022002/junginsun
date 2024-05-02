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
package com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.basic.SCGuidelineMainBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineTermsCntVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010 SCGuidelineMainDAO <br>
 * - NIS2010-SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Sungsoo
 * @see SCGuidelineMainBCImpl 참조
 * @since J2EE 1.4
 */
public class SCGuidelineMainDBDAO extends DBDAOSupport {

	/**
	 * 선택된 Service Scope에 등록된 Guideline 리스트를 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGlineScpEffDtListVO> searchGuidelineScopeEffectiveDateList(PriSgMnVO priSgMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGlineScpEffDtListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgMnVO != null) {
				Map<String, String> mapVO = priSgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGuidelineMainDBDAORsltGlineScpEffDtListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGlineScpEffDtListVO.class);
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
	 * SC Guideline 메인화면을 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGlineMnVO> searchGuidelineMain(PriSgMnVO priSgMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGlineMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgMnVO != null) {
				Map<String, String> mapVO = priSgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCGuidelineMainDBDAORsltGlineMnVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGlineMnVO.class);
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
	 * Guideline Effective Date가 중복인지 조회합니다. <br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchGuidelineEffectiveDate(PriSgMnVO priSgMnVO) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgMnVO != null) {
				Map<String, String> mapVO = priSgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if (priSgMnVO.getGlineSeq() == null || "".equals(priSgMnVO.getGlineSeq())) {
					velParam.put("HAS_GLINE_SEQ", "N");
				} else {
					velParam.put("HAS_GLINE_SEQ", "Y");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCGuidelineMainDBDAOChkGlEffDtRSQL(), param,
					velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = false;
			} else {
				rtnChk = true;
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnChk;
	}

	/**
	 * 하위 탭들에 데이터가 존재하는지 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineTermsCntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGlineTermsCntVO> searchGuidelineTermsCount(PriSgMnVO priSgMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGlineTermsCntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgMnVO != null) {
				Map<String, String> mapVO = priSgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCGuidelineMainDBDAORsltGlineTermsCntVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltGlineTermsCntVO.class);
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
	 * Guideline Main 데이터를 생성한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception DAOException
	 */
	public void addGuidelineMain(PriSgMnVO priSgMnVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCGuidelineMainDBDAOPriSgMnCSQL(), param, velParam);
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
	 * Guideline Main 데이터를 갱신한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param String isConfirm
	 * @return int
	 * @exception DAOException
	 */
	public int modifyGuidelineMain(PriSgMnVO priSgMnVO, String isConfirm) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("IS_CONFIRM", isConfirm);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new SCGuidelineMainDBDAOPriSgMnUSQL(), param, velParam);
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
	 * Guideline Main 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMain(PriSgMnVO priSgMnVO) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCGuidelineMainDBDAOPriSgMnDSQL(), param, velParam);
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
	 * SCSalesGuidelineDAO 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchGuidelineCopyGuidelineSeq(PriSgMnVO priSgMnVO) throws DAOException {
		int nextSeq = -1;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgMnVO != null) {
				Map<String, String> mapVO = priSgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCGuidelineMainDBDAOMaxGlineSeqRSQL(),
					param, velParam);
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
	 * Guideline Main을 Copy 합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void copyGuidelineMainAll(GlineMnCpVO glineMnCpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = glineMnCpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCGuidelineMainDBDAOPriSgMnGlineMnCpCSQL(), param,
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
	 * Commodity Header 의 Child 유무를 조회합니다.
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchCommodityHeaderHasChild(PriSgMnVO priSgMnVO) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgMnVO != null) {
				Map<String, String> mapVO = priSgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCGuidelineMainDBDAOCheckCmdtHdrHasChildRSQL(), param,
					velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = false;
			} else {
				rtnChk = true;
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnChk;
	}
}
