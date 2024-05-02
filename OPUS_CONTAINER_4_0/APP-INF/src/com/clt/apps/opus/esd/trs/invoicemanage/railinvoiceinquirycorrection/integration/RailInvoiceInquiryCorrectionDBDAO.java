/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InvoiceInquiryCorrectionDBDAO.java
 *@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.vo.SearchInvoiceInquirySecondExcelFormVO;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic.RailInvoiceInquiryCorrectionBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.event.EsdTrs0046Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.vo.SearchRailInvoiceInquiryCorrectionListConditionVO;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.vo.SearchUsRailInvoiceInquirySecondExcelFormVO;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.vo.TrsTrspRailInvWrkVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-invoicemanage에 대한 DB 처리를 담당<br>
 * - ESD-invoicemanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author chkong
 * @see RailInvoiceInquiryCorrectionBCImpl 참조
 * @since J2EE 1.4
 */
public class RailInvoiceInquiryCorrectionDBDAO extends DBDAOSupport {

	/**
	 * InvoiceInquiryCorrection의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchRailInvoiceInquiryCorrectionList(EsdTrs0046Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		StringTokenizer st = null;
		List<String> noCdArr = new ArrayList<String>();
		try {
			SearchRailInvoiceInquiryCorrectionListConditionVO conditionVO = event.getInquiryConditionVO();
			if (conditionVO != null) {
				Map<String, String> condiParams = conditionVO.getColumnValues();

				String dateCd = condiParams.get("date_cd");
				String fmdate = condiParams.get("fmdate").replace("-", "");
				String todate = condiParams.get("todate").replace("-", "");
				String statusCd = condiParams.get("status_cd");
				String holdCd = condiParams.get("hold_cd");
				String amountVerifyCd = condiParams.get("amount_verify_cd");
				String spTp = condiParams.get("sp_tp");
				String comboSvcProvider = condiParams.get("combo_svc_provider");
				String noTp = condiParams.get("no_tp");
				String noCd = condiParams.get("no_cd");
				if (!"".equals(noCd)) {
					int j = 0;
					noCdArr.clear();
					st = new StringTokenizer(noCd, ",");
					while (st.hasMoreTokens()) {
						String tmpStr = "";
						tmpStr = st.nextToken();
						tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
						noCdArr.add(j++, tmpStr);
					}
				}
				String invCreOfc = condiParams.get("inv_cre_ofc");
				String ivcCreUsrId = condiParams.get("ivc_cre_usr_id");

				param.put("dateCd", dateCd);
				param.put("fmdate", fmdate);
				param.put("todate", todate);
				param.put("statusCd", statusCd);
				param.put("holdCd", holdCd);
				param.put("amountVerifyCd", amountVerifyCd);
				param.put("spTp", spTp);
				param.put("comboSvcProvider", comboSvcProvider);
				param.put("noTp", noTp);
				param.put("noCd", noCdArr);
				param.put("invCreOfc", invCreOfc);
				param.put("ivcCreUsrId", ivcCreUsrId);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RailInvoiceInquiryCorrectionDBDAOSearchRailInvoiceInquiryCorrectionListRSQL(), param, param);

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
	 * InvoiceInquiryCorrection의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiRailInvoiceHold(EsdTrs0046Event event) throws DAOException {
		Collection<TrsTrspRailInvWrkVO> updModels = new ArrayList<TrsTrspRailInvWrkVO>();
		try {
			TrsTrspRailInvWrkVO[] multiVos = event.getTrsTrspRailInvWrkVOs();
			if (multiVos != null) {
				for (int i = 0; i < multiVos.length; i++) {
					if (multiVos[i].getIbflag().equals("U")) {
						updModels.add(multiVos[i]);
					}
				}
			}

			String usrId = event.getInquiryConditionVO().getUsrId();
			String usrOfcCd = event.getInquiryConditionVO().getUsrOfcCd();
			Map<String, Object> param_wrk = new HashMap<String, Object>();
			param_wrk.put("usrId", usrId);
			param_wrk.put("usrOfcCd", usrOfcCd);

			int[] updCnt = null;
			if (updModels.size() > 0) {
				updCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAOMultiRailInvoiceHoldUSQL(), updModels, param_wrk, param_wrk);
			}
			if (updCnt != null) {
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to UPDATE No" + i + " SQL");
					}
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
	 * InvoiceInquiryCorrection의 데이타 모델을 DB에서 삭제한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void removeRailInvoiceInquiryCorrection(EsdTrs0046Event event) throws DAOException {
		// DELETE / UPDATE STORAGE
		Collection<TrsTrspRailInvWrkVO> delUpdModels = new ArrayList<TrsTrspRailInvWrkVO>();
		try {
			// GRID ROWS DATA
			TrsTrspRailInvWrkVO[] multiVos = event.getTrsTrspRailInvWrkVOs();
			if (multiVos != null) {
				for (int i = 0; i < multiVos.length; i++) {
					delUpdModels.add(multiVos[i]);
				}
			}

			String usrId = event.getInquiryConditionVO().getUsrId();
			String usrOfcCd = event.getInquiryConditionVO().getUsrOfcCd();

			Map<String, Object> param_wrk = new HashMap<String, Object>();
			param_wrk.put("usrId", usrId);
			param_wrk.put("usrOfcCd", usrOfcCd);

			// -----------------------------------------------------------------------------------------------------------------------------
			// START [ DELETE TABLES ] TRS_TRSP_RAIL_INV_DTL / TRS_TRSP_RAIL_INV_WRK
			// [ UPDATE TABLES ] TRS_TRSP_RAIL_BIL_VNDR_SET / TRS_TRSP_RAIL_SO_IF / TRS_TRSP_RAIL_CONV_AMT / TRS_TRSP_RAIL_BIL_ORD
			// -----------------------------------------------------------------------------------------------------------------------------
			int[] delCnt = null;
			int[] updCnt = null;
			if (delUpdModels.size() > 0) {
				delCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAORemoveRailInvoiceInquiryCorrectionWrkDtlDSQL(), delUpdModels, param_wrk, param_wrk);
				updCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAORemoveRailInvoiceInquiryCorrectionVndrSetUSQL(), delUpdModels, param_wrk, param_wrk);
				delCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAORemoveRailInvoiceInquiryCorrectionWrkDSQL(), delUpdModels, param_wrk, param_wrk);
				updCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAORemoveRailInvoiceInquiryCorrectionConvAmtUSQL(), delUpdModels, param_wrk, param_wrk);
				updCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAORemoveRailInvoiceInquiryCorrectionBilOrdUSQL(), delUpdModels, param_wrk, param_wrk);
			}
			if (delCnt != null) {
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to DELETE No" + i + " SQL");
					}
				}
			}
			if (updCnt != null) {
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to UPDATE No" + i + " SQL");
					}
				}
			}
			// -----------------------------------------------------------------------------------------------------------------------------
			// END [ UPDATE ] , [ DELETE ]
			// -----------------------------------------------------------------------------------------------------------------------------

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * InvoiceInquiryCorrection의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiRailInvoiceConfirmCancel(EsdTrs0046Event event) throws DAOException {
		// DELETE / UPDATE STORAGE
		Collection<TrsTrspRailInvWrkVO> updModels = new ArrayList<TrsTrspRailInvWrkVO>();
		try {
			// GRID ROWS DATA
			TrsTrspRailInvWrkVO[] multiVos = event.getTrsTrspRailInvWrkVOs();
			if (multiVos != null) {
				for (int i = 0; i < multiVos.length; i++) {
					updModels.add(multiVos[i]);
				}
			}
			String invAudStsCd = event.getInquiryConditionVO().getInvAudStsCd();
			String userId = event.getInquiryConditionVO().getUsrId();
			String usrOfcCd = event.getInquiryConditionVO().getUsrOfcCd();

			Map<String, Object> param_wrk = new HashMap<String, Object>();
			param_wrk.put("invAudStsCd", invAudStsCd);
			param_wrk.put("usrId", userId);
			param_wrk.put("usrOfcCd", usrOfcCd);

			// -----------------------------------------------------------------------------------------------------------------------------
			// START [ UPDATE TABLES] TRS_TRSP_RAIL_INV_WRK / TRS_TRSP_RAIL_BIL_VNDR_SET / TRS_TRSP_RAIL_SO_IF / TRS_TRSP_RAIL_CONV_AMT
			// -----------------------------------------------------------------------------------------------------------------------------
			int[] updCnt = null;
			if (updModels.size() > 0) {
				updCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAOMultiRailInvoiceConfirmCancelWrkUSQL(), updModels, param_wrk, param_wrk);
				updCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAOMultiRailInvoiceConfirmCancelVndrSetUSQL(), updModels, param_wrk, param_wrk);
				updCnt = new SQLExecuter("").executeBatch(new RailInvoiceInquiryCorrectionDBDAOMultiRailInvoiceConfirmCancelConvAmtUSQL(), updModels, param_wrk, param_wrk);
			}
			if (updCnt != null) {
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to UPDATE No" + i + " SQL");
					}
				}
			}
			// -----------------------------------------------------------------------------------------------------------------------------
			// END [ UPDATE ]
			// -----------------------------------------------------------------------------------------------------------------------------

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * Invoice DownExcel 항목 조회.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public List<SearchInvoiceInquirySecondExcelFormVO> searchUsRailInvoiceInquirySecondExcelForm(EsdTrs0046Event event) throws DAOException {
		DBRowSet dbRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspRailInvWrkVO[] invWrkVOs = event.getTrsTrspRailInvWrkVOs();
		List<SearchInvoiceInquirySecondExcelFormVO> rsList = new ArrayList<SearchInvoiceInquirySecondExcelFormVO>();
		try {
			if (invWrkVOs != null) {
				for (int i = 0; i < invWrkVOs.length; i++) {
					if (invWrkVOs[i] != null) {
						param.put("inv_no", invWrkVOs[i].getInvNo());
						param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
						dbRs = new SQLExecuter("DEFAULT").executeQuery(new RailInvoiceInquiryCorrectionDBDAOSearchUsRailInvoiceInquirySecondExcelFormRSQL(), param, param);
						if (dbRs != null && dbRs.getRowCount() > 0) {
							List<SearchInvoiceInquirySecondExcelFormVO> listTemp = (List) RowSetUtil.rowSetToVOs(dbRs, SearchUsRailInvoiceInquirySecondExcelFormVO.class);
							rsList.addAll(listTemp);
						}
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return rsList;
	}
}