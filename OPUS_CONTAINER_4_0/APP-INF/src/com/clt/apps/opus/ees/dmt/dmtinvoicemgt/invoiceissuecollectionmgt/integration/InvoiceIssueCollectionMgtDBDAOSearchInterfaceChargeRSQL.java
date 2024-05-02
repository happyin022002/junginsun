/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV A/R INVOICE INTERFACE CHARGE
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeRSQL(){
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
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeRSQL").append("\n"); 
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
		query.append("	   ,C.INV_RT_SEQ AS CHG_SEQ" ).append("\n"); 
		query.append("       ,C.BZC_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       ,CASE WHEN A.DMDT_TRF_CD = 'DMIF' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DMOF' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DTOC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DTIC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'CTOC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'CTIC' THEN 'DET'" ).append("\n"); 
		query.append("        END AS CHG_CD" ).append("\n"); 
		query.append("       ,B.CNTR_TPSZ_CD AS PER_TP_CD" ).append("\n"); 
		query.append("	   ,C.INV_RT_AMT AS TRF_RT_AMT" ).append("\n"); 
		query.append("       ,C.RT_OVR_DYS AS RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("	   ,C.RT_OVR_CHG_AMT AS CHG_AMT" ).append("\n"); 
		query.append("       ,B.CNTR_NO AS TRF_NO" ).append("\n"); 
		query.append("       ,CASE WHEN A.TAX_AMT <> 0 THEN 'Y'" ).append("\n"); 
		query.append("        END AS TVA_FLG" ).append("\n"); 
		query.append("       ,C.CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(C.CRE_DT,'yyyymmdd') AS CRE_DT" ).append("\n"); 
		query.append("       ,C.UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(C.UPD_DT,'yyyymmdd') AS UPD_DT" ).append("\n"); 
		query.append("FROM DMT_INV_MN A, DMT_INV_DTL B, DMT_INV_RT C" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = B.DMDT_INV_NO" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = B.CRE_OFC_CD" ).append("\n"); 
		query.append("AND B.DMDT_INV_NO = C.DMDT_INV_NO" ).append("\n"); 
		query.append("AND B.CRE_OFC_CD  = C.CRE_OFC_CD" ).append("\n"); 
		query.append("AND B.INV_DTL_SEQ = C.INV_DTL_SEQ" ).append("\n"); 
		query.append("AND A.DMDT_INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}