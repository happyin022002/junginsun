/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ARInvoiceCorrectionDBDAOSearchVatRatioEntryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.31
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.03.31 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceCorrectionDBDAOSearchVatRatioEntryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceCorrectionDBDAOSearchVatRatioEntryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration").append("\n"); 
		query.append("FileName : ARInvoiceCorrectionDBDAOSearchVatRatioEntryListRSQL").append("\n"); 
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
		query.append("SELECT   CNT_CD" ).append("\n"); 
		query.append("        ,INV_EU_CNT_SEQ" ).append("\n"); 
		query.append("        ,INV_EURO_VAT_RT" ).append("\n"); 
		query.append("        ,INV_EURO_VAT_ST_DT" ).append("\n"); 
		query.append("        ,INV_EURO_VAT_END_DT" ).append("\n"); 
		query.append("        ,DELT_FLG" ).append("\n"); 
		query.append("        ,DELT_DT" ).append("\n"); 
		query.append("  FROM  INV_AR_EU_CNT_VAT" ).append("\n"); 
		query.append(" ORDER  BY CNT_CD,INV_EU_CNT_SEQ" ).append("\n"); 

	}
}