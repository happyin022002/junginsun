/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchRdContentsMainRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.02
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchRdContentsMainRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRdContentsMain
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchRdContentsMainRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_prv_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_iss_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchRdContentsMainRSQL").append("\n"); 
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
		query.append("SELECT tmp.vndr_seq as vndr_code                    " ).append("\n"); 
		query.append("	  	,vd.vndr_lgl_eng_nm  as full_name                    " ).append("\n"); 
		query.append("	  	,vd.eng_addr as eng_addr                     " ).append("\n"); 
		query.append("		,vd_cntc.phn_no as phn_no" ).append("\n"); 
		query.append("		,vd_cntc.fax_no as fax_no" ).append("\n"); 
		query.append("		,vd.cntc_pson_nm as cntc_pson_nm" ).append("\n"); 
		query.append("		,so.trsp_bnd_cd as trsp_bnd_cd" ).append("\n"); 
		query.append("		,so.trsp_cost_dtl_mod_cd as trsp_cost_dtl_mod_cd" ).append("\n"); 
		query.append("		,commcode_pkg.get_comdtl_name_fnc('CD00283',so.trsp_crr_mod_cd) as trsp_crr_mod_nm" ).append("\n"); 
		query.append("		,commcode_pkg.get_comdtl_name_fnc('CD00744',so.trsp_cost_dtl_mod_cd) as trsp_cost_dtl_mod_nm" ).append("\n"); 
		query.append("		,NVL(wrk.trsp_wo_ofc_cty_cd,'')||NVL(wrk.trsp_wo_seq,'') as trsp_wo_cd" ).append("\n"); 
		query.append("		,DECODE (tmp.wo_iss_sts_cd, 'I','Issue','R', 'Reissue','C','Correction' ,'N','Cancellation') as wo_iss_sts_cd" ).append("\n"); 
		query.append("		,NVL(from_yard.yd_cd,from_lse_yard.lse_co_yd_cd) as fm_cd" ).append("\n"); 
		query.append("		,NVL(from_yard.yd_nm, from_lse_yard.lse_co_yd_nm) as fm_nm" ).append("\n"); 
		query.append("		,NVL(from_yard.yd_addr, from_lse_yard.yd_addr) as fm_addr" ).append("\n"); 
		query.append("		,NVL(from_yard.phn_no, from_lse_yard.phn_no) as fm_phn_no" ).append("\n"); 
		query.append("		,NVL(from_yard.fax_no, from_lse_yard.fax_no) as fm_fax_no" ).append("\n"); 
		query.append("		,NVL(from_yard.yd_pic_nm, from_lse_yard.yd_pic_nm) as fm_pic_nm" ).append("\n"); 
		query.append("		,NVL(to_yard.yd_cd, to_lse_yard.lse_co_yd_cd) as to_cd" ).append("\n"); 
		query.append("		,NVL(to_yard.yd_nm, to_lse_yard.lse_co_yd_nm) as to_nm" ).append("\n"); 
		query.append("		,NVL(to_yard.yd_addr, to_lse_yard.yd_addr) as to_addr" ).append("\n"); 
		query.append("		,NVL(to_yard.phn_no, to_lse_yard.phn_no) as to_phn_no" ).append("\n"); 
		query.append("		,NVL(to_yard.fax_no, to_lse_yard.fax_no) as to_fax_no                    " ).append("\n"); 
		query.append("		,NVL(to_yard.yd_pic_nm,to_lse_yard.yd_pic_nm) as to_pic_nm                    " ).append("\n"); 
		query.append("		,via_yard.yd_cd as via_cd" ).append("\n"); 
		query.append("		,via_yard.yd_nm as via_nm" ).append("\n"); 
		query.append("		,via_yard.yd_addr as via_addr" ).append("\n"); 
		query.append("		,via_yard.phn_no as via_phn_no" ).append("\n"); 
		query.append("		,via_yard.fax_no as via_fax_no" ).append("\n"); 
		query.append("		,via_yard.yd_pic_nm as via_pic_nm" ).append("\n"); 
		query.append("		,so.dor_nod_cd as dr_cd" ).append("\n"); 
		query.append("		,so.dor_de_addr as dr_addr" ).append("\n"); 
		query.append("		,so.fctry_nm as dr_nm" ).append("\n"); 
		query.append("		,so.cntc_pson_phn_no as dr_phn_no" ).append("\n"); 
		query.append("		,so.cntc_pson_fax_no as dr_fax_no" ).append("\n"); 
		query.append("		,so.cntc_pson_nm as dr_pic_nm" ).append("\n"); 
		query.append("		,wrk.wo_rmk as instruction" ).append("\n"); 
		query.append("		,vsl1.vsl_eng_nm||' '||SUBSTR(so.ib_vvd_cd,5,5) as ib_vvd_cd                    " ).append("\n"); 
		query.append("		,vsl2.vsl_eng_nm||' '||SUBSTR(so.ob_vvd_cd,5,5) as ob_vvd_cd" ).append("\n"); 
		query.append("		,org.ofc_addr  as ofc_addr" ).append("\n"); 
		query.append("		,org.ofc_phn_no as ofc_phn_no" ).append("\n"); 
		query.append("		,org.ofc_fax_no as ofc_fax_no" ).append("\n"); 
		query.append("		,usr.usr_nm as pic" ).append("\n"); 
		query.append("		,TO_CHAR(NVL(wrk.locl_upd_dt, wrk.locl_cre_dt),'YYYY-MM-DD')  as wo_cre_dt                    " ).append("\n"); 
		query.append("		,TO_CHAR(NVL(wrk.locl_upd_dt, wrk.locl_cre_dt),'HH24:MI') as wo_cre_tm" ).append("\n"); 
		query.append("    FROM trs_trsp_svc_ord so" ).append("\n"); 
		query.append("		,mdm_vendor vd" ).append("\n"); 
		query.append("		,mdm_vndr_cntc_pnt vd_cntc" ).append("\n"); 
		query.append("		,mdm_yard from_yard" ).append("\n"); 
		query.append("		,mdm_lse_co_yd from_lse_yard" ).append("\n"); 
		query.append("		,mdm_yard to_yard                " ).append("\n"); 
		query.append("		,mdm_lse_co_yd to_lse_yard" ).append("\n"); 
		query.append("		,mdm_yard via_yard" ).append("\n"); 
		query.append("		,trs_trsp_wrk_ord_prv_tmp tmp" ).append("\n"); 
		query.append("		,mdm_organization org" ).append("\n"); 
		query.append("		,com_user usr" ).append("\n"); 
		query.append("		,mdm_vsl_cntr vsl1" ).append("\n"); 
		query.append("		,mdm_vsl_cntr vsl2" ).append("\n"); 
		query.append("		,trs_trsp_wrk_ord wrk" ).append("\n"); 
		query.append("   WHERE tmp.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("     AND tmp.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("     AND tmp.trsp_so_ofc_cty_cd = so.trsp_so_ofc_cty_cd" ).append("\n"); 
		query.append("     AND tmp.trsp_so_seq = so.trsp_so_seq" ).append("\n"); 
		query.append("     AND org.ofc_cd = ?" ).append("\n"); 
		query.append("     AND tmp.vndr_seq = vd.vndr_seq(+)                " ).append("\n"); 
		query.append("     AND vd.vndr_seq = vd_cntc.vndr_seq(+)           " ).append("\n"); 
		query.append("     AND vd_cntc.prmry_chk_flg(+) = 'Y'" ).append("\n"); 
		query.append("     AND vd_cntc.phn_no(+) IS NOT NULL" ).append("\n"); 
		query.append("     AND vd.delt_flg(+) = 'N'" ).append("\n"); 
		query.append("     AND vd_cntc.delt_flg(+) = 'N'            " ).append("\n"); 
		query.append("     AND tmp.fm_nod_cd = from_yard.yd_cd(+)" ).append("\n"); 
		query.append("     AND from_yard.delt_flg(+) = 'N'" ).append("\n"); 
		query.append("     AND tmp.fm_nod_cd = from_lse_yard.lse_co_yd_cd(+)" ).append("\n"); 
		query.append("     AND from_lse_yard.delt_flg(+) = 'N'" ).append("\n"); 
		query.append("     AND tmp.to_nod_cd = to_yard.yd_cd(+" ).append("\n"); 
		query.append("     AND to_yard.delt_flg(+) = 'N'" ).append("\n"); 
		query.append("     AND tmp.to_nod_cd = to_lse_yard.lse_co_yd_cd(+)   " ).append("\n"); 
		query.append("     AND to_lse_yard.delt_flg(+) = 'N'" ).append("\n"); 
		query.append("     AND tmp.via_nod_cd = via_yard.yd_cd(+)" ).append("\n"); 
		query.append("     AND usr.usr_id = ?" ).append("\n"); 
		query.append("     AND tmp.trsp_wo_ofc_cty_cd = wrk.trsp_wo_ofc_cty_cd(+)" ).append("\n"); 
		query.append("     AND tmp.trsp_wo_seq = wrk.trsp_wo_seq(+)     " ).append("\n"); 
		query.append("     AND SUBSTR(so.ib_vvd_cd,1,4) = vsl1.vsl_cd(+)" ).append("\n"); 
		query.append("     AND SUBSTR(so.ob_vvd_cd,1,4)  = vsl2.vsl_cd(+)" ).append("\n"); 
		query.append("     AND ROWNUM = 1" ).append("\n"); 

	}
}