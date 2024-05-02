/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
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

public class InvoiceIssueCollectionMgtDBDAOSearchPayerInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEM/DET Payer Info & Fax/E-mail
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchPayerInformationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerInformationRSQL").append("\n"); 
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
		query.append("#if (${s_cust_gubun} == '1')" ).append("\n"); 
		query.append("	#if (${payr_yn} == 'Y') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("       ,LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.CUST_SEQ" ).append("\n"); 
		query.append("       ,B.RGST_NO AS CUST_RGST_NO" ).append("\n"); 
		query.append("       ,'' AS ISS_DIV_NM" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_NM" ).append("\n"); 
		query.append("       ,REPLACE(A.DMDT_PAYR_ADDR,'@*',CHR(13)) AS DMDT_PAYR_ADDR" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_PHN_NO" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_N1ST_EML" ).append("\n"); 
		query.append("	   ,SND_CYC_CD" ).append("\n"); 
		query.append("	   ,NVL(A.OTS_SH_GRP_CD, 'I') OTS_SH_GRP_CD" ).append("\n"); 
		query.append("	   ,NVL(A.SND_CNTR_LIST_FLG, 'Y') SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("	   ,SND_INV_FLG" ).append("\n"); 
		query.append("FROM DMT_PAYR_INFO A, MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID 	= NVL(@[svr_id]," ).append("\n"); 
		query.append("						  (SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("                           FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                           WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                           WHERE OFC_CD = SUBSTR(@[s_ofc_cd], 0, 5))" ).append("\n"); 
		query.append("                           AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                          ))" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 	= '00'" ).append("\n"); 
		query.append("AND A.CUST_SEQ 		= @[s_cust_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#elseif (${payr_yn} == 'N') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT (SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("        FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE OFC_CD = SUBSTR(@[s_ofc_cd], 0, 5))" ).append("\n"); 
		query.append("        AND CO_IND_CD = 'H') AS SVR_ID" ).append("\n"); 
		query.append("       ,LPAD(A.VNDR_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,A.VNDR_CNT_CD 		AS CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.VNDR_SEQ 			AS CUST_SEQ" ).append("\n"); 
		query.append("       ,A.RGST_NO 			AS CUST_RGST_NO" ).append("\n"); 
		query.append("       ,'' 					AS ISS_DIV_NM" ).append("\n"); 
		query.append("       ,A.VNDR_LGL_ENG_NM 	AS DMDT_PAYR_NM" ).append("\n"); 
		query.append("       ,A.ENG_ADDR 			AS DMDT_PAYR_ADDR" ).append("\n"); 
		query.append("       ,A.CNTC_PSON_NM 		AS DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,B.PHN_NO 			AS DMDT_PAYR_PHN_NO" ).append("\n"); 
		query.append("       ,B.FAX_NO 			AS DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append("       ,B.VNDR_EML 			AS DMDT_PAYR_N1ST_EML" ).append("\n"); 
		query.append("	   ,'W' SND_CYC_CD" ).append("\n"); 
		query.append("	   ,'I' OTS_SH_GRP_CD" ).append("\n"); 
		query.append("	   ,'Y' SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("	   ,'' SND_INV_FLG" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ       = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND B.VNDR_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("AND A.VNDR_SEQ         = @[s_cust_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2')" ).append("\n"); 
		query.append("	#if (${payr_yn} == 'Y') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT A.SYS_AREA_GRP_ID AS SVR_ID" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.CUST_SEQ" ).append("\n"); 
		query.append("       ,B.CUST_RGST_NO" ).append("\n"); 
		query.append("       ,CASE WHEN C.ISS_DIV_CD = 'P' THEN 'Paper'" ).append("\n"); 
		query.append("             WHEN C.ISS_DIV_CD = 'E' THEN 'EDI'" ).append("\n"); 
		query.append("             WHEN C.ISS_DIV_CD = 'I' THEN 'Internet'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END AS ISS_DIV_NM" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_NM" ).append("\n"); 
		query.append("       ,REPLACE(A.DMDT_PAYR_ADDR,'@*',CHR(13)) AS DMDT_PAYR_ADDR" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_PHN_NO" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append("       ,A.DMDT_PAYR_N1ST_EML" ).append("\n"); 
		query.append("	   ,SND_CYC_CD" ).append("\n"); 
		query.append("	   ,NVL(A.OTS_SH_GRP_CD, 'I') OTS_SH_GRP_CD" ).append("\n"); 
		query.append("	   ,NVL(A.SND_CNTR_LIST_FLG, 'Y') SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("	   ,SND_INV_FLG" ).append("\n"); 
		query.append("FROM DMT_PAYR_INFO A, MDM_CUSTOMER B, MDM_CR_CUST C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD 	= B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD		= C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ			= C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.SYS_AREA_GRP_ID 	= NVL(@[svr_id]," ).append("\n"); 
		query.append("						  (SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("                           FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("                           WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                                           FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                           WHERE OFC_CD = SUBSTR(@[s_ofc_cd], 0, 5))" ).append("\n"); 
		query.append("                           AND CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                          ))" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 		= SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= SUBSTR(@[s_cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#elseif (${payr_yn} == 'N') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT (SELECT SYS_AREA_GRP_ID " ).append("\n"); 
		query.append("        FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("        WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                        FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        WHERE OFC_CD = SUBSTR(@[s_ofc_cd], 0, 5))" ).append("\n"); 
		query.append("        AND CO_IND_CD = 'H') AS SVR_ID" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.CUST_SEQ" ).append("\n"); 
		query.append("       ,A.CUST_RGST_NO" ).append("\n"); 
		query.append("       ,CASE WHEN C.ISS_DIV_CD = 'P' THEN 'Paper'" ).append("\n"); 
		query.append("             WHEN C.ISS_DIV_CD = 'E' THEN 'EDI'" ).append("\n"); 
		query.append("             WHEN C.ISS_DIV_CD = 'I' THEN 'Internet'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END AS ISS_DIV_NM" ).append("\n"); 
		query.append("       ,DECODE(C.LOCL_NM, NULL, A.CUST_LGL_ENG_NM, C.LOCL_NM) 				AS DMDT_PAYR_NM" ).append("\n"); 
		query.append("	   ,(SELECT CASE WHEN CN.BKG_ADDR_ORD_CD = 1 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.ZIP_CD                                            " ).append("\n"); 
		query.append("                     WHEN CN.BKG_ADDR_ORD_CD = 2 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM                                       " ).append("\n"); 
		query.append("                     WHEN CN.BKG_ADDR_ORD_CD = 3 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM||' '||ADDR.ZIP_CD                                    " ).append("\n"); 
		query.append("                     WHEN CN.BKG_ADDR_ORD_CD = 4 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM||' '||ADDR.STE_CD||' '||ADDR.ZIP_CD                  " ).append("\n"); 
		query.append("                     WHEN CN.BKG_ADDR_ORD_CD = 5 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM||' '||ADDR.ZIP_CD                                    " ).append("\n"); 
		query.append("                     WHEN CN.BKG_ADDR_ORD_CD = 6 THEN ADDR.CTY_NM||' '||REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.ZIP_CD                                    " ).append("\n"); 
		query.append("                ELSE REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM||' '||ADDR.ZIP_CD                                                                                           " ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("         FROM MDM_CUST_ADDR ADDR, MDM_COUNTRY CN" ).append("\n"); 
		query.append("         WHERE ADDR.CUST_CNT_CD = CN.CNT_CD(+)" ).append("\n"); 
		query.append("		 AND ADDR.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("         AND ADDR.CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("		 AND ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("         AND ROWNUM = 1)" ).append("\n"); 
		query.append("       AS DMDT_PAYR_ADDR" ).append("\n"); 
		query.append("       ,C.CNTC_PSON_NM 											AS DMDT_PAYR_CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,DECODE(C.IB_PHN_NO, NULL, B.PHN_NO, C.IB_PHN_NO) 		AS DMDT_PAYR_PHN_NO" ).append("\n"); 
		query.append("       ,DECODE(C.IB_FAX_NO, NULL, B.FAX_NO, C.IB_FAX_NO) 		AS DMDT_PAYR_FAX_NO" ).append("\n"); 
		query.append("       ,DECODE(C.IB_EML, NULL, B.CUST_EML, C.IB_EML) 			AS DMDT_PAYR_N1ST_EML" ).append("\n"); 
		query.append("	   ,'W' SND_CYC_CD" ).append("\n"); 
		query.append("	   ,'I' OTS_SH_GRP_CD" ).append("\n"); 
		query.append("	   ,'Y' SND_CNTR_LIST_FLG" ).append("\n"); 
		query.append("	   ,'' SND_INV_FLG" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CUST_CNTC_PNT B, MDM_CR_CUST C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD  = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ       = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD		= C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ			= C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND B.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD      = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ         = SUBSTR(@[s_cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}