/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultExecuteMonthListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.26
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2011.05.26 이정수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jeong Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultExecuteMonthListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수행월결 결산 결과 조회
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultExecuteMonthListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_exe_yrmon_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultExecuteMonthListRSQL").append("\n"); 
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
		query.append("#if ( ${frm_retrieveDiv} == '0' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	B.REV_YRMON" ).append("\n"); 
		query.append("		,B.EXE_YRMON" ).append("\n"); 
		query.append("		,D.MN_COST_TP_CD" ).append("\n"); 
		query.append("		,D.SUB_COST_TP_CD" ).append("\n"); 
		query.append("		,D.SUB_COST_TP_NM" ).append("\n"); 
		query.append("		,SUM(B.ESTM_COST_AMT)      ESTM_COST_AMT" ).append("\n"); 
		query.append("		,SUM(B.PRE_ACT_COST_AMT)   PRE_ACT_COST_AMT" ).append("\n"); 
		query.append("		,SUM(B.PST_ACT_COST_AMT)   PST_ACT_COST_AMT" ).append("\n"); 
		query.append("		,(SUM(B.PST_ACT_COST_AMT)-SUM(B.PRE_ACT_COST_AMT)) DIFF_ACT_COST_AMT" ).append("\n"); 
		query.append("		,DECODE(SUM(B.ESTM_COST_AMT),0,0,(ABS(SUM(B.PST_ACT_COST_AMT)/SUM(B.ESTM_COST_AMT))*100)) ACT_COST_RATIO" ).append("\n"); 
		query.append("		,SUM(B.ACCL_COST_AMT)      ACCL_COST_AMT" ).append("\n"); 
		query.append("		,(SUM(B.PST_ACT_COST_AMT)+SUM(B.ACCL_COST_AMT)) CONFIRMED_COST_AMT" ).append("\n"); 
		query.append("		,(SUM(B.PST_ACT_COST_AMT)+SUM(B.ACCL_COST_AMT)-SUM(B.ESTM_COST_AMT)) DIFF_COST_AMT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	DISTINCT SUB_COST_TP_CD SUB_COST_TP_CD, ACCT_CD ACCT_CD" ).append("\n"); 
		query.append("		FROM	LEA_LGS_COST" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT	DISTINCT 'TMOC' SUB_COST_TP_CD, OTR_CRR_ACCT_CD ACCT_CD" ).append("\n"); 
		query.append("		FROM	LEA_LGS_COST   --Terminal Handling - Other Carrier" ).append("\n"); 
		query.append("		WHERE	OTR_CRR_ACCT_CD IS NOT NULL " ).append("\n"); 
		query.append("		)	A" ).append("\n"); 
		query.append("		,LEA_ACCT_COST_AMT	B" ).append("\n"); 
		query.append("		,LEA_SUB_COST_TP	D" ).append("\n"); 
		query.append("WHERE	A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND		A.SUB_COST_TP_CD = D.SUB_COST_TP_CD " ).append("\n"); 
		query.append("#if ( ${f_cost_type_v} == '1' )" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD IN ('TRDC','TMDC')											----- volume" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${f_cost_type_f} == '1' && ${f_cost_type_m} == '1' && ${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('TR', 'TM', 'MT', 'CH')									----- full, empty, chassis" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD NOT IN ('TRDC','TMDC')" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} == '1' && ${f_cost_type_m} == '1' && ${f_cost_type_c} != '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('TR', 'TM', 'MT')										----- full, empty" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD NOT IN ('TRDC','TMDC')	" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} == '1' && ${f_cost_type_m} != '1' && ${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('TR', 'TM', 'CH')										----- full, chassis" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD NOT IN ('TRDC','TMDC')	" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} != '1' && ${f_cost_type_m} == '1' && ${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('MT', 'CH')												----- empty, chassis" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} == '1' && ${f_cost_type_m} != '1' && ${f_cost_type_c} != '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('TR', 'TM')												----- full" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD NOT IN ('TRDC','TMDC')" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} != '1' && ${f_cost_type_m} == '1' && ${f_cost_type_c} != '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('MT')													----- empty" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} != '1' && ${f_cost_type_m} != '1' && ${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('CH')													----- chassis" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   B.REV_YRMON    = REPLACE(@[frm_rev_yrmon],'-')" ).append("\n"); 
		query.append("AND   B.EXE_YRMON   >= REPLACE(@[frm_exe_yrmon_from],'-')" ).append("\n"); 
		query.append("AND   B.EXE_YRMON   <= REPLACE(@[frm_exe_yrmon_to],'-')" ).append("\n"); 
		query.append("GROUP BY B.REV_YRMON" ).append("\n"); 
		query.append(",B.EXE_YRMON" ).append("\n"); 
		query.append(",D.MN_COST_TP_CD" ).append("\n"); 
		query.append(",D.SUB_COST_TP_CD" ).append("\n"); 
		query.append(",D.SUB_COST_TP_NM" ).append("\n"); 
		query.append("ORDER BY B.REV_YRMON" ).append("\n"); 
		query.append(",B.EXE_YRMON" ).append("\n"); 
		query.append(",D.MN_COST_TP_CD " ).append("\n"); 
		query.append(",D.SUB_COST_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif ( ${frm_retrieveDiv} == '1' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT	B.REV_YRMON" ).append("\n"); 
		query.append("		,B.EXE_YRMON" ).append("\n"); 
		query.append("		,D.MN_COST_TP_CD" ).append("\n"); 
		query.append("		,DECODE(D.MN_COST_TP_CD,'TM','Terminal Cost Total',DECODE(D.MN_COST_TP_CD,'MT','MT Cost Total','Transportation Cost Total')) 		 SUB_COST_TP_NM        " ).append("\n"); 
		query.append("		,SUM(B.ESTM_COST_AMT)      ESTM_COST_AMT" ).append("\n"); 
		query.append("		,SUM(B.PRE_ACT_COST_AMT)   PRE_ACT_COST_AMT" ).append("\n"); 
		query.append("		,SUM(B.PST_ACT_COST_AMT)   PST_ACT_COST_AMT" ).append("\n"); 
		query.append("		,(SUM(B.PST_ACT_COST_AMT)-SUM(B.PRE_ACT_COST_AMT)) DIFF_ACT_COST_AMT" ).append("\n"); 
		query.append("		,DECODE(SUM(B.ESTM_COST_AMT),0,0,(ABS(SUM(B.PST_ACT_COST_AMT)/SUM(B.ESTM_COST_AMT))*100)) ACT_COST_RATIO" ).append("\n"); 
		query.append("		,SUM(B.ACCL_COST_AMT)      ACCL_COST_AMT" ).append("\n"); 
		query.append("		,(SUM(B.PST_ACT_COST_AMT)+SUM(B.ACCL_COST_AMT)) CONFIRMED_COST_AMT" ).append("\n"); 
		query.append("		,(SUM(B.PST_ACT_COST_AMT)+SUM(B.ACCL_COST_AMT)-SUM(B.ESTM_COST_AMT)) DIFF_COST_AMT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	DISTINCT SUB_COST_TP_CD SUB_COST_TP_CD, ACCT_CD ACCT_CD" ).append("\n"); 
		query.append("		FROM	LEA_LGS_COST" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		SELECT	DISTINCT 'TMOC' SUB_COST_TP_CD, OTR_CRR_ACCT_CD ACCT_CD" ).append("\n"); 
		query.append("		FROM	LEA_LGS_COST   --Terminal Handling - Other Carrier" ).append("\n"); 
		query.append("		WHERE	OTR_CRR_ACCT_CD IS NOT NULL " ).append("\n"); 
		query.append("		)	A" ).append("\n"); 
		query.append("		,LEA_ACCT_COST_AMT	B" ).append("\n"); 
		query.append("		,LEA_SUB_COST_TP	D" ).append("\n"); 
		query.append("WHERE	A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND		A.SUB_COST_TP_CD = D.SUB_COST_TP_CD " ).append("\n"); 
		query.append("#if ( ${f_cost_type_v} == '1' )" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD IN ('TRDC','TMDC')											----- volume" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	#if (${f_cost_type_f} == '1' && ${f_cost_type_m} == '1' && ${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('TR', 'TM', 'MT', 'CH')									----- full, empty, chassis" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD NOT IN ('TRDC','TMDC')" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} == '1' && ${f_cost_type_m} == '1' && ${f_cost_type_c} != '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('TR', 'TM', 'MT')										----- full, empty" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD NOT IN ('TRDC','TMDC')	" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} == '1' && ${f_cost_type_m} != '1' && ${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('TR', 'TM', 'CH')										----- full, chassis" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD NOT IN ('TRDC','TMDC')	" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} != '1' && ${f_cost_type_m} == '1' && ${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('MT', 'CH')												----- empty, chassis" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} == '1' && ${f_cost_type_m} != '1' && ${f_cost_type_c} != '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('TR', 'TM')												----- full" ).append("\n"); 
		query.append("	AND	D.SUB_COST_TP_CD NOT IN ('TRDC','TMDC')" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} != '1' && ${f_cost_type_m} == '1' && ${f_cost_type_c} != '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('MT')													----- empty" ).append("\n"); 
		query.append("	#elseif (${f_cost_type_f} != '1' && ${f_cost_type_m} != '1' && ${f_cost_type_c} == '1')" ).append("\n"); 
		query.append("	AND	D.MN_COST_TP_CD IN ('CH')													----- chassis" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND   B.REV_YRMON    = REPLACE(@[frm_rev_yrmon],'-')" ).append("\n"); 
		query.append("AND   B.EXE_YRMON   >= REPLACE(@[frm_exe_yrmon_from],'-')" ).append("\n"); 
		query.append("AND   B.EXE_YRMON   <= REPLACE(@[frm_exe_yrmon_to],'-')" ).append("\n"); 
		query.append("GROUP BY B.REV_YRMON" ).append("\n"); 
		query.append(",B.EXE_YRMON" ).append("\n"); 
		query.append(",D.MN_COST_TP_CD" ).append("\n"); 
		query.append("ORDER BY B.REV_YRMON" ).append("\n"); 
		query.append(",B.EXE_YRMON" ).append("\n"); 
		query.append(",D.MN_COST_TP_CD " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}