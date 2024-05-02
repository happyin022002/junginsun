/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : USARailWoAckManageDBDAO.java
 *@FileTitle : USARail WO 신고 정보
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-20
 *@LastModifier : Lee Sang-Woo
 *@LastVersion : 1.0
 * 2006-12-20 Lee Sang-Woo
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.basic.USARailWoAckManageBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see USARailWoAckManageBCImpl 참조
 * @since J2EE 1.4
 */
public class USARailWoAckManageDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param param
	 * @return int
	 * @throws DAOException
	 */
	public int addUSARailWoAckManageList(HashMap<Object, Object> param) throws DAOException {
		int resultCount1 = 0;
		Map<String, Object> queryParam = new HashMap<String, Object>();
		String bil_edi_ctrl_seq = String.valueOf(param.get("org_credit"));
		String bil_edi_rcv_rslt_cd = String.valueOf(param.get("result"));
		String waybill = String.valueOf(param.get("waybill"));
		String error = String.valueOf(param.get("error"));
		try {
			queryParam.put("bil_edi_ctrl_seq", bil_edi_ctrl_seq);
			DBRowSet rs = new SQLExecuter("DEFAULT").executeQuery(new USARailWoAckManageDBDAOaddUSARailWoAckManageListRSQL(), queryParam, null);
			if (rs != null && rs.next()) {
				if (searchUSARailWoAckManageList(bil_edi_ctrl_seq)) {
					Map<String, Object> uparam = new HashMap<String, Object>();
					uparam.put("bil_edi_ctrl_seq", bil_edi_ctrl_seq);
					uparam.put("bil_edi_rcv_rslt_cd", bil_edi_rcv_rslt_cd);
					uparam.put("cre_ofc_cd", rs.getString("CRE_OFC_CD"));
					uparam.put("cxl_rqst_rjct_rsn", error);
					uparam.put("wbl_no", waybill);
					resultCount1 = new SQLExecuter("DEFAULT").executeUpdate(new USARailWoAckManageDBDAOaddUSARailWoAckManageListUSQL(), uparam, null);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return resultCount1;
	}

	/**
	 * ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param param
	 * @return int
	 * @throws DAOException
	 */
	public int receiveUSARailReWoAckManageList(HashMap<Object, Object> param) throws DAOException {
		int resultCount1 = 0;
		Map<String, Object> queryParam = new HashMap<String, Object>();
		String bil_edi_ctrl_seq = String.valueOf(param.get("org_credit"));
		String bil_edi_rcv_rslt_cd = String.valueOf(param.get("result"));
		String error = String.valueOf(param.get("error"));
		try {
			queryParam.put("bil_edi_ctrl_seq", bil_edi_ctrl_seq);
			DBRowSet rs = new SQLExecuter("DEFAULT").executeQuery(new USARailWoAckManageDBDAOaddUSARailReWoAckManageListRSQL(), queryParam, null);
			if (rs != null && rs.next()) {
				if (searchUSARailReWoAckManageList(bil_edi_ctrl_seq)) {
					Map<String, Object> uparam = new HashMap<String, Object>();
					uparam.put("bil_edi_ctrl_seq", bil_edi_ctrl_seq);
					uparam.put("bil_edi_rcv_rslt_cd", bil_edi_rcv_rslt_cd);
					uparam.put("cre_ofc_cd", rs.getString("CRE_OFC_CD"));
					uparam.put("cxl_rqst_rjct_rsn", error);
					resultCount1 = new SQLExecuter("DEFAULT").executeUpdate(new USARailWoAckManageDBDAOaddUSARailReWoAckManageListUSQL(), uparam, null);
				}
			} else {
				log.info("data does not exists. [BIL_EDI_CTRL_SEQ : " + bil_edi_ctrl_seq + "]");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return resultCount1;
	}

	/**
	 * ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public int receiveManageUSARail417WoAck(HashMap<Object, Object> param) throws DAOException {
		int resultCount2 = 0;
		Map<String, Object> queryParam = new HashMap<String, Object>();
		String bkgNo = String.valueOf(param.get("bkg_no"));
		String blNo = String.valueOf(param.get("bl_no"));
		String cntrNo = String.valueOf(param.get("cntr_no"));
		try {
			queryParam.put("bkg_no", bkgNo);
			queryParam.put("bl_no", blNo);
			queryParam.put("cntr_no", cntrNo);
			DBRowSet rs = new SQLExecuter("DEFAULT").executeQuery(new USARailWoAckManageDBDAOSearchManageUSARail417WoAckRSQL(), queryParam, null);
			if (rs.getRowCount() > 0) {
				queryParam.put("inbond_no", String.valueOf(param.get("inbond_no"))); // Inbond Number
				queryParam.put("cnru_no", String.valueOf(param.get("cnru_no"))); // Waybill Number
				resultCount2 = new SQLExecuter("DEFAULT").executeUpdate(new USARailWoAckManageDBDAOUpdateInbondNoUSARail417WoAckUSQL(), queryParam, null);
			} else {
				log.info("data does not exists. [BKG_NO : " + bkgNo + ", BL_NO : " + blNo + ", CNTR_NO : " + cntrNo + "]");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return resultCount2;
	}

	/**
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchUSARailWoAckManageList(String pk1) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		boolean isSuccessful = false;
		try {
			param.put("bil_edi_ctrl_seq", pk1);
			DBRowSet rs = new SQLExecuter("DEFAULT").executeQuery(new USARailWoAckManageDBDAOsearchUSARailWoAckManageListRSQL(), param, null);
			if (rs != null && rs.next()) {
				if (!rs.getString(1).equals("0")) {
					isSuccessful = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful;
	}

	/**
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchUSARailReWoAckManageList(String pk1) throws DAOException {
		boolean isSuccessful = false;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bil_edi_ctrl_seq", pk1);
			DBRowSet rs = new SQLExecuter("DEFAULT").executeQuery(new USARailWoAckManageDBDAOsearchUSARailReWoAckManageListRSQL(), param, null);
			if (rs != null && rs.next()) {
				if (!rs.getString(1).equals("0")) {
					isSuccessful = true;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return isSuccessful;
	}

	/**
	 * 목록을 가져온다.<br>
	 * 
	 * @param param
	 * @return Collection
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection selectUSARailWoAckManage(HashMap<Object, Object> param) throws DAOException {
		DBRowSet rs = null;
		Collection models = new ArrayList();
		try {
			String bil_edi_ctrl_seq = String.valueOf(param.get("org_credit"));
			Map<String, Object> queryParam = new HashMap<String, Object>();
			queryParam.put("bil_edi_ctrl_seq", bil_edi_ctrl_seq);
			rs = new SQLExecuter("DEFAULT").executeQuery(new USARailWoAckManageDBDAOselectUSARailWoAckManageRSQL(), queryParam, null);
			if (rs != null && rs.next()) {
				if ("W".equals(rs.getString("TRSP_RAIL_BIL_TP_CD"))) {
					TrsTrspEdiRailOrdVO trs_trsp_edi_rail_ord = new TrsTrspEdiRailOrdVO();
					trs_trsp_edi_rail_ord.setTrspSoOfcCtyCd(rs.getString("TRSP_SO_OFC_CTY_CD"));
					trs_trsp_edi_rail_ord.setTrspSoSeq(rs.getString("TRSP_SO_SEQ"));
					models.add(trs_trsp_edi_rail_ord);
				} else {
					models = null;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return models;
	}

	/**
	 * 
	 * @param param
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCreditSeqUsaEdiCd(HashMap<String, String> param) throws DAOException {
		try {
			Map<String, Object> queryParam = new HashMap<String, Object>();
			queryParam.put("bkg_no", param.get("bkg_no"));
			queryParam.put("eq_no", param.get("eq_no"));
			queryParam.put("usa_edi_cd", param.get("usa_edi_cd"));
			return new SQLExecuter("DEFAULT").executeQuery(new USARailWoAckManageDBDAOSearchCreditSeqUsaEdiCdRSQL(), queryParam, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
}