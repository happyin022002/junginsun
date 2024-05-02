/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchAGnCltRfndUsdLclAmtSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 
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

public class AccountReceivableAgentDBDAOSearchAGnCltRfndUsdLclAmtSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search agent collection refund usd local amount summary
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchAGnCltRfndUsdLclAmtSumRSQL(){
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
		query.append("FileName : AccountReceivableAgentDBDAOSearchAGnCltRfndUsdLclAmtSumRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(USD_AMT), 0) AS USD_AMT" ).append("\n"); 
		query.append("     , NVL(SUM(EQV_LOCL_AMT), 0) AS EQV_LOCL_AMT" ).append("\n"); 
		query.append("     , NVL(SUM(LOCL_AMT), 0) AS LOCL_AMT" ).append("\n"); 
		query.append("     , NVL(SUM(CHG_USD_AMT), 0) AS CHG_USD_AMT     " ).append("\n"); 
		query.append("FROM SAR_AGN_CLT_RFND_MST" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("  AND APRO_FLG = 'Y'" ).append("\n"); 
		query.append("  AND ASA_TP_CD IN ('C', 'R')" ).append("\n"); 

	}
}