/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOCaPerformanceReportInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.28 강동윤
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

public class PerformanceReportDBDAOCaPerformanceReportInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOCaPerformanceReportInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOCaPerformanceReportInVORSQL").append("\n"); 
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
		query.append("SELECT '' CHO_DT" ).append("\n"); 
		query.append(",'' CHO_FROM_DT" ).append("\n"); 
		query.append(",'' CHO_TO_DT" ).append("\n"); 
		query.append(",'' BKG_OFC_CD" ).append("\n"); 
		query.append(",'' BL_OBRD_FROM_DT" ).append("\n"); 
		query.append(",'' BL_OBRD_TO_DT" ).append("\n"); 
		query.append(",'' CORR_USR_ID" ).append("\n"); 
		query.append(",'' SLAN_CD" ).append("\n"); 
		query.append(",'' LAN_SKD_DIR_CD" ).append("\n"); 
		query.append(",'' VSL_CD" ).append("\n"); 
		query.append(",'' SKD_VOY_NO" ).append("\n"); 
		query.append(",'' SKD_DIR_CD" ).append("\n"); 
		query.append(",'' POR_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' DEL_CD" ).append("\n"); 
		query.append(",'' CA_RSN_CD" ).append("\n"); 
		query.append(",'' RAT_FLG" ).append("\n"); 
		query.append(",'' CA_KND" ).append("\n"); 
		query.append(",'' TAB_TP" ).append("\n"); 
		query.append(",'' CUST_TP" ).append("\n"); 
		query.append(",'' CUST_NM" ).append("\n"); 
		query.append(",'' REA_VAL" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}