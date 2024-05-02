/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OnhireApprovalDBDAOsearchPickupStatusSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.05.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireApprovalDBDAOsearchPickupStatusSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장단기 컨테이너 임차 계약 후 픽업승인에 대한 픽업 수량을 SUMMARY 한다.
	  * </pre>
	  */
	public OnhireApprovalDBDAOsearchPickupStatusSummaryRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_van_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pkup_due_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.onhireapproval.integration").append("\n"); 
		query.append("FileName : OnhireApprovalDBDAOsearchPickupStatusSummaryRSQL").append("\n"); 
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
		query.append("SELECT   NVL(BB, 'G.TTL') AUTH_NO" ).append("\n"); 
		query.append("       , CC || LTRIM(TO_CHAR(DD , '000000')) AGMT_NO" ).append("\n"); 
		query.append("       , CC AGMT_CTY_CD" ).append("\n"); 
		query.append("       , DD AGMT_SEQ" ).append("\n"); 
		query.append("       , REF_NO" ).append("\n"); 
		query.append("       , CTRT_NO" ).append("\n"); 
		query.append("       , NVL(VNDR_ABBR_NM, ' ') VNDR_ABBR_NM" ).append("\n"); 
		query.append("       , SUM(FF) AS QTY_TOTAL" ).append("\n"); 
		query.append("         #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("       , SUM(DECODE(EE, '$key', FF, 0)) $key" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("       , DECODE(DIV, 1, 'Auth VOL', 2, 'P/UP VOL', 3, 'Balance') DIVSION" ).append("\n"); 
		query.append("  FROM   (" ).append("\n"); 
		query.append("           SELECT   NVL(V1.BB, V2.BB) AS BB" ).append("\n"); 
		query.append("                  , NVL(V1.CC, V2.CC) AS CC" ).append("\n"); 
		query.append("                  , NVL(V1.DD, V2.DD) AS DD" ).append("\n"); 
		query.append("                  , NVL(V1.EE, V2.EE) AS EE" ).append("\n"); 
		query.append("                  , NVL(V1.GG, V2.GG) AS GG" ).append("\n"); 
		query.append("                  , NVL(V1.HH, V2.HH) AS HH" ).append("\n"); 
		query.append("                  , CASE V3.DIV_SEQ WHEN 1 THEN NVL(V2.FF, 0)" ).append("\n"); 
		query.append("                                    WHEN 2 THEN NVL(V1.FF, 0)" ).append("\n"); 
		query.append("                                    WHEN 3 THEN NVL(V2.FF, 0) - NVL(V1.FF, 0)" ).append("\n"); 
		query.append("                    END AS FF" ).append("\n"); 
		query.append("                  , V3.DIV_SEQ AS DIV" ).append("\n"); 
		query.append("                  , NVL(V2.REF_NO, V1.REF_NO) REF_NO" ).append("\n"); 
		query.append("                  , NVL(V2.CTRT_NO, V1.CTRT_NO) CTRT_NO" ).append("\n"); 
		query.append("                  , NVL(V2.VNDR_ABBR_NM, V1.VNDR_ABBR_NM) VNDR_ABBR_NM" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   A.CNTR_AUTH_NO BB" ).append("\n"); 
		query.append("                             , A.AGMT_CTY_CD CC" ).append("\n"); 
		query.append("                             , A.AGMT_SEQ DD" ).append("\n"); 
		query.append("                             , B.CNTR_TPSZ_CD EE" ).append("\n"); 
		query.append("                             , COUNT(A.CNTR_NO) FF" ).append("\n"); 
		query.append("                             , B.LSTM_CD GG" ).append("\n"); 
		query.append("                             , DECODE(A.CNTR_OLD_VAN_FLG , 'Y', 'O' , 'N', 'N') HH" ).append("\n"); 
		query.append("                             , LA.REF_NO" ).append("\n"); 
		query.append("                             , LA.LSE_CTRT_NO CTRT_NO" ).append("\n"); 
		query.append("                             , MV.VNDR_LGL_ENG_NM VNDR_ABBR_NM" ).append("\n"); 
		query.append("                      FROM     MST_CNTR_STS_HIS A" ).append("\n"); 
		query.append("                             , MST_CONTAINER B" ).append("\n"); 
		query.append("                             , LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                             , MDM_VENDOR MV" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                      AND      SUBSTR(NVL(A.CNTR_STS_RMK, ' '), 1, 6) <> 'SELLOE'" ).append("\n"); 
		query.append("                      AND      A.CNTR_LSTM_CNG_FLG = 'N'" ).append("\n"); 
		query.append("                      AND      A.CNTR_STS_CD IN ('LSI','OWN')" ).append("\n"); 
		query.append("                      AND      A.AGMT_SEQ <> 999990" ).append("\n"); 
		query.append("                      AND      A.CNTR_AUTH_NO > ' '" ).append("\n"); 
		query.append("                      AND      LA.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND      LA.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      MV.VNDR_SEQ = LA.VNDR_SEQ" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("                      AND	   DECODE(@[loc_tp], 'R', A.RCC_CD, 'L', A.LCC_CD, 'S', A.SCC_CD) = @[loc_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      AND      TO_DATE(SUBSTR(A.CNTR_AUTH_NO, 6,8), 'YYYYMMDD') BETWEEN TO_DATE(@[period_stdt], 'YYYYMMDD') AND TO_DATE(@[period_eddt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("#if (${auth_no} != '' )" ).append("\n"); 
		query.append("                      AND      A.CNTR_AUTH_NO      = @[auth_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' )" ).append("\n"); 
		query.append("                      AND      B.LSTM_CD          IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                                    '$key'," ).append("\n"); 
		query.append("                                                 #else" ).append("\n"); 
		query.append("                                                    '$key'" ).append("\n"); 
		query.append("                                                 #end" ).append("\n"); 
		query.append("                                             #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' ) " ).append("\n"); 
		query.append("                      AND      B.CNTR_TPSZ_CD     IN ( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                                   #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                                      '$key'," ).append("\n"); 
		query.append("                                                   #else" ).append("\n"); 
		query.append("                                                      '$key'" ).append("\n"); 
		query.append("                                                   #end" ).append("\n"); 
		query.append("                                               #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )                              " ).append("\n"); 
		query.append("                      AND      A.AGMT_CTY_CD       = @[agmt_cty_cd]" ).append("\n"); 
		query.append("                      AND      A.AGMT_SEQ          = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pkup_due_dt} != '' )" ).append("\n"); 
		query.append("                      AND      EXISTS ( SELECT   1" ).append("\n"); 
		query.append("                                    FROM     LSE_ONH_APRO S" ).append("\n"); 
		query.append("                                    WHERE    S.CNTR_ONH_AUTH_NO  = A.CNTR_AUTH_NO" ).append("\n"); 
		query.append("                                    AND      S.AGMT_CTY_CD       = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                    AND      S.AGMT_SEQ          = A.AGMT_SEQ" ).append("\n"); 
		query.append("                                    AND      S.PKUP_DUE_DT      <= TO_DATE(@[pkup_due_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("                                    AND      ROWNUM              = 1" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${new_van_tp_cd} == 'N' )" ).append("\n"); 
		query.append("                      AND      A.CNTR_OLD_VAN_FLG  = 'N'" ).append("\n"); 
		query.append("#elseif(${new_van_tp_cd} == 'O' )" ).append("\n"); 
		query.append("                      AND      A.CNTR_OLD_VAN_FLG  = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      GROUP BY A.CNTR_AUTH_NO" ).append("\n"); 
		query.append("                             , A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                             , A.AGMT_SEQ" ).append("\n"); 
		query.append("                             , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             , B.LSTM_CD" ).append("\n"); 
		query.append("                             , DECODE(A.CNTR_OLD_VAN_FLG , 'Y', 'O' , 'N', 'N')" ).append("\n"); 
		query.append("                             , REF_NO" ).append("\n"); 
		query.append("                             , LSE_CTRT_NO" ).append("\n"); 
		query.append("                             , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("                    ) V1 " ).append("\n"); 
		query.append("                    FULL OUTER JOIN" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("                      SELECT   A.CNTR_ONH_AUTH_NO BB" ).append("\n"); 
		query.append("                             , A.AGMT_CTY_CD CC" ).append("\n"); 
		query.append("                             , A.AGMT_SEQ DD" ).append("\n"); 
		query.append("                             , B.CNTR_TPSZ_CD EE" ).append("\n"); 
		query.append("                             , B.ONH_QTY FF" ).append("\n"); 
		query.append("                             , A.LSTM_CD GG" ).append("\n"); 
		query.append("                             , B.NEW_VAN_TP_CD HH" ).append("\n"); 
		query.append("                             , LA.REF_NO" ).append("\n"); 
		query.append("                             , LA.LSE_CTRT_NO CTRT_NO" ).append("\n"); 
		query.append("                             , MV.VNDR_LGL_ENG_NM VNDR_ABBR_NM" ).append("\n"); 
		query.append("                      FROM     LSE_ONH_APRO A" ).append("\n"); 
		query.append("                             , LSE_ONH_APRO_QTY B" ).append("\n"); 
		query.append("                             , LSE_AGREEMENT LA" ).append("\n"); 
		query.append("                             , MDM_VENDOR MV" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                      AND      A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND      A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      B.ONH_QTY <> 0" ).append("\n"); 
		query.append("                      AND      A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      AND      LA.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                      AND      LA.AGMT_SEQ = A.AGMT_SEQ" ).append("\n"); 
		query.append("                      AND      MV.VNDR_SEQ = LA.VNDR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("                      AND     A.ONH_LOC_CD         IN ( SELECT DISTINCT LCC_CD" ).append("\n"); 
		query.append("                                                    FROM   MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("                                                    WHERE  DECODE(@[loc_tp], 'R', A.RCC_CD, 'L', A.LCC_CD, 'S', A.SCC_CD) = @[loc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      AND     TO_DATE(SUBSTR(B.CNTR_ONH_AUTH_NO , 6,8), 'YYYYMMDD') BETWEEN TO_DATE(@[period_stdt], 'YYYYMMDD') AND TO_DATE(@[period_eddt], 'YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${auth_no} != '' )" ).append("\n"); 
		query.append("                      AND     A.CNTR_ONH_AUTH_NO  = @[auth_no] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '' )" ).append("\n"); 
		query.append("                      AND     A.LSTM_CD           IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                                      #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                                        '$key'," ).append("\n"); 
		query.append("                                                      #else" ).append("\n"); 
		query.append("                                                        '$key'" ).append("\n"); 
		query.append("                                                      #end" ).append("\n"); 
		query.append("                                                    #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd_str} != '' )" ).append("\n"); 
		query.append("                      AND     B.CNTR_TPSZ_CD      IN ( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                                        #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                                           '$key'," ).append("\n"); 
		query.append("                                                        #else" ).append("\n"); 
		query.append("                                                           '$key'" ).append("\n"); 
		query.append("                                                        #end" ).append("\n"); 
		query.append("                                                    #end )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${agmt_seq} != '' )" ).append("\n"); 
		query.append("                      AND     A.AGMT_CTY_CD       = @[agmt_cty_cd] " ).append("\n"); 
		query.append("                      AND     A.AGMT_SEQ          = @[agmt_seq] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pkup_due_dt} != '' )" ).append("\n"); 
		query.append("                      AND     A.PKUP_DUE_DT      <= TO_DATE(@[pkup_due_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${new_van_tp_cd} != '' )" ).append("\n"); 
		query.append("                      AND     B.NEW_VAN_TP_CD      = @[new_van_tp_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("                      AND     B.NEW_VAN_TP_CD      IN ('N', 'O')" ).append("\n"); 
		query.append("#end                " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    ) V2" ).append("\n"); 
		query.append("           ON       V1.BB = V2.BB" ).append("\n"); 
		query.append("           AND      V1.CC = V2.CC" ).append("\n"); 
		query.append("           AND      V1.DD = V2.DD" ).append("\n"); 
		query.append("           AND      V1.EE = V2.EE" ).append("\n"); 
		query.append("           AND      V1.GG = V2.GG" ).append("\n"); 
		query.append("           AND      V1.HH = V2.HH" ).append("\n"); 
		query.append("                  , ( SELECT LEVEL AS DIV_SEQ FROM DUAL CONNECT BY LEVEL <= 3 ) V3" ).append("\n"); 
		query.append("#if (${bal_tp} == '0' )" ).append("\n"); 
		query.append("           WHERE NVL(V1.FF,0) = NVL(V2.FF,0)" ).append("\n"); 
		query.append("#elseif (${bal_tp} == '1' )" ).append("\n"); 
		query.append("           WHERE NVL(V1.FF,0) != NVL(V2.FF,0)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS ((BB,CC,DD,DIV,REF_NO,CTRT_NO,VNDR_ABBR_NM), (DIV))" ).append("\n"); 
		query.append("ORDER BY BB" ).append("\n"); 
		query.append("       , CC" ).append("\n"); 
		query.append("       , DD" ).append("\n"); 
		query.append("       , DIV " ).append("\n"); 

	}
}