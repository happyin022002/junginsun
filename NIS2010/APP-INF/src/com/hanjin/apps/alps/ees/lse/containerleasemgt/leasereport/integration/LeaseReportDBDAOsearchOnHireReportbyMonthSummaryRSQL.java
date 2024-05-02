/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOnHireReportbyMonthSummaryRSQL.java
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

public class LeaseReportDBDAOsearchOnHireReportbyMonthSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 월별로 임차한 실적조회
	  * 2010.11.15 [CHM-201007039-01] 남궁진호 Term Change 조건에 따른 조회로직 수정
	  *  "Including"  -> 해당월 LSI 로 시작, 짝 lso 가 찾기==> TERM CHANGE FLAG 무시
	  *  "Excluding" -> 해당월 LSI 가 T/C='N' 로 시작, 짝 lso 가 T/C='N' 만
	  *  "Only"       -> 해당월 LSI  T/C='N', LSO가 T/C='Y' , 실제 반납한 LSO(기준 LSI 보다 큰 LSO 이고 T/C='N')
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOnHireReportbyMonthSummaryRSQL(){
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
		params.put("period_stdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.integration").append("\n"); 
		query.append("FileName : LeaseReportDBDAOsearchOnHireReportbyMonthSummaryRSQL").append("\n"); 
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
		query.append("        ,@[term_change] TERM_CHANGE" ).append("\n"); 
		query.append("	FROM   DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", XXX AS ( " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          SUM(DECODE(DD, '$key' , EE, 0)) $key ," ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("      CC  " ).append("\n"); 
		query.append("FROM ( SELECT " ).append("\n"); 
		query.append("         TO_CHAR(C.CNTR_STS_EVNT_DT , 'YYYY-MM') CC," ).append("\n"); 
		query.append("         A.CNTR_TPSZ_CD DD, " ).append("\n"); 
		query.append("         COUNT(A.CNTR_NO) EE" ).append("\n"); 
		query.append("       FROM MST_CONTAINER A," ).append("\n"); 
		query.append("            MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("            MST_CNTR_STS_HIS C," ).append("\n"); 
		query.append("            LSE_AGREEMENT D ," ).append("\n"); 
		query.append("            PARAM P" ).append("\n"); 
		query.append("       WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND   A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("       AND   C.CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')" ).append("\n"); 
		query.append("       AND   C.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND   C.AGMT_SEQ    = D.AGMT_SEQ" ).append("\n"); 
		query.append("       AND   SUBSTR(NVL(C.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("       AND   C.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("	   AND   A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("	   AND   P.TERM_CHANGE IS NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dii} != '' )" ).append("\n"); 
		query.append("  #if (${dii} == 'N' )" ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("  #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("       AND DECODE(P.loc_tp, 'R', C.RCC_CD, 'L', C.LCC_CD, 'S', C.SCC_CD ) = P.LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("          AND D.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                     '$key'," ).append("\n"); 
		query.append("                                 #else" ).append("\n"); 
		query.append("                                     '$key'" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                             #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       GROUP BY TO_CHAR(C.CNTR_STS_EVNT_DT , 'YYYY-MM'), A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("	    UNION ALL /* Term Change Excluding */" ).append("\n"); 
		query.append("	   SELECT " ).append("\n"); 
		query.append("         TO_CHAR(C.CNTR_STS_EVNT_DT , 'YYYY-MM') CC," ).append("\n"); 
		query.append("         A.CNTR_TPSZ_CD DD, " ).append("\n"); 
		query.append("         COUNT(A.CNTR_NO) EE" ).append("\n"); 
		query.append("       FROM MST_CONTAINER A," ).append("\n"); 
		query.append("            MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("            (SELECT A.*" ).append("\n"); 
		query.append("               FROM " ).append("\n"); 
		query.append("                 (SELECT A.*," ).append("\n"); 
		query.append("                     (SELECT /*+ INDEX_ASC(T02 XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                               CNTR_STS_SEQ" ).append("\n"); 
		query.append("                      FROM   MST_CNTR_STS_HIS T02" ).append("\n"); 
		query.append("                      WHERE  A.CNTR_NO      = T02.CNTR_NO" ).append("\n"); 
		query.append("                      AND    A.CNTR_STS_SEQ < T02.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                      AND    T02.CNTR_STS_CD  = 'LSO'" ).append("\n"); 
		query.append("                      AND    T02.CNTR_LSTM_CNG_FLG='Y'" ).append("\n"); 
		query.append("                      AND    ROWNUM           = 1" ).append("\n"); 
		query.append("                      ) AS LSO_STS_SEQ" ).append("\n"); 
		query.append("              FROM   MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("                     PARAM P" ).append("\n"); 
		query.append("              WHERE   A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD') " ).append("\n"); 
		query.append("               AND    A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("               AND    A.CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("               AND    A.CNTR_LSTM_CNG_FLG='N'					  " ).append("\n"); 
		query.append("               AND    SUBSTR(NVL(A.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("                )A" ).append("\n"); 
		query.append("           WHERE LSO_STS_SEQ IS NULL )C," ).append("\n"); 
		query.append("            LSE_AGREEMENT D ," ).append("\n"); 
		query.append("            PARAM P" ).append("\n"); 
		query.append("       WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND   A.CNTR_NO 		= C.CNTR_NO" ).append("\n"); 
		query.append("       AND   C.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND   C.AGMT_SEQ    = D.AGMT_SEQ      " ).append("\n"); 
		query.append("	   AND   A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("	   AND   P.TERM_CHANGE = 'N'      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${dii} != '' )" ).append("\n"); 
		query.append("  #if (${dii} == 'N' )" ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("  #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("       AND DECODE(P.loc_tp, 'R', C.RCC_CD, 'L', C.LCC_CD, 'S', C.SCC_CD ) = P.LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("          AND D.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                     '$key'," ).append("\n"); 
		query.append("                                 #else" ).append("\n"); 
		query.append("                                     '$key'" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                             #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       GROUP BY TO_CHAR(C.CNTR_STS_EVNT_DT , 'YYYY-MM'), A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("	   UNION ALL /* Term Change Only */" ).append("\n"); 
		query.append("	   SELECT " ).append("\n"); 
		query.append("         TO_CHAR(C.CNTR_STS_EVNT_DT , 'YYYY-MM') CC," ).append("\n"); 
		query.append("         A.CNTR_TPSZ_CD DD, " ).append("\n"); 
		query.append("         COUNT(A.CNTR_NO) EE" ).append("\n"); 
		query.append("       FROM MST_CONTAINER A," ).append("\n"); 
		query.append("            MDM_CNTR_TP_SZ B," ).append("\n"); 
		query.append("            (SELECT A.*" ).append("\n"); 
		query.append("               FROM " ).append("\n"); 
		query.append("                 (SELECT A.*," ).append("\n"); 
		query.append("                     (SELECT /*+ INDEX_ASC(T02 XPKMST_CNTR_STS_HIS) */" ).append("\n"); 
		query.append("                               CNTR_LSTM_CNG_FLG" ).append("\n"); 
		query.append("                      FROM   MST_CNTR_STS_HIS T02" ).append("\n"); 
		query.append("                      WHERE  A.CNTR_NO      = T02.CNTR_NO" ).append("\n"); 
		query.append("                      AND    A.CNTR_STS_SEQ < T02.CNTR_STS_SEQ" ).append("\n"); 
		query.append("                      AND    T02.CNTR_STS_CD  = 'LSO'" ).append("\n"); 
		query.append("                      AND    T02.CNTR_LSTM_CNG_FLG='Y'" ).append("\n"); 
		query.append("                      AND    ROWNUM           = 1" ).append("\n"); 
		query.append("                      ) AS LSO_CHK_FLG" ).append("\n"); 
		query.append("              	FROM   MST_CNTR_STS_HIS A," ).append("\n"); 
		query.append("               	      PARAM P" ).append("\n"); 
		query.append("              	WHERE   A.CNTR_STS_EVNT_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD') " ).append("\n"); 
		query.append("               	AND    A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("               	AND    A.CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("               	AND    A.CNTR_LSTM_CNG_FLG='N'					  " ).append("\n"); 
		query.append("               	AND    SUBSTR(NVL(A.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("                )A" ).append("\n"); 
		query.append("              WHERE LSO_CHK_FLG ='Y')C," ).append("\n"); 
		query.append("            LSE_AGREEMENT D ," ).append("\n"); 
		query.append("            PARAM P" ).append("\n"); 
		query.append("       WHERE A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       AND   A.CNTR_NO 		= C.CNTR_NO" ).append("\n"); 
		query.append("       AND   C.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("       AND   C.AGMT_SEQ    = D.AGMT_SEQ      " ).append("\n"); 
		query.append("	   AND   A.HJS_CRE_FLG = 'N'" ).append("\n"); 
		query.append("	   AND  'Y' 		= NVL(P.TERM_CHANGE,'N')" ).append("\n"); 
		query.append("#if (${dii} != '' )" ).append("\n"); 
		query.append("  #if (${dii} == 'N' )" ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("  #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD = 'DII'" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND C.CNTR_STS_CD IN ('LSI','DII','OWN')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("       AND DECODE(P.loc_tp, 'R', C.RCC_CD, 'L', C.LCC_CD, 'S', C.SCC_CD ) = P.LOC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("          AND D.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                     '$key'," ).append("\n"); 
		query.append("                                 #else" ).append("\n"); 
		query.append("                                     '$key'" ).append("\n"); 
		query.append("                                 #end" ).append("\n"); 
		query.append("                             #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       GROUP BY TO_CHAR(C.CNTR_STS_EVNT_DT , 'YYYY-MM'), A.CNTR_TPSZ_CD " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("GROUP BY CC " ).append("\n"); 
		query.append("ORDER BY CC )" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("  #foreach($key IN ${tysz})            " ).append("\n"); 
		query.append("   DECODE( AA.RCC , 'Ratio' ,  TO_CHAR( AA.$key , '990.00') , TO_CHAR( AA.$key , '999,999,999,990'  )) $key ,        " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  TO_CHAR( AA.DIV_TOTAL , '999,999,999,990'  ) DIV_TOTAL ," ).append("\n"); 
		query.append("  TO_CHAR((AA.DIV_TOTAL / BB.DIV_TOTAL ) * 100 , '990.00' ) || '%'  RATIO ," ).append("\n"); 
		query.append("  AA.RCC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("         $key ," ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("              $key + " ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("              $key" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("       ) DIV_TOTAL ," ).append("\n"); 
		query.append("      CC RCC" ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("        SUM( $key ) $key," ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("              SUM($key) + " ).append("\n"); 
		query.append("          #else" ).append("\n"); 
		query.append("              SUM($key)" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("       ) DIV_TOTAL ," ).append("\n"); 
		query.append("      'G.TTL' RCC" ).append("\n"); 
		query.append("FROM XXX" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("      #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("       SUM( $key ) / (" ).append("\n"); 
		query.append("          #foreach($key IN ${tysz})            " ).append("\n"); 
		query.append("              #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("                   SUM($key) + " ).append("\n"); 
		query.append("              #else" ).append("\n"); 
		query.append("                   SUM($key)" ).append("\n"); 
		query.append("              #end         " ).append("\n"); 
		query.append("          #end  " ).append("\n"); 
		query.append("                       ) * 100  $key ," ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("      100 DIV_TOTAL ," ).append("\n"); 
		query.append("      'Ratio' RCC" ).append("\n"); 
		query.append("FROM XXX ) AA , ( SELECT" ).append("\n"); 
		query.append("                    (#foreach($key IN ${tysz})            " ).append("\n"); 
		query.append("                        #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("                           SUM($key) + " ).append("\n"); 
		query.append("                        #else" ).append("\n"); 
		query.append("                           SUM($key)" ).append("\n"); 
		query.append("                        #end         " ).append("\n"); 
		query.append("                     #end ) DIV_TOTAL " ).append("\n"); 
		query.append("                  FROM XXX ) BB" ).append("\n"); 

	}
}