/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : NetworkCostDBDAOGNAExpAssignCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.24 
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

public class NetworkCostDBDAOGNAExpAssignCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  
	  * </pre>
	  */
	public NetworkCostDBDAOGNAExpAssignCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_year",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("f_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOGNAExpAssignCSQL").append("\n"); 
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
		query.append("INSERT INTO MAS_GEN_EXPN_ASGN(" ).append("\n"); 
		query.append("    TRD_CD" ).append("\n"); 
		query.append("    , RLANE_CD" ).append("\n"); 
		query.append("    , IOC_CD" ).append("\n"); 
		query.append("    , VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , DIR_CD" ).append("\n"); 
		query.append("    , OFC_CD" ).append("\n"); 
		query.append("    , LOD_QTA" ).append("\n"); 
		query.append("    , HO_EXPN_AMT" ).append("\n"); 
		query.append("    , OWN_EXPN_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , HO_QTA_RTO" ).append("\n"); 
		query.append("    , OWN_QTA_RTO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , EXPN_TTL" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT " ).append("\n"); 
		query.append("    , ADJ_EXPN_TTL" ).append("\n"); 
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
		query.append(", GEN_BUDGET_EXISTS_OFC AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT C.OFC_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("              ,GEN_EXPN_RQST_TP_CD" ).append("\n"); 
		query.append("              ,SUBSTR(PLN_YRMON,1,4)||'00' PLN_YRMON" ).append("\n"); 
		query.append("          FROM GEM_REQUEST" ).append("\n"); 
		query.append("         WHERE PLN_YRMON LIKE @[f_year]||'%'" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append("      ,GEM_ITEM B" ).append("\n"); 
		query.append("      ,GEM_APRO_STEP C" ).append("\n"); 
		query.append("      ,GEM_OFFICE D" ).append("\n"); 
		query.append(" WHERE A.GEN_EXPN_RQST_NO = B.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("   AND B.CRNT_GEN_EXPN_APRO_STEP_CD = 'CO'" ).append("\n"); 
		query.append("   AND B.CRNT_GEN_EXPN_APSTS_CD = 'AP'" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_RQST_NO = C.GEN_EXPN_RQST_NO" ).append("\n"); 
		query.append("   AND B.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_CD = C.GEN_EXPN_CD" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_ITM_NO = C.GEN_EXPN_ITM_NO" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_TRNS_DIV_CD = C.GEN_EXPN_TRNS_DIV_CD" ).append("\n"); 
		query.append("   AND B.GEN_EXPN_RQST_SEQ = C.GEN_EXPN_RQST_SEQ" ).append("\n"); 
		query.append("   AND B.CRNT_GEN_EXPN_APRO_STEP_CD = C.GEN_EXPN_APRO_STEP_CD" ).append("\n"); 
		query.append("   AND C.OFC_CD = D.OFC_CD" ).append("\n"); 
		query.append("   AND DECODE(TO_NUMBER(@[f_mon])" ).append("\n"); 
		query.append("              , 1,  C.JAN_AMT" ).append("\n"); 
		query.append("              , 2,  C.FEB_AMT" ).append("\n"); 
		query.append("              , 3,  C.MAR_AMT" ).append("\n"); 
		query.append("              , 4,  C.APR_AMT" ).append("\n"); 
		query.append("              , 5,  C.MAY_AMT" ).append("\n"); 
		query.append("              , 6,  C.JUN_AMT" ).append("\n"); 
		query.append("              , 7,  C.JUL_AMT" ).append("\n"); 
		query.append("              , 8,  C.AUG_AMT" ).append("\n"); 
		query.append("              , 9,  C.SEP_AMT" ).append("\n"); 
		query.append("              , 10, C.OCT_AMT" ).append("\n"); 
		query.append("              , 11, C.NOV_AMT" ).append("\n"); 
		query.append("              , 12, C.DEC_AMT" ).append("\n"); 
		query.append("              , 0" ).append("\n"); 
		query.append("       ) > 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", QTA AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT Q.TRD_CD, Q.RLANE_CD, T.IOC_CD, Q.VSL_CD, Q.SKD_VOY_NO, Q.SKD_DIR_CD" ).append("\n"); 
		query.append("     , O.REP_OFC_CD AS OFC_CD, SUM(Q.LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("  FROM SQM_QTA_RLSE_VER V" ).append("\n"); 
		query.append("     , SQM_CFM_QTA      Q" ).append("\n"); 
		query.append("     , SQM_CFM_TGT_VVD  T" ).append("\n"); 
		query.append("     , ORG_TREE_NOT_HO  O" ).append("\n"); 
		query.append("     , GEN_BUDGET_EXISTS_OFC GBO" ).append("\n"); 
		query.append(" WHERE V.BSE_TP_CD       = 'Q'" ).append("\n"); 
		query.append("   AND V.BSE_YR          = @[f_year]" ).append("\n"); 
		query.append("   AND V.BSE_QTR_CD      = TO_CHAR(TO_DATE(@[f_year]||@[f_mon], 'YYYYMM'), 'Q') || 'Q'" ).append("\n"); 
		query.append("   AND V.SQM_VER_STS_CD  = 'R'" ).append("\n"); 
		query.append("   AND T.QTA_TGT_CD      = 'D'		-- 고정" ).append("\n"); 
		query.append("   AND Q.QTA_RLSE_VER_NO = V.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("   AND Q.BSE_TP_CD       = V.BSE_TP_CD" ).append("\n"); 
		query.append("   AND Q.BSE_YR          = V.BSE_YR" ).append("\n"); 
		query.append("   AND Q.BSE_QTR_CD      = V.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND Q.OFC_VW_CD       = 'L'" ).append("\n"); 
		query.append("   AND Q.QTA_RLSE_VER_NO = T.QTA_RLSE_VER_NO" ).append("\n"); 
		query.append("   AND Q.BSE_TP_CD       = T.BSE_TP_CD" ).append("\n"); 
		query.append("   AND Q.BSE_YR          = T.BSE_YR" ).append("\n"); 
		query.append("   AND Q.BSE_QTR_CD      = T.BSE_QTR_CD" ).append("\n"); 
		query.append("   AND Q.QTA_TGT_CD      = T.QTA_TGT_CD" ).append("\n"); 
		query.append("   AND Q.TRD_CD          = T.TRD_CD" ).append("\n"); 
		query.append("   AND Q.RLANE_CD        = T.RLANE_CD" ).append("\n"); 
		query.append("   AND Q.DIR_CD          = T.DIR_CD" ).append("\n"); 
		query.append("   AND Q.VSL_CD          = T.VSL_CD" ).append("\n"); 
		query.append("   AND Q.SKD_VOY_NO      = T.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND Q.SKD_DIR_CD      = T.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND Q.RGN_OFC_CD      = O.OFC_CD" ).append("\n"); 
		query.append("   AND O.OFC_CD          = GBO.OFC_CD" ).append("\n"); 
		query.append("   AND Q.LOD_QTY         <> 0" ).append("\n"); 
		query.append(" GROUP BY Q.TRD_CD, Q.RLANE_CD, T.IOC_CD" ).append("\n"); 
		query.append("        , Q.VSL_CD, Q.SKD_VOY_NO, Q.SKD_DIR_CD, O.REP_OFC_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", GE_USD_SUM AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT COST_YRMON, OFC_CD, OFC_GRP_NO, SUM(EXPN_USD_AMT) EXPN_USD_AMT" ).append("\n"); 
		query.append("  FROM MAS_GEN_EXPN_OFC_STUP" ).append("\n"); 
		query.append(" WHERE COST_YRMON = @[f_year]||@[f_mon]" ).append("\n"); 
		query.append(" GROUP BY COST_YRMON, OFC_CD, OFC_GRP_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", GE_DTRB_NOT_YET AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.COST_YRMON, A.COST_WK, A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, A.IOC_CD" ).append("\n"); 
		query.append("     , A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD, A.HUL_BND_CD, A.OFC_CD" ).append("\n"); 
		query.append("     , A.EXPN_USD_AMT, A.LOD_QTY" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT A.COST_YRMON, A.COST_WK, A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, A.IOC_CD" ).append("\n"); 
		query.append("             , A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD, A.HUL_BND_CD, A.OFC_CD" ).append("\n"); 
		query.append("             , A.EXPN_USD_AMT" ).append("\n"); 
		query.append("             , NVL(Q.LOD_QTY, 0) AS LOD_QTY" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT A.COST_YRMON, A.COST_WK, A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, A.IOC_CD" ).append("\n"); 
		query.append("                     , A.VSL_CD, A.SKD_VOY_NO, A.DIR_CD" ).append("\n"); 
		query.append("                     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD03217' AND INTG_CD_VAL_CTNT = B.HUL_BND_CD) HUL_BND_CD" ).append("\n"); 
		query.append("                     , GE.OFC_CD, GE.OFC_GRP_NO, GE.EXPN_USD_AMT" ).append("\n"); 
		query.append("                  FROM MAS_MON_VVD A" ).append("\n"); 
		query.append("                     , MAS_LANE_RGST B" ).append("\n"); 
		query.append("                     , GE_USD_SUM GE" ).append("\n"); 
		query.append("                 WHERE A.TRD_CD     = B.TRD_CD" ).append("\n"); 
		query.append("                   AND A.RLANE_CD   = B.RLANE_CD" ).append("\n"); 
		query.append("                   AND A.IOC_CD     = B.IOC_CD" ).append("\n"); 
		query.append("                   AND A.DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("                   AND GE.OFC_GRP_NO = 2" ).append("\n"); 
		query.append("                   AND NVL(B.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("                   AND NVL(A.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("             , QTA Q" ).append("\n"); 
		query.append("         WHERE A.TRD_CD     = Q.TRD_CD(+)" ).append("\n"); 
		query.append("           AND A.IOC_CD     = Q.IOC_CD(+)" ).append("\n"); 
		query.append("           AND A.VSL_CD     = Q.VSL_CD(+)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = Q.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND A.DIR_CD     = Q.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND A.OFC_CD     = Q.OFC_CD(+)" ).append("\n"); 
		query.append("           AND A.COST_YRMON = @[f_year]||@[f_mon]" ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append(" WHERE A.LOD_QTY <> 0" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       GE.TRD_CD, GE.RLANE_CD, GE.IOC_CD, GE.VSL_CD, GE.SKD_VOY_NO, GE.DIR_CD" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("     , GE.OFC_CD, GE.LOD_QTY" ).append("\n"); 
		query.append("     , ROUND((SELECT SUM(EXPN_USD_AMT) FROM GE_USD_SUM WHERE OFC_GRP_NO = 1) * ROUND(GE.LOD_QTY / TOT_SUM.LOD_QTY, 15), 13) AS HO_EXPN_AMT     " ).append("\n"); 
		query.append("     , ROUND(EXPN_USD_AMT * ROUND(GE.LOD_QTY / OFC_SUM.LOD_QTY, 15), 13) AS OWN_EXPN_AMT" ).append("\n"); 
		query.append("     , ROUND(GE.LOD_QTY / TOT_SUM.LOD_QTY, 15) * 100 AS HO_QTA_RATIO" ).append("\n"); 
		query.append("     , ROUND(GE.LOD_QTY / OFC_SUM.LOD_QTY, 15) * 100 AS OWN_QTA_RATIO     " ).append("\n"); 
		query.append("     , ROUND((SELECT SUM(EXPN_USD_AMT) FROM GE_USD_SUM WHERE OFC_GRP_NO = 1) * ROUND(GE.LOD_QTY / TOT_SUM.LOD_QTY, 15), 13)" ).append("\n"); 
		query.append("         + ROUND(EXPN_USD_AMT * ROUND(GE.LOD_QTY / OFC_SUM.LOD_QTY, 15), 13) AS EXPN_TTL" ).append("\n"); 
		query.append("     , @[cre_usr_id] AS CRE_USR_ID, SYSDATE CRE_DT, @[upd_usr_id] AS UPD_USR_ID, SYSDATE UPD_DT" ).append("\n"); 
		query.append("     , ROUND((SELECT SUM(EXPN_USD_AMT) FROM GE_USD_SUM WHERE OFC_GRP_NO = 1) * ROUND(GE.LOD_QTY / TOT_SUM.LOD_QTY, 15), 13)" ).append("\n"); 
		query.append("         + ROUND(EXPN_USD_AMT * ROUND(GE.LOD_QTY / OFC_SUM.LOD_QTY, 15), 13) AS ADJ_EXPN_TTL" ).append("\n"); 
		query.append("  FROM GE_DTRB_NOT_YET GE" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("          FROM GE_DTRB_NOT_YET" ).append("\n"); 
		query.append("       ) TOT_SUM" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("        SELECT OFC_CD, SUM(LOD_QTY) AS LOD_QTY" ).append("\n"); 
		query.append("          FROM GE_DTRB_NOT_YET" ).append("\n"); 
		query.append("         GROUP BY OFC_CD" ).append("\n"); 
		query.append("       ) OFC_SUM" ).append("\n"); 
		query.append(" WHERE GE.OFC_CD = OFC_SUM.OFC_CD" ).append("\n"); 
		query.append(" ORDER BY COST_YRMON, COST_WK, TRD_CD, SUB_TRD_CD, RLANE_CD, VSL_CD, SKD_VOY_NO, DIR_CD, OFC_CD" ).append("\n"); 

	}
}