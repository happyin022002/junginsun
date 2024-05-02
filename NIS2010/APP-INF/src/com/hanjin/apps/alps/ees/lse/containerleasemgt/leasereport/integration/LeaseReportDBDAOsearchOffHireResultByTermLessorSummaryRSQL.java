/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOffHireResultByTermLessorSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOffHireResultByTermLessorSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차 장비 임차 실적을 Summary 조회 Off-Hire Result by Lease Term/Lessor-Option
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOffHireResultByTermLessorSummaryRSQL(){
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
		params.put("term_change",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOffHireResultByTermLessorSummaryRSQL").append("\n"); 
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
		query.append("WITH PARAM" ).append("\n"); 
		query.append("AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         @[period_stdt] PERIOD_STDT" ).append("\n"); 
		query.append("        ,@[period_eddt] PERIOD_EDDT" ).append("\n"); 
		query.append("        ,@[loc_cd] LOC_CD" ).append("\n"); 
		query.append("        ,@[loc_tp] LOC_TP" ).append("\n"); 
		query.append("        ,@[vndr_seq] VNDR_SEQ" ).append("\n"); 
		query.append("        ,@[company]  COMPANY" ).append("\n"); 
		query.append("        ,@[term_change] TERM_CHANGE" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append(", XXX AS (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  LSTM_CD ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("    #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("       $key + " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("       $key" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  ) DIV_TOTAL ," ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("    $key ," ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" VNDR_SEQ , " ).append("\n"); 
		query.append(" CC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      AA LSTM_CD ," ).append("\n"); 
		query.append("     #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("      SUM(DECODE(DD, '$key', EE, 0)) $key  ," ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("      DECODE(MUL_NO, 1, 'S.TTL', BB) VNDR_SEQ ," ).append("\n"); 
		query.append("      DECODE(MUL_NO, 1, '', CC) CC  " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("          D.LSTM_CD AA ," ).append("\n"); 
		query.append("          D.VNDR_SEQ BB ," ).append("\n"); 
		query.append("          E.VNDR_ABBR_NM  CC," ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD DD," ).append("\n"); 
		query.append("          COUNT(C.CNTR_NO) EE" ).append("\n"); 
		query.append("        FROM MST_CONTAINER A," ).append("\n"); 
		query.append("          MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("          MST_CNTR_STS_HIS C," ).append("\n"); 
		query.append("          LSE_AGREEMENT D ," ).append("\n"); 
		query.append("          MDM_VENDOR E ," ).append("\n"); 
		query.append("          PARAM P" ).append("\n"); 
		query.append("        WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("--          AND A.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("		  AND A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("          AND A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("          AND C.CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          AND C.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND C.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("          AND D.VNDR_SEQ = E.VNDR_SEQ(+)" ).append("\n"); 
		query.append("          AND SUBSTR(NVL(C.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("#if (${term_change} != '')             " ).append("\n"); 
		query.append("          AND C.CNTR_LSTM_CNG_FLG = P.TERM_CHANGE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dii} != '' )" ).append("\n"); 
		query.append("  #if (${dii} == 'N' )" ).append("\n"); 
		query.append("		  AND C.CNTR_STS_CD IN ('LSO', 'TLL')" ).append("\n"); 
		query.append("  #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD = 'DIO'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD IN ('LSO', 'DIO', 'TLL')" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("          AND C.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("#if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("          AND D.VNDR_SEQ = P.VNDR_SEQ " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("          AND A.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                     #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                        '$key'," ).append("\n"); 
		query.append("                                     #else" ).append("\n"); 
		query.append("                                        '$key'" ).append("\n"); 
		query.append("                                     #end" ).append("\n"); 
		query.append("                                 #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${company} != '' )" ).append("\n"); 
		query.append("          AND A.CNTR_USE_CO_CD = P.COMPANY" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' )" ).append("\n"); 
		query.append("          AND D.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                     '$key'," ).append("\n"); 
		query.append("                                 #else" ).append("\n"); 
		query.append("                                     '$key'" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                             #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY D.LSTM_CD , D.VNDR_SEQ , E.VNDR_ABBR_NM , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        )," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT 1 MUL_NO" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 2 MUL_NO" ).append("\n"); 
		query.append("        FROM DUAL)" ).append("\n"); 
		query.append("    GROUP BY AA, DECODE(MUL_NO, 1, 'S.TTL', BB) , DECODE(MUL_NO, 1, '', CC) )" ).append("\n"); 
		query.append("ORDER BY LSTM_CD, VNDR_SEQ )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append(" LSTM_CD ," ).append("\n"); 
		query.append(" VNDR_SEQ," ).append("\n"); 
		query.append(" CC SUPPLIER, " ).append("\n"); 
		query.append(" #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("   $key ," ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" DIV_TOTAL" ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'G.TTL' LSTM_CD ," ).append("\n"); 
		query.append("NULL VNDR_SEQ," ).append("\n"); 
		query.append("NULL SUPPLIER," ).append("\n"); 
		query.append("#foreach($key IN ${tysz})" ).append("\n"); 
		query.append("SUM($key) $key ," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("SUM(DIV_TOTAL) DIV_TOTAL " ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("WHERE VNDR_SEQ =  'S.TTL'" ).append("\n"); 

	}
}