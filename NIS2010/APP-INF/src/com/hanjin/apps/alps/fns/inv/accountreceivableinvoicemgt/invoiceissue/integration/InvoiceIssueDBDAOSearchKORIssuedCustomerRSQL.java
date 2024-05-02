/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueDBDAOSearchKORIssuedCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.03.12 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueDBDAOSearchKORIssuedCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * KOR Issue main, Customer 테이블에서 select
	  * </pre>
	  */
	public InvoiceIssueDBDAOSearchKORIssuedCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration").append("\n"); 
		query.append("FileName : InvoiceIssueDBDAOSearchKORIssuedCustomerRSQL").append("\n"); 
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
		query.append("SELECT A.INV_NO," ).append("\n"); 
		query.append("  A.INV_SEQ," ).append("\n"); 
		query.append("  A.AR_OFC_CD," ).append("\n"); 
		query.append("  A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("  LPAD(A.ACT_CUST_SEQ, 6, '0') ACT_CUST_SEQ," ).append("\n"); 
		query.append("  B.LOCL_NM," ).append("\n"); 
		query.append("  C.CUST_RGST_NO," ).append("\n"); 
		query.append("  C.INDIV_CORP_DIV_CD," ).append("\n"); 
		query.append("  B.ISS_DIV_CD," ).append("\n"); 
		query.append("  B.CNTC_PSON_NM," ).append("\n"); 
		query.append("  B.LOCL_ADDR1||B.LOCL_ADDR2||B.LOCL_ADDR3||B.LOCL_ADDR4 LOCL_ADDR," ).append("\n"); 
		query.append("  B.BZCT_NM," ).append("\n"); 
		query.append("  B.BZTP_NM," ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(A.ISS_DT, 'YYYYMMDD'), 'YYYY-MM-DD') ISS_DT," ).append("\n"); 
		query.append("  A.INV_RMK," ).append("\n"); 
		query.append("  DECODE(B.OB_FAX_NO, '', DECODE(B.IB_FAX_NO, '', A.CUST_FAX_NO, B.IB_FAX_NO), B.OB_FAX_NO) CUST_FAX_NO," ).append("\n"); 
		query.append("  DECODE(B.OB_EML, '', DECODE(B.IB_EML, '', A.CUST_EML, B.IB_EML), OB_EML) CUST_EML" ).append("\n"); 
		query.append("FROM INV_AR_KR_ISS A," ).append("\n"); 
		query.append("  MDM_CR_CUST B," ).append("\n"); 
		query.append("  MDM_CUSTOMER C" ).append("\n"); 
		query.append("WHERE A.ACT_CUST_CNT_CD = B.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = B.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND A.ACT_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("  AND A.ACT_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("  AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("  AND A.INV_SEQ = (" ).append("\n"); 
		query.append("    SELECT MAX(INV_SEQ)" ).append("\n"); 
		query.append("    FROM INV_AR_KR_ISS" ).append("\n"); 
		query.append("    WHERE INV_NO = @[inv_no]" ).append("\n"); 
		query.append("      AND AR_OFC_CD IN (" ).append("\n"); 
		query.append("        SELECT DISTINCT AR_OFC_CD" ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("          WHERE (LOC_CD LIKE 'KR%' OR LOC_CD LIKE 'HQ%')" ).append("\n"); 
		query.append("          AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("          AND AR_OFC_CD IS NOT NULL))" ).append("\n"); 

	}
}