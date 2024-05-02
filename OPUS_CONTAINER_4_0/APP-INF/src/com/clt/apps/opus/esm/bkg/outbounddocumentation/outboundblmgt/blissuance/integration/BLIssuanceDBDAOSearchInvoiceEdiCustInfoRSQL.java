/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchInvoiceEdiCustInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchInvoiceEdiCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchInvoiceEdiCustInfoRSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchInvoiceEdiCustInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchInvoiceEdiCustInfoRSQL").append("\n"); 
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
		query.append("       || 'CUST_BK_REMIT:' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR1:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_NM, 1, '')|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR2:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_NM, 2, '')|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_ADDR3:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_NM, 3, '')|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ADDR4:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_NM, 4, '')|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_ADDR5:' ||BKG_TOKEN_NL_FNC(BCUST.CUST_NM, 5, '')|| CHR(10)  " ).append("\n"); 
		query.append("       || 'CUST_CITY:' || BCUST.CUST_CTY_NM || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_STATE:' ||BCUST.CUST_STE_CD || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_ZIP:' ||BCUST.CUST_ZIP_ID|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CNT_CD:' ||BCUST.CUST_CNT_CD|| CHR(10) " ).append("\n"); 
		query.append("       || '{CONTACT_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_NM:' ||''|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_DEPT:' || ''|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_EMAIL:' ||BCUST.CUST_EML|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_FAX:' ||BCUST.CUST_FAX_NO|| CHR(10) " ).append("\n"); 
		query.append("       || 'CONTACT_TEL:' || ''||CHR(10) " ).append("\n"); 
		query.append("       || '}CONTACT_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{CUST_CD_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CD_TP_CD:' ||'CC'|| CHR(10) " ).append("\n"); 
		query.append("       || 'CUST_CD:' ||BCUST.CUST_CNT_CD||BCUST.CUST_SEQ || CHR(10) " ).append("\n"); 
		query.append("       || '}CUST_CD_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '{REGULATORY_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'DUNS:' || ''||CHR(10) " ).append("\n"); 
		query.append("       || '}REGULATORY_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || '}CUST_INFO' || CHR(10) " ).append("\n"); 
		query.append("  FROM BKG_CUSTOMER BCUST" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_CUST_TP_CD IN ('A','C','E','F','N','S')" ).append("\n"); 

	}
}