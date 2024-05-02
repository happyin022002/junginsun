/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOPriScgPrfVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
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

public class SurchargeDBDAOPriScgPrfVOUSQL implements ISQLTemplate{

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
	public SurchargeDBDAOPriScgPrfVOUSQL(){
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
		params.put("ts_port_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : SurchargeDBDAOPriScgPrfVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SCG_PRF SET " ).append("\n"); 
		query.append("	   FLT_PCT_TP_CD = @[flt_pct_tp_cd]" ).append("\n"); 
		query.append("	 , PCT_BSE_CD = @[pct_bse_cd]" ).append("\n"); 
		query.append("	 , SUB_TRD_USE_FLG = NVL(@[sub_trd_use_flg], 'N')" ).append("\n"); 
		query.append("	 , SLAN_USE_FLG = NVL(@[slan_use_flg], 'N')" ).append("\n"); 
		query.append("	 , POR_USE_FLG = NVL(@[por_use_flg], 'N')" ).append("\n"); 
		query.append("	 , POL_USE_FLG = NVL(@[pol_use_flg], 'N')" ).append("\n"); 
		query.append("	 , POD_USE_FLG = NVL(@[pod_use_flg], 'N')" ).append("\n"); 
		query.append("	 , DEL_USE_FLG = NVL(@[del_use_flg], 'N')" ).append("\n"); 
		query.append("	 , IMDG_CLSS_USE_FLG = NVL(@[imdg_clss_use_flg], 'N')" ).append("\n"); 
		query.append("     , CNL_TZ_FLG = NVL(@[cnl_tz_flg], 'N')" ).append("\n"); 
		query.append("	 , TS_PORT_USE_FLG = NVL(@[ts_port_use_flg], 'N')" ).append("\n"); 
		query.append("	 , TML_USE_FLG = NVL(@[tml_use_flg], 'N')" ).append("\n"); 
		query.append("	 , TRNS_MOD_USE_FLG = NVL(@[trns_mod_use_flg], 'N')" ).append("\n"); 
		query.append("	 , USA_SVC_MOD_USE_FLG = NVL(@[usa_svc_mod_use_flg], 'N')" ).append("\n"); 
		query.append("	 , RCV_DE_TERM_USE_FLG = NVL(@[rcv_de_term_use_flg], 'N')" ).append("\n"); 
		query.append("	 , HNGR_BAR_USE_FLG = NVL(@[hngr_bar_use_flg], 'N')" ).append("\n"); 
		query.append("	 , DIR_CALL_USE_FLG = NVL(@[dir_call_use_flg], 'N')" ).append("\n"); 
		query.append("	 , CGO_WGT_USE_FLG = NVL(@[cgo_wgt_use_flg], 'N')" ).append("\n"); 
		query.append("	 , CMDT_USE_FLG = NVL(@[cmdt_use_flg], 'N')" ).append("\n"); 
		query.append("	 , GRI_CMDT_USE_FLG = NVL(@[gri_cmdt_use_flg], 'N')" ).append("\n"); 
		query.append("	 , SOC_USE_FLG = NVL(@[soc_use_flg], 'N')" ).append("\n"); 
		query.append("	 , IO_GA_USE_FLG = NVL(@[io_ga_use_flg], 'N')" ).append("\n"); 
		query.append("	 , CRTE_DY_KNT_USE_FLG = NVL(@[crte_dy_knt_use_flg], 'N')" ).append("\n"); 
		query.append("	 , PRD_CRTE_TP_USE_FLG = NVL(@[prd_crte_tp_use_flg], 'N')" ).append("\n"); 
		query.append("	 , PRD_CRTE_USE_FLG = NVL(@[prd_crte_use_flg], 'N')" ).append("\n"); 
		query.append("	 , PSA_NO_MNG_FLG = NVL(@[psa_no_mng_flg], 'N')" ).append("\n"); 
		query.append("     , RC_AIR_COND_TP_USE_FLG = NVL(@[rc_air_cond_tp_use_flg], 'N')" ).append("\n"); 
		query.append("     , CTRT_DT_USE_FLG = NVL(@[ctrt_dt_use_flg], 'N')" ).append("\n"); 
		query.append("     , ACT_RAT_USE_FLG = NVL(@[act_rat_use_flg], 'N')" ).append("\n"); 
		query.append("     , PRN_HDN_USE_FLG = NVL(@[prn_hdn_use_flg], 'N')" ).append("\n"); 
		query.append("     , FD_GRD_USE_FLG = NVL(@[fd_grd_use_flg], 'N')" ).append("\n"); 
		query.append("     , STE_USE_FLG = NVL(@[ste_use_flg], 'N')" ).append("\n"); 
		query.append("     , ARR_DT_USE_FLG = NVL(@[arr_dt_use_flg], 'N')" ).append("\n"); 
		query.append("	 , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD IN (SELECT SVC_SCP_CD FROM PRI_SCG_TRD_SVC_SCP_MAPG WHERE TRD_CD = @[trd_cd])" ).append("\n"); 
		query.append("   AND CHG_CD = @[chg_cd]" ).append("\n"); 

	}
}