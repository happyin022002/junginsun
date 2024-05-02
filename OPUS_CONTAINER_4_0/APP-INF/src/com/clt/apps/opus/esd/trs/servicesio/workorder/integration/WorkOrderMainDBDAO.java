/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : WorkOrderMainDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esd.trs.servicesio.workorder.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.servicesio.workorder.vo.SelectTrspSvcOrdInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * 
 * @author
 * @see
 * @since J2EE 1.4
 */

public class WorkOrderMainDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public int addTrsEdiWrkOrdHis(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter().executeUpdate(new WorkOrderMainDBDAOAddTrsEdiWrkOrdHisCSQL(), param, param);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * TRS_EDI_WRK_ORD_HIS_SEQ1.NEXTVAL
	 * 
	 * @return
	 * @throws DAOException
	 */
	public int selectRcvMsgSeq() throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet ds = null;
		try {
			ds = new SQLExecuter().executeQuery(new WorkOrderMainDBDAOSelectRcvMsgSeqRSQL(), param, param);
			ds.next();
			return ds.getInt(1);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public int addTrsEdiUsaRcvMsg(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter().executeUpdate(new WorkOrderMainDBDAOAddTrsEdiUsaRcvMsgCSQL(), param, param);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public int addTrsEdiUsaRcvRejectMsg(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter().executeUpdate(new WorkOrderMainDBDAOAddTrsEdiUsaRcvRejectMsgCSQL(), param, param);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchSoBasicAndFuelAmt(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter().executeQuery(new WorkOrderMainDBDAOSearchSoBasicAndFuelAmtRSQL(), param, param);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public int modifyTrsTrspSvcOrd(HashMap<String, Object> param) throws DAOException {
		try {
			if (!param.containsKey("trs_sub_sts_cd")) {
				param.put("trs_sub_sts_cd", "");
			}
			if (!param.containsKey("apnt_dt")) {
				param.put("apnt_dt", "");
			}
			if (!param.containsKey("de_dt")) {
				param.put("de_dt", "");
			}
			return new SQLExecuter().executeUpdate(new WorkOrderMainDBDAOModifyTrsTrspSvcOrdUSQL(), param, param);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * INSERT TRS_SUB_STS_HIS FROM EDI
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public int insertTrsSubStsHis(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter().executeUpdate(new WorkOrderMainDBDAOInsertTrsSubStsHisCSQL(), param, param);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEdi315SendingList(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter().executeQuery(new WorkOrderMainDBDAOSearchEdi315SendingListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchTrsSvcOrdForScheduleAppt(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter().executeQuery(new WorkOrderMainDBDAOSearchTrsSvcOrdForScheduleApptRSQL(), param, param);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public SelectTrspSvcOrdInfoVO selectTrspSvcOrdInfo(HashMap<String, Object> param) throws DAOException {
		try {
			List list = new SQLExecuter().executeQuery(new WorkOrderMainDBDAOSelectTrspSvcOrdInfoRSQL(), param, param, SelectTrspSvcOrdInfoVO.class);
			if (list.isEmpty()) {
				StringBuilder sb = new StringBuilder("unmatched data => ");
				sb.append("S/O No : " + param.get("trsp_so_ofc_cty_cd") + param.get("trsp_so_seq"));
				sb.append("W/O No :" + param.get("trsp_wo_ofc_cty_cd") + param.get("trsp_wo_seq"));
				log.debug(sb.toString());
				return null;
			}
			return (SelectTrspSvcOrdInfoVO) list.get(0);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
}
