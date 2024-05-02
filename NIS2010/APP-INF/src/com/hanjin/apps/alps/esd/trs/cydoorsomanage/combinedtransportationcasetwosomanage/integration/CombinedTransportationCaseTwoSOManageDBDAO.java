/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CombinedTransportationCaseTwoSOManageDBDAO.java
*@FileTitle : CY & Door S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-29
*@LastModifier : z_kim_sang_geun
*@LastVersion : 1.0
* 2006-09-29 z_kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.integration;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.basic.CombinedTransportationCaseTwoSOManageBCImpl;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.combinedtransportationcasetwosomanage.event.EsdTrs0920Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author z_kim_sang_geun
 * @see CombinedTransportationCaseTwoSOManageBCImpl 참조
 * @since J2EE 1.4
 */
public class CombinedTransportationCaseTwoSOManageDBDAO extends DBDAOSupport {

	/**
	 * CombinedTransportationCaseTwoSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Cy AND Door Creation PART is Match Making Two.(Insert)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCombinedTransportationCaseTwoSOManage(EsdTrs0920Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		DBRowSet dRs = null;
		try{
			String strCostMode = event.getTrspCostDtlModCd(); //COST MODE : CY, DOOR
			// 쿼리에 변수 세팅.
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmSS"); //날짜의 FORMAT 형식
			String lstdate = "";
			int iyer = 0;
			int imon = 0;
			int iday = 0;
			int ihor = 0;
			int imin = 0;
			int isec = 0;
			String sFtime = "";
			String sTtime = "";
			String sNodeL = "";
			if( strCostMode.equals("CY") ) {
				lstdate = String.valueOf(event.getLstNodPlnDt()+event.getLstNodPlnDtHms());
				if( lstdate.length() > 10 ) {
					iyer = Integer.parseInt(lstdate.substring(0,   4)) - 1900;
					imon = Integer.parseInt(lstdate.substring(4,   6)) - 1;
					iday = Integer.parseInt(lstdate.substring(6,   8));
					ihor = Integer.parseInt(lstdate.substring(8,  10));
					imin = Integer.parseInt(lstdate.substring(10, 12));
					isec = Integer.parseInt(lstdate.substring(12, 14));
				}
				sFtime = sdf.format(new Date(iyer, imon, iday, ihor-2, imin, isec));           //From Departure Time
				sTtime = sdf.format(new Date(iyer, imon, iday, ihor+2, imin, isec));           //From Departure Time
				sNodeL = String.valueOf(event.getToNodCd()+event.getToNodYard());          //FromNode는 다른ToNode와 같아야한다.
			} else if( strCostMode.equals("DOOR") ) {
				lstdate = String.valueOf(event.getDorNodPlnDt()+event.getDorNodPlnDtHms());
				if( lstdate.length() > 10 ) {
					iyer = Integer.parseInt(lstdate.substring(0,   4)) - 1900;
					imon = Integer.parseInt(lstdate.substring(4,   6)) - 1;
					iday = Integer.parseInt(lstdate.substring(6,   8));
					ihor = Integer.parseInt(lstdate.substring(8,  10));
					imin = Integer.parseInt(lstdate.substring(10, 12));
					isec = Integer.parseInt(lstdate.substring(12, 14));
				}
				sFtime = sdf.format(new Date(iyer, imon, iday, ihor-2, imin, isec));    //Door Arrival Time
				sTtime = sdf.format(new Date(iyer, imon, iday, ihor+2, imin, isec));    //Door Arrival Time
				sNodeL = String.valueOf(event.getDorNodCd()+event.getDorNodYard()); //DoorNode는 다른DoorNode와 같아야한다.
			}
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("sNodeL",sNodeL);
			param.put("eq_tpsz_cd",event.getEqTpszCd());
			param.put("trsp_so_ofc_cty_cd",event.getTrspSoOfcCtyCd());
			param.put("lst_nod_pln_dt",event.getLstNodPlnDt());
			param.put("strCostMode",strCostMode);
			param.put("sFtime",sFtime);
			param.put("sTtime",sTtime);
			param.put("ui_conti_cd",event.getUiContiCd());
			param.put("cydoor_div",event.getCydoorDiv());
			
			Map<String, Object> vparam = new HashMap<String, Object>();
			vparam.put("strCostMode", strCostMode);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	
			CombinedTransportationCaseTwoSOManageDBDAOSearchCombinedTransportationCaseTwoSOManageRSQL template = new CombinedTransportationCaseTwoSOManageDBDAOSearchCombinedTransportationCaseTwoSOManageRSQL();
			dRs = sqlExe.executeQuery(template, param, vparam);
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
	 * CombinedTransportationCaseTwoSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * Cy AND Door Correction PART is Match Making Two.(Update)
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search02CombinedTransportationCaseTwoSOManage(EsdTrs0920Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		DBRowSet dRs = null;
		try{
			String strCostMode = event.getTrspCostDtlModCd(); //COST MODE : CY, DOOR
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmSS"); //날짜의 FORMAT 형식
			String lstdate = "";
			int iyer = 0;
			int imon = 0;
			int iday = 0;
			int ihor = 0;
			int imin = 0;
			int isec = 0;
			String sFtime = "";
			String sTtime = "";
			String sNodeL = "";
			if( strCostMode.equals("CY") ) {
				lstdate = String.valueOf(event.getLstNodPlnDt()+event.getLstNodPlnDtHms());
				if( lstdate.length() > 10 ) {
					iyer = Integer.parseInt(lstdate.substring(0,   4)) - 1900;
					imon = Integer.parseInt(lstdate.substring(4,   6)) - 1;
					iday = Integer.parseInt(lstdate.substring(6,   8));
					ihor = Integer.parseInt(lstdate.substring(8,  10));
					imin = Integer.parseInt(lstdate.substring(10, 12));
					isec = Integer.parseInt(lstdate.substring(12, 14));
				}
				sFtime = sdf.format(new Date(iyer, imon, iday, ihor-2, imin, isec));           //From Departure Time
				sTtime = sdf.format(new Date(iyer, imon, iday, ihor+2, imin, isec));           //From Departure Time
				sNodeL = String.valueOf(event.getToNodCd()+event.getToNodYard());          //FromNode는 다른ToNode와 같아야한다.
			} else if( strCostMode.equals("DOOR") ) {
				lstdate = String.valueOf(event.getDorNodPlnDt()+event.getDorNodPlnDtHms());
				if( lstdate.length() > 10 ) {
					iyer = Integer.parseInt(lstdate.substring(0,   4)) - 1900;
					imon = Integer.parseInt(lstdate.substring(4,   6)) - 1;
					iday = Integer.parseInt(lstdate.substring(6,   8));
					ihor = Integer.parseInt(lstdate.substring(8,  10));
					imin = Integer.parseInt(lstdate.substring(10, 12));
					isec = Integer.parseInt(lstdate.substring(12, 14));
				}
				sFtime = sdf.format(new Date(iyer, imon, iday, ihor-2, imin, isec));    //Door Arrival Time
				sTtime = sdf.format(new Date(iyer, imon, iday, ihor+2, imin, isec));    //Door Arrival Time
				sNodeL = String.valueOf(event.getDorNodCd()+event.getDorNodYard()); //DoorNode는 다른DoorNode와 같아야한다.
			}			
			
		
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cre_ofc_cd", event.getCreOfcCd());
			param.put("lst_nod_pln_dt", event.getLstNodPlnDt());
			param.put("eq_tpsz_cd", event.getEqTpszCd());
			param.put("sFtime", sFtime);
			param.put("sTtime",sTtime);
			param.put("sNodeL",sNodeL);
			Map<String, Object> vparam = new HashMap<String, Object>();
			vparam.put("strCostMode", strCostMode);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	 
			CombinedTransportationCaseTwoSOManageDBDAOsearch02CombinedTransportationCaseTwoSOManageRSQL template = new CombinedTransportationCaseTwoSOManageDBDAOsearch02CombinedTransportationCaseTwoSOManageRSQL();
			dRs = sqlExe.executeQuery(template, param, vparam);
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
	 * ServiceOfficeCodeSOManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search03ServiceOfficeCodeSOManage(EsdTrs0920Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		DBRowSet dRs = null;
		try{
			String sCtrl_ofc_cd = event.getCtrlOfcCd(); //COST MODE : CY, DOOR
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("sCtrl_ofc_cd", sCtrl_ofc_cd);
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	 
			CombinedTransportationCaseTwoSOManageDBDAOsearch03ServiceOfficeCodeSOManageRSQL template = new CombinedTransportationCaseTwoSOManageDBDAOsearch03ServiceOfficeCodeSOManageRSQL();
			dRs = sqlExe.executeQuery(template, param, null);
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
