/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CostManageDBDAOSearchBasicCmcbCoaPfmcListListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostManageDBDAOSearchBasicCmcbCoaPfmcListListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COA CM cost UC와 SQM간 차이를 조회하여 보여주는 화면
	  * 
	  * 2014.06.30 PEJ 쿼리튜닝(NO_MERGE 힌트 추가) 
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2015.07.17 김용습 [CHM-201536875] [CSR 전환건] SQM의 CM Cost 산출 및 조회 로직 보완
	  * 2015.08.20 김용습 [CHM-201536994] Split24-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * 2016.01.07 [CHM-201639699] NYCMS의 CM Cost I/F 로직 수정
	  * </pre>
	  */
	public CostManageDBDAOSearchBasicCmcbCoaPfmcListListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchBasicCmcbCoaPfmcListListRSQL").append("\n"); 
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
		query.append("SELECT BSE_TP_CD " ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,DECODE(OFC_VW_CD, 'C', 'Contract', 'Loading') AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RHQ_OFC AS RHQ_CD" ).append("\n"); 
		query.append("        ,RGN_OFC AS RGN_OFC_CD" ).append("\n"); 
		query.append("        ,ROUND(SUM(LOD_QTY), 5) AS LOD_QTY" ).append("\n"); 
		query.append("        ,ROUND(SUM(RA_CM_COST_TTL_AMT) / SUM(LOD_QTY), 5) AS MAS_RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,ROUND(SUM(PA_CM_COST_TTL_AMT) / SUM(LOD_QTY), 5) AS MAS_PA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,ROUND(SUM(RA_CM_COST_TTL_AMT) / SUM(LOD_QTY), 5) - RA_CM_UC_AMT AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,ROUND(SUM(PA_CM_COST_TTL_AMT) / SUM(LOD_QTY), 5) - PA_CM_UC_AMT AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT BSE_TP_CD" ).append("\n"); 
		query.append("                  ,BSE_YR" ).append("\n"); 
		query.append("                  ,BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,QTA_TGT_CD" ).append("\n"); 
		query.append("                  ,OFC_VW_CD" ).append("\n"); 
		query.append("                  ,TRD_CD" ).append("\n"); 
		query.append("                  ,SUB_TRD_CD" ).append("\n"); 
		query.append("                  ,RLANE_CD" ).append("\n"); 
		query.append("                  ,DIR_CD" ).append("\n"); 
		query.append("                  ,DECODE(OFC_VW_CD, 'C', CTRT_RHQ_OFC, 'L', SLS_RHQ_OFC) AS RHQ_OFC" ).append("\n"); 
		query.append("                  ,DECODE(OFC_VW_CD, 'C', CTRT_RGN_OFC, 'L', SLS_RGN_OFC) AS RGN_OFC" ).append("\n"); 
		query.append("                  ,CTRT_RGN_OFC" ).append("\n"); 
		query.append("                  ,SLS_RGN_OFC" ).append("\n"); 
		query.append("                  ,CTRT_OFC_CD" ).append("\n"); 
		query.append("                  ,SLS_OFC_CD" ).append("\n"); 
		query.append("                  ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("                  ,SUM(RA_CM_COST_TTL_AMT) AS RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                  ,SUM(PA_CM_COST_TTL_AMT) AS PA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                  ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("                  ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("                      SELECT S.BSE_TP_CD" ).append("\n"); 
		query.append("                            ,S.BSE_YR" ).append("\n"); 
		query.append("                            ,S.BSE_QTR_CD" ).append("\n"); 
		query.append("                            ,QTA_TGT_CD" ).append("\n"); 
		query.append("                            ,S.OFC_VW_CD" ).append("\n"); 
		query.append("                            ,T.TRD_CD" ).append("\n"); 
		query.append("                            ,T.SUB_TRD_CD" ).append("\n"); 
		query.append("                            ,T.RLANE_CD" ).append("\n"); 
		query.append("                            ,T.DIR_CD" ).append("\n"); 
		query.append("                            ,CTRT_RHQ_OFC" ).append("\n"); 
		query.append("                            ,CTRT_RGN_OFC" ).append("\n"); 
		query.append("                            ,SLS_RHQ_OFC" ).append("\n"); 
		query.append("                            ,SLS_RGN_OFC" ).append("\n"); 
		query.append("                            ,CTRT_OFC_CD" ).append("\n"); 
		query.append("                            ,SLS_OFC_CD" ).append("\n"); 
		query.append("                            ,LOD_QTY" ).append("\n"); 
		query.append("                            ,RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                            ,PA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                            ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("                            ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                                SELECT /*+ NO_MERGE */ DECODE(B.SPCL_CGO_FLG, 'Y', 'S', DECODE(SUBSTR(A.CNTR_TPSZ_CD, 1, 1), 'R', 'R', 'D')) AS QTA_TGT_CD" ).append("\n"); 
		query.append("                                      ,TRD_CD" ).append("\n"); 
		query.append("                                      ,SUB_TRD_CD" ).append("\n"); 
		query.append("                                      ,RLANE_CD" ).append("\n"); 
		query.append("                                      ,DIR_CD" ).append("\n"); 
		query.append("--                                      ,NVL((SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD), " ).append("\n"); 
		query.append("--                                           (SELECT RHQ_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = CTRT_OFC_CD)) AS CTRT_RHQ_OFC" ).append("\n"); 
		query.append("--                                      ,CASE WHEN    CTRT_OFC_CD = 'NYCRA'" ).append("\n"); 
		query.append("--                                                 OR CTRT_OFC_CD = 'HAMRU'" ).append("\n"); 
		query.append("--                                                 OR CTRT_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("--                                                 OR CTRT_OFC_CD = 'SHARC' THEN SUBSTR(CTRT_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("--                                                                          ELSE NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD)," ).append("\n"); 
		query.append("--                                                                                   (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = CTRT_OFC_CD))" ).append("\n"); 
		query.append("--                                        END AS CTRT_RGN_OFC" ).append("\n"); 
		query.append("--                                      ,NVL((SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)," ).append("\n"); 
		query.append("--                                           (SELECT RHQ_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD)) AS SLS_RHQ_OFC" ).append("\n"); 
		query.append("--                                      ,CASE WHEN    SLS_OFC_CD = 'NYCRA'" ).append("\n"); 
		query.append("--                                                 OR SLS_OFC_CD = 'HAMRU'" ).append("\n"); 
		query.append("--                                                 OR SLS_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("--                                                 OR SLS_OFC_CD = 'SHARC' THEN SUBSTR(SLS_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("--                                                                         ELSE NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)," ).append("\n"); 
		query.append("--                                                                                  (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD))" ).append("\n"); 
		query.append("--                                        END AS SLS_RGN_OFC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                      ,NVL((SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD), " ).append("\n"); 
		query.append("                                           (SELECT RHQ_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = CTRT_OFC_CD)) AS CTRT_RHQ_OFC                                     " ).append("\n"); 
		query.append("                                      ,CASE WHEN SLS_OFC_CD = 'NYCMW' OR SLS_OFC_CD = 'NYCME'" ).append("\n"); 
		query.append("                                                THEN (SELECT PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = (SELECT PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD))" ).append("\n"); 
		query.append("                                        ELSE NVL((SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)," ).append("\n"); 
		query.append("                                               (SELECT RHQ_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD)) END AS SLS_RHQ_OFC" ).append("\n"); 
		query.append("                                               " ).append("\n"); 
		query.append("                                      ,CASE WHEN    CTRT_OFC_CD = 'NYCRA'" ).append("\n"); 
		query.append("                                                 OR CTRT_OFC_CD = 'HAMRU'" ).append("\n"); 
		query.append("                                                 OR CTRT_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("                                                 OR CTRT_OFC_CD = 'SHARC' THEN SUBSTR(CTRT_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("                                                                          ELSE NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD)," ).append("\n"); 
		query.append("                                                                                   (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = CTRT_OFC_CD))" ).append("\n"); 
		query.append("                                        END AS CTRT_RGN_OFC" ).append("\n"); 
		query.append("                                      ,CASE WHEN    SLS_OFC_CD = 'NYCRA'" ).append("\n"); 
		query.append("                                                 OR SLS_OFC_CD = 'HAMRU'" ).append("\n"); 
		query.append("                                                 OR SLS_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("                                                 OR SLS_OFC_CD = 'SHARC' " ).append("\n"); 
		query.append("                                                 THEN SUBSTR(SLS_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("                                            WHEN SLS_OFC_CD = 'NYCMW' OR SLS_OFC_CD = 'NYCME'" ).append("\n"); 
		query.append("                                                THEN NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = (SELECT PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)), (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD))" ).append("\n"); 
		query.append("                                            ELSE NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD), (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD))" ).append("\n"); 
		query.append("                                        END AS SLS_RGN_OFC" ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                        " ).append("\n"); 
		query.append("                                      ,CTRT_OFC_CD" ).append("\n"); 
		query.append("                                      ,SLS_OFC_CD" ).append("\n"); 
		query.append("                                      ,DECODE(SUBSTR(A.CNTR_TPSZ_CD, -1), '2', BKG_QTY, BKG_QTY * 2) AS LOD_QTY" ).append("\n"); 
		query.append("                                      ,(RA_CM_COST_TTL_AMT - DMDT_COM_AMT) AS RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                                      ,(PA_CM_COST_TTL_AMT - DMDT_COM_AMT) AS PA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                                  FROM MAS_BKG_EXPN_DTL_WK     A" ).append("\n"); 
		query.append("                                      ,MAS_SPCL_REPO_CNTR_RGST B" ).append("\n"); 
		query.append("                                 WHERE SUBSTR(SLS_YRMON, 1, 4)||COST_WK BETWEEN @[f_fm_wk]  AND @[f_to_wk]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                                   AND TRD_CD         = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                                   AND RLANE_CD       = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                                   AND DIR_CD         = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                   AND A.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("                                   AND BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("                                   AND BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                                   AND BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("                                   AND A.CNTR_TPSZ_CD = B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                             ) T" ).append("\n"); 
		query.append("                            ,SQM_QTA_LANE_OFC      S" ).append("\n"); 
		query.append("                            ,SQM_QTA_LANE_OFC_COST C" ).append("\n"); 
		query.append("                       WHERE S.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                         AND S.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                         AND S.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                         AND S.OFC_VW_CD    = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("                         AND S.RHQ_CD       = @[f_rhq_cd]" ).append("\n"); 
		query.append("                         AND S.RGN_OFC_CD   = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                         AND S.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                         AND S.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                         AND S.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                         AND T.TRD_CD       = S.TRD_CD" ).append("\n"); 
		query.append("                         AND T.SUB_TRD_CD   = S.SUB_TRD_CD" ).append("\n"); 
		query.append("                         AND T.RLANE_CD     = S.RLANE_CD" ).append("\n"); 
		query.append("                         AND T.DIR_CD       = S.DIR_CD" ).append("\n"); 
		query.append("                         AND T.CTRT_RGN_OFC = DECODE(S.OFC_VW_CD, 'C', S.RGN_OFC_CD, T.CTRT_RGN_OFC)" ).append("\n"); 
		query.append("                         AND T.SLS_RGN_OFC  = DECODE(S.OFC_VW_CD, 'L', S.RGN_OFC_CD, T.SLS_RGN_OFC)" ).append("\n"); 
		query.append("                         AND T.CTRT_RHQ_OFC = DECODE(S.OFC_VW_CD, 'C', S.RHQ_CD    , T.CTRT_RHQ_OFC)" ).append("\n"); 
		query.append("                         AND T.SLS_RHQ_OFC  = DECODE(S.OFC_VW_CD, 'L', S.RHQ_CD    , T.SLS_RHQ_OFC)" ).append("\n"); 
		query.append("                         AND T.CTRT_RHQ_OFC IS NOT NULL" ).append("\n"); 
		query.append("                         AND T.SLS_RHQ_OFC  IS NOT NULL" ).append("\n"); 
		query.append("                         AND S.SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("                         AND S.BSE_TP_CD    = C.BSE_TP_CD" ).append("\n"); 
		query.append("                         AND S.BSE_YR       = C.BSE_YR" ).append("\n"); 
		query.append("                         AND S.BSE_QTR_CD   = C.BSE_QTR_CD" ).append("\n"); 
		query.append("                         AND S.OFC_VW_CD    = C.OFC_VW_CD" ).append("\n"); 
		query.append("                         AND T.TRD_CD       = C.TRD_CD" ).append("\n"); 
		query.append("                         AND T.RLANE_CD     = C.RLANE_CD" ).append("\n"); 
		query.append("                         AND T.DIR_CD       = C.DIR_CD" ).append("\n"); 
		query.append("                         AND T.CTRT_RGN_OFC = DECODE(S.OFC_VW_CD, 'C', C.RGN_OFC_CD, T.CTRT_RGN_OFC)" ).append("\n"); 
		query.append("                         AND T.SLS_RGN_OFC  = DECODE(S.OFC_VW_CD, 'L', C.RGN_OFC_CD, T.SLS_RGN_OFC)" ).append("\n"); 
		query.append("                         AND T.CTRT_RHQ_OFC = DECODE(S.OFC_VW_CD, 'C', C.RHQ_CD    , T.CTRT_RHQ_OFC)" ).append("\n"); 
		query.append("                         AND T.SLS_RHQ_OFC  = DECODE(S.OFC_VW_CD, 'L', C.RHQ_CD    , T.SLS_RHQ_OFC)" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("          GROUP BY BSE_TP_CD" ).append("\n"); 
		query.append("                  ,BSE_YR" ).append("\n"); 
		query.append("                  ,BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,QTA_TGT_CD" ).append("\n"); 
		query.append("                  ,OFC_VW_CD" ).append("\n"); 
		query.append("                  ,TRD_CD" ).append("\n"); 
		query.append("                  ,SUB_TRD_CD" ).append("\n"); 
		query.append("                  ,RLANE_CD" ).append("\n"); 
		query.append("                  ,DIR_CD" ).append("\n"); 
		query.append("                  ,DECODE(OFC_VW_CD, 'C', CTRT_RHQ_OFC, 'L', SLS_RHQ_OFC)" ).append("\n"); 
		query.append("                  ,DECODE(OFC_VW_CD, 'C', CTRT_RGN_OFC, 'L', SLS_RGN_OFC)" ).append("\n"); 
		query.append("                  ,CTRT_RGN_OFC" ).append("\n"); 
		query.append("                  ,SLS_RGN_OFC" ).append("\n"); 
		query.append("                  ,CTRT_OFC_CD" ).append("\n"); 
		query.append("                  ,SLS_OFC_CD" ).append("\n"); 
		query.append("                  ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("                  ,PA_CM_UC_AMT" ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("   WHERE RHQ_OFC IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY BSE_TP_CD" ).append("\n"); 
		query.append("        ,BSE_YR" ).append("\n"); 
		query.append("        ,BSE_QTR_CD" ).append("\n"); 
		query.append("        ,OFC_VW_CD" ).append("\n"); 
		query.append("        ,TRD_CD" ).append("\n"); 
		query.append("        ,SUB_TRD_CD" ).append("\n"); 
		query.append("        ,RLANE_CD" ).append("\n"); 
		query.append("        ,DIR_CD" ).append("\n"); 
		query.append("        ,RHQ_OFC" ).append("\n"); 
		query.append("        ,RGN_OFC" ).append("\n"); 
		query.append("        ,RA_CM_UC_AMT" ).append("\n"); 
		query.append("        ,PA_CM_UC_AMT" ).append("\n"); 

	}
}