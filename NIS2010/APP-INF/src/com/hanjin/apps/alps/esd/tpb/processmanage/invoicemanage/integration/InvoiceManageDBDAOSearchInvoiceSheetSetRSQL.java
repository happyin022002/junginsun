/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : InvoiceManageDBDAOSearchInvoiceSheetSetRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceManageDBDAOSearchInvoiceSheetSetRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchInvoiceSheetSet
	  * </pre>
	  */
	public InvoiceManageDBDAOSearchInvoiceSheetSetRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration").append("\n"); 
		query.append("FileName : InvoiceManageDBDAOSearchInvoiceSheetSetRSQL").append("\n"); 
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
		query.append("SELECT   TS.INV_ISS_OFC_CD AS S_INV_ISS_OFC_CD" ).append("\n"); 
		query.append("       , TS.CO_NM" ).append("\n"); 
		query.append("       , TS.OFC_ADDR" ).append("\n"); 
		query.append("       , TS.OFC_PHN_NO" ).append("\n"); 
		query.append("       , TS.OFC_FAX_NO" ).append("\n"); 
		query.append("       , TS.BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append("       , TS.INV_RMK1" ).append("\n"); 
		query.append("       , TS.INV_RMK2" ).append("\n"); 
		query.append("       , TS.VAT_XCH_RT" ).append("\n"); 
		query.append("       , TS.VAT_XCH_RT / 100 AS VAT_XCH_RT_DIV" ).append("\n"); 
		query.append("	   , TS.EUR_VAT_REF_NO" ).append("\n"); 
		query.append("       , S.IDA_STE_CD" ).append("\n"); 
		query.append("       , C.IDA_GST_RGST_NO" ).append("\n"); 
		query.append("       , C.IDA_PAN_NO" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT1 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_BANK_ACCT_NO" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT2 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_IFSC_CD" ).append("\n"); 
		query.append("       , ( SELECT ATTR_CTNT3 FROM DMT_HRD_CDG_CTNT WHERE HRD_CDG_ID = 'IDA_TAX_INFO' ) AS IDA_TAX_CIN_NO" ).append("\n"); 
		query.append("FROM     TPB_INV_SH_SET TS" ).append("\n"); 
		query.append("       , MDM_ORGANIZATION O" ).append("\n"); 
		query.append("       , MDM_CUSTOMER C" ).append("\n"); 
		query.append("       , MDM_LOCATION L" ).append("\n"); 
		query.append("       , MDM_STATE S" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      TS.INV_ISS_OFC_CD = O.OFC_CD" ).append("\n"); 
		query.append("AND      O.REP_CUST_CNT_CD = C.CUST_CNT_CD" ).append("\n"); 
		query.append("AND      O.REP_CUST_SEQ = C.CUST_SEQ" ).append("\n"); 
		query.append("AND      C.LOC_CD = L.LOC_CD" ).append("\n"); 
		query.append("AND      L.CNT_CD = S.CNT_CD(+)" ).append("\n"); 
		query.append("AND      L.STE_CD = S.STE_CD(+)" ).append("\n"); 
		query.append("AND      TS.INV_ISS_OFC_CD = @[s_inv_iss_ofc_cd]" ).append("\n"); 

	}
}