/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.09.19 
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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("         MAIN.DMDT_INV_NO AS INVNOO" ).append("\n"); 
		query.append("        ,MAIN.DMDT_TRF_CD AS CHARGE" ).append("\n"); 
		query.append("        ,MAIN.VSL_CD||MAIN.SKD_VOY_NO||MAIN.SKD_DIR_CD AS VVDCDD" ).append("\n"); 
		query.append("        ,MAIN.SC_NO AS SCNOOO" ).append("\n"); 
		query.append("        ,MAIN.BL_NO AS BLNOOO" ).append("\n"); 
		query.append("        ,DECODE ( MAIN.DMDT_TRF_CD , 'DMIF' , MAIN.POD_CD " ).append("\n"); 
		query.append("                                   , 'DMOF' , MAIN.POL_CD " ).append("\n"); 
		query.append("                                   , 'DTIC' , MAIN.DEL_CD " ).append("\n"); 
		query.append("                                   , 'CTIC' , MAIN.DEL_CD " ).append("\n"); 
		query.append("                                   , 'DTOC' , MAIN.POR_CD " ).append("\n"); 
		query.append("                                   , 'CTOC' , MAIN.POR_CD " ).append("\n"); 
		query.append("                                   , '' ) AS LOCCDD" ).append("\n"); 
		query.append("        ,DTIL.CNTR_NO AS CNTRNO" ).append("\n"); 
		query.append("        ,DTIL.CNTR_TPSZ_CD AS TYSZCD" ).append("\n"); 
		query.append("        ,TO_CHAR ( DTIL.FM_MVMT_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH' ) AS STPDFR" ).append("\n"); 
		query.append("        ,TO_CHAR ( DTIL.TO_MVMT_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH' ) AS STPDTO" ).append("\n"); 
		query.append("        ,TO_CHAR ( DTIL.FT_CMNC_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH' ) AS FTCMNC" ).append("\n"); 
		query.append("        ,TO_CHAR ( DTIL.FT_END_DT  , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH' ) AS FTCMPL" ).append("\n"); 
		query.append("        ,DTIL.FT_DYS AS FREEDY" ).append("\n"); 
		query.append("        ,DTIL.FX_FT_OVR_DYS AS OVERDY" ).append("\n"); 
		query.append("        ,MAIN.CHG_CURR_CD AS CURRCY" ).append("\n"); 
		query.append("        ,CASE WHEN (SUBSTR(MAIN.DMDT_INV_NO, 3,1) = 'M' AND NVL(DTIL.CNTR_NO,'N') = 'N') THEN MAIN.INV_CHG_AMT" ).append("\n"); 
		query.append("              WHEN (SUBSTR(MAIN.DMDT_INV_NO, 3,1) = 'M' AND NVL(DTIL.CNTR_INV_AMT,0) = 0) THEN (SELECT SUM(RT_OVR_CHG_AMT) FROM DMT_INV_RT RATE" ).append("\n"); 
		query.append("                                                                                                 WHERE DTIL.DMDT_INV_NO = RATE.DMDT_INV_NO" ).append("\n"); 
		query.append("                                                                                                   AND DTIL.CRE_OFC_CD = RATE.CRE_OFC_CD" ).append("\n"); 
		query.append("                                                                                                   AND DTIL.INV_DTL_SEQ = RATE.INV_DTL_SEQ)" ).append("\n"); 
		query.append("              ELSE DTIL.CNTR_INV_AMT" ).append("\n"); 
		query.append("              END NETAMT" ).append("\n"); 
		query.append("        ,CASE WHEN (SUBSTR(MAIN.DMDT_INV_NO, 3,1) = 'M' AND NVL(DTIL.CNTR_NO,'N') = 'N') THEN MAIN.TAX_AMT" ).append("\n"); 
		query.append("              WHEN (SUBSTR(MAIN.DMDT_INV_NO, 3,1) = 'M' AND NVL(DTIL.CNTR_INV_AMT,0) = 0) THEN (SELECT SUM(RT_OVR_CHG_AMT * MAIN.TAX_RTO * 0.01) FROM DMT_INV_RT RATE" ).append("\n"); 
		query.append("                                                                                                 WHERE DTIL.DMDT_INV_NO = RATE.DMDT_INV_NO" ).append("\n"); 
		query.append("                                                                                                   AND DTIL.CRE_OFC_CD = RATE.CRE_OFC_CD" ).append("\n"); 
		query.append("                                                                                                   AND DTIL.INV_DTL_SEQ = RATE.INV_DTL_SEQ)" ).append("\n"); 
		query.append("              ELSE DTIL.TAX_AMT" ).append("\n"); 
		query.append("              END TAXAMT" ).append("\n"); 
		query.append("        ,CASE WHEN (SUBSTR(MAIN.DMDT_INV_NO, 3,1) = 'M' AND NVL(DTIL.CNTR_NO,'N') = 'N') THEN MAIN.INV_AMT" ).append("\n"); 
		query.append("              WHEN (SUBSTR(MAIN.DMDT_INV_NO, 3,1) = 'M' AND NVL(DTIL.CNTR_INV_AMT,0) = 0) THEN (SELECT SUM((RT_OVR_CHG_AMT * MAIN.TAX_RTO * 0.01)+RT_OVR_CHG_AMT) FROM DMT_INV_RT RATE" ).append("\n"); 
		query.append("                                                                                                 WHERE DTIL.DMDT_INV_NO = RATE.DMDT_INV_NO" ).append("\n"); 
		query.append("                                                                                                   AND DTIL.CRE_OFC_CD = RATE.CRE_OFC_CD" ).append("\n"); 
		query.append("                                                                                                   AND DTIL.INV_DTL_SEQ = RATE.INV_DTL_SEQ) " ).append("\n"); 
		query.append("             ELSE ( DTIL.CNTR_INV_AMT + DTIL.TAX_AMT )" ).append("\n"); 
		query.append("             END TOTAMT" ).append("\n"); 
		query.append("##        ,DTIL.CNTR_INV_AMT NETAMT" ).append("\n"); 
		query.append("##        ,DTIL.TAX_AMT AS TAXAMT" ).append("\n"); 
		query.append("##        ,( DTIL.CNTR_INV_AMT + DTIL.TAX_AMT ) AS TOTAMT" ).append("\n"); 
		query.append("        ,TO_CHAR ( MAIN.CRE_DT , 'DDMonYY' , 'NLS_DATE_LANGUAGE=ENGLISH' ) AS ISSUDT" ).append("\n"); 
		query.append("        ,TO_DATE (TO_CHAR ( SYSDATE     , 'YYYYMMDD' ) , 'YYYYMMDD' ) - " ).append("\n"); 
		query.append("         TO_DATE (TO_CHAR ( MAIN.CRE_DT , 'YYYYMMDD' ) , 'YYYYMMDD' ) AS OVEDAY" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("         DMT_INV_MN  MAIN" ).append("\n"); 
		query.append("        ,DMT_INV_DTL DTIL" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("        MAIN.DMDT_INV_NO = DTIL.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("AND     MAIN.CRE_OFC_CD  = DTIL.CRE_OFC_CD(+)" ).append("\n"); 
		query.append("#if ( ${invno} != '' )" ).append("\n"); 
		query.append("AND     MAIN.DMDT_INV_NO IN (" ).append("\n"); 
		query.append("    #foreach( $dmdt_inv_no_p in ${tempINVNOList}) " ).append("\n"); 
		query.append("        #if($velocityCount < $tempINVNOList.size()) " ).append("\n"); 
		query.append("           '$dmdt_inv_no_p', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$dmdt_inv_no_p' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${creof} != '' )" ).append("\n"); 
		query.append("AND     MAIN.CRE_OFC_CD IN (" ).append("\n"); 
		query.append("    #foreach( $cre_ofc_cd_p in ${tempCREOFList}) " ).append("\n"); 
		query.append("        #if($velocityCount < $tempCREOFList.size()) " ).append("\n"); 
		query.append("           '$cre_ofc_cd_p', " ).append("\n"); 
		query.append("        #else " ).append("\n"); 
		query.append("           '$cre_ofc_cd_p' " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}