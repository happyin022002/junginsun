/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOSearchMrInvAudRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.07 
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

public class TesAdvanceAuditDBDAOSearchMrInvAudRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Mr Invoice를 심사한다.
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOSearchMrInvAudRSQL(){
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOSearchMrInvAudRSQL").append("\n"); 
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
		query.append("SELECT	  INV_NO" ).append("\n"); 
		query.append("		, VNDR_SEQ" ).append("\n"); 
		query.append("		, VSL_CD" ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, IO_BND_CD" ).append("\n"); 
		query.append("		, TO_CHAR(MAX(INV_CFM_DT), 'YYYYMMDDHH24MISS') AS INV_CFM_DT" ).append("\n"); 
		query.append("		, TO_CHAR(MAX(ATB_DT), 'YYYYMMDDHH24MISS') AS ATB_DT" ).append("\n"); 
		query.append("		, MAX(TML_INV_TP_CD) AS TML_INV_TP_CD" ).append("\n"); 
		query.append("		, MAX(YD_CD) AS YD_CD" ).append("\n"); 
		query.append("		, TO_CHAR(MAX(ISS_DT), 'YYYYMMDDHH24MISS') AS ISS_DT" ).append("\n"); 
		query.append("		, MAX(RHQ_OFC_CD) AS RHQ_CD" ).append("\n"); 
		query.append("		, MAX(INV_OFC_CD) AS INV_OFC_CD " ).append("\n"); 
		query.append("		, MAX(COST_OFC_CD) AS COST_OFC_CD" ).append("\n"); 
		query.append("		, MAX(CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("		, SUM(INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("		, SUM(EXPN_AUD_ESTM_AMT) AS EXPN_AUD_ESTM_AMT		     " ).append("\n"); 
		query.append("		, COUNT(DISTINCT ERR_LGS_COST_CD) AS AUD_LGS_COST_CD_QTY" ).append("\n"); 
		query.append("		, CASE WHEN MIN(AMT_AUTO_AUD_CD) = 'C' THEN 'Y' END AS AMT_AUD_TGT_FLG" ).append("\n"); 
		query.append("		, (CASE WHEN MIN(CALC_TP_CD) = 'A' AND WM_CONCAT(AAAAA.VRFY_RSLT_CD_CTNT) IS NOT NULL " ).append("\n"); 
		query.append("                     THEN (SELECT WM_CONCAT(DISTINCT X.DSCR_IND_CD)" ).append("\n"); 
		query.append("                     		FROM TES_TML_SO_CNTR_LIST X" ).append("\n"); 
		query.append("                     		WHERE X.TML_SO_OFC_CTY_CD	= AAAAA.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("                     		AND X.TML_SO_SEQ			= AAAAA.TML_SO_SEQ" ).append("\n"); 
		query.append("                     		AND X.VSL_CD				= AAAAA.VSL_CD" ).append("\n"); 
		query.append("							AND X.SKD_VOY_NO			= AAAAA.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND X.SKD_DIR_CD			= AAAAA.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND X.IO_BND_CD				= AAAAA.IO_BND_CD" ).append("\n"); 
		query.append("							AND (X.VRFY_RSLT_IND_CD		= 'CO' AND X.MODI_FLG = 'Y')" ).append("\n"); 
		query.append("							) " ).append("\n"); 
		query.append("		  END) AS VRFY_RSLT_CD_CTNT" ).append("\n"); 
		query.append("		, SUM(NVL(VOL_AUD_TGT_QTY, 0)) AS VOL_AUD_TGT_QTY" ).append("\n"); 
		query.append("		, MIN(BAT_VOL_RSLT_CD) AS BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, MIN(BAT_AMT_RSLT_CD) AS BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("		, MIN(BAT_ESTM_VOL_RSLT_CD) AS BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, CASE WHEN MAX(CALC_TP_CD) = 'A' THEN 'S' -- Auto일 경우 항상 Coincidence" ).append("\n"); 
		query.append("				-- CHM-201642319 TES Auto Audit 수정 요청 ( 2016-07-08)" ).append("\n"); 
		query.append("				WHEN MAX(AMT_AUTO_AUD_CD) = 'O' THEN 'O' -- Auto Audit Target Flag 'N', Diff Ratio Non" ).append("\n"); 
		query.append("				WHEN MIN(AMT_AUTO_AUD_CD) IN ('F', 'C')  AND SUM(EXPN_AUD_ESTM_AMT) > SUM(INV_AMT) THEN 'F'" ).append("\n"); 
		query.append("				WHEN MIN(AMT_AUTO_AUD_CD) IN ('F', 'C') AND DECODE(SUM(EXPN_AUD_ESTM_AMT), 0, NULL, ROUND(((SUM(INV_AMT) - SUM(EXPN_AUD_ESTM_AMT)) / DECODE(SUM(EXPN_AUD_ESTM_AMT), 0, 1, SUM(EXPN_AUD_ESTM_AMT))) * 100, 1)) <= MIN(EXPN_MAX_PRMT_RTO)" ).append("\n"); 
		query.append("					THEN LEAST('F', MIN(VRFY_RSLT_AUD_CD), MIN(VOL_AOTO_AUD_CD))" ).append("\n"); 
		query.append("		            ELSE (CASE WHEN MIN(VRFY_RSLT_AUD_CD) = 'S' AND MIN(VOL_AOTO_AUD_CD) = 'S' " ).append("\n"); 
		query.append("									THEN (CASE WHEN MAX(DECODE(AMT_AUTO_AUD_CD, 'O', 'A',AMT_AUTO_AUD_CD)) = 'A' THEN 'O'" ).append("\n"); 
		query.append("													ELSE MIN(DECODE(AMT_AUTO_AUD_CD, 'O', 'Z', AMT_AUTO_AUD_CD))" ).append("\n"); 
		query.append("										  END)" ).append("\n"); 
		query.append("                               		ELSE LEAST(MIN(AMT_AUTO_AUD_CD), MIN(VRFY_RSLT_AUD_CD), MIN(VOL_AOTO_AUD_CD)) " ).append("\n"); 
		query.append("                          END)" ).append("\n"); 
		query.append("		  END AS AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("		, COUNT(1) AS AUD_DTL_TGT_QTY" ).append("\n"); 
		query.append("		, WM_CONCAT(DISTINCT CALC_TP_CD_DESC) AS CALC_TP_CD_CTNT" ).append("\n"); 
		query.append("		, SUM(DECODE(BAT_VOL_RSLT_CD, 'F', 1, 0)) AS BAT_VOL_RSLT_CD_QTY" ).append("\n"); 
		query.append("		, SUM(DECODE(BAT_AMT_RSLT_CD, 'F', 1, 0)) AS BAT_AMT_RSLT_CD_QTY" ).append("\n"); 
		query.append("		, SUM(DECODE(BAT_ESTM_VOL_RSLT_CD, 'F', 1, 0)) AS BAT_ESTM_VOL_RSLT_CD_QTY" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	  AAAA.*" ).append("\n"); 
		query.append("				, CASE WHEN (CASE WHEN EXPN_MAX_PRMT_RTO < ((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT, 0, 1, EXPN_AUD_ESTM_AMT) ) * 100 THEN 'Y' END) = 'Y' THEN LGS_COST_CD" ).append("\n"); 
		query.append("						WHEN VRFY_RSLT_CD_CTNT IS NOT NULL THEN LGS_COST_CD" ).append("\n"); 
		query.append("						WHEN NVL(VOL_AUD_TGT_QTY, 0) > 0 THEN LGS_COST_CD" ).append("\n"); 
		query.append("				  END AS ERR_LGS_COST_CD" ).append("\n"); 
		query.append("				, CASE WHEN CALC_TP_CD = 'A' THEN 'S' -- Auto일 경우 금액에 관계없이 항상 Coincidence" ).append("\n"); 
		query.append("						WHEN EXPN_MAX_PRMT_RTO IS NULL THEN 'O'" ).append("\n"); 
		query.append("						WHEN INV_AMT - EXPN_AUD_ESTM_AMT < 0 THEN 'F' -- 마이너스 금액은 잠재적인 심사대상" ).append("\n"); 
		query.append("						WHEN EXPN_MAX_PRMT_RTO >= ((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT,0,1,EXPN_AUD_ESTM_AMT) ) * 100 -- 허용범위내(%)" ).append("\n"); 
		query.append("							THEN (CASE WHEN COST_CALC_MZD_CD = 'A' AND CALC_TP_CD = 'M' AND (((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT, 0, 1, EXPN_AUD_ESTM_AMT) ) * 100 BETWEEN 0 AND 1) THEN 'S' -- Auto는 1%이내일 경우 심사대상에서 제외" ).append("\n"); 
		query.append("										WHEN COST_CALC_MZD_CD = 'M' AND CALC_TP_CD = 'M' AND (((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT, 0, 1, EXPN_AUD_ESTM_AMT) ) * 100 BETWEEN 0 AND 3) THEN 'S' -- Manual은 3%이내일 경우 심사대상에서 제외" ).append("\n"); 
		query.append("											ELSE 'F'" ).append("\n"); 
		query.append("									END)" ).append("\n"); 
		query.append("						WHEN EXPN_MAX_PRMT_RTO < ((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT, 0, 1, EXPN_AUD_ESTM_AMT) ) * 100 THEN 'C' -- 설정된 허용범위를 초과화면 심사대상" ).append("\n"); 
		query.append("						WHEN N3MON_TOT_VOL IS NULL OR N3MON_TOT_AMT IS NULL OR VVD_VOL IS NULL THEN 'F'" ).append("\n"); 
		query.append("						ELSE 'O' -- Ratio가 등록되지 않아 비교값이 없는 경우" ).append("\n"); 
		query.append("					END AS AMT_AUTO_AUD_CD" ).append("\n"); 
		query.append("				, CASE WHEN VRFY_RSLT_CD_CTNT IS NOT NULL THEN 'F'" ).append("\n"); 
		query.append("							ELSE 'S'" ).append("\n"); 
		query.append("				  END AS VRFY_RSLT_AUD_CD" ).append("\n"); 
		query.append("				, CASE WHEN NVL(VOL_AUD_TGT_QTY, 0) > 0 THEN 'C'" ).append("\n"); 
		query.append("							ELSE 'S'" ).append("\n"); 
		query.append("				  END VOL_AOTO_AUD_CD" ).append("\n"); 
		query.append("				, (CASE WHEN N3MON_TOT_VOL IS NOT NULL THEN 'S' ELSE 'F' END) BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("				, (CASE WHEN N3MON_TOT_AMT IS NOT NULL THEN 'S' ELSE 'F' END) BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("				, (CASE WHEN VVD_VOL IS NOT NULL THEN 'S' ELSE 'F' END) BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("				, (CASE WHEN SEMI_AUTO_CALC_FLG = 'Y' THEN 'S' ELSE CALC_TP_CD END) CALC_TP_CD_DESC" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	AAA.*" ).append("\n"); 
		query.append("						, NVL( (CASE WHEN CALC_TP_CD = 'A' OR SEMI_AUTO_CALC_FLG = 'Y' THEN CTRT_RT * INV_XCH_RT" ).append("\n"); 
		query.append("									WHEN CALC_TP_CD = 'M' AND LGS_COST_CD  = 'SVXXHC' THEN ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 1)) / DECODE(VVD_CNT, 0, 1, VVD_CNT), 2)" ).append("\n"); 
		query.append("									WHEN CALC_TP_CD = 'M' AND LGS_COST_CD <> 'SVXXHC' THEN NVL(ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 1)) / TO_NUMBER(DECODE(BKG_GET_TOKEN_FNC(N3MON_INV, 2), '0', '1', BKG_GET_TOKEN_FNC(N3MON_INV, 2))), 2), CTRT_RT * INV_XCH_RT)" ).append("\n"); 
		query.append("								END)" ).append("\n"); 
		query.append("								*  NVL((CASE WHEN VVD_VOL * (CASE WHEN N3MON_TOT_VOL IS NULL OR N3MON_TOT_VOL = 0 THEN 1" ).append("\n"); 
		query.append("																  WHEN VVD_VOL / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("																  WHEN TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,NULL,N3MON_TOT_VOL) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("																  WHEN (NVL(RVIS_VOL_QTY,0) - NVL(VVD_VOL,0)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) " ).append("\n"); 
		query.append("										                                                       <= (NVL(RVIS_VOL_QTY,0) - (NVL(VVD_VOL,0)) * ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL),3)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) THEN 1" ).append("\n"); 
		query.append("																  	ELSE ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL),3)" ).append("\n"); 
		query.append("															 END) < 1" ).append("\n"); 
		query.append("												THEN 1" ).append("\n"); 
		query.append("												ELSE ROUND(VVD_VOL * (CASE WHEN N3MON_TOT_VOL IS NULL OR N3MON_TOT_VOL = 0 THEN 1" ).append("\n"); 
		query.append("																		   WHEN VVD_VOL / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("																		   WHEN TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,NULL,N3MON_TOT_VOL) BETWEEN 0.9 AND 1.1 THEN 1" ).append("\n"); 
		query.append("																		   WHEN (NVL(RVIS_VOL_QTY,0) - NVL(VVD_VOL,0)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) " ).append("\n"); 
		query.append("																				<= (NVL(RVIS_VOL_QTY,0) - (NVL(VVD_VOL,0)) * ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL),3)) / DECODE(RVIS_VOL_QTY,0,NULL,RVIS_VOL_QTY) THEN 1" ).append("\n"); 
		query.append("																				ELSE ROUND(TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) / DECODE(N3MON_TOT_VOL,0,1,N3MON_TOT_VOL),3)" ).append("\n"); 
		query.append("																	  END)" ).append("\n"); 
		query.append("															, 1)" ).append("\n"); 
		query.append("										 END)" ).append("\n"); 
		query.append("										, 1)" ).append("\n"); 
		query.append("								, 0) AS EXPN_AUD_ESTM_AMT " ).append("\n"); 
		query.append("						, TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 1)) AS N3MON_TOT_AMT" ).append("\n"); 
		query.append("						, TO_NUMBER(BKG_GET_TOKEN_FNC(N3MON_INV, 2)) AS N3MON_TOT_INV_VOL" ).append("\n"); 
		query.append("				FROM	(" ).append("\n"); 
		query.append("						SELECT	AA.*" ).append("\n"); 
		query.append("								, (SELECT	X.TTL_TML_AMT ||','|| TTL_RVIS_VOL_QTY" ).append("\n"); 
		query.append("									FROM	EAS_TML_MRN_TTL_AMT X" ).append("\n"); 
		query.append("									WHERE	X.TML_AUD_YRMON = AA.ATB_YM" ).append("\n"); 
		query.append("									AND		X.YD_CD         = AA.YD_CD" ).append("\n"); 
		query.append("									AND		X.IO_BND_CD     = AA.IO_BND_CD" ).append("\n"); 
		query.append("									AND		X.CNTR_TPSZ_CD  = (CASE WHEN AA.CNTR_STY_CD = 'F' AND SUBSTR(AA.CNTR_TPSZ_CD ,1,1) = 'R' AND NVL(AA.RC_FLG, 'N') = 'N' THEN 'D'||SUBSTR(AA.CNTR_TPSZ_CD ,2,1) ELSE AA.CNTR_TPSZ_CD END)" ).append("\n"); 
		query.append("									AND		X.LGS_COST_CD   = AA.LGS_COST_CD" ).append("\n"); 
		query.append("									AND		X.CURR_CD       = AA.CURR_CD" ).append("\n"); 
		query.append("									AND		X.DCGO_FLG      = AA.DCGO_FLG" ).append("\n"); 
		query.append("									AND		X.RC_FLG        = AA.RC_FLG" ).append("\n"); 
		query.append("									AND		X.COM_VVD_FLG   = AA.COM_VVD_FLG" ).append("\n"); 
		query.append("									) AS N3MON_INV" ).append("\n"); 
		query.append("								, (SELECT SUM(CASE WHEN AA.SPCL_CGO_TP_CALC_CD = 'DG' THEN X.DCGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'RF' THEN X.RC_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'AK' THEN X.AWK_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'BB' THEN X.BB_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'BA' THEN X.AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'GH' THEN X.HNGR_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'CF' THEN X.CFS_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.DCGO_FLG = 'Y' AND AA.RC_FLG = 'Y' THEN X.DG_RC_QTY" ).append("\n"); 
		query.append("													WHEN AA.DCGO_FLG = 'Y' AND AA.RC_FLG = 'N' THEN X.DCGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.DCGO_FLG = 'N' AND AA.RC_FLG = 'Y' THEN X.RC_QTY" ).append("\n"); 
		query.append("														ELSE (CASE WHEN X.CNTR_TTL_QTY - NVL(X.DCGO_QTY,0) - NVL(X.RC_QTY,0) - NVL(X.DG_RC_QTY,0) < 0 THEN 0" ).append("\n"); 
		query.append("																		ELSE X.CNTR_TTL_QTY - NVL(X.DCGO_QTY,0) - NVL(X.RC_QTY,0) - NVL(X.DG_RC_QTY,0)" ).append("\n"); 
		query.append("															  END)" ).append("\n"); 
		query.append("												END)" ).append("\n"); 
		query.append("									FROM	EAS_TML_MRN_TTL_QTY X" ).append("\n"); 
		query.append("									WHERE	X.TML_AUD_YRMON	= AA.ATB_YM" ).append("\n"); 
		query.append("									AND		X.YD_CD			= AA.YD_CD" ).append("\n"); 
		query.append("									AND		X.CNTR_TPSZ_CD	= (CASE WHEN AA.CNTR_STY_CD = 'F' AND SUBSTR(AA.CNTR_TPSZ_CD ,1,1) = 'R' AND NVL(AA.RC_FLG, 'N') = 'N' THEN 'D'||SUBSTR(AA.CNTR_TPSZ_CD ,2,1) ELSE AA.CNTR_TPSZ_CD END)" ).append("\n"); 
		query.append("									AND		X.IO_BND_CD		= AA.IO_BND_CD" ).append("\n"); 
		query.append("									AND		X.FULL_MTY_CD	= AA.CNTR_STY_CD" ).append("\n"); 
		query.append("									AND		X.TS_FLG		LIKE (CASE WHEN AA.TS_FLG IN ('Y', 'N') THEN AA.TS_FLG ELSE '%' END)       " ).append("\n"); 
		query.append("									AND		X.COM_VVD_FLG	= AA.COM_VVD_FLG" ).append("\n"); 
		query.append("									) AS N3MON_TOT_VOL" ).append("\n"); 
		query.append("								, (SELECT SUM(CASE WHEN AA.SPCL_CGO_TP_CALC_CD = 'DG' THEN X.DCGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'RF' THEN X.RC_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'AK' THEN X.AWK_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'BB' THEN X.BB_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'BA' THEN X.AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'GH' THEN X.HNGR_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.SPCL_CGO_TP_CALC_CD = 'CF' THEN X.CFS_CGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.DCGO_FLG = 'Y' AND AA.RC_FLG = 'Y' THEN X.DG_RC_QTY" ).append("\n"); 
		query.append("													WHEN AA.DCGO_FLG = 'Y' AND AA.RC_FLG = 'N' THEN X.DCGO_QTY" ).append("\n"); 
		query.append("													WHEN AA.DCGO_FLG = 'N' AND AA.RC_FLG = 'Y' THEN X.RC_QTY" ).append("\n"); 
		query.append("														ELSE (CASE WHEN X.CNTR_TTL_QTY - NVL(X.DCGO_QTY,0) - NVL(X.RC_QTY,0) - NVL(X.DG_RC_QTY,0) < 0 THEN 0" ).append("\n"); 
		query.append("																		ELSE X.CNTR_TTL_QTY - NVL(X.DCGO_QTY,0) - NVL(X.RC_QTY,0) - NVL(X.DG_RC_QTY,0)" ).append("\n"); 
		query.append("															  END)" ).append("\n"); 
		query.append("												END)" ).append("\n"); 
		query.append("									FROM	EAS_TML_MRN_VVD_QTY X" ).append("\n"); 
		query.append("									WHERE	X.YD_CD			= AA.YD_CD" ).append("\n"); 
		query.append("									AND		X.CNTR_TPSZ_CD	= AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("									AND		X.IO_BND_CD		= AA.IO_BND_CD" ).append("\n"); 
		query.append("									AND		X.FULL_MTY_CD	= AA.CNTR_STY_CD" ).append("\n"); 
		query.append("									AND		X.TS_FLG		LIKE (CASE WHEN AA.TS_FLG IN ('Y', 'N') THEN AA.TS_FLG ELSE '%' END)       " ).append("\n"); 
		query.append("									AND		X.VSL_CD		= AA.VSL_CD" ).append("\n"); 
		query.append("									AND		X.SKD_VOY_NO	= AA.SKD_VOY_NO" ).append("\n"); 
		query.append("									AND		X.SKD_DIR_CD	= AA.SKD_DIR_CD" ).append("\n"); 
		query.append("									) AS VVD_VOL" ).append("\n"); 
		query.append("								, (SELECT	COUNT(DISTINCT X.VSL_CD || X.SKD_VOY_NO)" ).append("\n"); 
		query.append("									FROM	EAS_TML_MRN_VVD_CD X" ).append("\n"); 
		query.append("									WHERE	X.TML_AUD_YRMON	= AA.ATB_YM" ).append("\n"); 
		query.append("									AND		X.YD_CD			= AA.YD_CD" ).append("\n"); 
		query.append("									AND		X.VSL_SLAN_CD   = AA.VSL_SLAN_CD" ).append("\n"); 
		query.append("									AND		X.CNTR_STY_CD   = AA.CNTR_STY_CD" ).append("\n"); 
		query.append("									) AS VVD_CNT" ).append("\n"); 
		query.append("								, (SELECT	WM_CONCAT(DISTINCT X.DSCR_IND_CD)" ).append("\n"); 
		query.append("									FROM	TES_TML_SO_CNTR_LIST X" ).append("\n"); 
		query.append("									WHERE	X.TML_SO_OFC_CTY_CD	= AA.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("									AND		X.TML_SO_SEQ		= AA.TML_SO_SEQ" ).append("\n"); 
		query.append("									AND		X.VSL_CD			= AA.VSL_CD" ).append("\n"); 
		query.append("									AND		X.SKD_VOY_NO		= AA.SKD_VOY_NO" ).append("\n"); 
		query.append("									AND		X.SKD_DIR_CD		= AA.SKD_DIR_CD" ).append("\n"); 
		query.append("									AND		X.IO_BND_CD			= AA.IO_BND_CD" ).append("\n"); 
		query.append("									AND		X.CNTR_TPSZ_CD		= AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("									AND		X.CNTR_STY_CD		= AA.CNTR_STY_CD" ).append("\n"); 
		query.append("									AND		X.LOCL_TS_IND_CD	LIKE DECODE(AA.TS_FLG, 'Y', 'T', 'N', 'L', '%')" ).append("\n"); 
		query.append("									AND		X.RC_FLG			= AA.RC_FLG" ).append("\n"); 
		query.append("									AND		DECODE(X.DCGO_CLSS_CD, NULL, 'N', 'N', 'N', 'Y') = AA.DCGO_FLG" ).append("\n"); 
		query.append("									AND		(X.VRFY_RSLT_IND_CD	= 'CO' AND X.MODI_FLG = 'Y')" ).append("\n"); 
		query.append("									AND		AA.CALC_TP_CD		= 'A'" ).append("\n"); 
		query.append("									) AS VRFY_RSLT_CD_CTNT" ).append("\n"); 
		query.append("								, CASE WHEN NVL(CALC_VOL_QTY,0) <> NVL(RVIS_VOL_QTY,0) THEN 1 ELSE 0 END VOL_AUD_TGT_QTY  -- 0이 아니면 심사대상  " ).append("\n"); 
		query.append("						FROM	(" ).append("\n"); 
		query.append("								SELECT	  D.CALC_TP_CD " ).append("\n"); 
		query.append("										, D.LGS_COST_CD" ).append("\n"); 
		query.append("										, NVL(D.CNTR_TPSZ_CD,'XX') CNTR_TPSZ_CD" ).append("\n"); 
		query.append("										, DECODE(D.DCGO_IND_CD, NULL, 'N', 'N', 'N', 'Y') DCGO_FLG" ).append("\n"); 
		query.append("										, NVL(D.RC_FLG, 'N') AS RC_FLG" ).append("\n"); 
		query.append("										, MAX(D.TML_WRK_DY_CD) AS TML_WRK_DY_CD" ).append("\n"); 
		query.append("										, MAX(D.IOC_CD) AS IOC_CD" ).append("\n"); 
		query.append("										, MAX(D.TML_TRNS_MOD_CD) AS TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("										, SUM(D.CALC_VOL_QTY) AS CALC_VOL_QTY" ).append("\n"); 
		query.append("										, SUM(D.RVIS_VOL_QTY) AS RVIS_VOL_QTY" ).append("\n"); 
		query.append("										, MAX(D.VOL_TR_UT_CD) AS VOL_TR_UT_CD" ).append("\n"); 
		query.append("										, MAX(D.CTRT_RT) AS CTRT_RT" ).append("\n"); 
		query.append("										, MAX(H.CURR_CD) CURR_CD" ).append("\n"); 
		query.append("										, MAX(D.INV_XCH_RT) AS INV_XCH_RT" ).append("\n"); 
		query.append("										, SUM(D.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("										, MAX(D.CALC_RMK) AS CALC_RMK" ).append("\n"); 
		query.append("										, MAX(D.ATB_DT) AS ATB_DT" ).append("\n"); 
		query.append("										, MAX(TO_CHAR(ADD_MONTHS(D.ATB_DT, -1), 'YYYYMM')) ATB_YM" ).append("\n"); 
		query.append("										, MAX(B.CNTR_STY_CD) AS CNTR_STY_CD" ).append("\n"); 
		query.append("										, NVL(MAX(A.TS_FLG),'A') AS TS_FLG" ).append("\n"); 
		query.append("										, MAX(C.VSL_SLAN_CD) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("										, MAX(H.INV_CFM_DT) AS INV_CFM_DT" ).append("\n"); 
		query.append("										, (CASE WHEN MAX(A.EXPN_AUD_TGT_FLG) = 'N' THEN NULL ELSE MAX(A.EXPN_MAX_PRMT_RTO) END) AS EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("										, MAX(H.TML_INV_TP_CD) AS TML_INV_TP_CD" ).append("\n"); 
		query.append("										, MAX(H.ISS_DT) AS ISS_DT" ).append("\n"); 
		query.append("										, MAX(H.RHQ_OFC_CD) AS RHQ_OFC_CD" ).append("\n"); 
		query.append("										, MAX(H.INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("										, MAX(H.COST_OFC_CD) AS COST_OFC_CD" ).append("\n"); 
		query.append("										, MAX(H.YD_CD) AS YD_CD" ).append("\n"); 
		query.append("										, MAX(H.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("										, MAX(H.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("										, MAX(D.VSL_CD) AS VSL_CD" ).append("\n"); 
		query.append("										, MAX(D.SKD_VOY_NO) AS SKD_VOY_NO" ).append("\n"); 
		query.append("										, MAX(D.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("										, MAX(D.IO_BND_CD) AS IO_BND_CD" ).append("\n"); 
		query.append("										, MAX(A.SPCL_CGO_TP_CALC_CD) AS SPCL_CGO_TP_CALC_CD" ).append("\n"); 
		query.append("										, MAX(H.TML_SO_OFC_CTY_CD) AS TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("										, MAX(H.TML_SO_SEQ) AS TML_SO_SEQ" ).append("\n"); 
		query.append("										, (CASE WHEN MAX(D.VSL_CD) = 'CNTC' THEN 'Y' ELSE 'N' END) AS COM_VVD_FLG" ).append("\n"); 
		query.append("										, NVL(MAX(D.SEMI_AUTO_CALC_FLG),'N') AS SEMI_AUTO_CALC_FLG" ).append("\n"); 
		query.append("										, MAX(B.COST_CALC_MZD_CD) AS COST_CALC_MZD_CD" ).append("\n"); 
		query.append("								FROM	(SELECT	EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(X.INV_OFC_CD) RHQ_OFC_CD" ).append("\n"); 
		query.append("												, X.*" ).append("\n"); 
		query.append("										FROM	TES_TML_SO_HDR X" ).append("\n"); 
		query.append("										) H" ).append("\n"); 
		query.append("										, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("										, EAS_TML_AUTO_AUD_CRTE A" ).append("\n"); 
		query.append("										, TES_TML_SO_COST B" ).append("\n"); 
		query.append("										, VSK_VSL_SKD     C" ).append("\n"); 
		query.append("								WHERE	1	= 1" ).append("\n"); 
		query.append("								AND		H.TML_SO_OFC_CTY_CD		= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("								AND		H.TML_SO_SEQ			= D.TML_SO_SEQ" ).append("\n"); 
		query.append("								AND		H.RHQ_OFC_CD			= A.AUD_OFC_CD" ).append("\n"); 
		query.append("								AND		D.LGS_COST_CD			= A.LGS_COST_CD" ).append("\n"); 
		query.append("								AND		D.LGS_COST_CD			= B.LGS_COST_CD" ).append("\n"); 
		query.append("								AND		D.VSL_CD				= C.VSL_CD(+)" ).append("\n"); 
		query.append("								AND		D.SKD_VOY_NO			= C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("								AND		D.SKD_DIR_CD			= C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("								AND		NVL(H.DELT_FLG, 'N')	<> 'Y'" ).append("\n"); 
		query.append("								AND		H.TML_INV_STS_CD		<> 'R'" ).append("\n"); 
		query.append("								AND		H.TML_INV_RJCT_STS_CD	<> 'RJ'" ).append("\n"); 
		query.append("								AND		H.VNDR_SEQ				= @[vndr_seq]" ).append("\n"); 
		query.append("								AND		H.INV_NO				= @[inv_no]" ).append("\n"); 
		query.append("								AND		D.VSL_CD				= @[vsl_cd]" ).append("\n"); 
		query.append("								AND		D.SKD_VOY_NO			= @[skd_voy_no]" ).append("\n"); 
		query.append("								AND		D.SKD_DIR_CD			= @[skd_dir_cd]" ).append("\n"); 
		query.append("								AND		D.IO_BND_CD				= @[io_bnd_cd]" ).append("\n"); 
		query.append("								GROUP BY  D.CALC_TP_CD " ).append("\n"); 
		query.append("										, D.LGS_COST_CD" ).append("\n"); 
		query.append("										, NVL(D.CNTR_TPSZ_CD, 'XX')" ).append("\n"); 
		query.append("										, DECODE(D.DCGO_IND_CD, NULL, 'N', 'N', 'N', 'Y')" ).append("\n"); 
		query.append("										, D.RC_FLG" ).append("\n"); 
		query.append("		                        ) AA" ).append("\n"); 
		query.append("		                ) AAA" ).append("\n"); 
		query.append("		        ) AAAA" ).append("\n"); 
		query.append("		) AAAAA" ).append("\n"); 
		query.append("GROUP BY  INV_NO" ).append("\n"); 
		query.append("		, VNDR_SEQ" ).append("\n"); 
		query.append("		, VSL_CD" ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, IO_BND_CD" ).append("\n"); 
		query.append("		, TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		, TML_SO_SEQ" ).append("\n"); 

	}
}