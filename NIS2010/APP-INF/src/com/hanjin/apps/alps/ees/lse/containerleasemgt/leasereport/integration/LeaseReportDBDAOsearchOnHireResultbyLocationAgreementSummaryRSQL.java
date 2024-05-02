/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOnHireResultbyLocationAgreementSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.19
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.11.19 남궁진호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author NamKoong JinHo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOnHireResultbyLocationAgreementSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차장비 임차 (ON 장비) 실적을 조회
	  * 2010.11.15 [CHM-201007039-01] 남궁진호 Term Change 조건에 따른 조회로직 수정
	  *  "Including"  -> 해당월 LSI 로 시작, 짝 lso 가 찾기==> TERM CHANGE FLAG 무시
	  *  "Excluding" -> 해당월 LSI 가 T/C='N' 로 시작, 짝 lso 가 T/C='N' 만
	  *  "Only"       -> 해당월 LSI  T/C='N', LSO가 T/C='Y' , 실제 반납한 LSO(기준 LSI 보다 큰 LSO 이고 T/C='N') 
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOnHireResultbyLocationAgreementSummaryRSQL(){
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
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("detail_cntr_tp_sz",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOnHireResultbyLocationAgreementSummaryRSQL").append("\n"); 
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
		query.append("		,@[detail_cntr_tp_sz] DTL_CNTR_TP_SZ" ).append("\n"); 
		query.append("        ,@[term_change] TERM_CHANGE /* Including(NULL), Excluding('N'), Only('Y') */" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  RCC, REF_NO,LSTM_CD,VNDR_ABBR_NM AS SUPPLIER," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("		      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("		          #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("		              $key + " ).append("\n"); 
		query.append("		          #else" ).append("\n"); 
		query.append("		              $key" ).append("\n"); 
		query.append("		          #end" ).append("\n"); 
		query.append("		      #end " ).append("\n"); 
		query.append("		  	) AS DIV_TOTAL ," ).append("\n"); 
		query.append("  		 	 #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("		          #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("		              $key , " ).append("\n"); 
		query.append("		          #else" ).append("\n"); 
		query.append("		              $key" ).append("\n"); 
		query.append("		          #end" ).append("\n"); 
		query.append("		      #end " ).append("\n"); 
		query.append("        , AGMT_CTY_CD,AGMT_SEQ,AGMT_NO" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  ROW_NUMBER() OVER (ORDER BY RCC, AGMT_SEQ) RN" ).append("\n"); 
		query.append("        , CASE WHEN  GROUPING(RCC) = 1 AND GROUPING(AGMT_SEQ) = 1 THEN 'TOTAL' WHEN GROUPING(RCC     ) = 1 THEN 'G.TTL' ELSE RCC    END AS RCC" ).append("\n"); 
		query.append("        , CASE WHEN  GROUPING(RCC) = 1 AND GROUPING(AGMT_SEQ) = 1 THEN  NULL   WHEN GROUPING(AGMT_SEQ) = 1 THEN 'S.TTL' ELSE REF_NO END AS REF_NO " ).append("\n"); 
		query.append("        , LSTM_CD, VNDR_ABBR_NM," ).append("\n"); 
		query.append("	      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("         SUM(DECODE(DD, '$key', EE, 0)) AS $key," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("          CASE WHEN  GROUPING(AGMT_SEQ) = 1 THEN 'ZZ' ELSE AGMT_CTY_CD END AS AGMT_CTY_CD" ).append("\n"); 
		query.append("        , CASE WHEN  GROUPING(AGMT_SEQ) = 1 THEN 0    ELSE AGMT_SEQ    END AS AGMT_SEQ" ).append("\n"); 
		query.append("        , CASE WHEN  GROUPING(RCC) = 1 AND GROUPING(AGMT_SEQ) = 1 THEN NULL WHEN GROUPING(AGMT_SEQ) = 1 THEN 'S.TTL' ELSE AGMT_CTY_CD || LTRIM(TO_CHAR(AGMT_SEQ , '000000')) END AS AGMT_NO" ).append("\n"); 
		query.append("FROM    (       /* CASE 1 : Term Change =무시. 해당월 LSI 로 시작, 짝 lso 가 찾기==> TERM CHANGE FLAG 무시 */" ).append("\n"); 
		query.append("        SELECT   T10.CNTR_NO, T10.AGMT_CTY_CD, T10.AGMT_SEQ" ).append("\n"); 
		query.append("                , T10.CNTR_STS_CD                 AS LSI_STS_CD" ).append("\n"); 
		query.append("                , T10.CNTR_STS_EVNT_DT            AS LSI_EVNT_DT" ).append("\n"); 
		query.append("                , T10.CNTR_LSTM_CNG_FLG           AS LSI_LSTM_CHG_CD" ).append("\n"); 
		query.append("                , T12.CNTR_STS_CD                 AS LSO_STS_CD" ).append("\n"); 
		query.append("                , T12.CNTR_STS_EVNT_DT            AS LSO_EVNT_DT" ).append("\n"); 
		query.append("                , NVL(T12.CNTR_LSTM_CNG_FLG, 'N') AS LSO_LSTM_CHG_CD" ).append("\n"); 
		query.append("                , NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD')) - T10.CNTR_STS_EVNT_DT + 1 AS USED_DAYS" ).append("\n"); 
		query.append("                , T13.CNTR_TPSZ_CD AS DD" ).append("\n"); 
		query.append("                , 1 AS EE" ).append("\n"); 
		query.append("                , T15.REF_NO" ).append("\n"); 
		query.append("                , T15.LSTM_CD" ).append("\n"); 
		query.append("                , T17.VNDR_ABBR_NM" ).append("\n"); 
		query.append("                #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("				, T10.LCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("                , T10.SCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("                , T10.YD_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("                , T10.RCC_CD AS RCC" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (PARTITION BY T10.CNTR_NO ORDER BY T10.CNTR_NO) RN" ).append("\n"); 
		query.append("                , T10.VNDR_SEQ, T10.COMPANY" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  T01.CNTR_NO, T01.CNTR_STS_SEQ, T01.YD_CD, T01.AGMT_CTY_CD, T01.AGMT_SEQ, T01.CNTR_STS_EVNT_DT, T01.CNTR_STS_CD, T01.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                	    , T01.RCC_CD, T01.LCC_CD, T01.SCC_CD," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT /*+ INDEX_ASC(T02 XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                               CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        FROM   MST_CNTR_STS_HIS T02" ).append("\n"); 
		query.append("                        WHERE  T01.CNTR_NO      = T02.CNTR_NO" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_SEQ < T02.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        AND    T02.CNTR_STS_CD  = 'LSO'" ).append("\n"); 
		query.append("                        AND    ROWNUM           = 1" ).append("\n"); 
		query.append("                        ) AS FST_CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        , P.VNDR_SEQ, P.COMPANY, P.DTL_CNTR_TP_SZ" ).append("\n"); 
		query.append("                FROM    MST_CNTR_STS_HIS T01," ).append("\n"); 
		query.append("                        PARAM P" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     DECODE(NVL(TERM_CHANGE, 'I'), 'I', 'I')   = NVL(TERM_CHANGE, 'I')                " ).append("\n"); 
		query.append("                #if (${dii} != '' )" ).append("\n"); 
		query.append("  					#if (${dii} == 'N' )" ).append("\n"); 
		query.append("          		AND CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("  					#elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("          		AND CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("  					#end" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				AND CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                AND     T01.AGMT_SEQ      <> 999990" ).append("\n"); 
		query.append("                #if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("				AND DECODE(P.loc_tp, 'R', T01.RCC_CD, 'L', T01.LCC_CD, 'S', T01.SCC_CD , 'Y' , T01.YD_CD , 'C' , SUBSTR(T01.YD_CD , 0 ,2)) = P.LOC_CD" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("				AND T01.AGMT_CTY_CD  = P.AGMT_CTY_CD       " ).append("\n"); 
		query.append("				AND T01.AGMT_SEQ     = P.AGMT_SEQ  " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                AND     CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                ) T10," ).append("\n"); 
		query.append("                MST_CNTR_STS_HIS T12," ).append("\n"); 
		query.append("                MST_CONTAINER    T13," ).append("\n"); 
		query.append("                MDM_CNTR_TP_SZ   T14," ).append("\n"); 
		query.append("                LSE_AGREEMENT    T15," ).append("\n"); 
		query.append("                MDM_VENDOR       T17" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T13.CNTR_NO" ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T14.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T12.CNTR_NO      (+)  " ).append("\n"); 
		query.append("        AND     T10.FST_CNTR_STS_SEQ    = T12.CNTR_STS_SEQ (+)" ).append("\n"); 
		query.append("        AND     T10.AGMT_CTY_CD         = T15.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T10.AGMT_SEQ            = T15.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T15.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     T13.HJS_CRE_FLG         = 'N'" ).append("\n"); 
		query.append("        #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("		AND     T10.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        #if (${detail_cntr_tp_sz} != '' ) " ).append("\n"); 
		query.append("        AND   T13.CNTR_TPSZ_CD = T10.DTL_CNTR_TP_SZ" ).append("\n"); 
		query.append("        #end			" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("	    AND  T13.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("	        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("	           '$key'," ).append("\n"); 
		query.append("	        #else" ).append("\n"); 
		query.append("	           '$key'" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	                             #end )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${company} != '' )" ).append("\n"); 
		query.append("		AND T13.CNTR_USE_CO_CD = T10.COMPANY " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("		AND   T15.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("			                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("			                                     '$key'," ).append("\n"); 
		query.append("			                                 #else" ).append("\n"); 
		query.append("			                                     '$key'" ).append("\n"); 
		query.append("			                                 #end" ).append("\n"); 
		query.append("			                             #end )" ).append("\n"); 
		query.append("				#end			" ).append("\n"); 
		query.append("        UNION ALL /* CASE 2 : 해당월 LSI 가 T/C='N' 로 시작, 짝 lso 가 T/C='N' 만 */" ).append("\n"); 
		query.append("        SELECT   T10.CNTR_NO, T10.AGMT_CTY_CD, T10.AGMT_SEQ" ).append("\n"); 
		query.append("                , T10.CNTR_STS_CD                 AS LSI_STS_CD" ).append("\n"); 
		query.append("                , T10.CNTR_STS_EVNT_DT            AS LSI_EVNT_DT" ).append("\n"); 
		query.append("                , T10.CNTR_LSTM_CNG_FLG           AS LSI_LSTM_CHG_CD" ).append("\n"); 
		query.append("                , T12.CNTR_STS_CD                 AS LSO_STS_CD" ).append("\n"); 
		query.append("                , T12.CNTR_STS_EVNT_DT            AS LSO_EVNT_DT" ).append("\n"); 
		query.append("                , NVL(T12.CNTR_LSTM_CNG_FLG, 'N') AS LSO_LSTM_CHG_CD" ).append("\n"); 
		query.append("                , NVL(T12.CNTR_STS_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD')) - T10.CNTR_STS_EVNT_DT + 1 AS USED_DAYS" ).append("\n"); 
		query.append("                , T13.CNTR_TPSZ_CD AS DD" ).append("\n"); 
		query.append("                , 1 AS EE" ).append("\n"); 
		query.append("                , T15.REF_NO" ).append("\n"); 
		query.append("                , T15.LSTM_CD" ).append("\n"); 
		query.append("                , T17.VNDR_ABBR_NM" ).append("\n"); 
		query.append("                #if     (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("				, T10.LCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("                , T10.SCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("                , T10.YD_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == ''  ) " ).append("\n"); 
		query.append("                , T10.RCC_CD AS RCC" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (PARTITION BY T10.CNTR_NO ORDER BY T10.CNTR_NO) RN" ).append("\n"); 
		query.append("                , T10.VNDR_SEQ, T10.COMPANY" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  T01.CNTR_NO, T01.CNTR_STS_SEQ, T01.YD_CD, T01.AGMT_CTY_CD, T01.AGMT_SEQ, T01.CNTR_STS_EVNT_DT" ).append("\n"); 
		query.append("                        , T01.CNTR_STS_CD, T01.CNTR_LSTM_CNG_FLG, T01.RCC_CD, T01.LCC_CD, T01.SCC_CD," ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                        SELECT /*+ INDEX_ASC(T02 XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        FROM   MST_CNTR_STS_HIS T02" ).append("\n"); 
		query.append("                        WHERE  T01.CNTR_NO      = T02.CNTR_NO" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_SEQ < T02.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        AND    T02.CNTR_STS_CD  = 'LSO'" ).append("\n"); 
		query.append("                        AND    ROWNUM           = 1" ).append("\n"); 
		query.append("                        ) AS FST_CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        , P.VNDR_SEQ, P.COMPANY" ).append("\n"); 
		query.append("                FROM    MST_CNTR_STS_HIS T01," ).append("\n"); 
		query.append("                        PARAM P" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     DECODE(TERM_CHANGE, 'N', 'N')   = TERM_CHANGE" ).append("\n"); 
		query.append("                #if (${dii} != '' )" ).append("\n"); 
		query.append("  								#if (${dii} == 'N' )" ).append("\n"); 
		query.append("          		AND     CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("  				    			#elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("          		AND     CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("  								#end" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("				AND     CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("                AND     T01.AGMT_SEQ      <> 999990" ).append("\n"); 
		query.append("                #if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("				AND   DECODE(P.loc_tp, 'R', T01.RCC_CD, 'L', T01.LCC_CD, 'S', T01.SCC_CD , 'Y' , T01.YD_CD , 'C' , SUBSTR(T01.YD_CD , 0 ,2)) = P.LOC_CD" ).append("\n"); 
		query.append("				#end								" ).append("\n"); 
		query.append("								" ).append("\n"); 
		query.append("				#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("				AND     T01.AGMT_CTY_CD  = P.AGMT_CTY_CD       " ).append("\n"); 
		query.append("				AND     T01.AGMT_SEQ     = P.AGMT_SEQ  " ).append("\n"); 
		query.append("				#end            " ).append("\n"); 
		query.append("                AND     CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                ) T10," ).append("\n"); 
		query.append("                MST_CNTR_STS_HIS T12," ).append("\n"); 
		query.append("                MST_CONTAINER    T13," ).append("\n"); 
		query.append("                MDM_CNTR_TP_SZ   T14," ).append("\n"); 
		query.append("                LSE_AGREEMENT    T15," ).append("\n"); 
		query.append("                MDM_VENDOR       T17" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T13.CNTR_NO" ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T14.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T12.CNTR_NO      (+)  " ).append("\n"); 
		query.append("        AND     T10.FST_CNTR_STS_SEQ    = T12.CNTR_STS_SEQ (+)" ).append("\n"); 
		query.append("        AND     T10.AGMT_CTY_CD         = T15.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T10.AGMT_SEQ            = T15.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T15.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     T13.HJS_CRE_FLG         = 'N'" ).append("\n"); 
		query.append("        AND     'N'                     = T10.CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("        AND     'N'                     = NVL(T12.CNTR_LSTM_CNG_FLG,  'N')" ).append("\n"); 
		query.append("        #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("		AND     T10.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("		#end				" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("	    AND  T13.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("	                                     #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("	                                        '$key'," ).append("\n"); 
		query.append("	                                     #else" ).append("\n"); 
		query.append("	                                        '$key'" ).append("\n"); 
		query.append("	                                     #end" ).append("\n"); 
		query.append("	                                 #end )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${company} != '' )" ).append("\n"); 
		query.append("		AND T13.CNTR_USE_CO_CD = T10.COMPANY " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("		AND   T15.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("		                          #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("			                                     '$key'," ).append("\n"); 
		query.append("			                                 #else" ).append("\n"); 
		query.append("			                                     '$key'" ).append("\n"); 
		query.append("			                                 #end" ).append("\n"); 
		query.append("		                             #end )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        UNION ALL /* CASE 3 : 해당월 LSO 가 T/C='Y' 로 시작, 짝 LSI  를 찾고, 실제 반납한 LSO(기준 LSO 보다 큰 LSO 이고 T/C='N') */" ).append("\n"); 
		query.append("        SELECT  T10.CNTR_NO, T10.AGMT_CTY_CD, T10.AGMT_SEQ" ).append("\n"); 
		query.append("                , T10.CNTR_STS_CD                 AS LSI_STS_CD                " ).append("\n"); 
		query.append("                , T10.LSI_EVNT_DT                     " ).append("\n"); 
		query.append("                , T10.CNTR_LSTM_CNG_FLG           AS LSI_LSTM_CHG_CD" ).append("\n"); 
		query.append("                , T10.LSO_STS_CD" ).append("\n"); 
		query.append("                , T10.LSO_EVNT_DT" ).append("\n"); 
		query.append("                , NVL(T10.LSO_LSTM_CHG_CD, 'N')   AS LSO_LSTM_CHG_CD" ).append("\n"); 
		query.append("                , NVL(LSO_EVNT_DT, TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD'), 'YYYYMMDD')) - LSI_EVNT_DT + 1 AS USED_DAYS" ).append("\n"); 
		query.append("                , T13.CNTR_TPSZ_CD AS DD" ).append("\n"); 
		query.append("                , 1 AS EE" ).append("\n"); 
		query.append("                , T15.REF_NO" ).append("\n"); 
		query.append("                , T15.LSTM_CD" ).append("\n"); 
		query.append("                , T17.VNDR_ABBR_NM" ).append("\n"); 
		query.append("                #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("				, T10.LSI_LCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'L' ) " ).append("\n"); 
		query.append("                , T10.LSI_SCC_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == 'S' ) " ).append("\n"); 
		query.append("                , T10.LSI_YD_CD AS RCC" ).append("\n"); 
		query.append("                #elseif (${loc_tp} == '' ) " ).append("\n"); 
		query.append("                , T10.LSI_RCC_CD AS RCC" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (PARTITION BY T10.CNTR_NO ORDER BY T10.CNTR_NO) RN" ).append("\n"); 
		query.append("                , '0' AS VNDR_SEQ, '' AS COMPANY" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  T12.CNTR_NO, T12.AGMT_CTY_CD, T12.AGMT_SEQ, T12.CNTR_STS_EVNT_DT AS LSI_EVNT_DT, T12.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                        , T12.CNTR_STS_CD, T12.CNTR_LSTM_CNG_FLG, T12.RCC_CD AS LSI_RCC_CD, T12.LCC_CD AS LSI_LCC_CD, T12.SCC_CD AS LSI_SCC_CD, T12.YD_CD AS LSI_YD_CD" ).append("\n"); 
		query.append("                        , T11.VNDR_SEQ, T11.COMPANY, T11.P_AGMT_CTY_CD, T11.P_AGMT_SEQ, T11.P_LOC_TP, T11.P_LOC_CD" ).append("\n"); 
		query.append("                        , ROW_NUMBER(               ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS RN" ).append("\n"); 
		query.append("                        , LEAD(T12.RCC_CD           ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_RCC_CD                        " ).append("\n"); 
		query.append("                        , LEAD(T12.LCC_CD           ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_LCC_CD" ).append("\n"); 
		query.append("                        , LEAD(T12.SCC_CD           ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_SCC_CD" ).append("\n"); 
		query.append("                        , LEAD(T12.YD_CD            ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_YD_CD                        " ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_STS_CD      ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_STS_CD" ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_STS_EVNT_DT ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_EVNT_DT" ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_STS_SEQ     ) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_STS_SEQ" ).append("\n"); 
		query.append("                        , LEAD(T12.CNTR_LSTM_CNG_FLG) OVER (PARTITION BY T12.CNTR_NO ORDER BY  T12.CNTR_STS_SEQ) AS LSO_LSTM_CHG_CD" ).append("\n"); 
		query.append("                FROM    (SELECT T01.CNTR_NO," ).append("\n"); 
		query.append("                               T01.CNTR_STS_SEQ," ).append("\n"); 
		query.append("                               T01.YD_CD," ).append("\n"); 
		query.append("                               T01.AGMT_CTY_CD," ).append("\n"); 
		query.append("                               T01.AGMT_SEQ," ).append("\n"); 
		query.append("                               T01.CNTR_STS_EVNT_DT," ).append("\n"); 
		query.append("                               T01.CNTR_STS_CD," ).append("\n"); 
		query.append("                               T01.CNTR_LSTM_CNG_FLG," ).append("\n"); 
		query.append("                               T01.RCC_CD," ).append("\n"); 
		query.append("                               (SELECT /*+ INDEX_ASC(T03 XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                                       CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                FROM   MST_CNTR_STS_HIS T03" ).append("\n"); 
		query.append("                                WHERE  T02.CNTR_NO = T03.CNTR_NO" ).append("\n"); 
		query.append("                                AND    T02.CNTR_STS_SEQ < T03.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                                AND    T03.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                                AND    T03.CNTR_STS_CD = 'LSO'" ).append("\n"); 
		query.append("                                AND    ROWNUM = 1 ) AS LSO_CNTR_STS_SEQ ," ).append("\n"); 
		query.append("                               P.VNDR_SEQ," ).append("\n"); 
		query.append("                               P.COMPANY," ).append("\n"); 
		query.append("                               P.AGMT_CTY_CD AS P_AGMT_CTY_CD," ).append("\n"); 
		query.append("                               P.AGMT_SEQ AS P_AGMT_SEQ," ).append("\n"); 
		query.append("                               P.LOC_TP AS P_LOC_TP," ).append("\n"); 
		query.append("                               P.LOC_CD AS P_LOC_CD" ).append("\n"); 
		query.append("                        FROM   MST_CNTR_STS_HIS T01," ).append("\n"); 
		query.append("                         /* LSI */" ).append("\n"); 
		query.append("                          MST_CNTR_STS_HIS T02," ).append("\n"); 
		query.append("                         /* LSI 이후 TERM CHANAGED LSO */" ).append("\n"); 
		query.append("                          PARAM P" ).append("\n"); 
		query.append("                        WHERE  1=1" ).append("\n"); 
		query.append("                        AND    DECODE(TERM_CHANGE, 'Y', 'Y') = TERM_CHANGE" ).append("\n"); 
		query.append("                        AND    T01.CNTR_NO = T02.CNTR_NO" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_SEQ = T02.PRNR_STS_SEQ " ).append("\n"); 
		query.append("                    #if (${dii} != '' ) " ).append("\n"); 
		query.append("                       #if (${dii} == 'N' )" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_CD IN ('LSI','OWN') " ).append("\n"); 
		query.append("                       #elseif (${dii} == 'Y' )" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_CD = 'DII' " ).append("\n"); 
		query.append("                       #end " ).append("\n"); 
		query.append("                   #else" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_CD IN ('LSI','DII','OWN') " ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                        AND    T02.CNTR_LSTM_CNG_FLG = 'Y'" ).append("\n"); 
		query.append("                        AND    T01.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("                        AND    T01.CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD') " ).append("\n"); 
		query.append("                        ) T11, " ).append("\n"); 
		query.append("                        MST_CNTR_STS_HIS T12                        " ).append("\n"); 
		query.append("                WHERE   T11.CNTR_NO         = T12.CNTR_NO" ).append("\n"); 
		query.append("                AND     T12.CNTR_STS_SEQ    IN (T11.CNTR_STS_SEQ, T11.LSO_CNTR_STS_SEQ)                       " ).append("\n"); 
		query.append("                )                T10," ).append("\n"); 
		query.append("                MST_CONTAINER    T13," ).append("\n"); 
		query.append("                MDM_CNTR_TP_SZ   T14," ).append("\n"); 
		query.append("                LSE_AGREEMENT    T15," ).append("\n"); 
		query.append("                MDM_VENDOR       T17" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T10.CNTR_NO             = T13.CNTR_NO" ).append("\n"); 
		query.append("        AND     T13.CNTR_TPSZ_CD        = T14.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        AND     T10.AGMT_CTY_CD         = T15.AGMT_CTY_CD" ).append("\n"); 
		query.append("        AND     T10.AGMT_SEQ            = T15.AGMT_SEQ" ).append("\n"); 
		query.append("        AND     T15.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     T13.HJS_CRE_FLG         = 'N'" ).append("\n"); 
		query.append("        AND     RN                      = 1" ).append("\n"); 
		query.append("        #if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("		AND    DECODE(P_LOC_TP, 'R', T10.LSI_RCC_CD, 'L', T10.LSI_LCC_CD, 'S', T10.LSI_SCC_CD , 'Y' , T10.LSI_YD_CD , 'C' , SUBSTR(T10.LSI_YD_CD , 0 ,2)) = P_LOC_CD" ).append("\n"); 
		query.append("		#end       " ).append("\n"); 
		query.append("        #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("		AND     T10.VNDR_SEQ            = T17.VNDR_SEQ" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("		AND T10.AGMT_CTY_CD     = P_AGMT_CTY_CD       " ).append("\n"); 
		query.append("		AND T10.AGMT_SEQ        = P_AGMT_SEQ" ).append("\n"); 
		query.append("		#end				" ).append("\n"); 
		query.append("		#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("	    AND  T13.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("	                                     #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("	                                        '$key'," ).append("\n"); 
		query.append("	                                     #else" ).append("\n"); 
		query.append("	                                        '$key'" ).append("\n"); 
		query.append("	                                     #end" ).append("\n"); 
		query.append("	                                 #end )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${company} != '' )" ).append("\n"); 
		query.append("		AND T13.CNTR_USE_CO_CD = T10.COMPANY " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("		AND   T15.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("			                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("			                                     '$key'," ).append("\n"); 
		query.append("			                                 #else" ).append("\n"); 
		query.append("			                                     '$key'" ).append("\n"); 
		query.append("			                                 #end" ).append("\n"); 
		query.append("			                             #end )" ).append("\n"); 
		query.append("		#end    " ).append("\n"); 
		query.append("        ) T20" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS ((RCC), (RCC,AGMT_CTY_CD, AGMT_SEQ, LSTM_CD, VNDR_ABBR_NM, REF_NO), (AGMT_CTY_CD, AGMT_SEQ, LSTM_CD, VNDR_ABBR_NM, REF_NO), ())" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}