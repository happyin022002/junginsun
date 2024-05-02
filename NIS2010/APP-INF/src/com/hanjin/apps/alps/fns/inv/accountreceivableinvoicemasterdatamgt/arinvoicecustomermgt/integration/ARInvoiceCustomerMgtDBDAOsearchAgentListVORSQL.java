/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOsearchAgentListVORSQL.java
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

public class ARInvoiceCustomerMgtDBDAOsearchAgentListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_INV_0081
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOsearchAgentListVORSQL(){
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
		query.append("FileName : ARInvoiceCustomerMgtDBDAOsearchAgentListVORSQL").append("\n"); 
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
		query.append("B.VNDR_CNT_CD VNDR_CNT_CD," ).append("\n"); 
		query.append("LPAD(B.VNDR_SEQ,6,0) VNDR_SEQ" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION A, BKG_CHN_AGN B , MDM_ORGANIZATION D" ).append("\n"); 
		query.append("WHERE A.AR_HD_QTR_OFC_CD = (SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION WHERE OFC_CD= @[ofc_cd])" ).append("\n"); 
		query.append("AND A.AR_OFC_CD NOT LIKE '%BB'" ).append("\n"); 
		query.append("AND B.CHN_AGN_CD = SUBSTR(A.AR_OFC_CD,4,2)" ).append("\n"); 
		query.append("AND D.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND SUBSTR(A.LOC_CD, 1, 2) = SUBSTR(D.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("ORDER BY A.AR_OFC_CD" ).append("\n"); 

	}
}