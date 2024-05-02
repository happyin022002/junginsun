/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchCommonCodeForPlanningRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchCommonCodeForPlanningRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * planning단계에서의 콤보를 정의한다.
	  * 
	  * *History
	  * 2014.03.25 이혜민 선조치                QTA Adjustment by VVD 화면 검색조건 로직 수정
	  * 2014.08.01 이혜민 CHM-201431396 Portion Adjustment by Head Office/RHQ 화면내 Row Add 추가
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2015.07.09 김용습 [CHM-201536817] [CSR 전환건] Final QTA Adjustment > Post QTA Adjustment > QTA Edit for IAS Sector 화면 내 Week 조회 로직 수정
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public CommonDBDAOSearchCommonCodeForPlanningRSQL(){
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
		params.put("f_ofc_org_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_ob_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchCommonCodeForPlanningRSQL").append("\n"); 
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
		query.append("#if (${methodname} == 'searchTradeControl')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Trade 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT         " ).append("\n"); 
		query.append("       A1.TRD_CD AS CODE" ).append("\n"); 
		query.append("      ,A1.TRD_CD AS NAME   " ).append("\n"); 
		query.append(" FROM SQM_DAT_RLT A1" ).append("\n"); 
		query.append("WHERE A1.BSE_TP_CD     = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND A1.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND A1.BSE_QTR_CD    = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("  AND A1.OFC_VW_CD     = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("  AND A1.TEAM_CD       = (SELECT CASE WHEN @[f_ofc_org_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN TEAM_CD" ).append("\n"); 
		query.append("                                                                                                                                       ELSE @[f_ofc_org_cd]" ).append("\n"); 
		query.append("                                 END TEAM_CD" ).append("\n"); 
		query.append("                            FROM DUAL)" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("  AND A1.RHQ_CD        = (SELECT CASE WHEN @[f_ofc_org_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN RHQ_CD" ).append("\n"); 
		query.append("                                                                                                                                       ELSE DECODE(@[f_ofc_org_cd], 'SELCMI', RHQ_CD, @[f_ofc_org_cd])" ).append("\n"); 
		query.append("                                 END TEAM_CD" ).append("\n"); 
		query.append("                            FROM DUAL)" ).append("\n"); 
		query.append("  AND A1.OB_DIV_CD     = DECODE(@[f_ob_div_cd],'All',OB_DIV_CD,@[f_ob_div_cd])" ).append("\n"); 
		query.append("  AND A1.TRD_CD = DECODE(@[f_ofc_org_cd], 'SELCMI', 'IAS', A1.TRD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  -- 20143Q 부터 IAS Sector Sales 판매 시작으로 Over All에서 제외시킴" ).append("\n"); 
		query.append("--  AND 1 = CASE WHEN A1.BSE_YR || A1.BSE_QTR_CD > '20142Q' " ).append("\n"); 
		query.append("--                    THEN (" ).append("\n"); 
		query.append("--                            SELECT DISTINCT 1" ).append("\n"); 
		query.append("--                              FROM SQM_QTA_LANE_MGMT S1" ).append("\n"); 
		query.append("--                             WHERE S1.TRD_CD = A1.TRD_CD" ).append("\n"); 
		query.append("--                               AND S1.IAS_SCTR_FLG IS NULL" ).append("\n"); 
		query.append("--                         )" ).append("\n"); 
		query.append("--          ELSE 1" ).append("\n"); 
		query.append("--     END" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchrLaneControl')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Rlane 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT         " ).append("\n"); 
		query.append("       MGMT.RLANE_CD AS CODE,  " ).append("\n"); 
		query.append("       MGMT.RLANE_CD AS NAME   " ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_OFC MGMT" ).append("\n"); 
		query.append("      ,SQM_DAT_RLT RLT " ).append("\n"); 
		query.append("WHERE RLT.BSE_TP_CD     = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND RLT.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND RLT.BSE_QTR_CD    = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '')" ).append("\n"); 
		query.append("  AND RLT.OFC_VW_CD     = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND RLT.TRD_CD        = @[f_trd_cd]" ).append("\n"); 
		query.append("  AND RLT.TRD_CD        = MGMT.TRD_CD" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("  AND RLT.TEAM_CD       = (SELECT CASE WHEN @[f_ofc_org_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN RLT.TEAM_CD" ).append("\n"); 
		query.append("                                                                                                                                           ELSE @[f_ofc_org_cd]" ).append("\n"); 
		query.append("                                   END TEAM_CD" ).append("\n"); 
		query.append("                             FROM DUAL)" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("  AND RLT.RHQ_CD        = (SELECT CASE WHEN @[f_ofc_org_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN RLT.RHQ_CD" ).append("\n"); 
		query.append("                                                                                                                                           ELSE DECODE(@[f_ofc_org_cd], 'SELCMI', RLT.RHQ_CD, @[f_ofc_org_cd])" ).append("\n"); 
		query.append("                                   END RHQ_CD" ).append("\n"); 
		query.append("                             FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  AND MGMT.RLANE_CD    = DECODE(RLT.RLANE_CD,'All',MGMT.RLANE_CD,RLT.RLANE_CD)" ).append("\n"); 
		query.append("  AND MGMT.SQM_ACT_FLG = 'Y'  " ).append("\n"); 
		query.append("ORDER BY MGMT.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchActiveOfc')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Office 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.RGN_OFC_CD AS CODE" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD AS NAME" ).append("\n"); 
		query.append(" FROM SQM_QTA_OFC A1" ).append("\n"); 
		query.append("     ,SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append("WHERE A1.RHQ_CD        = @[f_rhq_cd]" ).append("\n"); 
		query.append("  AND A2.BSE_TP_CD     = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("  AND A2.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND A2.BSE_QTR_CD    = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("  AND A2.OFC_VW_CD     = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("  AND A1.RHQ_CD        = A2.RHQ_CD" ).append("\n"); 
		query.append("  AND A1.RGN_OFC_CD    = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("  AND A1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("  AND A2.SQM_ACT_FLG   = 'Y'" ).append("\n"); 
		query.append("ORDER BY A1.RGN_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchMonth')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Month 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT BSE_MON AS CODE" ).append("\n"); 
		query.append("        ,BSE_MON AS NAME" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT '1Q' QTR_CD,'01' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '1Q' QTR_CD,'02' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '1Q' QTR_CD,'03' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '2Q' QTR_CD,'04' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '2Q' QTR_CD,'05' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '2Q' QTR_CD,'06' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '3Q' QTR_CD,'07' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '3Q' QTR_CD,'08' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '3Q' QTR_CD,'09' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '4Q' QTR_CD,'10' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '4Q' QTR_CD,'11' BSE_MON FROM DUAL UNION ALL" ).append("\n"); 
		query.append("            SELECT '4Q' QTR_CD,'12' BSE_MON FROM DUAL            " ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  WHERE QTR_CD = NVL(@[f_bse_qtr_cd],QTR_CD)" ).append("\n"); 
		query.append("  ORDER BY BSE_MON" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchWeek')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Week 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT BSE_WK AS CODE" ).append("\n"); 
		query.append("        ,BSE_WK AS NAME" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT '1Q' QTR_CD" ).append("\n"); 
		query.append("                  ,'00' BSE_WK " ).append("\n"); 
		query.append("              FROM DUAL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT CASE WHEN LEVEL < 14 THEN '1Q'" ).append("\n"); 
		query.append("                        WHEN LEVEL < 27 THEN '2Q'" ).append("\n"); 
		query.append("                        WHEN LEVEL < 40 THEN '3Q'" ).append("\n"); 
		query.append("                   ELSE '4Q'" ).append("\n"); 
		query.append("                   END AS QTR_CD" ).append("\n"); 
		query.append("                  ,CASE WHEN LEVEL < 10 THEN '0'||LEVEL" ).append("\n"); 
		query.append("                   ELSE TO_CHAR(LEVEL) " ).append("\n"); 
		query.append("                   END AS BSE_WK" ).append("\n"); 
		query.append("             FROM DUAL CONNECT BY LEVEL < 54 " ).append("\n"); 
		query.append("         )" ).append("\n"); 
		query.append("  WHERE QTR_CD = NVL(@[f_bse_qtr_cd],QTR_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchBoundControl')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Bound 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       CONV_DIR_CD AS CODE" ).append("\n"); 
		query.append("      ,CONV_DIR_CD AS NAME" ).append("\n"); 
		query.append("  FROM SQM_QTA_STEP_VER" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_gubun} == 'HO')" ).append("\n"); 
		query.append("   AND SUBSTR(QTA_VER_NO,4,6) = (SELECT CASE WHEN @[f_ofc_org_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN SUBSTR(QTA_VER_NO,4,6)" ).append("\n"); 
		query.append("                                                                                                                                                 ELSE DECODE(@[f_ofc_org_cd], 'SELCMI', SUBSTR(QTA_VER_NO,4,6), @[f_ofc_org_cd])" ).append("\n"); 
		query.append("                                         END TEAM_CD" ).append("\n"); 
		query.append("                                   FROM DUAL)" ).append("\n"); 
		query.append("#elseif (${f_gubun} == 'RHQ')" ).append("\n"); 
		query.append("   AND SUBSTR(QTA_VER_NO,4,5) = (SELECT CASE WHEN @[f_ofc_org_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN SUBSTR(QTA_VER_NO,4,5)" ).append("\n"); 
		query.append("                                                                                                                                                 ELSE DECODE(@[f_ofc_org_cd], 'SELCMI', SUBSTR(QTA_VER_NO,4,5), @[f_ofc_org_cd])" ).append("\n"); 
		query.append("                                         END TEAM_CD" ).append("\n"); 
		query.append("                                   FROM DUAL)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND  BSE_TP_CD               = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND  BSE_YR                  = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND  BSE_QTR_CD              = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_ofc_vw_cd} != '')" ).append("\n"); 
		query.append("   AND  OFC_VW_CD               = @[f_ofc_vw_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   and  QTA_STEP_CD             = NVL(@[f_qta_step_cd],QTA_STEP_CD)" ).append("\n"); 
		query.append("   AND  TRD_CD                  = @[f_trd_cd]" ).append("\n"); 
		query.append(" ORDER BY CONV_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRLaneSector')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sector Lane 목록을 가져온다. */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      DISTINCT " ).append("\n"); 
		query.append("      A1.RLANE_CD AS CODE" ).append("\n"); 
		query.append("    , A1.RLANE_CD AS NAME" ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("      ,MAS_LANE_RGST A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.TRD_CD   = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A1.IAS_SCTR_FLG IS NOT NULL" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.IAS_RGN_CD = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A1.RLANE_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRLaneControlSectorList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sector Lane 목록을 가져온다. */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      DISTINCT " ).append("\n"); 
		query.append("      A1.RLANE_CD AS CODE" ).append("\n"); 
		query.append("    , A1.RLANE_CD AS NAME" ).append("\n"); 
		query.append("  FROM SQM_SCTR_PF_GRP A1" ).append("\n"); 
		query.append("      ,MAS_LANE_RGST A2" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A2.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("   AND A2.IAS_RGN_CD = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A1.RLANE_CD  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRLaneGroupList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--노선의 VVD 정보를 가지고 온다." ).append("\n"); 
		query.append("SELECT DISTINCT RLANE_CD||DIR_CD CODE" ).append("\n"); 
		query.append("      ,VSL_CD||SKD_VOY_NO||SKD_DIR_CD NAME " ).append("\n"); 
		query.append("  FROM SQM_CFM_TGT_VVD " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BSE_TP_CD   = 'Q'" ).append("\n"); 
		query.append("   AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND TRD_CD      = NVL(@[f_trd_cd], TRD_CD) " ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY CODE" ).append("\n"); 
		query.append("   		 ,NAME " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchBSAList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT CODE, NAME" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT DISTINCT" ).append("\n"); 
		query.append("               A1.RLANE_CD" ).append("\n"); 
		query.append("              ,A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("              ,MAX(A2.RANGE_BSA)+9 CODE" ).append("\n"); 
		query.append("              ,MAX(A2.RANGE_BSA)+9 NAME --차이가 0~9 사이일 경우 큰 BSA를 대표로 그룹핑한다." ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                        SELECT DISTINCT" ).append("\n"); 
		query.append("                               RLANE_CD" ).append("\n"); 
		query.append("                              ,DIR_CD" ).append("\n"); 
		query.append("                              ,FNL_BSA_CAPA" ).append("\n"); 
		query.append("                          FROM SQM_QTA_TGT_VVD" ).append("\n"); 
		query.append("                         WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                           AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                           AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                           AND TRD_CD     = 'IAS'" ).append("\n"); 
		query.append("                           AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("                           AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append("                         ORDER BY DIR_CD, RLANE_CD,FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("               ) A1" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                        SELECT DISTINCT RLANE_CD, DIR_CD, FNL_BSA_CAPA, FNL_BSA_CAPA - 9 AS RANGE_BSA" ).append("\n"); 
		query.append("                          FROM SQM_QTA_TGT_VVD" ).append("\n"); 
		query.append("                         WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("                           AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("                           AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("                           AND TRD_CD     = 'IAS'" ).append("\n"); 
		query.append("                           AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("                         ORDER BY DIR_CD, RLANE_CD, FNL_BSA_CAPA DESC" ).append("\n"); 
		query.append("               ) A2" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND A1.DIR_CD        = A2.DIR_CD" ).append("\n"); 
		query.append("           AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("           AND A1.FNL_BSA_CAPA >= A2.RANGE_BSA" ).append("\n"); 
		query.append("         GROUP BY A1.RLANE_CD, A1.FNL_BSA_CAPA" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT GRP_BSA_CAPA, GRP_BSA_CAPA" ).append("\n"); 
		query.append("  FROM SQM_SCTR_ADD_TGT_VVD" ).append("\n"); 
		query.append(" WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND TRD_CD     = 'IAS'" ).append("\n"); 
		query.append("   AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("ORDER BY NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLaneOfcList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--Rlane 정보를 가지고 온다." ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       RLANE_CD CODE" ).append("\n"); 
		query.append("      ,RLANE_CD NAME " ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_OFC " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd], 'Y', '00', @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("   AND TRD_CD      = NVL(@[f_trd_cd], TRD_CD) " ).append("\n"); 
		query.append(" ORDER BY CODE" ).append("\n"); 
		query.append("   		 ,NAME " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRhqListByPortion')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Portion Adjustment 시트 내 RHQ 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.RHQ_CD AS CODE" ).append("\n"); 
		query.append("      ,A1.RHQ_CD AS NAME" ).append("\n"); 
		query.append(" FROM SQM_QTA_OFC A1" ).append("\n"); 
		query.append("     ,SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A2.BSE_TP_CD     = 'Q'" ).append("\n"); 
		query.append("  AND A2.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND A2.BSE_QTR_CD    = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("  AND A2.OFC_VW_CD     = SUBSTR(@[f_ofc_vw_cd],0, 1)" ).append("\n"); 
		query.append("  AND A2.TRD_CD        = @[f_trd_cd]" ).append("\n"); 
		query.append("  AND A2.RLANE_CD      = @[f_rlane_cd]" ).append("\n"); 
		query.append("  AND A2.DIR_CD        = @[f_dir_cd]" ).append("\n"); 
		query.append("  AND A1.RHQ_CD        = A2.RHQ_CD" ).append("\n"); 
		query.append("  AND A1.RGN_OFC_CD    = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("  AND A1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("  AND A2.SQM_ACT_FLG   = 'Y'" ).append("\n"); 
		query.append("ORDER BY A1.RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOfcListByPortion')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Portion Adjustment 시트 내  Office 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.RGN_OFC_CD AS CODE" ).append("\n"); 
		query.append("      ,A1.RGN_OFC_CD AS NAME" ).append("\n"); 
		query.append(" FROM SQM_QTA_OFC A1" ).append("\n"); 
		query.append("     ,SQM_QTA_LANE_OFC A2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A2.BSE_TP_CD     = 'Q'" ).append("\n"); 
		query.append("  AND A2.BSE_YR        = @[f_bse_yr]" ).append("\n"); 
		query.append("  AND A2.BSE_QTR_CD    = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("  AND A2.OFC_VW_CD     = SUBSTR(@[f_ofc_vw_cd],0, 1)" ).append("\n"); 
		query.append("  AND A2.TRD_CD        = @[f_trd_cd]" ).append("\n"); 
		query.append("  AND A2.RLANE_CD      = @[f_rlane_cd]" ).append("\n"); 
		query.append("  AND A2.DIR_CD        = @[f_dir_cd]" ).append("\n"); 
		query.append("  and A1.RHQ_CD        = @[f_rhq_cd]" ).append("\n"); 
		query.append("  AND A1.RHQ_CD        = A2.RHQ_CD" ).append("\n"); 
		query.append("  AND A1.RGN_OFC_CD    = A2.RGN_OFC_CD" ).append("\n"); 
		query.append("  AND A1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("  AND A2.SQM_ACT_FLG   = 'Y'" ).append("\n"); 
		query.append("ORDER BY A1.RGN_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRevisedWeekForSector')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* QTA Edit for IAS Sector 화면의 Week 콤보  */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT A1.BSE_WK CODE, A1.BSE_WK NAME" ).append("\n"); 
		query.append(" FROM SQM_CFM_TGT_VVD A1, MAS_LANE_RGST A3, SQM_CFM_QTA A4" ).append("\n"); 
		query.append("  WHERE 1=1" ).append("\n"); 
		query.append("   AND A1.TRD_CD          = A3.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD        = A3.RLANE_CD" ).append("\n"); 
		query.append("   AND A1.DIR_CD          = A3.DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A1.QTA_RLSE_VER_NO = A4.QTA_RLSE_VER_NO(+)" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD       = A4.BSE_TP_CD(+)" ).append("\n"); 
		query.append("   AND A1.BSE_YR          = A4.BSE_YR(+)" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD      = A4.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("   AND A1.TRD_CD          = A4.TRD_CD(+)" ).append("\n"); 
		query.append("   AND A1.RLANE_CD        = A4.RLANE_CD(+)" ).append("\n"); 
		query.append("   AND A1.DIR_CD          = A4.DIR_CD(+)" ).append("\n"); 
		query.append("   AND A1.VSL_CD          = A4.VSL_CD(+)" ).append("\n"); 
		query.append("   AND A1.SKD_VOY_NO      = A4.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND A1.SKD_DIR_CD      = A4.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND A4.OFC_VW_CD(+)    = 'L'" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD      = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("   AND A1.QTA_RLSE_VER_NO = SUBSTR(@[f_bse_yr],-2) ||@[f_bse_qtr_cd]||'02'" ).append("\n"); 
		query.append("   AND A1.BSE_YR || A1.BSE_QTR_CD >= '20143Q'" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.RLANE_CD        = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD      = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.DIR_CD          = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.IAS_RGN_CD      = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_dir} == 'on' && ${f_hul_bnd_cd} != '' && ${f_hul_bnd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A3.HUL_BND_CD       = @[f_hul_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND EXISTS (" ).append("\n"); 
		query.append("                SELECT DISTINCT 1" ).append("\n"); 
		query.append("                 FROM SQM_SCTR_PAIR_MGMT S1" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND S1.BSE_TP_CD  = A1.BSE_TP_CD" ).append("\n"); 
		query.append("                    AND S1.BSE_YR     = A1.BSE_YR" ).append("\n"); 
		query.append("                    AND S1.BSE_QTR_CD = A1.BSE_QTR_CD" ).append("\n"); 
		query.append("                    AND S1.TRD_CD     = A1.TRD_CD" ).append("\n"); 
		query.append("                    AND S1.RLANE_CD   = A1.RLANE_CD" ).append("\n"); 
		query.append("                    AND S1.DIR_CD     = A1.DIR_CD" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("    ORDER BY CODE							" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRevisedWeekForOverall')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* QTA Edit 화면의 Week 콤보  */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT BSE_WK CODE, BSE_WK NAME FROM SQM_CFM_TGT_VVD A, MAS_LANE_RGST B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.BSE_YR = @[f_bse_yr]" ).append("\n"); 
		query.append("AND A.BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("AND A.QTA_RLSE_VER_NO = SUBSTR(@[f_bse_yr],-2) ||@[f_bse_qtr_cd]||'02'" ).append("\n"); 
		query.append("AND A.TRD_CD = B.TRD_CD" ).append("\n"); 
		query.append("AND A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.DIR_CD = B.DIR_CD" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("AND A.TRD_CD = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_rlane_cd} != '' && ${f_rlane_cd} != 'All')" ).append("\n"); 
		query.append("AND A.RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_gubun} != 'on' && ${f_dir_cd} != '' && ${f_dir_cd} != 'All')" ).append("\n"); 
		query.append("AND A.DIR_CD = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_gubun} == 'on' && ${f_trd_dir} != '' && ${f_trd_dir} != 'All')" ).append("\n"); 
		query.append("AND B.HUL_BND_CD = @[f_trd_dir]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BSE_WK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}