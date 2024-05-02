/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ActualCustomerPopupDBDAO.java
*@FileTitle : Actual Customer Popup 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-09
*@LastModifier : eunhee
*@LastVersion : 1.0
* 2009-09-09 eunhee
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.actualcustomerpopup.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.actualcustomerpopup.basic.ActualCustomerPopupBCImpl;
import com.clt.apps.opus.esd.trs.common.actualcustomerpopup.event.EsdTrs0914Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ESD-ActualCustomerPopup에 대한 DB 처리를 담당<br>
 * - ESD-ActualCustomerPopup Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author poong_yeon
 * @see ActualCustomerPopupBCImpl 참조
 * @since J2EE 1.4
 */
public class ActualCustomerPopupDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ActualCustomerPopup의 모든 목록을 가져온다.<br>
	 *
	 * @param event EsdTrs0914Event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchActualCustomerList(EsdTrs0914Event event) throws DAOException {
		DBRowSet dRs = null;
		try{
			String sDorNodCd  = event.getDor_nod_cd();//Door Node
			String sDorLocCd  = sDorNodCd != null && sDorNodCd.length() >= 5 ? sDorNodCd.substring(0,5) : "";
			String act_cust_cd  = event.getAct_cust_cd(); //Customer Code
			String factory_nm = event.getFctry_nm();//Factory Name
			String sBoundCd = event.getBound_cd(); //BND -Main화면에서 넘겨 받음.
			String sContiCd= event.getConti_cd(); //fm_loc_conti_cd -Main화면에서 넘겨 받음.
			String	sCustInfoIndicator	= "A".equals(sContiCd) || "M".equals(sContiCd) ? "XEUR" : "EUR";
			sCustInfoIndicator			= "XEUR";
			
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("sDorLocCd", sDorLocCd);
			param.put("act_cust_cd", act_cust_cd);
			param.put("factory_nm", factory_nm);
			param.put("sBoundCd", sBoundCd);
			param.put("sCustInfoIndicator", sCustInfoIndicator);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			ActualCustomerPopupDBDAOSearchActualCustomerListRSQL template = new ActualCustomerPopupDBDAOSearchActualCustomerListRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}
	

	/**
	 * ActualCustomerPopup의 모든 목록을 가져온다.<br>
	 * @param event EsdTrs0914Event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchActualCustomer(EsdTrs0914Event event) throws DAOException {
		DBRowSet dRs = null;
		try{
			String acCustCd =event.getAct_cust_cnt_cd();
			String acCustSeq =event.getAct_cust_seq();
			String sUSACustNo =event.getUsa_trsp_act_cust_no();
			String sContiCd= event.getConti_cd(); //fm_loc_conti_cd -Main화면에서 넘겨 받음.
			String	sCustInfoIndicator	= "A".equals(sContiCd) || "M".equals(sContiCd) ? "XEUR" : "EUR";
			sCustInfoIndicator			= "XEUR";
			/** 2007-11-23 CONTI_CD 분기	***********-*************************
			 * ************************************-*************************
			 * 	'E'+'F'	: MDM_CUSTOMER			+ TRS_TRSP_ACT_CUST_ADDR
			 *  'A'+'M'	: TRS_TRSP_USA_ACT_CUST + TRS_TRSP_USA_ACT_CUST_DTL
			 * ************************************-*************************/
			
			//parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("acCustCd", acCustCd);
			param.put("acCustSeq", acCustSeq);
			param.put("sUSACustNo", sUSACustNo);
			param.put("sCustInfoIndicator", sCustInfoIndicator);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			ActualCustomerPopupDBDAOSearchActualCustomerRSQL template = new ActualCustomerPopupDBDAOSearchActualCustomerRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dRs;
	}
}



