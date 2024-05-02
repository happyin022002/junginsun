/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOSearchMdmCntrTpSzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.09
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.11.09 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchMdmCntrTpSzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Select
	  * </pre>
	  */
	public BookingUtilDBDAOSearchMdmCntrTpSzRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchMdmCntrTpSzRSQL").append("\n"); 
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
		query.append("SELECT  CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        CNTR_SZ_CD," ).append("\n"); 
		query.append("        CNTR_TP_CD," ).append("\n"); 
		query.append("        CNTR_TPSZ_LODG_WGT," ).append("\n"); 
		query.append("        CNTR_TPSZ_LODG_CAPA," ).append("\n"); 
		query.append("        CNTR_TPSZ_TARE_WGT," ).append("\n"); 
		query.append("        CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("        CNTR_TPSZ_RMK," ).append("\n"); 
		query.append("        CNTR_TPSZ_PSA_CD," ).append("\n"); 
		query.append("        CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("        MODI_CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        DELT_FLG," ).append("\n"); 
		query.append("        EAI_EVNT_DT," ).append("\n"); 
		query.append("        CNTR_TPSZ_GRP_CD," ).append("\n"); 
		query.append("        RPT_DP_SEQ," ).append("\n"); 
		query.append("        ACIAC_DIV_CD" ).append("\n"); 
		query.append("  FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(" WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("ORDER BY CNTR_TPSZ_CD" ).append("\n"); 

	}
}