/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.21
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2011.03.21 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KimTaeKyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INVOICE 생성 및 징수관리
	  * EES_DMT_4009
	  * Outstanding Inquiry by Customer N Issue
	  * 이성훈
	  * SungHoon, Lee
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_rhq_off",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cuno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfan",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("todt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("arif",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scno",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("payc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL").append("\n"); 
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
		query.append("SELECT PA.PAYERC" ).append("\n"); 
		query.append("       ,PA.PAYERN" ).append("\n"); 
		query.append("       ,PA.INVOCN" ).append("\n"); 
		query.append("       ,PA.INVOCR" ).append("\n"); 
		query.append("       ,PA.BLLAMT" ).append("\n"); 
		query.append("       ,PA.TAXAMT" ).append("\n"); 
		query.append("       ,PA.TOTAMT" ).append("\n"); 
		query.append("       ,PA.USEFLG" ).append("\n"); 
		query.append("       ,SUM(DECODE(PB.TARFTP,'DMIF',1,0)) AS DMIFYN" ).append("\n"); 
		query.append("       ,SUM(DECODE(PB.TARFTP,'DTIC',1,0)) AS DTICYN" ).append("\n"); 
		query.append("       ,SUM(DECODE(PB.TARFTP,'DMOF',1,0)) AS DMOFYN" ).append("\n"); 
		query.append("       ,SUM(DECODE(PB.TARFTP,'DTOC',1,0)) AS DTOCYN" ).append("\n"); 
		query.append("       ,SUM(DECODE(PB.TARFTP,'CTIC',1,0)) AS CTICYN" ).append("\n"); 
		query.append("       ,SUM(DECODE(PB.TARFTP,'CTOC',1,0)) AS CTOCYN" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("		DECODE( M.ACT_PAYR_CNT_CD , '00' , '' , M.ACT_PAYR_CNT_CD )||TO_CHAR( M.ACT_PAYR_SEQ , 'FM000000' )	PAYERC," ).append("\n"); 
		query.append("        REPLACE( NVL( U.CUST_LGL_ENG_NM , V.VNDR_LGL_ENG_NM ) , '/' , '_' )									PAYERN,         /* PAYER NAME - CUSTOMER NAME OR VENDOR NAME */" ).append("\n"); 
		query.append("        NVL( COUNT(*) , 0 )                                         										INVOCN,         /* INVOICE 개수 */" ).append("\n"); 
		query.append("        M.INV_CURR_CD                                               										INVOCR,         /* INVOICE CURRENCY */" ).append("\n"); 
		query.append("        NVL( SUM( M.INV_CHG_AMT ) , 0 )                             BLLAMT,         /* TOTAL INVOICE BILLING AMOUNT */" ).append("\n"); 
		query.append("        NVL( SUM( M.TAX_AMT ) , 0 )                                 TAXAMT,         /* TOTAL INVOICE TAX AMOUNT */" ).append("\n"); 
		query.append("        NVL( SUM( M.INV_AMT ) , 0 )                                 TOTAMT,         /* TOTAL INVOICE AMOUNT = TOTAL BILLING AMOUNT + TOTAL TAX AMOUNT */" ).append("\n"); 
		query.append("		DECODE ( NVL( U.CUST_LGL_ENG_NM , 'A' ) , 'A' , V.DELT_FLG , U.DELT_FLG ) USEFLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        DMT_INV_MN      M," ).append("\n"); 
		query.append("        MDM_CUSTOMER    U," ).append("\n"); 
		query.append("        MDM_VENDOR      V" ).append("\n"); 
		query.append("		, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE   " ).append("\n"); 
		query.append("        M.CRE_DT  BETWEEN TO_DATE(@[frdt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                      AND TO_DATE(@[todt], 'YYYY-MM-DD') + .99999                     /* INVOICE ISSUE DATE */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${isof} != '' )" ).append("\n"); 
		query.append("	AND M.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $cre_ofc_cd_p in ${tempISOFList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempISOFList.size()) " ).append("\n"); 
		query.append("	           '$cre_ofc_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$cre_ofc_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.DMDT_INV_STS_CD =   'I'                                                   /* NOT CANCELED INVOICE */" ).append("\n"); 
		query.append("AND     M.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND     MO.AR_HD_QTR_OFC_CD = @[h_rhq_off]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${arif} != '' )" ).append("\n"); 
		query.append("	#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("	AND ( " ).append("\n"); 
		query.append("		M.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $dmdt_ar_if_cd_p in ${tempARIFList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempARIFList.size()) " ).append("\n"); 
		query.append("	           '$dmdt_ar_if_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$dmdt_ar_if_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("			OR (M.DMDT_AR_IF_CD = 'H' AND M.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("	AND (M.DMDT_AR_IF_CD = 'H' AND M.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	AND M.DMDT_AR_IF_CD = @[arif]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_CNT_CD   =   U.CUST_CNT_CD(+)                                    /* PAYER NAME 가져오기 위해 OUTER JOIN */" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ     =    U.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ      =   V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${tftp} != 'A' )" ).append("\n"); 
		query.append("	AND M.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $dmdt_trf_cd_p in ${tempTFTPList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempTFTPList.size()) " ).append("\n"); 
		query.append("	           '$dmdt_trf_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$dmdt_trf_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_CNT_CD     =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), M.ACT_PAYR_CNT_CD), 6, M.ACT_PAYR_CNT_CD, M.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ        =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 3, 6), M.ACT_PAYR_SEQ), 6, @[payc], M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     (   /* ------------------------------------------------------------------- SC NO */" ).append("\n"); 
		query.append("            M.SC_NO     =   NVL( SUBSTR( @[scno], 1, 10), M.SC_NO)" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            NVL(M.SC_NO, ' ') = NVL( SUBSTR( @[scno], 1, 10), ' ')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND     (   /* ------------------------------------------------------------------- RFA NO */" ).append("\n"); 
		query.append("            M.RFA_NO     =   NVL( SUBSTR( @[rfan], 1, 10), M.RFA_NO)" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            NVL(M.RFA_NO, ' ') = NVL( SUBSTR( @[rfan], 1, 10), ' ')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${cuno} != '' )" ).append("\n"); 
		query.append("AND     M.BKG_NO    IN   (" ).append("\n"); 
		query.append("                            SELECT  BKG_NO" ).append("\n"); 
		query.append("                            FROM    BKG_CUSTOMER    BC" ).append("\n"); 
		query.append("                            WHERE BC.CUST_CNT_CD = DECODE(LENGTH(@[cuno]), 8, NVL(SUBSTR(@[cuno], 1, 2), BC.CUST_CNT_CD), 6, BC.CUST_CNT_CD, BC.CUST_CNT_CD)" ).append("\n"); 
		query.append("                            AND BC.CUST_SEQ = DECODE(LENGTH(@[cuno]), 8, NVL(SUBSTR(@[cuno], 3, 6), BC.CUST_SEQ), 6, @[cuno], BC.CUST_SEQ)" ).append("\n"); 
		query.append("	#if ( ${cutp} != 'A,S,C,N' )" ).append("\n"); 
		query.append("	AND BKG_CUST_TP_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $bkg_cust_tp_cd_p in ${tempCUTPList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempCUTPList.size()) " ).append("\n"); 
		query.append("	           '$bkg_cust_tp_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$bkg_cust_tp_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND BKG_CUST_TP_CD IN ( 'S','C','N' )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY    DECODE(M.ACT_PAYR_CNT_CD, '00', '', M.ACT_PAYR_CNT_CD)||TO_CHAR( M.ACT_PAYR_SEQ , 'FM000000' ), NVL(U.CUST_LGL_ENG_NM, V.VNDR_LGL_ENG_NM), M.INV_CURR_CD, --M.DMDT_TRF_CD ," ).append("\n"); 
		query.append("DECODE ( NVL( U.CUST_LGL_ENG_NM , 'A' ) , 'A' , V.DELT_FLG , U.DELT_FLG )" ).append("\n"); 
		query.append(") PA," ).append("\n"); 
		query.append("(	/*------------------------------------- PAYER TARIFF -------------------------------------------------*/" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("	DECODE( M.ACT_PAYR_CNT_CD , '00' , '' , M.ACT_PAYR_CNT_CD )||TO_CHAR( M.ACT_PAYR_SEQ , 'FM000000' )	PAYERC," ).append("\n"); 
		query.append("	REPLACE( NVL( U.CUST_LGL_ENG_NM , V.VNDR_LGL_ENG_NM ) , '/' , '_' )									PAYERN,         /* PAYER NAME - CUSTOMER NAME OR VENDOR NAME */" ).append("\n"); 
		query.append("	DECODE ( NVL( U.CUST_LGL_ENG_NM , 'A' ) , 'A' , V.DELT_FLG , U.DELT_FLG ) USEFLG," ).append("\n"); 
		query.append("	M.DMDT_TRF_CD                                               TARFTP" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("        DMT_INV_MN      M," ).append("\n"); 
		query.append("        MDM_CUSTOMER    U," ).append("\n"); 
		query.append("        MDM_VENDOR      V" ).append("\n"); 
		query.append("		, MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("WHERE   " ).append("\n"); 
		query.append("        M.CRE_DT  BETWEEN TO_DATE(@[frdt], 'YYYY-MM-DD') " ).append("\n"); 
		query.append("                      AND TO_DATE(@[todt], 'YYYY-MM-DD') + .99999                     /* INVOICE ISSUE DATE */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${isof} != '' )" ).append("\n"); 
		query.append("	AND M.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $cre_ofc_cd_p in ${tempISOFList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempISOFList.size()) " ).append("\n"); 
		query.append("	           '$cre_ofc_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$cre_ofc_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.DMDT_INV_STS_CD =   'I'                                                   /* NOT CANCELED INVOICE */" ).append("\n"); 
		query.append("AND     M.CRE_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("AND     MO.AR_HD_QTR_OFC_CD = @[h_rhq_off]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${arif} != '' )" ).append("\n"); 
		query.append("	#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("	AND ( " ).append("\n"); 
		query.append("		M.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $dmdt_ar_if_cd_p in ${tempARIFList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempARIFList.size()) " ).append("\n"); 
		query.append("	           '$dmdt_ar_if_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$dmdt_ar_if_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("			OR (M.DMDT_AR_IF_CD = 'H' AND M.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("	AND (M.DMDT_AR_IF_CD = 'H' AND M.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	AND M.DMDT_AR_IF_CD = @[arif]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_CNT_CD   =   U.CUST_CNT_CD(+)                                    /* PAYER NAME 가져오기 위해 OUTER JOIN */" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ     =    U.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ      =   V.VNDR_SEQ(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ( ${tftp} != 'A' )" ).append("\n"); 
		query.append("	AND M.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $dmdt_trf_cd_p in ${tempTFTPList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempTFTPList.size()) " ).append("\n"); 
		query.append("	           '$dmdt_trf_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$dmdt_trf_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_CNT_CD     =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 1, 2), M.ACT_PAYR_CNT_CD), 6, M.ACT_PAYR_CNT_CD, M.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("AND     M.ACT_PAYR_SEQ        =   DECODE(LENGTH(@[payc]), 8, NVL(SUBSTR(@[payc], 3, 6), M.ACT_PAYR_SEQ), 6, @[payc], M.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     (   /* ------------------------------------------------------------------- SC NO */" ).append("\n"); 
		query.append("            M.SC_NO     =   NVL( SUBSTR( @[scno], 1, 10), M.SC_NO)" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            NVL(M.SC_NO, ' ') = NVL( SUBSTR( @[scno], 1, 10), ' ')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("AND     (   /* ------------------------------------------------------------------- RFA NO */" ).append("\n"); 
		query.append("            M.RFA_NO     =   NVL( SUBSTR( @[rfan], 1, 10), M.RFA_NO)" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("            NVL(M.RFA_NO, ' ') = NVL( SUBSTR( @[rfan], 1, 10), ' ')" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${cuno} != '' )" ).append("\n"); 
		query.append("AND     M.BKG_NO    IN   (" ).append("\n"); 
		query.append("                            SELECT  BKG_NO" ).append("\n"); 
		query.append("                            FROM    BKG_CUSTOMER    BC" ).append("\n"); 
		query.append("                            WHERE BC.CUST_CNT_CD = DECODE(LENGTH(@[cuno]), 8, NVL(SUBSTR(@[cuno], 1, 2), BC.CUST_CNT_CD), 6, BC.CUST_CNT_CD, BC.CUST_CNT_CD)" ).append("\n"); 
		query.append("                            AND BC.CUST_SEQ = DECODE(LENGTH(@[cuno]), 8, NVL(SUBSTR(@[cuno], 3, 6), BC.CUST_SEQ), 6, @[cuno], BC.CUST_SEQ)" ).append("\n"); 
		query.append("	#if ( ${cutp} != 'A,S,C,N' )" ).append("\n"); 
		query.append("	AND BKG_CUST_TP_CD IN (" ).append("\n"); 
		query.append("	    #foreach( $bkg_cust_tp_cd_p in ${tempCUTPList}) " ).append("\n"); 
		query.append("	        #if($velocityCount < $tempCUTPList.size()) " ).append("\n"); 
		query.append("	           '$bkg_cust_tp_cd_p', " ).append("\n"); 
		query.append("	        #else " ).append("\n"); 
		query.append("	           '$bkg_cust_tp_cd_p' " ).append("\n"); 
		query.append("	        #end " ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	AND BKG_CUST_TP_CD IN ( 'S','C','N' )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") PB" ).append("\n"); 
		query.append("WHERE PA.PAYERC=PB.PAYERC" ).append("\n"); 
		query.append("GROUP BY PA.PAYERC" ).append("\n"); 
		query.append("       ,PA.PAYERN" ).append("\n"); 
		query.append("       ,PA.INVOCN" ).append("\n"); 
		query.append("       ,PA.INVOCR" ).append("\n"); 
		query.append("       ,PA.BLLAMT" ).append("\n"); 
		query.append("       ,PA.TAXAMT" ).append("\n"); 
		query.append("       ,PA.TOTAMT" ).append("\n"); 
		query.append("       ,PA.USEFLG" ).append("\n"); 
		query.append("ORDER BY PA.PAYERC" ).append("\n"); 

	}
}