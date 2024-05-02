/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerCargoClaimReportDBDAOSearchSettlementAnalysisSubTtlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.03.08 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerCargoClaimReportDBDAOSearchSettlementAnalysisSubTtlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Report By Month 경우 분기별 Sub Total 조회
	  * </pre>
	  */
	public ContainerCargoClaimReportDBDAOSearchSettlementAnalysisSubTtlListRSQL(){
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
		query.append("FileName : ContainerCargoClaimReportDBDAOSearchSettlementAnalysisSubTtlListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  ROWNUM DATA_SEQ" ).append("\n"); 
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
		query.append("  , ROWNUM DATA_SEQ2" ).append("\n"); 
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
		query.append("----------------------------MONTH 일경우 내부쿼리 시작" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("#if(${report_by} == '32')--MONTH" ).append("\n"); 
		query.append("			TCOL REPORT_BY" ).append("\n"); 
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
		query.append("#if(${report_by} == '32')--MONTH" ).append("\n"); 
		query.append("		  , ROW_NUMBER () OVER (ORDER BY REPORT_BY_SEQ ) ROW_NUM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		  , COUNT ( *) OVER () TOTAL" ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("#if(${report_by} == '32')--MONTH	" ).append("\n"); 
		query.append("			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD'),5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD'),5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD'),5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD'),5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.INCI_OCCR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INCI_OCCR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INCI_OCCR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INCI_OCCR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.SVEY_INP_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SVEY_INP_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SVEY_INP_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SVEY_INP_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.PRLM_CLM_NTC_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.PRLM_CLM_NTC_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.PRLM_CLM_NTC_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.PRLM_CLM_NTC_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.CLM_TM_BAR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CLM_TM_BAR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CLM_TM_BAR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CLM_TM_BAR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.LABL_TM_BAR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_TM_BAR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_TM_BAR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_TM_BAR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.FMAL_CLM_RCV_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FMAL_CLM_RCV_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FMAL_CLM_RCV_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FMAL_CLM_RCV_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.FACT_FND_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FACT_FND_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FACT_FND_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FACT_FND_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.SMNS_SVE_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SMNS_SVE_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SMNS_SVE_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SMNS_SVE_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.CGO_CLM_STL_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CGO_CLM_STL_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CGO_CLM_STL_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CGO_CLM_STL_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.LABL_PTY_RCVR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_PTY_RCVR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_PTY_RCVR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_PTY_RCVR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.INSUR_RCVR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INSUR_RCVR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INSUR_RCVR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INSUR_RCVR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.RCT_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.RCT_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.RCT_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.RCT_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.LODG_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LODG_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LODG_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LODG_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.DCHG_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DCHG_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DCHG_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DCHG_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.DE_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DE_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DE_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DE_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.CS_CLZ_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CS_CLZ_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CS_CLZ_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CS_CLZ_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END AS REPORT_BY" ).append("\n"); 
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
		query.append("                             AND A.MN_BL_FLG = 'Y' --대표 B/L 번호 " ).append("\n"); 
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
		query.append("#if(${report_by} == '32')" ).append("\n"); 
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
		query.append("			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND TO_CHAR(CLM_V.UPD_DT,'YYYY') BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.INCI_OCCR_DT,1,4) BETWEEN @[from_period]  AND @[to_period]" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.SVEY_INP_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.PRLM_CLM_NTC_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.CLM_TM_BAR_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.LABL_TM_BAR_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.FMAL_CLM_RCV_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.FACT_FND_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.SMNS_SVE_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.CGO_CLM_STL_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.LABL_PTY_RCVR_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.INSUR_RCVR_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.RCT_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.LODG_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.DCHG_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.DE_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("			      AND SUBSTR(CLM_V.CS_CLZ_DT,1,4) BETWEEN @[from_period]  AND @[to_period] " ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
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
		query.append("#if(${report_by} == '32')--MONTH" ).append("\n"); 
		query.append("				GROUP BY" ).append("\n"); 
		query.append("			  #if(${period} == 'DOU' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD'),5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD'),5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD'),5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(TO_CHAR(CLM_V.UPD_DT,'YYYYMMDD'),5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOI' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.INCI_OCCR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INCI_OCCR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INCI_OCCR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INCI_OCCR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSV' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.SVEY_INP_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SVEY_INP_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SVEY_INP_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SVEY_INP_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end " ).append("\n"); 
		query.append("			  #if(${period} == 'DON' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.PRLM_CLM_NTC_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.PRLM_CLM_NTC_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.PRLM_CLM_NTC_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.PRLM_CLM_NTC_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTB' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.CLM_TM_BAR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CLM_TM_BAR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CLM_TM_BAR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CLM_TM_BAR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOTBLP' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.LABL_TM_BAR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_TM_BAR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_TM_BAR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_TM_BAR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOF' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.FMAL_CLM_RCV_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FMAL_CLM_RCV_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FMAL_CLM_RCV_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FMAL_CLM_RCV_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOFF' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.FACT_FND_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FACT_FND_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FACT_FND_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.FACT_FND_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOSS' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.SMNS_SVE_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SMNS_SVE_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SMNS_SVE_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.SMNS_SVE_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOS' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.CGO_CLM_STL_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CGO_CLM_STL_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CGO_CLM_STL_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CGO_CLM_STL_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORLP' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.LABL_PTY_RCVR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_PTY_RCVR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_PTY_RCVR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LABL_PTY_RCVR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DORINS' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.INSUR_RCVR_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INSUR_RCVR_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INSUR_RCVR_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.INSUR_RCVR_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOR' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.RCT_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.RCT_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.RCT_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.RCT_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOL' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.LODG_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LODG_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LODG_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.LODG_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOD' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.DCHG_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DCHG_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DCHG_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DCHG_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DDL' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.DE_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DE_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DE_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.DE_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("			  #if(${period} == 'DOC' && ${from_period} != '')" ).append("\n"); 
		query.append("					CASE WHEN  SUBSTR(CLM_V.CS_CLZ_DT,5,2) BETWEEN '01' AND '03' THEN '1/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CS_CLZ_DT,5,2) BETWEEN '04' AND '06' THEN '2/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CS_CLZ_DT,5,2) BETWEEN '07' AND '09' THEN '3/4 TTL'" ).append("\n"); 
		query.append("						WHEN SUBSTR(CLM_V.CS_CLZ_DT,5,2) BETWEEN '10' AND '12' THEN '4/4 TTL'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--GROUP BY END" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("#if(${report_by} == '32')--MONTH" ).append("\n"); 
		query.append("			,(" ).append("\n"); 
		query.append("                    SELECT '1/4 TTL' TCOL, 1 REPORT_BY_SEQ  FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT '2/4 TTL' TCOL, 2 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT '3/4 TTL' TCOL, 3 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("                    UNION ALL" ).append("\n"); 
		query.append("                    SELECT '4/4 TTL' TCOL, 4 REPORT_BY_SEQ FROM DUAL" ).append("\n"); 
		query.append("              ) TBL" ).append("\n"); 
		query.append("              WHERE REPORT_BY(+) = TBL.TCOL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("----------------------------MONTH 일경우 내부쿼리  끝" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#if (${start_page} != '') " ).append("\n"); 
		query.append("WHERE ROW_NUM BETWEEN ${start_page} AND ${end_page}" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}