/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : railInvoiceauditDBDAO.java
 *@FileTitle : USA Rail Invoice Agree and Confirm
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-08
 *@LastModifier : chkong
 *@LastVersion : 1.0
 * 2006-12-08 chkong
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0038Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0923Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0925Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0929Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TrsTrspRailInvDtlVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author chkong
 * @see railInvoiceauditBCImpl 참조
 * @since J2EE 1.4
 */
public class RailInvoiceauditDBDAO extends DBDAOSupport {

	/**
	 * Payment VNDR Info을 가져온다.<br>
	 * 
	 * @param event
	 * @param vndrTp
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPaymentVndrList(EsdTrs0038Event event, String vndrTp) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("vndr_tp", vndrTp);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchPaymentVndrListRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Railinvoiceaudit의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @param rail_inv_aud_cd
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRailinvoiceauditList(EsdTrs0038Event event, String rail_inv_aud_cd) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			param.put("railInvAudCd", rail_inv_aud_cd);
			velParam.put("railInvAudCd", rail_inv_aud_cd);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchRailinvoiceauditDtlRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Railinvoiceaudit의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRailinvoiceaudit(EsdTrs0038Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchRailinvoiceauditRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Payment History 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchPaymentHistoryList(EsdTrs0929Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> condiParams = event.getColumnValues();
			param.put("eq_no", condiParams.get("cntr_no"));

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchPaymentHistoryListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Railinvoiceaudit의 저장전에 체크한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void searchReAuditVerify(EsdTrs0038Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();
		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			for (int i = 0; i < model.length; i++) {
				if (!"D".equals(model[i].getIbflag()) && !"0".equals(model[i].getPayFlg())) {
					param.put("eq_no", model[i].getEqNo());
					param.put("wbl_dt", model[i].getWblDt());
					dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchReAuditVerifyRSQL(), param, param);
					if (dbRowset.next())
						throw new DAOException(new ErrorHandler("TRS00101", new String[] { dbRowset.getString("EQ_NO"), dbRowset.getString("INV_NO") }).getMessage());
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * Railinvoiceaudit의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(수정)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void modifyTRS_TRSP_RAIL_INV_DTL(EsdTrs0038Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<TrsTrspRailInvDtlVO> voListSubInvSeq = new ArrayList<TrsTrspRailInvDtlVO>();
		List<TrsTrspRailInvDtlVO> voListNoSubInvSeq = new ArrayList<TrsTrspRailInvDtlVO>();
		List<TrsTrspRailInvDtlVO> voListCfCom = new ArrayList<TrsTrspRailInvDtlVO>();
		List<TrsTrspRailInvDtlVO> voListCfOther = new ArrayList<TrsTrspRailInvDtlVO>();

		TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();
		int insCntArr[] = null;
		int insCnt = 0;

		try {
			Map<String, String> mapVO = event.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			// RailInvoiceauditDBDAOModifyTrsRailInvCntRSQL 함수 호출
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvCntRSQL(), param, velParam);
			dbRowset.next();
			int resultValue = dbRowset.getInt("cnt");
			if (resultValue == 0) {
				// RailInvoiceauditDBDAOModifyTrsRailInvDtlCSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlCSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No 0 SQL");
			} else {
				// RailInvoiceauditDBDAOModifyTrsRailInvDtlUSQL 함수 호출
				insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlUSQL(), param, velParam);
				if (insCnt == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No 0 SQL");
			}

			for (int i = 0; i < model.length; i++) {
				if (model[i].getIbflag().length() > 0) {
					if (!"".equals(model[i].getSubInvSeq().trim())) { // Inquiry(ESD_TRS_0046)에서 Detail Inquiry 호출하여 Save 시
						voListSubInvSeq.add(model[i]);
					} else if ("".equals(model[i].getSubInvSeq().trim())) { // Audit & Confirm(ESD_TRS_0038)에서 Save 시
						voListNoSubInvSeq.add(model[i]);
					}

					if ("CF".equals(event.getSStsCd())) {
						if ("1".equals(model[i].getPayFlg())) {
							if ("NYK".equals(model[i].getTrspInvCoIndCd())) {
								voListCfCom.add(model[i]);
							} else {
								voListCfOther.add(model[i]);
							}
						}
					}
				}
			}

			// Inquiry(ESD_TRS_0046)에서 Detail Inquiry 호출하여 Save 시
			if (voListSubInvSeq.size() > 0) {
				// RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlUSQL 함수 호출
				insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlUSQL(), voListSubInvSeq, param, velParam);
				for (int j = 0; j < insCntArr.length; j++) {
					if (insCntArr[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			// Audit & Confirm(ESD_TRS_0038)에서 Save 시
			if (voListNoSubInvSeq.size() > 0) {
				// RailInvoiceauditDBDAOModifyTrsRailInvDtlDSQL 함수 호출
				insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlDSQL(), voListNoSubInvSeq, param, velParam);
				for (int j = 0; j < insCntArr.length; j++) {
					if (insCntArr[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlCSQL 함수 호출
				insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlDtlCSQL(), voListNoSubInvSeq, param, velParam);
				for (int j = 0; j < insCntArr.length; j++) {
					if (insCntArr[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL 함수 호출
				insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL(), voListNoSubInvSeq, param, velParam);
				for (int j = 0; j < insCntArr.length; j++) {
					if (insCntArr[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}

			if (voListCfCom.size() > 0) {
				// RailInvoiceauditDBDAOModifyTrsRailInvDtlConvAmtUSQL 함수 호출
				insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlConvAmtUSQL(), voListCfCom, param, velParam);
				for (int j = 0; j < insCntArr.length; j++) {
					if (insCntArr[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}

				// RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL 함수 호출
				insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlVndrSetUSQL(), voListCfCom, param, velParam);
				for (int j = 0; j < insCntArr.length; j++) {
					if (insCntArr[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}
			if (voListCfOther.size() > 0) {
				// RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL 함수 호출
				insCntArr = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new RailInvoiceauditDBDAOModifyTrsRailInvDtlRailSoUSQL(), voListCfOther, param, velParam);
				for (int j = 0; j < insCntArr.length; j++) {
					if (insCntArr[j] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + j + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * AP_INV_MAIN 에 넘길 값을 조회한다. [ESD_TRS_0038]<br>
	 * 
	 * @param invNo
	 * @param ofcCd
	 * @return List<ApPayInvVO>
	 * @throws DAOException
	 */
	public List<ApPayInvVO> searchApPayInvMain(String invNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApPayInvVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("inv_no", invNo);
			param.put("ofc_cd", ofcCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchApPayInvMainRSQL(), param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ApPayInvVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * AP_INV_DETAIL 에 넘길 값을 조회한다. [ESD_TRS_0038]<br>
	 * 
	 * @param invNo
	 * @return
	 * @throws DAOException
	 */
	public List<ApPayInvDtlVO> searchApPayInvDetail(String invNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApPayInvDtlVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("inv_no", invNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchApPayInvDetailRSQL(), param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ApPayInvDtlVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return list;
	}

	/**
	 * invRgstNo 정보를 TRS_TRSP_RAIL_INV_WRK 에 저장한다.
	 * 
	 * @param invNo
	 * @param ofcCd
	 * @param invRgstNo
	 * @throws DAOException
	 */
	public void updateRgstNoRailInvWrk(String invNo, String ofcCd, String invRgstNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("inv_no", invNo);
			param.put("ofc_cd", ofcCd);
			param.put("inv_rgst_no", invRgstNo);

			new SQLExecuter("DEFAULT").executeUpdate(new RailInvoiceauditDBDAOUpdateRgstNoInvWrkUSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CLM History 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchCLMHistory(EsdTrs0925Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> condiParams = event.getColumnValues();
			param.putAll(condiParams);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchCLMHistoryRSQL(), param, param);
			log.debug("searchCLMHistory count >>>>>>>>>>>>>>>>:" + dbRowset.getRowCount());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Invoice 목록을 가져온다.<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceList(EsdTrs0925Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> condiParams = event.getColumnValues();
			param.putAll(condiParams);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchInvoiceListRSQL(), param, param);
			log.debug("searchInvoiceList count >>>>>>>>>>>>>>>>:" + dbRowset.getRowCount());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Billing History 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchBillingList(EsdTrs0925Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> condiParams = event.getColumnValues();
			param.putAll(condiParams);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchBillingListRSQL(), param, param);
			log.debug("searchBillingList count >>>>>>>>>>>>>>>>:" + dbRowset.getRowCount());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Billing History 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchContainerInfo(EsdTrs0038Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = event.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchContainerInfoRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Invoice File Verify List<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList verifyInvoiceFileImportEqNo(EsdTrs0923Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();
		ArrayList returnList = new ArrayList();
		try {
			for (int i = 0; i < model.length; i++) {
				if (event != null && !"".equals(model[i].getCntrNo())) {
					param.put("cntr_no", model[i].getCntrNo());
				} else {
					param.put("cntr_no", "");
				}
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOSearchVerifyInvoiceFileImportEqNoRSQL(), param, param);
				returnList.add(dbRowset);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return returnList;
	}

	/**
	 * Invoice File Verify List<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList verifyInvoiceFileImportInvNo(EsdTrs0923Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();
		ArrayList returnList = new ArrayList();
		try {
			for (int i = 0; i < model.length; i++) {
				if (event != null && !"".equals(model[i].getCntrNo())) {
					param.put("cntr_no", model[i].getCntrNo());
				} else {
					param.put("cntr_no", "");
				}
				if (event != null && !"".equals(model[i].getWblDt())) {
					param.put("wbl_dt", model[i].getWblDt());
				} else {
					param.put("wbl_dt", "");
				}
				param.put("rail_road_code", event.getRailRoadCode());
				dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOVerifyInvoiceFileImportInvNoRSQL(), param, velParam);
				returnList.add(dbRowset);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return returnList;
	}

	/**
	 * Invoice File Verify List<br>
	 * 
	 * @param TrsTrspRailInvDtlVO trsTrspRailInvDtlVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyInvoiceFileImportVndrSetList(TrsTrspRailInvDtlVO trsTrspRailInvDtlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("cntr_no", trsTrspRailInvDtlVO.getCntrNo());
			param.put("wblDt", trsTrspRailInvDtlVO.getWblDt());
			param.put("invBilAmt", trsTrspRailInvDtlVO.getInvBilAmt());
			param.put("railRoadCode", trsTrspRailInvDtlVO.getInvVndrSeq());
			param.put("currency", trsTrspRailInvDtlVO.getCurrCd());
			param.put("fm_nod_cd", trsTrspRailInvDtlVO.getInvOrgNodNm());
			param.put("to_nod_cd", trsTrspRailInvDtlVO.getInvDestNodNm());
			return new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOVerifyInvoiceFileImportVndrSetListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * Invoice File Verify List<br>
	 * 
	 * @param TrsTrspRailInvDtlVO trsTrspRailInvDtlVO
	 * @return
	 * @throws DAOException
	 */
	public String verifyInvoiceFileImportVndrSetListForMultiSo(TrsTrspRailInvDtlVO trsTrspRailInvDtlVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		String invNo = "";
		try {
			param.put("cntr_no", trsTrspRailInvDtlVO.getCntrNo());
			param.put("wblDt", trsTrspRailInvDtlVO.getWblDt());
			param.put("invBilAmt", trsTrspRailInvDtlVO.getInvBilAmt());
			param.put("railRoadCode", trsTrspRailInvDtlVO.getInvVndrSeq());
			param.put("currency", trsTrspRailInvDtlVO.getCurrCd());
			param.put("fm_nod_cd", trsTrspRailInvDtlVO.getInvOrgNodNm());
			param.put("to_nod_cd", trsTrspRailInvDtlVO.getInvDestNodNm());
			DBRowSet ds = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate) new RailInvoiceauditDBDAOVerifyInvoiceFileImportVndrSetListForMultiSoRSQL(), param, param);
			if (ds.next()) {
				invNo = ds.getString(1);
			}
			return invNo;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}
}