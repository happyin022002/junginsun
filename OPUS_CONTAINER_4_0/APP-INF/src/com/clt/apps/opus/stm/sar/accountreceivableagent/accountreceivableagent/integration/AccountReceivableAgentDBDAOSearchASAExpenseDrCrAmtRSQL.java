/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchASAExpenseDrCrAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.12 
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

public class AccountReceivableAgentDBDAOSearchASAExpenseDrCrAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select ASA Expense Amount(Debit, Credit)
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchASAExpenseDrCrAmtRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration").append("\n"); 
		query.append("FileName : AccountReceivableAgentDBDAOSearchASAExpenseDrCrAmtRSQL").append("\n"); 
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
		query.append("SELECT NVL(SUM(CASE WHEN B.INV_AMT < 0  THEN B.INV_AMT ELSE 0 END), 0) * -1 AS DEBIT_AMT" ).append("\n"); 
		query.append("      , NVL(SUM(CASE WHEN B.INV_AMT > 0  THEN B.INV_AMT ELSE 0 END), 0) AS CREDIT_AMT  " ).append("\n"); 
		query.append("      , @[asa_no] AS ASA_NO   " ).append("\n"); 
		query.append("      , @[chg_tp_cd]  AS CHG_TP_CD" ).append("\n"); 
		query.append("   FROM SAR_OTS_HIS A" ).append("\n"); 
		query.append("      , SAR_OTS_CHG B" ).append("\n"); 
		query.append("  WHERE 1 = 1" ).append("\n"); 
		query.append("    AND A.OTS_HIS_SEQ = B.OTS_HIS_SEQ" ).append("\n"); 
		query.append("    AND A.BL_NO = @[asa_no]" ).append("\n"); 
		query.append("    AND A.OTS_SRC_CD ='STM AP'" ).append("\n"); 
		query.append("    AND B.CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 

	}
}