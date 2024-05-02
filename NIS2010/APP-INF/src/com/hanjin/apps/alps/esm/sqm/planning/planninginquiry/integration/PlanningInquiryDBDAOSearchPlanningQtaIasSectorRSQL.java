/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : PlanningInquiryDBDAOSearchPlanningQtaIasSectorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.29
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningInquiryDBDAOSearchPlanningQtaIasSectorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Planning QTA Inquiry for IAS Sector를 조회한다. Yearly, Quarterly 공통
	  * * History
	  * 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
	  * 2014.06.26 이혜민 CMCB에 Decode 추가
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2016.03.15 최성민 [CHM-201640194] QTA Set up by Head Office for IAS Sector_Summary VVD 중복 계산 관련 로직 수정
	  * </pre>
	  */
	public PlanningInquiryDBDAOSearchPlanningQtaIasSectorRSQL(){
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
		params.put("f_sqm_mn_sctr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ias_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.integration").append("\n"); 
		query.append("FileName : PlanningInquiryDBDAOSearchPlanningQtaIasSectorRSQL").append("\n"); 
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
		query.append("SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID  = 'CD00940'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = A1.OFC_VW_CD) OFC_VW_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD03218'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = A4.IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("      ,DECODE(A4.HUL_BND_CD, 'HH', 'H/H', 'BH', 'B/H') HUL_BND_CD" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, SUM(A1.LOD_QTY * A1.GRS_RPB_REV)/SUM(A1.LOD_QTY)) AS REV_RPB" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY * A1.GRS_RPB_REV) AS GRS_REV" ).append("\n"); 
		query.append("      ,SUM(A1.PA_CM_UC_AMT * A1.LOD_QTY) PA_CM_COST" ).append("\n"); 
		query.append("      ,SUM(A1.RA_CM_UC_AMT * A1.LOD_QTY) RA_CM_COST" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, (SUM(A1.PA_CM_UC_AMT * A1.LOD_QTY) / SUM(A1.LOD_QTY))) AS PA_CMCB" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, (SUM(A1.RA_CM_UC_AMT * A1.LOD_QTY) / SUM(A1.LOD_QTY))) AS RA_CMCB" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY * A1.GRS_RPB_REV) - SUM(A1.PA_CM_UC_AMT * A1.LOD_QTY) AS PA_CM" ).append("\n"); 
		query.append("      ,SUM(A1.LOD_QTY * A1.GRS_RPB_REV) - SUM(A1.RA_CM_UC_AMT * A1.LOD_QTY) AS RA_CM" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, (SUM(A1.LOD_QTY * A1.GRS_RPB_REV) - SUM(A1.PA_CM_UC_AMT*A1.LOD_QTY))/SUM(A1.LOD_QTY)) AS PA_CMPB" ).append("\n"); 
		query.append("      ,DECODE(SUM(A1.LOD_QTY),0,0, (SUM(A1.LOD_QTY * A1.GRS_RPB_REV) - SUM(A1.RA_CM_UC_AMT*A1.LOD_QTY))/SUM(A1.LOD_QTY)) AS RA_CMPB  " ).append("\n"); 
		query.append("--      ,A1.VSL_CD" ).append("\n"); 
		query.append("--      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("--      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')   " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '03') " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_pair} == 'Y')" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,DECODE(NVL(A2.SQM_MN_SCTR_FLG, 'N'), 'Y', 'Main', 'N', 'Sector') SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,A3.VVD_CNT" ).append("\n"); 
		query.append("      ,A3.TOT_BSA_CAPA" ).append("\n"); 
		query.append("      ,A3.BSE_MON" ).append("\n"); 
		query.append("FROM SQM_SCTR_CFM_QTA A1" ).append("\n"); 
		query.append("#if (${f_chk_pair} == 'Y')" ).append("\n"); 
		query.append("     ,SQM_SCTR_PAIR_MGMT A2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ,(SELECT BSE_TP_CD" ).append("\n"); 
		query.append("              ,BSE_YR" ).append("\n"); 
		query.append("              ,BSE_QTR_CD" ).append("\n"); 
		query.append("              ,TRD_CD" ).append("\n"); 
		query.append("              ,RLANE_CD" ).append("\n"); 
		query.append("              ,DIR_CD" ).append("\n"); 
		query.append("              ,VSL_CD" ).append("\n"); 
		query.append("              ,SKD_VOY_NO" ).append("\n"); 
		query.append("              ,SKD_DIR_CD" ).append("\n"); 
		query.append("              ,COUNT(BSE_MON) OVER(PARTITION BY BSE_YR,TRD_CD,RLANE_CD,DIR_CD,BSE_MON) AS VVD_CNT" ).append("\n"); 
		query.append("              ,SUM(FNL_BSA_CAPA) OVER(PARTITION BY BSE_YR,TRD_CD,RLANE_CD,DIR_CD,BSE_MON) AS TOT_BSA_CAPA" ).append("\n"); 
		query.append("              ,BSE_MON" ).append("\n"); 
		query.append("              ,SUB_TRD_CD" ).append("\n"); 
		query.append("              ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("        FROM SQM_QTA_TGT_VVD " ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        AND BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("        AND BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("        AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("        AND TRD_CD       = 'IAS'" ).append("\n"); 
		query.append("        AND DELT_FLG     = 'N'" ).append("\n"); 
		query.append("--        AND PF_SVC_TP_CD IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND FNL_BSA_CAPA <> 0" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("        AND SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("        AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_fm_mon} != '' && ${f_to_mon} != '')" ).append("\n"); 
		query.append("        AND BSE_MON BETWEEN ${f_fm_mon} AND ${f_to_mon}" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("        AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) A3" ).append("\n"); 
		query.append("        ,MAS_LANE_RGST A4" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A1.QTA_RLSE_VER_NO = DECODE(@[f_bse_tp_cd], 'Y', SUBSTR(@[f_bse_yr], 3)||'0001', SUBSTR(@[f_bse_yr], 3)||@[f_bse_qtr_cd]||'01')" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("AND A1.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("AND A1.OFC_VW_CD = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("AND A4.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.DIR_CD   = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} != '01' && ${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RHQ_CD          = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '03' && ${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD      = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POL_CD = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("AND A1.POD_CD = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("AND A4.IAS_RGN_CD  = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("AND A4.HUL_BND_CD  = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_pair} == 'Y')" ).append("\n"); 
		query.append("#if (${f_sqm_mn_sctr_flg} != '' && ${f_sqm_mn_sctr_flg} != 'All')" ).append("\n"); 
		query.append("AND NVL(A2.SQM_MN_SCTR_FLG, 'N') = @[f_sqm_mn_sctr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("AND A1.BSE_YR     = A2.BSE_YR" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = A2.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD     = A2.DIR_CD" ).append("\n"); 
		query.append("AND A1.PF_GRP_CD  = A2.PF_GRP_CD" ).append("\n"); 
		query.append("AND A1.POL_CD     = A2.POL_CD" ).append("\n"); 
		query.append("AND A1.POD_CD     = A2.POD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A1.BSE_TP_CD  = A3.BSE_TP_CD" ).append("\n"); 
		query.append("AND A1.BSE_YR     = A3.BSE_YR" ).append("\n"); 
		query.append("AND A1.BSE_QTR_CD = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD   = A3.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD     = A3.DIR_CD" ).append("\n"); 
		query.append("AND A1.VSL_CD     = A3.VSL_CD" ).append("\n"); 
		query.append("AND A1.SKD_VOY_NO = A3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A1.SKD_DIR_CD = A3.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND A1.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("AND A1.SUB_TRD_CD   = A4.SUB_TRD_CD" ).append("\n"); 
		query.append("AND A1.RLANE_CD     = A4.RLANE_CD" ).append("\n"); 
		query.append("AND A1.DIR_CD       = A4.DIR_CD  " ).append("\n"); 
		query.append("AND A4.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("AND A1.FNL_BSA_CAPA <> 0" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,A1.OFC_VW_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,A3.BSE_MON" ).append("\n"); 
		query.append("      ,A3.VVD_CNT" ).append("\n"); 
		query.append("      ,A3.TOT_BSA_CAPA" ).append("\n"); 
		query.append("      ,IAS_RGN_CD" ).append("\n"); 
		query.append("      ,A4.HUL_BND_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')   " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '03') " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_chk_pair} == 'Y')" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.POL_CALL_SEQ" ).append("\n"); 
		query.append("      ,A1.POD_CALL_SEQ" ).append("\n"); 
		query.append("      ,SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--      ,A1.VSL_CD" ).append("\n"); 
		query.append("--      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("--      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("       , IAS_RGN_CD" ).append("\n"); 
		query.append("       , RLANE_CD" ).append("\n"); 
		query.append("       , DIR_CD" ).append("\n"); 
		query.append("       , BSE_MON" ).append("\n"); 
		query.append("#if (${f_ofc_lvl} == '02')  " ).append("\n"); 
		query.append("	   , RHQ_CD" ).append("\n"); 
		query.append("#elseif (${f_ofc_lvl} == '03') " ).append("\n"); 
		query.append("       , RHQ_CD, RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       , HUL_BND_CD" ).append("\n"); 

	}
}