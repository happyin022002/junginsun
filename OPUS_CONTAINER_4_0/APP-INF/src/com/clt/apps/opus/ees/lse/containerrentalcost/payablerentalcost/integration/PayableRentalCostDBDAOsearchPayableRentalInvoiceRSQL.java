/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PayableRentalCostDBDAOsearchPayableRentalInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.25
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2016.01.25 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOsearchPayableRentalInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Rental payable invoice 처리에 대한 진행 상황을 조회
	  * </pre>
	  */
	public PayableRentalCostDBDAOsearchPayableRentalInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_st_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ed_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("register_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_st_month",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("invoice_ed_month",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOsearchPayableRentalInvoiceRSQL").append("\n"); 
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
		query.append("   B.INV_STS_CD, " ).append("\n"); 
		query.append("   A.VNDR_SEQ," ).append("\n"); 
		query.append("   A.PAY_VNDR_SEQ," ).append("\n"); 
		query.append("   A.LSTM_CD," ).append("\n"); 
		query.append("   A.INV_NO," ).append("\n"); 
		query.append("   A.IF_RGST_NO," ).append("\n"); 
		query.append("   TO_CHAR(B.INV_ISS_DT,'YYYY-MM-DD') INV_ISS_DT," ).append("\n"); 
		query.append("   TO_CHAR(B.INV_RCV_DT,'YYYY-MM-DD') INV_RCV_DT," ).append("\n"); 
		query.append("   SUM(A.PAY_RNTL_COST_AMT ) PAY_RNTL_COST_AMT," ).append("\n"); 
		query.append("   SUM(A.TTL_COST_AMT ) TTL_COST_AMT," ).append("\n"); 
		query.append("   SUM(A.CR_TTL_AMT ) CR_TTL_AMT," ).append("\n"); 
		query.append("   SUBSTR(A.CHG_COST_YRMON , 0,4) || '-' || SUBSTR(A.CHG_COST_YRMON , 5,2) CHG_COST_YRMON,  -- INV Month" ).append("\n"); 
		query.append("   TO_CHAR(B.INV_EFF_DT , 'YYYY-MM') INV_EFF_YRMON,  -- INV Month" ).append("\n"); 
		query.append("   TO_CHAR(A.APRO_DT,'YYYY-MM-DD') APRO_DT," ).append("\n"); 
		query.append("   A.APRO_USR_ID," ).append("\n"); 
		query.append("   '' REMARK," ).append("\n"); 
		query.append("   'P' AS CHG_TP," ).append("\n"); 
		query.append("   B.WHLD_TAX_AMT ," ).append("\n"); 
		query.append("   B.INV_VAT_AMT  ," ).append("\n"); 
		query.append("   B.INV_TTL_AMT," ).append("\n"); 
		query.append("   LA.LSE_PAY_TP_CD AS LSE_PAY_TP_CD," ).append("\n"); 
		query.append("   LA.AGMT_CTY_CD||TRIM(TO_CHAR(LA.AGMT_SEQ, '000000')) AS AGMT_NO" ).append("\n"); 
		query.append("FROM LSE_PAY_RNTL_CHG A , AP_PAY_INV B, LSE_AGREEMENT LA" ).append("\n"); 
		query.append("WHERE A.AGMT_CTY_CD = LA.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ    = LA.AGMT_SEQ" ).append("\n"); 
		query.append("AND   A.INV_NO      = B.INV_NO" ).append("\n"); 
		query.append("AND   A.IF_RGST_NO  = DECODE(A.IF_RGST_NO, NULL, NULL, B.INV_RGST_NO)" ).append("\n"); 
		query.append("AND   B.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("#if(${search_tp} == '01')" ).append("\n"); 
		query.append("    AND A.CHG_COST_YRMON BETWEEN @[cost_st_month] AND @[cost_ed_month] -- Cost Month" ).append("\n"); 
		query.append("#elseif(${search_tp} == '02')" ).append("\n"); 
		query.append("    AND TO_CHAR(B.INV_EFF_DT,'YYYYMM') BETWEEN @[invoice_st_month] AND @[invoice_ed_month] -- Inv Month" ).append("\n"); 
		query.append("#elseif(${search_tp} == '03')" ).append("\n"); 
		query.append("    AND A.INV_NO     = @[invoice_no] -- Invoice No" ).append("\n"); 
		query.append("#elseif(${search_tp} == '04')" ).append("\n"); 
		query.append("    AND A.IF_RGST_NO = @[register_no] --Resister No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("     AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("     AND A.LSTM_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("         #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("           '$key'," ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("           '$key'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${invoice_user} != '')" ).append("\n"); 
		query.append("    AND A.APRO_USR_ID = @[invoice_user] --Invoice User" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lse_pay_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("     AND LA.LSE_PAY_TP_CD = @[lse_pay_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY  B.INV_STS_CD,A.VNDR_SEQ,A.PAY_VNDR_SEQ,A.LSTM_CD,A.INV_NO,A.IF_RGST_NO," ).append("\n"); 
		query.append("TO_CHAR(B.INV_ISS_DT,'YYYY-MM-DD'),TO_CHAR(B.INV_RCV_DT,'YYYY-MM-DD')," ).append("\n"); 
		query.append("SUBSTR(A.CHG_COST_YRMON , 0,4) || '-' || SUBSTR(A.CHG_COST_YRMON , 5,2)," ).append("\n"); 
		query.append("TO_CHAR(B.INV_EFF_DT , 'YYYY-MM'),TO_CHAR(A.APRO_DT,'YYYY-MM-DD')," ).append("\n"); 
		query.append("A.APRO_USR_ID,B.WHLD_TAX_AMT,B.INV_VAT_AMT,B.INV_TTL_AMT, LA.LSE_PAY_TP_CD,LA.AGMT_CTY_CD||TRIM(TO_CHAR(LA.AGMT_SEQ, '000000'))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT B.INV_STS_CD," ).append("\n"); 
		query.append("  A.VNDR_SEQ," ).append("\n"); 
		query.append("  NULL AS PAY_VNDR_SEQ," ).append("\n"); 
		query.append("  D.LSTM_CD," ).append("\n"); 
		query.append("  A.INV_NO," ).append("\n"); 
		query.append("  A.IF_RGST_NO," ).append("\n"); 
		query.append("  TO_CHAR(B.INV_ISS_DT, 'YYYY-MM-DD') INV_ISS_DT," ).append("\n"); 
		query.append("  TO_CHAR(B.INV_RCV_DT, 'YYYY-MM-DD') INV_RCV_DT," ).append("\n"); 
		query.append("  SUM(A.PAY_AMT ) PAY_RNTL_COST_AMT," ).append("\n"); 
		query.append("  SUM(A.PAY_AMT ) TTL_COST_AMT," ).append("\n"); 
		query.append("  0 CR_TTL_AMT," ).append("\n"); 
		query.append("  '20'||SUBSTR(A.SKD_VOY_NO, 1, 2)|| '-' ||SUBSTR(A.SKD_VOY_NO, 3, 2) CHG_COST_YRMON," ).append("\n"); 
		query.append("  TO_CHAR(B.INV_EFF_DT , 'YYYY-MM') INV_EFF_YRMON," ).append("\n"); 
		query.append("  TO_CHAR(A.PAY_DT, 'YYYY-MM-DD') APRO_DT," ).append("\n"); 
		query.append("  A.APRO_USR_ID," ).append("\n"); 
		query.append("  '' REMARK," ).append("\n"); 
		query.append("  'O' AS CHG_TP," ).append("\n"); 
		query.append("  B.WHLD_TAX_AMT ," ).append("\n"); 
		query.append("  B.INV_VAT_AMT ," ).append("\n"); 
		query.append("  B.INV_TTL_AMT," ).append("\n"); 
		query.append("  D.LSE_PAY_TP_CD AS LSE_PAY_TP_CD," ).append("\n"); 
		query.append("  D.AGMT_CTY_CD||TRIM(TO_CHAR(D.AGMT_SEQ, '000000')) AS AGMT_NO" ).append("\n"); 
		query.append("FROM LSE_OP_LSE A ," ).append("\n"); 
		query.append("  AP_PAY_INV B ," ).append("\n"); 
		query.append("  LSE_AGREEMENT D" ).append("\n"); 
		query.append("WHERE A.AGMT_CTY_CD = D.AGMT_CTY_CD" ).append("\n"); 
		query.append("  AND A.AGMT_SEQ = D.AGMT_SEQ" ).append("\n"); 
		query.append("  AND A.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("  AND A.IF_RGST_NO = DECODE(A.IF_RGST_NO, NULL, NULL, B.INV_RGST_NO)" ).append("\n"); 
		query.append("  AND B.INV_SUB_SYS_CD = 'LSE'" ).append("\n"); 
		query.append("--  AND '20'||A.SKD_VOY_NO BETWEEN '201001' AND '201001' -- Cost Month" ).append("\n"); 
		query.append("#if(${search_tp} == '01')" ).append("\n"); 
		query.append("    AND '20'||A.SKD_VOY_NO BETWEEN @[cost_st_month] AND @[cost_ed_month] -- Cost Month" ).append("\n"); 
		query.append("#elseif(${search_tp} == '02')" ).append("\n"); 
		query.append("    AND TO_CHAR(B.INV_EFF_DT,'YYYYMM') BETWEEN @[invoice_st_month] AND @[invoice_ed_month] -- Inv Month" ).append("\n"); 
		query.append("#elseif(${search_tp} == '03')" ).append("\n"); 
		query.append("    AND A.INV_NO     = @[invoice_no] -- Invoice No" ).append("\n"); 
		query.append("#elseif(${search_tp} == '04')" ).append("\n"); 
		query.append("    AND A.IF_RGST_NO = @[register_no] --Resister No" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vndr_seq} != '')" ).append("\n"); 
		query.append("     AND A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lstm_cd_str} != '')" ).append("\n"); 
		query.append("     AND D.LSTM_CD IN (" ).append("\n"); 
		query.append("       #foreach($key IN ${lstm_cd})" ).append("\n"); 
		query.append("         #if($velocityCount < $lstm_cd.size())" ).append("\n"); 
		query.append("           '$key'," ).append("\n"); 
		query.append("         #else" ).append("\n"); 
		query.append("           '$key'" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lse_pay_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("     AND D.LSE_PAY_TP_CD = @[lse_pay_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("GROUP BY B.INV_STS_CD," ).append("\n"); 
		query.append("  A.VNDR_SEQ," ).append("\n"); 
		query.append("  D.LSTM_CD," ).append("\n"); 
		query.append("  A.INV_NO," ).append("\n"); 
		query.append("  A.IF_RGST_NO," ).append("\n"); 
		query.append("  TO_CHAR(B.INV_ISS_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("  TO_CHAR(B.INV_RCV_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("  '20'||SUBSTR(A.SKD_VOY_NO, 1, 2)|| '-' ||SUBSTR(A.SKD_VOY_NO, 3, 2)," ).append("\n"); 
		query.append(" -- INV Month" ).append("\n"); 
		query.append("  TO_CHAR(B.INV_EFF_DT , 'YYYY-MM')," ).append("\n"); 
		query.append(" -- INV Month" ).append("\n"); 
		query.append("  TO_CHAR(A.PAY_DT, 'YYYY-MM-DD')," ).append("\n"); 
		query.append("  A.APRO_USR_ID," ).append("\n"); 
		query.append("  B.WHLD_TAX_AMT," ).append("\n"); 
		query.append("  B.INV_VAT_AMT," ).append("\n"); 
		query.append("  B.INV_TTL_AMT," ).append("\n"); 
		query.append("  D.LSE_PAY_TP_CD," ).append("\n"); 
		query.append("  D.AGMT_CTY_CD||TRIM(TO_CHAR(D.AGMT_SEQ, '000000'))" ).append("\n"); 

	}
}