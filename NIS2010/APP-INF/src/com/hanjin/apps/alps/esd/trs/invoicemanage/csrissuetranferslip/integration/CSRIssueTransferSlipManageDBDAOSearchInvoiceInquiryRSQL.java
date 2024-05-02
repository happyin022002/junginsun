/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.integration").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("HDR.CSR_NO ," ).append("\n"); 
		query.append("HDR.VNDR_NO ," ).append("\n"); 
		query.append("TRS_COMMON_PKG.GET_VNDR_FULL_NM_FNC(HDR.VNDR_NO) VNDR_NM ," ).append("\n"); 
		query.append("COUNT(INV_WRK.INV_NO) INV_CNT ," ).append("\n"); 
		query.append("HDR.CSR_CURR_CD ," ).append("\n"); 
		query.append("HDR.CSR_AMT ," ).append("\n"); 
		query.append("HDR.INV_DT MAX_ISS_DT ," ).append("\n"); 
		query.append("HDR.INV_TERM_DT MAX_RCV_DT ," ).append("\n"); 
		query.append("DECODE(HDR.PAY_MZD_LU_CD, 'CHECK' , HDR.ATTR_CTNT2 , '') ASA_NO ," ).append("\n"); 
		query.append("HDR.VNDR_TERM_NM ," ).append("\n"); 
		query.append("DECODE(HDR.VNDR_TERM_NM , 'KR H/O PAYMENT_60' , NULL , 'O60' , NULL , TO_CHAR(TO_DATE(HDR.INV_TERM_DT, 'YYYY-MM-DD') + HDR.VNDR_TERM_NM, 'YYYY-MM-DD' )) PRE_DUE_DATE ," ).append("\n"); 
		query.append("TO_CHAR(TO_DATE(HDR.INV_TERM_DT, 'YYYY-MM-DD'), 'YYYY-MM-DD') PRE_DUE_DATE ," ).append("\n"); 
		query.append("INV_WRK.CRE_OFC_CD COST_OFC" ).append("\n"); 
		query.append("FROM AP_INV_HDR HDR ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CSR_NO ," ).append("\n"); 
		query.append("CRE_OFC_CD ," ).append("\n"); 
		query.append("INV_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CSR_NO ," ).append("\n"); 
		query.append("CRE_OFC_CD ," ).append("\n"); 
		query.append("INV_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_RAIL_INV_WRK" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT CSR_NO ," ).append("\n"); 
		query.append("CRE_OFC_CD ," ).append("\n"); 
		query.append("INV_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_INV_WRK )" ).append("\n"); 
		query.append("GROUP BY CSR_NO , CRE_OFC_CD , INV_NO ) INV_WRK" ).append("\n"); 
		query.append("WHERE INV_WRK.CSR_NO = HDR.CSR_NO" ).append("\n"); 
		query.append("AND HDR.CSR_NO = @[CSR_NO]" ).append("\n"); 
		query.append("GROUP BY HDR.CSR_NO , HDR.VNDR_NO , HDR.CSR_CURR_CD , HDR.CSR_AMT , HDR.INV_DT , HDR.INV_TERM_DT , HDR.PAY_MZD_LU_CD , HDR.ATTR_CTNT2 , HDR.VNDR_TERM_NM , INV_WRK.CRE_OFC_CD" ).append("\n"); 

	}
}