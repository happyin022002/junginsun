/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayableInvoiceDBDAOSearchUnsettledAccountListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountPayableInvoiceDBDAOSearchUnsettledAccountListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayableInvoiceDBDAOSearchUnsettledAccountListRSQL
	  * </pre>
	  */
	public AccountPayableInvoiceDBDAOSearchUnsettledAccountListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unstl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.integration").append("\n"); 
		query.append("FileName : AccountPayableInvoiceDBDAOSearchUnsettledAccountListRSQL").append("\n"); 
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
		query.append("SELECT  COA_ACCT_CD" ).append("\n"); 
		query.append("      , ACCT_ENG_NM" ).append("\n"); 
		query.append("      , ACCT_LOCL_NM" ).append("\n"); 
		query.append("      , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("      , VNDR_NO " ).append("\n"); 
		query.append("      , COA_CTR_CD" ).append("\n"); 
		query.append("      , OFC_CD" ).append("\n"); 
		query.append("      , AR_OFC_CD" ).append("\n"); 
		query.append("      , INV_NO" ).append("\n"); 
		query.append("      , UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("      , TO_CHAR(TO_DATE(GL_DT,'YYYYMMDD'), 'YYYY-MM-DD') AS GL_DT" ).append("\n"); 
		query.append("      , UNSTL_CURR_CD" ).append("\n"); 
		query.append("      , INP_DR_AMT" ).append("\n"); 
		query.append("      , C_INP_DR_AMT" ).append("\n"); 
		query.append("      , INP_CR_AMT" ).append("\n"); 
		query.append("      , C_INP_CR_AMT" ).append("\n"); 
		query.append("      , UNSTL_DESC" ).append("\n"); 
		query.append("FROM    (      " ).append("\n"); 
		query.append("        SELECT  SUS.COA_ACCT_CD             		AS COA_ACCT_CD" ).append("\n"); 
		query.append("              , MA.ACCT_ENG_NM              		AS ACCT_ENG_NM" ).append("\n"); 
		query.append("              , MA.ACCT_LOCL_NM             		AS ACCT_LOCL_NM" ).append("\n"); 
		query.append("              , MV.VNDR_LGL_ENG_NM          		AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("              , SUS.VNDR_NO                 		AS VNDR_NO " ).append("\n"); 
		query.append("              , SUS.COA_CTR_CD              		AS COA_CTR_CD" ).append("\n"); 
		query.append("              , SUS.OFC_CD                  		AS OFC_CD" ).append("\n"); 
		query.append("              , MO.AR_OFC_CD                		AS AR_OFC_CD" ).append("\n"); 
		query.append("              , SUS.INV_NO                  		AS INV_NO" ).append("\n"); 
		query.append("              , TO_CHAR(SUS.UNSTL_DL_LINE_NO)  	AS UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("              , SUS.GL_DT                   		AS GL_DT" ).append("\n"); 
		query.append("              , SUS.UNSTL_CURR_CD           		AS UNSTL_CURR_CD" ).append("\n"); 
		query.append("              , TO_CHAR(SUS.INP_DR_AMT)     		AS INP_DR_AMT" ).append("\n"); 
		query.append("              , OPUSADM.SAP_GET_CUR_AMT_FNC(SUS.UNSTL_CURR_CD, SUS.INP_DR_AMT) AS C_INP_DR_AMT" ).append("\n"); 
		query.append("              , TO_CHAR(SUS.INP_CR_AMT)              AS INP_CR_AMT" ).append("\n"); 
		query.append("              , OPUSADM.SAP_GET_CUR_AMT_FNC(SUS.UNSTL_CURR_CD, SUS.INP_CR_AMT) AS C_INP_CR_AMT" ).append("\n"); 
		query.append("              , SUS.UNSTL_DESC              AS UNSTL_DESC" ).append("\n"); 
		query.append("        FROM    SAP_UNSTL_SMRY SUS" ).append("\n"); 
		query.append("              , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("              , MDM_VENDOR MV" ).append("\n"); 
		query.append("              , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE   SUS.COA_ACCT_CD = MA.ACCT_CD " ).append("\n"); 
		query.append("        AND     TO_NUMBER(SUS.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     SUS.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND     SUS.ACCT_STL_FLG = 'N'" ).append("\n"); 
		query.append("        AND     SUS.UNSTL_YRMON = TO_CHAR(ADD_MONTHS(TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD'), -1), 'YYYYMM')" ).append("\n"); 
		query.append("        #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("          AND   SUS.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          AND   SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC('', @[usr_id]), SUS.OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vndr_no} != '')" ).append("\n"); 
		query.append("          AND   SUS.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${coa_acct_cd} != '')" ).append("\n"); 
		query.append("          AND   SUS.COA_ACCT_CD = @[coa_acct_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${unstl_curr_cd} != '')" ).append("\n"); 
		query.append("          AND   SUS.UNSTL_CURR_CD = @[unstl_curr_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        UNION   ALL" ).append("\n"); 
		query.append("        SELECT  SLCC.SGM_CTNT4              AS COA_ACCT_CD" ).append("\n"); 
		query.append("              , MA.ACCT_ENG_NM              AS ACCT_ENG_NM" ).append("\n"); 
		query.append("              , MA.ACCT_LOCL_NM             AS ACCT_LOCL_NM" ).append("\n"); 
		query.append("              , MV.VNDR_LGL_ENG_NM          AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("              , SIH.VNDR_NO                 AS VNDR_NO " ).append("\n"); 
		query.append("              , SLCC.SGM_CTNT3              AS COA_CTR_CD" ).append("\n"); 
		query.append("              , SIH.OFC_CD                  AS OFC_CD" ).append("\n"); 
		query.append("              , MO.AR_OFC_CD                AS AR_OFC_CD" ).append("\n"); 
		query.append("              , SIH.INV_NO                  AS INV_NO" ).append("\n"); 
		query.append("              , ''                          AS UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("              , SIH.GL_DT                   AS GL_DT" ).append("\n"); 
		query.append("              , SIH.INV_CURR_CD             AS UNSTL_CURR_CD" ).append("\n"); 
		query.append("              , ''                          AS INP_DR_AMT" ).append("\n"); 
		query.append("              , ''                          AS C_INP_DR_AMT" ).append("\n"); 
		query.append("              , TO_CHAR(SPS.PAY_RMN_AMT)    AS INP_CR_AMT" ).append("\n"); 
		query.append("              , OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SPS.PAY_RMN_AMT) AS C_INP_CR_AMT" ).append("\n"); 
		query.append("              , SIH.INV_DESC                AS UNSTL_DESC" ).append("\n"); 
		query.append("        FROM    SAP_PAY_SKD SPS" ).append("\n"); 
		query.append("              , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("              , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("              , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("              , MDM_VENDOR MV" ).append("\n"); 
		query.append("              , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE   SPS.INV_SEQ = SIH.INV_SEQ       " ).append("\n"); 
		query.append("        AND     SIH.LIAB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("        AND     SLCC.SGM_CTNT4 = MA.ACCT_CD" ).append("\n"); 
		query.append("        AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     SIH.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("        AND     SPS.PAY_RMN_AMT <> 0" ).append("\n"); 
		query.append("        AND     SIH.GL_DT >= SUBSTR(REPLACE(@[gl_dt],'-',''), 1, 6) || '01'" ).append("\n"); 
		query.append("        AND     SIH.GL_DT <= REPLACE(@[gl_dt],'-','')" ).append("\n"); 
		query.append("        #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          AND   SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC('', @[usr_id]), SIH.OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vndr_no} != '')" ).append("\n"); 
		query.append("          AND   SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${coa_acct_cd} != '')" ).append("\n"); 
		query.append("          AND   SLCC.SGM_CTNT4 = @[coa_acct_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${unstl_curr_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.INV_CURR_CD = @[unstl_curr_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        UNION   ALL" ).append("\n"); 
		query.append("        SELECT  SLCC.SGM_CTNT4              AS COA_ACCT_CD" ).append("\n"); 
		query.append("              , MA.ACCT_ENG_NM              AS ACCT_ENG_NM" ).append("\n"); 
		query.append("              , MA.ACCT_LOCL_NM             AS ACCT_LOCL_NM" ).append("\n"); 
		query.append("              , MV.VNDR_LGL_ENG_NM          AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("              , SIH.VNDR_NO                 AS VNDR_NO " ).append("\n"); 
		query.append("              , SLCC.SGM_CTNT3              AS COA_CTR_CD" ).append("\n"); 
		query.append("              , SIH.OFC_CD                  AS OFC_CD" ).append("\n"); 
		query.append("              , MO.AR_OFC_CD                AS AR_OFC_CD" ).append("\n"); 
		query.append("              , SIH.INV_NO                  AS INV_NO" ).append("\n"); 
		query.append("              , ''                          AS UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("              , SIH.GL_DT                   AS GL_DT" ).append("\n"); 
		query.append("              , SIH.INV_CURR_CD             AS UNSTL_CURR_CD" ).append("\n"); 
		query.append("              , ''                          AS INP_DR_AMT" ).append("\n"); 
		query.append("              , ''                          AS C_INP_DR_AMT" ).append("\n"); 
		query.append("              , TO_CHAR(SPD.PAY_AMT)        AS INP_CR_AMT" ).append("\n"); 
		query.append("              , OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, SPD.PAY_AMT) AS C_INP_CR_AMT" ).append("\n"); 
		query.append("              , SIH.INV_DESC                AS UNSTL_DESC" ).append("\n"); 
		query.append("        FROM    SAP_PAY_DTL SPD" ).append("\n"); 
		query.append("              , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("              , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("              , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("              , MDM_VENDOR MV" ).append("\n"); 
		query.append("              , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE   SPD.INV_SEQ = SIH.INV_SEQ       " ).append("\n"); 
		query.append("        AND     SIH.LIAB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("        AND     SLCC.SGM_CTNT4 = MA.ACCT_CD" ).append("\n"); 
		query.append("        AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     SIH.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("        AND     SPD.ACCTG_DT > TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD')" ).append("\n"); 
		query.append("        AND     SIH.GL_DT >= SUBSTR(REPLACE(@[gl_dt],'-',''), 1, 6) || '01'" ).append("\n"); 
		query.append("        AND     SIH.GL_DT <= REPLACE(@[gl_dt],'-','')" ).append("\n"); 
		query.append("        #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          AND   SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC('', @[usr_id]), SIH.OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vndr_no} != '')" ).append("\n"); 
		query.append("          AND   SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${coa_acct_cd} != '')" ).append("\n"); 
		query.append("          AND   SLCC.SGM_CTNT4 = @[coa_acct_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${unstl_curr_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.INV_CURR_CD = @[unstl_curr_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        UNION   ALL" ).append("\n"); 
		query.append("        SELECT  SLCC.SGM_CTNT4              AS COA_ACCT_CD" ).append("\n"); 
		query.append("              , MA.ACCT_ENG_NM              AS ACCT_ENG_NM" ).append("\n"); 
		query.append("              , MA.ACCT_LOCL_NM             AS ACCT_LOCL_NM" ).append("\n"); 
		query.append("              , MV.VNDR_LGL_ENG_NM          AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("              , SIH.VNDR_NO                 AS VNDR_NO " ).append("\n"); 
		query.append("              , SLCC.SGM_CTNT3              AS COA_CTR_CD" ).append("\n"); 
		query.append("              , SIH.OFC_CD                  AS OFC_CD" ).append("\n"); 
		query.append("              , MO.AR_OFC_CD                AS AR_OFC_CD" ).append("\n"); 
		query.append("              , SIH.INV_NO                  AS INV_NO" ).append("\n"); 
		query.append("              , TO_CHAR(SID.DTRB_LINE_NO)   AS UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("              , SIH.GL_DT                   AS GL_DT" ).append("\n"); 
		query.append("              , SIH.INV_CURR_CD             AS UNSTL_CURR_CD" ).append("\n"); 
		query.append("              , TO_CHAR(NVL(SID.PPAY_RMN_AMT, SID.DTRB_AMT)) AS INP_DR_AMT" ).append("\n"); 
		query.append("              , OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, NVL(SID.PPAY_RMN_AMT, SID.DTRB_AMT))   AS C_INP_DR_AMT" ).append("\n"); 
		query.append("              , ''                          AS INP_CR_AMT" ).append("\n"); 
		query.append("              , ''                          AS C_INP_CR_AMT" ).append("\n"); 
		query.append("              , SID.DTRB_DESC               AS UNSTL_DESC" ).append("\n"); 
		query.append("        FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("              , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("              , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("              , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("              , MDM_VENDOR MV" ).append("\n"); 
		query.append("              , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE   SID.INV_SEQ = SIH.INV_SEQ       " ).append("\n"); 
		query.append("        AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("        AND     SLCC.SGM_CTNT4 = MA.ACCT_CD" ).append("\n"); 
		query.append("        AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     SIH.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND     SIH.INV_TP_LU_CD = 'PREPAYMENT'" ).append("\n"); 
		query.append("        AND     SIH.INV_CXL_DT IS NULL" ).append("\n"); 
		query.append("        AND     (SID.PPAY_RMN_AMT IS NULL OR SID.PPAY_RMN_AMT <> 0 )" ).append("\n"); 
		query.append("        AND     NVL(SID.RVS_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("        AND     SID.LINE_TP_LU_CD = 'ITEM'" ).append("\n"); 
		query.append("        AND     SID.ACCTG_DT >= TO_DATE(SUBSTR(REPLACE(@[gl_dt],'-',''), 1, 6) || '01', 'YYYYMMDD')" ).append("\n"); 
		query.append("        AND     SID.ACCTG_DT <  TRUNC(TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD')) + 1" ).append("\n"); 
		query.append("        #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          AND   SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC('', @[usr_id]), SIH.OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vndr_no} != '')" ).append("\n"); 
		query.append("          AND   SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${coa_acct_cd} != '')" ).append("\n"); 
		query.append("          AND   SLCC.SGM_CTNT4 = @[coa_acct_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${unstl_curr_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.INV_CURR_CD = @[unstl_curr_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        UNION   ALL" ).append("\n"); 
		query.append("        SELECT  SLCC.SGM_CTNT4              		AS COA_ACCT_CD" ).append("\n"); 
		query.append("              , MA.ACCT_ENG_NM              		AS ACCT_ENG_NM" ).append("\n"); 
		query.append("              , MA.ACCT_LOCL_NM             		AS ACCT_LOCL_NM" ).append("\n"); 
		query.append("              , MV.VNDR_LGL_ENG_NM          		AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("              , SIH.VNDR_NO                 		AS VNDR_NO " ).append("\n"); 
		query.append("              , SLCC.SGM_CTNT3              		AS COA_CTR_CD" ).append("\n"); 
		query.append("              , SIH.OFC_CD                  		AS OFC_CD" ).append("\n"); 
		query.append("              , MO.AR_OFC_CD                		AS AR_OFC_CD" ).append("\n"); 
		query.append("              , SIH.INV_NO                  		AS INV_NO" ).append("\n"); 
		query.append("              , ''                          		AS UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("              , SIH.GL_DT                   		AS GL_DT" ).append("\n"); 
		query.append("              , SIH.INV_CURR_CD             		AS UNSTL_CURR_CD" ).append("\n"); 
		query.append("              , ''                          		AS INP_DR_AMT" ).append("\n"); 
		query.append("              , ''                          		AS C_INP_DR_AMT" ).append("\n"); 
		query.append("              , TO_CHAR(PPAY.PREPAY_APPLY_AMT)  AS INP_CR_AMT" ).append("\n"); 
		query.append("              , OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, PPAY.PREPAY_APPLY_AMT) AS C_INP_CR_AMT" ).append("\n"); 
		query.append("              , SIH.INV_DESC                		AS UNSTL_DESC" ).append("\n"); 
		query.append("        FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("              , (SELECT  SID.INV_SEQ         AS INV_SEQ" ).append("\n"); 
		query.append("                       , SID.DTRB_LINE_NO    AS DTRB_LINE_NO" ).append("\n"); 
		query.append("                       , SID.PPAY_INV_SEQ    AS PREPAY_INV_SEQ" ).append("\n"); 
		query.append("                       , SID.PPAY_LINE_NO    AS PREPAY_LINE_NO" ).append("\n"); 
		query.append("                       , SID.DTRB_AMT * (-1) AS PREPAY_APPLY_AMT" ).append("\n"); 
		query.append("                       , (SELECT SUM(NVL(SID2.PPAY_RMN_AMT, SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2 " ).append("\n"); 
		query.append("                          WHERE  SID2.INV_SEQ = SID.PPAY_INV_SEQ AND SID2.DTRB_LINE_NO = SID.PPAY_LINE_NO AND SID2.LINE_TP_LU_CD = 'ITEM' AND NVL(SID2.RVS_FLG, 'N') <> 'Y') AS PREPAY_RMN_AMT" ).append("\n"); 
		query.append("                       , SID.ACCTG_DT        AS ACCTG_DT" ).append("\n"); 
		query.append("                       , SID.DTRB_DESC       AS DTRB_DESC" ).append("\n"); 
		query.append("                       , SIH.INV_NO          AS PREPAY_INV_NO" ).append("\n"); 
		query.append("                       , SIH.VNDR_NO         AS VNDR_NO" ).append("\n"); 
		query.append("                 FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("                       , SAP_INV_DTL SID" ).append("\n"); 
		query.append("                 WHERE   SIH.INV_SEQ = SID.INV_SEQ" ).append("\n"); 
		query.append("                 AND     SID.DTRB_AMT < 0" ).append("\n"); 
		query.append("                 AND     NVL(SID.RVS_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                 AND     SID.LINE_TP_LU_CD = 'PREPAY') PPAY" ).append("\n"); 
		query.append("              , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("              , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("              , MDM_VENDOR MV" ).append("\n"); 
		query.append("              , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE   PPAY.INV_SEQ = SIH.INV_SEQ       " ).append("\n"); 
		query.append("        AND     SIH.LIAB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("        AND     SLCC.SGM_CTNT4 = MA.ACCT_CD" ).append("\n"); 
		query.append("        AND     TO_NUMBER(SIH.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     SIH.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND     PPAY.ACCTG_DT > TRUNC(TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD'))" ).append("\n"); 
		query.append("        AND     SIH.GL_DT >= SUBSTR(REPLACE(@[gl_dt],'-',''), 1, 6) || '01'" ).append("\n"); 
		query.append("        AND     SIH.GL_DT <=  REPLACE(@[gl_dt],'-','')" ).append("\n"); 
		query.append("        #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          AND   SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC('', @[usr_id]), SIH.OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vndr_no} != '')" ).append("\n"); 
		query.append("          AND   SIH.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${coa_acct_cd} != '')" ).append("\n"); 
		query.append("          AND   SLCC.SGM_CTNT4 = @[coa_acct_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${unstl_curr_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.INV_CURR_CD = @[unstl_curr_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        UNION   ALL" ).append("\n"); 
		query.append("        SELECT  SLCC.SGM_CTNT4              			AS COA_ACCT_CD" ).append("\n"); 
		query.append("              , MA.ACCT_ENG_NM              			AS ACCT_ENG_NM" ).append("\n"); 
		query.append("              , MA.ACCT_LOCL_NM             			AS ACCT_LOCL_NM" ).append("\n"); 
		query.append("              , MV.VNDR_LGL_ENG_NM          			AS VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("              , PPAY.VNDR_NO                			AS VNDR_NO " ).append("\n"); 
		query.append("              , SLCC.SGM_CTNT3              			AS COA_CTR_CD" ).append("\n"); 
		query.append("              , SIH.OFC_CD                  			AS OFC_CD" ).append("\n"); 
		query.append("              , MO.AR_OFC_CD                			AS AR_OFC_CD" ).append("\n"); 
		query.append("              , PPAY.PREPAY_INV_NO          			AS INV_NO" ).append("\n"); 
		query.append("              , TO_CHAR(SID.DTRB_LINE_NO)   			AS UNSTL_DL_LINE_NO" ).append("\n"); 
		query.append("              , TO_CHAR(SID.ACCTG_DT, 'YYYYMMDD') AS GL_DT" ).append("\n"); 
		query.append("              , SIH.INV_CURR_CD             			AS UNSTL_CURR_CD" ).append("\n"); 
		query.append("              , TO_CHAR(PPAY.PREPAY_APPLY_AMT)    AS INP_DR_AMT" ).append("\n"); 
		query.append("              , OPUSADM.SAP_GET_CUR_AMT_FNC(SIH.INV_CURR_CD, PPAY.PREPAY_APPLY_AMT) AS C_INP_DR_AMT" ).append("\n"); 
		query.append("              , ''                          			AS INP_CR_AMT" ).append("\n"); 
		query.append("              , ''                          			AS C_INP_CR_AMT" ).append("\n"); 
		query.append("              , SID.DTRB_DESC               			AS UNSTL_DESC" ).append("\n"); 
		query.append("        FROM    SAP_INV_DTL SID" ).append("\n"); 
		query.append("              , (SELECT  SID.INV_SEQ         AS INV_SEQ" ).append("\n"); 
		query.append("                       , SID.DTRB_LINE_NO    AS DTRB_LINE_NO" ).append("\n"); 
		query.append("                       , SID.PPAY_INV_SEQ    AS PREPAY_INV_SEQ" ).append("\n"); 
		query.append("                       , SID.PPAY_LINE_NO    AS PREPAY_LINE_NO" ).append("\n"); 
		query.append("                       , SID.DTRB_AMT * (-1) AS PREPAY_APPLY_AMT" ).append("\n"); 
		query.append("                       , (SELECT SUM(NVL(SID2.PPAY_RMN_AMT, SID2.DTRB_AMT)) FROM SAP_INV_DTL SID2 " ).append("\n"); 
		query.append("                          WHERE  SID2.INV_SEQ = SID.PPAY_INV_SEQ AND SID2.DTRB_LINE_NO = SID.PPAY_LINE_NO AND SID2.LINE_TP_LU_CD = 'ITEM' AND NVL(SID2.RVS_FLG, 'N') <> 'Y') AS PREPAY_RMN_AMT" ).append("\n"); 
		query.append("                       , SID.ACCTG_DT        AS ACCTG_DT" ).append("\n"); 
		query.append("                       , SID.DTRB_DESC       AS DTRB_DESC" ).append("\n"); 
		query.append("                       , SIH.INV_NO          AS PREPAY_INV_NO" ).append("\n"); 
		query.append("                       , SIH.VNDR_NO         AS VNDR_NO" ).append("\n"); 
		query.append("                 FROM    SAP_INV_HDR SIH" ).append("\n"); 
		query.append("                       , SAP_INV_DTL SID" ).append("\n"); 
		query.append("                 WHERE   SIH.INV_SEQ = SID.INV_SEQ" ).append("\n"); 
		query.append("                 AND     SID.DTRB_AMT < 0" ).append("\n"); 
		query.append("                 AND     NVL(SID.RVS_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                 AND     SID.LINE_TP_LU_CD = 'PREPAY') PPAY" ).append("\n"); 
		query.append("              , SAP_INV_HDR SIH" ).append("\n"); 
		query.append("              , SCO_LEGR_CD_CMB SLCC" ).append("\n"); 
		query.append("              , MDM_ACCOUNT MA" ).append("\n"); 
		query.append("              , MDM_VENDOR MV" ).append("\n"); 
		query.append("              , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("        WHERE   PPAY.PREPAY_INV_SEQ = SID.INV_SEQ  " ).append("\n"); 
		query.append("        AND     PPAY.PREPAY_LINE_NO = SID.DTRB_LINE_NO" ).append("\n"); 
		query.append("        AND     SID.INV_SEQ = SIH.INV_SEQ " ).append("\n"); 
		query.append("        AND     SID.DTRB_CD_CMB_SEQ = SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("        AND     SLCC.SGM_CTNT4 = MA.ACCT_CD" ).append("\n"); 
		query.append("        AND     TO_NUMBER(PPAY.VNDR_NO) = MV.VNDR_SEQ" ).append("\n"); 
		query.append("        AND     SIH.OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("        AND     NVL(SID.RVS_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("        AND     PPAY.ACCTG_DT > TRUNC(TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD'))" ).append("\n"); 
		query.append("        AND     SID.ACCTG_DT >= TO_DATE(SUBSTR(REPLACE(@[gl_dt],'-',''), 1, 6) || '01', 'YYYYMMDD')" ).append("\n"); 
		query.append("        AND     SID.ACCTG_DT <  TRUNC(TO_DATE(REPLACE(@[gl_dt],'-',''), 'YYYYMMDD')) + 1        " ).append("\n"); 
		query.append("        #if (${ofc_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("          AND   SAP_OFC_SECURITY_FNC(SAP_GET_AP_OFFICE_FNC('', @[usr_id]), SIH.OFC_CD, 'INCLUDE_ALL', '') = 'Y'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vndr_no} != '')" ).append("\n"); 
		query.append("          AND   PPAY.VNDR_NO = @[vndr_no]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${coa_acct_cd} != '')" ).append("\n"); 
		query.append("          AND   SLCC.SGM_CTNT4 = @[coa_acct_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${unstl_curr_cd} != '')" ).append("\n"); 
		query.append("          AND   SIH.INV_CURR_CD = @[unstl_curr_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("ORDER   BY UNSTL_CURR_CD, COA_ACCT_CD, COA_CTR_CD, VNDR_NO, INV_NO, UNSTL_DL_LINE_NO, GL_DT" ).append("\n"); 

	}
}