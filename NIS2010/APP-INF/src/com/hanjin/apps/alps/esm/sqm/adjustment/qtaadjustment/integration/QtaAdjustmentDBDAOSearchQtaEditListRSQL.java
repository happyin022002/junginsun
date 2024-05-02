/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchQtaEditListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
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

public class QtaAdjustmentDBDAOSearchQtaEditListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Qta Edit]을 [조회] 합니다
	  * 
	  * * 2015.02.11 이혜민 VVD Adjustment 기준을 COST_MON으로 바꾸면서 화면 정렬을 SLS_YR로 수정
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * * 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
	  * * 2016.06.14 김용습 PA CMCB 0으로 나오는 버그 수정
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchQtaEditListRSQL(){
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
		params.put("f_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_decimal_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_dir",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_to_mon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sqm_cng_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to_wk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchQtaEditListRSQL").append("\n"); 
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
		query.append("SELECT QTA.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("      ,QTA.BSE_TP_CD" ).append("\n"); 
		query.append("      ,QTA.BSE_YR" ).append("\n"); 
		query.append("      ,QTA.BSE_QTR_CD" ).append("\n"); 
		query.append("      ,DECODE(QTA.OFC_VW_CD,'L','LOADING','CONTRACT') OFC_VW_CD" ).append("\n"); 
		query.append("      ,QTA.QTA_TGT_CD" ).append("\n"); 
		query.append("      ,QTA.TRD_CD" ).append("\n"); 
		query.append("      ,QTA.DIR_CD" ).append("\n"); 
		query.append("      ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,QTA.RLANE_CD" ).append("\n"); 
		query.append("      ,VVD.SLS_YRMON" ).append("\n"); 
		query.append("      ,VVD.BSE_WK" ).append("\n"); 
		query.append("      ,QTA.RHQ_CD" ).append("\n"); 
		query.append("      ,QTA.RGN_OFC_CD" ).append("\n"); 
		query.append("      ,QTA.VSL_CD||QTA.SKD_VOY_NO||QTA.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("      ,QTA.VSL_CD" ).append("\n"); 
		query.append("      ,QTA.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,QTA.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,QTA.CONV_DIR_CD" ).append("\n"); 
		query.append("      ,QTA.LOD_QTY" ).append("\n"); 
		query.append("      ,CASE WHEN @[f_decimal_flg] = 'Y' THEN QTA.GRS_RPB_REV ELSE ROUND(QTA.GRS_RPB_REV) END GRS_RPB_REV" ).append("\n"); 
		query.append("      ,QTA.PA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,QTA.RA_CM_UC_AMT" ).append("\n"); 
		query.append("      ,VVD.BSE_MON" ).append("\n"); 
		query.append("      ,VVD.FNL_BSA_CAPA" ).append("\n"); 
		query.append("      ,QTA.SQM_CNG_TP_CD" ).append("\n"); 
		query.append("      ,DECODE(MAS.HUL_BND_CD,'BH','B/H','H/H') HUL_BND_CD" ).append("\n"); 
		query.append("  FROM SQM_CFM_QTA QTA" ).append("\n"); 
		query.append("      ,SQM_CFM_TGT_VVD VVD" ).append("\n"); 
		query.append("      ,MAS_LANE_RGST MAS" ).append("\n"); 
		query.append(" WHERE QTA.BSE_TP_CD                  = 'Q'" ).append("\n"); 
		query.append("   AND QTA.BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND QTA.BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND QTA.OFC_VW_CD                  = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("   AND QTA.QTA_TGT_CD                 = 'D'" ).append("\n"); 
		query.append("   AND SUBSTR(QTA.QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.TRD_CD                     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RLANE_CD                   = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_gubun} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.DIR_CD                     = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_gubun} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("   AND MAS.HUL_BND_CD                 = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RHQ_CD                     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.RGN_OFC_CD                 = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_mon} != '' && ${f_to_mon} != 'All')" ).append("\n"); 
		query.append("   AND VVD.BSE_MON                    = @[f_to_mon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_to_wk} != '' && ${f_to_wk} != 'All')" ).append("\n"); 
		query.append("   AND VVD.BSE_WK                     = @[f_to_wk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_vsl_cd} != '' )" ).append("\n"); 
		query.append("   AND QTA.VSL_CD                     = @[f_vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_voy_no} != '' )" ).append("\n"); 
		query.append("   AND QTA.SKD_VOY_NO                 = @[f_skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_skd_dir_cd} != '' )" ).append("\n"); 
		query.append("   AND QTA.SKD_DIR_CD                 = @[f_skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sqm_cng_tp_cd} != '' && ${f_sqm_cng_tp_cd} != 'All')" ).append("\n"); 
		query.append("   AND QTA.SQM_CNG_TP_CD              = @[f_sqm_cng_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND QTA.QTA_RLSE_VER_NO            = VVD.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("   AND QTA.BSE_TP_CD                  = VVD.BSE_TP_CD" ).append("\n"); 
		query.append("   AND QTA.BSE_YR                     = VVD.BSE_YR" ).append("\n"); 
		query.append("   AND QTA.BSE_QTR_CD                 = VVD.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND QTA.QTA_TGT_CD                 = VVD.QTA_TGT_CD" ).append("\n"); 
		query.append("   AND QTA.TRD_CD                     = VVD.TRD_CD" ).append("\n"); 
		query.append("   AND QTA.RLANE_CD                   = VVD.RLANE_CD" ).append("\n"); 
		query.append("   AND QTA.DIR_CD                     = VVD.DIR_CD  " ).append("\n"); 
		query.append("   AND QTA.VSL_CD                     = VVD.VSL_CD" ).append("\n"); 
		query.append("   AND QTA.SKD_VOY_NO                 = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND QTA.SKD_DIR_CD                 = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.RLANE_CD                   = MAS.RLANE_CD" ).append("\n"); 
		query.append("   AND VVD.DIR_CD                     = MAS.DIR_CD" ).append("\n"); 
		query.append("   AND VVD.TRD_CD                     = MAS.TRD_CD" ).append("\n"); 
		query.append("   AND VVD.IOC_CD                     = MAS.IOC_CD" ).append("\n"); 
		query.append(" ORDER BY  QTA.TRD_CD" ).append("\n"); 
		query.append("          ,QTA.CONV_DIR_CD" ).append("\n"); 
		query.append("          ,VVD.SUB_TRD_CD" ).append("\n"); 
		query.append("          ,QTA.RLANE_CD" ).append("\n"); 
		query.append("          ,NVL(SUBSTR(VVD.SLS_YRMON,0,4),QTA.BSE_YR)" ).append("\n"); 
		query.append("      	  ,VVD.BSE_MON" ).append("\n"); 
		query.append("          ,VVD.BSE_WK" ).append("\n"); 
		query.append("          ,QTA.VSL_CD||QTA.SKD_VOY_NO||QTA.SKD_DIR_CD" ).append("\n"); 
		query.append("          ,QTA.RHQ_CD" ).append("\n"); 
		query.append("          ,QTA.RGN_OFC_CD" ).append("\n"); 

	}
}