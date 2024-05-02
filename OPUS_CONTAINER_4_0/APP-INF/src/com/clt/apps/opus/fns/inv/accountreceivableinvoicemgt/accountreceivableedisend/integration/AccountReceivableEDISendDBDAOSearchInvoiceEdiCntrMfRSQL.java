/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrMfRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrMfRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceEdiCntrMf
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrMfRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiCntrMfRSQL").append("\n"); 
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
		query.append("SELECT '{CM_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CMD_CD:' || NVL(HAMO_TRF_CD, NVL(CMDT_HS_CD, NCM_NO)) ||CHR(10) " ).append("\n"); 
		query.append("       || 'CMD_DESC:' || REPLACE(REPLACE(CNTR_MF_GDS_DESC,CHR(13)||CHR(10),CHR(10)),CHR(10), ' ') ||CHR(10) " ).append("\n"); 
		query.append("       || '{PKG_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CM_PKG_LVL:' ||'1'|| CHR(10) " ).append("\n"); 
		query.append("       || 'CM_PKG_QTY:' || PCK_QTY || CHR(10) " ).append("\n"); 
		query.append("       || 'CM_PKG_UNIT:' || PCK_TP_CD || CHR(10)" ).append("\n"); 
		query.append("       || 'CM_PKG_UNIT_DESC:' || (SELECT PCK_NM FROM MDM_PCK_TP WHERE PCK_CD = BC.PCK_TP_CD)|| CHR(10) " ).append("\n"); 
		query.append("       || '}PKG_INFO' || CHR(10) " ).append("\n"); 
		query.append("	   || '{MEA_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CM_MEA_TP_CD:' || 'GWT'|| CHR(10)" ).append("\n"); 
		query.append("       || 'CM_MEA_UNIT:' ||WGT_UT_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CM_MEA_QTY:' || CNTR_MF_WGT||CHR(10)    " ).append("\n"); 
		query.append("       || '}MEA_INFO' || CHR(10)" ).append("\n"); 
		query.append("       || '{MEA_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CM_MEA_TP_CD:' || 'GVOL'|| CHR(10)" ).append("\n"); 
		query.append("       || 'CM_MEA_UNIT:' ||MEAS_UT_CD ||CHR(10) " ).append("\n"); 
		query.append("       || 'CM_MEA_QTY:' || MEAS_QTY||CHR(10)    " ).append("\n"); 
		query.append("       || '}MEA_INFO' || CHR(10)" ).append("\n"); 
		query.append("       || '}CM_INFO' || CHR(10)" ).append("\n"); 
		query.append("FROM BKG_CNTR_MF_DESC BC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]  " ).append("\n"); 
		query.append("ORDER BY CNTR_MF_SEQ" ).append("\n"); 

	}
}