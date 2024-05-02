/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGuidelineMainDAO.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.07.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.basic.RFAGuidelineMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineTermsCntVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriRgMnVO;

/**
 * NIS2010 RFAGuidelineMainDAO <br>
 * - NIS2010-RFAGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Sungsoo
 * @see RFAGuidelineMainBCImpl 참조
 * @since J2EE 1.4
 */
public class RFAGuidelineMainDBDAO extends DBDAOSupport {

	/**
	 * 선택된 Service Scope에 등록된 Guideline 리스트를 조회한다.<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGlineScpEffDtListVO> searchGuidelineScopeEffectiveDateList(PriRgMnVO priRgMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGlineScpEffDtListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRgMnVO != null) {
				Map<String, String> mapVO = priRgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGuidelineMainDBDAORsltGlineScpEffDtListVORSQL(), param, velParam);
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
	 * Guideline Main을 조회합니다.<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @return List<RsltGlineMnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGlineMnVO> searchGuidelineMain(PriRgMnVO priRgMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGlineMnVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRgMnVO != null) {
				Map<String, String> mapVO = priRgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAGuidelineMainDBDAORsltGlineMnVORSQL(),
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
	 * RFA Guideline 의 Effective Date 적합여부를 조회합니다.<br>
	 * 
	 * @param PriRgMnVO priRgMnVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchCheckGuidelineEffectiveDate(PriRgMnVO priRgMnVO) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRgMnVO != null) {
				Map<String, String> mapVO = priRgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if (priRgMnVO.getGlineSeq() == null || "".equals(priRgMnVO.getGlineSeq())) {
					velParam.put("HAS_GLINE_SEQ", "N");
				} else {
					velParam.put("HAS_GLINE_SEQ", "Y");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAGuidelineMainDBDAOChkGlEffDtRSQL(), param,
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
	 * @param PriRgMnVO priRgMnVO
	 * @return List<RsltGlineTermsCntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltGlineTermsCntVO> searchGuidelineTermsCount(PriRgMnVO priRgMnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltGlineTermsCntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priRgMnVO != null) {
				Map<String, String> mapVO = priRgMnVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFAGuidelineMainDBDAORsltGlineTermsCntVORSQL(), param, velParam);
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
	 * @param PriRgMnVO vo
	 * @exception DAOException
	 */
	public void addGuidelineMain(PriRgMnVO vo) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGuidelineMainDBDAOPriRgMnCSQL(), param, velParam);
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
	 * @param PriRgMnVO vo
	 * @param String isConfirm
	 * @return int
	 * @exception DAOException
	 */
	public int modifyGuidelineMain(PriRgMnVO vo, String isConfirm) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("IS_CONFIRM", isConfirm);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAGuidelineMainDBDAOPriRgMnUSQL(), param, velParam);
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
	 * 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int removeGuidelineMain(PriRgMnVO vo) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new RFAGuidelineMainDBDAOPriRgMnDSQL(), param, velParam);
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
	 * 생성할 Guideline 의 새로운 gline_seq 를 조회합니다.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int searchGuidelineCopyGuidelineSeq(PriRgMnVO vo) throws DAOException {
		int nextSeq = -1;
		DBRowSet dbRowset = null;

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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAGuidelineMainDBDAOMaxGlineSeqRSQL(),
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
     * Commodity Header 의 하위 존재여부를 체크합니다.<br>
     * 
     * @param PriRgMnVO vo
     * @return boolean
     * @exception DAOException
     */
	public boolean searchCommodityHeaderHasChild(PriRgMnVO vo) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFAGuidelineMainDBDAOCheckCmdtHdrHasChildRSQL(), param,
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
     * RFA Guideline Copy 대상들의 기존 데이터 유무를 조회합니다.<br>
     * 
     * @param PriRgMnVO priRgMnVO
     * @return List<RsltRfaGlineCopyVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRfaGlineCopyVO> searchGlineCopyCheckTermsExist(PriRgMnVO priRgMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRfaGlineCopyVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRgMnVO != null) {
                Map<String, String> mapVO = priRgMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFAGuidelineMainDBDAOGlineCopyCheckTermsExistRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRfaGlineCopyVO.class);
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
     * 복사한 RFA Guideline Main 정보를 생성합니다.<br>
     * 
     * @param RsltRfaGlineCopyVO vo
     * @exception DAOException
     */
    public void addGlineCopyGuidelineMain(RsltRfaGlineCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFAGuidelineMainDBDAOGlineCopyPriRgMnCSQL(), param, velParam);
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
