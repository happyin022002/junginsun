/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.27 
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

public class AccountReceivableEDISendDBDAOSearchInvoiceEdiCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchInvoiceEdiCustInfo
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchInvoiceEdiCustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchInvoiceEdiCustInfoRSQL").append("\n"); 
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
		query.append("SELECT '{CUST_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_TP_CD:' || BKG_CUST_TP_CD|| CHR(10) " ).append("\n"); 
		query.append("	   || 'CUST_NM:' || REPLACE(REPLACE(CUST_NM,CHR(13)||CHR(10),CHR(10)),CHR(10), ' ') ||CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_TAX_NO:' ||(SELECT CUST_RGST_NO FROM MDM_CUSTOMER WHERE CUST_CNT_CD = BCUST.CUST_CNT_CD AND CUST_SEQ = BCUST.CUST_SEQ) || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_BK_REMIT:' ||(SELECT BANK_ACCT_NO FROM MDM_CR_CUST WHERE CUST_CNT_CD = BCUST.CUST_CNT_CD AND CUST_SEQ = BCUST.CUST_SEQ) || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR1:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 1, '')|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR2:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 2, '')|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_ADDR3:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 3, '')|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR4:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 4, '')|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_ADDR5:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_ADDR, 5, '')|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_CITY:' || BCUST.CUST_CTY_NM || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_STATE:' ||BCUST.CUST_STE_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ZIP:' ||BCUST.CUST_ZIP_ID|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CNT_CD:' ||BCUST.CUST_CNT_CD|| CHR(10) " ).append("\n"); 
		query.append("       || '{CONTACT_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_NM:' ||ADDR.CNTC_PSON_NM|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_DEPT:' || ''|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_EMAIL:' ||CNTC.CUST_EML|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_FAX:' ||CNTC.FAX_NO|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_TEL:' || CNTC.PHN_NO||CHR(10) " ).append("\n"); 
		query.append("       || '}CONTACT_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{CUST_CD_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CD_TP_CD:' ||'CC'|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CD:' ||BCUST.CUST_CNT_CD||BCUST.CUST_SEQ || CHR(10) " ).append("\n"); 
		query.append("       || '}CUST_CD_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{REGULATORY_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DUNS:' || ''||CHR(10) " ).append("\n"); 
		query.append("       || '}REGULATORY_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '}CUST_INFO' || CHR(10) " ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER BCUST," ).append("\n"); 
		query.append("       MDM_CUST_ADDR ADDR," ).append("\n"); 
		query.append("       MDM_CUST_CNTC_PNT CNTC" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BCUST.CUST_CNT_CD = ADDR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND BCUST.CUST_SEQ = ADDR.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND BCUST.CUST_CNT_CD = CNTC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND BCUST.CUST_SEQ = CNTC.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND ADDR.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("   AND CNTC.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("   AND BCUST.BKG_CUST_TP_CD IN ('A','C','E','F','N','S')" ).append("\n"); 
		query.append("   AND BCUST.CUST_CNT_CD IS NOT NULL" ).append("\n"); 
		query.append("   AND BCUST.CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '{CUST_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_TP_CD:' || 'P'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'CUST_NM:' || REPLACE(REPLACE(MCUST.CUST_LGL_ENG_NM,CHR(13)||CHR(10),CHR(10)),CHR(10), ' ') ||CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_TAX_NO:' ||MCUST.CUST_RGST_NO || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_BK_REMIT:' ||(SELECT BANK_ACCT_NO FROM MDM_CR_CUST WHERE CUST_CNT_CD = MCUST.CUST_CNT_CD AND CUST_SEQ = MCUST.CUST_SEQ) || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR1:' ||ADDR.LOCL_ADDR1|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR2:' ||ADDR.LOCL_ADDR2|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_ADDR3:' ||ADDR.LOCL_ADDR3|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR4:' ||ADDR.LOCL_ADDR4|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_ADDR5:' ||''|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_CITY:' || ADDR.CTY_NM || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_STATE:' ||ADDR.STE_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ZIP:' ||ADDR.ZIP_CD|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CNT_CD:' ||MCUST.CUST_CNT_CD|| CHR(10) " ).append("\n"); 
		query.append("       || '{CONTACT_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_NM:' ||ADDR.CNTC_PSON_NM|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_DEPT:' || ''|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_EMAIL:' ||CNTC.CUST_EML|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_FAX:' ||CNTC.FAX_NO|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_TEL:' || CNTC.PHN_NO||CHR(10) " ).append("\n"); 
		query.append("       || '}CONTACT_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{CUST_CD_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CD_TP_CD:' ||'CC'|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CD:' ||MCUST.CUST_CNT_CD||MCUST.CUST_SEQ || CHR(10) " ).append("\n"); 
		query.append("       || '}CUST_CD_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{REGULATORY_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DUNS:' || ''||CHR(10) " ).append("\n"); 
		query.append("       || '}REGULATORY_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '}CUST_INFO' || CHR(10) " ).append("\n"); 
		query.append("  FROM MDM_CUSTOMER MCUST," ).append("\n"); 
		query.append("       MDM_CUST_ADDR ADDR," ).append("\n"); 
		query.append("       MDM_CUST_CNTC_PNT CNTC," ).append("\n"); 
		query.append("       INV_AR_MN IAM" ).append("\n"); 
		query.append(" WHERE IAM.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("   AND IAM.ACT_CUST_CNT_CD = MCUST.CUST_CNT_CD" ).append("\n"); 
		query.append("   AND IAM.ACT_CUST_SEQ = MCUST.CUST_SEQ" ).append("\n"); 
		query.append("   AND MCUST.CUST_CNT_CD = ADDR.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND MCUST.CUST_SEQ = ADDR.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND MCUST.CUST_CNT_CD = CNTC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("   AND MCUST.CUST_SEQ = CNTC.CUST_SEQ(+)" ).append("\n"); 
		query.append("   AND ADDR.PRMRY_CHK_FLG(+) = 'Y'" ).append("\n"); 
		query.append("   AND CNTC.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '{CUST_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_TP_CD:' || 'IO'|| CHR(10) " ).append("\n"); 
		query.append("	   || 'CUST_NM:' || REPLACE(REPLACE(MORG.OFC_ENG_NM,CHR(13)||CHR(10),CHR(10)),CHR(10), ' ') ||CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_TAX_NO:' ||MORG.OFC_TAX_ID || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_BK_REMIT:' ||'' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR1:' ||SUBSTR(MORG.OFC_ADDR, 1, 35)|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR2:' ||SUBSTR(MORG.OFC_ADDR, 36, 35)|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_ADDR3:' ||SUBSTR(MORG.OFC_ADDR, 71, 35)|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR4:' ||SUBSTR(MORG.OFC_ADDR, 106, 35)|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_ADDR5:' ||SUBSTR(MORG.OFC_ADDR, 141, 35)|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_CITY:' || '' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_STATE:' ||MLOC.STE_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ZIP:' ||MORG.OFC_ZIP_CD|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CNT_CD:' ||MLOC.CNT_CD|| CHR(10) " ).append("\n"); 
		query.append("       || '{CONTACT_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_NM:' || REPLACE(REPLACE(MORG.OFC_ENG_NM,CHR(13)||CHR(10),CHR(10)),CHR(10), ' ') ||CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_DEPT:' || ''|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_EMAIL:' ||MORG.OFC_REP_EML|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_FAX:' ||MORG.OFC_FAX_NO|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_TEL:' || MORG.OFC_PHN_NO||CHR(10) " ).append("\n"); 
		query.append("       || '}CONTACT_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{CUST_CD_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CD_TP_CD:' ||'OC'|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CD:' ||MORG.OFC_CD|| CHR(10) " ).append("\n"); 
		query.append("       || '}CUST_CD_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{REGULATORY_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DUNS:' || ''||CHR(10) " ).append("\n"); 
		query.append("       || '}REGULATORY_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '}CUST_INFO' || CHR(10) " ).append("\n"); 
		query.append("  FROM MDM_ORGANIZATION MORG," ).append("\n"); 
		query.append("       MDM_LOCATION MLOC," ).append("\n"); 
		query.append("       INV_AR_MN IAM" ).append("\n"); 
		query.append(" WHERE IAM.AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append("   AND IAM.AR_OFC_CD = MORG.OFC_CD" ).append("\n"); 
		query.append("   AND MORG.LOC_CD = MLOC.LOC_CD" ).append("\n"); 

	}
}