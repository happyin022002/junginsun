/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOauditMnrInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.11.10 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOauditMnrInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MNR INVOICE에 대한 EAS 심사 결과를 리턴함
	  * INVOICE 단건에 대한 심사이므로 INVOICE에 속한 장비수대로 최대 3건의 데이터가 발생할수 있음
	  * MNR REPAIR에서 DETAIL로 넘어오는 경우 AP(CSR)과 I/F가 되지 않았으므로
	  * 이 SQL을 변형하여 사용함
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOauditMnrInvoiceRSQL(){
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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOauditMnrInvoiceRSQL").append("\n"); 
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
		query.append("SELECT A.AUTO_AUDIT" ).append("\n"); 
		query.append("     , (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL X WHERE INTG_CD_ID = 'CD03417' AND X.INTG_CD_VAL_CTNT = A.AUTO_AUDIT) AUTO_AUDIT_DESC" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("SELECT B.EXPN_AUD_STS_CD AUDIT_RESULT" ).append("\n"); 
		query.append("     , TO_CHAR(UPD_DT, 'YYYY-MM-DD') CHEKED_DT" ).append("\n"); 
		query.append("     , (SELECT USR_NM " ).append("\n"); 
		query.append("          FROM COM_USER F " ).append("\n"); 
		query.append("         WHERE B.UPD_USR_ID = F.USR_ID" ).append("\n"); 
		query.append("       ) CHECKED_USER_NM" ).append("\n"); 
		query.append("     -- S : Coincidence|F : Discrepancy|C : Candidate EAC|O : N/A" ).append("\n"); 
		query.append("     , CASE WHEN A.WK_VRFY_YN = 'Y' THEN 'C'" ).append("\n"); 
		query.append("            WHEN A.EST_VRFY_YN = 'Y' THEN 'C'" ).append("\n"); 
		query.append("            WHEN A.EXPN_MAX_PRMT_RTO < A.WO_INV_RTO  THEN 'C'" ).append("\n"); 
		query.append("            WHEN A.WO_INV_RTO <= -1 THEN 'F'" ).append("\n"); 
		query.append("            WHEN A.EST_VRFY_DESC IS NOT NULL THEN 'F'" ).append("\n"); 
		query.append("            WHEN A.WK_VRFY_DESC IS NOT NULL THEN 'F'" ).append("\n"); 
		query.append("            WHEN ABS(A.WO_INV_RTO) < 1 THEN 'S' " ).append("\n"); 
		query.append("            WHEN A.EXPN_MAX_PRMT_RTO > A.WO_INV_RTO THEN 'F'" ).append("\n"); 
		query.append("       ELSE 'C'       END AUTO_AUDIT" ).append("\n"); 
		query.append("       -- ERROR CODE : N 이고 금액차가 -1 보다 작으면 POTENTIAL EAC" ).append("\n"); 
		query.append("       -- ERROR CODE : N 이고 금액차가 +- 1 안이면 COINCIDENCE" ).append("\n"); 
		query.append("       -- ERROR CODE : N 이고 설정 차이 비율보다 낮으면 COINCIDENCE" ).append("\n"); 
		query.append("       -- P : Coincidence|A : Candidate EAC|E : Potential EAC" ).append("\n"); 
		query.append("     , CASE WHEN A.WK_VRFY_YN = 'Y' THEN ''" ).append("\n"); 
		query.append("            WHEN A.EST_VRFY_YN = 'Y' THEN ''" ).append("\n"); 
		query.append("            WHEN A.EXPN_MAX_PRMT_RTO < A.WO_INV_RTO THEN ''" ).append("\n"); 
		query.append("            WHEN A.WO_INV_RTO <= -1 AND B.EXPN_AUD_STS_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("            WHEN A.EST_VRFY_DESC IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("            WHEN A.WK_VRFY_DESC IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("            WHEN ABS(A.WO_INV_RTO) < 1 AND B.EXPN_AUD_STS_CD IS NULL THEN 'P' " ).append("\n"); 
		query.append("            WHEN A.EXPN_MAX_PRMT_RTO > A.WO_INV_RTO AND B.EXPN_AUD_STS_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("       ELSE ''" ).append("\n"); 
		query.append("       END SELECT_FLG" ).append("\n"); 
		query.append("       -- SELECT FLG와 SELECT_FLG_TEMP는 서로 같아야 함" ).append("\n"); 
		query.append("     , CASE WHEN A.WK_VRFY_YN = 'Y' THEN ''" ).append("\n"); 
		query.append("            WHEN A.EST_VRFY_YN = 'Y' THEN ''" ).append("\n"); 
		query.append("            WHEN A.EXPN_MAX_PRMT_RTO < A.WO_INV_RTO THEN ''" ).append("\n"); 
		query.append("            WHEN A.WO_INV_RTO <= -1 AND B.EXPN_AUD_STS_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("            WHEN A.EST_VRFY_DESC IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("            WHEN A.WK_VRFY_DESC IS NOT NULL THEN 'E'" ).append("\n"); 
		query.append("            WHEN ABS(A.WO_INV_RTO) < 1 AND B.EXPN_AUD_STS_CD IS NULL THEN 'P' " ).append("\n"); 
		query.append("            WHEN A.EXPN_MAX_PRMT_RTO > A.WO_INV_RTO AND B.EXPN_AUD_STS_CD IS NULL THEN 'E'" ).append("\n"); 
		query.append("       ELSE ''" ).append("\n"); 
		query.append("       END SELECT_FLG_TEMP" ).append("\n"); 
		query.append("       -- ERROR CODE : N 이고 금액차가 -1 보다 작으면 POTENTIAL EAC" ).append("\n"); 
		query.append("       -- ERROR CODE : N 이고 금액차가 +- 1 안이면 COINCIDENCE" ).append("\n"); 
		query.append("       -- ERROR CODE : N 이고 설정 차이 비율보다 낮으면 COINCIDENCE" ).append("\n"); 
		query.append("     , CASE WHEN A.EST_VRFY_YN = 'Y' THEN '0'" ).append("\n"); 
		query.append("            WHEN A.WK_VRFY_YN = 'Y' THEN '0'" ).append("\n"); 
		query.append("            WHEN A.EXPN_MAX_PRMT_RTO < A.WO_INV_RTO THEN '0'" ).append("\n"); 
		query.append("            WHEN A.WO_INV_RTO <= -1 AND B.EXPN_AUD_STS_CD IS NULL THEN '1'" ).append("\n"); 
		query.append("            WHEN A.EST_VRFY_DESC IS NOT NULL THEN '1'" ).append("\n"); 
		query.append("            WHEN A.WK_VRFY_DESC IS NOT NULL THEN '1'" ).append("\n"); 
		query.append("            WHEN ABS(A.WO_INV_RTO) < 1 AND B.EXPN_AUD_STS_CD IS NULL THEN '1' " ).append("\n"); 
		query.append("            WHEN A.EXPN_MAX_PRMT_RTO > A.WO_INV_RTO AND B.EXPN_AUD_STS_CD IS NULL THEN '1'" ).append("\n"); 
		query.append("       ELSE '0'" ).append("\n"); 
		query.append("       END SEL" ).append("\n"); 
		query.append("     , A.INV_NO" ).append("\n"); 
		query.append("     , A.CSR_NO" ).append("\n"); 
		query.append("     , A.EQ_KND_CD_NM" ).append("\n"); 
		query.append("     , A.EQ_KND_CD" ).append("\n"); 
		query.append("     , A.VNDR_SEQ" ).append("\n"); 
		query.append("     , A.VNDR_NM" ).append("\n"); 
		query.append("     , A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("     , A.INV_OFC_CD" ).append("\n"); 
		query.append("     , A.WO_CURR_CD" ).append("\n"); 
		query.append("     , A.MNR_AGMT_AMT" ).append("\n"); 
		query.append("     , A.MNR_WRK_AMT" ).append("\n"); 
		query.append("     , A.TTL_INV_AMT" ).append("\n"); 
		query.append("     , A.SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("     , A.INV_CURR_CD" ).append("\n"); 
		query.append("     , DECODE(A.REFL_EX_YN, 'Y', 'Y', '') REFL_EX_YN" ).append("\n"); 
		query.append("     , A.BZC_AMT" ).append("\n"); 
		query.append("     , A.COST_AMT" ).append("\n"); 
		query.append("     , A.INV_AMT" ).append("\n"); 
		query.append("     , A.INV_CHG_AMT" ).append("\n"); 
		query.append("     , A.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("     , A.ISS_DT" ).append("\n"); 
		query.append("     , A.AP_PAY_DT" ).append("\n"); 
		query.append("     , A.PAY_DUE_DT" ).append("\n"); 
		query.append("     , A.CFM_DT" ).append("\n"); 
		query.append("     , A.INV_RMK" ).append("\n"); 
		query.append("     , A.INV_STS_CD" ).append("\n"); 
		query.append("     , A.CHG_WO_AMT" ).append("\n"); 
		query.append("     , ROUND((A.CHG_WO_AMT/(DECODE(A.COST_AMT, 0, 1, A.COST_AMT))) * 100, 3) INV_DIFF_PCT" ).append("\n"); 
		query.append("     , DECODE(A.WK_VRFY_YN, 'Y', 'Y', '') WK_VRFY_YN" ).append("\n"); 
		query.append("     , DECODE(A.EST_VRFY_YN, 'Y', 'Y', '') EST_VRFY_YN" ).append("\n"); 
		query.append("     , A.WO_INV_RTO" ).append("\n"); 
		query.append("     , A.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("     , A.INV_STS_NM" ).append("\n"); 
		query.append("     , A.INV_STS_CD" ).append("\n"); 
		query.append("     , A.INV_CRE_USER_NM" ).append("\n"); 
		query.append("     , TO_CHAR(B.UPD_DT, 'YYYY-MM-DD') AUDIT_DT" ).append("\n"); 
		query.append("     , (" ).append("\n"); 
		query.append("       SELECT DECODE(MAX(CFM.EAC_NO), NULL, '', 'Y') " ).append("\n"); 
		query.append("         FROM EAS_MNR_CFM_INV_DTL CFM" ).append("\n"); 
		query.append("        WHERE A.INV_NO = CFM.INV_NO" ).append("\n"); 
		query.append("          AND A.VNDR_SEQ = CFM.VNDR_SEQ" ).append("\n"); 
		query.append("          AND A.EQ_KND_CD = CFM.EQ_KND_CD" ).append("\n"); 
		query.append("     ) EAC_YN" ).append("\n"); 
		query.append("     , B.EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("     , B.EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("     , (SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = B.EXPN_AUD_RSLT_USR_ID) EXPN_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("     , A.EST_VRFY_DESC || DECODE(A.WK_VRFY_DESC, NULL, '', '@'||A.WK_VRFY_DESC) EST_VRFY_DESC" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("  (    " ).append("\n"); 
		query.append("    SELECT A.INV_NO" ).append("\n"); 
		query.append("         , A.CSR_NO" ).append("\n"); 
		query.append("         , A.EQ_KND_CD_NM" ).append("\n"); 
		query.append("         , A.EQ_KND_CD" ).append("\n"); 
		query.append("         , A.VNDR_SEQ" ).append("\n"); 
		query.append("         , A.VNDR_NM" ).append("\n"); 
		query.append("         , A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("         , A.INV_OFC_CD" ).append("\n"); 
		query.append("         , A.WO_CURR_CD" ).append("\n"); 
		query.append("         , A.MNR_AGMT_AMT" ).append("\n"); 
		query.append("         , A.MNR_WRK_AMT" ).append("\n"); 
		query.append("         , A.TTL_INV_AMT" ).append("\n"); 
		query.append("         , A.SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("         , A.INV_CURR_CD" ).append("\n"); 
		query.append("         , A.REFL_EX_YN" ).append("\n"); 
		query.append("         , A.BZC_AMT" ).append("\n"); 
		query.append("         , A.COST_AMT" ).append("\n"); 
		query.append("         , A.INV_AMT" ).append("\n"); 
		query.append("         , A.INV_CHG_AMT" ).append("\n"); 
		query.append("         , A.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("         , A.ISS_DT" ).append("\n"); 
		query.append("         , A.AP_PAY_DT" ).append("\n"); 
		query.append("         , A.PAY_DUE_DT" ).append("\n"); 
		query.append("         , A.CFM_DT" ).append("\n"); 
		query.append("         , A.INV_RMK" ).append("\n"); 
		query.append("         , NVL(TO_NUMBER(A.CHG_WO_AMT), 0) CHG_WO_AMT" ).append("\n"); 
		query.append("         , NVL(TO_NUMBER(A.WO_INV_RTO), 0) WO_INV_RTO" ).append("\n"); 
		query.append("         , A.INV_OFC_CD OFC" ).append("\n"); 
		query.append("         , A.RHQ_INV_OFC_CD RHQ" ).append("\n"); 
		query.append("         -- WO 검증" ).append("\n"); 
		query.append("         , CASE WHEN A.WO_OFC_CNT = 0 THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                  FROM EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                     , TABLE(BKG_SPLIT_FNC(A.WK_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("                 WHERE V.AUD_OFC_CD = A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("                   AND V.EXPN_AUD_MNR_VRFY_TP_CD = 'W'" ).append("\n"); 
		query.append("                   AND V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND V.MNR_VRFY_TP_CD = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           ELSE " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                  FROM EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                     , TABLE(BKG_SPLIT_FNC(A.WK_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("                 WHERE V.AUD_OFC_CD = A.INV_OFC_CD" ).append("\n"); 
		query.append("                   AND V.EXPN_AUD_MNR_VRFY_TP_CD = 'W'" ).append("\n"); 
		query.append("                   AND V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND V.MNR_VRFY_TP_CD = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           END WK_VRFY_YN" ).append("\n"); 
		query.append("         -- VRFY 검증" ).append("\n"); 
		query.append("         , CASE WHEN EST_OFC_CNT = 0 THEN" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                  FROM EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                     , TABLE(BKG_SPLIT_FNC(A.EST_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("                 WHERE V.AUD_OFC_CD = A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("                   AND V.EXPN_AUD_MNR_VRFY_TP_CD = 'E'" ).append("\n"); 
		query.append("                   AND V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND V.MNR_VRFY_TP_CD = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                  FROM EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                     , TABLE(BKG_SPLIT_FNC(A.EST_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("                 WHERE V.AUD_OFC_CD = A.INV_OFC_CD" ).append("\n"); 
		query.append("                   AND V.EXPN_AUD_MNR_VRFY_TP_CD = 'E'" ).append("\n"); 
		query.append("                   AND V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                   AND V.MNR_VRFY_TP_CD = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("           END EST_VRFY_YN" ).append("\n"); 
		query.append("         , A.WK_VRFY_DESC" ).append("\n"); 
		query.append("         , A.EST_VRFY_DESC" ).append("\n"); 
		query.append("         , A.EST_OFC_CNT" ).append("\n"); 
		query.append("         , A.WO_OFC_CNT" ).append("\n"); 
		query.append("         , A.INV_STS_NM" ).append("\n"); 
		query.append("         , A.INV_STS_CD" ).append("\n"); 
		query.append("         , A.INV_CRE_USER_NM" ).append("\n"); 
		query.append("         , A.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("      FROM" ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT /*+USE_NL(B C E A)*/ " ).append("\n"); 
		query.append("               B.INV_NO" ).append("\n"); 
		query.append("             , E.CSR_NO" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT MGC.MNR_CD_DESC " ).append("\n"); 
		query.append("                  FROM MNR_GEN_CD MGC " ).append("\n"); 
		query.append("                 WHERE A.EQ_KND_CD = MGC.MNR_CD_ID " ).append("\n"); 
		query.append("                   AND MGC.PRNT_CD_ID = 'CD00002'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) EQ_KND_CD_NM" ).append("\n"); 
		query.append("             , A.EQ_KND_CD" ).append("\n"); 
		query.append("             , MAX(E.VNDR_SEQ) VNDR_SEQ" ).append("\n"); 
		query.append("             , MAX(D.VNDR_LGL_ENG_NM) VNDR_NM" ).append("\n"); 
		query.append("             , MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(C.ISS_OFC_CD) RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("             , C.ISS_OFC_CD INV_OFC_CD" ).append("\n"); 
		query.append("             , A.CURR_CD WO_CURR_CD" ).append("\n"); 
		query.append("             , SUM(A.MNR_AGMT_AMT) MNR_AGMT_AMT" ).append("\n"); 
		query.append("             , SUM(A.MNR_WRK_AMT) MNR_WRK_AMT" ).append("\n"); 
		query.append("             , SUM(A.INV_AMT) TTL_INV_AMT" ).append("\n"); 
		query.append("             , SUM(B.SPR_PRT_UC_AMT) SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("             , C.CURR_CD INV_CURR_CD" ).append("\n"); 
		query.append("             , DECODE(A.CURR_CD, C.CURR_CD, 'N', 'Y') REFL_EX_YN" ).append("\n"); 
		query.append("             , SUM(B.BZC_AMT) BZC_AMT" ).append("\n"); 
		query.append("             , SUM(B.COST_AMT) COST_AMT" ).append("\n"); 
		query.append("             , SUM(B.INV_AMT) INV_AMT" ).append("\n"); 
		query.append("             , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(C.ISS_DT), 'YYYYMM'), C.CURR_CD, A.CURR_CD, SUM(B.INV_AMT)) INV_CHG_AMT" ).append("\n"); 
		query.append("             , MAX(C.GEN_PAY_TERM_CD) GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("             , TO_CHAR(MAX(C.ISS_DT), 'YYYY-MM-DD') ISS_DT" ).append("\n"); 
		query.append("             , TO_CHAR(MAX(E.AP_PAY_DT), 'YYYY-MM-DD') AP_PAY_DT" ).append("\n"); 
		query.append("             , (SELECT TO_CHAR(TO_DATE(INV_TERM_DT, 'YYYYMMDD'), 'YYYY-MM-DD') FROM AP_INV_HDR PAY WHERE PAY.CSR_NO = E.CSR_NO) PAY_DUE_DT" ).append("\n"); 
		query.append("             , TO_CHAR(MAX(C.CFM_DT), 'YYYY-MM-DD') CFM_DT" ).append("\n"); 
		query.append("             , MAX(E.INV_RMK) INV_RMK" ).append("\n"); 
		query.append("             , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(C.ISS_DT), 'YYYYMM'), C.CURR_CD, A.CURR_CD, SUM(B.INV_AMT)) - SUM(B.COST_AMT) CHG_WO_AMT" ).append("\n"); 
		query.append("             -- B.COST_AMT의 합이 0이면 ERROR 발생" ).append("\n"); 
		query.append("             , DECODE(SUM(B.COST_AMT), 0, 0, ROUND((MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(C.ISS_DT), 'YYYYMM'), C.CURR_CD, A.CURR_CD, SUM(B.INV_AMT)) - SUM(B.COST_AMT)) / SUM(B.COST_AMT) * 100 , 2)) WO_INV_RTO" ).append("\n"); 
		query.append("             , WM_CONCAT(DISTINCT DECODE(B.MNR_VRFY_TP_CD, 'SS','','OF','','SL','',B.MNR_VRFY_TP_CD)) AS WK_VRFY_DESC" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT WM_CONCAT(DISTINCT RD.MNR_VRFY_TP_CD)" ).append("\n"); 
		query.append("                  FROM MNR_RPR_RQST_HDR RH" ).append("\n"); 
		query.append("                     , MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("                     , MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                     , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("                     , MNR_PAY_INV_WRK WRK" ).append("\n"); 
		query.append("                     , AP_PAY_INV INV" ).append("\n"); 
		query.append("                 WHERE RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND RH.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                   AND RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("                   AND RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                   AND RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("                   AND OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                   AND OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                   AND OD.PAY_INV_SEQ = WRK.PAY_INV_SEQ" ).append("\n"); 
		query.append("                   AND WRK.INV_RGST_NO = INV.INV_RGST_NO" ).append("\n"); 
		query.append("                   AND INV.INV_NO = B.INV_NO" ).append("\n"); 
		query.append("                   AND INV.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("                   AND OH.EQ_KND_CD = A.EQ_KND_CD" ).append("\n"); 
		query.append("                   AND OD.EQ_NO = RH.RQST_EQ_NO" ).append("\n"); 
		query.append("                   AND OH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("                   AND RD.MNR_VRFY_TP_CD NOT IN ('SS', 'SL' ,'OF')" ).append("\n"); 
		query.append("             ) AS EST_VRFY_DESC" ).append("\n"); 
		query.append("             , (" ).append("\n"); 
		query.append("                SELECT MGC.MNR_CD_DESC " ).append("\n"); 
		query.append("                  FROM MNR_GEN_CD MGC " ).append("\n"); 
		query.append("                 WHERE E.INV_STS_CD = MGC.MNR_CD_ID " ).append("\n"); 
		query.append("                   AND MGC.PRNT_CD_ID = 'CD00042'" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) INV_STS_NM" ).append("\n"); 
		query.append("             , E.INV_STS_CD" ).append("\n"); 
		query.append("             , (SELECT USR_NM " ).append("\n"); 
		query.append("                  FROM COM_USER F " ).append("\n"); 
		query.append("                 WHERE C.CRE_USR_ID = F.USR_ID" ).append("\n"); 
		query.append("               ) INV_CRE_USER_NM" ).append("\n"); 
		query.append("             , NVL(" ).append("\n"); 
		query.append("                    (SELECT EXPN_MAX_PRMT_RTO FROM EAS_MNR_PRE_AUD_RTO_CFG WHERE AUD_OFC_CD = C.ISS_OFC_CD AND MNR_VRFY_TP_AUD_FLG = 'Y')" ).append("\n"); 
		query.append("                  , (SELECT EXPN_MAX_PRMT_RTO FROM EAS_MNR_PRE_AUD_RTO_CFG WHERE AUD_OFC_CD = MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(C.ISS_OFC_CD) AND MNR_VRFY_TP_AUD_FLG = 'Y')" ).append("\n"); 
		query.append("               ) EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("             , (SELECT COUNT(1) FROM EAS_MNR_PRE_AUD_VRFY_CFG CFG WHERE C.ISS_OFC_CD = CFG.AUD_OFC_CD AND CFG.EXPN_AUD_MNR_VRFY_TP_CD = 'E' AND CFG.MNR_VRFY_TP_AUD_FLG = 'Y') EST_OFC_CNT" ).append("\n"); 
		query.append("             , (SELECT COUNT(1) FROM EAS_MNR_PRE_AUD_VRFY_CFG CFG WHERE C.ISS_OFC_CD = CFG.AUD_OFC_CD AND CFG.EXPN_AUD_MNR_VRFY_TP_CD = 'W' AND CFG.MNR_VRFY_TP_AUD_FLG = 'Y') WO_OFC_CNT" ).append("\n"); 
		query.append("          FROM MNR_ORD_HDR A" ).append("\n"); 
		query.append("             , MNR_ORD_DTL B" ).append("\n"); 
		query.append("             , MNR_PAY_INV_WRK C" ).append("\n"); 
		query.append("             , MDM_VENDOR D" ).append("\n"); 
		query.append("             , AP_PAY_INV E" ).append("\n"); 
		query.append("         WHERE A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("           AND A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("           AND B.PAY_INV_SEQ = C.PAY_INV_SEQ" ).append("\n"); 
		query.append("           AND C.MNR_PRNR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("           AND C.INV_RGST_NO = E.INV_RGST_NO(+)" ).append("\n"); 
		query.append("           AND C.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("           AND A.MNR_WO_TP_CD IN ('EST','SPL')" ).append("\n"); 
		query.append("           AND B.ACCT_CD != '511591'" ).append("\n"); 
		query.append("           AND E.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("           AND C.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("           AND C.MNR_PRNR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("         GROUP BY B.INV_NO" ).append("\n"); 
		query.append("                , E.CSR_NO" ).append("\n"); 
		query.append("                , A.EQ_KND_CD" ).append("\n"); 
		query.append("                , E.VNDR_SEQ" ).append("\n"); 
		query.append("                , C.ISS_OFC_CD" ).append("\n"); 
		query.append("                , C.CURR_CD" ).append("\n"); 
		query.append("                , A.CURR_CD" ).append("\n"); 
		query.append("                , E.INV_STS_CD" ).append("\n"); 
		query.append("                , C.CRE_USR_ID" ).append("\n"); 
		query.append("        ) A" ).append("\n"); 
		query.append("      ) A, EAS_MNR_CFM_INV B" ).append("\n"); 
		query.append(" WHERE A.INV_NO = B.INV_NO(+)" ).append("\n"); 
		query.append("   AND A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("   AND A.EQ_KND_CD = B.EQ_KND_CD(+)" ).append("\n"); 
		query.append("  ) A" ).append("\n"); 

	}
}