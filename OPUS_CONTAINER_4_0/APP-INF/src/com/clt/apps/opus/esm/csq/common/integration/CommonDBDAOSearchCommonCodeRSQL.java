/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CommonDBDAOSearchCommonCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.common.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
	  * CSQ 에서 사용하는 목록성 코드조회
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
		params.put("f_qta_tgt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_dur",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.csq.common.integration").append("\n"); 
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
		query.append("  SELECT T_YEAR - CPY_NO CODE " ).append("\n"); 
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
		query.append("#elseif (${methodname} == 'searchMdmSubTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sub Trade 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT " ).append("\n"); 
		query.append("         SUB_TRD_CD CODE" ).append("\n"); 
		query.append("        ,SUB_TRD_CD NAME" ).append("\n"); 
		query.append("    FROM COA_LANE_RGST" ).append("\n"); 
		query.append("   WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != ''  && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("     AND TRD_CD   = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sub Trade 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       SUB_TRD_CD CODE" ).append("\n"); 
		query.append("      ,SUB_TRD_CD NAME" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_MGMT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${sector_include} != 'Y')" ).append("\n"); 
		query.append("   AND IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND TRD_CD      = NVL(@[f_trd_cd], TRD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRhqList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* RHQ 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         N2ND_PRNT_OFC_CD AS CODE" ).append("\n"); 
		query.append("        ,N2ND_PRNT_OFC_CD AS NAME" ).append("\n"); 
		query.append("    FROM CSQ_ORGANIZATION_V" ).append("\n"); 
		query.append("   WHERE N2ND_PRNT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("     AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY N2ND_PRNT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchOfcList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Office 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("--MDM과 CSQ_QTA_OFC UNION 해서 가져옴" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("     N4TH_PRNT_OFC_CD AS CODE" ).append("\n"); 
		query.append("    ,N4TH_PRNT_OFC_CD AS NAME" ).append("\n"); 
		query.append("FROM CSQ_ORGANIZATION_V" ).append("\n"); 
		query.append("WHERE N4TH_PRNT_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("#if (${f_rhq_cd} != '' && ${f_rhq_cd} != 'All')" ).append("\n"); 
		query.append(" AND N2ND_PRNT_OFC_CD = @[f_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("   RGN_OFC_CD AS CODE" ).append("\n"); 
		query.append("  ,RGN_OFC_CD AS NAME" ).append("\n"); 
		query.append("FROM CSQ_QTA_OFC " ).append("\n"); 
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
		query.append("    FROM CSQ_DAT_RLT" ).append("\n"); 
		query.append("#if (${rhq} == 'Org')" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/* RHQ 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         N2ND_PRNT_OFC_CD AS CODE" ).append("\n"); 
		query.append("        ,N2ND_PRNT_OFC_CD AS NAME" ).append("\n"); 
		query.append("    FROM CSQ_ORGANIZATION_V" ).append("\n"); 
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
		query.append("         SELECT /*+ index_desc(coa_wk_prd XPKCOA_WK_PRD) */" ).append("\n"); 
		query.append("                MIN(COST_YR||COST_WK) AS MIN_YRWK" ).append("\n"); 
		query.append("               ,MAX(COST_YR||COST_WK) AS MAX_YRWK" ).append("\n"); 
		query.append("           FROM COA_WK_PRD" ).append("\n"); 
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
		query.append("           FROM COA_WK_PRD" ).append("\n"); 
		query.append("          WHERE TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'rhqForPlan')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* RHQ 목록을 조회한다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         RHQ_CD AS CODE" ).append("\n"); 
		query.append("        ,RHQ_CD AS NAME" ).append("\n"); 
		query.append("    FROM CSQ_QTA_OFC " ).append("\n"); 
		query.append("   WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY RHQ_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'officeForPlan')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* OFC 목록을 조회한다 */" ).append("\n"); 
		query.append("  SELECT DISTINCT" ).append("\n"); 
		query.append("         RGN_OFC_CD AS CODE" ).append("\n"); 
		query.append("        ,RGN_OFC_CD AS NAME" ).append("\n"); 
		query.append("    FROM CSQ_QTA_OFC " ).append("\n"); 
		query.append("   WHERE RHQ_CD = (SELECT CASE WHEN @[rhq_cd] IN (SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03255') THEN RHQ_CD" ).append("\n"); 
		query.append("                                                                                                                            ELSE @[rhq_cd]" ).append("\n"); 
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
		query.append("    FROM CSQ_CFM_TGT_VVD" ).append("\n"); 
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
		query.append("/* Lane Master 상의 Overall RLane 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.RLANE_CD AS CODE" ).append("\n"); 
		query.append("      ,A1.RLANE_CD AS NAME" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = NVL(@[f_trd_cd], A1.TRD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${sector_include} != 'Y')" ).append("\n"); 
		query.append("   AND A1.IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A1.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchRLaneSectorList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Lane Master 상의 Sector RLane 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       A1.RLANE_CD AS CODE" ).append("\n"); 
		query.append("      ,A1.RLANE_CD AS NAME" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_MGMT A1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.TRD_CD      = NVL(@[f_trd_cd], A1.TRD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND A1.BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND A1.BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${f_sub_trd_cd} != '' && ${f_sub_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND A1.SUB_TRD_CD  = @[f_sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A1.CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A1.IAS_SCTR_FLG = 'Y'" ).append("\n"); 
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
		query.append("           FROM COA_WK_PRD" ).append("\n"); 
		query.append("          WHERE TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN SLS_FM_DT AND SLS_TO_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchTradeList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- OverAll 또는 Sector를 포함한 전체 Trade 정보를 조회한다" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       TRD_CD CODE" ).append("\n"); 
		query.append("      ,TRD_CD NAME" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_MGMT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CSQ_ACT_FLG  = 'Y'" ).append("\n"); 
		query.append("   AND BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("#if (${sector_include} != 'Y')" ).append("\n"); 
		query.append("   AND IAS_SCTR_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchPfGroupList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- PF Group List 콤보의 목록을 가져온다." ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       RLANE_CD||'|'||PF_GRP_CD NAME" ).append("\n"); 
		query.append("      ,PF_GRP_CD CODE" ).append("\n"); 
		query.append("#if (${tb_nm} == 'csq_sctr_pair_mgmt')" ).append("\n"); 
		query.append("FROM CSQ_SCTR_PAIR_MGMT" ).append("\n"); 
		query.append("#elseif (${tb_nm} == 'csq_sctr_lane_ofc')" ).append("\n"); 
		query.append("FROM CSQ_SCTR_LANE_OFC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND RLANE_CD IN (${f_rlane_cd})" ).append("\n"); 
		query.append("ORDER BY NAME, CODE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${methodname} == 'searchSubTradeSectorList')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Sub Trade Sector 콤보의 목록을 가져온다 */" ).append("\n"); 
		query.append("SELECT DISTINCT " ).append("\n"); 
		query.append("       SUB_TRD_CD CODE" ).append("\n"); 
		query.append("      ,SUB_TRD_CD NAME" ).append("\n"); 
		query.append("  FROM CSQ_QTA_LANE_MGMT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND CSQ_ACT_FLG = 'Y'" ).append("\n"); 
		query.append("   AND IAS_SCTR_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${f_trd_cd} != '' && ${f_trd_cd} != 'All')" ).append("\n"); 
		query.append("   AND TRD_CD      = NVL(@[f_trd_cd], TRD_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND BSE_TP_CD   = @[f_bse_tp_cd]" ).append("\n"); 
		query.append("   AND BSE_YR      = @[f_bse_yr]" ).append("\n"); 
		query.append("   AND BSE_QTR_CD  = DECODE(@[f_bse_tp_cd],'Y','00',@[f_bse_qtr_cd])" ).append("\n"); 
		query.append("ORDER BY SUB_TRD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}