/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDPCSVolListInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.15 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDPCSVolListInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchDPCSVolListInVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDPCSVolListInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDPCSVolListInVORSQL").append("\n"); 
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
		query.append("' ' from_dt" ).append("\n"); 
		query.append(", ' ' to_dt" ).append("\n"); 
		query.append(", ' ' from_mt" ).append("\n"); 
		query.append(", ' ' to_mt" ).append("\n"); 
		query.append(", ' ' vvd_cd" ).append("\n"); 
		query.append(", ' ' pol_cd" ).append("\n"); 
		query.append(", ' ' pod_cd" ).append("\n"); 
		query.append(", ' ' pfm_by_queue_cd" ).append("\n"); 
		query.append(", ' ' sr_knd_cd" ).append("\n"); 
		query.append(", ' ' pic_cd" ).append("\n"); 
		query.append(", ' ' bkg_no" ).append("\n"); 
		query.append(", ' ' usr_id" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}