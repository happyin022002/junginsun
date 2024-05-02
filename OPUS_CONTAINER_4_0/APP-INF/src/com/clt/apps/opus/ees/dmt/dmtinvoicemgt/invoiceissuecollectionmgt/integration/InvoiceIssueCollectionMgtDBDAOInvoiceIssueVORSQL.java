/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOInvoiceIssueVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.12 
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

public class InvoiceIssueCollectionMgtDBDAOInvoiceIssueVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VO 생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOInvoiceIssueVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOInvoiceIssueVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' EXPT_AMT" ).append("\n"); 
		query.append(",'' AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' BIL_AMT" ).append("\n"); 
		query.append(",'' FT_CMNC_DT" ).append("\n"); 
		query.append(",'' GB" ).append("\n"); 
		query.append(",'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' DMDT_CHG_STS_CD" ).append("\n"); 
		query.append(",'' FT_DYS" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' FM_MVMT_DT" ).append("\n"); 
		query.append(",'' BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",'' BZC_TRF_SEQ" ).append("\n"); 
		query.append(",'' FT_END_DT" ).append("\n"); 
		query.append(",'' ORG_CHG_AMT" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' TO_MVMT_DT" ).append("\n"); 
		query.append(",'' DMDT_INV_NO" ).append("\n"); 
		query.append(",'' ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",'' RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",'' RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",'' RT_DTL_GRP" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' CMDT_EXPT_AMT" ).append("\n"); 
		query.append(",'' DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' INV_BILL_AMT" ).append("\n"); 
		query.append(",'' INV_CHG_TOT" ).append("\n"); 
		query.append(",'' OFC_TRNS_FLG" ).append("\n"); 
		query.append(",'' CHG_OFC_CD" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}