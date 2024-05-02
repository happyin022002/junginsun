/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchEdi10514701TroCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchEdi10514701TroCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi_105147_01_TRO_CNTR
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchEdi10514701TroCntrRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchEdi10514701TroCntrRSQL").append("\n"); 
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
		query.append("SELECT	 so.eq_no cntr_no					" ).append("\n"); 
		query.append(" 		,tpsz.cntr_tpsz_tare_wgt cntr_tare_wgt" ).append("\n"); 
		query.append(" 		,NVL(tro.cgo_wgt,1) + tpsz.cntr_tpsz_tare_wgt cntr_gross_wgt" ).append("\n"); 
		query.append("		,tpsz.cntr_tpsz_iso_cd cntr_tp" ).append("\n"); 
		query.append("		,so.eq_tpsz_cd cntr_tp_desc" ).append("\n"); 
		query.append("		,so.trsp_bnd_cd tro_bound				" ).append("\n"); 
		query.append("		,so.trsp_crr_mod_cd	tro_type" ).append("\n"); 
		query.append("		,tro.EUR_TRNS_TP_CD tro_haul_type" ).append("\n"); 
		query.append("		,so.bkg_no bkg_no				" ).append("\n"); 
		query.append("		,so.bl_no	bl_no" ).append("\n"); 
		query.append("		,so.slan_cd	tvvd_lane" ).append("\n"); 
		query.append("		,vsl.call_sgn_no tvvd_vsl_call" ).append("\n"); 
		query.append("		,vsl.vsl_eng_nm tvsl_name			" ).append("\n"); 
		query.append("		,so.vsl_cd||so.skd_voy_no||so.skd_dir_cd	tvvd_vvd" ).append("\n"); 
		query.append("		,so.por_cd tvv_por" ).append("\n"); 
		query.append("		,so.pol_cd tvv_pol" ).append("\n"); 
		query.append("		,loc1.loc_nm tvvd_pol_nm" ).append("\n"); 
		query.append("		,so.pod_cd tvvd_pod" ).append("\n"); 
		query.append("		,loc2.loc_nm tvvd_pod_nm" ).append("\n"); 
		query.append("		,TO_CHAR(skd1.vps_etd_dt,'YYYYMMDDHH24MI') tvvd_etd" ).append("\n"); 
		query.append("		,TO_CHAR(skd2.vps_eta_dt,'YYYYMMDDHH24MI') tvvd_eta" ).append("\n"); 
		query.append("		,'' tvvd_pol_eta --추가" ).append("\n"); 
		query.append("		,'' tvvd_close_dt --추가" ).append("\n"); 
		query.append("		,so.del_cd del" ).append("\n"); 
		query.append("		,DECODE(so.cgo_tp_cd,'F','N','B','N','Y')	mt_ind" ).append("\n"); 
		query.append("		,bkg.rc_flg rf_ind     " ).append("\n"); 
		query.append("		,bkg.dcgo_flg dg_ind   " ).append("\n"); 
		query.append("		,bkg.awk_cgo_flg awk_ind" ).append("\n"); 
		query.append("		,TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(so.spcl_instr_rmk ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) spcl_inst" ).append("\n"); 
		query.append("		,TRIM(SUBSTR( REPLACE( REPLACE(REPLACE(REPLACE(bkg.INTER_RMK ,CHR(13)||CHR(10),' '), '\\\"','*'),CHR(9),' '), CHR(10),' ') ,1,350)) remark" ).append("\n"); 
		query.append("		,tro.cstms_clr_no	trm_customs_no" ).append("\n"); 
		query.append("		,cm.cmdt_hs_cd	cmd_hs_cd" ).append("\n"); 
		query.append("		,CASE WHEN so.trsp_bnd_cd = 'I' " ).append("\n"); 
		query.append("			  	  AND so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("			 	THEN ''	" ).append("\n"); 
		query.append("     		  WHEN so.trsp_bnd_cd = 'O'" ).append("\n"); 
		query.append("     			  AND so.trsp_cost_dtl_mod_cd = 'DR' " ).append("\n"); 
		query.append("     			  AND yd1.yd_fcty_tp_psdo_yd_flg='Y'" ).append("\n"); 
		query.append("     		    THEN ''							" ).append("\n"); 
		query.append("     			ELSE so.fm_nod_cd " ).append("\n"); 
		query.append("     		 END pu_yd" ).append("\n"); 
		query.append("		,CASE WHEN so.trsp_bnd_cd= 'I' " ).append("\n"); 
		query.append("		          AND so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("		        THEN ''	" ).append("\n"); 
		query.append("     	      WHEN so.trsp_bnd_cd= 'O' " ).append("\n"); 
		query.append("     			  AND so.trsp_cost_dtl_mod_cd = 'DR' " ).append("\n"); 
		query.append("     			  AND yd1.yd_fcty_tp_psdo_yd_flg='Y' " ).append("\n"); 
		query.append("     			THEN ''" ).append("\n"); 
		query.append("     			ELSE yd1.yd_nm " ).append("\n"); 
		query.append("     		 END pu_yd_desc" ).append("\n"); 
		query.append("		,CASE WHEN so.trsp_bnd_cd = 'I' " ).append("\n"); 
		query.append("				  AND so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				THEN ''	" ).append("\n"); 
		query.append("     		  WHEN SO.TRSP_BND_CD= 'O' " ).append("\n"); 
		query.append("     			  AND so.trsp_cost_dtl_mod_cd = 'DR'" ).append("\n"); 
		query.append("     			  AND yd1.yd_fcty_tp_psdo_yd_flg = 'Y' " ).append("\n"); 
		query.append("     			THEN ''							" ).append("\n"); 
		query.append("     		  ELSE TO_CHAR(tro.cntr_pkup_dt,'YYYYMMDDHH24MI') " ).append("\n"); 
		query.append("     	 END pu_dt" ).append("\n"); 
		query.append("		,CASE WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("			  	  AND so.trsp_bnd_cd = 'I' 			" ).append("\n"); 
		query.append("			    THEN so.fm_nod_cd" ).append("\n"); 
		query.append("     		  WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("     			  AND so.trsp_bnd_cd = 'O'			" ).append("\n"); 
		query.append("				THEN so.via_nod_cd" ).append("\n"); 
		query.append("			  ELSE ''" ).append("\n"); 
		query.append("		 END fm_yd" ).append("\n"); 
		query.append("		,CASE WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("		          AND so.trsp_bnd_cd = 'I'" ).append("\n"); 
		query.append("				THEN yd1.yd_nm" ).append("\n"); 
		query.append("			  WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'O'			" ).append("\n"); 
		query.append("				THEN yd2.yd_nm" ).append("\n"); 
		query.append("			  ELSE '' " ).append("\n"); 
		query.append("		 END fm_yd_desc" ).append("\n"); 
		query.append("		,CASE WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'I' 			" ).append("\n"); 
		query.append("				THEN TO_CHAR(so.n1st_nod_pln_dt ,'YYYYMMDDHH24MI')					" ).append("\n"); 
		query.append("			  WHEN so.via_nod_cd IS NOT NULL" ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'O'			" ).append("\n"); 
		query.append("				THEN TO_CHAR(so.dor_nod_pln_dt,'YYYYMMDDHH24MI')					" ).append("\n"); 
		query.append("			  ELSE '' " ).append("\n"); 
		query.append("		  END fm_yd_dt" ).append("\n"); 
		query.append("		,CASE WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'I'" ).append("\n"); 
		query.append("				THEN so.via_nod_cd" ).append("\n"); 
		query.append("			  WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'O'" ).append("\n"); 
		query.append("				THEN so.to_nod_cd" ).append("\n"); 
		query.append("			  ELSE '' " ).append("\n"); 
		query.append("		 END to_yd" ).append("\n"); 
		query.append("		,CASE WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'I'" ).append("\n"); 
		query.append("				THEN yd2.yd_nm" ).append("\n"); 
		query.append("			  WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'O'" ).append("\n"); 
		query.append("				THEN yd3.yd_nm" ).append("\n"); 
		query.append("			  ELSE '' " ).append("\n"); 
		query.append("		 END to_yd_desc" ).append("\n"); 
		query.append("		,CASE WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'I'" ).append("\n"); 
		query.append("				THEN TO_CHAR(so.dor_nod_pln_dt,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("			  WHEN so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				  AND so.trsp_bnd_cd = 'O'" ).append("\n"); 
		query.append("				THEN TO_CHAR(so.lst_nod_pln_dt,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("			  ELSE '' " ).append("\n"); 
		query.append("		 END to_yd_dt" ).append("\n"); 
		query.append("		,CASE WHEN so.trsp_bnd_cd = 'O' " ).append("\n"); 
		query.append("				  AND so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				THEN ''	" ).append("\n"); 
		query.append("			  WHEN so.trsp_bnd_cd = 'I' " ).append("\n"); 
		query.append("				   AND so.trsp_cost_dtl_mod_cd = 'DR' " ).append("\n"); 
		query.append("				   AND yd1.yd_fcty_tp_psdo_yd_flg ='Y' " ).append("\n"); 
		query.append("				 THEN ''" ).append("\n"); 
		query.append("			   ELSE so.to_nod_cd" ).append("\n"); 
		query.append("		 END RTN_YD" ).append("\n"); 
		query.append("		,CASE WHEN so.trsp_bnd_cd = 'O' " ).append("\n"); 
		query.append("				  AND so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				THEN ''	" ).append("\n"); 
		query.append("			  WHEN so.trsp_bnd_cd = 'I' " ).append("\n"); 
		query.append("				  AND so.trsp_cost_dtl_mod_cd = 'DR' " ).append("\n"); 
		query.append("				  AND yd1.yd_fcty_tp_psdo_yd_flg='Y' " ).append("\n"); 
		query.append("				THEN ''							" ).append("\n"); 
		query.append("				ELSE yd3.yd_nm" ).append("\n"); 
		query.append("			  END rtn_yd_desc" ).append("\n"); 
		query.append("		,CASE WHEN so.trsp_bnd_cd = 'O' " ).append("\n"); 
		query.append("				  AND so.via_nod_cd IS NOT NULL " ).append("\n"); 
		query.append("				THEN ''	" ).append("\n"); 
		query.append("			  WHEN so.trsp_bnd_cd = 'I' " ).append("\n"); 
		query.append("				  AND so.trsp_cost_dtl_mod_cd = 'DR' " ).append("\n"); 
		query.append("				  AND yd1.yd_fcty_tp_psdo_yd_flg ='Y' " ).append("\n"); 
		query.append("				 THEN ''							" ).append("\n"); 
		query.append("			  ELSE TO_CHAR(tro.cntr_rtn_dt,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		 END rtn_dt" ).append("\n"); 
		query.append("		,(SELECT SEAL.CNTR_SEAL_NO  FROM BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("                           WHERE SEAL.CNTR_SEAL_SEQ = 1" ).append("\n"); 
		query.append("                            AND SEAL.BKG_NO  = SO.BKG_NO" ).append("\n"); 
		query.append("                            AND SEAL.CNTR_NO = SO.EQ_NO )	seal_no " ).append("\n"); 
		query.append("        ,(SELECT /*+ INDEX_ASC(DTL XPKBKG_EUR_TRO_DTL) */" ).append("\n"); 
		query.append("                 UPPER(DTL.LOD_REF_NO)" ).append("\n"); 
		query.append("            FROM BKG_EUR_TRO_DTL DTL" ).append("\n"); 
		query.append("           WHERE DTL.BKG_NO      = tro.BKG_NO" ).append("\n"); 
		query.append("             AND DTL.IO_BND_CD   = tro.IO_BND_CD" ).append("\n"); 
		query.append("             AND DTL.TRO_SEQ     = tro.TRO_SEQ" ).append("\n"); 
		query.append("             AND ROWNUM = 1" ).append("\n"); 
		query.append("          ) LOAD_REF" ).append("\n"); 
		query.append("    FROM mdm_cntr_tp_sz tpsz" ).append("\n"); 
		query.append("		,mdm_vsl_cntr vsl" ).append("\n"); 
		query.append("		,mdm_location loc1" ).append("\n"); 
		query.append("		,mdm_location loc2" ).append("\n"); 
		query.append("		,vsk_vsl_port_skd skd1" ).append("\n"); 
		query.append("		,vsk_vsl_port_skd skd2" ).append("\n"); 
		query.append("		,bkg_vvd bv" ).append("\n"); 
		query.append("		,bkg_eur_tro tro" ).append("\n"); 
		query.append("		,bkg_booking bkg" ).append("\n"); 
		query.append("		,mdm_yard yd1" ).append("\n"); 
		query.append("		,mdm_yard yd2" ).append("\n"); 
		query.append("		,mdm_yard yd3" ).append("\n"); 
		query.append("		,bkg_cntr_mf_desc cm   " ).append("\n"); 
		query.append("		,trs_trsp_svc_ord so													" ).append("\n"); 
		query.append("   WHERE so.delt_flg <> 'Y'			" ).append("\n"); 
		query.append("	 AND so.trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("	 AND so.trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 
		query.append("	 AND so.hjl_no is null			" ).append("\n"); 
		query.append("	 AND so.eq_tpsz_cd = tpsz.cntr_tpsz_cd(+)" ).append("\n"); 
		query.append("	 AND so.vsl_cd = vsl.vsl_cd(+)" ).append("\n"); 
		query.append("	 AND so.pol_cd = loc1.loc_cd" ).append("\n"); 
		query.append("	 AND so.pod_cd = loc2.loc_cd" ).append("\n"); 
		query.append("	 AND bv.bkg_no = bkg.bkg_no			" ).append("\n"); 
		query.append("	 AND bv.vsl_pre_pst_cd = 'T'				" ).append("\n"); 
		query.append("	 AND bv.vsl_cd = skd1.vsl_cd(+)" ).append("\n"); 
		query.append("	 AND bv.skd_voy_no = skd1.skd_voy_no(+)		" ).append("\n"); 
		query.append("	 AND bv.skd_dir_cd = skd1.skd_dir_cd(+)	" ).append("\n"); 
		query.append("	 AND bv.pol_cd = skd1.vps_port_cd(+) " ).append("\n"); 
		query.append("	 AND skd1.clpt_ind_seq(+) =1" ).append("\n"); 
		query.append("	 -- AND NVL(skd1.cng_sts_cd,'XX' ) <> 'S'  kys 확인해보기!!" ).append("\n"); 
		query.append("	 AND bv.vsl_cd = skd2.vsl_cd(+)" ).append("\n"); 
		query.append("	 AND bv.skd_voy_no = skd2.skd_voy_no(+)" ).append("\n"); 
		query.append("	 AND bv.skd_dir_cd = skd2.skd_dir_cd(+)	" ).append("\n"); 
		query.append("	 AND bv.pod_cd = skd2.vps_port_cd(+)" ).append("\n"); 
		query.append("	 AND skd2.clpt_ind_seq(+) =1" ).append("\n"); 
		query.append("	 -- AND NVL(skd2.cng_sts_cd,'XX' )<> 'S'  kys 확인해보기!! " ).append("\n"); 
		query.append("	 AND so.bkg_no = tro.bkg_no" ).append("\n"); 
		query.append("	 AND tro.tro_seq = so.tro_seq" ).append("\n"); 
		query.append("	 AND so.bkg_no = bkg.bkg_no" ).append("\n"); 
		query.append("	 AND so.bkg_no = cm.bkg_no(+)" ).append("\n"); 
		query.append("	 AND so.eq_no = cm.cntr_no(+)		" ).append("\n"); 
		query.append("	 AND cm.cntr_mf_seq(+) = 1 " ).append("\n"); 
		query.append("	 AND so.fm_nod_cd = yd1.yd_cd(+)" ).append("\n"); 
		query.append("	 AND so.via_nod_cd = yd2.yd_cd(+)" ).append("\n"); 
		query.append("	 AND so.to_nod_cd = yd3.yd_cd(+)" ).append("\n"); 

	}
}