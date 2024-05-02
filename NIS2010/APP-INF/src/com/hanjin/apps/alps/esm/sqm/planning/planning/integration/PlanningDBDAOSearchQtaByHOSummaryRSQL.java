/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanningDBDAOSearchQtaByHOSummaryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.15 
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

public class PlanningDBDAOSearchQtaByHOSummaryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * QTA Set up by Head Office_RHQ별 QTA Summary 조회
	  * 
	  * * 2014.09.26 [CHM-201431754] 이혜민 simulation_v를 RHQ, Office 단으로 나눠서 관리
	  * * 2014.12.23 [CHM-201433043] 이혜민 QTA Set up by Head Office 화면 내 RHQ QTA Summary 확인
	  * * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * </pre>
	  */
	public PlanningDBDAOSearchQtaByHOSummaryRSQL(){
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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_usr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_trd_dir",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.planning.planning.integration").append("\n"); 
		query.append("FileName : PlanningDBDAOSearchQtaByHOSummaryRSQL").append("\n"); 
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
		query.append("SELECT C1.BSE_TP_CD" ).append("\n"); 
		query.append("        ,C1.BSE_YR" ).append("\n"); 
		query.append("        ,C1.BSE_QTR_CD" ).append("\n"); 
		query.append("        ,DECODE(C1.OB_DIV_CD, 'O', 'O/B', 'N.O/B') AS OB_DIV_CD" ).append("\n"); 
		query.append("        ,DECODE(C1.OFC_VW_CD, 'C', 'Contract', 'Loading') AS OFC_VW_CD" ).append("\n"); 
		query.append("        ,C1.TRD_CD" ).append("\n"); 
		query.append("        ,C1.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,SUBSTR(C1.HUL_BND_CD, 1, 1) || '/' || SUBSTR(C1.HUL_BND_CD, 2) AS HUL_BND_CD" ).append("\n"); 
		query.append("        ,C1.RHQ_CD" ).append("\n"); 
		query.append("        ,C1.RHQ_QTY" ).append("\n"); 
		query.append("        ,C1.RHQ_WK_QTY" ).append("\n"); 
		query.append("        ,ROUND(RATIO_TO_REPORT(C1.RHQ_QTY) OVER (PARTITION BY C1.OFC_VW_CD, C1.TRD_CD, C1.CONV_DIR_CD), 4) * 100 AS RHQ_QTY_RTO" ).append("\n"); 
		query.append("        ,C1.RHQ_REV" ).append("\n"); 
		query.append("        ,C1.RHQ_WK_REV" ).append("\n"); 
		query.append("        ,ROUND(RATIO_TO_REPORT(C1.RHQ_REV) OVER (PARTITION BY C1.OFC_VW_CD, C1.TRD_CD, C1.CONV_DIR_CD), 4) * 100 AS RHQ_REV_RTO" ).append("\n"); 
		query.append("        ,C2.PST_WK_QTY" ).append("\n"); 
		query.append("        ,ROUND(RATIO_TO_REPORT(C2.PST_WK_QTY) OVER (PARTITION BY C1.OFC_VW_CD, C1.TRD_CD, C1.CONV_DIR_CD), 4) * 100 AS PST_QTY_RTO" ).append("\n"); 
		query.append("        ,C2.PST_WK_REV" ).append("\n"); 
		query.append("        ,ROUND(RATIO_TO_REPORT(C2.PST_WK_REV) OVER (PARTITION BY C1.OFC_VW_CD, C1.TRD_CD, C1.CONV_DIR_CD), 4) * 100 AS PST_REV_RTO" ).append("\n"); 
		query.append("        ,C1.RHQ_WK_QTY - C2.PST_WK_QTY AS DIFF_QTY" ).append("\n"); 
		query.append("        ,ROUND(RATIO_TO_REPORT(C1.RHQ_REV) OVER (PARTITION BY C1.OFC_VW_CD, C1.TRD_CD, C1.CONV_DIR_CD), 4) * 100 - ROUND(RATIO_TO_REPORT(C2.PST_WK_QTY) OVER (PARTITION BY C1.OFC_VW_CD, C1.TRD_CD, C1.CONV_DIR_CD), 4) * 100 AS DIFF_QTY_RTO" ).append("\n"); 
		query.append("        ,C1.RHQ_WK_REV - C2.PST_WK_REV AS DIFF_REV" ).append("\n"); 
		query.append("        ,ROUND(RATIO_TO_REPORT(C1.RHQ_REV) OVER (PARTITION BY C1.OFC_VW_CD, C1.TRD_CD, C1.CONV_DIR_CD), 4) * 100 - ROUND(RATIO_TO_REPORT(C2.PST_WK_REV) OVER (PARTITION BY C1.OFC_VW_CD, C1.TRD_CD, C1.CONV_DIR_CD), 4) * 100 AS DIFF_REV_RTO" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT V.BSE_TP_CD" ).append("\n"); 
		query.append("                  ,V.BSE_YR" ).append("\n"); 
		query.append("                  ,V.BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,V.OB_DIV_CD" ).append("\n"); 
		query.append("                  ,V.OFC_VW_CD" ).append("\n"); 
		query.append("                  ,V.TRD_CD" ).append("\n"); 
		query.append("                  ,V.CONV_DIR_CD" ).append("\n"); 
		query.append("                  ,C.HUL_BND_CD" ).append("\n"); 
		query.append("                  ,V.RHQ_CD" ).append("\n"); 
		query.append("                  ,SUM(V.RHQ_QTY) AS RHQ_QTY" ).append("\n"); 
		query.append("                  ,SUM(V.RHQ_REV) AS RHQ_REV" ).append("\n"); 
		query.append("#if (${f_bse_tp_cd} == 'Y')" ).append("\n"); 
		query.append("                  ,SUM(V.RHQ_QTY) / 53 AS RHQ_WK_QTY" ).append("\n"); 
		query.append("                  ,SUM(V.RHQ_REV) / 53 AS RHQ_WK_REV" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                  ,SUM(V.RHQ_QTY) / 13 AS RHQ_WK_QTY" ).append("\n"); 
		query.append("                  ,SUM(V.RHQ_REV) / 13 AS RHQ_WK_REV" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              FROM SQM_DAT_RLT      	R" ).append("\n"); 
		query.append("                  ,SQM_SIMULATION_V_RHQ V" ).append("\n"); 
		query.append("                  ,MAS_LANE_RGST    	C" ).append("\n"); 
		query.append("             WHERE R.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("               AND R.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND R.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("               AND R.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("               AND R.BSE_TP_CD   = V.BSE_TP_CD" ).append("\n"); 
		query.append("               AND R.BSE_YR      = V.BSE_YR" ).append("\n"); 
		query.append("               AND R.BSE_QTR_CD  = V.BSE_QTR_CD" ).append("\n"); 
		query.append("               AND R.OFC_VW_CD   = V.OFC_VW_CD" ).append("\n"); 
		query.append("               AND R.TRD_CD      = V.TRD_CD" ).append("\n"); 
		query.append("               AND DECODE(UPPER(R.RLANE_CD), 'ALL', V.RLANE_CD, R.RLANE_CD) = V.RLANE_CD" ).append("\n"); 
		query.append("               AND R.CONV_DIR_CD = V.CONV_DIR_CD" ).append("\n"); 
		query.append("               AND R.RHQ_CD      = V.RHQ_CD" ).append("\n"); 
		query.append("               AND R.TEAM_CD     = (SELECT CASE WHEN @[f_usr_ofc_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN R.TEAM_CD" ).append("\n"); 
		query.append("                                                                                                                                                    ELSE @[f_usr_ofc_cd]" ).append("\n"); 
		query.append("                                            END TEAM_CD" ).append("\n"); 
		query.append("                                      FROM DUAL)" ).append("\n"); 
		query.append("               AND V.TRD_CD      = C.TRD_CD" ).append("\n"); 
		query.append("               AND V.RLANE_CD    = C.RLANE_CD" ).append("\n"); 
		query.append("               AND V.SKD_DIR_CD  = C.DIR_CD" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("               AND V.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("               AND V.CONV_DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_click} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("               AND C.HUL_BND_CD  = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ob_div_cd} != '' && ${f_ob_div_cd} != 'All')" ).append("\n"); 
		query.append("               AND V.OB_DIV_CD   = @[f_ob_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               GROUP BY V.BSE_TP_CD" ).append("\n"); 
		query.append("                      ,V.BSE_YR" ).append("\n"); 
		query.append("                      ,V.BSE_QTR_CD" ).append("\n"); 
		query.append("                      ,V.OB_DIV_CD" ).append("\n"); 
		query.append("                      ,V.OFC_VW_CD" ).append("\n"); 
		query.append("                      ,V.TRD_CD" ).append("\n"); 
		query.append("                      ,V.CONV_DIR_CD" ).append("\n"); 
		query.append("                      ,C.HUL_BND_CD" ).append("\n"); 
		query.append("                      ,V.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ) C1" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            SELECT I.BSE_TP_CD" ).append("\n"); 
		query.append("                  ,I.BSE_YR" ).append("\n"); 
		query.append("                  ,I.BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,I.OFC_VW_CD" ).append("\n"); 
		query.append("                  ,I.TRD_CD" ).append("\n"); 
		query.append("                  ,NVL(C.CONV_DIR_CD, I.DIR_CD) AS CONV_DIR_CD" ).append("\n"); 
		query.append("                  ,I.RHQ_CD" ).append("\n"); 
		query.append("                  ,SUM(I.LOD_QTY) AS PST_QTY" ).append("\n"); 
		query.append("                  ,ROUND(SUM(I.GRS_TTL_REV),0) AS PST_REV" ).append("\n"); 
		query.append("                  ,ROUND(SUM(DECODE(I.VVD_KNT, 0, 0, I.LOD_QTY/I.VVD_KNT)), 0) AS PST_WK_QTY" ).append("\n"); 
		query.append("                  ,ROUND(SUM(DECODE(I.VVD_KNT, 0, 0, I.GRS_TTL_REV/I.VVD_KNT)), 0) AS PST_WK_REV" ).append("\n"); 
		query.append("                  ,SUM(I.VVD_KNT) AS VVD_KNT" ).append("\n"); 
		query.append("              FROM SQM_PERF_IF  I" ).append("\n"); 
		query.append("                  ,SQM_DIR_CONV C " ).append("\n"); 
		query.append("             WHERE I.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("               AND I.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("               AND I.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("               AND I.QTA_TGT_CD  = 'D'" ).append("\n"); 
		query.append("               AND I.SQM_LVL_CD  = '1'" ).append("\n"); 
		query.append("               AND I.OFC_VW_CD   = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("               AND I.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("               AND I.BSE_TP_CD   = C.BSE_TP_CD  (+)" ).append("\n"); 
		query.append("               AND I.BSE_YR      = C.BSE_YR     (+)" ).append("\n"); 
		query.append("               AND I.BSE_QTR_CD  = C.BSE_QTR_CD (+)" ).append("\n"); 
		query.append("               AND I.TRD_CD      = C.TRD_CD     (+)" ).append("\n"); 
		query.append("               AND I.RLANE_CD    = C.RLANE_CD   (+)" ).append("\n"); 
		query.append("               AND I.DIR_CD      = C.DIR_CD     (+)" ).append("\n"); 
		query.append("          GROUP BY I.BSE_TP_CD" ).append("\n"); 
		query.append("                  ,I.BSE_YR" ).append("\n"); 
		query.append("                  ,I.BSE_QTR_CD" ).append("\n"); 
		query.append("                  ,I.OFC_VW_CD" ).append("\n"); 
		query.append("                  ,I.TRD_CD" ).append("\n"); 
		query.append("                  ,NVL(C.CONV_DIR_CD, I.DIR_CD)" ).append("\n"); 
		query.append("                  ,I.RHQ_CD" ).append("\n"); 
		query.append("         ) C2" ).append("\n"); 
		query.append("   WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("     AND C1.RHQ_CD     = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND C1.BSE_TP_CD   = C2.BSE_TP_CD   (+)" ).append("\n"); 
		query.append("     AND C1.BSE_YR      = C2.BSE_YR      (+)" ).append("\n"); 
		query.append("     AND C1.BSE_QTR_CD  = C2.BSE_QTR_CD  (+)" ).append("\n"); 
		query.append("     AND C1.OFC_VW_CD   = C2.OFC_VW_CD   (+)" ).append("\n"); 
		query.append("     AND C1.TRD_CD      = C2.TRD_CD      (+)" ).append("\n"); 
		query.append("     AND C1.CONV_DIR_CD = C2.CONV_DIR_CD (+)" ).append("\n"); 
		query.append("     AND C1.RHQ_CD      = C2.RHQ_CD      (+)" ).append("\n"); 
		query.append("ORDER BY C1.OFC_VW_CD" ).append("\n"); 
		query.append("        ,C1.TRD_CD" ).append("\n"); 
		query.append("        ,C1.CONV_DIR_CD" ).append("\n"); 
		query.append("        ,C1.RHQ_CD" ).append("\n"); 

	}
}