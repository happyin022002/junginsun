/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : donotificationreportDBDAO.java
*@FileTitle : D/O notification Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-06-03
*@LastModifier : 
*@LastVersion : 1.0
* 2016-06-03
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.event.EsdTrs0291Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.vo.DoNotificationReportVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SHIN DONG IL
 * @see donotificationreportBCImpl 참조
 * @since J2EE 1.6
 */
public class DoNotificationReportDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * D/O Notification Report List 조회
	 * @param event
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchDoNotificationReportList(EsdTrs0291Event event) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("f_sent_fm_dt", event.getF_sent_fm_dt().replaceAll("-",""));
			param.put("f_sent_to_dt", event.getF_sent_to_dt().replaceAll("-",""));
			param.put("f_fm_node", event.getF_fm_node());
			param.put("f_to_node", event.getF_to_node());
			param.put("f_latest", event.getF_latest());
			param.put("f_door", event.getF_door());
			
			List<Object> arr_ofcCd = null;
			arr_ofcCd = this.seperationParameter(event.getF_ctrl_ofc_cd(), ","); 
			param.put("f_ctrl_ofc_cd", arr_ofcCd);
			
			List<Object> arr_trnkVvd = null;
			arr_trnkVvd = this.seperationParameter(event.getF_trnk_vvd(), ",");
			param.put("f_trnk_vvd", arr_trnkVvd);
			
			List<Object> arr_bkgNo = null;
			arr_bkgNo = this.seperationParameter(event.getF_bkg_no(), ",");
			param.put("f_bkg_no", arr_bkgNo);
			
			List<Object> arr_cntrNo = null;
			arr_cntrNo = this.seperationParameter(event.getF_cntr_no(), ",");			
			param.put("f_cntr_no", arr_cntrNo);
			
			List<Object> arr_scNo = null;
			arr_scNo = this.seperationParameter(event.getF_sc_no(), ",");
			param.put("f_sc_no", arr_scNo);
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new DoNotificationReportDBDAOSearchDoNotificationReportListRSQL(), param, param);
			
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
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param String sparameter
	 * @param String sSeperate
	 * @return ArrayList<String>
	 * @throws 
	 */
	public ArrayList<Object> seperationParameter(String sparameter, String sSeperate) {
		ArrayList<Object>	arrlist	= null;
		StringTokenizer		st		= null;
		int						j		= 0;
		
		if ( !"".equals(sparameter) ) {
			arrlist = new ArrayList<Object>();
			st = new StringTokenizer(sparameter, sSeperate);
			while ( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
	
}