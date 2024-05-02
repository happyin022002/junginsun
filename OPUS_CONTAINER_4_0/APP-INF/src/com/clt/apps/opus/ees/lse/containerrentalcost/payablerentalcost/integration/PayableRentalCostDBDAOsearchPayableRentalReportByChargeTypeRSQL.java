/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회
	  * </pre>
	  */
	public PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_eddt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payable",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("report_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeRSQL").append("\n"); 
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
		query.append("WITH PARAM AS (" ).append("\n"); 
		query.append("SELECT DECODE(AA.GRP_ID1, 1, 'G.TTL', AA.VNDR_SEQ)  AS VNDR_SEQ" ).append("\n"); 
		query.append("     , DECODE(AA.GRP_ID1, 1, NULL, AA.ABBR_NM)      AS ABBR_NM" ).append("\n"); 
		query.append("     , DECODE(AA.GRP_ID1, 1, NULL, AA.CNTR_TPSZ_CD) AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , AA.QTY" ).append("\n"); 
		query.append("     , AA.CURR_CD" ).append("\n"); 
		query.append("     , AA.OPL + AA.PDM + AA.PUC + AA.PCR + AA.LON + AA.LOF + AA.DOC + AA.DCR + AA.DII + AA.DIO + AA.DPP + AA.GTO + AA.GTI + AA.WDP + AA.OTH + AA.CRD AS G_TTL" ).append("\n"); 
		query.append("     , AA.OPL" ).append("\n"); 
		query.append("     , AA.PDM" ).append("\n"); 
		query.append("     , AA.PUC" ).append("\n"); 
		query.append("     , AA.PCR" ).append("\n"); 
		query.append("     , AA.PUC + AA.PCR AS TTL_1" ).append("\n"); 
		query.append("     , AA.LON" ).append("\n"); 
		query.append("     , AA.LOF" ).append("\n"); 
		query.append("     , AA.LON + AA.LOF AS TTL_2" ).append("\n"); 
		query.append("     , AA.DOC" ).append("\n"); 
		query.append("     , AA.DCR" ).append("\n"); 
		query.append("     , AA.DOC + AA.DCR AS TTL_3" ).append("\n"); 
		query.append("     , AA.DII" ).append("\n"); 
		query.append("     , AA.DIO" ).append("\n"); 
		query.append("     , AA.DII + AA.DIO AS TTL_4" ).append("\n"); 
		query.append("     , AA.GTO" ).append("\n"); 
		query.append("     , AA.GTI" ).append("\n"); 
		query.append("     , AA.GTO + AA.GTI AS TTL_5" ).append("\n"); 
		query.append("     , AA.DPP" ).append("\n"); 
		query.append("     , AA.WDP" ).append("\n"); 
		query.append("     , AA.OTH" ).append("\n"); 
		query.append("     , AA.CRD" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("         SELECT NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append("              , GROUPING(NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ)) AS GRP_ID1" ).append("\n"); 
		query.append("              , SUBSTR(NVL(VNDR.VNDR_ABBR_NM, '   '), 1, 3) ABBR_NM" ).append("\n"); 
		query.append("              , LTC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , GROUPING(LTC.CNTR_TPSZ_CD) AS GRP_ID2" ).append("\n"); 
		query.append("              , NVL(TPSZ.RPT_DP_SEQ, 999) AS RPT_DP_SEQ" ).append("\n"); 
		query.append("              , GROUPING(TPSZ.RPT_DP_SEQ) AS GRP_ID3" ).append("\n"); 
		query.append("              , COUNT(DISTINCT CNTR_NO) QTY" ).append("\n"); 
		query.append("              , LTMP.CURR_CD" ).append("\n"); 
		query.append("              , 0 AS OPL" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'PDM', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) PDM" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'PUC', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) PUC" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'PCR', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) PCR" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'LON', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) LON" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'LOF', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) LOF" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'DOC', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) DOC" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'DCR', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) DCR" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'DII', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) DII" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'DIO', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) DIO" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'DPP', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) DPP" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'GTO', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) GTO" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'GTI', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) GTI" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'WDP', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) WDP" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'OTH', DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) OTH" ).append("\n"); 
		query.append("              , SUM(DECODE(LSE_PAY_CHG_TP_CD, 'CRD', LTC.CR_AMT, 0)) CRD" ).append("\n"); 
		query.append("         FROM   LSE_PAY_RNTL_CHG_DTL LTC," ).append("\n"); 
		query.append("                LSE_PAY_RNTL_CHG     LTMP," ).append("\n"); 
		query.append("                MDM_VENDOR           VNDR," ).append("\n"); 
		query.append("                MDM_CNTR_TP_SZ       TPSZ," ).append("\n"); 
		query.append("                ( SELECT @[report_type]  AS REPORT_TYPE," ).append("\n"); 
		query.append("                         @[period_stdt]  AS PERIOD_STDT," ).append("\n"); 
		query.append("                         @[period_eddt]  AS PERIOD_EDDT," ).append("\n"); 
		query.append("                         @[payable]      AS PAYABLE," ).append("\n"); 
		query.append("                         @[agmt_cty_cd]  AS AGMT_CTY_CD," ).append("\n"); 
		query.append("                         @[agmt_seq]     AS AGMT_SEQ," ).append("\n"); 
		query.append("                         @[vndr_seq]     AS VNDR_SEQ," ).append("\n"); 
		query.append("                         @[loc_tp]       AS LOC_TP," ).append("\n"); 
		query.append("                         @[loc_cd]       AS LOC_CD" ).append("\n"); 
		query.append("                  FROM   DUAL" ).append("\n"); 
		query.append("                ) P" ).append("\n"); 
		query.append("         WHERE  1=1" ).append("\n"); 
		query.append("#if(${search_tp} == 'Cost')" ).append("\n"); 
		query.append("			AND LTMP.CHG_COST_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT" ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Revenue')" ).append("\n"); 
		query.append("			AND  LTMP.INV_NO     IN (SELECT API.INV_NO FROM AP_PAY_INV API  WHERE 1=1" ).append("\n"); 
		query.append("        	AND  API.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("        	AND  LTMP.IF_RGST_NO  = DECODE(LTMP.IF_RGST_NO, NULL, NULL, API.INV_RGST_NO)" ).append("\n"); 
		query.append("			AND TO_CHAR(API.INV_EFF_DT,'YYYYMM') BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT)" ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Payment')" ).append("\n"); 
		query.append("			AND  LTMP.INV_NO     IN (SELECT   API.INV_NO FROM AP_PAY_INV  API WHERE 1=1 " ).append("\n"); 
		query.append("        	AND  API.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("        	AND  API.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("        	AND TO_CHAR(API.UPD_DT,'YYYYMM') BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND  LTMP.LSE_PAY_RNTL_STS_CD = DECODE(P.PAYABLE, 'S', 'I', LTMP.LSE_PAY_RNTL_STS_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("           AND  LTMP.VNDR_SEQ    = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND  NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ) = VNDR.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("           AND  LTMP.LSTM_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("         #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                 '$key'," ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("                                 '$key'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("           AND  LTMP.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND  LTMP.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND  LTMP.CHG_SEQ     = LTC.CHG_SEQ" ).append("\n"); 
		query.append("           AND  LTMP.AGMT_CTY_CD = LTC.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND  LTMP.AGMT_SEQ    = LTC.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${payable} == 'S')" ).append("\n"); 
		query.append("           AND  NVL(LTC.CNTR_AUD_STS_CD, 'A') = 'A' -- Invoice Amount ( P.PAYABLE = 'S' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND  LTC.CNTR_TPSZ_CD = TPSZ.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("           AND  LTC.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                     '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("                                     '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("   #if (${loc_tp} == 'R')" ).append("\n"); 
		query.append("           AND  LTC.ONH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("           AND  LTC.ONH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("           AND  LTC.ONH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("           AND  SUBSTR(LTC.ONH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lse_pay_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                       WHERE LTMP.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                         AND LTMP.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                         AND LA.LSE_PAY_TP_CD = @[lse_pay_tp_cd]" ).append("\n"); 
		query.append("                         AND ROWNUM           = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP BY NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ), LTMP.CURR_CD, VNDR.VNDR_ABBR_NM, LTC.CNTR_TPSZ_CD, TPSZ.RPT_DP_SEQ" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT LOL.VNDR_SEQ VNDR_SEQ" ).append("\n"); 
		query.append("              , GROUPING(LOL.VNDR_SEQ) AS GRP_ID1" ).append("\n"); 
		query.append("              , SUBSTR(NVL(MV.VNDR_ABBR_NM, '   '), 1, 3) ABBR_NM" ).append("\n"); 
		query.append("              , LOL.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              , GROUPING(LOL.CNTR_TPSZ_CD) AS GRP_ID2" ).append("\n"); 
		query.append("              , NVL(TPSZ.RPT_DP_SEQ, 999) AS RPT_DP_SEQ" ).append("\n"); 
		query.append("              , GROUPING(TPSZ.RPT_DP_SEQ) AS GRP_ID3" ).append("\n"); 
		query.append("              , SUM(OP_LSE_QTY) QTY" ).append("\n"); 
		query.append("              , LOL.CURR_CD" ).append("\n"); 
		query.append("              , SUM(LOL.PAY_AMT)OPL" ).append("\n"); 
		query.append("              , 0 AS PDM" ).append("\n"); 
		query.append("              , 0 AS PUC" ).append("\n"); 
		query.append("              , 0 AS PCR" ).append("\n"); 
		query.append("              , 0 AS LON" ).append("\n"); 
		query.append("              , 0 AS LOF" ).append("\n"); 
		query.append("              , 0 AS DOC" ).append("\n"); 
		query.append("              , 0 AS DCR" ).append("\n"); 
		query.append("              , 0 AS DII" ).append("\n"); 
		query.append("              , 0 AS DIO" ).append("\n"); 
		query.append("              , 0 AS DPP" ).append("\n"); 
		query.append("              , 0 AS GTO" ).append("\n"); 
		query.append("              , 0 AS GTI" ).append("\n"); 
		query.append("              , 0 AS WDP" ).append("\n"); 
		query.append("              , 0 AS OTH" ).append("\n"); 
		query.append("              , 0 AS CRD" ).append("\n"); 
		query.append("       FROM LSE_OP_LSE LOL" ).append("\n"); 
		query.append("          , MDM_VENDOR  MV" ).append("\n"); 
		query.append("          , MDM_CNTR_TP_SZ     TPSZ " ).append("\n"); 
		query.append("          , ( SELECT @[report_type]  AS REPORT_TYPE," ).append("\n"); 
		query.append("                     @[period_stdt]  AS PERIOD_STDT," ).append("\n"); 
		query.append("                     @[period_eddt]  AS PERIOD_EDDT," ).append("\n"); 
		query.append("                     @[payable]      AS PAYABLE," ).append("\n"); 
		query.append("                     @[agmt_cty_cd]  AS AGMT_CTY_CD," ).append("\n"); 
		query.append("                     @[agmt_seq]     AS AGMT_SEQ," ).append("\n"); 
		query.append("                     @[vndr_seq]     AS VNDR_SEQ," ).append("\n"); 
		query.append("                     @[loc_tp]       AS LOC_TP," ).append("\n"); 
		query.append("                     @[loc_cd]       AS LOC_CD" ).append("\n"); 
		query.append("               FROM   DUAL  ) P" ).append("\n"); 
		query.append("         WHERE  1=1" ).append("\n"); 
		query.append("#if(${search_tp} == 'Cost')" ).append("\n"); 
		query.append("		AND LOL.SKD_VOY_NO BETWEEN SUBSTR(P.PERIOD_STDT, 3, 4) AND SUBSTR(P.PERIOD_EDDT, 3, 4)" ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Revenue')" ).append("\n"); 
		query.append("		AND  LOL.INV_NO     IN (SELECT   API.INV_NO FROM AP_PAY_INV  API WHERE 1=1 " ).append("\n"); 
		query.append("        AND  API.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("        AND  LOL.IF_RGST_NO  = DECODE(LOL.IF_RGST_NO, NULL, NULL, API.INV_RGST_NO)" ).append("\n"); 
		query.append("		AND TO_CHAR(API.INV_EFF_DT,'YYYYMM') BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT)" ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Payment')" ).append("\n"); 
		query.append("	    AND  LOL.INV_NO     IN (SELECT   API.INV_NO FROM AP_PAY_INV  API WHERE 1=1 " ).append("\n"); 
		query.append("        AND  API.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("        AND  API.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("        AND TO_CHAR(API.UPD_DT,'YYYYMM') BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND  P.PAYABLE  = 'S'" ).append("\n"); 
		query.append("           AND  LOL.CNTR_TPSZ_CD = TPSZ.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("           AND  LOL.VNDR_SEQ    = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND  LOL.VNDR_SEQ    = MV.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("           AND  EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("                         FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                         WHERE LA.AGMT_CTY_CD = LOL.AGMT_CTY_CD" ).append("\n"); 
		query.append("                         AND   LA.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                         AND   LA.LSTM_CD IN (" ).append("\n"); 
		query.append("                                                #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                                     #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                                        '$key'," ).append("\n"); 
		query.append("                                                     #else" ).append("\n"); 
		query.append("                                                        '$key'" ).append("\n"); 
		query.append("                                                     #end" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("           AND  LOL.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("           AND  LOL.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("           AND 'A' = 'B'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("           AND  LOL.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	                                  #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("		                                   #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                              '$key'," ).append("\n"); 
		query.append("		                                   #else" ).append("\n"); 
		query.append("                                              '$key'" ).append("\n"); 
		query.append("		                                   #end" ).append("\n"); 
		query.append("	                                  #end" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lse_pay_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("           AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                        FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                       WHERE LOL.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                         AND LOL.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                         AND LA.LSE_PAY_TP_CD = @[lse_pay_tp_cd]" ).append("\n"); 
		query.append("                         AND ROWNUM           = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         GROUP  BY (LOL.VNDR_SEQ, MV.VNDR_ABBR_NM, LOL.CURR_CD, LOL.CNTR_TPSZ_CD, TPSZ.RPT_DP_SEQ)   " ).append("\n"); 
		query.append("       ) AA" ).append("\n"); 
		query.append("WHERE  ( AA.GRP_ID1 = 0 AND AA.GRP_ID2 = 0 AND AA.GRP_ID3 = 0 )" ).append("\n"); 
		query.append("   OR  AA.GRP_ID1 = 1" ).append("\n"); 
		query.append("ORDER  BY AA.GRP_ID1, AA.VNDR_SEQ, AA.RPT_DP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       VNDR_SEQ" ).append("\n"); 
		query.append("     , ABBR_NM" ).append("\n"); 
		query.append("     , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , QTY" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , G_TTL" ).append("\n"); 
		query.append("     , OPL" ).append("\n"); 
		query.append("     , PDM" ).append("\n"); 
		query.append("     , PUC" ).append("\n"); 
		query.append("     , PCR" ).append("\n"); 
		query.append("     , TTL_1" ).append("\n"); 
		query.append("     , LON" ).append("\n"); 
		query.append("     , LOF" ).append("\n"); 
		query.append("     , TTL_2" ).append("\n"); 
		query.append("     , DOC" ).append("\n"); 
		query.append("     , DCR" ).append("\n"); 
		query.append("     , TTL_3" ).append("\n"); 
		query.append("     , DII" ).append("\n"); 
		query.append("     , DIO" ).append("\n"); 
		query.append("     , TTL_4" ).append("\n"); 
		query.append("     , GTO" ).append("\n"); 
		query.append("     , GTI" ).append("\n"); 
		query.append("     , TTL_5" ).append("\n"); 
		query.append("     , DPP" ).append("\n"); 
		query.append("     , WDP" ).append("\n"); 
		query.append("     , OTH" ).append("\n"); 
		query.append("     , CRD" ).append("\n"); 
		query.append("FROM PARAM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       'G.TTL' VNDR_SEQ" ).append("\n"); 
		query.append("     , '' ABBR_NM" ).append("\n"); 
		query.append("     , '' CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     , SUM(QTY)" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , SUM(G_TTL)" ).append("\n"); 
		query.append("     , SUM(OPL)" ).append("\n"); 
		query.append("     , SUM(PDM)" ).append("\n"); 
		query.append("     , SUM(PUC)" ).append("\n"); 
		query.append("     , SUM(PCR)" ).append("\n"); 
		query.append("     , SUM(TTL_1)" ).append("\n"); 
		query.append("     , SUM(LON)" ).append("\n"); 
		query.append("     , SUM(LOF)" ).append("\n"); 
		query.append("     , SUM(TTL_2)" ).append("\n"); 
		query.append("     , SUM(DOC)" ).append("\n"); 
		query.append("     , SUM(DCR)" ).append("\n"); 
		query.append("     , SUM(TTL_3)" ).append("\n"); 
		query.append("     , SUM(DII)" ).append("\n"); 
		query.append("     , SUM(DIO)" ).append("\n"); 
		query.append("     , SUM(TTL_4)" ).append("\n"); 
		query.append("     , SUM(GTO)" ).append("\n"); 
		query.append("     , SUM(GTI)" ).append("\n"); 
		query.append("     , SUM(TTL_5)" ).append("\n"); 
		query.append("     , SUM(DPP)" ).append("\n"); 
		query.append("     , SUM(WDP)" ).append("\n"); 
		query.append("     , SUM(OTH)" ).append("\n"); 
		query.append("     , SUM(CRD)" ).append("\n"); 
		query.append("FROM PARAM " ).append("\n"); 
		query.append("GROUP BY CURR_CD" ).append("\n"); 

	}
}