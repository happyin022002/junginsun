/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterEmailFaxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterEmailFaxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search customer email fax
	  * </pre>
	  */
	public AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterEmailFaxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.integration").append("\n"); 
		query.append("FileName : AccountReceivableOutstandingDBDAOsearchPaymentRequestLetterEmailFaxRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    MAX(FAX)   AS FAX," ).append("\n"); 
		query.append("    MAX(EMAIL) AS EMAIL " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        '' AS EMAIL" ).append("\n"); 
		query.append("        ,INTL_FAX_NO || REGEXP_REPLACE(FAX_NO, '[ ]|[-]','') FAX" ).append("\n"); 
		query.append("    FROM MDM_CUST_CNTC_PNT" ).append("\n"); 
		query.append("    WHERE CUST_CNT_CD = SUBSTR(@[cust_cd],0,2)" ).append("\n"); 
		query.append("    AND CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("    AND FAX_NO IS NOT NULL " ).append("\n"); 
		query.append("    AND PAY_RQST_LTR_FLG = 'Y'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        SUBSTR(MAX(SYS_CONNECT_BY_PATH(EMAIL,';')),2) AS EMAIL," ).append("\n"); 
		query.append("        MAX(FAX) AS FAX" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT ROWNUM AS SEQ,EMAIL,FAX FROM" ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("             SELECT" ).append("\n"); 
		query.append("                 DISTINCT" ).append("\n"); 
		query.append("                   MCP.CUST_EML AS EMAIL" ).append("\n"); 
		query.append("                 , ''           AS FAX " ).append("\n"); 
		query.append("              FROM MDM_CUSTOMER MC" ).append("\n"); 
		query.append("                 , MDM_CR_CUST MCC" ).append("\n"); 
		query.append("                 , MDM_CUST_CNTC_PNT MCP" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND MC.CUST_CNT_CD = SUBSTR(@[cust_cd],0,2)" ).append("\n"); 
		query.append("               AND MC.CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3))" ).append("\n"); 
		query.append("               AND MC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("               AND MC.CUST_CNT_CD = MCC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("               AND MC.CUST_SEQ = MCC.CUST_SEQ(+)" ).append("\n"); 
		query.append("               AND MC.CUST_CNT_CD = MCP.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("               AND MC.CUST_SEQ = MCP.CUST_SEQ(+)" ).append("\n"); 
		query.append("               AND MC.DELT_FLG = MCC.DELT_FLG(+)" ).append("\n"); 
		query.append("               AND MCP.PAY_RQST_LTR_FLG = 'Y'" ).append("\n"); 
		query.append("         ) " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    START WITH SEQ = 1 CONNECT BY PRIOR SEQ = SEQ - 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}