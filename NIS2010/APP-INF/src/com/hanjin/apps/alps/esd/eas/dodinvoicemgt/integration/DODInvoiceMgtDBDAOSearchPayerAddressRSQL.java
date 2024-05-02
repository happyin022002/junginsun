/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchPayerAddressRSQL.java
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

public class DODInvoiceMgtDBDAOSearchPayerAddressRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payer address 정보 조회
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchPayerAddressRSQL(){
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
		query.append("FileName : DODInvoiceMgtDBDAOSearchPayerAddressRSQL").append("\n"); 
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
		query.append("SELECT 'EAS' AS JOB_TP" ).append("\n"); 
		query.append("	,'' AS GUBUN" ).append("\n"); 
		query.append("	,REPLACE(CUST_ADDR,'@*',CHR(13)||CHR(10))	AS CUST_ADDR" ).append("\n"); 
		query.append("FROM EAS_PAYR_INFO KK" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD 	= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND CUST_SEQ 		= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND CUST_ADDR IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#if (${s_cust_gubun} == '1') " ).append("\n"); 
		query.append("SELECT 'MDM' AS JOB_TP" ).append("\n"); 
		query.append("	,'GENERAL' AS GUBUN" ).append("\n"); 
		query.append("	,ZIP_CD||','||ENG_ADDR AS CUST_ADDR" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[s_cust_cd]" ).append("\n"); 
		query.append("AND ENG_ADDR IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("-- MDM - CREDIT" ).append("\n"); 
		query.append("SELECT 'MDM' AS JOB_TP" ).append("\n"); 
		query.append("	,'CREDIT' AS GUBUN" ).append("\n"); 
		query.append("	,TRIM(LOCL_ADDR1)||CHR(13)||CHR(10)||TRIM(LOCL_ADDR2)||CHR(13)||CHR(10)||TRIM(LOCL_ADDR3)||CHR(13)||CHR(10)||TRIM(LOCL_ADDR4)||CHR(13)||CHR(10)||LOCL_ZIP_CD AS CUST_ADDR" ).append("\n"); 
		query.append("FROM MDM_CR_CUST" ).append("\n"); 
		query.append("WHERE CUST_CNT_CD 	= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND CUST_SEQ 		= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND TRIM(LOCL_ADDR1)||TRIM(LOCL_ADDR2)||TRIM(LOCL_ADDR3)||TRIM(LOCL_ADDR4) IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("--MDM GENERAL" ).append("\n"); 
		query.append("SELECT 'MDM' AS JOB_TP" ).append("\n"); 
		query.append("	,'GENERAL' AS GUBUN" ).append("\n"); 
		query.append("	, CASE WHEN CN.BKG_ADDR_ORD_CD = 1 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.ZIP_CD" ).append("\n"); 
		query.append("		   WHEN CN.BKG_ADDR_ORD_CD = 2 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM" ).append("\n"); 
		query.append("		   WHEN CN.BKG_ADDR_ORD_CD = 3 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM||' '||ADDR.ZIP_CD" ).append("\n"); 
		query.append("		   WHEN CN.BKG_ADDR_ORD_CD = 4 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM||' '||ADDR.STE_CD||' '||ADDR.ZIP_CD" ).append("\n"); 
		query.append("		   WHEN CN.BKG_ADDR_ORD_CD = 5 THEN REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.CTY_NM||' '||ADDR.ZIP_CD" ).append("\n"); 
		query.append("		   WHEN CN.BKG_ADDR_ORD_CD = 6 THEN ADDR.CTY_NM||' '||REPLACE(ADDR.BZET_ADDR,'@*',CHR(13)||CHR(10))||' '||ADDR.ZIP_CD" ).append("\n"); 
		query.append("		ELSE ADDR.BZET_ADDR||' '||ADDR.CTY_NM||' '||ADDR.ZIP_CD" ).append("\n"); 
		query.append("	   END AS CUST_ADDR" ).append("\n"); 
		query.append("FROM MDM_CUST_ADDR ADDR, MDM_COUNTRY CN" ).append("\n"); 
		query.append("WHERE ADDR.CUST_CNT_CD = CN.CNT_CD(+)" ).append("\n"); 
		query.append("AND ADDR.CUST_CNT_CD 	= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND ADDR.CUST_SEQ 		= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND ADDR.BZET_ADDR IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}