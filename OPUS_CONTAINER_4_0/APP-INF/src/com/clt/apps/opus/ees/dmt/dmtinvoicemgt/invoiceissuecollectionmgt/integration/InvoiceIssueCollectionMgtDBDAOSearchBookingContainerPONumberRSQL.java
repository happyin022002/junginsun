/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingContainerPONumberRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.08 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchBookingContainerPONumberRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_REFERENCE의 CUST_REF_NO_CTNT 조회
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchBookingContainerPONumberRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingContainerPONumberRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("FROM BKG_REFERENCE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[s_bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO IN (" ).append("\n"); 
		query.append("    #foreach( $cntr_no in ${s_cntr_no_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $s_cntr_no_list.size()) " ).append("\n"); 
		query.append("           '$cntr_no', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$cntr_no' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("AND BKG_REF_TP_CD = 'CTPO'" ).append("\n"); 

	}
}