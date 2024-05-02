/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOSaelsPerformanceReportInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.21 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSaelsPerformanceReportInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOSaelsPerformanceReportInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSaelsPerformanceReportInVORSQL").append("\n"); 
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
		query.append("SELECT '' VVD" ).append("\n"); 
		query.append(",'' VVD_SIG" ).append("\n"); 
		query.append(",'' VSL_CD" ).append("\n"); 
		query.append(",'' SKD_VOY_NO" ).append("\n"); 
		query.append(",'' SKD_DIR_CD" ).append("\n"); 
		query.append(",'' SLAN_CD" ).append("\n"); 
		query.append(",'' VVD_IDX" ).append("\n"); 
		query.append(",'' BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",'' BKG_CUST_TP_CD" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",'' CUST_NM" ).append("\n"); 
		query.append(",'' CUNTRACT_TP" ).append("\n"); 
		query.append(",'' CUNTRACT_NO" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' POR_CD" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' REP_CMDT_CD" ).append("\n"); 
		query.append(",'' CMDT_CD" ).append("\n"); 
		query.append(",'' DCGO_FLG" ).append("\n"); 
		query.append(",'' RC_FLG" ).append("\n"); 
		query.append(",'' AWK_CGO_FLG" ).append("\n"); 
		query.append(",'' BB_CGO_FLG" ).append("\n"); 
		query.append(",'' RD_CGO_FLG" ).append("\n"); 
		query.append(",'' LOAD_VIEW" ).append("\n"); 
		query.append(",'' BL_TP_CD" ).append("\n"); 
		query.append(",'' BKG_OFC_CD" ).append("\n"); 
		query.append(",'' BKG_OFC_SUB" ).append("\n"); 
		query.append(",'' OB_SLS_OFC_CD" ).append("\n"); 
		query.append(",'' OB_SLS_OFC_SUB" ).append("\n"); 
		query.append(",'' OB_SREP_CD" ).append("\n"); 
		query.append(",'' CTRT_OFC_CD" ).append("\n"); 
		query.append(",'' CTRT_SREP_CD" ).append("\n"); 
		query.append(",'' IB_SLS_OFC_CD" ).append("\n"); 
		query.append(",'' IB_SLS_OFC_SUB" ).append("\n"); 
		query.append(",'' ORG_ROUT_CD" ).append("\n"); 
		query.append(",'' DEST_ROUT_CD" ).append("\n"); 
		query.append(",'' ORG_SVC_MOD_CD" ).append("\n"); 
		query.append(",'' DEST_INLND_SVC_MOD_CD" ).append("\n"); 
		query.append(",'' ORG_CNT" ).append("\n"); 
		query.append(",'' DEST_CNT" ).append("\n"); 
		query.append(",'' REP_KND" ).append("\n"); 
		query.append(",'' GRP_BY" ).append("\n"); 
		query.append(",'' GRP_COL" ).append("\n"); 
		query.append(",'' GRP_CON" ).append("\n"); 
		query.append(",'' FRT_TERM_CD" ).append("\n"); 
		query.append(",'' IOC_CD" ).append("\n"); 
		query.append(",'' R_OPTION" ).append("\n"); 
		query.append(",'' OP_FROM" ).append("\n"); 
		query.append(",'' OP_TO" ).append("\n"); 
		query.append(",'' CUST_CD" ).append("\n"); 
		query.append(",'' CUST_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}