/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LeaseReportDBDAOsearchOffHireResultvsDOLSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.07.12 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeaseReportDBDAOsearchOffHireResultvsDOLSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 임차장비 임차 (Off 장비) 실적을 조회(Off-Hire Vs DOL)
	  * </pre>
	  */
	public LeaseReportDBDAOsearchOffHireResultvsDOLSummaryRSQL(){
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
		params.put("dii",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : LeaseReportDBDAOsearchOffHireResultvsDOLSummaryRSQL").append("\n"); 
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
		query.append("SELECT  @[period_stdt]   PERIOD_STDT" ).append("\n"); 
		query.append("        , @[period_eddt]  PERIOD_EDDT" ).append("\n"); 
		query.append("        , @[loc_tp]       LOC_TP" ).append("\n"); 
		query.append("        , @[loc_cd]       LOC_CD" ).append("\n"); 
		query.append("        , @[agmt_cty_cd]  AGMT_CTY_CD" ).append("\n"); 
		query.append("        , @[agmt_seq]     AGMT_SEQ" ).append("\n"); 
		query.append("        , @[vndr_seq]     VNDR_SEQ" ).append("\n"); 
		query.append("        , @[term_change]  TERM_CHANGE" ).append("\n"); 
		query.append("        , @[dii]          DII" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", XXX AS (" ).append("\n"); 
		query.append("SELECT  (" ).append("\n"); 
		query.append("        SELECT  " ).append("\n"); 
		query.append("		#if(${rt_type}=='A')" ).append("\n"); 
		query.append("			A.LCC_CD || ' / ' || A.SCC_CD" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			A.LCC_CD " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        FROM    MDM_EQ_ORZ_CHT A" ).append("\n"); 
		query.append("        WHERE   A.SCC_CD = T1.SCC_CD " ).append("\n"); 
		query.append("        ) SCC_CD2," ).append("\n"); 
		query.append("#if(${rt_type}=='A')" ).append("\n"); 
		query.append("        AGMT_NO ," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		SCC_CD AS AGMT_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        DIV     ," ).append("\n"); 
		query.append("        DIV     AS DIV2," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("            #if($velocityCount < $tysz.size())" ).append("\n"); 
		query.append("                $key + " ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("                $key" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ) DIV_TOTAL ," ).append("\n"); 
		query.append("        #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("           $key ," ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AGMT_CTY_CD," ).append("\n"); 
		query.append("        AGMT_SEQ" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  AA SCC_CD ," ).append("\n"); 
		query.append("                CC || LTRIM(TO_CHAR(DD , '000000')) AGMT_NO," ).append("\n"); 
		query.append("                CC AGMT_CTY_CD," ).append("\n"); 
		query.append("                DD AGMT_SEQ," ).append("\n"); 
		query.append("                #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("                SUM(DECODE(EE, '$key', FF, 0)) $key ," ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                DIV " ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  V2.AA," ).append("\n"); 
		query.append("                                V2.CC," ).append("\n"); 
		query.append("                                V2.DD,                                " ).append("\n"); 
		query.append("                                V2.EE," ).append("\n"); 
		query.append("                                V5.DIV_SEQ AS DIV," ).append("\n"); 
		query.append("                                CASE V5.DIV_SEQ" ).append("\n"); 
		query.append("                                     WHEN 1 THEN NVL(V2.FF , 0)" ).append("\n"); 
		query.append("                                     WHEN 2 THEN NVL(V2.FFF, 0)" ).append("\n"); 
		query.append("                                     WHEN 3 THEN NVL(V2.FF , 0) - NVL(V2.FFF, 0)" ).append("\n"); 
		query.append("                                     WHEN 4 THEN NVL(V4.FF , 0)" ).append("\n"); 
		query.append("                                END AS FF" ).append("\n"); 
		query.append("                        FROM    (" ).append("\n"); 
		query.append("                                SELECT  NVL(V2.AA, V3.AA) AS AA, NVL(V2.CC, V3.CC) AS CC, NVL(V2.DD, V3.DD) AS DD, NVL(V2.EE, V3.EE) AS EE, NVL(V2.FF, 0) AS FF" ).append("\n"); 
		query.append("                                        , V3.AA AS AAA, V3.CC AS CCC, V3.DD AS DDD, V3.EE AS EEE, V3.FF AS FFF" ).append("\n"); 
		query.append("                                FROM    (" ).append("\n"); 
		query.append("                                        SELECT  A.LOC_CD            AA," ).append("\n"); 
		query.append("                                                A.AGMT_CTY_CD       CC," ).append("\n"); 
		query.append("                                                A.AGMT_SEQ          DD," ).append("\n"); 
		query.append("                                                A.CNTR_TPSZ_CD      EE," ).append("\n"); 
		query.append("                                                MAX(A.AGMT_CHG_VAL) FF" ).append("\n"); 
		query.append("                                        FROM    LSE_AGMT_RT         A," ).append("\n"); 
		query.append("                                                LSE_AGREEMENT       B," ).append("\n"); 
		query.append("                                                PARAM               P " ).append("\n"); 
		query.append("                                        WHERE   A.AGMT_CTY_CD   = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                        AND     A.AGMT_SEQ      = B.AGMT_SEQ" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                        #if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("                                            #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("                                                       AND A.LOC_CD           IN ( SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD )" ).append("\n"); 
		query.append("                                            #else" ).append("\n"); 
		query.append("                                                       AND A.LOC_CD           IN ( SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD )" ).append("\n"); 
		query.append("                                            #end " ).append("\n"); 
		query.append("                                        #end " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                        #if (${agmt_seq} != '' ) " ).append("\n"); 
		query.append("                                                       AND B.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                       AND B.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                                       AND A.CNTR_RNTL_CHG_TP_CD = 'DOCV'" ).append("\n"); 
		query.append("                                                       " ).append("\n"); 
		query.append("                                        #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("                                                       AND B.VNDR_SEQ    = P.VNDR_SEQ " ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                        #if (${cntr_tpsz_cd_str} != '' ) " ).append("\n"); 
		query.append("                                                       AND A.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                                                     #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                                                         '$key'," ).append("\n"); 
		query.append("                                                                     #else" ).append("\n"); 
		query.append("                                                                         '$key'" ).append("\n"); 
		query.append("                                                                     #end" ).append("\n"); 
		query.append("                                                                 #end )" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                        #if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("                                                       AND B.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                                                     '$key'," ).append("\n"); 
		query.append("                                                                 #else" ).append("\n"); 
		query.append("                                                                     '$key'" ).append("\n"); 
		query.append("                                                                 #end" ).append("\n"); 
		query.append("                                                             #end )" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                        GROUP BY A.LOC_CD , A.AGMT_CTY_CD , A.AGMT_SEQ , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                        ) V2 FULL OUTER JOIN" ).append("\n"); 
		query.append("                                        (" ).append("\n"); 
		query.append("                                        SELECT  A.SCC_CD            AA," ).append("\n"); 
		query.append("                                                A.AGMT_CTY_CD       CC," ).append("\n"); 
		query.append("                                                A.AGMT_SEQ          DD," ).append("\n"); 
		query.append("                                                B.CNTR_TPSZ_CD      EE," ).append("\n"); 
		query.append("                                                COUNT(A.CNTR_NO)    FF" ).append("\n"); 
		query.append("                                        FROM    MST_CNTR_STS_HIS    A," ).append("\n"); 
		query.append("                                                MST_CONTAINER       B," ).append("\n"); 
		query.append("                                                LSE_AGREEMENT       C," ).append("\n"); 
		query.append("                                                PARAM               P " ).append("\n"); 
		query.append("                                        WHERE   1=1" ).append("\n"); 
		query.append("                                        AND     A.CNTR_NO       = B.CNTR_NO" ).append("\n"); 
		query.append("                                        AND     A.AGMT_CTY_CD   = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                        AND     A.AGMT_SEQ      = C.AGMT_SEQ" ).append("\n"); 
		query.append("                                        AND     B.CO_CRE_FLG   = 'N'" ).append("\n"); 
		query.append("                                        AND     A.CNTR_STS_EVNT_DT BETWEEN TO_DATE( P.PERIOD_STDT,'YYYYMMDD') AND TO_DATE( P.PERIOD_EDDT,'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        #if (${term_change} != '' )             " ).append("\n"); 
		query.append("                                                      AND A.CNTR_LSTM_CNG_FLG = P.TERM_CHANGE" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        #if (${dii} != '' )" ).append("\n"); 
		query.append("                                          #if (${dii} == 'N' )" ).append("\n"); 
		query.append("                                        		  AND A.CNTR_STS_CD = 'LSO'" ).append("\n"); 
		query.append("                                          #elseif (${dii} == 'Y' ) " ).append("\n"); 
		query.append("                                                  AND A.CNTR_STS_CD = 'DIO'" ).append("\n"); 
		query.append("                                          #end" ).append("\n"); 
		query.append("                                        #else" ).append("\n"); 
		query.append("                                                  AND A.CNTR_STS_CD IN ('LSO', 'DIO')" ).append("\n"); 
		query.append("                                        #end    " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                        #if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("                                            #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("                                                      AND A.SCC_CD           IN ( SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD )" ).append("\n"); 
		query.append("                                            #else" ).append("\n"); 
		query.append("                                                      AND A.SCC_CD           IN ( SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD )" ).append("\n"); 
		query.append("                                            #end " ).append("\n"); 
		query.append("                                        #end " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                        #if (${agmt_seq} != '' ) " ).append("\n"); 
		query.append("                                                      AND B.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                      AND B.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("                                                      AND B.VNDR_SEQ    = P.VNDR_SEQ " ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        #if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("                                                      AND C.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                                                 #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                                                     '$key'," ).append("\n"); 
		query.append("                                                                 #else" ).append("\n"); 
		query.append("                                                                     '$key'" ).append("\n"); 
		query.append("                                                                 #end" ).append("\n"); 
		query.append("                                                             #end )" ).append("\n"); 
		query.append("                                        #end" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                                        GROUP BY A.SCC_CD , A.AGMT_CTY_CD , A.AGMT_SEQ , B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                        ) V3" ).append("\n"); 
		query.append("                                        ON (    1=1" ).append("\n"); 
		query.append("                                        AND   V2.CC = V3.CC" ).append("\n"); 
		query.append("                                        AND   V2.DD = V3.DD" ).append("\n"); 
		query.append("                                        AND   V2.EE = V3.EE" ).append("\n"); 
		query.append("                                        AND   V2.AA = V3.AA" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("                                ) V2," ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                  SELECT ML.SCC_CD AS AA" ).append("\n"); 
		query.append("                                       , LDI.AGMT_CTY_CD    AS CC" ).append("\n"); 
		query.append("                                       , LDI.AGMT_SEQ       AS DD" ).append("\n"); 
		query.append("                                       , LDI.CNTR_TPSZ_CD   AS EE" ).append("\n"); 
		query.append("                                       , SUM(LDI.CNTR_QTY) AS FF" ).append("\n"); 
		query.append("                                   FROM LSE_DLY_INVT LDI, PARAM P, MDM_LOCATION ML, LSE_AGREEMENT LA, MDM_YARD MY" ).append("\n"); 
		query.append("                                  WHERE LDI.CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append("                                    AND LDI.YD_CD       = MY.YD_CD" ).append("\n"); 
		query.append("                                    AND MY.LOC_CD       = ML.LOC_CD" ).append("\n"); 
		query.append("                                    AND LDI.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                    AND LDI.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("                                    AND LDI.EXE_DT = ( SELECT MAX(SUB.EXE_DT)" ).append("\n"); 
		query.append("                                                         FROM LSE_DLY_INVT SUB, PARAM P" ).append("\n"); 
		query.append("                                                        WHERE SUB.EXE_DT BETWEEN TO_DATE(P.PERIOD_STDT, 'YYYYMMDD') AND TO_DATE(P.PERIOD_EDDT, 'YYYYMMDD')+ 0.99999" ).append("\n"); 
		query.append("                                                          AND SUB.CNMV_STS_CD = 'MT')" ).append("\n"); 
		query.append("                                #if (${loc_cd} != '' ) " ).append("\n"); 
		query.append("                                    #if (${loc_tp} == 'R' ) " ).append("\n"); 
		query.append("                                              AND ML.SCC_CD           IN ( SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE RCC_CD = P.LOC_CD )" ).append("\n"); 
		query.append("                                    #else" ).append("\n"); 
		query.append("                                              AND ML.SCC_CD           IN ( SELECT SCC_CD FROM MDM_EQ_ORZ_CHT WHERE SCC_CD = P.LOC_CD )" ).append("\n"); 
		query.append("                                    #end " ).append("\n"); 
		query.append("                                #end                                 " ).append("\n"); 
		query.append("                                #if (${agmt_seq} != '' ) " ).append("\n"); 
		query.append("                                              AND LA.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                              AND LA.AGMT_SEQ    = P.AGMT_SEQ" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                #if (${vndr_seq} != '' ) " ).append("\n"); 
		query.append("                                              AND LA.VNDR_SEQ    = P.VNDR_SEQ " ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                #if (${cntr_tpsz_cd_str} != '' ) " ).append("\n"); 
		query.append("                                              AND LDI.CNTR_TPSZ_CD IN( #foreach($key IN ${cntr_tpsz_cd})" ).append("\n"); 
		query.append("                                                             #if($velocityCount < $cntr_tpsz_cd.size())" ).append("\n"); 
		query.append("                                                                 '$key'," ).append("\n"); 
		query.append("                                                             #else" ).append("\n"); 
		query.append("                                                                 '$key'" ).append("\n"); 
		query.append("                                                             #end" ).append("\n"); 
		query.append("                                                         #end )" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                " ).append("\n"); 
		query.append("                                #if (${lstm_cd_str} != '' ) " ).append("\n"); 
		query.append("                                              AND LA.LSTM_CD IN ( #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("                                                         #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("                                                             '$key'," ).append("\n"); 
		query.append("                                                         #else" ).append("\n"); 
		query.append("                                                             '$key'" ).append("\n"); 
		query.append("                                                         #end" ).append("\n"); 
		query.append("                                                     #end )" ).append("\n"); 
		query.append("                                #end" ).append("\n"); 
		query.append("                                  GROUP BY ML.SCC_CD, LDI.AGMT_CTY_CD, LDI.AGMT_SEQ, LDI.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                ) V4 ," ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                SELECT 1 AS DIV_SEQ FROM DUAL UNION" ).append("\n"); 
		query.append("                                SELECT 2 AS DIV_SEQ FROM DUAL UNION" ).append("\n"); 
		query.append("                                SELECT 3 AS DIV_SEQ FROM DUAL UNION" ).append("\n"); 
		query.append("                                SELECT 4 AS DIV_SEQ FROM DUAL" ).append("\n"); 
		query.append("                                ) V5" ).append("\n"); 
		query.append("                WHERE   1 =1                " ).append("\n"); 
		query.append("                AND     V2.CC = V4.CC(+)" ).append("\n"); 
		query.append("                AND     V2.DD = V4.DD(+)" ).append("\n"); 
		query.append("                AND     V2.EE = V4.EE(+)" ).append("\n"); 
		query.append("                AND     V2.AA = V4.AA(+)" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        GROUP BY AA , CC , DD , DIV" ).append("\n"); 
		query.append("        ORDER BY AA , CC , DD , DIV" ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  CASE WHEN DIV IS NULL THEN NULL WHEN SCC_CD2 IS NULL THEN 'G.TTL' ELSE SCC_CD2 END AS LOCATION," ).append("\n"); 
		query.append("        AGMT_NO     ," ).append("\n"); 
		query.append("        DECODE(DIV, 1, 'DOL', 2 , 'Off-Hired' , 3, 'Balance', 4, 'MT Inventory' )            AS DIV     ," ).append("\n"); 
		query.append("        SUM(DIV_TOTAL) AS DIV_TOTAL," ).append("\n"); 
		query.append("       #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          SUM($key) $key," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("        AGMT_CTY_CD AS AGMT_CTY_CD ," ).append("\n"); 
		query.append("        AGMT_SEQ    AS AGMT_SEQ    ," ).append("\n"); 
		query.append("        SCC_CD2     AS SCC_CD" ).append("\n"); 
		query.append("FROM    XXX" ).append("\n"); 
		query.append("GROUP BY GROUPING SETS " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SCC_CD2     ," ).append("\n"); 
		query.append("        AGMT_NO     ," ).append("\n"); 
		query.append("        DIV         ," ).append("\n"); 
		query.append("        DIV_TOTAL   , " ).append("\n"); 
		query.append("       #foreach($key IN ${tysz})" ).append("\n"); 
		query.append("          $key," ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("        AGMT_CTY_CD ," ).append("\n"); 
		query.append("        AGMT_SEQ    ," ).append("\n"); 
		query.append("        SCC_CD2       " ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        DIV" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        ," ).append("\n"); 
		query.append("        ()" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY SCC_CD2, AGMT_NO, AGMT_CTY_CD, AGMT_SEQ, DIV2" ).append("\n"); 

	}
}