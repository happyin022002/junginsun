/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultManualInputListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.27
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2010.01.27 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeon Jae Hong
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
		query.append("Path : com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
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
		query.append("SELECT	B.EXE_YRMON" ).append("\n"); 
		query.append(",	B.REV_YRMON" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_A,NULL,DECODE(A.ACT_COST_AMT_A,NULL,DECODE(A.ACCL_COST_AMT_A,NULL,'I')),'U') IBFLAG_A" ).append("\n"); 
		query.append(",	NVL(A.ESTM_COST_AMT_A ,0) ESTM_COST_AMT_A" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_A  ,0) ACT_COST_AMT_A" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_A ,0) ACCL_COST_AMT_A" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_B,NULL,DECODE(A.ACT_COST_AMT_B,NULL,DECODE(A.ACCL_COST_AMT_B,NULL,'I')),'U') IBFLAG_B" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_B,NULL, NVL(A.ACT_COST_AMT_B,0), 0 , NVL(A.ACT_COST_AMT_B,0), A.ESTM_COST_AMT_B) ESTM_COST_AMT_B" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_B  ,0) ACT_COST_AMT_B" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_B ,0) ACCL_COST_AMT_B" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_C,NULL,DECODE(A.ACT_COST_AMT_C,NULL,DECODE(A.ACCL_COST_AMT_C,NULL,'I')),'U') IBFLAG_C" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_C,NULL,NVL(A.ACT_COST_AMT_C,0), 0 ,NVL(A.ACT_COST_AMT_C,0),A.ESTM_COST_AMT_C) ESTM_COST_AMT_C" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_C  ,0) ACT_COST_AMT_C" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_C ,0) ACCL_COST_AMT_C" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_D,NULL,DECODE(A.ACT_COST_AMT_D,NULL,DECODE(A.ACCL_COST_AMT_D,NULL,'I')),'U') IBFLAG_D" ).append("\n"); 
		query.append(",	NVL(A.ESTM_COST_AMT_D ,0) ESTM_COST_AMT_D" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_D  ,0) ACT_COST_AMT_D" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_D ,0) ACCL_COST_AMT_D" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_F,NULL,DECODE(A.ACT_COST_AMT_F,NULL,DECODE(A.ACCL_COST_AMT_F,NULL,'I')),'U') IBFLAG_F" ).append("\n"); 
		query.append(",	NVL(A.ESTM_COST_AMT_F ,0) ESTM_COST_AMT_F" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_F  ,0) ACT_COST_AMT_F" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_F ,0) ACCL_COST_AMT_F" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_G,NULL,DECODE(A.ACT_COST_AMT_G,NULL,DECODE(A.ACCL_COST_AMT_G,NULL,'I')),'U') IBFLAG_G" ).append("\n"); 
		query.append(",	NVL(A.ESTM_COST_AMT_G ,0) ESTM_COST_AMT_G" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_G  ,0) ACT_COST_AMT_G" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_G ,0) ACCL_COST_AMT_G" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_H,NULL,DECODE(A.ACT_COST_AMT_H,NULL,DECODE(A.ACCL_COST_AMT_H,NULL,'I')),'U') IBFLAG_H" ).append("\n"); 
		query.append(",	NVL(A.ESTM_COST_AMT_H ,0) ESTM_COST_AMT_H" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_H  ,0) ACT_COST_AMT_H" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_H ,0) ACCL_COST_AMT_H" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_I,NULL,DECODE(A.ACT_COST_AMT_I,NULL,DECODE(A.ACCL_COST_AMT_I,NULL,'I')),'U') IBFLAG_I" ).append("\n"); 
		query.append(",	NVL(A.ESTM_COST_AMT_I ,0) ESTM_COST_AMT_I" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_I  ,0) ACT_COST_AMT_I" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_I ,0) ACCL_COST_AMT_I" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_J,NULL,DECODE(A.ACT_COST_AMT_J,NULL,DECODE(A.ACCL_COST_AMT_J,NULL,'I')),'U') IBFLAG_J" ).append("\n"); 
		query.append(",	NVL(A.ESTM_COST_AMT_J ,0) ESTM_COST_AMT_J" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_J  ,0) ACT_COST_AMT_J" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_J ,0) ACCL_COST_AMT_J" ).append("\n"); 
		query.append(",	DECODE(A.ESTM_COST_AMT_K,NULL,DECODE(A.ACT_COST_AMT_K,NULL,DECODE(A.ACCL_COST_AMT_K,NULL,'I')),'U') IBFLAG_K" ).append("\n"); 
		query.append(",	NVL(A.ESTM_COST_AMT_K ,0) ESTM_COST_AMT_K" ).append("\n"); 
		query.append(",	NVL(A.ACT_COST_AMT_K  ,0) ACT_COST_AMT_K" ).append("\n"); 
		query.append(",	NVL(A.ACCL_COST_AMT_K ,0) ACCL_COST_AMT_K" ).append("\n"); 
		query.append("FROM 		(SELECT		EXE_YRMON" ).append("\n"); 
		query.append(",	REV_YRMON" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512073',ESTM_COST_AMT))       ESTM_COST_AMT_A" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512073',PRE_ACT_COST_AMT))    ACT_COST_AMT_A" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512073',ACCL_COST_AMT))       ACCL_COST_AMT_A" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512019',ESTM_COST_AMT))       ESTM_COST_AMT_B" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512019',PRE_ACT_COST_AMT))    ACT_COST_AMT_B" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512019',ACCL_COST_AMT))       ACCL_COST_AMT_B" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512351',ESTM_COST_AMT))       ESTM_COST_AMT_C" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512351',PRE_ACT_COST_AMT))    ACT_COST_AMT_C" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512351',ACCL_COST_AMT))       ACCL_COST_AMT_C" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512361',ESTM_COST_AMT))       ESTM_COST_AMT_D" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512361',PRE_ACT_COST_AMT))    ACT_COST_AMT_D" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512361',ACCL_COST_AMT))       ACCL_COST_AMT_D" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512061',ESTM_COST_AMT))       ESTM_COST_AMT_F" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512061',PRE_ACT_COST_AMT))    ACT_COST_AMT_F" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512061',ACCL_COST_AMT))       ACCL_COST_AMT_F" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512151',ESTM_COST_AMT))       ESTM_COST_AMT_G" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512151',PRE_ACT_COST_AMT))    ACT_COST_AMT_G" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512151',ACCL_COST_AMT))       ACCL_COST_AMT_G" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512221',ESTM_COST_AMT))       ESTM_COST_AMT_H" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512221',PRE_ACT_COST_AMT))    ACT_COST_AMT_H" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512221',ACCL_COST_AMT))       ACCL_COST_AMT_H" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512341',ESTM_COST_AMT))       ESTM_COST_AMT_I" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512341',PRE_ACT_COST_AMT))    ACT_COST_AMT_I" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512341',ACCL_COST_AMT))       ACCL_COST_AMT_I" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512181',ESTM_COST_AMT))       ESTM_COST_AMT_J" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512181',PRE_ACT_COST_AMT))    ACT_COST_AMT_J" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512181',ACCL_COST_AMT))       ACCL_COST_AMT_J" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512381',ESTM_COST_AMT))       ESTM_COST_AMT_K" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512381',PRE_ACT_COST_AMT))    ACT_COST_AMT_K" ).append("\n"); 
		query.append(",	SUM(DECODE(REP_ACCT_CD,'512381',ACCL_COST_AMT))       ACCL_COST_AMT_K" ).append("\n"); 
		query.append("FROM			(SELECT		A.EXE_YRMON" ).append("\n"); 
		query.append(",	A.REV_YRMON" ).append("\n"); 
		query.append(",	B.REP_ACCT_CD    REP_ACCT_CD" ).append("\n"); 
		query.append(",	B.ACCT_CD" ).append("\n"); 
		query.append(",	A.ESTM_COST_AMT" ).append("\n"); 
		query.append(",	A.PRE_ACT_COST_AMT" ).append("\n"); 
		query.append(",	A.ACCL_COST_AMT" ).append("\n"); 
		query.append("FROM			LEA_ACCT_COST_AMT 	A" ).append("\n"); 
		query.append(",	(SELECT 	DISTINCT(ACCT_CD)   		ACCT_CD" ).append("\n"); 
		query.append(",	REP_ACCT_CD" ).append("\n"); 
		query.append(",	ACCL_AUTO_CD" ).append("\n"); 
		query.append("FROM 			LEA_LGS_COST" ).append("\n"); 
		query.append("WHERE 		ACCL_AUTO_CD = 'M'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT(OTR_CRR_ACCT_CD) 	ACCT_CD" ).append("\n"); 
		query.append(",	OTR_CRR_REP_ACCT_CD 		REP_ACCT_CD" ).append("\n"); 
		query.append(",	'M' 										ACCL_AUTO_CD" ).append("\n"); 
		query.append("FROM 			LEA_LGS_COST" ).append("\n"); 
		query.append("WHERE 		ACCL_AUTO_CD IS NOT NULL" ).append("\n"); 
		query.append("AND 			OTR_CRR_ACCT_CD IS NOT NULL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE   	A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND     	A.EXE_YRMON  = REPLACE(@[frm_exe_yrmon],'-')" ).append("\n"); 
		query.append("AND     	A.REV_YRMON >= REPLACE(@[frm_rev_yrmon_from],'-')" ).append("\n"); 
		query.append("AND     	A.REV_YRMON <= REPLACE(@[frm_rev_yrmon_to],'-')" ).append("\n"); 
		query.append("AND     	A.ACCL_AUTO_CD = 'M'" ).append("\n"); 
		query.append("--AND     A.ACCL_AUTO_CD = B.ACCL_AUTO_CD" ).append("\n"); 
		query.append("AND     	B.REP_ACCT_CD IN ('512073','512351','512361', '512019', '512061','512151','512221','512341','512181','512381')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY 	EXE_YRMON" ).append("\n"); 
		query.append(",	REV_YRMON" ).append("\n"); 
		query.append(")A" ).append("\n"); 
		query.append(",	(SELECT  EXE_YRMON, REV_YRMON" ).append("\n"); 
		query.append("FROM	(SELECT  	REPLACE(@[frm_exe_yrmon]		,'-') EXE_YRMON" ).append("\n"); 
		query.append(",	REPLACE(@[frm_rev_yrmon_from]	,'-') REV_YRMON" ).append("\n"); 
		query.append("FROM		DUAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach( ${eachrevyrmon} in ${arrrevmonthorder})" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT	REPLACE(@[frm_exe_yrmon]		,'-') EXE_YRMON" ).append("\n"); 
		query.append(",	TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[frm_rev_yrmon_from],'-'),'YYYYMM'),${eachrevyrmon}),'YYYYMM') REV_YRMON" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE 		A.EXE_YRMON(+) 		= B.EXE_YRMON" ).append("\n"); 
		query.append("AND   		A.REV_YRMON(+) 		= B.REV_YRMON" ).append("\n"); 
		query.append("ORDER BY 	B.EXE_YRMON" ).append("\n"); 
		query.append(",	B.REV_YRMON" ).append("\n"); 

	}
}