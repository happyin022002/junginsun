/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchAgentCListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.12.17 최우석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi,Woo-Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOsearchAgentCListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * arControl='C' or arOfc='XMNBB' 인 경우
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchAgentCListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchAgentCListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("A.AR_OFC_CD AGN_CD," ).append("\n"); 
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("B.CHN_AGN_CD," ).append("\n"); 
		query.append("B.CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(B.CUST_SEQ,6,0) CUST_SEQ," ).append("\n"); 
		query.append("B.VNDR_CNT_CD," ).append("\n"); 
		query.append("LPAD(B.VNDR_SEQ,6,0) VNDR_SEQ" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A, BKG_CHN_AGN B" ).append("\n"); 
		query.append("WHERE A.OFC_CD LIKE DECODE (@[ofc_cd], A.AR_HD_QTR_OFC_CD, '%', @[ofc_cd])" ).append("\n"); 
		query.append("AND A.AR_CTRL_OFC_CD = 'C'" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND A.AR_OFC_CD NOT LIKE '___BB'" ).append("\n"); 
		query.append("AND B.CHN_AGN_CD = SUBSTR(A.AR_OFC_CD,4,2)" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("SUBSTR(B.FINC_OFC_CD, 1,3) || B.CHN_AGN_CD AS AGN_CD," ).append("\n"); 
		query.append("A.AR_OFC_CD," ).append("\n"); 
		query.append("B.CHN_AGN_CD," ).append("\n"); 
		query.append("B.CUST_CNT_CD," ).append("\n"); 
		query.append("LPAD(B.CUST_SEQ,6,0) CUST_SEQ," ).append("\n"); 
		query.append("B.VNDR_CNT_CD," ).append("\n"); 
		query.append("LPAD(B.VNDR_SEQ,6,0) VNDR_SEQ" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A, BKG_CHN_AGN B" ).append("\n"); 
		query.append("WHERE A.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND A.AR_OFC_CD IS NOT NULL" ).append("\n"); 
		query.append("AND B.FINC_OFC_CD LIKE DECODE(A.AR_OFC_CD, A.AR_HD_QTR_OFC_CD, '%', A.AR_OFC_CD)" ).append("\n"); 
		query.append("AND B.CHN_AGN_CD <> 'BB'" ).append("\n"); 
		query.append("ORDER BY AGN_CD" ).append("\n"); 

	}
}