/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.03.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qta Edit for IAS Sector을 조회 합니다.
	  * 
	  * * History
	  * * 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
	  * * 2014.07.08 PEJ [CHM-201431035] QTA Edit for IAS Sector Sales의 BSA 중복 현상 로직 수정
	  * * 2015.02.11 이혜민 VVD Adjustment 기준을 COST_MON으로 바꾸면서 화면 정렬을 SLS_YR로 수정
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL(){
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
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_pf_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL").append("\n"); 
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
		query.append("SELECT A1.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A1.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A1.BSE_YR" ).append("\n"); 
		query.append("      ,A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("        FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("        WHERE INTG_CD_ID  = 'CD00940'" ).append("\n"); 
		query.append("        AND INTG_CD_VAL_CTNT = A1.OFC_VW_CD) OFC_VW_CD" ).append("\n"); 
		query.append("      ,A1.TRD_CD" ).append("\n"); 
		query.append("      ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("		FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("		WHERE INTG_CD_ID = 'CD03218'" ).append("\n"); 
		query.append("		AND INTG_CD_VAL_CTNT = A3.IAS_RGN_CD) IAS_RGN_CD" ).append("\n"); 
		query.append("      ,A1.RLANE_CD" ).append("\n"); 
		query.append("      ,A1.DIR_CD" ).append("\n"); 
		query.append("      ,DECODE(A3.HUL_BND_CD,'BH','B/H','H/H') HUL_BND_CD" ).append("\n"); 
		query.append("      ,A2.SLS_YRMON" ).append("\n"); 
		query.append("      ,A2.BSE_MON" ).append("\n"); 
		query.append("      ,A2.BSE_WK" ).append("\n"); 
		query.append("      ,A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      , A1.PF_GRP_CD" ).append("\n"); 
		query.append("      ,A2.FNL_BSA_CAPA " ).append("\n"); 
		query.append("      ,A1.RHQ_CD" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A1.POL_CD" ).append("\n"); 
		query.append("      ,A1.POD_CD" ).append("\n"); 
		query.append("      ,A1.VSL_CD" ).append("\n"); 
		query.append("      ,A1.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,A1.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,A1.LOD_QTY" ).append("\n"); 
		query.append("      ,A1.GRS_RPB_REV" ).append("\n"); 
		query.append("      ,A1.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,A1.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,A1.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("	  ,DECODE(NVL(A4.SQM_MN_SCTR_FLG, 'N'), 'Y', 'Main', 'N', 'Sector') SQM_MN_SCTR_FLG" ).append("\n"); 
		query.append("  FROM SQM_SCTR_CFM_QTA A1" ).append("\n"); 
		query.append("      ,SQM_CFM_TGT_VVD A2" ).append("\n"); 
		query.append("      ,MAS_LANE_RGST A3" ).append("\n"); 
		query.append("      ,SQM_SCTR_PAIR_MGMT A4" ).append("\n"); 
		query.append("--      , SQM_SCTR_PF_GRP PG" ).append("\n"); 
		query.append("--      , VSK_VSL_SKD VS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A1.BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("   AND A1.BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD                  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("   AND SUBSTR(A1.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("   AND A1.TRD_CD                     = 'IAS'  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD                 = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD                   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.DIR_CD                     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.HUL_BND_CD                 = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.IAS_RGN_CD                 = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RHQ_CD                     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD                 = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_mon} != '' && ${f_to_mon} != 'All')" ).append("\n"); 
		query.append("   AND A2.BSE_MON                    = @[f_to_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_wk} != '' && ${f_to_wk} != 'All')" ).append("\n"); 
		query.append("   AND A2.BSE_WK                     = @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '' )" ).append("\n"); 
		query.append("   AND A1.VSL_CD                     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '' )" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO                 = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '' )" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD                 = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pol_cd} != '' && ${f_pol_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.POL_CD                 = @[f_pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_pod_cd} != '' && ${f_pod_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.POD_CD                 = @[f_pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sqm_mn_sctr_flg} != '' && ${f_sqm_mn_sctr_flg} != 'All')" ).append("\n"); 
		query.append("AND NVL(A4.SQM_MN_SCTR_FLG, 'N') = @[f_sqm_mn_sctr_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_pf_grp_cd} != '' && ${f_pf_grp_cd} != 'All')" ).append("\n"); 
		query.append("   AND A4.PF_GRP_CD                 = @[f_pf_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.QTA_RLSE_VER_NO            = A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD                  = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR                     = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD                 = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.TRD_CD                     = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD                   = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD                     = A2.DIR_CD  " ).append("\n"); 
		query.append("   AND A1.VSL_CD                     = A2.VSL_CD" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO                 = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD                 = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.TRD_CD                     = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD                 = A3.SUB_TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD                   = A3.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD                     = A3.DIR_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A2.IOC_CD                     = A3.IOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD  				 = A4.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR     				 = A4.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD 				 = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD   				 = A4.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD     				 = A4.DIR_CD" ).append("\n"); 
		query.append("   AND A1.PF_GRP_CD  				 = A4.PF_GRP_CD" ).append("\n"); 
		query.append("   AND A1.POL_CD     				 = A4.POL_CD" ).append("\n"); 
		query.append("   AND A1.POD_CD     				 = A4.POD_CD   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--   AND A1.BSE_TP_CD                  = PG.BSE_TP_CD(+)" ).append("\n"); 
		query.append("--   AND A1.BSE_YR                     = PG.BSE_YR(+)" ).append("\n"); 
		query.append("--   AND A1.BSE_QTR_CD                 = PG.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("--   AND A1.RLANE_CD                   = PG.RLANE_CD(+)    " ).append("\n"); 
		query.append("--   AND A1.VSL_CD                     = VS.VSL_CD(+)" ).append("\n"); 
		query.append("--   AND A1.SKD_VOY_NO                 = VS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("--   AND A1.SKD_DIR_CD                 = VS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("--   AND PG.PF_SVC_TP_CD               = VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" ORDER BY  A1.TRD_CD" ).append("\n"); 
		query.append("          ,A1.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,A1.RLANE_CD" ).append("\n"); 
		query.append("          ,NVL(SUBSTR(A2.SLS_YRMON,0,4),A1.BSE_YR)" ).append("\n"); 
		query.append("          ,A2.BSE_MON" ).append("\n"); 
		query.append("          ,A2.BSE_WK" ).append("\n"); 
		query.append("          ,A1.VSL_CD||A1.SKD_VOY_NO||A1.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,A1.RHQ_CD" ).append("\n"); 
		query.append("          ,A1.RGN_OFC_CD" ).append("\n"); 

	}
}