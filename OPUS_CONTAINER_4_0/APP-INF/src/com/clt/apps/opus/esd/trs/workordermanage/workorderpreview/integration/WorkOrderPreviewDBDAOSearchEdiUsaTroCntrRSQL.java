/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdiUsaTroCntrRSQL.java
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

public class WorkOrderPreviewDBDAOSearchEdiUsaTroCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_USA_TRO_CNTR
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdiUsaTroCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdiUsaTroCntrRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_NL(DOR_YARD_DTL) INDEX(BV XPKBKG_BKG_VVD) */												" ).append("\n"); 
		query.append("		 so.eq_no as cntr_no" ).append("\n"); 
		query.append(" 		,trs_common_pkg.get_cntr_tare_wgt_to_uom_fnc('LBS', so.eq_tpsz_cd) as cntr_tare_wgt" ).append("\n"); 
		query.append("	 	,so.cntr_lbs_wgt as cntr_gross_wgt" ).append("\n"); 
		query.append(" 		,so.cntr_lbs_wgt-trs_common_pkg.get_cntr_tare_wgt_to_uom_fnc('LBS', so.eq_tpsz_cd) as cntr_net_wgt" ).append("\n"); 
		query.append("		,'LBS' as cntr_wgt_unit" ).append("\n"); 
		query.append("  		,tpsz.cntr_tpsz_iso_cd as cntr_tp" ).append("\n"); 
		query.append("		,so.eq_tpsz_cd as cntr_tp_desc" ).append("\n"); 
		query.append("		,so.trsp_bnd_cd as tro_bound" ).append("\n"); 
		query.append("		,so.trsp_crr_mod_cd as tro_type" ).append("\n"); 
		query.append("		,'' as tro_haul_type" ).append("\n"); 
		query.append("		,so.bkg_no as bkg_no" ).append("\n"); 
		query.append("		,so.bl_no as bl_no" ).append("\n"); 
		query.append("		,so.trsp_so_ofc_cty_cd||so.trsp_so_seq as so_no" ).append("\n"); 
		query.append("		,LPAD(so.edi_ctrl_seq, 9, 0) as unique_no" ).append("\n"); 
		query.append("        --,CASE WHEN (select EDI.FRT_CLT_FLG||EDI.OBL_RDEM_FLG||EDI.CSTMS_CLR_CD FOC from BKG_CGO_RLSE EDI WHERE EDI.BL_NO = SO.BL_NO ) = 'YYY'" ).append("\n"); 
		query.append("        ,CASE WHEN TRS_GET_FOC_INFO_FNC(SO.BL_NO, SO.TRSP_SO_OFC_CTY_CD, SO.TRSP_SO_SEQ, NULL) = 'YYY'" ).append("\n"); 
		query.append("                    THEN PK.PKUP_NO " ).append("\n"); 
		query.append("		  ELSE '' " ).append("\n"); 
		query.append("		  END as pu_no" ).append("\n"); 
		query.append("		,(SELECT IT.IBD_TRSP_NO FROM BKG_CSTMS_ADV_IBD IT " ).append("\n"); 
		query.append("               WHERE IT.CNT_CD = 'US' AND IT.BL_NO = SO.BL_NO)  as it_no" ).append("\n"); 
		query.append("		,(SELECT PU.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("          FROM BKG_REFERENCE PU" ).append("\n"); 
		query.append("          WHERE PU.BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("          AND PU.CNTR_NO = SO.EQ_NO AND PU.BKG_REF_TP_CD = 'CTPO' ) AS po_no" ).append("\n"); 
		query.append("  		,TO_CHAR(PK.PKUP_AVAL_DT,'YYYYMMDD') as ava_date" ).append("\n"); 
		query.append("		,TO_CHAR(PK.LST_FREE_DT,'YYYYMMDD') as lf_date" ).append("\n"); 
		query.append("  		,TO_CHAR(so.n1st_nod_pln_dt,'YYYYMMDDHHMM') as edt" ).append("\n"); 
		query.append("		,TO_CHAR(so.lst_nod_pln_dt,'YYYYMMDDHHMM') as eat" ).append("\n"); 
		query.append("		,so.lst_loc_cd as usa_l_city" ).append("\n"); 
		query.append("		,trs_get_blck_stwg_cd_fnc(so.bkg_no) as mlb " ).append("\n"); 
		query.append("		,so.slan_cd as tvvd_lane	" ).append("\n"); 
		query.append("		,vsl.call_sgn_no as tvvd_vsl_call" ).append("\n"); 
		query.append(" 		, vsl.vsl_eng_nm as tvsl_name" ).append("\n"); 
		query.append("		,so.vsl_cd||so.skd_voy_no||so.skd_dir_cd as tvvd_vvd" ).append("\n"); 
		query.append(" 		,so.por_cd as tvvd_por" ).append("\n"); 
		query.append("		,so.pol_cd as tvvd_pol" ).append("\n"); 
		query.append(" 		,loc1.loc_nm as tvvd_pol_nm" ).append("\n"); 
		query.append("		,so.pod_cd as tvvd_pod" ).append("\n"); 
		query.append("  		,loc2.loc_nm as tvvd_pod_nm" ).append("\n"); 
		query.append("		,TO_CHAR(skd1.vps_etd_dt, 'YYYYMMDDHH24MI')	as tvvd_etd" ).append("\n"); 
		query.append("  		,TO_CHAR(skd2.vps_eta_dt, 'YYYYMMDDHH24MI')as tvvd_eta" ).append("\n"); 
		query.append("		,DECODE(so.cgo_tp_cd,'F','N','B','N','Y') as mt_ind" ).append("\n"); 
		query.append("		,bkg_cntr.rc_flg as rf_ind   " ).append("\n"); 
		query.append("		,bkg_cntr.dcgo_flg as dg_ind   " ).append("\n"); 
		query.append("		,bkg_cntr.awk_cgo_flg as awk_ind  		" ).append("\n"); 
		query.append("		,so.spcl_cgo_cntr_tp_cd as spe_cargo" ).append("\n"); 
		query.append("   		,REPLACE(so.spcl_instr_rmk, CHR(13)||CHR(10), ' ') as spcl_inst" ).append("\n"); 
		query.append("		,REPLACE(bkg.inter_rmk, CHR(13)||CHR(10), ' ') as remark " ).append("\n"); 
		query.append("   		,''	as trm_customs_no" ).append("\n"); 
		query.append("		,cm.cmdt_hs_cd	as cmd_hs_cd" ).append("\n"); 
		query.append("		,NVL(from_yard.yd_cd,from_lse_yard.lse_co_yd_cd) as fm_yd" ).append("\n"); 
		query.append("		,REPLACE(trs_common_pkg.get_yd_cd_nm_fnc(so.fm_nod_cd),CHR(13)||CHR(10), ' ') as fm_yd_desc" ).append("\n"); 
		query.append("  		,TO_CHAR(so.n1st_nod_pln_dt ,'YYYYMMDDHH24MI') as fm_yd_dt" ).append("\n"); 
		query.append("		,REPLACE(NVL(from_yard.yd_addr,from_lse_yard.yd_addr), CHR(13)||CHR(10), ' ') as fm_addr" ).append("\n"); 
		query.append("		,'' as fm_city" ).append("\n"); 
		query.append("		,'' as fm_state" ).append("\n"); 
		query.append("		,NVL(from_yard.zip_cd,'') as fm_zip" ).append("\n"); 
		query.append("		,NVL(from_yard.phn_no,from_lse_yard.phn_no) as fm_tel" ).append("\n"); 
		query.append("		,NVL(from_yard.fax_no,from_lse_yard.fax_no) as fm_fax" ).append("\n"); 
		query.append("		,NVL(from_yard.yd_pic_nm,from_lse_yard.yd_pic_nm) as fm_pic" ).append("\n"); 
		query.append("		,NVL(dor_yard.zn_cd, so.dor_nod_cd) as dr_yd" ).append("\n"); 
		query.append("		,REPLACE(NVL(so.fctry_nm,''), CHR(13)||CHR(10), ' ') as dr_yd_desc" ).append("\n"); 
		query.append("		,TO_CHAR(so.dor_nod_pln_dt,'YYYYMMDDHH24MI') as dr_yd_dt" ).append("\n"); 
		query.append("		,REPLACE(NVL(so.dor_de_addr,''), CHR(13)||CHR(10), ' ') as dr_addr" ).append("\n"); 
		query.append("		,'' as dr_city" ).append("\n"); 
		query.append("		,'' as dr_state" ).append("\n"); 
		query.append("		,NVL(dor_yard_dtl.zip_cd, so.dor_pst_cd) as dr_zip" ).append("\n"); 
		query.append("		,so.cntc_pson_phn_no as dr_tel" ).append("\n"); 
		query.append("		,so.cntc_pson_fax_no as dr_fax" ).append("\n"); 
		query.append("		,so.cntc_pson_nm as dr_pic" ).append("\n"); 
		query.append("		,NVL(via_yard.yd_cd,via_lse_yard.lse_co_yd_cd) as via_yd" ).append("\n"); 
		query.append("		,REPLACE(trs_common_pkg.get_yd_cd_nm_fnc(so.via_nod_cd),CHR(13)||CHR(10), ' ') as via_yd_desc" ).append("\n"); 
		query.append("		,'' as via_yd_dt" ).append("\n"); 
		query.append("		,REPLACE(NVL(via_yard.yd_addr,via_lse_yard.yd_addr),CHR(13)||CHR(10), ' ') as via_addr" ).append("\n"); 
		query.append("		,'' as via_city" ).append("\n"); 
		query.append("		,'' as via_state" ).append("\n"); 
		query.append("		,NVL(via_yard.zip_cd, '') as via_zip" ).append("\n"); 
		query.append("		,NVL(via_yard.phn_no,via_lse_yard.phn_no) as via_tel" ).append("\n"); 
		query.append("		,NVL(via_yard.fax_no,via_lse_yard.fax_no) as via_fax" ).append("\n"); 
		query.append("		,NVL(via_yard.yd_pic_nm,via_lse_yard.yd_pic_nm) as via_pic" ).append("\n"); 
		query.append("		,NVL(to_yard.yd_cd, to_lse_yard.lse_co_yd_cd) as to_yd" ).append("\n"); 
		query.append("		,REPLACE(trs_common_pkg.get_yd_cd_nm_fnc(so.to_nod_cd),CHR(13)||CHR(10), ' ') as to_yd_desc" ).append("\n"); 
		query.append("		,TO_CHAR(so.lst_nod_pln_dt,'YYYYMMDDHH24MI') as to_yd_dt" ).append("\n"); 
		query.append("		,REPLACE(NVL(to_yard.yd_addr, to_lse_yard.yd_addr),CHR(13)||CHR(10), ' ') as to_addr" ).append("\n"); 
		query.append("		,''	as to_city" ).append("\n"); 
		query.append("		,''	as to_state" ).append("\n"); 
		query.append("		,NVL(to_yard.zip_cd, '')	AS TO_ZIP" ).append("\n"); 
		query.append("		,NVL(to_yard.phn_no, to_lse_yard.phn_no) as to_tel" ).append("\n"); 
		query.append("		,NVL(to_yard.fax_no, to_lse_yard.fax_no) as to_fax" ).append("\n"); 
		query.append("		,NVL(to_yard.yd_pic_nm, to_lse_yard.yd_pic_nm)	as to_pic" ).append("\n"); 
		query.append("		,(SELECT SEAL.CNTR_SEAL_NO  FROM BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("                           WHERE SEAL.CNTR_SEAL_SEQ = 1" ).append("\n"); 
		query.append("                            AND SEAL.BKG_NO  = SO.BKG_NO" ).append("\n"); 
		query.append("                            AND SEAL.CNTR_NO = SO.EQ_NO ) seal_no " ).append("\n"); 
		query.append("		,LTRIM(TO_CHAR(TO_CHAR(NVL(so.bzc_amt,0) +	NVL(so.etc_add_amt,0)+NVL(so.fuel_scg_amt,0) +	NVL(so.nego_amt,0)), '999999999999990.00')) as cntr_rate" ).append("\n"); 
		query.append("		,so.curr_cd as cntr_rate_cur	" ).append("\n"); 
		query.append("	FROM trs_trsp_svc_ord  so" ).append("\n"); 
		query.append(" 		,mdm_cntr_tp_sz	tpsz" ).append("\n"); 
		query.append("		,bkg_container bkg_cntr    " ).append("\n"); 
		query.append(" 		,mdm_vsl_cntr vsl" ).append("\n"); 
		query.append(" 		,mdm_location loc1" ).append("\n"); 
		query.append(" 		,mdm_location loc2" ).append("\n"); 
		query.append(" 		,vsk_vsl_port_skd skd1" ).append("\n"); 
		query.append(" 		,vsk_vsl_port_skd skd2" ).append("\n"); 
		query.append("		,bkg_vvd bv " ).append("\n"); 
		query.append("		,bkg_booking bkg" ).append("\n"); 
		query.append("		,bkg_cntr_mf_desc cm " ).append("\n"); 
		query.append("		,BKG_PKUP_NTC_PKUP_NO PK	" ).append("\n"); 
		query.append("		,mdm_yard from_yard" ).append("\n"); 
		query.append(" 		,mdm_lse_co_yd from_lse_yard" ).append("\n"); 
		query.append("	 	,mdm_yard via_yard" ).append("\n"); 
		query.append(" 		,mdm_lse_co_yd via_lse_yard" ).append("\n"); 
		query.append(" 		,mdm_yard to_yard" ).append("\n"); 
		query.append(" 		,mdm_lse_co_yd to_lse_yard" ).append("\n"); 
		query.append(" 		,mdm_zone dor_yard" ).append("\n"); 
		query.append(" 		,mdm_zn_dtl dor_yard_dtl" ).append("\n"); 
		query.append("        ,mdm_location loc_pk" ).append("\n"); 
		query.append("   WHERE so.delt_flg<> 'Y'" ).append("\n"); 
		query.append(" 	 AND so.trsp_so_ofc_cty_cd= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	 AND so.trsp_so_seq= @[trsp_so_seq]" ).append("\n"); 
		query.append("	 AND so.eq_tpsz_cd= tpsz.cntr_tpsz_cd(+)" ).append("\n"); 
		query.append("	 AND so.bkg_no = bkg_cntr.bkg_no(+)" ).append("\n"); 
		query.append("	 AND so.eq_no	= bkg_cntr.cntr_no(+)" ).append("\n"); 
		query.append("	 AND so.vsl_cd= vsl.vsl_cd(+)" ).append("\n"); 
		query.append("	 AND so.pol_cd= loc1.loc_cd(+)" ).append("\n"); 
		query.append("	 AND so.pod_cd= loc2.loc_cd(+)" ).append("\n"); 
		query.append("	 AND SO.BKG_NO= PK.BKG_NO(+)" ).append("\n"); 
		query.append("     AND SO.EQ_NO=  PK.CNTR_NO(+)" ).append("\n"); 
		query.append("     AND PK.DEL_CD = loc_pk.LOC_CD(+)" ).append("\n"); 
		query.append("     AND PK.OFC_CD = loc_pk.EQ_CTRL_OFC_CD(+)" ).append("\n"); 
		query.append("     AND 'N'       = loc_pk.DELT_FLG(+)" ).append("\n"); 
		query.append("	 AND bv.vsl_pre_pst_cd(+)= 'T'" ).append("\n"); 
		query.append(" 	 AND bv.vsl_cd= skd1.vsl_cd(+)" ).append("\n"); 
		query.append("	 AND bv.skd_voy_no= skd1.skd_voy_no(+)" ).append("\n"); 
		query.append("	 AND bv.skd_dir_cd= skd1.skd_dir_cd(+)" ).append("\n"); 
		query.append("	 AND bv.pol_cd= skd1.vps_port_cd(+) " ).append("\n"); 
		query.append("	 AND skd1.clpt_ind_seq(+)= 1						" ).append("\n"); 
		query.append("	 AND NVL(skd1.skd_cng_sts_cd,'XX' ) <> 'S' " ).append("\n"); 
		query.append(" 	 AND bv.vsl_cd= skd2.vsl_cd(+)" ).append("\n"); 
		query.append("	 AND bv.skd_voy_no= skd2.skd_voy_no(+)" ).append("\n"); 
		query.append("	 AND bv.skd_dir_cd= skd2.skd_dir_cd(+)" ).append("\n"); 
		query.append("	 AND bv.pol_cd= skd2.vps_port_cd(+) " ).append("\n"); 
		query.append("	 AND skd2.clpt_ind_seq(+)= 1						" ).append("\n"); 
		query.append("	 AND NVL(skd2.skd_cng_sts_cd,'XX' ) <> 'S' " ).append("\n"); 
		query.append("	 AND bkg.bkg_no	= bv.bkg_no(+)" ).append("\n"); 
		query.append("	 AND so.bkg_no= bkg.bkg_no(+)" ).append("\n"); 
		query.append("	 AND so.bkg_no= cm.bkg_no(+)" ).append("\n"); 
		query.append("	 AND so.eq_no= cm.cntr_no(+)" ).append("\n"); 
		query.append("	 AND cm.cntr_mf_seq(+) = 1  	 " ).append("\n"); 
		query.append("	 AND so.fm_nod_cd	= from_yard.yd_cd(+)" ).append("\n"); 
		query.append("	 AND from_yard.delt_flg(+)= 'N'			" ).append("\n"); 
		query.append("	 AND so.fm_nod_cd= from_lse_yard.lse_co_yd_cd(+)" ).append("\n"); 
		query.append("	 AND from_lse_yard.delt_flg(+) = 'N'" ).append("\n"); 
		query.append("	 AND so.via_nod_cd= via_yard.yd_cd(+)" ).append("\n"); 
		query.append("	 AND via_yard.delt_flg(+) = 'N'			" ).append("\n"); 
		query.append("	 AND so.via_nod_cd= via_lse_yard.lse_co_yd_cd(+)" ).append("\n"); 
		query.append("	 AND via_lse_yard.delt_flg(+)= 'N'" ).append("\n"); 
		query.append("	 AND so.to_nod_cd= to_yard.yd_cd(+)" ).append("\n"); 
		query.append("	 AND to_yard.delt_flg(+) = 'N'			" ).append("\n"); 
		query.append("	 AND so.to_nod_cd= to_lse_yard.lse_co_yd_cd(+)" ).append("\n"); 
		query.append("	 AND to_lse_yard.delt_flg(+)= 'N'" ).append("\n"); 
		query.append("	 AND so.dor_nod_cd = dor_yard.zn_cd(+)" ).append("\n"); 
		query.append("	 AND so.dor_nod_cd= dor_yard_dtl.zn_cd(+)" ).append("\n"); 
		query.append("	 AND dor_yard.delt_flg(+) = 'N'" ).append("\n"); 

	}
}