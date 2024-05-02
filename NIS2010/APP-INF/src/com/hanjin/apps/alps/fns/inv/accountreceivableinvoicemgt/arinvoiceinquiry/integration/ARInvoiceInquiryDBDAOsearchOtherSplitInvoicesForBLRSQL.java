/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOsearchOtherSplitInvoicesForBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.22
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOsearchOtherSplitInvoicesForBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOtherSplitInvoicesForBL
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOsearchOtherSplitInvoicesForBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOsearchOtherSplitInvoicesForBLRSQL").append("\n"); 
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
		query.append("SELECT BL_SRC_NO" ).append("\n"); 
		query.append("     , INV_NO" ).append("\n"); 
		query.append("     , ACT_CUST" ).append("\n"); 
		query.append("     , POL_CD" ).append("\n"); 
		query.append("     , POD_CD" ).append("\n"); 
		query.append("     , CHG_CD" ).append("\n"); 
		query.append("     , CASE WHEN RAT_AS_CNTR_QTY < 0 THEN RAT_AS_CNTR_QTY * -1 ELSE RAT_AS_CNTR_QTY END RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("     , CASE WHEN CHG_AMT < 0 THEN CASE WHEN TRF_RT_AMT > 0 THEN TRF_RT_AMT * -1" ).append("\n"); 
		query.append("                                                           ELSE TRF_RT_AMT" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("                             ELSE CASE WHEN TRF_RT_AMT < 0 THEN TRF_RT_AMT * -1" ).append("\n"); 
		query.append("                                                           ELSE TRF_RT_AMT" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("       END TRF_RT_AMT" ).append("\n"); 
		query.append("     , PER_TP_CD" ).append("\n"); 
		query.append("     , CURR_CD" ).append("\n"); 
		query.append("     , CHG_AMT" ).append("\n"); 
		query.append("     , INV_XCH_RT" ).append("\n"); 
		query.append("     , DP_PRCS_KNT" ).append("\n"); 
		query.append("     , DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("     , ROUND(LOCAL_TOTAL, DP_PRCS_KNT_LOCAL) LOCAL_TOTAL" ).append("\n"); 
		query.append("     , ROUND(GRID_TOTAL, DP_PRCS_KNT_LOCAL) GRID_TOTAL" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("         SELECT AA.BL_SRC_NO" ).append("\n"); 
		query.append("              , AA.INV_NO" ).append("\n"); 
		query.append("              , AA.ACT_CUST" ).append("\n"); 
		query.append("              , AA.POL_CD" ).append("\n"); 
		query.append("              , AA.POD_CD" ).append("\n"); 
		query.append("              , AA.CHG_CD" ).append("\n"); 
		query.append("              , DECODE(AA.PER_TP_CD, 'PC', AA.RAT_AS_CNTR_QTY, SUM(CASE WHEN AA.CHG_AMT > 0 THEN AA.RAT_AS_CNTR_QTY ELSE AA.RAT_AS_CNTR_QTY * -1 END)) RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("              , DECODE(AA.PER_TP_CD, 'PC', SUM(CASE WHEN AA.CHG_AMT > 0 THEN AA.TRF_RT_AMT ELSE AA.TRF_RT_AMT * -1 END), AA.TRF_RT_AMT) TRF_RT_AMT" ).append("\n"); 
		query.append("              , AA.PER_TP_CD" ).append("\n"); 
		query.append("              , AA.CURR_CD" ).append("\n"); 
		query.append("              , SUM(AA.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("              , AA.INV_XCH_RT" ).append("\n"); 
		query.append("              , SUM(AA.CHG_AMT * AA.INV_XCH_RT) LOCAL_TOTAL" ).append("\n"); 
		query.append("              , AA.GRID_TOTAL GRID_TOTAL" ).append("\n"); 
		query.append("              , AA.DP_PRCS_KNT" ).append("\n"); 
		query.append("              , AA.DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("          FROM (                 " ).append("\n"); 
		query.append("                 SELECT B.BL_SRC_NO" ).append("\n"); 
		query.append("                      , B.INV_NO" ).append("\n"); 
		query.append("                      , B.ACT_CUST_CNT_CD||TO_CHAR(B.ACT_CUST_SEQ,'000000') ACT_CUST" ).append("\n"); 
		query.append("                      , A.POL_CD" ).append("\n"); 
		query.append("                      , A.POD_CD" ).append("\n"); 
		query.append("                      , C.CHG_CD" ).append("\n"); 
		query.append("                      , C.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("                      , C.TRF_RT_AMT" ).append("\n"); 
		query.append("                      , C.PER_TP_CD" ).append("\n"); 
		query.append("                      , C.CURR_CD" ).append("\n"); 
		query.append("                      , C.CHG_AMT" ).append("\n"); 
		query.append("                      , D.DP_PRCS_KNT" ).append("\n"); 
		query.append("                      , C.INV_XCH_RT" ).append("\n"); 
		query.append("                      , A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                      , C.CHG_AMT*C.INV_XCH_RT LCL_AMT" ).append("\n"); 
		query.append("                      , SUM(C.CHG_AMT*C.INV_XCH_RT) OVER (PARTITION BY C.CURR_CD) GRID_TOTAL" ).append("\n"); 
		query.append("                      , E.DP_PRCS_KNT DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("                   FROM INV_AR_MN A" ).append("\n"); 
		query.append("                      , ( SELECT INV_NO,INV_SEQ,AR_OFC_CD,ACT_CUST_CNT_CD,ACT_CUST_SEQ, BL_SRC_NO,BKG_NO, AR_IF_NO" ).append("\n"); 
		query.append("                          FROM   INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("                          WHERE  1=1" ).append("\n"); 
		query.append("                          AND    AR_OFC_CD = @[ofc]" ).append("\n"); 
		query.append("                          AND    BL_SRC_NO = @[bl_no]" ).append("\n"); 
		query.append("                          AND   (AR_OFC_CD, BL_SRC_NO, INV_SPLIT_ISS_WRK_NO) IN (" ).append("\n"); 
		query.append("                                                                                   SELECT AR_OFC_CD, BL_SRC_NO, MAX(INV_SPLIT_ISS_WRK_NO)" ).append("\n"); 
		query.append("                                                                                   FROM   INV_AR_SPLIT_ISS" ).append("\n"); 
		query.append("                                                                                   WHERE  INV_SPLIT_ISS_WRK_NO IS NOT NULL" ).append("\n"); 
		query.append("                                                                                   GROUP BY AR_OFC_CD, BL_SRC_NO) ) B" ).append("\n"); 
		query.append("                      , INV_AR_SPLIT_ISS_CHG C" ).append("\n"); 
		query.append("                      , MDM_CURRENCY D" ).append("\n"); 
		query.append("                      , MDM_CURRENCY E" ).append("\n"); 
		query.append("                  WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("                    AND B.INV_NO  = C.INV_NO" ).append("\n"); 
		query.append("                    AND B.INV_SEQ = C.INV_SEQ" ).append("\n"); 
		query.append("                    AND D.CURR_CD = C.CURR_CD" ).append("\n"); 
		query.append("                    AND E.CURR_CD = A.LOCL_CURR_CD" ).append("\n"); 
		query.append("                    AND C.CHG_AMT <> 0" ).append("\n"); 
		query.append("                    AND B.AR_OFC_CD = @[ofc]" ).append("\n"); 
		query.append("                    AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("                    AND B.BL_SRC_NO = @[bl_no]                               " ).append("\n"); 
		query.append("                ) AA" ).append("\n"); 
		query.append("       GROUP BY AA.BL_SRC_NO, AA.INV_NO, AA.ACT_CUST, AA.POL_CD, AA.POD_CD, AA.CHG_CD, AA.RAT_AS_CNTR_QTY, AA.TRF_RT_AMT, AA.PER_TP_CD, AA.CURR_CD, AA.INV_XCH_RT, AA.GRID_TOTAL, AA.DP_PRCS_KNT, AA.DP_PRCS_KNT_LOCAL" ).append("\n"); 
		query.append("       ORDER BY AA.INV_NO, AA.CHG_CD, AA.POL_CD, AA.POD_CD, AA.TRF_RT_AMT, AA.PER_TP_CD, AA.CURR_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(" WHERE CHG_AMT <> 0" ).append("\n"); 

	}
}