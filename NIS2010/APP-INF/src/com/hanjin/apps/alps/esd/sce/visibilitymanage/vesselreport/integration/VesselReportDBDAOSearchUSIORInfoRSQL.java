/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselReportDBDAOSearchUSIORInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOSearchUSIORInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select info
	  * </pre>
	  */
	public VesselReportDBDAOSearchUSIORInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchUSIORInfoRSQL").append("\n"); 
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
		query.append("SELECT '' AS t_pup_sts" ).append("\n"); 
		query.append(", '' AS t_truck_sts" ).append("\n"); 
		query.append(", '' AS t_p_no" ).append("\n"); 
		query.append(", '' AS fm_dt" ).append("\n"); 
		query.append(", '' AS s_lane" ).append("\n"); 
		query.append(", '' AS t_rail_billing_sts" ).append("\n"); 
		query.append(", '' AS s_neweq_office" ).append("\n"); 
		query.append(", '' AS eqmt_ofc" ).append("\n"); 
		query.append(", '' AS s_vvd" ).append("\n"); 
		query.append(", '' AS s_rail_dest" ).append("\n"); 
		query.append(", '' AS edi_status" ).append("\n"); 
		query.append(", '' AS t_cost_mode" ).append("\n"); 
		query.append(", '' AS to_dt" ).append("\n"); 
		query.append(", '' AS ofc_cd" ).append("\n"); 
		query.append(", '' AS s_del" ).append("\n"); 
		query.append(", '' AS cost_div" ).append("\n"); 
		query.append(", '' AS dateselect" ).append("\n"); 
		query.append(", '' AS s_pup_office" ).append("\n"); 
		query.append(", '' AS s_pol_pod" ).append("\n"); 
		query.append(", '' AS vndr_seq" ).append("\n"); 
		query.append(", '' AS s_sc_no" ).append("\n"); 
		query.append(", '' AS s_eq_office" ).append("\n"); 
		query.append(", '' AS t_end_sts" ).append("\n"); 
		query.append(", '' AS s_c_loc" ).append("\n"); 
		query.append(", '' AS port_cd" ).append("\n"); 
		query.append(", '' AS s_bkg_no" ).append("\n"); 
		query.append(", '' AS s_cntr_no" ).append("\n"); 
		query.append(", '' AS mst_bkg_sts" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}