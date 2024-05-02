/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.27 
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

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 결산 결과에 대해 Account code(계정코드) 별로 조회한다.
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultAccountListRSQL").append("\n"); 
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
		query.append("SELECT  B.EXE_YRMON" ).append("\n"); 
		query.append("    ,	B.REV_YRMON" ).append("\n"); 
		query.append("    ,	A.ACCL_AUTO_CD" ).append("\n"); 
		query.append("    ,	A.ACCT_CD" ).append("\n"); 
		query.append("    ,	A.ACCT_CD_NM" ).append("\n"); 
		query.append("    ,	NVL(B.ESTM_COST_AMT,0) 			ESTM_COST_AMT" ).append("\n"); 
		query.append("    ,	NVL(B.PRE_ACT_COST_AMT,0) 		PRE_ACT_COST_AMT" ).append("\n"); 
		query.append("    --,	NVL(B.PST_ACT_COST_AMT,0) 		PST_ACT_COST_AMT" ).append("\n"); 
		query.append("    ,	CASE  WHEN B.ACCT_CD IN ('512181','512381') 									THEN B.PRE_ACT_COST_AMT" ).append("\n"); 
		query.append("	 		  WHEN B.ACCT_CD IN ('512073','512075','512361') AND B.REV_YRMON < '201201' THEN B.PRE_ACT_COST_AMT" ).append("\n"); 
		query.append("	          ELSE B.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("        END   PST_ACT_COST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --,	CASE  WHEN A.ACCL_AUTO_CD = 'A' THEN (NVL(B.PST_ACT_COST_AMT,0) - NVL(B.PRE_ACT_COST_AMT,0))" ).append("\n"); 
		query.append("    --          ELSE  0" ).append("\n"); 
		query.append("    --    END   DIFF_ACT_COST_AMT" ).append("\n"); 
		query.append("    ,	CASE  WHEN B.ACCT_CD IN ('512181','512381') 									THEN 0" ).append("\n"); 
		query.append("	 		  WHEN B.ACCT_CD IN ('512073','512075','512361') AND B.REV_YRMON < '201201' THEN 0" ).append("\n"); 
		query.append("			  WHEN A.ACCL_AUTO_CD = 'A' THEN (NVL(B.PST_ACT_COST_AMT,0) - NVL(B.PRE_ACT_COST_AMT,0))" ).append("\n"); 
		query.append("              ELSE  0" ).append("\n"); 
		query.append("        END   DIFF_ACT_COST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --,	CASE  WHEN A.ACCL_AUTO_CD = 'A' THEN DECODE(NVL(B.ESTM_COST_AMT,0),0,0,(NVL(B.PST_ACT_COST_AMT,0)/NVL(B.ESTM_COST_AMT,0)*100))" ).append("\n"); 
		query.append("    --          ELSE  0" ).append("\n"); 
		query.append("    --    END ACT_COST_RATIO" ).append("\n"); 
		query.append("    ,	CASE  WHEN B.ACCT_CD IN ('512181','512381') 									THEN DECODE(NVL(B.ESTM_COST_AMT,0),0,0,(NVL(B.PRE_ACT_COST_AMT,0)/NVL(B.ESTM_COST_AMT,0)*100))" ).append("\n"); 
		query.append("	 		  WHEN B.ACCT_CD IN ('512073','512075','512361') AND B.REV_YRMON < '201201' THEN DECODE(NVL(B.ESTM_COST_AMT,0),0,0,(NVL(B.PRE_ACT_COST_AMT,0)/NVL(B.ESTM_COST_AMT,0)*100))" ).append("\n"); 
		query.append("			  WHEN A.ACCL_AUTO_CD = 'A' THEN DECODE(NVL(B.ESTM_COST_AMT,0),0,0,(NVL(B.PST_ACT_COST_AMT,0)/NVL(B.ESTM_COST_AMT,0)*100))" ).append("\n"); 
		query.append("              ELSE  0" ).append("\n"); 
		query.append("        END ACT_COST_RATIO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --,	CASE  WHEN A.ACCL_AUTO_CD = 'A' THEN (NVL(B.PST_ACT_COST_AMT,0)+NVL(B.ACCL_COST_AMT,0))" ).append("\n"); 
		query.append("    --          ELSE  (NVL(B.PRE_ACT_COST_AMT,0)+NVL(B.ACCL_COST_AMT,0))" ).append("\n"); 
		query.append("    --    END  						    CONFIRMED_COST_AMT" ).append("\n"); 
		query.append("    ,	CASE  WHEN B.ACCT_CD IN ('512181','512381') 									THEN (NVL(B.PRE_ACT_COST_AMT,0)+NVL(B.ACCL_COST_AMT,0))" ).append("\n"); 
		query.append("	 		  WHEN B.ACCT_CD IN ('512073','512075','512361') AND B.REV_YRMON < '201201' THEN (NVL(B.PRE_ACT_COST_AMT,0)+NVL(B.ACCL_COST_AMT,0))" ).append("\n"); 
		query.append("			  WHEN A.ACCL_AUTO_CD = 'A' 												THEN (NVL(B.PST_ACT_COST_AMT,0)+NVL(B.ACCL_COST_AMT,0))" ).append("\n"); 
		query.append("              ELSE  (NVL(B.PRE_ACT_COST_AMT,0)+NVL(B.ACCL_COST_AMT,0))" ).append("\n"); 
		query.append("        END  						    CONFIRMED_COST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    --,	(NVL(B.PST_ACT_COST_AMT,0) + NVL(B.ACCL_COST_AMT,0)-NVL(B.ESTM_COST_AMT,0)) 	DIFF_COST_AMT" ).append("\n"); 
		query.append("    ,	CASE  WHEN B.ACCT_CD IN ('512181','512381') 									THEN (NVL(B.PRE_ACT_COST_AMT,0) + NVL(B.ACCL_COST_AMT,0)-NVL(B.ESTM_COST_AMT,0)) 	" ).append("\n"); 
		query.append("	 		  WHEN B.ACCT_CD IN ('512073','512075','512361') AND B.REV_YRMON < '201201' THEN (NVL(B.PRE_ACT_COST_AMT,0) + NVL(B.ACCL_COST_AMT,0)-NVL(B.ESTM_COST_AMT,0)) 	" ).append("\n"); 
		query.append("		      ELSE (NVL(B.PST_ACT_COST_AMT,0) + NVL(B.ACCL_COST_AMT,0)-NVL(B.ESTM_COST_AMT,0)) 	" ).append("\n"); 
		query.append("	    END   DIFF_COST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,	NVL(B.ACCL_COST_AMT,0)  		ACCL_COST_AMT" ).append("\n"); 
		query.append("    ,	C.MNL_INP_FLG" ).append("\n"); 
		query.append("    ,	C.ERP_IF_FLG" ).append("\n"); 
		query.append("    ,	TO_CHAR(C.ERP_IF_DT,'YYYYMMDD')   ERP_IF_DT" ).append("\n"); 
		query.append("FROM    (	SELECT 	DISTINCT(ACCT_CD)   ACCT_CD" ).append("\n"); 
		query.append("                ,	ACCT_NM ACCT_CD_NM" ).append("\n"); 
		query.append("                ,	ACCL_AUTO_CD" ).append("\n"); 
		query.append("            FROM	LEA_LGS_COST" ).append("\n"); 
		query.append("            WHERE	ACCL_AUTO_CD IS NOT NULL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT 	DISTINCT(OTR_CRR_ACCT_CD) ACCT_CD" ).append("\n"); 
		query.append("                ,	OTR_CRR_ACCT_NM ACCT_CD_NM" ).append("\n"); 
		query.append("                ,   'M' ACCL_AUTO_CD" ).append("\n"); 
		query.append("            FROM	LEA_LGS_COST                                                         	" ).append("\n"); 
		query.append("            WHERE	ACCL_AUTO_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND 	OTR_CRR_ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("    ,	LEA_ACCT_COST_AMT B" ).append("\n"); 
		query.append("    ,	LEA_ACCL_COND_ITM C" ).append("\n"); 
		query.append("WHERE   A.ACCT_CD          			= B.ACCT_CD" ).append("\n"); 
		query.append("AND     A.ACCL_AUTO_CD     			= B.ACCL_AUTO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_acct_type_a} == '1' || ${f_acct_type_m} == '1' || ${f_acct_type_t} == '1') " ).append("\n"); 
		query.append("	AND    (             		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_acct_type_a} == '1' && ${f_acct_type_m} != '1' && ${f_acct_type_t} != '1')" ).append("\n"); 
		query.append("	A.ACCL_AUTO_CD     = 'A'  " ).append("\n"); 
		query.append("#elseif ( ${f_acct_type_a} != '1' && ${f_acct_type_m} == '1' && ${f_acct_type_t} != '1')" ).append("\n"); 
		query.append("    A.ACCL_AUTO_CD     = 'M' " ).append("\n"); 
		query.append("#elseif ( ${f_acct_type_a} != '1' && ${f_acct_type_m} != '1' && ${f_acct_type_t} == '1')" ).append("\n"); 
		query.append("    A.ACCL_AUTO_CD     = 'T'  " ).append("\n"); 
		query.append("#elseif ( ${f_acct_type_a} == '1' && ${f_acct_type_m} == '1' && ${f_acct_type_t} != '1')  		" ).append("\n"); 
		query.append("	A.ACCL_AUTO_CD     = 'A'  OR A.ACCL_AUTO_CD     = 'M' " ).append("\n"); 
		query.append("#elseif ( ${f_acct_type_a} == '1' && ${f_acct_type_m} != '1' && ${f_acct_type_t} == '1')  		" ).append("\n"); 
		query.append("	A.ACCL_AUTO_CD     = 'A'  OR A.ACCL_AUTO_CD     = 'T' " ).append("\n"); 
		query.append("#elseif ( ${f_acct_type_a} != '1' && ${f_acct_type_m} == '1' && ${f_acct_type_t} == '1')  		" ).append("\n"); 
		query.append("	A.ACCL_AUTO_CD     = 'M'  OR A.ACCL_AUTO_CD     = 'T'   " ).append("\n"); 
		query.append("#elseif ( ${f_acct_type_a} == '1' && ${f_acct_type_m} == '1' && ${f_acct_type_t} == '1')  		" ).append("\n"); 
		query.append("	A.ACCL_AUTO_CD    IN ( 'A','M','T')     		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_acct_type_a} == '1' || ${f_acct_type_m} == '1' || ${f_acct_type_t} == '1') " ).append("\n"); 
		query.append("	)            		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${f_acct_type_a} != '1' && ${f_acct_type_m} != '1' && ${f_acct_type_t} != '1') " ).append("\n"); 
		query.append("	AND    A.ACCL_AUTO_CD NOT IN ( 'A','M','T')        		" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     B.EXE_YRMON     = C.EXE_YRMON(+)" ).append("\n"); 
		query.append("AND     B.EXE_YRMON     = REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("AND     B.REV_YRMON     >= REPLACE(@[frm_rev_yrmon_from],'-')" ).append("\n"); 
		query.append("AND     B.REV_YRMON     <= REPLACE(@[frm_rev_yrmon_to],'-')" ).append("\n"); 
		query.append("ORDER BY 	B.EXE_YRMON" ).append("\n"); 
		query.append("		,	B.REV_YRMON" ).append("\n"); 
		query.append("		,	A.ACCL_AUTO_CD" ).append("\n"); 
		query.append("		,	A.ACCT_CD" ).append("\n"); 
		query.append("		,	A.ACCT_CD_NM" ).append("\n"); 

	}
}