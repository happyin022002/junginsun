/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateGuidelineDAO.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.20
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.04.20 문동규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.basic.SCRateGuidelineBCImpl;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtDetailVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtHdrListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCmdtRnoteListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtCustTpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtListExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutPntListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.vo.RsltRtRoutViaListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriSgMnVO;
import com.hanjin.syscommon.common.table.PriSgRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSgRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriSgRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSgRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSgRtMqcRngVO;
import com.hanjin.syscommon.common.table.PriSgRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSgRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSgRtVO;

/**
 * NIS2010 SCRateGuidelineDBDAO <br>
 * - NIS2010-SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Moon Dong Gyu
 * @see SCRateGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class SCRateGuidelineDBDAO extends DBDAOSupport {

	/**
	 * Radio Button 표시를 위한 Customer Type을 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtCustTpVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCustTpVO> searchRateCustomerType(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCustTpVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSgRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAORsltRateCustTpRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCustTpVO.class);
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
	 * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtCmdtHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderList(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtHdrListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSgRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateGuidelineDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
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
	 * Rate Guideline CMDT Detail의 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtCmdtDetailVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtDetailVO> searchRateCommodityDetailList(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSgRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateGuidelineDBDAORsltRtCmdtDetailVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtDetailVO.class);
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
	 * Rate Guideline Route 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtRoutVO priSgRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutHdrListVO> searchRateRouteHeaderList(PriSgRtCmdtRoutVO priSgRtCmdtRoutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutHdrListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtCmdtRoutVO != null) {
				Map<String, String> mapVO = priSgRtCmdtRoutVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateGuidelineDBDAORsltRtRoutHdrListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
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
	 * Rate Guideline Origin Point 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return List<RsltRtRoutPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutPntListVO> searchRateRouteOriginPointList(PriSgRtVO priSgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutPntListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtVO != null) {
				Map<String, String> mapVO = priSgRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateGuidelineDBDAOOrgPriSgRtRoutPntVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutPntListVO.class);
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
	 * Rate Guideline Origin Via. 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return List<RsltRtRoutViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutViaListVO> searchRateRouteOriginViaList(PriSgRtVO priSgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutViaListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtVO != null) {
				Map<String, String> mapVO = priSgRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateGuidelineDBDAOOrgPriSgRtRoutViaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutViaListVO.class);
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
	 * Rate Guideline Destination Via. 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return List<RsltRtRoutViaListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutViaListVO> searchRateRouteDestinationViaList(PriSgRtVO priSgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutViaListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtVO != null) {
				Map<String, String> mapVO = priSgRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateGuidelineDBDAODestPriSgRtRoutViaVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutViaListVO.class);
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
	 * Rate Guideline Destination Point 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return List<RsltRtRoutPntListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtRoutPntListVO> searchRateRouteDestinationPointList(PriSgRtVO priSgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtRoutPntListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtVO != null) {
				Map<String, String> mapVO = priSgRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateGuidelineDBDAODestPriSgRtRoutPntVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutPntListVO.class);
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
	 * Rate Guideline Route Note 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return List<RsltRtCmdtRnoteListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtCmdtRnoteListVO> searchRateCommodityRnoteList(PriSgRtVO priSgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtCmdtRnoteListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtVO != null) {
				Map<String, String> mapVO = priSgRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SCRateGuidelineDBDAORsltRtCmdtRnoteListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtRnoteListVO.class);
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
	 * Rate Guideline Rate 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtVO priSgRtVO
	 * @return List<RsltRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListVO> searchRateList(PriSgRtVO priSgRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtVO != null) {
				Map<String, String> mapVO = priSgRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAORsltRtListVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListVO.class);
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
     * Guideline Rate Commodity Header 의 신규 Commodity Header Sequence 를 조회합니다.<br>
     * 
     * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
     * @return int
     * @exception DAOException
     */
    public int searchNextCmdtHdrSeq(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws DAOException {
        int nextSeq = -1;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = priSgRtCmdtHdrVO.getColumnValues();
            param.putAll(mapVO);
                
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAOGetNextCmdtHdrSeqRSQL(), param, null);
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
     * Commodity Group Code 의 존재여부를 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdListVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public RsltCdListVO searchCommodityCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
        List<RsltCdListVO> list = null;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = rsltCdListVO.getColumnValues();
            param.putAll(mapVO);
            
            if (rsltCdListVO.getCd().length() == 5) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAOLoadExcelCheckGrpCmdtRSQL(), param, null);
            } else if (rsltCdListVO.getCd().length() == 6) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAOLoadExcelCheckCmdtRSQL(), param, null);
            } else {
                return null;
            }

            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        
        if (list == null || list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * Location Group Code 의 존재여부를 조회합니다.<br>
     * 
     * @param RsltCdListVO rsltCdListVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public RsltCdListVO searchLocationCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
        List<RsltCdListVO> list = null;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = rsltCdListVO.getColumnValues();
            param.putAll(mapVO);
            
            if (rsltCdListVO.getCd().length() == 4) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAOLoadExcelCheckGrpLocRSQL(), param, null);
            } else if (rsltCdListVO.getCd().length() == 5) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAOLoadExcelCheckLocRSQL(), param, null);
            } else {
                return null;
            }
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        
        if (list == null || list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

	/**
	 * Rate Guideline Excel Download 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtCmdtHdrVO priSgRtCmdtHdrVO
	 * @return List<RsltRtListExcelVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltRtListExcelVO> searchRateListExcel(PriSgRtCmdtHdrVO priSgRtCmdtHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltRtListExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtCmdtHdrVO != null) {
				Map<String, String> mapVO = priSgRtCmdtHdrVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAORsltRtListExcelVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListExcelVO.class);
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
	 * Guideline MQC의 리스트를 조회한다.<br>
	 * 
	 * @param PriSgRtMqcRngVO priSgRtMqcRngVO
	 * @return List<PriSgRtMqcRngVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriSgRtMqcRngVO> searchRateMQCRangeList(PriSgRtMqcRngVO priSgRtMqcRngVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgRtMqcRngVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priSgRtMqcRngVO != null) {
				Map<String, String> mapVO = priSgRtMqcRngVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtMqcRngVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriSgRtMqcRngVO.class);
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
	 * @param List<PriSgRtVO> insModels
	 * @exception DAOException
	 */
	public void addRate(List<PriSgRtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtVOCSQL(), insModels, null);
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
	 * @param List<PriSgRtVO> updModels
	 * @exception DAOException
	 */
	public void modifyRate(List<PriSgRtVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtVOUSQL(), updModels, null);
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
	 * @param List<PriSgRtVO> delModels
	 * @exception DAOException
	 */
	public void removeRate(List<PriSgRtVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtVODSQL(), delModels,
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
	 * @param List<PriSgRtCmdtVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodity(List<PriSgRtCmdtVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtVOCSQL(), insModels,
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
	 * Commodity 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriSgRtCmdtVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateCommodity(List<PriSgRtCmdtVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtVOUSQL(), updModels,
						null);
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
	 * @param List<PriSgRtCmdtVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodity(List<PriSgRtCmdtVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtVODSQL(), delModels,
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
	 * Commodity Header 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSgRtCmdtHdrVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityHeader(List<PriSgRtCmdtHdrVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtHdrVOCSQL(), insModels,
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
	 * Commodity Header 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriSgRtCmdtHdrVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateCommodityHeader(List<PriSgRtCmdtHdrVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtHdrVOUSQL(), updModels,
						null);
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
	 * Commodity Header 데이터를 삭제한다.
	 * 
	 * @param List<PriSgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeader(List<PriSgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtHdrVODSQL(), delModels,
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
	 * Commodity Header 데이터를 삭제한다.
	 * 
	 * @param List<PriSgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCmdt(List<PriSgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtVODSQL(), delModels,
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
	 * Commodity Header 데이터를 삭제한다.
	 * 
	 * @param List<PriSgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeCmdtRout(List<PriSgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRoutVODSQL(), delModels,
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
	 * Commodity Header 데이터를 삭제한다.
	 * 
	 * @param List<PriSgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutPnt(List<PriSgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutPntVODSQL(), delModels,
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
	 * Commodity Header 데이터를 삭제한다.
	 * 
	 * @param List<PriSgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRoutVia(List<PriSgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutViaVODSQL(), delModels,
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
	 * Commodity Header 데이터를 삭제한다.
	 * 
	 * @param List<PriSgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRnote(List<PriSgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRnoteVODSQL(),
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
	 * Commodity Header 데이터를 삭제한다.
	 * 
	 * @param List<PriSgRtCmdtHdrVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityHeaderCascadeRt(List<PriSgRtCmdtHdrVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "1");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtVODSQL(), delModels,
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
	 * Commodity Note 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSgRtCmdtRnoteVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRnote(List<PriSgRtCmdtRnoteVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRnoteVOCSQL(),
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
	 * Route Note 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriSgRtCmdtRnoteVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateCommodityRnote(List<PriSgRtCmdtRnoteVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRnoteVOUSQL(),
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
	 * Route Note 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSgRtCmdtRnoteVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRnote(List<PriSgRtCmdtRnoteVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRnoteVODSQL(),
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
	 * Route 데이터를 생성한다.<br>
	 * 
	 * @param List<PriSgRtCmdtRoutVO> insModels
	 * @exception DAOException
	 */
	public void addRateCommodityRoute(List<PriSgRtCmdtRoutVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRoutVOCSQL(), insModels,
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
	 * Commodity Header 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriSgRtCmdtRoutVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateCommodityRoute(List<PriSgRtCmdtRoutVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRoutVOUSQL(), updModels,
						null);
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
	 * Route 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriSgRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCommodityRoute(List<PriSgRtCmdtRoutVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				velParam.put("CASCADE_LEVEL", "2");

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRnoteVODSQL(),
						delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutPntVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutViaVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}

				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRoutVODSQL(), delModels,
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
	 * @param List<PriSgRtRoutPntVO> insModels
	 * @exception DAOException
	 */
	public void addRateRoutePoint(List<PriSgRtRoutPntVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutPntVOCSQL(), insModels,
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
	 * @param List<PriSgRtRoutPntVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateRoutePoint(List<PriSgRtRoutPntVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutPntVOUSQL(), updModels,
						null);
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
	 * @param List<PriSgRtRoutPntVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRoutePoint(List<PriSgRtRoutPntVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutPntVODSQL(), delModels,
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
	 * @param List<PriSgRtRoutViaVO> insModels
	 * @exception DAOException
	 */
	public void addRateRouteVia(List<PriSgRtRoutViaVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutViaVOCSQL(), insModels,
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
	 * @param List<PriSgRtRoutViaVO> updModels
	 * @exception DAOException
	 */
	public void modifyRateRouteVia(List<PriSgRtRoutViaVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutViaVOUSQL(), updModels,
						null);
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
	 * @param List<PriSgRtRoutViaVO> delModels
	 * @exception DAOException
	 */
	public void removeRateRouteVia(List<PriSgRtRoutViaVO> delModels) throws DAOException {
		try {
			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("CASCADE_LEVEL", "3");

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutViaVODSQL(), delModels,
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
	 * Guideline MQC의 단건의 데이터를 생성한다.<br>
	 * 
	 * @param PriSgRtMqcRngVO priSgRtMqcRngVO
	 * @exception DAOException
	 */
	public void addRateMQCRange(PriSgRtMqcRngVO priSgRtMqcRngVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSgRtMqcRngVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtMqcRngVOCSQL(), param,
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
	 * Guideline MQC의 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param PriSgRtMqcRngVO priSgRtMqcRngVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyRateMQCRange(PriSgRtMqcRngVO priSgRtMqcRngVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSgRtMqcRngVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe
					.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtMqcRngVOUSQL(), param, velParam);
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
	 * Guideline MQC의 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgRtMqcRngVO priSgRtMqcRngVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeRateMQCRange(PriSgRtMqcRngVO priSgRtMqcRngVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priSgRtMqcRngVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe
					.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtMqcRngVODSQL(), param, velParam);
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
	public int removeGuidelineMainRate(PriSgMnVO priSgMnVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgMnVORtDSQL(), param, velParam);
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
	public int removeGuidelineMainRateCommodity(PriSgMnVO priSgMnVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgMnVOCmdtDSQL(), param, velParam);
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
	public int removeGuidelineMainRateCommodityHdr(PriSgMnVO priSgMnVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgMnVOCmdtHdrDSQL(), param,
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
	public int removeGuidelineMainRateCommodityRnote(PriSgMnVO priSgMnVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgMnVOCmdtRnoteDSQL(), param,
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
	public int removeGuidelineMainRateCommodityRoute(PriSgMnVO priSgMnVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgMnVOCmdtRoutDSQL(), param,
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
	public int removeGuidelineMainRateRoutePoint(PriSgMnVO priSgMnVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgMnVORoutPntDSQL(), param,
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
	public int removeGuidelineMainRateRouteVia(PriSgMnVO priSgMnVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgMnVORoutViaDSQL(), param,
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
	 * Guideline Main Copy를 실행한다<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainRateCommodityHeaderCopy(GlineMnCpVO glineMnCpVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtHdrGlineMainCopyCSQL(),
					param, velParam);
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
	 * Guideline Main Copy를 실행한다<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainRateCommodityCopy(GlineMnCpVO glineMnCpVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtGlineMainCopyCSQL(), param,
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
		return;
	}

	/**
	 * Guideline Main Copy를 실행한다<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainRateCommodityRouteCopy(GlineMnCpVO glineMnCpVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRoutGlineMainCopyCSQL(),
					param, velParam);
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
	 * Guideline Main Copy를 실행한다<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainRateRoutePointCopy(GlineMnCpVO glineMnCpVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutPntGlineMainCopyCSQL(),
					param, velParam);
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
	 * Guideline Main Copy를 실행한다<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainRateRouteViaCopy(GlineMnCpVO glineMnCpVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtRoutViaGlineMainCopyCSQL(),
					param, velParam);
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
	 * Guideline Main Copy를 실행한다<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainRateCommodityRnoteCopy(GlineMnCpVO glineMnCpVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtCmdtRnoteGlineMainCopyCSQL(),
					param, velParam);
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
	 * Guideline Main Copy를 실행한다<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception DAOException
	 */
	public void addGuidelineMainRateCopy(GlineMnCpVO glineMnCpVO) throws DAOException {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new SCRateGuidelineDBDAOPriSgRtGlineMainCopyCSQL(), param,
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
		return;
	}
}
