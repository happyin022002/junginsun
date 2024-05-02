/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceInquiryDBDAOSearchNotIssueAgingByCustomerRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.25
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2010.02.25 박정진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JungJin, Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceInquiryDBDAOSearchNotIssueAgingByCustomerRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer의 I/B, O/B 별로 Invoice 미발행건수 및  Due date까지 남은 일수를 현재일로부터  날짜수 조건에 따라 집계한다.
	  * </pre>
	  */
	public ARInvoiceInquiryDBDAOSearchNotIssueAgingByCustomerRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("day3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("day2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("as_of_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("day1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("day5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("day4",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration").append("\n"); 
		query.append("FileName : ARInvoiceInquiryDBDAOSearchNotIssueAgingByCustomerRSQL").append("\n"); 
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
		query.append("SELECT MN.AR_OFC_CD," ).append("\n"); 
		query.append("  MN.IO_BND_CD," ).append("\n"); 
		query.append("  ST1.CR_CLT_OFC_CD," ).append("\n"); 
		query.append("  ST1.CR_AMT," ).append("\n"); 
		query.append("  ST1.IB_CR_TERM_DYS," ).append("\n"); 
		query.append("  ST1.OB_CR_TERM_DYS," ).append("\n"); 
		query.append("  ST2.DP_PRCS_KNT," ).append("\n"); 
		query.append("  MN.DAY1," ).append("\n"); 
		query.append("  MN.DAY2," ).append("\n"); 
		query.append("  MN.DAY3," ).append("\n"); 
		query.append("  MN.DAY4," ).append("\n"); 
		query.append("  MN.DAY5," ).append("\n"); 
		query.append("  MN.NOT_ARRIVED_CNT + MN.WI_TERM_CNT + MN.BELOW_DAY1_CNT + MN.BELOW_DAY2_CNT + MN.BELOW_DAY3_CNT + MN.BELOW_DAY4_CNT + MN.BELOW_DAY5_CNT + MN.OVER_DAY5_CNT TTL_CNT," ).append("\n"); 
		query.append("  ROUND(MN.NOT_ARRIVED + MN.WI_TERM + MN.BELOW_DAY1 + MN.BELOW_DAY2 + MN.BELOW_DAY3 + MN.BELOW_DAY4 + MN.BELOW_DAY5 + MN.OVER_DAY5, ST2.DP_PRCS_KNT) TTL_AMT," ).append("\n"); 
		query.append("  MN.NOT_ARRIVED_CNT + MN.WI_TERM_CNT TTL_WI_TERM_CNT," ).append("\n"); 
		query.append("  ROUND(MN.NOT_ARRIVED + MN.WI_TERM, ST2.DP_PRCS_KNT) TTL_WI_TERM_AMT," ).append("\n"); 
		query.append("  MN.NOT_ARRIVED_CNT," ).append("\n"); 
		query.append("  ROUND(MN.NOT_ARRIVED, ST2.DP_PRCS_KNT) NOT_ARRIVED_AMT," ).append("\n"); 
		query.append("  MN.WI_TERM_CNT," ).append("\n"); 
		query.append("  ROUND(MN.WI_TERM, ST2.DP_PRCS_KNT) WI_TERM_AMT," ).append("\n"); 
		query.append("  MN.NOT_ARRIVED_CNT + MN.WI_TERM_CNT TTL_WI_TERM_CNT," ).append("\n"); 
		query.append("  ROUND(MN.NOT_ARRIVED + MN.WI_TERM, ST2.DP_PRCS_KNT) TTL_WI_TERM_AMT," ).append("\n"); 
		query.append("  MN.BELOW_DAY1_CNT + MN.BELOW_DAY2_CNT + MN.BELOW_DAY3_CNT + MN.BELOW_DAY4_CNT + MN.BELOW_DAY5_CNT + MN.OVER_DAY5_CNT LT_CNT," ).append("\n"); 
		query.append("  ROUND(MN.BELOW_DAY1 + MN.BELOW_DAY2 + MN.BELOW_DAY3 + MN.BELOW_DAY4 + MN.BELOW_DAY5 + MN.OVER_DAY5, ST2.DP_PRCS_KNT) TTL_LT_AMT," ).append("\n"); 
		query.append("  MN.BELOW_DAY1_CNT," ).append("\n"); 
		query.append("  ROUND(MN.BELOW_DAY1, ST2.DP_PRCS_KNT) BELOW_DAY1_AMT," ).append("\n"); 
		query.append("  MN.BELOW_DAY2_CNT," ).append("\n"); 
		query.append("  ROUND(MN.BELOW_DAY2, ST2.DP_PRCS_KNT) BELOW_DAY2_AMT," ).append("\n"); 
		query.append("  MN.BELOW_DAY3_CNT," ).append("\n"); 
		query.append("  ROUND(MN.BELOW_DAY3, ST2.DP_PRCS_KNT) BELOW_DAY3_AMT," ).append("\n"); 
		query.append("  MN.BELOW_DAY4_CNT," ).append("\n"); 
		query.append("  ROUND(MN.BELOW_DAY4, ST2.DP_PRCS_KNT) BELOW_DAY4_AMT," ).append("\n"); 
		query.append("  MN.BELOW_DAY5_CNT," ).append("\n"); 
		query.append("  ROUND(MN.BELOW_DAY5, ST2.DP_PRCS_KNT) BELOW_DAY5_AMT," ).append("\n"); 
		query.append("  MN.OVER_DAY5_CNT," ).append("\n"); 
		query.append("  ROUND(MN.OVER_DAY5, ST2.DP_PRCS_KNT) OVER_DAY5_AMT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("-- O/B" ).append("\n"); 
		query.append("    SELECT TB.AR_OFC_CD," ).append("\n"); 
		query.append("      TB.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("      TB.ACT_CUST_SEQ," ).append("\n"); 
		query.append("      'O/B' IO_BND_CD," ).append("\n"); 
		query.append("      TB.LOCL_CURR_CD," ).append("\n"); 
		query.append("      TB.DAY1," ).append("\n"); 
		query.append("      TB.DAY2," ).append("\n"); 
		query.append("      TB.DAY3," ).append("\n"); 
		query.append("      TB.DAY4," ).append("\n"); 
		query.append("      TB.DAY5," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.SAIL_ARR_DT >  TB.AS_OF_DT THEN 1 ELSE 0 END) NOT_ARRIVED_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.SAIL_ARR_DT >  TB.AS_OF_DT THEN TB.CHG_AMT ELSE 0 END) NOT_ARRIVED," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.SAIL_ARR_DT <= TB.AS_OF_DT AND TB.DUE_DT >= TB.AS_OF_DT THEN 1 ELSE 0 END) WI_TERM_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.SAIL_ARR_DT <= TB.AS_OF_DT AND TB.DUE_DT >= TB.AS_OF_DT THEN TB.CHG_AMT ELSE 0 END) WI_TERM," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY0) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY1) THEN 1 ELSE 0 END) BELOW_DAY1_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY0) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY1) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY1," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY1) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY2) THEN 1 ELSE 0 END) BELOW_DAY2_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY1) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY2) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY2," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY2) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY3) THEN 1 ELSE 0 END) BELOW_DAY3_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY2) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY3) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY3," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY3) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY4) THEN 1 ELSE 0 END) BELOW_DAY4_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY3) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY4) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY4," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY4) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY5) THEN 1 ELSE 0 END) BELOW_DAY5_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY4) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY5) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY5," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY5) < TB.OVER_DUE THEN 1 ELSE 0 END) OVER_DAY5_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY5) < TB.OVER_DUE THEN TB.CHG_AMT ELSE 0 END) OVER_DAY5" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT A.AR_OFC_CD," ).append("\n"); 
		query.append("          A.AR_IF_NO," ).append("\n"); 
		query.append("          A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("          A.ACT_CUST_SEQ," ).append("\n"); 
		query.append("#if(${curr_flag} == 'U')" ).append("\n"); 
		query.append("-- USD" ).append("\n"); 
		query.append("          DECODE(A.USD_XCH_RT, 0, 0, SUM(B.CHG_AMT * B.INV_XCH_RT) / A.USD_XCH_RT) CHG_AMT," ).append("\n"); 
		query.append("          'USD' LOCL_CURR_CD," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("-- LCL" ).append("\n"); 
		query.append("          SUM(B.CHG_AMT * B.INV_XCH_RT) CHG_AMT," ).append("\n"); 
		query.append("          A.LOCL_CURR_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYYMMDD') SAIL_ARR_DT," ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(A.DUE_DT, 'YYYYMMDD'), 'YYYYMMDD') DUE_DT," ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(REPLACE(@[as_of_dt], '-', ''), 'YYYYMMDD'), 'YYYYMMDD') AS_OF_DT," ).append("\n"); 
		query.append("          TO_DATE(REPLACE(@[as_of_dt], '-', ''), 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') OVER_DUE," ).append("\n"); 
		query.append("          '0' DAY0," ).append("\n"); 
		query.append("          @[day1] DAY1," ).append("\n"); 
		query.append("          @[day2] DAY2," ).append("\n"); 
		query.append("          @[day3] DAY3," ).append("\n"); 
		query.append("          @[day4] DAY4," ).append("\n"); 
		query.append("          @[day5] DAY5" ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("          INV_AR_CHG B" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("          AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("          AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("          AND A.AR_OFC_CD = @[ar_ofc_cd] -- OFFICE" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("          AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                            WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                               FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                              WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                                  AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND A.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("          AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("          AND A.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '')" ).append("\n"); 
		query.append("-- SCP" ).append("\n"); 
		query.append("          AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ex_rate_flag} == 'A')" ).append("\n"); 
		query.append("-- USD_XCH_RT" ).append("\n"); 
		query.append("          AND A.USD_XCH_RT != 0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND A.USD_XCH_RT = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY A.AR_OFC_CD, A.AR_IF_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.USD_XCH_RT, A.LOCL_CURR_CD, A.SAIL_ARR_DT, A.DUE_DT ) TB" ).append("\n"); 
		query.append("#if(${amt_option} == 'P')" ).append("\n"); 
		query.append("-- AMT_OPTION" ).append("\n"); 
		query.append("    WHERE TB.CHG_AMT >= 0" ).append("\n"); 
		query.append("#elseif(${amt_option} == 'M')" ).append("\n"); 
		query.append("    WHERE TB.CHG_AMT < 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY TB.AR_OFC_CD, TB.ACT_CUST_CNT_CD, TB.ACT_CUST_SEQ, TB.LOCL_CURR_CD, TB.DAY1, TB.DAY2, TB.DAY3, TB.DAY4, TB.DAY5" ).append("\n"); 
		query.append("-- I/B" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT TB.AR_OFC_CD," ).append("\n"); 
		query.append("      TB.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("      TB.ACT_CUST_SEQ," ).append("\n"); 
		query.append("      'I/B' IO_BND_CD," ).append("\n"); 
		query.append("      TB.LOCL_CURR_CD," ).append("\n"); 
		query.append("      TB.DAY1," ).append("\n"); 
		query.append("      TB.DAY2," ).append("\n"); 
		query.append("      TB.DAY3," ).append("\n"); 
		query.append("      TB.DAY4," ).append("\n"); 
		query.append("      TB.DAY5," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.SAIL_ARR_DT >  TB.AS_OF_DT THEN 1 ELSE 0 END) NOT_ARRIVED_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.SAIL_ARR_DT >  TB.AS_OF_DT THEN TB.CHG_AMT ELSE 0 END) NOT_ARRIVED," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.SAIL_ARR_DT <= TB.AS_OF_DT AND TB.DUE_DT >= TB.AS_OF_DT THEN 1 ELSE 0 END) WI_TERM_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.SAIL_ARR_DT <= TB.AS_OF_DT AND TB.DUE_DT >= TB.AS_OF_DT THEN TB.CHG_AMT ELSE 0 END) WI_TERM," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY0) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY1) THEN 1 ELSE 0 END) BELOW_DAY1_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY0) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY1) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY1," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY1) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY2) THEN 1 ELSE 0 END) BELOW_DAY2_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY1) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY2) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY2," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY2) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY3) THEN 1 ELSE 0 END) BELOW_DAY3_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY2) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY3) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY3," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY3) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY4) THEN 1 ELSE 0 END) BELOW_DAY4_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY3) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY4) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY4," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY4) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY5) THEN 1 ELSE 0 END) BELOW_DAY5_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY4) < TB.OVER_DUE AND TB.OVER_DUE <= TO_NUMBER(TB.DAY5) THEN TB.CHG_AMT ELSE 0 END) BELOW_DAY5," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY5) < TB.OVER_DUE THEN 1 ELSE 0 END) OVER_DAY5_CNT," ).append("\n"); 
		query.append("      SUM(CASE WHEN TB.DUE_DT < TB.AS_OF_DT AND TO_NUMBER(TB.DAY5) < TB.OVER_DUE THEN TB.CHG_AMT ELSE 0 END) OVER_DAY5" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT A.AR_OFC_CD," ).append("\n"); 
		query.append("          A.AR_IF_NO," ).append("\n"); 
		query.append("          A.ACT_CUST_CNT_CD," ).append("\n"); 
		query.append("          A.ACT_CUST_SEQ," ).append("\n"); 
		query.append("#if(${curr_flag} == 'U')" ).append("\n"); 
		query.append("-- USD" ).append("\n"); 
		query.append("          DECODE(A.USD_XCH_RT, 0, 0, SUM(B.CHG_AMT * B.INV_XCH_RT) / A.USD_XCH_RT) CHG_AMT," ).append("\n"); 
		query.append("          'USD' LOCL_CURR_CD," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("-- LCL" ).append("\n"); 
		query.append("          SUM(B.CHG_AMT * B.INV_XCH_RT) CHG_AMT," ).append("\n"); 
		query.append("          A.LOCL_CURR_CD," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(A.SAIL_ARR_DT, 'YYYYMMDD'), 'YYYYMMDD') SAIL_ARR_DT," ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(A.DUE_DT, 'YYYYMMDD'), 'YYYYMMDD') DUE_DT," ).append("\n"); 
		query.append("          TO_CHAR(TO_DATE(REPLACE(@[as_of_dt], '-', ''), 'YYYYMMDD'), 'YYYYMMDD') AS_OF_DT," ).append("\n"); 
		query.append("          TO_DATE(REPLACE(@[as_of_dt], '-', ''), 'YYYYMMDD') - TO_DATE(A.DUE_DT, 'YYYYMMDD') OVER_DUE," ).append("\n"); 
		query.append("          '0' DAY0," ).append("\n"); 
		query.append("          @[day1] DAY1," ).append("\n"); 
		query.append("          @[day2] DAY2," ).append("\n"); 
		query.append("          @[day3] DAY3," ).append("\n"); 
		query.append("          @[day4] DAY4," ).append("\n"); 
		query.append("          @[day5] DAY5" ).append("\n"); 
		query.append("        FROM INV_AR_MN A," ).append("\n"); 
		query.append("          INV_AR_CHG B" ).append("\n"); 
		query.append("        WHERE A.AR_IF_NO = B.AR_IF_NO" ).append("\n"); 
		query.append("          AND A.ACT_CUST_CNT_CD = @[act_cust_cnt_cd]" ).append("\n"); 
		query.append("          AND A.ACT_CUST_SEQ = @[act_cust_seq]" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '')" ).append("\n"); 
		query.append("          AND A.AR_OFC_CD = @[ar_ofc_cd] -- OFFICE" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND A.AR_OFC_CD IN ( SELECT OFC_CD -- OFC ALL 선택시 적용..  " ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                WHERE AR_HD_QTR_OFC_CD = ( SELECT AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("                                                             FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                            WHERE OFC_CD = ( SELECT AR_OFC_CD" ).append("\n"); 
		query.append("                                                                               FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                                                              WHERE OFC_CD = @[user_ofc_cd]))" ).append("\n"); 
		query.append("                                  AND OFC_CD = AR_OFC_CD )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          AND A.IO_BND_CD = 'I'" ).append("\n"); 
		query.append("          AND NVL(A.INV_DELT_DIV_CD, 'N') <> 'Y'" ).append("\n"); 
		query.append("          AND A.INV_ISS_FLG = 'N'" ).append("\n"); 
		query.append("#if(${svc_scp_cd} != '')" ).append("\n"); 
		query.append("-- SCP" ).append("\n"); 
		query.append("          AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${ex_rate_flag} == 'A')" ).append("\n"); 
		query.append("-- USD_XCH_RT" ).append("\n"); 
		query.append("          AND A.USD_XCH_RT != 0" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          AND A.USD_XCH_RT = 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        GROUP BY A.AR_OFC_CD, A.AR_IF_NO, A.ACT_CUST_CNT_CD, A.ACT_CUST_SEQ, A.USD_XCH_RT, A.LOCL_CURR_CD, A.SAIL_ARR_DT, A.DUE_DT ) TB" ).append("\n"); 
		query.append("#if(${amt_option} == 'P')" ).append("\n"); 
		query.append("-- AMT_OPTION" ).append("\n"); 
		query.append("    WHERE TB.CHG_AMT >= 0" ).append("\n"); 
		query.append("#elseif(${amt_option} == 'M')" ).append("\n"); 
		query.append("    WHERE TB.CHG_AMT < 0" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    GROUP BY TB.AR_OFC_CD, TB.ACT_CUST_CNT_CD, TB.ACT_CUST_SEQ, TB.LOCL_CURR_CD, TB.DAY1, TB.DAY2, TB.DAY3, TB.DAY4, TB.DAY5 ) MN," ).append("\n"); 
		query.append("  MDM_CR_CUST ST1," ).append("\n"); 
		query.append("  MDM_CURRENCY ST2" ).append("\n"); 
		query.append("WHERE MN.ACT_CUST_CNT_CD = ST1.CUST_CNT_CD (+)" ).append("\n"); 
		query.append("  AND MN.ACT_CUST_SEQ = ST1.CUST_SEQ (+)" ).append("\n"); 
		query.append("  AND MN.LOCL_CURR_CD = ST2.CURR_CD" ).append("\n"); 
		query.append("  AND (MN.NOT_ARRIVED_CNT + MN.WI_TERM_CNT + MN.BELOW_DAY1_CNT + MN.BELOW_DAY2_CNT + MN.BELOW_DAY3_CNT + MN.BELOW_DAY4_CNT + MN.BELOW_DAY5_CNT + MN.OVER_DAY5_CNT) > 0" ).append("\n"); 
		query.append("ORDER BY MN.AR_OFC_CD, MN.IO_BND_CD DESC" ).append("\n"); 

	}
}