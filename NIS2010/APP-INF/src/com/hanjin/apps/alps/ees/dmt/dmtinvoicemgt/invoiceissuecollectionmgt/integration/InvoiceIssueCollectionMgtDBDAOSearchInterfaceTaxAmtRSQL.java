/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceTaxAmtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.25 
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

public class InvoiceIssueCollectionMgtDBDAOSearchInterfaceTaxAmtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tax Amt Search
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchInterfaceTaxAmtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceTaxAmtRSQL").append("\n"); 
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
		query.append("SELECT A.DMDT_INV_NO" ).append("\n"); 
		query.append("	,'' AS SRC_IF_DT" ).append("\n"); 
		query.append("	,'' AS SRC_IF_SEQ" ).append("\n"); 
		query.append("	,@[chg_seq] AS CHG_SEQ" ).append("\n"); 
		query.append("	,A.INV_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("	,CASE @[chg_flg] WHEN 'T' THEN DECODE((SELECT AR_OFC_CD  FROM MDM_ORGANIZATION WHERE OFC_CD = @[ar_ofc_cd]),'VLCSC','IVA','SYDSC','AST','TVA') " ).append("\n"); 
		query.append("                     WHEN 'S' THEN 'SBC' " ).append("\n"); 
		query.append("                     WHEN 'K' THEN 'KKC' END AS CHG_CD" ).append("\n"); 
		query.append("	,'BL' AS PER_TP_CD" ).append("\n"); 
		query.append("	,CASE @[chg_flg] WHEN 'T' THEN A.TAX_AMT" ).append("\n"); 
		query.append("                     WHEN 'S' THEN A.IDA_LOCL_TAX" ).append("\n"); 
		query.append("                     WHEN 'K' THEN A.IDA_N2ND_LOCL_TAX END AS TRF_RT_AMT" ).append("\n"); 
		query.append("	,1 AS RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("	,CASE @[chg_flg] WHEN 'T' THEN A.TAX_AMT" ).append("\n"); 
		query.append("                     WHEN 'S' THEN A.IDA_LOCL_TAX" ).append("\n"); 
		query.append("                     WHEN 'K' THEN A.IDA_N2ND_LOCL_TAX END AS CHG_AMT" ).append("\n"); 
		query.append("	,'' AS TRF_NO" ).append("\n"); 
		query.append("	,'N' TVA_FLG" ).append("\n"); 
		query.append("	,'N' SBC_FLG" ).append("\n"); 
		query.append("	,'N' KKC_FLG" ).append("\n"); 
		query.append("	,A.CRE_USR_ID" ).append("\n"); 
		query.append("	,TO_CHAR(A.CRE_DT,'yyyymmdd') AS CRE_DT" ).append("\n"); 
		query.append("	,A.UPD_USR_ID" ).append("\n"); 
		query.append("	,TO_CHAR(A.UPD_DT,'yyyymmdd') AS UPD_DT" ).append("\n"); 
		query.append("FROM DMT_INV_MN A" ).append("\n"); 
		query.append("WHERE A.DMDT_INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("AND A.CRE_OFC_CD = @[cre_ofc_cd]" ).append("\n"); 

	}
}