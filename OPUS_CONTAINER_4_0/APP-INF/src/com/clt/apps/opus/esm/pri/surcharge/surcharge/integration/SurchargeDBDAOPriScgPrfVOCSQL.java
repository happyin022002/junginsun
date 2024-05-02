/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeDBDAOPriScgPrfVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.21
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.12.21 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JaeYeon Kim
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
	  *    
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
		params.put("cgo_wgt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
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
		query.append("SVC_SCP_CD" ).append("\n"); 
		query.append(", CHG_CD" ).append("\n"); 
		query.append(", FLT_PCT_TP_CD" ).append("\n"); 
		query.append(", PCT_BSE_CD" ).append("\n"); 
		query.append(", POR_USE_FLG" ).append("\n"); 
		query.append(", POL_USE_FLG" ).append("\n"); 
		query.append(", POD_USE_FLG" ).append("\n"); 
		query.append(", DEL_USE_FLG" ).append("\n"); 
		query.append(", RCV_DE_TERM_USE_FLG" ).append("\n"); 
		query.append(", IMDG_CLSS_USE_FLG" ).append("\n"); 
		query.append(", CNL_TZ_FLG" ).append("\n"); 
		query.append(", CGO_WGT_USE_FLG" ).append("\n"); 
		query.append(", TRNS_MOD_USE_FLG" ).append("\n"); 
		query.append(", HNGR_BAR_USE_FLG" ).append("\n"); 
		query.append(", SUB_TRD_USE_FLG" ).append("\n"); 
		query.append(", SLAN_USE_FLG" ).append("\n"); 
		query.append(", DIR_CALL_USE_FLG" ).append("\n"); 
		query.append(", TML_USE_FLG" ).append("\n"); 
		query.append(", CMDT_USE_FLG" ).append("\n"); 
		query.append(", IO_GA_USE_FLG" ).append("\n"); 
		query.append(", TS_PORT_USE_FLG" ).append("\n"); 
		query.append(", SOC_USE_FLG" ).append("\n"); 
		query.append(", GRI_CMDT_USE_FLG" ).append("\n"); 
		query.append(", USA_SVC_MOD_USE_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[svc_scp_cd]" ).append("\n"); 
		query.append(", @[chg_cd]" ).append("\n"); 
		query.append(", @[flt_pct_tp_cd]" ).append("\n"); 
		query.append(", @[pct_bse_cd]" ).append("\n"); 
		query.append(", DECODE(@[por_use_flg], NULL, 'N', @[por_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[pol_use_flg], NULL, 'N', @[pol_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[pod_use_flg], NULL, 'N', @[pod_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[del_use_flg], NULL, 'N', @[del_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[rcv_de_term_use_flg], NULL, 'N', @[rcv_de_term_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[imdg_clss_use_flg], NULL, 'N', @[imdg_clss_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[cnl_tz_flg], NULL, 'N', @[cnl_tz_flg])" ).append("\n"); 
		query.append(", DECODE(@[cgo_wgt_use_flg], NULL, 'N', @[cgo_wgt_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[trns_mod_use_flg], NULL, 'N', @[trns_mod_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[hngr_bar_use_flg], NULL, 'N', @[hngr_bar_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[sub_trd_use_flg], NULL, 'N', @[sub_trd_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[slan_use_flg], NULL, 'N', @[slan_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[dir_call_use_flg], NULL, 'N', @[dir_call_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[tml_use_flg], NULL, 'N', @[tml_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[cmdt_use_flg], NULL, 'N', @[cmdt_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[io_ga_use_flg], NULL, 'N', @[io_ga_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[ts_port_use_flg], NULL, 'N', @[ts_port_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[soc_use_flg], NULL, 'N', @[soc_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[gri_cmdt_use_flg], NULL, 'N', @[gri_cmdt_use_flg])" ).append("\n"); 
		query.append(", DECODE(@[usa_svc_mod_use_flg], NULL, 'N', @[usa_svc_mod_use_flg])" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}