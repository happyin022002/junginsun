/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CSR_NO",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryRSQL").append("\n"); 
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
		query.append("SELECT HDR.CSR_NO" ).append("\n"); 
		query.append("      ,HDR.VNDR_NO" ).append("\n"); 
		query.append("      ,TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(HDR.VNDR_NO) VNDR_NM" ).append("\n"); 
		query.append("      ,INV_WRK.INV_CNT" ).append("\n"); 
		query.append("      ,HDR.CSR_CURR_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(HDR.CSR_AMT, 'FM999,999,999,999,990.90') CSR_AMT" ).append("\n"); 
		query.append("      ,TO_CHAR(INV_WRK.INV_ISS_DT, 'YYYY-MM-DD') MAX_ISS_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(INV_WRK.INV_RCV_DT, 'YYYY-MM-DD') MAX_RCV_DT" ).append("\n"); 
		query.append("      ,DECODE(HDR.PAY_MZD_LU_CD, 'CHK', HDR.ATTR_CTNT2, '') ASA_NO" ).append("\n"); 
		query.append("      ,HDR.VNDR_TERM_NM" ).append("\n"); 
		query.append("      ,DECODE(HDR.VNDR_TERM_NM, 'KR H/O PAYMENT_60', NULL, 'O60', NULL, TO_CHAR(TO_DATE(HDR.INV_TERM_DT, 'YYYYMMDD'), 'YYYY-MM-DD')) PRE_DUE_DATE" ).append("\n"); 
		query.append("      ,INV_WRK.CRE_OFC_CD AS COST_OFC" ).append("\n"); 
		query.append("  FROM AP_INV_HDR HDR" ).append("\n"); 
		query.append("      ,(SELECT CSR_NO" ).append("\n"); 
		query.append("              ,MAX(CRE_OFC_CD) CRE_OFC_CD" ).append("\n"); 
		query.append("              ,MAX(INV_ISS_DT) INV_ISS_DT" ).append("\n"); 
		query.append("              ,MAX(INV_RCV_DT) INV_RCV_DT" ).append("\n"); 
		query.append("              ,COUNT(*) INV_CNT       " ).append("\n"); 
		query.append("          FROM (SELECT CSR_NO" ).append("\n"); 
		query.append("                      ,RAIL_INV_WRK.CRE_OFC_CD" ).append("\n"); 
		query.append("                      ,RAIL_INV_WRK.INV_ISS_DT" ).append("\n"); 
		query.append("                      ,INV_RCV_DT" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_RAIL_INV_WRK RAIL_INV_WRK" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT CSR_NO" ).append("\n"); 
		query.append("                      ,INV_WRK.CRE_OFC_CD" ).append("\n"); 
		query.append("                      ,INV_ISS_DT" ).append("\n"); 
		query.append("                      ,INV_RCV_DT" ).append("\n"); 
		query.append("                  FROM TRS_TRSP_INV_WRK INV_WRK" ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("         GROUP BY CSR_NO) INV_WRK" ).append("\n"); 
		query.append(" WHERE INV_WRK.CSR_NO = HDR.CSR_NO" ).append("\n"); 
		query.append("   AND HDR.CSR_NO = @[CSR_NO]" ).append("\n"); 

	}
}