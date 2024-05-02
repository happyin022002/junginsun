/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAgreementManageCommonDAOTesAgreementManageCommonRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : yOnghO
*@LastVersion : 1.0
* 2016.02.12 yOnghO
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOnghO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAgreementManageCommonDAOTesAgreementManageCommonRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesAgreementManage Common
	  * </pre>
	  */
	public TesAgreementManageCommonDAOTesAgreementManageCommonRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo").append("\n"); 
		query.append("FileName : TesAgreementManageCommonDAOTesAgreementManageCommonRSQL").append("\n"); 
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
		query.append("  '' f_cmd" ).append("\n"); 
		query.append(", '' iPage" ).append("\n"); 
		query.append(", '' is_valid_yd_cd" ).append("\n"); 
		query.append(", '' yd_cd" ).append("\n"); 
		query.append(", '' yd_cd_name" ).append("\n"); 
		query.append(", '' yd_cd_hidden" ).append("\n"); 
		query.append(", '' yd_cd_deltflg" ).append("\n"); 
		query.append(", '' vndr_seq" ).append("\n"); 
		query.append(", '' is_valid_vndr_seq" ).append("\n"); 
		query.append(", '' vndr_seq_hidden" ).append("\n"); 
		query.append(", '' vndr_seq_deltflg" ).append("\n"); 
		query.append(", '' row_num" ).append("\n"); 
		query.append(", '' accm_seq" ).append("\n"); 
		query.append(", '' accm_cost_seq" ).append("\n"); 
		query.append(", '' accm_dtl_seq" ).append("\n"); 
		query.append(", '' eff_agmt" ).append("\n"); 
		query.append(", '' ofc_cd" ).append("\n"); 
		query.append(", '' eff_on" ).append("\n"); 
		query.append(", '' loop_value" ).append("\n"); 
		query.append(", '' tml_agmt_ofc_no" ).append("\n"); 
		query.append(", '' tml_agmt_sts_cd" ).append("\n"); 
		query.append(", '' tml_agmt_tp_cd" ).append("\n"); 
		query.append(", '' lgs_cost_cd" ).append("\n"); 
		query.append(", '' tml_agmt_vol_ut_cd" ).append("\n"); 
		query.append(", '' io_bnd_cd" ).append("\n"); 
		query.append(", '' curr_cd" ).append("\n"); 
		query.append(", '' select_tab" ).append("\n"); 
		query.append(", '' sheet_prefix" ).append("\n"); 
		query.append(", '' regAgmtFlg" ).append("\n"); 
		query.append(", '' regAgmtHDRFlg" ).append("\n"); 
		query.append(", '' initFormDTLFlg" ).append("\n"); 
		query.append(", '' agmtHDRCreAdjFlg" ).append("\n"); 
		query.append(", '' command_h" ).append("\n"); 
		query.append(", '' input_list_verify_flg" ).append("\n"); 
		query.append(", '' thrpFlg" ).append("\n"); 
		query.append(", '' vfsArray" ).append("\n"); 
		query.append(", '' fileImportFlg" ).append("\n"); 
		query.append(", '' lane_cdString" ).append("\n"); 
		query.append(", '' copy_tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append(", '' agmt_confirm_flg" ).append("\n"); 
		query.append(", '' cre_ofc_cd" ).append("\n"); 
		query.append(", '' cre_usr_id" ).append("\n"); 
		query.append(", '' upd_usr_id" ).append("\n"); 
		query.append(", '' inquiryFlg" ).append("\n"); 
		query.append(", '' amend_cd" ).append("\n"); 
		query.append(", '' wkdy_flg_fd          " ).append("\n"); 
		query.append(", '' sat_flg_fd           " ).append("\n"); 
		query.append(", '' sun_flg_fd           " ).append("\n"); 
		query.append(", '' hol_flg_fd           " ).append("\n"); 
		query.append(", '' dg_none  				" ).append("\n"); 
		query.append(", '' same_dg_none  			" ).append("\n"); 
		query.append(", '' same_dg  				" ).append("\n"); 
		query.append(", '' sep_dg_none  			" ).append("\n"); 
		query.append(", '' dcgo_n1st_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_n2nd_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_n3rd_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_n4th_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_n5th_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_n6th_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_n7th_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_n8th_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_n9th_clss_flg  	" ).append("\n"); 
		query.append(", '' dcgo_non_clss_flg  		" ).append("\n"); 
		query.append(", '' dg_none_fd  			" ).append("\n"); 
		query.append(", '' same_dg_none_fd  		" ).append("\n"); 
		query.append(", '' same_dg_fd  			" ).append("\n"); 
		query.append(", '' sep_dg_none_fd  		" ).append("\n"); 
		query.append(", '' dcgo_n1st_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_n2nd_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_n3rd_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_n4th_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_n5th_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_n6th_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_n7th_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_n8th_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_n9th_clss_flg_fd" ).append("\n"); 
		query.append(", '' dcgo_non_clss_flg_fd " ).append("\n"); 
		query.append(", '' dg_none_r  				" ).append("\n"); 
		query.append(", '' same_dg_none_r  		" ).append("\n"); 
		query.append(", '' same_dg_r  				" ).append("\n"); 
		query.append(", '' sep_dg_none_r  			" ).append("\n"); 
		query.append(", '' dcgo_n1st_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_n2nd_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_n3rd_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_n4th_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_n5th_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_n6th_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_n7th_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_n8th_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_n9th_clss_flg_r " ).append("\n"); 
		query.append(", '' dcgo_non_clss_flg_r  " ).append("\n"); 
		query.append(", '' d2    					" ).append("\n"); 
		query.append(", '' d4    					" ).append("\n"); 
		query.append(", '' d5    					" ).append("\n"); 
		query.append(", '' d7    					" ).append("\n"); 
		query.append(", '' d8    					" ).append("\n"); 
		query.append(", '' d9    					" ).append("\n"); 
		query.append(", '' dw    					" ).append("\n"); 
		query.append(", '' dx    					" ).append("\n"); 
		query.append(", '' r2    					" ).append("\n"); 
		query.append(", '' r4    					" ).append("\n"); 
		query.append(", '' r5    					     " ).append("\n"); 
		query.append(", '' r7  " ).append("\n"); 
		query.append(", '' r8" ).append("\n"); 
		query.append(", '' r9  					    " ).append("\n"); 
		query.append(", '' f2    					     " ).append("\n"); 
		query.append(", '' f4    					    " ).append("\n"); 
		query.append(", '' o2    					    " ).append("\n"); 
		query.append(", '' o4    " ).append("\n"); 
		query.append(", '' o5					    " ).append("\n"); 
		query.append(", '' s2    					    " ).append("\n"); 
		query.append(", '' s4    					    " ).append("\n"); 
		query.append(", '' t2    					     " ).append("\n"); 
		query.append(", '' t4    					    " ).append("\n"); 
		query.append(", '' a2    					    " ).append("\n"); 
		query.append(", '' a4" ).append("\n"); 
		query.append(", '' a5       					    " ).append("\n"); 
		query.append(", '' p2    					    " ).append("\n"); 
		query.append(", '' p4    					    " ).append("\n"); 
		query.append(", '' f5 " ).append("\n"); 
		query.append(", '' c2    					    " ).append("\n"); 
		query.append(", '' c4   					" ).append("\n"); 
		query.append(", '' d2_fd  					" ).append("\n"); 
		query.append(", '' d4_fd  					" ).append("\n"); 
		query.append(", '' d5_fd  					" ).append("\n"); 
		query.append(", '' d7_fd  					" ).append("\n"); 
		query.append(", '' d8_fd  					" ).append("\n"); 
		query.append(", '' d9_fd  					" ).append("\n"); 
		query.append(", '' dw_fd  					" ).append("\n"); 
		query.append(", '' dx_fd  					" ).append("\n"); 
		query.append(", '' r2_fd  					" ).append("\n"); 
		query.append(", '' r4_fd  					" ).append("\n"); 
		query.append(", '' r5_fd  					     " ).append("\n"); 
		query.append(", '' r7_fd " ).append("\n"); 
		query.append(", '' r8_fd" ).append("\n"); 
		query.append(", '' r9_fd 					    " ).append("\n"); 
		query.append(", '' f2_fd  					     " ).append("\n"); 
		query.append(", '' f4_fd  					    " ).append("\n"); 
		query.append(", '' o2_fd  					    " ).append("\n"); 
		query.append(", '' o4_fd " ).append("\n"); 
		query.append(", '' o5_fd 					    " ).append("\n"); 
		query.append(", '' s2_fd  					    " ).append("\n"); 
		query.append(", '' s4_fd  					    " ).append("\n"); 
		query.append(", '' t2_fd  					     " ).append("\n"); 
		query.append(", '' t4_fd  					    " ).append("\n"); 
		query.append(", '' a2_fd  					    " ).append("\n"); 
		query.append(", '' a4_fd  " ).append("\n"); 
		query.append(", '' a5_fd 					    " ).append("\n"); 
		query.append(", '' p2_fd  					    " ).append("\n"); 
		query.append(", '' p4_fd  					    " ).append("\n"); 
		query.append(", '' f5_fd " ).append("\n"); 
		query.append(", '' c2_fd" ).append("\n"); 
		query.append(", '' c4_fd 					     " ).append("\n"); 
		query.append(", '' d2_r  					" ).append("\n"); 
		query.append(", '' d4_r  					" ).append("\n"); 
		query.append(", '' d5_r  					" ).append("\n"); 
		query.append(", '' d7_r  					" ).append("\n"); 
		query.append(", '' d8_r  					" ).append("\n"); 
		query.append(", '' d9_r  					" ).append("\n"); 
		query.append(", '' dw_r  					" ).append("\n"); 
		query.append(", '' dx_r  					" ).append("\n"); 
		query.append(", '' r2_r  					" ).append("\n"); 
		query.append(", '' r4_r  					" ).append("\n"); 
		query.append(", '' r5_r  					     " ).append("\n"); 
		query.append(", '' r7_r " ).append("\n"); 
		query.append(", '' r8_r" ).append("\n"); 
		query.append(", '' r9_r 					    " ).append("\n"); 
		query.append(", '' f2_r  					     " ).append("\n"); 
		query.append(", '' f4_r  					    " ).append("\n"); 
		query.append(", '' o2_r  					    " ).append("\n"); 
		query.append(", '' o4_r " ).append("\n"); 
		query.append(", '' o5_r 					    " ).append("\n"); 
		query.append(", '' s2_r  					    " ).append("\n"); 
		query.append(", '' s4_r  					    " ).append("\n"); 
		query.append(", '' t2_r  					     " ).append("\n"); 
		query.append(", '' t4_r  					    " ).append("\n"); 
		query.append(", '' a2_r  					    " ).append("\n"); 
		query.append(", '' a4_r" ).append("\n"); 
		query.append(", '' a5_r   					    " ).append("\n"); 
		query.append(", '' p2_r  					    " ).append("\n"); 
		query.append(", '' p4_r  					    " ).append("\n"); 
		query.append(", '' f5_r" ).append("\n"); 
		query.append(", '' c2_r  					    " ).append("\n"); 
		query.append(", '' c4_r  					" ).append("\n"); 
		query.append(", '' teu_rate  				" ).append("\n"); 
		query.append(", '' box_rate  				" ).append("\n"); 
		query.append(", '' move_rate  				" ).append("\n"); 
		query.append(", '' gang_hour_rate	" ).append("\n"); 
		query.append(", '' ton_rate		" ).append("\n"); 
		query.append(", '' ts_rt  					" ).append("\n"); 
		query.append(", '' loc_cd" ).append("\n"); 
		query.append(", '' cre_ofc_cd2" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}