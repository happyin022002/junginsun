/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOCprtItemVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2010.02.17 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author donghoon han
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOCprtItemVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOCprtItemVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOCprtItemVORSQL").append("\n"); 
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
		query.append("SELECT	A.RPT_ITM_ID" ).append("\n"); 
		query.append("		,A.ITM_GRP_NM" ).append("\n"); 
		query.append("		,A.RPT_ITM_GRP_ID" ).append("\n"); 
		query.append("		,A.DP_SEQ" ).append("\n"); 
		query.append("		,A.RPT_ITM_NM" ).append("\n"); 
		query.append("		,A.MST_ITM_ID" ).append("\n"); 
		query.append("		,A.N2ND_MST_ITM_ID" ).append("\n"); 
		query.append("		,A.CPRT_CONV_TP_CD" ).append("\n"); 
		query.append("		,A.CRE_USR_ID" ).append("\n"); 
		query.append("		,A.CRE_DT" ).append("\n"); 
		query.append("		,A.UPD_USR_ID" ).append("\n"); 
		query.append("		,A.UPD_DT" ).append("\n"); 
		query.append("		,'' RPT_TMPLT_NM" ).append("\n"); 
		query.append("FROM    INV_CPRT_ITM A" ).append("\n"); 
		query.append("ORDER BY DP_SEQ" ).append("\n"); 

	}
}