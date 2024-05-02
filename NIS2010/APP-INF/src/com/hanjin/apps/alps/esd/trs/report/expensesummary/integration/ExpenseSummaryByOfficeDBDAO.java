/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExpenseSummaryByOfficeDBDAO.java
*@FileTitle : Expense Summary by Office
*Open Issues :
*Change history : Report - Expense Summary by Office 화면신규 개발 
*@LastModifyDate : 2009-01-08
*@LastModifier : ah young Han
*@LastVersion : 1.0
* 2009-01-08 ah young Han
* 1.0 최초 생성
* N200901080024  2009-02-27 'Report(Expense Summary by Office) 메뉴 개발 요청 '
* R200904140001  2009-04-14 searchExpenseSummaryByOffice 쿼리 수정
* 2011.07.26 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
* 2012.02.15 금병주 [CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
* 2012.03.19 권   민 [CHM-201216858] [TRS] Expense Summary Report 조회속도 튜닝 작업
* 2013.04.12 조인영 [CHM-201323766] Report Multiple select 조회 기능 추가
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.expensesummary.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.basic.ExpenseSummaryByOfficeBCImpl;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.event.EsdTrs0104Event;
import com.hanjin.apps.alps.esd.trs.report.expensesummary.vo.SearchHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ENIS-Transportation S/O에 대한 DB 처리를 담당<br>
 * - ENIS-Transportation S/O Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author ah young Han
 * @see ExpenseSummaryByOfficeBCImpl 참조
 * @since J2EE 1.4
 */
public class ExpenseSummaryByOfficeDBDAO extends DBDAOSupport {


	/**
	 * searchExpenseSummary By Office 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchExpenseSummaryByOffice(EsdTrs0104Event event) throws DAOException {		
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchHeaderVO shvo = event.getSearchHeaderVO();

//		StringTokenizer st = null;
		
		try {
			String input_office  = shvo.getInputOffice();
			
			
			if( !input_office.equals("") && !input_office.equals("null") && input_office != null) {
				ArrayList<String> inputOfcArr = null;
				
				inputOfcArr = CommonUtil.seperationParameter(input_office, ",");
				param.put("inputOfcArr", inputOfcArr);
			}
			
            String status_cd = shvo.getStatusCd();
            if(!status_cd.equals("") && !status_cd.equals("null") && status_cd != null && !status_cd.equals("INV"))
            {
                java.util.ArrayList statusCdArr = null;
                statusCdArr = CommonUtil.seperationParameter(status_cd, ",");
                param.put("statusCdArr", statusCdArr);
            }

            String costmode = shvo.getSelCostmode();
            if(!costmode.equals("") && !costmode.equals("null") && costmode != null && !costmode.equals("ALL"))
            {
                java.util.ArrayList costmodeArr = null;
                costmodeArr = CommonUtil.seperationParameter(costmode, ",");
                param.put("costmodeArr", costmodeArr);
            }
            
            String transmode = shvo.getSelTransmode();
            if(!transmode.equals("") && !transmode.equals("null") && transmode != null && !transmode.equals("ALL"))
            {
                java.util.ArrayList transmodeArr = null;
                transmodeArr = CommonUtil.seperationParameter(transmode, ",");
                param.put("transmodeArr", transmodeArr);
            }
            
            String sotype = shvo.getSelSotype();
            if(!sotype.equals("") && !sotype.equals("null") && sotype != null && !sotype.equals("ALL"))
            {
                java.util.ArrayList sotypeArr = null;
                sotypeArr = CommonUtil.seperationParameter(sotype, ",");
                param.put("sotypeArr", sotypeArr);
            }
            
            DBRowSet dORs = new SQLExecuter("DEFAULT").executeQuery(new ExpenseSummaryByOfficeDBDAOSearchExpenseSummaryByOfficeChkRSQL(), param,param);
            if(dORs .next()){
            	String chk = dORs .getString("chk");
            	param.put("chk", chk);  
            }
			
			param.put("period", shvo.getHidPeriod());  
			param.put("FromDate", shvo.getHidFromDate());
			param.put("ToDate", shvo.getHidToDate());
			param.put("radio_office", shvo.getRadioOffice());
			param.put("input_office", shvo.getInputOffice());
			param.put("costmode", shvo.getSelCostmode());
			param.put("transmode", shvo.getSelTransmode());
			param.put("sotype", shvo.getSelSotype());	
			param.put("bndcd", shvo.getIoBound());
			param.put("bkgterm", shvo.getSelBkgterm());
			param.put("node_div", shvo.getNodeDiv());
			param.put("from_node", shvo.getHidFromNode());
			param.put("via_node", shvo.getHidViaNode());
			param.put("to_node", shvo.getHidToNode());
			param.put("door_node", shvo.getHidDoorNode());
			param.put("status_cd", shvo.getStatusCd());
			//grid flag parameter 추가 2012.02.15 kbj
			param.put("grid_flg", event.getGrid_flg());
			//ETS_YN parameter 추가 2012.08.16 SHIN DONG IL
			param.put("ets_yn", shvo.getEtsYn());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ExpenseSummaryByOfficeDBDAOSearchExpenseSummaryByOfficeRSQL(), param,param);
			

			
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
	 * searchExpenseSummary By Office 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchOfficeCount(EsdTrs0104Event event) throws DAOException {		
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchHeaderVO shvo = event.getSearchHeaderVO();

		try {
			String input_office  = shvo.getInputOffice();
			
			
			if( !input_office.equals("") && !input_office.equals("null") && input_office != null) {
				ArrayList<String> inputOfcArr = null;
				
				inputOfcArr = CommonUtil.seperationParameter(input_office, ",");
				param.put("inputOfcArr", inputOfcArr);
			}
			
            String status_cd = shvo.getStatusCd();
            if(!status_cd.equals("") && !status_cd.equals("null") && status_cd != null && !status_cd.equals("INV"))
            {
                java.util.ArrayList statusCdArr = null;
                statusCdArr = CommonUtil.seperationParameter(status_cd, ",");
                param.put("statusCdArr", statusCdArr);
            }

            String costmode = shvo.getSelCostmode();
            if(!costmode.equals("") && !costmode.equals("null") && costmode != null && !costmode.equals("ALL"))
            {
                java.util.ArrayList costmodeArr = null;
                costmodeArr = CommonUtil.seperationParameter(costmode, ",");
                param.put("costmodeArr", costmodeArr);
            }
            
            String transmode = shvo.getSelTransmode();
            if(!transmode.equals("") && !transmode.equals("null") && transmode != null && !transmode.equals("ALL"))
            {
                java.util.ArrayList transmodeArr = null;
                transmodeArr = CommonUtil.seperationParameter(transmode, ",");
                param.put("transmodeArr", transmodeArr);
            }
            
            String sotype = shvo.getSelSotype();
            if(!sotype.equals("") && !sotype.equals("null") && sotype != null && !sotype.equals("ALL"))
            {
                java.util.ArrayList sotypeArr = null;
                sotypeArr = CommonUtil.seperationParameter(sotype, ",");
                param.put("sotypeArr", sotypeArr);
            }
            
            DBRowSet dORs = new SQLExecuter("DEFAULT").executeQuery(new ExpenseSummaryByOfficeDBDAOSearchExpenseSummaryByOfficeChkRSQL(), param,param);
            if(dORs .next()){
            	String chk = dORs .getString("chk");
            	param.put("chk", chk);  
            }
			
			param.put("period", shvo.getHidPeriod());  
			param.put("FromDate", shvo.getHidFromDate());
			param.put("ToDate", shvo.getHidToDate());
			param.put("radio_office", shvo.getRadioOffice());
			param.put("input_office", shvo.getInputOffice());
			param.put("costmode", shvo.getSelCostmode());
			param.put("transmode", shvo.getSelTransmode());
			param.put("sotype", shvo.getSelSotype());	
			param.put("bndcd", shvo.getIoBound());
			param.put("bkgterm", shvo.getSelBkgterm());
			param.put("node_div", shvo.getNodeDiv());
			param.put("from_node", shvo.getHidFromNode());
			param.put("via_node", shvo.getHidViaNode());
			param.put("to_node", shvo.getHidToNode());
			param.put("door_node", shvo.getHidDoorNode());
			param.put("status_cd", shvo.getStatusCd());
			param.put("grid_flg", event.getGrid_flg());
			param.put("ets_yn", shvo.getEtsYn());
			dRs = new SQLExecuter("DEFAULT").executeQuery(new ExpenseSummaryByOfficeDBDAOSearchOfficeCountRSQL(), param,param);
			

			
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