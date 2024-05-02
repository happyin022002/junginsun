/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOSearchGraphPerformanceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOSearchGraphPerformanceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가
	  * 2015.08.17 김기원 CHM-201537021  조직코드 변경
	  * 2016.04.28 Arie Im CHM-201641178 아프리카 대륙 구주지역본부/동서남아지역본부 구분 로직 추가
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOSearchGraphPerformanceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_kpi_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_tgt_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOSearchGraphPerformanceListRSQL").append("\n"); 
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
		query.append("SELECT P.RHQ, P.PORT_CD, P.CLPT_IND_SEQ, P.SKD_DIR_CD, P.YD_CD, P.SLAN_CD" ).append("\n"); 
		query.append("     , P.VVD_CD, P.TTL_MVS" ).append("\n"); 
		query.append("     , TO_CHAR(P.STEAM_IN_TIME, '90.9') AS STEAM_IN_TIME" ).append("\n"); 
		query.append("     , TO_CHAR(P.ARRIVAL_TIME, '90.9') AS ARRIVAL_TIME     --, P.OPERATION_TIME" ).append("\n"); 
		query.append("     , TO_CHAR(ROUND(CASE WHEN K.TTL_CNTR_MV_KNT IS NULL  THEN NULL" ).append("\n"); 
		query.append("                  WHEN P.OPERATION_TIME = 0       THEN 0" ).append("\n"); 
		query.append("                  WHEN P.TTL_MVS        = 0       THEN 0" ).append("\n"); 
		query.append("             ELSE K.TTL_CNTR_MV_KNT / (P.TTL_MVS / P.OPERATION_TIME)" ).append("\n"); 
		query.append("             END,1), '90.9') AS OPERATION_TIME_T" ).append("\n"); 
		query.append("     , TO_CHAR(P.DEPARTURE_TIME, '90.9') AS DEPARTURE_TIME" ).append("\n"); 
		query.append("     , TO_CHAR(GROSS_CRANE_PROD, '90.9') AS GROSS_CRANE_PROD" ).append("\n"); 
		query.append("     , TO_CHAR(K.STM_IN_HRS, '90.9') AS STM_IN_HRS" ).append("\n"); 
		query.append("     , TO_CHAR(VSL_ARR_HRS, '90.9') AS VSL_ARR_HRS" ).append("\n"); 
		query.append("     , TO_CHAR(TML_OP_HRS, '90.9') AS TML_OP_HRS" ).append("\n"); 
		query.append("     , TO_CHAR(VSL_DEP_HRS, '90.9') AS VSL_DEP_HRS" ).append("\n"); 
		query.append("     , TO_CHAR(GRS_CRN_PROD_HRS, '90.9') AS GRS_CRN_PROD_HRS" ).append("\n"); 
		query.append("     , P.WORK_COMPLETED" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("       SELECT (" ).append("\n"); 
		query.append("              SELECT CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                     ELSE O.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("--                          CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')               THEN 'HAMRU'" ).append("\n"); 
		query.append("--                               WHEN ML.CONTI_CD  = 'M'                                                                    THEN 'NYCRA'" ).append("\n"); 
		query.append("--                               WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF'  THEN DECODE(ML.CNT_CD,'KR','SELIB','JP','TYOIB','SHARC')" ).append("\n"); 
		query.append("--                               WHEN (ML.CONTI_CD = 'A'        AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR') THEN 'SINRS'" ).append("\n"); 
		query.append("--							   WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                               ELSE ''" ).append("\n"); 
		query.append("--                          END" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("                FROM MDM_LOCATION  ML, MAS_OFC_LVL O" ).append("\n"); 
		query.append("               WHERE ML.LOC_CD = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("                	AND ML.EQ_CTRL_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                	AND ML.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                	AND ML.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                	AND O.OFC_APLY_TO_YRMON ='999912'" ).append("\n"); 
		query.append("                	AND O.OFC_LVL < 9" ).append("\n"); 
		query.append("              )                      AS RHQ" ).append("\n"); 
		query.append("            , T2.VPS_PORT_CD         AS PORT_CD" ).append("\n"); 
		query.append("            , T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            , T2.SKD_DIR_CD" ).append("\n"); 
		query.append("            , T2.YD_CD" ).append("\n"); 
		query.append("            , T2.SLAN_CD" ).append("\n"); 
		query.append("            , T2.VSL_CD||T2.SKD_VOY_NO||T2.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("            , T1.MVS                                  AS TTL_MVS" ).append("\n"); 
		query.append("            , ROUND(NVL((T2.VPS_ETB_DT  - CASE WHEN T4.PLT_IN_DT BETWEEN T2.VPS_ETA_DT AND T2.VPS_ETB_DT THEN T4.PLT_IN_DT" ).append("\n"); 
		query.append("                                          ELSE T2.VPS_ETA_DT END)*24, 0),1) AS STEAM_IN_TIME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            , ROUND(NVL((T1.COMMENCE    - T2.VPS_ETB_DT  )*24, 0),1) AS ARRIVAL_TIME" ).append("\n"); 
		query.append("            , NVL((T1.COMPLETE    - T1.COMMENCE    )*24, 0) AS OPERATION_TIME" ).append("\n"); 
		query.append("            , ROUND(NVL((T2.VPS_ETD_DT  - T1.COMPLETE    )*24, 0),1) AS DEPARTURE_TIME" ).append("\n"); 
		query.append("            , ROUND(CASE WHEN NVL(TO_NUMBER(SUBSTR(T1.GROSS_GANG,1,INSTR(T1.GROSS_GANG,':')-1)) + TO_NUMBER(SUBSTR(T1.GROSS_GANG,INSTR(T1.GROSS_GANG,':')+1)/60),0) = 0 THEN 0" ).append("\n"); 
		query.append("                    ELSE T1.MVS / (NVL(TO_NUMBER(SUBSTR(T1.GROSS_GANG,1,INSTR(T1.GROSS_GANG,':')-1)) + TO_NUMBER(SUBSTR(T1.GROSS_GANG,INSTR(T1.GROSS_GANG,':')+1)/60),0))" ).append("\n"); 
		query.append("                    END,1) AS GROSS_CRANE_PROD" ).append("\n"); 
		query.append("            , TO_CHAR(T1.COMPLETE, 'YYYY-MM-DD HH24:MI')      AS WORK_COMPLETED" ).append("\n"); 
		query.append("         FROM TDR_HEADER       T1" ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("            , VSK_VSL_SKD      T3" ).append("\n"); 
		query.append("            , FCM_DEP_RPT      T4" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND     T1.VSL_CD            = T2.VSL_CD" ).append("\n"); 
		query.append("          AND     T1.VOY_NO            = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND     T1.DIR_CD            = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND     T1.PORT_CD           = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND     T1.CALL_IND          = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("          AND     T2.VSL_CD            = T3.VSL_CD" ).append("\n"); 
		query.append("          AND     T2.SKD_VOY_NO        = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND     T2.SKD_DIR_CD        = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND     T2.SLAN_CD           = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("          AND     T2.VSL_CD            = T4.VSL_CD(+)" ).append("\n"); 
		query.append("          AND     T2.SKD_VOY_NO        = T4.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND     T2.SKD_DIR_CD        = T4.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND     T2.SLAN_CD           = T4.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("          AND     T2.CLPT_IND_SEQ      = T4.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("          AND     T2.VPS_PORT_CD       = T4.DEP_PORT_CD(+)" ).append("\n"); 
		query.append("          AND     T2.PORT_SKD_STS_CD   = 'D'" ).append("\n"); 
		query.append("          AND     T2.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("          AND     NVL(T2.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("          AND     T2.VPS_PORT_CD      NOT IN ('PAPAC','EGSUZ')" ).append("\n"); 
		query.append("          AND     T2.VPS_ETD_DT       BETWEEN TO_DATE(REPLACE(@[fr_dt], '-', '')||'000000', 'YYYYMMDDHH24MISS')          -- '2012-03-14'" ).append("\n"); 
		query.append("                                      AND     TO_DATE(REPLACE(@[to_dt], '-', '')||'235959', 'YYYYMMDDHH24MISS')             -- '2012-05-14'" ).append("\n"); 
		query.append("          AND     T3.ACT_CRR_CD       = 'SML'" ).append("\n"); 
		query.append("          AND     SLAN_CD             = @[slan_cd]              -- 'PNH'" ).append("\n"); 
		query.append("          AND     T2.VPS_PORT_CD      = @[port_cd]              -- 'USSEA'" ).append("\n"); 
		query.append("          AND     T2.CLPT_IND_SEQ     = @[clpt_ind_seq]         -- '2'" ).append("\n"); 
		query.append("       )P," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT KPI_TGT_YR        , SLAN_CD           , VPS_PORT_CD        , KPI_VER_SEQ" ).append("\n"); 
		query.append("            , FM_EFF_DT         , TO_EFF_DT         , TTL_CNTR_MV_KNT    , STM_IN_HRS" ).append("\n"); 
		query.append("            , VSL_ARR_HRS       , TML_OP_HRS        , VSL_DEP_HRS        , GRS_CRN_PROD_HRS" ).append("\n"); 
		query.append("            , RHQ               , PORT_KPI_DIR_CD   , CLPT_IND_SEQ" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("              SELECT  KPI_TGT_YR        , SLAN_CD           , VPS_PORT_CD        , KPI_VER_SEQ" ).append("\n"); 
		query.append("                    , FM_EFF_DT         , TO_EFF_DT         , TTL_CNTR_MV_KNT    , STM_IN_HRS" ).append("\n"); 
		query.append("                    , VSL_ARR_HRS       , TML_OP_HRS        , VSL_DEP_HRS        , GRS_CRN_PROD_HRS" ).append("\n"); 
		query.append("                    , NET_CRN_PROD_HRS" ).append("\n"); 
		query.append("                    , (" ).append("\n"); 
		query.append("                      SELECT  CASE WHEN NVL(ML.DELT_FLG,'N') <> 'N' OR ML.CALL_PORT_FLG <> 'Y' THEN ''" ).append("\n"); 
		query.append("                              ELSE O.OFC_N3RD_LVL_CD " ).append("\n"); 
		query.append("--                                   CASE WHEN ML.CONTI_CD  IN ('E','F') AND ML.LOC_CD NOT IN('EGAIS','ZADUR','RUVVO')               THEN 'HAMRU'" ).append("\n"); 
		query.append("--                                        WHEN ML.CONTI_CD  = 'M'                                                                    THEN 'NYCRA'" ).append("\n"); 
		query.append("--                                        WHEN ML.CONTI_CD = 'A' AND ML.SCONTI_CD = 'AF'  THEN DECODE(ML.CNT_CD,'KR','SELIB','JP','TYOIB','SHARC')" ).append("\n"); 
		query.append("--                                        WHEN (ML.CONTI_CD = 'A'        AND ML.SCONTI_CD <> 'AF') OR ML.LOC_CD IN ('EGAIS','ZADUR') THEN 'SINRS'" ).append("\n"); 
		query.append("--										WHEN ML.CONTI_CD  IN ('E') AND ML.LOC_CD = 'RUVVO' THEN 'VVOIA'" ).append("\n"); 
		query.append("--                                        ELSE ''" ).append("\n"); 
		query.append("--                                   END" ).append("\n"); 
		query.append("                              END" ).append("\n"); 
		query.append("                        FROM MDM_LOCATION  ML, MAS_OFC_LVL O" ).append("\n"); 
		query.append("                       WHERE ML.LOC_CD = T.VPS_PORT_CD" ).append("\n"); 
		query.append("                       		AND ML.EQ_CTRL_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("                       		AND ML.CALL_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                       		AND ML.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                       		AND O.OFC_APLY_TO_YRMON ='999912'" ).append("\n"); 
		query.append("                       		AND O.OFC_LVL < 9" ).append("\n"); 
		query.append("                       ) RHQ" ).append("\n"); 
		query.append("                    , T.PORT_KPI_DIR_CD" ).append("\n"); 
		query.append("                    , T.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                FROM OPF_PORT_TM_KPI T" ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("                 AND SLAN_CD         = @[slan_cd]               -- 'PNH'" ).append("\n"); 
		query.append("                 AND VPS_PORT_CD     = @[port_cd]               -- 'USSEA'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               #if(${port_kpi_dir_cd} != '')" ).append("\n"); 
		query.append("                 AND PORT_KPI_DIR_CD = @[port_kpi_dir_cd]       -- 'W'" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                 AND CLPT_IND_SEQ    = @[clpt_ind_seq]          -- '2'" ).append("\n"); 
		query.append("                 AND KPI_TGT_YR      = @[kpi_tgt_yr]            -- '2012'" ).append("\n"); 
		query.append("                 AND KPI_VER_SEQ     = @[kpi_ver_seq]           -- '2'" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND RHQ    = @[rhq_ofc_cd]           -- 'NYCRA'" ).append("\n"); 
		query.append("       )K" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND K.SLAN_CD      = P.SLAN_CD" ).append("\n"); 
		query.append("   AND K.VPS_PORT_CD  = P.PORT_CD" ).append("\n"); 
		query.append("   AND K.RHQ          = @[rhq_ofc_cd]           -- 'NYCRA'" ).append("\n"); 
		query.append("   AND CASE WHEN K.PORT_KPI_DIR_CD = 'A' THEN P.SKD_DIR_CD" ).append("\n"); 
		query.append("       ELSE K.PORT_KPI_DIR_CD" ).append("\n"); 
		query.append("       END  = P.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND K.CLPT_IND_SEQ = P.CLPT_IND_SEQ" ).append("\n"); 
		query.append("-- ORDER BY RHQ, PORT_CD, SLAN_CD, SKD_DIR_CD, CLPT_IND_SEQ, YD_CD DESC, WORK_COMPLETED, VVD_CD" ).append("\n"); 
		query.append(" ORDER BY RHQ, PORT_CD, SLAN_CD, CLPT_IND_SEQ, YD_CD DESC, WORK_COMPLETED, VVD_CD      --WORK_COMPLETED 로 SORTING 하기 위해 SKD_DIR_CD 를 빼줌 (2012.06.26)" ).append("\n"); 

	}
}