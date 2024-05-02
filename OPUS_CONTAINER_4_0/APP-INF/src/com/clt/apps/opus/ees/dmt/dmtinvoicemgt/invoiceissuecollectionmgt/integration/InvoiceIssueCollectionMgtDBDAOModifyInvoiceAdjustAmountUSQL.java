/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOModifyInvoiceAdjustAmountUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.28 
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

public class InvoiceIssueCollectionMgtDBDAOModifyInvoiceAdjustAmountUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Adjustment Request - After Booking Approval 에서 승인처리시 Charge Calculation 시 Invoice 를 계산된 결과로 갱신해주는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOModifyInvoiceAdjustAmountUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOModifyInvoiceAdjustAmountUSQL").append("\n"); 
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
		query.append("UPDATE	DMT_INV_MN INV_MN" ).append("\n"); 
		query.append("SET		INV_MN.AFT_INV_ADJ_AMT =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	SUM(CHG_CALC.BIL_AMT)" ).append("\n"); 
		query.append("FROM	DMT_INV_DTL INV_DTL" ).append("\n"); 
		query.append(",	DMT_CHG_CALC CHG_CALC" ).append("\n"); 
		query.append("WHERE	INV_DTL.DMDT_INV_NO = INV_MN.DMDT_INV_NO" ).append("\n"); 
		query.append("AND	CHG_CALC.SYS_AREA_GRP_ID = INV_DTL.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND CHG_CALC.CNTR_NO = INV_DTL.CNTR_NO" ).append("\n"); 
		query.append("AND CHG_CALC.CNTR_CYC_NO = INV_DTL.CNTR_CYC_NO" ).append("\n"); 
		query.append("AND	CHG_CALC.DMDT_TRF_CD = INV_DTL.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND CHG_CALC.DMDT_CHG_LOC_DIV_CD = INV_DTL.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("AND CHG_CALC.CHG_SEQ = INV_DTL.CHG_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE	INV_MN.DMDT_INV_NO IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT	DISTINCT(INV_MN2.DMDT_INV_NO)" ).append("\n"); 
		query.append("FROM	DMT_AFT_BKG_ADJ_RQST_DTL ADJ_RQST_DTL" ).append("\n"); 
		query.append(",	DMT_INV_MN INV_MN2" ).append("\n"); 
		query.append("WHERE	ADJ_RQST_DTL.AFT_EXPT_DAR_NO = @[aft_expt_dar_no]" ).append("\n"); 
		query.append("AND	ADJ_RQST_DTL.DMDT_TRF_CD = INV_MN2.DMDT_TRF_CD" ).append("\n"); 
		query.append("AND ADJ_RQST_DTL.BKG_NO = INV_MN2.BKG_NO" ).append("\n"); 
		query.append("AND NVL(INV_MN2.DMDT_INV_STS_CD, 'I') = 'I'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}