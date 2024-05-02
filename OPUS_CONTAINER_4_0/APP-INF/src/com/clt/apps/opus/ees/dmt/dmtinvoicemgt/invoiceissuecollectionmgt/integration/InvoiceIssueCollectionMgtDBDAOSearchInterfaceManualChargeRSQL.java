/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceManualChargeRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchInterfaceManualChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Manual Detail 이 존재하지 않을때 Interface Charge 데이터 생성
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInterfaceManualChargeRSQL(){
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
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceManualChargeRSQL").append("\n"); 
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
		query.append("	   ,1 AS CHG_SEQ" ).append("\n"); 
		query.append("       ,(SELECT AR_CURR_CD FROM MDM_ORGANIZATION WHERE DELT_FLG = 'N' AND OFC_CD = A.CRE_OFC_CD) AS CURR_CD" ).append("\n"); 
		query.append("       ,CASE WHEN A.DMDT_TRF_CD = 'DMIF' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DMOF' THEN 'DEM'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DTOC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'DTIC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'CTOC' THEN 'DET'" ).append("\n"); 
		query.append("             WHEN A.DMDT_TRF_CD = 'CTIC' THEN 'DET'" ).append("\n"); 
		query.append("        END AS CHG_CD" ).append("\n"); 
		query.append("       ,'' AS PER_TP_CD		--container type size cd" ).append("\n"); 
		query.append("	   ,A.INV_CHG_AMT AS TRF_RT_AMT" ).append("\n"); 
		query.append("       ,1 AS RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("	   ,A.INV_CHG_AMT AS CHG_AMT" ).append("\n"); 
		query.append("       ,'' AS TRF_NO		--container no" ).append("\n"); 
		query.append("       ,CASE WHEN A.TAX_AMT <> 0 THEN 'Y'" ).append("\n"); 
		query.append("        END AS TVA_FLG" ).append("\n"); 
		query.append("       ,A.CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(A.CRE_DT,'yyyymmdd') AS CRE_DT" ).append("\n"); 
		query.append("       ,A.UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(A.UPD_DT,'yyyymmdd') AS UPD_DT" ).append("\n"); 
		query.append("FROM DMT_INV_MN A" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}