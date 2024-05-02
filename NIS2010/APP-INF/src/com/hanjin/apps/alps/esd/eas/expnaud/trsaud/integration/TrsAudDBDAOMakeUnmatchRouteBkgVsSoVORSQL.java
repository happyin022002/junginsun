/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOMakeUnmatchRouteBkgVsSoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOMakeUnmatchRouteBkgVsSoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO for Un-Match Route Between BKG vs. S/O
	  * </pre>
	  */
	public TrsAudDBDAOMakeUnmatchRouteBkgVsSoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOMakeUnmatchRouteBkgVsSoVORSQL").append("\n"); 
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
		query.append("SELECT   ''	s_rhq_ofc_cd" ).append("\n"); 
		query.append("        ,''	s_ofc_cd" ).append("\n"); 
		query.append("        ,''	s_fm_dt" ).append("\n"); 
		query.append("        ,''	s_to_dt" ).append("\n"); 
		query.append("        ,''	s_wo_sts_cd" ).append("\n"); 
		query.append("        ,''	s_bnd_cd" ).append("\n"); 
		query.append("        ,''	s_bkg_no" ).append("\n"); 
		query.append("        ,''	s_eac_if" ).append("\n"); 
		query.append("        ,''	s_xcld_oft_incl" ).append("\n"); 
		query.append("        ,''	s_rcv_trm" ).append("\n"); 
		query.append("        ,''	s_dlvry_trm" ).append("\n"); 
		query.append("		,'' s_cst_cd" ).append("\n"); 
		query.append("        ,'' chk" ).append("\n"); 
		query.append("        ,''	slan_cd" ).append("\n"); 
		query.append("        ,''	vvd" ).append("\n"); 
		query.append("        ,''	bkg_no" ).append("\n"); 
		query.append("        ,''	eq_no" ).append("\n"); 
		query.append("        ,''	eq_tpsz_cd" ).append("\n"); 
		query.append("        ,''	trsp_bnd_cd" ).append("\n"); 
		query.append("        ,''	bkg_rcvde_term_cd" ).append("\n"); 
		query.append("        ,''	tro_flg" ).append("\n"); 
		query.append("        ,''	por_nod_cd" ).append("\n"); 
		query.append("        ,''	pol_nod_cd" ).append("\n"); 
		query.append("        ,''	pod_nod_cd" ).append("\n"); 
		query.append("        ,''	del_nod_cd" ).append("\n"); 
		query.append("        ,''	bkg_curr_cd" ).append("\n"); 
		query.append("        ,''	bkg_scg_amt" ).append("\n"); 
		query.append("        ,''	bkg_scg_usd_amt" ).append("\n"); 
		query.append("        ,''	fm_nod_cd" ).append("\n"); 
		query.append("        ,''	via_nod_cd" ).append("\n"); 
		query.append("        ,''	to_nod_cd" ).append("\n"); 
		query.append("        ,''	dor_nod_cd" ).append("\n"); 
		query.append("        ,''	trsp_crr_mod_cd" ).append("\n"); 
		query.append("        ,''	so_no" ).append("\n"); 
		query.append("        ,''	wo_no" ).append("\n"); 
		query.append("        ,''	wo_vndr_seq" ).append("\n"); 
		query.append("        ,''	inv_no" ).append("\n"); 
		query.append("        ,''	curr_cd" ).append("\n"); 
		query.append("        ,''	wo_amt" ).append("\n"); 
		query.append("        ,''	inv_curr_cd" ).append("\n"); 
		query.append("        ,''	inv_amt" ).append("\n"); 
		query.append("        ,''	inv_usd_amt" ).append("\n"); 
		query.append("        ,''	so_usr_nm" ).append("\n"); 
		query.append("        ,''	inv_usr_nm" ).append("\n"); 
		query.append("        ,''	inter_rmk" ).append("\n"); 
		query.append("        ,''	spcl_instr_rmk" ).append("\n"); 
		query.append("        ,''	eac_if_flg" ).append("\n"); 
		query.append("        ,''	trsp_purp_rsn" ).append("\n"); 
		query.append("        ,''	cng_rsn_desc" ).append("\n"); 
		query.append("		,'' trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}