/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOSearchEstimatedProRevenueListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOEstimatedDBDAOSearchEstimatedProRevenueListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOEstimatedDBDAOSearchEstimatedProRevenueListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_duration",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
		query.append("FileName : TCharterIOEstimatedDBDAOSearchEstimatedProRevenueListVORSQL").append("\n"); 
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
		query.append("WITH V_FMS_CONTRACT AS (" ).append("\n"); 
		query.append("        SELECT VSL_CD" ).append("\n"); 
		query.append("             , FLET_CTRT_NO" ).append("\n"); 
		query.append("             , FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , FLET_CTRT_FACT_CD" ).append("\n"); 
		query.append("          FROM FMS_CONTRACT" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("        SELECT FI.VSL_CD" ).append("\n"); 
		query.append("             , FC.FLET_CTRT_NO" ).append("\n"); 
		query.append("             , FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , FLET_CTRT_FACT_CD" ).append("\n"); 
		query.append("          FROM FMS_CONTRACT FC" ).append("\n"); 
		query.append("             , FMS_ID_VSL FI" ).append("\n"); 
		query.append("         WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO" ).append("\n"); 
		query.append("           AND FC.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append(", V_ESTM_REV_VVD AS (" ).append("\n"); 
		query.append("    SELECT DISTINCT A.EXE_YRMON" ).append("\n"); 
		query.append("         , A.REV_YRMON" ).append("\n"); 
		query.append("         , A.RLANE_CD" ).append("\n"); 
		query.append("         , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD" ).append("\n"); 
		query.append("         , A.VSL_CD" ).append("\n"); 
		query.append("         , A.SKD_VOY_NO" ).append("\n"); 
		query.append("         , A.SKD_DIR_CD" ).append("\n"); 
		query.append("         , A.REV_DIR_CD" ).append("\n"); 
		query.append("         , A.VST_DT" ).append("\n"); 
		query.append("         , A.VED_DT" ).append("\n"); 
		query.append("         , A.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("         , B.FLET_CTRT_NO" ).append("\n"); 
		query.append("         , B.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("         , B.FLET_CTRT_FACT_CD" ).append("\n"); 
		query.append("      FROM (SELECT *" ).append("\n"); 
		query.append("              FROM GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("               AND G.EXE_YRMON      = REPLACE(@[exe_yrmon],'-')" ).append("\n"); 
		query.append("               AND G.REV_YRMON      BETWEEN REPLACE(@[fr_duration],'-') AND REPLACE(@[to_duration],'-')" ).append("\n"); 
		query.append("               AND G.ESTM_VVD_TP_CD = 'PV'" ).append("\n"); 
		query.append("               AND G.ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("               AND NOT EXISTS ( SELECT NULL" ).append("\n"); 
		query.append("                                  FROM FMS_VVD" ).append("\n"); 
		query.append("                                 WHERE VSL_CD = G.VSL_CD" ).append("\n"); 
		query.append("                                   AND REV_YRMON BETWEEN REPLACE(@[fr_duration],'-') AND REPLACE(@[to_duration],'-')" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = SUBSTR(REPLACE(@[exe_yrmon],'-'), 3, 4)" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = 'V'" ).append("\n"); 
		query.append("                                   AND REV_DIR_CD = 'V')" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("            SELECT *" ).append("\n"); 
		query.append("              FROM GL_ESTM_REV_VVD G" ).append("\n"); 
		query.append("             WHERE G.EXE_YRMON      = REPLACE(@[exe_yrmon],'-')" ).append("\n"); 
		query.append("               AND G.REV_YRMON      BETWEEN REPLACE(@[fr_duration],'-') AND REPLACE(@[to_duration],'-')" ).append("\n"); 
		query.append("               AND G.ESTM_VVD_TP_CD = 'PV'" ).append("\n"); 
		query.append("               AND NOT (SUBSTRB(G.RLANE_CD, 4, 1) <> 'I' AND SUBSTRB(G.ESTM_IOC_DIV_CD, 1, 1) = 'I')" ).append("\n"); 
		query.append("               AND NOT EXISTS ( SELECT NULL" ).append("\n"); 
		query.append("                                  FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("                                 WHERE EXE_YRMON = G.EXE_YRMON" ).append("\n"); 
		query.append("                                   AND REV_YRMON = G.REV_YRMON" ).append("\n"); 
		query.append("                                   AND VSL_CD = G.VSL_CD" ).append("\n"); 
		query.append("                                   AND SKD_VOY_NO = G.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND SKD_DIR_CD = G.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND REV_DIR_CD = G.REV_DIR_CD" ).append("\n"); 
		query.append("                                   AND ESTM_VVD_TP_CD = G.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                                   AND ESTM_IOC_DIV_CD = 'OO')" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append("         , V_FMS_CONTRACT B" ).append("\n"); 
		query.append("     WHERE A.VSL_CD = B.VSL_CD " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT 'I' AS IBFLAG" ).append("\n"); 
		query.append("     , A.EXE_YRMON" ).append("\n"); 
		query.append("     , A.REV_YRMON" ).append("\n"); 
		query.append("     , A.REV_YRMON||A.FLET_CTRT_TP_CD AS SUBSUMCOL" ).append("\n"); 
		query.append("     , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.VST_DT" ).append("\n"); 
		query.append("     , A.VED_DT" ).append("\n"); 
		query.append("     , A.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("     , ROUND(A.HIRE_AMT, 3) AS HIRE_AMT" ).append("\n"); 
		query.append("     , ROUND(SUM(A.EST_AMT), 3) AS EST_AMT" ).append("\n"); 
		query.append("  FROM (SELECT VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , REV_DIR_CD" ).append("\n"); 
		query.append("             , EXE_YRMON" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , FLET_CTRT_NO" ).append("\n"); 
		query.append("             , MIN(HIRE_EFF_DT) HIRE_EFF_DT" ).append("\n"); 
		query.append("             , MAX(HIRE_EXP_DT) HIRE_EXP_DT" ).append("\n"); 
		query.append("             , MIN(HIRE_N1ST_AMT + HIRE_N2ND_AMT) HIRE_AMT" ).append("\n"); 
		query.append("             , SUM(DAYS*(HIRE_N1ST_AMT + HIRE_N2ND_AMT)) EST_AMT" ).append("\n"); 
		query.append("             , VST_DT" ).append("\n"); 
		query.append("             , VED_DT" ).append("\n"); 
		query.append("             , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("             , FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , RLANE_CD" ).append("\n"); 
		query.append("          FROM (SELECT A.VSL_CD" ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , A.REV_DIR_CD" ).append("\n"); 
		query.append("                     , A.EXE_YRMON" ).append("\n"); 
		query.append("                     , A.REV_YRMON" ).append("\n"); 
		query.append("                     , C.FLET_CTRT_NO" ).append("\n"); 
		query.append("                     , CASE WHEN A.VST_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                            ELSE TRUNC(C.EFF_DT)" ).append("\n"); 
		query.append("                       END HIRE_EFF_DT" ).append("\n"); 
		query.append("                     , CASE WHEN A.VED_DT > TO_CHAR(C.EXP_DT,'YYYYMMDD') THEN TRUNC(C.EXP_DT)-1" ).append("\n"); 
		query.append("                            ELSE TO_DATE(A.VED_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                       END HIRE_EXP_DT" ).append("\n"); 
		query.append("                     , CASE WHEN A.VED_DT > TO_CHAR(C.EXP_DT,'YYYYMMDD') THEN TRUNC(C.EXP_DT)-1" ).append("\n"); 
		query.append("                            ELSE TO_DATE(A.VED_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                       END - " ).append("\n"); 
		query.append("                       CASE WHEN A.VST_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD')" ).append("\n"); 
		query.append("                            ELSE TRUNC(C.EFF_DT)" ).append("\n"); 
		query.append("                       END +1 DAYS" ).append("\n"); 
		query.append("                     , CASE WHEN SUBSTR(TO_CHAR(FIRST_VALUE(C.EXP_DT) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT),'YYYYMMDDHH24MISS'),9,4) = '0000'" ).append("\n"); 
		query.append("                                 AND C.HIR_CURR_N2ND_CD IS NULL THEN NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (" ).append("\n"); 
		query.append("                                                            SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("                                                              FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                                             WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_LVL = '1')),0)" ).append("\n"); 
		query.append("                            ELSE FIRST_VALUE(NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (" ).append("\n"); 
		query.append("                                                            SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("                                                              FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                                             WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_LVL = '1')),0)) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT DESC)" ).append("\n"); 
		query.append("                       END HIRE_N1ST_AMT" ).append("\n"); 
		query.append("                     , CASE WHEN SUBSTR(TO_CHAR(FIRST_VALUE(C.EXP_DT) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT),'YYYYMMDDHH24MISS'),9,4) = '0000'" ).append("\n"); 
		query.append("                                 AND C.HIR_CURR_N2ND_CD IS NULL THEN NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (" ).append("\n"); 
		query.append("                                                            SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("                                                              FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                                             WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_LVL = '1')),0)" ).append("\n"); 
		query.append("                            ELSE FIRST_VALUE(NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (" ).append("\n"); 
		query.append("                                                            SELECT NVL(EX1.USD_LOCL_XCH_RT,1)" ).append("\n"); 
		query.append("                                                              FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("                                                             WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON" ).append("\n"); 
		query.append("                                                               AND EX1.ACCT_XCH_RT_LVL = '1')),0)) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT DESC)" ).append("\n"); 
		query.append("                       END HIRE_N2ND_AMT" ).append("\n"); 
		query.append("                     , A.VST_DT" ).append("\n"); 
		query.append("                     , A.VED_DT" ).append("\n"); 
		query.append("                     , A.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("                     , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("                     , A.RLANE_CD" ).append("\n"); 
		query.append("                  FROM V_ESTM_REV_VVD A" ).append("\n"); 
		query.append("                     , FMS_HIRE C" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND A.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("                   AND A.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("                   AND A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("                   AND A.VST_DT <= TO_CHAR(C.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("                   AND A.VED_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("         GROUP BY VSL_CD" ).append("\n"); 
		query.append("             , SKD_VOY_NO" ).append("\n"); 
		query.append("             , SKD_DIR_CD" ).append("\n"); 
		query.append("             , REV_DIR_CD" ).append("\n"); 
		query.append("             , EXE_YRMON" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , FLET_CTRT_NO" ).append("\n"); 
		query.append("             , VST_DT" ).append("\n"); 
		query.append("             , VED_DT" ).append("\n"); 
		query.append("             , ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("             , FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("             , RLANE_CD " ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" GROUP BY A.EXE_YRMON" ).append("\n"); 
		query.append("     , A.REV_YRMON" ).append("\n"); 
		query.append("     , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.VSL_CD" ).append("\n"); 
		query.append("     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , A.REV_DIR_CD" ).append("\n"); 
		query.append("     , A.VST_DT" ).append("\n"); 
		query.append("     , A.VED_DT" ).append("\n"); 
		query.append("     , A.HIRE_AMT" ).append("\n"); 
		query.append("     , A.VST_DT" ).append("\n"); 
		query.append("     , A.VED_DT" ).append("\n"); 
		query.append("     , A.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("     , A.FLET_CTRT_TP_CD" ).append("\n"); 
		query.append(" ORDER BY A.REV_YRMON" ).append("\n"); 
		query.append("     , A.FLET_CTRT_TP_CD " ).append("\n"); 

	}
}