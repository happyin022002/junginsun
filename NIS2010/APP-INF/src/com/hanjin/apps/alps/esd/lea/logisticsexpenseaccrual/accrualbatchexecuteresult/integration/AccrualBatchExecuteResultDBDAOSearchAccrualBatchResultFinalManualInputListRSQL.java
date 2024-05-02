/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultFinalManualInputListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.07.16 
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

public class AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultFinalManualInputListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccrualBatchResultFinalManualInputList 정보 조회
	  * </pre>
	  */
	public AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultFinalManualInputListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.integration").append("\n"); 
		query.append("FileName : AccrualBatchExecuteResultDBDAOSearchAccrualBatchResultFinalManualInputListRSQL").append("\n"); 
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
		query.append("SELECT     S.REV_YRMON" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512073','512075') THEN S.ESTM_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS ESTM_COST_AMT_512073" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512073','512075') THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512073" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512073','512075') THEN S.ADJ_ACCL_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS ADJ_ACCL_COST_AMT_512073" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512361' THEN S.ESTM_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS ESTM_COST_AMT_512361" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512361' THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512361" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512361' THEN S.ADJ_ACCL_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS ADJ_ACCL_COST_AMT_512361" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512074' THEN S.ESTM_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS ESTM_COST_AMT_512074" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512074' THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512074                      " ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512074' THEN S.ADJ_ACCL_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS ADJ_ACCL_COST_AMT_512074" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512362' THEN S.ESTM_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS ESTM_COST_AMT_512362" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512362' THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512362" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512362' THEN S.ADJ_ACCL_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS ADJ_ACCL_COST_AMT_512362" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512061', '512062', '512063', '512064', '512065', '512066') THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512061" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512151', '512133', '512144', '512152', '512153', '512154', '512155') THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512151" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512221', '512222') THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512221" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512341', '512342', '512343', '512344', '512345', '512346', '512347') THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512341" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512171', '512172') THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512171" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512331', '512332', '512333', '512334', '512335', '512336') THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512331" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512351' THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512351" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD IN ('512019', '512029', '512039', '512069', '512119', '512229', '512429') THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512019" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512181' THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512181" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("        ,  SUM(CASE WHEN S.ACCT_CD = '512381' THEN S.PST_ACT_COST_AMT" ).append("\n"); 
		query.append("                ELSE 0" ).append("\n"); 
		query.append("           END)                  AS PST_ACT_COST_AMT_512381" ).append("\n"); 
		query.append("           -----------------------------------------------------------------------" ).append("\n"); 
		query.append("FROM       LEA_ACCL_COST_SMRY   S" ).append("\n"); 
		query.append("WHERE      S.REV_YRMON          BETWEEN REPLACE(@[frm_rev_yrmon_from],'-') AND REPLACE(@[frm_rev_yrmon_to],'-')   -- 변수 BINDING" ).append("\n"); 
		query.append("AND        S.ACCT_CD            IN (  '512073', '512074', '512075'" ).append("\n"); 
		query.append("                                    , '512361', '512362'" ).append("\n"); 
		query.append("                  , '512061', '512062', '512063', '512064', '512065', '512066'" ).append("\n"); 
		query.append("                  , '512151', '512133', '512144', '512152', '512153', '512154', '512155'" ).append("\n"); 
		query.append("                  , '512221', '512222'" ).append("\n"); 
		query.append("                  , '512341', '512342', '512343', '512344', '512345', '512346', '512347'" ).append("\n"); 
		query.append("                  , '512171', '512172'" ).append("\n"); 
		query.append("                  , '512331', '512332', '512333', '512334', '512335', '512336'" ).append("\n"); 
		query.append("                  , '512351'" ).append("\n"); 
		query.append("                  , '512019', '512029', '512039', '512069', '512119', '512229', '512429'" ).append("\n"); 
		query.append("                  , '512181'" ).append("\n"); 
		query.append("                  , '512381'" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY   S.REV_YRMON" ).append("\n"); 
		query.append("ORDER BY   S.REV_YRMON             ASC" ).append("\n"); 

	}
}