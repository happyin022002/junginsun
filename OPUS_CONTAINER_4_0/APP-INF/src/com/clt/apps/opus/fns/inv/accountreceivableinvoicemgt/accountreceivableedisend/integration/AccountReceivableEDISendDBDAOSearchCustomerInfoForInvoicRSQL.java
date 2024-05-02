/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchCustomerInfoForInvoicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchCustomerInfoForInvoicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCustomerInfoForInvoic
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchCustomerInfoForInvoicRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration ").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchCustomerInfoForInvoicRSQL").append("\n"); 
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
		query.append("SELECT   DISTINCT" ).append("\n"); 
		query.append("         BCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("       , BCUST.CUST_SEQ" ).append("\n"); 
		query.append("       , BKG_TOKEN_NL_FNC(CUST_NM, 1, '') AS CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("       , BKG_TOKEN_NL_FNC(CUST_NM, 2, '') AS CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append("       , BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 1, '') AS LOCL_ADDR1" ).append("\n"); 
		query.append("       , BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 2, '') AS LOCL_ADDR2" ).append("\n"); 
		query.append("       , BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 3, '') || BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 4, '') || BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 5, '')  AS LOCL_ADDR3" ).append("\n"); 
		query.append("       , ADDR.CNTC_PSON_NM AS CNTC_PSON_NM" ).append("\n"); 
		query.append("       , CNTC.PHN_NO AS PHN_NO" ).append("\n"); 
		query.append("       , CNTC.FAX_NO AS FAX_NO" ).append("\n"); 
		query.append("       , CNTC.CUST_EML AS CUST_EML" ).append("\n"); 
		query.append("       , BCUST.CUST_ADDR AS  ADDR   " ).append("\n"); 
		query.append("       , BCUST.CUST_CTY_NM AS CTY_NM                                        " ).append("\n"); 
		query.append("       , BCUST.CUST_ZIP_ID AS ZIP_CD                                        " ).append("\n"); 
		query.append("       , (SELECT CUST_RGST_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = BCUST.CUST_CNT_CD AND CUST_SEQ = BCUST.CUST_SEQ) AS CUST_RGST_NO              " ).append("\n"); 
		query.append("       , BCUST.CUST_STE_CD AS STE_CD " ).append("\n"); 
		query.append("       , BCUST.BKG_CUST_TP_CD AS IBCS_TP" ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER BCUST," ).append("\n"); 
		query.append("       MDM_CUST_ADDR ADDR," ).append("\n"); 
		query.append("       MDM_CUST_CNTC_PNT CNTC," ).append("\n"); 
		query.append("       INV_EDI_HDR IEH" ).append("\n"); 
		query.append(" WHERE BCUST.CUST_CNT_CD = ADDR.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND BCUST.CUST_SEQ = ADDR.CUST_SEQ" ).append("\n"); 
		query.append("   AND BCUST.CUST_CNT_CD = CNTC.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND BCUST.CUST_SEQ = CNTC.CUST_SEQ" ).append("\n"); 
		query.append("   AND ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("   AND CNTC.CUST_CNTC_PNT_SEQ = 1" ).append("\n"); 
		query.append("   AND BCUST.BKG_CUST_TP_CD IN ('A','C','E','F','N','S')" ).append("\n"); 
		query.append("   AND BCUST.CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND BCUST.CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("   AND IEH.EDI_HDR_SEQ IN (${edi_hdr_seq_list})" ).append("\n"); 
		query.append("   AND IEH.BKG_NO = BCUST.BKG_NO" ).append("\n"); 

	}
}