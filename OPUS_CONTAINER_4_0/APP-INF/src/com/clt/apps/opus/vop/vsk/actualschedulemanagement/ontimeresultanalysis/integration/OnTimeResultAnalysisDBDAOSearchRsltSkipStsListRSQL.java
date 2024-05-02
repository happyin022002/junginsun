/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltSkipStsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchRsltSkipStsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRsltSkipStsList
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchRsltSkipStsListRSQL(){
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
		params.put("port_skp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intg_cd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchRsltSkipStsListRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(T21.GRP, 'ZZZZZZZ', 'TOTAL', 'XXXXXXX', null, T21.GRP) AS LANE, DECODE(T21.NO, 1, 'CNT', 2, 'HRS') AS CNT_HRS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 01, CNT_INFO)) AS BDA" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 02, CNT_INFO)) AS BDS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 03, CNT_INFO)) AS BOA" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 04, CNT_INFO)) AS BPC" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 05, CNT_INFO)) AS BWD" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 06, CNT_INFO)) AS BWO" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 07, CNT_INFO)) AS BWS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 08, CNT_INFO)) AS BWW" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 09, CNT_INFO)) AS CTL" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 10, CNT_INFO)) AS DBS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 11, CNT_INFO)) AS DCC" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 12, CNT_INFO)) AS DLC" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 13, CNT_INFO)) AS DSO" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 14, CNT_INFO)) AS DWS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 15, CNT_INFO)) AS ENG" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 16, CNT_INFO)) AS HDA" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 17, CNT_INFO)) AS IPE" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 18, CNT_INFO)) AS MVS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 19, CNT_INFO)) AS OTH" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 20, CNT_INFO)) AS PDT" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 21, CNT_INFO)) AS PSB" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 22, CNT_INFO)) AS PTS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 23, CNT_INFO)) AS VAD" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 24, CNT_INFO)) AS VDP" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 25, CNT_INFO)) AS VDS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 26, CNT_INFO)) AS VHD" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 27, CNT_INFO)) AS VSP" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 28, CNT_INFO)) AS VTR" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 29, CNT_INFO)) AS WBW" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 30, CNT_INFO)) AS WCT" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 31, CNT_INFO)) AS WDA" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 32, CNT_INFO)) AS WDC" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 33, CNT_INFO)) AS WDG" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 34, CNT_INFO)) AS WDH" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 35, CNT_INFO)) AS WDL" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 36, CNT_INFO)) AS WDS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 37, CNT_INFO)) AS WDT" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 38, CNT_INFO)) AS WDW" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 39, CNT_INFO)) AS WDY" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 40, CNT_INFO)) AS WGS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 41, CNT_INFO)) AS WHM" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 42, CNT_INFO)) AS WLM" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 43, CNT_INFO)) AS WLS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 44, CNT_INFO)) AS WSC" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 45, CNT_INFO)) AS WTS" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 46, CNT_INFO)) AS WYC" ).append("\n"); 
		query.append("        ,MAX(DECODE(INTG_CD_VAL_DP_SEQ, 47, CNT_INFO)) AS XXX " ).append("\n"); 
		query.append("        ,MAX(DECODE(T21.NO, 1, NVL(TTL_SKIP_CNT, 0), 2, TTL_SKIP_TM)) AS TTL        " ).append("\n"); 
		query.append("        ,MAX(DECODE(T21.NO, 2, TO_CHAR(CALL_CNT, '999,999'))) AS ARR_DEP" ).append("\n"); 
		query.append("        ,MAX(DECODE(T21.NO, 2, NVL(TTL_SKIP_CNT, 0) )) AS CALL_CNT" ).append("\n"); 
		query.append("       -- ,MAX(DECODE(T21.NO, 2, NVL(TO_CHAR(ROUND((TTL_SKIP_CNT / (CALL_CNT + TTL_SKIP_CNT)) * 100, 1), '990.0'), '0') ||'%' )) AS ONTM_CNT" ).append("\n"); 
		query.append("        ,MAX(DECODE(T21.NO, 2, NVL(TO_CHAR(ROUND((TTL_SKIP_CNT / CALL_CNT) * 100, 1), '990.0'), '0') ||'%' )) AS ONTM_CNT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("            SELECT  NO, INTG_CD_VAL_DP_SEQ, INTG_CD_VAL_CTNT, NVL(GRP,'XXXXXXX') AS GRP, RSN_CD, SKIP_CNT, SKIP_TM, TTL_SKIP_CNT, TTL_SKIP_TM" ).append("\n"); 
		query.append("					, DECODE(NO, 1, TO_CHAR(SKIP_CNT, '999,999') ||CHR(10)|| TO_CHAR(ROUND((SKIP_CNT / TTL_SKIP_CNT) * 100, 1), '990.0') || '%'  , 2, TO_CHAR(SKIP_TM, '999,999') ||CHR(10)|| TO_CHAR(ROUND((SKIP_TM / DECODE(TTL_SKIP_TM,0,NULL,TTL_SKIP_TM)) * 100, 1), '990.0') || '%' ) AS CNT_INFO" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("                        SELECT  INTG_CD_VAL_DP_SEQ, INTG_CD_VAL_CTNT, GRP, RSN_CD, SKIP_CNT, SKIP_TM" ).append("\n"); 
		query.append("                                ,SUM(SKIP_CNT) OVER (PARTITION BY GRP) AS TTL_SKIP_CNT" ).append("\n"); 
		query.append("                                ,SUM(SKIP_TM ) OVER (PARTITION BY GRP) AS TTL_SKIP_TM" ).append("\n"); 
		query.append("                        FROM    (" ).append("\n"); 
		query.append("                                    SELECT  DECODE(GROUPING(GRP),0, GRP,1,'ZZZZZZZ') GRP" ).append("\n"); 
		query.append("                                            ,RSN_CD, SUM(SKIP_CNT) SKIP_CNT, SUM(SKIP_TM) SKIP_TM" ).append("\n"); 
		query.append("                                    FROM    (" ).append("\n"); 
		query.append("                                                SELECT  " ).append("\n"); 
		query.append("                                                        #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("								                            T1.VPS_PORT_CD AS GRP," ).append("\n"); 
		query.append("								                        #end" ).append("\n"); 
		query.append("								                        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("								                            T1.VSL_CD AS GRP," ).append("\n"); 
		query.append("								                        #end" ).append("\n"); 
		query.append("								                        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("								                            T1.SLAN_CD AS GRP," ).append("\n"); 
		query.append("								                        #end" ).append("\n"); 
		query.append("								                        #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("								                            T1.TS_PORT_CD AS GRP," ).append("\n"); 
		query.append("								                        #end" ).append("\n"); 
		query.append("                                                        PORT_SKP_RSN_CD    AS RSN_CD," ).append("\n"); 
		query.append("                                                        SUM(1)             AS SKIP_CNT," ).append("\n"); 
		query.append("                                                        SUM(TTL_DLAY_HRS)  AS SKIP_TM                                " ).append("\n"); 
		query.append("                                                FROM    VSK_VSL_PORT_SKD T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("                                                WHERE   T1.VSL_CD           = T2.VSL_CD" ).append("\n"); 
		query.append("                                                AND     T1.USD_FLG          = 'Y'" ).append("\n"); 
		query.append("                                                AND     T1.VSL_CD           LIKE @[vsl_cd]||'%'" ).append("\n"); 
		query.append("                                                AND     T1.VPS_PORT_CD      LIKE @[vps_port_cd]||'%'" ).append("\n"); 
		query.append("                                                AND     T2.CRR_CD           LIKE @[crr_cd]||'%'" ).append("\n"); 
		query.append("                                                AND ( (DECODE(@[lane_grp], 'I', T1.SLAN_CD) = NVL(@[vsl_slan_cd], T1.SLAN_CD))  OR  (DECODE(@[lane_grp], 'G', T1.SLAN_CD) IN  (SELECT VSL_SLAN_CD FROM VSK_USR_LANE_GRP WHERE USR_ID = @[usr_id] AND LANE_GRP_NM = @[lane_grp_nm] ))) " ).append("\n"); 
		query.append("                                                AND     T1.PORT_SKP_TP_CD   = DECODE(@[port_skp_tp_cd], 'A', PORT_SKP_TP_CD, @[port_skp_tp_cd])" ).append("\n"); 
		query.append("                                                AND     T1.PORT_SKP_RSN_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                AND     T1.VPS_ETA_DT BETWEEN TO_DATE(@[act_inp_fm_dt], 'YYYYMM') AND LAST_DAY(TO_DATE(@[act_inp_to_dt], 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("												AND     T1.SKD_CNG_STS_CD   = 'S'" ).append("\n"); 
		query.append("                                                AND     T1.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                                                 #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("								                GROUP BY T1.VPS_PORT_CD, PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("						                        #end" ).append("\n"); 
		query.append("						                        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("						                        GROUP BY T1.VSL_CD, PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("						                        #end" ).append("\n"); 
		query.append("						                        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("						                        GROUP BY T1.SLAN_CD, PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("						                        #end" ).append("\n"); 
		query.append("						                        #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("						                        GROUP BY T1.TS_PORT_CD, PORT_SKP_RSN_CD" ).append("\n"); 
		query.append("						                        #end" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                    GROUP BY ROLLUP(GRP),RSN_CD" ).append("\n"); 
		query.append("                                ) T11, COM_INTG_CD_DTL T12" ).append("\n"); 
		query.append("                        WHERE   1 = 1" ).append("\n"); 
		query.append("                        AND     T11.RSN_CD (+)      = T12.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("                        AND     T12.INTG_CD_ID      = @[intg_cd_id]" ).append("\n"); 
		query.append("                        AND     T11.RSN_CD IS NOT NULL" ).append("\n"); 
		query.append("                    ) T11, (SELECT 1 NO FROM DUAL UNION ALL SELECT 2 FROM DUAL)" ).append("\n"); 
		query.append("        ) T20," ).append("\n"); 
		query.append("        (SELECT  NO, NVL(GRP,'XXXXXXX') AS GRP, CALL_CNT" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("                        SELECT  DECODE(GROUPING(" ).append("\n"); 
		query.append("                                                #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("						                            T1.VPS_PORT_CD" ).append("\n"); 
		query.append("						                        #end" ).append("\n"); 
		query.append("						                        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("						                            T1.VSL_CD" ).append("\n"); 
		query.append("						                        #end" ).append("\n"); 
		query.append("						                        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("						                            T1.SLAN_CD" ).append("\n"); 
		query.append("						                        #end" ).append("\n"); 
		query.append("						                        #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("						                            T1.TS_PORT_CD" ).append("\n"); 
		query.append("						                        #end" ).append("\n"); 
		query.append("                                                ), " ).append("\n"); 
		query.append("                                        0, " ).append("\n"); 
		query.append("                                        #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("				                            T1.VPS_PORT_CD," ).append("\n"); 
		query.append("				                        #end" ).append("\n"); 
		query.append("				                        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("				                            T1.VSL_CD," ).append("\n"); 
		query.append("				                        #end" ).append("\n"); 
		query.append("				                        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("				                            T1.SLAN_CD," ).append("\n"); 
		query.append("				                        #end" ).append("\n"); 
		query.append("				                        #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("				                            T1.TS_PORT_CD," ).append("\n"); 
		query.append("				                        #end" ).append("\n"); 
		query.append("                                        1, 'ZZZZZZZ') AS GRP," ).append("\n"); 
		query.append("--                                SUM(DECODE(SKD_CNG_STS_CD, 'S', 0, 1))   AS CALL_CNT" ).append("\n"); 
		query.append("                                  SUM(1)   AS CALL_CNT                  " ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD T1, MDM_VSL_CNTR T2" ).append("\n"); 
		query.append("                        WHERE   T1.VSL_CD           = T2.VSL_CD" ).append("\n"); 
		query.append("                        AND     T1.VSL_CD           LIKE @[vsl_cd]||'%'" ).append("\n"); 
		query.append("                        AND     T1.VPS_PORT_CD      LIKE @[vps_port_cd]||'%'" ).append("\n"); 
		query.append("                        AND     T2.CRR_CD           LIKE @[crr_cd]||'%'" ).append("\n"); 
		query.append("						AND ( (DECODE(@[lane_grp], 'I', T1.SLAN_CD) = NVL(@[vsl_slan_cd], T1.SLAN_CD))  OR  (DECODE(@[lane_grp], 'G', T1.SLAN_CD) IN  (SELECT VSL_SLAN_CD FROM VSK_USR_LANE_GRP WHERE USR_ID = @[usr_id] AND LANE_GRP_NM = @[lane_grp_nm])) )" ).append("\n"); 
		query.append("                        AND     T1.VPS_ETA_DT BETWEEN TO_DATE(@[act_inp_fm_dt], 'YYYYMM') AND LAST_DAY(TO_DATE(@[act_inp_to_dt], 'YYYYMM')) + 0.99999" ).append("\n"); 
		query.append("                        AND     T1.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("--						AND     T1.SKD_CNG_STS_CD   = 'S'" ).append("\n"); 
		query.append("                         #if (${grp_flg} == 'P')" ).append("\n"); 
		query.append("		                GROUP BY ROLLUP(T1.VPS_PORT_CD)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'V')" ).append("\n"); 
		query.append("                        GROUP BY ROLLUP(T1.VSL_CD)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'L')" ).append("\n"); 
		query.append("                        GROUP BY ROLLUP(T1.SLAN_CD)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                        #if (${grp_flg} == 'R')" ).append("\n"); 
		query.append("                        GROUP BY ROLLUP(T1.TS_PORT_CD)" ).append("\n"); 
		query.append("                        #end" ).append("\n"); 
		query.append("                    ), (SELECT 1 NO FROM DUAL UNION ALL SELECT 2 FROM DUAL )            " ).append("\n"); 
		query.append("        ) T21        " ).append("\n"); 
		query.append("WHERE   T20.GRP = T21.GRP" ).append("\n"); 
		query.append("AND     T20.NO  = T21.NO" ).append("\n"); 
		query.append("GROUP BY T21.GRP, T21.NO" ).append("\n"); 
		query.append("ORDER BY T21.GRP, T21.NO" ).append("\n"); 

	}
}