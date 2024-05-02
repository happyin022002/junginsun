/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableCommonDBDAOSearchPopInternalBankAcctListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableCommonDBDAOSearchPopInternalBankAcctListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPopInternalBankAcctList
	  * </pre>
	  */
	public AccountPayableCommonDBDAOSearchPopInternalBankAcctListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inactive_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration").append("\n"); 
		query.append("FileName : AccountPayableCommonDBDAOSearchPopInternalBankAcctListRSQL").append("\n"); 
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
		query.append("SELECT  SBA.BANK_ACCT_SEQ         AS BANK_ACCT_SEQ           -- Hidden" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NO          AS BANK_ACCT_NUMBER" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_NM          AS BANK_ACCT_NAME" ).append("\n"); 
		query.append("      , SBA.BANK_BRNC_SEQ         AS BANK_BRANCH_SEQ         -- Hidden" ).append("\n"); 
		query.append("      , SBB.BANK_NM               AS BANK_NAME" ).append("\n"); 
		query.append("      , SBB.BANK_ALTN_NM          AS BANK_NAME_ALT           -- Hidden" ).append("\n"); 
		query.append("      , SBB.BANK_BRNC_NM          AS BANK_BRANCH_NAME " ).append("\n"); 
		query.append("      , SBB.BANK_BRNC_ALTN_NM     AS BANK_BRANCH_NAME_ALT    -- Hidden" ).append("\n"); 
		query.append("      , MO.AP_OFC_CD              AS AP_OFFICE_CODE          -- Hidden" ).append("\n"); 
		query.append("      , MO.AP_CTRL_OFC_CD         AS AP_CONTROL_OFFICE_CODE  -- Hidden" ).append("\n"); 
		query.append("      , MO2.AR_OFC_CD             AS AR_OFFICE_CODE          -- Hidden" ).append("\n"); 
		query.append("      , MO2.AR_CTRL_OFC_CD        AS AR_CONTROL_OFFICE_CODE  -- Hidden" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_TP_MN_CD    AS BANK_ACCT_MAJOR_TYPE    -- Hidden" ).append("\n"); 
		query.append("      , SBA.BANK_ACCT_TP_SUB_CD   AS BANK_ACCT_MINOR_TYPE    -- Hidden" ).append("\n"); 
		query.append("      , (SELECT  SLD.LU_DESC " ).append("\n"); 
		query.append("         FROM    SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("         WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'BANK ACCOUNT TYPE(L)'" ).append("\n"); 
		query.append("         AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y' AND NVL(SLD.LU_END_DT, SYSDATE) <= SYSDATE AND SLD.LU_CD = SBA.BANK_ACCT_TP_MN_CD AND ROWNUM = 1) AS BANK_ACCT_MAJOR" ).append("\n"); 
		query.append("      , (SELECT  SLD.LU_DESC " ).append("\n"); 
		query.append("         FROM    SCO_LU_HDR SLH, SCO_LU_DTL SLD" ).append("\n"); 
		query.append("         WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD AND SLH.LU_TP_CD = 'BANK ACCOUNT TYPE(M)'" ).append("\n"); 
		query.append("         AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y' AND NVL(SLD.LU_END_DT, SYSDATE) <= SYSDATE AND SLD.LU_CD = SBA.BANK_ACCT_TP_SUB_CD AND ROWNUM = 1) AS BANK_ACCT_MINOR" ).append("\n"); 
		query.append("      , SBA.ASET_CD_CMB_SEQ       AS ASSET_CODE_COMBINATION_ID  -- Hidden" ).append("\n"); 
		query.append("      , SBA.CURR_CD               AS CURRENCY_CODE" ).append("\n"); 
		query.append("      , SBA.CNTC_AREA_CD          AS COUNTRY_CODE            -- Hidden" ).append("\n"); 
		query.append("FROM    SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("      , SAP_BANK_BRNC SBB" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("      , MDM_ORGANIZATION MO2" ).append("\n"); 
		query.append("WHERE  SBA.BANK_ACCT_TP_NM = 'INTERNAL'" ).append("\n"); 
		query.append("AND    SBA.BANK_BRNC_SEQ = SBB.BANK_BRNC_SEQ" ).append("\n"); 
		query.append("AND    SBA.OPN_OFC_CD = MO.OFC_CD(+)" ).append("\n"); 
		query.append("AND    SBA.AR_OFC_CD = MO2.OFC_CD(+)" ).append("\n"); 
		query.append("AND    ( DECODE(@[ofc_type], 'AP', MO.AP_OFC_CD, MO2.AR_OFC_CD) = @[ofc_cd]" ).append("\n"); 
		query.append("       OR (@[ofc_type] = 'ALL' AND (MO.AP_CTRL_OFC_CD = @[ofc_cd] OR MO2.AR_CTRL_OFC_CD = @[ofc_cd])))" ).append("\n"); 
		query.append("AND    ( (@[inactive_type] = '1' AND SBA.INACT_DT IS NULL) OR (@[inactive_type] = '2' AND SBA.INACT_DT IS NOT NULL) OR (@[inactive_type] = '3' AND 1 = 1) )" ).append("\n"); 
		query.append("#if (${bank_acct_no} != '') " ).append("\n"); 
		query.append("AND    SBA.BANK_ACCT_NO LIKE @[bank_acct_no] || '%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}