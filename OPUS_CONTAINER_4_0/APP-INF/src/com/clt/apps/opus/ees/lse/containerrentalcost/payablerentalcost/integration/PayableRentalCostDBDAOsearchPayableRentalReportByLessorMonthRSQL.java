/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableRentalCostDBDAOsearchPayableRentalReportByLessorMonthRSQL.java
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

public class PayableRentalCostDBDAOsearchPayableRentalReportByLessorMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Invoice 한 결과에 대하여 Lessor & Month pe별로 실적을 조회
	  * </pre>
	  */
	public PayableRentalCostDBDAOsearchPayableRentalReportByLessorMonthRSQL(){
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
		params.put("period_year",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : PayableRentalCostDBDAOsearchPayableRentalReportByLessorMonthRSQL").append("\n"); 
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
		query.append("      SELECT" ).append("\n"); 
		query.append("             @[report_type]  AS REPORT_TYPE," ).append("\n"); 
		query.append("             @[period_year]  AS PERIOD_YEAR," ).append("\n"); 
		query.append("             @[period_stdt]  AS PERIOD_STDT," ).append("\n"); 
		query.append("		 	 @[period_eddt]  AS PERIOD_EDDT," ).append("\n"); 
		query.append("             @[status]       AS STATUS," ).append("\n"); 
		query.append("             @[payable]      AS PAYABLE," ).append("\n"); 
		query.append("             @[agmt_cty_cd]  AS AGMT_CTY_CD," ).append("\n"); 
		query.append("             @[agmt_seq]     AS AGMT_SEQ," ).append("\n"); 
		query.append("             @[vndr_seq]     AS VNDR_SEQ," ).append("\n"); 
		query.append("             @[loc_tp]       AS LOC_TP," ).append("\n"); 
		query.append("             @[loc_cd]       AS LOC_CD" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("   , XXX AS (" ).append("\n"); 
		query.append("      SELECT" ).append("\n"); 
		query.append("             TO_CHAR(NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ)) VNDR_SEQ ," ).append("\n"); 
		query.append("             SUBSTR(NVL(VNDR.VNDR_ABBR_NM, '   '), 1, 3) ABBR_NM ," ).append("\n"); 
		query.append("             LTMP.CURR_CD ," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'01',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  JAN," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'02',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  FEB," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'03',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  MAR," ).append("\n"); 
		query.append("             (SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'01',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'02',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'03',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))) TTL_1," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'04',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  APR," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'05',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  MAY," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'06',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  JUN," ).append("\n"); 
		query.append("             (SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'04',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'05',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'06',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))) TTL_2," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'07',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  JUL," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'08',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  AUG," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'09',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  SEP," ).append("\n"); 
		query.append("             (SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'07',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'08',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'09',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))) TTL_3," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'10',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  OCT," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'11',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  NOV," ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'12',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))  DEC," ).append("\n"); 
		query.append("             (SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'10',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'11',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'12',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))) TTL_4," ).append("\n"); 
		query.append("             (SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'01',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'02',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'03',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'04',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'05',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'06',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'07',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'08',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'09',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'10',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'11',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0)) +" ).append("\n"); 
		query.append("             SUM(DECODE(SUBSTR(LTMP.CHG_COST_YRMON,5,2),'12',DECODE(P.PAYABLE, 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT),0))) G_TTL" ).append("\n"); 
		query.append("        FROM LSE_PAY_RNTL_CHG_DTL LTC," ).append("\n"); 
		query.append("             LSE_PAY_RNTL_CHG LTMP," ).append("\n"); 
		query.append("             MDM_VENDOR VNDR ," ).append("\n"); 
		query.append("             PARAM P" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
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
		query.append("         AND LTMP.LSE_PAY_RNTL_STS_CD = DECODE(P.PAYABLE, 'S', 'I', LTMP.LSE_PAY_RNTL_STS_CD)" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("         AND LTMP.VNDR_SEQ    = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ)    = VNDR.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("         AND LTMP.LSTM_CD IN (" ).append("\n"); 
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
		query.append("         AND LTMP.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("         AND LTMP.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND LTMP.CHG_SEQ     = LTC.CHG_SEQ" ).append("\n"); 
		query.append("         AND LTMP.AGMT_CTY_CD = LTC.AGMT_CTY_CD" ).append("\n"); 
		query.append("         AND LTMP.AGMT_SEQ    = LTC.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${payable} == 'S')" ).append("\n"); 
		query.append("         AND NVL(LTC.CNTR_AUD_STS_CD, 'A') = 'A' -- Invoice Amount ( P.PAYABLE = 'S' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("         AND LTC.CNTR_TPSZ_CD IN (" ).append("\n"); 
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
		query.append("         AND LTC.ONH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("         AND LTC.ONH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("         AND LTC.ONH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("         AND SUBSTR(LTC.ONH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_type_cd_str} != '')" ).append("\n"); 
		query.append("         AND LTC.LSE_PAY_CHG_TP_CD IN (" ).append("\n"); 
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
		query.append("       GROUP BY NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ), LTMP.CURR_CD, VNDR.VNDR_ABBR_NM" ).append("\n"); 
		query.append("       UNION ALL" ).append("\n"); 
		query.append("         SELECT " ).append("\n"); 
		query.append("                 TO_CHAR(LTC.VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("                 SUBSTR(NVL(VNDR.VNDR_ABBR_NM, '   '), 1, 3) ABBR_NM ," ).append("\n"); 
		query.append("                 LTC.CURR_CD ," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '01', LTC.PAY_AMT, 0))    JAN," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '02', LTC.PAY_AMT, 0))    FEB," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '03', LTC.PAY_AMT, 0))    MAR," ).append("\n"); 
		query.append("                  (SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '01', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '02', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '03', LTC.PAY_AMT, 0))) TTL_1," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '04', LTC.PAY_AMT, 0))    APR," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '05', LTC.PAY_AMT, 0))    MAY," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '06', LTC.PAY_AMT, 0))    JUN," ).append("\n"); 
		query.append("                  (SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '04', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '05', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '06', LTC.PAY_AMT, 0))) TTL_2," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '07', LTC.PAY_AMT, 0))    JUL," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '08', LTC.PAY_AMT, 0))    AUG," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '09', LTC.PAY_AMT, 0))    SEP," ).append("\n"); 
		query.append("                  (SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '07', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '08', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '09', LTC.PAY_AMT, 0))) TTL_3," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '10', LTC.PAY_AMT, 0))    OCT," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '11', LTC.PAY_AMT, 0))    NOV," ).append("\n"); 
		query.append("                 SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '12', LTC.PAY_AMT, 0))    DEC," ).append("\n"); 
		query.append("                  (SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '10', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '11', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '12', LTC.PAY_AMT, 0))) TTL_4," ).append("\n"); 
		query.append("                  (SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '01', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '02', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '03', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '04', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '05', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '06', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '07', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '08', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '09', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '10', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '11', LTC.PAY_AMT, 0))" ).append("\n"); 
		query.append("                  +SUM(DECODE(SUBSTR(LTC.SKD_VOY_NO, -2), '12', LTC.PAY_AMT, 0))) G_TTL" ).append("\n"); 
		query.append("            FROM LSE_OP_LSE LTC," ).append("\n"); 
		query.append("                 LSE_AGREEMENT LTMP ," ).append("\n"); 
		query.append("                 MDM_VENDOR VNDR," ).append("\n"); 
		query.append("                 PARAM P" ).append("\n"); 
		query.append("           WHERE  1=1" ).append("\n"); 
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
		query.append("             AND  P.PAYABLE   = 'S'" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("         AND LTC.VNDR_SEQ    = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND LTC.VNDR_SEQ    = VNDR.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("         AND LTMP.LSTM_CD IN (" ).append("\n"); 
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
		query.append("         AND LTC.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("         AND LTC.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         AND LTMP.AGMT_CTY_CD = LTC.AGMT_CTY_CD" ).append("\n"); 
		query.append("         AND LTMP.AGMT_SEQ    = LTC.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("         AND LTC.CNTR_TPSZ_CD IN (" ).append("\n"); 
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
		query.append("         AND 'A' = 'B'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${charge_type_cd_str} != '')" ).append("\n"); 
		query.append("         AND 'OPL' IN (" ).append("\n"); 
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
		query.append("       GROUP BY LTC.VNDR_SEQ, LTC.CURR_CD, SUBSTR(NVL(VNDR.VNDR_ABBR_NM, '   '), 1, 3)" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       ABBR_NM," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       JAN," ).append("\n"); 
		query.append("       FEB," ).append("\n"); 
		query.append("       MAR," ).append("\n"); 
		query.append("       TTL_1," ).append("\n"); 
		query.append("       APR," ).append("\n"); 
		query.append("       MAY," ).append("\n"); 
		query.append("       JUN," ).append("\n"); 
		query.append("       TTL_2," ).append("\n"); 
		query.append("       JUL," ).append("\n"); 
		query.append("       AUG," ).append("\n"); 
		query.append("       SEP," ).append("\n"); 
		query.append("       TTL_3," ).append("\n"); 
		query.append("       OCT," ).append("\n"); 
		query.append("       NOV," ).append("\n"); 
		query.append("       DEC," ).append("\n"); 
		query.append("       TTL_4," ).append("\n"); 
		query.append("       G_TTL" ).append("\n"); 
		query.append("  FROM XXX" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("       'G.TTL' VNDR_SEQ," ).append("\n"); 
		query.append("       NULL ABBR_NM," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       SUM(JAN)," ).append("\n"); 
		query.append("       SUM(FEB)," ).append("\n"); 
		query.append("       SUM(MAR)," ).append("\n"); 
		query.append("       SUM(TTL_1)," ).append("\n"); 
		query.append("       SUM(APR)," ).append("\n"); 
		query.append("       SUM(MAY)," ).append("\n"); 
		query.append("       SUM(JUN)," ).append("\n"); 
		query.append("       SUM(TTL_2)," ).append("\n"); 
		query.append("       SUM(JUL)," ).append("\n"); 
		query.append("       SUM(AUG)," ).append("\n"); 
		query.append("       SUM(SEP)," ).append("\n"); 
		query.append("       SUM(TTL_3)," ).append("\n"); 
		query.append("       SUM(OCT)," ).append("\n"); 
		query.append("       SUM(NOV)," ).append("\n"); 
		query.append("       SUM(DEC)," ).append("\n"); 
		query.append("       SUM(TTL_4)," ).append("\n"); 
		query.append("       SUM(G_TTL)" ).append("\n"); 
		query.append("  FROM XXX" ).append("\n"); 
		query.append(" GROUP BY CURR_CD" ).append("\n"); 

	}
}