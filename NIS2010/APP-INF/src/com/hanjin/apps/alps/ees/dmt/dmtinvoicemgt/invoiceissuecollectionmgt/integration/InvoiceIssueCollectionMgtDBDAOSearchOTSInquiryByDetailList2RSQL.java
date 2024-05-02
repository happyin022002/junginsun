/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList2RSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * down to excel detail rate
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList2RSQL").append("\n"); 
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
		query.append("select  case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then ''" ).append("\n"); 
		query.append("				else MAIN.DMDT_INV_NO" ).append("\n"); 
		query.append("		end																	as INVNOO" ).append("\n"); 
		query.append("       ,MAIN.DMDT_TRF_CD 													as CHARGE" ).append("\n"); 
		query.append("       ,MAIN.VSL_CD||MAIN.SKD_VOY_NO||MAIN.SKD_DIR_CD 						as VVDCDD" ).append("\n"); 
		query.append("       ,MAIN.SC_NO 															as SCNOOO" ).append("\n"); 
		query.append("       ,MAIN.BL_NO 															as BLNOOO" ).append("\n"); 
		query.append("       ,decode(MAIN.DMDT_TRF_CD, 'DMIF', MAIN.POD_CD" ).append("\n"); 
		query.append("                               , 'DMOF', MAIN.POL_CD " ).append("\n"); 
		query.append("                               , 'DTIC', MAIN.DEL_CD " ).append("\n"); 
		query.append("                               , 'CTIC', MAIN.DEL_CD " ).append("\n"); 
		query.append("                               , 'DTOC', MAIN.POR_CD " ).append("\n"); 
		query.append("                               , 'CTOC', MAIN.POR_CD " ).append("\n"); 
		query.append("                               , '') 										as LOCCDD" ).append("\n"); 
		query.append("       ,DTIL.CNTR_NO 														as CNTRNO" ).append("\n"); 
		query.append("       ,DTIL.CNTR_TPSZ_CD 													as TYSZCD" ).append("\n"); 
		query.append("       ,to_char(DTIL.FM_MVMT_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH') 	as STPDFR" ).append("\n"); 
		query.append("       ,to_char(DTIL.TO_MVMT_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH') 	as STPDTO" ).append("\n"); 
		query.append("       ,to_char(DTIL.FT_CMNC_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH') 	as FTCMNC" ).append("\n"); 
		query.append("       ,to_char(DTIL.FT_END_DT  , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH') 	as FTCMPL" ).append("\n"); 
		query.append("       ,DTIL.FT_DYS 														as FREEDY" ).append("\n"); 
		query.append("--       ,DTIL.FX_FT_OVR_DYS 													as OVERDY" ).append("\n"); 
		query.append("       ,NVL(DTIL.FX_FT_OVR_DYS, DECODE(SUBSTR(MAIN.DMDT_INV_NO, 3,1), 'M', " ).append("\n"); 
		query.append("            (SELECT SUM(RT_OVR_DYS) " ).append("\n"); 
		query.append("             FROM DMT_INV_RT RATE " ).append("\n"); 
		query.append("             WHERE DTIL.DMDT_INV_NO = RATE.DMDT_INV_NO " ).append("\n"); 
		query.append("                AND DTIL.CRE_OFC_CD = RATE.CRE_OFC_CD " ).append("\n"); 
		query.append("                AND DTIL.INV_DTL_SEQ = RATE.INV_DTL_SEQ" ).append("\n"); 
		query.append("            ), 0" ).append("\n"); 
		query.append("        ))    as OVERDY" ).append("\n"); 
		query.append("       ,MAIN.CHG_CURR_CD 													as CURRCY" ).append("\n"); 
		query.append("       ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  BIL_AMT" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID 	= DTIL.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  CNTR_NO 			= DTIL.CNTR_NO" ).append("\n"); 
		query.append("						   AND  CNTR_CYC_NO 		= DTIL.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DMDT_TRF_CD 		= DTIL.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DMDT_CHG_LOC_DIV_CD = DTIL.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  CHG_SEQ 			= DTIL.CHG_SEQ" ).append("\n"); 
		query.append("					 )				" ).append("\n"); 
		query.append("			 when(substr(MAIN.DMDT_INV_NO, 3,1) = 'M' AND nvl(DTIL.CNTR_NO,'N') = 'N') " ).append("\n"); 
		query.append("				then MAIN.INV_CHG_AMT" ).append("\n"); 
		query.append("             when(substr(MAIN.DMDT_INV_NO, 3,1) = 'M' AND nvl(DTIL.CNTR_INV_AMT,0) = 0) " ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  SUM(RT_OVR_CHG_AMT) " ).append("\n"); 
		query.append("						  FROM  DMT_INV_RT RATE" ).append("\n"); 
		query.append("                         WHERE  DTIL.DMDT_INV_NO = RATE.DMDT_INV_NO" ).append("\n"); 
		query.append("                           AND  DTIL.CRE_OFC_CD = RATE.CRE_OFC_CD" ).append("\n"); 
		query.append("                           AND  DTIL.INV_DTL_SEQ = RATE.INV_DTL_SEQ" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("             else DTIL.CNTR_INV_AMT" ).append("\n"); 
		query.append("        end 																as NETAMT" ).append("\n"); 
		query.append("       ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then 0" ).append("\n"); 
		query.append("			 when(substr(MAIN.DMDT_INV_NO, 3,1) = 'M' AND nvl(DTIL.CNTR_NO,'N') = 'N') " ).append("\n"); 
		query.append("				then MAIN.TAX_AMT" ).append("\n"); 
		query.append("             when(substr(MAIN.DMDT_INV_NO, 3,1) = 'M' AND nvl(DTIL.CNTR_INV_AMT,0) = 0) " ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  SUM(RT_OVR_CHG_AMT * MAIN.TAX_RTO * 0.01) " ).append("\n"); 
		query.append("						  FROM  DMT_INV_RT RATE" ).append("\n"); 
		query.append("                         WHERE  DTIL.DMDT_INV_NO = RATE.DMDT_INV_NO" ).append("\n"); 
		query.append("                           AND  DTIL.CRE_OFC_CD  = RATE.CRE_OFC_CD" ).append("\n"); 
		query.append("                           AND  DTIL.INV_DTL_SEQ = RATE.INV_DTL_SEQ" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("             else DTIL.TAX_AMT" ).append("\n"); 
		query.append("        end 																as TAXAMT" ).append("\n"); 
		query.append("       ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  BIL_AMT" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID 	= DTIL.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  CNTR_NO 			= DTIL.CNTR_NO" ).append("\n"); 
		query.append("						   AND  CNTR_CYC_NO 		= DTIL.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DMDT_TRF_CD 		= DTIL.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DMDT_CHG_LOC_DIV_CD = DTIL.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  CHG_SEQ 			= DTIL.CHG_SEQ" ).append("\n"); 
		query.append("					 )" ).append("\n"); 
		query.append("			 when(substr(MAIN.DMDT_INV_NO, 3,1) = 'M' AND nvl(DTIL.CNTR_NO,'N') = 'N') " ).append("\n"); 
		query.append("				then MAIN.INV_AMT" ).append("\n"); 
		query.append("             when(substr(MAIN.DMDT_INV_NO, 3,1) = 'M' AND nvl(DTIL.CNTR_INV_AMT,0) = 0) " ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  SUM((RT_OVR_CHG_AMT * MAIN.TAX_RTO * 0.01)+RT_OVR_CHG_AMT) " ).append("\n"); 
		query.append("						  FROM  DMT_INV_RT RATE" ).append("\n"); 
		query.append("                         WHERE  DTIL.DMDT_INV_NO = RATE.DMDT_INV_NO" ).append("\n"); 
		query.append("                           AND  DTIL.CRE_OFC_CD  = RATE.CRE_OFC_CD" ).append("\n"); 
		query.append("                           AND  DTIL.INV_DTL_SEQ = RATE.INV_DTL_SEQ" ).append("\n"); 
		query.append("				     ) " ).append("\n"); 
		query.append("            else ( DTIL.CNTR_INV_AMT + DTIL.TAX_AMT )" ).append("\n"); 
		query.append("        end TOTAMT" ).append("\n"); 
		query.append("##     ,DTIL.CNTR_INV_AMT NETAMT" ).append("\n"); 
		query.append("##     ,DTIL.TAX_AMT AS TAXAMT" ).append("\n"); 
		query.append("##     ,(DTIL.CNTR_INV_AMT + DTIL.TAX_AMT ) AS TOTAMT" ).append("\n"); 
		query.append("	   ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then ''" ).append("\n"); 
		query.append("			 else" ).append("\n"); 
		query.append("				to_char(MAIN.CRE_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH')" ).append("\n"); 
		query.append("		end 																as ISSUDT" ).append("\n"); 
		query.append("       ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then 0" ).append("\n"); 
		query.append("			 else" ).append("\n"); 
		query.append("				to_date(to_char(sysdate, 'YYYYMMDD') , 'YYYYMMDD') - to_date(to_char(MAIN.CRE_DT , 'YYYYMMDD') , 'YYYYMMDD')" ).append("\n"); 
		query.append("		end 																as OVEDAY" ).append("\n"); 
		query.append("       ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  ORG_CHG_AMT" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID 	= DTIL.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  CNTR_NO 			= DTIL.CNTR_NO" ).append("\n"); 
		query.append("						   AND  CNTR_CYC_NO 		= DTIL.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DMDT_TRF_CD 		= DTIL.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DMDT_CHG_LOC_DIV_CD = DTIL.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  CHG_SEQ 			= DTIL.CHG_SEQ" ).append("\n"); 
		query.append("					 )		 " ).append("\n"); 
		query.append("			 else" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  ORG_CHG_AMT     " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC " ).append("\n"); 
		query.append("						 WHERE  DMDT_INV_NO = DTIL.DMDT_INV_NO " ).append("\n"); 
		query.append("						   AND  CNTR_NO     = DTIL.CNTR_NO " ).append("\n"); 
		query.append("						   AND  ROWNUM      = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		end																	as ORG_CHG_AMT" ).append("\n"); 
		query.append("       ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  CMDT_EXPT_AMT" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID 	= DTIL.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  CNTR_NO 			= DTIL.CNTR_NO" ).append("\n"); 
		query.append("						   AND  CNTR_CYC_NO 		= DTIL.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DMDT_TRF_CD 		= DTIL.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DMDT_CHG_LOC_DIV_CD = DTIL.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  CHG_SEQ 			= DTIL.CHG_SEQ" ).append("\n"); 
		query.append("					 )		 " ).append("\n"); 
		query.append("			 else" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  CMDT_EXPT_AMT     " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC " ).append("\n"); 
		query.append("						 WHERE  DMDT_INV_NO = DTIL.DMDT_INV_NO " ).append("\n"); 
		query.append("						   AND  CNTR_NO     = DTIL.CNTR_NO " ).append("\n"); 
		query.append("						   AND  ROWNUM      = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		end																	as CMDT_EXPT_AMT		" ).append("\n"); 
		query.append("       ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID 	= DTIL.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  CNTR_NO 			= DTIL.CNTR_NO" ).append("\n"); 
		query.append("						   AND  CNTR_CYC_NO 		= DTIL.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DMDT_TRF_CD 		= DTIL.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DMDT_CHG_LOC_DIV_CD = DTIL.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  CHG_SEQ 			= DTIL.CHG_SEQ" ).append("\n"); 
		query.append("					 )		 " ).append("\n"); 
		query.append("			 else" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  SC_RFA_EXPT_AMT     " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC " ).append("\n"); 
		query.append("						 WHERE  DMDT_INV_NO = DTIL.DMDT_INV_NO " ).append("\n"); 
		query.append("						   AND  CNTR_NO     = DTIL.CNTR_NO " ).append("\n"); 
		query.append("						   AND  ROWNUM      = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		end																	as SC_RFA_EXPT_AMT		" ).append("\n"); 
		query.append("       ,case when MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C'" ).append("\n"); 
		query.append("				then (" ).append("\n"); 
		query.append("						select  AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC" ).append("\n"); 
		query.append("						 WHERE  SYS_AREA_GRP_ID 	= DTIL.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						   AND  CNTR_NO 			= DTIL.CNTR_NO" ).append("\n"); 
		query.append("						   AND  CNTR_CYC_NO 		= DTIL.CNTR_CYC_NO" ).append("\n"); 
		query.append("						   AND  DMDT_TRF_CD 		= DTIL.DMDT_TRF_CD" ).append("\n"); 
		query.append("						   AND  DMDT_CHG_LOC_DIV_CD = DTIL.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("						   AND  CHG_SEQ 			= DTIL.CHG_SEQ" ).append("\n"); 
		query.append("					 )		 " ).append("\n"); 
		query.append("			 else" ).append("\n"); 
		query.append("					(" ).append("\n"); 
		query.append("						select  AFT_EXPT_DC_AMT     " ).append("\n"); 
		query.append("						  FROM  DMT_CHG_CALC " ).append("\n"); 
		query.append("						 WHERE  DMDT_INV_NO = DTIL.DMDT_INV_NO " ).append("\n"); 
		query.append("						   AND  CNTR_NO     = DTIL.CNTR_NO " ).append("\n"); 
		query.append("						   AND  ROWNUM      = 1" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("		end																	as AFT_EXPT_DC_AMT			" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  TAA_NO          " ).append("\n"); 
		query.append("			  FROM  BKG_BOOKING  " ).append("\n"); 
		query.append("			 WHERE  BKG_NO = MAIN.BKG_NO " ).append("\n"); 
		query.append("		) 																	as TAA_NO" ).append("\n"); 
		query.append("       ,MAIN.RFA_NO" ).append("\n"); 
		query.append("	   ,MAIN.POL_CD" ).append("\n"); 
		query.append("	   ,MAIN.POD_CD" ).append("\n"); 
		query.append("	   ,MAIN.DEL_CD" ).append("\n"); 
		query.append("	   ,CASE" ).append("\n"); 
		query.append("			WHEN MAIN.DMDT_INV_STS_CD = 'X' AND MAIN.DMDT_VT_INV_STS_CD = 'C' THEN" ).append("\n"); 
		query.append("				''" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("				MAIN.INV_RMK" ).append("\n"); 
		query.append("		END																as INV_RMK" ).append("\n"); 
		query.append("	   ,SH.CUST_CNT_CD||SH.CUST_SEQ SH_CUST_CD" ).append("\n"); 
		query.append("	   ,SH.CUST_NM SH_CUST_NM" ).append("\n"); 
		query.append("	   ,CN.CUST_CNT_CD||CN.CUST_SEQ CN_CUST_CD" ).append("\n"); 
		query.append("       ,CN.CUST_NM CN_CUST_NM" ).append("\n"); 
		query.append("   	   ,CASE " ).append("\n"); 
		query.append("			WHEN ATTR_CTNT1 IS NULL THEN -- AUTO I/F 가 아닐 경우 (INVOICE 발행 OFFICE 가 AUTO I/F 대상 OFFICE 가 아닐 경우)" ).append("\n"); 
		query.append("				CASE " ).append("\n"); 
		query.append("					WHEN DMDT_INV_STS_CD = 'I' AND DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("						'Y'" ).append("\n"); 
		query.append("                    ELSE " ).append("\n"); 
		query.append("						'N'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("            ELSE -- AUTO I/F 일 경우 (INVOICE 발행 OFFICE 가 AUTO I/F 대상 OFFICE 일 경우)" ).append("\n"); 
		query.append("				NVL(OTS_CLT_FLG, 'N')" ).append("\n"); 
		query.append("        END V_COLLECTED" ).append("\n"); 
		query.append("	   ,INV_XCH_RT" ).append("\n"); 
		query.append("	   ,INV_CURR_CD" ).append("\n"); 
		query.append("	   ,BKG_CNTR_QTY" ).append("\n"); 
		query.append("	   ,INV_DTL_SEQ" ).append("\n"); 
		query.append("	   ,MAIN.BIL_AMT" ).append("\n"); 
		query.append("		 " ).append("\n"); 
		query.append("  FROM  DMT_INV_MN  		MAIN" ).append("\n"); 
		query.append("       ,DMT_INV_DTL 		DTIL" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER 		SH" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER 		CN" ).append("\n"); 
		query.append("       ,DMT_HRD_CDG_CTNT 	D" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append(" WHERE  MAIN.DMDT_INV_NO 	 = DTIL.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("   AND  MAIN.CRE_OFC_CD  	 = DTIL.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("   AND  MAIN.CRE_OFC_CD      = D.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND  D.HRD_CDG_ID(+)      = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("   AND  MAIN.BKG_NO 		 = SH.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  SH.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND  MAIN.BKG_NO 		 = CN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  CN.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("#if ( ${invno} != '' )" ).append("\n"); 
		query.append("   AND  MAIN.DMDT_INV_NO in" ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $dmdt_inv_no_p in ${tempINVNOList}) " ).append("\n"); 
		query.append("				#if($velocityCount < $tempINVNOList.size()) " ).append("\n"); 
		query.append("				   '$dmdt_inv_no_p', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("				   '$dmdt_inv_no_p' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${creof} != '' )" ).append("\n"); 
		query.append("   AND  MAIN.CRE_OFC_CD in " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			#foreach( $cre_ofc_cd_p in ${tempCREOFList}) " ).append("\n"); 
		query.append("				#if($velocityCount < $tempCREOFList.size()) " ).append("\n"); 
		query.append("				   '$cre_ofc_cd_p', " ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("				   '$cre_ofc_cd_p' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append("SELECT M.* " ).append("\n"); 
		query.append("-- overpayment 관련 마이너스 금액 표시되도록 그대로 금액 반영" ).append("\n"); 
		query.append("--	,DECODE(V_COLLECTED,'Y','',COL_CHARGE1) AS COL_CHARGE" ).append("\n"); 
		query.append("--	,DECODE(V_COLLECTED,'Y','',COL_TAX1) AS COL_TAX" ).append("\n"); 
		query.append("	,COL_CHARGE1 AS COL_CHARGE" ).append("\n"); 
		query.append("	,COL_TAX1 AS COL_TAX" ).append("\n"); 
		query.append("	,NVL(NETAMT,0) - (NVL(COL_CHARGE1,0))  AS UNCOL_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T1.*" ).append("\n"); 
		query.append("--   ,CASE " ).append("\n"); 
		query.append("-- overpayment 관련 마이너스 금액 표시되도록 그대로 금액 반영" ).append("\n"); 
		query.append("--		WHEN (V_COLLECTED = 'Y')" ).append("\n"); 
		query.append("--        THEN NETAMT	" ).append("\n"); 
		query.append("--        ELSE " ).append("\n"); 
		query.append("--           CASE " ).append("\n"); 
		query.append("--			WHEN BKG_CNTR_QTY != 1                      " ).append("\n"); 
		query.append("--               THEN ROUND( COL_CHARGE * NETAMT/BIL_AMT,2)                      " ).append("\n"); 
		query.append("--               ELSE COL_CHARGE " ).append("\n"); 
		query.append("--           END" ).append("\n"); 
		query.append("--     END AS COL_CHARGE1" ).append("\n"); 
		query.append("	, COL_CHARGE AS COL_CHARGE1" ).append("\n"); 
		query.append("-- overpayment 관련 마이너스 금액 표시되도록 그대로 금액 반영" ).append("\n"); 
		query.append("--	 CASE WHEN (V_COLLECTED = 'Y')" ).append("\n"); 
		query.append("--        THEN COL_TAX	" ).append("\n"); 
		query.append("--        ELSE " ).append("\n"); 
		query.append("--           CASE WHEN BKG_CNTR_QTY != 1                   " ).append("\n"); 
		query.append("--               THEN ROUND( COL_TAX * NETAMT/BIL_AMT,2)" ).append("\n"); 
		query.append("--               ELSE COL_TAX " ).append("\n"); 
		query.append("--           END" ).append("\n"); 
		query.append("--     END AS COL_TAX1	" ).append("\n"); 
		query.append("	, COL_TAX AS COL_TAX1" ).append("\n"); 
		query.append("    , TO_CHAR(T2.COL_DATE, 'YYYY-MM-DD') AS COL_DATE" ).append("\n"); 
		query.append("    FROM INV_DATA T1" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("    	A.DMDT_INV_NO " ).append("\n"); 
		query.append("	    , SUM(DECODE(DMDT_INV_PAY_TP_CD,'M',ROUND((NETAMT/BIL_AMT)*INV_PAY_AMT/DECODE(A.INV_CURR_CD,B.CURRCY,1,INV_XCH_RT),4),0)) AS COL_CHARGE" ).append("\n"); 
		query.append("    	, SUM(DECODE(DMDT_INV_PAY_TP_CD,'V',ROUND((NETAMT/BIL_AMT)*INV_PAY_AMT/DECODE(A.INV_CURR_CD,B.CURRCY,1,INV_XCH_RT),4),0)) AS COL_TAX" ).append("\n"); 
		query.append("		, MAX(INV_PAY_DT)  AS COL_DATE" ).append("\n"); 
		query.append("		, MAX(INV_PAY_COFF_DT) AS COL_DUE_DT, CNTRNO" ).append("\n"); 
		query.append("    FROM DMT_INV_OTS_PAY_RCV A , INV_DATA B" ).append("\n"); 
		query.append("    WHERE B.INVNOO = A.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("    GROUP BY A.DMDT_INV_NO, CNTRNO" ).append("\n"); 
		query.append("    ) T2" ).append("\n"); 
		query.append("    WHERE T1.INVNOO = T2.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("    AND T1.CNTRNO = T2.CNTRNO(+)" ).append("\n"); 
		query.append("ORDER BY T1.INVNOO,T1.CNTRNO" ).append("\n"); 
		query.append(") M" ).append("\n"); 

	}
}