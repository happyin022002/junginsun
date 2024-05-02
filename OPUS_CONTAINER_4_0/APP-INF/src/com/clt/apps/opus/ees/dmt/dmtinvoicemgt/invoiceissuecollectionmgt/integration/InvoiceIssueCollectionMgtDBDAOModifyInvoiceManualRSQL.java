/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOModifyInvoiceManualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.11.19 김태균
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

public class InvoiceIssueCollectionMgtDBDAOModifyInvoiceManualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue - Booking (UPDATE)
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOModifyInvoiceManualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration ").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOModifyInvoiceManualRSQL").append("\n"); 
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
		query.append("UPDATE DMT_INV_MN" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("TAX_RTO = @[tax_rto]" ).append("\n"); 
		query.append(",	TAX_AMT = @[tax_amt]" ).append("\n"); 
		query.append(",	INV_AMT = @[inv_amt]" ).append("\n"); 
		query.append(",	INV_RMK = @[inv_rmk1]||chr(10)||@[inv_rmk2]" ).append("\n"); 
		query.append(",	NTC_KNT_CD = @[ntc_knt_cd]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE)" ).append("\n"); 
		query.append(",	UPD_OFC_CD = @[upd_ofc_cd]" ).append("\n"); 
		query.append(",	ACT_PAYR_CNT_CD = @[act_payr_cnt_cd]" ).append("\n"); 
		query.append(",	ACT_PAYR_SEQ = @[act_payr_seq]" ).append("\n"); 
		query.append(",	DMDT_PAYR_CNTC_PNT_NM = @[dmdt_payr_cntc_pnt_nm]" ).append("\n"); 
		query.append(",	DC_AMT = @[dc_amt]" ).append("\n"); 
		query.append(",	BIL_AMT = @[bil_amt]" ).append("\n"); 
		query.append(",	INV_XCH_RT = @[inv_xch_rt]" ).append("\n"); 
		query.append(",	INV_CHG_AMT = @[inv_chg_amt]" ).append("\n"); 
		query.append(",	INV_REF_NO = @[inv_ref_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${caller} != '4004')" ).append("\n"); 
		query.append(",	ORG_CHG_AMT = @[org_chg_amt]" ).append("\n"); 
		query.append(",	DMDT_EXPT_AMT = @[dmdt_expt_amt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${caller} == '4004')" ).append("\n"); 
		query.append(",	VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append(",	SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append(",	SKD_DIR_CD = SUBSTR(@[vvd_cd], 9)" ).append("\n"); 
		query.append(",	POR_CD = @[por_cd]" ).append("\n"); 
		query.append(",	POL_CD = @[pol_cd]" ).append("\n"); 
		query.append(",	POD_CD = @[pod_cd]" ).append("\n"); 
		query.append(",	DEL_CD = @[del_cd]" ).append("\n"); 
		query.append(",	DMDT_MNL_INV_RSN_CD = @[dmdt_mnl_inv_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${caller} == '4004' || ${caller} == '4016')" ).append("\n"); 
		query.append(",	MNL_INV_RMK = @[mnl_inv_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	DMDT_INV_NO = @[dmdt_inv_no]" ).append("\n"); 
		query.append("AND	CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}