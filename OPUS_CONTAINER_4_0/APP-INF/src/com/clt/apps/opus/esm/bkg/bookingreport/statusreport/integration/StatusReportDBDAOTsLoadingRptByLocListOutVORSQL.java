/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportDBDAOTsLoadingRptByLocListOutVORSQL.java
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

public class StatusReportDBDAOTsLoadingRptByLocListOutVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOTsLoadingRptByLocListOutVORSQL
	  * </pre>
	  */
	public StatusReportDBDAOTsLoadingRptByLocListOutVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOTsLoadingRptByLocListOutVORSQL").append("\n"); 
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
		query.append("/* Out VO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("'seq_no' seq_no" ).append("\n"); 
		query.append(", 'bkg_no' bkg_no" ).append("\n"); 
		query.append(", 'shipper_cd' shipper_cd" ).append("\n"); 
		query.append(", 'pol_cd' pol_cd" ).append("\n"); 
		query.append(", 'pod_cd' pod_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'in_vvd' in_vvd" ).append("\n"); 
		query.append(", 'out_vvd' out_vvd" ).append("\n"); 
		query.append(", 'feu' feu" ).append("\n"); 
		query.append(", 'teu' teu" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'order_by' order_by" ).append("\n"); 
		query.append(", 'order_by_title' order_by_title" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'bl_no' bl_no" ).append("\n"); 
		query.append(", 'shipper_nm' shipper_nm" ).append("\n"); 
		query.append(", 'in_lane' in_lane" ).append("\n"); 
		query.append(", 'out_lane' out_lane" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'in_tmnl' in_tmnl" ).append("\n"); 
		query.append(", 'out_tmnl' out_tmnl" ).append("\n"); 
		query.append(", 'in_zone' in_zone" ).append("\n"); 
		query.append(", 'out_zone' out_zone" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", 'total_40t' total_40t" ).append("\n"); 
		query.append(", 'total_20t' total_20t" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}