/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesMarineStorageDetailCostByDayRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TesAdvanceAuditDBDAOTesMarineStorageDetailCostByDayRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesMarineStorageDetailCostByDay
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesMarineStorageDetailCostByDayRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesMarineStorageDetailCostByDayRSQL").append("\n"); 
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
		query.append("SELECT CALC_TP_CD" ).append("\n"); 
		query.append("  , LGS_COST_CD" ).append("\n"); 
		query.append("  , (SELECT LGS_COST_FULL_NM  FROM TES_LGS_COST WHERE LGS_COST_CD = X.LGS_COST_CD) AS LGS_COST_FULL_NM " ).append("\n"); 
		query.append("  , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  , DCGO_IND_FLG" ).append("\n"); 
		query.append("  , CNTR_VOL" ).append("\n"); 
		query.append("  , REV_YRMON" ).append("\n"); 
		query.append("  , BKG_GET_TOKEN_FNC(TES_INV_DYS,1) STAY_DYS" ).append("\n"); 
		query.append("  , BKG_GET_TOKEN_FNC(TES_INV_DYS,2) FREE_DYS" ).append("\n"); 
		query.append("  , PAY_DYS" ).append("\n"); 
		query.append("  , FREE_DY_XCLD_DYS" ).append("\n"); 
		query.append("  , OVR_DYS" ).append("\n"); 
		query.append("  , VOL_TR_UT_CD" ).append("\n"); 
		query.append("  , CTRT_RT" ).append("\n"); 
		query.append("  , CURR_CD" ).append("\n"); 
		query.append("  , INV_XCH_RT" ).append("\n"); 
		query.append("  , INV_AMT" ).append("\n"); 
		query.append("  , CALC_AMT" ).append("\n"); 
		query.append("  , CALC_RMK" ).append("\n"); 
		query.append("  , YD_CD" ).append("\n"); 
		query.append("  , YD_NM" ).append("\n"); 
		query.append("  , INV_NO" ).append("\n"); 
		query.append("  , VNDR_SEQ" ).append("\n"); 
		query.append("  , VNDR_NM" ).append("\n"); 
		query.append("  , TML_INV_TP_CD" ).append("\n"); 
		query.append("  , INV_CFM_DT" ).append("\n"); 
		query.append("  , FM_PRD_DT" ).append("\n"); 
		query.append("  , TO_PRD_DT" ).append("\n"); 
		query.append("  , INV_OFC_CD" ).append("\n"); 
		query.append("  , STO_CNTR_SZ_NM" ).append("\n"); 
		query.append("  , AGMT_NO" ).append("\n"); 
		query.append("  , AGMT_VER_NO  " ).append("\n"); 
		query.append("  , TOT_VOL" ).append("\n"); 
		query.append("  , TOT_QTY" ).append("\n"); 
		query.append("  , TOT_AMT" ).append("\n"); 
		query.append("  ,(TOT_VOL/DECODE(TOT_QTY, 0,1,TOT_QTY)) AS TOT_TERM_TIME" ).append("\n"); 
		query.append("  , DECODE(CALC_TP_CD, 'A', CTRT_RT, ROUND(TOT_AMT / TOT_VOL, 2)) AS AVG_RT" ).append("\n"); 
		query.append("  , ESTM_VOL" ).append("\n"); 
		query.append("  , ESTM_QTY" ).append("\n"); 
		query.append("  , (ESTM_VOL/DECODE(ESTM_QTY, 0,1,ESTM_QTY)) AS ESTM_TERM_TIME" ).append("\n"); 
		query.append("	-- CHM-201642319 Estimation Amount에 Exch. Rate 적용 (2016-07-07)" ).append("\n"); 
		query.append("  , (DECODE(CALC_TP_CD ,'A', CTRT_RT, ROUND(TOT_AMT / TOT_VOL, 2)) * NVL(INV_XCH_RT, 1) * ESTM_VOL) AS ESTM_AMT" ).append("\n"); 
		query.append("  , CASE WHEN EXPN_MAX_PRMT_RTO < ((INV_AMT - (DECODE(CALC_TP_CD ,'A', CTRT_RT, ROUND(TOT_AMT / TOT_VOL, 2)) * NVL(INV_XCH_RT, 1) * ESTM_VOL)) / DECODE((DECODE(CALC_TP_CD ,'A', CTRT_RT, ROUND(TOT_AMT / TOT_VOL, 2)) * NVL(INV_XCH_RT, 1) * ESTM_VOL), 0, 1, (DECODE(CALC_TP_CD ,'A', CTRT_RT, ROUND(TOT_AMT / TOT_VOL, 2)) * NVL(INV_XCH_RT, 1) * ESTM_VOL))) * 100" ).append("\n"); 
		query.append("         THEN 'Y'" ).append("\n"); 
		query.append("    END EXCEED_AVG_FLG" ).append("\n"); 
		query.append("  , DSCR_CTNT" ).append("\n"); 
		query.append("  , EAC_FLG" ).append("\n"); 
		query.append("  , EXPN_AUD_SEQ" ).append("\n"); 
		query.append("  , TML_CALC_IND_CD" ).append("\n"); 
		query.append("  , STO_DYS_IND_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT CALC_TP_CD" ).append("\n"); 
		query.append("             , LGS_COST_CD" ).append("\n"); 
		query.append("             , CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             , CNTR_TPSZ_CD AS STO_CNTR_SZ_NM" ).append("\n"); 
		query.append("             , DCGO_IND_FLG" ).append("\n"); 
		query.append("             , CNTR_VOL" ).append("\n"); 
		query.append("             , REV_YRMON" ).append("\n"); 
		query.append("             , STAY_DYS" ).append("\n"); 
		query.append("             , FREE_DYS" ).append("\n"); 
		query.append("             , PAY_DYS" ).append("\n"); 
		query.append("             , FREE_DY_XCLD_DYS" ).append("\n"); 
		query.append("             , OVR_DYS" ).append("\n"); 
		query.append("             , VOL_TR_UT_CD" ).append("\n"); 
		query.append("             , CTRT_RT" ).append("\n"); 
		query.append("             , CURR_CD" ).append("\n"); 
		query.append("             , INV_XCH_RT" ).append("\n"); 
		query.append("             , INV_AMT" ).append("\n"); 
		query.append("             , CALC_AMT" ).append("\n"); 
		query.append("             , CALC_RMK" ).append("\n"); 
		query.append("             , EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("             , YD_CD" ).append("\n"); 
		query.append("             , INV_NO" ).append("\n"); 
		query.append("             , INV_CFM_DT" ).append("\n"); 
		query.append("             , INV_OFC_CD" ).append("\n"); 
		query.append("             , VNDR_SEQ" ).append("\n"); 
		query.append("             , (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.YD_CD) AS YD_NM" ).append("\n"); 
		query.append("             , (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append("             , FM_PRD_DT" ).append("\n"); 
		query.append("             , TO_PRD_DT" ).append("\n"); 
		query.append("             , A.TML_INV_TP_CD" ).append("\n"); 
		query.append("             , A.TML_CALC_IND_CD" ).append("\n"); 
		query.append("             , A.STO_DYS_IND_CD" ).append("\n"); 
		query.append("             , A.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("             , A.TML_AGMT_OFC_CTY_CD || LPAD(A.TML_AGMT_SEQ, 5, '0') AS AGMT_NO" ).append("\n"); 
		query.append("             , SUBSTR(LPAD(A.TML_AGMT_VER_NO, 4, '0'), 0, 2 ) || '.' || SUBSTR(LPAD(A.TML_AGMT_VER_NO, 4, '0'), 3, 2 ) AS AGMT_VER_NO" ).append("\n"); 
		query.append("             , (SELECT SUM(CASE WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_DYS" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_DYS" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_DYS" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_DYS" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = 'ALL' THEN X.OVR_DYS" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_QTY" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_QTY" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_QTY" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_QTY" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = 'ALL' THEN X.CNTR_OVR_QTY" ).append("\n"); 
		query.append("                           END)" ).append("\n"); 
		query.append("                  FROM EAS_TML_STO_TTL_QTY X" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                  AND X.TML_AUD_YRMON       = A.PRD_YM" ).append("\n"); 
		query.append("                  AND X.YD_CD       = A.YD_CD" ).append("\n"); 
		query.append("                  AND X.FULL_MTY_CD     = A.CNTR_STY_CD" ).append("\n"); 
		query.append("                  AND CASE WHEN A.STO_DYS_IND_CD = 'IO' THEN 'O'" ).append("\n"); 
		query.append("                           WHEN A.STO_DYS_IND_CD = 'DT' THEN 'A'" ).append("\n"); 
		query.append("                      END =" ).append("\n"); 
		query.append("                      CASE WHEN A.STO_DYS_IND_CD = 'IO' THEN X.STO_AUD_QTY_CLSS_CD" ).append("\n"); 
		query.append("                           WHEN A.STO_DYS_IND_CD = 'DT' AND X.STO_AUD_QTY_CLSS_CD IN ('T', 'I') THEN 'A'" ).append("\n"); 
		query.append("                      END" ).append("\n"); 
		query.append("                  AND NVL(X.DCGO_FLG, 'N') = NVL(A.DCGO_IND_FLG, 'N')" ).append("\n"); 
		query.append("              ) AS TOT_VOL" ).append("\n"); 
		query.append("             , NVL((SELECT SUM(CASE WHEN A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_QTY" ).append("\n"); 
		query.append("                                    WHEN A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_QTY" ).append("\n"); 
		query.append("                                    WHEN A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_QTY" ).append("\n"); 
		query.append("                                    WHEN A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_QTY" ).append("\n"); 
		query.append("                                    WHEN A.CNTR_TPSZ_CD = 'ALL'  THEN X.CNTR_OVR_QTY" ).append("\n"); 
		query.append("                               END)" ).append("\n"); 
		query.append("                      FROM EAS_TML_STO_TTL_QTY X" ).append("\n"); 
		query.append("                     WHERE 1  = 1" ).append("\n"); 
		query.append("                       AND X.TML_AUD_YRMON       = A.PRD_YM" ).append("\n"); 
		query.append("                       AND X.YD_CD        = A.YD_CD" ).append("\n"); 
		query.append("                       AND X.FULL_MTY_CD    = A.CNTR_STY_CD" ).append("\n"); 
		query.append("                       AND CASE WHEN A.STO_DYS_IND_CD = 'IO' THEN 'O'" ).append("\n"); 
		query.append("                                WHEN A.STO_DYS_IND_CD = 'DT' THEN 'I'" ).append("\n"); 
		query.append("                           END = X.STO_AUD_QTY_CLSS_CD" ).append("\n"); 
		query.append("                       AND NVL(X.DCGO_FLG, 'N') = NVL(A.DCGO_IND_FLG, 'N')" ).append("\n"); 
		query.append("               ),0) " ).append("\n"); 
		query.append("             + NVL((SELECT SUM(CASE WHEN A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_QTY" ).append("\n"); 
		query.append("                                    WHEN A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_QTY" ).append("\n"); 
		query.append("                                    WHEN A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_QTY" ).append("\n"); 
		query.append("                                    WHEN A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_QTY" ).append("\n"); 
		query.append("                                    WHEN A.CNTR_TPSZ_CD = 'ALL'  THEN X.CNTR_OVR_QTY" ).append("\n"); 
		query.append("                               END)" ).append("\n"); 
		query.append("                      FROM EAS_TML_STO_TTL_QTY X" ).append("\n"); 
		query.append("                     WHERE 1  = 1" ).append("\n"); 
		query.append("                       AND X.TML_AUD_YRMON       = A.PRD_YM" ).append("\n"); 
		query.append("                       AND X.YD_CD        = A.YD_CD" ).append("\n"); 
		query.append("                       AND X.FULL_MTY_CD    = A.CNTR_STY_CD" ).append("\n"); 
		query.append("                       AND X.STO_AUD_QTY_CLSS_CD = 'T'" ).append("\n"); 
		query.append("                       AND A.STO_DYS_IND_CD = 'DT'" ).append("\n"); 
		query.append("                       AND NVL(X.DCGO_FLG, 'N') = NVL(A.DCGO_IND_FLG, 'N')" ).append("\n"); 
		query.append("               ),0)        " ).append("\n"); 
		query.append("               AS TOT_QTY" ).append("\n"); 
		query.append("              , (SELECT ROUND(SUM(CASE WHEN A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_DYS " ).append("\n"); 
		query.append("                                       WHEN A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_DYS " ).append("\n"); 
		query.append("                                       WHEN A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_DYS " ).append("\n"); 
		query.append("                                       WHEN A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_DYS " ).append("\n"); 
		query.append("                                       WHEN A.CNTR_TPSZ_CD = 'ALL'  THEN X.OVR_DYS " ).append("\n"); 
		query.append("                                       END)/" ).append("\n"); 
		query.append("                                       SUM(CASE WHEN A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_QTY " ).append("\n"); 
		query.append("                                       WHEN A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_QTY " ).append("\n"); 
		query.append("                                       WHEN A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_QTY " ).append("\n"); 
		query.append("                                       WHEN A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_QTY " ).append("\n"); 
		query.append("                                       WHEN A.CNTR_TPSZ_CD = 'ALL'  THEN X.CNTR_TTL_QTY " ).append("\n"); 
		query.append("                                       END),1)" ).append("\n"); 
		query.append("                   FROM EAS_TML_STO_TTL_QTY X" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                    AND X.TML_AUD_YRMON          = A.PRD_YM" ).append("\n"); 
		query.append("                    AND X.YD_CD                  = A.YD_CD" ).append("\n"); 
		query.append("                    AND X.FULL_MTY_CD            = A.CNTR_STY_CD" ).append("\n"); 
		query.append("                    AND X.STO_AUD_QTY_CLSS_CD = 'O'" ).append("\n"); 
		query.append("                    AND NVL(X.DCGO_FLG, 'N') = NVL(A.DCGO_IND_FLG, 'N')" ).append("\n"); 
		query.append("                ) AS TOT_TERM_TIME   " ).append("\n"); 
		query.append("              , (SELECT CASE WHEN CNTR_TPSZ_CD = '20FT' THEN CNTR_20FT_AMT" ).append("\n"); 
		query.append("                             WHEN CNTR_TPSZ_CD = '40FT' THEN CNTR_40FT_AMT" ).append("\n"); 
		query.append("                             WHEN CNTR_TPSZ_CD = '45FT' THEN CNTR_45FT_AMT" ).append("\n"); 
		query.append("                             WHEN CNTR_TPSZ_CD = '40HC' THEN CNTR_40FT_HC_AMT" ).append("\n"); 
		query.append("                             WHEN CNTR_TPSZ_CD = 'ALL' THEN CNTR_TTL_AMT" ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                   FROM EAS_TML_STO_TTL_AMT X" ).append("\n"); 
		query.append("                  WHERE 1 = 1" ).append("\n"); 
		query.append("                    AND X.TML_AUD_YRMON          = A.PRD_YM" ).append("\n"); 
		query.append("                    AND X.YD_CD                  = A.YD_CD" ).append("\n"); 
		query.append("                    AND X.TML_INV_TP_CD   = 'ST'" ).append("\n"); 
		query.append("                    AND X.CALC_COST_GRP_CD  = 'SD'" ).append("\n"); 
		query.append("                    AND X.LGS_COST_CD      = A.LGS_COST_CD" ).append("\n"); 
		query.append("                    AND CASE WHEN X.EXPN_AUD_CRTE_CGO_TP_CD IN ('Y', 'R') THEN 'Y' " ).append("\n"); 
		query.append("                             WHEN X.EXPN_AUD_CRTE_CGO_TP_CD = 'D' THEN 'D' " ).append("\n"); 
		query.append("                        END" ).append("\n"); 
		query.append("                      = CASE WHEN A.DCGO_IND_FLG = 'Y' THEN 'D' ELSE 'Y' END" ).append("\n"); 
		query.append("                    AND X.CURR_CD    = A.CURR_CD" ).append("\n"); 
		query.append("                 ) TOT_AMT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               , (SELECT SUM(CASE WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_DYS" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_DYS" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_DYS" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_DYS" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'IO' AND A.CNTR_TPSZ_CD = 'ALL' THEN X.OVR_DYS" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_QTY" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_QTY" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_QTY" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_QTY" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'DT' AND A.CNTR_TPSZ_CD = 'ALL' THEN X.CNTR_OVR_QTY" ).append("\n"); 
		query.append("                            END)" ).append("\n"); 
		query.append("                    FROM EAS_TML_STO_YD_DLY_QTY X" ).append("\n"); 
		query.append("                   WHERE 1 = 1" ).append("\n"); 
		query.append("                     AND X.YD_CD       = A.YD_CD" ).append("\n"); 
		query.append("                     AND X.FULL_MTY_CD     = A.CNTR_STY_CD" ).append("\n"); 
		query.append("                     AND CASE WHEN A.STO_DYS_IND_CD = 'IO' THEN 'O'" ).append("\n"); 
		query.append("                             WHEN A.STO_DYS_IND_CD  = 'DT' THEN 'A'" ).append("\n"); 
		query.append("                         END =" ).append("\n"); 
		query.append("                          CASE WHEN A.STO_DYS_IND_CD = 'IO' THEN X.STO_AUD_QTY_CLSS_CD" ).append("\n"); 
		query.append("                               WHEN A.STO_DYS_IND_CD = 'DT' AND X.STO_AUD_QTY_CLSS_CD IN ('T', 'I') THEN 'A'" ).append("\n"); 
		query.append("                          END" ).append("\n"); 
		query.append("                     AND NVL(X.DCGO_FLG, 'N') = NVL(A.DCGO_IND_FLG, 'N')" ).append("\n"); 
		query.append("                     AND X.CNMV_DT BETWEEN A.FM_PRD_DT AND A.TO_PRD_DT" ).append("\n"); 
		query.append("                 ) - NVL(FREE_DY_XCLD_DYS,0) AS ESTM_VOL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("               , NVL((SELECT SUM(CASE WHEN A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_QTY" ).append("\n"); 
		query.append("                                      WHEN A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_QTY" ).append("\n"); 
		query.append("                                      WHEN A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_QTY" ).append("\n"); 
		query.append("                                      WHEN A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_QTY" ).append("\n"); 
		query.append("                                      WHEN A.CNTR_TPSZ_CD = 'ALL'  THEN X.CNTR_OVR_QTY" ).append("\n"); 
		query.append("                                 END)" ).append("\n"); 
		query.append("                        FROM EAS_TML_STO_YD_DLY_QTY X" ).append("\n"); 
		query.append("                       WHERE 1  = 1" ).append("\n"); 
		query.append("                         AND X.YD_CD          = A.YD_CD" ).append("\n"); 
		query.append("                         AND X.FULL_MTY_CD    = A.CNTR_STY_CD" ).append("\n"); 
		query.append("                         AND CASE WHEN A.STO_DYS_IND_CD = 'IO' THEN 'O'" ).append("\n"); 
		query.append("                                  WHEN A.STO_DYS_IND_CD = 'DT' THEN 'I'" ).append("\n"); 
		query.append("                             END = X.STO_AUD_QTY_CLSS_CD" ).append("\n"); 
		query.append("                         AND NVL(X.DCGO_FLG, 'N') = NVL(A.DCGO_IND_FLG, 'N')" ).append("\n"); 
		query.append("                         AND X.CNMV_DT BETWEEN A.FM_PRD_DT AND A.TO_PRD_DT" ).append("\n"); 
		query.append("                     ),0) " ).append("\n"); 
		query.append("               + NVL((SELECT SUM(CASE WHEN A.CNTR_TPSZ_CD = '20FT' THEN X.CNTR_20FT_OVR_QTY" ).append("\n"); 
		query.append("                                      WHEN A.CNTR_TPSZ_CD = '40FT' THEN X.CNTR_40FT_OVR_QTY" ).append("\n"); 
		query.append("                                      WHEN A.CNTR_TPSZ_CD = '45FT' THEN X.CNTR_45FT_OVR_QTY" ).append("\n"); 
		query.append("                                      WHEN A.CNTR_TPSZ_CD = '40HC' THEN X.CNTR_40FT_HC_OVR_QTY" ).append("\n"); 
		query.append("                                      WHEN A.CNTR_TPSZ_CD = 'ALL'  THEN X.CNTR_OVR_QTY" ).append("\n"); 
		query.append("                                END)" ).append("\n"); 
		query.append("                        FROM EAS_TML_STO_YD_DLY_QTY X" ).append("\n"); 
		query.append("                       WHERE 1  = 1" ).append("\n"); 
		query.append("                         AND X.YD_CD          = A.YD_CD" ).append("\n"); 
		query.append("                         AND X.FULL_MTY_CD    = A.CNTR_STY_CD" ).append("\n"); 
		query.append("                         AND X.STO_AUD_QTY_CLSS_CD = 'T'" ).append("\n"); 
		query.append("                         AND A.STO_DYS_IND_CD = 'DT'" ).append("\n"); 
		query.append("                         AND NVL(X.DCGO_FLG, 'N') = NVL(A.DCGO_IND_FLG, 'N')" ).append("\n"); 
		query.append("                         AND X.CNMV_DT BETWEEN A.FM_PRD_DT AND A.FM_PRD_DT" ).append("\n"); 
		query.append("                 ),0)        " ).append("\n"); 
		query.append("                 AS ESTM_QTY" ).append("\n"); 
		query.append("               , ( SELECT WM_CONCAT(DISTINCT X.DSCR_IND_CD)" ).append("\n"); 
		query.append("                     FROM TES_TML_SO_CNTR_LIST X" ).append("\n"); 
		query.append("                    WHERE X.TML_SO_OFC_CTY_CD = A.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                      AND X.TML_SO_SEQ         = A.TML_SO_SEQ" ).append("\n"); 
		query.append("                      AND X.CNTR_STY_CD    = A.CNTR_STY_CD" ).append("\n"); 
		query.append("                      AND NVL(X.DCGO_CLSS_CD, 'N')= NVL(A.DCGO_IND_FLG, 'N')" ).append("\n"); 
		query.append("                      AND (X.VRFY_RSLT_IND_CD = 'CO' AND X.MODI_FLG = 'Y')" ).append("\n"); 
		query.append("                 ) AS DSCR_CTNT -- VERIFY RESULT                 " ).append("\n"); 
		query.append("               , DECODE(( SELECT EAC_NO" ).append("\n"); 
		query.append("                            FROM EAS_TML_AUD E" ).append("\n"); 
		query.append("                               , EAS_TML_AUD_DTL EA" ).append("\n"); 
		query.append("                            WHERE 1 = 1" ).append("\n"); 
		query.append("                              AND E.INV_NO      = A.INV_NO" ).append("\n"); 
		query.append("                              AND E.YD_CD       = A.YD_CD" ).append("\n"); 
		query.append("                              AND E.VNDR_SEQ    = A.VNDR_SEQ" ).append("\n"); 
		query.append("                              AND E.INV_CFM_DT  = A.INV_CFM_DT" ).append("\n"); 
		query.append("                              AND E.INV_NO      = EA.INV_NO(+)" ).append("\n"); 
		query.append("                              AND E.VNDR_SEQ    = EA.VNDR_SEQ(+)" ).append("\n"); 
		query.append("                              AND E.INV_CFM_DT  = EA.INV_CFM_DT(+)" ).append("\n"); 
		query.append("                              AND E.EXPN_AUD_SEQ   = EA.EXPN_AUD_SEQ(+)" ).append("\n"); 
		query.append("                              AND A.CALC_TP_CD     = EA.CALC_TP_CD(+)" ).append("\n"); 
		query.append("                              AND A.LGS_COST_CD = EA.LGS_COST_CD(+)" ).append("\n"); 
		query.append("                              AND DECODE(NVL(A.DCGO_IND_FLG, 'N'), 'N', 'N', 'Y') = EA.DCGO_FLG(+)" ).append("\n"); 
		query.append("                              AND (CASE WHEN SUBSTR(A.CNTR_TPSZ_CD, 2, 1) IN ('2', '3') THEN '20FT'" ).append("\n"); 
		query.append("                                        WHEN SUBSTR(A.CNTR_TPSZ_CD, 2, 1) = '5' THEN '40HC'" ).append("\n"); 
		query.append("                                        WHEN SUBSTR(A.CNTR_TPSZ_CD, 2, 1) = '7' THEN '45FT'" ).append("\n"); 
		query.append("                                        WHEN SUBSTR(A.CNTR_TPSZ_CD, 2, 1) NOT IN ('2', '3', '5', '7') THEN '40FT'" ).append("\n"); 
		query.append("                                   END) = EA.STO_CNTR_SZ_NM(+)" ).append("\n"); 
		query.append("                       ), NULL, 'N', 'Y') AS EAC_FLG" ).append("\n"); 
		query.append("               , ( SELECT EXPN_AUD_SEQ" ).append("\n"); 
		query.append("                     FROM EAS_TML_AUD E" ).append("\n"); 
		query.append("                    WHERE 1    = 1" ).append("\n"); 
		query.append("                      AND E.INV_NO      = A.INV_NO" ).append("\n"); 
		query.append("                      AND E.YD_CD       = A.YD_CD" ).append("\n"); 
		query.append("                      AND E.VNDR_SEQ    = A.VNDR_SEQ" ).append("\n"); 
		query.append("                      AND E.INV_CFM_DT  = A.INV_CFM_DT" ).append("\n"); 
		query.append("                 ) AS EXPN_AUD_SEQ" ).append("\n"); 
		query.append("               , EAS_EXPN_AUD_PKG.GET_TES_DAYS_FNC(TML_SO_OFC_CTY_CD, TML_SO_SEQ, CALC_TP_CD, LGS_COST_CD, CNTR_TPSZ_CD, DCGO_IND_FLG) TES_INV_DYS" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT  DECODE(D.SEMI_AUTO_CALC_FLG, 'Y', 'S', D.CALC_TP_CD) AS CALC_TP_CD" ).append("\n"); 
		query.append("                      , D.LGS_COST_CD" ).append("\n"); 
		query.append("                      , CASE WHEN SUBSTR(D.CNTR_TPSZ_CD, 2, 1) IN ('2', '3') THEN '20FT'" ).append("\n"); 
		query.append("                             WHEN SUBSTR(D.CNTR_TPSZ_CD, 2, 1) = '5' THEN '40HC'" ).append("\n"); 
		query.append("                             WHEN SUBSTR(D.CNTR_TPSZ_CD, 2, 1) = '7' THEN '45FT'" ).append("\n"); 
		query.append("                             WHEN SUBSTR(D.CNTR_TPSZ_CD, 2, 1) NOT IN  ('2', '3', '5', '7') THEN '40FT'" ).append("\n"); 
		query.append("                             ELSE 'ALL'" ).append("\n"); 
		query.append("                        END AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                      , DECODE(NVL(D.DCGO_IND_CD, 'N'), 'N', 'N', 'Y') AS DCGO_IND_FLG" ).append("\n"); 
		query.append("                      , MAX(SC.CNTR_STY_CD) AS CNTR_STY_CD" ).append("\n"); 
		query.append("                      , COUNT(DISTINCT D.CNTR_NO) AS CNTR_VOL" ).append("\n"); 
		query.append("                      , MAX(D.REV_YRMON) AS REV_YRMON" ).append("\n"); 
		query.append("                      , SUM(D.STAY_DYS) AS STAY_DYS" ).append("\n"); 
		query.append("                      , SUM(D.FREE_DYS) AS FREE_DYS" ).append("\n"); 
		query.append("                      , SUM(D.PAY_DYS) AS PAY_DYS" ).append("\n"); 
		query.append("                      , SUM(D.FREE_DY_XCLD_DYS) AS FREE_DY_XCLD_DYS" ).append("\n"); 
		query.append("                      , SUM(D.OVR_DYS) AS OVR_DYS" ).append("\n"); 
		query.append("                      , MAX(D.VOL_TR_UT_CD) AS VOL_TR_UT_CD" ).append("\n"); 
		query.append("                      , MAX(D.CTRT_RT) AS CTRT_RT" ).append("\n"); 
		query.append("                      , MAX(H.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("                      , MAX(D.INV_XCH_RT) AS INV_XCH_RT" ).append("\n"); 
		query.append("                      , SUM(D.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("                      , SUM(D.CALC_AMT) AS CALC_AMT" ).append("\n"); 
		query.append("                      , MAX(D.CALC_RMK) AS CALC_RMK" ).append("\n"); 
		query.append("                      , MAX(AC.EXPN_MAX_PRMT_RTO) AS EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("                      , MAX(H.YD_CD) AS YD_CD" ).append("\n"); 
		query.append("                      , MAX(H.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("                      , MAX(H.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("                      , MAX(H.INV_CFM_DT) AS INV_CFM_DT" ).append("\n"); 
		query.append("                      , MAX(H.INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("                      , MAX(TO_CHAR(ADD_MONTHS(TO_DATE(AD.FM_PRD_DT, 'YYYYMMDD'),-1), 'YYYYMM')) AS PRD_YM" ).append("\n"); 
		query.append("                      , MAX(AD.FM_PRD_DT) AS FM_PRD_DT" ).append("\n"); 
		query.append("                      , MAX(AD.TO_PRD_DT) AS TO_PRD_DT" ).append("\n"); 
		query.append("                      , MAX(H.TML_INV_TP_CD) AS TML_INV_TP_CD" ).append("\n"); 
		query.append("                      , MAX(H.TML_CALC_IND_CD) AS TML_CALC_IND_CD" ).append("\n"); 
		query.append("                      , MAX(H.STO_DYS_IND_CD) AS STO_DYS_IND_CD" ).append("\n"); 
		query.append("                      , MAX(D.CALC_COST_GRP_CD ) AS CALC_COST_GRP_CD " ).append("\n"); 
		query.append("                      , MAX(H.TML_SO_OFC_CTY_CD) AS TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                      , MAX(H.TML_SO_SEQ) AS TML_SO_SEQ" ).append("\n"); 
		query.append("                      , MAX(D.TML_AGMT_OFC_CTY_CD) AS TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("                      , MAX(D.TML_AGMT_SEQ) AS TML_AGMT_SEQ" ).append("\n"); 
		query.append("                      , MAX(D.TML_AGMT_VER_NO) AS TML_AGMT_VER_NO" ).append("\n"); 
		query.append("                FROM TES_TML_SO_HDR H " ).append("\n"); 
		query.append("                      , TES_TML_SO_DTL D" ).append("\n"); 
		query.append("                      , TES_TML_SO_COST SC" ).append("\n"); 
		query.append("                      , EAS_TML_AUTO_AUD_CRTE AC" ).append("\n"); 
		query.append("                      , EAS_TML_AUD AD" ).append("\n"); 
		query.append("                WHERE 1 = 1" ).append("\n"); 
		query.append("                AND  H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                AND  H.TML_SO_SEQ  = D.TML_SO_SEQ" ).append("\n"); 
		query.append("                AND  D.LGS_COST_CD  = SC.LGS_COST_CD" ).append("\n"); 
		query.append("                AND  D.LGS_COST_CD  = AC.LGS_COST_CD" ).append("\n"); 
		query.append("                AND  AC.AUD_OFC_CD  = EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(H.INV_OFC_CD)" ).append("\n"); 
		query.append("                AND  H.INV_NO     = AD.INV_NO" ).append("\n"); 
		query.append("                AND  H.VNDR_SEQ   = AD.VNDR_SEQ" ).append("\n"); 
		query.append("                AND  H.INV_CFM_DT = AD.INV_CFM_DT" ).append("\n"); 
		query.append("                AND  SC.EAS_AUD_FLG  = 'Y'" ).append("\n"); 
		query.append("                AND  H.TML_INV_TP_CD  = 'ST'" ).append("\n"); 
		query.append("                AND  D.CALC_COST_GRP_CD = 'SD'" ).append("\n"); 
		query.append("                AND  H.YD_CD    = @[s_yd_cd]" ).append("\n"); 
		query.append("                AND  H.VNDR_SEQ = @[s_vndr_seq]" ).append("\n"); 
		query.append("                AND  H.INV_NO   = @[s_inv_no]                " ).append("\n"); 
		query.append("                GROUP BY DECODE(D.SEMI_AUTO_CALC_FLG, 'Y', 'S', D.CALC_TP_CD)" ).append("\n"); 
		query.append("                       , D.LGS_COST_CD" ).append("\n"); 
		query.append("                       , CASE WHEN SUBSTR(D.CNTR_TPSZ_CD, 2, 1) IN ('2', '3') THEN '20FT'" ).append("\n"); 
		query.append("                              WHEN SUBSTR(D.CNTR_TPSZ_CD, 2, 1) = '5' THEN '40HC'" ).append("\n"); 
		query.append("                              WHEN SUBSTR(D.CNTR_TPSZ_CD, 2, 1) = '7' THEN '45FT'" ).append("\n"); 
		query.append("                              WHEN SUBSTR(D.CNTR_TPSZ_CD, 2, 1) NOT IN  ('2', '3', '5', '7') THEN '40FT'" ).append("\n"); 
		query.append("                              ELSE 'ALL'" ).append("\n"); 
		query.append("                         END" ).append("\n"); 
		query.append("                       , DECODE(NVL(D.DCGO_IND_CD, 'N'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append("                ) A" ).append("\n"); 
		query.append("      ) X" ).append("\n"); 

	}
}