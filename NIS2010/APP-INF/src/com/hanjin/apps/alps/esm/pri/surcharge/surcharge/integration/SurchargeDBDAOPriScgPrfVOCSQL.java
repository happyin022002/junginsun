/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOPriScgPrfVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOPriScgPrfVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2013.03.07 전윤주 [CHM-201323465] Reefer condition type 추가
	  * 2013.04.17 전윤주 [CHM-201324203] Contract date 추가
	  * 2013.10.01 전윤주 [CHM-201326927] MDM rating flag와 연계하여 Auto 항목 추가
	  * 2013.10.01 전윤주 [CHM-201326929] BL Printing시 숨길 수 있는 Hide 항목 추가
	  * 2014.03.20 전윤주 [CHM-201429456] Food Grade 항목 추가
	  * 2014.04.10 전윤주 [CHM-201429656] State code 항목 추가
	  * 2015.04.10 전지예 [CHM-201535041] Arrival Date 항목 추가
	  * </pre>
	  */
	public SurchargeDBDAOPriScgPrfVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_ga_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_mod_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gri_cmdt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rat_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dir_call_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pct_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_port_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_air_cond_tp_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_dt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prd_crte_tp_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_bar_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_dt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_svc_mod_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_no_mng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crte_dy_knt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fd_grd_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_de_term_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_pct_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prd_crte_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_hdn_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgPrfVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCG_PRF (" ).append("\n"); 
		query.append("	   SVC_SCP_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("     , FLT_PCT_TP_CD" ).append("\n"); 
		query.append("     , PCT_BSE_CD" ).append("\n"); 
		query.append("	 , POR_USE_FLG" ).append("\n"); 
		query.append("     , POL_USE_FLG" ).append("\n"); 
		query.append("     , POD_USE_FLG" ).append("\n"); 
		query.append("     , DEL_USE_FLG" ).append("\n"); 
		query.append("	 , RCV_DE_TERM_USE_FLG" ).append("\n"); 
		query.append("	 , IMDG_CLSS_USE_FLG" ).append("\n"); 
		query.append("	 , CNL_TZ_FLG" ).append("\n"); 
		query.append("	 , CGO_WGT_USE_FLG" ).append("\n"); 
		query.append("	 , TRNS_MOD_USE_FLG" ).append("\n"); 
		query.append("     , HNGR_BAR_USE_FLG" ).append("\n"); 
		query.append("     , SUB_TRD_USE_FLG" ).append("\n"); 
		query.append("     , SLAN_USE_FLG" ).append("\n"); 
		query.append("     , DIR_CALL_USE_FLG     " ).append("\n"); 
		query.append("     , TML_USE_FLG" ).append("\n"); 
		query.append("     , CMDT_USE_FLG" ).append("\n"); 
		query.append("     , IO_GA_USE_FLG" ).append("\n"); 
		query.append("     , TS_PORT_USE_FLG" ).append("\n"); 
		query.append("     , SOC_USE_FLG" ).append("\n"); 
		query.append("     , GRI_CMDT_USE_FLG     " ).append("\n"); 
		query.append("     , USA_SVC_MOD_USE_FLG" ).append("\n"); 
		query.append("     , CRTE_DY_KNT_USE_FLG" ).append("\n"); 
		query.append("     , PRD_CRTE_TP_USE_FLG" ).append("\n"); 
		query.append("     , PRD_CRTE_USE_FLG" ).append("\n"); 
		query.append("	 , PSA_NO_MNG_FLG" ).append("\n"); 
		query.append("     , RC_AIR_COND_TP_USE_FLG" ).append("\n"); 
		query.append("     , CTRT_DT_USE_FLG" ).append("\n"); 
		query.append("     , ACT_RAT_USE_FLG" ).append("\n"); 
		query.append("     , PRN_HDN_USE_FLG" ).append("\n"); 
		query.append("     , FD_GRD_USE_FLG" ).append("\n"); 
		query.append("     , STE_USE_FLG" ).append("\n"); 
		query.append("     , ARR_DT_USE_FLG" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , UPD_USR_ID" ).append("\n"); 
		query.append(") SELECT" ).append("\n"); 
		query.append("	   SVC_SCP_CD" ).append("\n"); 
		query.append("     , @[chg_cd]" ).append("\n"); 
		query.append("     , @[flt_pct_tp_cd]" ).append("\n"); 
		query.append("     , @[pct_bse_cd]" ).append("\n"); 
		query.append("	 , DECODE(@[por_use_flg], NULL, 'N', @[por_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[pol_use_flg], NULL, 'N', @[pol_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[pod_use_flg], NULL, 'N', @[pod_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[del_use_flg], NULL, 'N', @[del_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[rcv_de_term_use_flg], NULL, 'N', @[rcv_de_term_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[imdg_clss_use_flg], NULL, 'N', @[imdg_clss_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[cnl_tz_flg], NULL, 'N', @[cnl_tz_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[cgo_wgt_use_flg], NULL, 'N', @[cgo_wgt_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[trns_mod_use_flg], NULL, 'N', @[trns_mod_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[hngr_bar_use_flg], NULL, 'N', @[hngr_bar_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[sub_trd_use_flg], NULL, 'N', @[sub_trd_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[slan_use_flg], NULL, 'N', @[slan_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[dir_call_use_flg], NULL, 'N', @[dir_call_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[tml_use_flg], NULL, 'N', @[tml_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[cmdt_use_flg], NULL, 'N', @[cmdt_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[io_ga_use_flg], NULL, 'N', @[io_ga_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[ts_port_use_flg], NULL, 'N', @[ts_port_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[soc_use_flg], NULL, 'N', @[soc_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[gri_cmdt_use_flg], NULL, 'N', @[gri_cmdt_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[usa_svc_mod_use_flg], NULL, 'N', @[usa_svc_mod_use_flg])   " ).append("\n"); 
		query.append("     , DECODE(@[crte_dy_knt_use_flg], NULL, 'N', @[crte_dy_knt_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[prd_crte_tp_use_flg], NULL, 'N', @[prd_crte_tp_use_flg])" ).append("\n"); 
		query.append("     , DECODE(@[prd_crte_use_flg], NULL, 'N', @[prd_crte_use_flg])" ).append("\n"); 
		query.append("	 , DECODE(@[psa_no_mng_flg], NULL, 'N', @[psa_no_mng_flg])" ).append("\n"); 
		query.append("     , DECODE(@[rc_air_cond_tp_use_flg], NULL, 'N', @[rc_air_cond_tp_use_flg])" ).append("\n"); 
		query.append("     , DECODE(@[ctrt_dt_use_flg], NULL, 'N', @[ctrt_dt_use_flg])" ).append("\n"); 
		query.append("     , DECODE(@[act_rat_use_flg], NULL, 'N', @[act_rat_use_flg])" ).append("\n"); 
		query.append("     , DECODE(@[prn_hdn_use_flg], NULL, 'N', @[prn_hdn_use_flg])" ).append("\n"); 
		query.append("     , DECODE(@[fd_grd_use_flg], NULL, 'N', @[fd_grd_use_flg])" ).append("\n"); 
		query.append("     , DECODE(@[ste_use_flg], NULL, 'N', @[ste_use_flg])" ).append("\n"); 
		query.append("     , DECODE(@[arr_dt_use_flg], NULL, 'N', @[arr_dt_use_flg])" ).append("\n"); 
		query.append("	 , @[cre_usr_id]" ).append("\n"); 
		query.append("	 , @[upd_usr_id]" ).append("\n"); 
		query.append("	FROM PRI_SCG_TRD_SVC_SCP_MAPG MAPG" ).append("\n"); 
		query.append("	WHERE TRD_CD = @[trd_cd] " ).append("\n"); 
		query.append("	AND NOT EXISTS (SELECT  'Y' FROM PRI_SCG_PRF AA WHERE AA.SVC_SCP_CD = MAPG.SVC_SCP_CD AND AA.CHG_CD = @[chg_cd])" ).append("\n"); 

	}
}