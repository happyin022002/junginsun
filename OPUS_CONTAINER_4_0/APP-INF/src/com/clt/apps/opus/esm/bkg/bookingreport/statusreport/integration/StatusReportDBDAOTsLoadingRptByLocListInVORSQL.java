/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportDBDAOTsLoadingRptByLocListInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.10.07 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOTsLoadingRptByLocListInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOTsLoadingRptByLocListInVORSQL
	  * </pre>
	  */
	public StatusReportDBDAOTsLoadingRptByLocListInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOTsLoadingRptByLocListInVORSQL").append("\n"); 
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
		query.append("'location_cd' location_cd" ).append("\n"); 
		query.append(", 'location_yd_cd' location_yd_cd" ).append("\n"); 
		query.append(", 'dura_from_dt' dura_from_dt" ).append("\n"); 
		query.append(", 'dura_to_dt' dura_to_dt" ).append("\n"); 
		query.append(", 'bl_type_ob' bl_type_ob" ).append("\n"); 
		query.append(", 'bl_type_ts' bl_type_ts" ).append("\n"); 
		query.append(", 'trade_zone' trade_zone" ).append("\n"); 
		query.append(", 'pol_cd' pol_cd" ).append("\n"); 
		query.append(", 'pod_cd' pod_cd" ).append("\n"); 
		query.append(", 'out_lane' out_lane" ).append("\n"); 
		query.append(", 'out_tmnl' out_tmnl" ).append("\n"); 
		query.append(", 'shipper_cd' shipper_cd" ).append("\n"); 
		query.append(", 'order_by' order_by" ).append("\n"); 
		query.append(", 'order_by_title' order_by_title" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}