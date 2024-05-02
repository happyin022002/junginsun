/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PRICommonDAO.java
 *@FileTitle : PRICommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.16
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.16 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommon.pricommon.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.CheckUpdateDateVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdDtlVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCompensationChargeComboListVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltPriAuthorizationVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltPriMdmSlsRepVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ComUpldFileVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.MdmSlsRepVO;
import com.clt.syscommon.common.table.PriAuthorizationVO;
import com.clt.syscommon.common.table.PriTariffVO;

/**
 * PRICommonDAO <br>
 * - PRICommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Sungsoo
 * @see PRICommonBCImpl 참조
 * @since J2EE 1.4
 */
public class PRICommonDBDAO extends DBDAOSupport {
	

	/**
	 * Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchServiceScopeCodeList(
			RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltCdListVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Sub-continent 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSubcontinentCodeList(
			RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOMdmSubcontinentRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Currency Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCurrencyCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltCurrencyListRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Per Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchPerCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltPerListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Service Scope Code Detail Name 을 조회합니다.<br>
	 * 
	 * @param String svcScpCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchServiceScopeCodeDetailName(String svcScpCd)
			throws DAOException {
		DBRowSet dbRowset = null;
		String svcScpNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (svcScpCd != null) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("svc_scp_cd", svcScpCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOSvcScpNmRSQL(), param,
					velParam);

			if (dbRowset.next()) {
				svcScpNm = dbRowset.getString(1);
			} else {
				svcScpNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return svcScpNm;
	}

	/**
	 * Location Code Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchLocationName(RsltCdListVO rsltCdlistVo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOLocNmRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
     * RFA Location Code Name 을 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchRFALocationName(RsltCdListVO rsltCdlistVo) throws DAOException {
        List<RsltCdListVO> list = null;
        DBRowSet dbRowset = null;

        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORfaLocNmRSQL(), param, velParam);

            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Country Code Name 을 조회합니다.<br>
	 * 
	 * @param String cntCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchCountryName(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		String cntNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cntCd != null) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("cnt_cd", cntCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOCountryNmRSQL(), param,
					velParam);

			if (dbRowset.next()) {
				cntNm = dbRowset.getString(1);
			} else {
				cntNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntNm;
	}

	/**
	 * Commodity Code Name 을 조회합니다.<br>
	 * 
	 * @param String cmdtCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchCommodityName(String cmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		String cntNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cmdtCd != null) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("cmdt_cd", cmdtCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOCommodityNmRSQL(), param,
					velParam);

			if (dbRowset.next()) {
				cntNm = dbRowset.getString(1);
			} else {
				cntNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntNm;
	}
	
	
	/**
	 * Rep Commodity Code Name 을 조회합니다.<br>
	 * 
	 * @param String repCmdtCd
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchRepCommodityName(String repCmdtCd) throws DAOException {
		DBRowSet dbRowset = null;
		String cntNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (repCmdtCd != null) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("rep_cmdt_cd", repCmdtCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORepCommodityNmRSQL(), param,
					velParam);

			if (dbRowset.next()) {
				cntNm = dbRowset.getString(1);
			} else {
				cntNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntNm;
	}
	
	  

	/**
	 * surcharge 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSurchargeCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOSurchargeRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
     * Commodity Group Code Name 을 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception DAOException
     */
    public String searchCommodityGroupName (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        String cntNm = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOCommodityGroupNmRSQL(), param, velParam);

            if (dbRowset.next()) {
                cntNm = dbRowset.getString(1);
            } else {
                cntNm = "";
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntNm;
    }

    /**
     * S/C Proposal Commodity Group Code Name 을 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception DAOException
     */
    public String searchSpCommodityGroupName (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        String cntNm = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOSpScpCommodityGroupNmRSQL(), param, velParam);

            if (dbRowset.next()) {
                cntNm = dbRowset.getString(1);
            } else {
                cntNm = "";
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntNm;
    }


    /**
     * RFA Guideline Commodity Group Code Name 을 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception DAOException
     */
    public String searchRgCommodityGroupName (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        String cntNm = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORgCommodityGroupNmRSQL(), param, velParam);

            if (dbRowset.next()) {
                cntNm = dbRowset.getString(1);
            } else {
                cntNm = "";
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntNm;
    }


    /**
     * RFA Proposal Commodity Group Code Name 을 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception DAOException
     */
    public String searchRpCommodityGroupName (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        String cntNm = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORpScpCommodityGroupNmRSQL(), param, velParam);

            if (dbRowset.next()) {
                cntNm = dbRowset.getString(1);
            } else {
                cntNm = "";
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntNm;
    }

 
	/**
     * Location Group Code Name 을 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception DAOException
     */
    public String searchLocationGroupName (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        String cntNm = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOLocationGroupNmRSQL(), param, velParam);

            if (dbRowset.next()) {
                cntNm = dbRowset.getString(1);
            } else {
                cntNm = "";
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntNm;
    }

    /**
     * RFA Guideline Location Group Code Name 을 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception DAOException
     */
    public String searchRgLocationGroupName (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        String cntNm = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORgLocationGroupNmRSQL(), param, velParam);

            if (dbRowset.next()) {
                cntNm = dbRowset.getString(1);
            } else {
                cntNm = "";
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntNm;
    }

    /**
     * RFA Proposal Location Group Code Name 을 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception DAOException
     */
    public String searchRpLocationGroupName (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        String cntNm = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORpScpLocationGroupNmRSQL(), param, velParam);

            if (dbRowset.next()) {
                cntNm = dbRowset.getString(1);
            } else {
                cntNm = "";
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cntNm;
    }

    
 
	/**
	 * mdm_cntr_sz 코드리스트를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchMdmCntrSzCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOMdmCntrSzRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * S/C Proposal Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSpScpServiceScopeCodeList(
			RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new PRICommonDBDAORsltSpScpServiceScopeListVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Office Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchOfficeCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltOfcListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Office 별 Sales Rep List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSalesRepByOfficeList(
			RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltSrepByOfcListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * 조직도(Ras)를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRasOrganizationList(
			RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORasOrganizationRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * 해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴합니다.
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;

		String usdAmount = "0";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOGlMonXchRtRSQL(), param,
					velParam);

			if (dbRowset.next()) {
				usdAmount = dbRowset.getString(1);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return usdAmount;
	}

	/**
	 * unmatch type code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOBkgRevUmchTpRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * unmatch sub type code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(
			RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOBkgRevUmchSubTpRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * MQC에 등록되어 있는 Scope을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSpScpMqcServiceScopeCodeList(
			RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new PRICommonDBDAORsltSpScpMqcServiceScopeListVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Sale Rep.을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSalesRepCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltSlsRepListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Group Location의 명칭을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSpScopeGroupLocationName(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		String cntNm = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOSpScpGrpLocNmRSQL(),
					param, velParam);

			if (dbRowset.next()) {
				cntNm = dbRowset.getString(1);
			} else {
				cntNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntNm;
	}
	
	/**
	 * PRI_SCG_GRP_LOC 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSurchargeGroupLocationName(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		String sGrpLocNm = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOScgGrpLocNmRSQL(), param,
					velParam);

			if (dbRowset.next()) {
				sGrpLocNm = dbRowset.getString(1);
			} else {
				sGrpLocNm = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sGrpLocNm;
	}
	
	/**
	 * MDM_SUB_TRD 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSubTrdCdList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltSubTrdCdRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * MDM_SVC_SCP_LANE 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSvcScpLaneCdList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltSvcScpLaneCdRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Customer의 명칭을 가져온다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCustomerName(RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOCustomerNmRSQL(), param,
					velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * MDM_CHARGE 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchChargeCdList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOChargeCdListRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * MDM_SUB_TRD 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchScgGrpCmdtCdList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOScgGrpCmdtCdListRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Region Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRegionName(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORgnNmRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * PRI_AUTHORIZATION 테이블을 조회합니다.<br>
	 * 
	 * @param PriAuthorizationVO rsltCdlistVo
	 * @return List<PriAuthorizationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriAuthorizationVO> searchAuthorization(PriAuthorizationVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<PriAuthorizationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOPriAuthorizationVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriAuthorizationVO.class);
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
	 * Tariff Code로 PRI_AUTHORIZATION 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<PriAuthorizationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriAuthorizationVO> searchAuthByTariff(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriAuthorizationVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdListVO != null) {
				Map<String, String> mapVO = rsltCdListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOPriAuthByTariffVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriAuthorizationVO.class);
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
	 * SCOPE 별 CHARGE 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchScopeChargeCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOScopeChargeCdListRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * 전체 Currency Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchAllCurrencyCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltAllCurrencyListRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Service Scope Property Mapping List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSvcScpPptMapgList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOSvcScpPptMapgVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * 전체 Per Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchAllPerCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltAllPerListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Note Conversion Rule Mapping List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchNoteConvRuleMapgList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAONoteConvRuleMapgListRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Request Office Name 정보를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRequestOfficeName(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORequestOfficeNmRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Customer 별 Sales Rep List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCustBySaleRepList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltCustBySaleRepRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Sales Rep Code 로 Office Code 와 Sales Rep Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCustByReqOffice(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOCustByReqOfficeNmRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Approval Office List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchApprovalOfficeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOApprovalOfficeRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * 기존의 office코드와 함께 Approval Office List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchApprovalOfficeAllList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOApprovalOfficeNewRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * 모든 Location Name 을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchTotalLocationName(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				
				//code length
				velParam.put("cd_length", rsltCdlistVo.getCd().length());
				//group_cmd
				velParam.put("group_cmd", rsltCdlistVo.getEtc1());
				//ori/Dest type code
				velParam.put("etc2", rsltCdlistVo.getEtc2());
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltTotLocListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * VESSEL SERVICE LANE의 코드명을 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchVesselServiceLaneName(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOMdmVslSvcLaneNmRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * VSK VESSEL SCHEDULE 코드를 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchVskVesselScheduleCode(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOVslVslSkdCdRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Actual Customer 리스트 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchActualCustomerList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOActualCustomerListRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * IMDG Class 리스트 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchImdgClassCode(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOImdgClassCodeListRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * MDM_LOCATION 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchServiceScopeLocationCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltLocCdVORSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * RFA Proposal Service Scope Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRpScpServiceScopeCodeList(
			RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new PRICommonDBDAORsltRpScpServiceScopeListVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * SYS_GUID() 값을 조회합니다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchSysGuid() throws DAOException {
		DBRowSet dbRowset = null;
		String guid = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOSysGuidVORSQL(), null, null);
			if (dbRowset.next()) {
				guid = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return guid;
	}

	/**
	 * DMT S/C EXCEPTION GROUP 데이터 유무를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchDmtScExptGrpCount(RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		String count = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAODmtScExptGrpCountRSQL(), param, null);
			if (dbRowset.next()) {
				count = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return count;
	}	
	
	/**
	 * Rep Charge Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOMdmRepChgRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * S/C No prefix 리스트를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchScPrefixList(RsltCdListVO rsltCdlistVo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOScPrefixListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * S/C RHQ 리스트를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRHQList(RsltCdListVO rsltCdlistVo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORHQListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Batch Job 실행후 jobid와 상태를 program no(etc1)와 parameter(etc2)로 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBatchScheduleJobId(RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		String jobId = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOScheduleJobIdRSQL(), param,
					velParam);
			if (dbRowset.next()) {
				jobId = dbRowset.getString(1);
			}
			 
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return jobId;
	}	
	
	/**
	 * S/C Term Type 을 조회한다.<br>
	 * 
	 * @param  rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchTermTypeList(RsltCdListVO rsltCdlistVo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORsltTermTypeVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * RFA Term Type 을 조회한다.<br>
	 * 
	 * @param  rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRfaTermTypeList(RsltCdListVO rsltCdlistVo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORsltRfaTermTypeVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Trade Code 을 조회한다.<br>
	 * 
	 * @param  rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchTradeCodeList(RsltCdListVO rsltCdlistVo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORsltTradeCodeVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * RLane 을 조회한다.<br>
	 * 
	 * @param  rsltCdlistVo RsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRLaneCodeList(RsltCdListVO rsltCdlistVo) throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORsltRLaneCodeVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
     * 조직도를 조회합니다.<br>
     * 
     * @param  ComOrganizationVO comOrganizationVO
     * @param List<OrganizationVO> orgList
     * @return List<ComOrganizationVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<ComOrganizationVO> searchOrganizationList(ComOrganizationVO comOrganizationVO,List<OrganizationVO> orgList) throws DAOException {
        List<ComOrganizationVO> list = null;
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (comOrganizationVO != null) {
                Map<String, String> mapVO = comOrganizationVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            
			List<String> tempList = new ArrayList<String>();
			int size = orgList.size();
			for(int i=0; i<size; i++) {
				if( !(orgList.get(i).getOfcCd().trim()).equals(ConstantMgr.getHeadOfficeCode()) ){
					tempList.add(orgList.get(i).getOfcCd());
				}
			}
			velParam.put("ofc_cd_list", tempList);
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOComOrganizationVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComOrganizationVO.class);
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
     * charge 리스트를 조회합니다.<br>
     * 
     * @param  MdmChargeVO mdmChargeVO
     * @return List<MdmChargeVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<MdmChargeVO> searchChargeList(MdmChargeVO mdmChargeVO) throws DAOException {
        List<MdmChargeVO> list = null;
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (mdmChargeVO != null) {
                Map<String, String> mapVO = mdmChargeVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORsltMdmChargeListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmChargeVO.class);
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
	 * PRS 승인권자인지 조회한다.<br>
	 * 
	 * @param RsltPriAuthorizationVO priAuthorizationVO
	 * @return List<RsltPrsProposalSummaryRevenueDetailVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<RsltPriAuthorizationVO> searchPriAuthorization(RsltPriAuthorizationVO priAuthorizationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriAuthorizationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try{
			if (priAuthorizationVO != null) {
				Map<String, String> mapVO = priAuthorizationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRICommonDBDAORsltPriAuthorizationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriAuthorizationVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
			 

	/**
	 * SALES REP 권한자 인지 조회한다.<br>
	 * 
	 * @param String srepCd
	 * @return List<RsltPriMdmSlsRepVO>
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public List<RsltPriMdmSlsRepVO> searchMdmSlsRep(String srepCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriMdmSlsRepVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
 
		try{
			param.put("srep_cd", srepCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRICommonDBDAORsltPriMdmSlsRepRSQL(), param,null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriMdmSlsRepVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

    /**
     * Sales Rep Code 로 User 정보를 조회합니다.<br>
     * 
     * @param MdmSlsRepVO mdmSlsRepVO
     * @return List<ComUserVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComUserVO> searchSalesRepInfo (MdmSlsRepVO mdmSlsRepVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ComUserVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (mdmSlsRepVO != null) {
                Map<String, String> mapVO = mdmSlsRepVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOComUserSlsRepRSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComUserVO.class);
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
	 * Tariff Code List 를 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOTariffCodeRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
     * Service Scope Code 로 Tariff Code 를 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchTariffCodeByServiceScopeCode(RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltCdListVO> list = null;
        
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOTariffCdBySvcScpCdRSQL(), param,
                    velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Actual Customer 리스트 조회<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRFAActualCustomerList(RsltCdListVO rsltCdlistVo)
			throws DAOException {
		List<RsltCdListVO> list = null;
		DBRowSet dbRowset = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORFAActualCustomerListRSQL(), param,
					velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
     * Service Scope Code List 를 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchTariffServiceScopeCodeList (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltCdListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOTariffServiceScopeListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
     * Upload 되어있는 Excel Template File Key 를 조회합니다.<br>
     * 
     * @param ComUpldFileVO comUpldFileVO
     * @return String
     * @exception DAOException
     */
    public String searchExcelTemplateFileKey (ComUpldFileVO comUpldFileVO) throws DAOException {
        DBRowSet dbRowset = null;
        String fileKey = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (comUpldFileVO != null) {
                Map<String, String> mapVO = comUpldFileVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOExcelTemplateFileRSQL(), param, velParam);
            if (dbRowset.next()) {
                fileKey = dbRowset.getString(1);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return fileKey;
    }
    
    /**
	 * Compensation Charge Combo list 리스트를 조회한다.<br>
	 * DHF, CMS, NMS, ODF 조회.<br>
     * 
     * @param  RsltCompensationChargeComboListVO pVo
     * @return List<RsltCompensationChargeComboListVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public List<RsltCompensationChargeComboListVO> searchCompensationChargeComboList(RsltCompensationChargeComboListVO pVo) throws DAOException {
        List<RsltCompensationChargeComboListVO> list = null;
        DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if (pVo != null) {
                Map<String, String> mapVO = pVo.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORsltCompensationChargeComboListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCompensationChargeComboListVO.class);
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
     * Customer 별 Sales Rep List 를 조회합니다.<br>
     *
     * @param RsltCdListVO rsltCdlistVo
     * @return List<RsltCdListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltCdListVO> searchSalesRepListByCustOnly (RsltCdListVO rsltCdlistVo) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltCdListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rsltCdlistVo != null) {
                Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAORsltSalesRepByCustOnlyRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Region Code, Country Code가 MDM_SVC_SCP_LMT 에 Origin, Dest에 맞춰서 존재 하는지 확인한다..<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCheckServiceScopeOriginDestRegionList(RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null; 
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//code length
				velParam.put("cd_length", rsltCdlistVo.getCd().length());
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAORsltCheckOriginDestSvcVORSQL(), param,	velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
     * 화면 조회이후 upd_dt가 변경되었는지 확인한다.<br>
     * 
     * @param CheckUpdateDateVO checkUpdateDate
     * @return CheckUpdateDateVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public CheckUpdateDateVO searchCheckUpdateDate(CheckUpdateDateVO checkUpdateDate) throws DAOException {
        DBRowSet dbRowset = null;
        CheckUpdateDateVO returnValue = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (checkUpdateDate != null) {
                Map<String, String> mapVO = checkUpdateDate.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOCheckUpdateDateRSQL(), param,
                    velParam);
            List<CheckUpdateDateVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, CheckUpdateDateVO.class);
            if( list != null && list.size() > 0){
            	returnValue = list.get(0);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return returnValue;
    } 
    
	/**
	 * 입력한 Tariff Code에 해당하는 Tariff Name 조회
	 * 
	 * @param PriTariffVO priTariffVO
	 * @return List<PriTariffVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<PriTariffVO> searchTariffCodeName(PriTariffVO priTariffVO) throws DAOException {
		DBRowSet dbRowset = null;		
		List<PriTariffVO> list = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (priTariffVO != null) {
				Map<String, String> mapVO = priTariffVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOSearchTariffCodeNameRSQL(),param, velParam); 
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriTariffVO.class);
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
     * SYSDATE의 정보를 YYYYMMDD포멧으로 조회한다.<br>
     * 
	 * @param RsltCdListVO rsltCdlistVo
     * @return String
     * @exception DAOException
     */
    public String searchSystemDate (RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		String sysdate = null;

        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOSysdateRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				sysdate = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sysdate;
	}
    
    
	/**
	 * Rep Service Scoop Code List 를 조회합니다.<br>
	 * 
	 * 
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRepSvcScpCdList()
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new PRICommonDBDAOMdmSvcScpRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * MDM_CHARGE 테이블을 조회합니다.<br>
	 * 
	 * @param RsltCdListVO rsltCdlistVo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchChargeListForPctBse(RsltCdListVO rsltCdlistVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltCdlistVo != null) {
				Map<String, String> mapVO = rsltCdlistVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOSearchChargeListForPctBseRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * Search the info from PRI_PARA_CD Table.<br>
	 * 
	 * @param PriParaCdVO priParaCdVo
	 * @return List<PriParaCdVO>
	 * @exception DAOException
	 * @LastModifyDate : 2014.10.13
	 */
	@SuppressWarnings("unchecked")
	public List<PriParaCdVO> searchPriParaCd (PriParaCdVO priParaCdVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriParaCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priParaCdVo != null) {
				Map<String, String> mapVO = priParaCdVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOPriParaCdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriParaCdDtlVO.class);
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
	 * Search the info from PRI_PARA_CD_DTL Table.<br>
	 * 
	 * @param PriParaCdDtlVO priParaCdDtlVo
	 * @return List<PriParaCdDtlVO>
	 * @exception DAOException
	 * @LastModifyDate : 2014.10.13
	 */
	@SuppressWarnings("unchecked")
	public List<PriParaCdDtlVO> searchPriParaCdDtl (PriParaCdDtlVO priParaCdDtlVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriParaCdDtlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priParaCdDtlVo != null) {
				Map<String, String> mapVO = priParaCdDtlVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOPriParaCdDtlListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriParaCdDtlVO.class);
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
     * check to User Role(COM_USR_ROLE_MTCH) in use about PRI <br>
     *
     * @param ComUserVO comUserVo
     * @return String
     * @exception DAOException
     * @LastModifyDate : 2014.10.13
     */
    @SuppressWarnings("unchecked")
    public String checkPriUserRole(ComUserVO comUserVo) throws DAOException {
       
    	String isRole = "N";
        DBRowSet dbRowset = null;

        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(comUserVo != null){
                Map<String, String> mapVO = comUserVo.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PRICommonDBDAOCheckComUserRoleMtchRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
            	isRole = dbRowset.getString("ISROLE");
            }

        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return isRole;
    }

	/**
	 * CNTR Type Code List 를 조회합니다.<br>
	 * 
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchCntrTpCodeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PRICommonDBDAOSearchCntrTpCodeListRSQL(), null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
