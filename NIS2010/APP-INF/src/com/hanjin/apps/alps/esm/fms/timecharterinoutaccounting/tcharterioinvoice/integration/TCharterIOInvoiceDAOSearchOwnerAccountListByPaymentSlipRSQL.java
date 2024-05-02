/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOwnerAccountListByPaymentSlipRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchOwnerAccountListByPaymentSlipRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다.(Prepayment, Standard)
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOwnerAccountListByPaymentSlipRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOwnerAccountListByPaymentSlipRSQL").append("\n"); 
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
		query.append("SELECT A.*," ).append("\n"); 
		query.append("       TO_CHAR(ABS(INITIAL_AMT_USD) - ABS(N1ST_AMT),'FM999,999,999,999,999,990.00') EX_DIFF_USD," ).append("\n"); 
		query.append("       ROUND(INITIAL_AMT_USD * FLET_OLAY_COMM_RT_AMT / 100, 2)  REFUND_ADD_COMM" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  (SELECT C.ACCT_ITM_NM" ).append("\n"); 
		query.append("             FROM FMS_ACCT_ITM C" ).append("\n"); 
		query.append("             WHERE C.ACCT_CD = '962111'" ).append("\n"); 
		query.append("               AND FO.ACCT_ITM_SEQ = C.ACCT_ITM_SEQ) ACCT_ITM_NM," ).append("\n"); 
		query.append("            FO.AP_DESC,  -- DESCRIPTION " ).append("\n"); 
		query.append("            FO.VSL_CD || FO.SKD_VOY_NO || FO.SKD_DIR_CD || FO.REV_DIR_CD VVD_BUNKER,  -- VVD " ).append("\n"); 
		query.append("            (SELECT DECODE(SIGN(C.FLET_OLAY_COMM_RT_AMT), 1, 'Y', 'N')" ).append("\n"); 
		query.append("             FROM FMS_CONTRACT C" ).append("\n"); 
		query.append("             WHERE C.FLET_CTRT_NO = @[flet_ctrt_no]) OA_COMM_FLAG," ).append("\n"); 
		query.append("            DECODE(FO.OA_STL_STS_CD, 'RC', 'RECEIVED', 'RF', 'REFUND') OA_STL_STS_CD,  -- SETTLEMENT" ).append("\n"); 
		query.append("            FO.SLP_TP_CD||FO.SLP_FUNC_CD||FO.SLP_OFC_CD||FO.SLP_ISS_DT||FO.SLP_SER_NO||FO.SLP_SEQ_NO ORG_SLP_NO,  -- CSR NO" ).append("\n"); 
		query.append("            FO.N1ST_AMT ,  -- USD AMT" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("            FO.PAIR_SLP_TP_CD||FO.PAIR_SLP_FUNC_CD||FO.PAIR_SLP_OFC_CD||FO.PAIR_SLP_ISS_DT||FO.PAIR_SLP_SER_NO||FO.PAIR_SLP_SEQ_NO MATCHING_SLIP_NO,  -- MATCHING SLIP NO" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("            FO.N2ND_CURR_CD LOC_CURR_CD, -- CUR" ).append("\n"); 
		query.append("            TO_CHAR(FO.N2ND_AMT,'FM999,999,999,999,999,990.00') LOC_AMT, -- LCL AMT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            (SELECT P.N1ST_AMT" ).append("\n"); 
		query.append("             FROM FMS_OWNR_ACCT_SLP P" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_TP_CD = P.SLP_TP_CD" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_FUNC_CD = P.SLP_FUNC_CD" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_OFC_CD = P.SLP_OFC_CD" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_ISS_DT = P.SLP_ISS_DT" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_SER_NO = P.SLP_SER_NO" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_SEQ_NO = P.SLP_SEQ_NO) INITIAL_AMT_USD, -- INITIAL AMT(USD)" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("            (SELECT AP_CTR_CD" ).append("\n"); 
		query.append("              FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("              WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("              AND ROWNUM = 1) CTR_CD," ).append("\n"); 
		query.append("            (SELECT LOC_CD" ).append("\n"); 
		query.append("              FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("              WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("              AND ROWNUM = 1) SLP_LOC_CD," ).append("\n"); 
		query.append("            '04' FLET_SRC_TP_CD," ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            (SELECT DECODE(FLET_OLAY_COMM_RT_AMT,NULL,0,TO_CHAR(FLET_OLAY_COMM_RT_AMT,'FM999,999,999,990.00'))" ).append("\n"); 
		query.append("              FROM FMS_CONTRACT " ).append("\n"); 
		query.append("              WHERE FLET_CTRT_NO = @[flet_ctrt_no]) FLET_OLAY_COMM_RT_AMT," ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("            FO.SLP_TP_CD," ).append("\n"); 
		query.append("            FO.SLP_FUNC_CD," ).append("\n"); 
		query.append("            FO.SLP_OFC_CD," ).append("\n"); 
		query.append("            FO.SLP_ISS_DT," ).append("\n"); 
		query.append("            FO.SLP_SER_NO," ).append("\n"); 
		query.append("            FO.SLP_SEQ_NO," ).append("\n"); 
		query.append("            (SELECT DECODE(VSL_CD, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("              FROM AR_MST_REV_VVD" ).append("\n"); 
		query.append("              WHERE 1 = 1" ).append("\n"); 
		query.append("                AND VSL_CD = FO.VSL_CD" ).append("\n"); 
		query.append("                AND SKD_VOY_NO = FO.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND SKD_DIR_CD = FO.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND RLANE_DIR_CD = FO.REV_DIR_CD" ).append("\n"); 
		query.append("                AND NVL(DELT_FLG, 'N') = 'N') VVD_YN," ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("           (SELECT P.AP_DESC" ).append("\n"); 
		query.append("             FROM FMS_OWNR_ACCT_SLP P" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_TP_CD = P.SLP_TP_CD" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_FUNC_CD = P.SLP_FUNC_CD" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_OFC_CD = P.SLP_OFC_CD" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_ISS_DT = P.SLP_ISS_DT" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_SER_NO = P.SLP_SER_NO" ).append("\n"); 
		query.append("               AND FO.PAIR_SLP_SEQ_NO = P.SLP_SEQ_NO) INITIAL_DESC -- INITIAL_DESC       " ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("    FROM FMS_OWNR_ACCT_SLP FO" ).append("\n"); 
		query.append("    WHERE FO.ACCT_CD = '111071'" ).append("\n"); 
		query.append("      AND FO.CSR_SLP_FLG = 'N'" ).append("\n"); 
		query.append("      AND FO.VSL_CD IN (SELECT VSL_CD" ).append("\n"); 
		query.append("                        FROM FMS_CONTRACT" ).append("\n"); 
		query.append("                        WHERE FLET_CTRT_NO = @[flet_ctrt_no]  -- 입력값" ).append("\n"); 
		query.append("                        UNION ALL" ).append("\n"); 
		query.append("                        SELECT VSL_CD" ).append("\n"); 
		query.append("                        FROM FMS_ID_VSL" ).append("\n"); 
		query.append("                        WHERE FLET_CTRT_NO = @[flet_ctrt_no]  -- 입력값" ).append("\n"); 
		query.append("                        AND USE_FLG = 'Y')" ).append("\n"); 
		query.append("    -- Slip Type Condition                   " ).append("\n"); 
		query.append("    --  AND FO.OA_STL_STS_CD IN ('RF')    --  Slip Type : Standard  and  Owner's Account 버튼 실행시    " ).append("\n"); 
		query.append("    --  AND FO.OA_STL_STS_CD IN ('RC')    --  Slip Type : Payment   and  Owner's Account 버튼 실행시    " ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    #if(${slp_tp} == 'S')" ).append("\n"); 
		query.append("       AND FO.OA_STL_STS_CD IN ('RC', 'RF') " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if(${slp_tp} == 'P')" ).append("\n"); 
		query.append("        AND FO.OA_STL_STS_CD IN ('RC', 'RF')  -- 2017.04.27 RF 추가" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("#if(${slp_tp} == 'S')" ).append("\n"); 
		query.append(" --WHERE ABS(N1ST_AMT) <> ABS(INITIAL_AMT_USD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}