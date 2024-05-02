/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchCustomerListByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2013.09.26 임옥영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Okyoung Im
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchCustomerListByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자가 Execl Upload한 B/L의 Customer정보를 조회한다.
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchCustomerListByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDAOSearchCustomerListByBLRSQL").append("\n"); 
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
		query.append("SELECT BC.BL_NO,BC.SC_NO, BC.RFA_NO," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'S', BC.CUST_CNT_CD||DECODE(BC.CUST_CNT_CD, NULL, NULL,TRIM(TO_CHAR(BC.CUST_SEQ,'000000'))), '')) S_CUST," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'S', BC.CUST_LGL_ENG_NM, '')) S_NM1," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'S', BC.CUST_NM, '')) S_NM2," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'C', BC.CUST_CNT_CD||DECODE(BC.CUST_CNT_CD, NULL, NULL,TRIM(TO_CHAR(BC.CUST_SEQ,'000000'))), '')) C_CUST," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'C', BC.CUST_LGL_ENG_NM, '')) C_NM1," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'C', BC.CUST_NM, '')) C_NM2," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'N', BC.CUST_CNT_CD||DECODE(BC.CUST_CNT_CD, NULL, NULL,TRIM(TO_CHAR(BC.CUST_SEQ,'000000'))), '')) N_CUST," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'N', BC.CUST_LGL_ENG_NM, '')) N_NM1," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'N', BC.CUST_NM, '')) N_NM2," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'F', BC.CUST_CNT_CD||DECODE(BC.CUST_CNT_CD, NULL, NULL,TRIM(TO_CHAR(BC.CUST_SEQ,'000000'))), '')) F_CUST," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'F', BC.CUST_LGL_ENG_NM, '')) F_NM1," ).append("\n"); 
		query.append("       MAX(DECODE(BC.BKG_CUST_TP_CD, 'F', BC.CUST_NM, '')) F_NM2" ).append("\n"); 
		query.append("FROM               " ).append("\n"); 
		query.append("        (               " ).append("\n"); 
		query.append("            SELECT BB.BL_NO, BB.SC_NO, BB.RFA_NO, BC.BKG_CUST_TP_CD, BC.CUST_CNT_CD, BC.CUST_SEQ, MC.CUST_LGL_ENG_NM, BC.CUST_NM                         " ).append("\n"); 
		query.append("            FROM   BKG_BOOKING BB," ).append("\n"); 
		query.append("                   BKG_CUSTOMER BC," ).append("\n"); 
		query.append("                   MDM_CUSTOMER MC" ).append("\n"); 
		query.append("            WHERE  BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("            AND    BC.CUST_CNT_CD = MC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("            AND    BC.CUST_SEQ = MC.CUST_SEQ(+)" ).append("\n"); 
		query.append("			AND	   BB.BL_NO IN(" ).append("\n"); 
		query.append("								#foreach(${keys} IN ${keyList}) " ).append("\n"); 
		query.append("	      	     					'$keys',  " ).append("\n"); 
		query.append("	           			    	#end" ).append("\n"); 
		query.append("						'')" ).append("\n"); 
		query.append("            AND    BC.BKG_CUST_TP_CD IN ('F','N','C','S')" ).append("\n"); 
		query.append("        ) BC" ).append("\n"); 
		query.append("GROUP BY BC.BL_NO, BC.SC_NO, BC.RFA_NO" ).append("\n"); 
		query.append("ORDER BY BC.BL_NO" ).append("\n"); 

	}
}