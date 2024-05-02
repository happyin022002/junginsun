/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CommonDBDAOSearchCommonCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.07.15 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CommonDBDAOSearchCommonCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SQM 에서 사용하는 목록성 코드조회
	  * 
	  * *History
	  * 2014.06.24 [CHM-201430703] 이혜민 SQM 신규 Office 등록 로직 변경(MDM+SQM_QTA_OFC)
	  * 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
	  * 2016.01.28 최성민 [CHM-201639851] Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
	  * 20160422 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * 2016.07.15 CHM-201642546 Allocation = QTA Adjustment 화면 Office Add 버튼 추가
	  * </pre>
	  */
	public CommonDBDAOSearchCommonCodeRSQL(){
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
		params.put("f_dur",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_qta_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year_wk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.common.integration").append("\n"); 
		query.append("FileName : CommonDBDAOSearchCommonCodeRSQL").append("\n"); 
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
		query.append("#if (${methodname} == 'searchYearList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Year 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT T_YEAR - CPY_NO CODE" ).append("\n"); 
		query.append("        ,T_YEAR - CPY_NO NAME" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("           SELECT 2013 AS F_YEAR" ).append("\n"); 
		query.append("                 ,TO_CHAR(SYSDATE, 'YYYY') + 1 AS T_YEAR" ).append("\n"); 
		query.append("             FROM DUAL" ).append("\n"); 
		query.append("         ) Y" ).append("\n"); 
		query.append("        ,COM_CPY_NO C" ).append("\n"); 
		query.append("   WHERE C.CPY_NO <= T_YEAR - F_YEAR" ).append("\n"); 
		query.append("ORDER BY C.CPY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchQuarterList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Quarter 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT INTG_CD_VAL_CTNT    AS CODE" ).append("\n"); 
		query.append("        ,INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   WHERE INTG_CD_ID        = 'CD01365'" ).append("\n"); 
		query.append("     AND INTG_CD_VAL_CTNT <> '00'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOfficeViewList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Office View 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT INTG_CD_VAL_CTNT    AS CODE" ).append("\n"); 
		query.append("        ,INTG_CD_VAL_DP_DESC AS NAME" ).append("\n"); 
		query.append("    FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("   WHERE INTG_CD_ID        = 'CD00940'" ).append("\n"); 
		query.append("     AND INTG_CD_VAL_DESC <> 'ALL'" ).append("\n"); 
		query.append("ORDER BY INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchMdmTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Trade 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT TRD_CD CODE" ).append("\n"); 
		query.append("        ,TRD_CD NAME" ).append("\n"); 
		query.append("    FROM MDM_TRADE" ).append("\n"); 
		query.append("   WHERE VSL_TP_CD = 'C'" ).append("\n"); 
		query.append("     AND DELT_FLG  = 'N'" ).append("\n"); 
		query.append("     AND TRD_CD   <> 'COM'" ).append("\n"); 
		query.append("ORDER BY TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sub Trade 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT " ).append("\n"); 
		query.append("         SUB_TRD_CD CODE" ).append("\n"); 
		query.append("        ,SUB_TRD_CD NAME" ).append("\n"); 
		query.append("    FROM MAS_LANE_RGST" ).append("\n"); 
		query.append("   WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != ''  && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND TRD_CD   = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRhqList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* RHQ 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         N2ND_PRNT_OFC_CD AS CODE" ).append("\n"); 
		query.append("        ,N2ND_PRNT_OFC_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_ORGANIZATION_V" ).append("\n"); 
		query.append("   WHERE N2ND_PRNT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("     AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOfcList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Office 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("--MDM과 SQM_QTA_OFC UNION 해서 가져옴" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("     N4TH_PRNT_OFC_CD AS CODE" ).append("\n"); 
		query.append("    ,N4TH_PRNT_OFC_CD AS NAME" ).append("\n"); 
		query.append("FROM SQM_ORGANIZATION_V" ).append("\n"); 
		query.append("WHERE N4TH_PRNT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append(" AND N2ND_PRNT_OFC_CD = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("   RGN_OFC_CD AS CODE" ).append("\n"); 
		query.append("  ,RGN_OFC_CD AS NAME" ).append("\n"); 
		query.append("FROM SQM_QTA_OFC " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append("AND RHQ_CD = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchHoTeamsList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* H/O Teams 목록을 조회한다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         TEAM_CD AS CODE" ).append("\n"); 
		query.append("        ,TEAM_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_DAT_RLT" ).append("\n"); 
		query.append("#if (${rhq} == 'Org')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/* RHQ 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         N2ND_PRNT_OFC_CD AS CODE" ).append("\n"); 
		query.append("        ,N2ND_PRNT_OFC_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_ORGANIZATION_V" ).append("\n"); 
		query.append("   WHERE N2ND_PRNT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("     AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCPeriodList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Create Period 기간을 가져온다 */" ).append("\n"); 
		query.append("SELECT MIN_YRWK || '~' || MAX_YRWK AS CODE" ).append("\n"); 
		query.append("      ,SUBSTR(MIN_YRWK, 1, 4) || '.wk' || SUBSTR(MIN_YRWK, 5, 2) || ' ~ ' || SUBSTR(MAX_YRWK, 1, 4) || '.wk' || SUBSTR(MAX_YRWK, 5, 2) AS NAME" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT /*+ index_desc(mas_wk_prd XPKMAS_WK_PRD) */" ).append("\n"); 
		query.append("                MIN(COST_YR||COST_WK) AS MIN_YRWK" ).append("\n"); 
		query.append("               ,MAX(COST_YR||COST_WK) AS MAX_YRWK" ).append("\n"); 
		query.append("           FROM MAS_WK_PRD" ).append("\n"); 
		query.append("          WHERE COST_YR||COST_WK <= @[f_year_wk]" ).append("\n"); 
		query.append("            AND ROWNUM           <= @[f_dur]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchNextQtaList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 현재 주차를 포함한 분기의 다음 분기를 가져온다 */" ).append("\n"); 
		query.append("SELECT DECODE(QTA, 1, COST_YR + 1, COST_YR) || '-' || QTA || 'Q' AS CODE" ).append("\n"); 
		query.append("      ,DECODE(QTA, 1, COST_YR + 1, COST_YR) || '-' || QTA || 'Q' AS NAME" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT COST_YR" ).append("\n"); 
		query.append("               ,CASE WHEN COST_WK <= 13 THEN 2" ).append("\n"); 
		query.append("                     WHEN COST_WK <= 26 THEN 3" ).append("\n"); 
		query.append("                     WHEN COST_WK <= 39 THEN 4" ).append("\n"); 
		query.append("                     WHEN COST_WK <= 53 THEN 1" ).append("\n"); 
		query.append("                 END QTA" ).append("\n"); 
		query.append("           FROM MAS_WK_PRD" ).append("\n"); 
		query.append("          WHERE TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'rhqForPlan')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* RHQ 목록을 조회한다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         RHQ_CD AS CODE" ).append("\n"); 
		query.append("        ,RHQ_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_QTA_OFC " ).append("\n"); 
		query.append("   WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'officeForPlan')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* OFC 목록을 조회한다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         RGN_OFC_CD AS CODE" ).append("\n"); 
		query.append("        ,RGN_OFC_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_QTA_OFC " ).append("\n"); 
		query.append("   WHERE RHQ_CD = (SELECT CASE WHEN @[rhq_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN RHQ_CD" ).append("\n"); 
		query.append("                                                                                                                            ELSE DECODE(@[rhq_cd], 'SELCMI', RHQ_CD, @[rhq_cd])" ).append("\n"); 
		query.append("                           END TEAM_CD" ).append("\n"); 
		query.append("                      FROM DUAL)" ).append("\n"); 
		query.append("     AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY RGN_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchGroupCustomer')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Group Customer 목록을 조회한다 */" ).append("\n"); 
		query.append("	SELECT DISTINCT" ).append("\n"); 
		query.append("       	   CUST_GRP_ID CODE" ).append("\n"); 
		query.append("          ,CUST_GRP_NM NAME" ).append("\n"); 
		query.append("	  FROM MDM_CUST_PERF_GRP" ).append("\n"); 
		query.append("	 WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${f_acc_grp_cd} != ''  && ${f_acc_grp_cd} == 'C')" ).append("\n"); 
		query.append("	   AND NEW_KEY_ACCT_FLG = 'Y' --> CORE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_acc_grp_cd} != ''  && ${f_acc_grp_cd} == 'R')" ).append("\n"); 
		query.append("	   AND RGN_ACCT_FLG ='Y'     --> REGION" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  ORDER BY CUST_GRP_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchVvdList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* VVD 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS CODE" ).append("\n"); 
		query.append("        ,VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_CFM_TGT_VVD" ).append("\n"); 
		query.append("   WHERE BSE_TP_CD  = 'Q'" ).append("\n"); 
		query.append("     AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("     AND QTA_TGT_CD = @[f_qta_tgt_cd]" ).append("\n"); 
		query.append("     AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("     AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("     AND SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("     AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("ORDER BY CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSpclVvdList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* VVD 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS CODE" ).append("\n"); 
		query.append("        ,VSL_CD || SKD_VOY_NO || SKD_DIR_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_SPCL_TGT_VVD" ).append("\n"); 
		query.append("   WHERE BSE_TP_CD  = 'Q'" ).append("\n"); 
		query.append("     AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND BSE_QTR_CD = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("     AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("     AND DIR_CD     = @[f_dir_cd]" ).append("\n"); 
		query.append("     AND SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("     AND RLANE_CD   = @[f_rlane_cd]" ).append("\n"); 
		query.append("ORDER BY CODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchAdjLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Adjustment 화면에서 사용하는 Lane 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         RLANE_CD AS CODE" ).append("\n"); 
		query.append("        ,RLANE_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_QTA_RLSE_VER A" ).append("\n"); 
		query.append("        ,SQM_CFM_TGT_VVD  B" ).append("\n"); 
		query.append("   WHERE A.QTA_RLSE_VER_NO = B.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("     AND A.BSE_TP_CD       = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND A.BSE_YR          = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND A.BSE_QTR_CD      = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("     AND A.SQM_VER_STS_CD  = 'R'" ).append("\n"); 
		query.append("     AND B.QTA_TGT_CD      = 'D'" ).append("\n"); 
		query.append("     AND B.TRD_CD          = @[f_trd_cd]" ).append("\n"); 
		query.append("     AND A.BSE_TP_CD       = B.BSE_TP_CD" ).append("\n"); 
		query.append("     AND A.BSE_YR          = B.BSE_YR" ).append("\n"); 
		query.append("     AND A.BSE_QTR_CD      = B.BSE_QTR_CD" ).append("\n"); 
		query.append("ORDER BY RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSpclAdjLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Spcl Adjustment 화면에서 사용하는 Lane 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         RLANE_CD AS CODE" ).append("\n"); 
		query.append("        ,RLANE_CD AS NAME" ).append("\n"); 
		query.append("    FROM SQM_SPCL_TGT_VVD" ).append("\n"); 
		query.append("   WHERE BSE_TP_CD  = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("     AND BSE_YR     = @[f_bse_yr]" ).append("\n"); 
		query.append("     AND BSE_QTR_CD = DECODE(@[f_bse_qtr_cd], 'All', BSE_QTR_CD, @[f_bse_qtr_cd])" ).append("\n"); 
		query.append("     AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("ORDER BY RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchMdmRLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       RLANE_CD AS CODE" ).append("\n"); 
		query.append("      ,RLANE_CD AS NAME" ).append("\n"); 
		query.append("  FROM MDM_DTL_REV_LANE" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND TRD_CD     = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND SUB_TRD_CD = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND DELT_FLG   = 'N'" ).append("\n"); 
		query.append(" ORDER BY SUBSTR(RLANE_CD,-2), RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRLaneList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Lane Master 상의 RLane 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.RLANE_CD AS CODE" ).append("\n"); 
		query.append("      ,A1.RLANE_CD AS NAME" ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("      ,MAS_LANE_RGST A2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_ias_rgn_cd} != '' && ${f_ias_rgn_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = A2.TRD_CD" ).append("\n"); 
		query.append("   AND A1.RLANE_CD    = A2.RLANE_CD" ).append("\n"); 
		query.append("   AND A2.IAS_RGN_CD  = @[f_ias_rgn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("ORDER BY A1.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchCurrentQtaList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* 현재 주차의 분기를 가져온다 */" ).append("\n"); 
		query.append("SELECT COST_YR || '-' || QTA || 'Q' AS CODE" ).append("\n"); 
		query.append("      ,COST_YR || '-' || QTA || 'Q' AS NAME" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT COST_YR" ).append("\n"); 
		query.append("               ,CASE WHEN COST_WK <= 13 THEN 1" ).append("\n"); 
		query.append("                     WHEN COST_WK <= 26 THEN 2" ).append("\n"); 
		query.append("                     WHEN COST_WK <= 39 THEN 3" ).append("\n"); 
		query.append("                     WHEN COST_WK <= 53 THEN 4" ).append("\n"); 
		query.append("                 END QTA" ).append("\n"); 
		query.append("           FROM MAS_WK_PRD" ).append("\n"); 
		query.append("          WHERE TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubTradeSectorList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sub Trade Sector 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       SUB_TRD_CD CODE" ).append("\n"); 
		query.append("      ,SUB_TRD_CD NAME" ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_MGMT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND IAS_SCTR_FLG IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPolCdSectorList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* R/Lane에 따른 POL Sector 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       POL_CD CODE" ).append("\n"); 
		query.append("      ,POL_CD NAME" ).append("\n"); 
		query.append("#if (${tb_nm} == 'sqm_sctr_pair_mgmt')" ).append("\n"); 
		query.append("FROM SQM_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("#elseif (${tb_nm} == 'sqm_sctr_lane_ofc')" ).append("\n"); 
		query.append("FROM SQM_SCTR_LANE_OFC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("AND RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("ORDER BY POL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPodCdSectorList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* R/Lane에 따른 POD Sector 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       POD_CD CODE" ).append("\n"); 
		query.append("      ,POD_CD NAME" ).append("\n"); 
		query.append("#if (${tb_nm} == 'sqm_sctr_pair_mgmt')" ).append("\n"); 
		query.append("FROM SQM_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("#elseif (${tb_nm} == 'sqm_sctr_lane_ofc')" ).append("\n"); 
		query.append("FROM SQM_SCTR_LANE_OFC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("AND RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("ORDER BY POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPolCdSectorMultiList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Multi R/Lane에 따른 POL Sector 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       POL_CD CODE" ).append("\n"); 
		query.append("      ,POL_CD NAME" ).append("\n"); 
		query.append("FROM SQM_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_act_flag} != 'N')" ).append("\n"); 
		query.append("AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND RLANE_CD IN ( ${f_rlane_cd} )" ).append("\n"); 
		query.append("ORDER BY POL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPodCdSectorMultiList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Multi R/Lane에 따른 POD Sector 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       POD_CD CODE" ).append("\n"); 
		query.append("      ,POD_CD NAME" ).append("\n"); 
		query.append("FROM SQM_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_act_flag} != 'N')" ).append("\n"); 
		query.append("AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND RLANE_CD IN ( ${f_rlane_cd} )" ).append("\n"); 
		query.append("ORDER BY POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- OverAll의 Trade 정보를 조회한다.(SQM_QTA_LANE_MGMT 테이블에서 Sector Sale 정보를 제외하고 조회)" ).append("\n"); 
		query.append("-- Sector Trade 제외되는 로직 삭제" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       TRD_CD CODE" ).append("\n"); 
		query.append("      ,TRD_CD NAME" ).append("\n"); 
		query.append("  FROM SQM_QTA_LANE_MGMT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND SQM_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append(" ORDER BY TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPfGroupList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- PF Group List 콤보의 목록을 가져온다." ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       RLANE_CD||'|'||PF_GRP_CD NAME" ).append("\n"); 
		query.append("      ,PF_GRP_CD CODE" ).append("\n"); 
		query.append("#if (${tb_nm} == 'sqm_sctr_pair_mgmt')" ).append("\n"); 
		query.append("FROM SQM_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("#elseif (${tb_nm} == 'sqm_sctr_lane_ofc')" ).append("\n"); 
		query.append("FROM SQM_SCTR_LANE_OFC" ).append("\n"); 
		query.append("#elseif (${tb_nm} == 'sqm_sctr_pf_grp')" ).append("\n"); 
		query.append("FROM SQM_SCTR_PF_GRP" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RLANE_CD IN (${f_rlane_cd})" ).append("\n"); 
		query.append("ORDER BY NAME, CODE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLaneRHQList')" ).append("\n"); 
		query.append(" SELECT DISTINCT RHQ_CD CODE" ).append("\n"); 
		query.append("      , RHQ_CD NAME" ).append("\n"); 
		query.append("   FROM SQM_QTA_LANE_OFC" ).append("\n"); 
		query.append("  WHERE BSE_TP_CD   = 'Q'" ).append("\n"); 
		query.append("    AND OFC_VW_CD   = 'L'" ).append("\n"); 
		query.append("    AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("    AND BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("    AND TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchLaneOfficeList')" ).append("\n"); 
		query.append(" SELECT DISTINCT RGN_OFC_CD CODE" ).append("\n"); 
		query.append("      , RGN_OFC_CD NAME" ).append("\n"); 
		query.append("   FROM SQM_QTA_LANE_OFC" ).append("\n"); 
		query.append("  WHERE BSE_TP_CD   = 'Q'" ).append("\n"); 
		query.append("    AND OFC_VW_CD   = 'L'" ).append("\n"); 
		query.append("    AND SQM_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("    AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("    AND BSE_QTR_CD  = @[f_bse_qtr_cd]" ).append("\n"); 
		query.append("    AND TRD_CD      = @[f_trd_cd]" ).append("\n"); 
		query.append("    AND RLANE_CD    = @[f_rlane_cd]" ).append("\n"); 
		query.append("    AND RHQ_CD      = @[f_rhq_cd]" ).append("\n"); 
		query.append("ORDER BY RGN_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}