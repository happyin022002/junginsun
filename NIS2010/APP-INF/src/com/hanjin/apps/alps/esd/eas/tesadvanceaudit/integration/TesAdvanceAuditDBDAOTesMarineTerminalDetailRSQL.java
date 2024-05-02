/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOTesMarineTerminalDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
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

public class TesAdvanceAuditDBDAOTesMarineTerminalDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TesMarineTerminalDetail
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOTesMarineTerminalDetailRSQL(){
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
		params.put("s_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOTesMarineTerminalDetailRSQL").append("\n"); 
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
		query.append("SELECT    CALC_TP_CD" ).append("\n"); 
		query.append("        , LGS_COST_CD" ).append("\n"); 
		query.append("		, (SELECT LGS_COST_FULL_NM  FROM TES_LGS_COST WHERE LGS_COST_CD = X.LGS_COST_CD) AS LGS_COST_FULL_NM " ).append("\n"); 
		query.append("        , DECODE(CNTR_TPSZ_CD, 'XX', NULL, CNTR_TPSZ_CD) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , IO_BND_CD" ).append("\n"); 
		query.append("        , DG_FLG" ).append("\n"); 
		query.append("        , RC_FLG" ).append("\n"); 
		query.append("        , TML_WRK_DY_CD -- Applied date" ).append("\n"); 
		query.append("        , IOC_CD  -- IPC" ).append("\n"); 
		query.append("        , TML_TRNS_MOD_CD -- Mode" ).append("\n"); 
		query.append("        , LANE_CD" ).append("\n"); 
		query.append("        , TIER_VOL" ).append("\n"); 
		query.append("        , CALC_VOL_QTY" ).append("\n"); 
		query.append("        , RVIS_VOL_QTY" ).append("\n"); 
		query.append("        , VOL_TR_UT_CD" ).append("\n"); 
		query.append("        , CTRT_RT" ).append("\n"); 
		query.append("        , CURR_CD" ).append("\n"); 
		query.append("        , INV_XCH_RT" ).append("\n"); 
		query.append("        , INV_AMT" ).append("\n"); 
		query.append("        , CALC_RMK" ).append("\n"); 
		query.append("        , N3MON_TOT_VOL" ).append("\n"); 
		query.append("		, N3MON_TOT_INV_VOL " ).append("\n"); 
		query.append("        , N3MON_TOT_AMT" ).append("\n"); 
		query.append("		, FREQ * 100 AS FREQ" ).append("\n"); 
		query.append("        , VVD_CNT" ).append("\n"); 
		query.append("        , CTRT_RT AS AGMT_RT" ).append("\n"); 
		query.append("        , UNIT_AVG_COST" ).append("\n"); 
		query.append("		, VVD_VOL" ).append("\n"); 
		query.append("		, CASE WHEN VVD_VOL * FREQ < 1 THEN 1" ).append("\n"); 
		query.append("               WHEN VVD_VOL * FREQ IS NULL THEN 1" ).append("\n"); 
		query.append("			   ELSE ROUND(VVD_VOL * FREQ, 1)" ).append("\n"); 
		query.append("		  END AS ESTM_VOL	-- Estimation Volume" ).append("\n"); 
		query.append("        , ESTM_AMT" ).append("\n"); 
		query.append("        , CASE WHEN EXPN_MAX_PRMT_RTO < ((INV_AMT - ESTM_AMT) / DECODE(ESTM_AMT, 0, 1, ESTM_AMT)) * 100" ).append("\n"); 
		query.append("              THEN 'Y'" ).append("\n"); 
		query.append("          END EXCEED_AVG_FLG" ).append("\n"); 
		query.append("		, ROUND((INV_AMT - ESTM_AMT) / DECODE(ESTM_AMT, 0, 1, ESTM_AMT) * 100, 3) AS INV_DIFF_PCT" ).append("\n"); 
		query.append("        , VOL_DIFF_FLG      " ).append("\n"); 
		query.append("        , DSCR_CTNT" ).append("\n"); 
		query.append("        , EAC_FLG" ).append("\n"); 
		query.append("        , INV_NO" ).append("\n"); 
		query.append("        , VNDR_SEQ" ).append("\n"); 
		query.append("        , ATB_DT" ).append("\n"); 
		query.append("        , YD_CD" ).append("\n"); 
		query.append("		, INV_CFM_DT" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("		, YD_NM" ).append("\n"); 
		query.append("		, VNDR_NM" ).append("\n"); 
		query.append("		, AGMT_NO" ).append("\n"); 
		query.append("		, AGMT_VER_NO" ).append("\n"); 
		query.append("		, EXPN_AUD_SEQ" ).append("\n"); 
		query.append("        , EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT    DECODE(SEMI_AUTO_CALC_FLG, 'Y', 'S', CALC_TP_CD) AS CALC_TP_CD" ).append("\n"); 
		query.append("				, LGS_COST_CD" ).append("\n"); 
		query.append("				, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, IO_BND_CD" ).append("\n"); 
		query.append("				, DCGO_FLG AS DG_FLG" ).append("\n"); 
		query.append("				, RC_FLG" ).append("\n"); 
		query.append("				, TML_WRK_DY_CD -- Applied date" ).append("\n"); 
		query.append("				, IOC_CD  -- IPC" ).append("\n"); 
		query.append("				, TML_TRNS_MOD_CD -- Mode" ).append("\n"); 
		query.append("				, VSL_SLAN_CD AS LANE_CD" ).append("\n"); 
		query.append("				, TIER_VOL" ).append("\n"); 
		query.append("				, CALC_VOL_QTY" ).append("\n"); 
		query.append("				, RVIS_VOL_QTY" ).append("\n"); 
		query.append("				, VOL_TR_UT_CD" ).append("\n"); 
		query.append("				, CTRT_RT" ).append("\n"); 
		query.append("				, CURR_CD" ).append("\n"); 
		query.append("				, INV_XCH_RT" ).append("\n"); 
		query.append("				, INV_AMT" ).append("\n"); 
		query.append("				, CALC_RMK" ).append("\n"); 
		query.append("				, N3MON_TOT_VOL -- MVMT VOL." ).append("\n"); 
		query.append("				, TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 1)) AS N3MON_TOT_AMT -- Amount" ).append("\n"); 
		query.append("				, TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) AS N3MON_TOT_INV_VOL -- INVOICE VOL." ).append("\n"); 
		query.append("				, VVD_CNT " ).append("\n"); 
		query.append("				, CASE WHEN LGS_COST_CD  = 'SVXXHC' THEN ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 1)) / TO_NUMBER(DECODE(BKG_GET_TOKEN_FNC(N3MON_INV, 2), NULL, 1, 0, 1, BKG_GET_TOKEN_FNC(N3MON_INV, 2))), 2)" ).append("\n"); 
		query.append("					   WHEN LGS_COST_CD <> 'SVXXHC' THEN ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 1)) / TO_NUMBER(DECODE(BKG_GET_TOKEN_FNC(N3MON_INV, 2), NULL, 1, 0, 1, BKG_GET_TOKEN_FNC(N3MON_INV, 2))), 2)" ).append("\n"); 
		query.append("				  END UNIT_AVG_COST" ).append("\n"); 
		query.append("				, CASE WHEN N3MON_TOT_VOL IS NULL OR N3MON_TOT_VOL = 0 THEN 1" ).append("\n"); 
		query.append("                       WHEN VVD_VOL / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("					   WHEN TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,NULL,N3MON_TOT_VOL) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("                       WHEN (NVL(RVIS_VOL_QTY,0) - NVL(VVD_VOL,0)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) " ).append("\n"); 
		query.append("                            <= (NVL(RVIS_VOL_QTY,0) - (NVL(VVD_VOL,0)) * ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL),3)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY)" ).append("\n"); 
		query.append("                            THEN 1" ).append("\n"); 
		query.append("					   ELSE ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL), 3)" ).append("\n"); 
		query.append("				  END AS FREQ	-- FREQUENCY" ).append("\n"); 
		query.append("				, DECODE(VVD_VOL, 0, 1, NULL, 1, VVD_VOL) VVD_VOL		-- MVMT VOL." ).append("\n"); 
		query.append("				, NVL((CASE WHEN CALC_TP_CD = 'A' OR SEMI_AUTO_CALC_FLG = 'Y' THEN CTRT_RT * NVL(INV_XCH_RT, 1)" ).append("\n"); 
		query.append("                            WHEN CALC_TP_CD = 'M' AND LGS_COST_CD  = 'SVXXHC' THEN ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 1)) / DECODE(VVD_CNT, 0, 1, VVD_CNT), 2)" ).append("\n"); 
		query.append("                            WHEN CALC_TP_CD = 'M' AND LGS_COST_CD <> 'SVXXHC' THEN NVL(ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 1)) / TO_NUMBER(DECODE(BKG_GET_TOKEN_FNC(N3MON_INV, 2), '0', '1', BKG_GET_TOKEN_FNC(N3MON_INV, 2))), 2), CTRT_RT * NVL(INV_XCH_RT, 1))" ).append("\n"); 
		query.append("                       END)" ).append("\n"); 
		query.append("                   * NVL((CASE WHEN VVD_VOL * (CASE WHEN N3MON_TOT_VOL IS NULL OR N3MON_TOT_VOL = 0 THEN 1" ).append("\n"); 
		query.append("                                                    WHEN VVD_VOL / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("                                                    WHEN TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,NULL,N3MON_TOT_VOL) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("                                                    WHEN (NVL(RVIS_VOL_QTY,0) - NVL(VVD_VOL,0)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) " ).append("\n"); 
		query.append("                                                      <= (NVL(RVIS_VOL_QTY,0) - (NVL(VVD_VOL,0)) * ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL),3)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY)" ).append("\n"); 
		query.append("                                                    THEN 1" ).append("\n"); 
		query.append("                                                    ELSE ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL), 3)" ).append("\n"); 
		query.append("                                               END) < 1" ).append("\n"); 
		query.append("					           THEN 1" ).append("\n"); 
		query.append("                               ELSE ROUND(VVD_VOL * (CASE WHEN N3MON_TOT_VOL IS NULL OR N3MON_TOT_VOL = 0 THEN 1" ).append("\n"); 
		query.append("                                                          WHEN VVD_VOL / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("                                                          WHEN TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,NULL,N3MON_TOT_VOL) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("                                                          WHEN (NVL(RVIS_VOL_QTY,0) - NVL(VVD_VOL,0)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) " ).append("\n"); 
		query.append("                                                             <= (NVL(RVIS_VOL_QTY,0) - (NVL(VVD_VOL,0)) * ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL),3)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY)" ).append("\n"); 
		query.append("                                                          THEN 1" ).append("\n"); 
		query.append("                                                          ELSE ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL), 3)" ).append("\n"); 
		query.append("                                                     END), 1)" ).append("\n"); 
		query.append("						  END), 1)" ).append("\n"); 
		query.append("                  , 0) AS ESTM_AMT " ).append("\n"); 
		query.append("				, CASE WHEN CALC_VOL_QTY <> RVIS_VOL_QTY THEN 'Y' END VOL_DIFF_FLG" ).append("\n"); 
		query.append("				, EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("				, DSCR_CTNT" ).append("\n"); 
		query.append("				, EAC_FLG" ).append("\n"); 
		query.append("				, INV_NO" ).append("\n"); 
		query.append("				, VNDR_SEQ" ).append("\n"); 
		query.append("				, ATB_DT" ).append("\n"); 
		query.append("				, YD_CD" ).append("\n"); 
		query.append("				, INV_CFM_DT" ).append("\n"); 
		query.append("				, VSL_CD" ).append("\n"); 
		query.append("				, SKD_VOY_NO" ).append("\n"); 
		query.append("				, SKD_DIR_CD" ).append("\n"); 
		query.append("				, YD_NM" ).append("\n"); 
		query.append("				, VNDR_NM" ).append("\n"); 
		query.append("				, AGMT_NO" ).append("\n"); 
		query.append("				, AGMT_VER_NO" ).append("\n"); 
		query.append("				, EXPN_AUD_SEQ" ).append("\n"); 
		query.append("		FROM	(		" ).append("\n"); 
		query.append("				SELECT    A.CALC_TP_CD " ).append("\n"); 
		query.append("						, A.SEMI_AUTO_CALC_FLG" ).append("\n"); 
		query.append("						, A.LGS_COST_CD" ).append("\n"); 
		query.append("						, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("						, A.IO_BND_CD" ).append("\n"); 
		query.append("						, A.DCGO_FLG" ).append("\n"); 
		query.append("						, A.RC_FLG" ).append("\n"); 
		query.append("						, A.VSL_CD" ).append("\n"); 
		query.append("						, A.SKD_VOY_NO" ).append("\n"); 
		query.append("						, A.SKD_DIR_CD" ).append("\n"); 
		query.append("						, A.TML_WRK_DY_CD" ).append("\n"); 
		query.append("						, A.IOC_CD" ).append("\n"); 
		query.append("						, A.TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("						, A.FM_TR_VOL_VAL" ).append("\n"); 
		query.append("						, A.TO_TR_VOL_VAL" ).append("\n"); 
		query.append("						, A.CALC_VOL_QTY" ).append("\n"); 
		query.append("						, A.RVIS_VOL_QTY" ).append("\n"); 
		query.append("						, A.VOL_TR_UT_CD" ).append("\n"); 
		query.append("						, A.FM_TR_VOL_VAL || '~' || A.TO_TR_VOL_VAL AS TIER_VOL" ).append("\n"); 
		query.append("						, A.CTRT_RT" ).append("\n"); 
		query.append("						, A.CURR_CD" ).append("\n"); 
		query.append("						, A.INV_XCH_RT" ).append("\n"); 
		query.append("						, A.INV_AMT" ).append("\n"); 
		query.append("						, A.CALC_RMK" ).append("\n"); 
		query.append("						, A.YD_CD" ).append("\n"); 
		query.append("						, A.INV_NO" ).append("\n"); 
		query.append("						, A.INV_CFM_DT" ).append("\n"); 
		query.append("						, A.VNDR_SEQ" ).append("\n"); 
		query.append("						, A.ATB_DT" ).append("\n"); 
		query.append("						, A.CNTR_STY_CD" ).append("\n"); 
		query.append("						, A.TS_FLG" ).append("\n"); 
		query.append("						, A.VSL_SLAN_CD" ).append("\n"); 
		query.append("						, A.EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("						, A.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("						, A.TML_AGMT_SEQ" ).append("\n"); 
		query.append("						, A.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("						, (A.INV_AMT / DECODE(A.RVIS_VOL_QTY, 0, 1, A.RVIS_VOL_QTY)) AS INV_AVG_COST" ).append("\n"); 
		query.append("						, (SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.YD_CD) AS YD_NM" ).append("\n"); 
		query.append("						, (SELECT VNDR_LGL_ENG_NM FROM MDM_VENDOR WHERE VNDR_SEQ = A.VNDR_SEQ) AS VNDR_NM" ).append("\n"); 
		query.append("						, TML_AGMT_OFC_CTY_CD || LPAD(TML_AGMT_SEQ, 5, '0') AS AGMT_NO" ).append("\n"); 
		query.append("						, SUBSTR(LPAD(A.TML_AGMT_VER_NO, 4, '0'), 0, 2 ) || DECODE(A.TML_AGMT_VER_NO, NULL, '', '.') || SUBSTR(LPAD(A.TML_AGMT_VER_NO, 4, '0'), 3, 2 ) AS AGMT_VER_NO" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						, (SELECT X.TTL_TML_AMT ||','|| TTL_RVIS_VOL_QTY" ).append("\n"); 
		query.append("							 FROM EAS_TML_MRN_TTL_AMT X" ).append("\n"); 
		query.append("							WHERE X.TML_AUD_YRMON = TO_CHAR(ADD_MONTHS(A.ATB_DT, -1), 'YYYYMM')" ).append("\n"); 
		query.append("							  AND X.YD_CD            = A.YD_CD" ).append("\n"); 
		query.append("							  AND X.IO_BND_CD      = A.IO_BND_CD" ).append("\n"); 
		query.append("							  AND X.CNTR_TPSZ_CD  = (CASE WHEN A.CNTR_STY_CD = 'F' AND SUBSTR(A.CNTR_TPSZ_CD ,1,1) = 'R' AND NVL(A.RC_FLG, 'N') = 'N' THEN 'D'||SUBSTR(A.CNTR_TPSZ_CD ,2,1) ELSE A.CNTR_TPSZ_CD END)" ).append("\n"); 
		query.append("							  AND X.LGS_COST_CD    = A.LGS_COST_CD" ).append("\n"); 
		query.append("							  AND X.CURR_CD         = A.CURR_CD" ).append("\n"); 
		query.append("							  AND X.DCGO_FLG        = A.DCGO_FLG" ).append("\n"); 
		query.append("							  AND X.RC_FLG            = A.RC_FLG" ).append("\n"); 
		query.append("							  AND X.COM_VVD_FLG   = A.COM_VVD_FLG" ).append("\n"); 
		query.append("						 ) N3MON_INV" ).append("\n"); 
		query.append("							" ).append("\n"); 
		query.append("						, (SELECT SUM((CASE WHEN A.SPCL_CGO_TP_CALC_CD = 'DG' THEN DCGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'RF' THEN RC_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'AK' THEN AWK_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'BB' THEN BB_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'BA' THEN AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'GH' THEN HNGR_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'CF' THEN CFS_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.DCGO_FLG = 'Y' AND NVL(A.RC_FLG,'N') = 'Y' THEN DG_RC_QTY" ).append("\n"); 
		query.append("										  WHEN A.DCGO_FLG = 'Y' AND NVL(A.RC_FLG,'N') = 'N' THEN DCGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.DCGO_FLG = 'N' AND NVL(A.RC_FLG,'N') = 'Y' THEN RC_QTY" ).append("\n"); 
		query.append("										  ELSE (CASE WHEN CNTR_TTL_QTY - NVL(DCGO_QTY,0) - NVL(RC_QTY,0) - NVL(DG_RC_QTY,0) < 0 THEN 0" ).append("\n"); 
		query.append("													 ELSE CNTR_TTL_QTY - NVL(DCGO_QTY,0) - NVL(RC_QTY,0) - NVL(DG_RC_QTY,0)" ).append("\n"); 
		query.append("												END)" ).append("\n"); 
		query.append("									END))" ).append("\n"); 
		query.append("							   FROM EAS_TML_MRN_TTL_QTY X" ).append("\n"); 
		query.append("							  WHERE X.TML_AUD_YRMON = TO_CHAR(ADD_MONTHS(A.ATB_DT, -1), 'YYYYMM')" ).append("\n"); 
		query.append("								AND X.YD_CD        = A.YD_CD" ).append("\n"); 
		query.append("								AND X.CNTR_TPSZ_CD = (CASE WHEN A.CNTR_STY_CD = 'F' AND SUBSTR(A.CNTR_TPSZ_CD ,1,1) = 'R' AND NVL(A.RC_FLG, 'N') = 'N' THEN 'D'||SUBSTR(A.CNTR_TPSZ_CD ,2,1) ELSE NVL(A.CNTR_TPSZ_CD, 'XX') END)" ).append("\n"); 
		query.append("								AND X.IO_BND_CD    = A.IO_BND_CD" ).append("\n"); 
		query.append("								AND X.FULL_MTY_CD  = A.CNTR_STY_CD" ).append("\n"); 
		query.append("								AND X.TS_FLG       LIKE (CASE WHEN A.TS_FLG IN ('Y', 'N') THEN A.TS_FLG ELSE '%' END)" ).append("\n"); 
		query.append("								AND X.COM_VVD_FLG  = A.COM_VVD_FLG " ).append("\n"); 
		query.append("							) N3MON_TOT_VOL" ).append("\n"); 
		query.append("						  , NVL((SELECT SUM((CASE WHEN A.SPCL_CGO_TP_CALC_CD = 'DG' THEN DCGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'RF' THEN RC_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'AK' THEN AWK_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'BB' THEN BB_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'BA' THEN AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'GH' THEN HNGR_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.SPCL_CGO_TP_CALC_CD = 'CF' THEN CFS_CGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.DCGO_FLG = 'Y' AND NVL(A.RC_FLG,'N') = 'Y' THEN DG_RC_QTY" ).append("\n"); 
		query.append("										  WHEN A.DCGO_FLG = 'Y' AND NVL(A.RC_FLG,'N') = 'N' THEN DCGO_QTY" ).append("\n"); 
		query.append("										  WHEN A.DCGO_FLG = 'N' AND NVL(A.RC_FLG,'N') = 'Y' THEN RC_QTY" ).append("\n"); 
		query.append("										  ELSE (CASE WHEN CNTR_TTL_QTY - NVL(DCGO_QTY,0) - NVL(RC_QTY,0) - NVL(DG_RC_QTY,0) < 0 THEN 0" ).append("\n"); 
		query.append("													 ELSE CNTR_TTL_QTY - NVL(DCGO_QTY,0) - NVL(RC_QTY,0) - NVL(DG_RC_QTY,0)" ).append("\n"); 
		query.append("												END)" ).append("\n"); 
		query.append("									END))" ).append("\n"); 
		query.append("							   FROM EAS_TML_MRN_VVD_QTY X" ).append("\n"); 
		query.append("							  WHERE X.YD_CD        = A.YD_CD" ).append("\n"); 
		query.append("								AND X.CNTR_TPSZ_CD = NVL(A.CNTR_TPSZ_CD, 'XX')" ).append("\n"); 
		query.append("								AND X.IO_BND_CD    = A.IO_BND_CD" ).append("\n"); 
		query.append("								AND X.FULL_MTY_CD  = A.CNTR_STY_CD" ).append("\n"); 
		query.append("								AND X.TS_FLG       LIKE (CASE WHEN A.TS_FLG IN ('Y', 'N') THEN A.TS_FLG ELSE '%' END)" ).append("\n"); 
		query.append("								AND X.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("								AND X.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("								AND X.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("							), 0) VVD_VOL            " ).append("\n"); 
		query.append("						  , (SELECT COUNT(DISTINCT X.VSL_CD||X.SKD_VOY_NO)" ).append("\n"); 
		query.append("							   FROM EAS_TML_MRN_VVD_CD X" ).append("\n"); 
		query.append("							  WHERE X.TML_AUD_YRMON = TO_CHAR(ADD_MONTHS(A.ATB_DT, -1), 'YYYYMM')" ).append("\n"); 
		query.append("								AND X.YD_CD         = A.YD_CD" ).append("\n"); 
		query.append("								AND X.VSL_SLAN_CD   = A.VSL_SLAN_CD" ).append("\n"); 
		query.append("								AND X.CNTR_STY_CD   = A.CNTR_STY_CD" ).append("\n"); 
		query.append("							) VVD_CNT" ).append("\n"); 
		query.append("						  , (SELECT WM_CONCAT(DISTINCT DSCR_IND_CD)  -- DSCR_IND_CD" ).append("\n"); 
		query.append("							   FROM TES_TML_SO_CNTR_LIST X" ).append("\n"); 
		query.append("							  WHERE X.TML_SO_OFC_CTY_CD = A.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("								AND X.TML_SO_SEQ        = A.TML_SO_SEQ" ).append("\n"); 
		query.append("								AND X.VSL_CD            = A.VSL_CD" ).append("\n"); 
		query.append("								AND X.SKD_VOY_NO        = A.SKD_VOY_NO" ).append("\n"); 
		query.append("								AND X.SKD_DIR_CD        = A.SKD_DIR_CD" ).append("\n"); 
		query.append("								AND X.IO_BND_CD         = A.IO_BND_CD" ).append("\n"); 
		query.append("								AND X.CNTR_TPSZ_CD      = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("								AND X.CNTR_STY_CD       = A.CNTR_STY_CD" ).append("\n"); 
		query.append("								AND X.LOCL_TS_IND_CD    LIKE DECODE(A.TS_FLG, 'Y', 'T', 'N', 'L', '%')" ).append("\n"); 
		query.append("								AND X.RC_FLG            = A.RC_FLG" ).append("\n"); 
		query.append("								AND X.DCGO_CLSS_CD      = A.DCGO_FLG" ).append("\n"); 
		query.append("								AND (VRFY_RSLT_IND_CD = 'CO' AND MODI_FLG = 'Y')" ).append("\n"); 
		query.append("                                AND A.CALC_TP_CD = 'A'" ).append("\n"); 
		query.append("							 ) DSCR_CTNT" ).append("\n"); 
		query.append("						, ( SELECT DECODE(EAC_NO, NULL, 'N', 'Y')" ).append("\n"); 
		query.append("							FROM   EAS_TML_AUD E" ).append("\n"); 
		query.append("								, EAS_TML_AUD_DTL EA" ).append("\n"); 
		query.append("							WHERE  1 = 1" ).append("\n"); 
		query.append("							AND    E.INV_NO       = A.INV_NO" ).append("\n"); 
		query.append("							AND    E.YD_CD        = A.YD_CD" ).append("\n"); 
		query.append("							AND    E.VNDR_SEQ     = A.VNDR_SEQ" ).append("\n"); 
		query.append("							AND    E.INV_CFM_DT   = A.INV_CFM_DT" ).append("\n"); 
		query.append("							AND    E.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("							AND    E.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND    E.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND    E.IO_BND_CD    = A.IO_BND_CD" ).append("\n"); 
		query.append("							AND    E.INV_NO       = EA.INV_NO(+)" ).append("\n"); 
		query.append("							AND    E.VNDR_SEQ     = EA.VNDR_SEQ(+)" ).append("\n"); 
		query.append("							AND    E.INV_CFM_DT   = EA.INV_CFM_DT(+)" ).append("\n"); 
		query.append("							AND    E.EXPN_AUD_SEQ = EA.EXPN_AUD_SEQ(+)" ).append("\n"); 
		query.append("							AND    A.CALC_TP_CD   = EA.CALC_TP_CD(+)" ).append("\n"); 
		query.append("							AND    A.LGS_COST_CD  = EA.LGS_COST_CD(+)" ).append("\n"); 
		query.append("							AND    A.CNTR_TPSZ_CD = EA.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("							AND    A.IO_BND_CD    = EA.IO_BND_CD(+)" ).append("\n"); 
		query.append("							AND    A.DCGO_FLG     = EA.DCGO_FLG(+)" ).append("\n"); 
		query.append("							AND    A.RC_FLG	      = EA.RC_FLG(+)" ).append("\n"); 
		query.append("						  ) AS EAC_FLG" ).append("\n"); 
		query.append("						, ( SELECT	EXPN_AUD_SEQ" ).append("\n"); 
		query.append("							FROM	EAS_TML_AUD E" ).append("\n"); 
		query.append("							WHERE  1    = 1" ).append("\n"); 
		query.append("							AND    E.INV_NO       = A.INV_NO" ).append("\n"); 
		query.append("							AND    E.YD_CD        = A.YD_CD" ).append("\n"); 
		query.append("							AND    E.VNDR_SEQ     = A.VNDR_SEQ" ).append("\n"); 
		query.append("							AND    E.VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("							AND    E.SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND    E.SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND    E.IO_BND_CD    = A.IO_BND_CD" ).append("\n"); 
		query.append("							AND    E.INV_CFM_DT   = A.INV_CFM_DT" ).append("\n"); 
		query.append("						  ) AS EXPN_AUD_SEQ" ).append("\n"); 
		query.append("				 " ).append("\n"); 
		query.append("				FROM	(" ).append("\n"); 
		query.append("						SELECT    D.CALC_TP_CD" ).append("\n"); 
		query.append("								, D.LGS_COST_CD" ).append("\n"); 
		query.append("								, NVL(D.CNTR_TPSZ_CD,'XX') AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("								, D.IO_BND_CD" ).append("\n"); 
		query.append("								, MAX(D.SEMI_AUTO_CALC_FLG) AS SEMI_AUTO_CALC_FLG" ).append("\n"); 
		query.append("								, DECODE(D.DCGO_IND_CD, NULL, 'N', 'N', 'N', 'Y') DCGO_FLG" ).append("\n"); 
		query.append("								, NVL(D.RC_FLG, 'N') AS RC_FLG" ).append("\n"); 
		query.append("								, MAX(D.VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("								, MAX(D.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("								, MAX(D.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("								, MAX(D.TML_WRK_DY_CD) AS TML_WRK_DY_CD" ).append("\n"); 
		query.append("								, MAX(D.IOC_CD) AS IOC_CD" ).append("\n"); 
		query.append("								, MAX(D.TML_TRNS_MOD_CD) AS TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("								, MIN(D.FM_TR_VOL_VAL) AS FM_TR_VOL_VAL" ).append("\n"); 
		query.append("								, MAX(D.TO_TR_VOL_VAL) AS TO_TR_VOL_VAL" ).append("\n"); 
		query.append("								, SUM(D.CALC_VOL_QTY) AS CALC_VOL_QTY" ).append("\n"); 
		query.append("								, SUM(D.RVIS_VOL_QTY) AS RVIS_VOL_QTY" ).append("\n"); 
		query.append("								, MAX(D.VOL_TR_UT_CD) AS VOL_TR_UT_CD" ).append("\n"); 
		query.append("								, MAX(D.CTRT_RT) AS CTRT_RT" ).append("\n"); 
		query.append("								, MAX(H.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("								, MAX(D.INV_XCH_RT) AS INV_XCH_RT" ).append("\n"); 
		query.append("								, SUM(D.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("								, MAX(D.CALC_RMK) AS CALC_RMK" ).append("\n"); 
		query.append("								, MAX(H.YD_CD) AS YD_CD" ).append("\n"); 
		query.append("								, MAX(H.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("								, MAX(H.INV_CFM_DT) AS INV_CFM_DT" ).append("\n"); 
		query.append("								, MAX(H.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("								, MAX(D.ATB_DT) AS ATB_DT" ).append("\n"); 
		query.append("								, MAX(A.SPCL_CGO_TP_CALC_CD) AS SPCL_CGO_TP_CALC_CD" ).append("\n"); 
		query.append("								, MAX(NVL(A.TS_FLG, 'A')) AS TS_FLG" ).append("\n"); 
		query.append("                                , (CASE WHEN MAX(A.EXPN_AUD_TGT_FLG) = 'N' THEN NULL ELSE MAX(A.EXPN_MAX_PRMT_RTO) END) AS EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("								, MAX(B.CNTR_STY_CD) AS CNTR_STY_CD" ).append("\n"); 
		query.append("								, MAX(C.VSL_SLAN_CD) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("								, MAX(H.TML_SO_OFC_CTY_CD) AS TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("								, MAX(H.TML_SO_SEQ) AS TML_SO_SEQ" ).append("\n"); 
		query.append("								, MAX(D.TML_AGMT_OFC_CTY_CD) AS TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("								, MAX(D.TML_AGMT_SEQ) AS TML_AGMT_SEQ	" ).append("\n"); 
		query.append("								, MAX(D.TML_AGMT_VER_NO) AS TML_AGMT_VER_NO" ).append("\n"); 
		query.append("								, (CASE WHEN MAX(D.VSL_CD) = 'CNTC' THEN 'Y' ELSE 'N' END) AS COM_VVD_FLG" ).append("\n"); 
		query.append("						FROM (SELECT EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(X.INV_OFC_CD) RHQ_OFC_CD" ).append("\n"); 
		query.append("								   , X.*" ).append("\n"); 
		query.append("								FROM TES_TML_SO_HDR X" ).append("\n"); 
		query.append("							 ) H" ).append("\n"); 
		query.append("						   , TES_TML_SO_DTL D" ).append("\n"); 
		query.append("						   , EAS_TML_AUTO_AUD_CRTE A" ).append("\n"); 
		query.append("						   , TES_TML_SO_COST B" ).append("\n"); 
		query.append("						   , VSK_VSL_SKD     C" ).append("\n"); 
		query.append("						WHERE 1 = 1" ).append("\n"); 
		query.append("						AND  H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("						AND  H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("						AND  H.RHQ_OFC_CD = A.AUD_OFC_CD" ).append("\n"); 
		query.append("						AND  D.LGS_COST_CD = A.LGS_COST_CD" ).append("\n"); 
		query.append("						AND  D.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("						AND  D.VSL_CD     = C.VSL_CD(+)" ).append("\n"); 
		query.append("						AND  D.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("						AND  D.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("						AND  NVL(H.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("						AND  H.TML_INV_STS_CD <> 'R'" ).append("\n"); 
		query.append("						AND  H.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("						AND  H.YD_CD      = @[s_yd_cd]" ).append("\n"); 
		query.append("						AND  H.VNDR_SEQ   = @[s_vndr_seq]" ).append("\n"); 
		query.append("						AND  H.INV_NO     = @[s_inv_no]" ).append("\n"); 
		query.append("						AND  D.VSL_CD     = SUBSTR(@[s_vvd], 1, 4)" ).append("\n"); 
		query.append("						AND  D.SKD_VOY_NO = SUBSTR(@[s_vvd], 5, 4)" ).append("\n"); 
		query.append("						AND  D.SKD_DIR_CD = SUBSTR(@[s_vvd], 9, 1)" ).append("\n"); 
		query.append("						AND  D.IO_BND_CD  = @[s_io_bnd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						GROUP BY D.CALC_TP_CD " ).append("\n"); 
		query.append("							  , D.LGS_COST_CD" ).append("\n"); 
		query.append("							  , NVL(D.CNTR_TPSZ_CD,'XX')" ).append("\n"); 
		query.append("							  , D.IO_BND_CD" ).append("\n"); 
		query.append("							  , DECODE(D.DCGO_IND_CD, NULL, 'N', 'N', 'N', 'Y')" ).append("\n"); 
		query.append("							  , D.RC_FLG" ).append("\n"); 
		query.append("						) A" ).append("\n"); 
		query.append("				) Z" ).append("\n"); 
		query.append("		) X" ).append("\n"); 

	}
}