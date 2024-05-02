/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOsearchReceivablebyLessorMonthReportDataRSQL.java
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

public class ReceivableRentalCostDBDAOsearchReceivablebyLessorMonthReportDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Summary By Total Charge Type
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOsearchReceivablebyLessorMonthReportDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOsearchReceivablebyLessorMonthReportDataRSQL").append("\n"); 
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
		query.append(" COST_YRMON," ).append("\n"); 
		query.append(" CHARGE_TYPE," ).append("\n"); 
		query.append(" VNDR_SEQ," ).append("\n"); 
		query.append(" ABBR_NM," ).append("\n"); 
		query.append(" LSTM_CD," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})   " ).append("\n"); 
		query.append("   $key,  " ).append("\n"); 
		query.append(" #end " ).append("\n"); 
		query.append(" G_TTL ," ).append("\n"); 
		query.append(" AGMT_NO" ).append("\n"); 
		query.append("FROM(SELECT" ).append("\n"); 
		query.append("   SUBSTR( A.QTY_YRMON  , 0 , 4 ) || '-' || SUBSTR( A.QTY_YRMON  , 5 , 2 )  COST_YRMON, " ).append("\n"); 
		query.append("   B.LSE_RCV_CHG_TP_CD CHARGE_TYPE," ).append("\n"); 
		query.append("   A.VNDR_SEQ ," ).append("\n"); 
		query.append("   A.VNDR_ABBR_NM ABBR_NM," ).append("\n"); 
		query.append("   A.LSTM_CD ," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   SUM(DECODE(B.CNTR_TPSZ_CD, '$key', B.COST_AMT, 0)) $key ," ).append("\n"); 
		query.append(" #end  " ).append("\n"); 
		query.append("   ( #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("	    #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("	       SUM(DECODE(B.CNTR_TPSZ_CD, '$key', B.COST_AMT, 0)) +" ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("	       SUM(DECODE(B.CNTR_TPSZ_CD, '$key', B.COST_AMT, 0))" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	 #end ) G_TTL , " ).append("\n"); 
		query.append("   A.AGMT_CTY_CD ||  LTRIM(To_CHAR(A.AGMT_SEQ,'000000')) AGMT_NO" ).append("\n"); 
		query.append(" FROM LSE_RCV_RNTL_CHG A, LSE_RCV_RNTL_CHG_DTL B " ).append("\n"); 
		query.append("WHERE A.COST_YRMON   = B.COST_YRMON" ).append("\n"); 
		query.append("  AND A.RCV_RNTL_SEQ = B.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("  AND A.AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("  AND A.AGMT_SEQ     = B.AGMT_SEQ" ).append("\n"); 
		query.append("  AND A.QTY_YRMON BETWEEN @[period_stdt] AND @[period_eddt]" ).append("\n"); 
		query.append("  AND A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("  AND B.LSE_RCV_CHG_CRE_CD <> 'D'" ).append("\n"); 
		query.append("#if (${receivable} == 'S' ) " ).append("\n"); 
		query.append("  AND A.LSE_CNTR_CHG_STS_CD = 'I'               --S/O Amount경우 조건, Total Amount 인 경우 조건이 없어짐.." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} == 'SBO' ) " ).append("\n"); 
		query.append("  AND   B.LSTM_CD = 'SO'" ).append("\n"); 
		query.append("#elseif (${status} == 'MUO' ) " ).append("\n"); 
		query.append("  AND   B.LSTM_CD = 'MO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' ) " ).append("\n"); 
		query.append("  AND A.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("  AND A.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("  AND B.LSTM_CD IN (" ).append("\n"); 
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
		query.append("  AND B.CNTR_TPSZ_CD IN (" ).append("\n"); 
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
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     #if (${loc_tp} == 'R')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("            AND     SUBSTR(B.OFFH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.QTY_YRMON , B.LSE_RCV_CHG_TP_CD , A.VNDR_SEQ , A.VNDR_ABBR_NM , A.LSTM_CD , A.AGMT_CTY_CD ||  LTRIM(To_CHAR(A.AGMT_SEQ,'000000')) " ).append("\n"); 
		query.append("ORDER BY COST_YRMON , LSE_RCV_CHG_TP_CD )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   'G.TTL' COST_YRMON, " ).append("\n"); 
		query.append("   NULL CHARGE_TYPE," ).append("\n"); 
		query.append("   NULL VNDR_SEQ ," ).append("\n"); 
		query.append("   NULL ABBR_NM," ).append("\n"); 
		query.append("   NULL LSTM_CD ," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   SUM(DECODE(B.CNTR_TPSZ_CD, '$key', B.COST_AMT, 0)) $key ," ).append("\n"); 
		query.append(" #end  " ).append("\n"); 
		query.append("   ( #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("	    #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("	       SUM(DECODE(B.CNTR_TPSZ_CD, '$key', B.COST_AMT, 0)) +" ).append("\n"); 
		query.append("	    #else" ).append("\n"); 
		query.append("	       SUM(DECODE(B.CNTR_TPSZ_CD, '$key', B.COST_AMT, 0))" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	 #end ) G_TTL , " ).append("\n"); 
		query.append("   NULL AGMT_NO" ).append("\n"); 
		query.append(" FROM LSE_RCV_RNTL_CHG A, LSE_RCV_RNTL_CHG_DTL B " ).append("\n"); 
		query.append("WHERE A.COST_YRMON   = B.COST_YRMON" ).append("\n"); 
		query.append("  AND A.RCV_RNTL_SEQ = B.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("  AND A.AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("  AND A.AGMT_SEQ     = B.AGMT_SEQ" ).append("\n"); 
		query.append("  AND A.QTY_YRMON BETWEEN @[period_stdt] AND @[period_eddt]" ).append("\n"); 
		query.append("  AND A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("  AND B.LSE_RCV_CHG_CRE_CD <> 'D'" ).append("\n"); 
		query.append("#if (${receivable} == 'S' ) " ).append("\n"); 
		query.append("  AND A.LSE_CNTR_CHG_STS_CD = 'I'               --S/O Amount경우 조건, Total Amount 인 경우 조건이 없어짐.." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} == 'SBO' ) " ).append("\n"); 
		query.append("  AND   B.LSTM_CD = 'SO'" ).append("\n"); 
		query.append("#elseif (${status} == 'MUO' ) " ).append("\n"); 
		query.append("  AND   B.LSTM_CD = 'MO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' ) " ).append("\n"); 
		query.append("  AND A.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("  AND A.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("  AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("  AND B.LSTM_CD IN (" ).append("\n"); 
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
		query.append("  AND B.CNTR_TPSZ_CD IN (" ).append("\n"); 
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
		query.append("#if (${loc_cd} != '')" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     #if (${loc_tp} == 'R')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("            AND     B.OFFH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("     #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("            AND     SUBSTR(B.OFFH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY 1" ).append("\n"); 

	}
}