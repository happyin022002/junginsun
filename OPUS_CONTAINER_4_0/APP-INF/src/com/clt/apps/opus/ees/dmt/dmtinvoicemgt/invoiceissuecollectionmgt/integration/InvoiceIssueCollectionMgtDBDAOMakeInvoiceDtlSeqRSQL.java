/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOMakeInvoiceDtlSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.09.08 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Tae Kyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOMakeInvoiceDtlSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MakeInvoiceDtlSeq
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOMakeInvoiceDtlSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOMakeInvoiceDtlSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(INV_DTL_SEQ),0)+1 AS MAX_SEQ" ).append("\n"); 
		query.append("FROM DMT_INV_DTL" ).append("\n"); 
		query.append("WHERE DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}