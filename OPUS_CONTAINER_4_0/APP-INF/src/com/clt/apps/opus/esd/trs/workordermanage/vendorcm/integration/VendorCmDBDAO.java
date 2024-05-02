/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : VendorCmDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.vendorcm.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo.JoEdiHistoryVO;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.vo.JoEdiRcvMsgVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see DBDAOSupport
 * @since J2EE 1.4
 */
public class VendorCmDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = -370197864266713779L;

	/**
	 * 
	 * @param paramVo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchJoEdiHistory(JoEdiHistoryVO paramVo) throws DAOException {
		DBRowSet ds = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (paramVo != null) {
				param.putAll(paramVo.getColumnValues());
				ArrayList<String> soNoArrays = CommonUtil.seperationParameter(paramVo.getSoNo(), ",");
				if (!soNoArrays.isEmpty()) {
					param.put("soArrays", soNoArrays);
					ds = new SQLExecuter("DEFAULT").executeQuery(new VendorCmDBDAOSearchJoEdiHistoryRSQL(), param, param);
				}
			}
			return ds;
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
	 * @param paramVo
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchJoEdiRcvMsgList(JoEdiRcvMsgVO paramVo) throws DAOException {
		DBRowSet ds = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (paramVo != null) {
				param.putAll(paramVo.getColumnValues());
				ArrayList<String> soNoArrays = CommonUtil.seperationParameter(paramVo.getSoNo(), ",");
				if (!soNoArrays.isEmpty()) {
					param.put("soArrays", soNoArrays);
					param.put("history", "N");
					if (!CheckUtilities.isInBlank(paramVo.getRcvMsgSeq())) {
						param.put("history", "Y");
					}
					ds = new SQLExecuter("DEFAULT").executeQuery(new VendorCmDBDAOSearchJoEdiRcvMsgListRSQL(), param, param);
				}
			}
			return ds;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * TRS_TRSP_SVC_ORD : TRS_SUB_STS_CD update
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public int modifyTrsTrspSvcOrd(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter("DEFAULT").executeUpdate(new VendorCmDBDAOModifyTrsTrspSvcOrdUSQL(), param, param);
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
	public int modifyTrsTrspScgDtl(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter("DEFAULT").executeUpdate(new VendorCmDBDAOModifyTrsTrspScgDtlUSQL(), param, param);
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
	public int modifyTrsSoAmtAndSubTpyeCode(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter("DEFAULT").executeUpdate(new VendorCmDBDAOModifyTrsSoAmtAndSubTpyeCodeUSQL(), param, param);
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
	public int modifyRcvMsgStsCd(HashMap<String, Object> param) throws DAOException {
		try {
			return new SQLExecuter("DEFAULT").executeUpdate(new VendorCmDBDAOModifyRcvMsgStsCdUSQL(), param, param);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} catch (Exception e) {
			throw new DAOException(e.getMessage());
		}
	}
}
