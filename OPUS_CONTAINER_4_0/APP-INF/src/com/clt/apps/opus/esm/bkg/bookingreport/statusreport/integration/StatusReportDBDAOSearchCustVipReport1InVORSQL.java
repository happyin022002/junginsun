/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportDBDAOSearchCustVipReport1InVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchCustVipReport1InVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchCustVipReport1InVORSQL
	  * 2010.09.10 김영철 [ ] VIP REPORT 부분 오류 수정 ( 반영일 : 2010.09.24 )
	  * </pre>
	  */
	public StatusReportDBDAOSearchCustVipReport1InVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchCustVipReport1InVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' p_bkg_rpt_knd_cd ," ).append("\n"); 
		query.append("'' rows_per_page ," ).append("\n"); 
		query.append("'' curr_page ," ).append("\n"); 
		query.append("'' IN_OUT_CD ," ).append("\n"); 
		query.append("'' VPS_ETA_DT ," ).append("\n"); 
		query.append("'' VPS_ETD_DT ," ).append("\n"); 
		query.append("'' VVD_CD ," ).append("\n"); 
		query.append("'' POR_CD ," ).append("\n"); 
		query.append("'' POL_CD ," ).append("\n"); 
		query.append("'' POL_YARD_CD ," ).append("\n"); 
		query.append("'' POD_CD ," ).append("\n"); 
		query.append("'' POD_YARD_CD ," ).append("\n"); 
		query.append("'' DEL_CD ," ).append("\n"); 
		query.append("'' EQ_OFC_CD ," ).append("\n"); 
		query.append("'' SC_NO ," ).append("\n"); 
		query.append("'' CUST_TP_CD ," ).append("\n"); 
		query.append("'' CUST_CNT_CD ," ).append("\n"); 
		query.append("'' CUST_SEQ ," ).append("\n"); 
		query.append("'' CUST_NM ," ).append("\n"); 
		query.append("'' EDI_ID ," ).append("\n"); 
		query.append("'' EDI_GR_CD ," ).append("\n"); 
		query.append("'' GDI_GR_NM ," ).append("\n"); 
		query.append("'' GCUST ," ).append("\n"); 
		query.append("'' CREDIT," ).append("\n"); 
		query.append("'' SP_CARGO_RF," ).append("\n"); 
		query.append("'' SP_CARGO_DG," ).append("\n"); 
		query.append("'' SP_CARGO_AK," ).append("\n"); 
		query.append("'' SP_CARGO_BB," ).append("\n"); 
		query.append("'' SELECT_LIST" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}