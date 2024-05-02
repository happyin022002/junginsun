/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SurchargeDBDAOPriScgRtVOCSQL.java
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

public class SurchargeDBDAOPriScgRtVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRI_SCG_RT 테이블 입력
	  * </pre>
	  */
	public SurchargeDBDAOPriScgRtVOCSQL(){
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
		params.put("pol_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("scg_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_esvc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surcharge.integration").append("\n"); 
		query.append("FileName : SurchargeDBDAOPriScgRtVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_SCG_RT (" ).append("\n"); 
		query.append("	   SVC_SCP_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("	 , SCG_SEQ" ).append("\n"); 
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
		query.append("	 , CRE_USR_ID" ).append("\n"); 
		query.append("	 , CRE_DT" ).append("\n"); 
		query.append("	 , UPD_USR_ID" ).append("\n"); 
		query.append("	 , UPD_DT" ).append("\n"); 
		query.append("	 , CNL_TZ_CD" ).append("\n"); 
		query.append("     , BKG_ESVC_TP_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("SVC_SCP_CD" ).append("\n"); 
		query.append(",CHG_CD" ).append("\n"); 
		query.append(",SCG_SEQ" ).append("\n"); 
		query.append(",EFF_DT" ).append("\n"); 
		query.append(",EXP_DT" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",VSL_SLAN_CD" ).append("\n"); 
		query.append(",CASE WHEN POR_DEF_CD IS NULL THEN NULL ELSE DECODE(LENGTH(POR_DEF_CD), 2, 'C', 3, 'R', 4, 'G', 5, 'L') END POR_TP_CD" ).append("\n"); 
		query.append(",POR_DEF_CD" ).append("\n"); 
		query.append(",CASE WHEN POL_DEF_CD IS NULL THEN NULL ELSE DECODE(LENGTH(POL_DEF_CD), 2, 'C', 3, 'R', 4, 'G', 5, 'L') END POL_TP_CD" ).append("\n"); 
		query.append(",POL_DEF_CD" ).append("\n"); 
		query.append(",CASE WHEN POD_DEF_CD IS NULL THEN NULL ELSE DECODE(LENGTH(POD_DEF_CD), 2, 'C', 3, 'R', 4, 'G', 5, 'L') END POD_TP_CD" ).append("\n"); 
		query.append(",POD_DEF_CD" ).append("\n"); 
		query.append(",CASE WHEN DEL_DEF_CD IS NULL THEN NULL ELSE DECODE(LENGTH(DEL_DEF_CD), 2, 'C', 3, 'R', 4, 'G', 5, 'L') END DEL_TP_CD" ).append("\n"); 
		query.append(",DEL_DEF_CD" ).append("\n"); 
		query.append(",TS_PORT_CD" ).append("\n"); 
		query.append(",TML_CD" ).append("\n"); 
		query.append(",ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append(",DEST_TRSP_MOD_CD" ).append("\n"); 
		query.append(",USA_SVC_MOD_CD" ).append("\n"); 
		query.append(",PRC_RCV_TERM_CD" ).append("\n"); 
		query.append(",PRC_DE_TERM_CD" ).append("\n"); 
		query.append(",PRC_HNGR_BAR_TP_CD" ).append("\n"); 
		query.append(",DIR_CALL_FLG" ).append("\n"); 
		query.append(",MIN_CGO_WGT" ).append("\n"); 
		query.append(",MAX_CGO_WGT" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",SCG_GRP_CMDT_CD" ).append("\n"); 
		query.append(",PRC_CGO_TP_CD" ).append("\n"); 
		query.append(",SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append(",RAT_UT_CD" ).append("\n"); 
		query.append(",CURR_CD" ).append("\n"); 
		query.append(",SCG_AMT" ).append("\n"); 
		query.append(",PAY_TERM_CD" ).append("\n"); 
		query.append(",WDR_FLG" ).append("\n"); 
		query.append(",SOC_FLG" ).append("\n"); 
		query.append(",IO_GA_CD" ).append("\n"); 
		query.append(",DELT_FLG" ).append("\n"); 
		query.append(",SCG_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",CNL_TZ_CD" ).append("\n"); 
		query.append(",BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[svc_scp_cd] AS SVC_SCP_CD" ).append("\n"); 
		query.append(",	@[chg_cd] AS CHG_CD" ).append("\n"); 
		query.append(",	NVL(MAX(SCG_SEQ), 0)+1 AS SCG_SEQ" ).append("\n"); 
		query.append(",	TO_DATE(@[eff_dt],'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append(",	DECODE(@[exp_dt], NULL, TO_DATE('99991231', 'YYYY-MM-DD') ,TO_DATE(@[exp_dt],'YYYY-MM-DD')) AS EXP_DT" ).append("\n"); 
		query.append(",	@[sub_trd_cd] AS SUB_TRD_CD" ).append("\n"); 
		query.append(",	@[vsl_slan_cd] AS VSL_SLAN_CD" ).append("\n"); 
		query.append(",	@[por_tp_cd] AS POR_TP_CD" ).append("\n"); 
		query.append(",	@[por_def_cd] AS POR_DEF_CD" ).append("\n"); 
		query.append(",	@[pol_tp_cd] AS POL_TP_CD" ).append("\n"); 
		query.append(",	@[pol_def_cd] AS POL_DEF_CD" ).append("\n"); 
		query.append(",   @[pod_tp_cd] AS POD_TP_CD" ).append("\n"); 
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
		query.append(",	'N' AS WDR_FLG" ).append("\n"); 
		query.append(",   @[soc_flg] AS SOC_FLG" ).append("\n"); 
		query.append(",   @[io_ga_cd] AS IO_GA_CD" ).append("\n"); 
		query.append(",	'N' AS DELT_FLG" ).append("\n"); 
		query.append(",	@[scg_rmk] AS SCG_RMK" ).append("\n"); 
		query.append(",	@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(",	@[upd_usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",	SYSDATE AS UPD_DT" ).append("\n"); 
		query.append(",	@[cnl_tz_cd] AS CNL_TZ_CD" ).append("\n"); 
		query.append(",	@[bkg_esvc_tp_cd] AS BKG_ESVC_TP_CD" ).append("\n"); 
		query.append("  FROM PRI_SCG_RT" ).append("\n"); 
		query.append(" WHERE SVC_SCP_CD = @[svc_scp_cd] " ).append("\n"); 
		query.append("   AND CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}