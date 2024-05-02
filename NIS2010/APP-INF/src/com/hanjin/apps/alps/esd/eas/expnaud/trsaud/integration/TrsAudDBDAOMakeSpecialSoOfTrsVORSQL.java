/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOMakeSpecialSoOfTrsVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.03 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOMakeSpecialSoOfTrsVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Special S/O of Transport  조회용 VO
	  * </pre>
	  */
	public TrsAudDBDAOMakeSpecialSoOfTrsVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOMakeSpecialSoOfTrsVORSQL").append("\n"); 
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
		query.append("SELECT    '' s_rhq_ofc_cd" ).append("\n"); 
		query.append("          ,'' s_ofc_cd" ).append("\n"); 
		query.append("          ,'' s_fm_dt" ).append("\n"); 
		query.append("          ,'' s_to_dt" ).append("\n"); 
		query.append("          ,'' s_bnd_cd" ).append("\n"); 
		query.append("          ,'' s_eac_if" ).append("\n"); 
		query.append("          ,'' s_trsp_crr_mod_cd" ).append("\n"); 
		query.append("          ,'' eq_no" ).append("\n"); 
		query.append("          ,'' eq_tpsz_cd" ).append("\n"); 
		query.append("          ,'' trsp_crr_mod_cd" ).append("\n"); 
		query.append("          ,'' trsp_so_tp_cd" ).append("\n"); 
		query.append("          ,'' so_no" ).append("\n"); 
		query.append("          ,'' so_locl_cre_dt" ).append("\n"); 
		query.append("          ,'' so_usr_nm     " ).append("\n"); 
		query.append("          ,'' wo_no" ).append("\n"); 
		query.append("          ,'' wo_locl_cre_dt" ).append("\n"); 
		query.append("          ,'' wo_ofc_cd" ).append("\n"); 
		query.append("          ,'' wo_usr_nm      " ).append("\n"); 
		query.append("          ,'' fm_nod_cd" ).append("\n"); 
		query.append("          ,'' via_nod_cd" ).append("\n"); 
		query.append("          ,'' to_nod_cd" ).append("\n"); 
		query.append("          ,'' dor_nod_cd" ).append("\n"); 
		query.append("          ,'' vndr_seq" ).append("\n"); 
		query.append("          ,'' vndr_nm" ).append("\n"); 
		query.append("          ,'' prnt_vndr_seq" ).append("\n"); 
		query.append("          ,'' prnt_vndr_nm" ).append("\n"); 
		query.append("          ,'' n3pty_bil_flg" ).append("\n"); 
		query.append("          ,'' curr_cd" ).append("\n"); 
		query.append("          ,'' bzc_amt" ).append("\n"); 
		query.append("          ,'' nego_amt" ).append("\n"); 
		query.append("          ,'' fuel_scg_amt" ).append("\n"); 
		query.append("          ,'' scg_vat_amt" ).append("\n"); 
		query.append("          ,'' etc_add_amt" ).append("\n"); 
		query.append("          ,'' wo_tot_amt" ).append("\n"); 
		query.append("          ,'' wo_usd_tot_amt" ).append("\n"); 
		query.append("          ,'' inv_no" ).append("\n"); 
		query.append("          ,'' inv_vndr_seq" ).append("\n"); 
		query.append("          ,'' trsp_purp_rsn  " ).append("\n"); 
		query.append("          ,'' inter_rmk" ).append("\n"); 
		query.append("          ,'' spcl_instr_rmk" ).append("\n"); 
		query.append("		  ,'' bkg_no" ).append("\n"); 
		query.append("          ,'' por_cd" ).append("\n"); 
		query.append("          ,'' pol_cd" ).append("\n"); 
		query.append("          ,'' pod_cd" ).append("\n"); 
		query.append("          ,'' del_cd" ).append("\n"); 
		query.append("          ,'' eac_if_flg" ).append("\n"); 
		query.append("          ,'' ord" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}