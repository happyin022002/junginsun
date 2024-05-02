/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeTySzRSQL.java
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

public class PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeTySzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Invoice 한 결과에 대하여 Charge Type & TP/SZ 별로 실적을 조회
	  *  total 부분의 avaerage 로직 에러 수정(==> total amout / total vol)
	  * </pre>
	  */
	public PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeTySzRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOsearchPayableRentalReportByChargeTypeTySzRSQL").append("\n"); 
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
		query.append("    SELECT " ).append("\n"); 
		query.append("            @[report_type]  AS REPORT_TYPE," ).append("\n"); 
		query.append("            @[period_stdt]  AS PERIOD_STDT," ).append("\n"); 
		query.append("            @[period_eddt]  AS PERIOD_EDDT," ).append("\n"); 
		query.append("            @[status]       AS STATUS,            " ).append("\n"); 
		query.append("            @[payable]      AS PAYABLE," ).append("\n"); 
		query.append("            @[agmt_cty_cd]  AS AGMT_CTY_CD," ).append("\n"); 
		query.append("            @[agmt_seq]     AS AGMT_SEQ," ).append("\n"); 
		query.append("            @[vndr_seq]     AS VNDR_SEQ," ).append("\n"); 
		query.append("            @[loc_tp]       AS LOC_TP," ).append("\n"); 
		query.append("            @[loc_cd]       AS LOC_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append("), XXX AS ( " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("               AA.CHARGE_TYPE CHARGE_TYPE," ).append("\n"); 
		query.append("               AA.DIV DIV," ).append("\n"); 
		query.append("			   AA.CURR_CD," ).append("\n"); 
		query.append("               AA.G_TTL G_TTL," ).append("\n"); 
		query.append("#foreach($key IN ${tysz})" ).append("\n"); 
		query.append("               $key ," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("               AA.DIV_SEQ DIV_SEQ," ).append("\n"); 
		query.append("               BB.DSP_SEQ DSP_SEQ" ).append("\n"); 
		query.append("         FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" CHARGE_TYPE ," ).append("\n"); 
		query.append(" DECODE( DIV  , 1 ,'VOL' , 2 , 'AMT' , 3 , 'AVG') DIV , " ).append("\n"); 
		query.append(" CURR_CD , " ).append("\n"); 
		query.append(" CASE WHEN DIV = 3 THEN" ).append("\n"); 
		query.append("    DECODE(SUM(G_TTL) OVER (PARTITION BY CHARGE_TYPE,CURR_CD ORDER BY CHARGE_TYPE, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0," ).append("\n"); 
		query.append("           ROUND(SUM(G_TTL) OVER (PARTITION BY CHARGE_TYPE,CURR_CD ORDER BY CHARGE_TYPE, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("                 SUM(G_TTL) OVER (PARTITION BY CHARGE_TYPE,CURR_CD ORDER BY CHARGE_TYPE, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(" ELSE" ).append("\n"); 
		query.append("    G_TTL" ).append("\n"); 
		query.append(" END G_TTL," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("  $key ," ).append("\n"); 
		query.append(" #end  " ).append("\n"); 
		query.append("  DIV DIV_SEQ " ).append("\n"); 
		query.append("FROM( SELECT" ).append("\n"); 
		query.append("                LSE_PAY_CHG_TP_CD CHARGE_TYPE,  " ).append("\n"); 
		query.append("                DIV," ).append("\n"); 
		query.append("			    CURR_CD," ).append("\n"); 
		query.append("               #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("                SUM(DECODE(CNTR_TPSZ_CD, '$key', FF, 0)) $key ," ).append("\n"); 
		query.append("               #end " ).append("\n"); 
		query.append("               (" ).append("\n"); 
		query.append("               #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("                 #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("                    SUM(DECODE(CNTR_TPSZ_CD, '$key', FF, 0)) +" ).append("\n"); 
		query.append("                 #else" ).append("\n"); 
		query.append("                    SUM(DECODE(CNTR_TPSZ_CD, '$key', FF, 0)) " ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               ) G_TTL" ).append("\n"); 
		query.append("      FROM( SELECT" ).append("\n"); 
		query.append("     V1.LSE_PAY_CHG_TP_CD," ).append("\n"); 
		query.append("     V1.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("     V2.DIV_SEQ DIV," ).append("\n"); 
		query.append("	 V1.CURR_CD," ).append("\n"); 
		query.append("     CASE V2.DIV_SEQ" ).append("\n"); 
		query.append("     WHEN 1 THEN NVL(V1.F1,0)" ).append("\n"); 
		query.append("     WHEN 2 THEN NVL(V1.F2,0)" ).append("\n"); 
		query.append("     WHEN 3 THEN NVL(V1.F3,0) " ).append("\n"); 
		query.append("     WHEN 4 THEN NVL(V1.F1,0) + NVL(V1.F2,0) + NVL(V1.F3,0) " ).append("\n"); 
		query.append("     END AS FF" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      LSE_PAY_CHG_TP_CD," ).append("\n"); 
		query.append("	  LTMP.CURR_CD," ).append("\n"); 
		query.append("      CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      COUNT(DISTINCT CNTR_NO) F1 ," ).append("\n"); 
		query.append("      SUM(DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT)) F2 , " ).append("\n"); 
		query.append("      ROUND( (SUM(DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT))  / COUNT(DISTINCT CNTR_NO)) * 100 ) / 100 F3" ).append("\n"); 
		query.append("    FROM LSE_PAY_RNTL_CHG_DTL LTC," ).append("\n"); 
		query.append("         LSE_PAY_RNTL_CHG LTMP ," ).append("\n"); 
		query.append("         PARAM P " ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if(${search_tp} == 'Cost')" ).append("\n"); 
		query.append("					AND LTMP.CHG_COST_YRMON BETWEEN  P.PERIOD_STDT AND P.PERIOD_EDDT" ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Revenue')" ).append("\n"); 
		query.append("			        AND  LTMP.INV_NO     IN (SELECT API.INV_NO FROM AP_PAY_INV API  WHERE 1=1" ).append("\n"); 
		query.append("        			AND  API.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("        			AND  LTMP.IF_RGST_NO  = DECODE(LTMP.IF_RGST_NO, NULL, NULL, API.INV_RGST_NO)" ).append("\n"); 
		query.append("					AND TO_CHAR(API.INV_EFF_DT,'YYYYMM') BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT)" ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Payment')" ).append("\n"); 
		query.append("					AND  LTMP.INV_NO     IN (SELECT   API.INV_NO FROM AP_PAY_INV  API WHERE 1=1 " ).append("\n"); 
		query.append("        			AND  API.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("        			AND  API.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("        			AND TO_CHAR(API.UPD_DT,'YYYYMM') BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      AND LTMP.LSE_PAY_RNTL_STS_CD = DECODE(P.PAYABLE, 'S', 'I', LTMP.LSE_PAY_RNTL_STS_CD)" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("      AND LTMP.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("      AND LTMP.LSTM_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("         #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("           '$key'," ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("           '$key'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("      AND LTMP.AGMT_CTY_CD  = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND LTMP.AGMT_SEQ     = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND LTMP.CHG_SEQ = LTC.CHG_SEQ" ).append("\n"); 
		query.append("      AND LTMP.AGMT_CTY_CD = LTC.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND LTMP.AGMT_SEQ    = LTC.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${payable} == 'S')" ).append("\n"); 
		query.append("      AND NVL(LTC.CNTR_AUD_STS_CD, 'A') = 'A' -- Invoice Amount ( P.PAYABLE = 'S' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("      AND LTC.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("			        '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			        '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("   #if (${loc_tp} == 'R')" ).append("\n"); 
		query.append("      AND LTC.ONH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("      AND LTC.ONH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("      AND LTC.ONH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("      AND SUBSTR(LTC.ONH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_type_cd_str} != '')" ).append("\n"); 
		query.append("      AND LTC.LSE_PAY_CHG_TP_CD IN (" ).append("\n"); 
		query.append("      #foreach($key IN ${charge_type_cd})" ).append("\n"); 
		query.append("        #if($velocityCount < $charge_type_cd.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lse_pay_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("     AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                   FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                  WHERE LTMP.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND LTMP.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND LA.LSE_PAY_TP_CD = @[lse_pay_tp_cd]" ).append("\n"); 
		query.append("                    AND ROWNUM           = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY LSE_PAY_CHG_TP_CD, CNTR_TPSZ_CD, LTMP.CURR_CD" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      'OPL' AS LSE_PAY_CHG_TP_CD," ).append("\n"); 
		query.append("	  LTC.CURR_CD," ).append("\n"); 
		query.append("      LTC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("      SUM(LTC.OP_LSE_QTY) F1," ).append("\n"); 
		query.append("      SUM(LTC.PAY_AMT) F2," ).append("\n"); 
		query.append("      DECODE(SUM(LTC.OP_LSE_QTY), 0, 0, ROUND((SUM(LTC.PAY_AMT) / SUM(LTC.OP_LSE_QTY)) * 100 ) / 100) F3" ).append("\n"); 
		query.append("    FROM   LSE_OP_LSE LTC" ).append("\n"); 
		query.append("         , LSE_AGREEMENT LTMP" ).append("\n"); 
		query.append("         , PARAM P" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if(${search_tp} == 'Cost')" ).append("\n"); 
		query.append("					AND LTC.SKD_VOY_NO BETWEEN SUBSTR(P.PERIOD_STDT, 3, 4) AND SUBSTR(P.PERIOD_EDDT, 3, 4)" ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Revenue')" ).append("\n"); 
		query.append("					AND  LTC.INV_NO     IN (SELECT   API.INV_NO FROM AP_PAY_INV  API WHERE 1=1 " ).append("\n"); 
		query.append("        			AND  API.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("        			AND  LTC.IF_RGST_NO  = DECODE(LTC.IF_RGST_NO, NULL, NULL, API.INV_RGST_NO)" ).append("\n"); 
		query.append("					AND TO_CHAR(API.INV_EFF_DT,'YYYYMM') BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT)" ).append("\n"); 
		query.append("#elseif(${search_tp} == 'Payment')" ).append("\n"); 
		query.append("					AND  LTC.INV_NO     IN (SELECT   API.INV_NO FROM AP_PAY_INV  API WHERE 1=1 " ).append("\n"); 
		query.append("        			AND  API.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("        			AND  API.INV_STS_CD = 'D'" ).append("\n"); 
		query.append("        			AND TO_CHAR(API.UPD_DT,'YYYYMM') BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND  P.PAYABLE   = 'S'" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("      AND LTC.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("      AND LTMP.LSTM_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("         #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("           '$key'," ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("           '$key'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("      AND LTC.AGMT_CTY_CD  = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND LTC.AGMT_SEQ     = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND LTMP.AGMT_CTY_CD = LTC.AGMT_CTY_CD" ).append("\n"); 
		query.append("      AND LTMP.AGMT_SEQ    = LTC.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("      AND LTC.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("			        '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			        '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("             AND 'A' = 'B'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${charge_type_cd_str} != '')" ).append("\n"); 
		query.append("      AND 'OPL' IN (" ).append("\n"); 
		query.append("      #foreach($key IN ${charge_type_cd})" ).append("\n"); 
		query.append("        #if($velocityCount < $charge_type_cd.size())" ).append("\n"); 
		query.append("            '$key'," ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            '$key'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lse_pay_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("     AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                   FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                  WHERE LTC.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                    AND LTC.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                    AND LA.LSE_PAY_TP_CD = @[lse_pay_tp_cd]" ).append("\n"); 
		query.append("                    AND ROWNUM           = 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY 'OPL', LTC.CNTR_TPSZ_CD, LTC.CURR_CD) V1," ).append("\n"); 
		query.append("            ( SELECT 1 AS DIV_SEQ FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 2 AS DIV_SEQ FROM DUAL UNION ALL" ).append("\n"); 
		query.append("              SELECT 3 AS DIV_SEQ FROM DUAL             " ).append("\n"); 
		query.append("             ) V2" ).append("\n"); 
		query.append("         )   " ).append("\n"); 
		query.append("      GROUP BY LSE_PAY_CHG_TP_CD,  DIV, CURR_CD )       " ).append("\n"); 
		query.append("      ORDER BY CHARGE_TYPE , DIV_SEQ ) AA ," ).append("\n"); 
		query.append("               ( SELECT	 1 DSP_SEQ, 'PDM' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	 2 DSP_SEQ, 'PUC' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	 3 DSP_SEQ, 'PCR' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	 4 DSP_SEQ, 'LON' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	 5 DSP_SEQ, 'LOF' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	 6 DSP_SEQ, 'DOC' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	 7 DSP_SEQ, 'DCR' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	 8 DSP_SEQ, 'DII' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	 9 DSP_SEQ, 'DIO' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	10 DSP_SEQ, 'DPP' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	11 DSP_SEQ, 'WDP' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	12 DSP_SEQ, 'GTI' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	13 DSP_SEQ, 'GTO' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	14 DSP_SEQ, 'OPL' CHARGE_TYPE FROM DUAL " ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	15 DSP_SEQ, 'CRD' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("                 UNION ALL                                      " ).append("\n"); 
		query.append("                 SELECT	16 DSP_SEQ, 'OTH' CHARGE_TYPE FROM DUAL ) BB" ).append("\n"); 
		query.append("         WHERE AA.CHARGE_TYPE = BB.CHARGE_TYPE" ).append("\n"); 
		query.append("         ORDER BY BB.DSP_SEQ , AA.CURR_CD, AA.DIV_SEQ)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   CHARGE_TYPE," ).append("\n"); 
		query.append("   DIV ," ).append("\n"); 
		query.append("   DECODE( DIV  ,'VOL' , 1  , 'AMT' , 2  , 'AVG', 3  ) DIV_ORDER," ).append("\n"); 
		query.append("   CURR_CD ," ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   $key ," ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("   G_TTL" ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  CHARGE_TYPE," ).append("\n"); 
		query.append("  DIV ,  " ).append("\n"); 
		query.append("  DIV_ORDER," ).append("\n"); 
		query.append("  CURR_CD ," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("  $key ," ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("  G_TTL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  CHARGE_TYPE," ).append("\n"); 
		query.append("  DIV ,  " ).append("\n"); 
		query.append("  DIV_ORDER," ).append("\n"); 
		query.append("  CURR_CD ," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("  $key ," ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append("  G_TTL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("   'G.TTL' CHARGE_TYPE," ).append("\n"); 
		query.append("   DIV ,  " ).append("\n"); 
		query.append("   DECODE( DIV  ,'VOL' , 1  , 'AMT' , 2  ) DIV_ORDER," ).append("\n"); 
		query.append("   CURR_CD ," ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   SUM($key) $key ," ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("   SUM(G_TTL) G_TTL" ).append("\n"); 
		query.append("  FROM XXX" ).append("\n"); 
		query.append("  WHERE DIV_SEQ <> 3" ).append("\n"); 
		query.append("  GROUP BY DIV , DIV_SEQ, CURR_CD" ).append("\n"); 
		query.append("  ORDER BY DIV_SEQ )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   'G.TTL' CHARGE_TYPE," ).append("\n"); 
		query.append("   'AVG' DIV , " ).append("\n"); 
		query.append("   3 AS DIV_ORDER, " ).append("\n"); 
		query.append("   A.CURR_CD ,    " ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   case when A.$key    > 0 AND V.$key    > 0 then round((A.$key    / V.$key   ) * 100 ) / 100  else 0 end $key ,   " ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("   case when A.G_TTL > 0 AND V.G_TTL > 0 then round((A.G_TTL / V.G_TTL) * 100 ) / 100  else 0 end G_TTL" ).append("\n"); 
		query.append("FROM ( SELECT" ).append("\n"); 
		query.append("          'G.TTL' CHARGE_TYPE," ).append("\n"); 
		query.append("		  CURR_CD," ).append("\n"); 
		query.append("         #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          SUM($key) $key," ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("          SUM(G_TTL) G_TTL" ).append("\n"); 
		query.append("       FROM XXX " ).append("\n"); 
		query.append("       WHERE DIV = 'VOL'" ).append("\n"); 
		query.append("       GROUP BY DIV , DIV_SEQ, CURR_CD" ).append("\n"); 
		query.append("       ORDER BY DIV_SEQ ) V , " ).append("\n"); 
		query.append("     ( SELECT" ).append("\n"); 
		query.append("          'G.TTL' CHARGE_TYPE,     " ).append("\n"); 
		query.append("         CURR_CD,     " ).append("\n"); 
		query.append("         #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          SUM($key) $key," ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("          SUM(G_TTL) G_TTL" ).append("\n"); 
		query.append("       FROM XXX " ).append("\n"); 
		query.append("       WHERE DIV = 'AMT'" ).append("\n"); 
		query.append("       GROUP BY DIV , DIV_SEQ , CURR_CD" ).append("\n"); 
		query.append("       ORDER BY DIV_SEQ ) A " ).append("\n"); 
		query.append("WHERE  V.CHARGE_TYPE = A.CHARGE_TYPE" ).append("\n"); 
		query.append("AND V.CURR_CD = A.CURR_CD" ).append("\n"); 
		query.append("ORDER BY CURR_CD , DIV_ORDER, DIV DESC" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}