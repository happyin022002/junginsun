/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchPotnAdjustmentListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.03 
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

public class QtaAdjustmentDBDAOSearchPotnAdjustmentListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Portion Adjustment by Head Office]을 [조회] 합니다
	  * [Portion Adjustment by RHQ]을 [조회] 합니다
	  * 
	  * * 2014.05.07 박은주 [CHM-201430106] 정렬기준변경(OB/NOB 제외)
	  * * 2015.02.27 이혜민 [CHM-201533807] 조회시 apply_fm_yrwk, apply_to_yrwk 그대로 가져오도록 수정
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.03.22 CHM-201640709 Adjusted 클릭시 Contract 컬럼을 Contract O/B와 Contract N/OB로 나눠서 보여주도록 로직 수정
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchPotnAdjustmentListRSQL(){
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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_qta_step_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_dir",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchPotnAdjustmentListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A2.BSE_TP_CD" ).append("\n"); 
		query.append("      ,A2.BSE_YR" ).append("\n"); 
		query.append("      ,A2.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(A2.OFC_VW_CD,'C','CONTRACT','LOADING')    AS OFC_VW_CD" ).append("\n"); 
		query.append("      ,DECODE(A3.OB_DIV_CD,'N','N.OB','O/B')            AS OB_DIV_CD" ).append("\n"); 
		query.append("      ,DECODE(A4.HUL_BND_CD,'HH','H/H','B/H')           AS HUL_BND_CD" ).append("\n"); 
		query.append("      ,A2.QTA_STEP_CD" ).append("\n"); 
		query.append("      ,A2.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,A2.RHQ_CD" ).append("\n"); 
		query.append("      ,A2.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A2.TRD_CD" ).append("\n"); 
		query.append("      ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A2.RLANE_CD" ).append("\n"); 
		query.append("      ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,A2.DIR_CD" ).append("\n"); 
		query.append("      ,A2.APLY_FM_YRWK AS APLY_FM_YRWK" ).append("\n"); 
		query.append("      ,A2.APLY_TO_YRWK AS APLY_TO_YRWK" ).append("\n"); 
		query.append("      ,A2.APLY_FM_YRWK AS ORG_FM_YRWK" ).append("\n"); 
		query.append("      ,A2.APLY_TO_YRWK AS ORG_TO_YRWK" ).append("\n"); 
		query.append("      ,A2.GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,A2.GID_REV_POTN_RTO" ).append("\n"); 
		query.append("      ,A2.LOD_POTN_RTO" ).append("\n"); 
		query.append("      ,A2.REV_POTN_RTO" ).append("\n"); 
		query.append("      ,A2.FM_VVD_CD" ).append("\n"); 
		query.append("      ,A2.TO_VVD_CD" ).append("\n"); 
		query.append("      ,DENSE_RANK() OVER(PARTITION BY A2.BSE_TP_CD, A2.BSE_YR, A2.BSE_QTR_CD, A2.OFC_VW_CD, A2.QTA_STEP_CD, A2.TRD_CD, A2.RLANE_CD" ).append("\n"); 
		query.append("                         ORDER BY A2.TRD_CD, A2.RLANE_CD, A2.CONV_DIR_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ' || ${f_gubun} == 'RHQ_C')" ).append("\n"); 
		query.append("                                     ,A2.RHQ_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("									, A2.APLY_FM_YRWK" ).append("\n"); 
		query.append("                         ) GRP_NO" ).append("\n"); 
		query.append("      ,(SELECT MAS.COST_YRMON FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = A2.TRD_CD AND MAS.RLANE_CD = A2.RLANE_CD AND MAS.VSL_CD||MAS.SKD_VOY_NO||MAS.DIR_CD = A2.FM_VVD_CD) AS FM_COST_YRMON" ).append("\n"); 
		query.append("      ,(SELECT MAS.COST_YRMON FROM MAS_MON_VVD MAS WHERE MAS.TRD_CD = A2.TRD_CD AND MAS.RLANE_CD = A2.RLANE_CD AND MAS.VSL_CD||MAS.SKD_VOY_NO||MAS.DIR_CD = A2.TO_VVD_CD) AS TO_COST_YRMON " ).append("\n"); 
		query.append("	  ,(SELECT DISTINCT 'Y' FROM SQM_QTA_NEW_LANE NLANE WHERE NLANE.BSE_TP_CD = A2.BSE_TP_CD AND NLANE.BSE_YR = A2.BSE_YR AND NLANE.BSE_QTR_CD = A2.BSE_QTR_CD AND NLANE.TRD_CD = A2.TRD_CD AND NLANE.RLANE_CD = A2.RLANE_CD AND NLANE.DIR_CD = A2.DIR_CD AND ROWNUM < 2) AS NEW_LANE_FLAG" ).append("\n"); 
		query.append("      ,(SELECT DISTINCT 'Y' FROM SQM_QTA_POTN_MGMT PLANNING WHERE PLANNING.BSE_TP_CD = A2.BSE_TP_CD AND PLANNING.BSE_YR = A2.BSE_YR AND PLANNING.BSE_QTR_CD = A2.BSE_QTR_CD AND PLANNING.OFC_VW_CD = A2.OFC_VW_CD AND PLANNING.QTA_STEP_CD IN ('03','04','05') AND PLANNING.RHQ_CD = A2.RHQ_CD AND PLANNING.TRD_CD = A2.TRD_CD AND PLANNING.RLANE_CD = A2.RLANE_CD AND PLANNING.CONV_DIR_CD = A2.CONV_DIR_CD AND PLANNING.DIR_CD = A2.DIR_CD AND ROWNUM < 2) AS PLANNING_FLAG" ).append("\n"); 
		query.append("      ,(SELECT DISTINCT 'Y' FROM SQM_CFM_QTA_POTN_MGMT POSTADJUST WHERE POSTADJUST.BSE_TP_CD = A2.BSE_TP_CD AND POSTADJUST.BSE_YR = A2.BSE_YR AND POSTADJUST.BSE_QTR_CD = A2.BSE_QTR_CD AND POSTADJUST.OFC_VW_CD = A2.OFC_VW_CD AND POSTADJUST.QTA_STEP_CD IN ('03','04','05') AND POSTADJUST.TRD_CD = A2.TRD_CD AND POSTADJUST.RLANE_CD = A2.RLANE_CD AND POSTADJUST.DIR_CD = A2.DIR_CD AND POSTADJUST.RHQ_CD = A2.RHQ_CD AND POSTADJUST.CONV_DIR_CD = A2.CONV_DIR_CD AND ROWNUM < 2) AS POSTADJUJST_FLAG  " ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_OFC A1" ).append("\n"); 
		query.append("      ,SQM_CFM_QTA_POTN_MGMT A2" ).append("\n"); 
		query.append("      ,SQM_DAT_RLT A3" ).append("\n"); 
		query.append("      ,MAS_LANE_RGST A4" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A2.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("   AND A2.RLANE_CD     = A4.RLANE_CD" ).append("\n"); 
		query.append("   AND A2.DIR_CD       = A4.DIR_CD" ).append("\n"); 
		query.append("   AND A4.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A2.BSE_TP_CD    = A3.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A2.BSE_YR       = A3.BSE_YR" ).append("\n"); 
		query.append("   AND A2.BSE_QTR_CD   = A3.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A2.OFC_VW_CD    = A3.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A2.TRD_CD       = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A2.CONV_DIR_CD  = A3.CONV_DIR_CD" ).append("\n"); 
		query.append("   AND A2.RHQ_CD       = A3.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("   AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND A1.OFC_VW_CD    = A2.OFC_VW_CD" ).append("\n"); 
		query.append("   AND A1.RHQ_CD       = A2.RHQ_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'RHQ'|| ${f_gubun} == 'RHQ_C')" ).append("\n"); 
		query.append("   AND A1.RGN_OFC_CD   = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("   AND A1.SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND A2.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A2.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A2.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND A2.OFC_VW_CD    = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("   AND A2.QTA_STEP_CD  = @[f_qta_step_cd]" ).append("\n"); 
		query.append("   AND A3.TEAM_CD      = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255')" ).append("\n"); 
		query.append("                                                       THEN A3.TEAM_CD" ).append("\n"); 
		query.append("                                                  ELSE @[ofc_cd]" ).append("\n"); 
		query.append("                                                END TEAM_CD" ).append("\n"); 
		query.append("                                          FROM DUAL)" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("   AND A2.QTA_STEP_CD  <> '02'" ).append("\n"); 
		query.append("   AND A3.RHQ_CD       = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255')" ).append("\n"); 
		query.append("                                                       THEN A3.RHQ_CD" ).append("\n"); 
		query.append("                                                  ELSE DECODE(@[ofc_cd], 'SELCMI', A3.RHQ_CD, @[ofc_cd])" ).append("\n"); 
		query.append("                                                END RHQ_CD" ).append("\n"); 
		query.append("                                          FROM DUAL)" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ_C')" ).append("\n"); 
		query.append("   AND A2.QTA_STEP_CD  = @[f_qta_step_cd]" ).append("\n"); 
		query.append("   AND A3.RHQ_CD       = (SELECT CASE WHEN @[ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255')" ).append("\n"); 
		query.append("                                                       THEN A3.RHQ_CD" ).append("\n"); 
		query.append("                                                  ELSE DECODE(@[ofc_cd], 'SELCMI', A3.RHQ_CD, @[ofc_cd])" ).append("\n"); 
		query.append("                                                END RHQ_CD" ).append("\n"); 
		query.append("                                          FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.RLANE_CD     IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.CONV_DIR_CD  = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("   AND A4.HUL_BND_CD  = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.OB_DIV_CD   = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.RGN_OFC_CD   = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY A2.TRD_CD" ).append("\n"); 
		query.append("         ,A2.SUB_TRD_CD" ).append("\n"); 
		query.append("         ,A2.RLANE_CD" ).append("\n"); 
		query.append("         ,A2.CONV_DIR_CD" ).append("\n"); 
		query.append("         ,APLY_FM_YRWK" ).append("\n"); 
		query.append("         ,APLY_TO_YRWK" ).append("\n"); 
		query.append("         ,A2.RHQ_CD" ).append("\n"); 
		query.append("         ,A2.RGN_OFC_CD" ).append("\n"); 

	}
}