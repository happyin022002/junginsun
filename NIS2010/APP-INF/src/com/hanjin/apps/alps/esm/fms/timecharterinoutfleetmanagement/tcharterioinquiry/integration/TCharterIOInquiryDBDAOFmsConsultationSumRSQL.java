/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInquiryDBDAOFmsConsultationSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInquiryDBDAOFmsConsultationSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Statement of Account Sum Select
	  * </pre>
	  */
	public TCharterIOInquiryDBDAOFmsConsultationSumRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hir_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.integration").append("\n"); 
		query.append("FileName : TCharterIOInquiryDBDAOFmsConsultationSumRSQL").append("\n"); 
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
		query.append("SELECT '' ITM_NM," ).append("\n"); 
		query.append("'' HIRE_NO," ).append("\n"); 
		query.append("'' ACCT_DT," ).append("\n"); 
		query.append("'' ACCT_DESC," ).append("\n"); 
		query.append("BBBB.CURR_CD1," ).append("\n"); 
		query.append("BBBB.DR_AMT," ).append("\n"); 
		query.append("CCCC.CURR_CD2," ).append("\n"); 
		query.append("CCCC.CR_AMT" ).append("\n"); 
		query.append("FROM (SELECT '1' NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '2' NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '3' NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '4' NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '5' NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '6' NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '7' NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '8' NUM FROM DUAL" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT '9' NUM FROM DUAL) AAAA," ).append("\n"); 
		query.append("(SELECT ROWNUM NUM," ).append("\n"); 
		query.append("CURR_CD1," ).append("\n"); 
		query.append("DR_AMT" ).append("\n"); 
		query.append("FROM (SELECT CURR_CD1," ).append("\n"); 
		query.append("SUM(DR_AMT) DR_AMT" ).append("\n"); 
		query.append("FROM  /*--------- 1. Prepayment - Hire ----------*/" ).append("\n"); 
		query.append("(SELECT A.CURR_CD CURR_CD1," ).append("\n"); 
		query.append("A.INV_AMT DR_AMT" ).append("\n"); 
		query.append("FROM FMS_INVOICE D," ).append("\n"); 
		query.append("FMS_INV_DTL A," ).append("\n"); 
		query.append("FMS_ACCT_ITM B" ).append("\n"); 
		query.append("WHERE D.FLET_CTRT_NO = A.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND D.FLET_ISS_TP_CD = A.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("AND D.INV_SEQ = A.INV_SEQ" ).append("\n"); 
		query.append("AND D.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND A.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("AND A.ACCT_CD = '510911'" ).append("\n"); 
		query.append("AND (A.SLP_TP_CD LIKE '19%' OR A.SLP_TP_CD LIKE '07%' OR A.SLP_TP_CD LIKE '20%')" ).append("\n"); 
		query.append("AND A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND B.ACCT_CD = '510911'" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND D.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*--------- 2. Prepayment - Other’s Expenses / Lumpsum ----------*/" ).append("\n"); 
		query.append("SELECT A.CURR_CD CURR_CD1," ).append("\n"); 
		query.append("A.INV_AMT DR_AMT" ).append("\n"); 
		query.append("FROM FMS_INV_DTL A," ).append("\n"); 
		query.append("FMS_ACCT_ITM B," ).append("\n"); 
		query.append("FMS_INVOICE C" ).append("\n"); 
		query.append("WHERE A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND A.FLET_ISS_TP_CD = 'PRE'" ).append("\n"); 
		query.append("AND (A.SLP_TP_CD LIKE '19%' OR A.SLP_TP_CD LIKE '07%' OR A.SLP_TP_CD LIKE '20%')" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = C.FLET_CTRT_NO" ).append("\n"); 
		query.append("AND A.FLET_ISS_TP_CD = C.FLET_ISS_TP_CD" ).append("\n"); 
		query.append("AND A.INV_SEQ = C.INV_SEQ" ).append("\n"); 
		query.append("AND A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND C.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.ACCT_CD <> '510911'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*--------- 4. Charterer''s Account ----------*/" ).append("\n"); 
		query.append("SELECT A.CURR_CD CURR_CD1," ).append("\n"); 
		query.append("DECODE(A.CHTR_PAY_RCV_CD,'P',A.INV_AMT,A.INV_AMT * -1) DR_AMT" ).append("\n"); 
		query.append("FROM FMS_INV_DTL A," ).append("\n"); 
		query.append("FMS_ACCT_ITM B," ).append("\n"); 
		query.append("FMS_CONSULTATION C" ).append("\n"); 
		query.append("WHERE A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND A.FLET_ISS_TP_CD = 'CHT'" ).append("\n"); 
		query.append("AND (A.SLP_TP_CD LIKE '19%' OR A.SLP_TP_CD LIKE '07%' OR A.SLP_TP_CD LIKE '20%')" ).append("\n"); 
		query.append("AND A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND A.SLP_TP_CD = C.SLP_TP_CD(+)" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = C.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = C.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = C.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = C.SLP_SER_NO(+)" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND C.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*--------- 6. Bunker On Delivery ----------*/" ).append("\n"); 
		query.append("SELECT B.CSR_CURR_CD CURR_CD1," ).append("\n"); 
		query.append("(A.BNK_QTY*A.BNK_PRC_AMT) DR_AMT" ).append("\n"); 
		query.append("FROM FMS_BUNKER A," ).append("\n"); 
		query.append("FMS_CONSULTATION B," ).append("\n"); 
		query.append("FMS_ACCT_ITM C," ).append("\n"); 
		query.append("FMS_ACCT_CATE D" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.BNK_TP_CD = 'BOD'" ).append("\n"); 
		query.append("AND B.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = C.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND B.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND B.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = C.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND A.ACCT_CD = D.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = D.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND D.FLET_ACCT_CATE_CD = 'BU'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*--------- 8. Others(+) ----------*/" ).append("\n"); 
		query.append("SELECT B.CSR_CURR_CD CURR_CD1," ).append("\n"); 
		query.append("B.CSR_AMT DR_AMT" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("--AND A.PPAY_HIR_NO IS NULL" ).append("\n"); 
		query.append("AND A.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.CSR_AMT >= 0" ).append("\n"); 
		query.append("AND B.FLET_SRC_TP_CD IN ('10', '11', '20', '98', '99')" ).append("\n"); 
		query.append("--AND B.ACCT_CD NOT IN ('954112', '241121')" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND A.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.VAT_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("GROUP BY AA.CURR_CD1 ) AAA) BBBB," ).append("\n"); 
		query.append("(SELECT ROWNUM NUM," ).append("\n"); 
		query.append("CURR_CD2," ).append("\n"); 
		query.append("CR_AMT" ).append("\n"); 
		query.append("FROM (SELECT CURR_CD2," ).append("\n"); 
		query.append("SUM(CR_AMT) CR_AMT" ).append("\n"); 
		query.append("FROM  /*--------- 3. Off-Hire ----------*/" ).append("\n"); 
		query.append("(SELECT A.CURR_CD CURR_CD2," ).append("\n"); 
		query.append("A.INV_AMT CR_AMT" ).append("\n"); 
		query.append("FROM FMS_INV_DTL A," ).append("\n"); 
		query.append("FMS_ACCT_ITM B," ).append("\n"); 
		query.append("FMS_CONSULTATION C" ).append("\n"); 
		query.append("WHERE A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND A.FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("AND (A.SLP_TP_CD LIKE '19%' OR A.SLP_TP_CD LIKE '07%' OR A.SLP_TP_CD LIKE '20%')" ).append("\n"); 
		query.append("AND A.ACCT_CD = B.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = B.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND A.SLP_TP_CD = C.SLP_TP_CD(+)" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = C.SLP_FUNC_CD(+)" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = C.SLP_OFC_CD(+)" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = C.SLP_ISS_DT(+)" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = C.SLP_SER_NO(+)" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND C.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*--------- 5. Owner''s Account ----------*/" ).append("\n"); 
		query.append("SELECT DISTINCT 'USD' CURR_CD2," ).append("\n"); 
		query.append("CR_AMT" ).append("\n"); 
		query.append("FROM (SELECT DISTINCT D.N1ST_AMT CR_AMT" ).append("\n"); 
		query.append("FROM FMS_CSUL_SLP B," ).append("\n"); 
		query.append("FMS_CONSULTATION C," ).append("\n"); 
		query.append("FMS_OWNR_ACCT_SLP D" ).append("\n"); 
		query.append("WHERE C.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND C.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND C.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND C.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND C.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND D.SLP_TP_CD = B.AP_SLP_TP_CD" ).append("\n"); 
		query.append("AND D.SLP_FUNC_CD = B.AP_SLP_FUNC_CD" ).append("\n"); 
		query.append("AND D.SLP_OFC_CD = B.AP_SLP_OFC_CD" ).append("\n"); 
		query.append("AND D.SLP_ISS_DT = B.AP_SLP_ISS_DT" ).append("\n"); 
		query.append("AND D.SLP_SER_NO = B.AP_SLP_SER_NO" ).append("\n"); 
		query.append("AND D.SLP_SEQ_NO = B.AP_SLP_SEQ_NO" ).append("\n"); 
		query.append("AND D.CSR_SLP_FLG = 'Y'" ).append("\n"); 
		query.append("AND D.FLET_PPAY_RLT_CD = 'O'" ).append("\n"); 
		query.append("AND D.ACCT_CD = '111071'" ).append("\n"); 
		query.append("AND C.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND C.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT A.N1ST_AMT CR_AMT" ).append("\n"); 
		query.append("FROM FMS_OWNR_ACCT_SLP A," ).append("\n"); 
		query.append("FMS_CONSULTATION B" ).append("\n"); 
		query.append("WHERE A.CSUL_SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.CSUL_SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.CSUL_SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.CSUL_SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.CSUL_SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.CSR_SLP_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.FLET_PPAY_RLT_CD = 'O'" ).append("\n"); 
		query.append("AND A.ACCT_CD = '111071'" ).append("\n"); 
		query.append("AND B.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND B.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*--------- 7. Bunker On Redelivery ----------*/" ).append("\n"); 
		query.append("SELECT B.CSR_CURR_CD CURR_CD2," ).append("\n"); 
		query.append("A.BNK_QTY*A.BNK_PRC_AMT CR_AMT" ).append("\n"); 
		query.append("FROM FMS_BUNKER A," ).append("\n"); 
		query.append("FMS_CONSULTATION B," ).append("\n"); 
		query.append("FMS_ACCT_ITM C," ).append("\n"); 
		query.append("FMS_ACCT_CATE D" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND A.BNK_TP_CD = 'BOR'" ).append("\n"); 
		query.append("AND B.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = C.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND B.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND B.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.ACCT_CD = C.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = C.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND A.ACCT_CD = D.ACCT_CD" ).append("\n"); 
		query.append("AND A.ACCT_ITM_SEQ = D.ACCT_ITM_SEQ" ).append("\n"); 
		query.append("AND D.FLET_ACCT_CATE_CD = 'BU'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("/*--------- 8. Others(-) ----------*/" ).append("\n"); 
		query.append("SELECT B.CSR_CURR_CD CURR_CD2," ).append("\n"); 
		query.append("B.CSR_AMT*-1 CR_AMT" ).append("\n"); 
		query.append("FROM FMS_CONSULTATION A," ).append("\n"); 
		query.append("FMS_CSUL_SLP B" ).append("\n"); 
		query.append("WHERE A.SLP_TP_CD = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND A.SLP_OFC_CD = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND A.SLP_ISS_DT = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND A.SLP_SER_NO = B.SLP_SER_NO" ).append("\n"); 
		query.append("--AND A.PPAY_HIR_NO IS NULL" ).append("\n"); 
		query.append("AND A.APRO_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.CSR_AMT < 0" ).append("\n"); 
		query.append("AND B.FLET_SRC_TP_CD IN ('10', '11', '20', '98', '99')" ).append("\n"); 
		query.append("--AND B.ACCT_CD NOT IN ('954112', '241121')" ).append("\n"); 
		query.append("AND A.FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("#if (${hir_no} != '')" ).append("\n"); 
		query.append("AND A.PPAY_HIR_NO = @[hir_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.VAT_SLP_TP_CD IS NULL" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("GROUP BY AA.CURR_CD2 ) AAA) CCCC" ).append("\n"); 
		query.append("WHERE AAAA.NUM = BBBB.NUM(+)" ).append("\n"); 
		query.append("AND AAAA.NUM = CCCC.NUM(+)" ).append("\n"); 
		query.append("AND (BBBB.CURR_CD1 IS NOT NULL OR CCCC.CURR_CD2 IS NOT NULL)" ).append("\n"); 

	}
}