/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.04
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InvoiceIssueCollectionMgtDBDAOSearchBookingInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Issue 후 Invoice Creation & Issue - Booking
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchBookingInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("s_dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchBookingInvoiceRSQL").append("\n"); 
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
		query.append("WITH INV_DATA AS (" ).append("\n"); 
		query.append("	SELECT  A.DMDT_INV_NO" ).append("\n"); 
		query.append("		   ,TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("		   ,A.CRE_OFC_CD " ).append("\n"); 
		query.append("		   ,(SELECT SUBSTR(LOC_CD,0,2) FROM MDM_ORGANIZATION WHERE OFC_CD = A.CRE_OFC_CD) AS CRE_CNT_CD" ).append("\n"); 
		query.append("		   ,A.CRE_USR_ID" ).append("\n"); 
		query.append("		   ,NVL((SELECT USR_NM FROM COM_USER WHERE USR_ID = A.CRE_USR_ID),A.CRE_USR_ID) AS CRE_USR_NM" ).append("\n"); 
		query.append("		   ,A.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("		   ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01974' AND INTG_CD_VAL_CTNT = A.DMDT_INV_STS_CD) AS DMDT_INV_STS_NM" ).append("\n"); 
		query.append("		   ,A.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("		   ,TO_CHAR(A.AR_IF_DT, 'YYYY-MM-DD') AS AR_IF_DT" ).append("\n"); 
		query.append("		   ,A.AR_IF_OFC_CD" ).append("\n"); 
		query.append("		   ,A.AR_IF_USR_ID" ).append("\n"); 
		query.append("		   ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.AR_IF_USR_ID) AS AR_IF_USR_NM" ).append("\n"); 
		query.append("		   ,A.CR_INV_NO" ).append("\n"); 
		query.append("		   ,A.BKG_NO" ).append("\n"); 
		query.append("		   ,A.BL_NO" ).append("\n"); 
		query.append("		   ,A.DMDT_TRF_CD" ).append("\n"); 
		query.append("		   ,A.SC_NO" ).append("\n"); 
		query.append("		   ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("		   ,A.POR_CD" ).append("\n"); 
		query.append("		   ,A.POL_CD" ).append("\n"); 
		query.append("		   ,A.POD_CD" ).append("\n"); 
		query.append("		   ,A.DEL_CD	" ).append("\n"); 
		query.append("		   ,A.ACT_PAYR_CNT_CD||LPAD(A.ACT_PAYR_SEQ,6,'0') 	AS PAYER_CD" ).append("\n"); 
		query.append("		   " ).append("\n"); 
		query.append("#if (${caller} == '4016')" ).append("\n"); 
		query.append("		   ,A.BKG_RCV_TERM_CD || '/' || A.BKG_DE_TERM_CD 	AS RD" ).append("\n"); 
		query.append("		   ,A.DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("		   ,'' 												AS PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("		   ,'' 												AS PAYR_CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("		   ,'' 												AS PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("		   ,LPAD(A.VNDR_SEQ, 6, '0') 						AS TRUCKER_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("		   ,A.BKG_RCV_TERM_CD || '/' || A.BKG_DE_TERM_CD 	AS RD" ).append("\n"); 
		query.append("		   ,'' 												AS DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("		   ,'' 												AS PAYR_CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("		   ,'' 												AS PAYR_CNTC_PNT_FAX_NO   " ).append("\n"); 
		query.append("		   ,'' 												AS PAYR_CNTC_PNT_EML" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				SELECT  MAX(LPAD(VNDR_SEQ,6,'0'))" ).append("\n"); 
		query.append("				  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("				 WHERE  SYS_AREA_GRP_ID     = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				   AND  CNTR_NO             = B.CNTR_NO" ).append("\n"); 
		query.append("				   AND  CNTR_CYC_NO         = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("				   AND  DMDT_TRF_CD         = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("				   AND  DMDT_CHG_LOC_DIV_CD = B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				   AND  CHG_SEQ             = B.CHG_SEQ" ).append("\n"); 
		query.append("			) AS TRUCKER_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		   ,DECODE((" ).append("\n"); 
		query.append("						SELECT  DMDT_PAYR_NM                                                                                                                                            " ).append("\n"); 
		query.append("						  FROM  DMT_PAYR_INFO                                                                                                                                             " ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  SYS_AREA_GRP_ID                                                                                                               " ).append("\n"); 
		query.append("                                      FROM  COM_SYS_AREA_GRP_ID                                                                                                             " ).append("\n"); 
		query.append("                                     WHERE  CNT_CD = " ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("												SELECT  SUBSTR(LOC_CD, 1, 2)                                                                                          " ).append("\n"); 
		query.append("                                                  FROM  MDM_ORGANIZATION                                                                                                " ).append("\n"); 
		query.append("                                                 WHERE  OFC_CD = A.CRE_OFC_CD" ).append("\n"); 
		query.append("											) " ).append("\n"); 
		query.append("                                       AND  CO_IND_CD = 'H'" ).append("\n"); 
		query.append("								) " ).append("\n"); 
		query.append("						   AND  CUST_CNT_CD = A.ACT_PAYR_CNT_CD                                                                                                                            " ).append("\n"); 
		query.append("						   AND  CUST_SEQ    = A.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			       ,NULL" ).append("\n"); 
		query.append("				   ,DECODE((" ).append("\n"); 
		query.append("								SELECT  LOCL_NM" ).append("\n"); 
		query.append("								  FROM  MDM_CR_CUST" ).append("\n"); 
		query.append("								 WHERE  CUST_CNT_CD = A.ACT_PAYR_CNT_CD" ).append("\n"); 
		query.append("								   AND  CUST_SEQ    = A.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("								   AND  LOCL_NM IS NOT NULL" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					       ,NULL" ).append("\n"); 
		query.append("					       ,(" ).append("\n"); 
		query.append("								SELECT  CASE " ).append("\n"); 
		query.append("											WHEN A.ACT_PAYR_CNT_CD = '00' " ).append("\n"); 
		query.append("												THEN (" ).append("\n"); 
		query.append("														SELECT  VNDR_LGL_ENG_NM                                                                             " ).append("\n"); 
		query.append("                                                          FROM  MDM_VENDOR                                                                                                 " ).append("\n"); 
		query.append("                                                         WHERE  VNDR_SEQ = A.ACT_PAYR_SEQ                                                                                 " ).append("\n"); 
		query.append("                                                           AND  VNDR_LGL_ENG_NM IS NOT NULL" ).append("\n"); 
		query.append("													 )" ).append("\n"); 
		query.append("											ELSE (" ).append("\n"); 
		query.append("													SELECT  CUST_LGL_ENG_NM                                                                                                                " ).append("\n"); 
		query.append("													  FROM  MDM_CUSTOMER                                                                                                                     " ).append("\n"); 
		query.append("													 WHERE  CUST_CNT_CD = A.ACT_PAYR_CNT_CD                                                                                                 " ).append("\n"); 
		query.append("													   AND  CUST_SEQ     = A.ACT_PAYR_SEQ                                                                                                     " ).append("\n"); 
		query.append("													   AND  CUST_LGL_ENG_NM IS NOT NULL" ).append("\n"); 
		query.append("												 ) " ).append("\n"); 
		query.append("										END MDM_NAME                                                                                                                                " ).append("\n"); 
		query.append("								  FROM  DUAL" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("						   ,(" ).append("\n"); 
		query.append("								SELECT  LOCL_NM                                                                                                                                    " ).append("\n"); 
		query.append("								  FROM  MDM_CR_CUST                                                                                                                                   " ).append("\n"); 
		query.append("								 WHERE  CUST_CNT_CD = A.ACT_PAYR_CNT_CD                                                                                                              " ).append("\n"); 
		query.append("								   AND  CUST_SEQ    = A.ACT_PAYR_SEQ                                                                                                                   " ).append("\n"); 
		query.append("								   AND  LOCL_NM IS NOT NULL" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("					)                                                                                                                                                    " ).append("\n"); 
		query.append("              	   ,(" ).append("\n"); 
		query.append("						SELECT  DMDT_PAYR_NM                                                                                                                                             " ).append("\n"); 
		query.append("						  FROM  DMT_PAYR_INFO                                                                                                                                              " ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID = " ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									SELECT  SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                                      FROM  COM_SYS_AREA_GRP_ID                                                                                                               " ).append("\n"); 
		query.append("                                     WHERE  CNT_CD = " ).append("\n"); 
		query.append("											(" ).append("\n"); 
		query.append("												SELECT  SUBSTR(LOC_CD, 1, 2)                                                                                            " ).append("\n"); 
		query.append("                                                  FROM  MDM_ORGANIZATION                                                                                                  " ).append("\n"); 
		query.append("                                                 WHERE  OFC_CD = A.CRE_OFC_CD" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("                                       AND  CO_IND_CD = 'H'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   AND  CUST_CNT_CD = A.ACT_PAYR_CNT_CD                                                                                                                             " ).append("\n"); 
		query.append("						   AND  CUST_SEQ    = A.ACT_PAYR_SEQ" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			) 										AS ACT_PAYR_CUST_NM        -- E-mail Send용 Customer" ).append("\n"); 
		query.append("	       ,A.CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("		   ,CASE " ).append("\n"); 
		query.append("				WHEN INSTRB(REPLACE(A.INV_RMK,'@*',CHR(10)), chr(10), 1, 1) = 0 THEN" ).append("\n"); 
		query.append("					SUBSTRB(REPLACE(A.INV_RMK,'@*',CHR(10)), INSTRB(REPLACE(A.INV_RMK,'@*',CHR(10)), chr(10), -1, 1) + 1)" ).append("\n"); 
		query.append("				ELSE " ).append("\n"); 
		query.append("					SUBSTRB(REPLACE(A.INV_RMK,'@*',CHR(10)), 0, INSTRB(REPLACE(A.INV_RMK,'@*',CHR(10)), chr(10),1,1))" ).append("\n"); 
		query.append("			END 									AS INV_RMK1" ).append("\n"); 
		query.append("		   ,CASE " ).append("\n"); 
		query.append("				WHEN INSTRB(REPLACE(A.INV_RMK,'@*',CHR(10)), chr(10), 1, 1) = 0 THEN" ).append("\n"); 
		query.append("					''" ).append("\n"); 
		query.append("				ELSE " ).append("\n"); 
		query.append("					SUBSTRB(REPLACE(A.INV_RMK,'@*',CHR(10)), INSTRB(REPLACE(A.INV_RMK,'@*',CHR(10)), chr(10),-1,1)+1)" ).append("\n"); 
		query.append("			END 									AS INV_RMK2" ).append("\n"); 
		query.append("		   ,A.CHG_CURR_CD" ).append("\n"); 
		query.append("		   ,A.DMDT_CHG_TP_CD 			 			AS CHG_TYPE" ).append("\n"); 
		query.append("		   ,NVL(A.ORG_CHG_AMT,0) 		 			AS MN_ORG_CHG_AMT" ).append("\n"); 
		query.append("		   ,NVL(A.DMDT_EXPT_AMT,0)		 			AS DMDT_EXPT_AMT" ).append("\n"); 
		query.append("		   ,NVL(A.BIL_AMT,0)			 			AS MN_BIL_AMT" ).append("\n"); 
		query.append("		   ,NVL(A.AFT_INV_ADJ_AMT,0) 	 			AS AFT_INV_ADJ_AMT" ).append("\n"); 
		query.append("		   ,A.INV_CURR_CD" ).append("\n"); 
		query.append("		   ,NVL(A.INV_XCH_RT,0)			 			AS INV_XCH_RT" ).append("\n"); 
		query.append("		   ,NVL(A.BKG_CNTR_QTY,0)	 	 			AS CNTR_CNT" ).append("\n"); 
		query.append("		   ,NVL(A.DC_AMT,0)				 			AS DC_AMT" ).append("\n"); 
		query.append("		   ,NVL(A.INV_CHG_AMT,0)		 			AS INV_CHG_AMT" ).append("\n"); 
		query.append("		   ,A.TAX_RTO					 			AS INV_TAX_RTO" ).append("\n"); 
		query.append("		   ,NVL(A.TAX_AMT,0)			 			AS TAX_AMT" ).append("\n"); 
		query.append("		   ,NVL(A.INV_AMT,0)			 			AS INV_AMT" ).append("\n"); 
		query.append("		   ,TO_CHAR(A.CRE_DT,'YYYYMMDD') 			AS ISSUE_DAY" ).append("\n"); 
		query.append("		   ,A.NTC_KNT_CD" ).append("\n"); 
		query.append("		   ,A.INV_REF_NO" ).append("\n"); 
		query.append("		   ,B.SYS_AREA_GRP_ID 			 			AS SVR_ID" ).append("\n"); 
		query.append("		   ,A.DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append("		   ,REPLACE(A.CXL_RMK, '@*', CHR(10)) 		AS CXL_RMK" ).append("\n"); 
		query.append("		   ,A.INV_HLD_RSN_CD" ).append("\n"); 
		query.append("		   ,REPLACE(A.INV_HLD_RMK, '@*', CHR(10)) 	AS INV_HLD_RMK" ).append("\n"); 
		query.append("		   ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01962' AND INTG_CD_VAL_CTNT = A.DMDT_CXL_RSN_CD) AS DMDT_CXL_RSN_NM" ).append("\n"); 
		query.append("		   ,(SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID = 'CD01980' AND INTG_CD_VAL_CTNT = A.INV_HLD_RSN_CD) AS INV_HLD_RSN_NM" ).append("\n"); 
		query.append("		   ,TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("		   ,A.UPD_OFC_CD" ).append("\n"); 
		query.append("		   ,A.UPD_USR_ID" ).append("\n"); 
		query.append("		   ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.UPD_USR_ID) AS UPD_USR_NM" ).append("\n"); 
		query.append("		   ,A.MNL_INV_RMK" ).append("\n"); 
		query.append("		   -- FAX_EMAIL SENDING COUNT" ).append("\n"); 
		query.append("		   ,(SELECT COUNT(*) FROM DMT_FAX_EML_SND_HIS WHERE DMDT_INV_NO = A.DMDT_INV_NO) AS FAX_EMAIL_SND_CNT" ).append("\n"); 
		query.append("		   -- CR_AR_YN" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				SELECT  CASE " ).append("\n"); 
		query.append("							WHEN DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("								'(A/R:Y)'" ).append("\n"); 
		query.append("							WHEN DMDT_AR_IF_CD = 'N' THEN " ).append("\n"); 
		query.append("								'(A/R:N)'" ).append("\n"); 
		query.append("							ELSE " ).append("\n"); 
		query.append("								''" ).append("\n"); 
		query.append("						END" ).append("\n"); 
		query.append("				  FROM  DMT_INV_MN" ).append("\n"); 
		query.append("				 WHERE  BKG_NO = A.BKG_NO " ).append("\n"); 
		query.append("                   AND  CR_INV_NO = A.DMDT_INV_NO" ).append("\n"); 
		query.append("			) AS CR_AR_YN" ).append("\n"); 
		query.append("		   ,DECODE(A.INV_PRT_FLG, 'Y', 'P','') AS INV_PRT_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   ,(SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = A.CRE_OFC_CD) AS RHQ_OFC_CD" ).append("\n"); 
		query.append("		   ,IDA_EXPN_TAX_RT     	" ).append("\n"); 
		query.append("		   ,IDA_EXPN_TAX" ).append("\n"); 
		query.append("		   ,IDA_EDU_TAX_RT      	" ).append("\n"); 
		query.append("		   ,IDA_EDU_TAX" ).append("\n"); 
		query.append("		   ,IDA_HIGH_EDU_TAX_RT 	" ).append("\n"); 
		query.append("		   ,IDA_HIGH_EDU_TAX" ).append("\n"); 
		query.append("		   ,IDA_LOCL_TAX_RT     	" ).append("\n"); 
		query.append("		   ,IDA_LOCL_TAX" ).append("\n"); 
		query.append("		   ,IDA_N2ND_LOCL_TAX_RT    " ).append("\n"); 
		query.append("		   ,IDA_N2ND_LOCL_TAX" ).append("\n"); 
		query.append("		   ,NVL(A.INV_NEW_RPT_FLG,'N') AS INV_NEW_RPT_FLG" ).append("\n"); 
		query.append("		   ,A.RFA_NO" ).append("\n"); 
		query.append("		   ,(SELECT TAA_NO FROM BKG_BOOKING Z WHERE Z.BKG_NO = A.BKG_NO ) AS TAA_NO" ).append("\n"); 
		query.append("		   ,A.CRE_DT AS S_CRE_DT, OTS_CLT_FLG" ).append("\n"); 
		query.append("		   ,CASE " ).append("\n"); 
		query.append("				WHEN ATTR_CTNT1 IS NULL THEN" ).append("\n"); 
		query.append("                 -- AUTO I/F 가 아닐 경우 (INVOICE 발행 OFFICE 가 AUTO I/F 대상 OFFICE 가 아닐 경우)" ).append("\n"); 
		query.append("                    CASE " ).append("\n"); 
		query.append("						WHEN DMDT_INV_STS_CD = 'I' AND DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("							'Y'" ).append("\n"); 
		query.append("                        ELSE " ).append("\n"); 
		query.append("							'N'" ).append("\n"); 
		query.append("                    END" ).append("\n"); 
		query.append("                ELSE -- AUTO I/F 일 경우 (INVOICE 발행 OFFICE 가 AUTO I/F 대상 OFFICE 일 경우)" ).append("\n"); 
		query.append("                    NVL(OTS_CLT_FLG, 'N')" ).append("\n"); 
		query.append("			END VT_COLLECTED" ).append("\n"); 
		query.append("           ,CASE " ).append("\n"); 
		query.append("				WHEN ATTR_CTNT1 IS NOT NULL THEN " ).append("\n"); 
		query.append("					'Y' " ).append("\n"); 
		query.append("				ELSE " ).append("\n"); 
		query.append("					'N' " ).append("\n"); 
		query.append("			END AUTO_AR_IF_OFC_FLG  " ).append("\n"); 
		query.append("	       ,A.BIL_AMT" ).append("\n"); 
		query.append("           ,A.IDA_CGST_RTO" ).append("\n"); 
		query.append("           ,A.IDA_CGST_AMT" ).append("\n"); 
		query.append("           ,A.IDA_SGST_RTO" ).append("\n"); 
		query.append("           ,A.IDA_SGST_AMT" ).append("\n"); 
		query.append("		   ,A.IDA_IGST_RTO" ).append("\n"); 
		query.append("           ,A.IDA_IGST_AMT" ).append("\n"); 
		query.append("		   ,A.IDA_UGST_RTO" ).append("\n"); 
		query.append("           ,A.IDA_UGST_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  FROM  DMT_INV_MN 			A" ).append("\n"); 
		query.append("	       ,DMT_INV_DTL 		B" ).append("\n"); 
		query.append("	       ,MDM_VENDOR 			VENDOR" ).append("\n"); 
		query.append("           ,DMT_HRD_CDG_CTNT 	D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 WHERE  A.DMDT_INV_NO   = B.DMDT_INV_NO" ).append("\n"); 
		query.append("	   AND  A.CRE_OFC_CD    = D.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("	   AND  D.HRD_CDG_ID(+) = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("	   AND  A.CRE_OFC_CD    = B.CRE_OFC_CD" ).append("\n"); 
		query.append("	   AND  A.DMDT_INV_NO   = @[s_invoice_no]" ).append("\n"); 
		query.append("	   AND  A.CRE_OFC_CD    = @[ofc_cd]" ).append("\n"); 
		query.append("	   AND  A.DMDT_TRF_CD   = @[s_dmdt_trf_cd]" ).append("\n"); 
		query.append("	   AND  A.VNDR_SEQ      = VENDOR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	   AND  ROWNUM          = 1" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  T1.*" ).append("\n"); 
		query.append("       ,CASE " ).append("\n"); 
		query.append("			WHEN VT_COLLECTED = 'Y' THEN " ).append("\n"); 
		query.append("				INV_CHG_AMT" ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("				T2.INV_COL_CHARGE" ).append("\n"); 
		query.append("		END COL_CHARGE" ).append("\n"); 
		query.append("	   ,CASE " ).append("\n"); 
		query.append("			WHEN VT_COLLECTED = 'Y' THEN " ).append("\n"); 
		query.append("				TAX_AMT" ).append("\n"); 
		query.append("			ELSE " ).append("\n"); 
		query.append("				T2.INV_COL_TAX" ).append("\n"); 
		query.append("		END COL_TAX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  -- 납부금(INVOICE CURRENC)" ).append("\n"); 
		query.append("	   ,T2.INV_COL_CHARGE" ).append("\n"); 
		query.append("	   ,T2.INV_COL_TAX" ).append("\n"); 
		query.append("	  -- 납부금(CHARGE CURRENC)" ).append("\n"); 
		query.append("	   ,T2.CHG_COL_CHARGE" ).append("\n"); 
		query.append("	   ,T2.CHG_COL_TAX" ).append("\n"); 
		query.append("      -- 미수금(INVOICE CURRENCY)" ).append("\n"); 
		query.append("	   ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', INV_AMT-(NVL(INV_COL_CHARGE,0)+NVL(INV_COL_TAX,0)), DECODE(VT_COLLECTED, 'Y', 0, INV_AMT))  INV_UNCOL_AMT" ).append("\n"); 
		query.append("      -- 미수금(CHARGE CURRENCY)" ).append("\n"); 
		query.append("	   ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', BIL_AMT - NVL(CHG_COL_CHARGE,0), DECODE(VT_COLLECTED, 'Y', 0, BIL_AMT ))  CHG_UNCOL_AMT" ).append("\n"); 
		query.append("	   ,TO_CHAR(COL_DATE, 'YYYY-MM-DD') AS COL_DATE" ).append("\n"); 
		query.append("	   ,OTS_CLT_FLG" ).append("\n"); 
		query.append("	   ,DECODE(NVL(OTS_CLT_FLG,'N')" ).append("\n"); 
		query.append("			,'Y'" ).append("\n"); 
		query.append("			,(TO_DATE(TO_CHAR(COL_DATE,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(T1.S_CRE_DT,'YYYYMMDD'),'YYYYMMDD'))" ).append("\n"); 
		query.append("			,(TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(T1.CRE_OFC_CD),SYSDATE),'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(T1.S_CRE_DT,'YYYYMMDD'),'YYYYMMDD'))" ).append("\n"); 
		query.append("		) AS COL_OVER_DAY" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("  FROM  INV_DATA T1" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  A.DMDT_INV_NO " ).append("\n"); 
		query.append("	               ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'M',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) 			AS INV_COL_CHARGE" ).append("\n"); 
		query.append("    	           ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'V',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) 			AS INV_COL_TAX" ).append("\n"); 
		query.append("                   ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'M',ROUND(INV_PAY_AMT/DECODE(A.INV_CURR_CD,B.INV_CURR_CD,INV_XCH_RT,1),2),0)) AS CHG_COL_CHARGE" ).append("\n"); 
		query.append("    	           ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'V',ROUND(INV_PAY_AMT/DECODE(A.INV_CURR_CD,B.INV_CURR_CD,INV_XCH_RT,1),2),0)) AS CHG_COL_TAX" ).append("\n"); 
		query.append("		           ,MAX(INV_PAY_DT)	AS COL_DATE" ).append("\n"); 
		query.append("		           ,MAX(INV_PAY_COFF_DT) AS COL_DUE_DT" ).append("\n"); 
		query.append("			  FROM  DMT_INV_OTS_PAY_RCV A" ).append("\n"); 
		query.append("                   ,INV_DATA 			B" ).append("\n"); 
		query.append("			 WHERE  B.DMDT_INV_NO = A.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("			GROUP BY A.DMDT_INV_NO" ).append("\n"); 
		query.append("		) T2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE  T1.DMDT_INV_NO = T2.DMDT_INV_NO(+)" ).append("\n"); 

	}
}