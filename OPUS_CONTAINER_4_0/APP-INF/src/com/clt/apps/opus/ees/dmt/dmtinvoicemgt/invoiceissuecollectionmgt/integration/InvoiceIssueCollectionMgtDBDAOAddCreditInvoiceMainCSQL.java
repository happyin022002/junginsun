/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceMainCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.01 
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

public class InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceMainCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Cancel Reason Entry
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceMainCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cr_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_cxl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceMainCSQL").append("\n"); 
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
		query.append("INSERT INTO DMT_INV_MN (" ).append("\n"); 
		query.append("	TAX_RTO" ).append("\n"); 
		query.append(",	TAX_AMT" ).append("\n"); 
		query.append(",	INV_AMT" ).append("\n"); 
		query.append(",	AFT_EXPT_APRO_NO" ).append("\n"); 
		query.append(",	AFT_INV_ADJ_AMT" ).append("\n"); 
		query.append(",	CR_INV_NO" ).append("\n"); 
		query.append(",	INV_RMK" ).append("\n"); 
		query.append(",	DMDT_AR_IF_CD" ).append("\n"); 
		query.append(",	AR_IF_NO" ).append("\n"); 
		query.append(",	AR_IF_DT" ).append("\n"); 
		query.append(",	AR_IF_USR_ID" ).append("\n"); 
		query.append(",	AR_IF_OFC_CD" ).append("\n"); 
		query.append(",	NTC_KNT_CD" ).append("\n"); 
		query.append(",	DMDT_INV_STS_CD" ).append("\n"); 
		query.append(",	DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append(",	CXL_RMK" ).append("\n"); 
		query.append(",	INV_HLD_RSN_CD" ).append("\n"); 
		query.append(",	INV_HLD_RMK" ).append("\n"); 
		query.append(",	INV_PRT_FLG" ).append("\n"); 
		query.append(",	INV_REF_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
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
		query.append(",	DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
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
		query.append(") " ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("	TAX_RTO" ).append("\n"); 
		query.append(",	0 - TAX_AMT" ).append("\n"); 
		query.append(",	0 - INV_AMT" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	0" ).append("\n"); 
		query.append(",	@[cr_inv_no]		" ).append("\n"); 
		query.append(",	INV_RMK" ).append("\n"); 
		query.append(",	'N'" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	'C'" ).append("\n"); 
		query.append(",	@[dmdt_cxl_rsn_cd]" ).append("\n"); 
		query.append(",	@[cxl_rmk]" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	NULL" ).append("\n"); 
		query.append(",	INV_PRT_FLG" ).append("\n"); 
		query.append(",	INV_REF_NO" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	SYSDATE" ).append("\n"); 
		query.append(",	@[upd_ofc_cd]" ).append("\n"); 
		query.append(",	@[dmdt_inv_no]		" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]" ).append("\n"); 
		query.append(",	DMDT_TRF_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	DMDT_CHG_TP_CD" ).append("\n"); 
		query.append(",	MNL_INP_FLG" ).append("\n"); 
		query.append(",	MNL_INV_SND_FLG" ).append("\n"); 
		query.append(",	DMDT_MNL_INV_RSN_CD" ).append("\n"); 
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
		query.append(",	DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	SC_NO" ).append("\n"); 
		query.append(",	RFA_NO" ).append("\n"); 
		query.append(",	CHG_CURR_CD" ).append("\n"); 
		query.append(",	0 - ORG_CHG_AMT" ).append("\n"); 
		query.append(",	0 - DMDT_EXPT_AMT" ).append("\n"); 
		query.append(",	0 - DC_AMT" ).append("\n"); 
		query.append(",	0 - BIL_AMT" ).append("\n"); 
		query.append(",	BKG_CNTR_QTY" ).append("\n"); 
		query.append(",	INV_CURR_CD" ).append("\n"); 
		query.append(",	INV_XCH_RT" ).append("\n"); 
		query.append(",	0 - INV_CHG_AMT" ).append("\n"); 
		query.append("FROM DMT_INV_MN" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	DMDT_INV_NO = @[old_dmdt_inv_no]	" ).append("\n"); 
		query.append("AND CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}