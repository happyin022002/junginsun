/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceDetailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.20 
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

public class InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceDetailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice No. 로 Invoice  Detail 정보를 조회하는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceDetailListRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceDetailListRSQL").append("\n"); 
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
		query.append("SELECT	DMDT_INV_NO" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	INV_DTL_SEQ" ).append("\n"); 
		query.append(",	SYS_AREA_GRP_ID" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CNTR_CYC_NO" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append(",	CHG_SEQ" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	TO_CHAR(FM_MVMT_DT, 'YYYY-MM-DD') FM_MVMT_DT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_MVMT_DT, 'YYYY-MM-DD') TO_MVMT_DT" ).append("\n"); 
		query.append(",	FT_DYS" ).append("\n"); 
		query.append(",	TO_CHAR(FT_CMNC_DT, 'YYYY-MM-DD') FT_CMNC_DT" ).append("\n"); 
		query.append(",	TO_CHAR(FT_END_DT, 'YYYY-MM-DD') FT_END_DT" ).append("\n"); 
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
		query.append("FROM	DMT_INV_DTL" ).append("\n"); 
		query.append("WHERE	DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("ORDER BY INV_DTL_SEQ" ).append("\n"); 

	}
}