/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceSumByPayerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.22 
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

public class InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceSumByPayerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_DMT_4008 Payer에 대한 currency별 Normal Inv. Total, Manual Inv. Total
	  * --  InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceListRSQL와 동일한 조건절 사용함
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceSumByPayerRSQL(){
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
		params.put("s_inv_over_to",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_inv_over_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_issue_to",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceSumByPayerRSQL").append("\n"); 
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
		query.append("#if (${inv_flg} == 'N')" ).append("\n"); 
		query.append("	SELECT 'Normal Inv. Total' AS T_NAME " ).append("\n"); 
		query.append("			, T.T_CURR" ).append("\n"); 
		query.append("			, T.T_CHARGES" ).append("\n"); 
		query.append("			, T.T_INCURRED_AMT" ).append("\n"); 
		query.append("			, T.T_EXPT_AMT" ).append("\n"); 
		query.append("			, T.T_DC_AMT" ).append("\n"); 
		query.append("			, T.T_BIL_AMT" ).append("\n"); 
		query.append("			, S.T_INV_CURR" ).append("\n"); 
		query.append("			, S.T_CHR_CNT" ).append("\n"); 
		query.append("			, S.T_INV_CHG_AMT" ).append("\n"); 
		query.append("			, S.T_TAX_AMT" ).append("\n"); 
		query.append("			, S.T_INV_AMT" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT A.CHG_CURR_CD AS T_CURR" ).append("\n"); 
		query.append("	        , COUNT( B.CNTR_NO) AS T_CHARGES" ).append("\n"); 
		query.append("	      	, SUM(NVL(B.ORG_CHG_AMT, 0)) AS T_INCURRED_AMT" ).append("\n"); 
		query.append("	      	, SUM(NVL(B.SC_RFA_EXPT_AMT, 0)) AS T_EXPT_AMT" ).append("\n"); 
		query.append("	      	, SUM(NVL(B.AFT_EXPT_DC_AMT, 0)) AS T_DC_AMT" ).append("\n"); 
		query.append("	      	, SUM(NVL(B.BIL_AMT, 0)) AS T_BIL_AMT" ).append("\n"); 
		query.append("		FROM DMT_INV_MN A, DMT_INV_DTL B" ).append("\n"); 
		query.append("		WHERE ('R' = SUBSTR(A.DMDT_INV_NO,3,1) OR 'T' = SUBSTR(A.DMDT_INV_NO,3,1))" ).append("\n"); 
		query.append("		AND A.DMDT_INV_NO = B.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD = B.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("		## Tariff Type" ).append("\n"); 
		query.append("		#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("		AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_trf_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			           '$dmdt_trf_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		## AR/IF = (N, Y, H, H and LIT)" ).append("\n"); 
		query.append("		#if (${s_dmdt_ar_if_cd} != '')" ).append("\n"); 
		query.append("		AND " ).append("\n"); 
		query.append("			#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("		    (A.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("				#foreach( $dmdt_ar_if_no in ${dmdt_ar_if_list}) " ).append("\n"); 
		query.append("					#if($velocityCount < $dmdt_ar_if_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_ar_if_no', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("			           '$dmdt_ar_if_no' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				## AR/IF = L" ).append("\n"); 
		query.append("				#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("					OR (A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				## AR/IF = L" ).append("\n"); 
		query.append("				#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("					(A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## INVOICE STATUS" ).append("\n"); 
		query.append("		#if (${s_dmdt_inv_sts_cd} != '')" ).append("\n"); 
		query.append("		AND A.DMDT_INV_STS_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_inv_sts_no in ${dmdt_inv_sts_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_inv_sts_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_inv_sts_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			           '$dmdt_inv_sts_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## OFC radio box" ).append("\n"); 
		query.append("		#if (${s_inv_check} == 'N')" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach( $s_issue_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$s_issue_ofc', #else '$s_issue_ofc' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		AND TO_CHAR(A.CRE_DT,'YYYYMMDD') BETWEEN @[s_issue_fm] AND @[s_issue_to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## INV radio box" ).append("\n"); 
		query.append("		#if (${s_inv_check} == 'Y')" ).append("\n"); 
		query.append("			#if (${session_rhq_ofc_cd} != 'SINHO')" ).append("\n"); 
		query.append("			AND A.CRE_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD = @[session_rhq_ofc_cd] )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_invoice_no} != '')	" ).append("\n"); 
		query.append("				AND A.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("					#foreach( $invoice_cd in ${invoice_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $invoice_no_list.size()) " ).append("\n"); 
		query.append("							'$invoice_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$invoice_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("				AND A.BKG_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("							'$bkg_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$bkg_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("				AND A.BL_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("							'$bl_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$bl_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## OVER DAYS" ).append("\n"); 
		query.append("		#if(${s_inv_over_to} != '')" ).append("\n"); 
		query.append("		AND (TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),SYSDATE), 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT, 'YYYYMMDD'), 'YYYYMMDD')) BETWEEN @[s_inv_over_fm] AND @[s_inv_over_to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## ISSUE ID" ).append("\n"); 
		query.append("		#if(${s_issue_usr_id} != '')" ).append("\n"); 
		query.append("		AND A.CRE_USR_ID = @[s_issue_usr_id]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## PAYER" ).append("\n"); 
		query.append("		#if(${s_payer_cd} != '')" ).append("\n"); 
		query.append("			#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("			AND LPAD(A.ACT_PAYR_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("			#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("			AND A.ACT_PAYR_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("			AND LPAD(A.ACT_PAYR_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## SC NO" ).append("\n"); 
		query.append("		#if(${s_sc_no} != '')" ).append("\n"); 
		query.append("		AND A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## RFA NO" ).append("\n"); 
		query.append("		#if(${s_rfa_no} != '')" ).append("\n"); 
		query.append("		AND A.RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY A.CHG_CURR_CD	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	) T," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		SELECT A.CHG_CURR_CD AS T_CURR" ).append("\n"); 
		query.append("			, A.INV_CURR_CD AS T_INV_CURR" ).append("\n"); 
		query.append("	      	, COUNT( B.CNTR_NO) AS T_CHR_CNT" ).append("\n"); 
		query.append("	      	, SUM(NVL(B.CNTR_INV_AMT, 0)) AS T_INV_CHG_AMT" ).append("\n"); 
		query.append("	      	, SUM(NVL(B.TAX_AMT, 0)) AS T_TAX_AMT" ).append("\n"); 
		query.append("	      	, SUM(NVL(B.CNTR_INV_AMT, 0) + NVL(B.TAX_AMT, 0)) AS T_INV_AMT" ).append("\n"); 
		query.append("		FROM DMT_INV_MN A, DMT_INV_DTL B" ).append("\n"); 
		query.append("		WHERE ('R' = SUBSTR(A.DMDT_INV_NO,3,1) OR 'T' = SUBSTR(A.DMDT_INV_NO,3,1))" ).append("\n"); 
		query.append("		AND A.DMDT_INV_NO = B.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD = B.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("		## Tariff Type" ).append("\n"); 
		query.append("		#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("		AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_trf_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			           '$dmdt_trf_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		## AR/IF = (N, Y, H, H and LIT)" ).append("\n"); 
		query.append("		#if (${s_dmdt_ar_if_cd} != '')" ).append("\n"); 
		query.append("		AND " ).append("\n"); 
		query.append("			#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("		    (A.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("				#foreach( $dmdt_ar_if_no in ${dmdt_ar_if_list}) " ).append("\n"); 
		query.append("					#if($velocityCount < $dmdt_ar_if_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_ar_if_no', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("			           '$dmdt_ar_if_no' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				## AR/IF = L" ).append("\n"); 
		query.append("				#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("					OR (A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				## AR/IF = L" ).append("\n"); 
		query.append("				#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("					(A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## INVOICE STATUS" ).append("\n"); 
		query.append("		#if (${s_dmdt_inv_sts_cd} != '')" ).append("\n"); 
		query.append("		AND A.DMDT_INV_STS_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_inv_sts_no in ${dmdt_inv_sts_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_inv_sts_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_inv_sts_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			           '$dmdt_inv_sts_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## OFC radio box" ).append("\n"); 
		query.append("		#if (${s_inv_check} == 'N')" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach( $s_issue_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$s_issue_ofc', #else '$s_issue_ofc' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		AND TO_CHAR(A.CRE_DT,'YYYYMMDD') BETWEEN @[s_issue_fm] AND @[s_issue_to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## INV radio box" ).append("\n"); 
		query.append("		#if (${s_inv_check} == 'Y')" ).append("\n"); 
		query.append("			#if (${session_rhq_ofc_cd} != 'SINHO')" ).append("\n"); 
		query.append("			AND A.CRE_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD = @[session_rhq_ofc_cd] )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_invoice_no} != '')	" ).append("\n"); 
		query.append("				AND A.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("					#foreach( $invoice_cd in ${invoice_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $invoice_no_list.size()) " ).append("\n"); 
		query.append("							'$invoice_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$invoice_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("				AND A.BKG_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("							'$bkg_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$bkg_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("				AND A.BL_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("							'$bl_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$bl_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## OVER DAYS" ).append("\n"); 
		query.append("		#if(${s_inv_over_to} != '')" ).append("\n"); 
		query.append("		AND (TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),SYSDATE), 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT, 'YYYYMMDD'), 'YYYYMMDD')) BETWEEN @[s_inv_over_fm] AND @[s_inv_over_to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## ISSUE ID" ).append("\n"); 
		query.append("		#if(${s_issue_usr_id} != '')" ).append("\n"); 
		query.append("		AND A.CRE_USR_ID = @[s_issue_usr_id]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## PAYER" ).append("\n"); 
		query.append("		#if(${s_payer_cd} != '')" ).append("\n"); 
		query.append("			#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("			AND LPAD(A.ACT_PAYR_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("			#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("			AND A.ACT_PAYR_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("			AND LPAD(A.ACT_PAYR_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## SC NO" ).append("\n"); 
		query.append("		#if(${s_sc_no} != '')" ).append("\n"); 
		query.append("		AND A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## RFA NO" ).append("\n"); 
		query.append("		#if(${s_rfa_no} != '')" ).append("\n"); 
		query.append("		AND A.RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY A.CHG_CURR_CD, A.INV_CURR_CD		" ).append("\n"); 
		query.append("	) S" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	WHERE S.T_CURR = T.T_CURR" ).append("\n"); 
		query.append("	ORDER BY S.T_CURR, S.T_INV_CURR" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT 'Manual Inv. Total' AS T_NAME " ).append("\n"); 
		query.append("			, T.T_CURR" ).append("\n"); 
		query.append("			, T.T_CHARGES" ).append("\n"); 
		query.append("			, T.T_INCURRED_AMT" ).append("\n"); 
		query.append("			, T.T_EXPT_AMT" ).append("\n"); 
		query.append("			, T.T_DC_AMT" ).append("\n"); 
		query.append("			, T.T_BIL_AMT" ).append("\n"); 
		query.append("			, S.T_INV_CURR" ).append("\n"); 
		query.append("			, S.T_CHR_CNT" ).append("\n"); 
		query.append("			, S.T_INV_CHG_AMT" ).append("\n"); 
		query.append("			, S.T_TAX_AMT" ).append("\n"); 
		query.append("			, S.T_INV_AMT" ).append("\n"); 
		query.append("	FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT A.CHG_CURR_CD AS T_CURR" ).append("\n"); 
		query.append("	        , COUNT( A.DMDT_INV_NO) AS T_CHARGES" ).append("\n"); 
		query.append("		    , SUM(NVL(A.ORG_CHG_AMT,0))  AS T_INCURRED_AMT" ).append("\n"); 
		query.append("		    , SUM(NVL(A.DMDT_EXPT_AMT,0)) AS T_EXPT_AMT" ).append("\n"); 
		query.append("		    , SUM(NVL(A.DC_AMT,0)) AS T_DC_AMT" ).append("\n"); 
		query.append("	      	, SUM(NVL(A.BIL_AMT, 0)) AS T_BIL_AMT" ).append("\n"); 
		query.append("		FROM DMT_INV_MN A" ).append("\n"); 
		query.append("		WHERE 'M' = SUBSTR(DMDT_INV_NO,3,1)" ).append("\n"); 
		query.append("		## Tariff Type" ).append("\n"); 
		query.append("		#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("		AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_trf_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			           '$dmdt_trf_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		## AR/IF = (N, Y, H, H and LIT)" ).append("\n"); 
		query.append("		#if (${s_dmdt_ar_if_cd} != '')" ).append("\n"); 
		query.append("		AND " ).append("\n"); 
		query.append("			#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("		    (A.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("				#foreach( $dmdt_ar_if_no in ${dmdt_ar_if_list}) " ).append("\n"); 
		query.append("					#if($velocityCount < $dmdt_ar_if_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_ar_if_no', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("			           '$dmdt_ar_if_no' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				## AR/IF = L" ).append("\n"); 
		query.append("				#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("					OR (A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				## AR/IF = L" ).append("\n"); 
		query.append("				#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("					(A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## INVOICE STATUS" ).append("\n"); 
		query.append("		#if (${s_dmdt_inv_sts_cd} != '')" ).append("\n"); 
		query.append("		AND A.DMDT_INV_STS_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_inv_sts_no in ${dmdt_inv_sts_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_inv_sts_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_inv_sts_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			           '$dmdt_inv_sts_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## OFC radio box" ).append("\n"); 
		query.append("		#if (${s_inv_check} == 'N')" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach( $s_issue_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$s_issue_ofc', #else '$s_issue_ofc' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		AND TO_CHAR(A.CRE_DT,'YYYYMMDD') BETWEEN @[s_issue_fm] AND @[s_issue_to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## INV radio box" ).append("\n"); 
		query.append("		#if (${s_inv_check} == 'Y')" ).append("\n"); 
		query.append("			#if (${session_rhq_ofc_cd} != 'SINHO')" ).append("\n"); 
		query.append("			AND A.CRE_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD = @[session_rhq_ofc_cd] )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_invoice_no} != '')	" ).append("\n"); 
		query.append("				AND A.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("					#foreach( $invoice_cd in ${invoice_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $invoice_no_list.size()) " ).append("\n"); 
		query.append("							'$invoice_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$invoice_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("				AND A.BKG_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("							'$bkg_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$bkg_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("				AND A.BL_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("							'$bl_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$bl_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## OVER DAYS" ).append("\n"); 
		query.append("		#if(${s_inv_over_to} != '')" ).append("\n"); 
		query.append("		AND (TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),SYSDATE), 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT, 'YYYYMMDD'), 'YYYYMMDD')) BETWEEN @[s_inv_over_fm] AND @[s_inv_over_to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## ISSUE ID" ).append("\n"); 
		query.append("		#if(${s_issue_usr_id} != '')" ).append("\n"); 
		query.append("		AND A.CRE_USR_ID = @[s_issue_usr_id]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## PAYER" ).append("\n"); 
		query.append("		#if(${s_payer_cd} != '')" ).append("\n"); 
		query.append("			#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("			AND LPAD(A.ACT_PAYR_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("			#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("			AND A.ACT_PAYR_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("			AND LPAD(A.ACT_PAYR_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## SC NO" ).append("\n"); 
		query.append("		#if(${s_sc_no} != '')" ).append("\n"); 
		query.append("		AND A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## RFA NO" ).append("\n"); 
		query.append("		#if(${s_rfa_no} != '')" ).append("\n"); 
		query.append("		AND A.RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY A.CHG_CURR_CD	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	) T," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		SELECT A.CHG_CURR_CD AS T_CURR" ).append("\n"); 
		query.append("			, A.INV_CURR_CD AS T_INV_CURR" ).append("\n"); 
		query.append("	      	, COUNT( A.DMDT_INV_NO) AS T_CHR_CNT" ).append("\n"); 
		query.append("	      	, SUM(NVL(A.INV_CHG_AMT, 0)) AS T_INV_CHG_AMT" ).append("\n"); 
		query.append("	      	, SUM(NVL(A.TAX_AMT, 0)) AS T_TAX_AMT" ).append("\n"); 
		query.append("	      	, SUM(NVL(A.INV_AMT, 0)) AS T_INV_AMT" ).append("\n"); 
		query.append("		FROM DMT_INV_MN A" ).append("\n"); 
		query.append("		WHERE 'M' = SUBSTR(A.DMDT_INV_NO,3,1)" ).append("\n"); 
		query.append("		## Tariff Type" ).append("\n"); 
		query.append("		#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("		AND A.DMDT_TRF_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_trf_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			           '$dmdt_trf_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		## AR/IF = (N, Y, H, H and LIT)" ).append("\n"); 
		query.append("		#if (${s_dmdt_ar_if_cd} != '')" ).append("\n"); 
		query.append("		AND " ).append("\n"); 
		query.append("			#if(${ar_if_cnt} > 0)" ).append("\n"); 
		query.append("		    (A.DMDT_AR_IF_CD IN (" ).append("\n"); 
		query.append("				#foreach( $dmdt_ar_if_no in ${dmdt_ar_if_list}) " ).append("\n"); 
		query.append("					#if($velocityCount < $dmdt_ar_if_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_ar_if_no', " ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("			           '$dmdt_ar_if_no' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				## AR/IF = L" ).append("\n"); 
		query.append("				#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("					OR (A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				## AR/IF = L" ).append("\n"); 
		query.append("				#if (${s_ar_if_l_yn} != '')	" ).append("\n"); 
		query.append("					(A.DMDT_AR_IF_CD = 'H' AND A.INV_HLD_RSN_CD = 'LIT')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## INVOICE STATUS" ).append("\n"); 
		query.append("		#if (${s_dmdt_inv_sts_cd} != '')" ).append("\n"); 
		query.append("		AND A.DMDT_INV_STS_CD IN (" ).append("\n"); 
		query.append("			#foreach( $dmdt_inv_sts_no in ${dmdt_inv_sts_list}) " ).append("\n"); 
		query.append("				#if($velocityCount < $dmdt_inv_sts_list.size()) " ).append("\n"); 
		query.append("			           '$dmdt_inv_sts_no', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("			           '$dmdt_inv_sts_no' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## OFC radio box" ).append("\n"); 
		query.append("		#if (${s_inv_check} == 'N')" ).append("\n"); 
		query.append("		AND A.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("				#foreach( $s_issue_ofc in ${ofc_cd_list} )" ).append("\n"); 
		query.append("					#if($velocityCount < $ofc_cd_list.size()) '$s_issue_ofc', #else '$s_issue_ofc' #end" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("		AND TO_CHAR(A.CRE_DT,'YYYYMMDD') BETWEEN @[s_issue_fm] AND @[s_issue_to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## INV radio box" ).append("\n"); 
		query.append("		#if (${s_inv_check} == 'Y')" ).append("\n"); 
		query.append("			#if (${session_rhq_ofc_cd} != 'SINHO')" ).append("\n"); 
		query.append("			AND A.CRE_OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION WHERE AR_HD_QTR_OFC_CD = @[session_rhq_ofc_cd] )" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_invoice_no} != '')	" ).append("\n"); 
		query.append("				AND A.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("					#foreach( $invoice_cd in ${invoice_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $invoice_no_list.size()) " ).append("\n"); 
		query.append("							'$invoice_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$invoice_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("				AND A.BKG_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("							'$bkg_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$bkg_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("				AND A.BL_NO IN (" ).append("\n"); 
		query.append("					#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("						#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("							'$bl_cd', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("							'$bl_cd' " ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## OVER DAYS" ).append("\n"); 
		query.append("		#if(${s_inv_over_to} != '')" ).append("\n"); 
		query.append("		AND (TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(A.CRE_OFC_CD),SYSDATE), 'YYYYMMDD'), 'YYYYMMDD') - TO_DATE(TO_CHAR(A.CRE_DT, 'YYYYMMDD'), 'YYYYMMDD')) BETWEEN @[s_inv_over_fm] AND @[s_inv_over_to]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## ISSUE ID" ).append("\n"); 
		query.append("		#if(${s_issue_usr_id} != '')" ).append("\n"); 
		query.append("		AND A.CRE_USR_ID = @[s_issue_usr_id]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## PAYER" ).append("\n"); 
		query.append("		#if(${s_payer_cd} != '')" ).append("\n"); 
		query.append("			#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("			AND LPAD(A.ACT_PAYR_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("			#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("			AND A.ACT_PAYR_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("			AND LPAD(A.ACT_PAYR_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## SC NO" ).append("\n"); 
		query.append("		#if(${s_sc_no} != '')" ).append("\n"); 
		query.append("		AND A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		## RFA NO" ).append("\n"); 
		query.append("		#if(${s_rfa_no} != '')" ).append("\n"); 
		query.append("		AND A.RFA_NO = @[s_rfa_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY A.CHG_CURR_CD, A.INV_CURR_CD		" ).append("\n"); 
		query.append("	) S" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	WHERE S.T_CURR = T.T_CURR" ).append("\n"); 
		query.append("	ORDER BY S.T_CURR, S.T_INV_CURR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}