/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOPriScgRtVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.24 
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

public class SurchargeDBDAOPriScgRtVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCG_RT 테이블 수정
	  * 2013.03.07 전윤주 [CHM-201323465] Reefer condition type 추가
	  * 2013.04.17 전윤주 [CHM-201324203] 전윤주 Contract date 추가
	  * 2013.10.01 전윤주 [CHM-201326927] MDM rating flag와 연계하여 Auto 항목 추가
	  * 2013.10.01 전윤주 [CHM-201326929] BL Printing시 숨길 수 있는 Hide 항목 추가
	  * 2014.03.20 전윤주 [CHM-201429456] Food Grade 항목 추가
	  * 2014.04.10 전윤주 [CHM-201429656] State code 항목 추가  
	  * 2015.04.10 전지예 [CHM-201535041] Arrival Date 항목 추가
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
		params.put("fd_grd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scg_prd_crte_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_air_cond_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wdr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_rqst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("psa_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scg_rqst_proc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_prd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_hdn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_crte_dy_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("por_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnl_tz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_rat_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration").append("\n"); 
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
		query.append("MERGE INTO PRI_SCG_RQST_RT RT" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("        @[scg_seq] as SCG_SEQ" ).append("\n"); 
		query.append("       ,@[svc_scp_cd] as SVC_SCP_CD" ).append("\n"); 
		query.append("       ,@[chg_cd] as CHG_CD" ).append("\n"); 
		query.append("       ,@[scg_rqst_proc_cd] as SCG_RQST_PROC_CD" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 
		query.append(") TMP" ).append("\n"); 
		query.append("   ON(" ).append("\n"); 
		query.append("          RT.SCG_SEQ = TMP.SCG_SEQ" ).append("\n"); 
		query.append("     AND  RT.SVC_SCP_CD = TMP.SVC_SCP_CD" ).append("\n"); 
		query.append("     AND  RT.CHG_CD = TMP.CHG_CD" ).append("\n"); 
		query.append("     AND  RT.SCG_RQST_PROC_CD = TMP.SCG_RQST_PROC_CD" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   WHEN MATCHED THEN" ).append("\n"); 
		query.append("       UPDATE SET" ).append("\n"); 
		query.append("       RT.EFF_DT = TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	 , RT.EXP_DT = DECODE(@[exp_dt], NULL, TO_DATE('99991231', 'YYYY-MM-DD') ,TO_DATE(@[exp_dt],'YYYY-MM-DD'))" ).append("\n"); 
		query.append("	 , RT.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("	 , RT.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("	 , RT.POR_TP_CD = @[por_tp_cd]" ).append("\n"); 
		query.append("	 , RT.POR_DEF_CD = @[por_def_cd]" ).append("\n"); 
		query.append("	 , RT.POL_TP_CD = @[pol_tp_cd]" ).append("\n"); 
		query.append("	 , RT.POL_DEF_CD = @[pol_def_cd]" ).append("\n"); 
		query.append("	 , RT.POD_TP_CD = @[pod_tp_cd]" ).append("\n"); 
		query.append("	 , RT.POD_DEF_CD = @[pod_def_cd]" ).append("\n"); 
		query.append("	 , RT.DEL_TP_CD = @[del_tp_cd]" ).append("\n"); 
		query.append("	 , RT.DEL_DEF_CD = @[del_def_cd]" ).append("\n"); 
		query.append("	 , RT.TS_PORT_CD = @[ts_port_cd]" ).append("\n"); 
		query.append("	 , RT.TML_CD = @[tml_cd]" ).append("\n"); 
		query.append("	 , RT.ORG_TRSP_MOD_CD = @[org_trsp_mod_cd]" ).append("\n"); 
		query.append("	 , RT.DEST_TRSP_MOD_CD = @[dest_trsp_mod_cd]" ).append("\n"); 
		query.append("	 , RT.USA_SVC_MOD_CD = @[usa_svc_mod_cd]" ).append("\n"); 
		query.append("	 , RT.PRC_RCV_TERM_CD = @[prc_rcv_term_cd]" ).append("\n"); 
		query.append("	 , RT.PRC_DE_TERM_CD = @[prc_de_term_cd]" ).append("\n"); 
		query.append("	 , RT.PRC_HNGR_BAR_TP_CD = @[prc_hngr_bar_tp_cd]" ).append("\n"); 
		query.append("	 , RT.DIR_CALL_FLG = @[dir_call_flg]" ).append("\n"); 
		query.append("	 , RT.MIN_CGO_WGT = @[min_cgo_wgt]" ).append("\n"); 
		query.append("	 , RT.MAX_CGO_WGT = @[max_cgo_wgt]" ).append("\n"); 
		query.append("	 , RT.CMDT_CD = @[cmdt_cd]" ).append("\n"); 
		query.append("	 , RT.SCG_GRP_CMDT_CD = @[scg_grp_cmdt_cd]" ).append("\n"); 
		query.append("	 , RT.PRC_CGO_TP_CD = @[prc_cgo_tp_cd]" ).append("\n"); 
		query.append("	 , RT.SCG_IMDG_CLSS_CD = @[scg_imdg_clss_cd]" ).append("\n"); 
		query.append("	 , RT.RAT_UT_CD = @[rat_ut_cd]" ).append("\n"); 
		query.append("	 , RT.CURR_CD = @[curr_cd]" ).append("\n"); 
		query.append("	 , RT.SCG_AMT = @[scg_amt]" ).append("\n"); 
		query.append("	 , RT.PAY_TERM_CD = @[pay_term_cd]" ).append("\n"); 
		query.append("	 , RT.WDR_FLG = DECODE(@[wdr_flg], '0', 'N', 'Y')" ).append("\n"); 
		query.append("	 , RT.SOC_FLG = @[soc_flg]" ).append("\n"); 
		query.append("	 , RT.IO_GA_CD = @[io_ga_cd]" ).append("\n"); 
		query.append("	 , RT.CNL_TZ_CD = @[cnl_tz_cd]" ).append("\n"); 
		query.append("	 , RT.DELT_FLG = NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append("	 , RT.SCG_RMK = @[scg_rmk]" ).append("\n"); 
		query.append("     , RT.SCG_CRTE_DY_KNT = @[scg_crte_dy_knt] " ).append("\n"); 
		query.append("     , RT.SCG_PRD_TP_CD = @[scg_prd_tp_cd]" ).append("\n"); 
		query.append("     , RT.SCG_PRD_CRTE_CD = @[scg_prd_crte_cd]" ).append("\n"); 
		query.append("     , RT.PSA_NO = @[psa_no]" ).append("\n"); 
		query.append("     , RT.RC_AIR_COND_TP_CD = @[rc_air_cond_tp_cd]" ).append("\n"); 
		query.append("     , RT.CTRT_DT = TO_DATE(@[ctrt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("     , RT.ACT_RAT_FLG = @[act_rat_flg]" ).append("\n"); 
		query.append("     , RT.PRN_HDN_FLG =  DECODE(@[prn_hdn_flg],'1', 'Y', '')" ).append("\n"); 
		query.append("     , RT.FD_GRD_FLG = @[fd_grd_flg]" ).append("\n"); 
		query.append("     , RT.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("     , RT.STE_CD = @[ste_cd]" ).append("\n"); 
		query.append("     , RT.ARR_DT = TO_DATE(@[arr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("	 , RT.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	 , RT.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	 , RT.SCG_RQST_STS_CD = @[scg_rqst_sts_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("   INSERT" ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("       SVC_SCP_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("	 , SCG_SEQ" ).append("\n"); 
		query.append("     , SCG_RQST_SEQ" ).append("\n"); 
		query.append("     , SCG_RQST_STS_CD" ).append("\n"); 
		query.append("     , SCG_RQST_PROC_CD" ).append("\n"); 
		query.append("	 , EFF_DT" ).append("\n"); 
		query.append("	 , EXP_DT" ).append("\n"); 
		query.append("	 , SUB_TRD_CD" ).append("\n"); 
		query.append("	 , VSL_SLAN_CD" ).append("\n"); 
		query.append("	 , POR_TP_CD" ).append("\n"); 
		query.append("	 , POR_DEF_CD" ).append("\n"); 
		query.append("	 , POL_TP_CD" ).append("\n"); 
		query.append("	 , POL_DEF_CD" ).append("\n"); 
		query.append("	 , POD_TP_CD" ).append("\n"); 
		query.append("	 , POD_DEF_CD" ).append("\n"); 
		query.append("	 , DEL_TP_CD" ).append("\n"); 
		query.append("	 , DEL_DEF_CD" ).append("\n"); 
		query.append("	 , TS_PORT_CD" ).append("\n"); 
		query.append("	 , TML_CD" ).append("\n"); 
		query.append("	 , ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("	 , DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append("	 , USA_SVC_MOD_CD" ).append("\n"); 
		query.append("	 , PRC_RCV_TERM_CD" ).append("\n"); 
		query.append("	 , PRC_DE_TERM_CD" ).append("\n"); 
		query.append("	 , PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append("	 , DIR_CALL_FLG" ).append("\n"); 
		query.append("	 , MIN_CGO_WGT" ).append("\n"); 
		query.append("	 , MAX_CGO_WGT" ).append("\n"); 
		query.append("	 , CMDT_CD" ).append("\n"); 
		query.append("	 , SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append("	 , PRC_CGO_TP_CD" ).append("\n"); 
		query.append("	 , SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("	 , RAT_UT_CD" ).append("\n"); 
		query.append("	 , CURR_CD" ).append("\n"); 
		query.append("	 , SCG_AMT" ).append("\n"); 
		query.append("	 , PAY_TERM_CD" ).append("\n"); 
		query.append("	 , WDR_FLG" ).append("\n"); 
		query.append("	 , SOC_FLG" ).append("\n"); 
		query.append("	 , IO_GA_CD" ).append("\n"); 
		query.append("	 , DELT_FLG" ).append("\n"); 
		query.append("	 , SCG_RMK" ).append("\n"); 
		query.append("     , SCG_CRTE_DY_KNT" ).append("\n"); 
		query.append("     , SCG_PRD_TP_CD" ).append("\n"); 
		query.append("     , SCG_PRD_CRTE_CD" ).append("\n"); 
		query.append("	 , PSA_NO" ).append("\n"); 
		query.append("     , RC_AIR_COND_TP_CD" ).append("\n"); 
		query.append("     , CTRT_DT" ).append("\n"); 
		query.append("     , ACT_RAT_FLG" ).append("\n"); 
		query.append("     , PRN_HDN_FLG" ).append("\n"); 
		query.append("     , FD_GRD_FLG" ).append("\n"); 
		query.append("     , CNT_CD" ).append("\n"); 
		query.append("     , STE_CD" ).append("\n"); 
		query.append("     , ARR_DT" ).append("\n"); 
		query.append("	 , CRE_USR_ID" ).append("\n"); 
		query.append("	 , CRE_DT" ).append("\n"); 
		query.append("	 , UPD_USR_ID" ).append("\n"); 
		query.append("	 , UPD_DT" ).append("\n"); 
		query.append("	 , CNL_TZ_CD" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("   VALUES" ).append("\n"); 
		query.append("   (" ).append("\n"); 
		query.append("            @[svc_scp_cd] " ).append("\n"); 
		query.append("        ,	@[chg_cd] " ).append("\n"); 
		query.append("        ,	@[scg_seq]" ).append("\n"); 
		query.append("        ,   (SELECT NVL(MAX(SCG_RQST_SEQ), 0)+1 FROM PRI_SCG_RQST_RT WHERE SVC_SCP_CD = @[svc_scp_cd] AND CHG_CD = @[chg_cd] AND SCG_SEQ = @[scg_seq])" ).append("\n"); 
		query.append("        ,   @[scg_rqst_sts_cd]" ).append("\n"); 
		query.append("        ,   @[scg_rqst_proc_cd]" ).append("\n"); 
		query.append("        ,	TO_DATE(@[eff_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("        ,	DECODE(@[exp_dt], NULL, TO_DATE('99991231', 'YYYY-MM-DD') ,TO_DATE(@[exp_dt],'YYYY-MM-DD')) " ).append("\n"); 
		query.append("        ,	@[sub_trd_cd] " ).append("\n"); 
		query.append("        ,	@[vsl_slan_cd] " ).append("\n"); 
		query.append("        ,	@[por_tp_cd] " ).append("\n"); 
		query.append("        ,	@[por_def_cd] " ).append("\n"); 
		query.append("        ,	@[pol_tp_cd] " ).append("\n"); 
		query.append("        ,	@[pol_def_cd] " ).append("\n"); 
		query.append("        ,	@[pod_tp_cd] " ).append("\n"); 
		query.append("        ,	@[pod_def_cd] " ).append("\n"); 
		query.append("        ,	@[del_tp_cd]" ).append("\n"); 
		query.append("        ,	@[del_def_cd] " ).append("\n"); 
		query.append("        ,	@[ts_port_cd] " ).append("\n"); 
		query.append("        ,	@[tml_cd] " ).append("\n"); 
		query.append("        ,	@[org_trsp_mod_cd] " ).append("\n"); 
		query.append("        ,	@[dest_trsp_mod_cd] " ).append("\n"); 
		query.append("        ,	@[usa_svc_mod_cd] " ).append("\n"); 
		query.append("        ,	@[prc_rcv_term_cd] " ).append("\n"); 
		query.append("        ,	@[prc_de_term_cd] " ).append("\n"); 
		query.append("        ,	@[prc_hngr_bar_tp_cd] " ).append("\n"); 
		query.append("        ,	@[dir_call_flg] " ).append("\n"); 
		query.append("        ,	@[min_cgo_wgt] " ).append("\n"); 
		query.append("        ,	@[max_cgo_wgt] " ).append("\n"); 
		query.append("        ,	@[cmdt_cd] " ).append("\n"); 
		query.append("        ,	@[scg_grp_cmdt_cd] " ).append("\n"); 
		query.append("        ,	@[prc_cgo_tp_cd] " ).append("\n"); 
		query.append("        ,	@[scg_imdg_clss_cd] " ).append("\n"); 
		query.append("        ,	@[rat_ut_cd] " ).append("\n"); 
		query.append("        ,	@[curr_cd] " ).append("\n"); 
		query.append("        ,	@[scg_amt] " ).append("\n"); 
		query.append("        ,	@[pay_term_cd]" ).append("\n"); 
		query.append("        ,	DECODE(@[wdr_flg], '1', 'Y', 'N') " ).append("\n"); 
		query.append("        ,   @[soc_flg] " ).append("\n"); 
		query.append("        ,   @[io_ga_cd] " ).append("\n"); 
		query.append("        ,	NVL(@[delt_flg], 'N')" ).append("\n"); 
		query.append("        ,	@[scg_rmk] " ).append("\n"); 
		query.append("        ,   @[scg_crte_dy_knt] " ).append("\n"); 
		query.append("        ,   @[scg_prd_tp_cd]" ).append("\n"); 
		query.append("        ,   @[scg_prd_crte_cd] " ).append("\n"); 
		query.append("        ,   @[psa_no]" ).append("\n"); 
		query.append("        ,   @[rc_air_cond_tp_cd] " ).append("\n"); 
		query.append("        ,   TO_DATE(@[ctrt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("        ,   @[act_rat_flg] " ).append("\n"); 
		query.append("        ,   DECODE(@[prn_hdn_flg], 1, 'Y', '')" ).append("\n"); 
		query.append("        ,   @[fd_grd_flg] " ).append("\n"); 
		query.append("        ,   @[cnt_cd] " ).append("\n"); 
		query.append("        ,   @[ste_cd] " ).append("\n"); 
		query.append("        ,   TO_DATE(@[arr_dt],'YYYY-MM-DD') " ).append("\n"); 
		query.append("        ,	@[cre_usr_id] " ).append("\n"); 
		query.append("        ,	SYSDATE" ).append("\n"); 
		query.append("        ,	@[upd_usr_id] " ).append("\n"); 
		query.append("        ,	SYSDATE" ).append("\n"); 
		query.append("        ,	@[cnl_tz_cd]" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}