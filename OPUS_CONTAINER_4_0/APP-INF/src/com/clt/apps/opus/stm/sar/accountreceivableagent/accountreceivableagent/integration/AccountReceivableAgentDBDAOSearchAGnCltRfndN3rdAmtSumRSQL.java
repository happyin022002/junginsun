/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchAGnCltRfndN3rdAmtSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAgentDBDAOSearchAGnCltRfndN3rdAmtSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search Agent collection refund third amount summary
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchAGnCltRfndN3rdAmtSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("asa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchAGnCltRfndN3rdAmtSumRSQL").append("\n"); 
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
		query.append("SELECT SUM(N3RD_AMT) AS N3RD_AMT," ).append("\n"); 
		query.append("       N3RD_CURR_CD AS N3RD_CURR_CD," ).append("\n"); 
		query.append("       SUM(N3RD_LOCL_AMT) AS N3RD_LOCL_AMT" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT NVL(N3RD_AMT1, 0) AS N3RD_AMT" ).append("\n"); 
		query.append("             , N3RD_CURR_CD1 AS N3RD_CURR_CD" ).append("\n"); 
		query.append("             , NVL(N3RD_LOCL_AMT1, 0) AS N3RD_LOCL_AMT          " ).append("\n"); 
		query.append("        FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("          AND APRO_FLG = 'Y'" ).append("\n"); 
		query.append("          AND ASA_TP_CD IN ('C', 'R')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT NVL(N3RD_AMT2, 0) AS N3RD_AMT" ).append("\n"); 
		query.append("             , N3RD_CURR_CD2 AS N3RD_CURR_CD" ).append("\n"); 
		query.append("             , NVL(N3RD_LOCL_AMT2, 0) AS N3RD_LOCL_AMT          " ).append("\n"); 
		query.append("        FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("          AND APRO_FLG = 'Y'" ).append("\n"); 
		query.append("          AND ASA_TP_CD IN ('C', 'R')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT NVL(N3RD_AMT3, 0) AS N3RD_AMT" ).append("\n"); 
		query.append("             , N3RD_CURR_CD3 AS N3RD_CURR_CD" ).append("\n"); 
		query.append("             , NVL(N3RD_LOCL_AMT3, 0) AS N3RD_LOCL_AMT          " ).append("\n"); 
		query.append("        FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("          AND APRO_FLG = 'Y'" ).append("\n"); 
		query.append("          AND ASA_TP_CD IN ('C', 'R')" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT NVL(N3RD_AMT4, 0) AS N3RD_AMT" ).append("\n"); 
		query.append("             , N3RD_CURR_CD4 AS N3RD_CURR_CD" ).append("\n"); 
		query.append("             , NVL(N3RD_LOCL_AMT4, 0) AS N3RD_LOCL_AMT                   " ).append("\n"); 
		query.append("        FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("        WHERE 1 = 1" ).append("\n"); 
		query.append("          AND ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("          AND APRO_FLG = 'Y'" ).append("\n"); 
		query.append("          AND ASA_TP_CD IN ('C', 'R')            " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE  N3RD_CURR_CD IS NOT NULL" ).append("\n"); 
		query.append("GROUP BY N3RD_CURR_CD" ).append("\n"); 
		query.append("HAVING SUM(N3RD_LOCL_AMT) <> 0 " ).append("\n"); 

	}
}