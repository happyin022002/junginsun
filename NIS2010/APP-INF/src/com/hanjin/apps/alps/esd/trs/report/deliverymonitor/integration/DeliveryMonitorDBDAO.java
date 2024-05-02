/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DeliveryMonitorDBDAO.java
*@FileTitle : Delivery Monitering
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2014.10.29 [CHM-201432512] Delivery Monitoring 메뉴 개선2
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.deliverymonitor.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event.EsdTrs0260Event;
import com.hanjin.apps.alps.esd.trs.report.deliverymonitor.event.EsdTrs0270Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 
 * @see DeliveryMonitorDBDAO 참조
 * @since J2EE 1.4
 */
public class DeliveryMonitorDBDAO extends DBDAOSupport {
	
	/**
	 * Delivery Motiring Summary 조회.<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchDelivery(EsdTrs0260Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
		List<String> ofcCode = new ArrayList();
		List<String> bkgNumber = new ArrayList();
		List<String> cntrNumber = new ArrayList();
		List<String> soNumber = new ArrayList();
		List<String> woNumber = new ArrayList();

		String sOfcCd = JSPUtil.getNull(event.getsOfcCd());
		if(!sOfcCd.equals("")){
			String arrOfcCd[] = sOfcCd.split(",");
			for(int i=0;i<arrOfcCd.length;i++){   
				ofcCode.add(arrOfcCd[i]);   
			} 
		}
		param.put("arr_ofc_cd",ofcCode);
		
		String sBkgNo = JSPUtil.getNull(event.getsBkgNo());
		if(!sBkgNo.equals("")){
			String arrBkgNo[] = sBkgNo.split(",");
			for(int i=0;i<arrBkgNo.length;i++){   
				bkgNumber.add(arrBkgNo[i]);   
			} 
		}
		param.put("arr_bkg_no",bkgNumber);
		
		String sCntrNo = JSPUtil.getNull(event.getsCntrNo());
		if(!sCntrNo.equals("")){
			String arrCntrNo[] = sCntrNo.split(",");
			for(int i=0;i<arrCntrNo.length;i++){   
				cntrNumber.add(arrCntrNo[i]);   
			} 
		}
		param.put("arr_cntr_no",cntrNumber);
		
		String sSoNo = JSPUtil.getNull(event.getsSoNo());
		if(!sSoNo.equals("")){
			String arrSoNo[] = sSoNo.split(",");
			for(int i=0;i<arrSoNo.length;i++){   
				soNumber.add(arrSoNo[i]);   
			} 
		}
		param.put("arr_so_no",soNumber);
		
		String sWoNo = JSPUtil.getNull(event.getsWoNo());
		if(!sWoNo.equals("")){
			String arrWoNo[] = sWoNo.split(",");
			for(int i=0;i<arrWoNo.length;i++){   
				soNumber.add(arrWoNo[i]);   
			} 
		}
		param.put("arr_wo_no",woNumber);

		String sFromDt =  JSPUtil.getNull(event.getsFromDt());
		param.put("sFromDt",sFromDt);
		
		String sToDt =  JSPUtil.getNull(event.getsToDt());
		param.put("sToDt",sToDt);
		
		String sBndCd = JSPUtil.getNull(event.getsBndCd());
		param.put("sBndCd",sBndCd);
		
		String sDoYn =  JSPUtil.getNull(event.getsDoYn());
		param.put("sDoYn",sDoYn);
		
		String sStsCd = JSPUtil.getNull(event.getsStsCd());
		param.put("sStsCd",sStsCd);

		String sFmLoc = JSPUtil.getNull(event.getsFmLoc());
		String sFmYard = JSPUtil.getNull(event.getsFmYard());
		param.put("sFmLoc",sFmLoc+sFmYard);

		String sViaLoc = JSPUtil.getNull(event.getsViaLoc());
		String sViaYard = JSPUtil.getNull(event.getsViaYard());
		param.put("sViaLoc",sViaLoc+sViaYard);
		
		String sToLoc = JSPUtil.getNull(event.getsToLoc());
		String sToYard = JSPUtil.getNull(event.getsToYard());
		param.put("sToLoc",sToLoc+sToYard);
		
		String sDrLoc = JSPUtil.getNull(event.getsDrLoc());
		String sDrYard = JSPUtil.getNull(event.getsDrYard());
		param.put("sDrLoc",sDrLoc+sDrYard);
		
		String sDrNm = JSPUtil.getNull(event.getsDrNm());
		param.put("sDrNm",sDrNm);

		try {
			dRs = new SQLExecuter("").executeQuery(new DeliveryMonitorDBDAOsearchDeliveryRSQL(), param,param);
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
	 * Delivery Motiring Detail 조회.<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchDeliveryDetail(EsdTrs0270Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		List<String> bkgNumber = new ArrayList();
		List<String> cntrNumber = new ArrayList();
		List<String> soNumber = new ArrayList();
		List<String> woNumber = new ArrayList();
		
		String sBkgNo = JSPUtil.getNull(event.getsBkgNo());
		if(!sBkgNo.equals("")){
			String arrBkgNo[] = sBkgNo.split(",");
			for(int i=0;i<arrBkgNo.length;i++){   
				bkgNumber.add(arrBkgNo[i]);   
			} 
		}
		param.put("arr_bkg_no",bkgNumber);
		
		String sCntrNo = JSPUtil.getNull(event.getsCntrNo());
		if(!sCntrNo.equals("")){
			String arrCntrNo[] = sCntrNo.split(",");
			for(int i=0;i<arrCntrNo.length;i++){   
				cntrNumber.add(arrCntrNo[i]);   
			} 
		}
		param.put("arr_cntr_no",cntrNumber);
		
		String sSoNo = JSPUtil.getNull(event.getsSoNo());
		if(!sSoNo.equals("")){
			String arrSoNo[] = sSoNo.split(",");
			for(int i=0;i<arrSoNo.length;i++){   
				soNumber.add(arrSoNo[i]);   
			} 
		}
		param.put("arr_so_no",soNumber);
		
		String sWoNo = JSPUtil.getNull(event.getsWoNo());
		if(!sWoNo.equals("")){
			String arrWoNo[] = sWoNo.split(",");
			for(int i=0;i<arrWoNo.length;i++){   
				soNumber.add(arrWoNo[i]);   
			} 
		}
		param.put("arr_wo_no",woNumber);
		
		String sOfcCd =  JSPUtil.getNull(event.getsOfcCd());
		param.put("sOfcCd",sOfcCd);
		
		String sFromDt =  JSPUtil.getNull(event.getsFromDt());
		param.put("sFromDt",sFromDt);
		
		String sToDt =  JSPUtil.getNull(event.getsToDt());
		param.put("sToDt",sToDt);
		
		String sBndCd = JSPUtil.getNull(event.getsBndCd());
		param.put("sBndCd",sBndCd);
		
		String sDoYn =  JSPUtil.getNull(event.getsDoYn());
		param.put("sDoYn",sDoYn);
		
		String sStsCd = JSPUtil.getNull(event.getsStsCd());
		param.put("sStsCd",sStsCd);
		
		String sFmLoc = JSPUtil.getNull(event.getsFmLoc());
		param.put("sFmLoc",sFmLoc);

		String sViaLoc = JSPUtil.getNull(event.getsViaLoc());
		param.put("sViaLoc",sViaLoc);

		String sToLoc = JSPUtil.getNull(event.getsToLoc());
		param.put("sToLoc",sToLoc);

		String sDrLoc = JSPUtil.getNull(event.getsDrLoc());
		param.put("sDrLoc",sDrLoc);
		
		String sYrWeek = JSPUtil.getNull(event.getsYrWeek());
		param.put("sYrWeek",sYrWeek);

		try {
			dRs = new SQLExecuter("").executeQuery(new DeliveryMonitorDBDAOsearchDeliveryDetailRSQL(), param,param);
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