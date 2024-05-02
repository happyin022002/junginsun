/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOVesselUtilizationStatusReportInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.11.16 강동윤
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

public class PerformanceReportDBDAOVesselUtilizationStatusReportInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PerformanceReportDBDAOVesselUtilizationStatusReportInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOVesselUtilizationStatusReportInVORSQL").append("\n"); 
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
		query.append("SELECT '' TRD_CD" ).append("\n"); 
		query.append(",'' SUB_TRD_CD" ).append("\n"); 
		query.append(",'' VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append(",'' SLAN_CD" ).append("\n"); 
		query.append(",'' VVD" ).append("\n"); 
		query.append(",'' ETD_FROM_DT" ).append("\n"); 
		query.append(",'' ETD_TO_DT" ).append("\n"); 
		query.append(",'' COST_YRMON" ).append("\n"); 
		query.append(",'' COST_YEAR" ).append("\n"); 
		query.append(",'' COST_MONTH" ).append("\n"); 
		query.append(",'' COST_WK" ).append("\n"); 
		query.append(",'' F_CMD" ).append("\n"); 
		query.append(",'' DT_TP" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}