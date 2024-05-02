/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOffHireResultbyLocationAgreementSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOffHireResultbyLocationAgreementSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차 장비 반납 실적을 보는 화면-Off Hire Result by Location / AGMT No(Contract No.)-Option   
	  * Summary 조회
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOffHireResultbyLocationAgreementSummaryRSQL(){
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
		params.put("old_agmt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOffHireResultbyLocationAgreementSummaryRSQL").append("\n"); 
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
		query.append("        ,@[company]  COMPANY" ).append("\n"); 
		query.append("        ,@[loc_cd] LOC_CD" ).append("\n"); 
		query.append("        ,@[loc_tp] LOC_TP" ).append("\n"); 
		query.append("        ,@[vndr_seq] VNDR_SEQ" ).append("\n"); 
		query.append("        ,@[agmt_cty_cd] AGMT_CTY_CD" ).append("\n"); 
		query.append("        ,@[agmt_seq] AGMT_SEQ" ).append("\n"); 
		query.append("        ,@[term_change] TERM_CHANGE" ).append("\n"); 
		query.append("        ,@[old_agmt_no] OLD_AGMT_NO " ).append("\n"); 
		query.append("		,@[lse_ctrt_no] LSE_CTRT_NO" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", " ).append("\n"); 
		query.append("XXX AS (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  RCC ," ).append("\n"); 
		query.append("  REF_NO ," ).append("\n"); 
		query.append("  LSTM_CD ," ).append("\n"); 
		query.append("  VNDR_ABBR_NM ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("     #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("         $key + " ).append("\n"); 
		query.append("     #else" ).append("\n"); 
		query.append("         $key" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  ) DIV_TOTAL ," ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("     $key ," ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  AGMT_CTY_CD," ).append("\n"); 
		query.append("  AGMT_SEQ," ).append("\n"); 
		query.append("  OLD_AGMT_NO," ).append("\n"); 
		query.append("  DECODE( AGMT_CTY_CD , 'ZZ' , 'S.TTL' ,  AGMT_CTY_CD || LTRIM(TO_CHAR(AGMT_SEQ , '000000'))) AGMT_NO," ).append("\n"); 
		query.append("  LSE_CTRT_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      AA RCC ," ).append("\n"); 
		query.append("      DECODE(MUL_NO, 1, 'S.TTL', REF_NO) REF_NO," ).append("\n"); 
		query.append("      DECODE(MUL_NO, 1, 'ZZ', BB) AGMT_CTY_CD," ).append("\n"); 
		query.append("      DECODE(MUL_NO, 1, '', LSTM_CD) LSTM_CD," ).append("\n"); 
		query.append("      DECODE(MUL_NO, 1, '', VNDR_ABBR_NM) VNDR_ABBR_NM," ).append("\n"); 
		query.append("      DECODE(MUL_NO, 1, '', OLD_AGMT_NO) OLD_AGMT_NO," ).append("\n"); 
		query.append("     #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("      SUM(DECODE(DD, '$key', EE, 0)) $key ," ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("      DECODE(MUL_NO, 1, 0, CC) AGMT_SEQ ," ).append("\n"); 
		query.append("	  DECODE(MUL_NO, 1, '', LSE_CTRT_NO) LSE_CTRT_NO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("#if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("        C.LCC_CD AA ," ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("        C.SCC_CD AA ," ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("        C.YD_CD AA ," ).append("\n"); 
		query.append("#elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("        C.RCC_CD AA , " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          C.AGMT_CTY_CD BB," ).append("\n"); 
		query.append("          C.AGMT_SEQ CC," ).append("\n"); 
		query.append("          A.CNTR_TPSZ_CD DD," ).append("\n"); 
		query.append("          COUNT(C.CNTR_NO) EE," ).append("\n"); 
		query.append("          D.REF_NO," ).append("\n"); 
		query.append("          D.LSTM_CD," ).append("\n"); 
		query.append("          E.VNDR_ABBR_NM," ).append("\n"); 
		query.append("          D.OLD_AGMT_NO," ).append("\n"); 
		query.append("		  D.LSE_CTRT_NO" ).append("\n"); 
		query.append("        FROM MST_CONTAINER A," ).append("\n"); 
		query.append("          MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("          MST_CNTR_STS_HIS C," ).append("\n"); 
		query.append("          LSE_AGREEMENT D ," ).append("\n"); 
		query.append("          MDM_VENDOR E ," ).append("\n"); 
		query.append("          PARAM P" ).append("\n"); 
		query.append("        WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("          AND A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("--          AND A.ONH_YD_CD <> 'KRSEL1H'" ).append("\n"); 
		query.append("		  AND A.CO_CRE_FLG = 'N'" ).append("\n"); 
		query.append("          AND C.CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("          AND C.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("          AND C.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("          AND D.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("-- T-project 특정 오피스 예외사항 제거" ).append("\n"); 
		query.append("--          AND SUBSTR(NVL(C.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("#if (${term_change} != '' )             " ).append("\n"); 
		query.append("           AND C.CNTR_LSTM_CNG_FLG = P.TERM_CHANGE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${old_agmt_no} != '' )             " ).append("\n"); 
		query.append("           AND D.OLD_AGMT_NO = P.OLD_AGMT_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lse_ctrt_no} != '' )             " ).append("\n"); 
		query.append("           AND D.LSE_CTRT_NO = P.LSE_CTRT_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dii} != '' )" ).append("\n"); 
		query.append("  #if (${dii} == 'N' )" ).append("\n"); 
		query.append("		  AND C.CNTR_STS_CD = 'LSO'" ).append("\n"); 
		query.append("  #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD = 'DIO'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		  AND C.CNTR_STS_CD IN ('LSO', 'DIO')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND C.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("#if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("          AND DECODE(P.loc_tp, 'R', C.RCC_CD, 'L', C.LCC_CD, 'S', C.SCC_CD , 'Y' , C.YD_CD , 'C' , SUBSTR(YD_CD , 0 ,2)) = P.LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("           AND D.VNDR_SEQ = P.VNDR_SEQ " ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' ) " ).append("\n"); 
		query.append("          AND A.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                     #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                        '$key'," ).append("\n"); 
		query.append("                                     #else" ).append("\n"); 
		query.append("                                        '$key'" ).append("\n"); 
		query.append("                                     #end" ).append("\n"); 
		query.append("                                 #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("          AND C.AGMT_CTY_CD  = P.AGMT_CTY_CD       " ).append("\n"); 
		query.append("          AND C.AGMT_SEQ     = P.AGMT_SEQ  " ).append("\n"); 
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
		query.append("        GROUP BY C.AGMT_CTY_CD, C.AGMT_SEQ, A.CNTR_TPSZ_CD, D.REF_NO," ).append("\n"); 
		query.append("#if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("        C.LCC_CD," ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("        C.SCC_CD, " ).append("\n"); 
		query.append("#elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("        C.YD_CD," ).append("\n"); 
		query.append("#elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("        C.RCC_CD, " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("        D.LSTM_CD," ).append("\n"); 
		query.append("        E.VNDR_ABBR_NM," ).append("\n"); 
		query.append("        D.OLD_AGMT_NO," ).append("\n"); 
		query.append("		D.LSE_CTRT_NO" ).append("\n"); 
		query.append("        )," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT 1 MUL_NO" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 2 MUL_NO" ).append("\n"); 
		query.append("        FROM DUAL)" ).append("\n"); 
		query.append("    GROUP BY AA, DECODE(MUL_NO, 1, 'ZZ', BB), DECODE(MUL_NO, 1, 0, CC), DECODE(MUL_NO, 1, 'S.TTL', REF_NO) , DECODE(MUL_NO, 1, '', LSTM_CD) , DECODE(MUL_NO, 1, '', VNDR_ABBR_NM)" ).append("\n"); 
		query.append("             , DECODE(MUL_NO, 1, '', OLD_AGMT_NO), DECODE(MUL_NO, 1, '', LSE_CTRT_NO))" ).append("\n"); 
		query.append("ORDER BY RCC, AGMT_CTY_CD, AGMT_SEQ )" ).append("\n"); 
		query.append("SELECT	RCC, REF_NO, LSTM_CD, SUPPLIER, DIV_TOTAL," ).append("\n"); 
		query.append("#foreach($key IN ${tysz})" ).append("\n"); 
		query.append("		$key ," ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("  		AGMT_CTY_CD, AGMT_SEQ, AGMT_NO, OLD_AGMT_NO, LSE_CTRT_NO" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      RCC ," ).append("\n"); 
		query.append("      REF_NO ," ).append("\n"); 
		query.append("      LSTM_CD ," ).append("\n"); 
		query.append("      VNDR_ABBR_NM AS SUPPLIER," ).append("\n"); 
		query.append("      DIV_TOTAL ," ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("         $key ," ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      AGMT_CTY_CD," ).append("\n"); 
		query.append("      AGMT_SEQ," ).append("\n"); 
		query.append("      AGMT_NO," ).append("\n"); 
		query.append("      OLD_AGMT_NO," ).append("\n"); 
		query.append("	  LSE_CTRT_NO" ).append("\n"); 
		query.append("    FROM XXX" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      'G.TTL' RCC ," ).append("\n"); 
		query.append("      REF_NO ," ).append("\n"); 
		query.append("      LSTM_CD ," ).append("\n"); 
		query.append("      VNDR_ABBR_NM SUPPLIER," ).append("\n"); 
		query.append("      SUM(DIV_TOTAL) DIV_TOTAL ," ).append("\n"); 
		query.append("     #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("      SUM($key) $key ," ).append("\n"); 
		query.append("     #end " ).append("\n"); 
		query.append("      AGMT_CTY_CD," ).append("\n"); 
		query.append("      AGMT_SEQ," ).append("\n"); 
		query.append("      AGMT_NO," ).append("\n"); 
		query.append("      OLD_AGMT_NO," ).append("\n"); 
		query.append("	  LSE_CTRT_NO" ).append("\n"); 
		query.append("    FROM XXX" ).append("\n"); 
		query.append("    WHERE AGMT_NO != 'S.TTL'" ).append("\n"); 
		query.append("    GROUP BY AGMT_CTY_CD, AGMT_SEQ, AGMT_NO, REF_NO, VNDR_ABBR_NM, LSTM_CD, OLD_AGMT_NO, LSE_CTRT_NO" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("      'TOTAL' RCC ," ).append("\n"); 
		query.append("      NULL REF_NO ," ).append("\n"); 
		query.append("      NULL LSTM_CD ," ).append("\n"); 
		query.append("      NULL SUPPLIER ," ).append("\n"); 
		query.append("      SUM(DIV_TOTAL) DIV_TOTAL ," ).append("\n"); 
		query.append("     #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("      SUM($key) $key ," ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("      'ZZ' AGMT_CTY_CD," ).append("\n"); 
		query.append("       0  AGMT_SEQ," ).append("\n"); 
		query.append("      NULL AGMT_NO," ).append("\n"); 
		query.append("      NULL OLD_AGMT_NO," ).append("\n"); 
		query.append("	  NULL LSE_CTRT_NO" ).append("\n"); 
		query.append("    FROM XXX" ).append("\n"); 
		query.append("    WHERE REF_NO = 'S.TTL'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY DECODE(RCC, 'TOTAL',2,'G.TTL',1,0), RCC, AGMT_CTY_CD, AGMT_SEQ" ).append("\n"); 

	}
}