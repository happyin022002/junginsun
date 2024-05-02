/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOJooSettlementVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOJooSettlementVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOJooSettlementVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_bsa_qty_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmb_cfm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_slt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_bzc_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_lst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("uc_bss_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sail_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_dup_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_per_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sconti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_bsa_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_slt_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_tj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_scg_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_stl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_bss_port_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_adj_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_bsa_slt_prc_locl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("st_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fnl_own_bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOJooSettlementVOCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_SETTLEMENT (" ).append("\n"); 
		query.append("   ACCT_YRMON" ).append("\n"); 
		query.append("  ,STL_VVD_SEQ" ).append("\n"); 
		query.append("  ,STL_SEQ" ).append("\n"); 
		query.append("  ,TRD_CD" ).append("\n"); 
		query.append("  ,JO_CRR_CD" ).append("\n"); 
		query.append("  ,RLANE_CD" ).append("\n"); 
		query.append("  ,RE_DIVR_CD" ).append("\n"); 
		query.append("  ,JO_STL_ITM_CD" ).append("\n"); 
		query.append("  ,JO_MNU_NM" ).append("\n"); 
		query.append("  ,VSL_CD" ).append("\n"); 
		query.append("  ,SKD_VOY_NO" ).append("\n"); 
		query.append("  ,SKD_DIR_CD" ).append("\n"); 
		query.append("  ,REV_DIR_CD" ).append("\n"); 
		query.append("  ,STL_BZC_PORT_CD" ).append("\n"); 
		query.append("  ,ETA_DT" ).append("\n"); 
		query.append("  ,JO_STL_JB_CD" ).append("\n"); 
		query.append("  ,BSA_QTY" ).append("\n"); 
		query.append("  ,BSA_SLT_PRC" ).append("\n"); 
		query.append("  ,LOCL_CURR_CD" ).append("\n"); 
		query.append("  ,ADJ_BSA_QTY_LOCL_AMT" ).append("\n"); 
		query.append("  ,ADJ_BSA_SLT_PRC_LOCL_AMT" ).append("\n"); 
		query.append("  ,STL_LOCL_AMT" ).append("\n"); 
		query.append("  ,STL_USD_AMT" ).append("\n"); 
		query.append("  ,IOC_CD" ).append("\n"); 
		query.append("  ,SCONTI_CD" ).append("\n"); 
		query.append("  ,FNL_OWN_BSA_QTY" ).append("\n"); 
		query.append("  ,FNL_BSA_WGT" ).append("\n"); 
		query.append("  ,USD_SLT_BSA_QTY" ).append("\n"); 
		query.append("  ,USD_SLT_WGT" ).append("\n"); 
		query.append("  ,BSA_PER_WGT" ).append("\n"); 
		query.append("  ,FM_PORT_CD" ).append("\n"); 
		query.append("  ,TO_PORT_CD" ).append("\n"); 
		query.append("  ,RF_SCG_STL_TP_CD" ).append("\n"); 
		query.append("  ,RF_SCG_PRC" ).append("\n"); 
		query.append("  ,STL_RMK" ).append("\n"); 
		query.append("  ,CMB_CFM_FLG" ).append("\n"); 
		query.append("  ,STL_TJ_NO" ).append("\n"); 
		query.append("  ,STL_ADJ_FLG" ).append("\n"); 
		query.append("  ,PRE_ACCT_YRMON" ).append("\n"); 
		query.append("  ,PRE_STL_VVD_SEQ" ).append("\n"); 
		query.append("  ,PRE_STL_SEQ" ).append("\n"); 
		query.append("  ,STL_LST_FLG" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UC_BSS_PORT_CD" ).append("\n"); 
		query.append("  ,UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("  ,STL_DUP_FLG" ).append("\n"); 
		query.append("  ,ST_DT" ).append("\n"); 
		query.append("  ,END_DT" ).append("\n"); 
		query.append("  ,SAIL_DYS" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("   REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("  ,@[stl_vvd_seq]" ).append("\n"); 
		query.append("  ,NVL((SELECT /*+INDEX_DESC(A XPKJOO_SETTLEMENT)*/ A.STL_SEQ + 1 FROM JOO_SETTLEMENT A WHERE  A.ACCT_YRMON = REPLACE(@[acct_yrmon],'-','') AND A.STL_VVD_SEQ = @[stl_vvd_seq] AND ROWNUM = 1),1)" ).append("\n"); 
		query.append("  ,@[trd_cd]" ).append("\n"); 
		query.append("  ,@[jo_crr_cd]" ).append("\n"); 
		query.append("  ,@[rlane_cd]" ).append("\n"); 
		query.append("  ,@[re_divr_cd]" ).append("\n"); 
		query.append("  ,@[jo_stl_itm_cd]" ).append("\n"); 
		query.append("  ,@[jo_mnu_nm]" ).append("\n"); 
		query.append("  ,@[vsl_cd]" ).append("\n"); 
		query.append("  ,@[skd_voy_no]" ).append("\n"); 
		query.append("  ,@[skd_dir_cd]" ).append("\n"); 
		query.append("  ,@[rev_dir_cd]" ).append("\n"); 
		query.append("  ,@[stl_bzc_port_cd]" ).append("\n"); 
		query.append("  ,TO_DATE(@[eta_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("  ,@[jo_stl_jb_cd]" ).append("\n"); 
		query.append("  ,@[bsa_qty]" ).append("\n"); 
		query.append("  ,@[bsa_slt_prc]" ).append("\n"); 
		query.append("  ,@[locl_curr_cd]" ).append("\n"); 
		query.append("  ,@[adj_bsa_qty_locl_amt]" ).append("\n"); 
		query.append("  ,@[adj_bsa_slt_prc_locl_amt]" ).append("\n"); 
		query.append("  ,DECODE(@[re_divr_cd],'R',ROUND(@[stl_locl_amt], (SELECT DP_PRCS_KNT FROM MDM_CURRENCY WHERE CURR_CD = @[locl_curr_cd])), @[stl_locl_amt])" ).append("\n"); 
		query.append("  ,@[stl_usd_amt]" ).append("\n"); 
		query.append("  ,@[ioc_cd]" ).append("\n"); 
		query.append("  ,@[sconti_cd]" ).append("\n"); 
		query.append("  ,@[fnl_own_bsa_qty]" ).append("\n"); 
		query.append("  ,@[fnl_bsa_wgt]" ).append("\n"); 
		query.append("  ,@[usd_slt_bsa_qty]" ).append("\n"); 
		query.append("  ,@[usd_slt_wgt]" ).append("\n"); 
		query.append("  ,@[bsa_per_wgt]" ).append("\n"); 
		query.append("  ,@[fm_port_cd]" ).append("\n"); 
		query.append("  ,@[to_port_cd]" ).append("\n"); 
		query.append("  ,@[rf_scg_stl_tp_cd]" ).append("\n"); 
		query.append("  ,@[rf_scg_prc]" ).append("\n"); 
		query.append("  ,@[stl_rmk]" ).append("\n"); 
		query.append("  ,NVL(@[cmb_cfm_flg],'N')" ).append("\n"); 
		query.append("  ,@[stl_tj_no]" ).append("\n"); 
		query.append("  ,NVL(@[stl_adj_flg],'N')" ).append("\n"); 
		query.append("  ,@[pre_acct_yrmon]" ).append("\n"); 
		query.append("  ,@[pre_stl_vvd_seq]" ).append("\n"); 
		query.append("  ,@[pre_stl_seq]" ).append("\n"); 
		query.append("  ,NVL(@[stl_lst_flg],'Y')" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,SYSDATE" ).append("\n"); 
		query.append("  ,@[cre_usr_id]" ).append("\n"); 
		query.append("  ,@[uc_bss_port_cd]" ).append("\n"); 
		query.append("  ,TO_DATE(@[uc_bss_port_etd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("  ,NVL(@[stl_dup_flg],'N')" ).append("\n"); 
		query.append("  ,TO_DATE(@[st_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  ,TO_DATE(@[end_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("  ,@[sail_dys]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}