/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchARInvoiceChargeSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchARInvoiceChargeSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchARInvoiceChargeSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_if_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchARInvoiceChargeSumRSQL").append("\n"); 
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
		query.append("SELECT E.GUBUN," ).append("\n"); 
		query.append("  C.CURR_CD," ).append("\n"); 
		query.append("  SAR_GET_FMT_MASK_FNC(C.CURR_CD,SUM(C.CHG_AMT)) CHG_AMT," ).append("\n"); 
		query.append("  C.INV_XCH_RT," ).append("\n"); 
		query.append("  H.LOCL_CURR_CD," ).append("\n"); 
		query.append("  CASE WHEN SUM(C.CHG_AMT) = 0 THEN 0 ELSE SUM(SAR_GET_CUR_AMT_FNC(D.LOCL_CURR_CD,C.CHG_AMT*C.INV_XCH_RT)) END LOCAL_TOTAL," ).append("\n"); 
		query.append("  I.DP_PRCS_KNT DP_PRCS_KNT," ).append("\n"); 
		query.append("  J.DP_PRCS_KNT DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("FROM INV_AR_CHG C," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT DISTINCT B.CURR_CD," ).append("\n"); 
		query.append("      B.INV_XCH_RT," ).append("\n"); 
		query.append("      A.LOCL_CURR_CD" ).append("\n"); 
		query.append("    FROM INV_AR_MN A," ).append("\n"); 
		query.append("      INV_AR_CHG B" ).append("\n"); 
		query.append("    WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("      AND A.AR_IF_NO = @[max_if_no]" ).append("\n"); 
		query.append("      AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y' )D," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT '1' GUBUN," ).append("\n"); 
		query.append("      'USD' AS CURR_CD" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT DISTINCT '2' GUBUN," ).append("\n"); 
		query.append("      AR_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("    FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("    WHERE AR_OFC_CD = (" ).append("\n"); 
		query.append("        SELECT AR_OFC_CD" ).append("\n"); 
		query.append("        FROM INV_AR_MN" ).append("\n"); 
		query.append("        WHERE AR_IF_NO = @[max_if_no]" ).append("\n"); 
		query.append("          AND NVL(INV_DELT_DIV_CD, 'N') <> 'Y' )" ).append("\n"); 
		query.append("      AND AR_CURR_CD <> 'USD' ) E," ).append("\n"); 
		query.append("  INV_AR_MN H," ).append("\n"); 
		query.append("  MDM_CURRENCY I," ).append("\n"); 
		query.append("  MDM_CURRENCY J" ).append("\n"); 
		query.append("WHERE C.CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("  AND C.INV_XCH_RT = D.INV_XCH_RT" ).append("\n"); 
		query.append("  AND C.CURR_CD = E.CURR_CD(+)" ).append("\n"); 
		query.append("  AND C.AR_IF_NO = H.AR_IF_NO" ).append("\n"); 
		query.append("  AND I.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("  AND J.CURR_CD = H.LOCL_CURR_CD" ).append("\n"); 
		query.append("  AND H.AR_IF_NO = @[max_if_no]" ).append("\n"); 
		query.append("  AND NVL(H.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("GROUP BY E.GUBUN, C.CURR_CD, C.INV_XCH_RT, H.LOCL_CURR_CD, I.DP_PRCS_KNT, J.DP_PRCS_KNT" ).append("\n"); 
		query.append("ORDER BY NVL(E.GUBUN, '99'), C.CURR_CD" ).append("\n"); 

	}
}