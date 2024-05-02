/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QtaAdjustmentDBDAOSearchOfcZeroPortionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.15 
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

public class QtaAdjustmentDBDAOSearchOfcZeroPortionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Adjustment by VVD, Portion Adjustement by HO, RHQ 화면에서 Creation 전에 
	  * RHQ에는 Portion을 부여했으나 
	  * 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회합니다.
	  * 
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public QtaAdjustmentDBDAOSearchOfcZeroPortionRSQL(){
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
		params.put("f_hul_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAOSearchOfcZeroPortionRSQL").append("\n"); 
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
		query.append("SELECT DECODE(D.OFC_VW_CD,'C','Contract','L','Loading')||'/'||D.TRD_CD||'/'||D.RLANE_CD||'/'||D.DIR_CD||'B/'||D.HUL_BND_CD||'/'||D.RHQ_CD AS OfcZeroPortion" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("--02에게 Portion을 배부한것만 추림" ).append("\n"); 
		query.append("        SELECT NVL(A.OFC_VW_CD,  B.OFC_VW_CD)   OFC_VW_CD" ).append("\n"); 
		query.append("              ,NVL(A.TRD_CD,     B.TRD_CD)      TRD_CD" ).append("\n"); 
		query.append("              ,NVL(A.SUB_TRD_CD, B.SUB_TRD_CD)  SUB_TRD_CD" ).append("\n"); 
		query.append("              ,NVL(A.RLANE_CD,   B.RLANE_CD)    RLANE_CD" ).append("\n"); 
		query.append("              ,NVL(A.DIR_CD,     B.DIR_CD)      DIR_CD" ).append("\n"); 
		query.append("              ,NVL(A.RHQ_CD,     B.RHQ_CD)      RHQ_CD" ).append("\n"); 
		query.append("              ,NVL(A.HUL_BND_CD, B.HUL_BND_CD)  HUL_BND_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT A1.*, A3.HUL_BND_CD" ).append("\n"); 
		query.append("                FROM SQM_CFM_QTA_POTN_MGMT A1, SQM_QTA_LANE_OFC A2, MAS_LANE_RGST A3, SQM_DAT_RLT A4" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("                AND A3.HUL_BND_CD   = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.CONV_DIR_CD  = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("                AND A3.HUL_BND_CD   = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("                AND A4.OB_DIV_CD    = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND A1.QTA_STEP_CD  = '02'" ).append("\n"); 
		query.append("                AND A1.LOD_POTN_RTO <> 0" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = A2.OFC_VW_CD" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("                AND A1.RHQ_CD       = A2.RHQ_CD" ).append("\n"); 
		query.append("                AND A2.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A3.TRD_CD" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     = A3.RLANE_CD" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = A3.DIR_CD" ).append("\n"); 
		query.append("                AND A3.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = A4.BSE_TP_CD" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = A4.BSE_YR" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = A4.OFC_VW_CD" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("                AND A1.CONV_DIR_CD  = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("                AND A1.RHQ_CD       = A4.RHQ_CD" ).append("\n"); 
		query.append("             )A " ).append("\n"); 
		query.append("        FULL OUTER JOIN " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT DISTINCT A1.*, A3.HUL_BND_CD" ).append("\n"); 
		query.append("                FROM SQM_QTA_POTN_MGMT A1, SQM_QTA_LANE_OFC A2, MAS_LANE_RGST A3, SQM_DAT_RLT A4" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("                AND A3.HUL_BND_CD   = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.CONV_DIR_CD  = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("                AND A3.HUL_BND_CD   = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("                AND A4.OB_DIV_CD    = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND A1.QTA_STEP_CD  = '02'" ).append("\n"); 
		query.append("                AND A1.LOD_POTN_RTO <> 0" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = A2.OFC_VW_CD" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("                AND A1.RHQ_CD       = A2.RHQ_CD" ).append("\n"); 
		query.append("                AND A2.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A3.TRD_CD" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     = A3.RLANE_CD" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = A3.DIR_CD" ).append("\n"); 
		query.append("                AND A3.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = A4.BSE_TP_CD" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = A4.BSE_YR" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = A4.OFC_VW_CD" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("                AND A1.CONV_DIR_CD  = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("                AND A1.RHQ_CD       = A4.RHQ_CD" ).append("\n"); 
		query.append("            )B" ).append("\n"); 
		query.append("        ON  A.BSE_TP_CD    = B.BSE_TP_CD " ).append("\n"); 
		query.append("        AND A.BSE_YR       = B.BSE_YR     " ).append("\n"); 
		query.append("        AND A.BSE_QTR_CD   = B.BSE_QTR_CD " ).append("\n"); 
		query.append("        AND A.OFC_VW_CD    = B.OFC_VW_CD " ).append("\n"); 
		query.append("        AND A.QTA_STEP_CD  = B.QTA_STEP_CD" ).append("\n"); 
		query.append("        AND A.TRD_CD       = B.TRD_CD    " ).append("\n"); 
		query.append("        AND A.RLANE_CD     = B.RLANE_CD  " ).append("\n"); 
		query.append("        AND A.DIR_CD       = B.DIR_CD     " ).append("\n"); 
		query.append("        AND A.RHQ_CD       = B.RHQ_CD     " ).append("\n"); 
		query.append("        AND A.RGN_OFC_CD   = B.RGN_OFC_CD" ).append("\n"); 
		query.append("        AND A.HUL_BND_CD   = B.HUL_BND_CD" ).append("\n"); 
		query.append("     ) C" ).append("\n"); 
		query.append("--03,04,05 의 SUM이 0인것     " ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT NVL(A.OFC_VW_CD,   B.OFC_VW_CD)      OFC_VW_CD" ).append("\n"); 
		query.append("              ,NVL(A.QTA_STEP_CD, B.QTA_STEP_CD)    QTA_STEP_CD" ).append("\n"); 
		query.append("              ,NVL(A.TRD_CD,      B.TRD_CD)         TRD_CD" ).append("\n"); 
		query.append("              ,NVL(A.SUB_TRD_CD,  B.SUB_TRD_CD)     SUB_TRD_CD" ).append("\n"); 
		query.append("              ,NVL(A.RLANE_CD,    B.RLANE_CD)       RLANE_CD" ).append("\n"); 
		query.append("              ,NVL(A.DIR_CD,      B.DIR_CD)         DIR_CD" ).append("\n"); 
		query.append("              ,NVL(A.RHQ_CD,      B.RHQ_CD)         RHQ_CD" ).append("\n"); 
		query.append("              ,NVL(A.HUL_BND_CD,  B.HUL_BND_CD)     HUL_BND_CD" ).append("\n"); 
		query.append("              ,NVL(SUM(A.LOD_POTN_RTO), SUM(B.LOD_POTN_RTO)) LOD_POTN_RTO " ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT DISTINCT A1.*, A3.HUL_BND_CD" ).append("\n"); 
		query.append("                FROM SQM_CFM_QTA_POTN_MGMT A1, SQM_QTA_LANE_OFC A2, MAS_LANE_RGST A3, SQM_DAT_RLT A4" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("                AND A3.HUL_BND_CD   = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.CONV_DIR_CD  = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("                AND A3.HUL_BND_CD   = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("                AND A4.OB_DIV_CD    = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND A1.QTA_STEP_CD  <> '02'" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = A2.OFC_VW_CD" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("                AND A1.RHQ_CD       = A2.RHQ_CD" ).append("\n"); 
		query.append("                AND A1.RGN_OFC_CD   = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("                AND A2.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A3.TRD_CD" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     = A3.RLANE_CD" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = A3.DIR_CD" ).append("\n"); 
		query.append("                AND A3.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = A4.BSE_TP_CD" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = A4.BSE_YR" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = A4.OFC_VW_CD" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("                AND A1.CONV_DIR_CD  = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("                AND A1.RHQ_CD       = A4.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             )A " ).append("\n"); 
		query.append("        FULL OUTER JOIN " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT DISTINCT A1.*, A3.HUL_BND_CD" ).append("\n"); 
		query.append("                FROM SQM_QTA_POTN_MGMT A1, SQM_QTA_LANE_OFC A2, MAS_LANE_RGST A3, SQM_DAT_RLT A4" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = @[f_bse_yr]" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '' && ${f_ofc_vw_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     IN (${f_rlane_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("                AND A3.HUL_BND_CD   = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_conv_dir_cd} != '' && ${f_conv_dir_cd} != 'All')" ).append("\n"); 
		query.append("                AND A1.CONV_DIR_CD  = @[f_conv_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("                AND A3.HUL_BND_CD   = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("                AND A4.OB_DIV_CD    = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND A1.QTA_STEP_CD  <> '02'" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = A2.BSE_TP_CD" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = A2.BSE_YR" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = A2.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = A2.OFC_VW_CD" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A2.TRD_CD" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     = A2.RLANE_CD" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = A2.DIR_CD" ).append("\n"); 
		query.append("                AND A1.RHQ_CD       = A2.RHQ_CD" ).append("\n"); 
		query.append("                AND A1.RGN_OFC_CD   = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("                AND A2.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A3.TRD_CD" ).append("\n"); 
		query.append("                AND A1.RLANE_CD     = A3.RLANE_CD" ).append("\n"); 
		query.append("                AND A1.DIR_CD       = A3.DIR_CD" ).append("\n"); 
		query.append("                AND A3.DELT_FLG     = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                AND A1.BSE_TP_CD    = A4.BSE_TP_CD" ).append("\n"); 
		query.append("                AND A1.BSE_YR       = A4.BSE_YR" ).append("\n"); 
		query.append("                AND A1.BSE_QTR_CD   = A4.BSE_QTR_CD" ).append("\n"); 
		query.append("                AND A1.OFC_VW_CD    = A4.OFC_VW_CD" ).append("\n"); 
		query.append("                AND A1.TRD_CD       = A4.TRD_CD" ).append("\n"); 
		query.append("                AND A1.CONV_DIR_CD  = A4.CONV_DIR_CD" ).append("\n"); 
		query.append("                AND A1.RHQ_CD       = A4.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            )B" ).append("\n"); 
		query.append("        ON  A.BSE_TP_CD    = B.BSE_TP_CD " ).append("\n"); 
		query.append("        AND A.BSE_YR       = B.BSE_YR     " ).append("\n"); 
		query.append("        AND A.BSE_QTR_CD   = B.BSE_QTR_CD " ).append("\n"); 
		query.append("        AND A.OFC_VW_CD    = B.OFC_VW_CD " ).append("\n"); 
		query.append("        AND A.QTA_STEP_CD  = B.QTA_STEP_CD" ).append("\n"); 
		query.append("        AND A.TRD_CD       = B.TRD_CD    " ).append("\n"); 
		query.append("        AND A.RLANE_CD     = B.RLANE_CD  " ).append("\n"); 
		query.append("        AND A.DIR_CD       = B.DIR_CD     " ).append("\n"); 
		query.append("        AND A.RHQ_CD       = B.RHQ_CD     " ).append("\n"); 
		query.append("        AND A.RGN_OFC_CD   = B.RGN_OFC_CD" ).append("\n"); 
		query.append("        AND A.HUL_BND_CD   = B.HUL_BND_CD" ).append("\n"); 
		query.append("        GROUP BY NVL(A.OFC_VW_CD,   B.OFC_VW_CD) " ).append("\n"); 
		query.append("                ,NVL(A.QTA_STEP_CD, B.QTA_STEP_CD) " ).append("\n"); 
		query.append("                ,NVL(A.TRD_CD,      B.TRD_CD) " ).append("\n"); 
		query.append("                ,NVL(A.SUB_TRD_CD,  B.SUB_TRD_CD)" ).append("\n"); 
		query.append("                ,NVL(A.RLANE_CD,    B.RLANE_CD)" ).append("\n"); 
		query.append("                ,NVL(A.DIR_CD,      B.DIR_CD) " ).append("\n"); 
		query.append("                ,NVL(A.RHQ_CD,      B.RHQ_CD)" ).append("\n"); 
		query.append("                ,NVL(A.HUL_BND_CD,  B.HUL_BND_CD)" ).append("\n"); 
		query.append("        HAVING NVL(SUM(A.LOD_POTN_RTO), SUM(B.LOD_POTN_RTO)) = 0" ).append("\n"); 
		query.append("        ORDER BY NVL(A.OFC_VW_CD,   B.OFC_VW_CD) " ).append("\n"); 
		query.append("                ,NVL(A.QTA_STEP_CD, B.QTA_STEP_CD) " ).append("\n"); 
		query.append("                ,NVL(A.TRD_CD,      B.TRD_CD) " ).append("\n"); 
		query.append("                ,NVL(A.SUB_TRD_CD,  B.SUB_TRD_CD)" ).append("\n"); 
		query.append("                ,NVL(A.RLANE_CD,    B.RLANE_CD) " ).append("\n"); 
		query.append("                ,NVL(A.DIR_CD,      B.DIR_CD) " ).append("\n"); 
		query.append("                ,NVL(A.RHQ_CD,      B.RHQ_CD)" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     ) D" ).append("\n"); 
		query.append("WHERE C.OFC_VW_CD   = D.OFC_VW_CD" ).append("\n"); 
		query.append("AND   C.TRD_CD      = D.TRD_CD" ).append("\n"); 
		query.append("AND   C.SUB_TRD_CD  = D.SUB_TRD_CD " ).append("\n"); 
		query.append("AND   C.RLANE_CD    = D.RLANE_CD" ).append("\n"); 
		query.append("AND   C.DIR_CD      = D.DIR_CD" ).append("\n"); 
		query.append("AND   C.RHQ_CD      = D.RHQ_CD" ).append("\n"); 
		query.append("AND   C.HUL_BND_CD  = D.HUL_BND_CD" ).append("\n"); 

	}
}