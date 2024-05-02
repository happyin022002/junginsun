/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOPriScgReqRtVOCSQL.java
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

public class SurchargeDBDAOPriScgReqRtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Surcharge Req 테이블에 값 Insert
	  * </pre>
	  */
	public SurchargeDBDAOPriScgReqRtVOCSQL(){
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
		params.put("ctrt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scg_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("del_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgReqRtVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCG_RQST_RT (" ).append("\n"); 
		query.append("	   SVC_SCP_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("	 , SCG_SEQ" ).append("\n"); 
		query.append("	 , SCG_RQST_SEQ" ).append("\n"); 
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
		query.append("	 , SCG_RQST_STS_CD" ).append("\n"); 
		query.append("	 , SCG_RQST_PROC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	@[svc_scp_cd] AS SVC_SCP_CD" ).append("\n"); 
		query.append(",	@[chg_cd] AS CHG_CD" ).append("\n"); 
		query.append(",	NVL(MAX(SCG_SEQ), 0) AS SCG_SEQ  -- Rate 테이블에 먼저 insert하기때문에 +1 하지 않는다" ).append("\n"); 
		query.append(",	'1' AS SCG_RQST_SEQ" ).append("\n"); 
		query.append(",	TO_DATE(@[eff_dt],'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",	DECODE(@[exp_dt], NULL, TO_DATE('99991231', 'YYYY-MM-DD') ,TO_DATE(@[exp_dt],'YYYY-MM-DD')) AS EXP_DT" ).append("\n"); 
		query.append(",	@[sub_trd_cd] AS SUB_TRD_CD" ).append("\n"); 
		query.append(",	@[vsl_slan_cd] AS VSL_SLAN_CD" ).append("\n"); 
		query.append(",	@[por_tp_cd] AS POR_TP_CD" ).append("\n"); 
		query.append(",	@[por_def_cd] AS POR_DEF_CD" ).append("\n"); 
		query.append(",	@[pol_tp_cd] AS POL_TP_CD" ).append("\n"); 
		query.append(",	@[pol_def_cd] AS POL_DEF_CD" ).append("\n"); 
		query.append(",	@[pod_tp_cd] AS POD_TP_CD" ).append("\n"); 
		query.append(",	@[pod_def_cd] AS POD_DEF_CD" ).append("\n"); 
		query.append(",	@[del_tp_cd] AS DEL_TP_CD" ).append("\n"); 
		query.append(",	@[del_def_cd] AS DEL_DEF_CD" ).append("\n"); 
		query.append(",	@[ts_port_cd] AS TS_PORT_CD" ).append("\n"); 
		query.append(",	@[tml_cd] AS TML_CD" ).append("\n"); 
		query.append(",	@[org_trsp_mod_cd] AS ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	@[dest_trsp_mod_cd] AS DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append(",	@[usa_svc_mod_cd] AS USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",	@[prc_rcv_term_cd] AS PRC_RCV_TERM_CD" ).append("\n"); 
		query.append(",	@[prc_de_term_cd] AS PRC_DE_TERM_CD" ).append("\n"); 
		query.append(",	@[prc_hngr_bar_tp_cd] AS PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",	@[dir_call_flg] AS DIR_CALL_FLG" ).append("\n"); 
		query.append(",	@[min_cgo_wgt] AS MIN_CGO_WGT" ).append("\n"); 
		query.append(",	@[max_cgo_wgt] AS MAX_CGO_WGT" ).append("\n"); 
		query.append(",	@[cmdt_cd] AS CMDT_CD" ).append("\n"); 
		query.append(",	@[scg_grp_cmdt_cd] AS SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append(",	@[prc_cgo_tp_cd] AS PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",	@[scg_imdg_clss_cd] AS SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	@[rat_ut_cd] AS RAT_UT_CD" ).append("\n"); 
		query.append(",	@[curr_cd] AS CURR_CD" ).append("\n"); 
		query.append(",	@[scg_amt] AS SCG_AMT" ).append("\n"); 
		query.append(",	@[pay_term_cd] AS PAY_TERM_CD" ).append("\n"); 
		query.append(",	DECODE(@[wdr_flg], '1', 'Y', 'N') AS WDR_FLG" ).append("\n"); 
		query.append(",   @[soc_flg] AS SOC_FLG" ).append("\n"); 
		query.append(",   @[io_ga_cd] AS IO_GA_CD" ).append("\n"); 
		query.append(",	'N' AS DELT_FLG" ).append("\n"); 
		query.append(",	@[scg_rmk] AS SCG_RMK" ).append("\n"); 
		query.append(",   @[scg_crte_dy_knt] AS SCG_CRTE_DY_KNT" ).append("\n"); 
		query.append(",   @[scg_prd_tp_cd] AS SCG_PRD_TP_CD" ).append("\n"); 
		query.append(",   @[scg_prd_crte_cd] AS SCG_PRD_CRTE_CD " ).append("\n"); 
		query.append(",   @[psa_no] AS PSA_NO" ).append("\n"); 
		query.append(",   @[rc_air_cond_tp_cd] AS RC_AIR_COND_TP_CD" ).append("\n"); 
		query.append(",   TO_DATE(@[ctrt_dt],'YYYY-MM-DD') AS CTRT_DT" ).append("\n"); 
		query.append(",   @[act_rat_flg] AS ACT_RAT_FLG" ).append("\n"); 
		query.append(",   DECODE(@[prn_hdn_flg], 1, 'Y', '') AS PRN_HDN_FLG --체크하지 않으면 없는 것으로 간주. 그래야 헤더에 있는 use_flag를 삭제 할 수 있음" ).append("\n"); 
		query.append(",   @[fd_grd_flg] AS FD_GRD_FLG" ).append("\n"); 
		query.append(",   @[cnt_cd] AS CNT_CD" ).append("\n"); 
		query.append(",   @[ste_cd] AS STE_CD" ).append("\n"); 
		query.append(",   TO_DATE(@[arr_dt],'YYYY-MM-DD') AS ARR_DT" ).append("\n"); 
		query.append(",	@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[cnl_tz_cd] AS CNL_TZ_CD" ).append("\n"); 
		query.append(",   'N' AS SCG_RQST_STS_CD" ).append("\n"); 
		query.append(",   'S' AS SCG_RQST_PROC_CD" ).append("\n"); 
		query.append("  FROM PRI_SCG_RT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("   AND CHG_CD = @[chg_cd]" ).append("\n"); 

	}
}