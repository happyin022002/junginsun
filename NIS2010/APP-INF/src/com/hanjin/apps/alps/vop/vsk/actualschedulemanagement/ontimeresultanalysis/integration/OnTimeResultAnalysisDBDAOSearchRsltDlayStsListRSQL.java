/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltDlayStsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchRsltDlayStsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRsltDlayStsList
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchRsltDlayStsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_grp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ie_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_inp_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_inp_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchRsltDlayStsListRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(T22.GRP, 'ZZZZZZZ', 'TOTAL', T22.GRP) AS LANE, DECODE(NO, 1, 'CNT', 2, 'HRS') AS CNT_HRS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 01, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS SBW" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 02, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS SMT" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 03, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS SVD" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 04, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS SDA" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 05, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS WAD" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 06, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS WPG" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 07, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS WPC" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 08, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS WPV" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 09, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS WMT" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 10, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS WCA" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 11, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS WIO" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 12, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS WNH" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 13, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS OTH" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 14, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS BTT" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 15, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS BLS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 16, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS BDA" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 17, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS BNS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 18, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS BCW" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 19, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS BCM" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 20, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS BRB" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 21, DECODE(NO, 1, TO_CHAR(DELAY_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_CNT / TTL_DLY_CNT) * 100, 1), '990.0') || '%' , 2, TO_CHAR(DELAY_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((DELAY_TM / TTL_DLY_TM) * 100, 1), '990.0') || '%' ))) AS BSP" ).append("\n"); 
		query.append("        ,MAX(DECODE(NO, 1, TO_CHAR(TTL_DLY_CNT, '999,999') ||CHR(10)|| '100' || '%'  , 2, TO_CHAR(TTL_DLY_TM, '999,999') ||CHR(10)||'100' || '%' )) AS TTL" ).append("\n"); 
		query.append("        ,MAX(DECODE(NO, 1, 'ARR', 2, 'DEP', 3, 'TTL')) AS ARR_DEP" ).append("\n"); 
		query.append("        ,MAX(DECODE(NO, 1, TO_CHAR(ARR, '999,999'), 2, TO_CHAR(DEP, '999,999'), 3, TO_CHAR(ARR + DEP, '999,999') )) AS CALL_CNT" ).append("\n"); 
		query.append("        ,MAX(DECODE(NO, 1, TO_CHAR(EXC_BER, '999,999')           ||CHR(10)|| TO_CHAR(ROUND(DECODE(ARR, 0, 0, (EXC_BER / ARR) * 100), 1)                        , '990.0') || '%'," ).append("\n"); 
		query.append("                        2, TO_CHAR(EXC_DEP, '999,999')           ||CHR(10)|| TO_CHAR(DECODE(DEP, 0, 0, ROUND((EXC_DEP / DEP) * 100, 1))                        , '990.0') || '%', " ).append("\n"); 
		query.append("                        3, TO_CHAR(EXC_BER + EXC_DEP, '999,999') ||CHR(10)|| TO_CHAR(ROUND(DECODE((ARR + DEP), 0, 0, (EXC_BER + EXC_DEP)/(ARR + DEP) * 100, 1)), '990.0') || '%')) AS ONTM_CNT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  1" ).append("\n"); 
		query.append("                , DECODE(GROUPING(GRP), 0, GRP, 1,'ZZZZZZZ')     AS GRP" ).append("\n"); 
		query.append("                , INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                , INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("                , SUM(DELAY_CNT)                                 AS DELAY_CNT" ).append("\n"); 
		query.append("                , SUM(DELAY_TM )                                 AS DELAY_TM" ).append("\n"); 
		query.append("                , SUM(SUM(DELAY_CNT)) OVER (PARTITION BY GRP)    AS TTL_DLY_CNT /*GRP별 DELAY COUNT SUM */" ).append("\n"); 
		query.append("                , SUM(SUM(DELAY_TM )) OVER (PARTITION BY GRP)    AS TTL_DLY_TM  /*GRP별 DELAY TIME SUM  */" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  RSN_CD1 || RSN_CD2 || RSN_CD3 ||RSN_CD4  AS RSN_CD" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("                        , T1.VPS_PORT_CD                         AS GRP" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("                        , T1.VSL_CD                              AS GRP" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("                        , T2.VSL_SLAN_CD                         AS GRP" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        , SUM(DELAY_CNT)                         AS DELAY_CNT" ).append("\n"); 
		query.append("                        , SUM(NVL(DLAY_HRS1, 0) + NVL(DLAY_HRS2, 0) + NVL(DLAY_HRS3, 0) + NVL(DLAY_HRS4, 0)) AS DELAY_TM" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  VSL_CD" ).append("\n"); 
		query.append("                                , SKD_VOY_NO" ).append("\n"); 
		query.append("                                , SKD_DIR_CD" ).append("\n"); 
		query.append("                                , VPS_PORT_CD" ).append("\n"); 
		query.append("                                , COUNT(*)                              AS DELAY_CNT" ).append("\n"); 
		query.append("                                , DECODE(SEQ, 1, ARR_DLAY_RSN_CD1    )  AS RSN_CD1" ).append("\n"); 
		query.append("                                , NVL(SUM(DECODE(SEQ, 1, ARR_DLAY_HRS1   )),0) AS DLAY_HRS1" ).append("\n"); 
		query.append("                                , DECODE(SEQ, 2, ARR_DLAY_RSN_CD2    )  AS RSN_CD2" ).append("\n"); 
		query.append("                                , NVL(SUM(DECODE(SEQ, 2, ARR_DLAY_HRS2   )),0) AS DLAY_HRS2" ).append("\n"); 
		query.append("                                , DECODE(SEQ, 3, DEP_DLAY_RSN_CD1    )  AS RSN_CD3" ).append("\n"); 
		query.append("                                , NVL(SUM(DECODE(SEQ, 3, DEP_DLAY_HRS1   )),0) AS DLAY_HRS3" ).append("\n"); 
		query.append("                                , DECODE(SEQ, 4, DEP_DLAY_RSN_CD2    )  AS RSN_CD4" ).append("\n"); 
		query.append("                                , NVL(SUM(DECODE(SEQ, 4, DEP_DLAY_HRS2   )),0) AS DLAY_HRS4" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_SKD_RSLT," ).append("\n"); 
		query.append("                                (" ).append("\n"); 
		query.append("                                SELECT 1 SEQ FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                                SELECT 2     FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                                SELECT 3     FROM DUAL UNION ALL" ).append("\n"); 
		query.append("                                SELECT 4     FROM DUAL" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                        WHERE   ACT_INP_YRMON  >= TO_CHAR(TO_DATE(@[act_inp_fm_dt], 'YYYYMM'), 'YYYYMM')" ).append("\n"); 
		query.append("                        AND     ACT_INP_YRMON  <= TO_CHAR(TO_DATE(@[act_inp_to_dt], 'YYYYMM'), 'YYYYMM')" ).append("\n"); 
		query.append("                        AND     VSL_CD         LIKE @[vsl_cd]|| '%'" ).append("\n"); 
		query.append("                        AND     VPS_PORT_CD    LIKE @[vps_port_cd]|| '%'" ).append("\n"); 
		query.append("                        GROUP BY SEQ" ).append("\n"); 
		query.append("                                  , VSL_CD" ).append("\n"); 
		query.append("                                  , SKD_VOY_NO" ).append("\n"); 
		query.append("                                  , SKD_DIR_CD" ).append("\n"); 
		query.append("                                  , VPS_PORT_CD" ).append("\n"); 
		query.append("                                  , ARR_DLAY_RSN_CD1" ).append("\n"); 
		query.append("                                  , ARR_DLAY_RSN_CD2" ).append("\n"); 
		query.append("                                  , DEP_DLAY_RSN_CD1" ).append("\n"); 
		query.append("                                  , DEP_DLAY_RSN_CD2" ).append("\n"); 
		query.append("                        ) T1, VSK_VSL_SKD T2, MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("                WHERE   T1.VSL_CD      = T2.VSL_CD" ).append("\n"); 
		query.append("                AND     T1.SKD_VOY_NO  = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     T1.SKD_DIR_CD  = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     T1.VSL_CD      = T3.VSL_CD" ).append("\n"); 
		query.append("                AND    ((DECODE(@[lane_grp], 'I', T2.VSL_SLAN_CD) = NVL(@[vsl_slan_cd], T2.VSL_SLAN_CD))  OR  (DECODE(@[lane_grp], 'G', T2.VSL_SLAN_CD) IN  (SELECT VSL_SLAN_CD FROM VSK_USR_LANE_GRP WHERE USR_ID = @[usr_id] AND LANE_GRP_NM = @[lane_grp_nm])))" ).append("\n"); 
		query.append("                AND     T3.CRR_CD      LIKE @[crr_cd]|| '%'" ).append("\n"); 
		query.append("                AND     RSN_CD1 || RSN_CD2 || RSN_CD3 ||RSN_CD4 IS NOT NULL" ).append("\n"); 
		query.append("                GROUP BY RSN_CD1" ).append("\n"); 
		query.append("                         , RSN_CD2" ).append("\n"); 
		query.append("                         , RSN_CD3" ).append("\n"); 
		query.append("                         , RSN_CD4" ).append("\n"); 
		query.append("                         #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("                         , T1.VPS_PORT_CD" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("                         , T1.VSL_CD" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                         #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("                         , T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("                         #end" ).append("\n"); 
		query.append("                ) T11," ).append("\n"); 
		query.append("                COM_INTG_CD_DTL T12" ).append("\n"); 
		query.append("        WHERE   T11.RSN_CD      = T12.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("        AND     T12.INTG_CD_ID  = 'CD01830'" ).append("\n"); 
		query.append("        GROUP BY 1" ).append("\n"); 
		query.append("                 , ROLLUP(GRP)" ).append("\n"); 
		query.append("                 , INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                 , INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("        ) T21," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  1" ).append("\n"); 
		query.append("                #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("                , DECODE(DECODE(GROUPING(T1.VSL_CD||VPS_PORT_CD), 0, T1.VSL_CD||VPS_PORT_CD, 1, 'ZZZZZZZ'), 'ZZZZZZZ', 'ZZZZZZZ', " ).append("\n"); 
		query.append("                          SUBSTR(DECODE(GROUPING(T1.VSL_CD||VPS_PORT_CD), 0, T1.VSL_CD||VPS_PORT_CD, 1, 'ZZZZZZZ'), 5)) AS GRP" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("                , DECODE(GROUPING(T1.VSL_CD  ), 0, T1.VSL_CD  , 1,'ZZZZZZZ') AS GRP" ).append("\n"); 
		query.append("                #end" ).append("\n"); 
		query.append("                #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("                , DECODE(DECODE(GROUPING(T1.VSL_CD||VSL_SLAN_CD), 0, T1.VSL_CD||VSL_SLAN_CD, 1, 'ZZZZZZZ'), 'ZZZZZZZ', 'ZZZZZZZ', " ).append("\n"); 
		query.append("                          SUBSTR(DECODE(GROUPING(T1.VSL_CD||VSL_SLAN_CD), 0, T1.VSL_CD||VSL_SLAN_CD, 1, 'ZZZZZZZ'), 5)) AS GRP" ).append("\n"); 
		query.append("                #end               " ).append("\n"); 
		query.append("                , SUM(ARR) AS ARR" ).append("\n"); 
		query.append("                , SUM(DEP) AS DEP" ).append("\n"); 
		query.append("                , SUM(EXC_BER) AS EXC_BER" ).append("\n"); 
		query.append("                , SUM(EXC_DEP) AS EXC_DEP" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  1" ).append("\n"); 
		query.append("                        , VSL_CD" ).append("\n"); 
		query.append("                        , SKD_VOY_NO" ).append("\n"); 
		query.append("                        , SKD_DIR_CD" ).append("\n"); 
		query.append("                        , VPS_PORT_CD" ).append("\n"); 
		query.append("                        , SUM(DECODE(VSKD_RSLT_XCLD_CD, 'A', 0, 'S', 0, 1)) AS ARR" ).append("\n"); 
		query.append("                        , SUM(DECODE(VSKD_RSLT_XCLD_CD, 'D', 0, 'S', 0, 1)) AS DEP" ).append("\n"); 
		query.append("                        , SUM(DECODE(VSKD_RSLT_XCLD_CD, 'A', 0, 'S', 0, DECODE(SIGN(0 - DECODE(@[ie_flg], 'I', INCL_BRTH_DLAY_HRS, XCLD_BRTH_DLAY_HRS)), -1, 0, 1))) AS EXC_BER" ).append("\n"); 
		query.append("                        , SUM(DECODE(VSKD_RSLT_XCLD_CD, 'D', 0, 'S', 0, DECODE(SIGN(0 - DECODE(@[ie_flg], 'I', INCL_DEP_DLAY_HRS , XCLD_DEP_DLAY_HRS )), -1, 0, 1))) AS EXC_DEP" ).append("\n"); 
		query.append("                FROM    VSK_VSL_SKD_RSLT" ).append("\n"); 
		query.append("                WHERE   1               = 1" ).append("\n"); 
		query.append("                AND     ACT_INP_YRMON  >= TO_CHAR(TO_DATE(@[act_inp_fm_dt], 'YYYYMM'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND     ACT_INP_YRMON  <= TO_CHAR(TO_DATE(@[act_inp_to_dt], 'YYYYMM'), 'YYYYMM')" ).append("\n"); 
		query.append("                AND     VSL_CD         LIKE @[vsl_cd]|| '%'" ).append("\n"); 
		query.append("                AND     VPS_PORT_CD    LIKE @[vps_port_cd]|| '%'" ).append("\n"); 
		query.append("                GROUP BY VSL_CD" ).append("\n"); 
		query.append("                         , SKD_VOY_NO" ).append("\n"); 
		query.append("                         , SKD_DIR_CD" ).append("\n"); 
		query.append("                         , VPS_PORT_CD" ).append("\n"); 
		query.append("                ) T1,      " ).append("\n"); 
		query.append("                VSK_VSL_SKD T2, MDM_VSL_CNTR T3" ).append("\n"); 
		query.append("        WHERE   T1.VSL_CD      = T2.VSL_CD" ).append("\n"); 
		query.append("        AND     T1.SKD_VOY_NO  = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T1.SKD_DIR_CD  = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     T2.VSL_CD      = T3.VSL_CD" ).append("\n"); 
		query.append("        AND    ((DECODE(@[lane_grp], 'I', T2.VSL_SLAN_CD) = NVL(@[vsl_slan_cd], T2.VSL_SLAN_CD))  OR  (DECODE(@[lane_grp], 'G', T2.VSL_SLAN_CD) IN  (SELECT VSL_SLAN_CD FROM VSK_USR_LANE_GRP WHERE USR_ID = @[usr_id] AND LANE_GRP_NM = @[lane_grp_nm])))" ).append("\n"); 
		query.append("        AND     NVL(T2.ACT_CRR_CD, T3.CRR_CD)     LIKE @[crr_cd] || '%'" ).append("\n"); 
		query.append("        #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("        GROUP BY ROLLUP (T1.VSL_CD||VPS_PORT_CD)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("        GROUP BY ROLLUP (T1.VSL_CD)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("        GROUP BY ROLLUP (T1.VSL_CD||VSL_SLAN_CD)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ) T22," ).append("\n"); 
		query.append("        (SELECT 1 NO FROM DUAL UNION ALL SELECT 2 FROM DUAL UNION ALL SELECT 3 FROM DUAL)" ).append("\n"); 
		query.append("WHERE   T21.GRP (+) = T22.GRP" ).append("\n"); 
		query.append("GROUP BY T22.GRP, NO" ).append("\n"); 
		query.append("ORDER BY T22.GRP, NO" ).append("\n"); 

	}
}