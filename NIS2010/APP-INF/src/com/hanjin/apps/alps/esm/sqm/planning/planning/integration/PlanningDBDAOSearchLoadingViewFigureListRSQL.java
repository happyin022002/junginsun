/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PlanningDBDAOSearchLoadingViewFigureListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.29
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.06.29 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.planning.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanningDBDAOSearchLoadingViewFigureListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [Loading View Figure Copy]을 [조회] 합니다
	  * </pre>
	  */
	public PlanningDBDAOSearchLoadingViewFigureListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchLoadingViewFigureListRSQL").append("\n"); 
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
		query.append(" SELECT A1.BSE_TP_CD" ).append("\n"); 
		query.append("      , A1.BSE_YR" ).append("\n"); 
		query.append("      , A1.BSE_QTR_CD" ).append("\n"); 
		query.append("      , A1.OFC_VW_CD" ).append("\n"); 
		query.append("      , A1.OB_DIV_CD" ).append("\n"); 
		query.append("      , A1.QTA_STEP_CD" ).append("\n"); 
		query.append("      , A1.QTA_VER_NO" ).append("\n"); 
		query.append("      , A1.RHQ_CD" ).append("\n"); 
		query.append("      , A1.RGN_OFC_CD" ).append("\n"); 
		query.append("      , A1.TRD_CD" ).append("\n"); 
		query.append("      , A1.RLANE_CD" ).append("\n"); 
		query.append("      , A1.DIR_CD" ).append("\n"); 
		query.append("      , A1.CONV_DIR_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A1.GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("      , A1.GID_REV_POTN_RTO" ).append("\n"); 
		query.append("      , NVL(A2.LOD_POTN_RTO,0) AS LOD_POTN_RTO" ).append("\n"); 
		query.append("      , NVL(A2.REV_POTN_RTO,0) AS REV_POTN_RTO" ).append("\n"); 
		query.append("      , CASE WHEN A1.LOD_POTN_RTO = NVL(A2.LOD_POTN_RTO,0) AND A1.REV_POTN_RTO = NVL(A2.REV_POTN_RTO,0)  THEN 'N' ELSE 'Y' END AS MODI_FLG" ).append("\n"); 
		query.append("      , A1.HUL_BND_CD" ).append("\n"); 
		query.append("   FROM (" ).append("\n"); 
		query.append("         SELECT PO.BSE_TP_CD" ).append("\n"); 
		query.append("              , PO.BSE_YR" ).append("\n"); 
		query.append("              , PO.BSE_QTR_CD" ).append("\n"); 
		query.append("              , DECODE(PO.OFC_VW_CD, 'C', 'CONTRACT', 'L', 'LOADING') AS OFC_VW_CD" ).append("\n"); 
		query.append("              , DECODE(RLT.OB_DIV_CD, 'N', 'N.OB', 'O/B')             AS OB_DIV_CD" ).append("\n"); 
		query.append("              , PO.QTA_STEP_CD" ).append("\n"); 
		query.append("              , PO.QTA_VER_NO" ).append("\n"); 
		query.append("              , PO.RHQ_CD" ).append("\n"); 
		query.append("              , PO.RGN_OFC_CD" ).append("\n"); 
		query.append("              , PO.TRD_CD" ).append("\n"); 
		query.append("              , PO.RLANE_CD" ).append("\n"); 
		query.append("              , PO.DIR_CD" ).append("\n"); 
		query.append("              , PO.CONV_DIR_CD" ).append("\n"); 
		query.append("              , PO.SUB_TRD_CD" ).append("\n"); 
		query.append("              , PO.GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("              , PO.GID_REV_POTN_RTO" ).append("\n"); 
		query.append("              , PO.LOD_POTN_RTO" ).append("\n"); 
		query.append("              , PO.REV_POTN_RTO" ).append("\n"); 
		query.append("              , DECODE(MAS.HUL_BND_CD, 'HH', 'H/H', 'B/H') AS HUL_BND_CD" ).append("\n"); 
		query.append("           FROM SQM_QTA_POTN_MGMT PO" ).append("\n"); 
		query.append("              , SQM_QTA_LANE_OFC OFC" ).append("\n"); 
		query.append("              , SQM_DAT_RLT RLT" ).append("\n"); 
		query.append("              , MAS_LANE_RGST MAS" ).append("\n"); 
		query.append("          WHERE PO.BSE_TP_CD                = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND PO.BSE_YR                   = @[f_bse_yr]" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("            AND PO.BSE_QTR_CD               = '00'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND PO.BSE_QTR_CD               = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND PO.OFC_VW_CD                = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("            AND PO.BSE_TP_CD                = OFC.BSE_TP_CD" ).append("\n"); 
		query.append("            AND PO.BSE_YR                   = OFC.BSE_YR" ).append("\n"); 
		query.append("            AND PO.BSE_QTR_CD               = OFC.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND PO.OFC_VW_CD                = OFC.OFC_VW_CD" ).append("\n"); 
		query.append("            AND PO.TRD_CD                   = OFC.TRD_CD" ).append("\n"); 
		query.append("            AND PO.RLANE_CD                 = OFC.RLANE_CD" ).append("\n"); 
		query.append("            AND PO.DIR_CD                   = OFC.DIR_CD" ).append("\n"); 
		query.append("            AND PO.RHQ_CD                   = OFC.RHQ_CD" ).append("\n"); 
		query.append("            AND PO.RGN_OFC_CD               = OFC.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND PO.BSE_TP_CD                = RLT.BSE_TP_CD" ).append("\n"); 
		query.append("            AND PO.BSE_YR                   = RLT.BSE_YR" ).append("\n"); 
		query.append("            AND PO.BSE_QTR_CD               = RLT.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND PO.OFC_VW_CD                = RLT.OFC_VW_CD" ).append("\n"); 
		query.append("            AND PO.TRD_CD                   = RLT.TRD_CD" ).append("\n"); 
		query.append("            AND PO.RLANE_CD                 = DECODE(RLT.RLANE_CD, 'All', PO.RLANE_CD, RLT.RLANE_CD)" ).append("\n"); 
		query.append("            AND PO.CONV_DIR_CD              = RLT.CONV_DIR_CD" ).append("\n"); 
		query.append("            AND PO.RHQ_CD                   = RLT.RHQ_CD" ).append("\n"); 
		query.append("            AND PO.TRD_CD                   = MAS.TRD_CD" ).append("\n"); 
		query.append("            AND PO.RLANE_CD                 = MAS.RLANE_CD" ).append("\n"); 
		query.append("            AND PO.DIR_CD                   = MAS.DIR_CD" ).append("\n"); 
		query.append("            AND OFC.SQM_ACT_FLG             = 'Y'" ).append("\n"); 
		query.append("            AND PO.RHQ_CD                   =" ).append("\n"); 
		query.append("                (SELECT CASE WHEN @[ofc_cd] IN" ).append("\n"); 
		query.append("                                        (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255'" ).append("\n"); 
		query.append("                                        ) THEN PO.RHQ_CD ELSE DECODE(@[ofc_cd], 'SELCMI', PO.RHQ_CD, @[ofc_cd]) END TEAM_CD" ).append("\n"); 
		query.append("                   FROM DUAL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("            AND PO.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("            AND PO.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("            AND PO.CONV_DIR_CD  = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("            AND MAS.HUL_BND_CD  = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("            AND PO.RGN_OFC_CD   = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("            AND RLT.OB_DIV_CD   = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) A1" ).append("\n"); 
		query.append("      , (SELECT PO.BSE_TP_CD" ).append("\n"); 
		query.append("              , PO.BSE_YR" ).append("\n"); 
		query.append("              , PO.BSE_QTR_CD" ).append("\n"); 
		query.append("              , DECODE(PO.OFC_VW_CD, 'C', 'CONTRACT', 'L', 'LOADING') AS OFC_VW_CD" ).append("\n"); 
		query.append("              , DECODE(RLT.OB_DIV_CD, 'N', 'N.OB', 'O/B')             AS OB_DIV_CD" ).append("\n"); 
		query.append("              , PO.QTA_STEP_CD" ).append("\n"); 
		query.append("              , PO.QTA_VER_NO" ).append("\n"); 
		query.append("              , PO.RHQ_CD" ).append("\n"); 
		query.append("              , PO.RGN_OFC_CD" ).append("\n"); 
		query.append("              , PO.TRD_CD" ).append("\n"); 
		query.append("              , PO.RLANE_CD" ).append("\n"); 
		query.append("              , PO.DIR_CD" ).append("\n"); 
		query.append("              , PO.CONV_DIR_CD" ).append("\n"); 
		query.append("              , PO.SUB_TRD_CD" ).append("\n"); 
		query.append("              , PO.GID_LOD_POTN_RTO" ).append("\n"); 
		query.append("              , PO.GID_REV_POTN_RTO" ).append("\n"); 
		query.append("              , PO.LOD_POTN_RTO" ).append("\n"); 
		query.append("              , PO.REV_POTN_RTO" ).append("\n"); 
		query.append("              , DECODE(MAS.HUL_BND_CD, 'HH', 'H/H', 'B/H') AS HUL_BND_CD" ).append("\n"); 
		query.append("           FROM SQM_QTA_POTN_MGMT PO" ).append("\n"); 
		query.append("              , SQM_QTA_LANE_OFC OFC" ).append("\n"); 
		query.append("              , SQM_DAT_RLT RLT" ).append("\n"); 
		query.append("              , MAS_LANE_RGST MAS" ).append("\n"); 
		query.append("          WHERE 1                           =1" ).append("\n"); 
		query.append("            AND PO.BSE_TP_CD                = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("            AND PO.BSE_YR                   = @[f_bse_yr]" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("            AND PO.BSE_QTR_CD               = '00'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("            AND PO.BSE_QTR_CD               = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND PO.OFC_VW_CD                = 'L'" ).append("\n"); 
		query.append("            AND PO.BSE_TP_CD                = OFC.BSE_TP_CD" ).append("\n"); 
		query.append("            AND PO.BSE_YR                   = OFC.BSE_YR" ).append("\n"); 
		query.append("            AND PO.BSE_QTR_CD               = OFC.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND PO.OFC_VW_CD                = OFC.OFC_VW_CD" ).append("\n"); 
		query.append("            AND PO.TRD_CD                   = OFC.TRD_CD" ).append("\n"); 
		query.append("            AND PO.RLANE_CD                 = OFC.RLANE_CD" ).append("\n"); 
		query.append("            AND PO.DIR_CD                   = OFC.DIR_CD" ).append("\n"); 
		query.append("            AND PO.RHQ_CD                   = OFC.RHQ_CD" ).append("\n"); 
		query.append("            AND PO.RGN_OFC_CD               = OFC.RGN_OFC_CD" ).append("\n"); 
		query.append("            AND PO.BSE_TP_CD                = RLT.BSE_TP_CD" ).append("\n"); 
		query.append("            AND PO.BSE_YR                   = RLT.BSE_YR" ).append("\n"); 
		query.append("            AND PO.BSE_QTR_CD               = RLT.BSE_QTR_CD" ).append("\n"); 
		query.append("            AND PO.OFC_VW_CD                = RLT.OFC_VW_CD" ).append("\n"); 
		query.append("            AND PO.TRD_CD                   = RLT.TRD_CD" ).append("\n"); 
		query.append("            AND PO.RLANE_CD                 = DECODE(RLT.RLANE_CD, 'All', PO.RLANE_CD, RLT.RLANE_CD)" ).append("\n"); 
		query.append("            AND PO.CONV_DIR_CD              = RLT.CONV_DIR_CD" ).append("\n"); 
		query.append("            AND PO.RHQ_CD                   = RLT.RHQ_CD" ).append("\n"); 
		query.append("            AND PO.TRD_CD                   = MAS.TRD_CD" ).append("\n"); 
		query.append("            AND PO.RLANE_CD                 = MAS.RLANE_CD" ).append("\n"); 
		query.append("            AND PO.DIR_CD                   = MAS.DIR_CD" ).append("\n"); 
		query.append("            AND OFC.SQM_ACT_FLG             = 'Y'" ).append("\n"); 
		query.append("            AND PO.RHQ_CD                   =" ).append("\n"); 
		query.append("                (SELECT CASE WHEN @[ofc_cd] IN" ).append("\n"); 
		query.append("                                        (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255'" ).append("\n"); 
		query.append("                                        ) THEN PO.RHQ_CD ELSE DECODE(@[ofc_cd], 'SELCMI', PO.RHQ_CD, @[ofc_cd]) END TEAM_CD" ).append("\n"); 
		query.append("                   FROM DUAL)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("            AND PO.TRD_CD       = @[f_trd_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("            AND PO.RLANE_CD     = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("            AND PO.CONV_DIR_CD  = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("            AND MAS.HUL_BND_CD  = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rgn_ofc_cd} != '' && ${f_rgn_ofc_cd} != 'All')" ).append("\n"); 
		query.append("            AND PO.RGN_OFC_CD   = @[f_rgn_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("            AND RLT.OB_DIV_CD   = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ) A2" ).append("\n"); 
		query.append("  WHERE A1.BSE_TP_CD   = A2.BSE_TP_CD(+)" ).append("\n"); 
		query.append("    AND A1.BSE_YR      = A2.BSE_YR(+)" ).append("\n"); 
		query.append("    AND A1.BSE_QTR_CD  = A2.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("    AND A1.QTA_VER_NO  = A2.QTA_VER_NO(+)" ).append("\n"); 
		query.append("    AND A1.RHQ_CD      = A2.RHQ_CD(+)" ).append("\n"); 
		query.append("    AND A1.RGN_OFC_CD  = A2.RGN_OFC_CD(+)" ).append("\n"); 
		query.append("    AND A1.TRD_CD      = A2.TRD_CD(+)" ).append("\n"); 
		query.append("    AND A1.RLANE_CD    = A2.RLANE_CD(+)" ).append("\n"); 
		query.append("    AND A1.CONV_DIR_CD = A2.CONV_DIR_CD(+)" ).append("\n"); 
		query.append("ORDER BY A1.TRD_CD" ).append("\n"); 
		query.append("      , A1.SUB_TRD_CD" ).append("\n"); 
		query.append("      , A1.RLANE_CD" ).append("\n"); 
		query.append("      , A1.CONV_DIR_CD" ).append("\n"); 
		query.append("      , A1.RHQ_CD" ).append("\n"); 
		query.append("      , A1.RGN_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}