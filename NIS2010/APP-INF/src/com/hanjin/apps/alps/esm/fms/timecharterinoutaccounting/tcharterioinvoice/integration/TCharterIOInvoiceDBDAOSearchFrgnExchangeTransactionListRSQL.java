/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOSearchFrgnExchangeTransactionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.27 
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

public class TCharterIOInvoiceDBDAOSearchFrgnExchangeTransactionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FRGN Exchange Transaction(O/A0) 정보를 조회를 합니다.
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOSearchFrgnExchangeTransactionListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("match_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("origin_csr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOSearchFrgnExchangeTransactionListRSQL").append("\n"); 
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
		query.append("SELECT A.*" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.SLP_OFC_CD," ).append("\n"); 
		query.append("       A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO CSR_NO," ).append("\n"); 
		query.append("       A.EFF_DT," ).append("\n"); 
		query.append("       A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD VVD," ).append("\n"); 
		query.append("       A.AP_DESC," ).append("\n"); 
		query.append("       A.N2ND_CURR_CD CURR," ).append("\n"); 
		query.append("       A.N2ND_AMT AMT," ).append("\n"); 
		query.append("       A.N1ST_AMT USD_AMT," ).append("\n"); 
		query.append("       A.PAIR_SLP_TP_CD||A.PAIR_SLP_FUNC_CD||A.PAIR_SLP_OFC_CD||A.PAIR_SLP_ISS_DT||A.PAIR_SLP_SER_NO||A.PAIR_SLP_SEQ_NO MATCH_CSR_NO," ).append("\n"); 
		query.append("       (SELECT P.EFF_DT" ).append("\n"); 
		query.append("             FROM FMS_OWNR_ACCT_SLP P" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_TP_CD = P.SLP_TP_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_FUNC_CD = P.SLP_FUNC_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_OFC_CD = P.SLP_OFC_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_ISS_DT = P.SLP_ISS_DT" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_SER_NO = P.SLP_SER_NO" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_SEQ_NO = P.SLP_SEQ_NO) GL_DATE,  --MATCHING_CSR_NO GL DATE" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("       (SELECT P.N1ST_AMT" ).append("\n"); 
		query.append("        FROM FMS_OWNR_ACCT_SLP P" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_TP_CD = P.SLP_TP_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_FUNC_CD = P.SLP_FUNC_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_OFC_CD = P.SLP_OFC_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_ISS_DT = P.SLP_ISS_DT" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_SER_NO = P.SLP_SER_NO" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_SEQ_NO = P.SLP_SEQ_NO) MATCH_CSR_USD_AMT," ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("       ABS(A.N1ST_AMT) -    " ).append("\n"); 
		query.append("       ABS((SELECT P.N1ST_AMT" ).append("\n"); 
		query.append("        FROM FMS_OWNR_ACCT_SLP P" ).append("\n"); 
		query.append("             WHERE 1 = 1" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_TP_CD = P.SLP_TP_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_FUNC_CD = P.SLP_FUNC_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_OFC_CD = P.SLP_OFC_CD" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_ISS_DT = P.SLP_ISS_DT" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_SER_NO = P.SLP_SER_NO" ).append("\n"); 
		query.append("               AND A.PAIR_SLP_SEQ_NO = P.SLP_SEQ_NO)) LOCL_XCH_RT_AMT,  -- EX.DIFF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         -- Transaction CSR No (환차손 전표가 있는 경우)" ).append("\n"); 
		query.append("       (SELECT D.SLP_TP_CD||D.SLP_FUNC_CD||D.SLP_OFC_CD||D.SLP_ISS_DT||D.SLP_SER_NO" ).append("\n"); 
		query.append("                   FROM FMS_CSUL_SLP D" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                    AND D.ORG_SLP_TP_CD = A.SLP_TP_CD" ).append("\n"); 
		query.append("                    AND D.ORG_SLP_FUNC_CD = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("                    AND D.ORG_SLP_OFC_CD = A.SLP_OFC_CD" ).append("\n"); 
		query.append("                    AND D.ORG_ISS_DT = A.SLP_ISS_DT " ).append("\n"); 
		query.append("                    AND D.ORG_SLP_SER_NO = A.SLP_SER_NO" ).append("\n"); 
		query.append("                    AND D.ORG_SLP_SEQ_NO = A.SLP_SEQ_NO" ).append("\n"); 
		query.append("                    AND D.FLET_SRC_TP_CD = '90'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1) transaction_csr_no," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        -- 전표 Detail 정보 조회  / FMS_CSUL_SLP 테이블 ORG..시작 전표 조회" ).append("\n"); 
		query.append("         A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO ORI1_CSR_NO," ).append("\n"); 
		query.append("         A.PAIR_SLP_TP_CD||A.PAIR_SLP_FUNC_CD||A.PAIR_SLP_OFC_CD||A.PAIR_SLP_ISS_DT||A.PAIR_SLP_SER_NO||A.PAIR_SLP_SEQ_NO ORI2_CSR_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (SELECT COUNT(F.ATCH_FILE_OA_LNK_ID) CNT" ).append("\n"); 
		query.append("        FROM FMS_OWNR_ACCT_ATCH_FILE F" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO = F.ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append("        ) ATCH_FILE_FLET_KNT," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      (SELECT /*+INDEX_DESC(F XPKFMS_ATCH_FILE) */" ).append("\n"); 
		query.append("       	       F.ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append("  	   	FROM FMS_OWNR_ACCT_ATCH_FILE F" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO||A.SLP_SEQ_NO = F.ATCH_FILE_OA_LNK_ID" ).append("\n"); 
		query.append("          AND ROWNUM = 1" ).append("\n"); 
		query.append("       ) ATTACH_LINK" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM FMS_OWNR_ACCT_SLP A" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  #if(${vsl_cd} != '')" ).append("\n"); 
		query.append("   AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${origin_csr_no} != '')" ).append("\n"); 
		query.append("   AND @[origin_csr_no] = A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||A.SLP_ISS_DT||A.SLP_SER_NO" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  AND A.OA_STL_STS_CD = 'CN'" ).append("\n"); 
		query.append("  AND A.N1ST_AMT > 0" ).append("\n"); 
		query.append("  AND TO_CHAR(A.UPD_DT, 'YYYYMM') BETWEEN REPLACE (@[from_eff_dt],'-','')  AND REPLACE (@[to_eff_dt],'-','') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  #if(${match_csr_no} != '')" ).append("\n"); 
		query.append("  AND @[match_csr_no] = A.PAIR_SLP_TP_CD||A.PAIR_SLP_FUNC_CD||A.PAIR_SLP_OFC_CD||A.PAIR_SLP_ISS_DT||A.PAIR_SLP_SER_NO" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${transact_cd} == 'N')" ).append("\n"); 
		query.append("    -- 조건 Transaction = No" ).append("\n"); 
		query.append("  AND 'N' = (SELECT DECODE(COUNT(D.SLP_TP_CD), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                   FROM FMS_CSUL_SLP D" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                    AND D.ORG_SLP_TP_CD = A.SLP_TP_CD" ).append("\n"); 
		query.append("                    AND D.ORG_SLP_FUNC_CD = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("                    AND D.ORG_SLP_OFC_CD = A.SLP_OFC_CD" ).append("\n"); 
		query.append("                    AND D.ORG_ISS_DT = A.SLP_ISS_DT " ).append("\n"); 
		query.append("                    AND D.ORG_SLP_SER_NO = A.SLP_SER_NO" ).append("\n"); 
		query.append("                    AND D.ORG_SLP_SEQ_NO = A.SLP_SEQ_NO" ).append("\n"); 
		query.append("                    AND D.FLET_SRC_TP_CD = '90'" ).append("\n"); 
		query.append("                    AND ROWNUM = 1)       " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("  #if(${transact_cd} == 'Y')" ).append("\n"); 
		query.append("    -- 조건 Transaction = YES" ).append("\n"); 
		query.append("   AND 'Y' = (SELECT DECODE(COUNT(D.SLP_TP_CD), 1, 'Y', 'N')" ).append("\n"); 
		query.append("              FROM FMS_CSUL_SLP D" ).append("\n"); 
		query.append("              WHERE 1 = 1" ).append("\n"); 
		query.append("              AND D.ORG_SLP_TP_CD = A.SLP_TP_CD" ).append("\n"); 
		query.append("              AND D.ORG_SLP_FUNC_CD = A.SLP_FUNC_CD" ).append("\n"); 
		query.append("              AND D.ORG_SLP_OFC_CD = A.SLP_OFC_CD" ).append("\n"); 
		query.append("              AND D.ORG_ISS_DT = A.SLP_ISS_DT " ).append("\n"); 
		query.append("              AND D.ORG_SLP_SER_NO = A.SLP_SER_NO" ).append("\n"); 
		query.append("              AND D.ORG_SLP_SEQ_NO = A.SLP_SEQ_NO" ).append("\n"); 
		query.append("              AND D.FLET_SRC_TP_CD = '90'" ).append("\n"); 
		query.append("              AND ROWNUM = 1)  " ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("#if(${transact_cd} == 'N')" ).append("\n"); 
		query.append("WHERE ABS(A.USD_AMT) <> ABS(MATCH_CSR_USD_AMT)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}