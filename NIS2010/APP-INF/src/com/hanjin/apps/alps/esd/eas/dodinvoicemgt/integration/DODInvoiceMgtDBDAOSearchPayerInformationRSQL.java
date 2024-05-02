/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchPayerInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.17
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.17 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchPayerInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchPayerInformation
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchPayerInformationRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchPayerInformationRSQL").append("\n"); 
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
		query.append("SELECT  LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.CUST_SEQ" ).append("\n"); 
		query.append("       ,B.RGST_NO AS CUST_RGST_NO" ).append("\n"); 
		query.append("       ,'' AS ISS_DIV_NM" ).append("\n"); 
		query.append("       ,A.PAYR_NM " ).append("\n"); 
		query.append("       ,REPLACE(A.CUST_ADDR,'@*',CHR(13)) AS CUST_ADDR" ).append("\n"); 
		query.append("       ,A.CNTC_PNT_NM  " ).append("\n"); 
		query.append("       ,A.CNTC_PNT_PHN_NO " ).append("\n"); 
		query.append("       ,A.CNTC_PNT_FAX_NO " ).append("\n"); 
		query.append("       ,A.N1ST_EML  " ).append("\n"); 
		query.append("FROM EAS_PAYR_INFO A, MDM_VENDOR B" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD 	= '00'" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 		= SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= SUBSTR(@[s_cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#elseif (${payr_yn} == 'N') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  LPAD(A.VNDR_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,A.VNDR_CNT_CD 		AS CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.VNDR_SEQ 			AS CUST_SEQ" ).append("\n"); 
		query.append("       ,A.RGST_NO 			AS CUST_RGST_NO" ).append("\n"); 
		query.append("       ,'' 					AS ISS_DIV_NM" ).append("\n"); 
		query.append("       ,A.VNDR_LGL_ENG_NM 	AS PAYR_NM" ).append("\n"); 
		query.append("       ,A.ENG_ADDR 		    	AS CUST_ADDR" ).append("\n"); 
		query.append("       ,A.CNTC_PSON_NM 	  	AS CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,B.PHN_NO 		  	AS CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("       ,B.FAX_NO 			  AS CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("       ,B.VNDR_EML 			AS N1ST_EML" ).append("\n"); 
		query.append("FROM MDM_VENDOR A, MDM_VNDR_CNTC_PNT B" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ       = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND B.VNDR_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("AND A.VNDR_SEQ         = SUBSTR(@[s_cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2')" ).append("\n"); 
		query.append("	#if (${payr_yn} == 'Y') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.CUST_SEQ" ).append("\n"); 
		query.append("       ,B.CUST_RGST_NO" ).append("\n"); 
		query.append("       ,CASE WHEN C.ISS_DIV_CD = 'P' THEN 'Paper'" ).append("\n"); 
		query.append("             WHEN C.ISS_DIV_CD = 'E' THEN 'EDI'" ).append("\n"); 
		query.append("             WHEN C.ISS_DIV_CD = 'I' THEN 'Internet'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END AS ISS_DIV_NM" ).append("\n"); 
		query.append("       ,A.PAYR_NM" ).append("\n"); 
		query.append("       ,REPLACE(A.CUST_ADDR,'@*',CHR(13)) AS CUST_ADDR" ).append("\n"); 
		query.append("       ,A.CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,A.CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("       ,A.CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("       ,A.N1ST_EML" ).append("\n"); 
		query.append("FROM EAS_PAYR_INFO A, MDM_CUSTOMER B, MDM_CR_CUST C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD		= C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ			= C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD 	= SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ 			= SUBSTR(@[s_cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#elseif (${payr_yn} == 'N') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT  A.CUST_CNT_CD||LPAD(A.CUST_SEQ,6,'0') AS CUST_CD" ).append("\n"); 
		query.append("       ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("       ,A.CUST_SEQ" ).append("\n"); 
		query.append("       ,A.CUST_RGST_NO" ).append("\n"); 
		query.append("       ,CASE WHEN C.ISS_DIV_CD = 'P' THEN 'Paper'" ).append("\n"); 
		query.append("             WHEN C.ISS_DIV_CD = 'E' THEN 'EDI'" ).append("\n"); 
		query.append("             WHEN C.ISS_DIV_CD = 'I' THEN 'Internet'" ).append("\n"); 
		query.append("             ELSE ''" ).append("\n"); 
		query.append("        END AS ISS_DIV_NM" ).append("\n"); 
		query.append("       ,DECODE(C.LOCL_NM, NULL, A.CUST_LGL_ENG_NM, C.LOCL_NM) 				AS PAYR_NM" ).append("\n"); 
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
		query.append("	      	 AND ADDR.CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND ADDR.CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("		       AND ADDR.PRMRY_CHK_FLG = 'Y'" ).append("\n"); 
		query.append("         AND ROWNUM = 1   )           AS CUST_ADDR" ).append("\n"); 
		query.append("       ,C.CNTC_PSON_NM 								AS CNTC_PNT_NM" ).append("\n"); 
		query.append("       ,DECODE(C.IB_PHN_NO, NULL, B.PHN_NO, C.IB_PHN_NO) 	AS CNTC_PNT_PHN_NO" ).append("\n"); 
		query.append("       ,DECODE(C.IB_FAX_NO, NULL, B.FAX_NO, C.IB_FAX_NO) 	AS CNTC_PNT_FAX_NO" ).append("\n"); 
		query.append("       ,DECODE(C.IB_EML, NULL, B.CUST_EML, C.IB_EML) 			AS N1ST_EML" ).append("\n"); 
		query.append("FROM MDM_CUSTOMER A, MDM_CUST_CNTC_PNT B, MDM_CR_CUST C" ).append("\n"); 
		query.append("WHERE A.CUST_CNT_CD  = B.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ       = B.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD		= C.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND A.CUST_SEQ			= C.CUST_SEQ(+)" ).append("\n"); 
		query.append("AND B.CUST_CNTC_PNT_SEQ(+) = 1" ).append("\n"); 
		query.append("AND A.CUST_CNT_CD      = SUBSTR(@[s_cust_cd],1,2)" ).append("\n"); 
		query.append("AND A.CUST_SEQ         = SUBSTR(@[s_cust_cd],3,6)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}