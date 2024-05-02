/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingUtilDBDAOmdmVslSvcLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.12.15 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOmdmVslSvcLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 특정 Location코드를 가지고 관할하는 SVC Lane 목록을 조회한다.
	  * </pre>
	  */
	public BookingUtilDBDAOmdmVslSvcLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOmdmVslSvcLaneRSQL").append("\n"); 
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
		query.append("SELECT 	vsl_slan_cd," ).append("\n"); 
		query.append("vsl_slan_nm," ).append("\n"); 
		query.append("vsl_svc_tp_cd," ).append("\n"); 
		query.append("vsl_tp_cd," ).append("\n"); 
		query.append("st_eff_dt," ).append("\n"); 
		query.append("end_eff_dt," ).append("\n"); 
		query.append("vsl_slan_skd_tp_cd," ).append("\n"); 
		query.append("ofc_cd," ).append("\n"); 
		query.append("co_cd," ).append("\n"); 
		query.append("fdr_div_cd," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt," ).append("\n"); 
		query.append("delt_flg," ).append("\n"); 
		query.append("eai_evnt_dt," ).append("\n"); 
		query.append("cnl_agn_vndr_seq," ).append("\n"); 
		query.append("vskd_flet_grp_cd," ).append("\n"); 
		query.append("spcl_cgo_rqst_tgt_lane_flg," ).append("\n"); 
		query.append("tml_prod_rpt_flg," ).append("\n"); 
		query.append("pndlm_flg" ).append("\n"); 
		query.append("FROM 	mdm_vsl_svc_lane" ).append("\n"); 
		query.append("WHERE 	1=1" ).append("\n"); 
		query.append("--AND		vsl_svc_tp_cd <> 'O'" ).append("\n"); 
		query.append("AND 	vsl_tp_cd = 'C'" ).append("\n"); 
		query.append("AND		delt_flg = 'N'" ).append("\n"); 
		query.append("AND 	co_cd = 'H'" ).append("\n"); 
		query.append("ORDER BY vsl_slan_cd" ).append("\n"); 

	}
}