/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SurchargeDBDAOChkPriScgRtExcelVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.12.19 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surcharge.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHLOE MIJIN SEO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeDBDAOChkPriScgRtExcelVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SurchargeDBDAOChkPriScgRtVORSQL
	  * </pre>
	  */
	public SurchargeDBDAOChkPriScgRtExcelVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_call_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_ga_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_tz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("min_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOChkPriScgRtExcelVORSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("  FROM PRI_SCG_RT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("#if (${scg_seq} !='')" ).append("\n"); 
		query.append("	AND SCG_SEQ <> @[scg_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${por_def_cd} != '')" ).append("\n"); 
		query.append("   AND POR_DEF_CD = @[por_def_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND POR_DEF_CD IS NULL   " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_def_cd} != '')" ).append("\n"); 
		query.append("   AND POL_DEF_CD = @[pol_def_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND POL_DEF_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_def_cd} != '')" ).append("\n"); 
		query.append("   AND POD_DEF_CD = @[pod_def_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND POD_DEF_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_def_cd} != '')" ).append("\n"); 
		query.append("   AND DEL_DEF_CD = @[del_def_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND DEL_DEF_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND RAT_UT_CD = @[rat_ut_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${prc_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("   AND PRC_CGO_TP_CD = @[prc_cgo_tp_cd] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PRC_CGO_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_imdg_clss_cd} != '')" ).append("\n"); 
		query.append("   AND SCG_IMDG_CLSS_CD = @[scg_imdg_clss_cd] " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SCG_IMDG_CLSS_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pay_term_cd} != '')" ).append("\n"); 
		query.append("   AND PAY_TERM_CD = @[pay_term_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PAY_TERM_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnl_tz_cd} != '')" ).append("\n"); 
		query.append("   AND CNL_TZ_CD = @[cnl_tz_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND CNL_TZ_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${min_cgo_wgt} != '')" ).append("\n"); 
		query.append("   AND MIN_CGO_WGT = @[min_cgo_wgt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND MIN_CGO_WGT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${max_cgo_wgt} != '')" ).append("\n"); 
		query.append("   AND MAX_CGO_WGT = @[max_cgo_wgt]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND MAX_CGO_WGT IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_trsp_mod_cd} != '')" ).append("\n"); 
		query.append("   AND ORG_TRSP_MOD_CD = @[org_trsp_mod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND ORG_TRSP_MOD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_trsp_mod_cd} != '')" ).append("\n"); 
		query.append("   AND DEST_TRSP_MOD_CD = @[dest_trsp_mod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND DEST_TRSP_MOD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_rcv_term_cd} != '')" ).append("\n"); 
		query.append("   AND PRC_RCV_TERM_CD = @[prc_rcv_term_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PRC_RCV_TERM_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_de_term_cd} != '')" ).append("\n"); 
		query.append("   AND PRC_DE_TERM_CD = @[prc_de_term_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PRC_DE_TERM_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${prc_hngr_bar_tp_cd} != '')" ).append("\n"); 
		query.append("   AND PRC_HNGR_BAR_TP_CD = @[prc_hngr_bar_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND PRC_HNGR_BAR_TP_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '')" ).append("\n"); 
		query.append("   AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SUB_TRD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dir_call_flg} != '')" ).append("\n"); 
		query.append("   AND DIR_CALL_FLG = @[dir_call_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND DIR_CALL_FLG IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${tml_cd} != '')" ).append("\n"); 
		query.append("   AND TML_CD = @[tml_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND TML_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND CMDT_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_ga_cd} != '')" ).append("\n"); 
		query.append("   AND IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND IO_GA_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ts_port_cd} != '')" ).append("\n"); 
		query.append("   AND TS_PORT_CD = @[ts_port_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND TS_PORT_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${soc_flg} != '')" ).append("\n"); 
		query.append("   AND SOC_FLG = @[soc_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SOC_FLG IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${scg_grp_cmdt_cd} != '')" ).append("\n"); 
		query.append("   AND SCG_GRP_CMDT_CD = @[scg_grp_cmdt_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND SCG_GRP_CMDT_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usa_svc_mod_cd} != '')" ).append("\n"); 
		query.append("   AND USA_SVC_MOD_CD = @[usa_svc_mod_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND USA_SVC_MOD_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${exp_dt} != '')" ).append("\n"); 
		query.append("   AND ((TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT OR TO_DATE(@[exp_dt], 'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT) " ).append("\n"); 
		query.append("             OR (TO_DATE(@[eff_dt], 'YYYYMMDD') <= EFF_DT AND TO_DATE(@[exp_dt], 'YYYYMMDD') >= EXP_DT))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN EFF_DT AND EXP_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}