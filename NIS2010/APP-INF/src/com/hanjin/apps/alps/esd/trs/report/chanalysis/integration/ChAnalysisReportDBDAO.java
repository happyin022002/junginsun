/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PendingListDBDAO.java
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.chanalysis.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.report.chanalysis.event.EsdTrs0101Event;
import com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.basic.PendingListBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행<br>
 *
 * @author kimjin
 * @see PendingListBCImpl
 * @since J2EE 1.6 
 */
public class ChAnalysisReportDBDAO extends DBDAOSupport {

	/**
	 * PendingList 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchChAnalysis(EsdTrs0101Event event) throws DAOException {		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
						
		boolean month_flg = false;
		
		if (event.getSoFmdt().length() == 6) month_flg = true;

		param.put("MONTH_FLG", 		month_flg);
		param.put("INPUT_OFFICE", 	CommonUtil.seperationParameter(event.getInputOffice(), ","));
		param.put("FROM_NODE", 		CommonUtil.seperationParameter(event.getFrmNode(), ","));
		param.put("TO_NODE", 		CommonUtil.seperationParameter(event.getToNode(), ","));
		param.put("SO_FMDT", 		event.getSoFmdt());
		param.put("SO_TODT", 		event.getSoTodt());
		param.put("HID_BOUNDMODE", 	event.getHidBoundmode());
		param.put("HID_BKGTERM", 	event.getHidBkgterm());
		param.put("HID_TROSTS", 	event.getHidTrosts());
		param.put("HID_INCLMTY", 	event.getHidInclmty());
				
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChAnalysisReportDBDAOSearchChAnalysisRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		 return dRs;		 
	}

	/**
	 * 검색된 vvd 값을 리턴<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search_vvd(EsdTrs0101Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("TRUNK_VVD", event.getTrunkVvd());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChAnalysisReportDBDAOSearchVvdRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		 return dRs;		 
	}

	/**
	 * office 검색된 결과값을 리턴<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search_ofc(EsdTrs0101Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("SEL_RHQMODE", 	event.getHidRhq());
		param.put("HID_BOUNDMODE", 	event.getHidBoundmode());
		
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ChAnalysisReportDBDAOSearchOfcRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		 return dRs;		 
	}

	
	/**
	 * weekDate
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet weekDate(EsdTrs0101Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("WEEK", event.getHidWeek());
		
		try {
			if ("M".equals(event.getHidPeriod()))
				dRs = new SQLExecuter("DEFAULT").executeQuery(new ChAnalysisReportDBDAOWeekDateMonthRSQL(), param,param);
			else
				dRs = new SQLExecuter("DEFAULT").executeQuery(new ChAnalysisReportDBDAOWeekDateWeekRSQL(), param,param);				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		 return dRs;		 
	}		
}