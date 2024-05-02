/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SettlementProcessDBDAOSlotHireTgtCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.09.07 민정호
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

public class SettlementProcessDBDAOSlotHireTgtCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Slot Hire Target 저장
	  * </pre>
	  */
	public SettlementProcessDBDAOSlotHireTgtCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_entr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_add_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_ovr_ton_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_ocn_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_rnd_rule_lvl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ovr_bsa_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_45ft_und_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("op_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_vvd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_40ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_inter_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_lodg_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_20ft_ovr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rnd_knd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ton_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_40ft_ovr_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_rf_ocn_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_sctr_prc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_ovr_ocn_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_ovr_mt_ocn_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_add_bsa_crr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_ovr_mt_inter_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_lodg_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_rank",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rdr_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_ovr_inter_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_fsh_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_inter_ovr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_lodg_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_prc_fsh_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rf_inter_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_bsa_entr_rdr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yrwk rev_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_45ft_ovr_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_stl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.integration").append("\n"); 
		query.append("FileName : SettlementProcessDBDAOSlotHireTgtCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_SLT_TGT J		--변경" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" J.REV_YRMON " ).append("\n"); 
		query.append(",J.REV_YRMON_SEQ" ).append("\n"); 
		query.append(",J.TRD_CD " ).append("\n"); 
		query.append(",J.CRR_CD " ).append("\n"); 
		query.append(",J.RLANE_CD " ).append("\n"); 
		query.append(",J.RE_DIVR_CD " ).append("\n"); 
		query.append(",J.VSL_CD " ).append("\n"); 
		query.append(",J.SKD_VOY_NO " ).append("\n"); 
		query.append(",J.SKD_DIR_CD " ).append("\n"); 
		query.append(",J.REV_DIR_CD			--" ).append("\n"); 
		query.append(",J.ESTM_VVD_TP_CD " ).append("\n"); 
		query.append(",J.OP_CRR_CD			--" ).append("\n"); 
		query.append(",J.ACCT_CD " ).append("\n"); 
		query.append(",J.JO_STL_JB_CD " ).append("\n"); 
		query.append(",J.BSA_QTY " ).append("\n"); 
		query.append(",J.BSA_SLT_PRC " ).append("\n"); 
		query.append(",J.ACT_BSA_QTY " ).append("\n"); 
		query.append(",J.ACT_SLT_PRC " ).append("\n"); 
		query.append(",J.FNL_BSA_QTY " ).append("\n"); 
		query.append(",J.FNL_BSA_SLT_PRC " ).append("\n"); 
		query.append(",J.ESTM_STL_AMT " ).append("\n"); 
		query.append(",J.ACT_STL_AMT " ).append("\n"); 
		query.append(",J.FNL_STL_AMT " ).append("\n"); 
		query.append(",J.ADJ_RSLT_CD " ).append("\n"); 
		query.append(",J.ADJ_RMK " ).append("\n"); 
		query.append(",J.JO_STL_STS_CD " ).append("\n"); 
		query.append(",J.N1ST_LODG_PORT_ETD_DT " ).append("\n"); 
		query.append(",J.LST_LODG_PORT_CD " ).append("\n"); 
		query.append(",J.LST_LODG_PORT_ETD_DT " ).append("\n"); 
		query.append(",J.STL_CLZ_FLG " ).append("\n"); 
		query.append(",J.JO_ALOC_ENBL_FLG " ).append("\n"); 
		query.append(",J.JO_BSA_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_BSA_ADD_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_ADD_BSA_CRR_FLG " ).append("\n"); 
		query.append(",J.JO_OVR_BSA_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_TON_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_OVR_TON_WGT " ).append("\n"); 
		query.append(",J.JO_20FT_SUB_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_20FT_OVR_RTO " ).append("\n"); 
		query.append(",J.JO_40FT_SUB_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_40FT_OVR_RTO " ).append("\n"); 
		query.append(",J.JO_45FT_SUB_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_45FT_OVR_RTO " ).append("\n"); 
		query.append(",J.JO_45FT_UND_RTO " ).append("\n"); 
		query.append(",J.JO_RF_OCN_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_RF_INTER_TEU_QTY " ).append("\n"); 
		query.append(",J.JO_RND_KND_FLG " ).append("\n"); 
		query.append(",J.JO_RND_RULE_LVL " ).append("\n"); 
		query.append(",J.JO_INTER_OVR_FLG " ).append("\n"); 
		query.append(",J.JO_RDR_PORT_CD " ).append("\n"); 
		query.append(",J.JO_FSH_FLG " ).append("\n"); 
		query.append(",J.JO_BSA_PRC " ).append("\n"); 
		query.append(",J.JO_OVR_OCN_PRC " ).append("\n"); 
		query.append(",J.JO_OVR_INTER_PRC " ).append("\n"); 
		query.append(",J.JO_OVR_MT_OCN_PRC " ).append("\n"); 
		query.append(",J.JO_OVR_MT_INTER_PRC " ).append("\n"); 
		query.append(",J.JO_SCTR_PRC_FLG " ).append("\n"); 
		query.append(",J.JO_RF_OCN_PRC " ).append("\n"); 
		query.append(",J.JO_RF_INTER_PRC " ).append("\n"); 
		query.append(",J.JO_PRC_FSH_FLG " ).append("\n"); 
		query.append(",J.YRWK " ).append("\n"); 
		query.append(",j.REV_PORT_ETD_DT " ).append("\n"); 
		query.append(",J.JO_BSA_ENTR_RMK " ).append("\n"); 
		query.append(",J.JO_BSA_ENTR_RDR_RMK " ).append("\n"); 
		query.append(",J.CRE_DT" ).append("\n"); 
		query.append(",J.CRE_USR_ID" ).append("\n"); 
		query.append(",J.UPD_DT" ).append("\n"); 
		query.append(",J.UPD_USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append(" @[rev_yrmon]					--AS REV_YRMON            " ).append("\n"); 
		query.append(",@[rev_yrmon_seq]			    --AS REV_YRMON_SEQ" ).append("\n"); 
		query.append(",@[trd_cd] 						--AS TRD_CD               " ).append("\n"); 
		query.append(",@[crr_cd] 						--AS CRR_CD               " ).append("\n"); 
		query.append(",@[rlane_cd] 					--AS RLANE_CD             " ).append("\n"); 
		query.append(",@[re_divr_cd] 					--AS RE_DIVR_CD           " ).append("\n"); 
		query.append(",@[vsl_cd] 						--AS VSL_CD               " ).append("\n"); 
		query.append(",@[skd_voy_no] 					--AS SKD_VOY_NO           " ).append("\n"); 
		query.append(",@[skd_dir_cd] 					--AS SKD_DIR_CD           " ).append("\n"); 
		query.append(",@[rev_dir_cd]					--AS REV_DIR_CD --" ).append("\n"); 
		query.append(",@[estm_vvd_tp_cd]				--AS ESTM_VVD_TP_CD    " ).append("\n"); 
		query.append(",@[op_crr_cd]   				--AS OR_CRR_CD  --" ).append("\n"); 
		query.append(",@[acct_cd] 					--AS ACCT_CD    " ).append("\n"); 
		query.append(",@[jo_stl_jb_cd] 				--AS JO_STL_JB_CD         " ).append("\n"); 
		query.append(",@[bsa_qty] 					--AS BSA_QTY              " ).append("\n"); 
		query.append(",@[bsa_slt_prc] 				--AS BSA_SLT_PRC          " ).append("\n"); 
		query.append(",@[bsa_qty] 					--AS ACT_BSA_QTY   --저장 시점의 BSA       " ).append("\n"); 
		query.append(",@[bsa_slt_prc] 				--AS ACT_SLT_PRC   --저장 시점의 BSA PRICE       " ).append("\n"); 
		query.append(",@[fnl_bsa_qty] 				--AS FNL_BSA_QTY          " ).append("\n"); 
		query.append(",@[fnl_bsa_slt_prc] 			--AS FNL_BSA_SLT_PRC      " ).append("\n"); 
		query.append(",@[estm_stl_amt] 				--AS ESTM_STL_AMT         " ).append("\n"); 
		query.append(",@[act_stl_amt] 				--AS ACT_STL_AMT          " ).append("\n"); 
		query.append(",@[fnl_stl_amt] 				--AS FNL_STL_AMT          " ).append("\n"); 
		query.append(",@[adj_rslt_cd] 				--AS ADJ_RSLT_CD          " ).append("\n"); 
		query.append(",@[adj_rmk] 					--AS ADJ_RMK              " ).append("\n"); 
		query.append(",@[jo_stl_sts_cd]				--AS JO_STL_STS_CD        " ).append("\n"); 
		query.append(",TO_DATE(@[n1st_lodg_port_etd_dt],'YYYYMMDDHH24MISS') 		--AS N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append(",@[lst_lodg_port_cd] 			--AS LST_LODG_PORT_CD     " ).append("\n"); 
		query.append(",TO_DATE(@[lst_lodg_port_etd_dt],'YYYYMMDDHH24MISS') 		--AS LST_LODG_PORT_ETD_DT " ).append("\n"); 
		query.append(",@[stl_clz_flg] 				--AS STL_CLZ_FLG          " ).append("\n"); 
		query.append(",DECODE(@[bsa_rank],'1','Y','N') --AS JO_ALOC_ENBL_FLG     " ).append("\n"); 
		query.append(",@[jo_bsa_teu_qty] 				--AS JO_BSA_TEU_QTY       " ).append("\n"); 
		query.append(",@[jo_bsa_add_teu_qty] 			--AS JO_BSA_ADD_TEU_QTY   " ).append("\n"); 
		query.append(",@[jo_add_bsa_crr_flg] 			--AS JO_ADD_BSA_CRR_FLG   " ).append("\n"); 
		query.append(",@[jo_ovr_bsa_teu_qty] 			--AS JO_OVR_BSA_TEU_QTY   " ).append("\n"); 
		query.append(",@[jo_ton_teu_qty] 				--AS JO_TON_TEU_QTY       " ).append("\n"); 
		query.append(",@[jo_ovr_ton_wgt] 				--AS JO_OVR_TON_WGT       " ).append("\n"); 
		query.append(",@[jo_20ft_sub_teu_qty] 		--AS JO_20FT_SUB_TEU_QTY  " ).append("\n"); 
		query.append(",@[jo_20ft_ovr_rto] 			--AS JO_20FT_OVR_RTO      " ).append("\n"); 
		query.append(",@[jo_40ft_sub_teu_qty] 		--AS JO_40FT_SUB_TEU_QTY  " ).append("\n"); 
		query.append(",@[jo_40ft_ovr_rto] 			--AS JO_40FT_OVR_RTO      " ).append("\n"); 
		query.append(",@[jo_45ft_sub_teu_qty] 		--AS JO_45FT_SUB_TEU_QTY  " ).append("\n"); 
		query.append(",@[jo_45ft_ovr_rto] 			--AS JO_45FT_OVR_RTO      " ).append("\n"); 
		query.append(",@[jo_45ft_und_rto] 			--AS JO_45FT_UND_RTO      " ).append("\n"); 
		query.append(",@[jo_rf_ocn_teu_qty] 			--AS JO_RF_OCN_TEU_QTY    " ).append("\n"); 
		query.append(",@[jo_rf_inter_teu_qty] 		--AS JO_RF_INTER_TEU_QTY  " ).append("\n"); 
		query.append(",@[jo_rnd_knd_flg] 				--AS JO_RND_KND_FLG       " ).append("\n"); 
		query.append(",@[jo_rnd_rule_lvl] 			--AS JO_RND_RULE_LVL      " ).append("\n"); 
		query.append(",@[jo_inter_ovr_flg] 			--AS JO_INTER_OVR_FLG     " ).append("\n"); 
		query.append(",@[jo_rdr_port_cd] 				--AS JO_RDR_PORT_CD       " ).append("\n"); 
		query.append(",@[jo_fsh_flg] 					--AS JO_FSH_FLG           " ).append("\n"); 
		query.append(",@[jo_bsa_prc] 					--AS JO_BSA_PRC           " ).append("\n"); 
		query.append(",@[jo_ovr_ocn_prc] 				--AS JO_OVR_OCN_PRC       " ).append("\n"); 
		query.append(",@[jo_ovr_inter_prc] 			--AS JO_OVR_INTER_PRC     " ).append("\n"); 
		query.append(",@[jo_ovr_mt_ocn_prc] 			--AS JO_OVR_MT_OCN_PRC    " ).append("\n"); 
		query.append(",@[jo_ovr_mt_inter_prc] 		--AS JO_OVR_MT_INTER_PRC  " ).append("\n"); 
		query.append(",@[jo_sctr_prc_flg] 			--AS JO_SCTR_PRC_FLG      " ).append("\n"); 
		query.append(",@[jo_rf_ocn_prc] 				--AS JO_RF_OCN_PRC        " ).append("\n"); 
		query.append(",@[jo_rf_inter_prc] 			--AS JO_RF_INTER_PRC      " ).append("\n"); 
		query.append(",@[jo_prc_fsh_flg] 				--AS JO_PRC_FSH_FLG       " ).append("\n"); 
		query.append(",@[yrwk] 						--AS YRWK " ).append("\n"); 
		query.append(",@[yrwk rev_port_etd_dt]		--AS REV_PORT_ETD_DT " ).append("\n"); 
		query.append(",@[jo_bsa_entr_rmk] 			--AS JO_BSA_ENTR_RMK      " ).append("\n"); 
		query.append(",@[jo_bsa_entr_rdr_rmk]			--AS JO_BSA_ENTR_RDR_RMK  " ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}