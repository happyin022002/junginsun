/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeTySzRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.12
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.11.12 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeTySzRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Receivable Invoice 한 결과에 대하여 Charge Type , TP/SZ별로 실적을 조회
	  * 2010.11.12 남궁진호 [CHM-201007083-01]  total 부분의 avaerage 로직 에러 수정(==> total amout / total vol)
	  * </pre>
	  */
	public ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeTySzRSQL(){
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
		query.append("FileName : ReceivableRentalCostDBDAOsearchReceivableRentalReportByChargeTypeTySzRSQL").append("\n"); 
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
		query.append(") , XXX AS (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  AA.CHARGE_TYPE," ).append("\n"); 
		query.append("  AA.DIV ,  " ).append("\n"); 
		query.append("  AA.G_TTL ," ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("     $key ," ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  AA.DIV_SEQ , " ).append("\n"); 
		query.append("  BB.DSP_SEQ" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" CHARGE_TYPE," ).append("\n"); 
		query.append(" DECODE( DIV  , 1 ,'VOL' , 2 , 'AMT' , 3 , 'AVG' ) DIV ,  " ).append("\n"); 
		query.append("  CASE  WHEN DIV = 3 THEN " ).append("\n"); 
		query.append("    DECODE(SUM(G_TTL) OVER (PARTITION BY CHARGE_TYPE ORDER BY CHARGE_TYPE, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 0, 0, " ).append("\n"); 
		query.append("        ROUND( SUM(G_TTL) OVER (PARTITION BY CHARGE_TYPE    ORDER BY CHARGE_TYPE, DIV ROWS BETWEEN 1 PRECEDING AND 1 PRECEDING) /" ).append("\n"); 
		query.append("               SUM(G_TTL) OVER (PARTITION BY CHARGE_TYPE   ORDER BY CHARGE_TYPE, DIV ROWS BETWEEN 2 PRECEDING AND 2 PRECEDING), 2))" ).append("\n"); 
		query.append("   ELSE " ).append("\n"); 
		query.append("		G_TTL" ).append("\n"); 
		query.append("   END AS G_TTL," ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("     $key ," ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  DIV DIV_SEQ " ).append("\n"); 
		query.append("FROM( SELECT" ).append("\n"); 
		query.append("                LSE_RCV_CHG_TP_CD CHARGE_TYPE,  " ).append("\n"); 
		query.append("                DIV,        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("                SUM(DECODE(CNTR_TPSZ_CD, '$key', FF, 0)) $key ," ).append("\n"); 
		query.append("      #end            " ).append("\n"); 
		query.append("	   #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("                SUM(DECODE(CNTR_TPSZ_CD, '$key', FF, 0)) +" ).append("\n"); 
		query.append("      #end   " ).append("\n"); 
		query.append("                0 G_TTL " ).append("\n"); 
		query.append("      FROM( SELECT" ).append("\n"); 
		query.append("               V1.LSE_RCV_CHG_TP_CD," ).append("\n"); 
		query.append("               V1.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("               V2.DIV_SEQ DIV," ).append("\n"); 
		query.append("               CASE V2.DIV_SEQ" ).append("\n"); 
		query.append("                    WHEN 1 THEN NVL(V1.F1,0)" ).append("\n"); 
		query.append("                    WHEN 2 THEN NVL(V1.F2,0)" ).append("\n"); 
		query.append("                    WHEN 3 THEN NVL(V1.F3,0)                   " ).append("\n"); 
		query.append("               END AS FF" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            (SELECT" ).append("\n"); 
		query.append("                B.LSE_RCV_CHG_TP_CD ,     " ).append("\n"); 
		query.append("                B.CNTR_TPSZ_CD ,   " ).append("\n"); 
		query.append("                COUNT(DISTINCT(B.CNTR_NO)) F1 , " ).append("\n"); 
		query.append("                SUM(B.COST_AMT) F2 ," ).append("\n"); 
		query.append("                round( (SUM(B.COST_AMT)  / COUNT(DISTINCT(B.CNTR_NO))) * 100 ) / 100 F3" ).append("\n"); 
		query.append("             FROM    LSE_RCV_RNTL_CHG A, LSE_RCV_RNTL_CHG_DTL B , PARAM P" ).append("\n"); 
		query.append("             WHERE   A.COST_YRMON   = B.COST_YRMON" ).append("\n"); 
		query.append("             AND     A.RCV_RNTL_SEQ = B.RCV_RNTL_SEQ" ).append("\n"); 
		query.append("             AND     A.AGMT_CTY_CD  = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("             AND     A.AGMT_SEQ     = B.AGMT_SEQ" ).append("\n"); 
		query.append("             AND     A.QTY_YRMON BETWEEN P.PERIOD_STDT AND P.PERIOD_EDDT" ).append("\n"); 
		query.append("             AND     A.CXL_FLG = 'N'            " ).append("\n"); 
		query.append("             -- AND     B.FREE_DYS > 10" ).append("\n"); 
		query.append("             AND     B.LSE_RCV_CHG_CRE_CD <> 'D'" ).append("\n"); 
		query.append("#if (${receivable} == 'A' ) " ).append("\n"); 
		query.append("             AND     A.LSE_CNTR_CHG_STS_CD = 'I'               --Actual Amount경우 조건, Total Amount 인 경우 조건이 없어짐.." ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' ) " ).append("\n"); 
		query.append("             AND     A.AGMT_CTY_CD  = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("             AND     A.AGMT_SEQ     = P.AGMT_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${status} == 'SBO' ) " ).append("\n"); 
		query.append("             AND     B.LSTM_CD = 'SO'" ).append("\n"); 
		query.append("#elseif (${status} == 'MUO' ) " ).append("\n"); 
		query.append("             AND     B.LSTM_CD = 'MO'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("             AND A.VNDR_SEQ = P.VNDR_SEQ" ).append("\n"); 
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
		query.append("  AND B.LSE_RCV_CHG_TP_CD IN (" ).append("\n"); 
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
		query.append("             GROUP BY B.LSE_RCV_CHG_TP_CD , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append(") V1," ).append("\n"); 
		query.append("            ( SELECT 1 AS DIV_SEQ FROM DUAL" ).append("\n"); 
		query.append("              UNION" ).append("\n"); 
		query.append("              SELECT 2 AS DIV_SEQ FROM DUAL" ).append("\n"); 
		query.append("              UNION" ).append("\n"); 
		query.append("              SELECT 3 AS DIV_SEQ FROM DUAL) V2" ).append("\n"); 
		query.append("         )   " ).append("\n"); 
		query.append("      GROUP BY   LSE_RCV_CHG_TP_CD,  DIV )       " ).append("\n"); 
		query.append("      ORDER BY   CHARGE_TYPE  ,  DIV_SEQ ) AA ," ).append("\n"); 
		query.append("( SELECT	 1 DSP_SEQ, 'PDM' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	 2 DSP_SEQ, 'PUC' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	 3 DSP_SEQ, 'PCR' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	 4 DSP_SEQ, 'LON' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	 5 DSP_SEQ, 'LOF' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	 6 DSP_SEQ, 'DOC' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	 7 DSP_SEQ, 'DCR' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	 8 DSP_SEQ, 'DIO' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	 9 DSP_SEQ, 'DPP' CHARGE_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	10 DSP_SEQ, 'CRD' CHARGE_TYPE FROM DUAL ) BB" ).append("\n"); 
		query.append("WHERE AA.CHARGE_TYPE = BB.CHARGE_TYPE" ).append("\n"); 
		query.append("ORDER BY BB.DSP_SEQ , AA.DIV_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   CHARGE_TYPE," ).append("\n"); 
		query.append("   DIV ," ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   $key ," ).append("\n"); 
		query.append("  #end  " ).append("\n"); 
		query.append("   G_TTL " ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  CHARGE_TYPE," ).append("\n"); 
		query.append("  DIV ,  " ).append("\n"); 
		query.append("#foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   $key ," ).append("\n"); 
		query.append("  #end   " ).append("\n"); 
		query.append("  G_TTL" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("( SELECT" ).append("\n"); 
		query.append("   'G.TTL' CHARGE_TYPE," ).append("\n"); 
		query.append("   DIV ," ).append("\n"); 
		query.append("   #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("     SUM($key) $key ," ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   SUM(G_TTL) G_TTL" ).append("\n"); 
		query.append("  FROM XXX" ).append("\n"); 
		query.append("  WHERE DIV_SEQ <> 3" ).append("\n"); 
		query.append("  GROUP BY DIV , DIV_SEQ" ).append("\n"); 
		query.append("  ORDER BY DIV_SEQ )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("   'G.TTL' CHARGE_TYPE," ).append("\n"); 
		query.append("   'AVG' DIV ,      " ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   case when A.$key    > 0 AND V.$key    > 0 then round((A.$key    / V.$key   ) * 100 ) / 100  else 0 end $key ,   " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("   case when A.G_TTL > 0 AND V.G_TTL > 0 then round((A.G_TTL / V.G_TTL) * 100 ) / 100  else 0 end G_TTL   " ).append("\n"); 
		query.append("FROM ( SELECT" ).append("\n"); 
		query.append("          'G.TTL' CHARGE_TYPE," ).append("\n"); 
		query.append("         #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          SUM($key)    $key," ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("          SUM(G_TTL) G_TTL" ).append("\n"); 
		query.append("       FROM XXX " ).append("\n"); 
		query.append("       WHERE DIV = 'VOL'" ).append("\n"); 
		query.append("       GROUP BY DIV , DIV_SEQ" ).append("\n"); 
		query.append("       ORDER BY DIV_SEQ ) V , " ).append("\n"); 
		query.append("     ( SELECT" ).append("\n"); 
		query.append("          'G.TTL' CHARGE_TYPE,          " ).append("\n"); 
		query.append("         #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          SUM($key) $key," ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("          SUM(G_TTL) G_TTL" ).append("\n"); 
		query.append("       FROM XXX " ).append("\n"); 
		query.append("       WHERE DIV = 'AMT'" ).append("\n"); 
		query.append("       GROUP BY DIV , DIV_SEQ" ).append("\n"); 
		query.append("       ORDER BY DIV_SEQ ) A " ).append("\n"); 
		query.append("WHERE  V.CHARGE_TYPE = A.CHARGE_TYPE" ).append("\n"); 

	}
}