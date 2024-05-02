/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceChargeSumVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.11.04 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOARInvoiceChargeSumVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceChargeSumVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceChargeSumVORSQL").append("\n"); 
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
		query.append("SELECT AA.CURR_CD," ).append("\n"); 
		query.append("SUM(AA.CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("AA.INV_XCH_RT," ).append("\n"); 
		query.append("SUM(AA.LCL_AMT) LOCAL_TOTAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT E.GUBUN," ).append("\n"); 
		query.append("C.CURR_CD," ).append("\n"); 
		query.append("C.CHG_AMT," ).append("\n"); 
		query.append("ROUND(C.CHG_AMT * C.INV_XCH_RT, J.DP_PRCS_KNT) LCL_AMT," ).append("\n"); 
		query.append("C.INV_XCH_RT," ).append("\n"); 
		query.append("H.LOCL_CURR_CD," ).append("\n"); 
		query.append("I.DP_PRCS_KNT DP_PRCS_KNT," ).append("\n"); 
		query.append("J.DP_PRCS_KNT DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("FROM INV_AR_CHG C," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT CURR_CD," ).append("\n"); 
		query.append("INV_XCH_RT" ).append("\n"); 
		query.append("FROM INV_AR_CHG" ).append("\n"); 
		query.append("WHERE (AR_IF_NO," ).append("\n"); 
		query.append("CURR_CD) IN (" ).append("\n"); 
		query.append("SELECT MAX(AR_IF_NO)," ).append("\n"); 
		query.append("CURR_CD" ).append("\n"); 
		query.append("FROM INV_AR_CHG" ).append("\n"); 
		query.append("WHERE (AR_IF_NO) IN (" ).append("\n"); 
		query.append("SELECT A.AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_ISS_DTL A," ).append("\n"); 
		query.append("INV_AR_MN B" ).append("\n"); 
		query.append("WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("AND A.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND B.AR_OFC_CD = @[ofc]" ).append("\n"); 
		query.append("AND NVL(B.INV_DELT_DIV_CD, 'N') <> 'Y' )" ).append("\n"); 
		query.append("GROUP BY CURR_CD))D," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT '1' GUBUN," ).append("\n"); 
		query.append("'USD' AS CURR_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' GUBUN," ).append("\n"); 
		query.append("AR_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE OFC_CD = @[ofc]" ).append("\n"); 
		query.append("AND AR_CURR_CD != 'USD' ) E," ).append("\n"); 
		query.append("INV_AR_MN H," ).append("\n"); 
		query.append("MDM_CURRENCY I," ).append("\n"); 
		query.append("MDM_CURRENCY J" ).append("\n"); 
		query.append("WHERE C.CURR_CD = D.CURR_CD" ).append("\n"); 
		query.append("AND C.INV_XCH_RT = D.INV_XCH_RT" ).append("\n"); 
		query.append("AND C.CURR_CD = E.CURR_CD(+)" ).append("\n"); 
		query.append("AND C.AR_IF_NO = H.AR_IF_NO" ).append("\n"); 
		query.append("AND I.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("AND J.CURR_CD = H.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND C.AR_IF_NO IN (" ).append("\n"); 
		query.append("SELECT G.AR_IF_NO" ).append("\n"); 
		query.append("FROM INV_AR_ISS_DTL F," ).append("\n"); 
		query.append("INV_AR_MN G" ).append("\n"); 
		query.append("WHERE F.AR_IF_NO = G.AR_IF_NO" ).append("\n"); 
		query.append("AND F.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("AND G.AR_OFC_CD = @[ofc])" ).append("\n"); 
		query.append("AND NVL(H.INV_DELT_DIV_CD, 'N') <> 'Y' ) AA" ).append("\n"); 
		query.append("GROUP BY AA.GUBUN, AA.CURR_CD, AA.INV_XCH_RT, AA.DP_PRCS_KNT, AA.DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("ORDER BY NVL(AA.GUBUN, '99'), AA.CURR_CD" ).append("\n"); 

	}
}