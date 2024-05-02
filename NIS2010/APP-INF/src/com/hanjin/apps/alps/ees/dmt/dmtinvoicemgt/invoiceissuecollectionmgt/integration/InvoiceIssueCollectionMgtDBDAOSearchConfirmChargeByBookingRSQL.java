/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.16 
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

public class InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice Creation & Issue
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_cfm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL").append("\n"); 
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
		query.append("select  BKG_NO" ).append("\n"); 
		query.append("	   ,BL_NO" ).append("\n"); 
		query.append("	   ,CNTR_CNT" ).append("\n"); 
		query.append("	   ,'' 											as GB" ).append("\n"); 
		query.append("	   ,CNTR_NO" ).append("\n"); 
		query.append("	   ,OFC_CD" ).append("\n"); 
		query.append("	   ,DMDT_TRF_CD" ).append("\n"); 
		query.append("	   ,decode(ACT_CNT_CD,'00','',ACT_CNT_CD) 		as ACT_CNT_CD" ).append("\n"); 
		query.append("	   ,decode(ACT_CUST_SEQ,0,'',ACT_CUST_SEQ) 		as ACT_CUST_SEQ" ).append("\n"); 
		query.append("	   , ( " ).append("\n"); 
		query.append("           SELECT CASE WHEN (DMDT_TRF_CD IN ('DTIC', 'CTIC') AND SUBSTR(DEL_CD,1,2) = 'US' AND BB.DE_TERM_CD = 'Y')" ).append("\n"); 
		query.append("                    OR (DMDT_TRF_CD IN ('DTOC', 'CTOC') AND SUBSTR(POR_CD,1,2) = 'US' AND BB.RCV_TERM_CD = 'Y')" ).append("\n"); 
		query.append("                       		THEN AA.VNDR_SEQ" ).append("\n"); 
		query.append("                       ELSE " ).append("\n"); 
		query.append("                              CASE WHEN SUBSTR(DMDT_TRF_CD,3,1) = 'I' AND SUBSTR(DEL_CD,1,2) IN ('US', 'CA') THEN" ).append("\n"); 
		query.append("                                                         NVL(( SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') " ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("                                                                WHERE BKG_NO = BB.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("																  AND CUST_CNT_CD IS NOT NULL AND CUST_SEQ IS NOT NULL)," ).append("\n"); 
		query.append("                                                             ( SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0')" ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("                                                                WHERE BKG_NO = BB.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND BKG_CUST_TP_CD = 'N'))" ).append("\n"); 
		query.append("                                   WHEN SUBSTR(DMDT_TRF_CD,3,1) = 'O' AND SUBSTR(POR_CD,1,2) IN ('US', 'CA') THEN" ).append("\n"); 
		query.append("                                                             ( SELECT CUST_CNT_CD||LPAD(CUST_SEQ,6,'0') " ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER " ).append("\n"); 
		query.append("                                                                WHERE BKG_NO = BB.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND BKG_CUST_TP_CD = 'S')                                   " ).append("\n"); 
		query.append("								   ELSE  NVL(" ).append("\n"); 
		query.append("											   (SELECT ACT_CUST_CNT_CD || LPAD(ACT_CUST_SEQ, 6, '0')" ).append("\n"); 
		query.append("													FROM INV_AR_MN AR" ).append("\n"); 
		query.append("													WHERE BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("													AND IO_BND_CD = SUBSTR(DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("													AND AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("																			FROM INV_AR_MN" ).append("\n"); 
		query.append("																			WHERE BKG_NO = AA.BKG_NO" ).append("\n"); 
		query.append("																			AND   IO_BND_CD = SUBSTR(DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("																	)" ).append("\n"); 
		query.append("												), DECODE(CUST_CD,'00','',CUST_CD)" ).append("\n"); 
		query.append("											)" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BB WHERE BB.BKG_NO = AA.BKG_NO ) AS CUST_CD" ).append("\n"); 
		query.append("	    ,(" ).append("\n"); 
		query.append("           SELECT CASE WHEN (DMDT_TRF_CD IN ('DTIC', 'CTIC') AND SUBSTR(DEL_CD,1,2) = 'US' AND BB.DE_TERM_CD = 'Y')" ).append("\n"); 
		query.append("                    OR (DMDT_TRF_CD IN ('DTOC', 'CTOC') AND SUBSTR(POR_CD,1,2) = 'US' AND BB.RCV_TERM_CD = 'Y')" ).append("\n"); 
		query.append("                           THEN (SELECT	VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = AA.VNDR_SEQ AND ROWNUM = 1)" ).append("\n"); 
		query.append("                       ELSE " ).append("\n"); 
		query.append("                              CASE WHEN SUBSTR(DMDT_TRF_CD,3,1) = 'I' AND SUBSTR(DEL_CD,1,2) IN ('US', 'CA') THEN" ).append("\n"); 
		query.append("                                                         NVL(( SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                                                WHERE A.BKG_NO = BB.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND A.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("																  AND A.CUST_CNT_CD IS NOT NULL AND A.CUST_SEQ IS NOT NULL" ).append("\n"); 
		query.append("                                                                  AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                  AND A.CUST_SEQ = B.CUST_SEQ " ).append("\n"); 
		query.append("                                                                  AND ROWNUM = 1 )," ).append("\n"); 
		query.append("                                                             ( SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                                                WHERE A.BKG_NO = BB.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND A.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("                                                                  AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                  AND A.CUST_SEQ = B.CUST_SEQ " ).append("\n"); 
		query.append("                                                                  AND ROWNUM = 1 ))" ).append("\n"); 
		query.append("                                   WHEN SUBSTR(DMDT_TRF_CD,3,1) = 'O' AND SUBSTR(POR_CD,1,2) IN ('US', 'CA') THEN" ).append("\n"); 
		query.append("                                                             ( SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("                                                                 FROM BKG_CUSTOMER A, MDM_CUSTOMER B" ).append("\n"); 
		query.append("                                                                WHERE A.BKG_NO = BB.BKG_NO " ).append("\n"); 
		query.append("                                                                  AND A.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("                                                                  AND A.CUST_CNT_CD = B.CUST_CNT_CD" ).append("\n"); 
		query.append("                                                                  AND A.CUST_SEQ = B.CUST_SEQ " ).append("\n"); 
		query.append("                                                                  AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                                   ELSE NVL((SELECT CUST_LGL_ENG_NM " ).append("\n"); 
		query.append("                                            	FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("                                            	WHERE (CUST_SEQ, CUST_CNT_CD) = " ).append("\n"); 
		query.append("													(SELECT ACT_CUST_SEQ, ACT_CUST_CNT_CD" ).append("\n"); 
		query.append("														FROM INV_AR_MN AR" ).append("\n"); 
		query.append("														WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("														AND IO_BND_CD = SUBSTR(AA.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("														AND AR_IF_NO = (SELECT MAX(AR_IF_NO)" ).append("\n"); 
		query.append("																			FROM INV_AR_MN" ).append("\n"); 
		query.append("																			WHERE BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("																			AND   IO_BND_CD = SUBSTR(AA.DMDT_TRF_CD,3,1)" ).append("\n"); 
		query.append("																		)" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("												), CUST_NM)" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                   END" ).append("\n"); 
		query.append("            FROM BKG_BOOKING BB WHERE BB.BKG_NO = AA.BKG_NO )CUST_NM" ).append("\n"); 
		query.append("	   ,SC_NO" ).append("\n"); 
		query.append("	   ,RFA_NO" ).append("\n"); 
		query.append("	   ,TAA_NO" ).append("\n"); 
		query.append("	   ,AR_CURR_CD" ).append("\n"); 
		query.append("	   ,SUBSTR(VVD_CD,1,4) AS VSL_CD" ).append("\n"); 
		query.append("	   ,SUBSTR(VVD_CD,5,4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("	   ,SUBSTR(VVD_CD,9,1) AS SKD_DIR_CD" ).append("\n"); 
		query.append("	   ,POL_CD" ).append("\n"); 
		query.append("	   ,POD_CD" ).append("\n"); 
		query.append("	   ,POR_CD" ).append("\n"); 
		query.append("	   ,DEL_CD" ).append("\n"); 
		query.append("	   ,BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("	   ,ORG_CHG_AMT" ).append("\n"); 
		query.append("	   ,SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("	   ,AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("	   ,BIL_AMT" ).append("\n"); 
		query.append("	   ,CHG_CUST_CNT_CD" ).append("\n"); 
		query.append("	   ,CHG_CUST_SEQ" ).append("\n"); 
		query.append("	   ,'' 											as DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("       ,DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("			select  A.BKG_NO" ).append("\n"); 
		query.append("				   ,BB.BL_NO 							as BL_NO" ).append("\n"); 
		query.append("				   ,count(A.CNTR_NO) 						as CNTR_CNT" ).append("\n"); 
		query.append("				   ,'' 										as CNTR_NO" ).append("\n"); 
		query.append("				   ,min(B.OFC_CD) 							as OFC_CD" ).append("\n"); 
		query.append("				   ,min(B.DMDT_TRF_CD) 						as DMDT_TRF_CD" ).append("\n"); 
		query.append("				   ,min(B.ACT_CNT_CD) 						as ACT_CNT_CD" ).append("\n"); 
		query.append("				   ,min(B.ACT_CUST_SEQ) 					as ACT_CUST_SEQ" ).append("\n"); 
		query.append("				   ,min(B.CUST_CNT_CD) 						as CHG_CUST_CNT_CD" ).append("\n"); 
		query.append("				   ,min(B.CUST_SEQ) 						as CHG_CUST_SEQ" ).append("\n"); 
		query.append("				   ,min(decode(B.ACT_CNT_CD, '00', '', B.ACT_CNT_CD) ||" ).append("\n"); 
		query.append("				   	  decode(B.ACT_CUST_SEQ,  0, '', LPAD(B.ACT_CUST_SEQ, 6, '0'))" ).append("\n"); 
		query.append("				   	  ) 							as CUST_CD" ).append("\n"); 
		query.append("				   ,min(decode(B.ACT_CNT_CD, '00', (select VNDR_LGL_ENG_NM from MDM_VENDOR   where VNDR_SEQ = B.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("				   							     , (select CUST_LGL_ENG_NM from MDM_CUSTOMER where CUST_CNT_CD = B.ACT_CNT_CD and CUST_SEQ = B.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				   	) 										as CUST_NM" ).append("\n"); 
		query.append("				   ,min(BB.SC_NO) 							as SC_NO" ).append("\n"); 
		query.append("				   ,min(BB.RFA_NO) 							as RFA_NO" ).append("\n"); 
		query.append("				   ,min(BB.TAA_NO) 							as TAA_NO" ).append("\n"); 
		query.append("				   ,min(B.BZC_TRF_CURR_CD) 					as BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("				   ,sum(B.ORG_CHG_AMT) 						as ORG_CHG_AMT" ).append("\n"); 
		query.append("				   ,sum(B.SC_RFA_EXPT_AMT) 					as SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("				   ,sum(B.AFT_EXPT_DC_AMT) 					as AFT_EXPT_DC_AMT" ).append("\n"); 
		query.append("				   ,sum(B.BIL_AMT) 							as BIL_AMT" ).append("\n"); 
		query.append("				   ,case " ).append("\n"); 
		query.append("						when (select AR_OFC_CD from MDM_ORGANIZATION  where OFC_CD = @[ofc_cd]) in ('MTRBS', 'TORSC', 'VANSO') then 'USD'" ).append("\n"); 
		query.append("						else (select AR_CURR_CD from MDM_ORGANIZATION where OFC_CD = @[ofc_cd])" ).append("\n"); 
		query.append("				    end										as AR_CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                   , MIN(DECODE(SUBSTR(B.DMDT_TRF_CD,3,1),'I'," ).append("\n"); 
		query.append("                     ( SELECT /*+ ORDERED USE_NL( V K )" ).append("\n"); 
		query.append("                                            INDEX    ( V XPKBKG_VVD )" ).append("\n"); 
		query.append("                                            INDEX_DESC    ( K XPKVSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                               V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("                          FROM BKG_VVD V" ).append("\n"); 
		query.append("                              ,VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("                         WHERE V.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                           AND V.POD_CD = BB.POD_CD" ).append("\n"); 
		query.append("                           AND (V.VSL_PRE_PST_CD, V.VSL_SEQ) =" ).append("\n"); 
		query.append("                                  (SELECT /*+ INDEX_DESC( VV XPKBKG_VVD) */" ).append("\n"); 
		query.append("                                          VV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                         ,VV.VSL_SEQ" ).append("\n"); 
		query.append("                                     FROM BKG_VVD VV" ).append("\n"); 
		query.append("                                    WHERE VV.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                      AND VV.POD_CD = V.POD_CD" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1)" ).append("\n"); 
		query.append("                           AND V.VSL_CD = K.VSL_CD(+)" ).append("\n"); 
		query.append("                           AND V.SKD_VOY_NO = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                           AND V.SKD_DIR_CD = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                           AND V.POD_CD = K.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                           AND V.POD_CLPT_IND_SEQ = K.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                           AND NVL (K.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                           AND ROWNUM = 1 )" ).append("\n"); 
		query.append("                   , ( SELECT /*+ ORDERED USE_NL( V K )" ).append("\n"); 
		query.append("                               INDEX    ( V XPKBKG_VVD )" ).append("\n"); 
		query.append("                               INDEX_DESC    ( K XPKVSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                           V.VSL_CD||V.SKD_VOY_NO||V.SKD_DIR_CD" ).append("\n"); 
		query.append("                      FROM BKG_VVD V" ).append("\n"); 
		query.append("                          ,VSK_VSL_PORT_SKD K" ).append("\n"); 
		query.append("                     WHERE V.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                       AND V.POL_CD = BB.POL_CD" ).append("\n"); 
		query.append("                       AND (V.VSL_PRE_PST_CD, V.VSL_SEQ) =" ).append("\n"); 
		query.append("                              (SELECT /*+ INDEX( VV XPKBKG_VVD) */" ).append("\n"); 
		query.append("                                      VV.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                     ,VV.VSL_SEQ" ).append("\n"); 
		query.append("                                 FROM BKG_VVD VV" ).append("\n"); 
		query.append("                                WHERE VV.BKG_NO = V.BKG_NO" ).append("\n"); 
		query.append("                                  AND VV.POL_CD = V.POL_CD" ).append("\n"); 
		query.append("                                  AND ROWNUM = 1)" ).append("\n"); 
		query.append("                       AND V.VSL_CD = K.VSL_CD(+)" ).append("\n"); 
		query.append("                       AND V.SKD_VOY_NO = K.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                       AND V.SKD_DIR_CD = K.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                       AND V.POL_CD = K.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("                       AND V.POL_CLPT_IND_SEQ = K.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("                       AND NVL (K.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("                       AND ROWNUM = 1 ))) AS VVD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				   ,min(BB.POL_CD) 							as POL_CD" ).append("\n"); 
		query.append("				   ,min(BB.POD_CD) 							as POD_CD" ).append("\n"); 
		query.append("				   ,min(BB.POR_CD) 							as POR_CD" ).append("\n"); 
		query.append("				   ,min(BB.DEL_CD) 							as DEL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--				   ,max(nvl(R.DMDT_DELT_RQST_STS_CD,'N'))  	as DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("--                    ,MAX( NVL( ( SELECT MAX(DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("--                              FROM DMT_CHG_DELT_RQST_APRO R" ).append("\n"); 
		query.append("--                             WHERE 1=1" ).append("\n"); 
		query.append("--                               and  B.CNTR_NO 		  = R.CNTR_NO" ).append("\n"); 
		query.append("--                               and  B.CNTR_CYC_NO 	  = R.CNTR_CYC_NO" ).append("\n"); 
		query.append("--                               and  B.SYS_AREA_GRP_ID = R.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("--                               and  B.DMDT_TRF_CD     = R.DMDT_TRF_CD ) , 'N' )) AS DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("				   ,nvl(max((" ).append("\n"); 
		query.append("				 	SELECT  CASE " ).append("\n"); 
		query.append("				 				WHEN NVL(MAX(DD.DMDT_DELT_RQST_STS_CD), 'N') IN ('C', 'N') THEN 'N'" ).append("\n"); 
		query.append("				 				WHEN 0 < MAX((	" ).append("\n"); 
		query.append("				 							SELECT  COUNT(1)" ).append("\n"); 
		query.append("				 							  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("				 							 WHERE  SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				 							   AND  CNTR_NO             = DD.CNTR_NO" ).append("\n"); 
		query.append("				 							   AND  CNTR_CYC_NO         = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("				 							   AND  DMDT_TRF_CD         = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("				 							   AND  DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				 							   AND  CHG_SEQ             = DD.CHG_SEQ" ).append("\n"); 
		query.append("				 							   AND  CHG_OFC_CD          = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("				 							   AND  DELT_SEQ            = DD.DELT_SEQ" ).append("\n"); 
		query.append("				 							   AND  CHG_DELT_PATH_LVL  >=" ).append("\n"); 
		query.append("				 									(" ).append("\n"); 
		query.append("				 										SELECT  max(CHG_DELT_PATH_LVL)" ).append("\n"); 
		query.append("				 										  FROM  DMT_CHG_DELT_PATH" ).append("\n"); 
		query.append("				 										 WHERE  SYS_AREA_GRP_ID        = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				 										   AND  CNTR_NO                = DD.CNTR_NO" ).append("\n"); 
		query.append("				 										   AND  CNTR_CYC_NO            = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("				 										   AND  DMDT_TRF_CD            = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("				 										   AND  DMDT_CHG_LOC_DIV_CD    = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				 										   AND  CHG_SEQ                = DD.CHG_SEQ" ).append("\n"); 
		query.append("				 										   AND  CHG_OFC_CD             = DD.CHG_OFC_CD" ).append("\n"); 
		query.append("				 										   AND  DELT_SEQ               = DD.DELT_SEQ" ).append("\n"); 
		query.append("				 										   AND  CHG_DELT_PATH_CPLS_FLG = 'Y'" ).append("\n"); 
		query.append("				 									)" ).append("\n"); 
		query.append("				 							   and  CHG_DELT_STS_CD IN ('A', 'J')" ).append("\n"); 
		query.append("				 						 )) THEN 'X'		--// Charge Deletion 요청 불가, Charge Deletion Cancel 불가" ).append("\n"); 
		query.append("				 				ELSE MAX(DD.DMDT_DELT_RQST_STS_CD)" ).append("\n"); 
		query.append("				 			END" ).append("\n"); 
		query.append("				 	  FROM  DMT_CHG_DELT_RQST_APRO DD" ).append("\n"); 
		query.append("				 	 WHERE  DD.SYS_AREA_GRP_ID     = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				 	   AND	DD.CNTR_NO		       = B.CNTR_NO" ).append("\n"); 
		query.append("				 	   AND	DD.CNTR_CYC_NO		   = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("				 	   AND	DD.DMDT_TRF_CD		   = B.DMDT_TRF_CD" ).append("\n"); 
		query.append("				 	   AND	DD.DMDT_CHG_LOC_DIV_CD = B.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				 	   AND	DD.CHG_SEQ			   = B.CHG_SEQ" ).append("\n"); 
		query.append("				 	   AND  DD.CHG_OFC_CD          = B.OFC_CD" ).append("\n"); 
		query.append("				 	   AND  DD.DELT_SEQ            = " ).append("\n"); 
		query.append("				 			( " ).append("\n"); 
		query.append("				 				SELECT  NVL(MAX(DS.DELT_SEQ), 0) " ).append("\n"); 
		query.append("				 				  FROM  DMT_CHG_DELT_RQST_APRO DS" ).append("\n"); 
		query.append("				 				 WHERE  DS.SYS_AREA_GRP_ID     = DD.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("				 				   AND  DS.CNTR_NO	           = DD.CNTR_NO" ).append("\n"); 
		query.append("				 				   AND  DS.CNTR_CYC_NO	       = DD.CNTR_CYC_NO" ).append("\n"); 
		query.append("				 				   AND  DS.DMDT_TRF_CD	       = DD.DMDT_TRF_CD" ).append("\n"); 
		query.append("				 				   AND  DS.DMDT_CHG_LOC_DIV_CD = DD.DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("				 				   AND  DS.CHG_SEQ		       = DD.CHG_SEQ" ).append("\n"); 
		query.append("				 				   AND  DS.CHG_OFC_CD          = DD.CHG_OFC_CD  " ).append("\n"); 
		query.append("				 			)  " ).append("\n"); 
		query.append("				    )), 'N') AS DMDT_DELT_RQST_STS_CD" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("				 	, MAX( ( SELECT	LPAD(VNDR_SEQ,6,'0') AS VNDR_CD" ).append("\n"); 
		query.append("                               FROM	MDM_VENDOR" ).append("\n"); 
		query.append("                              WHERE	VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("                                AND	DELT_FLG <> 'Y' )) VNDR_SEQ	" ).append("\n"); 
		query.append("			  from  DMT_CHG_BKG_CNTR 		A " ).append("\n"); 
		query.append("				   ,DMT_CHG_CALC 			B" ).append("\n"); 
		query.append("				   ,BKG_BOOKING				BB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--########## Confirm 된 Charge 는 무조건 Invoice 생성 대상이 되어야 함.(Office Transfer 조건과는 무관) 2015.02.26 ##############################	   " ).append("\n"); 
		query.append("			--	   ,COM_SYS_AREA_GRP_ID     C" ).append("\n"); 
		query.append("--####################################################################################################################################" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--				   ,DMT_CHG_DELT_RQST_APRO 	R" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			 where  A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("               and  A.CNTR_NO         = B.CNTR_NO" ).append("\n"); 
		query.append("			   and  A.CNTR_CYC_NO     = B.CNTR_CYC_NO" ).append("\n"); 
		query.append("			   AND  A.BKG_NO          = BB.BKG_NO" ).append("\n"); 
		query.append("--			   and  B.CNTR_NO 		  = R.CNTR_NO(+)" ).append("\n"); 
		query.append("--			   and  B.CNTR_CYC_NO 	  = R.CNTR_CYC_NO(+)" ).append("\n"); 
		query.append("--			   and  B.SYS_AREA_GRP_ID = R.SYS_AREA_GRP_ID(+)" ).append("\n"); 
		query.append("--			   and  B.DMDT_TRF_CD     = R.DMDT_TRF_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--########## Confirm 된 Charge 는 무조건 Invoice 생성 대상이 되어야 함.(Office Transfer 조건과는 무관) 2015.02.26 ##############################" ).append("\n"); 
		query.append("--			   and  (							-- OFC_TRNS_FLG 상태에 따라 쿼리가 달라짐" ).append("\n"); 
		query.append("--						(	B.OFC_TRNS_FLG = 'Y'" ).append("\n"); 
		query.append("--							and C.SYS_AREA_GRP_ID = A.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("--							and C.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("--											FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("--											WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("--							and CO_IND_CD = 'H'" ).append("\n"); 
		query.append("--							and decode(B.OFC_TRNS_RHQ_CNG_FLG, 'Y', B.SYS_AREA_GRP_ID, A.SYS_AREA_GRP_ID)=B.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("--						)" ).append("\n"); 
		query.append("--						OR" ).append("\n"); 
		query.append("--						(" ).append("\n"); 
		query.append("--							B.OFC_TRNS_FLG = 'N'" ).append("\n"); 
		query.append("--							and C.CNT_CD = (SELECT SUBSTR(LOC_CD,1,2) " ).append("\n"); 
		query.append("--											FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("--											WHERE OFC_CD = B.OFC_CD)" ).append("\n"); 
		query.append("--							and CO_IND_CD = 'H'" ).append("\n"); 
		query.append("--							and A.SYS_AREA_GRP_ID = B.SYS_AREA_GRP_ID       " ).append("\n"); 
		query.append("--						)" ).append("\n"); 
		query.append("--					)" ).append("\n"); 
		query.append("--####################################################################################################################################" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			and  B.OFC_CD 			= @[s_ofc_cd]" ).append("\n"); 
		query.append("			and  B.DMDT_CHG_STS_CD 	= 'C'" ).append("\n"); 
		query.append("			#if (${s_dmdt_trf_cd} != '')" ).append("\n"); 
		query.append("			and B.DMDT_TRF_CD in " ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					#foreach( $dmdt_trf_no in ${dmdt_trf_cd_list}) " ).append("\n"); 
		query.append("						#if($velocityCount < $dmdt_trf_cd_list.size()) " ).append("\n"); 
		query.append("						   '$dmdt_trf_no', " ).append("\n"); 
		query.append("						#else " ).append("\n"); 
		query.append("						   '$dmdt_trf_no' " ).append("\n"); 
		query.append("						#end " ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_cont_type} == 'date') " ).append("\n"); 
		query.append("			and to_char(B.CFM_DT,'YYYYMMDD') between @[fm_cfm_dt] and @[to_cfm_dt]" ).append("\n"); 
		query.append("			#elseif (${s_cont_type} == 'cntr') " ).append("\n"); 
		query.append("				#if (${s_bkg_no} != '')	" ).append("\n"); 
		query.append("					and A.BKG_NO in " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							#foreach( $bkg_cd in ${bkg_no_list} )" ).append("\n"); 
		query.append("								#if($velocityCount < $bkg_no_list.size()) " ).append("\n"); 
		query.append("									'$bkg_cd', " ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("									'$bkg_cd' " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${s_bl_no} != '')	" ).append("\n"); 
		query.append("					and A.BL_NO in " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							#foreach( $bl_cd in ${bl_no_list} )" ).append("\n"); 
		query.append("								#if($velocityCount < $bl_no_list.size()) " ).append("\n"); 
		query.append("									'$bl_cd', " ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("									'$bl_cd' " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${s_cntr_no} != '')	" ).append("\n"); 
		query.append("					and A.CNTR_NO in " ).append("\n"); 
		query.append("						(" ).append("\n"); 
		query.append("							#foreach( $cntr_cd in ${cntr_no_list} )" ).append("\n"); 
		query.append("								#if($velocityCount < $cntr_no_list.size()) " ).append("\n"); 
		query.append("									'$cntr_cd', " ).append("\n"); 
		query.append("								#else " ).append("\n"); 
		query.append("									'$cntr_cd' " ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				#if (${s_fm_dt} != '' && ${s_to_dt} != '')					" ).append("\n"); 
		query.append("					and to_char(B.CFM_DT,'YYYYMMDD') between REPLACE(@[s_fm_dt],'-','') and REPLACE(@[s_to_dt],'-','')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_chg_type} == 'G') " ).append("\n"); 
		query.append("			and B.CHG_SEQ = 1" ).append("\n"); 
		query.append("			#elseif (${s_chg_type} == 'B') " ).append("\n"); 
		query.append("			and B.CHG_SEQ <> 1" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_cust_cd} != '') " ).append("\n"); 
		query.append("				#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("			and LPAD(B.ACT_CUST_SEQ,6,'0') = LPAD(@[s_cust_cd],6,'0')" ).append("\n"); 
		query.append("				#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("			and B.ACT_CNT_CD = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("			and LPAD(B.ACT_CUST_SEQ,6,'0') = SUBSTR(@[s_cust_cd],3)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${s_sc_no} != '') " ).append("\n"); 
		query.append("			and A.SC_NO = @[s_sc_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${rfa_no} != '') " ).append("\n"); 
		query.append("			and A.RFA_NO = @[rfa_no]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		## 조건 추가(2010.01.12)" ).append("\n"); 
		query.append("			and ((B.DUL_TP_EXPT_FLG= 'Y' and SUBSTR(B.DMDT_TRF_CD,1,1)  = 'C') or (B.DUL_TP_EXPT_FLG ='N'))" ).append("\n"); 
		query.append("			group by A.BKG_NO, BB.BL_NO" ).append("\n"); 
		query.append("		) AA" ).append("\n"); 
		query.append(" where  AA.DMDT_DELT_RQST_STS_CD in ('N', 'X')	--// 삭제요청이 없었거나, 삭제요청이 있었을 경우에는 필수최종승인을 통해서 Charge 의 상태가 최종갱신된 경우의 건만 조회한다." ).append("\n"); 
		query.append("order by BKG_NO" ).append("\n"); 

	}
}