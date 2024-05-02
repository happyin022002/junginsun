/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAODmtInvMnVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.18 
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

public class InvoiceIssueCollectionMgtDBDAODmtInvMnVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DmtInvMnVO
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAODmtInvMnVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAODmtInvMnVORSQL").append("\n"); 
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
		query.append("TAX_RTO" ).append("\n"); 
		query.append(",	TAX_AMT" ).append("\n"); 
		query.append(",	INV_AMT" ).append("\n"); 
		query.append(",	'' AS TOT_AMT" ).append("\n"); 
		query.append(",	AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append(",	AFT_INV_ADJ_AMT" ).append("\n"); 
		query.append(",	CR_INV_NO" ).append("\n"); 
		query.append(",	'' AS CR_AR_IF_CD" ).append("\n"); 
		query.append(",	INV_RMK" ).append("\n"); 
		query.append(",	'' AS INV_RMK1" ).append("\n"); 
		query.append(",	'' AS INV_RMK2" ).append("\n"); 
		query.append(",	DMDT_AR_IF_CD" ).append("\n"); 
		query.append(",	AR_IF_NO" ).append("\n"); 
		query.append(",	AR_IF_DT" ).append("\n"); 
		query.append(",	AR_IF_USR_ID" ).append("\n"); 
		query.append(",	'' AS AR_IF_USR_NM" ).append("\n"); 
		query.append(",	AR_IF_OFC_CD" ).append("\n"); 
		query.append(",	NTC_KNT_CD" ).append("\n"); 
		query.append(",	DMDT_INV_STS_CD" ).append("\n"); 
		query.append(",	'' AS DMDT_INV_STS_DESC" ).append("\n"); 
		query.append(",	DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append(",	'' AS DMDT_CXL_RSN_NM" ).append("\n"); 
		query.append(",	CXL_RMK" ).append("\n"); 
		query.append(",	INV_HLD_RSN_CD" ).append("\n"); 
		query.append(",	'' AS INV_HLD_RSN_NM" ).append("\n"); 
		query.append(",	INV_HLD_RMK" ).append("\n"); 
		query.append(",	INV_PRT_FLG" ).append("\n"); 
		query.append(",	INV_REF_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	'' AS UPD_USR_NM" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	UPD_OFC_CD" ).append("\n"); 
		query.append(",	DMDT_INV_NO" ).append("\n"); 
		query.append(",	CRE_OFC_CD" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_TP_CD" ).append("\n"); 
		query.append(",	MNL_INP_FLG" ).append("\n"); 
		query.append(",	MNL_INV_SND_FLG" ).append("\n"); 
		query.append(",	DMDT_MNL_INV_RSN_CD" ).append("\n"); 
		query.append(",	'' AS DMDT_MNL_INV_RSN_NM" ).append("\n"); 
		query.append(",	MNL_INV_RMK" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	CUST_CNT_CD" ).append("\n"); 
		query.append(",	CUST_SEQ" ).append("\n"); 
		query.append(",	DMDT_PAYR_TP_CD" ).append("\n"); 
		query.append(",	ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append(",	ACT_PAYR_SEQ" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	CHG_CURR_CD" ).append("\n"); 
		query.append(",	ORG_CHG_AMT" ).append("\n"); 
		query.append(",	DMDT_EXPT_AMT" ).append("\n"); 
		query.append(",	DC_AMT" ).append("\n"); 
		query.append(",	BIL_AMT" ).append("\n"); 
		query.append(",	BKG_CNTR_QTY" ).append("\n"); 
		query.append(",	INV_CURR_CD" ).append("\n"); 
		query.append(",	INV_XCH_RT" ).append("\n"); 
		query.append(",	INV_CHG_AMT" ).append("\n"); 
		query.append(",	NTC_KNT_CD" ).append("\n"); 
		query.append(",	'' AS PAYR_CNTC_PNT_LIST" ).append("\n"); 
		query.append(",	DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",	'' AS PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append(",	'' AS PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append(",	'' AS PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append(",	'' AS ISSUE_DT" ).append("\n"); 
		query.append(",	'' AS ISSUE_OFC_CD" ).append("\n"); 
		query.append(",	'' AS ISSUE_USR_NM" ).append("\n"); 
		query.append(",	'' AS TRUCKER_CD" ).append("\n"); 
		query.append(",	'' AS VNDR_SEQ" ).append("\n"); 
		query.append(",	'' AS VNDR_NM" ).append("\n"); 
		query.append(",	'' AS TRUCKER_NM" ).append("\n"); 
		query.append(",	'' AS BKG_CUST_CD" ).append("\n"); 
		query.append(",	'' AS BKG_CUST_NM" ).append("\n"); 
		query.append(",	'' AS ACT_CUST_CD" ).append("\n"); 
		query.append(",	'' AS ACT_CUST_NM" ).append("\n"); 
		query.append(",	'' AS VVD_CD" ).append("\n"); 
		query.append(",	'' AS RCV_TERM_CD" ).append("\n"); 
		query.append(",	'' AS DE_TERM_CD" ).append("\n"); 
		query.append(",	'' AS ACT_PAYR_CUST_CD" ).append("\n"); 
		query.append(",	'' AS ACT_PAYR_CUST_NM" ).append("\n"); 
		query.append(",	'' AS CR_TERM_DYS" ).append("\n"); 
		query.append(",	'' AS ISS_DT_PRN_FLG" ).append("\n"); 
		query.append(",	'' AS DFLT_TAX_RTO" ).append("\n"); 
		query.append(",	'' AS DUE_DT" ).append("\n"); 
		query.append(",	'' AS OLD_DMDT_INV_NO" ).append("\n"); 
		query.append(",	'' AS ERR_CODE" ).append("\n"); 
		query.append(",	'' AS ERR_MSG" ).append("\n"); 
		query.append(",	'' AS CALLER" ).append("\n"); 
		query.append(",	'' AS BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append(",	'' AS CRE_CNT_CD" ).append("\n"); 
		query.append(",	'' AS CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append(",	'' AS SUTH_CHN_ISS_FLG" ).append("\n"); 
		query.append("FROM DMT_INV_MN" ).append("\n"); 

	}
}