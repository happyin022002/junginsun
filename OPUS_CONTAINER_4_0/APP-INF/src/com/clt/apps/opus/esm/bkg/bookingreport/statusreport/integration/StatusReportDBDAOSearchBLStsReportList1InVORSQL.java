/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStsReportList1InVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.12.28 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStsReportList1InVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStsReportList1InVORSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStsReportList1InVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStsReportList1InVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("/* 0647 BlStsReportInVO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' ROWS_PER_PAGE ," ).append("\n"); 
		query.append("'' CURR_PAGE ," ).append("\n"); 
		query.append("'' DURA_OPT," ).append("\n"); 
		query.append("'' DURA_FROM_DT," ).append("\n"); 
		query.append("'' DURA_TO_DT ," ).append("\n"); 
		query.append("'' BL_TYPE_ORI ," ).append("\n"); 
		query.append("'' BL_TYPE_WAY ," ).append("\n"); 
		query.append("'' VVD_CD ," ).append("\n"); 
		query.append("'' POL_CD ," ).append("\n"); 
		query.append("'' POD_CD ," ).append("\n"); 
		query.append("'' POR_CD ," ).append("\n"); 
		query.append("'' DEL_CD ," ).append("\n"); 
		query.append("'' DEL_OFC_CD," ).append("\n"); 
		query.append("'' DEL_OFC_CD," ).append("\n"); 
		query.append("'' OBL_OFC_CD ," ).append("\n"); 
		query.append("'' BKG_OFC_CD ," ).append("\n"); 
		query.append("'' SAL_OFC_CD ," ).append("\n"); 
		query.append("'' BL_OFC_CD ," ).append("\n"); 
		query.append("'' OBL_RCV_OFC_CD," ).append("\n"); 
		query.append("'' BY_CD," ).append("\n"); 
		query.append("'' STAFF_ID," ).append("\n"); 
		query.append("'' BKG_BL_CD ," ).append("\n"); 
		query.append("'' BKG_BL_NO," ).append("\n"); 
		query.append("'' cust_tp_cd," ).append("\n"); 
		query.append("'' cust_cnt_cd," ).append("\n"); 
		query.append("'' cust_seq," ).append("\n"); 
		query.append("'' cust_nm," ).append("\n"); 
		query.append("'' BL_STS_CD," ).append("\n"); 
		query.append("'' sc_rfa_no," ).append("\n"); 
		query.append("'' sc_rfa_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}