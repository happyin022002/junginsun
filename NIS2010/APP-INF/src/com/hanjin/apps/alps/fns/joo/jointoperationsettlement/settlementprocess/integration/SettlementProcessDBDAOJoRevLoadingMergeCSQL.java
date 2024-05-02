/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SettlementProcessDBDAOJoRevLoadingMergeCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.18
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.03.18 민정호
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

public class SettlementProcessDBDAOJoRevLoadingMergeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Jo Rev Loading 정보를 입력한다.
	  * </pre>
	  */
	public SettlementProcessDBDAOJoRevLoadingMergeCSQL(){
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
		params.put("ovr_usd_sto_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dg_cntr_stl_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_clz_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rmk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grand_ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grand_ttl_slot",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ovr_usd_slt_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_20_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : SettlementProcessDBDAOJoRevLoadingMergeCSQL").append("\n"); 
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
		query.append("MERGE INTO JOO_LODG_TGT A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         @[rev_yrmon]			AS REV_YRMON                                    " ).append("\n"); 
		query.append("        ,@[rev_yrmon_seq]		AS REV_YRMON_SEQ              " ).append("\n"); 
		query.append("        ,@[trd_cd] 				AS TRD_CD                                       " ).append("\n"); 
		query.append("        ,@[crr_cd] 				AS CRR_CD                                       " ).append("\n"); 
		query.append("        ,@[rlane_cd] 			AS RLANE_CD                                     " ).append("\n"); 
		query.append("        ,'R'					AS RE_DIVR_CD                                   " ).append("\n"); 
		query.append("        ,@[vsl_cd] 				AS VSL_CD                                       " ).append("\n"); 
		query.append("        ,@[skd_voy_no]			AS SKD_VOY_NO                                   " ).append("\n"); 
		query.append("        ,@[skd_dir_cd] 			AS SKD_DIR_CD                                   " ).append("\n"); 
		query.append("        ,@[vps_port_cd] 		AS VPS_PORT_CD                                  " ).append("\n"); 
		query.append("  --    ,yd_cd 					AS YD_CD                                        " ).append("\n"); 
		query.append("        ,@[clpt_ind_seq] 		AS CLPT_IND_SEQ                " ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        A.REV_YRMON     = B.REV_YRMON " ).append("\n"); 
		query.append("    AND A.REV_YRMON_SEQ = B.REV_YRMON_SEQ  " ).append("\n"); 
		query.append("    AND A.RE_DIVR_CD    = 'R'" ).append("\n"); 
		query.append("    AND A.REV_YRMON_SEQ = B.REV_YRMON_SEQ  " ).append("\n"); 
		query.append("    AND A.TRD_CD        = B.TRD_CD  " ).append("\n"); 
		query.append("    AND A.CRR_CD        = B.CRR_CD  " ).append("\n"); 
		query.append("    AND A.RLANE_CD      = B.RLANE_CD  " ).append("\n"); 
		query.append("    AND A.RE_DIVR_CD    = B.RE_DIVR_CD  " ).append("\n"); 
		query.append("    AND A.VSL_CD        = B.VSL_CD  " ).append("\n"); 
		query.append("    AND A.SKD_VOY_NO    = B.SKD_VOY_NO  " ).append("\n"); 
		query.append("    AND A.SKD_DIR_CD    = B.SKD_DIR_CD  " ).append("\n"); 
		query.append("    AND A.VPS_PORT_CD   = B.VPS_PORT_CD  " ).append("\n"); 
		query.append("--    AND A.YD_CD         = B.YD_CD" ).append("\n"); 
		query.append("    AND A.CLPT_IND_SEQ  = B.CLPT_IND_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("        SET " ).append("\n"); 
		query.append("             STL_TGT_FLG			    = @[stl_tgt_flg]" ).append("\n"); 
		query.append("            ,STL_CLZ_FLG 			    = @[stl_clz_flg] 			" ).append("\n"); 
		query.append("            ,ALOC_TEU_KNT				= @[all_teu] 			                          " ).append("\n"); 
		query.append("            ,ALOC_TEU_WGT             = @[all_wgt] 			             " ).append("\n"); 
		query.append("            ,TTL_USD_TEU_KNT          = @[grand_ttl_slot] 		             " ).append("\n"); 
		query.append("            ,TTL_USD_TEU_WGT          = @[grand_ttl_wgt] 		             " ).append("\n"); 
		query.append("            ,OVR_USD_SLT_TEU_KNT      = @[ovr_usd_slt_teu_knt]              " ).append("\n"); 
		query.append("            ,OVR_USD_SLT_WGT          = @[ovr_usd_slt_wgt] 	             " ).append("\n"); 
		query.append("            ,FX_OVR_USD_SLT_TEU_KNT   = @[over_slot_c] 		             " ).append("\n"); 
		query.append("            ,FX_OVR_USD_SLT_TEU_WGT   = @[over_wgt_c] 			             " ).append("\n"); 
		query.append("            ,MCNTR_TEU_KNT    	  		= @[mcntr_teu_knt] 		" ).append("\n"); 
		query.append("            ,MCNTR_WGT         	  		= @[mcntr_wgt] 			" ).append("\n"); 
		query.append("            ,OVR_USD_STO_TP_CD     		= @[ovr_usd_sto_tp_cd] 	" ).append("\n"); 
		query.append("            ,FNL_OVR_USD_SLT_KNT      = @[fin_used] 			             " ).append("\n"); 
		query.append("            ,RF_CNTR_20FT_KNT         = @[rf_20_qty] 			             " ).append("\n"); 
		query.append("            ,RF_CNTR_40FT_KNT         = @[rf_40_qty] 			             " ).append("\n"); 
		query.append("            ,RF_CNTR_SMRY_KNT         = @[rf_rdr_qty] 			             " ).append("\n"); 
		query.append("            ,FCNTR_20FT_KNT           = @[full_20] 			             " ).append("\n"); 
		query.append("            ,MCNTR_20FT_KNT           = @[mt_20] 				             " ).append("\n"); 
		query.append("            ,FCNTR_40FT_KNT           = @[full_40] 			             " ).append("\n"); 
		query.append("            ,MCNTR_40FT_KNT           = @[mt_40] 				             " ).append("\n"); 
		query.append("            ,HC_FCNTR_20FT_KNT        = @[hc_ld_20] 			             " ).append("\n"); 
		query.append("            ,HC_MCNTR_20FT_KNT        = @[hc_bsa_20] 			             " ).append("\n"); 
		query.append("            ,HC_FCNTR_40FT_KNT        = @[hc_ld_40] 			             " ).append("\n"); 
		query.append("            ,HC_MCNTR_40FT_KNT        = @[hc_bsa_40] 			             " ).append("\n"); 
		query.append("            ,FCNTR_45FT_KNT           = @[hc_ld_45] 			             " ).append("\n"); 
		query.append("            ,MCNTR_45FT_KNT           = @[hc_bsa_45] 			             " ).append("\n"); 
		query.append("            ,AWK_FCNTR_KNT            = @[ak_unit] 			             " ).append("\n"); 
		query.append("            ,AWK_MCNTR_KNT            = @[ak_void] 			             " ).append("\n"); 
		query.append("            ,DG_FCNTR_KNT             = @[dg_20] 				             " ).append("\n"); 
		query.append("            ,DG_MCNTR_KNT             = @[dg_40] 				" ).append("\n"); 
		query.append("            ,UPD_DT 				 	= SYSDATE" ).append("\n"); 
		query.append("            ,UPD_USR_ID 				= @[upd_usr_id] 			" ).append("\n"); 
		query.append("            ,JO_STL_RMK_CD			= @[rmk_flg]" ).append("\n"); 
		query.append("            ,JO_STL_RMK				= @[rmk]        " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("     INSERT" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("         REV_YRMON " ).append("\n"); 
		query.append("        ,REV_YRMON_SEQ " ).append("\n"); 
		query.append("        ,TRD_CD " ).append("\n"); 
		query.append("        ,CRR_CD " ).append("\n"); 
		query.append("        ,RLANE_CD " ).append("\n"); 
		query.append("        ,RE_DIVR_CD " ).append("\n"); 
		query.append("        ,VSL_CD " ).append("\n"); 
		query.append("        ,SKD_VOY_NO " ).append("\n"); 
		query.append("        ,SKD_DIR_CD " ).append("\n"); 
		query.append("        ,VPS_PORT_CD " ).append("\n"); 
		query.append("        ,YD_CD " ).append("\n"); 
		query.append("        ,CLPT_IND_SEQ " ).append("\n"); 
		query.append("        ,RF_SCG_STL_TP_CD 	--" ).append("\n"); 
		query.append("        ,SLAN_CD 				--" ).append("\n"); 
		query.append("        ,RDR_FLG " ).append("\n"); 
		query.append("        ,VPS_ETD_DT " ).append("\n"); 
		query.append("        ,ACCT_CD " ).append("\n"); 
		query.append("        ,JO_STL_JB_CD " ).append("\n"); 
		query.append("        ,JO_STL_STS_CD " ).append("\n"); 
		query.append("        ,STL_TGT_FLG " ).append("\n"); 
		query.append("        ,STL_CLZ_FLG 			--" ).append("\n"); 
		query.append("        ,STL_OVR_USD_SLT_CLZ_FLG	--" ).append("\n"); 
		query.append("        ,STL_RF_CLZ_FLG			--" ).append("\n"); 
		query.append("        ,STL_DG_CLZ_FLG 			--" ).append("\n"); 
		query.append("        ,ALOC_TEU_KNT " ).append("\n"); 
		query.append("        ,ALOC_TEU_WGT " ).append("\n"); 
		query.append("        ,TTL_USD_TEU_KNT " ).append("\n"); 
		query.append("        ,TTL_USD_TEU_WGT " ).append("\n"); 
		query.append("        ,OVR_USD_SLT_TEU_KNT " ).append("\n"); 
		query.append("        ,OVR_USD_SLT_WGT " ).append("\n"); 
		query.append("        ,FX_OVR_USD_SLT_TEU_KNT " ).append("\n"); 
		query.append("        ,FX_OVR_USD_SLT_TEU_WGT " ).append("\n"); 
		query.append("        ,MCNTR_TEU_KNT " ).append("\n"); 
		query.append("        ,MCNTR_WGT " ).append("\n"); 
		query.append("        ,OVR_USD_STO_TP_CD " ).append("\n"); 
		query.append("        ,FNL_OVR_USD_SLT_KNT " ).append("\n"); 
		query.append("        ,RF_CNTR_20FT_KNT " ).append("\n"); 
		query.append("        ,RF_CNTR_40FT_KNT " ).append("\n"); 
		query.append("        ,RF_CNTR_SMRY_KNT " ).append("\n"); 
		query.append("        ,FCNTR_20FT_KNT " ).append("\n"); 
		query.append("        ,MCNTR_20FT_KNT " ).append("\n"); 
		query.append("        ,FCNTR_40FT_KNT " ).append("\n"); 
		query.append("        ,MCNTR_40FT_KNT " ).append("\n"); 
		query.append("        ,HC_FCNTR_20FT_KNT " ).append("\n"); 
		query.append("        ,HC_MCNTR_20FT_KNT " ).append("\n"); 
		query.append("        ,HC_FCNTR_40FT_KNT " ).append("\n"); 
		query.append("        ,HC_MCNTR_40FT_KNT " ).append("\n"); 
		query.append("        ,FCNTR_45FT_KNT " ).append("\n"); 
		query.append("        ,MCNTR_45FT_KNT " ).append("\n"); 
		query.append("        ,AWK_FCNTR_KNT " ).append("\n"); 
		query.append("        ,AWK_MCNTR_KNT " ).append("\n"); 
		query.append("        ,DG_FCNTR_KNT " ).append("\n"); 
		query.append("        ,DG_MCNTR_KNT " ).append("\n"); 
		query.append("        ,OVR_USD_SLT_TEU_CAPA " ).append("\n"); 
		query.append("        ,OVR_USD_SLT_PRC " ).append("\n"); 
		query.append("        ,OVR_USD_SLT_AMT " ).append("\n"); 
		query.append("        ,OVR_USD_SLT_RMK " ).append("\n"); 
		query.append("        ,RF_20FT_CNTR_STL_TEU_CAPA " ).append("\n"); 
		query.append("        ,RF_20FT_CNTR_STL_PRC " ).append("\n"); 
		query.append("        ,RF_20FT_CNTR_STL_AMT " ).append("\n"); 
		query.append("        ,RF_20FT_CNTR_STL_RMK " ).append("\n"); 
		query.append("        ,RF_40FT_CNTR_STL_TEU_CAPA " ).append("\n"); 
		query.append("        ,RF_40FT_CNTR_STL_PRC " ).append("\n"); 
		query.append("        ,RF_40FT_CNTR_STL_AMT " ).append("\n"); 
		query.append("        ,RF_40FT_CNTR_STL_RMK " ).append("\n"); 
		query.append("        ,DG_CNTR_STL_TEU_CAPA " ).append("\n"); 
		query.append("        ,DG_CNTR_STL_PRC " ).append("\n"); 
		query.append("        ,DG_CNTR_STL_AMT " ).append("\n"); 
		query.append("        ,DG_CNTR_STL_RMK " ).append("\n"); 
		query.append("        ,CRE_DT " ).append("\n"); 
		query.append("        ,CRE_USR_ID " ).append("\n"); 
		query.append("        ,UPD_DT " ).append("\n"); 
		query.append("        ,UPD_USR_ID " ).append("\n"); 
		query.append("        ,REV_DIR_CD" ).append("\n"); 
		query.append("        ,JO_STL_RMK_CD " ).append("\n"); 
		query.append("        ,JO_STL_RMK      " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     VALUES" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("         @[rev_yrmon]			-- AS REV_YRMON                                    " ).append("\n"); 
		query.append("        ,@[rev_yrmon_seq]		-- AS REV_YRMON_SEQ                               " ).append("\n"); 
		query.append("        ,@[trd_cd] 				-- AS TRD_CD                                       " ).append("\n"); 
		query.append("        ,@[crr_cd] 				-- AS CRR_CD                                       " ).append("\n"); 
		query.append("        ,@[rlane_cd] 			-- AS RLANE_CD                                     " ).append("\n"); 
		query.append("        ,@[re_divr_cd]			-- AS RE_DIVR_CD                                   " ).append("\n"); 
		query.append("        ,@[vsl_cd] 				-- AS VSL_CD                                       " ).append("\n"); 
		query.append("        ,@[skd_voy_no]			-- AS SKD_VOY_NO                                   " ).append("\n"); 
		query.append("        ,@[skd_dir_cd] 			-- AS SKD_DIR_CD                                   " ).append("\n"); 
		query.append("        ,@[vps_port_cd] 		-- AS VPS_PORT_CD                                  " ).append("\n"); 
		query.append("        ,@[yd_cd] 				-- AS YD_CD                                        " ).append("\n"); 
		query.append("        ,@[clpt_ind_seq] 		-- AS CLPT_IND_SEQ        " ).append("\n"); 
		query.append("        ,'T'					-- AS RF_SCG_STL_TP_CD 	" ).append("\n"); 
		query.append("        ,@[slan_cd]				-- AS SLAN_CD 				                         " ).append("\n"); 
		query.append("        ,@[rdr_flg] 			-- AS RDR_FLG                                      " ).append("\n"); 
		query.append("        ,TO_DATE(@[vps_etd_dt],'YYYYMMDDHH24MISS') -- AS VPS_ETD_DT                                   " ).append("\n"); 
		query.append("        ,@[acct_cd] 				-- AS ACCT_CD                                      " ).append("\n"); 
		query.append("        ,@[jo_stl_jb_cd] 			-- AS JO_STL_JB_CD                                 " ).append("\n"); 
		query.append("        ,@[jo_stl_sts_cd] 			-- AS JO_STL_STS_CD                                " ).append("\n"); 
		query.append("        ,@[stl_tgt_flg] 			-- AS STL_TGT_FLG         " ).append("\n"); 
		query.append("        ,@[stl_clz_flg] 			-- AS STL_CLZ_FLG 			--" ).append("\n"); 
		query.append("        ,@[stl_ovr_usd_slt_clz_flg] -- AS STL_OVR_USD_SLT_CLZ_FLG	--" ).append("\n"); 
		query.append("        ,@[stl_rf_clz_flg] 			-- AS STL_RF_CLZ_FLG			--" ).append("\n"); 
		query.append("        ,@[stl_dg_clz_flg] 			-- AS STL_DG_CLZ_FLG 			--                         " ).append("\n"); 
		query.append("        -----------------------------------------------" ).append("\n"); 
		query.append("        ,@[all_teu] 			-- AS ALOC_TEU_KNT                                 " ).append("\n"); 
		query.append("        ,@[all_wgt] 			-- AS ALOC_TEU_WGT                                 " ).append("\n"); 
		query.append("        ,@[grand_ttl_slot] 		-- AS TTL_USD_TEU_KNT                              " ).append("\n"); 
		query.append("        ,@[grand_ttl_wgt] 		-- AS TTL_USD_TEU_WGT                              " ).append("\n"); 
		query.append("        ,@[ovr_usd_slt_teu_knt] -- AS OVR_USD_SLT_TEU_KNT                          " ).append("\n"); 
		query.append("        ,@[ovr_usd_slt_wgt] 	-- AS OVR_USD_SLT_WGT                              " ).append("\n"); 
		query.append("        ,@[over_slot_c] 		-- AS FX_OVR_USD_SLT_TEU_KNT                       " ).append("\n"); 
		query.append("        ,@[over_wgt_c] 			-- AS FX_OVR_USD_SLT_TEU_WGT                       " ).append("\n"); 
		query.append("        ,@[mcntr_teu_knt] 		-- AS MCNTR_TEU_KNT    --                            " ).append("\n"); 
		query.append("        ,@[mcntr_wgt] 			-- AS MCNTR_WGT          --                          " ).append("\n"); 
		query.append("        ,@[ovr_usd_sto_tp_cd] 	-- AS OVR_USD_STO_TP_CD      --                       " ).append("\n"); 
		query.append("        ,@[fin_used] 			-- AS FNL_OVR_USD_SLT_KNT                          " ).append("\n"); 
		query.append("        ,@[rf_20_qty] 			-- AS RF_CNTR_20FT_KNT                             " ).append("\n"); 
		query.append("        ,@[rf_40_qty] 			-- AS RF_CNTR_40FT_KNT      " ).append("\n"); 
		query.append("        ,@[rf_rdr_qty] 			-- AS RF_CNTR_SMRY_KNT                             " ).append("\n"); 
		query.append("        ,@[full_20] 			-- AS FCNTR_20FT_KNT                               " ).append("\n"); 
		query.append("        ,@[mt_20] 				-- AS MCNTR_20FT_KNT                               " ).append("\n"); 
		query.append("        ,@[full_40] 			-- AS FCNTR_40FT_KNT                               " ).append("\n"); 
		query.append("        ,@[mt_40] 				-- AS MCNTR_40FT_KNT                               " ).append("\n"); 
		query.append("        ,@[hc_ld_20] 			-- AS HC_FCNTR_20FT_KNT                            " ).append("\n"); 
		query.append("        ,@[hc_bsa_20] 			-- AS HC_MCNTR_20FT_KNT                            " ).append("\n"); 
		query.append("        ,@[hc_ld_40] 			-- AS HC_FCNTR_40FT_KNT                            " ).append("\n"); 
		query.append("        ,@[hc_bsa_40] 			-- AS HC_MCNTR_40FT_KNT                            " ).append("\n"); 
		query.append("        ,@[hc_ld_45] 			-- AS FCNTR_45FT_KNT                               " ).append("\n"); 
		query.append("        ,@[hc_bsa_45] 			-- AS MCNTR_45FT_KNT                               " ).append("\n"); 
		query.append("        ,@[ak_unit] 			-- AS AWK_FCNTR_KNT                                " ).append("\n"); 
		query.append("        ,@[ak_void] 			-- AS AWK_MCNTR_KNT                                " ).append("\n"); 
		query.append("        ,@[dg_20] 				-- AS DG_FCNTR_KNT                                 " ).append("\n"); 
		query.append("        ,@[dg_40] 				-- AS DG_MCNTR_KNT  " ).append("\n"); 
		query.append("        -----------------------------------------------------" ).append("\n"); 
		query.append("        ,@[ovr_usd_slt_teu_capa] 		-- AS OVR_USD_SLT_TEU_CAPA                         " ).append("\n"); 
		query.append("        ,@[ovr_usd_slt_prc] 			-- AS OVR_USD_SLT_PRC                              " ).append("\n"); 
		query.append("        ,@[ovr_usd_slt_amt] 			-- AS OVR_USD_SLT_AMT                              " ).append("\n"); 
		query.append("        ,@[ovr_usd_slt_rmk] 			-- AS OVR_USD_SLT_RMK                              " ).append("\n"); 
		query.append("        ,@[rf_20ft_cntr_stl_teu_capa] 	-- AS RF_20FT_CNTR_STL_TEU_CAPA                    " ).append("\n"); 
		query.append("        ,@[rf_20ft_cntr_stl_prc] 		-- AS RF_20FT_CNTR_STL_PRC                         " ).append("\n"); 
		query.append("        ,@[rf_20ft_cntr_stl_amt] 		-- AS RF_20FT_CNTR_STL_AMT                         " ).append("\n"); 
		query.append("        ,@[rf_20ft_cntr_stl_rmk] 		-- AS RF_20FT_CNTR_STL_RMK                         " ).append("\n"); 
		query.append("        ,@[rf_40ft_cntr_stl_teu_capa] 	-- AS RF_40FT_CNTR_STL_TEU_CAPA                    " ).append("\n"); 
		query.append("        ,@[rf_40ft_cntr_stl_prc] 		-- AS RF_40FT_CNTR_STL_PRC                         " ).append("\n"); 
		query.append("        ,@[rf_40ft_cntr_stl_amt] 		-- AS RF_40FT_CNTR_STL_AMT                         " ).append("\n"); 
		query.append("        ,@[rf_40ft_cntr_stl_rmk] 		-- AS RF_40FT_CNTR_STL_RMK                         " ).append("\n"); 
		query.append("        ,@[dg_cntr_stl_teu_capa] 		-- AS DG_CNTR_STL_TEU_CAPA                         " ).append("\n"); 
		query.append("        ,@[dg_cntr_stl_prc] 			-- AS DG_CNTR_STL_PRC                              " ).append("\n"); 
		query.append("        ,@[dg_cntr_stl_amt] 			-- AS DG_CNTR_STL_AMT                              " ).append("\n"); 
		query.append("        ,@[dg_cntr_stl_rmk] 			-- AS DG_CNTR_STL_RMK                              " ).append("\n"); 
		query.append("        ,SYSDATE 						-- AS CRE_DT                                       " ).append("\n"); 
		query.append("        ,@[upd_usr_id] 					-- AS CRE_USR_ID                                   " ).append("\n"); 
		query.append("        ,SYSDATE 						-- AS UPD_DT                                       " ).append("\n"); 
		query.append("        ,@[upd_usr_id] 					-- AS UPD_USR_ID                                   " ).append("\n"); 
		query.append("        ,@[rev_dir_cd]					-- AS REV_DIR_CD" ).append("\n"); 
		query.append("        ,@[rmk_flg]						-- AS JO_STL_RMK_CD " ).append("\n"); 
		query.append("        ,@[rmk]							-- AS JO_STL_RMK      " ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}