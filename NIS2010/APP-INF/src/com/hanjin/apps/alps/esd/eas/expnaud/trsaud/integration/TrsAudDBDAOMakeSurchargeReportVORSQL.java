/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TrsAudDBDAOMakeSurchargeReportVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.30 
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

public class TrsAudDBDAOMakeSurchargeReportVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO for Surcharge Report
	  * </pre>
	  */
	public TrsAudDBDAOMakeSurchargeReportVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOMakeSurchargeReportVORSQL").append("\n"); 
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
		query.append("SELECT	 ''	s_dt_tp_cd" ).append("\n"); 
		query.append("        ,''	s_fm_dt" ).append("\n"); 
		query.append("        ,''	s_to_dt" ).append("\n"); 
		query.append("        ,''	s_ofc_tp_cd" ).append("\n"); 
		query.append("        ,''	s_rhq_ofc_cd" ).append("\n"); 
		query.append("        ,''	s_ofc_cd" ).append("\n"); 
		query.append("        ,''	s_trns_mod_cd" ).append("\n"); 
		query.append("        ,''	s_scg_cd" ).append("\n"); 
		query.append("        ,''	s_cgo_tp_cd" ).append("\n"); 
		query.append("        ,''	s_srch_opt_cd" ).append("\n"); 
		query.append("        ,''	s_eac_if" ).append("\n"); 
		query.append("		,'' chk" ).append("\n"); 
		query.append("		,''	yr_mon" ).append("\n"); 
		query.append("        ,''	so_no" ).append("\n"); 
		query.append("        ,''	wo_no" ).append("\n"); 
		query.append("        ,''	inv_no" ).append("\n"); 
		query.append("        ,''	bkg_no" ).append("\n"); 
		query.append("        ,''	eq_no" ).append("\n"); 
		query.append("        ,''	eq_tpsz_cd" ).append("\n"); 
		query.append("        ,''	cgo_tp_cd" ).append("\n"); 
		query.append("        ,''	cost_nm" ).append("\n"); 
		query.append("        ,''	curr_cd" ).append("\n"); 
		query.append("        ,''	scg_amt" ).append("\n"); 
		query.append("        ,''	scg_usd_amt" ).append("\n"); 
		query.append("        ,''	inv_curr_cd" ).append("\n"); 
		query.append("        ,''	inv_scg_amt" ).append("\n"); 
		query.append("        ,''	inv_usd_scg_amt" ).append("\n"); 
		query.append("        ,''	trsp_crr_mod_cd" ).append("\n"); 
		query.append("        ,''	fm_nod_cd" ).append("\n"); 
		query.append("        ,''	via_nod_cd" ).append("\n"); 
		query.append("        ,''	to_nod_cd" ).append("\n"); 
		query.append("        ,''	dor_nod_cd" ).append("\n"); 
		query.append("        ,''	trsp_bnd_cd" ).append("\n"); 
		query.append("        ,''	otr_rmk" ).append("\n"); 
		query.append("        ,''	trsp_purp_rsn" ).append("\n"); 
		query.append("        ,''	inter_rmk" ).append("\n"); 
		query.append("        ,''	inv_otr_rmk" ).append("\n"); 
		query.append("        ,''	inv_rmk" ).append("\n"); 
		query.append("        ,''	rhq_ofc_cd" ).append("\n"); 
		query.append("        ,''	so_ofc_cd" ).append("\n"); 
		query.append("        ,''	so_usr_nm" ).append("\n"); 
		query.append("        ,''	n3pty_bil_flg" ).append("\n"); 
		query.append("        ,''	wo_vndr_seq" ).append("\n"); 
		query.append("        ,''	wo_vndr_nm" ).append("\n"); 
		query.append("        ,''	inv_vndr_seq" ).append("\n"); 
		query.append("        ,''	inv_vndr_nm" ).append("\n"); 
		query.append("        ,''	sc_no" ).append("\n"); 
		query.append("        ,''	rfa_no" ).append("\n"); 
		query.append("        ,''	shipper" ).append("\n"); 
		query.append("        ,''	consignee" ).append("\n"); 
		query.append("        ,''	eac_if_flg" ).append("\n"); 
		query.append("        ,'' lgs_cost_cd" ).append("\n"); 
		query.append("        ,'' cntr_spe" ).append("\n"); 
		query.append("        ,'' nego_rmk" ).append("\n"); 
		query.append("        ,'' spcl_instr_rmk" ).append("\n"); 
		query.append("        ,'' sub_rail_seq" ).append("\n"); 
		query.append("        ,'' chk_usrail" ).append("\n"); 
		query.append("        ,'' hid_usrail" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 

	}
}