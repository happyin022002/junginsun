/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice No. 로 Invoice Main 정보를 조회하는 쿼리
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL").append("\n"); 
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
		query.append("	SELECT  INV_MN.DMDT_INV_NO" ).append("\n"); 
		query.append("		   ,TO_CHAR(INV_MN.CRE_DT, 'YYYY-MM-DD') 	AS ISSUE_DT" ).append("\n"); 
		query.append("		   ,INV_MN.CRE_OFC_CD 						AS ISSUE_OFC_CD" ).append("\n"); 
		query.append("		   ,USER_A.USR_NM 							AS ISSUE_USR_NM" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				SELECT	SUBSTR(LOC_CD,0,2) " ).append("\n"); 
		query.append("				FROM 	MDM_ORGANIZATION " ).append("\n"); 
		query.append("				WHERE 	OFC_CD = INV_MN.CRE_OFC_CD" ).append("\n"); 
		query.append("			) 										AS CRE_CNT_CD" ).append("\n"); 
		query.append("		   ,INV_MN.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				SELECT	INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("				FROM 	COM_INTG_CD_DTL " ).append("\n"); 
		query.append("				WHERE 	INTG_CD_ID = 'CD01974' " ).append("\n"); 
		query.append("					AND INTG_CD_VAL_CTNT = INV_MN.DMDT_INV_STS_CD" ).append("\n"); 
		query.append("			) 										AS DMDT_INV_STS_DESC" ).append("\n"); 
		query.append("		   ,INV_MN.DMDT_AR_IF_CD" ).append("\n"); 
		query.append("		   ,TO_CHAR(INV_MN.AR_IF_DT, 'YYYY-MM-DD') 	AS AR_IF_DT" ).append("\n"); 
		query.append("		   ,INV_MN.AR_IF_OFC_CD " ).append("\n"); 
		query.append("		   ,INV_MN.AR_IF_USR_ID" ).append("\n"); 
		query.append("		   ,USER_B.USR_NM 							AS AR_IF_USR_NM" ).append("\n"); 
		query.append("		   ,INV_MN.CR_INV_NO" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				SELECT	DMDT_AR_IF_CD" ).append("\n"); 
		query.append("				FROM	DMT_INV_MN" ).append("\n"); 
		query.append("				WHERE	DMDT_INV_NO = INV_MN.CR_INV_NO" ).append("\n"); 
		query.append("					AND CRE_OFC_CD = INV_MN.CRE_OFC_CD" ).append("\n"); 
		query.append("			) 										AS CR_AR_IF_CD" ).append("\n"); 
		query.append("		   ,INV_MN.BKG_NO" ).append("\n"); 
		query.append("		   ,INV_MN.BL_NO" ).append("\n"); 
		query.append("		   ,INV_MN.DMDT_TRF_CD" ).append("\n"); 
		query.append("		   ,INV_MN.IO_BND_CD" ).append("\n"); 
		query.append("		   ,INV_MN.MNL_INV_SND_FLG" ).append("\n"); 
		query.append("		   ,INV_MN.VSL_CD || INV_MN.SKD_VOY_NO || INV_MN.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("		   ,INV_MN.POR_CD" ).append("\n"); 
		query.append("		   ,INV_MN.POL_CD" ).append("\n"); 
		query.append("		   ,INV_MN.POD_CD" ).append("\n"); 
		query.append("		   ,INV_MN.DEL_CD" ).append("\n"); 
		query.append("		   ,INV_MN.BKG_RCV_TERM_CD 					AS RCV_TERM_CD" ).append("\n"); 
		query.append("		   ,INV_MN.BKG_DE_TERM_CD 					AS DE_TERM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		   ,CASE " ).append("\n"); 
		query.append("				WHEN DECODE(INV_MN.ACT_PAYR_CNT_CD, '00', '', INV_MN.ACT_PAYR_CNT_CD) || LPAD(INV_MN.ACT_PAYR_SEQ, 6, '0') = '000000' " ).append("\n"); 
		query.append("				THEN ''" ).append("\n"); 
		query.append("				ELSE DECODE(INV_MN.ACT_PAYR_CNT_CD, '00', '', INV_MN.ACT_PAYR_CNT_CD) || LPAD(INV_MN.ACT_PAYR_SEQ, 6, '0')" ).append("\n"); 
		query.append("			END 									AS ACT_PAYR_CUST_CD" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				SELECT	DECODE(NVL(CUST.CUST_LGL_ENG_NM, ''), '', VNDR.VNDR_LGL_ENG_NM, CUST.CUST_LGL_ENG_NM)" ).append("\n"); 
		query.append("				FROM	DMT_INV_MN A, MDM_CUSTOMER CUST, MDM_VENDOR VNDR" ).append("\n"); 
		query.append("				WHERE	A.DMDT_INV_NO		= INV_MN.DMDT_INV_NO" ).append("\n"); 
		query.append("					AND A.BKG_NO            = INV_MN.BKG_NO" ).append("\n"); 
		query.append("					AND A.ACT_PAYR_CNT_CD 	= CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("					AND	A.ACT_PAYR_SEQ		= CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("					AND A.ACT_PAYR_SEQ		= VNDR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("			) 										AS ACT_PAYR_CUST_NM" ).append("\n"); 
		query.append("		   ,INV_MN.DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("		   ,DECODE((SELECT DMDT_PAYR_NM                                                                                                                                            " ).append("\n"); 
		query.append("				   FROM DMT_PAYR_INFO                                                                                                                                             " ).append("\n"); 
		query.append("				   WHERE SYS_AREA_GRP_ID  = (SELECT SYS_AREA_GRP_ID                                                                                                               " ).append("\n"); 
		query.append("											 FROM COM_SYS_AREA_GRP_ID                                                                                                             " ).append("\n"); 
		query.append("											 WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)                                                                                          " ).append("\n"); 
		query.append("															 FROM MDM_ORGANIZATION                                                                                                " ).append("\n"); 
		query.append("															 WHERE OFC_CD = INV_MN.CRE_OFC_CD)                                                                                         " ).append("\n"); 
		query.append("											 AND CO_IND_CD = 'H')                                                                                                                 " ).append("\n"); 
		query.append("				   AND CUST_CNT_CD = INV_MN.ACT_PAYR_CNT_CD                                                                                                                            " ).append("\n"); 
		query.append("				   AND CUST_SEQ  = INV_MN.ACT_PAYR_SEQ)" ).append("\n"); 
		query.append("				  ,NULL" ).append("\n"); 
		query.append("				  ,(DECODE((SELECT LOCL_NM                                                                                                                                     " ).append("\n"); 
		query.append("							FROM MDM_CR_CUST                                                                                                                                   " ).append("\n"); 
		query.append("							WHERE CUST_CNT_CD = INV_MN.ACT_PAYR_CNT_CD                                                                                                              " ).append("\n"); 
		query.append("							AND CUST_SEQ    = INV_MN.ACT_PAYR_SEQ                                                                                                                   " ).append("\n"); 
		query.append("							AND LOCL_NM IS NOT NULL)" ).append("\n"); 
		query.append("						   ,NULL" ).append("\n"); 
		query.append("						   ,(SELECT CASE WHEN INV_MN.ACT_PAYR_CNT_CD = '00' THEN (SELECT VNDR_LGL_ENG_NM                                                                             " ).append("\n"); 
		query.append("																			 FROM MDM_VENDOR                                                                                                 " ).append("\n"); 
		query.append("																			 WHERE VNDR_SEQ = INV_MN.ACT_PAYR_SEQ                                                                                 " ).append("\n"); 
		query.append("																			 AND VNDR_LGL_ENG_NM IS NOT NULL)                                                                                " ).append("\n"); 
		query.append("									ELSE (SELECT CUST_LGL_ENG_NM                                                                                                                " ).append("\n"); 
		query.append("										  FROM MDM_CUSTOMER                                                                                                                     " ).append("\n"); 
		query.append("										  WHERE CUST_CNT_CD = INV_MN.ACT_PAYR_CNT_CD                                                                                                 " ).append("\n"); 
		query.append("										  AND CUST_SEQ     = INV_MN.ACT_PAYR_SEQ                                                                                                     " ).append("\n"); 
		query.append("										  AND CUST_LGL_ENG_NM IS NOT NULL)                                                                                                      " ).append("\n"); 
		query.append("									END MDM_NAME                                                                                                                                " ).append("\n"); 
		query.append("							  FROM DUAL)" ).append("\n"); 
		query.append("							,(SELECT LOCL_NM                                                                                                                                    " ).append("\n"); 
		query.append("							  FROM MDM_CR_CUST                                                                                                                                   " ).append("\n"); 
		query.append("							  WHERE CUST_CNT_CD = INV_MN.ACT_PAYR_CNT_CD                                                                                                              " ).append("\n"); 
		query.append("							  AND CUST_SEQ    = INV_MN.ACT_PAYR_SEQ                                                                                                                   " ).append("\n"); 
		query.append("							  AND LOCL_NM IS NOT NULL)                                                                                                                                                  " ).append("\n"); 
		query.append("							)                                                                                                                                                    " ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				  ,(SELECT DMDT_PAYR_NM                                                                                                                                             " ).append("\n"); 
		query.append("					FROM DMT_PAYR_INFO                                                                                                                                              " ).append("\n"); 
		query.append("					WHERE SYS_AREA_GRP_ID  = (SELECT SYS_AREA_GRP_ID                                                                                                                " ).append("\n"); 
		query.append("											  FROM COM_SYS_AREA_GRP_ID                                                                                                               " ).append("\n"); 
		query.append("											  WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)                                                                                            " ).append("\n"); 
		query.append("															  FROM MDM_ORGANIZATION                                                                                                  " ).append("\n"); 
		query.append("															  WHERE OFC_CD = INV_MN.CRE_OFC_CD)                                                                                           " ).append("\n"); 
		query.append("											  AND CO_IND_CD = 'H')                                                                                                                   " ).append("\n"); 
		query.append("					AND CUST_CNT_CD = INV_MN.ACT_PAYR_CNT_CD                                                                                                                             " ).append("\n"); 
		query.append("					AND CUST_SEQ  = INV_MN.ACT_PAYR_SEQ)                                                                                                                                                               " ).append("\n"); 
		query.append("			)										AS ACT_PAYR_CUST_NM2        -- E-mail Send용 Customer" ).append("\n"); 
		query.append("		   ,CASE WHEN INSTRB(INV_MN.INV_RMK, chr(10), 1, 1) = 0 " ).append("\n"); 
		query.append("				 THEN SUBSTRB(INV_MN.INV_RMK, INSTRB(INV_MN.INV_RMK, chr(10), -1, 1) + 1)" ).append("\n"); 
		query.append("				 ELSE SUBSTRB(INV_MN.INV_RMK, 0, INSTRB(INV_MN.INV_RMK, chr(10), 1, 1))" ).append("\n"); 
		query.append("			END 									AS INV_RMK1" ).append("\n"); 
		query.append("		   ,CASE WHEN INSTRB(INV_MN.INV_RMK, chr(10), 1, 1) = 0 " ).append("\n"); 
		query.append("				 THEN ''" ).append("\n"); 
		query.append("				 ELSE SUBSTRB(INV_MN.INV_RMK, INSTRB(INV_MN.INV_RMK, chr(10), -1, 1) + 1)" ).append("\n"); 
		query.append("			END 									AS INV_RMK2" ).append("\n"); 
		query.append("		   ,INV_MN.NTC_KNT_CD" ).append("\n"); 
		query.append("		   ,INV_MN.INV_REF_NO" ).append("\n"); 
		query.append("		   ,INV_MN.CHG_CURR_CD" ).append("\n"); 
		query.append("		   ,INV_MN.BIL_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.INV_CURR_CD" ).append("\n"); 
		query.append("		   ,INV_MN.INV_XCH_RT" ).append("\n"); 
		query.append("		   ,INV_MN.BKG_CNTR_QTY" ).append("\n"); 
		query.append("		   ,INV_MN.DC_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.INV_CHG_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.TAX_RTO" ).append("\n"); 
		query.append("		   ,INV_MN.TAX_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.INV_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.IDA_LOCL_TAX" ).append("\n"); 
		query.append("		   ,INV_MN.IDA_N2ND_LOCL_TAX" ).append("\n"); 
		query.append("		   ,INV_MN.IDA_CGST_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.IDA_SGST_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.IDA_IGST_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.IDA_UGST_AMT" ).append("\n"); 
		query.append("		   ,INV_MN.DMDT_MNL_INV_RSN_CD" ).append("\n"); 
		query.append("		   ,INV_MN.MNL_INV_RMK" ).append("\n"); 
		query.append("		   ,LPAD(INV_MN.VNDR_SEQ, 6, '0') 			AS VNDR_SEQ" ).append("\n"); 
		query.append("		   ,VENDOR.VNDR_LGL_ENG_NM 					AS VNDR_NM" ).append("\n"); 
		query.append("		   ,INV_MN.DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				SELECT	INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("				FROM	COM_INTG_CD_DTL " ).append("\n"); 
		query.append("				WHERE	INTG_CD_ID = 'CD01962' " ).append("\n"); 
		query.append("					AND INTG_CD_VAL_CTNT = INV_MN.DMDT_CXL_RSN_CD" ).append("\n"); 
		query.append("			) 										AS DMDT_CXL_RSN_NM" ).append("\n"); 
		query.append("		   ,INV_MN.CXL_RMK" ).append("\n"); 
		query.append("		   ,INV_MN.INV_HLD_RSN_CD" ).append("\n"); 
		query.append("		   ,(" ).append("\n"); 
		query.append("				SELECT	INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("				FROM 	COM_INTG_CD_DTL " ).append("\n"); 
		query.append("				WHERE	INTG_CD_ID = 'CD01980' " ).append("\n"); 
		query.append("					AND INTG_CD_VAL_CTNT = INV_MN.INV_HLD_RSN_CD" ).append("\n"); 
		query.append("			) 										AS INV_HLD_RSN_NM" ).append("\n"); 
		query.append("		   ,INV_MN.INV_HLD_RMK" ).append("\n"); 
		query.append("		   ,TO_CHAR(INV_MN.UPD_DT, 'YYYY-MM-DD') 	AS UPD_DT" ).append("\n"); 
		query.append("		   ,INV_MN.UPD_OFC_CD" ).append("\n"); 
		query.append("		   ,INV_MN.UPD_USR_ID" ).append("\n"); 
		query.append("		   ,USER_A.USR_NM 							AS UPD_USR_NM" ).append("\n"); 
		query.append("		   ,SH_OPT.BIL_TO_LOC_DIV_CD" ).append("\n"); 
		query.append("		   ,INV_MN.CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("		   ,INV_MN.SUTH_CHN_ISS_FLG" ).append("\n"); 
		query.append("		   ,(SELECT AR_HD_QTR_OFC_CD FROM MDM_ORGANIZATION WHERE OFC_CD = INV_MN.CRE_OFC_CD	) AS RHQ_OFC_CD" ).append("\n"); 
		query.append("		   ,INV_MN.INV_NEW_RPT_FLG" ).append("\n"); 
		query.append("		   ,INV_MN.CRE_DT" ).append("\n"); 
		query.append("		   ,INV_MN.CRE_OFC_CD" ).append("\n"); 
		query.append("		   ,OTS_CLT_FLG" ).append("\n"); 
		query.append("		   ,CASE " ).append("\n"); 
		query.append("				WHEN ATTR_CTNT1 IS NULL THEN " ).append("\n"); 
		query.append("					-- AUTO I/F 가 아닐 경우 (INVOICE 발행 OFFICE 가 AUTO I/F 대상 OFFICE 가 아닐 경우)" ).append("\n"); 
		query.append("					CASE " ).append("\n"); 
		query.append("						WHEN DMDT_INV_STS_CD = 'I' AND DMDT_AR_IF_CD = 'Y' THEN " ).append("\n"); 
		query.append("							'Y'" ).append("\n"); 
		query.append("						ELSE " ).append("\n"); 
		query.append("							'N'" ).append("\n"); 
		query.append("					END" ).append("\n"); 
		query.append("				ELSE -- AUTO I/F 일 경우 (INVOICE 발행 OFFICE 가 AUTO I/F 대상 OFFICE 일 경우)" ).append("\n"); 
		query.append("					NVL(OTS_CLT_FLG, 'N')" ).append("\n"); 
		query.append("		    END 									AS VT_COLLECTED" ).append("\n"); 
		query.append("		   ,CASE " ).append("\n"); 
		query.append("				WHEN ATTR_CTNT1 IS NOT NULL THEN " ).append("\n"); 
		query.append("					'Y' " ).append("\n"); 
		query.append("				ELSE " ).append("\n"); 
		query.append("					'N' " ).append("\n"); 
		query.append("			END AS AUTO_AR_IF_OFC_FLG       -- AUTO I/F OFFICE 인지 여부를 나타내는 FLAG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	  FROM  DMT_INV_MN       	INV_MN	" ).append("\n"); 
		query.append("		   ,COM_USER         	USER_A" ).append("\n"); 
		query.append("		   ,COM_USER         	USER_B" ).append("\n"); 
		query.append("		   ,MDM_VENDOR       	VENDOR" ).append("\n"); 
		query.append("		   ,DMT_OFC_SH_OPT   	SH_OPT" ).append("\n"); 
		query.append("		   ,DMT_HRD_CDG_CTNT 	D" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	 WHERE  INV_MN.DMDT_INV_NO 	= @[dmdt_inv_no]" ).append("\n"); 
		query.append("	   AND  INV_MN.CRE_OFC_CD   = D.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("	   AND  D.HRD_CDG_ID(+)     = 'AUTO_AR_IF_OFC'" ).append("\n"); 
		query.append("	   AND  INV_MN.UPD_USR_ID 	= USER_A.USR_ID(+)" ).append("\n"); 
		query.append("	   AND  INV_MN.AR_IF_USR_ID = USER_B.USR_ID(+)" ).append("\n"); 
		query.append("	   AND  INV_MN.VNDR_SEQ 	= VENDOR.VNDR_SEQ(+)" ).append("\n"); 
		query.append("	   AND  INV_MN.CRE_OFC_CD 	= SH_OPT.OFC_CD(+)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  T1.*" ).append("\n"); 
		query.append("       ,CASE WHEN (VT_COLLECTED = 'Y') THEN INV_CHG_AMT ELSE T2.INV_COL_CHARGE END AS COL_CHARGE" ).append("\n"); 
		query.append("       ,CASE WHEN (VT_COLLECTED = 'Y') THEN TAX_AMT     ELSE T2.INV_COL_TAX    END AS COL_TAX" ).append("\n"); 
		query.append("	   -- 납부금(INVOICE CURRENC)" ).append("\n"); 
		query.append("       ,T2.INV_COL_CHARGE" ).append("\n"); 
		query.append("       ,T2.INV_COL_TAX" ).append("\n"); 
		query.append("	   -- 납부금(CHARGE CURRENC)" ).append("\n"); 
		query.append("       ,T2.CHG_COL_CHARGE" ).append("\n"); 
		query.append("       ,T2.CHG_COL_TAX" ).append("\n"); 
		query.append("       -- 미수금(INVOICE CURRENCY)" ).append("\n"); 
		query.append("       ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', INV_AMT-(NVL(INV_COL_CHARGE,0)+NVL(INV_COL_TAX,0)), DECODE(VT_COLLECTED, 'Y', 0, INV_AMT)) AS INV_UNCOL_AMT" ).append("\n"); 
		query.append("       -- 미수금(CHARGE CURRENCY)" ).append("\n"); 
		query.append("       ,DECODE(AUTO_AR_IF_OFC_FLG, 'Y', BIL_AMT - NVL(CHG_COL_CHARGE,0), DECODE(VT_COLLECTED, 'Y', 0, BIL_AMT ))  CHG_UNCOL_AMT" ).append("\n"); 
		query.append("	   ,DECODE(NVL(OTS_CLT_FLG,'N'), 'Y'" ).append("\n"); 
		query.append("		  ,(TO_DATE(TO_CHAR(COL_DATE,'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(T1.CRE_DT,'YYYYMMDD'),'YYYYMMDD'))" ).append("\n"); 
		query.append("		  ,(TO_DATE(TO_CHAR(NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(T1.CRE_OFC_CD),SYSDATE),'YYYYMMDD'),'YYYYMMDD') - TO_DATE(TO_CHAR(T1.CRE_DT,'YYYYMMDD'),'YYYYMMDD'))" ).append("\n"); 
		query.append("	    ) 									AS COL_OVER_DAY" ).append("\n"); 
		query.append("       ,TO_CHAR(T2.COL_DATE, 'YYYY-MM-DD') 	AS COL_DATE" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  FROM  INV_DATA T1" ).append("\n"); 
		query.append("       ,(" ).append("\n"); 
		query.append("			SELECT  A.DMDT_INV_NO" ).append("\n"); 
		query.append("			       ,A.BKG_NO" ).append("\n"); 
		query.append("				   ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'M',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) AS INV_COL_CHARGE" ).append("\n"); 
		query.append("				   ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'V',INV_PAY_AMT*DECODE(A.INV_CURR_CD,B.INV_CURR_CD,1,INV_XCH_RT),0)) AS INV_COL_TAX" ).append("\n"); 
		query.append("                   ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'M',ROUND(INV_PAY_AMT/DECODE(A.INV_CURR_CD,B.INV_CURR_CD,INV_XCH_RT,1),3),0)) AS CHG_COL_CHARGE" ).append("\n"); 
		query.append("    	           ,SUM(DECODE(DMDT_INV_PAY_TP_CD,'V',ROUND(INV_PAY_AMT/DECODE(A.INV_CURR_CD,B.INV_CURR_CD,INV_XCH_RT,1),3),0)) AS CHG_COL_TAX" ).append("\n"); 
		query.append("		           ,MAX(INV_PAY_DT)  		AS COL_DATE" ).append("\n"); 
		query.append("		           ,MAX(INV_PAY_COFF_DT) 	AS COL_DUE_DT" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("			  FROM  DMT_INV_OTS_PAY_RCV 	A" ).append("\n"); 
		query.append("			       ,INV_DATA 				B" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			WHERE  B.DMDT_INV_NO = A.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("			  AND  B.BKG_NO = A.BKG_NO(+)" ).append("\n"); 
		query.append("			  " ).append("\n"); 
		query.append("			GROUP BY A.DMDT_INV_NO, A.BKG_NO" ).append("\n"); 
		query.append("		) T2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE  T1.DMDT_INV_NO = T2.DMDT_INV_NO(+)" ).append("\n"); 
		query.append("   AND  T1.BKG_NO      = T2.BKG_NO(+)" ).append("\n"); 

	}
}