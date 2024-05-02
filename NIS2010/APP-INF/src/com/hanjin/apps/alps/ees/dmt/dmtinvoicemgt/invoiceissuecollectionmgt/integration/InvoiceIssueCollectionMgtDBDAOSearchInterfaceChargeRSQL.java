/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.07 
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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_tax_appl_tm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
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
		query.append("SELECT  '' 								AS SRC_IF_DT" ).append("\n"); 
		query.append("	   ,'' 								AS SRC_IF_SEQ" ).append("\n"); 
		query.append("	   ,T3.INV_RT_SEQ 					AS CHG_SEQ" ).append("\n"); 
		query.append("       ,T3.BZC_CURR_CD 					AS CURR_CD" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(T1.DMDT_TRF_CD, 1, 2), 'DM', 'DMR', 'DT', 'DTC', 'CT', 'CDD', '')	AS CHG_CD" ).append("\n"); 
		query.append("       ,T2.CNTR_TPSZ_CD 				AS PER_TP_CD" ).append("\n"); 
		query.append("	   ,T3.INV_RT_AMT 					AS TRF_RT_AMT" ).append("\n"); 
		query.append("       ,T3.RT_OVR_DYS 					AS RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("	   ,T3.RT_OVR_CHG_AMT 				AS CHG_AMT" ).append("\n"); 
		query.append("       ,T2.CNTR_NO 						AS TRF_NO" ).append("\n"); 
		query.append("       ,DECODE(T1.TAX_AMT, 0, 'N', 'Y') AS TVA_FLG" ).append("\n"); 
		query.append("       ,T3.CRE_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(T3.CRE_DT,'yyyymmdd') 	AS CRE_DT" ).append("\n"); 
		query.append("       ,T3.UPD_USR_ID" ).append("\n"); 
		query.append("       ,TO_CHAR(T3.UPD_DT,'yyyymmdd') 	AS UPD_DT" ).append("\n"); 
		query.append("	   ,CASE " ).append("\n"); 
		query.append("			-- 인도 TAX 변경 후에는 SBC AMOUNT 가 존재하지 않음." ).append("\n"); 
		query.append("			WHEN @[ida_tax_appl_tm] = 'A'" ).append("\n"); 
		query.append("				THEN 'N'" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("					WHEN NVL(T1.IDA_LOCL_TAX,0) <> 0 " ).append("\n"); 
		query.append("						THEN 'Y'" ).append("\n"); 
		query.append("					ELSE 'N'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("		END 							AS SBC_FLG" ).append("\n"); 
		query.append("	   ,CASE " ).append("\n"); 
		query.append("			-- 인도 TAX 변경 후에는 KKC AMOUNT 가 존재하지 않음." ).append("\n"); 
		query.append("			WHEN @[ida_tax_appl_tm] = 'A'" ).append("\n"); 
		query.append("				THEN 'N'" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("					WHEN NVL(T1.IDA_N2ND_LOCL_TAX,0) <> 0 " ).append("\n"); 
		query.append("						THEN 'Y'" ).append("\n"); 
		query.append("					ELSE 'N'" ).append("\n"); 
		query.append("				END" ).append("\n"); 
		query.append("		END 							AS KKC_FLG	   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM  DMT_INV_MN 		T1" ).append("\n"); 
		query.append("       ,DMT_INV_DTL 	T2" ).append("\n"); 
		query.append("	   ,DMT_INV_RT 		T3" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" WHERE  T1.DMDT_INV_NO = T2.DMDT_INV_NO" ).append("\n"); 
		query.append("   AND  T1.CRE_OFC_CD  = T2.CRE_OFC_CD" ).append("\n"); 
		query.append("   AND  T2.DMDT_INV_NO = T3.DMDT_INV_NO" ).append("\n"); 
		query.append("   AND  T2.CRE_OFC_CD  = T3.CRE_OFC_CD" ).append("\n"); 
		query.append("   AND  T2.INV_DTL_SEQ = T3.INV_DTL_SEQ" ).append("\n"); 
		query.append("   AND  T1.DMDT_INV_NO = @[invoice_no]" ).append("\n"); 
		query.append("   AND  T1.CRE_OFC_CD  = @[cre_ofc_cd]" ).append("\n"); 

	}
}