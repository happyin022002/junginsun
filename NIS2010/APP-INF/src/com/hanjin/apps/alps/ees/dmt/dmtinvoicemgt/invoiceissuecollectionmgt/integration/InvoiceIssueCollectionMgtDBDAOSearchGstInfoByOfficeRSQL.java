/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchGstInfoByOfficeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.31 
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

public class InvoiceIssueCollectionMgtDBDAOSearchGstInfoByOfficeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InvoiceIssueCollectionMgtDBDAOSearchGstInfoByOfficeRSQL
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchGstInfoByOfficeRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchGstInfoByOfficeRSQL").append("\n"); 
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
		query.append("SELECT  A2.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       ,A2.IDA_PAN_NO" ).append("\n"); 
		query.append("	   ,A4.IDA_STE_CD" ).append("\n"); 
		query.append("	   ,A4.STE_NM 				AS IDA_STE_NM" ).append("\n"); 
		query.append("	   ,A5.ATTR_CTNT3			AS IDA_TAX_CIN" ).append("\n"); 
		query.append("	   ,A5.ATTR_CTNT4			AS IDA_SVC_CATE_RMK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  MDM_ORGANIZATION  A1" ).append("\n"); 
		query.append("       ,MDM_CUSTOMER      A2" ).append("\n"); 
		query.append("	   ,MDM_LOCATION      A3" ).append("\n"); 
		query.append("	   ,MDM_STATE         A4	" ).append("\n"); 
		query.append("	   ,DMT_HRD_CDG_CTNT  A5" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append(" WHERE  A1.OFC_CD          = @[ofc_cd]" ).append("\n"); 
		query.append("   AND  A1.REP_CUST_CNT_CD = A2.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND  A1.REP_CUST_SEQ    = A2.CUST_SEQ" ).append("\n"); 
		query.append("   AND  A1.LOC_CD          = A3.LOC_CD" ).append("\n"); 
		query.append("   AND  A3.STE_CD          = A4.STE_CD" ).append("\n"); 
		query.append("   AND  A1.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("   AND  A2.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("   AND  A3.DELT_FLG        = 'N'						   " ).append("\n"); 
		query.append("   AND  A4.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("   AND  A5.HRD_CDG_ID      = 'IDA_TAX_INFO'" ).append("\n"); 

	}
}