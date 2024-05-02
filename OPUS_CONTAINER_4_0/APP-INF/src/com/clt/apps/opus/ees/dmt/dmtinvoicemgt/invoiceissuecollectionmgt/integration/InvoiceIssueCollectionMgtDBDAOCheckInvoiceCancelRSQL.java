/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOCheckInvoiceCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOCheckInvoiceCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Cancel 여부 체크
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOCheckInvoiceCancelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOCheckInvoiceCancelRSQL").append("\n"); 
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
		query.append("SELECT DECODE(CXL_BKG_CHG_FLG, 'Y', 'Y', 'N') AS CANCEL_YN" ).append("\n"); 
		query.append("FROM DMT_INV_DTL A, DMT_CHG_CALC B" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = @[s_invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_CYC_NO = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND A.DMDT_TRF_CD = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND A.DMDT_CHG_LOC_DIV_CD = B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND A.CHG_SEQ = B.CHG_SEQ" ).append("\n"); 

	}
}