/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOAddPaymentSelectedInvoiceInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayablePaymentDBDAOAddPaymentSelectedInvoiceInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addPaymentSelectedInvoiceInfo
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOAddPaymentSelectedInvoiceInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("functional_currency",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_skd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_bat_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOAddPaymentSelectedInvoiceInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO SAP_SEL_INV" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   PAY_BAT_SEQ" ).append("\n"); 
		query.append(" , PAY_BAT_NM" ).append("\n"); 
		query.append(" , INV_SEQ" ).append("\n"); 
		query.append(" , PAY_NO" ).append("\n"); 
		query.append(" , VNDR_NO" ).append("\n"); 
		query.append(" , VNDR_NM" ).append("\n"); 
		query.append(" , PAY_VNDR_ADDR1" ).append("\n"); 
		query.append(" , PAY_VNDR_ADDR2" ).append("\n"); 
		query.append(" , AP_CTY_CD" ).append("\n"); 
		query.append(" , AP_STE_CD" ).append("\n"); 
		query.append(" , ZIP_CD" ).append("\n"); 
		query.append(" , AP_CNT_CD" ).append("\n"); 
		query.append(" , INV_NO" ).append("\n"); 
		query.append(" , INV_DT" ).append("\n"); 
		query.append(" , VCHR_NO" ).append("\n"); 
		query.append(" , INV_AMT" ).append("\n"); 
		query.append(" , INV_PAY_AMT" ).append("\n"); 
		query.append(" , LIAB_COA_CO_CD" ).append("\n"); 
		query.append(" , LIAB_COA_RGN_CD" ).append("\n"); 
		query.append(" , LIAB_COA_CTR_CD" ).append("\n"); 
		query.append(" , LIAB_COA_ACCT_NO" ).append("\n"); 
		query.append(" , LIAB_COA_VVD_CD" ).append("\n"); 
		query.append(" , LIAB_COA_INTER_CO_CD" ).append("\n"); 
		query.append(" , DUE_DT" ).append("\n"); 
		query.append(" , INV_DESC" ).append("\n"); 
		query.append(" , PAY_PRIO_CD" ).append("\n"); 
		query.append(" , PAY_RMN_AMT" ).append("\n"); 
		query.append(" , PAY_AMT" ).append("\n"); 
		query.append(" , PAY_SKD_NO" ).append("\n"); 
		query.append(" , PAY_BAT_FLG" ).append("\n"); 
		query.append(" , AMT_MODI_FLG" ).append("\n"); 
		query.append(" , PAY_CHK_NO" ).append("\n"); 
		query.append(" , INV_XCH_RT" ).append("\n"); 
		query.append(" , BANK_ACCT_TP_NM" ).append("\n"); 
		query.append(" , ATTR_CATE_NM" ).append("\n"); 
		query.append(" , ATTR_CTNT1" ).append("\n"); 
		query.append(" , ATTR_CTNT2" ).append("\n"); 
		query.append(" , ATTR_CTNT3" ).append("\n"); 
		query.append(" , ATTR_CTNT4" ).append("\n"); 
		query.append(" , ATTR_CTNT5" ).append("\n"); 
		query.append(" , ATTR_CTNT6" ).append("\n"); 
		query.append(" , ATTR_CTNT7" ).append("\n"); 
		query.append(" , ATTR_CTNT8" ).append("\n"); 
		query.append(" , ATTR_CTNT9" ).append("\n"); 
		query.append(" , ATTR_CTNT10" ).append("\n"); 
		query.append(" , ATTR_CTNT11" ).append("\n"); 
		query.append(" , ATTR_CTNT12" ).append("\n"); 
		query.append(" , ATTR_CTNT13" ).append("\n"); 
		query.append(" , ATTR_CTNT14" ).append("\n"); 
		query.append(" , ATTR_CTNT15" ).append("\n"); 
		query.append(" , BANK_ACCT_NO" ).append("\n"); 
		query.append(" , PROP_PAY_AMT" ).append("\n"); 
		query.append(" , PAY_SEL_PAY_SEQ" ).append("\n"); 
		query.append(" , INV_PAY_SEQ" ).append("\n"); 
		query.append(" , XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append(" , PAY_CURR_CD" ).append("\n"); 
		query.append(" , PAY_XCH_RT" ).append("\n"); 
		query.append(" , PAY_XCH_RT_TP_CD" ).append("\n"); 
		query.append(" , PAY_XCH_DT" ).append("\n"); 
		query.append(" , CRE_USR_ID" ).append("\n"); 
		query.append(" , CRE_DT" ).append("\n"); 
		query.append(" , UPD_USR_ID" ).append("\n"); 
		query.append(" , UPD_DT" ).append("\n"); 
		query.append(" , LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT @[pay_bat_seq]" ).append("\n"); 
		query.append("     , @[pay_bat_nm]" ).append("\n"); 
		query.append("     , SPS.INV_SEQ" ).append("\n"); 
		query.append("     , SPS.PAY_SKD_NO" ).append("\n"); 
		query.append("     , SIH.VNDR_NO" ).append("\n"); 
		query.append("     , MV.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("     , MV.ENG_ADDR" ).append("\n"); 
		query.append("     , '' AS PAY_VNDR_ADDR2" ).append("\n"); 
		query.append("     , MV.LOC_CD AS AP_CTY_CD" ).append("\n"); 
		query.append("     , '' AS AP_STE_CD" ).append("\n"); 
		query.append("     , MV.ZIP_CD" ).append("\n"); 
		query.append("     , MV.VNDR_CNT_CD AS AP_CNT_CD" ).append("\n"); 
		query.append("     , SIH.INV_NO" ).append("\n"); 
		query.append("     , SIH.INV_DT " ).append("\n"); 
		query.append("     , '' AS VCHR_NO" ).append("\n"); 
		query.append("     , SIH.INV_AMT" ).append("\n"); 
		query.append("     , SIH.INV_PAY_AMT" ).append("\n"); 
		query.append("     , '' LIAB_COA_CO_CD" ).append("\n"); 
		query.append("     , '' LIAB_COA_RGN_CD" ).append("\n"); 
		query.append("     , '' LIAB_COA_CTR_CD" ).append("\n"); 
		query.append("     , '' LIAB_COA_ACCT_NO" ).append("\n"); 
		query.append("     , '' LIAB_COA_VVD_CD" ).append("\n"); 
		query.append("     , '' LIAB_COA_INTER_CO_CD" ).append("\n"); 
		query.append("     , SPS.DUE_DT " ).append("\n"); 
		query.append("     , SIH.INV_DESC " ).append("\n"); 
		query.append("     , SPS.PAY_PRIO_CD " ).append("\n"); 
		query.append("     , SPS.PAY_RMN_AMT   " ).append("\n"); 
		query.append("     , SPS.PAY_RMN_AMT AS PAY_AMT" ).append("\n"); 
		query.append("     , SPS.PAY_SKD_NO" ).append("\n"); 
		query.append("     , 'Y' AS PAY_BAT_FLG" ).append("\n"); 
		query.append("     , 'N' AS AMT_MODI_FLG" ).append("\n"); 
		query.append("     , '' AS PAY_CHK_NO" ).append("\n"); 
		query.append("     , SIH.INV_XCH_RT " ).append("\n"); 
		query.append("     , '' AS BANK_ACCT_TP_NM" ).append("\n"); 
		query.append("     , '' AS ATTR_CATE_NM" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT1" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT2" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT3" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT4" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT5" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT6" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT7" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT8" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT9" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT10" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT11" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT12" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT13" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT14" ).append("\n"); 
		query.append("     , '' AS ATTR_CTNT15" ).append("\n"); 
		query.append("     , '' AS BANK_ACCT_NO" ).append("\n"); 
		query.append("     , SPS.PAY_RMN_AMT AS PROP_PAY_AMT" ).append("\n"); 
		query.append("     , '' AS PAY_SEL_PAY_SEQ" ).append("\n"); 
		query.append("     , '' AS INV_PAY_SEQ" ).append("\n"); 
		query.append("     , SPS.XTER_BANK_ACCT_SEQ " ).append("\n"); 
		query.append("     , SIH.INV_PAY_CURR_CD AS PAY_CURR_CD" ).append("\n"); 
		query.append("     , DECODE(SIH.INV_PAY_CURR_CD, @[functional_currency], '', NVL((SELECT  GDXR.CONV_XCH_RT FROM GL_DLY_XCH_RT GDXR WHERE GDXR.ACCT_XCH_RT_DT = REPLACE(@[pay_dt],'-','')" ).append("\n"); 
		query.append("                                                                    AND     ACCT_XCH_RT_LVL = '1' AND FM_CURR_CD = SIH.INV_PAY_CURR_CD AND TO_CURR_CD = @[functional_currency]" ).append("\n"); 
		query.append("                                                                    AND     GDXR.DELT_FLG <> 'Y' AND ROWNUM = 1), 1)) AS PAY_XCH_RT" ).append("\n"); 
		query.append("     , '1' AS PAY_XCH_RT_TP_CD" ).append("\n"); 
		query.append("     , TO_DATE(REPLACE(@[pay_dt],'-',''), 'YYYYMMDD') AS PAY_XCH_DT" ).append("\n"); 
		query.append("     , @[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("     , @[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append("     , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("     , SIH.LIAB_CD_CMB_SEQ " ).append("\n"); 
		query.append("FROM   SAP_INV_HDR SIH" ).append("\n"); 
		query.append("     , SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("     , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE  SIH.INV_SEQ = SPS.INV_SEQ" ).append("\n"); 
		query.append("AND    TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ " ).append("\n"); 
		query.append("AND    SPS.INV_SEQ = @[inv_seq]" ).append("\n"); 
		query.append("AND    SPS.PAY_SKD_NO = TO_NUMBER(@[pay_skd_no])" ).append("\n"); 

	}
}