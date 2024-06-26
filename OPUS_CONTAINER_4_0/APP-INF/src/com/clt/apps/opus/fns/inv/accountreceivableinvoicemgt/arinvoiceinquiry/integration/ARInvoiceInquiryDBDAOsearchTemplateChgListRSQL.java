/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOsearchTemplateChgListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOsearchTemplateChgListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Template Charge List
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOsearchTemplateChgListRSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOsearchTemplateChgListRSQL").append("\n"); 
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
		query.append("SELECT  DP_SEQ" ).append("\n"); 
		query.append("       ,CHG_CD" ).append("\n"); 
		query.append("       ,CPRT_CHG_GRP_FLG" ).append("\n"); 
		query.append("       ,AR_OFC_CD" ).append("\n"); 
		query.append("       ,RPT_TMPLT_NM" ).append("\n"); 
		query.append("       ,RPT_ITM_ID " ).append("\n"); 
		query.append("       ,CPRT_TP_CTNT" ).append("\n"); 
		query.append("       ,CPRT_VAL_CTNT" ).append("\n"); 
		query.append("       ,CRE_USR_ID       " ).append("\n"); 
		query.append("       ,TO_CHAR(CRE_DT,'YYYYMMDDHH24MISS') as CRE_DT           " ).append("\n"); 
		query.append("FROM  INV_CPRT_TMPLT_CHG" ).append("\n"); 
		query.append("WHERE AR_OFC_CD     = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND   RPT_TMPLT_NM  = @[rpt_tmplt_nm]" ).append("\n"); 
		query.append("ORDER BY CPRT_TP_CTNT DESC,CPRT_VAL_CTNT,DP_SEQ ASC" ).append("\n"); 

	}
}