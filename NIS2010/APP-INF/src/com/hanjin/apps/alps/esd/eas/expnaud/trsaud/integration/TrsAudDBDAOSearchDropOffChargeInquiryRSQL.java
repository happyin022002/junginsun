/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TrsAudDBDAOSearchDropOffChargeInquiryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.11 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TrsAudDBDAOSearchDropOffChargeInquiryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop-Off Charge Inquiry 조회
	  * </pre>
	  */
	public TrsAudDBDAOSearchDropOffChargeInquiryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ecc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.expnaud.trsaud.integration").append("\n"); 
		query.append("FileName : TrsAudDBDAOSearchDropOffChargeInquiryRSQL").append("\n"); 
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
		query.append("SELECT @[s_ecc] ECC_CD" ).append("\n"); 
		query.append("       ,BBB.BKG_STS_CD" ).append("\n"); 
		query.append("       ,AAA.CNTR_NO" ).append("\n"); 
		query.append("       ,AAA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("       ,AAA.BKG_NO" ).append("\n"); 
		query.append("       ,BBB.POR_CD" ).append("\n"); 
		query.append("       ,BBB.POL_CD" ).append("\n"); 
		query.append("       ,BBB.POD_CD" ).append("\n"); 
		query.append("       ,BBB.DEL_CD" ).append("\n"); 
		query.append("       ,BBB.DE_TERM_CD" ).append("\n"); 
		query.append("       ,SHP.CUST_CNT_CD || LPAD(TO_CHAR(SHP.CUST_SEQ), 6, '0') SHP_CD" ).append("\n"); 
		query.append("       ,CASE WHEN CNE.CUST_SEQ IS NOT NULL THEN CNE.CUST_CNT_CD || LPAD(TO_CHAR(CNE.CUST_SEQ), 6, '0')" ).append("\n"); 
		query.append("             WHEN NTY.CUST_SEQ IS NOT NULL THEN NTY.CUST_CNT_CD || LPAD(TO_CHAR(NTY.CUST_SEQ), 6, '0')" ).append("\n"); 
		query.append("        END CNE_CD" ).append("\n"); 
		query.append("       ,AAA.ORG_YD_CD  AS DEL_YD_CD" ).append("\n"); 
		query.append("       ,AAA.TO_YD_CD   AS ACT_RTN_YD_CD" ).append("\n"); 
		query.append("       ,BBB.SC_NO" ).append("\n"); 
		query.append("       ,BBB.RFA_NO" ).append("\n"); 
		query.append("       ,(SELECT X.INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("           FROM COM_INTG_CD_DTL X " ).append("\n"); 
		query.append("          WHERE X.INTG_CD_ID = 'CD02080' " ).append("\n"); 
		query.append("            AND X.INTG_CD_VAL_CTNT = BKG_GET_TOKEN_FNC(AAA.BKG_SCG_INFO,1,'^')" ).append("\n"); 
		query.append("        ) BKG_SCG_TERM_NM" ).append("\n"); 
		query.append("       ,BKG_GET_TOKEN_FNC(AAA.BKG_SCG_INFO,2,'^') BKG_SCG_CUR_CD" ).append("\n"); 
		query.append("       ,BKG_GET_TOKEN_FNC(AAA.BKG_SCG_INFO,3,'^') BKG_SCG_RAT_UT_CD" ).append("\n"); 
		query.append("       ,BKG_GET_TOKEN_FNC(AAA.BKG_SCG_INFO,4,'^') BKG_SCG_AMT" ).append("\n"); 
		query.append("       ,BKG_GET_TOKEN_FNC(AAA.BKG_SCG_INFO,5,'^') BKG_SCG_CD" ).append("\n"); 
		query.append("       ,CASE WHEN SUBSTR(AAA.ORG_YD_CD, 1, 2) = 'KR' THEN BKG_GET_TOKEN_FNC(AAA.KR_DOD_INFO,1,'^')" ).append("\n"); 
		query.append("             ELSE BKG_GET_TOKEN_FNC(AAA.N3PTY_INFO,1,'^')" ).append("\n"); 
		query.append("        END TPB_NO" ).append("\n"); 
		query.append("       ,CASE WHEN SUBSTR(AAA.ORG_YD_CD, 1, 2) = 'KR' THEN BKG_GET_TOKEN_FNC(AAA.KR_DOD_INFO,2,'^')" ).append("\n"); 
		query.append("             ELSE BKG_GET_TOKEN_FNC(AAA.N3PTY_INFO,2,'^')" ).append("\n"); 
		query.append("        END TPB_AMT" ).append("\n"); 
		query.append("       ,(SELECT 'Y'" ).append("\n"); 
		query.append("           FROM EAS_DRP_OFF_CHG_CHK X" ).append("\n"); 
		query.append("          WHERE X.BKG_NO        = AAA.BKG_NO" ).append("\n"); 
		query.append("            AND X.CNTR_NO       = AAA.CNTR_NO" ).append("\n"); 
		query.append("            AND X.MTY_RTN_YD_CD = AAA.ORG_YD_CD" ).append("\n"); 
		query.append("        ) EAC_IF_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT AA.ORG_YD_CD" ).append("\n"); 
		query.append("              ,AA.CNTR_NO" ).append("\n"); 
		query.append("              ,AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,AA.FM_MVMT_STS_CD" ).append("\n"); 
		query.append("              ,BKG_GET_TOKEN_FNC(AA.TO_MVMT_STS_INFO,1,'^') TO_MVMT_STS_CD" ).append("\n"); 
		query.append("              ,BKG_GET_TOKEN_FNC(AA.TO_MVMT_STS_INFO,2,'^') TO_EVNT_DT" ).append("\n"); 
		query.append("              ,BKG_GET_TOKEN_FNC(AA.TO_MVMT_STS_INFO,3,'^') BKG_NO" ).append("\n"); 
		query.append("              ,BKG_GET_TOKEN_FNC(AA.TO_MVMT_STS_INFO,4,'^') TO_YD_CD" ).append("\n"); 
		query.append("              ,(SELECT FRT_TERM_CD||'^'||CURR_CD||'^'||RAT_UT_CD||'^'||CHG_UT_AMT||'^'||X.CHG_CD" ).append("\n"); 
		query.append("                  FROM BKG_CHG_RT X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = BKG_GET_TOKEN_FNC(AA.TO_MVMT_STS_INFO,3,'^')" ).append("\n"); 
		query.append("                   AND X.CHG_CD IN ('OCP', 'DOD')" ).append("\n"); 
		query.append("                   AND ((X.RAT_UT_CD = AA.CNTR_TPSZ_CD) OR (CASE WHEN SUBSTR(AA.CNTR_TPSZ_CD, 2,1) IN ('2', '3') THEN '20'" ).append("\n"); 
		query.append("                                                                 WHEN SUBSTR(AA.CNTR_TPSZ_CD, 2,1) IN ('4', '5') THEN '40'" ).append("\n"); 
		query.append("                                                                 WHEN SUBSTR(AA.CNTR_TPSZ_CD, 2,1) IN ('6', '7') THEN '45'" ).append("\n"); 
		query.append("                                                            END" ).append("\n"); 
		query.append("                                                           ) = X.RAT_UT_CD)" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) BKG_SCG_INFO" ).append("\n"); 
		query.append("              ,(SELECT MAX(X.N3PTY_NO) ||'^'||" ).append("\n"); 
		query.append("                       SUM(ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(X.CFM_CURR_CD, X.CFM_AMT, TO_CHAR(X.CFM_DT,'YYYYMM')),2)) TPB_AMT_USD" ).append("\n"); 
		query.append("                  FROM TPB_OTS_DTL X" ).append("\n"); 
		query.append("                 WHERE X.BKG_NO = BKG_GET_TOKEN_FNC(AA.TO_MVMT_STS_INFO,3,'^')" ).append("\n"); 
		query.append("                   AND X.EQ_NO  = AA.CNTR_NO" ).append("\n"); 
		query.append("                   AND X.N3PTY_EXPN_TP_CD   = 'TRS'" ).append("\n"); 
		query.append("               ) N3PTY_INFO" ).append("\n"); 
		query.append("              ,(SELECT MAX(X.DOD_INV_NO) ||'^'||" ).append("\n"); 
		query.append("                       SUM(ROUND(TRS_COMMON_PKG.GET_CONVERSION_USD_AMT_FNC(Y.BIL_CURR_CD, Y.INV_AMT, TO_CHAR(SYSDATE,'YYYYMM')),2)) DOD_AMT_USD" ).append("\n"); 
		query.append("                  FROM EAS_DOD_INV_MN  X" ).append("\n"); 
		query.append("                      ,EAS_DOD_INV_DTL Y" ).append("\n"); 
		query.append("                 WHERE X.DOD_INV_NO = Y.DOD_INV_NO" ).append("\n"); 
		query.append("                   AND X.BKG_NO  = BKG_GET_TOKEN_FNC(AA.TO_MVMT_STS_INFO,3,'^')" ).append("\n"); 
		query.append("                   AND Y.CNTR_NO = AA.CNTR_NO                 " ).append("\n"); 
		query.append("               ) KR_DOD_INFO" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT ORG_YD_CD" ).append("\n"); 
		query.append("                      ,CNTR_NO" ).append("\n"); 
		query.append("                      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      ,MVMT_STS_CD AS FM_MVMT_STS_CD" ).append("\n"); 
		query.append("                      ,(SELECT /*+ INDEX (X XPKCTM_MOVEMENT) */" ).append("\n"); 
		query.append("                               X.MVMT_STS_CD||'^'||TO_CHAR(X.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI:SS')||'^'||X.BKG_NO||'^'||ORG_YD_CD" ).append("\n"); 
		query.append("                          FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("                         WHERE X.CNTR_NO  = M.CNTR_NO" ).append("\n"); 
		query.append("                           AND X.CNMV_YR  >= M.CNMV_YR" ).append("\n"); 
		query.append("                           AND X.CNMV_YR||LPAD(X.CNMV_ID_NO, 3, '0') > M.CNMV_YR||LPAD(M.CNMV_ID_NO, 3, '0')" ).append("\n"); 
		query.append("                           AND ROWNUM = 1" ).append("\n"); 
		query.append("                       ) TO_MVMT_STS_INFO" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("                 WHERE MVMT_STS_CD IN ('ID')" ).append("\n"); 
		query.append("                 #if (${s_ecc} != '') " ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                                 FROM MDM_EQ_ORZ_CHT X" ).append("\n"); 
		query.append("                                     ,MDM_LOCATION   Y" ).append("\n"); 
		query.append("                                     ,MDM_YARD       Z" ).append("\n"); 
		query.append("                                WHERE X.SCC_CD = Y.SCC_CD" ).append("\n"); 
		query.append("                                  AND Y.LOC_CD = Z.LOC_CD" ).append("\n"); 
		query.append("                                  AND X.ECC_CD = @[s_ecc]" ).append("\n"); 
		query.append("                                  AND Z.YD_CD  = M.ORG_YD_CD" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${s_loc} != '') " ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 'Y'" ).append("\n"); 
		query.append("                                 FROM MDM_LOCATION  Y" ).append("\n"); 
		query.append("                                     ,MDM_YARD      Z" ).append("\n"); 
		query.append("                                WHERE Y.LOC_CD = Z.LOC_CD" ).append("\n"); 
		query.append("                                  AND Y.LOC_CD = @[s_loc]" ).append("\n"); 
		query.append("                                  AND Z.YD_CD  = M.ORG_YD_CD" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                   AND M.CNMV_EVNT_DT BETWEEN TO_DATE(REPLACE(@[s_fm_dt],'-',''), 'YYYYMMDD')-30 AND TO_DATE(REPLACE(@[s_to_dt],'-',''), 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                 #if (${s_cntr_no} != '')" ).append("\n"); 
		query.append("                   AND M.CNTR_NO = @[s_cntr_no]" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("                 #if (${s_cntr_tpsz} != '')" ).append("\n"); 
		query.append("                   AND INSTR(@[s_cntr_tpsz], M.CNTR_TPSZ_CD) > 0     -- TP/SZ를 Multi로 받아서 처리" ).append("\n"); 
		query.append("                 #end" ).append("\n"); 
		query.append("               ) AA" ).append("\n"); 
		query.append("           WHERE (AA.FM_MVMT_STS_CD, BKG_GET_TOKEN_FNC(AA.TO_MVMT_STS_INFO,1,'^')) IN (('ID', 'MT'))" ).append("\n"); 
		query.append("             AND (TO_DATE(BKG_GET_TOKEN_FNC(TO_MVMT_STS_INFO,2,'^'), 'YYYY-MM-DD HH24:MI:SS') BETWEEN TO_DATE(@[s_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[s_to_dt], 'YYYY-MM-DD') + 0.99999) " ).append("\n"); 
		query.append("       ) AAA" ).append("\n"); 
		query.append("      ,BKG_BOOKING  BBB" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER SHP" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER CNE" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER NTY" ).append("\n"); 
		query.append(" WHERE AAA.BKG_NO = BBB.BKG_NO" ).append("\n"); 
		query.append("   AND AAA.BKG_NO = SHP.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'S'        = SHP.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND AAA.BKG_NO = CNE.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'C'        = CNE.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND AAA.BKG_NO = NTY.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'N'        = NTY.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   #if (${s_bkg_no} != '')" ).append("\n"); 
		query.append("     AND BBB.BKG_NO = @[s_bkg_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${s_de_term_cd} != '')" ).append("\n"); 
		query.append("     AND BBB.DE_TERM_CD = @[s_de_term_cd]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${s_cust_tp_cd} == 'S' && ${s_cust_cd} != '')" ).append("\n"); 
		query.append("     AND (SHP.CUST_CNT_CD, SHP.CUST_SEQ) IN ((SUBSTR(@[s_cust_cd], 1,2), TO_NUMBER(SUBSTR(@[s_cust_cd], 3))))" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${s_cust_tp_cd} == 'C' && ${s_cust_cd} != '')" ).append("\n"); 
		query.append("     AND (CNE.CUST_CNT_CD, CNE.CUST_SEQ) IN ((SUBSTR(@[s_cust_cd], 1,2), TO_NUMBER(SUBSTR(@[s_cust_cd], 3))))" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (${s_eac_if} != '')" ).append("\n"); 
		query.append("     #if (${s_eac_if} == 'Y')" ).append("\n"); 
		query.append("       AND EXISTS (SELECT '1'" ).append("\n"); 
		query.append("                     FROM EAS_DRP_OFF_CHG_CHK X" ).append("\n"); 
		query.append("                    WHERE X.BKG_NO            = AAA.BKG_NO" ).append("\n"); 
		query.append("                      AND X.CNTR_NO           = AAA.CNTR_NO" ).append("\n"); 
		query.append("                      AND X.MTY_RTN_YD_CD     = AAA.ORG_YD_CD" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("     #else" ).append("\n"); 
		query.append("       AND NOT EXISTS (SELECT '1'" ).append("\n"); 
		query.append("                         FROM EAS_DRP_OFF_CHG_CHK X" ).append("\n"); 
		query.append("                        WHERE X.BKG_NO            = AAA.BKG_NO" ).append("\n"); 
		query.append("                          AND X.CNTR_NO           = AAA.CNTR_NO" ).append("\n"); 
		query.append("                          AND X.MTY_RTN_YD_CD     = AAA.ORG_YD_CD" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   AND AAA.ORG_YD_CD <> AAA.TO_YD_CD" ).append("\n"); 

	}
}