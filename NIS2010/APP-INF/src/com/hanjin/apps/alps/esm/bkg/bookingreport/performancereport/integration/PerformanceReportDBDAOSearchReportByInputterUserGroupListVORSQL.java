/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchReportByInputterUserGroupListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.11
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.07.11 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchReportByInputterUserGroupListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchReportByInputterUserGroupListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchReportByInputterUserGroupListVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("      '' USER_ID" ).append("\n"); 
		query.append("      ,'' USER_NM" ).append("\n"); 
		query.append("      ,'' HIS_COUNT" ).append("\n"); 
		query.append("      ,'' BL_CNT" ).append("\n"); 
		query.append("      ,'' TOT_ORI_SI_CNT" ).append("\n"); 
		query.append("      ,'' AVG_ORI_TIME" ).append("\n"); 
		query.append("      ,'' TOT_ORI_POINT" ).append("\n"); 
		query.append("      ,'' TOT_ORI_EDI_SI_CNT" ).append("\n"); 
		query.append("      ,'' TOT_ORI_EDI_TIME" ).append("\n"); 
		query.append("      ,'' TOT_ORI_EMAIL_SI_CNT" ).append("\n"); 
		query.append("      ,'' TOT_ORI_EMAIL_TIME" ).append("\n"); 
		query.append("      ,'' TOT_ORI_FAX_SI_CNT" ).append("\n"); 
		query.append("      ,'' TOT_ORI_FAX_TIME" ).append("\n"); 
		query.append("      ,'' TOT_ORI_SEA_SI_CNT" ).append("\n"); 
		query.append("      ,'' TOT_ORI_SEA_TIME" ).append("\n"); 
		query.append("      ,'' TOT_AMEND_CNT" ).append("\n"); 
		query.append("      ,'' TOT_AMEND_TIME" ).append("\n"); 
		query.append("      ,'' TOT_AMEND_AVG_TIME" ).append("\n"); 
		query.append("      ,'' TOT_AMEND_POINT" ).append("\n"); 
		query.append("      ,'' TOT_RIDER_HBL_CNT" ).append("\n"); 
		query.append("      ,'' TOT_RIDER_HBL_TIME" ).append("\n"); 
		query.append("      ,'' TOT_RIDER_HBL_AVG_TIME" ).append("\n"); 
		query.append("      ,'' TOT_RIDER_HBL_POINT" ).append("\n"); 
		query.append("      ,'' TOT_ORDER_CNT" ).append("\n"); 
		query.append("      ,'' TOT_ORDER_TIME" ).append("\n"); 
		query.append("      ,'' TOT_ORDER_AVG_TIME" ).append("\n"); 
		query.append("      ,'' TOT_HBL_MAIL_FAX_CNT" ).append("\n"); 
		query.append("      ,'' TOT_CM_CNT" ).append("\n"); 
		query.append("      ,'' TOT_CNTR_CNT" ).append("\n"); 
		query.append("      ,'' TOT_CSTMS_MF_TP_CD_CNT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}