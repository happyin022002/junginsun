/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOARInvoiceChargeByINVNoVORSQL.java
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

public class ARInvoiceInquiryDBDAOARInvoiceChargeByINVNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOARInvoiceChargeByINVNoVORSQL(){
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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOARInvoiceChargeByINVNoVORSQL").append("\n"); 
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
		query.append("SELECT BL_SRC_NO," ).append("\n"); 
		query.append("  POL_CD," ).append("\n"); 
		query.append("  POD_CD," ).append("\n"); 
		query.append("  CHG_CD," ).append("\n"); 
		query.append("  RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("  SAR_GET_FMT_MASK_FNC(CURR_CD,TRF_RT_AMT) TRF_RT_AMT," ).append("\n"); 
		query.append("  PER_TP_CD," ).append("\n"); 
		query.append("  CURR_CD," ).append("\n"); 
		query.append("  SAR_GET_FMT_MASK_FNC(CURR_CD,CHG_AMT) CHG_AMT," ).append("\n"); 
		query.append("  INV_XCH_RT," ).append("\n"); 
		query.append("  SAR_GET_CUR_AMT_FNC(LOCL_CURR_CD,LOCAL_TOTAL) LOCAL_TOTAL," ).append("\n"); 
		query.append("  SAR_GET_CUR_AMT_FNC(LOCL_CURR_CD,GRID_TOTAL) GRID_TOTAL," ).append("\n"); 
		query.append("  DP_PRCS_KNT," ).append("\n"); 
		query.append("  DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("  INV_CURR_CD," ).append("\n"); 
		query.append("  ISS_XCH_RT," ).append("\n"); 
		query.append("  SAR_GET_CUR_AMT_FNC(INV_CURR_CD,INV_TOTAL) INV_TOTAL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT AA.BL_SRC_NO," ).append("\n"); 
		query.append("      AA.POL_CD," ).append("\n"); 
		query.append("      AA.POD_CD," ).append("\n"); 
		query.append("      AA.CHG_CD," ).append("\n"); 
		query.append("      AA.RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("      AA.TRF_RT_AMT TRF_RT_AMT," ).append("\n"); 
		query.append("      AA.PER_TP_CD," ).append("\n"); 
		query.append("      AA.CURR_CD," ).append("\n"); 
		query.append("      AA.CHG_AMT," ).append("\n"); 
		query.append("      AA.INV_XCH_RT," ).append("\n"); 
		query.append("      AA.LCL_AMT LOCAL_TOTAL," ).append("\n"); 
		query.append("      SUM(AA.LCL_AMT) OVER (PARTITION BY AA.CURR_CD) GRID_TOTAL," ).append("\n"); 
		query.append("      AA.DP_PRCS_KNT," ).append("\n"); 
		query.append("      AA.DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("      AA.INV_CURR_CD," ).append("\n"); 
		query.append("      AA.ISS_XCH_RT," ).append("\n"); 
		query.append("      AA.INV_AMT INV_TOTAL," ).append("\n"); 
		query.append("      AA.LOCL_CURR_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT A.AR_IF_NO," ).append("\n"); 
		query.append("		  A.BL_SRC_NO," ).append("\n"); 
		query.append("          A.POL_CD," ).append("\n"); 
		query.append("          A.POD_CD," ).append("\n"); 
		query.append("          B.CHG_CD," ).append("\n"); 
		query.append("          B.RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("          B.TRF_RT_AMT," ).append("\n"); 
		query.append("          B.PER_TP_CD," ).append("\n"); 
		query.append("          B.CURR_CD," ).append("\n"); 
		query.append("          B.CHG_AMT," ).append("\n"); 
		query.append("          D.DP_PRCS_KNT," ).append("\n"); 
		query.append("          B.INV_XCH_RT," ).append("\n"); 
		query.append("          A.LOCL_CURR_CD," ).append("\n"); 
		query.append("          B.CHG_AMT*B.INV_XCH_RT LCL_AMT," ).append("\n"); 
		query.append("          E.DP_PRCS_KNT DP_PRCS_KNT_LOCAL," ).append("\n"); 
		query.append("          A.INV_CURR_CD," ).append("\n"); 
		query.append("          B.ISS_XCH_RT," ).append("\n"); 
		query.append("          B.CHG_AMT*B.ISS_XCH_RT INV_AMT" ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("          INV_AR_CHG B," ).append("\n"); 
		query.append("          INV_AR_ISS_DTL C," ).append("\n"); 
		query.append("          MDM_CURRENCY D," ).append("\n"); 
		query.append("          MDM_CURRENCY E" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("          AND B.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("          AND B.CHG_SEQ = C.CHG_SEQ" ).append("\n"); 
		query.append("          AND D.CURR_CD = B.CURR_CD" ).append("\n"); 
		query.append("          AND E.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("          AND B.CHG_AMT <> 0" ).append("\n"); 
		query.append("          AND A.AR_OFC_CD = @[ofc]" ).append("\n"); 
		query.append("          AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("          AND C.INV_NO = @[inv_no] ) AA" ).append("\n"); 
		query.append("    ORDER BY AA.BL_SRC_NO, AA.CHG_CD, AA.PER_TP_CD, AA.CURR_CD, AA.AR_IF_NO)" ).append("\n"); 

	}
}