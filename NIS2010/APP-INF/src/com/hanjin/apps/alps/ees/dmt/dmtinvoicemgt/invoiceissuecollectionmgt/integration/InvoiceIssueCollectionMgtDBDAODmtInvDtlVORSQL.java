/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAODmtInvDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.20 
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

public class InvoiceIssueCollectionMgtDBDAODmtInvDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAODmtInvDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAODmtInvDtlVORSQL").append("\n"); 
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
		query.append("SELECT 	DMDT_INV_NO" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	INV_DTL_SEQ" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_CYC_NO" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	CHG_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	FM_MVMT_DT" ).append("\n"); 
		query.append(",	TO_MVMT_DT" ).append("\n"); 
		query.append(",	FT_DYS" ).append("\n"); 
		query.append(",	FT_CMNC_DT" ).append("\n"); 
		query.append(",	FT_END_DT" ).append("\n"); 
		query.append(",	FX_FT_OVR_DYS" ).append("\n"); 
		query.append(",	XCLD_SAT_FLG" ).append("\n"); 
		query.append(",	XCLD_SUN_FLG" ).append("\n"); 
		query.append(",	XCLD_HOL_FLG" ).append("\n"); 
		query.append(",	ORG_CHG_AMT" ).append("\n"); 
		query.append(",	SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append(",	AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append(",	BIL_AMT" ).append("\n"); 
		query.append(",	CNTR_INV_AMT" ).append("\n"); 
		query.append(",	TAX_RTO" ).append("\n"); 
		query.append(",	TAX_AMT" ).append("\n"); 
		query.append(",	INV_PRT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	'' AS OLD_DMT_INV_NO" ).append("\n"); 
		query.append(",	'' AS BKG_NO" ).append("\n"); 
		query.append(",	'' AS SC_NO" ).append("\n"); 
		query.append(",	'' AS DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append(",	'' AS OFC_TRNS_FLG" ).append("\n"); 
		query.append(",	'' AS BZC_TRF_SEQ" ).append("\n"); 
		query.append(",	'' AS BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append(",	'' AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append(",	'' AS SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	'' AS SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append(",	'' AS RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append(",	'' AS RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append(",	'' AS RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append(",	'' AS RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("FROM DMT_INV_DTL" ).append("\n"); 

	}
}