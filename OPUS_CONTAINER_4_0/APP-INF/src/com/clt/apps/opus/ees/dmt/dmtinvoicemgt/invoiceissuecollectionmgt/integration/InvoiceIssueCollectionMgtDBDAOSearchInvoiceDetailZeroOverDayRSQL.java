/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailZeroOverDayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.29
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2010.07.29 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM TAE KYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailZeroOverDayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice detail 중 FX_FT_OVR_DYS가 0 인 건수 조회
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailZeroOverDayRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailZeroOverDayRSQL").append("\n"); 
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
		query.append("SELECT CNTR_NO FROM DMT_INV_DTL" ).append("\n"); 
		query.append("WHERE DMDT_INV_NO 	= @[dmdt_inv_no]" ).append("\n"); 
		query.append("AND CRE_OFC_CD 		= @[cre_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(FX_FT_OVR_DYS,0) = 0" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CNTR_NO FROM DMT_CHG_CALC" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("(SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ) " ).append("\n"); 
		query.append("	IN " ).append("\n"); 
		query.append("(SELECT SYS_AREA_GRP_ID, CNTR_NO, CNTR_CYC_NO, DMDT_TRF_CD, DMDT_CHG_LOC_DIV_CD, CHG_SEQ " ).append("\n"); 
		query.append(" FROM DMT_INV_DTL " ).append("\n"); 
		query.append(" WHERE DMDT_INV_NO 	= @[dmdt_inv_no]" ).append("\n"); 
		query.append(" AND CRE_OFC_CD 	= @[cre_ofc_cd])" ).append("\n"); 
		query.append("AND DMDT_CHG_STS_CD = 'I'" ).append("\n"); 
		query.append("AND FX_FT_OVR_DYS = 0" ).append("\n"); 

	}
}