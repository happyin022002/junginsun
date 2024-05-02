/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerAddressRSQL.java
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

public class InvoiceIssueCollectionMgtDBDAOSearchPayerAddressRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Payer Address search
	  * </pre>
	  */
	public InvoiceIssueCollectionMgtDBDAOSearchPayerAddressRSQL(){
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
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration").append("\n"); 
		query.append("FileName : InvoiceIssueCollectionMgtDBDAOSearchPayerAddressRSQL").append("\n"); 
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
		query.append("SELECT 'DMT' AS JOB_TP" ).append("\n"); 
		query.append("	,'' AS GUBUN" ).append("\n"); 
		query.append("	,REPLACE(DMDT_PAYR_ADDR,'@*',CHR(13)||CHR(10))	AS DMDT_PAYR_ADDR" ).append("\n"); 
		query.append("FROM DMT_PAYR_INFO" ).append("\n"); 
		query.append("WHERE SYS_AREA_GRP_ID = NVL(@[svr_id]," ).append("\n"); 
		query.append("						(SELECT SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						 FROM COM_SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("						 WHERE CNT_CD = (SELECT SUBSTR(LOC_CD, 1, 2) " ).append("\n"); 
		query.append("										 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("										 WHERE OFC_CD = SUBSTR(@[s_ofc_cd], 0, 5))" ).append("\n"); 
		query.append("						 AND CO_IND_CD = 'H'))" ).append("\n"); 
		query.append("AND CUST_CNT_CD 	= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND CUST_SEQ 		= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND DMDT_PAYR_ADDR IS NOT NULL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("#if (${s_cust_gubun} == '1') " ).append("\n"); 
		query.append("SELECT 'MDM' AS JOB_TP" ).append("\n"); 
		query.append("	,'GENERAL' AS GUBUN" ).append("\n"); 
		query.append("	,ENG_ADDR||','||ZIP_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE VNDR_SEQ = @[s_cust_cd]" ).append("\n"); 
		query.append("AND ENG_ADDR IS NOT NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${s_cust_gubun} == '2') " ).append("\n"); 
		query.append("-- MDM - CREDIT" ).append("\n"); 
		query.append("SELECT 'MDM' AS JOB_TP" ).append("\n"); 
		query.append("	,'CREDIT' AS GUBUN" ).append("\n"); 
		query.append("	,TRIM(LOCL_ADDR1)||CHR(13)||CHR(10)||TRIM(LOCL_ADDR2)||CHR(13)||CHR(10)||TRIM(LOCL_ADDR3)||CHR(13)||CHR(10)||TRIM(LOCL_ADDR4)||CHR(13)||CHR(10)||LOCL_ZIP_CD AS ADDR" ).append("\n"); 
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
		query.append("	   END" ).append("\n"); 
		query.append("FROM MDM_CUST_ADDR ADDR, MDM_COUNTRY CN" ).append("\n"); 
		query.append("WHERE ADDR.CUST_CNT_CD = CN.CNT_CD(+)" ).append("\n"); 
		query.append("AND ADDR.CUST_CNT_CD 	= SUBSTR(@[s_cust_cd], 1, 2)" ).append("\n"); 
		query.append("AND ADDR.CUST_SEQ 		= SUBSTR(@[s_cust_cd], 3)" ).append("\n"); 
		query.append("AND ADDR.BZET_ADDR IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${s_pod_cnt_cd} == 'KR') " ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'BKG' AS JOB_TP" ).append("\n"); 
		query.append("    ,'자가운송 실화주' AS GUBUN" ).append("\n"); 
		query.append("	,BEP.PTY_ADDR1||' '||BEP.PTY_ADDR2||' '||BEP.PTY_ADDR3" ).append("\n"); 
		query.append("FROM   BKG_EDO_MST         BEM," ).append("\n"); 
		query.append("       BKG_EDO_PTY_TRSP    BEP" ).append("\n"); 
		query.append("WHERE BEM.EDO_TP_CD   	= '5JM'" ).append("\n"); 
		query.append("AND BEP.EDO_PTY_CD 		= 'AS'" ).append("\n"); 
		query.append("AND BEM.BKG_NO 			= @[s_bkg_no]" ).append("\n"); 
		query.append("AND BEM.EDO_RQST_NO 	= BEP.EDO_RQST_NO" ).append("\n"); 
		query.append("AND BEM.EDO_RQST_SEQ  	= BEP.EDO_RQST_SEQ" ).append("\n"); 
		query.append("AND BEP.PTY_ADDR1||BEP.PTY_ADDR2||BEP.PTY_ADDR3 IS NOT NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}