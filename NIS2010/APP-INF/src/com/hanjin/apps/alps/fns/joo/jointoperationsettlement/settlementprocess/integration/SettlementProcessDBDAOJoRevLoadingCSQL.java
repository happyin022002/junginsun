/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOJoRevLoadingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.17
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.12.17 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SettlementProcessDBDAOJoRevLoadingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Jo Rev Loading 정보를 입력한다.
	  * </pre>
	  */
	public SettlementProcessDBDAOJoRevLoadingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_40ft_cntr_stl_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_20ft_cntr_stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_40ft_cntr_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_sto_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_stl_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_clz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_wgt_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("all_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_slt_teu_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ak_unit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_bsa_20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_dg_clz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fin_used",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_40",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_slt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_slt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_40ft_cntr_stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_slt_teu_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_ld_20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grand_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("over_slot_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_20ft_cntr_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mt_40",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_40",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grand_ttl_slot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_bsa_40",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcntr_teu_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_stl_teu_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ak_void",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_usd_slt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_20_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_cntr_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_rdr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_20ft_cntr_stl_teu_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_ovr_usd_slt_clz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_scg_stl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_ld_40",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_bsa_45",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("all_teu",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_rf_clz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_20ft_cntr_stl_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hc_ld_45",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_40ft_cntr_stl_teu_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_40_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOJoRevLoadingCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_LODG_TGT J" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" J.REV_YRMON " ).append("\n"); 
		query.append(",J.REV_YRMON_SEQ " ).append("\n"); 
		query.append(",J.TRD_CD " ).append("\n"); 
		query.append(",J.CRR_CD " ).append("\n"); 
		query.append(",J.RLANE_CD " ).append("\n"); 
		query.append(",J.RE_DIVR_CD " ).append("\n"); 
		query.append(",J.VSL_CD " ).append("\n"); 
		query.append(",J.SKD_VOY_NO " ).append("\n"); 
		query.append(",J.SKD_DIR_CD " ).append("\n"); 
		query.append(",J.VPS_PORT_CD " ).append("\n"); 
		query.append(",J.YD_CD " ).append("\n"); 
		query.append(",J.CLPT_IND_SEQ " ).append("\n"); 
		query.append(",J.RF_SCG_STL_TP_CD 	--" ).append("\n"); 
		query.append(",j.SLAN_CD 				--" ).append("\n"); 
		query.append(",J.RDR_FLG " ).append("\n"); 
		query.append(",J.VPS_ETD_DT " ).append("\n"); 
		query.append(",J.ACCT_CD " ).append("\n"); 
		query.append(",J.JO_STL_JB_CD " ).append("\n"); 
		query.append(",J.JO_STL_STS_CD " ).append("\n"); 
		query.append(",J.STL_TGT_FLG " ).append("\n"); 
		query.append(",J.STL_CLZ_FLG 			--" ).append("\n"); 
		query.append(",J.STL_OVR_USD_SLT_CLZ_FLG	--" ).append("\n"); 
		query.append(",J.STL_RF_CLZ_FLG			--" ).append("\n"); 
		query.append(",J.STL_DG_CLZ_FLG 			--" ).append("\n"); 
		query.append(",J.ALOC_TEU_KNT " ).append("\n"); 
		query.append(",J.ALOC_TEU_WGT " ).append("\n"); 
		query.append(",J.TTL_USD_TEU_KNT " ).append("\n"); 
		query.append(",J.TTL_USD_TEU_WGT " ).append("\n"); 
		query.append(",J.OVR_USD_SLT_TEU_KNT " ).append("\n"); 
		query.append(",J.OVR_USD_SLT_WGT " ).append("\n"); 
		query.append(",J.FX_OVR_USD_SLT_TEU_KNT " ).append("\n"); 
		query.append(",J.FX_OVR_USD_SLT_TEU_WGT " ).append("\n"); 
		query.append(",J.MCNTR_TEU_KNT " ).append("\n"); 
		query.append(",J.MCNTR_WGT " ).append("\n"); 
		query.append(",J.OVR_USD_STO_TP_CD " ).append("\n"); 
		query.append(",J.FNL_OVR_USD_SLT_KNT " ).append("\n"); 
		query.append(",J.RF_CNTR_20FT_KNT " ).append("\n"); 
		query.append(",J.RF_CNTR_40FT_KNT " ).append("\n"); 
		query.append(",J.RF_CNTR_SMRY_KNT " ).append("\n"); 
		query.append(",J.FCNTR_20FT_KNT " ).append("\n"); 
		query.append(",J.MCNTR_20FT_KNT " ).append("\n"); 
		query.append(",J.FCNTR_40FT_KNT " ).append("\n"); 
		query.append(",J.MCNTR_40FT_KNT " ).append("\n"); 
		query.append(",J.HC_FCNTR_20FT_KNT " ).append("\n"); 
		query.append(",J.HC_MCNTR_20FT_KNT " ).append("\n"); 
		query.append(",J.HC_FCNTR_40FT_KNT " ).append("\n"); 
		query.append(",J.HC_MCNTR_40FT_KNT " ).append("\n"); 
		query.append(",J.FCNTR_45FT_KNT " ).append("\n"); 
		query.append(",J.MCNTR_45FT_KNT " ).append("\n"); 
		query.append(",J.AWK_FCNTR_KNT " ).append("\n"); 
		query.append(",J.AWK_MCNTR_KNT " ).append("\n"); 
		query.append(",J.DG_FCNTR_KNT " ).append("\n"); 
		query.append(",J.DG_MCNTR_KNT " ).append("\n"); 
		query.append(",J.OVR_USD_SLT_TEU_CAPA " ).append("\n"); 
		query.append(",J.OVR_USD_SLT_PRC " ).append("\n"); 
		query.append(",J.OVR_USD_SLT_AMT " ).append("\n"); 
		query.append(",J.OVR_USD_SLT_RMK " ).append("\n"); 
		query.append(",J.RF_20FT_CNTR_STL_TEU_CAPA " ).append("\n"); 
		query.append(",J.RF_20FT_CNTR_STL_PRC " ).append("\n"); 
		query.append(",J.RF_20FT_CNTR_STL_AMT " ).append("\n"); 
		query.append(",J.RF_20FT_CNTR_STL_RMK " ).append("\n"); 
		query.append(",J.RF_40FT_CNTR_STL_TEU_CAPA " ).append("\n"); 
		query.append(",J.RF_40FT_CNTR_STL_PRC " ).append("\n"); 
		query.append(",J.RF_40FT_CNTR_STL_AMT " ).append("\n"); 
		query.append(",J.RF_40FT_CNTR_STL_RMK " ).append("\n"); 
		query.append(",J.DG_CNTR_STL_TEU_CAPA " ).append("\n"); 
		query.append(",J.DG_CNTR_STL_PRC " ).append("\n"); 
		query.append(",J.DG_CNTR_STL_AMT " ).append("\n"); 
		query.append(",J.DG_CNTR_STL_RMK " ).append("\n"); 
		query.append(",J.CRE_DT " ).append("\n"); 
		query.append(",J.CRE_USR_ID " ).append("\n"); 
		query.append(",J.UPD_DT " ).append("\n"); 
		query.append(",J.UPD_USR_ID " ).append("\n"); 
		query.append(",J.REV_DIR_CD" ).append("\n"); 
		query.append(",J.JO_STL_RMK_CD " ).append("\n"); 
		query.append(",J.JO_STL_RMK " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" @[rev_yrmon]			AS REV_YRMON                                    " ).append("\n"); 
		query.append(",@[rev_yrmon_seq]		AS REV_YRMON_SEQ                               " ).append("\n"); 
		query.append(",@[trd_cd] 				AS TRD_CD                                       " ).append("\n"); 
		query.append(",@[crr_cd] 				AS CRR_CD                                       " ).append("\n"); 
		query.append(",@[rlane_cd] 			AS RLANE_CD                                     " ).append("\n"); 
		query.append(",@[re_divr_cd]			AS RE_DIVR_CD                                   " ).append("\n"); 
		query.append(",@[vsl_cd] 				AS VSL_CD                                       " ).append("\n"); 
		query.append(",@[skd_voy_no]			AS SKD_VOY_NO                                   " ).append("\n"); 
		query.append(",@[skd_dir_cd] 			AS SKD_DIR_CD                                   " ).append("\n"); 
		query.append(",@[vps_port_cd] 		AS VPS_PORT_CD                                  " ).append("\n"); 
		query.append(",@[yd_cd] 				AS YD_CD                                        " ).append("\n"); 
		query.append(",@[clpt_ind_seq] 		AS CLPT_IND_SEQ        " ).append("\n"); 
		query.append(",@[rf_scg_stl_tp_cd]	AS RF_SCG_STL_TP_CD 	" ).append("\n"); 
		query.append(",@[slan_cd]				AS SLAN_CD 				                         " ).append("\n"); 
		query.append(",@[rdr_flg] 			AS RDR_FLG                                      " ).append("\n"); 
		query.append(",TO_DATE(@[vps_etd_dt],'YYYYMMDDHH24MISS') AS VPS_ETD_DT                                   " ).append("\n"); 
		query.append(",@[acct_cd] 				AS ACCT_CD                                      " ).append("\n"); 
		query.append(",@[jo_stl_jb_cd] 			AS JO_STL_JB_CD                                 " ).append("\n"); 
		query.append(",@[jo_stl_sts_cd] 			AS JO_STL_STS_CD                                " ).append("\n"); 
		query.append(",@[stl_tgt_flg] 			AS STL_TGT_FLG         " ).append("\n"); 
		query.append(",@[stl_clz_flg] 			AS STL_CLZ_FLG 			--" ).append("\n"); 
		query.append(",@[stl_ovr_usd_slt_clz_flg] AS STL_OVR_USD_SLT_CLZ_FLG	--" ).append("\n"); 
		query.append(",@[stl_rf_clz_flg] 			AS STL_RF_CLZ_FLG			--" ).append("\n"); 
		query.append(",@[stl_dg_clz_flg] 			AS STL_DG_CLZ_FLG 			--                         " ).append("\n"); 
		query.append("-----------------------------------------------" ).append("\n"); 
		query.append(",@[all_teu] 			AS ALOC_TEU_KNT                                 " ).append("\n"); 
		query.append(",@[all_wgt] 			AS ALOC_TEU_WGT                                 " ).append("\n"); 
		query.append(",@[grand_ttl_slot] 		AS TTL_USD_TEU_KNT                              " ).append("\n"); 
		query.append(",@[grand_ttl_wgt] 		AS TTL_USD_TEU_WGT                              " ).append("\n"); 
		query.append(",@[ovr_usd_slt_teu_knt] AS OVR_USD_SLT_TEU_KNT                          " ).append("\n"); 
		query.append(",@[ovr_usd_slt_wgt] 	AS OVR_USD_SLT_WGT                              " ).append("\n"); 
		query.append(",@[over_slot_c] 		AS FX_OVR_USD_SLT_TEU_KNT                       " ).append("\n"); 
		query.append(",@[over_wgt_c] 			AS FX_OVR_USD_SLT_TEU_WGT                       " ).append("\n"); 
		query.append(",@[mcntr_teu_knt] 		AS MCNTR_TEU_KNT    --                            " ).append("\n"); 
		query.append(",@[mcntr_wgt] 			AS MCNTR_WGT          --                          " ).append("\n"); 
		query.append(",@[ovr_usd_sto_tp_cd] 	AS OVR_USD_STO_TP_CD      --                       " ).append("\n"); 
		query.append(",@[fin_used] 			AS FNL_OVR_USD_SLT_KNT                          " ).append("\n"); 
		query.append(",@[rf_20_qty] 			AS RF_CNTR_20FT_KNT                             " ).append("\n"); 
		query.append(",@[rf_40_qty] 			AS RF_CNTR_40FT_KNT      " ).append("\n"); 
		query.append(",@[rf_rdr_qty] 			AS RF_CNTR_SMRY_KNT                             " ).append("\n"); 
		query.append(",@[full_20] 			AS FCNTR_20FT_KNT                               " ).append("\n"); 
		query.append(",@[mt_20] 				AS MCNTR_20FT_KNT                               " ).append("\n"); 
		query.append(",@[full_40] 			AS FCNTR_40FT_KNT                               " ).append("\n"); 
		query.append(",@[mt_40] 				AS MCNTR_40FT_KNT                               " ).append("\n"); 
		query.append(",@[hc_ld_20] 			AS HC_FCNTR_20FT_KNT                            " ).append("\n"); 
		query.append(",@[hc_bsa_20] 			AS HC_MCNTR_20FT_KNT                            " ).append("\n"); 
		query.append(",@[hc_ld_40] 			AS HC_FCNTR_40FT_KNT                            " ).append("\n"); 
		query.append(",@[hc_bsa_40] 			AS HC_MCNTR_40FT_KNT                            " ).append("\n"); 
		query.append(",@[hc_ld_45] 			AS FCNTR_45FT_KNT                               " ).append("\n"); 
		query.append(",@[hc_bsa_45] 			AS MCNTR_45FT_KNT                               " ).append("\n"); 
		query.append(",@[ak_unit] 			AS AWK_FCNTR_KNT                                " ).append("\n"); 
		query.append(",@[ak_void] 			AS AWK_MCNTR_KNT                                " ).append("\n"); 
		query.append(",@[dg_20] 				AS DG_FCNTR_KNT                                 " ).append("\n"); 
		query.append(",@[dg_40] 				AS DG_MCNTR_KNT  " ).append("\n"); 
		query.append("-----------------------------------------------------" ).append("\n"); 
		query.append(",@[ovr_usd_slt_teu_capa] 		AS OVR_USD_SLT_TEU_CAPA                         " ).append("\n"); 
		query.append(",@[ovr_usd_slt_prc] 			AS OVR_USD_SLT_PRC                              " ).append("\n"); 
		query.append(",@[ovr_usd_slt_amt] 			AS OVR_USD_SLT_AMT                              " ).append("\n"); 
		query.append(",@[ovr_usd_slt_rmk] 			AS OVR_USD_SLT_RMK                              " ).append("\n"); 
		query.append(",@[rf_20ft_cntr_stl_teu_capa] 	AS RF_20FT_CNTR_STL_TEU_CAPA                    " ).append("\n"); 
		query.append(",@[rf_20ft_cntr_stl_prc] 		AS RF_20FT_CNTR_STL_PRC                         " ).append("\n"); 
		query.append(",@[rf_20ft_cntr_stl_amt] 		AS RF_20FT_CNTR_STL_AMT                         " ).append("\n"); 
		query.append(",@[rf_20ft_cntr_stl_rmk] 		AS RF_20FT_CNTR_STL_RMK                         " ).append("\n"); 
		query.append(",@[rf_40ft_cntr_stl_teu_capa] 	AS RF_40FT_CNTR_STL_TEU_CAPA                    " ).append("\n"); 
		query.append(",@[rf_40ft_cntr_stl_prc] 		AS RF_40FT_CNTR_STL_PRC                         " ).append("\n"); 
		query.append(",@[rf_40ft_cntr_stl_amt] 		AS RF_40FT_CNTR_STL_AMT                         " ).append("\n"); 
		query.append(",@[rf_40ft_cntr_stl_rmk] 		AS RF_40FT_CNTR_STL_RMK                         " ).append("\n"); 
		query.append(",@[dg_cntr_stl_teu_capa] 		AS DG_CNTR_STL_TEU_CAPA                         " ).append("\n"); 
		query.append(",@[dg_cntr_stl_prc] 			AS DG_CNTR_STL_PRC                              " ).append("\n"); 
		query.append(",@[dg_cntr_stl_amt] 			AS DG_CNTR_STL_AMT                              " ).append("\n"); 
		query.append(",@[dg_cntr_stl_rmk] 			AS DG_CNTR_STL_RMK                              " ).append("\n"); 
		query.append(",SYSDATE 						AS CRE_DT                                       " ).append("\n"); 
		query.append(",@[upd_usr_id] 					AS CRE_USR_ID                                   " ).append("\n"); 
		query.append(",SYSDATE 						AS UPD_DT                                       " ).append("\n"); 
		query.append(",@[upd_usr_id] 					AS UPD_USR_ID                                   " ).append("\n"); 
		query.append(",@[rev_dir_cd]					AS REV_DIR_CD" ).append("\n"); 
		query.append(",@[rmk_flg]						AS JO_STL_RMK_CD " ).append("\n"); 
		query.append(",@[rmk]							AS JO_STL_RMK " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}