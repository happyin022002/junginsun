/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TCharterIOEstimatedDBDAOSearchEstimatedProRevenueListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.integration").append("\n"); 
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
		query.append("SELECT 'I' ibflag," ).append("\n"); 
		query.append("		@[exe_yrmon] EXE_YRMON, A.REV_YRMON, A.REV_YRMON||A.FLET_CTRT_TP_CD SUBSUMCOL," ).append("\n"); 
		query.append("       A.FLET_CTRT_TP_CD, A.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("       A.RLANE_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("       A.VST_DT, A.VED_DT, A.ESTM_IOC_DIV_CD," ).append("\n"); 
		query.append("       A.HIRE_AMT," ).append("\n"); 
		query.append("       SUM(A.EST_AMT) EST_AMT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("			(SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, REV_YRMON," ).append("\n"); 
		query.append("					FLET_CTRT_NO,  MIN(HIRE_EFF_DT) HIRE_EFF_DT,MAX(HIRE_EXP_DT) HIRE_EXP_DT," ).append("\n"); 
		query.append("					MIN(HIRE_N1ST_AMT + HIRE_N2ND_AMT) HIRE_AMT," ).append("\n"); 
		query.append("					SUM(DAYS*(HIRE_N1ST_AMT + HIRE_N2ND_AMT)) EST_AMT," ).append("\n"); 
		query.append("         VST_DT, VED_DT, ESTM_IOC_DIV_CD, FLET_CTRT_TP_CD, RLANE_CD" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("			 FROM (" ).append("\n"); 
		query.append("					SELECT A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD, A.REV_YRMON," ).append("\n"); 
		query.append("							C.FLET_CTRT_NO," ).append("\n"); 
		query.append("							CASE WHEN A.VST_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD') ELSE TRUNC(C.EFF_DT) END HIRE_EFF_DT," ).append("\n"); 
		query.append("							CASE WHEN A.VED_DT > TO_CHAR(C.EXP_DT,'YYYYMMDD') THEN TRUNC(C.EXP_DT)-1 ELSE TO_DATE(A.VED_DT, 'YYYYMMDD') END HIRE_EXP_DT," ).append("\n"); 
		query.append("							CASE WHEN A.VED_DT > TO_CHAR(C.EXP_DT,'YYYYMMDD') THEN TRUNC(C.EXP_DT)-1 ELSE TO_DATE(A.VED_DT, 'YYYYMMDD') END -" ).append("\n"); 
		query.append("							CASE WHEN A.VST_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD') THEN TO_DATE(A.VST_DT, 'YYYYMMDD') ELSE TRUNC(C.EFF_DT) END +1 DAYS," ).append("\n"); 
		query.append("						    CASE WHEN SUBSTR(TO_CHAR(FIRST_VALUE(C.EXP_DT) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT),'YYYYMMDDHH24MISS'),9,4) = '0000' AND C.HIR_CURR_N2ND_CD IS NULL THEN" ).append("\n"); 
		query.append("									  NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("																									WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0)" ).append("\n"); 
		query.append("								 ELSE" ).append("\n"); 
		query.append("									  FIRST_VALUE(NVL(C.HIR_RT_N1ST_AMT/DECODE(C.HIR_CURR_N1ST_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("																											   WHERE C.HIR_CURR_N1ST_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0))" ).append("\n"); 
		query.append("																			OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT DESC)" ).append("\n"); 
		query.append("							 END HIRE_N1ST_AMT," ).append("\n"); 
		query.append("							CASE WHEN SUBSTR(TO_CHAR(FIRST_VALUE(C.EXP_DT) OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT),'YYYYMMDDHH24MISS'),9,4) = '0000' AND C.HIR_CURR_N2ND_CD IS NULL THEN" ).append("\n"); 
		query.append("									  NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("																									WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0)" ).append("\n"); 
		query.append("								 ELSE" ).append("\n"); 
		query.append("									  FIRST_VALUE(NVL(C.HIR_RT_N2ND_AMT/DECODE(C.HIR_CURR_N2ND_CD, 'USD', 1, (SELECT NVL(EX1.USD_LOCL_XCH_RT,1) FROM GL_MON_XCH_RT EX1" ).append("\n"); 
		query.append("																											   WHERE C.HIR_CURR_N2ND_CD = EX1.CURR_CD AND EX1.ACCT_XCH_RT_YRMON = A.REV_YRMON AND EX1.ACCT_XCH_RT_LVL = '3')),0))" ).append("\n"); 
		query.append("																			OVER(PARTITION BY C.FLET_CTRT_NO, A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD ORDER BY C.EXP_DT DESC)" ).append("\n"); 
		query.append("							 END HIRE_N2ND_AMT," ).append("\n"); 
		query.append("               A.VST_DT, A.VED_DT, A.ESTM_IOC_DIV_CD,A.FLET_CTRT_TP_CD, A.RLANE_CD" ).append("\n"); 
		query.append("					FROM " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("          		(SELECT DISTINCT A.REV_YRMON," ).append("\n"); 
		query.append("        		        B.FLET_CTRT_NO, B.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("        		        A.RLANE_CD, A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD_CD," ).append("\n"); 
		query.append("        		        A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("        		        A.VST_DT, A.VED_DT, A.ESTM_IOC_DIV_CD" ).append("\n"); 
		query.append("	            	FROM  " ).append("\n"); 
		query.append("                      (SELECT *" ).append("\n"); 
		query.append("                				FROM 	GL_ESTM_REV_VVD A" ).append("\n"); 
		query.append("                				WHERE 	EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("                				AND 	ESTM_VVD_TP_CD = 'PV'" ).append("\n"); 
		query.append("                				AND 	ESTM_IOC_DIV_CD = 'OO'" ).append("\n"); 
		query.append("                				UNION ALL" ).append("\n"); 
		query.append("                				SELECT *" ).append("\n"); 
		query.append("                				FROM 	GL_ESTM_REV_VVD A" ).append("\n"); 
		query.append("                				WHERE 	EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("                				AND 	ESTM_VVD_TP_CD = 'PV'" ).append("\n"); 
		query.append("                				AND 	ESTM_IOC_DIV_CD <> 'OO'" ).append("\n"); 
		query.append("                				AND		NOT (SUBSTRB(RLANE_CD, 4, 1) <> 'I' AND SUBSTRB(ESTM_IOC_DIV_CD, 1, 1) = 'I')" ).append("\n"); 
		query.append("                				AND 	NOT EXISTS (SELECT 	NULL" ).append("\n"); 
		query.append("                									FROM 	GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("                									WHERE	EXE_YRMON = A.EXE_YRMON" ).append("\n"); 
		query.append("                									AND		VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("                									AND		SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                									AND		SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                									AND		REV_DIR_CD = A.REV_DIR_CD" ).append("\n"); 
		query.append("                									AND		ESTM_VVD_TP_CD = A.ESTM_VVD_TP_CD" ).append("\n"); 
		query.append("                									AND		ESTM_IOC_DIV_CD = 'OO')) A," ).append("\n"); 
		query.append("                				(SELECT VSL_CD, FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT" ).append("\n"); 
		query.append("										WHERE FLET_CTRT_TP_CD = 'TI' AND FLET_CTRT_TP_CD LIKE null||'%' AND FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("										UNION ALL" ).append("\n"); 
		query.append("										SELECT FI.VSL_CD, FC.FLET_CTRT_NO, FLET_CTRT_TP_CD FROM FMS_CONTRACT FC, FMS_ID_VSL FI" ).append("\n"); 
		query.append("										WHERE FC.FLET_CTRT_NO = FI.FLET_CTRT_NO AND FC.FLET_CTRT_TP_CD = 'TI' AND FC.FLET_CTRT_TP_CD LIKE null||'%' AND FC.FLET_CTRT_FACT_CD = 'ACT') B" ).append("\n"); 
		query.append("                			WHERE 	A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                			) A," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      				FMS_HIRE C" ).append("\n"); 
		query.append("					WHERE A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("					AND 	A.VST_DT <= TO_CHAR(C.EXP_DT,'YYYYMMDD')" ).append("\n"); 
		query.append("					AND 	A.VED_DT >= TO_CHAR(C.EFF_DT,'YYYYMMDD') " ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD, REV_YRMON, FLET_CTRT_NO,  VST_DT, VED_DT, ESTM_IOC_DIV_CD, FLET_CTRT_TP_CD, RLANE_CD" ).append("\n"); 
		query.append("			) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.REV_YRMON," ).append("\n"); 
		query.append("       A.FLET_CTRT_TP_CD, A.FLET_CTRT_TP_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.REV_DIR_CD," ).append("\n"); 
		query.append("       A.VST_DT, A.VED_DT, A.HIRE_AMT,  VST_DT, VED_DT, ESTM_IOC_DIV_CD, FLET_CTRT_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY REV_YRMON, A.FLET_CTRT_TP_CD" ).append("\n"); 

	}
}