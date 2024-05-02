/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContainerCargoClaimReportDBDAOSearchSettlementAnalysisTotalRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.24
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2014.12.24 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerCargoClaimReportDBDAOSearchSettlementAnalysisTotalRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchSettlementAnalysis Total 조회
	  * </pre>
	  */
	public ContainerCargoClaimReportDBDAOSearchSettlementAnalysisTotalRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inci_plc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("labl_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_clmt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pre_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_ref_vvd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_cgo_clm_stl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fmal_clm_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svey_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_period",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_inci_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mjr_clm_dmg_lss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slv_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clmt_clm_agn_pty_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("insur_clm_pty_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_stl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_stl_auth_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cgo_clm_stl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hdlr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_clmt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pst_ts_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("minr_clm_dmg_lss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clm_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_period",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_clm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration").append("\n"); 
		query.append("FileName : ContainerCargoClaimReportDBDAOSearchSettlementAnalysisTotalRSQL").append("\n"); 
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
		query.append("SELECT DATA_SEQ  " ).append("\n"); 
		query.append(",'Total' REPORT_BY" ).append("\n"); 
		query.append(", DIV" ).append("\n"); 
		query.append(", SUM(CLAIMED) CLAIMED" ).append("\n"); 
		query.append(", SUM(PAID) PAID" ).append("\n"); 
		query.append(", SUM(TIME_BARRED) TIME_BARRED" ).append("\n"); 
		query.append(", SUM(WITHDRAWN) WITHDRAWN" ).append("\n"); 
		query.append(", SUM(REPUDIATED) REPUDIATED" ).append("\n"); 
		query.append(", SUM(TENDER_DEFENCE) TENDER_DEFENCE" ).append("\n"); 
		query.append(", SUM(DISMISSED) DISMISSED" ).append("\n"); 
		query.append(", SUM(TOT) TOT" ).append("\n"); 
		query.append(", SUM(OUTSTANDING) OUTSTANDING" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(CLAIMED), 0, 0,(SUM(OUTSTANDING)/SUM(CLAIMED))*100),2) OUTSTANDING_P  " ).append("\n"); 
		query.append(", SUM(PAID_DP) PAID_DP" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(PAID), 0, 0, (SUM(PAID_DP)/SUM(PAID))*100),2) PAID_DP_P" ).append("\n"); 
		query.append(", SUM(LP_RECOVERED) LP_RECOVERED" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(PAID_DP), 0, 0, (SUM(LP_RECOVERED)/SUM(PAID_DP))*100),2) LP_RECOVERED_P" ).append("\n"); 
		query.append(", SUM(INS_RECOVERED) INS_RECOVERED" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(PAID_DP), 0, 0, (SUM(INS_RECOVERED)/SUM(PAID_DP))*100),2) INS_RECOVERED_P" ).append("\n"); 
		query.append(", SUM(TOTAL_RECOVERED) TOTAL_RECOVERED" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(PAID_DP), 0, 0, (SUM(TOTAL_RECOVERED)/SUM(PAID_DP))*100),2) TOTAL_RECOVERED_P" ).append("\n"); 
		query.append(", SUM(NET_PAID) NET_PAID" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(PAID), 0, 0, (SUM(NET_PAID)/SUM(PAID))*100),2) NET_PAID_P" ).append("\n"); 
		query.append(",  DATA_SEQ2" ).append("\n"); 
		query.append(",'Total' REPORT_BY2" ).append("\n"); 
		query.append(", DIV2" ).append("\n"); 
		query.append(", SUM(CLAIMED2) CLAIMED2" ).append("\n"); 
		query.append(", SUM(PAID2) PAID2" ).append("\n"); 
		query.append(", SUM(TIME_BARRED2) TIME_BARRED2" ).append("\n"); 
		query.append(", SUM(WITHDRAWN2) WITHDRAWN2" ).append("\n"); 
		query.append(", SUM(REPUDIATED2) REPUDIATED2" ).append("\n"); 
		query.append(", SUM(TENDER_DEFENCE2) TENDER_DEFENCE2" ).append("\n"); 
		query.append(", SUM(DISMISSED2) DISMISSED2" ).append("\n"); 
		query.append(", SUM(TOT2) TOT2" ).append("\n"); 
		query.append(", SUM(OUTSTANDING2) OUTSTANDING2" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(CLAIMED2), 0, 0, (SUM(OUTSTANDING2)/SUM(CLAIMED2))*100),2) OUTSTANDING_P2" ).append("\n"); 
		query.append(", SUM(PAID_DP2) PAID_DP2" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(PAID2), 0, 0, (SUM(PAID_DP2)/SUM(PAID2))*100),2) PAID_DP_P2" ).append("\n"); 
		query.append(", SUM(LP_RECOVERED2) LP_RECOVERED2" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(PAID_DP2), 0, 0, (SUM(LP_RECOVERED2)/SUM(PAID_DP2))*100),2) LP_RECOVERED_P2" ).append("\n"); 
		query.append(", SUM(INS_RECOVERED2) INS_RECOVERED2" ).append("\n"); 
		query.append(", ROUND(DECODE (SUM(PAID_DP2), 0, 0, (SUM(INS_RECOVERED2)/SUM(PAID_DP2))*100),2) INS_RECOVERED_P2" ).append("\n"); 
		query.append(", SUM(TOTAL_RECOVERED2) TOTAL_RECOVERED2" ).append("\n"); 
		query.append(", SUM(TOTAL_RECOVERED_P2) TOTAL_RECOVERED_P2" ).append("\n"); 
		query.append(", SUM(NET_PAID2) NET_PAID2" ).append("\n"); 
		query.append(", SUM(NET_PAID_P2) NET_PAID_P2" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  ' ' DATA_SEQ" ).append("\n"); 
		query.append("  , REPORT_BY" ).append("\n"); 
		query.append("  , 'Amount' DIV" ).append("\n"); 
		query.append("  , CLAIMED" ).append("\n"); 
		query.append("  , PAID" ).append("\n"); 
		query.append("  , TIME_BARRED" ).append("\n"); 
		query.append("  , WITHDRAWN" ).append("\n"); 
		query.append("  , REPUDIATED" ).append("\n"); 
		query.append("  , TENDER_DEFENCE" ).append("\n"); 
		query.append("  , DISMISSED" ).append("\n"); 
		query.append("  , TOT" ).append("\n"); 
		query.append("  , OUTSTANDING" ).append("\n"); 
		query.append("  , ROUND (DECODE (CLAIMED, 0, 0, (OUTSTANDING / CLAIMED) * 100), 2) OUTSTANDING_P" ).append("\n"); 
		query.append("  , PAID_DP" ).append("\n"); 
		query.append("  , ROUND (DECODE (PAID, 0, 0, (PAID_DP / PAID) * 100), 2) PAID_DP_P" ).append("\n"); 
		query.append("  , LP_RECOVERED" ).append("\n"); 
		query.append("  , ROUND (DECODE (PAID, 0, 0, (LP_RECOVERED / PAID) * 100), 2) LP_RECOVERED_P" ).append("\n"); 
		query.append("  , INS_RECOVERED" ).append("\n"); 
		query.append("  , ROUND (DECODE (PAID, 0, 0, (INS_RECOVERED / PAID) * 100), 2) INS_RECOVERED_P" ).append("\n"); 
		query.append("  , TOTAL_RECOVERED" ).append("\n"); 
		query.append("  , ROUND (DECODE (PAID, 0, 0, (TOTAL_RECOVERED / PAID) * 100), 2) TOTAL_RECOVERED_P" ).append("\n"); 
		query.append("  , NET_PAID" ).append("\n"); 
		query.append("  , ROUND (DECODE (PAID, 0, 0, (NET_PAID / PAID) * 100), 2) NET_PAID_P" ).append("\n"); 
		query.append("  , ' ' DATA_SEQ2" ).append("\n"); 
		query.append("  , REPORT_BY REPORT_BY2" ).append("\n"); 
		query.append("  , 'Case' DIV2" ).append("\n"); 
		query.append("  , CLAIMED2" ).append("\n"); 
		query.append("  , PAID2" ).append("\n"); 
		query.append("  , TIME_BARRED2" ).append("\n"); 
		query.append("  , WITHDRAWN2" ).append("\n"); 
		query.append("  , REPUDIATED2" ).append("\n"); 
		query.append("  , TENDER_DEFENCE2" ).append("\n"); 
		query.append("  , DISMISSED2" ).append("\n"); 
		query.append("  , TOT2" ).append("\n"); 
		query.append("  , OUTSTANDING2" ).append("\n"); 
		query.append("  , ROUND (DECODE (CLAIMED2, 0, 0, (OUTSTANDING2 / CLAIMED2) * 100), 2) OUTSTANDING_P2" ).append("\n"); 
		query.append("  , PAID_DP2" ).append("\n"); 
		query.append("  , ROUND (DECODE (PAID2, 0, 0, (PAID_DP2 / PAID2) * 100), 2) PAID_DP_P2" ).append("\n"); 
		query.append("  , LP_RECOVERED2" ).append("\n"); 
		query.append("  , ROUND (DECODE (PAID2, 0, 0, (LP_RECOVERED2 / PAID2) * 100), 2) LP_RECOVERED_P2" ).append("\n"); 
		query.append("  , INS_RECOVERED2" ).append("\n"); 
		query.append("  , ROUND (DECODE (PAID2, 0, 0, (INS_RECOVERED2 / PAID2) * 100), 2) INS_RECOVERED_P2" ).append("\n"); 
		query.append("  , '' TOTAL_RECOVERED2" ).append("\n"); 
		query.append("  , '' TOTAL_RECOVERED_P2" ).append("\n"); 
		query.append("  , '' NET_PAID2" ).append("\n"); 
		query.append("  , '' NET_PAID_P2" ).append("\n"); 
		query.append("  , ROW_NUM" ).append("\n"); 
		query.append("  , TOTAL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("----------------------------붙여넣기 시작" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("#if(${report_by} == '30' || ${report_by} == '31' || ${report_by} == '32')--CLAIM_AMOUNT , SETTLED_AMOUNT, MONTH" ).append("\n"); 
		query.append("			TCOL REPORT_BY" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          , CLAIMED" ).append("\n"); 
		query.append("          , NVL (PAID, 0)                         AS PAID" ).append("\n"); 
		query.append("          , NVL (TIME_BARRED, 0)                  AS TIME_BARRED" ).append("\n"); 
		query.append("          , NVL (WITHDRAWN, 0)                    AS WITHDRAWN" ).append("\n"); 
		query.append("          , NVL (REPUDIATED, 0)                   AS REPUDIATED" ).append("\n"); 
		query.append("          , NVL (TENDER_DEFENCE, 0)               AS TENDER_DEFENCE" ).append("\n"); 
		query.append("          , NVL (DISMISSED, 0)                    AS DISMISSED" ).append("\n"); 
		query.append("          , NVL (TOT, 0)                          AS TOT" ).append("\n"); 
		query.append("          , NVL (OUTSTANDING, 0)                  AS OUTSTANDING" ).append("\n"); 
		query.append("          , NVL (PAID_DP, 0)                      AS PAID_DP" ).append("\n"); 
		query.append("          , NVL (LP_RECOVERED, 0)                 AS LP_RECOVERED" ).append("\n"); 
		query.append("          , NVL (INS_RECOVERED, 0)                AS INS_RECOVERED" ).append("\n"); 
		query.append("          , NVL (LP_RECOVERED + INS_RECOVERED, 0) AS TOTAL_RECOVERED" ).append("\n"); 
		query.append("          , (NVL (PAID_DP, 0) - NVL (LP_RECOVERED + INS_RECOVERED, 0)) NET_PAID" ).append("\n"); 
		query.append("          , CLAIMED2" ).append("\n"); 
		query.append("          , NVL (PAID2, 0)                          AS PAID2" ).append("\n"); 
		query.append("          , NVL (TIME_BARRED2, 0)                   AS TIME_BARRED2" ).append("\n"); 
		query.append("          , NVL (WITHDRAWN2, 0)                     AS WITHDRAWN2" ).append("\n"); 
		query.append("          , NVL (REPUDIATED2, 0)                    AS REPUDIATED2" ).append("\n"); 
		query.append("          , NVL (TENDER_DEFENCE2, 0)                AS TENDER_DEFENCE2" ).append("\n"); 
		query.append("          , NVL (DISMISSED2, 0)                     AS DISMISSED2" ).append("\n"); 
		query.append("          , NVL (TOT2, 0)                           AS TOT2" ).append("\n"); 
		query.append("          , NVL (OUTSTANDING2, 0)                   AS OUTSTANDING2" ).append("\n"); 
		query.append("          , NVL (PAID_DP2, 0)                       AS PAID_DP2" ).append("\n"); 
		query.append("          , NVL (LP_RECOVERED2, 0)                  AS LP_RECOVERED2" ).append("\n"); 
		query.append("          , NVL (INS_RECOVERED2, 0)                 AS INS_RECOVERED2" ).append("\n"); 
		query.append("          , NVL (LP_RECOVERED2 + INS_RECOVERED2, 0) AS TOTAL_RECOVERED2" ).append("\n"); 
		query.append("          , (NVL (PAID_DP2, 0) - NVL (LP_RECOVERED2 + INS_RECOVERED2, 0)) NET_PAID2" ).append("\n"); 
		query.append("#if(${report_by} == '30' || ${report_by} == '31' || ${report_by} == '32')--CLAIM_AMOUNT , SETTLED_AMOUNT, MONTH" ).append("\n"); 
		query.append("		  , ROW_NUMBER () OVER (ORDER BY REPORT_BY_SEQ ) ROW_NUM" ).append("\n"); 
		query.append("#else	" ).append("\n"); 
		query.append("		  , ROW_NUMBER () OVER (ORDER BY REPORT_BY ) ROW_NUM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  , COUNT ( *) OVER () TOTAL" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("#if(${report_by} == '01')--AREA" ).append("\n"); 
		query.append("					TBL.CLM_MISC_NM AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '02')--STATUS" ).append("\n"); 
		query.append("					TBL.CLM_MISC_NM AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '03')--HOFC" ).append("\n"); 
		query.append("				    TBL.OFC_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '04')--HANDLER" ).append("\n"); 
		query.append("				    CLM_V.HDLR_USR_ID AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '05')--LP_HOFC" ).append("\n"); 
		query.append("				    TBL.OFC_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '06')--LIABLE_PARTY" ).append("\n"); 
		query.append("				    TBL.CLM_PTY_ABBR_NM AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '07')--SURVEYOR" ).append("\n"); 
		query.append("				    TBL.CLM_PTY_ABBR_NM AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '08')--ROFC" ).append("\n"); 
		query.append("				    FMAL_CLM_RCV_OFC_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '09')--CLAIMANT" ).append("\n"); 
		query.append("				    TBL.PTY_NM AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '10')--CLAIMANT_AGENT" ).append("\n"); 
		query.append("				    TBL.PTY_NM AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '11')--SALVAGER" ).append("\n"); 
		query.append("				    TBL.CLM_PTY_ABBR_NM AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '12')--INSURER" ).append("\n"); 
		query.append("				    TBL.CLM_PTY_ABBR_NM AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '13')--VVD" ).append("\n"); 
		query.append("				    TRNK_REF_VVD_NO AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '14')--POR" ).append("\n"); 
		query.append("				    POR_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '15')--POL" ).append("\n"); 
		query.append("				    POL_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '16')--POD" ).append("\n"); 
		query.append("				    POD_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '17')--DEL" ).append("\n"); 
		query.append("				    DEL_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '18')--FVD" ).append("\n"); 
		query.append("					N1ST_PRE_REF_VVD_NO AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '19')--PRE_POT" ).append("\n"); 
		query.append("					N1ST_PRE_TS_LOC_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '20')--ON_POT" ).append("\n"); 
		query.append("					N1ST_PST_TS_LOC_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '21')--CT" ).append("\n"); 
		query.append("					CRR_TERM_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '22')--POI" ).append("\n"); 
		query.append("				    CLM_INCI_PLC_TP_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '23')--LANE" ).append("\n"); 
		query.append("				    SLAN_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '24')--CARGO" ).append("\n"); 
		query.append("				    CLM_CGO_TP_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '25')--TOC" ).append("\n"); 
		query.append("				    CGO_CLM_TP_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '26')--COLD1" ).append("\n"); 
		query.append("				    MJR_CLM_DMG_LSS_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '27')--CODL2" ).append("\n"); 
		query.append("				    MINR_CLM_DMG_LSS_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '28')--LITIGATION" ).append("\n"); 
		query.append("				    DECODE(SMNS_SVE_DT, NULL, 'N', 'Y' ) AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '29')--TOS" ).append("\n"); 
		query.append("				    CGO_CLM_STL_TP_CD AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '30')--CLAIM_AMOUNT" ).append("\n"); 
		query.append("				CASE WHEN  CLMT_USD_AMT >= 0 AND CLMT_USD_AMT <= 3000 THEN '0 ~ 3,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 3000 AND CLMT_USD_AMT <= 5000 THEN '3,001 ~ 5,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 5000 AND CLMT_USD_AMT <= 10000 THEN '5,001 ~ 10,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 10000 AND CLMT_USD_AMT <= 20000 THEN '10,001 ~ 20,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 20000 AND CLMT_USD_AMT <= 50000 THEN '20,001 ~ 50,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 50000 AND CLMT_USD_AMT <= 100000 THEN '50,001 ~ 100,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 100000 THEN '100,000 ~ '" ).append("\n"); 
		query.append("				END AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '31')--SETTLED_AMOUNT" ).append("\n"); 
		query.append("				CASE WHEN  CGO_CLM_STL_USD_AMT >= 0 AND CGO_CLM_STL_USD_AMT <= 3000 THEN '0 ~ 3,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 3000 AND CGO_CLM_STL_USD_AMT <= 5000 THEN '3,001 ~ 5,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 5000 AND CGO_CLM_STL_USD_AMT <= 10000 THEN '5,001 ~ 10,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 10000 AND CGO_CLM_STL_USD_AMT <= 20000 THEN '10,001 ~ 20,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 20000 AND CGO_CLM_STL_USD_AMT <= 50000 THEN '20,001 ~ 50,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 50000 AND CGO_CLM_STL_USD_AMT <= 100000 THEN '50,001 ~ 100,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 100000 THEN '100,000 ~ '" ).append("\n"); 
		query.append("				END AS REPORT_BY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '32')--MONTH	" ).append("\n"); 
		query.append("			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(CLM_V.UPD_DT,'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.INCI_OCCR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("				  TO_CHAR(TO_DATE(CLM_V.SVEY_INP_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.PRLM_CLM_NTC_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CLM_TM_BAR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LABL_TM_BAR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.FMAL_CLM_RCV_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.FACT_FND_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.SMNS_SVE_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CGO_CLM_STL_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LABL_PTY_RCVR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.INSUR_RCVR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.RCT_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LODG_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.DCHG_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.DE_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CS_CLZ_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '33')--YEAR" ).append("\n"); 
		query.append("			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(CLM_V.UPD_DT,'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.INCI_OCCR_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("				  TO_CHAR(TO_DATE(CLM_V.SVEY_INP_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.PRLM_CLM_NTC_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CLM_TM_BAR_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LABL_TM_BAR_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.FMAL_CLM_RCV_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.FACT_FND_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.SMNS_SVE_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CGO_CLM_STL_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LABL_PTY_RCVR_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.INSUR_RCVR_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.RCT_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LODG_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.DCHG_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.DE_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CS_CLZ_DT,'YYYYMMDD'),'YYYY') AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    --, 'Amount'                                                                                                                                                                  " ).append("\n"); 
		query.append("                  , SUM (CLMT_USD_AMT)                                                                                                                                                            AS CLAIMED" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_TP_CD, 'PD', CLMT_USD_AMT, 'CM', CLMT_USD_AMT))                                                                                                      AS PAID" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_TP_CD, 'TB', CLMT_USD_AMT))                                                                                                                          AS TIME_BARRED" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_TP_CD, 'WD', CLMT_USD_AMT))                                                                                                                          AS WITHDRAWN" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_TP_CD, 'RP', CLMT_USD_AMT))                                                                                                                          AS REPUDIATED" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_TP_CD, 'TD', CLMT_USD_AMT))                                                                                                                          AS TENDER_DEFENCE" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_TP_CD, 'DS', CLMT_USD_AMT))                                                                                                                          AS DISMISSED" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_TP_CD, 'PD', CLMT_USD_AMT, 'CM', CLMT_USD_AMT, 'TB', CLMT_USD_AMT, 'WD', CLMT_USD_AMT, 'RP', CLMT_USD_AMT, 'TD', CLMT_USD_AMT, 'DS', CLMT_USD_AMT))                      AS TOT" ).append("\n"); 
		query.append("                  , SUM (CLMT_USD_AMT) - SUM (DECODE (CGO_CLM_STL_TP_CD, 'PD', CLMT_USD_AMT, 'CM', CLMT_USD_AMT, 'TB', CLMT_USD_AMT, 'WD', CLMT_USD_AMT, 'RP', CLMT_USD_AMT, 'TD', CLMT_USD_AMT, 'DS', CLMT_USD_AMT)) AS OUTSTANDING" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_TP_CD, 'PD', CGO_CLM_STL_USD_AMT, 'CM', CGO_CLM_STL_USD_AMT)) PAID_DP" ).append("\n"); 
		query.append("                  , SUM (LABL_PTY_RCVR_USD_AMT) AS LP_RECOVERED" ).append("\n"); 
		query.append("                  , SUM (INSUR_RCVR_USD_AMT)    AS INS_RECOVERED" ).append("\n"); 
		query.append("                    --, 'Case'                                                                                                                                                          " ).append("\n"); 
		query.append("                  , COUNT (CLM_V.CGO_CLM_NO)                                                                                                                                                  AS CLAIMED2" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_STL_TP_CD, 'PD', CLM_V.CGO_CLM_NO, 'CM', CLM_V.CGO_CLM_NO))                                                                                        AS PAID2" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_STL_TP_CD, 'TB', CLM_V.CGO_CLM_NO))                                                                                                                AS TIME_BARRED2" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_STL_TP_CD, 'WD', CLM_V.CGO_CLM_NO))                                                                                                                AS WITHDRAWN2" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_STL_TP_CD, 'RP', CLM_V.CGO_CLM_NO))                                                                                                                AS REPUDIATED2" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_STL_TP_CD, 'TD', CLM_V.CGO_CLM_NO))                                                                                                                AS TENDER_DEFENCE2" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_STL_TP_CD, 'DS', CLM_V.CGO_CLM_NO))                                                                                                                AS DISMISSED2" ).append("\n"); 
		query.append("                  , COUNT (DECODE (CGO_CLM_STL_TP_CD, 'PD', CLM_V.CGO_CLM_NO, 'CM', CLM_V.CGO_CLM_NO, 'TB', CLM_V.CGO_CLM_NO, 'WD', CLM_V.CGO_CLM_NO, 'RP', CLM_V.CGO_CLM_NO, 'TD', CLM_V.CGO_CLM_NO, 'DS', CLM_V.CGO_CLM_NO))                      AS TOT2" ).append("\n"); 
		query.append("                  , COUNT (CLM_V.CGO_CLM_NO) - COUNT (DECODE (CGO_CLM_STL_TP_CD, 'PD', CLM_V.CGO_CLM_NO, 'CM', CLM_V.CGO_CLM_NO, 'TB', CLM_V.CGO_CLM_NO, 'WD', CLM_V.CGO_CLM_NO, 'RP', CLM_V.CGO_CLM_NO, 'TD', CLM_V.CGO_CLM_NO, 'DS', CLM_V.CGO_CLM_NO)) AS OUTSTANDING2" ).append("\n"); 
		query.append("                  , SUM (DECODE (CGO_CLM_STL_USD_AMT, 0, 0, NULL, 0, 1)) AS PAID_DP2 -- 0을 제외할경우" ).append("\n"); 
		query.append("			      , SUM (DECODE (LABL_PTY_RCVR_USD_AMT, 0, 0, NULL, 0, 1)) AS LP_RECOVERED2 " ).append("\n"); 
		query.append("                  , SUM (DECODE (INSUR_RCVR_USD_AMT, 0, 0, NULL, 0, 1))    AS INS_RECOVERED2" ).append("\n"); 
		query.append("				  --, COUNT (CGO_CLM_STL_USD_AMT)   AS PAID_DP2 -- 0을 포함할경우" ).append("\n"); 
		query.append("				  --, COUNT (LABL_PTY_RCVR_USD_AMT) AS LP_RECOVERED2 " ).append("\n"); 
		query.append("                  --, COUNT (INSUR_RCVR_USD_AMT)    AS INS_RECOVERED2" ).append("\n"); 
		query.append("                FROM" ).append("\n"); 
		query.append("                    CNI_CLM_V CLM_V" ).append("\n"); 
		query.append("		   		  , CNI_PARTY PARTY1" ).append("\n"); 
		query.append("		   	   	  , CNI_PARTY PARTY2" ).append("\n"); 
		query.append("		   		  , CNI_PARTY PARTY3" ).append("\n"); 
		query.append("		   		  , CNI_PARTY PARTY4" ).append("\n"); 
		query.append("		   		  , CNI_PARTY PARTY5" ).append("\n"); 
		query.append("		   		  , CNI_PARTY PARTY6" ).append("\n"); 
		query.append("		   		  , CNI_PARTY PARTY7  " ).append("\n"); 
		query.append("		   		  , (SELECT  A.CGO_CLM_NO" ).append("\n"); 
		query.append("                                 ,A.CGO_CLM_REF_BL_NO" ).append("\n"); 
		query.append("                            FROM  CNI_CGO_CLM_BL_DTL A" ).append("\n"); 
		query.append("                                 ,BKG_BOOKING B" ).append("\n"); 
		query.append("                           WHERE A.CGO_CLM_REF_BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("                             AND A.MN_BL_FLG = 'Y' --대표 B/L 번호" ).append("\n"); 
		query.append("                     ) BL_DTL" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                      SELECT A.CGO_CLM_NO" ).append("\n"); 
		query.append("                            ,A.CGO_CLM_REF_BL_NO " ).append("\n"); 
		query.append("                            ,A.CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("                            ,B.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("                      FROM (" ).append("\n"); 
		query.append("                            SELECT A.CGO_CLM_NO" ).append("\n"); 
		query.append("                                  ,A.CGO_CLM_REF_BL_NO " ).append("\n"); 
		query.append("                                  ,A.CGO_CLM_REF_CNTR_NO" ).append("\n"); 
		query.append("                                  ,B.BKG_NO      " ).append("\n"); 
		query.append("                              FROM CNI_CGO_CLM_CNTR_DTL A" ).append("\n"); 
		query.append("                                  ,BKG_BOOKING B" ).append("\n"); 
		query.append("                             WHERE A.CGO_CLM_REF_BL_NO = B.BL_NO(+)" ).append("\n"); 
		query.append("                               AND A.MN_CNTR_FLG = 'Y' --대표 컨테이너 번호" ).append("\n"); 
		query.append("                           ) A" ).append("\n"); 
		query.append("                          ,BKG_CONTAINER B" ).append("\n"); 
		query.append("                     WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("                       AND A.CGO_CLM_REF_CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("                  ) CNTR_DTL" ).append("\n"); 
		query.append("                  ,(" ).append("\n"); 
		query.append("                       SELECT A.CGO_CLM_NO, A.HDLR_USR_ID " ).append("\n"); 
		query.append("                        FROM CNI_CGO_CLM_HDLR_HIS A ," ).append("\n"); 
		query.append("                             (SELECT CGO_CLM_NO, MAX(CGO_CLM_HDLR_HIS_SEQ) CGO_CLM_HDLR_HIS_SEQ FROM  CNI_CGO_CLM_HDLR_HIS WHERE MGR_HDLR_DIV_CD = 'M' GROUP BY CGO_CLM_NO) B" ).append("\n"); 
		query.append("                       WHERE A.CGO_CLM_NO = B.CGO_CLM_NO" ).append("\n"); 
		query.append("                         AND A.MGR_HDLR_DIV_CD = 'M'" ).append("\n"); 
		query.append("                         AND A.CGO_CLM_HDLR_HIS_SEQ = B.CGO_CLM_HDLR_HIS_SEQ" ).append("\n"); 
		query.append("                  ) MGR" ).append("\n"); 
		query.append("#if(${report_by} == '01')--AREA" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = '09'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE CLM_AREA_CD      = TBL.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND CLM_AREA_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '02')--STATUS" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = '08'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE CGO_CLM_STS_CD      = TBL.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND CGO_CLM_STS_CD IS NOT NULL            " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '03')--HOFC" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("							OFC_ENG_NM" ).append("\n"); 
		query.append("							, OFC_CD" ).append("\n"); 
		query.append("						FROM" ).append("\n"); 
		query.append("							MDM_ORGANIZATION" ).append("\n"); 
		query.append("						WHERE " ).append("\n"); 
		query.append("							DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE HDLR_OFC_CD      = TBL.OFC_CD" ).append("\n"); 
		query.append("				AND HDLR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '04')--HANDLER" ).append("\n"); 
		query.append("				WHERE CLM_V.HDLR_USR_ID IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '05')--LP_HOFC" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("							OFC_ENG_NM" ).append("\n"); 
		query.append("							, OFC_CD" ).append("\n"); 
		query.append("						FROM" ).append("\n"); 
		query.append("							MDM_ORGANIZATION" ).append("\n"); 
		query.append("						WHERE " ).append("\n"); 
		query.append("							DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE HNDL_OFC_CD      = TBL.OFC_CD" ).append("\n"); 
		query.append("				AND HNDL_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '06')--LIABLE_PARTY" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("							CLM_PTY_NO" ).append("\n"); 
		query.append("							, CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("						FROM" ).append("\n"); 
		query.append("							CNI_PARTY" ).append("\n"); 
		query.append("						WHERE " ).append("\n"); 
		query.append("							DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE LABL_CLM_PTY_NO  = TBL.CLM_PTY_NO" ).append("\n"); 
		query.append("				AND LABL_CLM_PTY_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '07')--SURVEYOR" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("							CLM_PTY_NO" ).append("\n"); 
		query.append("							, CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("						FROM" ).append("\n"); 
		query.append("							CNI_PARTY" ).append("\n"); 
		query.append("						WHERE " ).append("\n"); 
		query.append("							DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE SVEY_CLM_PTY_NO  = TBL.CLM_PTY_NO" ).append("\n"); 
		query.append("				AND SVEY_CLM_PTY_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '08')--ROFC" ).append("\n"); 
		query.append("				WHERE FMAL_CLM_RCV_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '09')--CLAIMANT" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("							CLM_PTY_NO" ).append("\n"); 
		query.append("							, PTY_NM" ).append("\n"); 
		query.append("						FROM" ).append("\n"); 
		query.append("							CNI_PARTY" ).append("\n"); 
		query.append("						WHERE " ).append("\n"); 
		query.append("							DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE CLMT_CLM_PTY_NO  = TBL.CLM_PTY_NO" ).append("\n"); 
		query.append("				AND CLMT_CLM_PTY_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '10')--CLAIMANT_AGENT" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("							CLM_PTY_NO" ).append("\n"); 
		query.append("							, PTY_NM" ).append("\n"); 
		query.append("						FROM" ).append("\n"); 
		query.append("							CNI_PARTY" ).append("\n"); 
		query.append("						WHERE " ).append("\n"); 
		query.append("							DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE CLM_AGN_CLM_PTY_NO  = TBL.CLM_PTY_NO" ).append("\n"); 
		query.append("				AND CLM_AGN_CLM_PTY_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '11')--SALVAGER" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("							CLM_PTY_NO" ).append("\n"); 
		query.append("							, CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("						FROM" ).append("\n"); 
		query.append("							CNI_PARTY" ).append("\n"); 
		query.append("						WHERE " ).append("\n"); 
		query.append("							DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE SLV_CLM_PTY_NO  = TBL.CLM_PTY_NO" ).append("\n"); 
		query.append("				AND SLV_CLM_PTY_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '12')--INSURER" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("							CLM_PTY_NO" ).append("\n"); 
		query.append("							, CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("						FROM" ).append("\n"); 
		query.append("							CNI_PARTY" ).append("\n"); 
		query.append("						WHERE " ).append("\n"); 
		query.append("							DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("                WHERE INSUR_CLM_PTY_NO   = TBL.CLM_PTY_NO" ).append("\n"); 
		query.append("				AND INSUR_CLM_PTY_NO  IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '13')--VVD" ).append("\n"); 
		query.append("				WHERE TRNK_REF_VVD_NO IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '14')--POR" ).append("\n"); 
		query.append("				WHERE POR_CD IS NOT NULL AND ASCII(POR_CD) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '15')--POL" ).append("\n"); 
		query.append("				WHERE POL_CD IS NOT NULL AND ASCII(POL_CD) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '16')--POD" ).append("\n"); 
		query.append("				WHERE POD_CD IS NOT NULL AND ASCII(POD_CD) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '17')--DEL" ).append("\n"); 
		query.append("				WHERE DEL_CD IS NOT NULL AND ASCII(DEL_CD) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '18')--FVD" ).append("\n"); 
		query.append("				WHERE TRIM(N1ST_PRE_REF_VVD_NO) IS NOT NULL AND ASCII(N1ST_PRE_REF_VVD_NO) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '19')--PRE_POT" ).append("\n"); 
		query.append("				WHERE TRIM(N1ST_PRE_TS_LOC_CD) IS NOT NULL AND ASCII(N1ST_PRE_TS_LOC_CD) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '20')--ON_POT" ).append("\n"); 
		query.append("				WHERE TRIM(N1ST_PST_TS_LOC_CD) IS NOT NULL AND ASCII(N1ST_PST_TS_LOC_CD) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '21')--CT" ).append("\n"); 
		query.append("				WHERE CRR_TERM_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '22')--POI" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = '14'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("				WHERE CLM_INCI_PLC_TP_CD  = TBL.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND CLM_INCI_PLC_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '23')--LANE" ).append("\n"); 
		query.append("				WHERE SLAN_CD IS NOT NULL AND ASCII(SLAN_CD) > 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '24')--CARGO" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = '15'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("				WHERE CLM_CGO_TP_CD  = TBL.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND CLM_CGO_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '25')--TOC" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = '11'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("				WHERE CGO_CLM_TP_CD  = TBL.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND CGO_CLM_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '26')--COLD1" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = '02'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("				WHERE MJR_CLM_DMG_LSS_CD  = TBL.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND MJR_CLM_DMG_LSS_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '27')--COLD2" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = '05'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("				WHERE MINR_CLM_DMG_LSS_CD  = TBL.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND MINR_CLM_DMG_LSS_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '28')--LITIGATION" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '29')--TOS" ).append("\n"); 
		query.append("                  , (" ).append("\n"); 
		query.append("                        SELECT" ).append("\n"); 
		query.append("                            CLM_MISC_NM" ).append("\n"); 
		query.append("                          , CLM_MISC_CD" ).append("\n"); 
		query.append("                        FROM" ).append("\n"); 
		query.append("                            CNI_MISC_CD" ).append("\n"); 
		query.append("                        WHERE" ).append("\n"); 
		query.append("                            CLSS_CLM_MISC_CD = '07'" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("                    TBL" ).append("\n"); 
		query.append("				WHERE CGO_CLM_STL_TP_CD  = TBL.CLM_MISC_CD" ).append("\n"); 
		query.append("				AND CGO_CLM_STL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '30')--CLAIM_AMOUNT " ).append("\n"); 
		query.append("				WHERE CLMT_USD_AMT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '31')--SETTLED_AMOUNT" ).append("\n"); 
		query.append("				WHERE CGO_CLM_STL_USD_AMT IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '32' || ${report_by} == '33')--MONTH, YEAR" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--COMMON START" ).append("\n"); 
		query.append("				  AND CGO_CLM_STL_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("				  AND CLM_V.CLMT_CLM_PTY_NO      = PARTY1.CLM_PTY_NO(+)    " ).append("\n"); 
		query.append("				  AND CLM_V.CLM_AGN_CLM_PTY_NO   = PARTY2.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("				  AND CLM_V.DEFT_ATTY_CLM_PTY_NO = PARTY3.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("				  AND CLM_V.INSUR_CLM_PTY_NO     = PARTY4.CLM_PTY_NO(+)" ).append("\n"); 
		query.append("				  AND CLM_V.SLV_CLM_PTY_NO       = PARTY5.CLM_PTY_NO(+)  " ).append("\n"); 
		query.append("				  AND CLM_V.SVEY_CLM_PTY_NO      = PARTY6.CLM_PTY_NO(+) " ).append("\n"); 
		query.append("				  AND CLM_V.LABL_CLM_PTY_NO      = PARTY7.CLM_PTY_NO(+) " ).append("\n"); 
		query.append("  				  AND CLM_V.CGO_CLM_NO           = BL_DTL.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("  				  AND CLM_V.CGO_CLM_NO           = CNTR_DTL.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("  				  AND CLM_V.CGO_CLM_NO           = MGR.CGO_CLM_NO(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD') BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.INCI_OCCR_DT BETWEEN @[from_period]  AND @[to_period]" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.SVEY_INP_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.PRLM_CLM_NTC_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CLM_TM_BAR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.LABL_TM_BAR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.FMAL_CLM_RCV_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.FACT_FND_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.SMNS_SVE_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_STL_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.LABL_PTY_RCVR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.INSUR_RCVR_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.RCT_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.LODG_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.DCHG_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.DE_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CS_CLZ_DT BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  #if(${area} != 'All' && ${area} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CLM_AREA_CD = @[area] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${status} != 'All' && ${status} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_STS_CD = @[status] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${vt} != 'All' && ${vt} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_DIV_CD = @[vt] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${hdlr_ofc_cd} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.HDLR_OFC_CD = @[hdlr_ofc_cd] -- HOFC" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${hdlr_usr_id} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.HDLR_USR_ID = @[hdlr_usr_id] -- Handler" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${mgr_usr_id} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.HDLR_OFC_CD = @[mgr_usr_id] -- Manager" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${hndl_ofc_cd} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.HNDL_OFC_CD = @[hndl_ofc_cd] -- LP HOFC" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${labl_clm_pty_no} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.LABL_CLM_PTY_NO = @[labl_clm_pty_no] -- Liable Party" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${svey_clm_pty_no} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.SVEY_CLM_PTY_NO = @[svey_clm_pty_no] -- Surveyor" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${fmal_clm_rcv_ofc_cd} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.FMAL_CLM_RCV_OFC_CD = @[fmal_clm_rcv_ofc_cd] -- ROFC" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${clmt_clm_pty_no} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.CLMT_CLM_PTY_NO = @[clmt_clm_pty_no] -- Claimant" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${clmt_clm_agn_pty_no} != '') " ).append("\n"); 
		query.append("			      AND CLM_V.CLM_AGN_CLM_PTY_NO = @[clmt_clm_agn_pty_no] -- Agent" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${slv_clm_pty_no} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.SLV_CLM_PTY_NO = @[slv_clm_pty_no] -- Salvager" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${insur_clm_pty_no} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.INSUR_CLM_PTY_NO = @[insur_clm_pty_no] -- Insurer" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${clm_stl_auth_usr_id} != '')  " ).append("\n"); 
		query.append("			      AND CLM_V.CLM_STL_AUTH_USR_ID = @[clm_stl_auth_usr_id] -- Approver " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${trnk_ref_vvd_no} != '') " ).append("\n"); 
		query.append("			      AND CLM_V.TRNK_REF_VVD_NO LIKE @[trnk_ref_vvd_no]||'%' -- VVD" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${por_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.POR_CD = @[por_cd]  -- POR" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${pol_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.POL_CD = @[pol_cd]  -- POL" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${pod_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.POD_CD = @[pod_cd] -- POD" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${del_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.DEL_CD = @[del_cd] -- DEL" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${fvd} != '') " ).append("\n"); 
		query.append("			      AND CLM_V.N1ST_PRE_REF_VVD_NO = @[fvd]  -- FVD" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${n1st_pre_ts_loc_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.N1ST_PRE_TS_LOC_CD = @[n1st_pre_ts_loc_cd] -- PRE_POT" ).append("\n"); 
		query.append("			  #end  " ).append("\n"); 
		query.append("			  #if(${n1st_pst_ts_loc_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.N1ST_PST_TS_LOC_CD = @[n1st_pst_ts_loc_cd]  -- POS_POT" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${crr_term_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CRR_TERM_CD = @[crr_term_cd] -- CT" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${inci_plc_tp_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.INCI_PLC_TP_CD = @[inci_plc_tp_cd] --POI " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${slan_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.SLAN_CD = @[slan_cd]  -- Lane" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${clm_cgo_tp_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CLM_CGO_TP_CD = @[clm_cgo_tp_cd]  --Cargo" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${cgo_clm_tp_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_TP_CD = @[cgo_clm_tp_cd]  -- TOC" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${mjr_clm_dmg_lss_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.MJR_CLM_DMG_LSS_CD = @[mjr_clm_dmg_lss_cd]  --CODL1" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${minr_clm_dmg_lss_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.MINR_CLM_DMG_LSS_CD = @[minr_clm_dmg_lss_cd] --CODL2" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${lit} == 'Y')" ).append("\n"); 
		query.append("			      AND CLM_V.SMNS_SVE_DT <> ''  -- Litigation" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${cgo_clm_stl_tp_cd} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_STL_TP_CD = @[cgo_clm_stl_tp_cd]  -- TOS" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${from_clmt_usd_amt} != '' &&  ${to_clmt_usd_amt} !='')" ).append("\n"); 
		query.append("			      AND CLM_V.CLMT_USD_AMT BETWEEN @[from_clmt_usd_amt] AND @[to_clmt_usd_amt] -- Claim Amount" ).append("\n"); 
		query.append("			  #elseif(${from_clmt_usd_amt} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CLMT_USD_AMT >= @[from_clmt_usd_amt] -- Claim Amount" ).append("\n"); 
		query.append("			  #elseif(${to_clmt_usd_amt} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CLMT_USD_AMT < @[to_clmt_usd_amt] -- Claim Amount" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${from_cgo_clm_stl_usd_amt} != '' &&  ${to_cgo_clm_stl_usd_amt} !='')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_STL_USD_AMT BETWEEN @[from_cgo_clm_stl_usd_amt]  AND @[to_cgo_clm_stl_usd_amt]   -- Settled Amount" ).append("\n"); 
		query.append("			  #elseif(${from_cgo_clm_stl_usd_amt} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_STL_USD_AMT >= @[from_cgo_clm_stl_usd_amt] -- Settled Amount" ).append("\n"); 
		query.append("			  #elseif(${to_cgo_clm_stl_usd_amt} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_STL_USD_AMT < @[to_cgo_clm_stl_usd_amt] -- Settled Amount" ).append("\n"); 
		query.append("			  #end   " ).append("\n"); 
		query.append("			  #if(${cgo_clm_inci_no} != '')" ).append("\n"); 
		query.append("			      AND CLM_V.CGO_CLM_INCI_NO = @[cgo_clm_inci_no]  -- INC No." ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("--COMMON END" ).append("\n"); 
		query.append("--GROUP BY START" ).append("\n"); 
		query.append("#if(${report_by} == '01')--AREA" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    TBL.CLM_MISC_NM              " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '02')--STATUS" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    TBL.CLM_MISC_NM  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '03')--HOFC" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("				    TBL.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '04')--HANDLER" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					CLM_V.HDLR_USR_ID" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '05')--LP_HOFC" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("				    TBL.OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '06')--LIABLE_PARTY" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("				    TBL.CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '07')--SURVEYOR" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("				    TBL.CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '08')--ROFC" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					FMAL_CLM_RCV_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '09')--CLAIMANT" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("				    TBL.PTY_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '10')--CLAIMANT_AGENT" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("				    TBL.PTY_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '11')--SALVAGER" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("				    TBL.CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '12')--INSURER" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("				    TBL.CLM_PTY_ABBR_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '13')--VVD" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					TRNK_REF_VVD_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '14')--POR" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					POR_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '15')--POL" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					POL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '16')--POD" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '17')--DEL" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					DEL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '18')--FVD" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					N1ST_PRE_REF_VVD_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '19')--PRE_POT" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					N1ST_PRE_TS_LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '20')--ON_POT" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					N1ST_PST_TS_LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '21')--CT" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					CRR_TERM_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '22')--POI" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    CLM_INCI_PLC_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '23')--LANE" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					SLAN_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '24')--CARGO" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    CLM_CGO_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '25')--TOC" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    CGO_CLM_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '26')--COLD1" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    MJR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '27')--COLD2" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    MINR_CLM_DMG_LSS_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '28')--LITIGATION" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("					DECODE(SMNS_SVE_DT, NULL, 'N', 'Y' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '29')--TOS" ).append("\n"); 
		query.append("                GROUP BY" ).append("\n"); 
		query.append("                    CGO_CLM_STL_TP_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '30')--CLAIM_AMOUNT" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("				CASE WHEN  CLMT_USD_AMT >= 0 AND CLMT_USD_AMT <= 3000 THEN '0 ~ 3,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 3000 AND CLMT_USD_AMT <= 5000 THEN '3,001 ~ 5,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 5000 AND CLMT_USD_AMT <= 10000 THEN '5,001 ~ 10,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 10000 AND CLMT_USD_AMT <= 20000 THEN '10,001 ~ 20,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 20000 AND CLMT_USD_AMT <= 50000 THEN '20,001 ~ 50,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 50000 AND CLMT_USD_AMT <= 100000 THEN '50,001 ~ 100,000'" ).append("\n"); 
		query.append("					WHEN CLMT_USD_AMT > 100000 THEN '100,000 ~ '" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '31')--SETTLED_AMOUNT" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("				CASE WHEN  CGO_CLM_STL_USD_AMT >= 0 AND CGO_CLM_STL_USD_AMT <= 3000 THEN '0 ~ 3,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 3000 AND CGO_CLM_STL_USD_AMT <= 5000 THEN '3,001 ~ 5,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 5000 AND CGO_CLM_STL_USD_AMT <= 10000 THEN '5,001 ~ 10,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 10000 AND CGO_CLM_STL_USD_AMT <= 20000 THEN '10,001 ~ 20,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 20000 AND CGO_CLM_STL_USD_AMT <= 50000 THEN '20,001 ~ 50,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 50000 AND CGO_CLM_STL_USD_AMT <= 100000 THEN '50,001 ~ 100,000'" ).append("\n"); 
		query.append("					WHEN CGO_CLM_STL_USD_AMT > 100000 THEN '100,000 ~ '" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '32')--MONTH" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(CLM_V.UPD_DT,'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.INCI_OCCR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("				  TO_CHAR(TO_DATE(CLM_V.SVEY_INP_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.PRLM_CLM_NTC_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CLM_TM_BAR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LABL_TM_BAR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.FMAL_CLM_RCV_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.FACT_FND_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.SMNS_SVE_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CGO_CLM_STL_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LABL_PTY_RCVR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.INSUR_RCVR_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.RCT_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LODG_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.DCHG_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.DE_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CS_CLZ_DT,'YYYYMMDD'),'Mon', 'NLS_DATE_LANGUAGE=AMERICAN')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '33')--YEAR" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(CLM_V.UPD_DT,'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.INCI_OCCR_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("				  TO_CHAR(TO_DATE(CLM_V.SVEY_INP_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.PRLM_CLM_NTC_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CLM_TM_BAR_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LABL_TM_BAR_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.FMAL_CLM_RCV_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.FACT_FND_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.SMNS_SVE_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CGO_CLM_STL_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LABL_PTY_RCVR_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.INSUR_RCVR_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.RCT_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.LODG_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.DCHG_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.DE_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("				TO_CHAR(TO_DATE(CLM_V.CS_CLZ_DT,'YYYYMMDD'),'YYYY')" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--GROUP BY END" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#if(${report_by} == '30' || ${report_by} == '31')--CLAIM_AMOUNT or SETTLED_AMOUNT" ).append("\n"); 
		query.append("			,(" ).append("\n"); 
		query.append("                    SELECT '0 ~ 3,000' TCOL, 1 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL " ).append("\n"); 
		query.append("                    SELECT '3,001 ~ 50,000' TCOL, 2 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL " ).append("\n"); 
		query.append("                    SELECT '5,001 ~ 10,000' TCOL, 3 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL " ).append("\n"); 
		query.append("                    SELECT '10,001 ~ 20,000' TCOL, 4 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL " ).append("\n"); 
		query.append("                    SELECT '20,001 ~ 50,000' TCOL, 5 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL " ).append("\n"); 
		query.append("                    SELECT '50,001 ~ 100,000' TCOL, 6 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL " ).append("\n"); 
		query.append("                    SELECT '100,000 ~ ' TCOL, 7 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("              ) TBL" ).append("\n"); 
		query.append("              WHERE REPORT_BY(+) = TBL.TCOL " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${report_by} == '32')--MONTH" ).append("\n"); 
		query.append("			,(" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('01','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 1 REPORT_BY_SEQ  FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('02','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 2 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('03','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 3 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('04','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 4 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('05','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 5 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('06','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 6 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('07','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 7 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('08','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 8 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('09','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 9 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('10','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 10 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('11','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 11 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT TO_CHAR(to_date('12','MM'), 'Mon', 'NLS_DATE_LANGUAGE=AMERICAN') TCOL, 12 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("              ) TBL" ).append("\n"); 
		query.append("              WHERE REPORT_BY(+) = TBL.TCOL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("----------------------------붙여넣기 끝" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("		#if (${start_page} != '') " ).append("\n"); 
		query.append("		WHERE ROW_NUM BETWEEN 1 AND ${end_page}" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}