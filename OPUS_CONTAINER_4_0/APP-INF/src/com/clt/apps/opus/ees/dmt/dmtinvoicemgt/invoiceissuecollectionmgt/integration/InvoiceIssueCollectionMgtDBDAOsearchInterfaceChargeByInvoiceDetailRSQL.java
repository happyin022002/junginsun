/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOsearchInterfaceChargeByInvoiceDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2014.11.11 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOsearchInterfaceChargeByInvoiceDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR_OFFICE_CD가 LEHBB가 아닐 경우 DTL->RT로 생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOsearchInterfaceChargeByInvoiceDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOsearchInterfaceChargeByInvoiceDetailRSQL").append("\n"); 
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
		query.append("SELECT '' AS SRC_IF_DT" ).append("\n"); 
		query.append("	   ,'' AS SRC_IF_SEQ" ).append("\n"); 
		query.append("	   ,ROWNUM AS CHG_SEQ" ).append("\n"); 
		query.append("       ,A.INV_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       ,CASE WHEN A.DMDT_TRF_CD = 'DMIF' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DMOF' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DTOC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DTIC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'CTOC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'CTIC' THEN 'DET'" ).append("\n"); 
		query.append("        END AS CHG_CD" ).append("\n"); 
		query.append("       ,B.CNTR_TPSZ_CD AS PER_TP_CD" ).append("\n"); 
		query.append("	   ,(B.CNTR_INV_AMT/B.FX_FT_OVR_DYS) AS TRF_RT_AMT" ).append("\n"); 
		query.append("       ,B.FX_FT_OVR_DYS AS RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("	   ,B.CNTR_INV_AMT AS CHG_AMT" ).append("\n"); 
		query.append("       ,B.CNTR_NO AS TRF_NO" ).append("\n"); 
		query.append("       ,CASE WHEN A.TAX_AMT <> 0 THEN 'Y'" ).append("\n"); 
		query.append("        END AS TVA_FLG" ).append("\n"); 
		query.append("       ,A.CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(A.CRE_DT,'yyyymmdd') AS CRE_DT" ).append("\n"); 
		query.append("       ,A.UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(A.UPD_DT,'yyyymmdd') AS UPD_DT" ).append("\n"); 
		query.append("FROM DMT_INV_MN A, DMT_INV_DTL B" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD 	= B.CRE_OFC_CD" ).append("\n"); 
		query.append("AND A.DMDT_INV_NO 	= @[invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD	= @[cre_ofc_cd]" ).append("\n"); 
		query.append("#if (${credit_note} == 'Y') " ).append("\n"); 
		query.append("AND B.FX_FT_OVR_DYS != 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}