/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportDBDAOSearchBLStatusListSummaryOutVO1RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.02.23 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchBLStatusListSummaryOutVO1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchBLStatusListSummaryOutVO1RSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchBLStatusListSummaryOutVO1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchBLStatusListSummaryOutVO1RSQL").append("\n"); 
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
		query.append("/* StatusReportSummaryOutVO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("' ' AS ORDERBY_TITLE" ).append("\n"); 
		query.append(", ' ' AS SUB_F_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS SUB_F_TEU" ).append("\n"); 
		query.append(", ' ' AS SUB_P_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS SUB_P_TEU" ).append("\n"); 
		query.append(", ' ' AS SUB_R_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS SUB_R_TEU" ).append("\n"); 
		query.append(", ' ' AS SUB_T_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS SUB_T_TEU" ).append("\n"); 
		query.append(", ' ' AS SUB_BKG_CNT" ).append("\n"); 
		query.append(", ' ' AS GRD_F_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS GRD_F_TEU" ).append("\n"); 
		query.append(", ' ' AS GRD_P_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS GRD_P_TEU" ).append("\n"); 
		query.append(", ' ' AS GRD_R_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS GRD_R_TEU" ).append("\n"); 
		query.append(", ' ' AS GRD_T_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS GRD_T_TEU" ).append("\n"); 
		query.append(", ' ' AS GRD_BKG_CNT" ).append("\n"); 
		query.append(", ' ' AS POL_CD" ).append("\n"); 
		query.append(", ' ' AS TP_SZ" ).append("\n"); 
		query.append(", ' ' AS F_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS F_TEU" ).append("\n"); 
		query.append(", ' ' AS P_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS P_TEU" ).append("\n"); 
		query.append(", ' ' AS R_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS R_TEU" ).append("\n"); 
		query.append(", ' ' AS T_BKG_QTY" ).append("\n"); 
		query.append(", ' ' AS T_TEU" ).append("\n"); 
		query.append(", ' ' AS BKG_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}