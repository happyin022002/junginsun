/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnersAccountDBDAOCustomTaxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOCustomTaxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CustomTax 조회
	  * </pre>
	  */
	public OwnersAccountDBDAOCustomTaxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOCustomTaxRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("     TAX_INV_YRMON		" ).append("\n"); 
		query.append("    ,OFC_CD			" ).append("\n"); 
		query.append("    ,DOC_EVID_TP_CD AS TAX_ISS_CD		" ).append("\n"); 
		query.append("    ,TAX_VAT_TP_CD		" ).append("\n"); 
		query.append("    ,TAX_NAID_FLG    	" ).append("\n"); 
		query.append("    ,TAX_DIV_CD     	" ).append("\n"); 
		query.append("    ,FA_FLG     		" ).append("\n"); 
		query.append("    ,TAX_PL_CD			" ).append("\n"); 
		query.append("    ,TAX_NSL_FLG		" ).append("\n"); 
		query.append("    ,SPL_RGST_NO		" ).append("\n"); 
		query.append("    ,OWNR_NM  			" ).append("\n"); 
		query.append("    ,CO_NM  			" ).append("\n"); 
		query.append("    ,BZCT_NM			" ).append("\n"); 
		query.append("    ,BZTP_NM			" ).append("\n"); 
		query.append("    ,SPL_ADDR			" ).append("\n"); 
		query.append("    ,ISS_DT			" ).append("\n"); 
		query.append("    ,SPL_AMT			" ).append("\n"); 
		query.append("    ,TAX_AMT			" ).append("\n"); 
		query.append("    ,TOTAL_AMT			" ).append("\n"); 
		query.append("    ,SUBSTR(@[csr_no],1,2) AS SLP_TP_CD" ).append("\n"); 
		query.append("    ,SUBSTR(@[csr_no],3,1) AS SLP_FUNC_CD" ).append("\n"); 
		query.append("    ,DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 4, 5), SUBSTR(@[csr_no], 4, 6)) AS SLP_OFC_CD" ).append("\n"); 
		query.append("    ,DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 9, 6), SUBSTR(@[csr_no], 10, 6)) AS SLP_ISS_DT" ).append("\n"); 
		query.append("    ,DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 15, 5), SUBSTR(@[csr_no], 16, 5)) AS SLP_SER_NO" ).append("\n"); 
		query.append("    ,CRE_USR_ID		" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SUBSTR(TAX_INV_YRMON,1,4) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(TAX_INV_YRMON,5,2) TAX_INV_YRMON," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("			   DOC_EVID_TP_CD," ).append("\n"); 
		query.append("               TAX_VAT_TP_CD," ).append("\n"); 
		query.append("               TAX_NAID_FLG," ).append("\n"); 
		query.append("               TAX_DIV_CD," ).append("\n"); 
		query.append("               FA_FLG," ).append("\n"); 
		query.append("               TAX_PL_CD," ).append("\n"); 
		query.append("               TAX_NSL_FLG," ).append("\n"); 
		query.append("               SUBSTR(SPL_RGST_NO,1,3) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(SPL_RGST_NO,4,2) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(SPL_RGST_NO,6) SPL_RGST_NO," ).append("\n"); 
		query.append("               OWNR_NM," ).append("\n"); 
		query.append("               CO_NM," ).append("\n"); 
		query.append("               BZCT_NM," ).append("\n"); 
		query.append("               BZTP_NM," ).append("\n"); 
		query.append("               SPL_ADDR," ).append("\n"); 
		query.append("               SUBSTR(ISS_DT,1,4) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(ISS_DT,5,2) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(ISS_DT,7,2) ISS_DT," ).append("\n"); 
		query.append("               TO_CHAR(SPL_AMT,'FM999,999,999,999,999,990') SPL_AMT," ).append("\n"); 
		query.append("               TO_CHAR(TAX_AMT,'FM999,999,999,999,999,990') TAX_AMT," ).append("\n"); 
		query.append("               TO_CHAR(SPL_AMT + TAX_AMT,'FM999,999,999,999,999,990') TOTAL_AMT" ).append("\n"); 
		query.append("			   ,CRE_USR_ID		" ).append("\n"); 
		query.append("			   ,UPD_USR_ID			  " ).append("\n"); 
		query.append("          FROM FMS_TAX" ).append("\n"); 
		query.append("         WHERE    SLP_TP_CD" ).append("\n"); 
		query.append("               || SLP_FUNC_CD" ).append("\n"); 
		query.append("               || SLP_OFC_CD" ).append("\n"); 
		query.append("               || SLP_ISS_DT" ).append("\n"); 
		query.append("               || SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT BIL_INV_YRMON," ).append("\n"); 
		query.append("       OFC_CD," ).append("\n"); 
		query.append("	   DOC_EVID_TP_CD," ).append("\n"); 
		query.append("       BIL_VAT_TP_CD," ).append("\n"); 
		query.append("       BIL_NAID_FLG," ).append("\n"); 
		query.append("       BIL_DIV_CD," ).append("\n"); 
		query.append("       FA_FLG," ).append("\n"); 
		query.append("       BIL_PL_CD," ).append("\n"); 
		query.append("       BIL_NSL_FLG," ).append("\n"); 
		query.append("       SPL_RGST_NO," ).append("\n"); 
		query.append("       OWNR_NM," ).append("\n"); 
		query.append("       CO_NM," ).append("\n"); 
		query.append("       BZCT_NM," ).append("\n"); 
		query.append("       BZTP_NM," ).append("\n"); 
		query.append("       SPL_ADDR," ).append("\n"); 
		query.append("       ISS_DT," ).append("\n"); 
		query.append("       SPL_AMT," ).append("\n"); 
		query.append("       BIL_AMT," ).append("\n"); 
		query.append("       TOTAL_AMT" ).append("\n"); 
		query.append("       ,SUBSTR(@[csr_no],1,2) AS SLP_TP_CD" ).append("\n"); 
		query.append("       ,SUBSTR(@[csr_no],3,1) AS SLP_FUNC_CD" ).append("\n"); 
		query.append("       ,DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 4, 5), SUBSTR(@[csr_no], 4, 6)) AS SLP_OFC_CD" ).append("\n"); 
		query.append("       ,DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 9, 6), SUBSTR(@[csr_no], 10, 6)) AS SLP_ISS_DT" ).append("\n"); 
		query.append("       ,DECODE(LENGTH(@[csr_no]), 19, SUBSTR(@[csr_no], 15, 5), SUBSTR(@[csr_no], 16, 5)) AS SLP_SER_NO" ).append("\n"); 
		query.append("       ,CRE_USR_ID		" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT SUBSTR(BIL_INV_YRMON,1,4) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(BIL_INV_YRMON,5,2) BIL_INV_YRMON," ).append("\n"); 
		query.append("               OFC_CD," ).append("\n"); 
		query.append("			   DOC_EVID_TP_CD," ).append("\n"); 
		query.append("               NULL BIL_VAT_TP_CD," ).append("\n"); 
		query.append("               NULL BIL_NAID_FLG," ).append("\n"); 
		query.append("               BIL_DIV_CD," ).append("\n"); 
		query.append("               NULL FA_FLG," ).append("\n"); 
		query.append("               BIL_PL_CD," ).append("\n"); 
		query.append("               NULL BIL_NSL_FLG," ).append("\n"); 
		query.append("               SUBSTR(SPL_RGST_NO,1,3) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(SPL_RGST_NO,4,2) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(SPL_RGST_NO,6) SPL_RGST_NO," ).append("\n"); 
		query.append("               OWNR_NM," ).append("\n"); 
		query.append("               CO_NM," ).append("\n"); 
		query.append("               BZCT_NM," ).append("\n"); 
		query.append("               BZTP_NM," ).append("\n"); 
		query.append("               SPL_ADDR," ).append("\n"); 
		query.append("               SUBSTR(ISS_DT,1,4) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(ISS_DT,5,2) || '-' || " ).append("\n"); 
		query.append("               SUBSTR(ISS_DT,7,2) ISS_DT," ).append("\n"); 
		query.append("               TO_CHAR(SPL_AMT,'FM999,999,999,999,999,990') SPL_AMT," ).append("\n"); 
		query.append("               '0' BIL_AMT," ).append("\n"); 
		query.append("               TO_CHAR(SPL_AMT,'FM999,999,999,999,999,990') TOTAL_AMT" ).append("\n"); 
		query.append("               ,CRE_USR_ID		" ).append("\n"); 
		query.append("			   ,UPD_USR_ID	" ).append("\n"); 
		query.append("          FROM FMS_BILL" ).append("\n"); 
		query.append("         WHERE    SLP_TP_CD" ).append("\n"); 
		query.append("               || SLP_FUNC_CD" ).append("\n"); 
		query.append("               || SLP_OFC_CD" ).append("\n"); 
		query.append("               || SLP_ISS_DT" ).append("\n"); 
		query.append("               || SLP_SER_NO = @[csr_no]" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}