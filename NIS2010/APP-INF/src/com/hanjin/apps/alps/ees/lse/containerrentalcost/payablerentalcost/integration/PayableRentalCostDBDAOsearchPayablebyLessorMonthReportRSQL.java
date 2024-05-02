/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PayableRentalCostDBDAOsearchPayablebyLessorMonthReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2010.04.28 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOsearchPayablebyLessorMonthReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회
	  * </pre>
	  */
	public PayableRentalCostDBDAOsearchPayablebyLessorMonthReportRSQL(){
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
		params.put("payable",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOsearchPayablebyLessorMonthReportRSQL").append("\n"); 
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
		query.append("       COST_YRMON," ).append("\n"); 
		query.append("       CHARGE_TYPE," ).append("\n"); 
		query.append("       VNDR_SEQ," ).append("\n"); 
		query.append("       ABBR_NM," ).append("\n"); 
		query.append("       LSTM_CD," ).append("\n"); 
		query.append("#foreach($key IN ${tysz})   " ).append("\n"); 
		query.append("       $key," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("       G_TTL ," ).append("\n"); 
		query.append("       AGMT_NO" ).append("\n"); 
		query.append("  FROM ( SELECT " ).append("\n"); 
		query.append("                SUBSTR( LTMP.CHG_COST_YRMON  , 0 , 4 ) || '-' || SUBSTR(LTMP.CHG_COST_YRMON  , 5 , 2 )  COST_YRMON," ).append("\n"); 
		query.append("                LSE_PAY_CHG_TP_CD CHARGE_TYPE," ).append("\n"); 
		query.append("                NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ) VNDR_SEQ,         " ).append("\n"); 
		query.append("                SUBSTR(NVL(VNDR.VNDR_ABBR_NM, '   '), 1, 3) ABBR_NM," ).append("\n"); 
		query.append("                LSTM_CD LSTM_CD," ).append("\n"); 
		query.append("#foreach($key IN ${tysz})" ).append("\n"); 
		query.append("                SUM(DECODE(CNTR_TPSZ_CD, '$key', DECODE(@[payable], 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) $key ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("#foreach($key IN ${tysz})" ).append("\n"); 
		query.append("    #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("                 SUM(DECODE(CNTR_TPSZ_CD, '$key', DECODE(@[payable], 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) +" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("                 SUM(DECODE(CNTR_TPSZ_CD, '$key', DECODE(@[payable], 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                ) G_TTL , " ).append("\n"); 
		query.append("                LTC.AGMT_CTY_CD || LTRIM(TO_CHAR(LTC.AGMT_SEQ , '000000')) AGMT_NO   " ).append("\n"); 
		query.append("           FROM LSE_PAY_RNTL_CHG_DTL LTC," ).append("\n"); 
		query.append("                LSE_PAY_RNTL_CHG LTMP," ).append("\n"); 
		query.append("                MDM_VENDOR VNDR " ).append("\n"); 
		query.append("          WHERE LTMP.CHG_COST_YRMON BETWEEN @[period_stdt] AND @[period_eddt]" ).append("\n"); 
		query.append("            AND LTMP.LSE_PAY_RNTL_STS_CD = DECODE(@[payable], 'S', 'I', LTMP.LSE_PAY_RNTL_STS_CD)" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("            AND LTMP.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ)    = VNDR.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("            AND LTMP.LSTM_CD IN (" ).append("\n"); 
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
		query.append("            AND LTMP.AGMT_CTY_CD  = @[agmt_cty_cd]" ).append("\n"); 
		query.append("            AND LTMP.AGMT_SEQ     = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND LTMP.CHG_SEQ     = LTC.CHG_SEQ" ).append("\n"); 
		query.append("            AND LTMP.AGMT_CTY_CD = LTC.AGMT_CTY_CD" ).append("\n"); 
		query.append("            AND LTMP.AGMT_SEQ    = LTC.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${payable} == 'S')" ).append("\n"); 
		query.append("            AND NVL(LTC.CNTR_AUD_STS_CD, 'A') = 'A' -- Invoice Amount ( P.PAYABLE = 'S' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("            AND LTC.CNTR_TPSZ_CD IN (" ).append("\n"); 
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
		query.append("            AND LTC.ONH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("            AND LTC.ONH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("            AND LTC.ONH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("   #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("            AND SUBSTR(LTC.ONH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          GROUP BY LTMP.CHG_COST_YRMON ," ).append("\n"); 
		query.append("                   LSE_PAY_CHG_TP_CD ," ).append("\n"); 
		query.append("                   NVL(LTMP.PAY_VNDR_SEQ, LTMP.VNDR_SEQ) ,         " ).append("\n"); 
		query.append("                   SUBSTR(NVL(VNDR.VNDR_ABBR_NM, '   '), 1, 3) ," ).append("\n"); 
		query.append("                   LSTM_CD ,   " ).append("\n"); 
		query.append("                   LTC.AGMT_CTY_CD || LTRIM(TO_CHAR(LTC.AGMT_SEQ , '000000'))   " ).append("\n"); 
		query.append("          ORDER BY COST_YRMON , CHARGE_TYPE , VNDR_SEQ" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       'G.TTL'   COST_YRMON," ).append("\n"); 
		query.append("       NULL CHARGE_TYPE," ).append("\n"); 
		query.append("       NULL VNDR_SEQ,         " ).append("\n"); 
		query.append("       NULL ABBR_NM," ).append("\n"); 
		query.append("       NULL LSTM_CD," ).append("\n"); 
		query.append("#foreach($key IN ${tysz})" ).append("\n"); 
		query.append("       SUM(DECODE(CNTR_TPSZ_CD, '$key', DECODE(@[payable], 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) $key ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("#foreach($key IN ${tysz})" ).append("\n"); 
		query.append("    #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("        SUM(DECODE(CNTR_TPSZ_CD, '$key', DECODE(@[payable], 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0)) +" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        SUM(DECODE(CNTR_TPSZ_CD, '$key', DECODE(@[payable], 'S', LTC.DSCR_COST_AMT+LTC.CR_AMT, LTC.TTL_COST_AMT+LTC.CR_AMT), 0))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("       ) G_TTL , " ).append("\n"); 
		query.append("       NULL AGMT_NO   " ).append("\n"); 
		query.append("  FROM LSE_PAY_RNTL_CHG_DTL LTC," ).append("\n"); 
		query.append("       LSE_PAY_RNTL_CHG LTMP," ).append("\n"); 
		query.append("       MDM_VENDOR VNDR " ).append("\n"); 
		query.append(" WHERE LTMP.CHG_COST_YRMON BETWEEN @[period_stdt] AND @[period_eddt]" ).append("\n"); 
		query.append("   AND LTMP.LSE_PAY_RNTL_STS_CD = DECODE(@[payable], 'S', 'I', LTMP.LSE_PAY_RNTL_STS_CD)" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("   AND LTMP.VNDR_SEQ    = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND LTMP.VNDR_SEQ    = VNDR.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("     AND LTMP.LSTM_CD IN (" ).append("\n"); 
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
		query.append("   AND LTMP.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("   AND LTMP.AGMT_SEQ    = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND LTMP.CHG_SEQ     = LTC.CHG_SEQ" ).append("\n"); 
		query.append("   AND LTMP.AGMT_CTY_CD = LTC.AGMT_CTY_CD" ).append("\n"); 
		query.append("   AND LTMP.AGMT_SEQ    = LTC.AGMT_SEQ" ).append("\n"); 
		query.append("#if (${payable} == 'S')" ).append("\n"); 
		query.append("   AND NVL(LTC.CNTR_AUD_STS_CD, 'A') = 'A' -- Invoice Amount ( P.PAYABLE = 'S' )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '')" ).append("\n"); 
		query.append("   AND LTC.CNTR_TPSZ_CD IN (" ).append("\n"); 
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
		query.append("  #if (${loc_tp} == 'R')" ).append("\n"); 
		query.append("   AND LTC.ONH_LOC_CD IN (SELECT RCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("  #elseif (${loc_tp} == 'L')" ).append("\n"); 
		query.append("   AND LTC.ONH_LOC_CD IN (SELECT LCC_CD FROM MDM_EQ_ORZ_CHT WHERE LCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("  #elseif (${loc_tp} == 'S')" ).append("\n"); 
		query.append("   AND LTC.ONH_LOC_CD IN (SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = @[loc_cd])" ).append("\n"); 
		query.append("  #elseif (${loc_tp} == 'C')" ).append("\n"); 
		query.append("   AND SUBSTR(LTC.ONH_LOC_CD, 0 , 2 ) = P.LOC_CD" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}