/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOInterfaceChargeCalculationVORSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOInterfaceChargeCalculationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR IF CHARGE CALCULATION
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOInterfaceChargeCalculationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOInterfaceChargeCalculationVORSQL").append("\n"); 
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
		query.append("SELECT '' SRC_IF_DT" ).append("\n"); 
		query.append(",'' SRC_IF_SEQ" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' CURR_CD" ).append("\n"); 
		query.append(",'' CHG_CD" ).append("\n"); 
		query.append(",'' PER_TP_CD" ).append("\n"); 
		query.append(",'' TRF_NO" ).append("\n"); 
		query.append(",'' TVA_FLG" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append(",'' SVR_ID" ).append("\n"); 
		query.append(",'' CNTR_NO" ).append("\n"); 
		query.append(",'' CNTR_CYC_NO" ).append("\n"); 
		query.append(",'' DMDT_TRF_CD" ).append("\n"); 
		query.append(",'' DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",'' CHG_SEQ" ).append("\n"); 
		query.append(",'' DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",'' BZC_TRF_SEQ" ).append("\n"); 
		query.append(",'' BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",'' CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",'' FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",'' RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",'' RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",'' RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append(",'' SC_NO" ).append("\n"); 
		query.append(",'' SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",'' SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",'' INV_DTL_SEQ" ).append("\n"); 
		query.append(",'' CRE_OFC_CD" ).append("\n"); 
		query.append(",'' INV_XCH_RT" ).append("\n"); 
		query.append(",'' SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(",'' AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",'' ORG_FT_OVR_DYS" ).append("\n"); 
		query.append(",'' CMDT_EXPT_AMT" ).append("\n"); 
		query.append(",'' DUL_TP_EXPT_FLG" ).append("\n"); 
		query.append(",'' OFC_TRNS_FLG" ).append("\n"); 
		query.append(",'' BKG_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}