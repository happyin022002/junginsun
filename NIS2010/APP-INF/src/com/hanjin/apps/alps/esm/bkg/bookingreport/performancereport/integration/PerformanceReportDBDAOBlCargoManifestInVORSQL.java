/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOBlCargoManifestInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.13 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOBlCargoManifestInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOBlCargoManifestInVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOBlCargoManifestInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOBlCargoManifestInVORSQL").append("\n"); 
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
		query.append("/* IN VO*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'mode_type' mode_type" ).append("\n"); 
		query.append(", 'vvd_cd' vvd_cd" ).append("\n"); 
		query.append(", 'pol_cd' pol_cd" ).append("\n"); 
		query.append(", 'pol_yd_cd' pol_yd_cd" ).append("\n"); 
		query.append(", 'pod_cd' pod_cd" ).append("\n"); 
		query.append(", 'pod_yd_cd' pod_yd_cd" ).append("\n"); 
		query.append(", 'cargo_type' cargo_type" ).append("\n"); 
		query.append(", 'cargo_route' cargo_route" ).append("\n"); 
		query.append(", 'br_por_cd' br_por_cd" ).append("\n"); 
		query.append(", 'br_pol_cd' br_pol_cd" ).append("\n"); 
		query.append(", 'br_pod_cd' br_pod_cd" ).append("\n"); 
		query.append(", 'br_del_cd' br_del_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'fdr_vvd_cd' fdr_vvd_cd" ).append("\n"); 
		query.append(", 'fdr_pol_cd' fdr_pol_cd" ).append("\n"); 
		query.append(", 'fdr_pol_yd_cd' fdr_pol_yd_cd" ).append("\n"); 
		query.append(", 'fdr_pod_cd' fdr_pod_cd" ).append("\n"); 
		query.append(", 'fdr_pod_yd_cd' fdr_pod_yd_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' order_by_title" ).append("\n"); 
		query.append(", '' order_by" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}