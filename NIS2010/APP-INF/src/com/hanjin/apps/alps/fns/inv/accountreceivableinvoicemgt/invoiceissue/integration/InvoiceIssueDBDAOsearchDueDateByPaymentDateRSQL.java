/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueDBDAOsearchDueDateByPaymentDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOsearchDueDateByPaymentDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueDBDAOsearchDueDateByPaymentDateRSQL
	  * </pre>
	  */
	public InvoiceIssueDBDAOsearchDueDateByPaymentDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOsearchDueDateByPaymentDateRSQL").append("\n"); 
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
		query.append("SELECT DECODE(SUBSTR(PAYMENT, 5, 2), SUBSTR(@[due_dt], 5, 2), DECODE(SIGN(PAYMENT - TO_CHAR(LAST_DAY(TO_DATE(@[due_dt], 'YYYYMMDD')), 'YYYYMMDD')), -1, PAYMENT" ).append("\n"); 
		query.append("                                                                                                                                                    , TO_CHAR(LAST_DAY(TO_DATE(@[due_dt], 'YYYYMMDD')), 'YYYYMMDD'))" ).append("\n"); 
		query.append("                                   , PAYMENT" ).append("\n"); 
		query.append("       ) DUE_DT" ).append("\n"); 
		query.append("  FROM (SELECT DECODE(PAY_FLAG, NULL, SUBSTR(TO_CHAR(ADD_MONTHS(TO_DATE(@[due_dt], 'YYYYMMDD'), 1), 'YYYYMMDD'), 1, 6)||PAY_DT_DY1" ).append("\n"); 
		query.append("                                    , SUBSTR(@[due_dt], 1, 6)||PAY_FLAG) PAYMENT" ).append("\n"); 
		query.append("          FROM (SELECT MIN(DECODE(SIGN(PAY_FLAG - DUE_DT_FLAG), 0, PAY_FLAG" ).append("\n"); 
		query.append("                                                               , 1, PAY_FLAG)) PAY_FLAG" ).append("\n"); 
		query.append("                     , MIN(PAY_DT_DY1) PAY_DT_DY1" ).append("\n"); 
		query.append("                  FROM (SELECT DECODE(CPY.CPY_NO, 1, PAY_DT_DY1" ).append("\n"); 
		query.append("                                                , 2, PAY_DT_DY2" ).append("\n"); 
		query.append("                                                , 3, PAY_DT_DY3" ).append("\n"); 
		query.append("                                                , 4, PAY_DT_DY4) PAY_FLAG" ).append("\n"); 
		query.append("                             , SUBSTR(@[due_dt], 7, 2) DUE_DT_FLAG" ).append("\n"); 
		query.append("                             , PAY_DT_DY1" ).append("\n"); 
		query.append("                          FROM (SELECT PAY_DT_DY1" ).append("\n"); 
		query.append("                                     , PAY_DT_DY2 " ).append("\n"); 
		query.append("                                     , PAY_DT_DY3" ).append("\n"); 
		query.append("                                     , PAY_DT_DY4" ).append("\n"); 
		query.append("                                  FROM MDM_CR_CUST" ).append("\n"); 
		query.append("                                 WHERE CUST_CNT_CD  = @[cust_cnt_cd]" ).append("\n"); 
		query.append("                                   AND CUST_SEQ = @[cust_seq]" ).append("\n"); 
		query.append("                                   AND NVL(SUB_SYS_NM,'MDM') <> 'ERP')" ).append("\n"); 
		query.append("                             , COM_CPY_NO CPY" ).append("\n"); 
		query.append("                         WHERE CPY.CPY_NO BETWEEN 1 AND 4)))" ).append("\n"); 

	}
}