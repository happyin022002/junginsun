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
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0939Event;
import com.hanjin.bizcommon.approval.event.ComEns0U1Event;
import com.hanjin.bizcommon.approval.event.ComEns0U2Event;
import com.hanjin.bizcommon.authorization.vo.AuthorizationAproVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationInquiryVO;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdVO;


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
		ArrayList arrWoNo = new ArrayList();
		StringTokenizer st = null;
		
		String fmdate = event.getFmDate();
		String todate = event.getToDate();
		String combo_svc_provider = event.getComboSvcProvider();
		String wo_no = event.getWoNo();
		String wo_issue_office = event.getWoIssueOffice();
		String wo_issue_user = event.getWoIssueUser();
		String sel_ets = event.getSelEts();
		String wo_iss_sts = event.getWoIssSts();
		String sel_costmode = event.getSelCostMode();
		String issue_type = event.getIssueType();
		String sel_transmode = event.getSelTransMode();
		
		param.put("fmdate", fmdate);
		param.put("todate", todate);
		param.put("combo_svc_provider", combo_svc_provider);
		param.put("wo_no", wo_no);
		param.put("wo_issue_office", wo_issue_office);
		param.put("wo_issue_user", wo_issue_user);
		param.put("sel_ets", sel_ets);
		param.put("wo_iss_sts", wo_iss_sts);
		param.put("sel_costmode", sel_costmode);
		param.put("issue_type", issue_type);
		param.put("sel_transmode", sel_transmode);

		if(wo_no != null){
			if( !wo_no.equals("")) {
				int j = 0;
				st = new StringTokenizer(wo_no, ",");

				while( st.hasMoreTokens() ) {
					String wo = st.nextToken();
					arrWoNo.add(j++, wo);
				}
			}
		}
		param.put("wo_no", arrWoNo);

		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchWorkOrderInquiryListRSQL(), param,param);
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
	public DBRowSet searchWorkOrderInquiry(EsdTrs0025Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String wo_no_a = event.getWoNoA();

		param.put("wo_no_a", CommonUtil.seperationParameter(wo_no_a, ","));

		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchWorkOrderInquiryRSQL(), param,param);
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
	public DBRowSet searchWorkOrderInquiryAddCancel(EsdTrs0025Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String wo_no_a = event.getWoNoA();

		param.put("wo_no_a", CommonUtil.seperationParameter(wo_no_a, ","));

		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchWorkOrderInquiryAddCancelRSQL(), param,param);
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
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList<String> arrWoNo = new ArrayList<String>();
		
		TrsTrspWrkOrdVO [] trsTrspWrkOrdVOs = event.getTrsTrspWrkOrdVOs();
		
//		String cnt = "";
		String wo = "";
//		int returnInsertInt = 0;
//		int returnInsert2Int = 0;
		
		try {
			
			for(int f=0; trsTrspWrkOrdVOs != null && f < trsTrspWrkOrdVOs.length; f++){
				wo = trsTrspWrkOrdVOs[f].getTrspWoOfcCtyCd()+trsTrspWrkOrdVOs[f].getTrspWoSeq();
				arrWoNo.add(f, wo);
			}
			param.put("wo_no_a",arrWoNo);
			
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchWorkOrderInquiryRSQL(), param,param);
		

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
	public DBRowSet searchSvcOrdHisList(EsdTrs0025Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String wo_no_a = event.getWoNoA();
		String wo_iss_knt = event.getWoIssKnt();

		param.put("wo_no_a", wo_no_a);
		param.put("wo_iss_knt", wo_iss_knt);

		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchSvcOrdHisListRSQL(), param,param);
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
	 * WorkOrder Auth의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAuthWrkOrdList(EsdTrs0939Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String authAproRqstNo = event.getAuthAproRqstNo();

		param.put("auth_apro_rqst_no", authAproRqstNo);

		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchAuthWrkOrdListRSQL(), param, param);
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
	 * 조회 이벤트 처리<br>
	 * Authorization Approval Confirm 화면에 대한 TRS 용 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return 
	 * @throws DAOException
	 */
	public DBRowSet searchAuthApproTrsList(ComEns0U1Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		AuthorizationAproVO authorizationAproVO = event.getAuthorizationAproVO();
		Map<String, String> paramVo = authorizationAproVO.getColumnValues();
		param.putAll(paramVo);

		try {
			param.put("login_usr_id", event.getSignOnUserAccount().getUsr_id());
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchAuthApprovalTrsListRSQL(), param, param);
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
	 * 조회 이벤트 처리<br>
	 * Authorization Approval Inquiry 화면에 대한 TRS 용 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return 
	 * @throws DAOException
	 */
	public DBRowSet searchAuthAproTrsInquiry(ComEns0U2Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		AuthorizationInquiryVO authorizationInquiryVO = event.getAuthorizationInquiryVO();
		Map<String, String> paramVo = authorizationInquiryVO.getColumnValues();
		param.putAll(paramVo);

		try {
			dRs = new SQLExecuter().executeQuery(new WorkOrderInquiryDBDAOsearchAuthAproTrsInquiryRSQL(), param, param);
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