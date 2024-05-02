/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOsearchReceivableRentalReportByLessorMonthRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.05.06 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOsearchReceivableRentalReportByLessorMonthRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Invoice 한 결과에 대하여 Lessor , Month별로 실적을 조회
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOsearchReceivableRentalReportByLessorMonthRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("period_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("company",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("receivable",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOsearchReceivableRentalReportByLessorMonthRSQL").append("\n"); 
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
		query.append("            @[period_year]  AS PERIOD_YEAR," ).append("\n"); 
		query.append("            @[company]      AS COMPANY," ).append("\n"); 
		query.append("            @[status]       AS STATUS," ).append("\n"); 
		query.append("            @[receivable]   AS RECEIVABLE," ).append("\n"); 
		query.append("            @[agmt_cty_cd]  AS AGMT_CTY_CD," ).append("\n"); 
		query.append("            @[agmt_seq]     AS AGMT_SEQ," ).append("\n"); 
		query.append("            @[vndr_seq]     AS VNDR_SEQ," ).append("\n"); 
		query.append("            @[loc_tp]       AS LOC_TP," ).append("\n"); 
		query.append("            @[loc_cd]       AS LOC_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", XXX AS (" ).append("\n"); 
		query.append(" SELECT /*+ INDEX(A, XPKLSE_RCV_RNTL_CHG) */ " ).append("\n"); 
		query.append("     TO_CHAR(NVL(A.VNDR_SEQ, 0)) VNDR_SEQ , " ).append("\n"); 
		query.append("     SUBSTR(NVL(A.VNDR_ABBR_NM, '   '), 1, 3) ABBR_NM , " ).append("\n"); 
		query.append("     '1' ABBR_NM1 ," ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'01',COST_AMT,0))  JAN, " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'02',COST_AMT,0))  FEB, " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'03',COST_AMT,0))  MAR, " ).append("\n"); 
		query.append("    (SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'01',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'02',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'03',COST_AMT,0))) TTL_1," ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'04',COST_AMT,0))  APR, " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'05',COST_AMT,0))  MAY, " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'06',COST_AMT,0))  JUN, " ).append("\n"); 
		query.append("    (SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'04',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'05',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'06',COST_AMT,0))) TTL_2," ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'07',COST_AMT,0))  JUL, " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'08',COST_AMT,0))  AUG, " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'09',COST_AMT,0))  SEP, " ).append("\n"); 
		query.append("    (SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'07',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'08',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'09',COST_AMT,0))) TTL_3," ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'10',COST_AMT,0))  OCT, " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'11',COST_AMT,0))  NOV, " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'12',COST_AMT,0))  DEC," ).append("\n"); 
		query.append("    (SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'10',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'11',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'12',COST_AMT,0))) TTL_4," ).append("\n"); 
		query.append("    (SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'01',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'02',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'03',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'04',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'05',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'06',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'07',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'08',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'09',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'10',COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'11',COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(SUBSTR(A.QTY_YRMON,5,2),'12',COST_AMT,0))) G_TTL" ).append("\n"); 
		query.append("FROM    LSE_RCV_RNTL_CHG A, LSE_RCV_RNTL_CHG_DTL B , PARAM P" ).append("\n"); 
		query.append("WHERE   A.COST_YRMON   = B.COST_YRMON" ).append("\n"); 
		query.append("  AND   A.RCV_RNTL_SEQ = B.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("  AND   A.AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("  AND   A.AGMT_SEQ     = B.AGMT_SEQ" ).append("\n"); 
		query.append("  AND   A.QTY_YRMON like  P.PERIOD_YEAR || '%'" ).append("\n"); 
		query.append("  AND   A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("  AND   B.LSE_RCV_CHG_CRE_CD <> 'D'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${receivable} == 'A' ) " ).append("\n"); 
		query.append("  AND   A.LSE_CNTR_CHG_STS_CD = 'I'               --Actual Amount경우 조건, Total Amount 인 경우 조건이 없어짐.." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' ) " ).append("\n"); 
		query.append("  AND   A.AGMT_CTY_CD  = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("  AND   A.AGMT_SEQ     = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} == 'SBO' ) " ).append("\n"); 
		query.append("  AND   B.LSTM_CD = 'SO'" ).append("\n"); 
		query.append("#elseif (${status} == 'MUO' ) " ).append("\n"); 
		query.append("  AND   B.LSTM_CD = 'MO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("  AND   A.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("    	    AND     B.LSTM_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("			        '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			        '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("            AND     B.CNTR_TPSZ_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("			        '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			        '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${charge_type_cd_str} != '')" ).append("\n"); 
		query.append("            AND     B.LSE_RCV_CHG_TP_CD IN (" ).append("\n"); 
		query.append("	        #foreach($key IN ${charge_type_cd})" ).append("\n"); 
		query.append("		        #if($velocityCount < $charge_type_cd.size())" ).append("\n"); 
		query.append("			        '$key'," ).append("\n"); 
		query.append("		        #else" ).append("\n"); 
		query.append("			        '$key'" ).append("\n"); 
		query.append("		        #end" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     #if (${loc_tp} == 'R')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD)" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("            AND     SUBSTR(B.OFFH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.VNDR_SEQ, A.VNDR_ABBR_NM )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" VNDR_SEQ," ).append("\n"); 
		query.append(" ABBR_NM," ).append("\n"); 
		query.append(" JAN," ).append("\n"); 
		query.append(" FEB," ).append("\n"); 
		query.append(" MAR," ).append("\n"); 
		query.append(" TTL_1," ).append("\n"); 
		query.append(" APR," ).append("\n"); 
		query.append(" MAY," ).append("\n"); 
		query.append(" JUN," ).append("\n"); 
		query.append(" TTL_2," ).append("\n"); 
		query.append(" JUL," ).append("\n"); 
		query.append(" AUG," ).append("\n"); 
		query.append(" SEP," ).append("\n"); 
		query.append(" TTL_3," ).append("\n"); 
		query.append(" OCT," ).append("\n"); 
		query.append(" NOV," ).append("\n"); 
		query.append(" DEC," ).append("\n"); 
		query.append(" TTL_4," ).append("\n"); 
		query.append(" G_TTL" ).append("\n"); 
		query.append("FROM XXX " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" 'G.TTL' VNDR_SEQ," ).append("\n"); 
		query.append(" NULL ABBR_NM," ).append("\n"); 
		query.append(" SUM(JAN)," ).append("\n"); 
		query.append(" SUM(FEB)," ).append("\n"); 
		query.append(" SUM(MAR)," ).append("\n"); 
		query.append(" SUM(TTL_1)," ).append("\n"); 
		query.append(" SUM(APR)," ).append("\n"); 
		query.append(" SUM(MAY)," ).append("\n"); 
		query.append(" SUM(JUN)," ).append("\n"); 
		query.append(" SUM(TTL_2)," ).append("\n"); 
		query.append(" SUM(JUL)," ).append("\n"); 
		query.append(" SUM(AUG)," ).append("\n"); 
		query.append(" SUM(SEP)," ).append("\n"); 
		query.append(" SUM(TTL_3)," ).append("\n"); 
		query.append(" SUM(OCT)," ).append("\n"); 
		query.append(" SUM(NOV)," ).append("\n"); 
		query.append(" SUM(DEC)," ).append("\n"); 
		query.append(" SUM(TTL_4)," ).append("\n"); 
		query.append(" SUM(G_TTL)" ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("GROUP BY 1" ).append("\n"); 

	}
}