/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchASARemittanceExpDrCrAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.13 
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

public class AccountReceivableAgentDBDAOSearchASARemittanceExpDrCrAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select Remittance EXP Adjust
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchASARemittanceExpDrCrAmtRSQL(){
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
		query.append("FileName : AccountReceivableAgentDBDAOSearchASARemittanceExpDrCrAmtRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(CASE WHEN B.ADJ_AMT < 0 THEN B.ADJ_AMT ELSE 0 END), 0) AS DEBIT_AMT  " ).append("\n"); 
		query.append("         , NVL(SUM(CASE WHEN B.ADJ_AMT > 0 THEN B.ADJ_AMT ELSE 0 END), 0) AS CREDIT_AMT" ).append("\n"); 
		query.append("     FROM SAR_ADJ_HDR   A, " ).append("\n"); 
		query.append("          SAR_ADJ_DTL   B     " ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("      AND A.OTS_ADJ_SEQ = B.OTS_ADJ_SEQ" ).append("\n"); 
		query.append("      AND A.ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("      AND B.ADJ_TP_CD = 'EX'" ).append("\n"); 
		query.append("      AND NVL(A.RVS_FLG,'N') <> 'Y'" ).append("\n"); 

	}
}