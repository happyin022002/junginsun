/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchInvoiceLineNumDupCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.08
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.05.08 차상영
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

public class AccountPayableInvoiceDBDAOSearchInvoiceLineNumDupCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchInvoiceLineNumDupCheckRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchInvoiceLineNumDupCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration ").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchInvoiceLineNumDupCheckRSQL").append("\n"); 
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
		query.append("SELECT  ERROR_CNT" ).append("\n"); 
		query.append("FROM    (SELECT  COUNT(DISTINCT AID.DTRB_COA_CO_CD||AID.DTRB_COA_RGN_CD||AID.DTRB_COA_CTR_CD||AID.DTRB_COA_ACCT_CD||AID.DTRB_COA_VVD_CD||AID.DTRB_COA_INTER_CO_CD) ERROR_CNT" ).append("\n"); 
		query.append("        FROM    AP_INV_DTRB AID" ).append("\n"); 
		query.append("        WHERE   AID.CSR_NO = @[csr_no]" ).append("\n"); 
		query.append("        GROUP   BY AID.CSR_NO, AID.LINE_NO" ).append("\n"); 
		query.append("        HAVING  COUNT(DISTINCT AID.DTRB_COA_CO_CD||AID.DTRB_COA_RGN_CD||AID.DTRB_COA_CTR_CD||AID.DTRB_COA_ACCT_CD||AID.DTRB_COA_VVD_CD||AID.DTRB_COA_INTER_CO_CD) > 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("WHERE   ROWNUM = 1" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}