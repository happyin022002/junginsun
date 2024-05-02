/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchAutoARInfYnByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchAutoARInfYnByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchAutoARInfYnByOfficeRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchAutoARInfYnByOfficeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchAutoARInfYnByOfficeRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(COUNT(1), 0, 'N', 'Y') AS AUTO_AR_INF_YN" ).append("\n"); 
		query.append("  FROM  DMT_HRD_CDG_CTNT" ).append("\n"); 
		query.append(" WHERE  HRD_CDG_ID = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("   AND  ATTR_CTNT1 = @[dmt_ofc_cd]" ).append("\n"); 

	}
}