/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchARIFCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.11.26 김태균
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

public class InvoiceIssueCollectionMgtDBDAOSearchARIFCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * A/R I/F 발생건수 조회 와 INV_CUR VALIDATION CHECK
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchARIFCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchARIFCountRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("#if (${check_flg} == '1') " ).append("\n"); 
		query.append("	DECODE(DMDT_AR_IF_CD, 'Y', DMDT_INV_NO, '') AS DMDT_INV_NO" ).append("\n"); 
		query.append("#elseif(${check_flg} == '2') " ).append("\n"); 
		query.append("	DECODE(INV_CURR_CD, NULL,'N','Y') AS INV_CHK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("FROM DMT_INV_MN" ).append("\n"); 
		query.append("WHERE DMDT_INV_NO IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_inv_no in ${dmdt_inv_no_list}) " ).append("\n"); 
		query.append("        #if($velocityCount < $dmdt_inv_no_list.size()) " ).append("\n"); 
		query.append("           '$dmdt_inv_no', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_inv_no' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}