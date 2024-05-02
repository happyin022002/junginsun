/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchIndiaInvoiceNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.05
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchIndiaInvoiceNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchIndiaInvoiceNoRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchIndiaInvoiceNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fsc_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchIndiaInvoiceNoRSQL").append("\n"); 
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
		query.append("SELECT  MDL_ID" ).append("\n"); 
		query.append("       ,SER_NO_DIV_CD" ).append("\n"); 
		query.append("	   ,SER_NO_DIV_SEQ" ).append("\n"); 
		query.append("	   ,SER_NO_SEQ" ).append("\n"); 
		query.append("	   ,ATTR_CTNT1 		AS OFC_CTY_CD" ).append("\n"); 
		query.append("	   ,ATTR_CTNT2 		AS FSC_YR" ).append("\n"); 
		query.append("  FROM  COM_SER_NO_CTNT  " ).append("\n"); 
		query.append(" WHERE  MDL_ID        = 'DMT'" ).append("\n"); 
		query.append("   AND  SER_NO_DIV_CD = 'II'" ).append("\n"); 
		query.append("   AND  ATTR_CTNT1    = @[ofc_cty_cd]" ).append("\n"); 
		query.append("   AND  ATTR_CTNT2    = @[fsc_yr]" ).append("\n"); 

	}
}