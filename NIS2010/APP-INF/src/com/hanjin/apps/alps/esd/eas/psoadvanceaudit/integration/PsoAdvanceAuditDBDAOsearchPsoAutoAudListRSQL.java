/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PsoAdvanceAuditDBDAOsearchPsoAutoAudListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.07
*@LastModifier : Arie
*@LastVersion : 1.0
* 2016.06.07 Arie
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Arie
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PsoAdvanceAuditDBDAOsearchPsoAutoAudListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.03.25 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
	  * RHQ 없을때 데이터 처리 추가
	  * 2016.05.16 CHM-201641578 CHM-201641578 Split01-Auto Audit 인보이스 배치 생성 Logic 추가 요청
	  * 2016.06.07 CHM-201641967 PSO Auto Audit 결과 수정 요청
	  * </pre>
	  */
	public PsoAdvanceAuditDBDAOsearchPsoAutoAudListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_datetime",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("s_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rhq_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.psoadvanceaudit.integration").append("\n"); 
		query.append("FileName : PsoAdvanceAuditDBDAOsearchPsoAutoAudListRSQL").append("\n"); 
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
		query.append("WITH TB_SRC AS (" ).append("\n"); 
		query.append("SELECT  AA.*" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("          SELECT ROUND ( (X.VPS_ETD_DT - X.VPS_ETB_DT) * 24, 2)" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("           WHERE X.VSL_CD      = AA.VSL_CD" ).append("\n"); 
		query.append("             AND X.SKD_VOY_NO  = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND X.SKD_DIR_CD  = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND X.YD_CD       = AA.YD_CD" ).append("\n"); 
		query.append("             AND X.CALL_YD_IND_SEQ = 1" ).append("\n"); 
		query.append("          ) AS BERTHING_HOUR" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("          SELECT NVL(SUBSTR(MIN(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI')||B.yd_cd ),-7,5), '')" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("           WHERE A.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("             AND A.VSL_CD        = AA.VSL_CD" ).append("\n"); 
		query.append("             AND A.SKD_VOY_NO    = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND A.SKD_DIR_CD    = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND A.YD_CD         = AA.YD_CD" ).append("\n"); 
		query.append("             AND A.VPS_ETD_DT    < B.VPS_ETD_DT" ).append("\n"); 
		query.append("          ) AS COUNTRY_OF_NP" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("          SELECT X.NET_RGST_TONG_WGT " ).append("\n"); 
		query.append("            FROM MDM_VSL_CNTR X" ).append("\n"); 
		query.append("           WHERE X.VSL_CD =  AA.VSL_CD" ).append("\n"); 
		query.append("          ) AS NRT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("          SELECT S1.ARR_TUG_BOT_KNT ||','||S1.DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("            FROM VSK_ACT_PORT_SKD S1" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD S2" ).append("\n"); 
		query.append("           WHERE 1 = 1" ).append("\n"); 
		query.append("             AND S1.VSL_CD          = S2.VSL_CD" ).append("\n"); 
		query.append("             AND S1.SKD_VOY_NO      = S2.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND S1.SKD_DIR_CD      = S2.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND S1.VPS_PORT_CD     = S2.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND S1.CLPT_IND_SEQ    = S2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             AND (S1.VSL_CD, S1.SKD_VOY_NO, S1.SKD_DIR_CD, S1.VPS_PORT_CD, S1.CLPT_IND_SEQ) IN" ).append("\n"); 
		query.append("                          ( SELECT VSL_CD " ).append("\n"); 
		query.append("                                 , DECODE(TURN_PORT_IND_CD, 'Y', SKD_VOY_NO, 'N', SKD_VOY_NO, TURN_SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append("                                 , DECODE(TURN_PORT_IND_CD, 'Y', SKD_DIR_CD, 'N', SKD_DIR_CD, TURN_SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("                                 , VPS_PORT_CD" ).append("\n"); 
		query.append("                                 , DECODE(TURN_PORT_IND_CD, 'Y', CLPT_IND_SEQ, 'N', CLPT_IND_SEQ, TURN_CLPT_IND_SEQ) CLPT_IND_SEQ" ).append("\n"); 
		query.append("                              FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                             WHERE VSL_CD      = AA.VSL_CD" ).append("\n"); 
		query.append("                               AND SKD_VOY_NO  = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("                               AND SKD_DIR_CD  = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("                               AND VPS_PORT_CD = SUBSTR(AA.YD_CD, 1, 5)" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("             AND S2.VSL_CD       = AA.VSL_CD" ).append("\n"); 
		query.append("             AND S2.VPS_PORT_CD  = SUBSTR(AA.YD_CD, 1, 5)" ).append("\n"); 
		query.append("             AND S2.YD_CD        = AA.YD_CD" ).append("\n"); 
		query.append("             AND ROWNUM          = 1 -- Vsk Vessel Schedule과 Pso Charge 생성 단위가 다름. Second Calling 발생하던라도 하나의 yard로 Charge Data를 발생" ).append("\n"); 
		query.append("          ) AS ARR_DEP_TUG_KNT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("          SELECT X.GRS_RGST_TONG_WGT " ).append("\n"); 
		query.append("            FROM MDM_VSL_CNTR X" ).append("\n"); 
		query.append("           WHERE X.VSL_CD  = AA.VSL_CD" ).append("\n"); 
		query.append("         ) AS GRT" ).append("\n"); 
		query.append("       , (" ).append("\n"); 
		query.append("          SELECT NVL(SUBSTR(MAX(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI')||B.VPS_PORT_CD ),-5), '')" ).append("\n"); 
		query.append("            FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("               , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND A.VSL_CD            = AA.VSL_CD" ).append("\n"); 
		query.append("             AND A.SKD_VOY_NO        = AA.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND A.SKD_DIR_CD        = AA.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND A.YD_CD             = AA.YD_CD" ).append("\n"); 
		query.append("             AND A.CALL_YD_IND_SEQ   = 1" ).append("\n"); 
		query.append("             AND A.TURN_PORT_IND_CD IN ('Y','N')" ).append("\n"); 
		query.append("             AND B.VSL_CD            = A.VSL_CD" ).append("\n"); 
		query.append("             AND B.VPS_ETD_DT        < A.VPS_ETD_DT" ).append("\n"); 
		query.append("             AND NVL(B.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("             AND B.TURN_PORT_IND_CD IN ('Y','N')       " ).append("\n"); 
		query.append("          ) LAST_PORT" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT NVL(S.SUZ_GT_WGT, 0)||','||NVL(S.MADN_VOY_SUZ_NET_TONG_WGT, 0)" ).append("\n"); 
		query.append("            FROM MDM_VSL_CNTR S" ).append("\n"); 
		query.append("           WHERE S.VSL_CD = AA.VSL_CD" ).append("\n"); 
		query.append("          ) AS VSL_CNTR_INFO" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("          SELECT -- 잘못된 큰수가 입력된 경우가 있으므로 일의자리 이하 숫자만 선택한다." ).append("\n"); 
		query.append("                 CASE WHEN INSTR(NVL(SUBSTR(MAX(TO_CHAR(S.CRE_DT,'YYYYMMDDHH24MI')||S.LOCL_XCH_RT),13),1), '.') > 0 THEN " ).append("\n"); 
		query.append("                        SUBSTR(NVL(SUBSTR(MAX(TO_CHAR(S.CRE_DT,'YYYYMMDDHH24MI')||S.LOCL_XCH_RT),13),1), INSTR(NVL(SUBSTR(MAX(TO_CHAR(S.CRE_DT,'YYYYMMDDHH24MI')||S.LOCL_XCH_RT),13),1), '.') - 1)" ).append("\n"); 
		query.append("                      ELSE SUBSTR(NVL(SUBSTR(MAX(TO_CHAR(S.CRE_DT,'YYYYMMDDHH24MI')||S.LOCL_XCH_RT),13),1), -1, 1)" ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("            FROM PSO_CNL_TZ_FEE S" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND S.ISS_CTY_CD     = AA.ISS_CTY_CD" ).append("\n"); 
		query.append("             AND S.SO_SEQ         = AA.SO_SEQ" ).append("\n"); 
		query.append("             AND S.PSO_BZTP_CD    = '5'" ).append("\n"); 
		query.append("             AND S.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("             AND S.YD_CD LIKE 'EGSUZ' || '%'" ).append("\n"); 
		query.append("             AND S.LOCL_XCH_RT IS NOT NULL" ).append("\n"); 
		query.append("          ) AS SDR_RT           -- SRD" ).append("\n"); 
		query.append("       FROM    (" ).append("\n"); 
		query.append("         SELECT ISS_CTY_CD" ).append("\n"); 
		query.append("              , SO_SEQ" ).append("\n"); 
		query.append("              , VVD" ).append("\n"); 
		query.append("              , LGS_COST_CD" ).append("\n"); 
		query.append("              , MAX(SO_DTL_SEQ) AS SO_DTL_SEQ" ).append("\n"); 
		query.append("              , MAX(PAY_TERM_DYS) AS PAY_TERM_DYS " ).append("\n"); 
		query.append("              , MAX(INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("              , MAX(PSO_CHG_STS_CD) AS PSO_CHG_STS_CD" ).append("\n"); 
		query.append("              , MAX(VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("              , MAX(SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("              , MAX(SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("              , MAX(LGS_COST_CD) AS COST_CD" ).append("\n"); 
		query.append("              , MAX(ACCT_CD) AS ACCT_CD" ).append("\n"); 
		query.append("              , MAX(IO) AS IO    " ).append("\n"); 
		query.append("              , MAX(LGS_COST_FULL_NM) AS COST_NM" ).append("\n"); 
		query.append("              , SUM(TARIFF_COST) AS TARIFF_COST" ).append("\n"); 
		query.append("              , SUM(ADJCOST) AS ADJCOST" ).append("\n"); 
		query.append("              , SUM(AMOUNT) AS AMOUNT" ).append("\n"); 
		query.append("              , MAX(FOML1) AS FOML1" ).append("\n"); 
		query.append("              , MAX(FOML2) AS FOML2" ).append("\n"); 
		query.append("              , MAX(COND1) AS COND1" ).append("\n"); 
		query.append("              , MAX(RMK) AS RMK" ).append("\n"); 
		query.append("              , MAX(VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("              , MAX(YD_CD) AS YD_CD" ).append("\n"); 
		query.append("              , MAX(YD_CHG_NO) AS YD_CHG_NO" ).append("\n"); 
		query.append("              , MAX(YD_CHG_VER_SEQ) AS YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("              , MAX(BKG_GET_TOKEN_FNC(ATB_ATD,1)) ATB" ).append("\n"); 
		query.append("              , MAX(BKG_GET_TOKEN_FNC(ATB_ATD,2)) ATD" ).append("\n"); 
		query.append("              , MAX(TTL_LOCL_AMT) AS TTL_LOCL_AMT" ).append("\n"); 
		query.append("              , MAX(INV_LOCL_AMT) AS INV_LOCL_AMT" ).append("\n"); 
		query.append("              , MAX(LOCL_TAX_AMT) AS LOCL_TAX_AMT" ).append("\n"); 
		query.append("              , MAX(LOCL_WHLD_TAX_AMT) AS LOCL_WHLD_TAX_AMT" ).append("\n"); 
		query.append("              , MAX(CURR_CD)           AS CURR_CD" ).append("\n"); 
		query.append("              , MAX(EFF_DT)            AS EFF_DT" ).append("\n"); 
		query.append("              , MAX(PSO_TRNS_SLP_CTNT) AS PSO_TRNS_SLP_CTNT" ).append("\n"); 
		query.append("              , MAX(ISS_DT)            AS ISS_DT" ).append("\n"); 
		query.append("              , MAX(ACPT_DT)           AS ACPT_DT" ).append("\n"); 
		query.append("              , MAX(N3PTY_BIL_IF_FLG)  AS N3PTY_BIL_IF_FLG" ).append("\n"); 
		query.append("              , MAX(N3PTY_BIL_TP_CD)   AS N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("              , MAX(IF_RMK)            AS IF_RMK" ).append("\n"); 
		query.append("              , MAX(N3PTY_VNDR_SEQ)    AS N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("              , MAX(MNL_INP_XCH_RT)    AS MNL_INP_XCH_RT" ).append("\n"); 
		query.append("              , MAX(INV_NO)            AS INV_NO" ).append("\n"); 
		query.append("              , MAX(CRE_USR_ID)        AS CRE_USR_ID " ).append("\n"); 
		query.append("              , MAX(INV_RGST_NO)       AS INV_RGST_NO" ).append("\n"); 
		query.append("              , MAX(PAY_DUE_DT)        AS PAY_DUE_DT" ).append("\n"); 
		query.append("              , MAX(EXPN_MAX_PRMT_RTO) AS EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("              , MAX(RHQ_OFC_CD)        AS RHQ_OFC_CD" ).append("\n"); 
		query.append("--              , MAX(CSR_STS_CD)        AS CSR_STS_CD" ).append("\n"); 
		query.append("              , MAX(CSR_NO)            AS CSR_NO" ).append("\n"); 
		query.append("              , MAX(AP_PAY_DT)         AS AP_PAY_DT" ).append("\n"); 
		query.append("              , MAX(DIS_INV_OFC_CD)    AS DIS_INV_OFC_CD" ).append("\n"); 
		query.append("              , MAX(ACCT_ENG_NM)       AS ACCT_NM" ).append("\n"); 
		query.append("              , MAX(UPD_DT)            AS UPD_DT" ).append("\n"); 
		query.append("              , MAX(INV_CFM_DT)        AS INV_CFM_DT" ).append("\n"); 
		query.append("              --, MAX(AUD_RLST_FLG)      AS AUD_RLST_FLG" ).append("\n"); 
		query.append("           FROM (" ).append("\n"); 
		query.append("                SELECT T2.ISS_CTY_CD" ).append("\n"); 
		query.append("                     , T2.SO_SEQ" ).append("\n"); 
		query.append("                     , T2.ORG_SO_DTL_SEQ AS SO_DTL_SEQ" ).append("\n"); 
		query.append("                     , T2.VVD" ).append("\n"); 
		query.append("                     , SUBSTR(T2.VVD, 1, 4) AS VSL_CD" ).append("\n"); 
		query.append("                     , SUBSTR(T2.VVD, 5, 4) AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , SUBSTR(T2.VVD, 9) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , T1.PAY_TERM_DYS" ).append("\n"); 
		query.append("                     , DECODE(T1.INV_OFC_CD, 'PUSMOV', 'SELIB', T1.INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("                     , T1.INV_OFC_CD AS DIS_INV_OFC_CD" ).append("\n"); 
		query.append("                     , T1.PSO_CHG_STS_CD" ).append("\n"); 
		query.append("                     , T2.LGS_COST_CD" ).append("\n"); 
		query.append("                     --, DECODE(T2.DP_IO_BND_CD, 'I', 'IN', 'O', 'OUT', 'IN/OUT') AS IO" ).append("\n"); 
		query.append("                     , T2.DP_IO_BND_CD AS IO" ).append("\n"); 
		query.append("                     , C.ACCT_CD" ).append("\n"); 
		query.append("                     , C.LGS_COST_FULL_NM" ).append("\n"); 
		query.append("                     , T2.CALC_AMT AS TARIFF_COST" ).append("\n"); 
		query.append("                     , DECODE(T2.CALC_AMT, NULL, DECODE(T2.ADJ_AMT, NULL, T2.LOCL_AMT, T2.ADJ_AMT), T2.ADJ_AMT) AS ADJCOST" ).append("\n"); 
		query.append("                     , T2.LOCL_AMT  AS AMOUNT" ).append("\n"); 
		query.append("                     , T2.FOML_DESC AS FOML1" ).append("\n"); 
		query.append("                     , T2.XPR_DESC  AS FOML2" ).append("\n"); 
		query.append("                     , T2.XPR_DESC  AS COND1" ).append("\n"); 
		query.append("                     , T2.FOML_DESC AS COND2" ).append("\n"); 
		query.append("                     , T2.DIFF_RMK  AS RMK" ).append("\n"); 
		query.append("                     , T1.VNDR_SEQ  AS VNDR_SEQ" ).append("\n"); 
		query.append("                     , T1.YD_CD     AS YD_CD" ).append("\n"); 
		query.append("                     , T2.YD_CHG_NO AS YD_CHG_NO" ).append("\n"); 
		query.append("                     , T2.YD_CHG_VER_SEQ  AS YD_CHG_VER_SEQ" ).append("\n"); 
		query.append("                     , T1.TTL_LOCL_AMT    AS TTL_LOCL_AMT" ).append("\n"); 
		query.append("                     , T1.INV_LOCL_AMT    AS INV_LOCL_AMT  --Invoice Local Amount" ).append("\n"); 
		query.append("                     , T1.LOCL_TAX_AMT    AS LOCL_TAX_AMT" ).append("\n"); 
		query.append("                     , T1.LOCL_WHLD_TAX_AMT    AS LOCL_WHLD_TAX_AMT" ).append("\n"); 
		query.append("                     , T1.CURR_CD              AS CURR_CD" ).append("\n"); 
		query.append("                     , TO_CHAR(T1.EFF_DT, 'YYYY-MM-DD')    AS EFF_DT" ).append("\n"); 
		query.append("                     , T1.PSO_TRNS_SLP_CTNT                AS PSO_TRNS_SLP_CTNT" ).append("\n"); 
		query.append("                     , TO_CHAR(T1.ISS_DT, 'YYYY-MM-DD')    AS ISS_DT" ).append("\n"); 
		query.append("                     , TO_CHAR(T1.ACPT_DT, 'YYYY-MM-DD')   AS ACPT_DT" ).append("\n"); 
		query.append("                     , T3.N3PTY_BIL_IF_FLG" ).append("\n"); 
		query.append("                     , T3.N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                     , T3.IF_RMK " ).append("\n"); 
		query.append("                     , T3.N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("                     , T2.MNL_INP_XCH_RT    AS MNL_INP_XCH_RT" ).append("\n"); 
		query.append("                     , T1.INV_NO            AS INV_NO" ).append("\n"); 
		query.append("                     , T1.CRE_USR_ID " ).append("\n"); 
		query.append("                     , T1.INV_RGST_NO       AS INV_RGST_NO" ).append("\n"); 
		query.append("                     , (SELECT MIN(TO_CHAR(X.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI'))||','||MIN(TO_CHAR(X.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI'))" ).append("\n"); 
		query.append("                          FROM VSK_VSL_PORT_SKD  X" ).append("\n"); 
		query.append("                         WHERE X.VSL_CD      = T2.VSL_CD" ).append("\n"); 
		query.append("                           AND X.SKD_VOY_NO  = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND X.SKD_DIR_CD  = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND X.YD_CD       = T1.YD_CD" ).append("\n"); 
		query.append("                       ) ATB_ATD" ).append("\n"); 
		query.append("                     , (SELECT EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD (DECODE(T1.INV_OFC_CD, 'PUSMOV', 'SELIB', T1.INV_OFC_CD)) FROM DUAL) RHQ_OFC_CD" ).append("\n"); 
		query.append("                     , TO_CHAR(T1.ISS_DT + NVL(T1.PAY_TERM_DYS, 0), 'YYYY-MM-DD')  AS PAY_DUE_DT" ).append("\n"); 
		query.append("                     , (SELECT X.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("                          FROM EAS_PORT_SO_CHG_ACCT X" ).append("\n"); 
		query.append("                         WHERE X.AUD_OFC_CD  = (SELECT TRS_COMMON_PKG.TRS_GET_RHQ_OFC_CD (DECODE(T1.INV_OFC_CD, 'PUSMOV', 'SELIB', T1.INV_OFC_CD)) FROM DUAL)  " ).append("\n"); 
		query.append("                           AND X.LGS_COST_CD = T2.LGS_COST_CD" ).append("\n"); 
		query.append("                       ) EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("                     , (CASE WHEN AI.INV_STS_CD = 'D' THEN 'D' -- Paid" ).append("\n"); 
		query.append("                             WHEN AH.IF_FLG = 'Y' AND AH.RCV_ERR_FLG IS NULL THEN 'P' -- I/F Success" ).append("\n"); 
		query.append("                             WHEN AH.RCV_ERR_FLG = 'E' THEN 'J' -- A/P Rejected" ).append("\n"); 
		query.append("                             WHEN AH.IF_FLG = 'E' THEN 'E' -- I/F Error" ).append("\n"); 
		query.append("                             WHEN AH.IF_FLG IS NULL AND AH.APRO_FLG = 'Y' AND AH.IF_ERR_RSN = 'Sending...' THEN 'S' -- Sending" ).append("\n"); 
		query.append("                             WHEN AI.INV_STS_CD = 'R' OR AI.INV_STS_CD = 'B' OR AH.CSR_RJCT_DT IS NOT NULL THEN 'R' -- Disapproved" ).append("\n"); 
		query.append("                             WHEN AH.IF_FLG IS NULL AND NVL(AH.RQST_APRO_STEP_FLG,'N') = 'N' THEN 'A' -- Approval Requested" ).append("\n"); 
		query.append("                             WHEN AH.IF_FLG IS NULL AND NVL(AH.RQST_APRO_STEP_FLG,'N') = 'Y' THEN 'L' -- Requesting Approval" ).append("\n"); 
		query.append("                             WHEN T1.PSO_CHG_STS_CD = 'A' THEN 'C'" ).append("\n"); 
		query.append("                        END) CSR_STS_CD" ).append("\n"); 
		query.append("                      , AH.CSR_NO " ).append("\n"); 
		query.append("                      , TO_CHAR(AI.AP_PAY_DT, 'YYYY-MM-DD') AS AP_PAY_DT" ).append("\n"); 
		query.append("                      , MA.ACCT_ENG_NM" ).append("\n"); 
		query.append("                      , T1.UPD_DT -- 기존에 confirm date" ).append("\n"); 
		query.append("                      , AI.INV_CFM_DT " ).append("\n"); 
		query.append("                      --, (CASE WHEN AI.INV_NO IS NOT NULL THEN 'Y' ELSE 'N' END) AUD_RLST_FLG" ).append("\n"); 
		query.append("                  FROM PSO_CHARGE   T1" ).append("\n"); 
		query.append("                     , (SELECT X.*" ).append("\n"); 
		query.append("                             , CASE WHEN X.SO_DTL_SEQ = X.ORG_SO_DTL_SEQ THEN X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD" ).append("\n"); 
		query.append("                                    ELSE (SELECT Y.VSL_CD||Y.SKD_VOY_NO||Y.SKD_DIR_CD" ).append("\n"); 
		query.append("                                            FROM PSO_CHG_DTL Y" ).append("\n"); 
		query.append("                                           WHERE Y.ISS_CTY_CD = X.ISS_CTY_CD" ).append("\n"); 
		query.append("                                             AND Y.SO_SEQ     = X.SO_SEQ" ).append("\n"); 
		query.append("                                             AND Y.SO_DTL_SEQ = X.ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append("                                         )" ).append("\n"); 
		query.append("                               END VVD" ).append("\n"); 
		query.append("                          FROM PSO_CHG_DTL X" ).append("\n"); 
		query.append("                       ) T2" ).append("\n"); 
		query.append("                     , TES_LGS_COST C" ).append("\n"); 
		query.append("                     , MDM_ACCOUNT  MA" ).append("\n"); 
		query.append("                     , EAS_PORT_SO_CHG_ACCT CS" ).append("\n"); 
		query.append("                     , (SELECT X.ISS_CTY_CD" ).append("\n"); 
		query.append("                             , X.SO_SEQ" ).append("\n"); 
		query.append("                             , X.SO_DTL_SEQ" ).append("\n"); 
		query.append("                             , MAX(DECODE(X.ISS_CTY_CD, 'N', 'N', NULL, 'N', 'Y')) AS N3PTY_BIL_IF_FLG" ).append("\n"); 
		query.append("                             , MAX(X.N3PTY_BIL_TP_CD) AS N3PTY_BIL_TP_CD" ).append("\n"); 
		query.append("                             , MAX(X.IF_RMK)    AS IF_RMK" ).append("\n"); 
		query.append("                             , MAX(X.VNDR_SEQ)  AS N3PTY_VNDR_SEQ" ).append("\n"); 
		query.append("                          FROM PSO_N3RD_PTY_IF X" ).append("\n"); 
		query.append("                         GROUP BY X.ISS_CTY_CD" ).append("\n"); 
		query.append("                             , X.SO_SEQ" ).append("\n"); 
		query.append("                             , X.SO_DTL_SEQ" ).append("\n"); 
		query.append("                       ) T3" ).append("\n"); 
		query.append("                      , AP_PAY_INV AI" ).append("\n"); 
		query.append("                      , AP_INV_HDR AH" ).append("\n"); 
		query.append("                 WHERE 1=1               " ).append("\n"); 
		query.append("                   AND T1.ISS_CTY_CD  = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("                   AND T1.SO_SEQ      = T2.SO_SEQ" ).append("\n"); 
		query.append("                   AND T2.LGS_COST_CD = C.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND C.ACCT_CD      = MA.ACCT_CD" ).append("\n"); 
		query.append("                   AND T2.LGS_COST_CD = CS.LGS_COST_CD" ).append("\n"); 
		query.append("                   AND T2.ISS_CTY_CD  = T3.ISS_CTY_CD (+)" ).append("\n"); 
		query.append("                   AND T2.SO_SEQ      = T3.SO_SEQ     (+)" ).append("\n"); 
		query.append("                   AND T2.ORG_SO_DTL_SEQ  = T3.SO_DTL_SEQ (+)" ).append("\n"); 
		query.append("                   AND T1.INV_RGST_NO  = AI.INV_RGST_NO" ).append("\n"); 
		query.append("                   AND AI.CSR_NO       = AH.CSR_NO(+)" ).append("\n"); 
		query.append("                   AND CS.AUD_OFC_CD   = (SELECT EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD (DECODE(T1.INV_OFC_CD, 'PUSMOV', 'SELIB', T1.INV_OFC_CD)) FROM DUAL)" ).append("\n"); 
		query.append("                   AND C.ACCT_CD <> '999999'   " ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'A')" ).append("\n"); 
		query.append("-- 2시간 배치(이전 하루동안 confirm된 자료 중 auto audit 테이블에 없는 DATA)" ).append("\n"); 
		query.append("                   AND AI.INV_CFM_DT BETWEEN TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 1 AND TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                     FROM EAS_PORT_SO_CFM_INV X" ).append("\n"); 
		query.append("                                    WHERE X.ISS_CTY_CD = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("                                      AND X.SO_SEQ     = T2.SO_SEQ" ).append("\n"); 
		query.append("                                      --AND X.SO_DTL_SEQ = T2.ORG_SO_DTL_SEQ " ).append("\n"); 
		query.append("                                  )	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           " ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("-- 실시간 배치" ).append("\n"); 
		query.append("                   AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                                 FROM EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("                                WHERE X.ISS_CTY_CD = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("                                  AND X.SO_SEQ     = T2.SO_SEQ" ).append("\n"); 
		query.append("                                  --AND X.SO_DTL_SEQ = T2.ORG_SO_DTL_SEQ " ).append("\n"); 
		query.append("                                  AND X.SUB_SYS_CD = 'PSO'" ).append("\n"); 
		query.append("                                  AND X.BAT_PROG_STS_CD = 'P'" ).append("\n"); 
		query.append("                                  AND X.CRE_DT > SYSDATE - 2 -- 다양한 사유로 배치 중지 되었을 경우를 대비하여 이틀간 자료 배치 수행" ).append("\n"); 
		query.append("                               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'E')" ).append("\n"); 
		query.append("-- 메뉴얼 기간 배치 (Period로 조회)" ).append("\n"); 
		query.append("                   AND AI.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("                   AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                                     FROM EAS_PORT_SO_CFM_INV X" ).append("\n"); 
		query.append("                                    WHERE X.ISS_CTY_CD = T2.ISS_CTY_CD" ).append("\n"); 
		query.append("                                      AND X.SO_SEQ     = T2.SO_SEQ" ).append("\n"); 
		query.append("                                      --AND X.SO_DTL_SEQ = T2.ORG_SO_DTL_SEQ" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 
		query.append("#end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'F')" ).append("\n"); 
		query.append("-- 초기 자료 생성 (Period로 조회)" ).append("\n"); 
		query.append("                   AND AI.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYYMMDD') AND TO_DATE(@[s_to_dt], 'YYYYMMDD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("-- RHQ로 조회 (초기 자료 생성시 등에 옵션 조건으로 사용하기 위하여 남겨둠)" ).append("\n"); 
		query.append("                   AND CS.AUD_OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" 	" ).append("\n"); 
		query.append("#if (${s_inv_no}!= '')" ).append("\n"); 
		query.append("-- Invoice No로 조회" ).append("\n"); 
		query.append("                   AND T1.INV_NO IN (" ).append("\n"); 
		query.append("                     #foreach( ${key} IN ${invNos}) " ).append("\n"); 
		query.append("                        #if($velocityCount < $invNos.size()) " ).append("\n"); 
		query.append("                        '${key}'," ).append("\n"); 
		query.append("                        #else " ).append("\n"); 
		query.append("                        '${key}'" ).append("\n"); 
		query.append("                        #end " ).append("\n"); 
		query.append("                     #end" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    --AND T1.UPD_DT BETWEEN TO_DATE('2016-03-01','YYYY-MM-DD') AND TO_DATE('2016-03-15','YYYY-MM-DD') + 0.99999 " ).append("\n"); 
		query.append("                   AND LENGTH(T2.LGS_COST_CD) = 6" ).append("\n"); 
		query.append("                   AND C.ACCT_CD NOT IN ('999999', '511795')" ).append("\n"); 
		query.append("                   AND ((SUBSTR(C.ACCT_CD,0,4) IN ('5117', '5118', '5119') AND CS.LGS_COST_AUD_FLG = DECODE('1','1','Y','2','N')) OR (C.ACCT_CD IN ('564611', '511795') OR MA.ACCT_ENG_NM LIKE 'OTHER PORT%'))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                      " ).append("\n"); 
		query.append("                  )" ).append("\n"); 
		query.append("        GROUP BY ISS_CTY_CD" ).append("\n"); 
		query.append("               , SO_SEQ" ).append("\n"); 
		query.append("               , VVD" ).append("\n"); 
		query.append("               , LGS_COST_CD" ).append("\n"); 
		query.append("        ) AA" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("#if(${s_rhq_ofc_cd} != '')" ).append("\n"); 
		query.append("-- RHQ로 조회 (초기 자료 생성시 등에 옵션 조건으로 사용하기 위하여 남겨둠)" ).append("\n"); 
		query.append("AND     RHQ_OFC_CD = @[s_rhq_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'A')" ).append("\n"); 
		query.append("-- 2시간 배치 : DATA 누락으로 2시간 배치에서 하루이전 Confirm된 자료 중 EAS_PORT_SO_CFM_INV에 없는 DATA 생성 으로 변경" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM EAS_PORT_SO_CFM_INV X" ).append("\n"); 
		query.append("                WHERE X.ISS_CTY_CD = AA.ISS_CTY_CD" ).append("\n"); 
		query.append("                  AND X.SO_SEQ     = AA.SO_SEQ" ).append("\n"); 
		query.append("                  AND X.SO_DTL_SEQ = AA.SO_DTL_SEQ -- MAX값을 가져오므로 이곳에서 체크함" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("-- 실시간 배치" ).append("\n"); 
		query.append(" AND EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                 FROM EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("                WHERE X.ISS_CTY_CD = AA.ISS_CTY_CD" ).append("\n"); 
		query.append("                  AND X.SO_SEQ     = AA.SO_SEQ" ).append("\n"); 
		query.append("                  AND X.SO_DTL_SEQ = AA.SO_DTL_SEQ -- MAX값을 가져오므로 이곳에서 체크함" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${batch_tp_cd} == 'E')" ).append("\n"); 
		query.append("-- 메뉴얼 기간 배치 (Period로 조회)" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("                 FROM EAS_PORT_SO_CFM_INV X" ).append("\n"); 
		query.append("                WHERE X.ISS_CTY_CD = AA.ISS_CTY_CD" ).append("\n"); 
		query.append("                  AND X.SO_SEQ     = AA.SO_SEQ" ).append("\n"); 
		query.append("                  AND X.SO_DTL_SEQ = AA.O_DTL_SEQ -- MAX값을 가져오므로 이곳에서 체크함" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(", TB_VVD_TIER AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT DISTINCT VSL_CD, VOY_NO, DIR_CD, 'EGSUZ' AS PORT_CD," ).append("\n"); 
		query.append("       CASE WHEN RNK='Y' THEN" ).append("\n"); 
		query.append("            TIER_1ST" ).append("\n"); 
		query.append("       ELSE" ).append("\n"); 
		query.append("            TIER_2ND" ).append("\n"); 
		query.append("       END SCG_CAR_TIER" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	ROW_NUMBER () OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS SEQ" ).append("\n"); 
		query.append("				, VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND, YD_CD" ).append("\n"); 
		query.append("				, DECODE(SIGN(TEU - 11), -1, 'N', 'Y') AS RNK" ).append("\n"); 
		query.append("				, TIER_NO AS TIER_1ST				" ).append("\n"); 
		query.append("				, LEAD (TIER_NO) OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS TIER_2ND" ).append("\n"); 
		query.append("				, TEU AS TEU_1ST" ).append("\n"); 
		query.append("				, LEAD (TEU) OVER (PARTITION BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND ORDER BY TIER_NO DESC) AS TEU_2ND				" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND, YD_CD" ).append("\n"); 
		query.append("						, TIER_NO AS TIER_NO" ).append("\n"); 
		query.append("						, MAX(MAX_TIER_BY_BAY) AS TIER_ORG" ).append("\n"); 
		query.append("						, SUM(CASE WHEN (TIER = MAX_TIER_BY_BAY) THEN TEU ELSE 0 END) AS TEU" ).append("\n"); 
		query.append("				FROM	(	" ).append("\n"); 
		query.append("							SELECT	T1.VSL_CD" ).append("\n"); 
		query.append("									, T1.VOY_NO" ).append("\n"); 
		query.append("									, T1.DIR_CD" ).append("\n"); 
		query.append("									, T1.PORT_CD" ).append("\n"); 
		query.append("									, T1.CALL_IND" ).append("\n"); 
		query.append("									, T1.PLAN_TYPE" ).append("\n"); 
		query.append("									, T1.BAY" ).append("\n"); 
		query.append("									, T1.TIER" ).append("\n"); 
		query.append("									, T2.YD_CD					" ).append("\n"); 
		query.append("									, MAX(T1.TIER) OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY ) AS MAX_TIER_BY_BAY" ).append("\n"); 
		query.append("									, COUNT (DISTINCT T1.TIER) OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY ) AS TIER_NO							" ).append("\n"); 
		query.append("									, SUM( CASE WHEN T1.SZTP LIKE 'D2%' THEN 1 ELSE 2 END ) AS TEU" ).append("\n"); 
		query.append("									, ROW_NUMBER () OVER (PARTITION BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.BAY, T1.TIER ORDER BY T1.TIER DESC, T1.PLAN_TYPE DESC) AS PLAN_TYPE_SEQ 						" ).append("\n"); 
		query.append("							FROM	BAY_PLAN T1," ).append("\n"); 
		query.append("							        (" ).append("\n"); 
		query.append("							        SELECT /*+ INDEX_DESC(T2 XAK12VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("							                  T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T2.VPS_PORT_CD, T2.CLPT_IND_SEQ, T2.YD_CD" ).append("\n"); 
		query.append("							           FROM   VSK_VSL_PORT_SKD T1, VSK_VSL_PORT_SKD T2," ).append("\n"); 
		query.append("							                  (" ).append("\n"); 
		query.append("							                  SELECT DISTINCT VVD, YD_CD" ).append("\n"); 
		query.append("							                  FROM   TB_SRC" ).append("\n"); 
		query.append("							                  )  T3" ).append("\n"); 
		query.append("							           WHERE  1=1" ).append("\n"); 
		query.append("							           AND    T1.VSL_CD       = SUBSTR(T3.VVD, 1, 4)" ).append("\n"); 
		query.append("							           AND    T1.SKD_VOY_NO   = SUBSTR(T3.VVD, 5, 4)" ).append("\n"); 
		query.append("							           AND    T1.SKD_DIR_CD   = SUBSTR(T3.VVD, 9)" ).append("\n"); 
		query.append("							           AND    T1.VPS_PORT_CD  = SUBSTR(T3.YD_CD, 1, 5)" ).append("\n"); 
		query.append("							           AND    T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("							           AND    T1.SKD_VOY_NO   = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("							           AND    T1.SKD_DIR_CD   = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("							           AND    T1.CLPT_SEQ     > T2.CLPT_SEQ" ).append("\n"); 
		query.append("							           AND    NVL(T2.SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("									   AND    ROWNUM = 1" ).append("\n"); 
		query.append("							        ) T2" ).append("\n"); 
		query.append("							WHERE	1 = 1				" ).append("\n"); 
		query.append("							AND		T1.VSL_CD       = T2.VSL_CD" ).append("\n"); 
		query.append("							AND     T1.VOY_NO       = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND     T1.DIR_CD       = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND     T1.PORT_CD      = T2.VPS_PORT_CD" ).append("\n"); 
		query.append("							AND     T1.CALL_IND     = T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("							AND		T1.TIER		>= '50'" ).append("\n"); 
		query.append("							GROUP BY T1.VSL_CD, T1.VOY_NO, T1.DIR_CD, T1.PORT_CD, T1.CALL_IND, T1.PLAN_TYPE, T1.BAY, T1.TIER, YD_CD" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("				WHERE	PLAN_TYPE_SEQ	= 1		" ).append("\n"); 
		query.append("				GROUP BY VSL_CD, VOY_NO, DIR_CD, PORT_CD, CALL_IND, TIER_NO, YD_CD" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("		) T1, VSK_PORT_CNL_TR_SCG T2" ).append("\n"); 
		query.append("WHERE	T2.LOC_CD		= 'EGSUZ'" ).append("\n"); 
		query.append("AND		T2.TR_SEQ		= DECODE(RNK, 'Y', TIER_1ST, TIER_2ND) " ).append("\n"); 
		query.append("AND		T1.SEQ			= 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT   '' SEL" ).append("\n"); 
		query.append("        ,'' IBFLAG" ).append("\n"); 
		query.append("        ,'' SELECT_FLG" ).append("\n"); 
		query.append("        , T1.ISS_CTY_CD, T1.SO_SEQ, T1.SO_DTL_SEQ" ).append("\n"); 
		query.append("        , T3.EAC_NO" ).append("\n"); 
		query.append("        --, (SELECT F.FLET_CTRT_TP_CD FROM FMS_CONTRACT F WHERE F.VSL_CD = T1.VSL_CD) AS FLET_CTRT_TP_CD --동일배가 다른 TP으로도 들어오므로 검색조건에서 걸어주도록 수정" ).append("\n"); 
		query.append("        , (SELECT C.CNTR_VSL_CLSS_CAPA FROM MDM_VSL_CNTR C WHERE C.VSL_CD = T1.VSL_CD) AS CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("        , T3.PORT_CHG_AUD_CHK_CD                    --AS SELECT_FLG_TEMP" ).append("\n"); 
		query.append("        ,(CASE WHEN (TARIFF_COST = 0 OR TARIFF_COST IS NULL) " ).append("\n"); 
		query.append("					THEN CASE WHEN (T1.ADJCOST <0) THEN 'F' ELSE 'C' END" ).append("\n"); 
		query.append("			 --WHEN TARIFF_COST = 0 OR TARIFF_COST IS NULL THEN 'C'" ).append("\n"); 
		query.append("             --: PSO Auto Audit/Manual Audit에서 Tariff가 없는 것은 Candidate EAC로 분류-->PSO Auto Audit / Manual Audit에서 Tariff가 없고 Adjust Cost가 마이너스 금액인 경우는 Discrepancy로 분류" ).append("\n"); 
		query.append("               WHEN ABS(ROUND( (AMOUNT - TARIFF_COST) / DECODE(TARIFF_COST,0,1,TARIFF_COST) * 100 , 1 )) <= 1 THEN 'S'" ).append("\n"); 
		query.append("               WHEN T1.EXPN_MAX_PRMT_RTO >= (ROUND( (AMOUNT - TARIFF_COST) / DECODE(TARIFF_COST,0,1,TARIFF_COST) * 100 , 1 )) THEN CASE WHEN NVL(TARIFF_COST,0) = NVL(AMOUNT,0) THEN 'S'" ).append("\n"); 
		query.append("                                                                                                                                        ELSE 'F'" ).append("\n"); 
		query.append("                                                                                                                                   END" ).append("\n"); 
		query.append("               WHEN T1.EXPN_MAX_PRMT_RTO <  (ROUND( (AMOUNT - TARIFF_COST) / DECODE(TARIFF_COST,0,1,TARIFF_COST) * 100 , 1 )) THEN 'C'" ).append("\n"); 
		query.append("               --ELSE 'O' -- Ratio가 등록되지 않아 비교값이 없는 경우" ).append("\n"); 
		query.append("               ELSE (CASE WHEN T3.PORT_CHG_AUD_CHK_CD IS NULL THEN 'F'" ).append("\n"); 
		query.append("                          WHEN T3.PORT_CHG_AUD_CHK_CD = 'E' THEN 'C'" ).append("\n"); 
		query.append("                     END" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("          END) AUTO_EXPN_AUD_STS_CD--AUTO_AUDIT_FLG" ).append("\n"); 
		query.append("        , RHQ_OFC_CD     RHQ_CD                           --AS RHQ" ).append("\n"); 
		query.append("        , T1.INV_OFC_CD                             --AS OFFICE" ).append("\n"); 
		query.append("        , SUBSTR(T1.YD_CD,1,5)                      AS PORT" ).append("\n"); 
		query.append("        , T1.YD_CD                                  --AS YARD" ).append("\n"); 
		query.append("        , T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD        " ).append("\n"); 
		query.append("        , T1.VSL_CD||T1.SKD_VOY_NO||T1.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        , T1.IO                                     DP_IO_BND_CD--AS BOUND" ).append("\n"); 
		query.append("        , T1.ATB                                    VPS_ETB_DT--AS VPS_ATB_DT" ).append("\n"); 
		query.append("        , T1.ACCT_CD" ).append("\n"); 
		query.append("        --, T1.ACCT_NM" ).append("\n"); 
		query.append("        , T1.COST_CD                                LGS_COST_CD" ).append("\n"); 
		query.append("        --, T1.COST_NM" ).append("\n"); 
		query.append("        , T1.VNDR_SEQ                               --AS SP_NO" ).append("\n"); 
		query.append("        , T1.INV_NO" ).append("\n"); 
		query.append("        , T1.CRE_USR_ID INV_CRE_USR_ID--(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = T1.CRE_USR_ID) AS CRE_USR_ID" ).append("\n"); 
		query.append("        , T1.ISS_DT" ).append("\n"); 
		query.append("        , T1.CURR_CD" ).append("\n"); 
		query.append("        , DECODE(T1.TARIFF_COST, 0, NULL, T1.TARIFF_COST) CALC_AMT--TARIFF_COST" ).append("\n"); 
		query.append("        , T1.ADJCOST                                      ADJ_AMT" ).append("\n"); 
		query.append("        , T1.AMOUNT                                       INV_AMT" ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("           WHEN NVL(TARIFF_COST,0) = 0 THEN" ).append("\n"); 
		query.append("                NULL" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("                ROUND( (AMOUNT - TARIFF_COST) / TARIFF_COST * 100 , 2 )" ).append("\n"); 
		query.append("           END  AS DIFF_AMT--DIFF -->>01 DIFF 보정함" ).append("\n"); 
		query.append("        , T1.FOML1                                        FOML_DESC" ).append("\n"); 
		query.append("        , T1.FOML2                                        XPR_DESC" ).append("\n"); 
		query.append("        , T1.RMK                                          DIFF_RMK" ).append("\n"); 
		query.append("        , T1.BERTHING_HOUR                                BRTH_HRS" ).append("\n"); 
		query.append("        , T1.COUNTRY_OF_NP                                ST_PORT_CD" ).append("\n"); 
		query.append("        , T1.NRT                                          NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("        , BKG_GET_TOKEN_FNC(T1.ARR_DEP_TUG_KNT, 1) ARR_TUG_BOT_KNT" ).append("\n"); 
		query.append("        , BKG_GET_TOKEN_FNC(T1.ARR_DEP_TUG_KNT, 2) DEP_TUG_BOT_KNT" ).append("\n"); 
		query.append("        , T1.GRT                                          GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("        , T1.LAST_PORT                                    LST_PORT_CD" ).append("\n"); 
		query.append("        , BKG_GET_TOKEN_FNC(T1.VSL_CNTR_INFO, 1) SUZ_GT_WGT" ).append("\n"); 
		query.append("        , BKG_GET_TOKEN_FNC(T1.VSL_CNTR_INFO, 2) MADN_VOY_SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("        , '' AS NIGHT_FLG" ).append("\n"); 
		query.append("        , T1.SDR_RT                                       SDR_XCH_RT" ).append("\n"); 
		query.append("        , T4.SCG_CAR_TIER                                 VSL_TR_NO" ).append("\n"); 
		query.append("--        , DECODE(T3.PORT_CHG_AUD_CHK_CD,'','',(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = T3.UPD_USR_ID)) AS UPD_USR_ID" ).append("\n"); 
		query.append("--        , DECODE(T3.PORT_CHG_AUD_CHK_CD,'','',(SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = T3.UPD_USR_ID)) AS AUDIT_USR_ID" ).append("\n"); 
		query.append("        , DECODE(T3.PORT_CHG_AUD_CHK_CD,'','',UPD_USR_ID) AS UPD_USR_ID" ).append("\n"); 
		query.append("        , DECODE(T3.PORT_CHG_AUD_CHK_CD,'','',PORT_CHG_AUD_USR_ID) AS PORT_CHG_AUD_USR_ID" ).append("\n"); 
		query.append("        , DECODE(T3.PORT_CHG_AUD_CHK_CD,'','',TO_CHAR(T3.PORT_CHG_AUD_DT , 'YYYY-MM-DD')) PORT_CHG_AUD_DT " ).append("\n"); 
		query.append("        , T3.PORT_CHG_AUD_RSLT_RMK" ).append("\n"); 
		query.append("        , T3.PORT_CHG_AUD_RSLT_USR_ID" ).append("\n"); 
		query.append("--        , (SELECT X.USR_NM FROM COM_USER X WHERE X.USR_ID = T3.PORT_CHG_AUD_RSLT_USR_ID) AS PORT_CHG_AUD_RSLT_USR_NM" ).append("\n"); 
		query.append("        , T1.PAY_TERM_DYS" ).append("\n"); 
		query.append("        , T1.CSR_NO" ).append("\n"); 
		query.append("        , REPLACE(T1.PAY_DUE_DT, '-', '') PAY_DUE_DT" ).append("\n"); 
		query.append("        , T1.AP_PAY_DT" ).append("\n"); 
		query.append("        , T1.DIS_INV_OFC_CD" ).append("\n"); 
		query.append("        , TO_CHAR(T1.UPD_DT,'YYYY-MM-DD') UPD_DT" ).append("\n"); 
		query.append("        , T3.ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("        , T3.EXPN_AUD_RSLT_CD" ).append("\n"); 
		query.append("        , TO_CHAR(T1.INV_CFM_DT, 'YYYYMMDD HH24:MI:SS') INV_CFM_DT" ).append("\n"); 
		query.append("        , CASE WHEN (T3.ISS_CTY_CD IS NOT NULL AND T3.SO_SEQ IS NOT NULL AND T3.SO_DTL_SEQ IS NOT NULL) THEN 'Y' ELSE 'N' END AUD_RLST_FLG -- 기존 심사 자료가 있는지 확인" ).append("\n"); 
		query.append("        , CASE WHEN T3.EAC_NO IS NOT NULL THEN 'I' END EAC_IF_FLG --기존에 EAC_NO가 있는지 확인" ).append("\n"); 
		query.append("FROM    TB_SRC              T1," ).append("\n"); 
		query.append("        EAS_PORT_SO_CFM_INV T3," ).append("\n"); 
		query.append("        TB_VVD_TIER         T4" ).append("\n"); 
		query.append("WHERE   T1.ISS_CTY_CD       = T3.ISS_CTY_CD     (+)" ).append("\n"); 
		query.append("AND     T1.SO_SEQ           = T3.SO_SEQ         (+)" ).append("\n"); 
		query.append("AND     T1.SO_DTL_SEQ       = T3.SO_DTL_SEQ     (+)" ).append("\n"); 
		query.append("AND     T1.VSL_CD           = T4.VSL_CD         (+) " ).append("\n"); 
		query.append("AND     T1.SKD_VOY_NO       = T4.VOY_NO         (+)" ).append("\n"); 
		query.append("AND     T1.SKD_DIR_CD       = T4.DIR_CD         (+)" ).append("\n"); 
		query.append("AND     SUBSTR(T1.YD_CD,1,5)= T4.PORT_CD        (+)" ).append("\n"); 

	}
}