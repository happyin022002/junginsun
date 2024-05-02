/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeRSQL.java
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

public class ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeRSQL(){
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
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration").append("\n"); 
		query.append("FileName : ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeRSQL").append("\n"); 
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
		query.append("            @[company]      AS COMPANY," ).append("\n"); 
		query.append("            @[status]       AS STATUS,            " ).append("\n"); 
		query.append("            @[receivable]   AS RECEIVABLE," ).append("\n"); 
		query.append("            @[agmt_cty_cd]  AS AGMT_CTY_CD," ).append("\n"); 
		query.append("            @[agmt_seq]     AS AGMT_SEQ," ).append("\n"); 
		query.append("            @[vndr_seq]     AS VNDR_SEQ," ).append("\n"); 
		query.append("            @[loc_tp]       AS LOC_TP," ).append("\n"); 
		query.append("            @[loc_cd]       AS LOC_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("    FROM    DUAL" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", XXX AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    NVL( DECODE( A.LSTM_CD, 'SO' , 'SBO' ,  'MO' , 'MUO'  ) , '  ') STATUS," ).append("\n"); 
		query.append("    NVL(A.VNDR_SEQ, 0) VNDR_SEQ , " ).append("\n"); 
		query.append("    SUBSTR(NVL(A.VNDR_ABBR_NM, '   '), 1, 3) ABBR_NM, " ).append("\n"); 
		query.append("    NVL(B.CNTR_TPSZ_CD, '  ') CNTR_TPSZ_CD , " ).append("\n"); 
		query.append("    COUNT(DISTINCT(B.CNTR_NO)) QTY, " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'PDM',B.COST_AMT,0)) PDM ,     " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'PUC',B.COST_AMT,0)) PUC , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'PCR',B.COST_AMT,0)) PCR ," ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'PUC',B.COST_AMT,0)) + SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'PCR',B.COST_AMT,0)) TTL_1 , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'LON',B.COST_AMT,0)) LON , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'LOF',B.COST_AMT,0)) LOF ," ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'LON',B.COST_AMT,0)) + SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'LOF',B.COST_AMT,0)) TTL_2 , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'GTI',B.COST_AMT,0)) GTI , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'GTO',B.COST_AMT,0)) GTO , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'GTI',B.COST_AMT,0)) + SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'GTO',B.COST_AMT,0)) TTL_3 , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'DOC',B.COST_AMT,0)) DOC , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'DCR',B.COST_AMT,0)) DCR , " ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'DOC',B.COST_AMT,0)) + SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'DCR',B.COST_AMT,0)) TTL_4 ," ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'DPP',B.COST_AMT,0)) DPP ," ).append("\n"); 
		query.append("    SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'CRD',B.CR_AMT,0)) CRD ," ).append("\n"); 
		query.append("    (SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'PDM',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'PUC',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'PCR',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'LON',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'LOF',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'GTI',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'GTO',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'DOC',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'DCR',B.COST_AMT,0)) + " ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'DPP',B.COST_AMT,0)) +" ).append("\n"); 
		query.append("     SUM(DECODE(B.LSE_RCV_CHG_TP_CD,'CRD',B.CR_AMT,0))) G_TTL " ).append("\n"); 
		query.append("FROM LSE_RCV_RNTL_CHG A, LSE_RCV_RNTL_CHG_DTL B , PARAM P" ).append("\n"); 
		query.append("WHERE   A.COST_YRMON   = B.COST_YRMON" ).append("\n"); 
		query.append("  AND   A.RCV_RNTL_SEQ = B.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("  AND   A.AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("  AND   A.AGMT_SEQ     = B.AGMT_SEQ" ).append("\n"); 
		query.append("  AND   A.QTY_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT " ).append("\n"); 
		query.append("  AND   A.CXL_FLG = 'N'" ).append("\n"); 
		query.append("  AND   B.LSE_RCV_CHG_CRE_CD <> 'D'" ).append("\n"); 
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
		query.append("GROUP BY A.LSTM_CD, A.VNDR_SEQ, A.VNDR_ABBR_NM, B.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" STATUS," ).append("\n"); 
		query.append(" VNDR_SEQ ," ).append("\n"); 
		query.append(" ABBR_NM ," ).append("\n"); 
		query.append(" CNTR_TPSZ_CD , " ).append("\n"); 
		query.append(" QTY, " ).append("\n"); 
		query.append(" PDM ,     " ).append("\n"); 
		query.append(" PUC , " ).append("\n"); 
		query.append(" PCR ," ).append("\n"); 
		query.append(" TTL_1 , " ).append("\n"); 
		query.append(" LON , " ).append("\n"); 
		query.append(" LOF ," ).append("\n"); 
		query.append(" TTL_2 , " ).append("\n"); 
		query.append(" GTI , " ).append("\n"); 
		query.append(" GTO , " ).append("\n"); 
		query.append(" TTL_3 ," ).append("\n"); 
		query.append(" DOC , " ).append("\n"); 
		query.append(" DCR , " ).append("\n"); 
		query.append(" TTL_4 ," ).append("\n"); 
		query.append(" DPP ," ).append("\n"); 
		query.append(" CRD ," ).append("\n"); 
		query.append(" G_TTL " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT " ).append("\n"); 
		query.append(" STATUS," ).append("\n"); 
		query.append(" VNDR_SEQ ," ).append("\n"); 
		query.append(" ABBR_NM ," ).append("\n"); 
		query.append(" CNTR_TPSZ_CD , " ).append("\n"); 
		query.append(" QTY, " ).append("\n"); 
		query.append(" PDM ,     " ).append("\n"); 
		query.append(" PUC , " ).append("\n"); 
		query.append(" PCR ," ).append("\n"); 
		query.append(" TTL_1 , " ).append("\n"); 
		query.append(" LON , " ).append("\n"); 
		query.append(" LOF ," ).append("\n"); 
		query.append(" TTL_2 , " ).append("\n"); 
		query.append(" GTI , " ).append("\n"); 
		query.append(" GTO , " ).append("\n"); 
		query.append(" TTL_3 ," ).append("\n"); 
		query.append(" DOC , " ).append("\n"); 
		query.append(" DCR , " ).append("\n"); 
		query.append(" TTL_4 ," ).append("\n"); 
		query.append(" DPP ," ).append("\n"); 
		query.append(" CRD ," ).append("\n"); 
		query.append(" G_TTL " ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" STATUS," ).append("\n"); 
		query.append(" VNDR_SEQ ," ).append("\n"); 
		query.append(" ABBR_NM ," ).append("\n"); 
		query.append(" CNTR_TPSZ_CD , " ).append("\n"); 
		query.append(" ABBR_NM1," ).append("\n"); 
		query.append(" QTY, " ).append("\n"); 
		query.append(" PDM ,     " ).append("\n"); 
		query.append(" PUC , " ).append("\n"); 
		query.append(" PCR ," ).append("\n"); 
		query.append(" TTL_1 , " ).append("\n"); 
		query.append(" LON , " ).append("\n"); 
		query.append(" LOF ," ).append("\n"); 
		query.append(" TTL_2 , " ).append("\n"); 
		query.append(" GTI , " ).append("\n"); 
		query.append(" GTO , " ).append("\n"); 
		query.append(" TTL_3 ," ).append("\n"); 
		query.append(" DOC , " ).append("\n"); 
		query.append(" DCR , " ).append("\n"); 
		query.append(" TTL_4 ," ).append("\n"); 
		query.append(" DPP ," ).append("\n"); 
		query.append(" CRD ," ).append("\n"); 
		query.append(" G_TTL " ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" STATUS," ).append("\n"); 
		query.append(" TO_CHAR(VNDR_SEQ) VNDR_SEQ ," ).append("\n"); 
		query.append(" ABBR_NM , " ).append("\n"); 
		query.append(" XXX.CNTR_TPSZ_CD , " ).append("\n"); 
		query.append(" '1' ABBR_NM1," ).append("\n"); 
		query.append(" QTY, " ).append("\n"); 
		query.append(" PDM ,     " ).append("\n"); 
		query.append(" PUC , " ).append("\n"); 
		query.append(" PCR ," ).append("\n"); 
		query.append(" TTL_1 , " ).append("\n"); 
		query.append(" LON , " ).append("\n"); 
		query.append(" LOF ," ).append("\n"); 
		query.append(" TTL_2 , " ).append("\n"); 
		query.append(" GTI , " ).append("\n"); 
		query.append(" GTO , " ).append("\n"); 
		query.append(" TTL_3 ," ).append("\n"); 
		query.append(" DOC , " ).append("\n"); 
		query.append(" DCR , " ).append("\n"); 
		query.append(" TTL_4 ," ).append("\n"); 
		query.append(" DPP ," ).append("\n"); 
		query.append(" CRD ," ).append("\n"); 
		query.append(" G_TTL ," ).append("\n"); 
		query.append(" TTT.RPT_DP_SEQ" ).append("\n"); 
		query.append("FROM XXX , (SELECT CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               CNTR_SZ_CD," ).append("\n"); 
		query.append("               CNTR_TP_CD," ).append("\n"); 
		query.append("               CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("               CNTR_TPSZ_RMK," ).append("\n"); 
		query.append("               CNTR_TPSZ_ISO_CD," ).append("\n"); 
		query.append("               CNTR_TPSZ_GRP_CD," ).append("\n"); 
		query.append("               RPT_DP_SEQ" ).append("\n"); 
		query.append("            FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("            WHERE DELT_FLG='N'" ).append("\n"); 
		query.append("            AND ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("            ORDER BY RPT_DP_SEQ) TTT" ).append("\n"); 
		query.append("WHERE XXX.CNTR_TPSZ_CD = TTT.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("ORDER BY STATUS , VNDR_SEQ , TTT.RPT_DP_SEQ )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" STATUS," ).append("\n"); 
		query.append(" 'S.TTL' VNDR_SEQ ," ).append("\n"); 
		query.append(" NULL ABBR_NM ," ).append("\n"); 
		query.append(" NULL CNTR_TPSZ_CD , " ).append("\n"); 
		query.append(" '2' ABBR_NM1," ).append("\n"); 
		query.append(" SUM(QTY), " ).append("\n"); 
		query.append(" SUM(PDM) ,     " ).append("\n"); 
		query.append(" SUM(PUC) , " ).append("\n"); 
		query.append(" SUM(PCR) ," ).append("\n"); 
		query.append(" SUM(TTL_1) , " ).append("\n"); 
		query.append(" SUM(LON) , " ).append("\n"); 
		query.append(" SUM(LOF) ," ).append("\n"); 
		query.append(" SUM(TTL_2) , " ).append("\n"); 
		query.append(" SUM(GTI) , " ).append("\n"); 
		query.append(" SUM(GTO) , " ).append("\n"); 
		query.append(" SUM(TTL_3) ," ).append("\n"); 
		query.append(" SUM(DOC) , " ).append("\n"); 
		query.append(" SUM(DCR) , " ).append("\n"); 
		query.append(" SUM(TTL_4) ," ).append("\n"); 
		query.append(" SUM(DPP) ," ).append("\n"); 
		query.append(" SUM(CRD) ," ).append("\n"); 
		query.append(" SUM(G_TTL) " ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("GROUP BY STATUS)" ).append("\n"); 
		query.append("ORDER BY STATUS  , ABBR_NM1 )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" 'G.TTL' STATUS," ).append("\n"); 
		query.append(" NULL VNDR_SEQ ," ).append("\n"); 
		query.append(" NULL ABBR_NM ," ).append("\n"); 
		query.append(" NULL CNTR_TPSZ_CD , " ).append("\n"); 
		query.append(" SUM(QTY), " ).append("\n"); 
		query.append(" SUM(PDM) ,     " ).append("\n"); 
		query.append(" SUM(PUC) , " ).append("\n"); 
		query.append(" SUM(PCR) ," ).append("\n"); 
		query.append(" SUM(TTL_1) , " ).append("\n"); 
		query.append(" SUM(LON) , " ).append("\n"); 
		query.append(" SUM(LOF) ," ).append("\n"); 
		query.append(" SUM(TTL_2) , " ).append("\n"); 
		query.append(" SUM(GTI) , " ).append("\n"); 
		query.append(" SUM(GTO) , " ).append("\n"); 
		query.append(" SUM(TTL_3) ," ).append("\n"); 
		query.append(" SUM(DOC) , " ).append("\n"); 
		query.append(" SUM(DCR) , " ).append("\n"); 
		query.append(" SUM(TTL_4) ," ).append("\n"); 
		query.append(" SUM(DPP) ," ).append("\n"); 
		query.append(" SUM(CRD) ," ).append("\n"); 
		query.append(" SUM(G_TTL) " ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("GROUP BY 1" ).append("\n"); 

	}
}