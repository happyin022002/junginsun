/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOModifyUnsettledAccountSummarySettleUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.04.29 차상영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGYOUNG CHA
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOModifyUnsettledAccountSummarySettleUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOModifyUnsettledAccountSummarySettleUSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOModifyUnsettledAccountSummarySettleUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unstl_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOModifyUnsettledAccountSummarySettleUSQL").append("\n"); 
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
		query.append("UPDATE  SAP_UNSTL_SMRY SUS" ).append("\n"); 
		query.append("SET     SUS.ACCT_STL_FLG = 'Y'" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     (SUS.STL_KEY_NO, SUS.COA_ACCT_CD, SUS.COA_CTR_CD, SUS.VNDR_NO, SUS.UNSTL_CURR_CD) " ).append("\n"); 
		query.append("             IN (SELECT  STL_KEY_NO" ).append("\n"); 
		query.append("                       , COA_ACCT_CD" ).append("\n"); 
		query.append("                       , COA_CTR_CD" ).append("\n"); 
		query.append("                       , VNDR_NO" ).append("\n"); 
		query.append("                       , UNSTL_CURR_CD" ).append("\n"); 
		query.append("                 FROM    (SELECT  SUS2.STL_KEY_NO" ).append("\n"); 
		query.append("                                , SUS2.COA_ACCT_CD" ).append("\n"); 
		query.append("                                , SUS2.COA_CTR_CD" ).append("\n"); 
		query.append("                                , SUS2.VNDR_NO" ).append("\n"); 
		query.append("                                , SUS2.UNSTL_CURR_CD" ).append("\n"); 
		query.append("                                , SUM(SUS2.UNSTL_AMT) AS STL_AMT" ).append("\n"); 
		query.append("                          FROM    SAP_UNSTL_SMRY SUS2" ).append("\n"); 
		query.append("                          WHERE   1 = 1" ).append("\n"); 
		query.append("                          AND     SUS2.UNSTL_YRMON = REPLACE(@[unstl_yrmon],'-','')" ).append("\n"); 
		query.append("                          AND     SUS2.UNSTL_SRC_CD = 'AP'" ).append("\n"); 
		query.append("                          GROUP   BY SUS2.STL_KEY_NO, SUS2.COA_ACCT_CD, SUS2.COA_CTR_CD, SUS2.VNDR_NO, SUS2.UNSTL_CURR_CD)" ).append("\n"); 
		query.append("                 WHERE   1 = 1" ).append("\n"); 
		query.append("                 AND     STL_AMT = 0 )" ).append("\n"); 
		query.append("AND     SUS.UNSTL_YRMON = REPLACE(@[unstl_yrmon],'-','')" ).append("\n"); 
		query.append("AND     SUS.UNSTL_SRC_CD = 'AP'" ).append("\n"); 

	}
}