/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.19 
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

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exe.YearMonth 배치실행결과의 매뉴얼 Account code별 Actual cost를 계산해 놓은 Data를 가져온다.
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL(){
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
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL").append("\n"); 
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
		query.append("SELECT			B.EXE_YRMON" ).append("\n"); 
		query.append("			,	B.REV_YRMON" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_A,NULL,DECODE(A.ACT_COST_AMT_A,NULL,DECODE(A.ACCL_COST_AMT_A,NULL,'I')),'U') IBFLAG_A" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_A ,0) ESTM_COST_AMT_A" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_A  ,0) ACT_COST_AMT_A" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_A ,0) ACCL_COST_AMT_A" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_B,NULL,DECODE(A.ACT_COST_AMT_B,NULL,DECODE(A.ACCL_COST_AMT_B,NULL,'I')),'U') IBFLAG_B" ).append("\n"); 
		query.append("			,   NVL(A.ESTM_COST_AMT_B ,0) ESTM_COST_AMT_B" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_B  ,0) ACT_COST_AMT_B" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_B ,0) ACCL_COST_AMT_B" ).append("\n"); 
		query.append("				------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_AA,NULL,DECODE(A.ACT_COST_AMT_AA,NULL,DECODE(A.ACCL_COST_AMT_AA,NULL,'I')),'U')	IBFLAG_AA		--IBFLAG_512074" ).append("\n"); 
		query.append("			,	NVL		(A.ACT_COST_AMT_AA	, 0			)																ACT_COST_AMT_AA	--ACT_COST_AMT_512074" ).append("\n"); 
		query.append("			,   NVL		(A.ESTM_COST_AMT_AA , 0			) 																ESTM_COST_AMT_AA" ).append("\n"); 
		query.append("			,	NVL		(A.ACCL_COST_AMT_AA , 0			) 																ACCL_COST_AMT_AA" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_DD,NULL,DECODE(A.ACT_COST_AMT_DD,NULL,DECODE(A.ACCL_COST_AMT_DD,NULL,'I')),'U')	IBFLAG_DD		--IBFLAG_512362" ).append("\n"); 
		query.append("			,	NVL		(A.ACT_COST_AMT_DD	, 0			)																ACT_COST_AMT_DD	--ACT_COST_AMT_512362" ).append("\n"); 
		query.append("			,   NVL		(A.ESTM_COST_AMT_DD , 0			) 																ESTM_COST_AMT_DD" ).append("\n"); 
		query.append("			,	NVL		(A.ACCL_COST_AMT_DD , 0			) 																ACCL_COST_AMT_DD" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("				------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_C,NULL,DECODE(A.ACT_COST_AMT_C,NULL,DECODE(A.ACCL_COST_AMT_C,NULL,'I')),'U') IBFLAG_C" ).append("\n"); 
		query.append("			,   NVL(A.ESTM_COST_AMT_C ,0) ESTM_COST_AMT_C " ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_C  ,0) ACT_COST_AMT_C" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_C ,0) ACCL_COST_AMT_C" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_D,NULL,DECODE(A.ACT_COST_AMT_D,NULL,DECODE(A.ACCL_COST_AMT_D,NULL,'I')),'U') IBFLAG_D" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_D ,0) ESTM_COST_AMT_D" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_D  ,0) ACT_COST_AMT_D" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_D ,0) ACCL_COST_AMT_D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_F,NULL,DECODE(A.ACT_COST_AMT_F,NULL,DECODE(A.ACCL_COST_AMT_F,NULL,'I')),'U') IBFLAG_F" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_F ,0) ESTM_COST_AMT_F" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_F  ,0) ACT_COST_AMT_F" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_F ,0) ACCL_COST_AMT_F" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_G,NULL,DECODE(A.ACT_COST_AMT_G,NULL,DECODE(A.ACCL_COST_AMT_G,NULL,'I')),'U') IBFLAG_G" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_G ,0) ESTM_COST_AMT_G" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_G  ,0) ACT_COST_AMT_G" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_G ,0) ACCL_COST_AMT_G" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_H,NULL,DECODE(A.ACT_COST_AMT_H,NULL,DECODE(A.ACCL_COST_AMT_H,NULL,'I')),'U') IBFLAG_H" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_H ,0) ESTM_COST_AMT_H" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_H  ,0) ACT_COST_AMT_H" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_H ,0) ACCL_COST_AMT_H" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_I,NULL,DECODE(A.ACT_COST_AMT_I,NULL,DECODE(A.ACCL_COST_AMT_I,NULL,'I')),'U') IBFLAG_I" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_I ,0) ESTM_COST_AMT_I" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_I  ,0) ACT_COST_AMT_I" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_I ,0) ACCL_COST_AMT_I" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_J,NULL,DECODE(A.ACT_COST_AMT_J,NULL,DECODE(A.ACCL_COST_AMT_J,NULL,'I')),'U') IBFLAG_J" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_J ,0) ESTM_COST_AMT_J" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_J  ,0) ACT_COST_AMT_J" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_J ,0) ACCL_COST_AMT_J" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_K,NULL,DECODE(A.ACT_COST_AMT_K,NULL,DECODE(A.ACCL_COST_AMT_K,NULL,'I')),'U') IBFLAG_K" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_K ,0) ESTM_COST_AMT_K" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_K  ,0) ACT_COST_AMT_K" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_K ,0) ACCL_COST_AMT_K" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_L,NULL,DECODE(A.ACT_COST_AMT_L,NULL,DECODE(A.ACCL_COST_AMT_L,NULL,'I')),'U') IBFLAG_L" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_L ,0) ESTM_COST_AMT_L" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_L  ,0) ACT_COST_AMT_L" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_L ,0) ACCL_COST_AMT_L" ).append("\n"); 
		query.append("			,	DECODE(A.ESTM_COST_AMT_M,NULL,DECODE(A.ACT_COST_AMT_M,NULL,DECODE(A.ACCL_COST_AMT_M,NULL,'I')),'U') IBFLAG_M" ).append("\n"); 
		query.append("			,	NVL(A.ESTM_COST_AMT_M ,0) ESTM_COST_AMT_M" ).append("\n"); 
		query.append("			,	NVL(A.ACT_COST_AMT_M  ,0) ACT_COST_AMT_M" ).append("\n"); 
		query.append("			,	NVL(A.ACCL_COST_AMT_M ,0) ACCL_COST_AMT_M" ).append("\n"); 
		query.append("FROM 		(SELECT					EXE_YRMON" ).append("\n"); 
		query.append("								,	REV_YRMON" ).append("\n"); 
		query.append("                                    /* 512073 ESTM-ACT-ACCL : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512073', '512075')	THEN ESTM_COST_AMT 		END )	ESTM_COST_AMT_A" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512073', '512075') 	THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_A" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512073', '512075')	THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_A" ).append("\n"); 
		query.append("									" ).append("\n"); 
		query.append("									/* 512361 ESTM-ACT-ACCL */" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512361') 			THEN ESTM_COST_AMT 		END )   ESTM_COST_AMT_D" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512361') 			THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_D" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512361') 			THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                ---------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("                                    /* 512074 X-ACT-X : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512074') 			THEN ESTM_COST_AMT		END )   ESTM_COST_AMT_AA" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512074') 			THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_AA" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512074') 			THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_AA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512362 X-ACT-X */" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512362') 			THEN ESTM_COST_AMT 		END )   ESTM_COST_AMT_DD" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512362') 			THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_DD" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512362') 			THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_DD" ).append("\n"); 
		query.append("                                ---------------------------------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512019 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512019') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_B" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512019', '512029', '512039', '512069', '512119', '512229', '512429') 		THEN 0 					END	)   ESTM_COST_AMT_B" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512019', '512029', '512039', '512069', '512119', '512229', '512429') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_B" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512019', '512029', '512039', '512069', '512119', '512229', '512429') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512351 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512351') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_C" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512351') 		THEN 0 					END	)	ESTM_COST_AMT_C" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512351') 		THEN PRE_ACT_COST_AMT 	END	)	ACT_COST_AMT_C" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512351') 		THEN ACCL_COST_AMT 		END	)	ACCL_COST_AMT_C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512061 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */									" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512061') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_F" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512061', '512062', '512063', '512064', '512065', '512066') 		THEN 0 					END )   ESTM_COST_AMT_F" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512061', '512062', '512063', '512064', '512065', '512066') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_F" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512061', '512062', '512063', '512064', '512065', '512066') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_F" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512151 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512151') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_G" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512151', '512133', '512144', '512152', '512153', '512154', '512155') 		THEN 0 					END )   ESTM_COST_AMT_G" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512151', '512133', '512144', '512152', '512153', '512154', '512155') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_G" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512151', '512133', '512144', '512152', '512153', '512154', '512155') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_G" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512221 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512221') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_H" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512221', '512222') 		THEN 0 					END )   ESTM_COST_AMT_H" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512221', '512222') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_H" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512221', '512222') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_H" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512341 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512341') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_I" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512341', '512342', '512343', '512344', '512345', '512346', '512347') 		THEN 0 					END )   ESTM_COST_AMT_I" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512341', '512342', '512343', '512344', '512345', '512346', '512347') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_I" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512341', '512342', '512343', '512344', '512345', '512346', '512347') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_I" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512181 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512181') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_J" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512181') 		THEN 0 					END )   ESTM_COST_AMT_J" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512181') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_J" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512181') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_J" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512381 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512381') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_K" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512381') 		THEN 0 					END )   ESTM_COST_AMT_K" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512381') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_K" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512381') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_K" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512171 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512171') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_L" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512171', '512172') 		THEN 0 					END )   ESTM_COST_AMT_L" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512171', '512172') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_L" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512171', '512172') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_L" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("									/* 512331 ACTUAL ONLY, ESTM ZERO : 2011-04-26 commented by Jeong Sang-Ki */" ).append("\n"); 
		query.append("								--,   SUM( CASE WHEN REP_ACCT_CD IN ('512331') THEN ESTM_COST_AMT END )       ESTM_COST_AMT_M" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512331', '512332', '512333', '512334', '512335', '512336') 		THEN 0 					END )   ESTM_COST_AMT_M" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512331', '512332', '512333', '512334', '512335', '512336') 		THEN PRE_ACT_COST_AMT 	END )   ACT_COST_AMT_M" ).append("\n"); 
		query.append("								,   SUM( CASE WHEN ACCT_CD IN ('512331', '512332', '512333', '512334', '512335', '512336') 		THEN ACCL_COST_AMT 		END )   ACCL_COST_AMT_M" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				FROM			(SELECT		A.EXE_YRMON" ).append("\n"); 
		query.append("													,	A.REV_YRMON" ).append("\n"); 
		query.append("													,	B.REP_ACCT_CD    	REP_ACCT_CD" ).append("\n"); 
		query.append("													,	B.ACCT_CD" ).append("\n"); 
		query.append("													,	A.ESTM_COST_AMT" ).append("\n"); 
		query.append("													,	A.PRE_ACT_COST_AMT" ).append("\n"); 
		query.append("													,	A.ACCL_COST_AMT" ).append("\n"); 
		query.append("									FROM				LEA_ACCT_COST_AMT 	A" ).append("\n"); 
		query.append("													,	(SELECT 		DISTINCT(ACCT_CD)   			ACCT_CD" ).append("\n"); 
		query.append("																	,	REP_ACCT_CD" ).append("\n"); 
		query.append("																	,	ACCL_AUTO_CD" ).append("\n"); 
		query.append("														FROM 			LEA_LGS_COST" ).append("\n"); 
		query.append("														WHERE 			ACCL_AUTO_CD 					= 'M'" ).append("\n"); 
		query.append("																	OR  ACCT_CD               			IN ('512073','512075','512361')" ).append("\n"); 
		query.append("														UNION ALL" ).append("\n"); 
		query.append("														SELECT 			DISTINCT(OTR_CRR_ACCT_CD) 		ACCT_CD" ).append("\n"); 
		query.append("																	,	OTR_CRR_REP_ACCT_CD 			REP_ACCT_CD" ).append("\n"); 
		query.append("																	,	'M' 							ACCL_AUTO_CD" ).append("\n"); 
		query.append("														FROM 			LEA_LGS_COST" ).append("\n"); 
		query.append("														WHERE 			ACCL_AUTO_CD 					IS NOT NULL" ).append("\n"); 
		query.append("														AND 			OTR_CRR_ACCT_CD 				IS NOT NULL" ).append("\n"); 
		query.append("														) B" ).append("\n"); 
		query.append("									WHERE   	A.ACCT_CD 				= B.ACCT_CD" ).append("\n"); 
		query.append("									AND     	A.EXE_YRMON  			= REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("									AND     	A.REV_YRMON 			>= REPLACE(@[frm_rev_yrmon_from],'-')" ).append("\n"); 
		query.append("									AND     	A.REV_YRMON 			<= REPLACE(@[frm_rev_yrmon_to],'-')" ).append("\n"); 
		query.append("									AND     	(A.ACCL_AUTO_CD 	    = 'M' OR A.ACCT_CD IN ('512073','512075','512361'))" ).append("\n"); 
		query.append("									--AND     A.ACCL_AUTO_CD = B.ACCL_AUTO_CD" ).append("\n"); 
		query.append("									AND     	B.ACCT_CD 			    IN (		'512073', '512074', '512075'" ).append("\n"); 
		query.append("																				,	'512361', '512362'" ).append("\n"); 
		query.append("																				,	'512061', '512062', '512063', '512064', '512065', '512066'" ).append("\n"); 
		query.append("																				,	'512151', '512133', '512144', '512152', '512153', '512154', '512155'" ).append("\n"); 
		query.append("																				,	'512221', '512222'" ).append("\n"); 
		query.append("																				,	'512341', '512342', '512343', '512344', '512345', '512346', '512347'" ).append("\n"); 
		query.append("																				,	'512171', '512172'" ).append("\n"); 
		query.append("																				,	'512331', '512332', '512333', '512334', '512335', '512336'" ).append("\n"); 
		query.append("																				,	'512351'" ).append("\n"); 
		query.append("																				,	'512019', '512029', '512039', '512069', '512119', '512229', '512429'" ).append("\n"); 
		query.append("																				,	'512181'" ).append("\n"); 
		query.append("																				,	'512381'" ).append("\n"); 
		query.append("																			)" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("				GROUP BY 	EXE_YRMON" ).append("\n"); 
		query.append("						,	REV_YRMON" ).append("\n"); 
		query.append("				)A" ).append("\n"); 
		query.append("			,	(SELECT  EXE_YRMON, REV_YRMON" ).append("\n"); 
		query.append("     			FROM	(SELECT  	REPLACE(@[frm_exe_yrmon]		,'-') EXE_YRMON" ).append("\n"); 
		query.append("								,	REPLACE(@[frm_rev_yrmon_from]	,'-') REV_YRMON" ).append("\n"); 
		query.append("         				FROM		DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			#foreach( ${eachrevyrmon} in ${arrrevmonthorder})" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				SELECT	REPLACE(@[frm_exe_yrmon]		,'-') EXE_YRMON" ).append("\n"); 
		query.append("					,	TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[frm_rev_yrmon_from],'-'),'YYYYMM'),${eachrevyrmon}),'YYYYMM') REV_YRMON" ).append("\n"); 
		query.append("				FROM	DUAL" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		) B" ).append("\n"); 
		query.append("	WHERE 		A.EXE_YRMON(+) 		= B.EXE_YRMON" ).append("\n"); 
		query.append("	AND   		A.REV_YRMON(+) 		= B.REV_YRMON" ).append("\n"); 
		query.append("	ORDER BY 	B.EXE_YRMON" ).append("\n"); 
		query.append("			,	B.REV_YRMON" ).append("\n"); 

	}
}