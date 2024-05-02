/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOGNAExpCreByOfcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOGNAExpCreByOfcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public NetworkCostDBDAOGNAExpCreByOfcCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOGNAExpCreByOfcCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_GEN_EXPN_OFC_STUP(" ).append("\n"); 
		query.append("	COST_YRMON" ).append("\n"); 
		query.append("	, OFC_CD" ).append("\n"); 
		query.append("	, LOCL_CURR_CD" ).append("\n"); 
		query.append("	, OFC_GRP_NO" ).append("\n"); 
		query.append("	, BUD_LOCL_AMT" ).append("\n"); 
		query.append("	, BUD_USD_AMT" ).append("\n"); 
		query.append("	, EXPN_USD_AMT" ).append("\n"); 
		query.append("	, USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WITH " ).append("\n"); 
		query.append("ORG_TREE AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT LEVEL AS LVL, A.PRNT_OFC_CD, A.OFC_CD, A.OFC_TP_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(" START WITH OFC_CD = 'SELHO'" ).append("\n"); 
		query.append(" CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", ORG_TREE_NOT_HO AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT OFC_CD" ).append("\n"); 
		query.append("     , NVL(SUBSTR(SYS_CONNECT_BY_PATH(OFC_CD, ','), 2, INSTR(SYS_CONNECT_BY_PATH(OFC_CD, ','), ',', 1, 2) - 2)" ).append("\n"); 
		query.append("          , OFC_CD) " ).append("\n"); 
		query.append("       AS REP_OFC_CD" ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append(" START WITH OFC_CD IN (" ).append("\n"); 
		query.append("                       SELECT OFC_CD" ).append("\n"); 
		query.append("                         FROM ORG_TREE" ).append("\n"); 
		query.append("                        WHERE LVL = 4" ).append("\n"); 
		query.append("                          AND OFC_TP_CD IN ('BB', 'BA')" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append(" CONNECT BY PRIOR OFC_CD = PRNT_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", GEN_BUDGET_INIT AS -- USING GEM MODULE MENU QUERY" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.OFC_CD" ).append("\n"); 
		query.append("      ,B.LOCL_CURR_CD" ).append("\n"); 
		query.append("      ,SUM(A.JAN_AMT * NVL(B.RQST_UT_VAL, 1)) JAN_AMT   " ).append("\n"); 
		query.append("      ,SUM(A.FEB_AMT * NVL(B.RQST_UT_VAL, 1)) FEB_AMT   " ).append("\n"); 
		query.append("      ,SUM(A.MAR_AMT * NVL(B.RQST_UT_VAL, 1)) MAR_AMT   " ).append("\n"); 
		query.append("      ,SUM(A.APR_AMT * NVL(B.RQST_UT_VAL, 1)) APR_AMT   " ).append("\n"); 
		query.append("      ,SUM(A.MAY_AMT * NVL(B.RQST_UT_VAL, 1)) MAY_AMT   " ).append("\n"); 
		query.append("      ,SUM(A.JUN_AMT * NVL(B.RQST_UT_VAL, 1)) JUN_AMT" ).append("\n"); 
		query.append("      ,SUM(A.JUL_AMT * NVL(B.RQST_UT_VAL, 1)) JUL_AMT" ).append("\n"); 
		query.append("      ,SUM(A.AUG_AMT * NVL(B.RQST_UT_VAL, 1)) AUG_AMT                   " ).append("\n"); 
		query.append("      ,SUM(A.SEP_AMT * NVL(B.RQST_UT_VAL, 1)) SEP_AMT" ).append("\n"); 
		query.append("      ,SUM(A.OCT_AMT * NVL(B.RQST_UT_VAL, 1)) OCT_AMT                   " ).append("\n"); 
		query.append("      ,SUM(A.NOV_AMT * NVL(B.RQST_UT_VAL, 1)) NOV_AMT" ).append("\n"); 
		query.append("      ,SUM(A.DEC_AMT * NVL(B.RQST_UT_VAL, 1)) DEC_AMT" ).append("\n"); 
		query.append("      ,SUM(A.INT_TTL * NVL(B.RQST_UT_VAL, 1)) INT_TTL" ).append("\n"); 
		query.append("      ,SUM(A.ADD_TTL * NVL(B.RQST_UT_VAL, 1)) ADD_TTL" ).append("\n"); 
		query.append("      ,SUM(A.TRN_TTL * NVL(B.RQST_UT_VAL, 1)) TRN_TTL" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT C.OFC_CD" ).append("\n"); 
		query.append("              ,C.GEN_EXPN_CD" ).append("\n"); 
		query.append("              ,C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("              ,C.JAN_AMT" ).append("\n"); 
		query.append("              ,C.FEB_AMT" ).append("\n"); 
		query.append("              ,C.MAR_AMT" ).append("\n"); 
		query.append("              ,C.APR_AMT" ).append("\n"); 
		query.append("              ,C.MAY_AMT" ).append("\n"); 
		query.append("              ,C.JUN_AMT" ).append("\n"); 
		query.append("              ,C.JUL_AMT" ).append("\n"); 
		query.append("              ,C.AUG_AMT" ).append("\n"); 
		query.append("              ,C.SEP_AMT" ).append("\n"); 
		query.append("              ,C.OCT_AMT" ).append("\n"); 
		query.append("              ,C.NOV_AMT" ).append("\n"); 
		query.append("              ,C.DEC_AMT" ).append("\n"); 
		query.append("              ,DECODE(A.GEN_EXPN_RQST_TP_CD, 'EI', C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT, 0) INT_TTL" ).append("\n"); 
		query.append("              ,DECODE(A.GEN_EXPN_RQST_TP_CD, 'EA', C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT, 0) ADD_TTL" ).append("\n"); 
		query.append("              ,DECODE(A.GEN_EXPN_RQST_TP_CD, 'ET', C.JAN_AMT + C.FEB_AMT + C.MAR_AMT + C.APR_AMT + C.MAY_AMT + C.JUN_AMT + C.JUL_AMT + C.AUG_AMT + C.SEP_AMT + C.OCT_AMT + C.NOV_AMT + C.DEC_AMT, 0) TRN_TTL" ).append("\n"); 
		query.append("              ,B.GEN_EXPN_ITM_DESC" ).append("\n"); 
		query.append("              ,B.GEN_EXPN_CALC_BSS_DESC" ).append("\n"); 
		query.append("              ,B.RQST_OPIN_RMK" ).append("\n"); 
		query.append("              ,A.PLN_YRMON" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("                      ,GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("                      ,SUBSTR(PLN_YRMON,1,4)||'00' PLN_YRMON" ).append("\n"); 
		query.append("                  FROM GEM_REQUEST" ).append("\n"); 
		query.append("                 WHERE PLN_YRMON LIKE SUBSTR(@[f_cost_yrmon], 1, 4)||'%'" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("              ,GEM_ITEM B" ).append("\n"); 
		query.append("              ,GEM_APRO_STEP C" ).append("\n"); 
		query.append("         WHERE A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("           AND B.CRNT_GEN_EXPN_APRO_STEP_CD = 'CO'" ).append("\n"); 
		query.append("           AND B.CRNT_GEN_EXPN_APSTS_CD = 'AP'" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("           AND B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("           AND B.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("           AND B.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,GEM_OFFICE B" ).append("\n"); 
		query.append(" WHERE A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append(" GROUP BY A.OFC_CD, B.LOCL_CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", MAS_GEN_BUDGET AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT 'HO' AS OFC_CD, GBI.LOCL_CURR_CD" ).append("\n"); 
		query.append("      , SUM(DECODE(TO_NUMBER(SUBSTR(@[f_cost_yrmon], -2))" ).append("\n"); 
		query.append("                  , 1, GBI.JAN_AMT" ).append("\n"); 
		query.append("                  , 2, GBI.FEB_AMT" ).append("\n"); 
		query.append("                  , 3, GBI.MAR_AMT" ).append("\n"); 
		query.append("                  , 4, GBI.APR_AMT" ).append("\n"); 
		query.append("                  , 5, GBI.MAY_AMT" ).append("\n"); 
		query.append("                  , 6, GBI.JUN_AMT" ).append("\n"); 
		query.append("                  , 7, GBI.JUL_AMT" ).append("\n"); 
		query.append("                  , 8, GBI.AUG_AMT" ).append("\n"); 
		query.append("                  , 9, GBI.SEP_AMT" ).append("\n"); 
		query.append("                  , 10, GBI.OCT_AMT" ).append("\n"); 
		query.append("                  , 11, GBI.NOV_AMT" ).append("\n"); 
		query.append("                  , 12, GBI.DEC_AMT" ).append("\n"); 
		query.append("                  , 0)) AS BUD_LOCL_AMT" ).append("\n"); 
		query.append("      , 1 AS OFC_GRP_NO" ).append("\n"); 
		query.append("   FROM GEN_BUDGET_INIT GBI, ORG_TREE ORG" ).append("\n"); 
		query.append("  WHERE GBI.OFC_CD     = ORG.OFC_CD" ).append("\n"); 
		query.append("    AND ORG.LVL        IN (2, 3, 4)" ).append("\n"); 
		query.append("    AND ORG.OFC_TP_CD  = 'HT'" ).append("\n"); 
		query.append("  GROUP BY GBI.LOCL_CURR_CD" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append(" SELECT ORG.REP_OFC_CD AS OFC_CD, GBI.LOCL_CURR_CD" ).append("\n"); 
		query.append("      , SUM(DECODE(TO_NUMBER(SUBSTR(@[f_cost_yrmon], -2))" ).append("\n"); 
		query.append("                  , 1, GBI.JAN_AMT" ).append("\n"); 
		query.append("                  , 2, GBI.FEB_AMT" ).append("\n"); 
		query.append("                  , 3, GBI.MAR_AMT" ).append("\n"); 
		query.append("                  , 4, GBI.APR_AMT" ).append("\n"); 
		query.append("                  , 5, GBI.MAY_AMT" ).append("\n"); 
		query.append("                  , 6, GBI.JUN_AMT" ).append("\n"); 
		query.append("                  , 7, GBI.JUL_AMT" ).append("\n"); 
		query.append("                  , 8, GBI.AUG_AMT" ).append("\n"); 
		query.append("                  , 9, GBI.SEP_AMT" ).append("\n"); 
		query.append("                  , 10, GBI.OCT_AMT" ).append("\n"); 
		query.append("                  , 11, GBI.NOV_AMT" ).append("\n"); 
		query.append("                  , 12, GBI.DEC_AMT" ).append("\n"); 
		query.append("                  , 0)) AS BUD_LOCL_AMT" ).append("\n"); 
		query.append("      , 2 AS ORDER_IDX" ).append("\n"); 
		query.append("   FROM GEN_BUDGET_INIT GBI, ORG_TREE_NOT_HO ORG" ).append("\n"); 
		query.append("  WHERE GBI.OFC_CD     = ORG.OFC_CD" ).append("\n"); 
		query.append("  GROUP BY ORG.REP_OFC_CD, GBI.LOCL_CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[f_cost_yrmon] AS COST_YRMON, A.OFC_CD, A.LOCL_CURR_CD, A.OFC_GRP_NO" ).append("\n"); 
		query.append("     , A.BUD_LOCL_AMT" ).append("\n"); 
		query.append("     , NVL2(B.USD_LOCL_XCH_RT, ROUND(A.BUD_LOCL_AMT / B.USD_LOCL_XCH_RT, 2), 0) AS BUD_USD_AMT" ).append("\n"); 
		query.append("     , 0 AS EXPN_USD_AMT" ).append("\n"); 
		query.append("     , NVL(B.USD_LOCL_XCH_RT, 0) AS USD_LOCL_XCH_RT" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID, SYSDATE CRE_DT, @[upd_usr_id] AS UPD_USR_ID, SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM MAS_GEN_BUDGET A, GL_MON_XCH_RT B" ).append("\n"); 
		query.append(" WHERE A.LOCL_CURR_CD = B.CURR_CD(+)" ).append("\n"); 
		query.append("   AND B.ACCT_XCH_RT_YRMON(+) = @[f_cost_yrmon]" ).append("\n"); 
		query.append("   AND B.ACCT_XCH_RT_LVL(+) = '1'" ).append("\n"); 
		query.append("   AND NVL(B.DELT_FLG(+), 'N') = 'N'" ).append("\n"); 
		query.append(" ORDER BY A.OFC_GRP_NO, A.OFC_CD" ).append("\n"); 

	}
}