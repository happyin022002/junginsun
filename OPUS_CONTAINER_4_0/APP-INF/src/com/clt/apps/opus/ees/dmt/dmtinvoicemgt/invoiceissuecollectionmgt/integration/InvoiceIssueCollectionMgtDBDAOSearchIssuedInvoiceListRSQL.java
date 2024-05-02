/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Issued Invoice Inquiry - By Booking, By Container
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_issue_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_over",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("session_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_issue_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_issue_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceListRSQL").append("\n"); 
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
		query.append("#if(${s_group_by} == '1')" ).append("\n"); 
		query.append("	SELECT DISTINCT A.DMDT_INV_NO" ).append("\n"); 
		query.append("			,A.INV_PRT_FLG" ).append("\n"); 
		query.append("			,A.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("			,A.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("			,A.DMDT_TRF_CD" ).append("\n"); 
		query.append("			,A.BKG_NO" ).append("\n"); 
		query.append("			,A.BL_NO" ).append("\n"); 
		query.append("			,'' AS CNTR_NO" ).append("\n"); 
		query.append("			,A.SC_NO" ).append("\n"); 
		query.append("			,A.RFA_NO" ).append("\n"); 
		query.append("			,A.CHG_CURR_CD" ).append("\n"); 
		query.append("			,A.ORG_CHG_AMT" ).append("\n"); 
		query.append("			,A.DMDT_EXPT_AMT" ).append("\n"); 
		query.append("			,A.DC_AMT" ).append("\n"); 
		query.append("			,A.BIL_AMT" ).append("\n"); 
		query.append("			,A.INV_CURR_CD" ).append("\n"); 
		query.append("			,A.INV_CHG_AMT" ).append("\n"); 
		query.append("			,A.TAX_AMT" ).append("\n"); 
		query.append("			,A.INV_AMT" ).append("\n"); 
		query.append("			,DECODE(SUBSTR(A.DMDT_TRF_CD,3,1),'I',A.POD_CD,A.POL_CD) AS PORT" ).append("\n"); 
		query.append("			,TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("			,A.CRE_OFC_CD" ).append("\n"); 
		query.append("			,A.CRE_USR_ID AS ISSUE_ID" ).append("\n"); 
		query.append("			,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID) AS ISSUE_NM" ).append("\n"); 
		query.append("			,DECODE(A.DMDT_AR_IF_CD,'Y',A.AR_IF_NO,'') AS AR_IF_NO" ).append("\n"); 
		query.append("			,TO_CHAR(A.AR_IF_DT, 'YYYY-MM-DD') AS AR_IF_DT" ).append("\n"); 
		query.append("			,A.AR_IF_OFC_CD" ).append("\n"); 
		query.append("			,A.AR_IF_USR_ID" ).append("\n"); 
		query.append("			,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.AR_IF_USR_ID) AS AR_IF_USR_NM" ).append("\n"); 
		query.append("			,DECODE(NVL(A.DMDT_AR_IF_CD,'N'), 'Y', (TO_DATE(TO_CHAR(A.AR_IF_DT,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT,'YYYYMMDD'),'YYYYMMDD')), " ).append("\n"); 
		query.append("	                                              (TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),SYSDATE),'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT,'YYYYMMDD'),'YYYYMMDD'))) " ).append("\n"); 
		query.append("			 AS INV_OVER" ).append("\n"); 
		query.append("			,DECODE(A.ACT_PAYR_CNT_CD, '00', NULL ,A.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("			 ||DECODE(LPAD(A.ACT_PAYR_SEQ, 6,'0'), '000000', NULL, LPAD(A.ACT_PAYR_SEQ, 6,'0')) AS ACT_PAYR_CD" ).append("\n"); 
		query.append("			,CASE WHEN A.ACT_PAYR_CNT_CD = '00' THEN (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("	              ELSE (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.ACT_PAYR_CNT_CD AND CUST_SEQ = A.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("	         END ACT_PAYR_NM" ).append("\n"); 
		query.append("			,CASE WHEN A.ACT_PAYR_CNT_CD = '00' THEN (SELECT DELT_FLG FROM MDM_VENDOR WHERE VNDR_SEQ = A.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("				  ELSE (SELECT DELT_FLG FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.ACT_PAYR_CNT_CD AND CUST_SEQ = A.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("			 END ACT_DELT_FLG" ).append("\n"); 
		query.append("			,A.CR_INV_NO" ).append("\n"); 
		query.append("			,DECODE(A.RFA_NO, NULL,	(SELECT  PROP_OFC_CD" ).append("\n"); 
		query.append("									 FROM    PRI_SP_MN," ).append("\n"); 
		query.append("											 PRI_SP_HDR" ).append("\n"); 
		query.append("									 WHERE   PRI_SP_MN.PROP_NO   =   PRI_SP_HDR.PROP_NO" ).append("\n"); 
		query.append("									 AND     PRI_SP_HDR.SC_NO    =   A.SC_NO" ).append("\n"); 
		query.append("									 AND     ROWNUM              =   1)" ).append("\n"); 
		query.append("								  , (SELECT  PROP_OFC_CD" ).append("\n"); 
		query.append("									 FROM    PRI_RP_MN," ).append("\n"); 
		query.append("											 PRI_RP_HDR" ).append("\n"); 
		query.append("									 WHERE   PRI_RP_MN.PROP_NO   =   PRI_RP_HDR.PROP_NO" ).append("\n"); 
		query.append("									 AND     PRI_RP_HDR.RFA_NO   =   A.RFA_NO" ).append("\n"); 
		query.append("									 AND     ROWNUM              =   1)  )" ).append("\n"); 
		query.append("			 AS CTRT_OFC" ).append("\n"); 
		query.append("	FROM DMT_INV_MN A, DMT_INV_DTL B" ).append("\n"); 
		query.append("	WHERE A.DMDT_INV_NO = B.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("	AND A.CRE_OFC_CD = B.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("	-- Tariff Type" ).append("\n"); 
		query.append("	#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("	AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("		#foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("			#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("		           '$dmdt_trf_no', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		           '$dmdt_trf_no' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	-- AR/IF = (N, Y, H, H and LIT)" ).append("\n"); 
		query.append("	#if (${s_dmdt_ar_if_cd} != '')" ).append("\n"); 
		query.append("	AND " ).append("\n"); 
		query.append("		#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("	    (A.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_ar_if_no in ${dmdt_ar_if_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_ar_if_list.size()) " ).append("\n"); 
		query.append("		           '$dmdt_ar_if_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("		           '$dmdt_ar_if_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			-- AR/IF = L" ).append("\n"); 
		query.append("			#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("				OR (A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			-- AR/IF = L" ).append("\n"); 
		query.append("			#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("				(A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- INVOICE STATUS" ).append("\n"); 
		query.append("	#if (${s_dmdt_inv_sts_cd} != '')" ).append("\n"); 
		query.append("	AND A.DMDT_INV_STS_CD IN (" ).append("\n"); 
		query.append("		#foreach( $dmdt_inv_sts_no in ${dmdt_inv_sts_list}) " ).append("\n"); 
		query.append("			#if($velocityCount < $dmdt_inv_sts_list.size()) " ).append("\n"); 
		query.append("		           '$dmdt_inv_sts_no', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		           '$dmdt_inv_sts_no' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- OFC radio box" ).append("\n"); 
		query.append("	#if (${s_inv_check} == 'N')" ).append("\n"); 
		query.append("	AND A.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach( $s_issue_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $ofc_cd_list.size()) '$s_issue_ofc', #else '$s_issue_ofc' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	AND TO_CHAR(A.CRE_DT,'YYYYMMDD') BETWEEN @[s_issue_fm] AND @[s_issue_to]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- INV radio box" ).append("\n"); 
		query.append("	#if (${s_inv_check} == 'Y')" ).append("\n"); 
		query.append("--2010.02.18 하드코딩 삭제 작업" ).append("\n"); 
		query.append("		#if (${session_rhq_ofc_cd} != ${head_office})" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD = @[session_rhq_ofc_cd] )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_invoice_no} != '')	" ).append("\n"); 
		query.append("			AND A.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("				#foreach( $invoice_cd in ${invoice_no_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $invoice_no_list.size()) " ).append("\n"); 
		query.append("						'$invoice_cd', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$invoice_cd' " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("			AND A.BKG_NO IN (" ).append("\n"); 
		query.append("				#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("						'$bkg_cd', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$bkg_cd' " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("			AND A.BL_NO IN (" ).append("\n"); 
		query.append("				#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("						'$bl_cd', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$bl_cd' " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- OVER DAYS" ).append("\n"); 
		query.append("	#if(${s_inv_over} != '')" ).append("\n"); 
		query.append("	AND (TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),SYSDATE), 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT, 'YYYYMMDD'), 'YYYYMMDD')) > = @[s_inv_over]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- ISSUE ID" ).append("\n"); 
		query.append("	#if(${s_issue_usr_id} != '')" ).append("\n"); 
		query.append("	AND A.CRE_USR_ID = @[s_issue_usr_id]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- PAYER" ).append("\n"); 
		query.append("	#if(${s_payer_cd} != '')" ).append("\n"); 
		query.append("		#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("		AND LPAD(A.ACT_PAYR_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("		#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("		AND A.ACT_PAYR_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("		AND LPAD(A.ACT_PAYR_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- SC NO" ).append("\n"); 
		query.append("	#if(${s_sc_no} != '')" ).append("\n"); 
		query.append("	AND A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- RFA NO" ).append("\n"); 
		query.append("	#if(${s_rfa_no} != '')" ).append("\n"); 
		query.append("	AND A.RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	ORDER BY A.DMDT_INV_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${s_group_by} == '2')" ).append("\n"); 
		query.append("	SELECT A.DMDT_INV_NO" ).append("\n"); 
		query.append("			,A.INV_PRT_FLG" ).append("\n"); 
		query.append("			,A.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("			,A.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("			,A.DMDT_TRF_CD" ).append("\n"); 
		query.append("			,A.BKG_NO" ).append("\n"); 
		query.append("			,A.BL_NO" ).append("\n"); 
		query.append("			,B.CNTR_NO" ).append("\n"); 
		query.append("			,A.SC_NO" ).append("\n"); 
		query.append("			,A.RFA_NO" ).append("\n"); 
		query.append("			,A.CHG_CURR_CD" ).append("\n"); 
		query.append("			,B.ORG_CHG_AMT" ).append("\n"); 
		query.append("			,B.SC_RFA_EXPT_AMT AS DMDT_EXPT_AMT" ).append("\n"); 
		query.append("			,B.AFT_EXPT_DC_AMT AS DC_AMT" ).append("\n"); 
		query.append("			,B.BIL_AMT" ).append("\n"); 
		query.append("			,A.INV_CURR_CD" ).append("\n"); 
		query.append("			,B.CNTR_INV_AMT AS INV_CHG_AMT" ).append("\n"); 
		query.append("			,B.TAX_AMT" ).append("\n"); 
		query.append("			,(B.CNTR_INV_AMT + B.TAX_AMT)  AS INV_AMT" ).append("\n"); 
		query.append("			,DECODE(SUBSTR(A.DMDT_TRF_CD,3,1),'I',A.POD_CD,A.POL_CD) AS PORT" ).append("\n"); 
		query.append("			,TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("			,A.CRE_OFC_CD" ).append("\n"); 
		query.append("			,A.CRE_USR_ID AS ISSUE_ID" ).append("\n"); 
		query.append("			,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID) AS ISSUE_NM" ).append("\n"); 
		query.append("			,DECODE(A.DMDT_AR_IF_CD,'Y',A.AR_IF_NO,'') AS AR_IF_NO" ).append("\n"); 
		query.append("			,TO_CHAR(A.AR_IF_DT, 'YYYY-MM-DD') AS AR_IF_DT" ).append("\n"); 
		query.append("			,A.AR_IF_OFC_CD" ).append("\n"); 
		query.append("			,A.AR_IF_USR_ID" ).append("\n"); 
		query.append("			,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.AR_IF_USR_ID) AS AR_IF_USR_NM" ).append("\n"); 
		query.append("			,DECODE(NVL(A.DMDT_AR_IF_CD,'N'), 'Y', (TO_DATE(TO_CHAR(A.AR_IF_DT,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT,'YYYYMMDD'),'YYYYMMDD')), " ).append("\n"); 
		query.append("	                                              (TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),SYSDATE),'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT,'YYYYMMDD'),'YYYYMMDD'))) " ).append("\n"); 
		query.append("			 AS INV_OVER" ).append("\n"); 
		query.append("			,DECODE(A.ACT_PAYR_CNT_CD, '00', NULL ,A.ACT_PAYR_CNT_CD)" ).append("\n"); 
		query.append("			 ||DECODE(LPAD(A.ACT_PAYR_SEQ, 6,'0'), '000000', NULL, LPAD(A.ACT_PAYR_SEQ, 6,'0')) AS ACT_PAYR_CD" ).append("\n"); 
		query.append("			,CASE WHEN A.ACT_PAYR_CNT_CD = '00' THEN (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("	              ELSE (SELECT CUST_LGL_ENG_NM FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.ACT_PAYR_CNT_CD AND CUST_SEQ = A.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("	         END ACT_PAYR_NM" ).append("\n"); 
		query.append("			,CASE WHEN A.ACT_PAYR_CNT_CD = '00' THEN (SELECT DELT_FLG FROM MDM_VENDOR WHERE VNDR_SEQ = A.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("				  ELSE (SELECT DELT_FLG FROM MDM_CUSTOMER WHERE CUST_CNT_CD = A.ACT_PAYR_CNT_CD AND CUST_SEQ = A.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("			 END ACT_DELT_FLG" ).append("\n"); 
		query.append("			,A.CR_INV_NO" ).append("\n"); 
		query.append("			,DECODE(A.RFA_NO, NULL,	(SELECT  PROP_OFC_CD" ).append("\n"); 
		query.append("									 FROM    PRI_SP_MN," ).append("\n"); 
		query.append("											 PRI_SP_HDR" ).append("\n"); 
		query.append("									 WHERE   PRI_SP_MN.PROP_NO   =   PRI_SP_HDR.PROP_NO" ).append("\n"); 
		query.append("									 AND     PRI_SP_HDR.SC_NO    =   A.SC_NO" ).append("\n"); 
		query.append("									 AND     ROWNUM              =   1)" ).append("\n"); 
		query.append("								  , (SELECT  PROP_OFC_CD" ).append("\n"); 
		query.append("									 FROM    PRI_RP_MN," ).append("\n"); 
		query.append("											 PRI_RP_HDR" ).append("\n"); 
		query.append("									 WHERE   PRI_RP_MN.PROP_NO   =   PRI_RP_HDR.PROP_NO" ).append("\n"); 
		query.append("									 AND     PRI_RP_HDR.RFA_NO   =   A.RFA_NO" ).append("\n"); 
		query.append("									 AND     ROWNUM              =   1)  )" ).append("\n"); 
		query.append("			 AS CTRT_OFC" ).append("\n"); 
		query.append("	FROM DMT_INV_MN A, DMT_INV_DTL B" ).append("\n"); 
		query.append("	WHERE A.DMDT_INV_NO = B.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("	AND A.CRE_OFC_CD = B.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("	-- Tariff Type" ).append("\n"); 
		query.append("	#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("	AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("		#foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("			#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("		           '$dmdt_trf_no', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		           '$dmdt_trf_no' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	-- AR/IF = (N, Y, H, H and LIT)" ).append("\n"); 
		query.append("	#if (${s_dmdt_ar_if_cd} != '')" ).append("\n"); 
		query.append("	AND " ).append("\n"); 
		query.append("		#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("	    (A.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_ar_if_no in ${dmdt_ar_if_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_ar_if_list.size()) " ).append("\n"); 
		query.append("		           '$dmdt_ar_if_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("		           '$dmdt_ar_if_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			-- AR/IF = L" ).append("\n"); 
		query.append("			#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("				OR (A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			-- AR/IF = L" ).append("\n"); 
		query.append("			#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("				(A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- INVOICE STATUS" ).append("\n"); 
		query.append("	#if (${s_dmdt_inv_sts_cd} != '')" ).append("\n"); 
		query.append("	AND A.DMDT_INV_STS_CD IN (" ).append("\n"); 
		query.append("		#foreach( $dmdt_inv_sts_no in ${dmdt_inv_sts_list}) " ).append("\n"); 
		query.append("			#if($velocityCount < $dmdt_inv_sts_list.size()) " ).append("\n"); 
		query.append("		           '$dmdt_inv_sts_no', " ).append("\n"); 
		query.append("			#else " ).append("\n"); 
		query.append("		           '$dmdt_inv_sts_no' " ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- OFC radio box" ).append("\n"); 
		query.append("	#if (${s_inv_check} == 'N')" ).append("\n"); 
		query.append("	AND A.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach( $s_issue_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("				#if($velocityCount < $ofc_cd_list.size()) '$s_issue_ofc', #else '$s_issue_ofc' #end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	AND TO_CHAR(A.CRE_DT,'YYYYMMDD') BETWEEN @[s_issue_fm] AND @[s_issue_to]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- INV radio box" ).append("\n"); 
		query.append("	#if (${s_inv_check} == 'Y')" ).append("\n"); 
		query.append("		#if (${session_rhq_ofc_cd} != 'SINHO')" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD = @[session_rhq_ofc_cd] )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_invoice_no} != '')	" ).append("\n"); 
		query.append("			AND A.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("				#foreach( $invoice_cd in ${invoice_no_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $invoice_no_list.size()) " ).append("\n"); 
		query.append("						'$invoice_cd', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$invoice_cd' " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("			AND A.BKG_NO IN (" ).append("\n"); 
		query.append("				#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("						'$bkg_cd', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$bkg_cd' " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("			AND A.BL_NO IN (" ).append("\n"); 
		query.append("				#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("						'$bl_cd', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						'$bl_cd' " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- OVER DAYS" ).append("\n"); 
		query.append("	#if(${s_inv_over} != '')" ).append("\n"); 
		query.append("	AND (TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),SYSDATE), 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT, 'YYYYMMDD'), 'YYYYMMDD')) > = @[s_inv_over]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- ISSUE ID" ).append("\n"); 
		query.append("	#if(${s_issue_usr_id} != '')" ).append("\n"); 
		query.append("	AND A.CRE_USR_ID = @[s_issue_usr_id]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- PAYER" ).append("\n"); 
		query.append("	#if(${s_payer_cd} != '')" ).append("\n"); 
		query.append("		#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("		AND LPAD(A.ACT_PAYR_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("		#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("		AND A.ACT_PAYR_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("		AND LPAD(A.ACT_PAYR_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- SC NO" ).append("\n"); 
		query.append("	#if(${s_sc_no} != '')" ).append("\n"); 
		query.append("	AND A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	-- RFA NO" ).append("\n"); 
		query.append("	#if(${s_rfa_no} != '')" ).append("\n"); 
		query.append("	AND A.RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	ORDER BY A.DMDT_INV_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}