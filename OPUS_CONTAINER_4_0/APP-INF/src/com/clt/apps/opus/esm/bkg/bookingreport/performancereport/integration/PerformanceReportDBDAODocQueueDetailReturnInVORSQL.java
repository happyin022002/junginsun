/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAODocQueueDetailReturnInVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.03.05 김경섭
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

public class PerformanceReportDBDAODocQueueDetailReturnInVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAODocQueueDetailReturnInVORSQL
	  * </pre>
	  */
	public PerformanceReportDBDAODocQueueDetailReturnInVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAODocQueueDetailReturnInVORSQL").append("\n"); 
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
		query.append("/* DocQueueDetailReturnIn VO */" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("'' src_cd" ).append("\n"); 
		query.append(", '' sr_no" ).append("\n"); 
		query.append(", '' bkg_no" ).append("\n"); 
		query.append(", '' sr_knd_cd" ).append("\n"); 
		query.append(", '' grp_cd" ).append("\n"); 
		query.append(", '' usr_id" ).append("\n"); 
		query.append(", '' ui_grp_cd" ).append("\n"); 
		query.append(", '' message" ).append("\n"); 
		query.append(", '' rsn_bkg_mn_flg" ).append("\n"); 
		query.append(", '' rsn_cust_info_flg" ).append("\n"); 
		query.append(", '' rsn_frt_chg_flg" ).append("\n"); 
		query.append(", '' rsn_cntr_flg" ).append("\n"); 
		query.append(", '' rsn_cntr_mf_flg" ).append("\n"); 
		query.append(", '' rsn_dcgo_flg" ).append("\n"); 
		query.append(", '' rsn_awk_cgo_flg" ).append("\n"); 
		query.append(", '' rsn_rc_flg" ).append("\n"); 
		query.append(", '' rsn_bb_cgo_flg" ).append("\n"); 
		query.append(", '' rsn_rly_port_flg" ).append("\n"); 
		query.append(", '' rsn_new_bkg_flg" ).append("\n"); 
		query.append(", '' rsn_split_flg" ).append("\n"); 
		query.append(", '' rsn_bl_info_flg" ).append("\n"); 
		query.append(", '' rsn_hbl_flg" ).append("\n"); 
		query.append(", '' cust_verif_flg" ).append("\n"); 
		query.append(", '' sr_his_seq" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}