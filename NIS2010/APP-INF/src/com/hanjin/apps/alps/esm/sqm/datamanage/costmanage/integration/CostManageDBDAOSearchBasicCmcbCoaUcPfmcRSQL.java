/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CostManageDBDAOSearchBasicCmcbCoaUcPfmcRSQL.java
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

public class CostManageDBDAOSearchBasicCmcbCoaUcPfmcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic CMCB_COA UC PFMC List를 조회한다.
	  * 
	  * 2014.06.30 PEJ 쿼리튜닝(NO_MERGE 힌트 추가) 
	  * 2015.02.12 이혜민 [CHM-201533940] Sector CMCB 화면 내 COA UC PFMC 팝업 조회로직 변경
	  *                                                       sctr_lane_ofc내 act_flg 조건 삭제 (active 상관없이 Pol-Pod Active 기준으로)
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2015.07.17 김용습 [CHM-201536875] [CSR 전환건] SQM의 CM Cost 산출 및 조회 로직 보완
	  * 2015.08.20 김용습 [CHM-201536994] Split24-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청
	  * 2016.01.07 SUBSTR(CNTR_TPSZ_CD, -1), 2 -> SUBSTR(CNTR_TPSZ_CD, -1), '2'로 변경
	  * </pre>
	  */
	public CostManageDBDAOSearchBasicCmcbCoaUcPfmcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_fm_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration").append("\n"); 
		query.append("FileName : CostManageDBDAOSearchBasicCmcbCoaUcPfmcRSQL").append("\n"); 
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
		query.append("WITH MAS_DATA AS" ).append("\n"); 
		query.append("(SELECT BSE_TP_CD" ).append("\n"); 
		query.append("      ,BSE_YR" ).append("\n"); 
		query.append("      ,BSE_QTR_CD" ).append("\n"); 
		query.append("      ,OFC_VW_CD" ).append("\n"); 
		query.append("      ,RLANE_CD" ).append("\n"); 
		query.append("      ,DIR_CD" ).append("\n"); 
		query.append("      ,TRD_CD" ).append("\n"); 
		query.append("      ,SUB_TRD_CD" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("--      ,SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("--      ,SUM(REV)     AS REV" ).append("\n"); 
		query.append("--      ,SUM(PA_CM_COST_TTL_AMT) AS PA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("--      ,SUM(RA_CM_COST_TTL_AMT) AS RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(NVL(LOD_QTY,0)), 0, 0, SUM(NVL(PA_CM_COST_TTL_AMT,0))/SUM(NVL(LOD_QTY,0)))) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(NVL(LOD_QTY,0)), 0, 0, SUM(NVL(RA_CM_COST_TTL_AMT,0))/SUM(NVL(LOD_QTY,0)))) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,POD_CALL_SEQ" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B2.BSE_TP_CD" ).append("\n"); 
		query.append("              ,B2.BSE_YR" ).append("\n"); 
		query.append("              ,B2.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,B2.OFC_VW_CD" ).append("\n"); 
		query.append("              ,B2.TRD_CD" ).append("\n"); 
		query.append("              ,B2.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,B2.RLANE_CD" ).append("\n"); 
		query.append("              ,B2.DIR_CD" ).append("\n"); 
		query.append("              ,B1.CTRT_RGN_OFC" ).append("\n"); 
		query.append("              ,B1.SLS_RGN_OFC" ).append("\n"); 
		query.append("              ,B1.CTRT_OFC_CD" ).append("\n"); 
		query.append("              ,B1.SLS_OFC_CD" ).append("\n"); 
		query.append("              ,B1.VVD" ).append("\n"); 
		query.append("              ,B2.POL_CD" ).append("\n"); 
		query.append("              ,B2.POD_CD" ).append("\n"); 
		query.append("              ,B1.LOD_QTY" ).append("\n"); 
		query.append("              ,B1.REV" ).append("\n"); 
		query.append("              ,B1.RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("              ,B1.PA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("              ,B2.POL_CALL_SEQ" ).append("\n"); 
		query.append("              ,B2.POD_CALL_SEQ" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                  SELECT /*+ NO_MERGE */ " ).append("\n"); 
		query.append("                         TRD_CD" ).append("\n"); 
		query.append("                        ,SUB_TRD_CD" ).append("\n"); 
		query.append("                        ,RLANE_CD" ).append("\n"); 
		query.append("                        ,DIR_CD" ).append("\n"); 
		query.append("                        ,(SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD) CTRT_RHQ_OFC" ).append("\n"); 
		query.append("                        ,CASE WHEN    CTRT_OFC_CD = 'NYCRA'" ).append("\n"); 
		query.append("                                   OR CTRT_OFC_CD = 'HAMRU'" ).append("\n"); 
		query.append("                                   OR CTRT_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("                                   OR CTRT_OFC_CD = 'SHARC' THEN SUBSTR(CTRT_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("                                                            ELSE (SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = CTRT_OFC_CD)" ).append("\n"); 
		query.append("                          END AS CTRT_RGN_OFC" ).append("\n"); 
		query.append("                        ,(SELECT N2ND_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD) SLS_RHQ_OFC" ).append("\n"); 
		query.append("                        ,CASE WHEN    SLS_OFC_CD = 'NYCRA'" ).append("\n"); 
		query.append("                                   OR SLS_OFC_CD = 'HAMRU'" ).append("\n"); 
		query.append("                                   OR SLS_OFC_CD = 'SINRS'" ).append("\n"); 
		query.append("                                   OR SLS_OFC_CD = 'SHARC' THEN SUBSTR(SLS_OFC_CD, 1, 3)||'SC'" ).append("\n"); 
		query.append("                                                           ELSE (SELECT N4TH_PRNT_OFC_CD FROM SQM_ORGANIZATION_V WHERE OFC_CD = SLS_OFC_CD)" ).append("\n"); 
		query.append("                          END AS SLS_RGN_OFC" ).append("\n"); 
		query.append("                        ,CTRT_OFC_CD" ).append("\n"); 
		query.append("                        ,SLS_OFC_CD" ).append("\n"); 
		query.append("                        ,COST_WK" ).append("\n"); 
		query.append("                        ,VSL_CD||SKD_VOY_NO||DIR_CD AS VVD" ).append("\n"); 
		query.append("                        ,DECODE(SUBSTR(CNTR_TPSZ_CD, -1), '2', BKG_QTY, BKG_QTY * 2) AS LOD_QTY" ).append("\n"); 
		query.append("                        ,NVL(BKG_REV, 0) + NVL(BKG_OFT_REV, 0) + NVL(BKG_MISC_REV, 0) + NVL(SCR_CHG_REV, 0) AS REV" ).append("\n"); 
		query.append("                        ,BKG_POL_CD" ).append("\n"); 
		query.append("                        ,BKG_POD_CD" ).append("\n"); 
		query.append("                        ,(RA_CM_COST_TTL_AMT - DMDT_COM_AMT) AS RA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                        ,(PA_CM_COST_TTL_AMT - DMDT_COM_AMT) AS PA_CM_COST_TTL_AMT" ).append("\n"); 
		query.append("                    FROM MAS_BKG_EXPN_DTL_WK" ).append("\n"); 
		query.append("                   WHERE SUBSTR(SLS_YRMON, 1, 4)||COST_WK BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("                     AND DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                     AND BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("                     AND BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                     AND BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("                     AND RLANE_CD      = @[f_rlane_cd]" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("              ,SQM_SCTR_LANE_OFC B2" ).append("\n"); 
		query.append("         WHERE B2.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("           AND B2.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("           AND B2.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("           AND B2.OFC_VW_CD = 'L'" ).append("\n"); 
		query.append("           AND B2.TRD_CD       = B1.TRD_CD" ).append("\n"); 
		query.append("           AND B2.SUB_TRD_CD   = B1.SUB_TRD_CD" ).append("\n"); 
		query.append("           AND B2.RLANE_CD     = B1.RLANE_CD" ).append("\n"); 
		query.append("           AND B2.DIR_CD       = B1.DIR_CD" ).append("\n"); 
		query.append("           AND B2.POL_CD       = B1.BKG_POL_CD" ).append("\n"); 
		query.append("           AND B2.POD_CD       = B1.BKG_POD_CD" ).append("\n"); 
		query.append("           AND B2.RGN_OFC_CD   = DECODE(B2.OFC_VW_CD, 'C', B1.CTRT_RGN_OFC, 'L', B1.SLS_RGN_OFC)" ).append("\n"); 
		query.append("           AND B1.CTRT_RHQ_OFC IS NOT NULL" ).append("\n"); 
		query.append("           AND B1.SLS_RHQ_OFC  IS NOT NULL" ).append("\n"); 
		query.append("--           AND B2.SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" GROUP BY BSE_TP_CD" ).append("\n"); 
		query.append("         ,BSE_YR" ).append("\n"); 
		query.append("         ,BSE_QTR_CD" ).append("\n"); 
		query.append("         ,OFC_VW_CD" ).append("\n"); 
		query.append("         ,TRD_CD" ).append("\n"); 
		query.append("         ,SUB_TRD_CD" ).append("\n"); 
		query.append("         ,RLANE_CD" ).append("\n"); 
		query.append("         ,DIR_CD" ).append("\n"); 
		query.append("         ,POL_CD" ).append("\n"); 
		query.append("         ,POD_CD" ).append("\n"); 
		query.append("         ,POL_CALL_SEQ" ).append("\n"); 
		query.append("         ,POD_CALL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT A2.BSE_TP_CD" ).append("\n"); 
		query.append("       ,A2.BSE_YR" ).append("\n"); 
		query.append("       ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("       ,A2.TRD_CD" ).append("\n"); 
		query.append("       ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("       ,A2.RLANE_CD" ).append("\n"); 
		query.append("       ,A2.DIR_CD" ).append("\n"); 
		query.append("       ,A2.POL_CD" ).append("\n"); 
		query.append("       ,A2.POD_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD03218'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = A3.IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("       ,NVL(A1.PA_CM_UC_AMT, 0) AS MAS_PA_CM_UC_AMT" ).append("\n"); 
		query.append("       ,NVL(A1.RA_CM_UC_AMT, 0) AS MAS_RA_CM_UC_AMT" ).append("\n"); 
		query.append("       ,NVL(A2.PA_CM_UC_AMT, 0) - NVL(A1.PA_CM_UC_AMT, 0) AS PA_CM_UC_AMT" ).append("\n"); 
		query.append("       ,NVL(A2.RA_CM_UC_AMT, 0) - NVL(A1.RA_CM_UC_AMT, 0) AS RA_CM_UC_AMT" ).append("\n"); 
		query.append("       ,A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("       ,A1.POD_CALL_SEQ" ).append("\n"); 
		query.append("FROM MAS_DATA A1, SQM_SCTR_PAIR_COST A2, MAS_LANE_RGST A3" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A2.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A2.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A2.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("AND A2.SUB_TRD_CD   = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("AND A2.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("AND A2.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("AND A2.POL_CD       = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("AND A2.POD_CD       = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("AND A3.IAS_RGN_CD = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A2.TRD_CD = A3.TRD_CD" ).append("\n"); 
		query.append("AND A2.SUB_TRD_CD = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A2.RLANE_CD = A3.RLANE_CD" ).append("\n"); 
		query.append("AND A2.DIR_CD = A3.DIR_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD(+) = A2.DIR_CD" ).append("\n"); 
		query.append("AND A1.POL_CD(+) = A2.POL_CD" ).append("\n"); 
		query.append("AND A1.POD_CD(+) = A2.POD_CD" ).append("\n"); 
		query.append("ORDER BY A2.DIR_CD, A2.POL_CD, A2.POD_CD" ).append("\n"); 

	}
}