/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : EstimationReportDBDAOsearchMonEstmCompDiffListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EstimationReportDBDAOsearchMonEstmCompDiffListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 당월과 전월, 당월과 전년월의 차이를 retireve
	  * </pre>
	  */
	public EstimationReportDBDAOsearchMonEstmCompDiffListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.integration").append("\n"); 
		query.append("FileName : EstimationReportDBDAOsearchMonEstmCompDiffListRSQL").append("\n"); 
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
		query.append("SELECT RLANE_CD," ).append("\n"); 
		query.append("       SUM(CNT_1) - SUM(CNT_12) SUM_CNT1," ).append("\n"); 
		query.append("       SUM(CNT_PORT_1) - SUM(CNT_PORT_12) SUM_CNT_PORT," ).append("\n"); 
		query.append("       SUM(ACT_PORT_1) - SUM(ACT_PORT_2) SUM_ACT_PORT," ).append("\n"); 
		query.append("       SUM(AMT_1) - SUM(AMT_11) AS SUM_AMT1 ," ).append("\n"); 
		query.append("       SUM(CNT_2) - SUM(CNT_22) AS SUM_CNT2 ," ).append("\n"); 
		query.append("       SUM(AMT_2) - SUM(AMT_22) SUM_AMT2," ).append("\n"); 
		query.append("       SUM(AMT_1) - SUM(AMT_11) + SUM(AMT_2) - SUM(AMT_22) TOTAL_SUM_AMT " ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT RLANE_CD" ).append("\n"); 
		query.append("               ,COUNT(*) AS CNT_1,0 CNT_12, SUM(DECODE(PPORT,0,PORT,PPORT)) CNT_PORT_1,0 CNT_PORT_12, " ).append("\n"); 
		query.append("                SUM(DECODE(ACT_PPORT,0,ACT_PORT,ACT_PPORT)) ACT_PORT_1, 0 ACT_PORT_2,0 AMT_1,0 AMT_11,0 CNT_2, 0 CNT_22," ).append("\n"); 
		query.append("                 0 AMT_2, 0 AMT_22 " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("                 " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (SELECT DISTINCT E.RLANE_CD, E.VSL_CD, E.SKD_VOY_NO, E.SKD_DIR_CD," ).append("\n"); 
		query.append("                (SELECT COUNT(*) FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                WHERE VSL_CD = E.VSL_CD AND SKD_VOY_NO = E.SKD_VOY_NO AND SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(SKD_CNG_STS_CD, 'X') <> 'S') PORT ," ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                 (SELECT COUNT(*) FROM VSK_VSL_PORT_SKD A, PSO_PORT_EXPN_DIV B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND A.VSL_CD = E.VSL_CD AND A.SKD_VOY_NO = E.SKD_VOY_NO AND A.SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND A.SLAN_CD  = B.SLAN_CD" ).append("\n"); 
		query.append("                AND A.VPS_PORT_CD = B.LOC_CD" ).append("\n"); 
		query.append("                AND E.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S') PPORT," ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                (SELECT SUM(DECODE(NVL(TURN_SKD_VOY_NO, 1), 1, 1, 0.5)) -- TURNNING OR VIRTUAL인 경우 0.5" ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                WHERE VSL_CD = E.VSL_CD AND SKD_VOY_NO = E.SKD_VOY_NO AND SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(SKD_CNG_STS_CD, 'X') <> 'S') ACT_PORT," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                  NVL ((SELECT  SUM(DECODE(NVL(TURN_SKD_VOY_NO, 1), 1, 1, 0.5)) -- TURNNING OR VIRTUAL인 경우 0.5" ).append("\n"); 
		query.append("                        FROM VSK_VSL_PORT_SKD A, PSO_PORT_EXPN_DIV B" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND A.VSL_CD = E.VSL_CD AND A.SKD_VOY_NO = E.SKD_VOY_NO AND A.SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND A.SLAN_CD  = B.SLAN_CD" ).append("\n"); 
		query.append("                        AND A.VPS_PORT_CD = B.LOC_CD" ).append("\n"); 
		query.append("                        AND E.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                        AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S'),0) ACT_PPORT" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("        FROM GL_ESTM_REV_VVD E, GL_ESTM_IF_ERP P" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("        --AND E.EXE_YRMON = REPLACE([rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.REV_YRMON = REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("        AND E.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND E.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND E.REV_DIR_CD = P.REV_DIR_CD" ).append("\n"); 
		query.append("        AND E.ESTM_VVD_TP_CD = P.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        AND E.REV_YRMON = P.REV_YRMON" ).append("\n"); 
		query.append("		AND E.EXE_YRMON = P.EXE_YRMON" ).append("\n"); 
		query.append("        AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                            WHERE REV_YRMON = REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("                              AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("        AND P.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("        AND E.ESTM_IOC_DIV_CD = P.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        AND P.ACCT_CD <> '511911'" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        GROUP  BY RLANE_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       SELECT RLANE_CD" ).append("\n"); 
		query.append("               ,0 AS CNT_1,COUNT(*) AS CNT_12, 0 CNT_PORT_1, SUM(DECODE(PPORT,0,PORT,PPORT))  CNT_PORT_12, " ).append("\n"); 
		query.append("                0 ACT_PORT_1, SUM(DECODE(ACT_PPORT,0,ACT_PORT,ACT_PPORT)) ACT_PORT_2,0 AMT_1,0 AMT_11," ).append("\n"); 
		query.append("                0 CNT_2, 0 CNT_22,0 AMT_2, 0 AMT_22 " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (SELECT DISTINCT E.RLANE_CD, E.VSL_CD, E.SKD_VOY_NO, E.SKD_DIR_CD," ).append("\n"); 
		query.append("                (SELECT COUNT(*) FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                WHERE VSL_CD = E.VSL_CD AND SKD_VOY_NO = E.SKD_VOY_NO AND SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(SKD_CNG_STS_CD, 'X') <> 'S') PORT ," ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                 (SELECT COUNT(*) FROM VSK_VSL_PORT_SKD A, PSO_PORT_EXPN_DIV B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND A.VSL_CD = E.VSL_CD AND A.SKD_VOY_NO = E.SKD_VOY_NO AND A.SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND A.SLAN_CD  = B.SLAN_CD" ).append("\n"); 
		query.append("                AND A.VPS_PORT_CD = B.LOC_CD" ).append("\n"); 
		query.append("                AND E.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S') PPORT," ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                (SELECT SUM(DECODE(NVL(TURN_SKD_VOY_NO, 1), 1, 1, 0.5)) -- TURNNING OR VIRTUAL인 경우 0.5" ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                WHERE VSL_CD = E.VSL_CD AND SKD_VOY_NO = E.SKD_VOY_NO AND SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(SKD_CNG_STS_CD, 'X') <> 'S') ACT_PORT," ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("                  NVL ((SELECT  SUM(DECODE(NVL(TURN_SKD_VOY_NO, 1), 1, 1, 0.5)) -- TURNNING OR VIRTUAL인 경우 0.5" ).append("\n"); 
		query.append("                        FROM VSK_VSL_PORT_SKD A, PSO_PORT_EXPN_DIV B" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("                        AND A.VSL_CD = E.VSL_CD AND A.SKD_VOY_NO = E.SKD_VOY_NO AND A.SKD_DIR_CD = E.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND A.SLAN_CD  = B.SLAN_CD" ).append("\n"); 
		query.append("                        AND A.VPS_PORT_CD = B.LOC_CD" ).append("\n"); 
		query.append("                        AND E.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("                        AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND NVL(A.SKD_CNG_STS_CD, 'X') <> 'S'),0) ACT_PPORT" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM GL_ESTM_REV_VVD E, GL_ESTM_IF_ERP P" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("#if (${chk_rdo} == 'PM') " ).append("\n"); 
		query.append("--        AND E.EXE_YRMON = REPLACE([rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--        AND E.EXE_YRMON = substr([rev_yrmon],1,4) - 1 || 12" ).append("\n"); 
		query.append("        AND E.REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-12),'YYYYMM')" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("        AND E.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("        AND E.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND E.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND E.REV_DIR_CD = P.REV_DIR_CD" ).append("\n"); 
		query.append("        AND E.ESTM_VVD_TP_CD = P.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        AND E.REV_YRMON = P.REV_YRMON" ).append("\n"); 
		query.append("		AND E.EXE_YRMON = P.EXE_YRMON" ).append("\n"); 
		query.append("  #if (${chk_rdo} == 'PM')       " ).append("\n"); 
		query.append("        AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                            WHERE REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("                              AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("           AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                            WHERE REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-12),'YYYYMM')" ).append("\n"); 
		query.append("                              AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("  #end      " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        AND P.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("        AND E.ESTM_IOC_DIV_CD = P.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        AND P.ACCT_CD <> '511911'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("        GROUP  BY RLANE_CD" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        SELECT RLANE_CD," ).append("\n"); 
		query.append("               0 CNT_1,0 CNT_12, 0 CNT_PORT_1,0 CNT_PORT_12, " ).append("\n"); 
		query.append("               0 ACT_PORT_1, 0 ACT_PORT_2,0 AMT_1,0 AMT_11 ,COUNT(*) CNT_2,0 CNT_22," ).append("\n"); 
		query.append("               0 AMT_2, 0 AMT_22 " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (SELECT DISTINCT E.RLANE_CD, E.VSL_CD, E.SKD_VOY_NO, E.SKD_DIR_CD " ).append("\n"); 
		query.append("        FROM GL_ESTM_REV_VVD E, GL_ESTM_IF_ERP P" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("--        AND E.EXE_YRMON = REPLACE([rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.REV_YRMON = REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("        AND E.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND E.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND E.REV_DIR_CD = P.REV_DIR_CD" ).append("\n"); 
		query.append("        AND E.ESTM_VVD_TP_CD = P.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        AND E.REV_YRMON = P.REV_YRMON" ).append("\n"); 
		query.append("		AND E.EXE_YRMON = P.EXE_YRMON" ).append("\n"); 
		query.append("        AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                                    WHERE REV_YRMON = REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("                                       AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("        AND P.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("        AND E.ESTM_IOC_DIV_CD = P.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        AND P.ACCT_CD = '511911'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        GROUP BY RLANE_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("         SELECT RLANE_CD," ).append("\n"); 
		query.append("               0 CNT_1,0 CNT_12, 0 CNT_PORT_1,0 CNT_PORT_12, " ).append("\n"); 
		query.append("               0 ACT_PORT_1, 0 ACT_PORT_2,0 AMT_1, 0 AMT_11, 0 CNT_2,COUNT(*) CNT_22," ).append("\n"); 
		query.append("               0 AMT_2, 0 AMT_22 " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("        (SELECT DISTINCT E.RLANE_CD, E.VSL_CD, E.SKD_VOY_NO, E.SKD_DIR_CD " ).append("\n"); 
		query.append("        FROM GL_ESTM_REV_VVD E, GL_ESTM_IF_ERP P" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("#if (${chk_rdo} == 'PM') " ).append("\n"); 
		query.append("--        AND E.EXE_YRMON = REPLACE([rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--        AND E.EXE_YRMON = substr([rev_yrmon],1,4) - 1 || 12" ).append("\n"); 
		query.append("        AND E.REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-12),'YYYYMM')" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("        AND E.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("        AND E.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND E.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND E.REV_DIR_CD = P.REV_DIR_CD" ).append("\n"); 
		query.append("        AND E.ESTM_VVD_TP_CD = P.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        AND E.REV_YRMON = P.REV_YRMON" ).append("\n"); 
		query.append("		AND E.EXE_YRMON = P.EXE_YRMON" ).append("\n"); 
		query.append("  #if (${chk_rdo} == 'PM')       " ).append("\n"); 
		query.append("        AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                            WHERE REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("                              AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("           AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                            WHERE REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-12),'YYYYMM')" ).append("\n"); 
		query.append("                              AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("  #end     " ).append("\n"); 
		query.append("        AND P.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("        AND E.ESTM_IOC_DIV_CD = P.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        AND P.ACCT_CD = '511911'" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        GROUP BY RLANE_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT  RLANE_CD," ).append("\n"); 
		query.append("               0 CNT_1,0 CNT_12, 0 CNT_PORT_1,0 CNT_PORT_12, " ).append("\n"); 
		query.append("               0 ACT_PORT_1, 0 ACT_PORT_2," ).append("\n"); 
		query.append("               SUM(DECODE(X.ACCT_CD, '511911', 0, NVL(ESTM_AMT, 0))) AS AMT_1,  0 AMT_11," ).append("\n"); 
		query.append("               0 CNT_2," ).append("\n"); 
		query.append("               0 CNT_22," ).append("\n"); 
		query.append("               SUM(DECODE(X.ACCT_CD, '511911', NVL(ESTM_AMT, 0), 0)) AS AMT_2,  0 AMT_22  " ).append("\n"); 
		query.append("      FROM   " ).append("\n"); 
		query.append("     ( SELECT DISTINCT E.RLANE_CD, P.*" ).append("\n"); 
		query.append("        FROM GL_ESTM_REV_VVD E, GL_ESTM_IF_ERP P" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("--        AND E.EXE_YRMON = REPLACE([rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.REV_YRMON = REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("        AND E.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND E.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND E.REV_DIR_CD = P.REV_DIR_CD" ).append("\n"); 
		query.append("       -- AND E.ESTM_VVD_TP_CD = P.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        AND E.REV_YRMON = P.REV_YRMON" ).append("\n"); 
		query.append("		AND E.EXE_YRMON = P.EXE_YRMON" ).append("\n"); 
		query.append("        AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                                    WHERE REV_YRMON = REPLACE(@[rev_yrmon], '-', '')" ).append("\n"); 
		query.append("                                       AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("        AND P.SYS_SRC_ID = 'PSO' ) X" ).append("\n"); 
		query.append("      --  AND E.ESTM_IOC_DIV_CD = P.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        GROUP BY X.RLANE_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        SELECT  RLANE_CD," ).append("\n"); 
		query.append("               0 CNT_1,0 CNT_12, 0 CNT_PORT_1,0 CNT_PORT_12, " ).append("\n"); 
		query.append("               0 ACT_PORT_1, 0 ACT_PORT_2," ).append("\n"); 
		query.append("               0  AMT_1,  SUM(DECODE(P.ACCT_CD, '511911', 0, NVL(ESTM_AMT, 0))) AMT_11," ).append("\n"); 
		query.append("               0 CNT_2," ).append("\n"); 
		query.append("               0 CNT_22," ).append("\n"); 
		query.append("               0 AMT_2,  SUM(DECODE(P.ACCT_CD, '511911', NVL(ESTM_AMT, 0), 0))  AMT_22 " ).append("\n"); 
		query.append("        FROM GL_ESTM_REV_VVD E, GL_ESTM_IF_ERP P" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("#if (${chk_rdo} == 'PM') " ).append("\n"); 
		query.append("--        AND E.EXE_YRMON = REPLACE([rev_yrmon], '-', '')" ).append("\n"); 
		query.append("        AND E.REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("--        AND E.EXE_YRMON = substr([rev_yrmon],1,4) - 1 || 12" ).append("\n"); 
		query.append("        AND E.REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-12),'YYYYMM')" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("        AND E.VSL_CD = P.VSL_CD" ).append("\n"); 
		query.append("        AND E.SKD_VOY_NO = P.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND E.SKD_DIR_CD = P.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND E.REV_DIR_CD = P.REV_DIR_CD" ).append("\n"); 
		query.append("        AND E.ESTM_VVD_TP_CD = P.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("        AND E.REV_YRMON = P.REV_YRMON" ).append("\n"); 
		query.append("		AND E.EXE_YRMON = P.EXE_YRMON" ).append("\n"); 
		query.append("   #if (${chk_rdo} == 'PM')       " ).append("\n"); 
		query.append("        AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                            WHERE REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-1),'YYYYMM')" ).append("\n"); 
		query.append("                              AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("           AND P.EXE_YRMON IN (SELECT DISTINCT EXE_YRMON  FROM GL_ESTM_IF_ERP " ).append("\n"); 
		query.append("                            WHERE REV_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(@[rev_yrmon], 'YYYY-MM'),-12),'YYYYMM')" ).append("\n"); 
		query.append("                              AND SYS_SRC_ID = 'PSO')" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("        AND P.SYS_SRC_ID = 'PSO'" ).append("\n"); 
		query.append("        AND E.ESTM_IOC_DIV_CD = P.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("        GROUP BY E.RLANE_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ) " ).append("\n"); 
		query.append("  GROUP BY RLANE_CD" ).append("\n"); 
		query.append("  ORDER BY RLANE_CD" ).append("\n"); 

	}
}