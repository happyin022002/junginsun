/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OnhireBalanceDBDAOsearchOnhireStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnhireBalanceDBDAOsearchOnhireStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_1006 On-Hire Status 조회
	  * </pre>
	  */
	public OnhireBalanceDBDAOsearchOnhireStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lse_prd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.integration").append("\n"); 
		query.append("FileName : OnhireBalanceDBDAOsearchOnhireStatusRSQL").append("\n"); 
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
		query.append("SELECT A.RCC_CD" ).append("\n"); 
		query.append("      ,A.LCC_CD" ).append("\n"); 
		query.append("      ,A.ONH_ORD_YR" ).append("\n"); 
		query.append("      ,A.EQ_LSTM_CD" ).append("\n"); 
		query.append("      ,A.LSE_PRD_SEQ -- Period Hidden" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- ORDER QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_D2_QTY,0) ORDER_D2_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_D4_QTY,0) ORDER_D4_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_D5_QTY,0) ORDER_D5_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_D7_QTY,0) ORDER_D7_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_R2_QTY,0) ORDER_R2_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_R5_QTY,0) ORDER_R5_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_R9_QTY,0) ORDER_R9_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_O2_QTY,0) ORDER_O2_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_O4_QTY,0) ORDER_O4_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_O5_QTY,0) ORDER_O5_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_S2_QTY,0) ORDER_S2_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_S4_QTY,0) ORDER_S4_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_F2_QTY,0) ORDER_F2_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_F4_QTY,0) ORDER_F4_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_F5_QTY,0) ORDER_F5_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_A2_QTY,0) ORDER_A2_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_A4_QTY,0) ORDER_A4_QTY" ).append("\n"); 
		query.append("      ,NVL(A.ORDER_A5_QTY,0) ORDER_A5_QTY" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- APPROVAL QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_D2_QTY,0) APPR_D2_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_D4_QTY,0) APPR_D4_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_D5_QTY,0) APPR_D5_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_D7_QTY,0) APPR_D7_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_R2_QTY,0) APPR_R2_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_R5_QTY,0) APPR_R5_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_R9_QTY,0) APPR_R9_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_O2_QTY,0) APPR_O2_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_O4_QTY,0) APPR_O4_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_O5_QTY,0) APPR_O5_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_S2_QTY,0) APPR_S2_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_S4_QTY,0) APPR_S4_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_F2_QTY,0) APPR_F2_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_F4_QTY,0) APPR_F4_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_F5_QTY,0) APPR_F5_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_A2_QTY,0) APPR_A2_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_A4_QTY,0) APPR_A4_QTY" ).append("\n"); 
		query.append("      ,NVL(B.APPR_A5_QTY,0) APPR_A5_QTY" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      -- RESULT QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_D2_QTY,0) RSLT_D2_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_D4_QTY,0) RSLT_D4_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_D5_QTY,0) RSLT_D5_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_D7_QTY,0) RSLT_D7_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_R2_QTY,0) RSLT_R2_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_R5_QTY,0) RSLT_R5_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_R9_QTY,0) RSLT_R9_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_O2_QTY,0) RSLT_O2_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_O4_QTY,0) RSLT_O4_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_O5_QTY,0) RSLT_O5_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_S2_QTY,0) RSLT_S2_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_S4_QTY,0) RSLT_S4_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_F2_QTY,0) RSLT_F2_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_F4_QTY,0) RSLT_F4_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_F5_QTY,0) RSLT_F5_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_A2_QTY,0) RSLT_A2_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_A4_QTY,0) RSLT_A4_QTY" ).append("\n"); 
		query.append("      ,NVL(C.RSLT_A5_QTY,0) RSLT_A5_QTY" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      ,A.ONH_ORD_RMK" ).append("\n"); 
		query.append("      ,'Y' MERGE_FLAG" ).append("\n"); 
		query.append("      ,'Y' X_MERGE_FLAG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    -- <ON-HIRE ORDER - 메인데이터 > ---------------------------------------------------------------------" ).append("\n"); 
		query.append("    SELECT A.RCC_CD" ).append("\n"); 
		query.append("          ,A.LCC_CD" ).append("\n"); 
		query.append("          ,A.ONH_ORD_YR " ).append("\n"); 
		query.append("          ,A.EQ_LSTM_CD " ).append("\n"); 
		query.append("          ,A.LSE_PRD_SEQ  -- HIDDEN" ).append("\n"); 
		query.append("          ,A.ONH_ORD_RMK" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D2', B.CNTR_QTY)),0) ORDER_D2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D4', B.CNTR_QTY)),0) ORDER_D4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D5', B.CNTR_QTY)),0) ORDER_D5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D7', B.CNTR_QTY)),0) ORDER_D7_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R2', B.CNTR_QTY)),0) ORDER_R2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R5', B.CNTR_QTY)),0) ORDER_R5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R9', B.CNTR_QTY)),0) ORDER_R9_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O2', B.CNTR_QTY)),0) ORDER_O2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O4', B.CNTR_QTY)),0) ORDER_O4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O5', B.CNTR_QTY)),0) ORDER_O5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'S2', B.CNTR_QTY)),0) ORDER_S2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'S4', B.CNTR_QTY)),0) ORDER_S4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F2', B.CNTR_QTY)),0) ORDER_F2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F4', B.CNTR_QTY)),0) ORDER_F4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F5', B.CNTR_QTY)),0) ORDER_F5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A2', B.CNTR_QTY)),0) ORDER_A2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A4', B.CNTR_QTY)),0) ORDER_A4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A5', B.CNTR_QTY)),0) ORDER_A5_QTY" ).append("\n"); 
		query.append("    FROM EQR_CTRL_ONH_ORD A" ).append("\n"); 
		query.append("        ,EQR_CTRL_ONH_ORD_QTY B" ).append("\n"); 
		query.append("    WHERE A.ONH_ORD_YR = B.ONH_ORD_YR" ).append("\n"); 
		query.append("    AND   A.LCC_CD     = B.LCC_CD" ).append("\n"); 
		query.append("    AND   A.EQ_LSTM_CD = B.EQ_LSTM_CD" ).append("\n"); 
		query.append("    AND   A.LSE_PRD_SEQ= B.LSE_PRD_SEQ   " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    -- < 검색조건 > ----------------------" ).append("\n"); 
		query.append("#if( ${years} != '')" ).append("\n"); 
		query.append("    AND   A.ONH_ORD_YR IN (" ).append("\n"); 
		query.append("                            ${years}" ).append("\n"); 
		query.append("                          )    " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${eq_lstm_cd} != '')" ).append("\n"); 
		query.append("	AND   A.EQ_LSTM_CD  = @[eq_lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${lse_prd_seq} != '')" ).append("\n"); 
		query.append("    AND   A.LSE_PRD_SEQ = @[lse_prd_seq] -- 1st, 2nd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND   A.LCC_CD IN (" ).append("\n"); 
		query.append("                         SELECT LCC_CD " ).append("\n"); 
		query.append("                         FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                         WHERE 1 = 1" ).append("\n"); 
		query.append("#if( ${rcc_cd} != '' && ${rcc_cd} != 'ALL' )" ).append("\n"); 
		query.append("                         AND   RCC_CD = @[rcc_cd] -- RCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${lcc_cd} != '' &&  ${lcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                         AND   LCC_CD = @[lcc_cd] -- LCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    GROUP BY A.RCC_CD" ).append("\n"); 
		query.append("            ,A.LCC_CD" ).append("\n"); 
		query.append("            ,A.ONH_ORD_YR " ).append("\n"); 
		query.append("            ,A.EQ_LSTM_CD " ).append("\n"); 
		query.append("            ,A.LSE_PRD_SEQ" ).append("\n"); 
		query.append("            ,A.ONH_ORD_RMK" ).append("\n"); 
		query.append("    ORDER BY A.RCC_CD" ).append("\n"); 
		query.append("            ,A.LCC_CD" ).append("\n"); 
		query.append("            ,A.ONH_ORD_YR " ).append("\n"); 
		query.append("            ,A.EQ_LSTM_CD " ).append("\n"); 
		query.append("            ,A.LSE_PRD_SEQ " ).append("\n"); 
		query.append(") A              " ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    -- < P/Up Approval > ------------------------------------------------------------------------" ).append("\n"); 
		query.append("    SELECT SUBSTR(ONH_PLN_YRWK, 0, 4) YEAR" ).append("\n"); 
		query.append("          ,LCC_CD" ).append("\n"); 
		query.append("          ,EQ_LSTM_CD" ).append("\n"); 
		query.append("          ,NVL(SUM(D2_QTY),0) APPR_D2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(D4_QTY),0) APPR_D4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(D5_QTY),0) APPR_D5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(D7_QTY),0) APPR_D7_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(R2_QTY),0) APPR_R2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(R5_QTY),0) APPR_R5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(R9_QTY),0) APPR_R9_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(O2_QTY),0) APPR_O2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(O4_QTY),0) APPR_O4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(O5_QTY),0) APPR_O5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(S2_QTY),0) APPR_S2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(S4_QTY),0) APPR_S4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(F2_QTY),0) APPR_F2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(F4_QTY),0) APPR_F4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(F5_QTY),0) APPR_F5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(A2_QTY),0) APPR_A2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(A4_QTY),0) APPR_A4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(A5_QTY),0) APPR_A5_QTY" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (      " ).append("\n"); 
		query.append("        SELECT A.LSE_RQST_NO" ).append("\n"); 
		query.append("              ,A.ONH_PLN_YRWK" ).append("\n"); 
		query.append("              ,A.RCC_CD" ).append("\n"); 
		query.append("              ,A.LCC_CD" ).append("\n"); 
		query.append("              ,A.EQ_LSTM_CD" ).append("\n"); 
		query.append("              ,A.LSE_PLN_SEQ -- HIDDEN" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D2', B.CNTR_QTY)),0) D2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D4', B.CNTR_QTY)),0) D4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D5', B.CNTR_QTY)),0) D5_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D7', B.CNTR_QTY)),0) D7_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R2', B.CNTR_QTY)),0) R2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R5', B.CNTR_QTY)),0) R5_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R9', B.CNTR_QTY)),0) R9_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O2', B.CNTR_QTY)),0) O2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O4', B.CNTR_QTY)),0) O4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O5', B.CNTR_QTY)),0) O5_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'S2', B.CNTR_QTY)),0) S2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'S4', B.CNTR_QTY)),0) S4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F2', B.CNTR_QTY)),0) F2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F4', B.CNTR_QTY)),0) F4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F5', B.CNTR_QTY)),0) F5_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A2', B.CNTR_QTY)),0) A2_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A4', B.CNTR_QTY)),0) A4_QTY" ).append("\n"); 
		query.append("              ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A5', B.CNTR_QTY)),0) A5_QTY      " ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,C.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("              ,C.MFT_YR" ).append("\n"); 
		query.append("              ,C.AGMT_CTY_CD||C.AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("              ,C.ONH_LOC_CD" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("              ,CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'S'" ).append("\n"); 
		query.append("                    WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'R'" ).append("\n"); 
		query.append("                    WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN 'A'" ).append("\n"); 
		query.append("               END STS_CD  -- HIDDEN" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("              ,CASE WHEN A.LSE_RQST_NO IS NULL     AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'Saved'" ).append("\n"); 
		query.append("                    WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NULL     THEN 'Requested'" ).append("\n"); 
		query.append("                    WHEN A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL THEN 'Approved'" ).append("\n"); 
		query.append("               END STS_NM   " ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("        FROM EQR_CTRL_ONH_PLN_APRO      A" ).append("\n"); 
		query.append("            ,EQR_CTRL_ONH_PLN_APRO_QTY  B" ).append("\n"); 
		query.append("            ,(SELECT LSE_RQST_NO " ).append("\n"); 
		query.append("                   , CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                   , MFT_YR" ).append("\n"); 
		query.append("                   , AGMT_CTY_CD" ).append("\n"); 
		query.append("                   , AGMT_SEQ AGMT_NO" ).append("\n"); 
		query.append("                   , AGMT_SEQ" ).append("\n"); 
		query.append("                   , ONH_LOC_CD" ).append("\n"); 
		query.append("              FROM   LSE_ONH_APRO " ).append("\n"); 
		query.append("              WHERE  DELT_FLG  = 'N'  ) C" ).append("\n"); 
		query.append("        WHERE A.ONH_PLN_YRWK = B.ONH_PLN_YRWK" ).append("\n"); 
		query.append("        AND   A.LCC_CD       = B.LCC_CD" ).append("\n"); 
		query.append("        AND   A.EQ_LSTM_CD   = B.EQ_LSTM_CD" ).append("\n"); 
		query.append("        AND   A.LSE_PLN_SEQ  = B.LSE_PLN_SEQ    " ).append("\n"); 
		query.append("        AND   A.LSE_RQST_NO  = C.LSE_RQST_NO(+)" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        -- <검색조건> ------------" ).append("\n"); 
		query.append("#if( ${years} != '')" ).append("\n"); 
		query.append("        AND   SUBSTR(A.ONH_PLN_YRWK, 0, 4) IN (" ).append("\n"); 
		query.append("                                                  ${years}" ).append("\n"); 
		query.append("                                               )  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        AND   A.LCC_CD IN (" ).append("\n"); 
		query.append("                            SELECT LCC_CD " ).append("\n"); 
		query.append("                            FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("#if( ${rcc_cd} != '' && ${rcc_cd} != 'ALL' )" ).append("\n"); 
		query.append("                            AND   RCC_CD = @[rcc_cd] -- RCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${lcc_cd} != '' && ${lcc_cd} != 'ALL' )" ).append("\n"); 
		query.append("                            AND   LCC_CD = @[lcc_cd] -- LCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND (A.LSE_RQST_NO IS NOT NULL AND C.CNTR_ONH_AUTH_NO IS NOT NULL)  -- 하드코딩, APPROVAL 만 검색                 " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        GROUP BY A.LSE_RQST_NO" ).append("\n"); 
		query.append("                ,A.ONH_PLN_YRWK" ).append("\n"); 
		query.append("                ,A.RCC_CD" ).append("\n"); 
		query.append("                ,A.LCC_CD" ).append("\n"); 
		query.append("                ,A.EQ_LSTM_CD" ).append("\n"); 
		query.append("                ,A.LSE_PLN_SEQ" ).append("\n"); 
		query.append("                ,C.CNTR_ONH_AUTH_NO" ).append("\n"); 
		query.append("                ,C.MFT_YR" ).append("\n"); 
		query.append("                ,C.AGMT_CTY_CD||C.AGMT_SEQ" ).append("\n"); 
		query.append("                ,C.ONH_LOC_CD" ).append("\n"); 
		query.append("                " ).append("\n"); 
		query.append("        ORDER BY A.ONH_PLN_YRWK" ).append("\n"); 
		query.append("                ,A.RCC_CD" ).append("\n"); 
		query.append("                ,A.LCC_CD" ).append("\n"); 
		query.append("                ,A.EQ_LSTM_CD " ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    GROUP BY SUBSTR(ONH_PLN_YRWK, 0, 4) " ).append("\n"); 
		query.append("          ,LCC_CD" ).append("\n"); 
		query.append("          ,EQ_LSTM_CD        " ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("    -- < On-hire Result > ------------------------------------------------------------------------" ).append("\n"); 
		query.append("    -- ONH_ORD_YR 우선이며 NULL이면 MFT_YR 를 수집(2013-12-20, 신용찬, CHM-201328000)" ).append("\n"); 
		query.append("    SELECT (SELECT DISTINCT X.RCC_CD FROM MDM_EQ_ORZ_CHT X WHERE X.LCC_CD = A.ONH_LOC_CD AND ROWNUM=1) RCC_CD" ).append("\n"); 
		query.append("          ,A.ONH_LOC_CD LCC_CD-- LCC_CD" ).append("\n"); 
		query.append("          --,A.MFT_YR " ).append("\n"); 
		query.append("          ,NVL(A.ONH_ORD_YR, A.MFT_YR) MFT_YR" ).append("\n"); 
		query.append("          ,A.LSTM_CD" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D2', B.ONH_QTY)),0) RSLT_D2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D4', B.ONH_QTY)),0) RSLT_D4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D5', B.ONH_QTY)),0) RSLT_D5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'D7', B.ONH_QTY)),0) RSLT_D7_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R2', B.ONH_QTY)),0) RSLT_R2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R5', B.ONH_QTY)),0) RSLT_R5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'R9', B.ONH_QTY)),0) RSLT_R9_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O2', B.ONH_QTY)),0) RSLT_O2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O4', B.ONH_QTY)),0) RSLT_O4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'O5', B.ONH_QTY)),0) RSLT_O5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'S2', B.ONH_QTY)),0) RSLT_S2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'S4', B.ONH_QTY)),0) RSLT_S4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F2', B.ONH_QTY)),0) RSLT_F2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F4', B.ONH_QTY)),0) RSLT_F4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'F5', B.ONH_QTY)),0) RSLT_F5_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A2', B.ONH_QTY)),0) RSLT_A2_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A4', B.ONH_QTY)),0) RSLT_A4_QTY" ).append("\n"); 
		query.append("          ,NVL(SUM(DECODE(B.CNTR_TPSZ_CD, 'A5', B.ONH_QTY)),0) RSLT_A5_QTY" ).append("\n"); 
		query.append("    FROM LSE_ONH_APRO A" ).append("\n"); 
		query.append("        ,LSE_ONH_APRO_QTY B" ).append("\n"); 
		query.append("    WHERE A.AGMT_CTY_CD = B.AGMT_CTY_CD" ).append("\n"); 
		query.append("    AND   A.AGMT_SEQ    = B.AGMT_SEQ" ).append("\n"); 
		query.append("    AND   A.CNTR_ONH_AUTH_NO = B.CNTR_ONH_AUTH_NO " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    -- 검색조건" ).append("\n"); 
		query.append("    -- RCC/LCC 검색조건 있을경우" ).append("\n"); 
		query.append("    AND   A.ONH_LOC_CD IN (" ).append("\n"); 
		query.append("                             SELECT DISTINCT LCC_CD " ).append("\n"); 
		query.append("                             FROM MDM_EQ_ORZ_CHT" ).append("\n"); 
		query.append("                             WHERE 1 = 1" ).append("\n"); 
		query.append("#if( ${rcc_cd} != '' && ${rcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                             AND   RCC_CD = @[rcc_cd] -- RCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${lcc_cd} != '' && ${lcc_cd} != 'ALL')" ).append("\n"); 
		query.append("                             AND   LCC_CD = @[lcc_cd] -- LCC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                             AND  DELT_FLG = 'N'" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#if( ${eq_lstm_cd} != '')" ).append("\n"); 
		query.append("	AND   A.LSTM_CD  = @[eq_lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if( ${years} != '')" ).append("\n"); 
		query.append("    AND   NVL(A.ONH_ORD_YR, A.MFT_YR) IN (" ).append("\n"); 
		query.append("                        ${years}" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    AND   A.DELT_FLG   = 'N' -- 하드코딩                      " ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("    GROUP BY A.ONH_LOC_CD" ).append("\n"); 
		query.append("            --,A.MFT_YR " ).append("\n"); 
		query.append("            ,NVL(A.ONH_ORD_YR, A.MFT_YR)" ).append("\n"); 
		query.append("            ,A.LSTM_CD" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.ONH_ORD_YR = B.YEAR(+)" ).append("\n"); 
		query.append("AND   A.LCC_CD     = B.LCC_CD(+)" ).append("\n"); 
		query.append("AND   A.EQ_LSTM_CD = B.EQ_LSTM_CD(+)" ).append("\n"); 
		query.append("AND   A.ONH_ORD_YR = C.MFT_YR(+)" ).append("\n"); 
		query.append("AND   A.LCC_CD     = C.LCC_CD(+)" ).append("\n"); 
		query.append("AND   A.EQ_LSTM_CD = C.LSTM_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY RCC_CD" ).append("\n"); 
		query.append("        ,LCC_CD" ).append("\n"); 
		query.append("        ,ONH_ORD_YR" ).append("\n"); 
		query.append("        ,EQ_LSTM_CD" ).append("\n"); 
		query.append("        ,LSE_PRD_SEQ" ).append("\n"); 

	}
}