/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOSearchFleetStatusListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOSearchFleetStatusListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOSearchFleetStatusListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("carrier_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOSearchFleetStatusListRSQL").append("\n"); 
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
		query.append("WITH TB_SRC AS (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ownr_seq} != '')    -- OWNER SEQ                " ).append("\n"); 
		query.append("    SELECT C.VSL_CD, C.FLET_CTRT_TP_CD, V.VNDR_SEQ, V.VNDR_LGL_ENG_NM, O.OWNR_NM" ).append("\n"); 
		query.append("    FROM FMS_CONTRACT C," ).append("\n"); 
		query.append("         MDM_VENDOR V," ).append("\n"); 
		query.append("         FMS_OWNER O" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("      AND C.VNDR_SEQ = V.VNDR_SEQ" ).append("\n"); 
		query.append("      AND V.FLET_MGMT_OWNR_VNDR_SEQ = O.OWNR_SEQ   " ).append("\n"); 
		query.append("      AND C.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("      AND O.OWNR_SEQ = @[ownr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ownr_seq} == '')    -- OWNER SEQ" ).append("\n"); 
		query.append("    SELECT 'X' AS VSL_CD FROM DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", TB_SRC1 AS (" ).append("\n"); 
		query.append("SELECT  T1.VSL_SLAN_CD, T1.CRR_CD, T1.VSL_CLASS, T1.VSL_ENG_NM, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.ROUTEX" ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("          WHEN T1.CHK_ETB_DT = MAX(DECODE(T1.CRR_CD, 'SML', NULL, T1.CHK_ETB_DT)) OVER (PARTITION BY T1.VSL_SLAN_CD) THEN" ).append("\n"); 
		query.append("                1" ).append("\n"); 
		query.append("          ELSE" ).append("\n"); 
		query.append("                0" ).append("\n"); 
		query.append("          END AS MAX_ETB" ).append("\n"); 
		query.append("        , COUNT(*) OVER (PARTITION BY T1.VSL_SLAN_CD, T1.CRR_CD, T1.VSL_CLASS) AS VSL_CNT_BY_LANE" ).append("\n"); 
		query.append("        , SUM(SUM(DECODE(T1.CRR_CD, 'SML', 1, 0))) OVER () AS VSL_CNT_HJS" ).append("\n"); 
		query.append("        , SUM(SUM(DECODE(T1.CRR_CD, 'SML', 0, 1))) OVER () AS VSL_CNT_OTH" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T1.*," ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT  TRIM(TO_CHAR(MAX(PORT_ROTN_SEQ), '0000'))" ).append("\n"); 
		query.append("                        || TRIM(TO_CHAR(MAX(S1.SVC_DUR_DYS), '0000')) " ).append("\n"); 
		query.append("                        || TRIM(TO_CHAR(MAX(NVL(S1.N1ST_VSL_CLSS_KNT, 0) + NVL(S1.N2ND_VSL_CLSS_KNT, 0) + NVL(S1.N3RD_VSL_CLSS_KNT,0)), '0000'))" ).append("\n"); 
		query.append("                        || REGEXP_REPLACE(SUBSTR(WM_CONCAT(DISTINCT TO_CHAR(PORT_ROTN_SEQ, '00') || S2.PORT_CD ), 4), ', [0-9][0-9]', '-')" ).append("\n"); 
		query.append("                FROM    VSK_PF_SKD      S1," ).append("\n"); 
		query.append("                        VSK_PF_SKD_DTL  S2" ).append("\n"); 
		query.append("                WHERE   1=1" ).append("\n"); 
		query.append("                AND     T1.VSL_SLAN_CD      = S1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND     T1.PF_SKD_TP_CD     = S1.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                AND     S1.VSL_SLAN_CD      = S2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND     S1.PF_SVC_TP_CD     = S2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                ) AS ROUTEX" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T1.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ) AS VSL_SEQ" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (PARTITION BY T1.VSL_CD ORDER BY T1.PORT_CNT DESC) AS PORT_COUNT_SEQ" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.VPS_PORT_CD, T1.CLPT_IND_SEQ, T1.CLPT_SEQ, T1.SLAN_CD, T3.VSL_SLAN_CD, T3.PF_SKD_TP_CD, T1.VPS_ETA_DT, T1.VPS_ETB_DT, T1.VPS_ETD_DT" ).append("\n"); 
		query.append("                        , TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDD') AS FM_ETB_DT, TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDDHH24MISS') AS CHK_ETB_DT" ).append("\n"); 
		query.append("                        , LEAD(T1.VSL_CD ||'-'|| T1.SKD_VOY_NO ||'-'|| T1.SKD_DIR_CD ||'-'|| T1.VPS_PORT_CD ||'-'|| T1.CLPT_IND_SEQ) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ)        AS TO_VVD" ).append("\n"); 
		query.append("                        , LEAD(TO_CHAR(T1.VPS_ETB_DT, 'YYYYMMDD')) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ)                   AS TO_ETB_DT" ).append("\n"); 
		query.append("                        , T1.SLAN_CD AS FM_SLAN_CD, LEAD(T1.SLAN_CD) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ)                 AS TO_SLAN_CD" ).append("\n"); 
		query.append("                        , T1.TURN_SKD_VOY_NO AS FM_TURN_SKD_VOY_NO, LEAD(T1.TURN_SKD_VOY_NO) OVER (PARTITION BY T1.VSL_CD ORDER BY T1.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T1.CLPT_SEQ)       AS TO_TURN_VOY" ).append("\n"); 
		query.append("                        , COUNT(*) OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD) AS PORT_CNT" ).append("\n"); 
		query.append("                        , T2.VSL_SLAN_DIR_SEQ, T4.VSL_SVC_TP_CD, NVL(T3.ACT_CRR_CD, T5.CRR_CD) AS CRR_CD, NVL(T5.CNTR_VSL_CLSS_CAPA, T5.CNTR_DZN_CAPA) AS VSL_CLASS, T5.VSL_ENG_NM" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD            T1," ).append("\n"); 
		query.append("                        MDM_VSL_SVC_LANE_DIR        T2," ).append("\n"); 
		query.append("                        VSK_VSL_SKD                 T3," ).append("\n"); 
		query.append("                        MDM_VSL_SVC_LANE            T4," ).append("\n"); 
		query.append("                        MDM_VSL_CNTR                T5," ).append("\n"); 
		query.append("						TB_SRC                      T6" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     T1.SLAN_CD          = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND     T1.SKD_DIR_CD       = T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                AND     T1.VSL_CD           = T3.VSL_CD" ).append("\n"); 
		query.append("                AND     T1.SKD_VOY_NO       = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     T1.SKD_DIR_CD       = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     T3.VSL_SLAN_CD      = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("                AND     T4.VSL_SVC_TP_CD    <> 'O'" ).append("\n"); 
		query.append("				AND     T3.VSL_CD           = DECODE(T6.VSL_CD,'X',T3.VSL_CD,T6.VSL_CD)" ).append("\n"); 
		query.append("--                AND 	T3.VSL_SLAN_CD 	= 'BSF'   -- VSL CD : 2, VSL QTY : 1" ).append("\n"); 
		query.append("--                AND     T1.VSL_CD     ='EEGL'" ).append("\n"); 
		query.append("                AND     T3.VSL_CD           = T5.VSL_CD" ).append("\n"); 
		query.append("                AND     T1.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("                AND     'S'                 <> NVL(T1.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                AND     T1.VPS_ETB_DT       BETWEEN  TO_DATE(REPLACE(@[p_date], '-', ''), 'YYYYMMDD') - 90      -- '2014-11-07'" ).append("\n"); 
		query.append("                                            AND      TO_DATE(REPLACE(@[p_date], '-', ''), 'YYYYMMDD') + 30	-- '2014-11-07'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#if(${vsl_type} == 'O')     --Owner" ).append("\n"); 
		query.append("	                and T5.VSL_OWN_IND_CD = 'O'" ).append("\n"); 
		query.append("					and NVL(T3.ACT_CRR_CD, T5.CRR_CD) = 'SML'    " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	        #if(${vsl_type} == 'C')  --Charter" ).append("\n"); 
		query.append("	                and     T5.VSL_OWN_IND_CD <> 'O'" ).append("\n"); 
		query.append("	                and     NVL(T3.ACT_CRR_CD, T5.CRR_CD) = 'SML'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	        #if(${vsl_type} == 'J')   --Joint Operation" ).append("\n"); 
		query.append("					and     NVL(T3.ACT_CRR_CD, T5.CRR_CD) <> 'SML'    -- VSL_OWN_IND_CD : owner(O), charter 포함" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("            #if(${carrier_cd}!= '')" ).append("\n"); 
		query.append("                  	AND   NVL(T3.ACT_CRR_CD, T5.CRR_CD)   = UPPER(@[carrier_cd])  -- carrier_code" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("                                         " ).append("\n"); 
		query.append("                ) T1" ).append("\n"); 
		query.append("        WHERE   1=1" ).append("\n"); 
		query.append("        AND     T1.TO_ETB_DT    IS NOT NULL -- 다음 SKD 있을 경우에 조회 대상. (다)" ).append("\n"); 
		query.append("        AND     REPLACE(@[p_date], '-', '') BETWEEN FM_ETB_DT AND TO_ETB_DT" ).append("\n"); 
		query.append("        AND     1       =   (" ).append("\n"); 
		query.append("                            CASE" ).append("\n"); 
		query.append("                            WHEN   (FM_SLAN_CD  <> TO_SLAN_CD AND TO_TURN_VOY IS NULL) THEN" ).append("\n"); 
		query.append("                                    -- TURNING PORT가 끊긴 선박은 호출하지 않는다." ).append("\n"); 
		query.append("                                    0" ).append("\n"); 
		query.append("                            ELSE" ).append("\n"); 
		query.append("                                    1" ).append("\n"); 
		query.append("                            END" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("         ) T1" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     (" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN FM_SLAN_CD = TO_SLAN_CD THEN" ).append("\n"); 
		query.append("            VSL_SEQ" ).append("\n"); 
		query.append("        WHEN FM_SLAN_CD <> TO_SLAN_CD THEN" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN   FM_ETB_DT = REPLACE(@[p_date], '-', '') THEN		-- '2014-11-07'" ).append("\n"); 
		query.append("                PORT_COUNT_SEQ" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                VSL_SEQ" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("            1" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        =" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("        WHEN FM_SLAN_CD = TO_SLAN_CD THEN" ).append("\n"); 
		query.append("            1" ).append("\n"); 
		query.append("        WHEN FM_SLAN_CD <> TO_SLAN_CD THEN" ).append("\n"); 
		query.append("            CASE" ).append("\n"); 
		query.append("            WHEN   FM_ETB_DT = REPLACE(@[p_date], '-', '') THEN		-- '2014-11-07'" ).append("\n"); 
		query.append("                    1" ).append("\n"); 
		query.append("            ELSE" ).append("\n"); 
		query.append("                    1" ).append("\n"); 
		query.append("            END" ).append("\n"); 
		query.append("        ELSE" ).append("\n"); 
		query.append("                0" ).append("\n"); 
		query.append("        END" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("GROUP BY T1.VSL_SLAN_CD, T1.CRR_CD, T1.VSL_CLASS, T1.VSL_ENG_NM, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.ROUTEX, CHK_ETB_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", TB_SRC2 AS (" ).append("\n"); 
		query.append("SELECT  T1.VSL_SLAN_CD, T1.SVC_DUR_DYS, REPLACE(WM_CONCAT( DISTINCT FLEET_STATUS ), ',', NULL) AS FLEET_STATUS, MAX(T1.ROUTE) AS ROUTE" ).append("\n"); 
		query.append("        , SUM(VSL_CD_CNT) AS VSL_CD_CNT, MAX(T1.PF_VSL_CNT)                                     AS VSL_QTY_TTL" ).append("\n"); 
		query.append("        , REPLACE(WM_CONCAT(CRR_HJS), ',', CHR(13))                                             AS HJS_VSL_OWN_NM" ).append("\n"); 
		query.append("        , REPLACE(WM_CONCAT(CRR_OTH), ',', CHR(13))                                             AS HJS_VSL_CHT_NM" ).append("\n"); 
		query.append("        , SUM(SUM( CASE WHEN HJS_GUBUN = 1 AND CRR_HJS_SEQ = 1 THEN 1 ELSE 0 END)) OVER ()      AS LANE_HJS" ).append("\n"); 
		query.append("        , SUM(COUNT(DISTINCT T1.VSL_SLAN_CD)) OVER ()" ).append("\n"); 
		query.append("          - SUM(SUM( CASE WHEN HJS_GUBUN = 1 AND CRR_HJS_SEQ = 1 THEN 1 ELSE 0 END)) OVER ()    AS LANE_OTHERS" ).append("\n"); 
		query.append("        , SUM(COUNT(DISTINCT T1.VSL_SLAN_CD)) OVER ()                                           AS LANE_TOTAL" ).append("\n"); 
		query.append("        , VSL_CNT_HJS                                                                           AS EA_HJS" ).append("\n"); 
		query.append("        , VSL_CNT_OTH                                                                           AS EA_OTHERS" ).append("\n"); 
		query.append("        , (VSL_CNT_HJS + VSL_CNT_OTH)                                                           AS EA_TOTAL" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T1.VSL_SLAN_CD, T1.CRR_CD" ).append("\n"); 
		query.append("                , TO_NUMBER(SUBSTR(MAX(MAX(T1.ROUTEX)) OVER (PARTITION BY T1.VSL_SLAN_CD), 1, 4)) AS CALLING_CNT" ).append("\n"); 
		query.append("                , TO_NUMBER(SUBSTR(MAX(MAX(T1.ROUTEX)) OVER (PARTITION BY T1.VSL_SLAN_CD), 5, 4)) AS SVC_DUR_DYS" ).append("\n"); 
		query.append("                , TO_NUMBER(SUBSTR(MAX(MAX(T1.ROUTEX)) OVER (PARTITION BY T1.VSL_SLAN_CD), 9, 4)) AS PF_VSL_CNT" ).append("\n"); 
		query.append("                , SUBSTR(MAX(MAX(T1.ROUTEX)) OVER (PARTITION BY T1.VSL_SLAN_CD), 13) AS ROUTE" ).append("\n"); 
		query.append("                , T1.VSL_CLASS ||' x '|| T1.VSL_CNT_BY_LANE ||' '|| T1.CRR_CD ||CHR(13) AS FLEET_STATUS" ).append("\n"); 
		query.append("                , DECODE(T1.CRR_CD, 'SML', T1.VSL_ENG_NM, NULL) AS CRR_HJS" ).append("\n"); 
		query.append("                , DECODE(T1.CRR_CD, 'SML', NULL, T1.VSL_ENG_NM) AS CRR_OTH" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (PARTITION BY T1.VSL_SLAN_CD ORDER BY DECODE(T1.CRR_CD, 'SML', 1, 2) ASC) AS CRR_HJS_SEQ" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (PARTITION BY T1.VSL_SLAN_CD ORDER BY DECODE(T1.CRR_CD, 'SML', 2, 1) ASC) AS CRR_OTH_SEQ" ).append("\n"); 
		query.append("                , DECODE(T1.CRR_CD, 'SML', 1, 0) AS HJS_GUBUN" ).append("\n"); 
		query.append("                , 1 AS VSL_CD_CNT, VSL_CNT_HJS, VSL_CNT_OTH" ).append("\n"); 
		query.append("        FROM    TB_SRC1 T1" ).append("\n"); 
		query.append("        GROUP BY T1.VSL_SLAN_CD, T1.VSL_CLASS ||' x '|| T1.VSL_CNT_BY_LANE ||' '|| T1.CRR_CD ||CHR(13)" ).append("\n"); 
		query.append("                 , DECODE(T1.CRR_CD, 'SML', T1.VSL_ENG_NM, NULL), DECODE(T1.CRR_CD, 'SML', NULL, T1.VSL_ENG_NM), VSL_CNT_HJS, VSL_CNT_OTH" ).append("\n"); 
		query.append("                 , T1.CRR_CD" ).append("\n"); 
		query.append("        ORDER BY T1.VSL_CLASS ||' x '|| T1.VSL_CNT_BY_LANE ||' '|| T1.CRR_CD ||CHR(13)" ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("GROUP BY T1.VSL_SLAN_CD, T1.SVC_DUR_DYS, VSL_CNT_HJS, VSL_CNT_OTH" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bsa_type} == 'Y')   --BSA Check = 'Y' START" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, TB_SRC3 AS (   --BSA Check = 'Y'" ).append("\n"); 
		query.append("	SELECT  MAX(YR_WK) AS YR_WK, VSL_SLAN_CD" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(TTL_BSA_W       ), ',', CHR(13)) AS TTL_BSA_W" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(TTL_BSA_E       ), ',', CHR(13)) AS TTL_BSA_E" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(HJS_BSA_W       ), ',', CHR(13)) AS HJS_BSA_W" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(HJS_BSA_E       ), ',', CHR(13)) AS HJS_BSA_E" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(CO_BSA_W        ), ',', CHR(13)) AS CO_BSA_W" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(CO_BSA_E        ), ',', CHR(13)) AS CO_BSA_E" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(HJS_BSA_RTO_W   ), ',', CHR(13)) AS HJS_BSA_RTO_W" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(HJS_BSA_RTO_E   ), ',', CHR(13)) AS HJS_BSA_RTO_E" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(CHTR_BSA_RTO_W  ), ',', CHR(13)) AS CHTR_BSA_RTO_W" ).append("\n"); 
		query.append("	        , REPLACE(WM_CONCAT(CHTR_BSA_RTO_E  ), ',', CHR(13)) AS CHTR_BSA_RTO_E" ).append("\n"); 
		query.append("	FROM    (" ).append("\n"); 
		query.append("	        SELECT  MAX(YR_WK) AS YR_WK, VSL_SLAN_CD, TTL_BSA_W, TTL_BSA_E, HJS_BSA_W, HJS_BSA_E" ).append("\n"); 
		query.append("	                , CASE WHEN (TTL_BSA_W > 0 AND HJS_BSA_W > 0 ) THEN (TTL_BSA_W - HJS_BSA_W) END AS CO_BSA_W" ).append("\n"); 
		query.append("	                , CASE WHEN (TTL_BSA_E > 0 AND HJS_BSA_E > 0 ) THEN (TTL_BSA_E - HJS_BSA_E) END AS CO_BSA_E" ).append("\n"); 
		query.append("	                , DECODE(TTL_BSA_W, 0, 0, ROUND(NVL(HJS_BSA_W / TTL_BSA_W,0)*100, 2))           AS HJS_BSA_RTO_W" ).append("\n"); 
		query.append("	                , DECODE(TTL_BSA_E, 0, 0, ROUND(NVL(HJS_BSA_E / TTL_BSA_E,0)*100, 2))           AS HJS_BSA_RTO_E" ).append("\n"); 
		query.append("	                , CASE" ).append("\n"); 
		query.append("	                  WHEN (TTL_BSA_W > 0 AND HJS_BSA_W > 0 ) THEN" ).append("\n"); 
		query.append("	                        DECODE(TTL_BSA_W, 0, 0, ROUND(NVL((TTL_BSA_W - HJS_BSA_W) / TTL_BSA_W,0)*100, 2)) " ).append("\n"); 
		query.append("	                  END                                                                           AS CHTR_BSA_RTO_W" ).append("\n"); 
		query.append("	                , CASE" ).append("\n"); 
		query.append("	                  WHEN (TTL_BSA_E > 0 AND HJS_BSA_E > 0 ) THEN" ).append("\n"); 
		query.append("	                        DECODE(TTL_BSA_E, 0, 0, ROUND(NVL((TTL_BSA_E - HJS_BSA_E) / TTL_BSA_E,0)*100, 2)) " ).append("\n"); 
		query.append("	                  END                                                                           AS CHTR_BSA_RTO_E" ).append("\n"); 
		query.append("	        FROM    (" ).append("\n"); 
		query.append("	                SELECT  YR_WK, VSL_SLAN_CD,CRR_CD,VSL_CLASS,VSL_ENG_NM, TTL_BSA_W,TTL_BSA_E,HJS_BSA_W,HJS_BSA_E,CO_BSA_W,CO_BSA_E" ).append("\n"); 
		query.append("	                        , DENSE_RANK() OVER (PARTITION BY VSL_SLAN_CD ORDER BY CHK_HJS DESC, CHK_OTH DESC) AS RK" ).append("\n"); 
		query.append("	                FROM    (" ).append("\n"); 
		query.append("	                        SELECT  T1.VSL_SLAN_CD, T1.CRR_CD, T1.VSL_CLASS, T1.VSL_ENG_NM" ).append("\n"); 
		query.append("	                                , MAX(SUBSTR(T2.SLS_YRMON,1,4)||T2.COST_WK)                     AS YR_WK" ).append("\n"); 
		query.append("	                                , MAX(NVL(DECODE(T3.SKD_DIR_CD, 'W', T3.BSA_CAPA        ), 0))  AS TTL_BSA_W         -- LOADABLE CAPACITY" ).append("\n"); 
		query.append("	                                , MAX(NVL(DECODE(T3.SKD_DIR_CD, 'E', T3.BSA_CAPA        ), 0))  AS TTL_BSA_E  " ).append("\n"); 
		query.append("	                                , MAX(NVL(DECODE(T3.SKD_DIR_CD, 'W', T3.FNL_HJS_BSA_CAPA), 0))  AS HJS_BSA_W        -- HJS FINAL" ).append("\n"); 
		query.append("	                                , MAX(NVL(DECODE(T3.SKD_DIR_CD, 'E', T3.FNL_HJS_BSA_CAPA), 0))  AS HJS_BSA_E" ).append("\n"); 
		query.append("	                                , MAX(NVL(DECODE(T3.SKD_DIR_CD, 'W', T3.CO_BSA_CAPA     ), 0))  AS CO_BSA_W         -- CHT OUT" ).append("\n"); 
		query.append("	                                , MAX(NVL(DECODE(T3.SKD_DIR_CD, 'E', T3.CO_BSA_CAPA     ), 0))  AS CO_BSA_E" ).append("\n"); 
		query.append("	                                , MAX(DECODE(T1.CRR_CD, 'SML', 1, 0))                           AS CHK_HJS" ).append("\n"); 
		query.append("	                                , MAX(MAX_ETB)                                                  AS CHK_OTH" ).append("\n"); 
		query.append("	                                , MAX(DECODE(T1.CRR_CD, 'SML', 1, 0)) OVER ()                   AS CHK_HJS_EXISTS" ).append("\n"); 
		query.append("	                        FROM    TB_SRC1      T1," ).append("\n"); 
		query.append("	                                MAS_MON_VVD  T2," ).append("\n"); 
		query.append("	                                BSA_VVD_MST  T3" ).append("\n"); 
		query.append("	                        WHERE   1=1" ).append("\n"); 
		query.append("	--                        AND     T1.VSL_SLAN_CD  = 'ADN'" ).append("\n"); 
		query.append("	                        AND     T1.VSL_CD       = T2.VSL_CD         (+)" ).append("\n"); 
		query.append("	                        AND     T1.SKD_VOY_NO   = T2.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("	                        AND     T1.VSL_SLAN_CD  = T2.SLAN_CD        (+)" ).append("\n"); 
		query.append("	                        " ).append("\n"); 
		query.append("	                        AND     T2.TRD_CD       = T3.TRD_CD         (+)" ).append("\n"); 
		query.append("	                        AND     T2.RLANE_CD     = T3.RLANE_CD       (+)" ).append("\n"); 
		query.append("	                        AND     T2.IOC_CD       = T3.IOC_CD         (+)" ).append("\n"); 
		query.append("	                        AND     T2.VSL_CD       = T3.VSL_CD         (+)" ).append("\n"); 
		query.append("	                        AND     T2.SKD_VOY_NO   = T3.SKD_VOY_NO     (+)" ).append("\n"); 
		query.append("	                        AND     T2.DIR_CD       = T3.SKD_DIR_CD     (+)" ).append("\n"); 
		query.append("	                        " ).append("\n"); 
		query.append("	                        AND     'N'             = NVL(T2.DELT_FLG(+), 'N')" ).append("\n"); 
		query.append("	                        AND SUBSTR(T2.SLS_YRMON,1,4)||T2.COST_WK <= (" ).append("\n"); 
		query.append("	                                                                    SELECT COST_YR||COST_WK" ).append("\n"); 
		query.append("	                                                                    FROM MAS_WK_PRD" ).append("\n"); 
		query.append("	                                                                    WHERE TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[p_date], '-', ''),'YYYYMMDD') , +2),'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT    -- '2014-11-07'" ).append("\n"); 
		query.append("	                                                                    )" ).append("\n"); 
		query.append("	                        AND SUBSTR(T2.SLS_YRMON,1,4)||T2.COST_WK >= (" ).append("\n"); 
		query.append("	                                                                    SELECT  COST_YR||COST_WK" ).append("\n"); 
		query.append("	                                                                    FROM    MAS_WK_PRD" ).append("\n"); 
		query.append("	                                                                    WHERE   TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[p_date], '-', ''),'YYYYMMDD') , -2),'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT    -- '2014-11-07'" ).append("\n"); 
		query.append("	                                                                    )" ).append("\n"); 
		query.append("	                        GROUP BY T1.VSL_SLAN_CD, T1.CRR_CD, T1.VSL_CLASS, T1.VSL_ENG_NM" ).append("\n"); 
		query.append("	                        )" ).append("\n"); 
		query.append("	                WHERE   1=1" ).append("\n"); 
		query.append("	                AND     (CHK_HJS = 1 OR CHK_OTH = 1)" ).append("\n"); 
		query.append("	                )" ).append("\n"); 
		query.append("	        WHERE   1=1" ).append("\n"); 
		query.append("	        AND     RK = 1" ).append("\n"); 
		query.append("	        GROUP BY VSL_SLAN_CD, TTL_BSA_W, TTL_BSA_E, HJS_BSA_W, HJS_BSA_E, CO_BSA_W, CO_BSA_E" ).append("\n"); 
		query.append("	        )" ).append("\n"); 
		query.append("	WHERE   1=1" ).append("\n"); 
		query.append("	GROUP BY VSL_SLAN_CD" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end     	-- BSA NOT CHECK = 'Y' END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${bsa_type} != 'Y')  -- BSA Check = 'N' START" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", TB_SRC3 AS(       -- BSA Check = 'N' START" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            '' YR_WK, " ).append("\n"); 
		query.append("            '' VSL_SLAN_CD," ).append("\n"); 
		query.append("            '' TTL_BSA_W," ).append("\n"); 
		query.append("            '' TTL_BSA_E,  " ).append("\n"); 
		query.append("            '' HJS_BSA_W," ).append("\n"); 
		query.append("            '' HJS_BSA_E," ).append("\n"); 
		query.append("            '' CO_BSA_W," ).append("\n"); 
		query.append("            '' CO_BSA_E," ).append("\n"); 
		query.append("            '' HJS_BSA_RTO_W," ).append("\n"); 
		query.append("            '' HJS_BSA_RTO_E," ).append("\n"); 
		query.append("            '' CHTR_BSA_RTO_W," ).append("\n"); 
		query.append("            '' CHTR_BSA_RTO_E" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#end -- BSA Check = 'N' END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   ROWNUM AS SEQ" ).append("\n"); 
		query.append("        , T2.YR_WK" ).append("\n"); 
		query.append("        , T1.VSL_SLAN_CD AS SLAN_CD" ).append("\n"); 
		query.append("        , T1.SVC_DUR_DYS" ).append("\n"); 
		query.append("        , T1.FLEET_STATUS" ).append("\n"); 
		query.append("        , T1.VSL_CD_CNT" ).append("\n"); 
		query.append("        , T1.VSL_QTY_TTL" ).append("\n"); 
		query.append("        , T1.HJS_VSL_OWN_NM" ).append("\n"); 
		query.append("        , T1.HJS_VSL_CHT_NM" ).append("\n"); 
		query.append("        , T2.TTL_BSA_W" ).append("\n"); 
		query.append("        , T2.TTL_BSA_E" ).append("\n"); 
		query.append("        , T2.HJS_BSA_W" ).append("\n"); 
		query.append("        , T2.HJS_BSA_E" ).append("\n"); 
		query.append("        , T2.CO_BSA_W" ).append("\n"); 
		query.append("        , T2.CO_BSA_E" ).append("\n"); 
		query.append("        , T2.HJS_BSA_RTO_W" ).append("\n"); 
		query.append("        , T2.HJS_BSA_RTO_E" ).append("\n"); 
		query.append("        , T2.CHTR_BSA_RTO_W" ).append("\n"); 
		query.append("        , T2.CHTR_BSA_RTO_E" ).append("\n"); 
		query.append("        , T1.ROUTE          AS PORT_ROT" ).append("\n"); 
		query.append("        , T1.LANE_HJS" ).append("\n"); 
		query.append("        , T1.LANE_OTHERS" ).append("\n"); 
		query.append("        , T1.LANE_TOTAL" ).append("\n"); 
		query.append("        , T1.EA_HJS" ).append("\n"); 
		query.append("        , T1.EA_OTHERS" ).append("\n"); 
		query.append("        , T1.EA_TOTAL" ).append("\n"); 
		query.append("FROM    TB_SRC2 T1," ).append("\n"); 
		query.append("        TB_SRC3 T2" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.VSL_SLAN_CD  = T2.VSL_SLAN_CD (+)" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}