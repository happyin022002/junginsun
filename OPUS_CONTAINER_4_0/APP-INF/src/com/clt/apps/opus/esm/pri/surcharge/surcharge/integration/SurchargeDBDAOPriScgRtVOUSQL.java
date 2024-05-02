/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOPriScgRtVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2016.05.12 CHLOE MIJIN SEO
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

public class SurchargeDBDAOPriScgRtVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCG_RT 테이블 수정
	  * </pre>
	  */
	public SurchargeDBDAOPriScgRtVOUSQL(){
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
		params.put("prc_hngr_bar_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dest_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("scg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_esvc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgRtVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SCG_RT SET " ).append("\n"); 
		query.append("	   EFF_DT = TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	 , EXP_DT = DECODE(@[exp_dt], NULL, TO_DATE('99991231', 'YYYY-MM-DD') ,TO_DATE(@[exp_dt],'YYYY-MM-DD'))" ).append("\n"); 
		query.append("	 , SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("	 , VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("	 , POR_TP_CD = CASE WHEN @[por_def_cd] IS NULL THEN NULL ELSE DECODE(LENGTH(@[por_def_cd]), 2, 'C', 3, 'R', 4, 'G', 5, 'L') END" ).append("\n"); 
		query.append("	 , POR_DEF_CD = @[por_def_cd]" ).append("\n"); 
		query.append("	 , POL_TP_CD = CASE WHEN @[pol_def_cd] IS NULL THEN NULL ELSE DECODE(LENGTH(@[pol_def_cd]), 2, 'C', 3, 'R', 4, 'G', 5, 'L') END" ).append("\n"); 
		query.append("	 , POL_DEF_CD = @[pol_def_cd]" ).append("\n"); 
		query.append("	 , POD_TP_CD = CASE WHEN @[pod_def_cd] IS NULL THEN NULL ELSE DECODE(LENGTH(@[pod_def_cd]), 2, 'C', 3, 'R', 4, 'G', 5, 'L') END" ).append("\n"); 
		query.append("	 , POD_DEF_CD = @[pod_def_cd]" ).append("\n"); 
		query.append("	 , DEL_TP_CD = CASE WHEN @[del_def_cd] IS NULL THEN NULL ELSE DECODE(LENGTH(@[del_def_cd]), 2, 'C', 3, 'R', 4, 'G', 5, 'L') END" ).append("\n"); 
		query.append("	 , DEL_DEF_CD = @[del_def_cd]" ).append("\n"); 
		query.append("	 , TS_PORT_CD = @[ts_port_cd]" ).append("\n"); 
		query.append("	 , TML_CD = @[tml_cd]" ).append("\n"); 
		query.append("	 , ORG_TRSP_MOD_CD = @[org_trsp_mod_cd]" ).append("\n"); 
		query.append("	 , DEST_TRSP_MOD_CD = @[dest_trsp_mod_cd]" ).append("\n"); 
		query.append("	 , USA_SVC_MOD_CD = @[usa_svc_mod_cd]" ).append("\n"); 
		query.append("	 , PRC_RCV_TERM_CD = @[prc_rcv_term_cd]" ).append("\n"); 
		query.append("	 , PRC_DE_TERM_CD = @[prc_de_term_cd]" ).append("\n"); 
		query.append("	 , PRC_HNGR_BAR_TP_CD = @[prc_hngr_bar_tp_cd]" ).append("\n"); 
		query.append("	 , DIR_CALL_FLG = @[dir_call_flg]" ).append("\n"); 
		query.append("	 , MIN_CGO_WGT = @[min_cgo_wgt]" ).append("\n"); 
		query.append("	 , MAX_CGO_WGT = @[max_cgo_wgt]" ).append("\n"); 
		query.append("	 , CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("	 , SCG_GRP_CMDT_CD = @[scg_grp_cmdt_cd]" ).append("\n"); 
		query.append("	 , PRC_CGO_TP_CD = @[prc_cgo_tp_cd]" ).append("\n"); 
		query.append("	 , SCG_IMDG_CLSS_CD = @[scg_imdg_clss_cd]" ).append("\n"); 
		query.append("	 , RAT_UT_CD = @[rat_ut_cd]" ).append("\n"); 
		query.append("	 , CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("	 , SCG_AMT = @[scg_amt]" ).append("\n"); 
		query.append("	 , PAY_TERM_CD = @[pay_term_cd]" ).append("\n"); 
		query.append("	 , WDR_FLG = 'N'" ).append("\n"); 
		query.append("	 , SOC_FLG = @[soc_flg]" ).append("\n"); 
		query.append("	 , IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("	 , CNL_TZ_CD = @[cnl_tz_cd]" ).append("\n"); 
		query.append("	 , DELT_FLG = NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append("	 , SCG_RMK = @[scg_rmk]" ).append("\n"); 
		query.append("	 , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("     , BKG_ESVC_TP_CD = @[bkg_esvc_tp_cd]" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("   AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("   AND SCG_SEQ = @[scg_seq]" ).append("\n"); 

	}
}