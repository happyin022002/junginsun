/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOInvoiceDetailListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.21 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOInvoiceDetailListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOInvoiceDetailListVORSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOInvoiceDetailListVORSQL").append("\n"); 
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
		query.append("SELECT	D.SYS_AREA_GRP_ID AS SVR_ID," ).append("\n"); 
		query.append("D.CNTR_NO," ).append("\n"); 
		query.append("D.INV_DTL_SEQ," ).append("\n"); 
		query.append("D.CNTR_CYC_NO," ).append("\n"); 
		query.append("D.DMDT_TRF_CD," ).append("\n"); 
		query.append("D.DMDT_CHG_LOC_DIV_CD," ).append("\n"); 
		query.append("D.CHG_SEQ," ).append("\n"); 
		query.append("D.ORG_CHG_AMT," ).append("\n"); 
		query.append("D.SC_RFA_EXPT_AMT," ).append("\n"); 
		query.append("D.AFT_EXPT_DC_AMT," ).append("\n"); 
		query.append("D.BIL_AMT," ).append("\n"); 
		query.append("M.INV_CURR_CD" ).append("\n"); 
		query.append("FROM	DMT_INV_MN	M," ).append("\n"); 
		query.append("DMT_INV_DTL	D" ).append("\n"); 
		query.append("WHERE	M.DMDT_INV_NO	=	D.DMDT_INV_NO" ).append("\n"); 
		query.append("AND		D.DMDT_INV_NO	=	@[dmdt_inv_no]" ).append("\n"); 

	}
}