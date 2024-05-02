/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceCustomerMgtDBDAOTemplateItemVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.28
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2011.03.28 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCustomerMgtDBDAOTemplateItemVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TemplateItemVO
	  * </pre>
	  */
	public ARInvoiceCustomerMgtDBDAOTemplateItemVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_tmplt_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceCustomerMgtDBDAOTemplateItemVORSQL").append("\n"); 
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
		query.append("SELECT  A.RPT_ITM_NM" ).append("\n"); 
		query.append("		,B.RPT_TMPLT_NM" ).append("\n"); 
		query.append("		,B.RPT_ITM_ID" ).append("\n"); 
		query.append("        ,B.USR_DEF_NM        " ).append("\n"); 
		query.append("        ,B.ITM_SEQ" ).append("\n"); 
		query.append("		,B.RPT_AUTH_ID" ).append("\n"); 
		query.append("        ,B.AR_OFC_CD" ).append("\n"); 
		query.append("FROM    INV_CPRT_ITM A" ).append("\n"); 
		query.append("        ,INV_CPRT_TMPLT B" ).append("\n"); 
		query.append("WHERE   A.RPT_ITM_ID = B.RPT_ITM_ID" ).append("\n"); 
		query.append("AND     B.RPT_TMPLT_NM = @[rpt_tmplt_nm]" ).append("\n"); 
		query.append("AND     B.AR_OFC_CD    = @[ar_ofc_cd]" ).append("\n"); 
		query.append("ORDER BY B.ITM_SEQ, B.RPT_ITM_ID" ).append("\n"); 

	}
}