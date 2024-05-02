/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PRICommonDAO.java
 *@FileTitle : PRICommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.23
 *@LastModifier : 이승준
 *@LastVersion : 1.0
 * 2009.10.23 이승준
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBCImpl;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmChargeVO;

/**
 * OPUS RASCommonDAO <br>
 * - OPUS-RASCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung-Jun,Lee
 * @see RASCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class RASCommonDBDAO extends DBDAOSupport {

	/**
	 * PRICommonDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchServiceScopeCodeList(
			RsltCdListVO rsltcdlistvo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltcdlistvo != null) {
				Map<String, String> mapVO = rsltcdlistvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RASCommonDBDAORsltCdListVORSQL(), param,
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
	 * surcharge 코드리스트를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchSurchargeCodeList(RsltCdListVO rsltcdlistvo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltcdlistvo != null) {
				Map<String, String> mapVO = rsltcdlistvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RASCommonDBDAOSurchargeRSQL(), param,
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
	 * 조직도를 조회한다.(Ras)<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRasOrganizationList(RsltCdListVO rsltcdlistvo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltcdlistvo != null) {
				Map<String, String> mapVO = rsltcdlistvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RASCommonDBDAORasOrganizationRSQL(),	param, velParam);
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
	 * 조직도를 조회한다.(Ras)<br>
	 * 
	 * @param RsltContiListVO rsltcontilistvo
	 * @return List<RsltContiListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltContiListVO> seacrhRasContiList(RsltContiListVO rsltcontilistvo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltContiListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltcontilistvo != null) {
				Map<String, String> mapVO = rsltcontilistvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RASCommonDBDAORasContiRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltContiListVO.class);
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
	 * 해당 CUR 별 US 환율을 가져와 현재 AMOUNT와 곱하여 리턴
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return String
	 * @exception DAOException
	 */
	public String searchUsExangeAmount(RsltCdListVO rsltcdlistvo) throws DAOException {
		DBRowSet dbRowset = null;
		String usdAmount = "0";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (rsltcdlistvo != null) {
				Map<String, String> mapVO = rsltcdlistvo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RASCommonDBDAOGlMonXchRtRSQL(), param, velParam);
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
	 * BKG_REV_UMCH_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchBkgRevUmchTpList(RsltCdListVO rsltcdlistvo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltcdlistvo != null) {
				Map<String, String> mapVO = rsltcdlistvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RASCommonDBDAOBkgRevUmchTpRSQL(), param,
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
	 * BKG_REV_UMCH_SUB_TP 테이블 조회<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchBkgRevUmchSubTpList(
			RsltCdListVO rsltcdlistvo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltcdlistvo != null) {
				Map<String, String> mapVO = rsltcdlistvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RASCommonDBDAOBkgRevUmchSubTpRSQL(),
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
	 * PRICommonDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRatingUnitCodeList(RsltCdListVO rsltcdlistvo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltcdlistvo != null) {
				Map<String, String> mapVO = rsltcdlistvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RASCommonDBDAOPriRatingUnitRSQL(),
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
	 * PRICommonDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param RsltCdListVO rsltcdlistvo
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRepChargeCodeList(RsltCdListVO rsltcdlistvo)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltcdlistvo != null) {
				Map<String, String> mapVO = rsltcdlistvo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RASCommonDBDAOMdmRepChgRSQL(),
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
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RASCommonDBDAORsltMdmChargeListRSQL(), param, velParam);
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
}
