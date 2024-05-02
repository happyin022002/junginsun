/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanRouteManageDBDAOSaveOceanRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.21 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSaveOceanRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SaveOceanRoute
	  * </pre>
	  */
	public OceanRouteManageDBDAOSaveOceanRouteRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOSaveOceanRouteRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' ibflag" ).append("\n"); 
		query.append(",'' s_pol" ).append("\n"); 
		query.append(",'' s_lane" ).append("\n"); 
		query.append(",'' s_svc_type" ).append("\n"); 
		query.append(",'' s_ts1_port" ).append("\n"); 
		query.append(",'' s_ts1_lane" ).append("\n"); 
		query.append(",'' s_ts1_type" ).append("\n"); 
		query.append(",'' s_ts2_port" ).append("\n"); 
		query.append(",'' s_ts2_lane" ).append("\n"); 
		query.append(",'' s_ts2_type" ).append("\n"); 
		query.append(",'' s_pod" ).append("\n"); 
		query.append(",'' s_t_time" ).append("\n"); 
		query.append(",'' s_s_time" ).append("\n"); 
		query.append(",'' s_prior" ).append("\n"); 
		query.append(",'' s_f_u" ).append("\n"); 
		query.append(",'' s_route_flg" ).append("\n"); 
		query.append(",'' s_rout_seq" ).append("\n"); 
		query.append(",'' s_ts_ind" ).append("\n"); 
		query.append(",'' s_pf_ind" ).append("\n"); 
		query.append(",'' s_ts1_tztm" ).append("\n"); 
		query.append(",'' s_ts2_tztm" ).append("\n"); 
		query.append(",'' s_ts3_tztm" ).append("\n"); 
		query.append(",'' s_ts1_stay_tm" ).append("\n"); 
		query.append(",'' s_ts2_stay_tm" ).append("\n"); 
		query.append(",'' s_route_rmk" ).append("\n"); 
		query.append(",'' s_ts3_port" ).append("\n"); 
		query.append(",'' s_ts3_lane" ).append("\n"); 
		query.append(",'' s_ts3_type" ).append("\n"); 
		query.append(",'' s_prior" ).append("\n"); 
		query.append(",'' s_pol1" ).append("\n"); 
		query.append(",'' s_pod1" ).append("\n"); 
		query.append(",'' s_dir1" ).append("\n"); 
		query.append(",'' s_fdr_flg1" ).append("\n"); 
		query.append(",'' s_pol2" ).append("\n"); 
		query.append(",'' s_pod2" ).append("\n"); 
		query.append(",'' s_dir2" ).append("\n"); 
		query.append(",'' s_fdr_flg2" ).append("\n"); 
		query.append(",'' s_pol3" ).append("\n"); 
		query.append(",'' s_pod3" ).append("\n"); 
		query.append(",'' s_dir3" ).append("\n"); 
		query.append(",'' s_fdr_flg3" ).append("\n"); 
		query.append(",'' s_pol4" ).append("\n"); 
		query.append(",'' s_pod4" ).append("\n"); 
		query.append(",'' s_dir4" ).append("\n"); 
		query.append(",'' s_fdr_flg4" ).append("\n"); 
		query.append(",'' s_n1st_tztm_hrs" ).append("\n"); 
		query.append(",'' s_n2nd_tztm_hrs" ).append("\n"); 
		query.append(",'' s_n3rd_tztm_hrs" ).append("\n"); 
		query.append(",'' s_n4th_tztm_hrs" ).append("\n"); 
		query.append(",'' s_n1st_stay_tm_hrs" ).append("\n"); 
		query.append(",'' s_n2nd_stay_tm_hrs" ).append("\n"); 
		query.append(",'' s_n3rd_stay_tm_hrs" ).append("\n"); 
		query.append(",'' s_dup_allow" ).append("\n"); 
		query.append(",'' s_lnk_cnt" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' cre_ofc_cd" ).append("\n"); 
		query.append(",'' s_rmk" ).append("\n"); 
		query.append(",'' pf_ind_cd" ).append("\n"); 
		query.append(",'' ts_ind_cd" ).append("\n"); 
		query.append(",'' menu" ).append("\n"); 
		query.append(",'' max_seq" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}