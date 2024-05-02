/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOCreateQtaLoadRevForSectorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOCreateQtaLoadRevForSectorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [QTA Set up for IAS Sector by Head Office] 의 데이터를 [생성]한다
	  * 
	  * CHM-201639851 2016.01.28 Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
	  * 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public PlanningDBDAOCreateQtaLoadRevForSectorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOCreateQtaLoadRevForSectorCSQL").append("\n"); 
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
		query.append("INSERT INTO SQM_SCTR_LOD_REV(BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, FNL_BSA_CAPA, PF_GRP_CD, RGN_OFC_CD, POL_CD, POD_CD, TRD_CD, SUB_TRD_CD, RHQ_CD, GID_LOD_QTY, GID_GRS_RPB_REV, LOD_QTY, GRS_RPB_REV, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT )" ).append("\n"); 
		query.append(" SELECT IF1.BSE_TP_CD" ).append("\n"); 
		query.append("      , IF1.BSE_YR" ).append("\n"); 
		query.append("      , IF1.BSE_QTR_CD" ).append("\n"); 
		query.append("      , IF1.OFC_VW_CD" ).append("\n"); 
		query.append("      , IF1.RLANE_CD" ).append("\n"); 
		query.append("      , IF1.DIR_CD" ).append("\n"); 
		query.append("      , IF1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      , IF1.PF_GRP_CD" ).append("\n"); 
		query.append("      , IF1.RGN_OFC_CD" ).append("\n"); 
		query.append("      , IF1.POL_CD" ).append("\n"); 
		query.append("      , IF1.POD_CD" ).append("\n"); 
		query.append("      , IF1.TRD_CD" ).append("\n"); 
		query.append("      , IF1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , IF1.RHQ_CD" ).append("\n"); 
		query.append("      , IF1.GID_LOD_QTY" ).append("\n"); 
		query.append("      , IF1.GID_GRS_RPB_REV" ).append("\n"); 
		query.append("      , NVL(DECODE(PRE1.LOD_QTY,    0,PRE2.PRE_LOD_QTY,     PRE1.LOD_QTY), 0)     AS LOD_QTY" ).append("\n"); 
		query.append("      , NVL(DECODE(PRE1.GRS_RPB_REV,0,PRE2.PRE_GRS_RPB_REV, PRE1.GRS_RPB_REV), 0) AS GRS_RPB_REV" ).append("\n"); 
		query.append("      , @[f_usr_id]             AS CRE_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                 AS CRE_DT" ).append("\n"); 
		query.append("      , @[f_usr_id]             AS UPD_USR_ID" ).append("\n"); 
		query.append("      , SYSDATE                 AS UPD_DT" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("           SELECT C1.BSE_TP_CD" ).append("\n"); 
		query.append("                , C1.BSE_YR" ).append("\n"); 
		query.append("                , C1.BSE_QTR_CD" ).append("\n"); 
		query.append("                , C1.OFC_VW_CD" ).append("\n"); 
		query.append("                , C1.RLANE_CD" ).append("\n"); 
		query.append("                , C1.DIR_CD" ).append("\n"); 
		query.append("                , C3.BSA_CAPA AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("                , C1.PF_GRP_CD" ).append("\n"); 
		query.append("                , C1.RGN_OFC_CD" ).append("\n"); 
		query.append("                , C1.POL_CD" ).append("\n"); 
		query.append("                , C1.POD_CD" ).append("\n"); 
		query.append("                , C1.TRD_CD" ).append("\n"); 
		query.append("                , C1.SUB_TRD_CD" ).append("\n"); 
		query.append("                , C1.RHQ_CD" ).append("\n"); 
		query.append("                , NVL(C2.LOD_QTY, 0) AS GID_LOD_QTY" ).append("\n"); 
		query.append("                , ROUND(DECODE(NVL(C2.LOD_QTY, 0), 0, 0, C2.GRS_TTL_REV/C2.LOD_QTY)) AS GID_GRS_RPB_REV" ).append("\n"); 
		query.append("                , ROW_NUMBER() OVER (PARTITION BY C1.BSE_TP_CD, C1.BSE_YR, C1.BSE_QTR_CD, C1.OFC_VW_CD, C1.RLANE_CD, C1.DIR_CD, C1.PF_GRP_CD, C1.RGN_OFC_CD, C1.POL_CD, C1.POD_CD ORDER BY C3.BSA_CAPA DESC) BSA_RANK" ).append("\n"); 
		query.append("             FROM SQM_SCTR_LANE_OFC C1" ).append("\n"); 
		query.append("                , SQM_SCTR_PERF_IF C2" ).append("\n"); 
		query.append("                , ( " ).append("\n"); 
		query.append("                   SELECT DISTINCT B1.DIR_CD" ).append("\n"); 
		query.append("                        , B1.RLANE_CD" ).append("\n"); 
		query.append("                        , B1.BSA_CAPA" ).append("\n"); 
		query.append("                        , B1.PF_GRP_CD" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                           SELECT A1.DIR_CD" ).append("\n"); 
		query.append("                                , A1.RLANE_CD" ).append("\n"); 
		query.append("                                , A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                , A1.PF_GRP_CD" ).append("\n"); 
		query.append("                                , MAX(A2.RANGE_BSA)+9 AS BSA_CAPA" ).append("\n"); 
		query.append("                             FROM ( " ).append("\n"); 
		query.append("                                   SELECT DISTINCT S1.RLANE_CD" ).append("\n"); 
		query.append("                                        , S1.DIR_CD" ).append("\n"); 
		query.append("                                        , S1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                        , S2.PF_GRP_CD" ).append("\n"); 
		query.append("                                     FROM SQM_QTA_TGT_VVD S1" ).append("\n"); 
		query.append("                                        , SQM_SCTR_PF_GRP S2" ).append("\n"); 
		query.append("                                    WHERE 1 = 1" ).append("\n"); 
		query.append("                                      AND S1.BSE_TP_CD    = S2.BSE_TP_CD" ).append("\n"); 
		query.append("                                      AND S1.BSE_YR       = S2.BSE_YR" ).append("\n"); 
		query.append("                                      AND S1.BSE_QTR_CD   = S2.BSE_QTR_CD" ).append("\n"); 
		query.append("                                      AND S1.TRD_CD       = S2.TRD_CD" ).append("\n"); 
		query.append("                                      AND S1.RLANE_CD     = S2.RLANE_CD" ).append("\n"); 
		query.append("                                      AND S1.PF_SVC_TP_CD = S2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                                      AND S1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                      AND S1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                                      AND S1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                      AND S1.TRD_CD       = 'IAS'" ).append("\n"); 
		query.append("                                 ORDER BY DIR_CD" ).append("\n"); 
		query.append("                                        , RLANE_CD" ).append("\n"); 
		query.append("                                        , FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("                                  ) A1" ).append("\n"); 
		query.append("                                , ( " ).append("\n"); 
		query.append("                                   SELECT DISTINCT RLANE_CD" ).append("\n"); 
		query.append("                                        , DIR_CD" ).append("\n"); 
		query.append("                                        , FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                        , FNL_BSA_CAPA - 9 AS RANGE_BSA" ).append("\n"); 
		query.append("                                     FROM SQM_QTA_TGT_VVD" ).append("\n"); 
		query.append("                                    WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                                      AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                                      AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                                      AND TRD_CD     = 'IAS'" ).append("\n"); 
		query.append("                                 ORDER BY DIR_CD" ).append("\n"); 
		query.append("                                        , RLANE_CD" ).append("\n"); 
		query.append("                                        , FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("                                  ) A2" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND A1.DIR_CD        = A2.DIR_CD" ).append("\n"); 
		query.append("                              AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("                              AND A1.FNL_BSA_CAPA >= A2.RANGE_BSA" ).append("\n"); 
		query.append("                         GROUP BY A1.DIR_CD" ).append("\n"); 
		query.append("                                , A1.RLANE_CD" ).append("\n"); 
		query.append("                                , A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                                , A1.PF_GRP_CD" ).append("\n"); 
		query.append("                         ORDER BY A1.DIR_CD" ).append("\n"); 
		query.append("                                , A1.RLANE_CD" ).append("\n"); 
		query.append("                                , A1.FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("                          ) B1" ).append("\n"); 
		query.append("                  ) C3" ).append("\n"); 
		query.append("            WHERE 1 = 1" ).append("\n"); 
		query.append("              AND C1.BSE_TP_CD  = C2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("              AND C1.BSE_YR     = C2.BSE_YR(+)" ).append("\n"); 
		query.append("              AND C1.BSE_QTR_CD = C2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("              AND C1.OFC_VW_CD  = C2.OFC_VW_CD(+)" ).append("\n"); 
		query.append("              AND C1.RLANE_CD   = C2.RLANE_CD(+)" ).append("\n"); 
		query.append("              AND C1.DIR_CD     = C2.DIR_CD(+)" ).append("\n"); 
		query.append("              AND C1.RGN_OFC_CD = C2.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("              AND C1.POL_CD     = C2.POL_CD(+)" ).append("\n"); 
		query.append("              AND C1.POD_CD     = C2.POD_CD(+)" ).append("\n"); 
		query.append("              AND C1.RLANE_CD   = C3.RLANE_CD" ).append("\n"); 
		query.append("              AND C1.DIR_CD     = C3.DIR_CD" ).append("\n"); 
		query.append("              AND C1.PF_GRP_CD  = C3.PF_GRP_CD" ).append("\n"); 
		query.append("              AND C1.BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("              AND C1.BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("              AND C1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("          ) IF1" ).append("\n"); 
		query.append("          , SQM_SCTR_LOD_REV PRE1" ).append("\n"); 
		query.append("          , (" ).append("\n"); 
		query.append("         SELECT BSE_TP_CD" ).append("\n"); 
		query.append("              , @[f_bse_yr] BSE_YR" ).append("\n"); 
		query.append("              , DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) BSE_QTR_CD" ).append("\n"); 
		query.append("              , OFC_VW_CD" ).append("\n"); 
		query.append("              , RLANE_CD" ).append("\n"); 
		query.append("              , DIR_CD" ).append("\n"); 
		query.append("              , PF_GRP_CD" ).append("\n"); 
		query.append("              , RGN_OFC_CD" ).append("\n"); 
		query.append("              , POL_CD" ).append("\n"); 
		query.append("              , POD_CD" ).append("\n"); 
		query.append("              , LOD_QTY AS PRE_LOD_QTY" ).append("\n"); 
		query.append("              , GRS_RPB_REV AS PRE_GRS_RPB_REV" ).append("\n"); 
		query.append("              , ROW_NUMBER() OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, PF_GRP_CD, RGN_OFC_CD, POL_CD, POD_CD ORDER BY FNL_BSA_CAPA DESC) BSA_RANK" ).append("\n"); 
		query.append("              , COUNT(*) OVER (PARTITION BY BSE_TP_CD, BSE_YR, BSE_QTR_CD, OFC_VW_CD, RLANE_CD, DIR_CD, PF_GRP_CD, RGN_OFC_CD, POL_CD, POD_CD ) MAX_BSA_RANK" ).append("\n"); 
		query.append("           FROM SQM_SCTR_LOD_REV R1" ).append("\n"); 
		query.append("          WHERE BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND BSE_YR    = TO_CHAR(ADD_MONTHS(TO_DATE(@[f_bse_yr]||DECODE(SUBSTR(DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]), 0, 1), '1', '01', '2','04', '3', '07', '4', '10','1'), 'YYYYMM'), -2), 'YYYY')" ).append("\n"); 
		query.append("            AND BSE_QTR_CD= TO_CHAR(ADD_MONTHS(TO_DATE(@[f_bse_yr]||DECODE(SUBSTR(DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]), 0, 1), '1', '01', '2','04', '3', '07', '4', '10','1'), 'YYYYMM'), -2), 'Q')||'Q'" ).append("\n"); 
		query.append("--            AND OFC_VW_CD   = 'L'" ).append("\n"); 
		query.append("--            AND SUB_TRD_CD  = 'IA'" ).append("\n"); 
		query.append("--            AND RLANE_CD    = 'AUSIA'" ).append("\n"); 
		query.append("--            AND POL_CD = 'SGSIN'" ).append("\n"); 
		query.append("--            AND POD_CD = 'AUBNE'" ).append("\n"); 
		query.append("--            AND RGN_OFC_CD = 'BKKSC'" ).append("\n"); 
		query.append("                                                                                                  " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("         -- FNL_BSA_CAPA기준으로 가장작은 숫자에 해당하는 RANK에 10개를 만들어준다. 지난 분기보다 현재분기에 FNL_BSA_CAPA 갯수가 더 많을 수 있으므로" ).append("\n"); 
		query.append("         SELECT A.BSE_TP_CD" ).append("\n"); 
		query.append("              , A.BSE_YR" ).append("\n"); 
		query.append("              , A.BSE_QTR_CD" ).append("\n"); 
		query.append("              , A.OFC_VW_CD" ).append("\n"); 
		query.append("              , A.RLANE_CD" ).append("\n"); 
		query.append("              , A.DIR_CD" ).append("\n"); 
		query.append("              , A.PF_GRP_CD" ).append("\n"); 
		query.append("              , A.RGN_OFC_CD" ).append("\n"); 
		query.append("              , A.POL_CD" ).append("\n"); 
		query.append("              , A.POD_CD" ).append("\n"); 
		query.append("              , A.PRE_LOD_QTY" ).append("\n"); 
		query.append("              , A.PRE_GRS_RPB_REV" ).append("\n"); 
		query.append("              , B.BSA_RANK + A.MAX_BSA_RANK AS BSA_RANK" ).append("\n"); 
		query.append("              , A.MAX_BSA_RANK" ).append("\n"); 
		query.append("           FROM" ).append("\n"); 
		query.append("                (SELECT BSE_TP_CD" ).append("\n"); 
		query.append("                      , @[f_bse_yr] BSE_YR" ).append("\n"); 
		query.append("                      , DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) BSE_QTR_CD" ).append("\n"); 
		query.append("                      , OFC_VW_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                      , PF_GRP_CD" ).append("\n"); 
		query.append("                      , RGN_OFC_CD" ).append("\n"); 
		query.append("                      , POL_CD" ).append("\n"); 
		query.append("                      , POD_CD" ).append("\n"); 
		query.append("                      , MIN(LOD_QTY) KEEP (DENSE_RANK FIRST ORDER BY FNL_BSA_CAPA) AS PRE_LOD_QTY -- FNL_BSA_CAPA 기준으로 가장 큰숫자부터 RANK 정렬" ).append("\n"); 
		query.append("                      , MIN(GRS_RPB_REV) KEEP (DENSE_RANK FIRST ORDER BY FNL_BSA_CAPA) AS PRE_GRS_RPB_REV" ).append("\n"); 
		query.append("                      , COUNT(*) AS MAX_BSA_RANK" ).append("\n"); 
		query.append("                   FROM SQM_SCTR_LOD_REV R1" ).append("\n"); 
		query.append("                  WHERE BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                    AND BSE_YR    = TO_CHAR(ADD_MONTHS(TO_DATE(@[f_bse_yr]||DECODE(SUBSTR(DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]), 0, 1), '1', '01', '2', '04', '3', '07', '4', '10','1'), 'YYYYMM'), -2), 'YYYY')" ).append("\n"); 
		query.append("                    AND BSE_QTR_CD= TO_CHAR(ADD_MONTHS(TO_DATE(@[f_bse_yr]||DECODE(SUBSTR(DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]), 0, 1), '1', '01', '2','04', '3', '07', '4', '10', '1'), 'YYYYMM'), -2), 'Q')||'Q'" ).append("\n"); 
		query.append("--                    AND OFC_VW_CD   = 'L'" ).append("\n"); 
		query.append("--                    AND SUB_TRD_CD  = 'IA'" ).append("\n"); 
		query.append("--                    AND RLANE_CD    = 'AUSIA'" ).append("\n"); 
		query.append("                    GROUP BY BSE_TP_CD" ).append("\n"); 
		query.append("                      , BSE_YR" ).append("\n"); 
		query.append("                      , BSE_QTR_CD" ).append("\n"); 
		query.append("                      , OFC_VW_CD" ).append("\n"); 
		query.append("                      , RLANE_CD" ).append("\n"); 
		query.append("                      , DIR_CD" ).append("\n"); 
		query.append("                      , PF_GRP_CD" ).append("\n"); 
		query.append("                      , RGN_OFC_CD" ).append("\n"); 
		query.append("                      , POL_CD" ).append("\n"); 
		query.append("                      , POD_CD" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("              , (SELECT LEVEL AS BSA_RANK FROM DUAL CONNECT BY LEVEL < 10) B" ).append("\n"); 
		query.append("        ) PRE2" ).append("\n"); 
		query.append("  WHERE PRE1.BSE_TP_CD(+)    = IF1.BSE_TP_CD" ).append("\n"); 
		query.append("    AND PRE1.BSE_YR(+)       = IF1.BSE_YR" ).append("\n"); 
		query.append("    AND PRE1.BSE_QTR_CD(+)   = IF1.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND PRE1.OFC_VW_CD(+)    = IF1.OFC_VW_CD" ).append("\n"); 
		query.append("    AND PRE1.RLANE_CD(+)     = IF1.RLANE_CD" ).append("\n"); 
		query.append("    AND PRE1.DIR_CD(+)       = IF1.DIR_CD" ).append("\n"); 
		query.append("    AND PRE1.FNL_BSA_CAPA(+) = IF1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("    AND PRE1.PF_GRP_CD(+)    = IF1.PF_GRP_CD" ).append("\n"); 
		query.append("    AND PRE1.RGN_OFC_CD(+)   = IF1.RGN_OFC_CD" ).append("\n"); 
		query.append("    AND PRE1.POL_CD(+)       = IF1.POL_CD" ).append("\n"); 
		query.append("    AND PRE1.POD_CD(+)       = IF1.POD_CD  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    AND PRE2.BSE_TP_CD(+)    = IF1.BSE_TP_CD" ).append("\n"); 
		query.append("    AND PRE2.BSE_YR(+)       = IF1.BSE_YR" ).append("\n"); 
		query.append("    AND PRE2.BSE_QTR_CD(+)   = IF1.BSE_QTR_CD" ).append("\n"); 
		query.append("    AND PRE2.OFC_VW_CD(+)    = IF1.OFC_VW_CD" ).append("\n"); 
		query.append("    AND PRE2.RLANE_CD(+)     = IF1.RLANE_CD" ).append("\n"); 
		query.append("    AND PRE2.DIR_CD(+)       = IF1.DIR_CD" ).append("\n"); 
		query.append("    AND PRE2.BSA_RANK(+)     = IF1.BSA_RANK" ).append("\n"); 
		query.append("    AND PRE2.PF_GRP_CD(+)    = IF1.PF_GRP_CD" ).append("\n"); 
		query.append("    AND PRE2.RGN_OFC_CD(+)   = IF1.RGN_OFC_CD" ).append("\n"); 
		query.append("    AND PRE2.POL_CD(+)       = IF1.POL_CD" ).append("\n"); 
		query.append("    AND PRE2.POD_CD(+)       = IF1.POD_CD" ).append("\n"); 

	}
}