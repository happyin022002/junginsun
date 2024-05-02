/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PreDispatchStatusDBDAO.java
*@FileTitle : Pre-Dispatch Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-19
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-12-19 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.event.EsdTrs0020Event;
import com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.vo.SearchPreDispatchStatusVO;

/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kim_sang_geun
 * @see PreDispatchStatusBCImpl 참조
 * @since J2EE 1.4
 */
public class PreDispatchStatusDBDAO extends DBDAOSupport {

	/**
	 * PreDispatchStatus의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPreDispatchStatus(EsdTrs0020Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		ArrayList arr_wo_no   = new ArrayList();
		ArrayList arr_bkg_no  = new ArrayList();
		ArrayList arr_bill_no = new ArrayList();
		ArrayList arr_cntr_no = new ArrayList();
		
		
		try{
			SearchPreDispatchStatusVO model = event.getSearchPreDispatchStatusVo();
			
			if( model != null ){
				
				Map<String, String> condiParams = model.getColumnValues();
				
				if(model.getWoNo()   != null) arr_wo_no   = this.seperationParameter(condiParams.get("wo_no")  , ",");
				if(model.getBkgNo()  != null) arr_bkg_no  = this.seperationParameter(condiParams.get("bkg_no") , ",");
				if(model.getBillNo() != null) arr_bill_no = this.seperationParameter(condiParams.get("bill_no"), ",");
				if(model.getCntrNo() != null) arr_cntr_no = this.seperationParameter(condiParams.get("cntr_no"), ",");
				
				param.put("rad_wonotic"       , condiParams.get("rad_wonotic"));
				param.put("hid_frmdate"       , condiParams.get("hid_frmdate"));
				param.put("hid_todate"        , condiParams.get("hid_todate"));
				param.put("ctrl_ofc_cd"       , condiParams.get("ctrl_ofc_cd"));
				param.put("reference_no"      , condiParams.get("reference_no"));
				param.put("wo_iss_ofc_cd"     , condiParams.get("wo_iss_ofc_cd"));
				param.put("combo_svc_provider", condiParams.get("combo_svc_provider"));
				param.put("arr_wo_no"         , arr_wo_no);
				param.put("arr_bkg_no"        , arr_bkg_no);
				param.put("arr_bill_no"       , arr_bill_no);
				param.put("arr_cntr_no"       , arr_cntr_no);
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new PreDispatchStatusDBDAOSearchPreDispatchStatusRSQL(), param, param);
			
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
		
		return dbRowset;
	}

	/**
	 * PreDispatchStatus의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search01PreDispatchStatus(EsdTrs0020Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			SearchPreDispatchStatusVO model = event.getSearchPreDispatchStatusVo();
			
			if( model != null ){
				
				Map<String, String> condiParams = model.getColumnValues();
				
				param.put("trsp_so_ofc_cty_cd" , condiParams.get("trsp_so_ofc_cty_cd"));
				param.put("trsp_so_seq"        , condiParams.get("trsp_so_seq")       );
				param.put("trsp_wo_seq"        , condiParams.get("trsp_wo_seq")       );
				param.put("trsp_wo_ofc_cty_cd" , condiParams.get("trsp_wo_ofc_cty_cd"));
				
			}
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new PreDispatchStatusDBDAOSearch01PreDispatchStatusRSQL(), param, param);
			
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
		
		return dbRowset;
	}

	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
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