/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : MnrAdvanceAuditDBDAOsearchMnrAutoAudListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MnrAdvanceAuditDBDAOsearchMnrAutoAudListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchMnrAutoAudList 조회쿼리 (MNR Auto Audit 배치에서 사용)
	  * </pre>
	  */
	public MnrAdvanceAuditDBDAOsearchMnrAutoAudListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_datetime",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration").append("\n"); 
		query.append("FileName : MnrAdvanceAuditDBDAOsearchMnrAutoAudListRSQL").append("\n"); 
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
		query.append("SELECT   A.INV_NO" ).append("\n"); 
		query.append("       , A.VNDR_SEQ" ).append("\n"); 
		query.append("       , A.EQ_KND_CD" ).append("\n"); 
		query.append("       , NULL AS EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("       , 'BATCH' AS CRE_USR_ID -- 해당 내용은 BATCH성격에 맞게 변경하세요" ).append("\n"); 
		query.append("       , SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("       , 'BATCH' AS UPD_USR_ID -- 해당 내용은 BATCH성격에 맞게 변경하세요" ).append("\n"); 
		query.append("       , SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("       , NULL AS EXPN_AUD_RSLT_RMK" ).append("\n"); 
		query.append("       , NULL AS EXPN_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("       , NULL AS ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("       , NULL AS EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("       , A.RHQ_INV_OFC_CD AS RHQ_CD" ).append("\n"); 
		query.append("       , A.INV_OFC_CD AS INV_OFC_CD" ).append("\n"); 
		query.append("       , A.INV_CFM_DT" ).append("\n"); 
		query.append("       , CASE WHEN A.WK_VRFY_YN = 'Y' THEN 'C'" ).append("\n"); 
		query.append("              WHEN A.EST_VRFY_YN = 'Y' THEN 'C'" ).append("\n"); 
		query.append("              WHEN A.EXPN_MAX_PRMT_RTO < A.WO_INV_RTO  THEN 'C'" ).append("\n"); 
		query.append("              WHEN A.MLT_WO_CURR_FLG = 'Y' THEN 'C'" ).append("\n"); 
		query.append("              WHEN A.WO_INV_RTO <= -1 THEN 'F'" ).append("\n"); 
		query.append("              WHEN A.EST_VRFY_DESC IS NOT NULL THEN 'F'" ).append("\n"); 
		query.append("              WHEN A.WK_VRFY_DESC IS NOT NULL THEN 'F'" ).append("\n"); 
		query.append("              WHEN ABS(A.WO_INV_RTO) < 1 THEN 'S'" ).append("\n"); 
		query.append("              WHEN A.EXPN_MAX_PRMT_RTO > A.WO_INV_RTO THEN 'F'" ).append("\n"); 
		query.append("              ELSE 'C'" ).append("\n"); 
		query.append("         END AS AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("         -- ERROR CODE : N 이고 금액차가 -1 보다 작으면 POTENTIAL EAC" ).append("\n"); 
		query.append("         -- ERROR CODE : N 이고 금액차가 +- 1 안이면 COINCIDENCE" ).append("\n"); 
		query.append("         -- ERROR CODE : N 이고 설정 차이 비율보다 낮으면 COINCIDENCE" ).append("\n"); 
		query.append("         -- P : Coincidence|A : Candidate EAC|E : Potential EAC" ).append("\n"); 
		query.append("       , A.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("       , A.WO_CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("       , A.COST_AMT AS WO_AMT" ).append("\n"); 
		query.append("       , A.INV_AMT AS INV_AMT" ).append("\n"); 
		query.append("       , DECODE(A.REFL_EX_YN, 'Y', 'Y', '') AS CURR_CNG_FLG -- W/O CURR_CD와 INV CURR_CD가 같을경우 Y " ).append("\n"); 
		query.append("       , A.INV_CURR_CD -- FIELD추가 요청사항" ).append("\n"); 
		query.append("       , A.CHG_WO_AMT AS INV_DIFF_AMT  -- INV AMT - W/O AMT 금액" ).append("\n"); 
		query.append("       , ROUND((A.CHG_WO_AMT/(DECODE(A.COST_AMT, 0, 1, A.COST_AMT))) * 100, 3) AS INV_DIFF_RTO" ).append("\n"); 
		query.append("       , A.INV_CHG_AMT  -- W/O 기준으로 변환된 금액" ).append("\n"); 
		query.append("       , DECODE(A.WK_VRFY_YN, 'Y', 'Y', '') AS WO_VRFY_FLG " ).append("\n"); 
		query.append("       , DECODE(A.EST_VRFY_YN, 'Y', 'Y', '') AS ESTM_VRFY_FLG " ).append("\n"); 
		query.append("       , A.EST_VRFY_DESC AS ESTM_VRFY_DESC" ).append("\n"); 
		query.append("       , A.WK_VRFY_DESC AS WO_VRFY_DESC" ).append("\n"); 
		query.append("       , A.INV_CRE_USER_ID" ).append("\n"); 
		query.append("       , A.INV_CRE_USER_NM" ).append("\n"); 
		query.append("       , A.INV_RGST_NO" ).append("\n"); 
		query.append("       , A.MLT_WO_CURR_FLG" ).append("\n"); 
		query.append("FROM     (    " ).append("\n"); 
		query.append("           SELECT   A.INV_NO" ).append("\n"); 
		query.append("                  , A.CSR_NO" ).append("\n"); 
		query.append("                  , A.EQ_KND_CD_NM" ).append("\n"); 
		query.append("                  , A.EQ_KND_CD" ).append("\n"); 
		query.append("                  , A.VNDR_SEQ" ).append("\n"); 
		query.append("                  , A.VNDR_NM" ).append("\n"); 
		query.append("                  , A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("                  , A.INV_OFC_CD" ).append("\n"); 
		query.append("                  , A.WO_CURR_CD" ).append("\n"); 
		query.append("                  , A.MNR_AGMT_AMT" ).append("\n"); 
		query.append("                  , A.MNR_WRK_AMT" ).append("\n"); 
		query.append("                  , A.TTL_INV_AMT" ).append("\n"); 
		query.append("                  , A.SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("                  , A.INV_CURR_CD" ).append("\n"); 
		query.append("                  , A.REFL_EX_YN" ).append("\n"); 
		query.append("                  , A.BZC_AMT" ).append("\n"); 
		query.append("                  , A.COST_AMT " ).append("\n"); 
		query.append("                  , A.INV_AMT" ).append("\n"); 
		query.append("                  , A.INV_CHG_AMT" ).append("\n"); 
		query.append("                  , A.GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("                  , A.ISS_DT" ).append("\n"); 
		query.append("                  , A.AP_PAY_DT" ).append("\n"); 
		query.append("                  , A.PAY_DUE_DT" ).append("\n"); 
		query.append("                  , A.CFM_DT" ).append("\n"); 
		query.append("                  , A.INV_CFM_DT" ).append("\n"); 
		query.append("                  , A.INV_RMK" ).append("\n"); 
		query.append("                  , NVL(TO_NUMBER(A.CHG_WO_AMT), 0) AS CHG_WO_AMT" ).append("\n"); 
		query.append("                  , NVL(TO_NUMBER(A.WO_INV_RTO), 0) AS WO_INV_RTO" ).append("\n"); 
		query.append("                  , A.INV_OFC_CD OFC" ).append("\n"); 
		query.append("                  , A.RHQ_INV_OFC_CD RHQ" ).append("\n"); 
		query.append("                  -- WO 검증" ).append("\n"); 
		query.append("                  , CASE WHEN A.WO_OFC_CNT = 0 THEN" ).append("\n"); 
		query.append("                              (" ).append("\n"); 
		query.append("                                SELECT   DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                                FROM     EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                                       , TABLE(BKG_SPLIT_FNC(A.WK_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      V.AUD_OFC_CD = A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("                                AND      V.EXPN_AUD_MNR_VRFY_TP_CD = 'W'" ).append("\n"); 
		query.append("                                AND      V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                                AND      V.MNR_VRFY_TP_CD = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                         ELSE " ).append("\n"); 
		query.append("                              (" ).append("\n"); 
		query.append("                                SELECT   DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                                FROM     EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                                       , TABLE(BKG_SPLIT_FNC(A.WK_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      V.AUD_OFC_CD = A.INV_OFC_CD" ).append("\n"); 
		query.append("                                AND      V.EXPN_AUD_MNR_VRFY_TP_CD = 'W'" ).append("\n"); 
		query.append("                                AND      V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                                AND      V.MNR_VRFY_TP_CD = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                    END AS WK_VRFY_YN" ).append("\n"); 
		query.append("                  -- VRFY 검증" ).append("\n"); 
		query.append("                  , CASE WHEN EST_OFC_CNT = 0 THEN" ).append("\n"); 
		query.append("                              (" ).append("\n"); 
		query.append("                                SELECT   DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                                FROM     EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                                       , TABLE(BKG_SPLIT_FNC(A.EST_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      V.AUD_OFC_CD = A.RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("                                AND      V.EXPN_AUD_MNR_VRFY_TP_CD = 'E'" ).append("\n"); 
		query.append("                                AND      V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                                AND      V.MNR_VRFY_TP_CD = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                    ELSE" ).append("\n"); 
		query.append("                              (" ).append("\n"); 
		query.append("                                SELECT   DECODE(SIGN(COUNT(1)), 1, 'Y', 'N')" ).append("\n"); 
		query.append("                                FROM     EAS_MNR_PRE_AUD_VRFY_CFG V" ).append("\n"); 
		query.append("                                       , TABLE(BKG_SPLIT_FNC(A.EST_VRFY_DESC, ',')) Q" ).append("\n"); 
		query.append("                                WHERE    1 = 1" ).append("\n"); 
		query.append("                                AND      V.AUD_OFC_CD = A.INV_OFC_CD" ).append("\n"); 
		query.append("                                AND      V.EXPN_AUD_MNR_VRFY_TP_CD = 'E'" ).append("\n"); 
		query.append("                                AND      V.MNR_VRFY_TP_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("                                AND      V.MNR_VRFY_TP_CD = Q.COLUMN_VALUE" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                    END AS EST_VRFY_YN" ).append("\n"); 
		query.append("                  , A.WK_VRFY_DESC" ).append("\n"); 
		query.append("                  , A.EST_VRFY_DESC" ).append("\n"); 
		query.append("                  -- CHM-201537754 NA, UR, UH는 설정을 안하더라도 CATDIDATE 오류로 지정" ).append("\n"); 
		query.append("                  , SIGN(NVL(INSTR(A.EST_VRFY_DESC, 'NA'), 0)) AS EST_NA_CNT -- EST ERROR에 Agreement Not Found가 포함된경우" ).append("\n"); 
		query.append("                  , SIGN(NVL(INSTR(A.EST_VRFY_DESC, 'UR'), 0)) AS EST_UR_CNT -- EST ERROR에 Labor Rate Unmatched가 포함된경우" ).append("\n"); 
		query.append("                  , SIGN(NVL(INSTR(A.EST_VRFY_DESC, 'UH'), 0)) AS EST_UH_CNT -- EST ERROR에 Man-hour Unmatched가 포함된경우" ).append("\n"); 
		query.append("                  , SIGN(NVL(INSTR(A.EST_VRFY_DESC, 'VT'), 0)) AS EST_VT_CNT -- EST ERROR에 Volume Type Error가 포함된경우" ).append("\n"); 
		query.append("                  , A.EST_OFC_CNT" ).append("\n"); 
		query.append("                  , A.WO_OFC_CNT" ).append("\n"); 
		query.append("                  , A.INV_STS_NM" ).append("\n"); 
		query.append("                  , A.INV_STS_CD" ).append("\n"); 
		query.append("                  , A.INV_CRE_USER_ID" ).append("\n"); 
		query.append("                  , A.INV_CRE_USER_NM" ).append("\n"); 
		query.append("                  , A.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("                  , A.INV_RGST_NO" ).append("\n"); 
		query.append("                  , DECODE(SIGN(A.WO_CURR_CNT - 1), 1, 'Y', 'N') AS MLT_WO_CURR_FLG" ).append("\n"); 
		query.append("                  --, EST_WO_TP_FLG" ).append("\n"); 
		query.append("                  --, MNR_WO_TP_CD_CNT" ).append("\n"); 
		query.append("           FROM     (" ).append("\n"); 
		query.append("                      SELECT   /*+USE_NL(B C E A)*/ " ).append("\n"); 
		query.append("                               C.INV_NO" ).append("\n"); 
		query.append("                             , E.CSR_NO" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 SELECT   MGC.MNR_CD_DESC " ).append("\n"); 
		query.append("                                 FROM     MNR_GEN_CD MGC " ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      A.EQ_KND_CD = MGC.MNR_CD_ID " ).append("\n"); 
		query.append("                                 AND      MGC.PRNT_CD_ID = 'CD00002'" ).append("\n"); 
		query.append("                                 AND      ROWNUM = 1" ).append("\n"); 
		query.append("                               ) AS EQ_KND_CD_NM" ).append("\n"); 
		query.append("                             , A.EQ_KND_CD" ).append("\n"); 
		query.append("                             , MAX(E.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("                             , MAX(D.VNDR_LGL_ENG_NM) AS VNDR_NM" ).append("\n"); 
		query.append("                             , MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(E.INV_OFC_CD) AS RHQ_INV_OFC_CD" ).append("\n"); 
		query.append("                             , E.INV_OFC_CD" ).append("\n"); 
		query.append("                             , A.CURR_CD AS WO_CURR_CD" ).append("\n"); 
		query.append("                             , SUM(A.MNR_AGMT_AMT) AS MNR_AGMT_AMT" ).append("\n"); 
		query.append("                             , SUM(A.MNR_WRK_AMT) AS MNR_WRK_AMT" ).append("\n"); 
		query.append("                             , SUM(A.INV_AMT) AS TTL_INV_AMT" ).append("\n"); 
		query.append("                             , SUM(B.SPR_PRT_UC_AMT) AS SPR_PRT_UC_AMT" ).append("\n"); 
		query.append("                             , C.CURR_CD AS INV_CURR_CD" ).append("\n"); 
		query.append("                             , DECODE(A.CURR_CD, C.CURR_CD, 'N', 'Y') AS REFL_EX_YN" ).append("\n"); 
		query.append("                             , SUM(B.BZC_AMT) AS BZC_AMT" ).append("\n"); 
		query.append("                             , SUM(B.COST_AMT) AS COST_AMT" ).append("\n"); 
		query.append("                             , SUM(B.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("                             , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(E.INV_ISS_DT), 'YYYYMM'), C.CURR_CD, A.CURR_CD, SUM(B.INV_AMT)) AS INV_CHG_AMT" ).append("\n"); 
		query.append("                             , MAX(C.GEN_PAY_TERM_CD) AS GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("                             , TO_CHAR(MAX(C.ISS_DT), 'YYYY-MM-DD') AS ISS_DT" ).append("\n"); 
		query.append("                             , TO_CHAR(MAX(E.AP_PAY_DT), 'YYYY-MM-DD') AS AP_PAY_DT" ).append("\n"); 
		query.append("                             , (SELECT TO_CHAR(TO_DATE(INV_TERM_DT, 'YYYYMMDD'), 'YYYY-MM-DD') FROM AP_INV_HDR PAY WHERE PAY.CSR_NO = E.CSR_NO) AS PAY_DUE_DT" ).append("\n"); 
		query.append("                             , TO_CHAR(MAX(C.CFM_DT), 'YYYY-MM-DD') AS CFM_DT" ).append("\n"); 
		query.append("                             , TO_CHAR(MAX(C.INV_CFM_DT), 'YYYYMMDDHH24MISS') AS INV_CFM_DT" ).append("\n"); 
		query.append("                             , MAX(E.INV_RMK) AS INV_RMK" ).append("\n"); 
		query.append("                             , MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(E.INV_ISS_DT), 'YYYYMM'), C.CURR_CD, A.CURR_CD, SUM(B.INV_AMT)) - SUM(B.COST_AMT) AS CHG_WO_AMT" ).append("\n"); 
		query.append("                             -- B.COST_AMT의 합이 0이면 ERROR 발생" ).append("\n"); 
		query.append("                             , DECODE(SUM(B.COST_AMT), 0, 0, ROUND((MNR_COMMON_PKG.MNR_CAL_CURR_RATE_FNC(TO_CHAR(MAX(E.INV_ISS_DT), 'YYYYMM'), C.CURR_CD, A.CURR_CD, SUM(B.INV_AMT)) - SUM(B.COST_AMT)) / SUM(B.COST_AMT) * 100 , 2)) AS WO_INV_RTO" ).append("\n"); 
		query.append("                             , WM_CONCAT(DISTINCT DECODE(B.MNR_VRFY_TP_CD, 'SS','','OF','','SL','',B.MNR_VRFY_TP_CD)) AS WK_VRFY_DESC" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 SELECT   WM_CONCAT(DISTINCT RD.MNR_VRFY_TP_CD)" ).append("\n"); 
		query.append("                                 FROM     MNR_RPR_RQST_HDR RH" ).append("\n"); 
		query.append("                                        , MNR_RPR_RQST_DTL RD" ).append("\n"); 
		query.append("                                        , MNR_ORD_HDR OH" ).append("\n"); 
		query.append("                                        , MNR_ORD_DTL OD" ).append("\n"); 
		query.append("                                        , MNR_PAY_INV_WRK WRK" ).append("\n"); 
		query.append("                                        , AP_PAY_INV INV" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      RH.MNR_ORD_OFC_CTY_CD = OH.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                                 AND      RH.MNR_ORD_SEQ = OH.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                                 AND      RH.RQST_EQ_NO = RD.RQST_EQ_NO" ).append("\n"); 
		query.append("                                 AND      RH.RPR_RQST_SEQ = RD.RPR_RQST_SEQ" ).append("\n"); 
		query.append("                                 AND      RH.RPR_RQST_VER_NO = RD.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("                                 AND      OH.MNR_ORD_OFC_CTY_CD = OD.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                                 AND      OH.MNR_ORD_SEQ = OD.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                                 AND      OD.PAY_INV_SEQ = WRK.PAY_INV_SEQ" ).append("\n"); 
		query.append("                                 AND      WRK.INV_RGST_NO = INV.INV_RGST_NO" ).append("\n"); 
		query.append("                                 AND      INV.INV_NO = C.INV_NO" ).append("\n"); 
		query.append("                                 AND      INV.VNDR_SEQ = E.VNDR_SEQ" ).append("\n"); 
		query.append("                                 AND      OH.EQ_KND_CD = A.EQ_KND_CD" ).append("\n"); 
		query.append("                                 AND      OD.EQ_NO = RH.RQST_EQ_NO" ).append("\n"); 
		query.append("                                 AND      OH.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("                                 AND      RD.MNR_VRFY_TP_CD NOT IN ('SS', 'SL' ,'OF')" ).append("\n"); 
		query.append("                               ) AS EST_VRFY_DESC" ).append("\n"); 
		query.append("                             , (" ).append("\n"); 
		query.append("                                 SELECT   MGC.MNR_CD_DESC " ).append("\n"); 
		query.append("                                 FROM     MNR_GEN_CD MGC " ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      E.INV_STS_CD = MGC.MNR_CD_ID " ).append("\n"); 
		query.append("                                 AND      MGC.PRNT_CD_ID = 'CD00042'" ).append("\n"); 
		query.append("                                 AND      ROWNUM = 1" ).append("\n"); 
		query.append("                               ) AS INV_STS_NM" ).append("\n"); 
		query.append("                             , E.INV_STS_CD" ).append("\n"); 
		query.append("                             , C.CRE_USR_ID AS INV_CRE_USER_ID" ).append("\n"); 
		query.append("                             , ( SELECT USR_NM FROM COM_USER F WHERE C.CRE_USR_ID = F.USR_ID ) AS INV_CRE_USER_NM" ).append("\n"); 
		query.append("                             , ( SELECT USR_NM FROM COM_USER F WHERE C.CRE_USR_ID = F.USR_ID ) AS INV_CRE_USER_NM2" ).append("\n"); 
		query.append("                             , NVL(" ).append("\n"); 
		query.append("                                    ( SELECT EXPN_MAX_PRMT_RTO FROM EAS_MNR_PRE_AUD_RTO_CFG WHERE AUD_OFC_CD = E.INV_OFC_CD AND MNR_VRFY_TP_AUD_FLG = 'Y' )" ).append("\n"); 
		query.append("                                  , ( SELECT EXPN_MAX_PRMT_RTO FROM EAS_MNR_PRE_AUD_RTO_CFG WHERE AUD_OFC_CD = MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(E.INV_OFC_CD) AND MNR_VRFY_TP_AUD_FLG = 'Y' )" ).append("\n"); 
		query.append("                               ) AS EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("                             , ( SELECT COUNT(1) FROM EAS_MNR_PRE_AUD_VRFY_CFG CFG WHERE E.INV_OFC_CD = CFG.AUD_OFC_CD AND CFG.EXPN_AUD_MNR_VRFY_TP_CD = 'E' AND CFG.MNR_VRFY_TP_AUD_FLG = 'Y' ) AS EST_OFC_CNT" ).append("\n"); 
		query.append("                             , (SELECT COUNT(1) FROM EAS_MNR_PRE_AUD_VRFY_CFG CFG WHERE E.INV_OFC_CD = CFG.AUD_OFC_CD AND CFG.EXPN_AUD_MNR_VRFY_TP_CD = 'W' AND CFG.MNR_VRFY_TP_AUD_FLG = 'Y' ) AS WO_OFC_CNT" ).append("\n"); 
		query.append("                             , MAX(E.INV_RGST_NO) AS INV_RGST_NO" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER( PARTITION BY C.INV_NO, E.VNDR_SEQ, A.EQ_KND_CD ORDER BY SUM(B.INV_AMT) DESC ) AS WO_CURR_SEQ" ).append("\n"); 
		query.append("                             , COUNT(1) OVER( PARTITION BY C.INV_NO, E.VNDR_SEQ, A.EQ_KND_CD ) AS WO_CURR_CNT" ).append("\n"); 
		query.append("                             --, SUM( DISTINCT DECODE(A.MNR_WO_TP_CD,'EST',1,0 ) ) AS EST_WO_TP_FLG" ).append("\n"); 
		query.append("                             --, COUNT( DISTINCT A.MNR_WO_TP_CD ) AS MNR_WO_TP_CD_CNT" ).append("\n"); 
		query.append("                      FROM     MNR_ORD_HDR A" ).append("\n"); 
		query.append("                             , MNR_ORD_DTL B" ).append("\n"); 
		query.append("                             , MNR_PAY_INV_WRK C" ).append("\n"); 
		query.append("                             , MDM_VENDOR D" ).append("\n"); 
		query.append("                             , AP_PAY_INV E" ).append("\n"); 
		query.append("                      WHERE    1 = 1" ).append("\n"); 
		query.append("                      AND      A.MNR_ORD_OFC_CTY_CD = B.MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND      A.MNR_ORD_SEQ = B.MNR_ORD_SEQ" ).append("\n"); 
		query.append("                      AND      B.PAY_INV_SEQ = C.PAY_INV_SEQ" ).append("\n"); 
		query.append("                      AND      C.INV_RGST_NO = E.INV_RGST_NO" ).append("\n"); 
		query.append("                      AND      E.VNDR_SEQ = D.VNDR_SEQ" ).append("\n"); 
		query.append("                      AND      C.MNR_INV_STS_CD = 'HC'" ).append("\n"); 
		query.append("                      AND      C.MNR_GRP_TP_CD = 'RPR'" ).append("\n"); 
		query.append("                      AND      A.MNR_WO_TP_CD IN ('EST','SPL','EXT')" ).append("\n"); 
		query.append("                      AND      B.ACCT_CD != '511591'" ).append("\n"); 
		query.append("                      AND      E.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      -- BATCH 대상 4건에 대한 조건 완성" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'A')" ).append("\n"); 
		query.append("                      AND      C.INV_CFM_DT BETWEEN TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 1 AND TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                      AND      NOT EXISTS" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT   'X'" ).append("\n"); 
		query.append("                                 FROM     EAS_MNR_CFM_INV X" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      X.VNDR_SEQ  = C.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                 AND      X.INV_NO    = C.INV_NO" ).append("\n"); 
		query.append("                                 AND      X.EQ_KND_CD = A.EQ_KND_CD" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("                      --AND C.INV_CFM_DT BETWEEN TO_DATE([to_datetime], 'YYYYMMDDHH24MISS') - 0.0834 AND TO_DATE([to_datetime], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                      --AND E.INV_CFM_DT BETWEEN TO_DATE('20141201', 'YYYY-MM-DD') AND TO_DATE('20141231', 'YYYY-MM-DD') + 0.99999	" ).append("\n"); 
		query.append("                      --MNR_PAY_INV_WRK의 INV_CFM_DT: 한국 시간" ).append("\n"); 
		query.append("                      --AP_PAY_INV의 INV_CFM_DT: 로컬 시간" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("                      AND      EXISTS" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT   'X'" ).append("\n"); 
		query.append("						         FROM     EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      X.INV_NO        = C.INV_NO" ).append("\n"); 
		query.append("                                 AND      X.INV_VNDR_SEQ  = C.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                 AND      X.EQ_KND_CD     = A.EQ_KND_CD" ).append("\n"); 
		query.append("                                 AND      X.BAT_PROG_STS_CD = 'P'" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'E')" ).append("\n"); 
		query.append("                      AND      C.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                      AND      NOT EXISTS" ).append("\n"); 
		query.append("                               (" ).append("\n"); 
		query.append("                                 SELECT   'X'" ).append("\n"); 
		query.append("                                 FROM     EAS_MNR_CFM_INV X" ).append("\n"); 
		query.append("                                 WHERE    1 = 1" ).append("\n"); 
		query.append("                                 AND      X.VNDR_SEQ  = C.MNR_PRNR_SEQ" ).append("\n"); 
		query.append("                                 AND      X.INV_NO    = C.INV_NO" ).append("\n"); 
		query.append("                                 AND      X.EQ_KND_CD = A.EQ_KND_CD" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'F')" ).append("\n"); 
		query.append("                      AND      C.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${rhq_cd} != '')" ).append("\n"); 
		query.append("                      AND      @[rhq_cd] = ( SELECT MNR_COMMON_PKG.MNR_GET_RHQ_OFC_FNC(E.INV_OFC_CD) FROM DUAL )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                      GROUP BY C.INV_NO" ).append("\n"); 
		query.append("                             , E.CSR_NO" ).append("\n"); 
		query.append("                             , A.EQ_KND_CD" ).append("\n"); 
		query.append("                             , E.VNDR_SEQ" ).append("\n"); 
		query.append("                             , E.INV_OFC_CD" ).append("\n"); 
		query.append("                             , C.CURR_CD" ).append("\n"); 
		query.append("                             , A.CURR_CD" ).append("\n"); 
		query.append("                             , E.INV_STS_CD" ).append("\n"); 
		query.append("                             , C.CRE_USR_ID" ).append("\n"); 
		query.append("                    ) A" ).append("\n"); 
		query.append("           WHERE    WO_CURR_SEQ = 1" ).append("\n"); 
		query.append("         ) A" ).append("\n"); 

	}
}