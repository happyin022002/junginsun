/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAgentDBDAOSearchASARemittanceDrCrAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.10 
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

public class AccountReceivableAgentDBDAOSearchASARemittanceDrCrAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select receipt & refund adjust
	  * </pre>
	  */
	public AccountReceivableAgentDBDAOSearchASARemittanceDrCrAmtRSQL(){
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
		query.append("FileName : AccountReceivableAgentDBDAOSearchASARemittanceDrCrAmtRSQL").append("\n"); 
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
		query.append("SELECT SUM(DECODE(DR_CR,'D', AMT)) AS DEBIT_AMT  " ).append("\n"); 
		query.append("         , SUM(DECODE(DR_CR,'C', AMT)) AS CREDIT_AMT" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("        SELECT NVL(SUM(C.OTS_APLY_AMT),0) AS AMT " ).append("\n"); 
		query.append("            , 'D' DR_CR    " ).append("\n"); 
		query.append("        FROM  SAR_RECEIPT A" ).append("\n"); 
		query.append("            , SAR_RCT_APLY_HDR   B" ).append("\n"); 
		query.append("            , SAR_RCT_APLY_DTL   C     " ).append("\n"); 
		query.append("        WHERE 1 =1" ).append("\n"); 
		query.append("        AND A.ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("        AND NVL(B.RVS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("        AND A.RCT_CXL_RSN_CD IS NULL" ).append("\n"); 
		query.append("        AND A.RCT_SEQ = B.RCT_SEQ" ).append("\n"); 
		query.append("        AND B.RCT_APLY_HDR_SEQ = C.RCT_APLY_HDR_SEQ" ).append("\n"); 
		query.append("        AND B.RCT_SEQ = C.RCT_SEQ  " ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT NVL(SUM(B.ADJ_AMT),0) AS AMT   -- adjust plus amount(refund, reverse)" ).append("\n"); 
		query.append("            , 'C' DR_CR    " ).append("\n"); 
		query.append("        FROM SAR_ADJ_HDR   A, " ).append("\n"); 
		query.append("             SAR_ADJ_DTL   B     " ).append("\n"); 
		query.append("        WHERE 1 =1 " ).append("\n"); 
		query.append("        AND A.OTS_ADJ_SEQ = B.OTS_ADJ_SEQ" ).append("\n"); 
		query.append("        AND A.ASA_NO = @[asa_no]" ).append("\n"); 
		query.append("        AND B.ADJ_TP_CD = 'RFD'" ).append("\n"); 
		query.append("        AND NVL(A.RVS_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("    ) A" ).append("\n"); 

	}
}