/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountPayablePaymentDBDAOSearchPaymentEntryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.06 
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

public class AccountPayablePaymentDBDAOSearchPaymentEntryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountPayablePaymentDBDAOsearchPaymentEntryListRSQL
	  * </pre>
	  */
	public AccountPayablePaymentDBDAOSearchPaymentEntryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_mzd_lu_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_pay_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration").append("\n"); 
		query.append("FileName : AccountPayablePaymentDBDAOSearchPaymentEntryListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    PAY_SEQ," ).append("\n"); 
		query.append("    PAY_TP_CD," ).append("\n"); 
		query.append("    BANK_ACCT_NM," ).append("\n"); 
		query.append("    PAY_DT," ).append("\n"); 
		query.append("    OFC_CD," ).append("\n"); 
		query.append("    VNDR_NM," ).append("\n"); 
		query.append("    VNDR_NO," ).append("\n"); 
		query.append("    PAY_AMT,    " ).append("\n"); 
		query.append("    REMIT_TO_ACCT_NO," ).append("\n"); 
		query.append("    CURR_CD," ).append("\n"); 
		query.append("    DOC_SEQ," ).append("\n"); 
		query.append("    PAY_BAT_NM," ).append("\n"); 
		query.append("    PAY_MZD_LU_CD," ).append("\n"); 
		query.append("    PAY_STE_NM," ).append("\n"); 
		query.append("    PAY_XCH_DT," ).append("\n"); 
		query.append("    XCH_RT_TP_CD," ).append("\n"); 
		query.append("    PAY_XCH_RT," ).append("\n"); 
		query.append("    PAY_CNT_CD," ).append("\n"); 
		query.append("    PAY_ADDR1," ).append("\n"); 
		query.append("    TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(PAY_FUNC_CURR_CD, PAY_FUNC_AMT)) AS PAY_FUNC_AMT," ).append("\n"); 
		query.append("    BANK_ACCT_SEQ," ).append("\n"); 
		query.append("    XTER_BANK_ACCT_SEQ," ).append("\n"); 
		query.append("	BANK_ACCT_NO," ).append("\n"); 
		query.append("    PAY_CURR_PRCS," ).append("\n"); 
		query.append("    PERIOD_CHK," ).append("\n"); 
		query.append("	'' AS FR_DT," ).append("\n"); 
		query.append("	'' AS TO_DT," ).append("\n"); 
		query.append("	'' AS VNDR_PAY_GRP_CD," ).append("\n"); 
		query.append("	'' AS USR_ID," ).append("\n"); 
		query.append("	'' AS CHK_FLG," ).append("\n"); 
		query.append("	'' AS PAY_NO" ).append("\n"); 
		query.append("    ,(SELECT SUM(DECODE(ACCTG_PST_FLG, 'Y', 1, 0 )) FROM SAP_PAY_DTL D WHERE D.PAY_SEQ = A.PAY_SEQ ) AS CNT_ACCTG_PST_FLG_Y" ).append("\n"); 
		query.append("    ,PAY_STS_LU_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT SPH.PAY_SEQ," ).append("\n"); 
		query.append("           DECODE(SPH.PAY_TP_CD,'B','Batch','M','Manual') AS PAY_TP_CD," ).append("\n"); 
		query.append("           SPH.BANK_ACCT_NM," ).append("\n"); 
		query.append("           TO_CHAR(SPH.PAY_DT, 'YYYYMMDD') AS PAY_DT," ).append("\n"); 
		query.append("           SPH.OFC_CD," ).append("\n"); 
		query.append("           SPH.VNDR_NM," ).append("\n"); 
		query.append("           SPH.VNDR_NO," ).append("\n"); 
		query.append("           TRIM(OPUSADM.SAP_GET_CUR_AMT_FNC(SPH.CURR_CD, SPH.PAY_AMT)) AS PAY_AMT,    " ).append("\n"); 
		query.append("           SBA.BANK_ACCT_NO AS REMIT_TO_ACCT_NO," ).append("\n"); 
		query.append("           SPH.CURR_CD," ).append("\n"); 
		query.append("           SPH.DOC_SEQ," ).append("\n"); 
		query.append("           SPH.PAY_BAT_NM," ).append("\n"); 
		query.append("           SPH.PAY_MZD_LU_CD," ).append("\n"); 
		query.append("           SPH.PAY_STE_NM," ).append("\n"); 
		query.append("           SPH.PAY_XCH_DT," ).append("\n"); 
		query.append("           DECODE(SPH.XCH_RT_TP_CD, 1, 'Corporate') AS XCH_RT_TP_CD," ).append("\n"); 
		query.append("           SPH.PAY_XCH_RT," ).append("\n"); 
		query.append("           SPH.PAY_CNT_CD," ).append("\n"); 
		query.append("           SPH.PAY_ADDR1," ).append("\n"); 
		query.append("           SPH.PAY_FUNC_AMT," ).append("\n"); 
		query.append("           SPH.BANK_ACCT_SEQ," ).append("\n"); 
		query.append("           SPH.XTER_BANK_ACCT_SEQ," ).append("\n"); 
		query.append("		   SPH.BANK_ACCT_NO,						" ).append("\n"); 
		query.append("          (SELECT NVL(DP_PRCS_KNT, 0) FROM MDM_CURRENCY M WHERE M.CURR_CD = SPH.CURR_CD AND ROWNUM=1 ) AS PAY_CURR_PRCS," ).append("\n"); 
		query.append("          'Y' AS PERIOD_CHK," ).append("\n"); 
		query.append("          (" ).append("\n"); 
		query.append("            SELECT  SLD.lU_CD    " ).append("\n"); 
		query.append("            FROM    SCO_LU_HDR SLH" ).append("\n"); 
		query.append("                  , SCO_LU_DTL SLD" ).append("\n"); 
		query.append("            WHERE   SLH.LU_TP_CD = SLD.LU_TP_CD" ).append("\n"); 
		query.append("            AND     SLH.LU_TP_CD = 'FUNCTIONAL CURRENCY'" ).append("\n"); 
		query.append("            AND     SLH.LU_APPL_CD = 'SCO'" ).append("\n"); 
		query.append("            AND     NVL(SLD.ENBL_FLG, 'Y') = 'Y'" ).append("\n"); 
		query.append("            AND     NVL(SLD.LU_ST_DT, SYSDATE) >= SYSDATE " ).append("\n"); 
		query.append("            AND     ROWNUM = 1      " ).append("\n"); 
		query.append("          ) AS PAY_FUNC_CURR_CD" ).append("\n"); 
		query.append("          ,SPH.PAY_STS_LU_CD" ).append("\n"); 
		query.append("    FROM SAP_PAY_HDR SPH, SAP_INV_SEL_CRTE SISC ,SAP_BANK_ACCT SBA" ).append("\n"); 
		query.append("    WHERE SPH.PAY_BAT_RUN_SEQ = SISC.PAY_BAT_SEQ(+)" ).append("\n"); 
		query.append("    AND   SPH.XTER_BANK_ACCT_SEQ = SBA.BANK_ACCT_SEQ(+)" ).append("\n"); 
		query.append("    AND   SPH.PAY_DT  BETWEEN TO_DATE(REPLACE(@[fr_dt],'-',''),'YYYYMMDD') AND TO_DATE(REPLACE(@[to_dt],'-',''),'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("	#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("	    AND  SPH.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${bank_acct_nm} != '')" ).append("\n"); 
		query.append("	    AND  SPH.BANK_ACCT_NM = @[bank_acct_nm]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vndr_pay_grp_cd} != '')" ).append("\n"); 
		query.append("	    AND  SISC.VNDR_PAY_GRP_CD = @[vndr_pay_grp_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pay_mzd_lu_cd} != '')" ).append("\n"); 
		query.append("	    AND  SPH.PAY_MZD_LU_CD = @[pay_mzd_lu_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${doc_seq} != '')" ).append("\n"); 
		query.append("	    AND  SPH.DOC_SEQ = @[doc_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${pay_bat_nm} != '')" ).append("\n"); 
		query.append("	    AND  SPH.PAY_BAT_NM = @[pay_bat_nm]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vndr_nm} != '')" ).append("\n"); 
		query.append("	    AND  SPH.VNDR_NM LIKE @[vndr_nm]||'%'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("ORDER BY PAY_DT, PAY_SEQ, PAY_TP_CD, OFC_CD, VNDR_NO" ).append("\n"); 

	}
}