/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaSetupForIsaSecByHoSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.29 
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

public class PlanningDBDAOSearchQtaSetupForIsaSecByHoSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QTA Set Up for IAS Sector by Head Office_Summary를 조회한다.
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2016.02.25 최성민 [CHM-201640194] QTA Set up by Head Office for IAS Sector_Summary VVD 중복 계산 관련 로직 수정
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaSetupForIsaSecByHoSummaryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_vw_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaSetupForIsaSecByHoSummaryRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       C1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,C1.BSE_YR" ).append("\n"); 
		query.append("      ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID  = 'CD00940'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = C1.OFC_VW_CD) OFC_VW_CD" ).append("\n"); 
		query.append("      ,C1.RLANE_CD" ).append("\n"); 
		query.append("      ,C1.DIR_CD" ).append("\n"); 
		query.append("      ,C4.BSE_MON" ).append("\n"); 
		query.append("      ,C4.VVD_CNT" ).append("\n"); 
		query.append("      ,C4.TOT_BSA_CAPA" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD03218'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = C5.IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("      ,C1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,DECODE(C5.HUL_BND_CD, 'HH', 'H/H', 'BH', 'B/H') HUL_BND_CD" ).append("\n"); 
		query.append("      ,C1.TRD_CD" ).append("\n"); 
		query.append("      ,C1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("    --  ,SUM(C2.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("      ,DECODE(SUM(C2.LOD_QTY),0,0, SUM(C2.LOD_QTY) * C4.VVD_CNT) AS LOD_QTY" ).append("\n"); 
		query.append("      ,DECODE(SUM(C2.LOD_QTY),0,0, SUM(C2.LOD_QTY * C2.GRS_RPB_REV) /SUM(C2.LOD_QTY)) AS REV_RPB" ).append("\n"); 
		query.append("      ,SUM(C2.LOD_QTY * C2.GRS_RPB_REV) * C4.VVD_CNT AS GRS_REV" ).append("\n"); 
		query.append("  FROM SQM_SCTR_LANE_OFC  C1" ).append("\n"); 
		query.append("      ,SQM_SCTR_LOD_REV   C2" ).append("\n"); 
		query.append("      ,SQM_SCTR_PAIR_COST C3" ).append("\n"); 
		query.append("      ,(" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("               B1.BSE_TP_CD" ).append("\n"); 
		query.append("              ,B1.BSE_YR" ).append("\n"); 
		query.append("              ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("              ,B1.TRD_CD" ).append("\n"); 
		query.append("              ,B1.RLANE_CD" ).append("\n"); 
		query.append("              ,B1.DIR_CD" ).append("\n"); 
		query.append("              ,B1.VVD_CNT" ).append("\n"); 
		query.append("              ,B1.TOT_BSA_CAPA" ).append("\n"); 
		query.append("              ,B1.BSE_MON" ).append("\n"); 
		query.append("              ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("              ,MAX(B2.RANGE_BSA)+9 AS BSA_CAPA --차이가 0~9 사이일 경우 큰 BSA를 대표로 그룹핑한다." ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("                      ,A1.BSE_YR" ).append("\n"); 
		query.append("                      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                      ,A1.TRD_CD" ).append("\n"); 
		query.append("                      ,A1.RLANE_CD" ).append("\n"); 
		query.append("                      ,A1.DIR_CD" ).append("\n"); 
		query.append("                      ,COUNT(A1.BSE_MON) OVER(PARTITION BY A1.RLANE_CD,A1.DIR_CD,A1.BSE_MON) AS VVD_CNT" ).append("\n"); 
		query.append("                      ,SUM(A1.FNL_BSA_CAPA) OVER(PARTITION BY A1.RLANE_CD,A1.DIR_CD,A1.BSE_MON) AS TOT_BSA_CAPA" ).append("\n"); 
		query.append("                      ,A1.BSE_MON" ).append("\n"); 
		query.append("                      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("                      ,A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("                  FROM SQM_QTA_TGT_VVD A1" ).append("\n"); 
		query.append("                      ,SQM_SCTR_PF_GRP A2" ).append("\n"); 
		query.append("                 WHERE A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                   AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                   AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                   AND A1.TRD_CD       = 'IAS'" ).append("\n"); 
		query.append("                   AND A1.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                   AND A1.RLANE_CD     IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                   AND A1.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("                   AND A1.SUB_TRD_CD   = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                   AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("                   AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("                   AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("                   AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("                   AND A1.PF_SVC_TP_CD = A2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                   AND A1.FNL_BSA_CAPA <> 0" ).append("\n"); 
		query.append("                 ORDER BY A1.DIR_CD, A1.RLANE_CD, A1.BSE_MON" ).append("\n"); 
		query.append("               ) B1" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT DISTINCT RLANE_CD, DIR_CD, FNL_BSA_CAPA, FNL_BSA_CAPA - 9 AS RANGE_BSA" ).append("\n"); 
		query.append("                  FROM SQM_QTA_TGT_VVD" ).append("\n"); 
		query.append("                 WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                   AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                   AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                   AND TRD_CD     = 'IAS'" ).append("\n"); 
		query.append("                   AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                   AND FNL_BSA_CAPA <> 0" ).append("\n"); 
		query.append("                 ORDER BY DIR_CD, RLANE_CD, FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("               ) B2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND B1.DIR_CD        = B2.DIR_CD" ).append("\n"); 
		query.append("           AND B1.RLANE_CD      = B2.RLANE_CD" ).append("\n"); 
		query.append("           AND B1.FNL_BSA_CAPA >= B2.RANGE_BSA" ).append("\n"); 
		query.append("         GROUP BY B1.BSE_TP_CD" ).append("\n"); 
		query.append("                 ,B1.BSE_YR" ).append("\n"); 
		query.append("                 ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("                 ,B1.TRD_CD" ).append("\n"); 
		query.append("                 ,B1.RLANE_CD" ).append("\n"); 
		query.append("                 ,B1.DIR_CD" ).append("\n"); 
		query.append("                 ,B1.VVD_CNT" ).append("\n"); 
		query.append("                 ,B1.TOT_BSA_CAPA" ).append("\n"); 
		query.append("                 ,B1.BSE_MON" ).append("\n"); 
		query.append("                 ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("                 ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("         ORDER BY B1.DIR_CD, B1.RLANE_CD,B1.FNL_BSA_CAPA DESC, B1.BSE_MON       " ).append("\n"); 
		query.append("       )    C4" ).append("\n"); 
		query.append("     ,MAS_LANE_RGST C5" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND C1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND C1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND C1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd]) " ).append("\n"); 
		query.append("   AND C1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND C1.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND C1.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND C1.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND C1.RLANE_CD    IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND C1.DIR_CD      = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND C1.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("   AND C5.IAS_RGN_CD  = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("   AND C5.HUL_BND_CD  = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND C1.BSE_TP_CD   = C2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND C1.BSE_YR      = C2.BSE_YR" ).append("\n"); 
		query.append("   AND C1.BSE_QTR_CD  = C2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND C1.OFC_VW_CD   = C2.OFC_VW_CD" ).append("\n"); 
		query.append("   AND C1.RLANE_CD    = C2.RLANE_CD" ).append("\n"); 
		query.append("   AND C1.DIR_CD      = C2.DIR_CD" ).append("\n"); 
		query.append("   AND C1.PF_GRP_CD   = C2.PF_GRP_CD" ).append("\n"); 
		query.append("   AND C1.RGN_OFC_CD  = C2.RGN_OFC_CD" ).append("\n"); 
		query.append("   AND C1.POL_CD      = C2.POL_CD" ).append("\n"); 
		query.append("   AND C1.POD_CD      = C2.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND C1.BSE_TP_CD   = C3.BSE_TP_CD" ).append("\n"); 
		query.append("   AND C1.BSE_YR      = C3.BSE_YR" ).append("\n"); 
		query.append("   AND C1.BSE_QTR_CD  = C3.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND C1.RLANE_CD    = C3.RLANE_CD" ).append("\n"); 
		query.append("   AND C1.DIR_CD      = C3.DIR_CD" ).append("\n"); 
		query.append("   AND C1.POL_CD      = C3.POL_CD" ).append("\n"); 
		query.append("   AND C1.POD_CD      = C3.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND C2.BSE_TP_CD    = C4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND C2.BSE_YR       = C4.BSE_YR" ).append("\n"); 
		query.append("   AND C2.BSE_QTR_CD   = C4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND C2.TRD_CD       = C4.TRD_CD" ).append("\n"); 
		query.append("   AND C2.RLANE_CD     = C4.RLANE_CD" ).append("\n"); 
		query.append("   AND C2.DIR_CD       = C4.DIR_CD" ).append("\n"); 
		query.append("   AND C2.FNL_BSA_CAPA = C4.BSA_CAPA" ).append("\n"); 
		query.append("   AND C4.BSA_CAPA    <> 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND C1.TRD_CD       = C5.TRD_CD" ).append("\n"); 
		query.append("   AND C1.SUB_TRD_CD   = C5.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND C1.RLANE_CD     = C5.RLANE_CD" ).append("\n"); 
		query.append("   AND C1.DIR_CD       = C5.DIR_CD  " ).append("\n"); 
		query.append("   AND C5.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("GROUP BY C1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,C1.BSE_YR" ).append("\n"); 
		query.append("      ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,C1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,C1.RLANE_CD" ).append("\n"); 
		query.append("      ,C1.DIR_CD" ).append("\n"); 
		query.append("      ,C4.BSE_MON" ).append("\n"); 
		query.append("      ,C4.VVD_CNT" ).append("\n"); 
		query.append("      ,C4.TOT_BSA_CAPA" ).append("\n"); 
		query.append("      ,C5.IAS_RGN_CD" ).append("\n"); 
		query.append("      ,C1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,C5.HUL_BND_CD" ).append("\n"); 
		query.append("      ,C1.TRD_CD" ).append("\n"); 
		query.append("      ,C1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,C1.RHQ_CD" ).append("\n"); 
		query.append("ORDER BY RLANE_CD,DIR_CD,BSE_MON,RHQ_CD,RGN_OFC_CD,HUL_BND_CD" ).append("\n"); 

	}
}