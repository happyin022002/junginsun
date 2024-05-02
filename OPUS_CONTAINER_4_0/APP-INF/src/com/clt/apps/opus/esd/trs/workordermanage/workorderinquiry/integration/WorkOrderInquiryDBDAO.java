/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderInquiryDBDAO.java
 *@FileTitle : W/O 발행내역을 조회하는 화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-26
 *@LastModifier : poong_yeon
 *@LastVersion : 1.0
 * 2006-12-26 poong_yeon
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsTrspWrkOrdVO;

/**
 * ESD-workordermanage에 대한 DB 처리를 담당<br>
 * - ESD-workordermanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong_yeon
 * @see WorkOrderInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class WorkOrderInquiryDBDAO extends DBDAOSupport {

	/**
	 * WorkOrderInquiry의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderInquiryList(EsdTrs0025Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String> arrWoNo = new ArrayList<String>();
		String wo_no = event.getWoNo();
		param.put("fmdate", event.getFmDate());
		param.put("todate", event.getToDate());
		param.put("combo_svc_provider", event.getComboSvcProvider());
		param.put("wo_issue_office", event.getWoIssueOffice());
		param.put("wo_issue_user", event.getWoIssueUser());
		param.put("sel_ets", event.getSelEts());
		param.put("wo_iss_sts", event.getWoIssSts());
		param.put("sel_costmode", event.getSelCostMode());
		param.put("issue_type", event.getIssueType());
		param.put("sel_transmode", event.getSelTransMode());
		if (wo_no != null) {
			if (!wo_no.equals("")) {
				int j = 0;
				StringTokenizer st = new StringTokenizer(wo_no, ",");
				while (st.hasMoreTokens()) {
					String wo = st.nextToken();
					arrWoNo.add(j++, wo);
				}
			}
		}
		param.put("wo_no", arrWoNo);
		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchWorkOrderInquiryListRSQL(), param, param);
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
		return dRs;
	}

	/**
	 * WorkOrderInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings("rawtypes")
	public DBRowSet searchWorkOrderInquiry(EsdTrs0025Event event) throws DAOException {
		DBRowSet dRs = null;
		try {
			String wo_no_a = event.getWoNoA();
			ArrayList arrayParams = CommonUtil.seperationParameter(wo_no_a, ",");
			if (arrayParams != null && !arrayParams.isEmpty()) {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("wo_no_a", arrayParams);

				dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchWorkOrderInquiryRSQL(), param, param);
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
		return dRs;
	}

	/**
	 * WorkOrderInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchWorkOrderList(EsdTrs0025Event event) throws DAOException {
		DBRowSet dRs = null;
		TrsTrspWrkOrdVO[] trsTrspWrkOrdVOs = event.getTrsTrspWrkOrdVOs();
		try {
			if (trsTrspWrkOrdVOs != null) {
				ArrayList<String> arrWoNo = new ArrayList<String>();
				Map<String, Object> param = new HashMap<String, Object>();
				for (int f = 0; f < trsTrspWrkOrdVOs.length; f++) {
					if (!CheckUtilities.isInBlank(trsTrspWrkOrdVOs[f].getTrspWoOfcCtyCd()) && !CheckUtilities.isInBlank(trsTrspWrkOrdVOs[f].getTrspWoSeq())) {
						arrWoNo.add(f, trsTrspWrkOrdVOs[f].getTrspWoOfcCtyCd() + trsTrspWrkOrdVOs[f].getTrspWoSeq());
					}
				}
				param.put("wo_no_a", arrWoNo);
				dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchWorkOrderInquiryRSQL(), param, param);
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
		return dRs;
	}
}