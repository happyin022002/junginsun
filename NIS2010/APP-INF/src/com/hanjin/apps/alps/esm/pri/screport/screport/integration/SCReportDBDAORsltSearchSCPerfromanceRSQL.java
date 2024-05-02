/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCReportDBDAORsltSearchSCPerfromanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.11.11 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author day-hoh Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCReportDBDAORsltSearchSCPerfromanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sc performance search VO
	  * </pre>
	  */
	public SCReportDBDAORsltSearchSCPerfromanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.screport.screport.integration").append("\n"); 
		query.append("FileName : SCReportDBDAORsltSearchSCPerfromanceRSQL").append("\n"); 
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
		query.append("" ).append("\n"); 
		query.append("NULL AS BL_OBRD_DT_FROM" ).append("\n"); 
		query.append(",NULL AS BL_OBRD_DT_TO" ).append("\n"); 
		query.append(",NULL AS BL_OBRD_DT_FROM" ).append("\n"); 
		query.append(",NULL AS BL_OBRD_DT_TO" ).append("\n"); 
		query.append(",NULL AS BY_SCOPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS CNT" ).append("\n"); 
		query.append(",NULL AS CTRT_CUST_SLS_OFC_CD" ).append("\n"); 
		query.append(",NULL AS CTRT_CUST_SREP_CD" ).append("\n"); 
		query.append(",NULL AS CTRT_PTY_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS CTRT_EFF_DT" ).append("\n"); 
		query.append(",NULL AS CTRT_EXP_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS EFF_DT" ).append("\n"); 
		query.append(",NULL AS EXP_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS FNL_MQC_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS GAMT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS KEY_ACCT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS MQC_PERF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS OP_CNTR_QTY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS PRC_CTRT_CUST_TP_CD" ).append("\n"); 
		query.append(",NULL AS PRO_RT_MQC_PERF" ).append("\n"); 
		query.append(",NULL AS PROP_APRO_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS RHQ" ).append("\n"); 
		query.append(",NULL AS RHQ_CD" ).append("\n"); 
		query.append(",NULL AS RF_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS RF_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",NULL AS SC_NO" ).append("\n"); 
		query.append(",NULL AS SVC_SCP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}