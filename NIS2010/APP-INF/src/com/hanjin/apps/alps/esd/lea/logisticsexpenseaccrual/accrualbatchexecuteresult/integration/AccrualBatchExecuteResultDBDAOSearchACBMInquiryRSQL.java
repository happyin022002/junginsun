/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchACBMInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchACBMInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Accessorial cost budget management Report
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchACBMInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstyr_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bind_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstyr_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_mon_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_sub_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gl_mon_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchACBMInquiryRSQL").append("\n"); 
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
		query.append("SELECT RHQ_CD," ).append("\n"); 
		query.append("       COST_MN_TP," ).append("\n"); 
		query.append("       MN_COST_TP_NM," ).append("\n"); 
		query.append("       SUB_COST_TP_NM," ).append("\n"); 
		query.append("       COA_COST_SRC_CD," ).append("\n"); 
		query.append("       COST_DESC," ).append("\n"); 
		query.append("       COST_SRC_SYS_CD," ).append("\n"); 
		query.append("#if (${f_report} == '2') " ).append("\n"); 
		query.append("       CTRL_OFC_CD,  " ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("       MON_BUD ," ).append("\n"); 
		query.append("       PRD_SUM," ).append("\n"); 
		query.append("       LSTYR_SUM," ).append("\n"); 
		query.append("       DIFF_BUD," ).append("\n"); 
		query.append("       DIFF_BUD_RTO," ).append("\n"); 
		query.append("       DIFF_LSTYR," ).append("\n"); 
		query.append("       TTL_BUD," ).append("\n"); 
		query.append("       TTL_BUD_RTO," ).append("\n"); 
		query.append("       MON1, MON2, MON3, MON4, MON5, MON6, " ).append("\n"); 
		query.append("       MON7, MON8, MON9, MON10, MON11, MON12" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  T.RHQ_CD," ).append("\n"); 
		query.append("        C.COST_MN_TP," ).append("\n"); 
		query.append("        C.MN_COST_TP_NM," ).append("\n"); 
		query.append("        C.SUB_COST_TP_NM," ).append("\n"); 
		query.append("        T.COA_COST_SRC_CD," ).append("\n"); 
		query.append("        C.COST_DESC," ).append("\n"); 
		query.append("        C.COST_SRC_SYS_CD," ).append("\n"); 
		query.append("#if (${f_report} == '2')  " ).append("\n"); 
		query.append("        T.CTRL_OFC_CD,    " ).append("\n"); 
		query.append("        T.MON_BUD ," ).append("\n"); 
		query.append("        T.PRD_SUM," ).append("\n"); 
		query.append("        T.LSTYR_SUM," ).append("\n"); 
		query.append("        (T.PRD_SUM - T.MON_BUD) AS DIFF_BUD," ).append("\n"); 
		query.append("        DECODE(T.MON_BUD,0,0,ROUND(T.PRD_SUM / T.MON_BUD,2))*100 AS DIFF_BUD_RTO," ).append("\n"); 
		query.append("        (T.PRD_SUM - T.LSTYR_SUM) AS DIFF_LSTYR," ).append("\n"); 
		query.append("        T.TTL_BUD," ).append("\n"); 
		query.append("        DECODE(T.TTL_BUD,0,0,ROUND(T.PRD_SUM / T.TTL_BUD,2))*100 AS TTL_BUD_RTO," ).append("\n"); 
		query.append("        T.MON1, T.MON2, T.MON3, T.MON4, T.MON5, T.MON6, " ).append("\n"); 
		query.append("        T.MON7, T.MON8, T.MON9, T.MON10, T.MON11, T.MON12" ).append("\n"); 
		query.append("#elseif(${f_report} == '1')" ).append("\n"); 
		query.append("		SUM(T.MON_BUD) AS MON_BUD," ).append("\n"); 
		query.append("        SUM(T.PRD_SUM) AS PRD_SUM," ).append("\n"); 
		query.append("        SUM(T.LSTYR_SUM) AS LSTYR_SUM," ).append("\n"); 
		query.append("        (SUM(T.PRD_SUM) -  SUM(T.MON_BUD)) AS DIFF_BUD," ).append("\n"); 
		query.append("        (DECODE(SUM(T.MON_BUD),0,0,ROUND(SUM(T.PRD_SUM) /SUM(T.MON_BUD),2))*100) AS DIFF_BUD_RTO," ).append("\n"); 
		query.append("        (SUM(T.PRD_SUM) - SUM(T.LSTYR_SUM)) AS DIFF_LSTYR," ).append("\n"); 
		query.append("        SUM(T.TTL_BUD) AS TTL_BUD," ).append("\n"); 
		query.append("        (DECODE(SUM(T.TTL_BUD),0,0,ROUND(SUM(T.PRD_SUM)/SUM(T.TTL_BUD),2))*100) AS TTL_BUD_RTO," ).append("\n"); 
		query.append("        SUM(T.MON1) AS MON1,SUM(T.MON2) AS MON2, SUM(T.MON3) AS MON3, SUM(T.MON4) AS MON4," ).append("\n"); 
		query.append("        SUM(T.MON5) AS MON5,SUM(T.MON6) AS MON6, SUM(T.MON7) AS MON7, SUM(T.MON8) AS MON8," ).append("\n"); 
		query.append("        SUM(T.MON9) AS MON9,SUM(T.MON10) AS MON10, SUM(T.MON11) AS MON11, SUM(T.MON12) AS MON12" ).append("\n"); 
		query.append("#end         " ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT	B.RHQ_CD RHQ_CD," ).append("\n"); 
		query.append("		F.CTRL_OFC_CD CTRL_OFC_CD," ).append("\n"); 
		query.append("		F.COA_COST_SRC_CD COA_COST_SRC_CD, " ).append("\n"); 
		query.append("		ROUND(F.MON_BUD_USD_AMT *(REPLACE(@[gl_mon_to], '-') - REPLACE(@[gl_mon_from], '-')+1),2) MON_BUD," ).append("\n"); 
		query.append("        ROUND(NVL(SUM(CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				  ROUND(M.LOCL_COST_AMT /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	              ELSE M.USD_COST_AMT" ).append("\n"); 
		query.append("		          END ),0),2) PRD_SUM," ).append("\n"); 
		query.append("         (SELECT  ROUND(NVL(SUM(CASE WHEN LM.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				          ROUND(LM.LOCL_COST_AMT /(SELECT U1.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U1 " ).append("\n"); 
		query.append("                                             WHERE U1.ACCT_XCH_RT_YRMON =  REPLACE(@[lstyr_to],'-')" ).append("\n"); 
		query.append("                                               AND U1.CURR_CD =  LM.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U1.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U1.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                      ELSE LM.USD_COST_AMT" ).append("\n"); 
		query.append("		                  END  ),0),2) " ).append("\n"); 
		query.append("           FROM LEA_ACT_COST_IF LM" ).append("\n"); 
		query.append("           WHERE LM.EXE_YRMON(+) BETWEEN REPLACE(@[lstyr_from], '-') AND REPLACE(@[lstyr_to], '-')" ).append("\n"); 
		query.append("           AND F.COA_COST_SRC_CD = LM.COA_COST_SRC_CD" ).append("\n"); 
		query.append("           AND F.CTRL_OFC_CD  = DECODE(LM.CTRL_OFC_CD ,'PUSBS','PUSSC','PUSBO','PUSSC','SKGBA', 'PIRBA', LM.CTRL_OFC_CD)" ).append("\n"); 
		query.append("           AND LM.OTR_CRR_FLG = 'N'" ).append("\n"); 
		query.append("          ) LSTYR_SUM," ).append("\n"); 
		query.append("        ROUND(F.TTL_USD_AMT,2) TTL_BUD," ).append("\n"); 
		query.append("        ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				            ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'01',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                                                                            FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                                                                           WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                                                                             AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		                                                 AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		                                                 AND U.DELT_FLG = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'01',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                END ),0),2) MON1," ).append("\n"); 
		query.append("        ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				            ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'02',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                                                                            FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                                                                           WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                                                                             AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		                                                 AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		                                                 AND U.DELT_FLG = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'02',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                END ),0),2) MON2,        " ).append("\n"); 
		query.append("        ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				            ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'03',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                                                                             FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                                                                            WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                                                                              AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		                                                  AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		                                                  AND U.DELT_FLG = 'N'), 2)" ).append("\n"); 
		query.append("	                   ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'03',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		               END ),0),2) MON3," ).append("\n"); 
		query.append("        ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				           ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'04',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                   ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'04',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		               END ),0),2) MON4,  " ).append("\n"); 
		query.append("	    ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				            ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'05',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                                                                 FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                   ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'05',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		               END ),0),2) MON5," ).append("\n"); 
		query.append("       ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				                   ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'06',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'06',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                  END ),0),2) MON6,  	                         " ).append("\n"); 
		query.append("       ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				                   ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'07',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'07',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                  END ),0),2) MON7,  	        " ).append("\n"); 
		query.append("       ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				                   ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'08',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'08',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                  END ),0),2) MON8,  	                         " ).append("\n"); 
		query.append("       ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				                   ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'09',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'09',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                  END ),0),2) MON9," ).append("\n"); 
		query.append("		       ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				                   ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'10',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'10',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                  END ),0),2) MON10,  	                         " ).append("\n"); 
		query.append("       ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				                   ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'11',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'11',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                  END ),0),2) MON11," ).append("\n"); 
		query.append("		   ROUND(NVL(SUM( CASE WHEN M.REV_YRMON IS NULL THEN" ).append("\n"); 
		query.append("				                   ROUND(DECODE(SUBSTR(M.EXE_YRMON,5,2),'12',M.LOCL_COST_AMT,0) /(SELECT U.USD_LOCL_XCH_RT  " ).append("\n"); 
		query.append("                                              FROM GL_MON_XCH_RT U " ).append("\n"); 
		query.append("                                             WHERE U.ACCT_XCH_RT_YRMON =  REPLACE(@[gl_mon_to],'-')" ).append("\n"); 
		query.append("                                               AND U.CURR_CD =  M.LOCL_CURR_CD" ).append("\n"); 
		query.append("                                      		   AND U.ACCT_XCH_RT_LVL = '3'" ).append("\n"); 
		query.append("                                      		   AND U.DELT_FLG 		 = 'N'), 2)" ).append("\n"); 
		query.append("	                    ELSE DECODE(SUBSTR(M.EXE_YRMON,5,2),'12',M.USD_COST_AMT,0)" ).append("\n"); 
		query.append("		                  END ),0),2) MON12" ).append("\n"); 
		query.append(" FROM LEA_YRY_COST_BUD F, LEA_ACT_COST_IF M," ).append("\n"); 
		query.append("	 (SELECT  YY.RHQ_CD ,YY.OFC_CD , YY.SUB_OFC_CD" ).append("\n"); 
		query.append("	  FROM( SELECT DISTINCT" ).append("\n"); 
		query.append("                   	CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SHARC' --('SELTOB','SELCOE') THEN 'SHAAS'" ).append("\n"); 
		query.append("                         ELSE XX.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                    END	      AS RHQ_CD" ).append("\n"); 
		query.append("               	   ,CASE WHEN XX.OFC_CD IN ('SELTBB','SELOPE') THEN 'SELSC' --('SELTOB','SELCOE') THEN 'SELBB'" ).append("\n"); 
		query.append("                         ELSE XX.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                   	END       AS OFC_CD" ).append("\n"); 
		query.append("               		, XX.OFC_CD AS SUB_OFC_CD" ).append("\n"); 
		query.append("        	FROM(  SELECT *" ).append("\n"); 
		query.append("                     FROM( SELECT L.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                                      ,L.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("                                      ,L.OFC_CD" ).append("\n"); 
		query.append("                                      ,L.OFC_APLY_TO_YRMON" ).append("\n"); 
		query.append("                                      ,L.OFC_APLY_FM_YRMON" ).append("\n"); 
		query.append("                                      ,ROW_NUMBER() OVER (PARTITION BY L.OFC_CD ORDER BY L.OFC_APLY_TO_YRMON DESC)  OFC_ORDER" ).append("\n"); 
		query.append("                              FROM  COA_OFC_LVL L" ).append("\n"); 
		query.append("                             WHERE  L.OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                               AND  L.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("                           ) X" ).append("\n"); 
		query.append("                     WHERE X.OFC_ORDER = 1" ).append("\n"); 
		query.append("                  ) XX" ).append("\n"); 
		query.append("			  ) YY" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("    #if (${f_rhq_cd} != '')" ).append("\n"); 
		query.append("     AND YY.RHQ_CD = @[f_rhq_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${f_ofc_cd} != '')" ).append("\n"); 
		query.append("	AND YY.OFC_CD = @[f_ofc_cd]" ).append("\n"); 
		query.append("    #elseif(${f_report} == '2')" ).append("\n"); 
		query.append("	AND YY.OFC_CD IN (    SELECT DISTINCT" ).append("\n"); 
		query.append("						         LL.OFC_N5TH_LVL_CD" ).append("\n"); 
		query.append("					 	   FROM   COA_OFC_LVL LL" ).append("\n"); 
		query.append("					 			WHERE  1=1" ).append("\n"); 
		query.append("					  			 AND CASE (" ).append("\n"); 
		query.append("							         SELECT  OFC_LVL" ).append("\n"); 
		query.append("								     FROM (" ).append("\n"); 
		query.append("									   SELECT  L.OFC_LVL" ).append("\n"); 
		query.append("									   FROM    COA_OFC_LVL L" ).append("\n"); 
		query.append("									   WHERE   L.OFC_N3RD_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("									   AND     L.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("									   AND     L.OFC_CD = @[bind_ofc_cd]    /* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("									   ORDER BY L.OFC_APLY_TO_YRMON  DESC" ).append("\n"); 
		query.append("									  )" ).append("\n"); 
		query.append("									   WHERE ROWNUM  = 1" ).append("\n"); 
		query.append("									  )" ).append("\n"); 
		query.append("									   WHEN '1' THEN 'XXXXX'" ).append("\n"); 
		query.append("									   WHEN '2' THEN LL.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("									   WHEN '3' THEN LL.OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("									   WHEN '4' THEN LL.OFC_CD" ).append("\n"); 
		query.append("									   WHEN '5' THEN LL.OFC_CD" ).append("\n"); 
		query.append("									   WHEN '6' THEN LL.OFC_CD" ).append("\n"); 
		query.append("									   WHEN '7' THEN LL.OFC_CD" ).append("\n"); 
		query.append("									   WHEN '9' THEN 'XXXXX'" ).append("\n"); 
		query.append("									   ELSE          'XXXXX'" ).append("\n"); 
		query.append("								 END = @[bind_ofc_cd]    /* LOGIN-OFFICE CODE BINDING */" ).append("\n"); 
		query.append("					  AND LL.OFC_N5TH_LVL_CD IS NOT NULL" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${f_sub_ofc_cd} != '')" ).append("\n"); 
		query.append("		AND	YY.SUB_OFC_CD = @[f_sub_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		) B" ).append("\n"); 
		query.append("   		WHERE 1=1" ).append("\n"); 
		query.append("		AND M.EXE_YRMON(+) BETWEEN REPLACE(@[gl_mon_from], '-') AND REPLACE(@[gl_mon_to], '-')" ).append("\n"); 
		query.append("        AND F.BSE_YR = SUBSTR(@[gl_mon_from],1,4) -1" ).append("\n"); 
		query.append("        AND F.COA_COST_SRC_CD = M.COA_COST_SRC_CD(+)" ).append("\n"); 
		query.append("        AND F.CTRL_OFC_CD = decode(M.CTRL_OFC_CD(+) ,'PUSBS','PUSSC','PUSBO','PUSSC','SKGBA', 'PIRBA', M.CTRL_OFC_CD(+) )" ).append("\n"); 
		query.append("        AND F.CTRL_OFC_CD = B.SUB_OFC_CD" ).append("\n"); 
		query.append("        AND M.OTR_CRR_FLG(+)  = 'N'" ).append("\n"); 
		query.append("   GROUP BY F.BSE_YR, B.RHQ_CD, F.CTRL_OFC_CD ,F.COA_COST_SRC_CD, F.TTL_USD_AMT ,F.MON_BUD_USD_AMT " ).append("\n"); 
		query.append(" )T," ).append("\n"); 
		query.append("  (SELECT DISTINCT DECODE(Y.MN_COST_TP_CD, 'TM', 'Terminal', 'TR', 'Transport', 'MT', 'Mty Reposition ', 'CH', 'Chassis ', 'ETC' ) MN_COST_TP_NM" ).append("\n"); 
		query.append("		        ,Y.MN_COST_TP_CD COST_MN_TP" ).append("\n"); 
		query.append("            ,CASE WHEN Y.SUB_COST_TP_NM like 'Full CNTR Transportation%' THEN" ).append("\n"); 
		query.append("                      'Full CNTR Transportation' " ).append("\n"); 
		query.append("                  ELSE  Y.SUB_COST_TP_NM" ).append("\n"); 
		query.append("             END SUB_COST_TP_NM      " ).append("\n"); 
		query.append("		        ,X.COA_COST_SRC_CD, X.ACCT_CD, X.SUB_COST_TP_CD" ).append("\n"); 
		query.append("		        ,X.LGS_COST_FULL_NM COST_DESC" ).append("\n"); 
		query.append("                ,X.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("    FROM   LEA_LGS_COST X, LEA_SUB_COST_TP Y" ).append("\n"); 
		query.append("    WHERE  X.SUB_COST_TP_CD = Y.SUB_COST_TP_CD" ).append("\n"); 
		query.append("     AND   X.DELT_FLG = 'N'			 " ).append("\n"); 
		query.append("     AND   Y.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   )C" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append(" AND	T.COA_COST_SRC_CD = C.COA_COST_SRC_CD" ).append("\n"); 
		query.append(" AND (1=2" ).append("\n"); 
		query.append(" #if (${f_cost_type_f} == '1')" ).append("\n"); 
		query.append("     OR C.COST_MN_TP IN ('TR', 'TM')" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" #if (${f_cost_type_m} == '1')" ).append("\n"); 
		query.append("     OR C.COST_MN_TP = 'MT'" ).append("\n"); 
		query.append(" #end" ).append("\n"); 
		query.append(" )" ).append("\n"); 
		query.append("#if(${f_report} == '1') " ).append("\n"); 
		query.append(" GROUP BY T.RHQ_CD," ).append("\n"); 
		query.append("        C.COST_MN_TP," ).append("\n"); 
		query.append("        C.MN_COST_TP_NM," ).append("\n"); 
		query.append("        C.SUB_COST_TP_NM," ).append("\n"); 
		query.append("        T.COA_COST_SRC_CD," ).append("\n"); 
		query.append("        C.COST_DESC," ).append("\n"); 
		query.append("        C.COST_SRC_SYS_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        (SUM(MON_BUD) OVER(PARTITION BY RHQ_CD)) DESC," ).append("\n"); 
		query.append("        (SUM(MON_BUD) OVER(PARTITION BY RHQ_CD, COST_SRC_SYS_CD)) DESC ," ).append("\n"); 
		query.append("        (SUM(MON_BUD) OVER(PARTITION BY RHQ_CD, COST_SRC_SYS_CD, SUB_COST_TP_NM)) DESC ," ).append("\n"); 
		query.append("        (SUM(MON_BUD) OVER(PARTITION BY RHQ_CD, COST_SRC_SYS_CD, SUB_COST_TP_NM, COA_COST_SRC_CD)) DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("        (SUM(MON_BUD) OVER(PARTITION BY CTRL_OFC_CD)) DESC," ).append("\n"); 
		query.append("        (SUM(MON_BUD) OVER(PARTITION BY CTRL_OFC_CD, COST_SRC_SYS_CD)) DESC ," ).append("\n"); 
		query.append("        (SUM(MON_BUD) OVER(PARTITION BY CTRL_OFC_CD, COST_SRC_SYS_CD, SUB_COST_TP_NM)) DESC ," ).append("\n"); 
		query.append("        (SUM(MON_BUD) OVER(PARTITION BY CTRL_OFC_CD, COST_SRC_SYS_CD, SUB_COST_TP_NM, COA_COST_SRC_CD)) DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}