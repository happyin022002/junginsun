/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchAPIFPaymentCSRInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.04 
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

public class AccountPayablePaymentDBDAOSearchAPIFPaymentCSRInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAPIFPaymentCSRInfoList
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchAPIFPaymentCSRInfoListRSQL(){
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
		params.put("pay_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchAPIFPaymentCSRInfoListRSQL").append("\n"); 
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
		query.append("SELECT  SIH.INV_SEQ                        AS INV_SEQ" ).append("\n"); 
		query.append("      , SIH.INV_NO                         AS CSR_NO" ).append("\n"); 
		query.append("      , SIH.INV_CURR_CD                    AS INV_CURR_CD" ).append("\n"); 
		query.append("      , SIH.INV_PAY_CURR_CD                AS INV_PAY_CURR_CD" ).append("\n"); 
		query.append("      , SIH.PAY_MZD_LU_CD                  AS PAY_MZD_LU_CD" ).append("\n"); 
		query.append("      , MV.ENG_ADDR                        AS PAY_ADDR1" ).append("\n"); 
		query.append("      , MV.LOCL_LANG_ADDR                  AS PAY_ADDR2" ).append("\n"); 
		query.append("      , MV.LOC_CD                          AS AP_CTY_CD" ).append("\n"); 
		query.append("      , MV.VNDR_CNT_CD                     AS AP_CNT_CD" ).append("\n"); 
		query.append("      , 'NEGOTIABLE'                       AS PAY_STS_LU_CD" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM                 AS VNDR_NM" ).append("\n"); 
		query.append("      , MV.ZIP_CD                          AS ZIP_CD" ).append("\n"); 
		query.append("      , SIH.VNDR_NO                        AS VNDR_NO" ).append("\n"); 
		query.append("      , DECODE(SIH.INV_PAY_CURR_CD, @[functional_currency], 1, NVL((SELECT  GDXR.CONV_XCH_RT " ).append("\n"); 
		query.append("                                                                    FROM    GL_DLY_XCH_RT GDXR " ).append("\n"); 
		query.append("                                                                    WHERE   GDXR.ACCT_XCH_RT_DT = @[pay_dt]" ).append("\n"); 
		query.append("                                                                    AND     ACCT_XCH_RT_LVL = '1' " ).append("\n"); 
		query.append("                                                                    AND     FM_CURR_CD = SIH.INV_PAY_CURR_CD " ).append("\n"); 
		query.append("                                                                    AND     TO_CURR_CD = @[functional_currency]" ).append("\n"); 
		query.append("                                                                    AND     GDXR.DELT_FLG <> 'Y' AND ROWNUM = 1), 1)) AS PAY_XCH_RT" ).append("\n"); 
		query.append("      , @[pay_dt]                          AS PAY_XCH_DT" ).append("\n"); 
		query.append("      , '1'                                AS XCH_RT_TP_CD" ).append("\n"); 
		query.append("      , 1                                  AS PAY_BAT_RUN_SEQ" ).append("\n"); 
		query.append("      , SPS.XTER_BANK_ACCT_SEQ             AS XTER_BANK_ACCT_SEQ" ).append("\n"); 
		query.append("      , MV.VNDR_LGL_ENG_NM                 AS PAY_DESC" ).append("\n"); 
		query.append("      , SIH.OFC_CD                         AS OFC_CD" ).append("\n"); 
		query.append("      , TO_CHAR(TO_DATE(@[pay_dt],'YYYYMMDD'), 'YYYYMMDD') AS ACCTG_DT" ).append("\n"); 
		query.append("      , SIH.INV_AMT                        AS PAY_AMT" ).append("\n"); 
		query.append("      , SUBSTR(@[pay_dt], 1, 6)            AS EFF_YRMON" ).append("\n"); 
		query.append("      , 'N'                                AS ACCTG_PST_FLG " ).append("\n"); 
		query.append("      , DECODE(SIH.INV_PAY_CURR_CD, @[functional_currency], SIH.INV_AMT," ).append("\n"); 
		query.append("               ROUND(SIH.INV_AMT * NVL((SELECT  GDXR.CONV_XCH_RT FROM GL_DLY_XCH_RT GDXR " ).append("\n"); 
		query.append("                                        WHERE   GDXR.ACCT_XCH_RT_DT = @[pay_dt]" ).append("\n"); 
		query.append("                                        AND     ACCT_XCH_RT_LVL = '1' " ).append("\n"); 
		query.append("                                        AND     FM_CURR_CD = SIH.INV_PAY_CURR_CD " ).append("\n"); 
		query.append("                                        AND     TO_CURR_CD = @[functional_currency]" ).append("\n"); 
		query.append("                                        AND     GDXR.DELT_FLG <> 'Y' AND ROWNUM = 1), 1), " ).append("\n"); 
		query.append("              (SELECT NVL(MC.DP_PRCS_KNT, 0) FROM MDM_CURRENCY MC WHERE MC.CURR_CD = @[functional_currency] AND ROWNUM = 1))) AS PAY_FUNC_AMT" ).append("\n"); 
		query.append("      , SPS.PAY_SKD_NO                     AS PAY_SKD_NO" ).append("\n"); 
		query.append("      , SIH.AP_INV_SRC_CD                  AS AP_INV_SRC_CD" ).append("\n"); 
		query.append("      , SIH.LIAB_CD_CMB_SEQ                AS LIAB_CD_CMB_SEQ" ).append("\n"); 
		query.append("      , SIH.ATTR_CTNT13                    AS ATTR_CTNT13 " ).append("\n"); 
		query.append("      , SIH.AP_APSTS_CD                    AS AP_APSTS_CD " ).append("\n"); 
		query.append("      , 'SYSTEM'                           AS USR_ID" ).append("\n"); 
		query.append("      , TO_CHAR(SYSDATE, 'YYYYMMDD')       AS SYS_TODAY " ).append("\n"); 
		query.append("      , NVL(SIH.PAY_STS_FLG, 'N')          AS INV_PAY_STS_FLG" ).append("\n"); 
		query.append("      , NVL(SPS.PAY_STS_FLG, 'N')          AS PAY_STS_FLG" ).append("\n"); 
		query.append("FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("      , SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("      , MDM_VENDOR MV" ).append("\n"); 
		query.append("WHERE   SIH.INV_SEQ = SPS.INV_SEQ " ).append("\n"); 
		query.append("AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ " ).append("\n"); 
		query.append("AND     SPS.PAY_SKD_NO = 1" ).append("\n"); 
		query.append("AND     SIH.INV_NO = @[csr_no]" ).append("\n"); 
		query.append("AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("--AND     NVL(SPS.INV_HLD_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND     SPS.PAY_BAT_RUN_SEQ IS NULL" ).append("\n"); 

	}
}