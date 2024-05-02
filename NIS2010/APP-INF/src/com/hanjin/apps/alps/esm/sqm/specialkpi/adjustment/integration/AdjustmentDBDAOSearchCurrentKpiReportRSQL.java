/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AdjustmentDBDAOSearchCurrentKpiReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AdjustmentDBDAOSearchCurrentKpiReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCurrentKpiReport
	  * 
	  * * 2014.11.14 [CHM-201432523] Quarterly와 Yearly,Currently Updated 데이터 차이나는것 수정
	  *                      (MIN_TP_CD를 BSE_YR, BSE_QTR_CD 기준으로 가져오도록 BSE_TP_CD삭제, FNL_BSA_CAPA를 BSE_TP_CD기준으로 가져오도록 추가)
	  * * 2014.11.11 [CHM-201432524] Current KPI Report 화면 내 Trade Direction 조건 추가
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2015.11.20 김용습 [CHM-201538493] [CSR 전환건] Current KPI Report 화면 보완 (조회 조건 Week → Month 변경, Raw Data Export 버튼 추가)
	  * </pre>
	  */
	public AdjustmentDBDAOSearchCurrentKpiReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_spcl_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_conv_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration").append("\n"); 
		query.append("FileName : AdjustmentDBDAOSearchCurrentKpiReportRSQL").append("\n"); 
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
		query.append("SELECT BSE_TP_CD" ).append("\n"); 
		query.append(",BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",RGN_OFC_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",CONV_DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",BSE_MON" ).append("\n"); 
		query.append(",BSE_WK" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append(",SUM(FNL_BSA_CAPA) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append(",SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append(",SUM(GREV) AS GREV" ).append("\n"); 
		query.append(",ROUND(DECODE(SUM(LOD_QTY), 0, 0, SUM(GREV)/SUM(LOD_QTY)), 0) AS GRPB" ).append("\n"); 
		query.append(",DECODE(SUM(LOD_QTY), 0, 0, SUM(GREV)/SUM(LOD_QTY)) AS GRPB_DECIMAL" ).append("\n"); 
		query.append(",SUM(PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append(",SUM(RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append(",ROUND(DECODE(SUM(LOD_QTY), 0, 0, SUM(PA_CM_COST)/SUM(LOD_QTY)),0) AS PA_CMCB" ).append("\n"); 
		query.append(",ROUND(DECODE(SUM(LOD_QTY), 0, 0, SUM(RA_CM_COST)/SUM(LOD_QTY)),0) AS RA_CMCB" ).append("\n"); 
		query.append(",SUM(GREV) - SUM(PA_CM_COST) AS PA_CM" ).append("\n"); 
		query.append(",SUM(GREV) - SUM(RA_CM_COST) AS RA_CM" ).append("\n"); 
		query.append(",ROUND(DECODE(SUM(LOD_QTY), 0, 0, (SUM(GREV) - SUM(PA_CM_COST))/SUM(LOD_QTY)),0) AS PA_CMPB" ).append("\n"); 
		query.append(",ROUND(DECODE(SUM(LOD_QTY), 0, 0, (SUM(GREV) - SUM(RA_CM_COST))/SUM(LOD_QTY)),0) AS RA_CMPB" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT B1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,B1.BSE_YR" ).append("\n"); 
		query.append("--      ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,VVD_QUARTER AS BSE_QTR_CD" ).append("\n"); 
		query.append("      ,B1.RHQ_CD" ).append("\n"); 
		query.append("      ,B1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,B1.TRD_CD" ).append("\n"); 
		query.append("      ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,B1.RLANE_CD" ).append("\n"); 
		query.append("      ,B1.DIR_CD" ).append("\n"); 
		query.append("      ,B1.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(B1.HUL_BND_CD, 'HH', 'H/H', 'BH', 'B/H') HUL_BND_CD" ).append("\n"); 
		query.append("      ,B1.BSE_MON" ).append("\n"); 
		query.append("      ,B1.BSE_WK" ).append("\n"); 
		query.append("      ,B1.VVD" ).append("\n"); 
		query.append("      ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,SUM(B1.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("      ,SUM(B1.GREV) AS GREV" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(B1.LOD_QTY), 0, 0, SUM(B1.GREV)/SUM(B1.LOD_QTY)), 0) AS GRPB" ).append("\n"); 
		query.append("      ,DECODE(SUM(B1.LOD_QTY), 0, 0, SUM(B1.GREV)/SUM(B1.LOD_QTY)) AS GRPB_DECIMAL" ).append("\n"); 
		query.append("      ,SUM(B1.PA_CM_COST) AS PA_CM_COST" ).append("\n"); 
		query.append("      ,SUM(B1.RA_CM_COST) AS RA_CM_COST" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(B1.LOD_QTY), 0, 0, SUM(B1.PA_CM_COST)/SUM(B1.LOD_QTY)),0) AS PA_CMCB" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(B1.LOD_QTY), 0, 0, SUM(B1.RA_CM_COST)/SUM(B1.LOD_QTY)),0) AS RA_CMCB" ).append("\n"); 
		query.append("      ,SUM(B1.GREV) - SUM(B1.PA_CM_COST) AS PA_CM" ).append("\n"); 
		query.append("      ,SUM(B1.GREV) - SUM(B1.RA_CM_COST) AS RA_CM" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(B1.LOD_QTY), 0, 0, (SUM(B1.GREV) - SUM(B1.PA_CM_COST))/SUM(B1.LOD_QTY)),0) AS PA_CMPB" ).append("\n"); 
		query.append("      ,ROUND(DECODE(SUM(B1.LOD_QTY), 0, 0, (SUM(B1.GREV) - SUM(B1.RA_CM_COST))/SUM(B1.LOD_QTY)),0) AS RA_CMPB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("              ,MIN(A1.BSE_TP_CD) OVER(PARTITION BY A1.BSE_YR, A1.BSE_QTR_CD) MIN_TP_CD" ).append("\n"); 
		query.append("              ,A1.BSE_YR" ).append("\n"); 
		query.append("              ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("#if(${f_ofc_lvl} == '01')" ).append("\n"); 
		query.append("              ,'' AS RHQ_CD" ).append("\n"); 
		query.append("#elseif(${f_ofc_lvl} == '02' || ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("              ,A2.RHQ_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ofc_lvl} == '01' || ${f_ofc_lvl} == '02')" ).append("\n"); 
		query.append("              ,'' AS RGN_OFC_CD" ).append("\n"); 
		query.append("#elseif(${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("              ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,A2.TRD_CD" ).append("\n"); 
		query.append("              ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("              ,A2.RLANE_CD" ).append("\n"); 
		query.append("              ,A2.DIR_CD" ).append("\n"); 
		query.append("              ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("              ,A3.HUL_BND_CD" ).append("\n"); 
		query.append("              ,A1.BSE_MON" ).append("\n"); 
		query.append("              ,CASE WHEN A1.BSE_MON = '01' THEN '1Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '02' THEN '1Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '03' THEN '1Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '04' THEN '2Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '05' THEN '2Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '06' THEN '2Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '07' THEN '3Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '08' THEN '3Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '09' THEN '3Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '10' THEN '4Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '11' THEN '4Q'" ).append("\n"); 
		query.append("                WHEN A1.BSE_MON = '12' THEN '4Q' END AS VVD_QUARTER" ).append("\n"); 
		query.append("#if(${f_chk_week} != 'W')" ).append("\n"); 
		query.append("              ,'' AS BSE_WK" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              ,A1.BSE_WK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_chk_vvd} != 'V')" ).append("\n"); 
		query.append("              ,'' AS VVD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              ,A2.VSL_CD || A2.SKD_VOY_NO || A2.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_chk_week} == 'W' && ${f_chk_vvd} == 'V')" ).append("\n"); 
		query.append("              ,SUM(A1.FNL_BSA_CAPA) OVER(PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.TRD_CD, A1.SUB_TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.BSE_MON, A2.RGN_OFC_CD, A1.BSE_WK, A2.VSL_CD || A2.SKD_VOY_NO || A2.SKD_DIR_CD) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("#elseif(${f_chk_week} != 'W' && ${f_chk_vvd} == 'V')" ).append("\n"); 
		query.append("              ,SUM(A1.FNL_BSA_CAPA) OVER(PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.TRD_CD, A1.SUB_TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.BSE_MON, A2.RGN_OFC_CD, A2.VSL_CD || A2.SKD_VOY_NO || A2.SKD_DIR_CD) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("#elseif(${f_chk_week} == 'W' && ${f_chk_vvd} != 'V')" ).append("\n"); 
		query.append("              ,SUM(A1.FNL_BSA_CAPA) OVER(PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.TRD_CD, A1.SUB_TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.BSE_MON, A2.RGN_OFC_CD, A1.BSE_WK) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              ,SUM(A1.FNL_BSA_CAPA) OVER(PARTITION BY A1.BSE_TP_CD, A1.BSE_YR, A1.BSE_QTR_CD, A1.TRD_CD, A1.SUB_TRD_CD, A1.RLANE_CD, A1.DIR_CD, A1.BSE_MON, A2.RGN_OFC_CD) AS FNL_BSA_CAPA" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,A2.LOD_QTY" ).append("\n"); 
		query.append("              ,A2.LOD_QTY * ROUND(A2.GRS_RPB_REV, 0) AS GREV" ).append("\n"); 
		query.append("              ,A2.LOD_QTY * ROUND(A2.PA_CM_UC_AMT, 0) AS PA_CM_COST" ).append("\n"); 
		query.append("              ,A2.LOD_QTY * ROUND(A2.RA_CM_UC_AMT, 0) AS RA_CM_COST" ).append("\n"); 
		query.append("          FROM SQM_SPCL_TGT_VVD A1" ).append("\n"); 
		query.append("              ,SQM_SPCL_CFM_QTA A2" ).append("\n"); 
		query.append("              ,MAS_LANE_RGST A3" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A1.BSE_TP_CD   = A2.BSE_TP_CD" ).append("\n"); 
		query.append("           AND A1.BSE_YR      = A2.BSE_YR" ).append("\n"); 
		query.append("           AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("           AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.DIR_CD      = A2.DIR_CD" ).append("\n"); 
		query.append("           AND A1.VSL_CD      = A2.VSL_CD" ).append("\n"); 
		query.append("           AND A1.SKD_VOY_NO  = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND A1.SKD_DIR_CD  = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A1.TRD_CD      = A3.TRD_CD" ).append("\n"); 
		query.append("           AND A1.SUB_TRD_CD  = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD    = A3.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.DIR_CD      = A3.DIR_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_bse_tp_cd} == 'Q')" ).append("\n"); 
		query.append("           AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("#elseif(${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("           --BSE_TP_CD 가 Y면 F_YEAR_TP_CD 검사" ).append("\n"); 
		query.append("           AND A1.BSE_TP_CD   = DECODE(@[f_year_tp_cd], 'I', 'Y', 'C', A1.BSE_TP_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND A2.SPCL_TGT_CD = @[f_spcl_tgt_cd]" ).append("\n"); 
		query.append("#if(${f_fm_mon} != '' && ${f_to_mon} != '')" ).append("\n"); 
		query.append("           AND A1.BSE_MON     BETWEEN @[f_fm_mon] AND @[f_to_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_fm_wk} != '' && ${f_to_wk} != '')" ).append("\n"); 
		query.append("           AND A1.BSE_WK      BETWEEN @[f_fm_wk] AND @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("           AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("           AND A1.RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_trd_dir} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("           AND A2.CONV_DIR_CD = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("		   AND A3.HUL_BND_CD  = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${f_ofc_lvl} == '02' || ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("#if(${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("           AND A2.RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("#if(${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("           AND A2.RGN_OFC_CD  = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) B1" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND B1.BSE_TP_CD = B1.MIN_TP_CD" ).append("\n"); 
		query.append("   #if(${f_bse_qtr_cd} != 'All')" ).append("\n"); 
		query.append("   AND VVD_QUARTER  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY B1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,B1.BSE_YR" ).append("\n"); 
		query.append("--      ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,VVD_QUARTER" ).append("\n"); 
		query.append("      ,B1.RHQ_CD" ).append("\n"); 
		query.append("      ,B1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,B1.TRD_CD" ).append("\n"); 
		query.append("      ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,B1.RLANE_CD" ).append("\n"); 
		query.append("      ,B1.DIR_CD" ).append("\n"); 
		query.append("      ,B1.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,B1.HUL_BND_CD" ).append("\n"); 
		query.append("      ,B1.BSE_MON" ).append("\n"); 
		query.append("      ,B1.BSE_WK" ).append("\n"); 
		query.append("      ,B1.VVD" ).append("\n"); 
		query.append("      ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append(" ORDER BY B1.BSE_YR" ).append("\n"); 
		query.append("--      ,B1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,VVD_QUARTER" ).append("\n"); 
		query.append("#if(${f_ofc_lvl} == '02' || ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("      ,B1.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append("      ,B1.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,B1.TRD_CD" ).append("\n"); 
		query.append("      ,B1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,B1.RLANE_CD" ).append("\n"); 
		query.append("      ,B1.DIR_CD" ).append("\n"); 
		query.append("      ,B1.BSE_MON" ).append("\n"); 
		query.append("	  ,B1.BSE_WK" ).append("\n"); 
		query.append("      ,B1.FNL_BSA_CAPA" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY BSE_TP_CD" ).append("\n"); 
		query.append(",BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append(",RGN_OFC_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",CONV_DIR_CD" ).append("\n"); 
		query.append(",HUL_BND_CD" ).append("\n"); 
		query.append(",BSE_MON" ).append("\n"); 
		query.append(",BSE_WK" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append("--,FNL_BSA_CAPA" ).append("\n"); 
		query.append(" ORDER BY BSE_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append("#if(${f_ofc_lvl} == '02' || ${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append(",RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${f_ofc_lvl} == '03')" ).append("\n"); 
		query.append(",RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",SUB_TRD_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",BSE_MON" ).append("\n"); 
		query.append(",BSE_WK" ).append("\n"); 
		query.append(",FNL_BSA_CAPA" ).append("\n"); 

	}
}