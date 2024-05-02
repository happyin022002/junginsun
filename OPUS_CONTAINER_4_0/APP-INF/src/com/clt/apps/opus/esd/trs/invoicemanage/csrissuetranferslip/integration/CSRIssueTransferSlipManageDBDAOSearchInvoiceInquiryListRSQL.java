/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.27
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.12.27 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Invoice 목록 조회
	  * </pre>
	  */
	public CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryListRSQL(){
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
		query.append("FileName : CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryListRSQL").append("\n"); 
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
		query.append("SELECT NVL(INV_WRK.INV_NO , RAIL_WRK.INV_NO ) INV_NO ," ).append("\n"); 
		query.append("  NVL(INV_WRK.INV_VNDR_SEQ , RAIL_WRK.INV_VNDR_SEQ ) INV_VNDR_SEQ ," ).append("\n"); 
		query.append("  TO_CHAR(NVL(INV_WRK.INV_BZC_AMT , RAIL_WRK.INV_BZC_AMT ), 'FM999,999,999,999,990.90') INV_BZC_AMT ," ).append("\n"); 
		query.append("  TO_CHAR(NVL(INV_WRK.INV_VAT_AMT , RAIL_WRK.INV_VAT_AMT ), 'FM999,999,999,999,990.90') INV_VAT_AMT ," ).append("\n"); 
		query.append("  TO_CHAR(NVL(INV_WRK.INV_WHLD_TAX_AMT, 0 ), 'FM999,999,999,999,990.90') INV_WHLD_TAX_AMT ," ).append("\n"); 
		query.append("  TO_CHAR(NVL(INV_WRK.INV_TTL_AMT, RAIL_WRK.INV_TTL_AMT), 'FM999,999,999,999,990.90') INV_TTL_AMT ," ).append("\n"); 
		query.append("  NVL(TO_CHAR(INV_WRK.INV_ISS_DT, 'YYYY-MM-DD'), TO_CHAR(RAIL_WRK.INV_ISS_DT, 'YYYY-MM-DD')) INV_ISS_DT ," ).append("\n"); 
		query.append("  NVL(TO_CHAR(INV_WRK.INV_RCV_DT, 'YYYY-MM-DD'), TO_CHAR(RAIL_WRK.INV_RCV_DT, 'YYYY-MM-DD')) INV_RCV_DT ," ).append("\n"); 
		query.append("  NVL(TO_CHAR(INV_WRK.INV_CFM_DT, 'YYYY-MM-DD'), TO_CHAR(RAIL_WRK.INV_CFM_DT, 'YYYY-MM-DD')) INV_CFM_DT ," ).append("\n"); 
		query.append("  CASE WHEN INV_WRK.INV_NO IS NULL THEN 'R' ELSE 'T' END FLAG," ).append("\n"); 
		query.append("  (SELECT DISTINCT 'C' FROM TRS_TRSP_SVC_ORD C WHERE INV_WRK.INV_VNDR_SEQ = C.INV_VNDR_SEQ AND INV_WRK.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("   SELECT DISTINCT 'R' FROM TRS_TRSP_RFND_INV C WHERE INV_WRK.INV_VNDR_SEQ = C.INV_VNDR_SEQ AND INV_WRK.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("   UNION ALL" ).append("\n"); 
		query.append("   SELECT DISTINCT 'P' FROM TRS_TRSP_POOL_CHSS_INV C WHERE INV_WRK.INV_VNDR_SEQ = C.INV_VNDR_SEQ AND INV_WRK.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("  ) INV_TP_CD," ).append("\n"); 
		query.append("  (SELECT V.VNDR_LGL_ENG_NM FROM MDM_VENDOR V WHERE NVL(INV_WRK.INV_VNDR_SEQ, RAIL_WRK.INV_VNDR_SEQ) = V.VNDR_SEQ) INV_VNDR_NM" ).append("\n"); 
		query.append("FROM AP_INV_HDR DTRB ," ).append("\n"); 
		query.append("  TRS_TRSP_INV_WRK INV_WRK ," ).append("\n"); 
		query.append("  TRS_TRSP_RAIL_INV_WRK RAIL_WRK" ).append("\n"); 
		query.append("WHERE DTRB.CSR_NO = INV_WRK.CSR_NO(+)" ).append("\n"); 
		query.append("  AND DTRB.CSR_NO = RAIL_WRK.CSR_NO(+)" ).append("\n"); 
		query.append("  AND DTRB.CSR_NO = @[CSR_NO]" ).append("\n"); 

	}
}