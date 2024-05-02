/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : aaaaDAOSearchTsPlanGuideListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class aaaaDAOSearchTsPlanGuideListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTsPlanGuideList
	  * </pre>
	  */
	public aaaaDAOSearchTsPlanGuideListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo").append("\n"); 
		query.append("FileName : aaaaDAOSearchTsPlanGuideListRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' as pln_seq" ).append("\n"); 
		query.append(",'' as rep_trd_cd                                     		" ).append("\n"); 
		query.append(",'' as rep_sub_trd_cd                                     		" ).append("\n"); 
		query.append(",'' as rlane_cd                                     		" ).append("\n"); 
		query.append(",'' as vvd_cd                                     		" ).append("\n"); 
		query.append(",'' as irr_port_cd                                     		" ).append("\n"); 
		query.append(",'' as irr_yd_cd" ).append("\n"); 
		query.append(",'' as dir_cd                                     	" ).append("\n"); 
		query.append(",'' as ioc_cd                                     		" ).append("\n"); 
		query.append(",'' as cntr_full_flg                   		" ).append("\n"); 
		query.append(",'' as cntr_mty_flg                                     		" ).append("\n"); 
		query.append(",'' as crr_cd                                     		" ).append("\n"); 
		query.append(",'' as pol_cd                                     		" ).append("\n"); 
		query.append(",'' as n1st_port_etd_dt                                     		" ).append("\n"); 
		query.append(",'' as n1st_rlane_cd                                            	" ).append("\n"); 
		query.append(",'' as n1st_vsl_cd                                         		" ).append("\n"); 
		query.append(",'' as n1st_skd_voy_no                                        		" ).append("\n"); 
		query.append(",'' as n1st_skd_dir_cd                                        		" ).append("\n"); 
		query.append(",'' as n1st_port_etb_dt                                          	" ).append("\n"); 
		query.append(",'' as n1st_pod_cd                                            		" ).append("\n"); 
		query.append(",'' as n1st_pod_yd_cd                                            	" ).append("\n"); 
		query.append(",'' as n2nd_pol_cd                                            		" ).append("\n"); 
		query.append(",'' as n2nd_pol_yd_cd                                           	" ).append("\n"); 
		query.append(",'' as n2nd_port_etd_dt                                    		" ).append("\n"); 
		query.append(",'' as n2nd_rlane_cd                                          		" ).append("\n"); 
		query.append(",'' as n2nd_vsl_cd                                            		" ).append("\n"); 
		query.append(",'' as n2nd_skd_voy_no                                           	" ).append("\n"); 
		query.append(",'' as n2nd_skd_dir_cd                                        		" ).append("\n"); 
		query.append(",'' as n2nd_port_etb_dt                                          	" ).append("\n"); 
		query.append(",'' as n2nd_pod_cd                                            		" ).append("\n"); 
		query.append(",'' as n2nd_pod_yd_cd                                           	" ).append("\n"); 
		query.append(",'' as n3rd_pol_cd                                         		" ).append("\n"); 
		query.append(",'' as n3rd_pol_yd_cd                                         		" ).append("\n"); 
		query.append(",'' as n3rd_port_etd_dt                                       		" ).append("\n"); 
		query.append(",'' as n3rd_rlane_cd                                             	" ).append("\n"); 
		query.append(",'' as n3rd_vsl_cd                                            		" ).append("\n"); 
		query.append(",'' as n3rd_skd_voy_no                                           	" ).append("\n"); 
		query.append(",'' as n3rd_skd_dir_cd                                        		" ).append("\n"); 
		query.append(",'' as n3rd_port_etb_dt                                         	" ).append("\n"); 
		query.append(",'' as n3rd_pod_cd                                         		" ).append("\n"); 
		query.append(",'' as n3rd_pod_yd_cd                                         		" ).append("\n"); 
		query.append(",'' as n4th_pol_cd                                            		" ).append("\n"); 
		query.append(",'' as n4th_pol_yd_cd                                            	" ).append("\n"); 
		query.append(",'' as n4th_port_etd_dt                                       		" ).append("\n"); 
		query.append(",'' as n4th_rlane_cd                                             	" ).append("\n"); 
		query.append(",'' as n4th_vsl_cd                                        		" ).append("\n"); 
		query.append(",'' as n4th_skd_voy_no                                          	" ).append("\n"); 
		query.append(",'' as n4th_skd_dir_cd                                 		" ).append("\n"); 
		query.append(",'' as n4th_port_etb_dt     " ).append("\n"); 
		query.append(",'' as n4th_pod_cd                                        		" ).append("\n"); 
		query.append(",'' as n4th_pod_yd_cd                                         		" ).append("\n"); 
		query.append(",'' as n5th_pol_cd                                        		" ).append("\n"); 
		query.append(",'' as n5th_pol_yd_cd       " ).append("\n"); 
		query.append(",'' as n5th_port_etd_dt     " ).append("\n"); 
		query.append(",'' as n5th_rlane_cd        " ).append("\n"); 
		query.append(",'' as n5th_vsl_cd          " ).append("\n"); 
		query.append(",'' as n5th_skd_voy_no      " ).append("\n"); 
		query.append(",'' as n5th_skd_dir_cd      " ).append("\n"); 
		query.append(",'' as n5th_port_etb_dt     " ).append("\n"); 
		query.append(",'' as pod_cd               " ).append("\n"); 
		query.append(",'' as ts_pln_cfm_sts_cd    " ).append("\n"); 
		query.append(",'' as ts_rmk               " ).append("\n"); 
		query.append(",'' as cre_usr_id           " ).append("\n"); 
		query.append(",'' as cre_dt               " ).append("\n"); 
		query.append(",'' as upd_usr_id           " ).append("\n"); 
		query.append(",'' as upd_dt" ).append("\n"); 
		query.append(",'' as file_seq" ).append("\n"); 
		query.append(",'' as file_nm" ).append("\n"); 
		query.append(",'' as file_path_rmk" ).append("\n"); 
		query.append(",'' as file_sav_id" ).append("\n"); 
		query.append("     , '' as SKD_CNG_STS_CD" ).append("\n"); 
		query.append("     , '' as SKD_CNG_RSN_CD" ).append("\n"); 
		query.append(",'' as usr_rmk" ).append("\n"); 
		query.append(",'' as keys" ).append("\n"); 
		query.append(",'' as cost_wk" ).append("\n"); 
		query.append(",'' as mlt_pol_list_ctnt" ).append("\n"); 
		query.append(",'' as mlt_pod_list_ctnt" ).append("\n"); 
		query.append(",'' as pln_atch" ).append("\n"); 
		query.append(",'' as n1st_vvd_cd" ).append("\n"); 
		query.append(",'' as n2nd_vvd_cd" ).append("\n"); 
		query.append(",'' as n3rd_vvd_cd" ).append("\n"); 
		query.append(",'' as n4th_vvd_cd" ).append("\n"); 
		query.append(",'' as n5th_vvd_cd" ).append("\n"); 
		query.append(",'' as port_skp_tp_cd" ).append("\n"); 
		query.append(",'' as mlt_crr_list_ctnt" ).append("\n"); 
		query.append(", '' as PORT_SKP_RSN_CD" ).append("\n"); 
		query.append(", '' as PHS_IO_RSN_CD" ).append("\n"); 
		query.append(",'' as file_size" ).append("\n"); 
		query.append(",'' as search_tp" ).append("\n"); 
		query.append(",'' as ts_pln_gid_dtl" ).append("\n"); 
		query.append(",'' AS SKD_CNG_RSN_NM " ).append("\n"); 
		query.append(",'' AS EXIST_FLG" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}