/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpperformancEvaluationDBDAO.java
*@FileTitle : S/P Performance Evaluation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.09
*@LastModifier : 최 선
*@LastVersion : 1.1
* 2006.11.27 juhyun
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.11.09 최 선     1.1 [CHM-201006928] Performance Evaluation Save 후, 불필요한 재조회 프로세스 제외 처리
=========================================================*/
package com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.basic.SpperformancEvaluationBCImpl;
import com.hanjin.apps.alps.esd.trs.soinquiry.spperformancevaluation.event.EsdTrs0039Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspVndrPerfEvVO;


/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author juhyun
 * @see SpperformancEvaluationBCImpl 참조
 * @since J2EE 1.4
 */
public class SpperformancEvaluationDBDAO extends DBDAOSupport {

	/**
	 * SpperformancEvaluation의 모든 목록을 가져온다.<br>
	 * @param event EsdTrs0039Event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchSpperformancEvaluationList(EsdTrs0039Event event) throws DAOException {
		// DB ResultSet
		DBRowSet dRs = null;
		try {
			String r_period = event.getHidPeriod();   			//Issued       Executed       Evaluated
			String r_from_date = event.getHidFromDate();			//hid_from_date
			String r_to_date = event.getHidToDate();				//hid_to_date
			String r_provider = event.getHidProvider();				//provider 
			String r_wonumber = event.getWonumber();
			
			Map<String, Object> param = new HashMap<String, Object>();			
			param.put("hid_from_date",r_from_date);
			param.put("hid_to_date",r_to_date);
			param.put("hid_provider",r_provider);
			
			Map<String, Object> velParam = new HashMap<String, Object>();			
			List<String> tempWoNo = new ArrayList();
			tempWoNo  = this.seperationParameter(r_wonumber, ","); 
			
			velParam.put("tempWoNo", tempWoNo);
			velParam.put("r_period",r_period);	
			velParam.put("r_from_date",r_from_date);
			velParam.put("r_to_date",r_to_date);
			velParam.put("r_provider",r_provider);
			velParam.put("r_wonumber",r_wonumber);		

            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            SpperformancEvaluationDBDAOsearchSpperformancEvaluationListRSQL template = new SpperformancEvaluationDBDAOsearchSpperformancEvaluationListRSQL();
            dRs = sqlExe.executeQuery(template, param, velParam);			
			
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
	 * SpperformancEvaluation의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiTrsTrspVndrPerfEv(EsdTrs0039Event event) throws DAOException {
		try{		
			SQLExecuter sqlExe = new SQLExecuter("");
			TrsTrspVndrPerfEvVO[] model = event.getTrsTrspVndrPerfEvVOs();
			
			Map<String,Object> param = new HashMap<String,Object>();
			Collection<TrsTrspVndrPerfEvVO> insertVoList = new ArrayList<TrsTrspVndrPerfEvVO>();
			Collection<TrsTrspVndrPerfEvVO> updateVoList = new ArrayList<TrsTrspVndrPerfEvVO>();
			
			param.put("HID_CRE_DT", event.getHidCreDt());
			param.put("HID_CRE_USR_ID", event.getHidCreUsrId());
			param.put("HID_CRE_OFC_CD", event.getHidCreOfcCd());
			
			DBRowSet dbRowset = null;
			String evaFlg = null;
			
			for ( int i=0; i<model.length; i++ ) {
				param.put("trsp_wo_ofc_cty_cd", model[i].getTrspWoOfcCtyCd());
				param.put("trsp_wo_seq", model[i].getTrspWoSeq());
				
				dbRowset = new SQLExecuter("").executeQuery(new SpperformancEvaluationDBDAOSearchSpperformancEvaluationCheckRSQL(), param, null);
				if (dbRowset.next()) {
					evaFlg = dbRowset.getString("EVA_FLG");
				} else {
					evaFlg = "";
				}

				if (evaFlg.equals("N")) {
					insertVoList.add(model[i]);
				} else if (evaFlg.equals("Y")) {
					updateVoList.add(model[i]);
				}
				
			}	
			
			//1.Insert
			if(insertVoList.size() > 0){
				sqlExe.executeBatch((ISQLTemplate)new SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeCSQL(), insertVoList, null, param);
				sqlExe.executeBatch((ISQLTemplate)new SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvSoUSQL(), insertVoList, null, param);
				sqlExe.executeBatch((ISQLTemplate)new SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvRboUSQL(), insertVoList, null, param);
			}
			
			//2.Update
			if(updateVoList.size() > 0){
				sqlExe.executeBatch((ISQLTemplate)new SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvVpeUSQL(), updateVoList, null, param);
				sqlExe.executeBatch((ISQLTemplate)new SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvSoUSQL(), updateVoList, null, param);
				sqlExe.executeBatch((ISQLTemplate)new SpperformancEvaluationDBDAOmultiTrsTrspVndrPerfEvRboUSQL(), updateVoList, null, param);			
			}		

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		} 
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * @param sparameter
	 * @param sSeperate
	 * @return
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}	
}
