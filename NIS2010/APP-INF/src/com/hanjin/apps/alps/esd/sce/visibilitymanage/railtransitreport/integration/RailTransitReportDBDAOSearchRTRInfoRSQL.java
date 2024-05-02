/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RailTransitReportDBDAOSearchRTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReportDBDAOSearchRTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select dual
	  * </pre>
	  */
	public RailTransitReportDBDAOSearchRTRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReportDBDAOSearchRTRInfoRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	'' r_scno," ).append("\n"); 
		query.append("	'' r_bkg_no," ).append("\n"); 
		query.append("	'' to_dt," ).append("\n"); 
		query.append("	'' cgo_tp_cd," ).append("\n"); 
		query.append("	'' cust_cnt_seq," ).append("\n"); 
		query.append("	'' customer_loc," ).append("\n"); 
		query.append("	'' to_nod_cd," ).append("\n"); 
		query.append("	'' bkg_no," ).append("\n"); 
		query.append("	'' r_cntr_no," ).append("\n"); 
		query.append("	'' bl_no," ).append("\n"); 
		query.append("	'' r_vvd," ).append("\n"); 
		query.append("	'' bkg_ofc_cd," ).append("\n"); 
		query.append("	'' eq_no," ).append("\n"); 
		query.append("	'' r_bl_no," ).append("\n"); 
		query.append("	'' cstms_acpt_flg," ).append("\n"); 
		query.append("	'' pod_pol," ).append("\n"); 
		query.append("	'' trsp_bnd_cd," ).append("\n"); 
		query.append("	'' r_cust_cnt_cd," ).append("\n"); 
		query.append("	'' fm_nod_cd," ).append("\n"); 
		query.append("	'' r_origin," ).append("\n"); 
		query.append("	'' vvd," ).append("\n"); 
		query.append("	'' r_polpod," ).append("\n"); 
		query.append("	'' sc_no," ).append("\n"); 
		query.append("	'' r_dest," ).append("\n"); 
		query.append("	'' fm_dt," ).append("\n"); 
		query.append("	'' railcomp," ).append("\n"); 
		query.append("	'' r_cust_seq," ).append("\n"); 
		query.append("	'' date_kind," ).append("\n"); 
		query.append("    '' searchtype," ).append("\n"); 
		query.append("	'' dwell_kind," ).append("\n"); 
		query.append("	'' dwell_time," ).append("\n"); 
		query.append("	'' t_dep," ).append("\n"); 
		query.append("	'' type," ).append("\n"); 
		query.append("	'' cur_page," ).append("\n"); 
		query.append("    '' cntr_tpsz" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}