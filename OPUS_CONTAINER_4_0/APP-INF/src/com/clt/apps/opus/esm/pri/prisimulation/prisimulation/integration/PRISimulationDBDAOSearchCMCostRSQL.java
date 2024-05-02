/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PRISimulationDBDAOSearchCMCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRISimulationDBDAOSearchCMCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DAORSQLSearchCMCost
	  * </pre>
	  */
	public PRISimulationDBDAOSearchCMCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arv_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dep_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_trns_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.prisimulation.prisimulation.integration").append("\n"); 
		query.append("FileName : PRISimulationDBDAOSearchCMCostRSQL").append("\n"); 
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
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("    SELECT T.*," ).append("\n"); 
		query.append("           NVL((SELECT TRD_CD" ).append("\n"); 
		query.append("              FROM MDM_DTL_REV_LANE M" ).append("\n"); 
		query.append("             WHERE M.RLANE_CD LIKE T.SLAN_CD||'%'" ).append("\n"); 
		query.append("               AND M.VSL_SLAN_DIR_CD = T.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("               AND M.FM_CONTI_CD = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = T.POL_CD)" ).append("\n"); 
		query.append("               AND M.TO_CONTI_CD = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = T.POD_CD)" ).append("\n"); 
		query.append("           ),COA_RLANE_TRD_CONV_FNC(T.TRNK_SKD_DIR_CD,T.SLAN_CD,T.POL_CD,T.POD_CD )) AS TRD_CD," ).append("\n"); 
		query.append("           NVL((SELECT SUB_TRD_CD" ).append("\n"); 
		query.append("              FROM MDM_DTL_REV_LANE M" ).append("\n"); 
		query.append("             WHERE M.RLANE_CD LIKE T.SLAN_CD||'%'" ).append("\n"); 
		query.append("               AND M.VSL_SLAN_DIR_CD = T.TRNK_SKD_DIR_CD" ).append("\n"); 
		query.append("               AND M.FM_CONTI_CD = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = T.POL_CD)" ).append("\n"); 
		query.append("               AND M.TO_CONTI_CD = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = T.POD_CD)" ).append("\n"); 
		query.append("             )," ).append("\n"); 
		query.append("             (SELECT SUB_TRD_CD" ).append("\n"); 
		query.append("              FROM MDM_DTL_REV_LANE M" ).append("\n"); 
		query.append("             WHERE M.RLANE_CD = 'RBCCO'" ).append("\n"); 
		query.append("               AND M.VSL_SLAN_DIR_CD = 'E'" ).append("\n"); 
		query.append("               AND M.FM_CONTI_CD = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = T.POL_CD)" ).append("\n"); 
		query.append("               AND M.TO_CONTI_CD = (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = T.POD_CD)" ).append("\n"); 
		query.append("            )) AS SUB_TRD_CD" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("        SELECT (SELECT T_DTL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  FROM PRD_PROD_CTL_ROUT_DTL T_DTL" ).append("\n"); 
		query.append("                 WHERE T_DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                   AND T_DTL.PCTL_SEQ = PRD_GET_TLANE_FNC(M.PCTL_NO,'SEQ')" ).append("\n"); 
		query.append("               ) AS SLAN_CD," ).append("\n"); 
		query.append("--               (SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("--                       TO_CHAR(DTL.ARR_ST_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("--                  FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_INLND_ROUT_MST O" ).append("\n"); 
		query.append("--                 WHERE PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("--                   AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("--                   AND DTL.ROUT_ORG_NOD_CD = O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("--                   AND DTL.ROUT_DEST_NOD_CD = O.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("--                   AND DTL.ROUT_SEQ = O.ROUT_SEQ" ).append("\n"); 
		query.append("--                   AND DTL.ORG_NOD_CD = O.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("--                   AND DTL.ROUT_SEQ > 0" ).append("\n"); 
		query.append("--                   AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("--                   AND ROWNUM=1" ).append("\n"); 
		query.append("--                 UNION ALL" ).append("\n"); 
		query.append("--                SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("--                       TO_CHAR(DTL.ARR_ST_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("--                  FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("--                 WHERE DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("--                   AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("--                   AND DTL.ROUT_SEQ = 0" ).append("\n"); 
		query.append("--                   AND ROWNUM=1" ).append("\n"); 
		query.append("--               ) AS CCT," ).append("\n"); 
		query.append("               TO_CHAR((CASE (SELECT COUNT(*)" ).append("\n"); 
		query.append("                                FROM prd_prod_ctl_mst m1" ).append("\n"); 
		query.append("                               WHERE m1.POL_NOD_CD = (SELECT /*+ index(A XPKPRD_PROD_CTL_ROUT_DTL) */ DEST_NOD_CD" ).append("\n"); 
		query.append("                                                        FROM prd_prod_ctl_rout_dtl dtl" ).append("\n"); 
		query.append("                                                       WHERE dtl.pctl_no = m1.pctl_no" ).append("\n"); 
		query.append("                                                         AND dtl.DEST_NOD_TP_CD <> 'Z'" ).append("\n"); 
		query.append("                                                         AND dtl.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("                                                         AND dtl.MTY_YD_FLG = 'N'" ).append("\n"); 
		query.append("                                                         AND rownum = 1)" ).append("\n"); 
		query.append("                                 AND m1.pctl_no = M.PCTL_NO)" ).append("\n"); 
		query.append("                        WHEN 0 THEN" ).append("\n"); 
		query.append("                         (NVL(PRD_GET_INLND_CCT_FNC(M.PCTL_NO)," ).append("\n"); 
		query.append("                              (SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                                      DTL.ARR_ST_DT" ).append("\n"); 
		query.append("                                 FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                                     ,PRD_INLND_ROUT_MST    O" ).append("\n"); 
		query.append("                                WHERE DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                                  AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                  AND DTL.ROUT_ORG_NOD_CD = O.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                                  AND DTL.ROUT_DEST_NOD_CD = O.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                                  AND DTL.ROUT_SEQ = O.ROUT_SEQ" ).append("\n"); 
		query.append("                                  AND DTL.ORG_NOD_CD = O.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("                                  AND DTL.ROUT_SEQ > 0" ).append("\n"); 
		query.append("                                  AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1" ).append("\n"); 
		query.append("                               UNION ALL" ).append("\n"); 
		query.append("                               SELECT /*+INDEX_DESC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                                      DTL.ARR_ST_DT" ).append("\n"); 
		query.append("                                 FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                                WHERE DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                                  AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                                  AND DTL.ROUT_SEQ = 0" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1)))  " ).append("\n"); 
		query.append("                        ELSE	PRD_COMMON_PKG.PRD_GET_CCT_BY_PC_FNC(M.PCTL_NO)" ).append("\n"); 
		query.append("                        END)," ).append("\n"); 
		query.append("               'YYYY-MM-DD HH24:MI') AS CCT," ).append("\n"); 
		query.append("               (SELECT /*+INDEX_ASC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                       TO_CHAR(DTL.DEP_FSH_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                  FROM PRD_PROD_CTL_ROUT_DTL DTL, PRD_INLND_ROUT_MST I" ).append("\n"); 
		query.append("                 WHERE PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                   AND DTL.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND DTL.ROUT_ORG_NOD_CD = I.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("                   AND DTL.ROUT_DEST_NOD_CD = I.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("                   AND DTL.ROUT_SEQ = I.ROUT_SEQ" ).append("\n"); 
		query.append("                   AND DTL.DEST_NOD_CD = I.FULL_PKUP_YD_CD" ).append("\n"); 
		query.append("                   AND DTL.ROUT_SEQ > 0" ).append("\n"); 
		query.append("                   AND DTL.NOD_LNK_DIV_CD = 'N'" ).append("\n"); 
		query.append("                   AND ROWNUM=1" ).append("\n"); 
		query.append("                 UNION ALL" ).append("\n"); 
		query.append("                SELECT /*+INDEX_ASC(DTL XPKPRD_PROD_CTL_ROUT_DTL)*/" ).append("\n"); 
		query.append("                       TO_CHAR(DTL.DEP_FSH_DT,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("                  FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                 WHERE DTL.PCTL_NO = M.PCTL_NO" ).append("\n"); 
		query.append("                   AND DTL.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                   AND DTL.ROUT_SEQ = 0" ).append("\n"); 
		query.append("                   AND ROWNUM=1" ).append("\n"); 
		query.append("               ) AS CGO_AVAL_HRS," ).append("\n"); 
		query.append("               TTL_TZTM_HRS TTL_TZTM," ).append("\n"); 
		query.append("               LPAD (FLOOR (TTL_TZTM_HRS / 24), 2, 0) || LPAD (MOD (TTL_TZTM_HRS, 24), 2, 0) TTL_TZTM_HRS," ).append("\n"); 
		query.append("               OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("               POR_CD," ).append("\n"); 
		query.append("               POR_NOD_CD," ).append("\n"); 
		query.append("               OB_ITCHG_CTNT," ).append("\n"); 
		query.append("               POL_CD," ).append("\n"); 
		query.append("               POL_NOD_CD," ).append("\n"); 
		query.append("               RTRIM (   MAX (DECODE (TS.RK," ).append("\n"); 
		query.append("                                        1, REPLACE (TS.VSL_SLAN_CD, '-(', '(')" ).append("\n"); 
		query.append("                                       ))" ).append("\n"); 
		query.append("                        || N1ST_TS_PORT_CD" ).append("\n"); 
		query.append("                        || MAX (DECODE (TS.RK, 2, TS.VSL_SLAN_CD))" ).append("\n"); 
		query.append("                        || N2ND_TS_PORT_CD" ).append("\n"); 
		query.append("                        || MAX (DECODE (TS.RK, 3, TS.VSL_SLAN_CD))" ).append("\n"); 
		query.append("                        || N3RD_TS_PORT_CD" ).append("\n"); 
		query.append("                        || MAX (DECODE (TS.RK, 4, TS.VSL_SLAN_CD))," ).append("\n"); 
		query.append("                        '-'" ).append("\n"); 
		query.append("                       ) TS_ROUTE," ).append("\n"); 
		query.append("               POD_CD," ).append("\n"); 
		query.append("               POD_NOD_CD," ).append("\n"); 
		query.append("               IB_ITCHG_CTNT," ).append("\n"); 
		query.append("               DEL_CD," ).append("\n"); 
		query.append("               DEL_NOD_CD," ).append("\n"); 
		query.append("               MAX(DECODE(TS.RK,1,TS.SLAN_1,'')) AS N1ST_SLAN," ).append("\n"); 
		query.append("               MAX(DECODE(TS.RK,1,NVL(TS.SLAN_4,NVL(TS.SLAN_3,NVL(TS.SLAN_2,TS.SLAN_1))),'')) AS LAST_SLAN," ).append("\n"); 
		query.append("               LPAD(FLOOR(M.CML_OCN_TZTM_HRS/24), 2, 0) CML_OCN_TZTM_HRS," ).append("\n"); 
		query.append("               LPAD(TRUNC((M.CML_OCN_TZTM_HRS + M.CML_INLND_TZTM_HRS) / 24) + 1, 2, 0)  CML_INLND_TZTM_HRS," ).append("\n"); 
		query.append("               M.PCTL_NO," ).append("\n"); 
		query.append("               DECODE(ROUT_FLAG, 'G', 1, 'S', 1, 'T', 3, 'A', 4, 'V', 5, 'N', 6, 'D', 7) ORD," ).append("\n"); 
		query.append("               M.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("               ROUND(estm_cm_cost_amt_20,2) estm_cm_cost_amt_20," ).append("\n"); 
		query.append("               ROUND(estm_cm_cost_amt_40,2) estm_cm_cost_amt_40," ).append("\n"); 
		query.append("               ROUND(estm_cm_cost_amt_45,2) estm_cm_cost_amt_45," ).append("\n"); 
		query.append("               ROUND(estm_cm_cost_amt_70,2) estm_cm_cost_amt_70," ).append("\n"); 
		query.append("    		   ROUND(- estm_cm_cost_amt_20,2) AS estm_cm_amt_20," ).append("\n"); 
		query.append("    		   ROUND(- estm_cm_cost_amt_40,2) AS estm_cm_amt_40," ).append("\n"); 
		query.append("    		   ROUND(- estm_cm_cost_amt_45,2) AS estm_cm_amt_45," ).append("\n"); 
		query.append("    		   ROUND(- estm_cm_cost_amt_70,2) AS estm_cm_amt_70," ).append("\n"); 
		query.append("               ROUND(estm_cm_cost_amt2_20,2) estm_cm_cost_amt2_20," ).append("\n"); 
		query.append("               ROUND(estm_cm_cost_amt2_40,2) estm_cm_cost_amt2_40," ).append("\n"); 
		query.append("               ROUND(estm_cm_cost_amt2_45,2) estm_cm_cost_amt2_45," ).append("\n"); 
		query.append("               ROUND(estm_cm_cost_amt2_70,2) estm_cm_cost_amt2_70," ).append("\n"); 
		query.append("               ROUND(- estm_cm_cost_amt2_20,2) AS estm_cm_amt2_20 ," ).append("\n"); 
		query.append("               ROUND(- estm_cm_cost_amt2_40,2) AS estm_cm_amt2_40 ," ).append("\n"); 
		query.append("               ROUND(- estm_cm_cost_amt2_45,2) AS estm_cm_amt2_45 ," ).append("\n"); 
		query.append("               ROUND(- estm_cm_cost_amt2_70,2) AS estm_cm_amt2_70 ," ).append("\n"); 
		query.append("			   SIGN(mis_avg_cnt_20) AS mis_avg_flg_20 ," ).append("\n"); 
		query.append("               SIGN(mis_avg_cnt_40) AS mis_avg_flg_40 ," ).append("\n"); 
		query.append("               SIGN(mis_avg_cnt_45) AS mis_avg_flg_45 ," ).append("\n"); 
		query.append("               SIGN(mis_avg_cnt_70) AS mis_avg_flg_70 ," ).append("\n"); 
		query.append("    		   COST_FLG," ).append("\n"); 
		query.append("    		   " ).append("\n"); 
		query.append("    		   (SELECT " ).append("\n"); 
		query.append("                      CASE WHEN OB.TRSP_MOD_CD = 'WD' THEN DECODE(M.POD_CD, M.DEL_CD, 'F', 'B')" ).append("\n"); 
		query.append("                		   WHEN OB.TRSP_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("                		   WHEN OB.TRSP_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("                		   WHEN OB.TRSP_MOD_CD = 'TR' THEN 'A'" ).append("\n"); 
		query.append("                		   WHEN OB.TRSP_MOD_CD = 'TW' THEN DECODE(M.POD_CD, M.DEL_CD, 'E', 'U') END" ).append("\n"); 
		query.append("                	FROM PRD_INLND_ROUT_MST OB" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND (OB.ROUT_ORG_NOD_CD, OB.ROUT_DEST_NOD_CD, OB.ROUT_SEQ) =" ).append("\n"); 
		query.append("                				      (SELECT DTL.ROUT_ORG_NOD_CD, DTL.ROUT_DEST_NOD_CD, ROUT_SEQ " ).append("\n"); 
		query.append("                				         FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                				        WHERE DTL.PCTL_NO        = M.PCTL_NO   " ).append("\n"); 
		query.append("                				          AND DTL.PCTL_IO_BND_CD = 'O'" ).append("\n"); 
		query.append("                					      AND DTL.ROUT_SEQ       <> 0" ).append("\n"); 
		query.append("                						  AND ROWNUM = 1)" ).append("\n"); 
		query.append("                ) R_ORG_TRNS_MOD_CD," ).append("\n"); 
		query.append("                (SELECT " ).append("\n"); 
		query.append("                      CASE WHEN IB.TRSP_MOD_CD = 'WD' THEN DECODE(M.POD_CD, M.DEL_CD, 'F', 'B')" ).append("\n"); 
		query.append("                		   WHEN IB.TRSP_MOD_CD = 'RD' THEN 'R'" ).append("\n"); 
		query.append("                		   WHEN IB.TRSP_MOD_CD = 'TD' THEN 'T'" ).append("\n"); 
		query.append("                		   WHEN IB.TRSP_MOD_CD = 'TR' THEN 'A'" ).append("\n"); 
		query.append("                		   WHEN IB.TRSP_MOD_CD = 'TW' THEN DECODE(M.POD_CD, M.DEL_CD, 'E', 'U') END" ).append("\n"); 
		query.append("                	FROM PRD_INLND_ROUT_MST IB" ).append("\n"); 
		query.append("                   WHERE 1=1" ).append("\n"); 
		query.append("                     AND (IB.ROUT_ORG_NOD_CD, IB.ROUT_DEST_NOD_CD, IB.ROUT_SEQ) =" ).append("\n"); 
		query.append("                				      (SELECT DTL.ROUT_ORG_NOD_CD, DTL.ROUT_DEST_NOD_CD, ROUT_SEQ " ).append("\n"); 
		query.append("                				         FROM PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                				        WHERE DTL.PCTL_NO        = M.PCTL_NO   " ).append("\n"); 
		query.append("                				          AND DTL.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("                					      AND DTL.ROUT_SEQ       <> 0" ).append("\n"); 
		query.append("                						  AND ROWNUM = 1)" ).append("\n"); 
		query.append("                ) R_DEST_TRNS_MOD_CD" ).append("\n"); 
		query.append("               " ).append("\n"); 
		query.append("        FROM PRD_PROD_CTL_MST M," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT PCTL_NO," ).append("\n"); 
		query.append("              RANK () OVER (PARTITION BY PCTL_NO" ).append("\n"); 
		query.append("                ORDER BY PCTL_SEQ) RK," ).append("\n"); 
		query.append("              '-(' || VSL_SLAN_CD || ')-' VSL_SLAN_CD," ).append("\n"); 
		query.append("              LEAD(VSL_SLAN_CD, 0) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) AS SLAN_1," ).append("\n"); 
		query.append("              LEAD(VSL_SLAN_CD, 1) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) AS SLAN_2," ).append("\n"); 
		query.append("              LEAD(VSL_SLAN_CD, 2) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) AS SLAN_3," ).append("\n"); 
		query.append("              LEAD(VSL_SLAN_CD, 3) OVER (PARTITION BY PCTL_NO ORDER BY PCTL_SEQ) AS SLAN_4," ).append("\n"); 
		query.append("              UPD_IND_CD ROUT_FLAG" ).append("\n"); 
		query.append("             ,ROUT.OCN_ROUT_PRIO_CD" ).append("\n"); 
		query.append("            FROM PRD_PROD_CTL_ROUT_DTL DTL," ).append("\n"); 
		query.append("              PRD_OCN_ROUT ROUT" ).append("\n"); 
		query.append("            WHERE PCTL_NO LIKE @[pctl_no]||'%'" ).append("\n"); 
		query.append("              AND VSL_SLAN_CD IS NOT NULL" ).append("\n"); 
		query.append("              AND DTL.ROUT_ORG_NOD_CD = ROUT.ORG_LOC_CD(+)" ).append("\n"); 
		query.append("              AND DTL.ROUT_DEST_NOD_CD = ROUT.DEST_LOC_CD(+)" ).append("\n"); 
		query.append("              AND DTL.ROUT_SEQ = ROUT.ROUT_SEQ(+) ) TS," ).append("\n"); 
		query.append("          ( " ).append("\n"); 
		query.append("              SELECT PCTL_NO" ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',estm_cm_cost_amt,0)) estm_cm_cost_amt_20   --cm에 common_amt를 더해준다. cm에 dem/det를 - 해준다(CM/OP변경으로 dem/det삭제) " ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'4',estm_cm_cost_amt,0)) estm_cm_cost_amt_40  --cm에 common_amt를 더해준다. cm에 dem/det를 - 해준다(CM/OP변경으로 dem/det삭제) " ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'5',estm_cm_cost_amt,0)) estm_cm_cost_amt_45  --cm에 common_amt를 더해준다. cm에 dem/det를 - 해준다(CM/OP변경으로 dem/det삭제) " ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'7',estm_cm_cost_amt,0)) estm_cm_cost_amt_70  --cm에 common_amt를 더해준다. cm에 dem/det를 - 해준다(CM/OP변경으로 dem/det삭제) " ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',estm_cm_cost_amt2,0)) estm_cm_cost_amt2_20   --C.M Park EPP B 단가" ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'4',estm_cm_cost_amt2,0)) estm_cm_cost_amt2_40   --C.M Park EPP B 단가" ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'5',estm_cm_cost_amt2,0)) estm_cm_cost_amt2_45   --C.M Park EPP B 단가" ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'7',estm_cm_cost_amt2,0)) estm_cm_cost_amt2_70   --C.M Park EPP B 단가" ).append("\n"); 
		query.append("			 , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',mis_avg_cnt,0)) mis_avg_cnt_20   --contract 붙이지 못한 cost count " ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'4',mis_avg_cnt,0)) mis_avg_cnt_40  --contract 붙이지 못한 cost count" ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'5',mis_avg_cnt,0)) mis_avg_cnt_45  --contract 붙이지 못한 cost count" ).append("\n"); 
		query.append("             , SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'7',mis_avg_cnt,0)) mis_avg_cnt_70  --contract 붙이지 못한 cost count" ).append("\n"); 
		query.append("    		 , 'Y' COST_FLG" ).append("\n"); 
		query.append("                FROM ( " ).append("\n"); 
		query.append("                SELECT  PCTL_NO, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , DECODE(B.stnd_cost_tp_cd, 'C', NVL(estm_usd_ttl_amt, 0), 0) estm_cm_cost_amt " ).append("\n"); 
		query.append("                                       -- 2014.12.17 Changing Account (51102001)" ).append("\n"); 
		query.append("                      , DECODE(B.stnd_cost_tp_cd, 'C', DECODE (A.stnd_cost_cd , '51102001',  NVL(estm_usd_ttl_amt2, 0), NVL(estm_usd_ttl_amt,0)),0) estm_cm_cost_amt2 --C.M Park EPP B 단가" ).append("\n"); 
		query.append("					  , DECODE(a.cost_ass_bse_cd||a.ctrt_rtn_flg,'CN',1,0) mis_avg_cnt" ).append("\n"); 
		query.append("                FROM COA_COM_COST_PARA A , coa_stnd_acct_v B" ).append("\n"); 
		query.append("                WHERE PCTL_NO LIKE @[pctl_no]||'%'" ).append("\n"); 
		query.append("                AND B.pa_vw        = 'BKG' " ).append("\n"); 
		query.append("                AND A.stnd_cost_cd = B.stnd_cost_cd" ).append("\n"); 
		query.append("				AND ESTM_USD_TTL_AMT <> 0" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("                GROUP BY PCTL_NO" ).append("\n"); 
		query.append("          ) CO" ).append("\n"); 
		query.append("        WHERE M.PCTL_NO LIKE @[pctl_no]||'%'" ).append("\n"); 
		query.append("          AND M.PCTL_NO = TS.PCTL_NO(+)" ).append("\n"); 
		query.append("          AND M.PCTL_NO = CO.PCTL_NO(+)" ).append("\n"); 
		query.append("          AND NVL(M.CNST_FLG,' ') <> 'X' -- X : SVC N" ).append("\n"); 
		query.append("      GROUP BY TTL_TZTM_HRS," ).append("\n"); 
		query.append("               OCN_ROUT_PRIO_CD," ).append("\n"); 
		query.append("               POR_CD," ).append("\n"); 
		query.append("               POR_NOD_CD," ).append("\n"); 
		query.append("               OB_ITCHG_CTNT," ).append("\n"); 
		query.append("               POL_CD," ).append("\n"); 
		query.append("               POL_NOD_CD," ).append("\n"); 
		query.append("               POD_CD," ).append("\n"); 
		query.append("               POD_NOD_CD," ).append("\n"); 
		query.append("               IB_ITCHG_CTNT," ).append("\n"); 
		query.append("               DEL_CD," ).append("\n"); 
		query.append("               DEL_NOD_CD," ).append("\n"); 
		query.append("               M.PCTL_NO," ).append("\n"); 
		query.append("               M.TRNK_SKD_DIR_CD," ).append("\n"); 
		query.append("               N1ST_TS_PORT_CD," ).append("\n"); 
		query.append("               N2ND_TS_PORT_CD," ).append("\n"); 
		query.append("               N3RD_TS_PORT_CD," ).append("\n"); 
		query.append("               M.CML_OCN_TZTM_HRS," ).append("\n"); 
		query.append("               M.CML_INLND_TZTM_HRS," ).append("\n"); 
		query.append("               ROUT_FLAG," ).append("\n"); 
		query.append("               ESTM_CM_COST_AMT_20," ).append("\n"); 
		query.append("               ESTM_CM_COST_AMT_40," ).append("\n"); 
		query.append("               ESTM_CM_COST_AMT_45," ).append("\n"); 
		query.append("               ESTM_CM_COST_AMT_70," ).append("\n"); 
		query.append("               ESTM_CM_COST_AMT2_20," ).append("\n"); 
		query.append("               ESTM_CM_COST_AMT2_40," ).append("\n"); 
		query.append("               ESTM_CM_COST_AMT2_45," ).append("\n"); 
		query.append("               ESTM_CM_COST_AMT2_70," ).append("\n"); 
		query.append("			   MIS_AVG_CNT_20," ).append("\n"); 
		query.append("               MIS_AVG_CNT_40," ).append("\n"); 
		query.append("               MIS_AVG_CNT_45," ).append("\n"); 
		query.append("               MIS_AVG_CNT_70," ).append("\n"); 
		query.append("               COST_FLG" ).append("\n"); 
		query.append("    ) T" ).append("\n"); 
		query.append("     WHERE 1=1" ).append("\n"); 
		query.append("#if (${dep_lane} != '') " ).append("\n"); 
		query.append("       AND N1ST_SLAN = @[dep_lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${arv_lane} != '') " ).append("\n"); 
		query.append("       AND LAST_SLAN = @[arv_lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '') " ).append("\n"); 
		query.append("   AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${org_trns_mod_cd} != '') " ).append("\n"); 
		query.append("   AND R_ORG_TRNS_MOD_CD = @[org_trns_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${dest_trns_mod_cd} != '') " ).append("\n"); 
		query.append("   AND R_DEST_TRNS_MOD_CD = @[dest_trns_mod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY OCN_ROUT_PRIO_CD, TTL_TZTM_HRS, PCTL_NO" ).append("\n"); 

	}
}