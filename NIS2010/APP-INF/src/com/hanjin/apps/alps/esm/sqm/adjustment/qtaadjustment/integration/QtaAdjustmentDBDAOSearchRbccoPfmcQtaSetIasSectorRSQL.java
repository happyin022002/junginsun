/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchRbccoPfmcQtaSetIasSectorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchRbccoPfmcQtaSetIasSectorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RBCCO PFMC = QTA Setting for IAS Sector 를 조회합니다.
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2015.07.17 김용습 [CHM-201536875] [CSR 전환건] SQM의 CM Cost 산출 및 조회 로직 보완
	  * * 2015.08.20 김용습 [CHM-201536994] Split24-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * 2016.01.07 SUBSTR(CNTR_TPSZ_CD, -1), 2 -> SUBSTR(CNTR_TPSZ_CD, -1), '2'로 변경
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchRbccoPfmcQtaSetIasSectorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchRbccoPfmcQtaSetIasSectorRSQL").append("\n"); 
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
		query.append("SELECT @[f_bse_yr] AS BSE_YR" ).append("\n"); 
		query.append("      ,@[f_bse_qtr_cd] AS BSE_QTR_CD" ).append("\n"); 
		query.append("      ,C1.TRD_CD" ).append("\n"); 
		query.append("      ,C1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,C1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,C1.RLANE_CD" ).append("\n"); 
		query.append("      ,C1.DIR_CD" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("      ,C1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,C1.COST_MON AS BSE_MON" ).append("\n"); 
		query.append("      ,C1.COST_WK AS BSE_WK" ).append("\n"); 
		query.append("      ,C1.LOD_QTY" ).append("\n"); 
		query.append("      ,DECODE(C1.LOD_QTY, 0 , 0, TRUNC(C1.GRS_RPB_REV/C1.LOD_QTY)) AS GRS_RPB_REV" ).append("\n"); 
		query.append("      ,DECODE(C1.LOD_QTY, 0 , 0, TRUNC(C1.PA_CM_COST/C1.LOD_QTY)) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,DECODE(C1.LOD_QTY, 0 , 0, TRUNC(C1.RA_CM_COST/C1.LOD_QTY)) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("FROM (      " ).append("\n"); 
		query.append("        SELECT B1.TRD_CD" ).append("\n"); 
		query.append("              ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,DECODE(B2.CPY_NO, 0, 'Contract', 'Loading') AS OFC_VW_CD" ).append("\n"); 
		query.append("              ,B1.RLANE_CD" ).append("\n"); 
		query.append("              ,B1.DIR_CD" ).append("\n"); 
		query.append("              ,DECODE(B2.CPY_NO, 0, B1.CTRT_RHQ_OFC, B1.SLS_RHQ_OFC) AS RHQ_CD" ).append("\n"); 
		query.append("              ,DECODE(B2.CPY_NO, 0, B1.CTRT_RGN_OFC, B1.SLS_RGN_OFC) AS RGN_OFC_CD" ).append("\n"); 
		query.append("        --      ,B1.CTRT_RHQ_OFC" ).append("\n"); 
		query.append("        --      ,B1.CTRT_RGN_OFC" ).append("\n"); 
		query.append("        --      ,B1.SLS_RHQ_OFC" ).append("\n"); 
		query.append("        --      ,B1.SLS_RGN_OFC" ).append("\n"); 
		query.append("              ,SUBSTR(B1.COST_YRMON, 5) AS COST_MON" ).append("\n"); 
		query.append("              ,B1.COST_WK" ).append("\n"); 
		query.append("              ,B1.LOD_QTY" ).append("\n"); 
		query.append("              ,B1.GRS_RPB_REV" ).append("\n"); 
		query.append("              ,B1.PA_CM_COST" ).append("\n"); 
		query.append("              ,B1.RA_CM_COST" ).append("\n"); 
		query.append("        FROM (      " ).append("\n"); 
		query.append("                SELECT A1.TRD_CD" ).append("\n"); 
		query.append("                      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                      ,A1.DIR_CD" ).append("\n"); 
		query.append("                      ,A1.CTRT_RHQ_OFC" ).append("\n"); 
		query.append("                      ,A1.CTRT_RGN_OFC" ).append("\n"); 
		query.append("                      ,A1.SLS_RHQ_OFC" ).append("\n"); 
		query.append("                      ,A1.SLS_RGN_OFC" ).append("\n"); 
		query.append("                      ,A1.COST_YRMON" ).append("\n"); 
		query.append("                      ,A1.COST_WK" ).append("\n"); 
		query.append("                      ,SUM(A1.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("                      ,SUM(A1.GRS_RPB_REV) AS GRS_RPB_REV" ).append("\n"); 
		query.append("                      ,SUM(A1.RA_CM_COST_TTL_AMT) AS PA_CM_COST" ).append("\n"); 
		query.append("                      ,SUM(A1.PA_CM_COST_TTL_AMT) AS RA_CM_COST" ).append("\n"); 
		query.append("                FROM (      " ).append("\n"); 
		query.append("                        SELECT TRD_CD" ).append("\n"); 
		query.append("                            ,SUB_TRD_CD" ).append("\n"); 
		query.append("                            ,RLANE_CD" ).append("\n"); 
		query.append("                            ,DIR_CD" ).append("\n"); 
		query.append("                            ,NVL((SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD), " ).append("\n"); 
		query.append("                                 (SELECT RHQ_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = CTRT_OFC_CD)) AS CTRT_RHQ_OFC" ).append("\n"); 
		query.append("                            ,CASE WHEN    CTRT_OFC_CD = 'NYCRA'" ).append("\n"); 
		query.append("                                       OR CTRT_OFC_CD = 'HAMRU'" ).append("\n"); 
		query.append("                                       OR CTRT_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("                                       OR CTRT_OFC_CD = 'SHARC' THEN SUBSTR(CTRT_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("                                                                ELSE NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD)," ).append("\n"); 
		query.append("                                                                         (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = CTRT_OFC_CD))" ).append("\n"); 
		query.append("                              END AS CTRT_RGN_OFC" ).append("\n"); 
		query.append("                            ,NVL((SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)," ).append("\n"); 
		query.append("                                 (SELECT RHQ_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD)) AS SLS_RHQ_OFC" ).append("\n"); 
		query.append("                            ,CASE WHEN    SLS_OFC_CD = 'NYCRA'" ).append("\n"); 
		query.append("                                       OR SLS_OFC_CD = 'HAMRU'" ).append("\n"); 
		query.append("                                       OR SLS_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("                                       OR SLS_OFC_CD = 'SHARC' THEN SUBSTR(SLS_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("                                                               ELSE NVL((SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)," ).append("\n"); 
		query.append("                                                                        (SELECT RGN_OFC_CD FROM SQM_QTA_OFC WHERE RGN_OFC_CD = SLS_OFC_CD))" ).append("\n"); 
		query.append("                              END AS SLS_RGN_OFC" ).append("\n"); 
		query.append("                            ,COST_WK" ).append("\n"); 
		query.append("                            ,COST_YRMON" ).append("\n"); 
		query.append("                            ,DECODE(SUBSTR(CNTR_TPSZ_CD, -1), '2', BKG_QTY, BKG_QTY * 2) AS LOD_QTY" ).append("\n"); 
		query.append("                            ,NVL(BKG_REV, 0) + NVL(BKG_OFT_REV, 0) + NVL(BKG_MISC_REV, 0) + NVL(SCR_CHG_REV, 0) AS GRS_RPB_REV" ).append("\n"); 
		query.append("                            ,(RA_CM_COST_TTL_AMT - DMDT_COM_AMT) AS RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                            ,(PA_CM_COST_TTL_AMT - DMDT_COM_AMT) AS PA_CM_COST_TTL_AMT " ).append("\n"); 
		query.append("                        FROM MAS_BKG_EXPN_DTL_WK" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_bse_wk} != '' && ${f_bse_wk} != 'All')" ).append("\n"); 
		query.append("                         AND SUBSTR(SLS_YRMON, 1, 4)||COST_WK = @[f_bse_yr]||@[f_bse_wk]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                         AND SUBSTR(SLS_YRMON, 1, 4)||COST_WK BETWEEN @[f_bse_yr]||@[f_fm_wk] AND @[f_bse_yr]||@[f_to_wk]" ).append("\n"); 
		query.append("#end                         " ).append("\n"); 
		query.append("						 AND DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                         AND BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("                         AND BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                         AND BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("                         AND RLANE_CD      = 'RBCCO'" ).append("\n"); 
		query.append("                       ) A1   " ).append("\n"); 
		query.append("                GROUP BY  A1.TRD_CD" ).append("\n"); 
		query.append("                      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                      ,A1.DIR_CD" ).append("\n"); 
		query.append("                      ,A1.CTRT_RHQ_OFC" ).append("\n"); 
		query.append("                      ,A1.CTRT_RGN_OFC" ).append("\n"); 
		query.append("                      ,A1.SLS_RHQ_OFC" ).append("\n"); 
		query.append("                      ,A1.SLS_RGN_OFC" ).append("\n"); 
		query.append("                      ,A1.COST_YRMON" ).append("\n"); 
		query.append("                      ,A1.COST_WK" ).append("\n"); 
		query.append("                ) B1, COM_CPY_NO  B2" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND B2.CPY_NO        < 2" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    ) C1, SQM_QTA_LANE_OFC C2" ).append("\n"); 
		query.append("WHERE 1=1    " ).append("\n"); 
		query.append("AND C2.BSE_TP_CD = 'Q'" ).append("\n"); 
		query.append("AND C2.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("AND C2.BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("AND C2.OFC_VW_CD = SUBSTR(C1.OFC_VW_CD,0,1)" ).append("\n"); 
		query.append("AND C2.SUB_TRD_CD = C1.SUB_TRD_CD" ).append("\n"); 
		query.append("AND C2.RLANE_CD = C1.RLANE_CD" ).append("\n"); 
		query.append("AND C2.DIR_CD = C1.DIR_CD" ).append("\n"); 
		query.append("AND C2.RHQ_CD = C1.RHQ_CD" ).append("\n"); 
		query.append("AND C2.RGN_OFC_CD = C1.RGN_OFC_CD" ).append("\n"); 
		query.append("AND C2.SQM_ACT_FLG = 'Y'    " ).append("\n"); 
		query.append("ORDER BY TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD,COST_WK, OFC_VW_CD, RHQ_CD, RGN_OFC_CD" ).append("\n"); 

	}
}