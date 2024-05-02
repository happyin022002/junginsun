/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOSearchFreePoolAudRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.08 
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

public class TesAdvanceAuditDBDAOSearchFreePoolAudRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Storage Invoice의 FreePool을 심사한다.
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOSearchFreePoolAudRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_inv_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prd_ym",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_prd_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOSearchFreePoolAudRSQL").append("\n"); 
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
		query.append("		, TO_CHAR(MAX(INV_CFM_DT), 'YYYYMMDDHH24MISS') AS INV_CFM_DT" ).append("\n"); 
		query.append("		, MAX(FM_PRD_DT) AS FM_PRD_DT" ).append("\n"); 
		query.append("		, MAX(TO_PRD_DT) AS TO_PRD_DT     " ).append("\n"); 
		query.append("		, MAX(TML_INV_TP_CD) AS TML_INV_TP_CD" ).append("\n"); 
		query.append("		, MAX(YD_CD) AS YD_CD" ).append("\n"); 
		query.append("		, TO_CHAR(MAX(ISS_DT), 'YYYYMMDDHH24MISS') AS ISS_DT" ).append("\n"); 
		query.append("		, MAX(EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(INV_OFC_CD)) AS RHQ_CD" ).append("\n"); 
		query.append("		, MAX(INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("		, MAX(COST_OFC_CD) AS COST_OFC_CD" ).append("\n"); 
		query.append("		, MAX(CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("		, SUM(INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("		, CASE WHEN MIN(AMT_AUTO_AUD_CD) = 'C' THEN 'Y' END AS AMT_AUD_TGT_FLG" ).append("\n"); 
		query.append("		, SUM(EXPN_AUD_ESTM_AMT) AS EXPN_AUD_ESTM_AMT" ).append("\n"); 
		query.append("		, COUNT(DISTINCT ERR_LGS_COST_CD) AS AUD_LGS_COST_CD_QTY" ).append("\n"); 
		query.append("		, MIN(BAT_VOL_RSLT_CD) AS BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, MIN(BAT_AMT_RSLT_CD) AS BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("		, MIN(BAT_ESTM_VOL_RSLT_CD) AS BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("		, MIN(AMT_AUTO_AUD_CD) AS AMT_AUTO_AUD_CD" ).append("\n"); 
		query.append("		, MIN(AMT_AUTO_AUD_CD) AS AUTO_EXPN_AUD_STS_CD" ).append("\n"); 
		query.append("		, COUNT(1) AS AUD_DTL_TGT_QTY" ).append("\n"); 
		query.append("		, WM_CONCAT(DISTINCT CALC_TP_CD) AS CALC_TP_CD_CTNT" ).append("\n"); 
		query.append("		, SUM(DECODE(BAT_VOL_RSLT_CD, 'F', 1, 0)) AS BAT_VOL_RSLT_CD_QTY" ).append("\n"); 
		query.append("		, SUM(DECODE(BAT_AMT_RSLT_CD, 'F', 1, 0)) AS BAT_AMT_RSLT_CD_QTY" ).append("\n"); 
		query.append("		, SUM(DECODE(BAT_ESTM_VOL_RSLT_CD, 'F', 1, 0)) AS BAT_ESTM_VOL_RSLT_CD_QTY" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	  AAAA.*       " ).append("\n"); 
		query.append("		, CASE  WHEN CALC_TP_CD = 'A' THEN 'S'		-- Auto일 경우 항상 Coincidence" ).append("\n"); 
		query.append("				-- CHM-201642319 TES Auto Audit 수정 요청 ( 2016-07-08)" ).append("\n"); 
		query.append("				WHEN EXPN_MAX_PRMT_RTO IS NULL THEN 'O' -- Auto Audit Target Flag 'N', Diff Ratio Non" ).append("\n"); 
		query.append("				WHEN INV_AMT - EXPN_AUD_ESTM_AMT < 0 THEN 'F' -- 마이너스 금액은 잠재적인 심사대상" ).append("\n"); 
		query.append("						WHEN EXPN_MAX_PRMT_RTO >= ((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT,0,1,EXPN_AUD_ESTM_AMT) ) * 100 -- 허용범위내(%)" ).append("\n"); 
		query.append("							THEN (CASE WHEN CALC_TP_CD = 'A' AND (((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT, 0, 1, EXPN_AUD_ESTM_AMT) ) * 100 BETWEEN 0 AND 1) THEN 'S' -- Auto는 1%이내일 경우 심사대상에서 제외" ).append("\n"); 
		query.append("										WHEN CALC_TP_CD = 'M' AND (((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT, 0, 1, EXPN_AUD_ESTM_AMT) ) * 100 BETWEEN 0 AND 3) THEN 'S' -- Manual은 3%이내일 경우 심사대상에서 제외" ).append("\n"); 
		query.append("											ELSE 'F'" ).append("\n"); 
		query.append("									END)" ).append("\n"); 
		query.append("						WHEN EXPN_MAX_PRMT_RTO < ((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT, 0, 1, EXPN_AUD_ESTM_AMT) ) * 100 THEN 'C' -- 설정된 허용범위를 초과화면 심사대상" ).append("\n"); 
		query.append("						WHEN N3MON_TOT_VOL IS NULL OR N3MON_TOT_AMT IS NULL OR ESTM_VOL IS NULL THEN 'F'" ).append("\n"); 
		query.append("							ELSE 'O' -- Ratio가 등록되지 않아 비교값이 없는 경우" ).append("\n"); 
		query.append("				  END AS AMT_AUTO_AUD_CD" ).append("\n"); 
		query.append("				, CASE WHEN (CASE WHEN EXPN_MAX_PRMT_RTO < ((INV_AMT - EXPN_AUD_ESTM_AMT) / DECODE(EXPN_AUD_ESTM_AMT,0,1,EXPN_AUD_ESTM_AMT) ) * 100 THEN 'Y' END) = 'Y' THEN LGS_COST_CD" ).append("\n"); 
		query.append("				  END AS ERR_LGS_COST_CD" ).append("\n"); 
		query.append("				, (CASE WHEN N3MON_TOT_VOL IS NOT NULL THEN 'S' ELSE 'F' END) AS BAT_VOL_RSLT_CD" ).append("\n"); 
		query.append("				, (CASE WHEN N3MON_TOT_AMT IS NOT NULL THEN 'S' ELSE 'F' END) AS BAT_AMT_RSLT_CD" ).append("\n"); 
		query.append("				, (CASE WHEN ESTM_VOL IS NOT NULL THEN 'S' ELSE 'F' END) AS BAT_ESTM_VOL_RSLT_CD" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("				SELECT	AAA.*" ).append("\n"); 
		query.append("						, DECODE(CALC_TP_CD, 'A', RT * ROUND(N3MON_TOT_AMT / DECODE(N3MON_TOT_VOL, 0, 1, N3MON_TOT_VOL), 2)) * NVL(INV_XCH_RT, 1) * ESTM_VOL AS EXPN_AUD_ESTM_AMT " ).append("\n"); 
		query.append("				FROM	(" ).append("\n"); 
		query.append("						SELECT	AA.*" ).append("\n"); 
		query.append("								, ( SELECT  SUM(X.CNTR_TTL_QTY)" ).append("\n"); 
		query.append("									FROM    EAS_TML_STO_TTL_QTY X" ).append("\n"); 
		query.append("									WHERE   1    = 1" ).append("\n"); 
		query.append("									AND     X.TML_AUD_YRMON      = @[prd_ym]" ).append("\n"); 
		query.append("									AND     X.YD_CD              = AA.YD_CD" ).append("\n"); 
		query.append("									AND     X.FULL_MTY_CD        = 'M'" ).append("\n"); 
		query.append("									AND     X.STO_AUD_QTY_CLSS_CD IN ('T', 'I')" ).append("\n"); 
		query.append("								  ) AS N3MON_TOT_VOL" ).append("\n"); 
		query.append("								, ( SELECT  SUM(X.CNTR_TTL_AMT)" ).append("\n"); 
		query.append("									FROM    EAS_TML_STO_TTL_AMT X" ).append("\n"); 
		query.append("									WHERE   1    = 1" ).append("\n"); 
		query.append("									AND     X.TML_AUD_YRMON      = @[prd_ym]" ).append("\n"); 
		query.append("									AND     X.YD_CD              = AA.YD_CD" ).append("\n"); 
		query.append("									AND     X.TML_INV_TP_CD      = AA.TML_INV_TP_CD" ).append("\n"); 
		query.append("									AND     X.CALC_COST_GRP_CD   = 'SP'" ).append("\n"); 
		query.append("									AND     X.LGS_COST_CD        = AA.LGS_COST_CD" ).append("\n"); 
		query.append("									AND     X.CURR_CD            = AA.CURR_CD" ).append("\n"); 
		query.append("								  ) AS N3MON_TOT_AMT" ).append("\n"); 
		query.append("								, (" ).append("\n"); 
		query.append("									SELECT  SUM(CNTR_20FT_QTY) + ((SUM(CNTR_40FT_QTY) + SUM(CNTR_40FT_HC_QTY) + SUM(CNTR_45FT_QTY)) * 2)" ).append("\n"); 
		query.append("									FROM    EAS_TML_STO_YD_DLY_QTY X" ).append("\n"); 
		query.append("									WHERE   1    = 1" ).append("\n"); 
		query.append("									AND     X.YD_CD              = AA.YD_CD" ).append("\n"); 
		query.append("									AND     X.FULL_MTY_CD        = 'M'" ).append("\n"); 
		query.append("									AND     X.STO_AUD_QTY_CLSS_CD IN ('T', 'I')" ).append("\n"); 
		query.append("									AND     X.CNMV_DT BETWEEN @[fm_prd_dt] AND @[to_prd_dt]" ).append("\n"); 
		query.append("								  ) AS ESTM_VOL  " ).append("\n"); 
		query.append("						FROM	(" ).append("\n"); 
		query.append("								SELECT	  D.CALC_TP_CD" ).append("\n"); 
		query.append("										, D.LGS_COST_CD" ).append("\n"); 
		query.append("										, MAX(D.FP_CALC_PRD_CD) AS FP_CALC_PRD_CD" ).append("\n"); 
		query.append("										, MAX(TO_CHAR(ADD_MONTHS(TO_DATE(H.FM_PRD_DT, 'YYYYMMDD'), -1), 'YYYYMM')) AS PRD_YM" ).append("\n"); 
		query.append("										, SUM(D.STK_VOL_QTY) AS STK_VOL" ).append("\n"); 
		query.append("										, SUM(D.INV_VOL_QTY) AS INV_VOL" ).append("\n"); 
		query.append("										, SUM(D.DIFF_VOL_QTY) AS DIFF_VOL" ).append("\n"); 
		query.append("										, SUM(D.FP_TEU_QTY) AS FP_TEU" ).append("\n"); 
		query.append("										, SUM(D.OVR_VOL_QTY) AS OVR_VOL" ).append("\n"); 
		query.append("										, MAX(D.VOL_TR_UT_CD) AS VOL_TR_UT_CD" ).append("\n"); 
		query.append("										, MAX(D.CTRT_RT) AS RT    " ).append("\n"); 
		query.append("										, MAX(H.CURR_CD) AS CURR_CD" ).append("\n"); 
		query.append("										, MAX(D.INV_XCH_RT) AS INV_XCH_RT" ).append("\n"); 
		query.append("										, SUM(D.INV_AMT) AS INV_AMT" ).append("\n"); 
		query.append("										, SUM(D.CALC_AMT) AS CALC_AMT" ).append("\n"); 
		query.append("										, MAX(D.CALC_RMK) AS CALC_RMK   " ).append("\n"); 
		query.append("										, MAX(H.YD_CD) AS YD_CD" ).append("\n"); 
		query.append("										, MAX(H.INV_NO) AS INV_NO" ).append("\n"); 
		query.append("										, MAX(H.VNDR_SEQ) AS VNDR_SEQ" ).append("\n"); 
		query.append("										, MAX(H.FM_PRD_DT) AS FM_PRD_DT" ).append("\n"); 
		query.append("										, MAX(H.TO_PRD_DT) AS TO_PRD_DT" ).append("\n"); 
		query.append("										, MAX(D.TML_SO_OFC_CTY_CD) AS TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("										, MAX(D.TML_SO_SEQ) AS TML_SO_SEQ" ).append("\n"); 
		query.append("										, MAX(SC.COST_CALC_MZD_CD) AS COST_CALC_MZD_CD" ).append("\n"); 
		query.append("										, MAX(AC.SPCL_CGO_TP_CALC_CD) AS SPCL_CGO_TP_CALC_CD" ).append("\n"); 
		query.append("										, (CASE WHEN MAX(AC.EXPN_AUD_TGT_FLG) = 'N' THEN NULL ELSE MAX(AC.EXPN_MAX_PRMT_RTO) END) AS EXPN_MAX_PRMT_RTO" ).append("\n"); 
		query.append("										, MAX(H.INV_CFM_DT) AS INV_CFM_DT" ).append("\n"); 
		query.append("										, MAX(H.TML_INV_TP_CD) AS TML_INV_TP_CD" ).append("\n"); 
		query.append("										, MAX(H.ISS_DT) AS ISS_DT" ).append("\n"); 
		query.append("										, MAX(H.INV_OFC_CD) AS INV_OFC_CD" ).append("\n"); 
		query.append("										, MAX(H.COST_OFC_CD) AS COST_OFC_CD" ).append("\n"); 
		query.append("								FROM      TES_TML_SO_HDR H" ).append("\n"); 
		query.append("										, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("										, TES_TML_SO_COST SC" ).append("\n"); 
		query.append("										, EAS_TML_AUTO_AUD_CRTE AC" ).append("\n"); 
		query.append("								WHERE   1    = 1" ).append("\n"); 
		query.append("								AND     H.TML_SO_OFC_CTY_CD		= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("								AND     H.TML_SO_SEQ        	= D.TML_SO_SEQ" ).append("\n"); 
		query.append("								AND     D.LGS_COST_CD       	= SC.LGS_COST_CD" ).append("\n"); 
		query.append("								AND     D.LGS_COST_CD       	= AC.LGS_COST_CD" ).append("\n"); 
		query.append("								AND     AC.AUD_OFC_CD       	= EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(H.INV_OFC_CD)" ).append("\n"); 
		query.append("								AND     SC.EAS_AUD_FLG      	= 'Y'" ).append("\n"); 
		query.append("								AND     NVL(H.DELT_FLG, 'N')	<> 'Y'" ).append("\n"); 
		query.append("								AND     H.TML_INV_STS_CD 		<> 'R'" ).append("\n"); 
		query.append("								AND     H.TML_INV_RJCT_STS_CD	<> 'RJ'" ).append("\n"); 
		query.append("								AND     H.TML_INV_TP_CD			= @[tml_inv_tp_cd] -- OF, ST" ).append("\n"); 
		query.append("								AND     D.CALC_COST_GRP_CD    	= 'SP'" ).append("\n"); 
		query.append("								AND     H.VNDR_SEQ              = @[vndr_seq]" ).append("\n"); 
		query.append("								AND     H.INV_NO                = @[inv_no]" ).append("\n"); 
		query.append("								GROUP BY  D.CALC_TP_CD" ).append("\n"); 
		query.append("										, D.LGS_COST_CD" ).append("\n"); 
		query.append("										, H.FM_PRD_DT" ).append("\n"); 
		query.append("										, H.TO_PRD_DT" ).append("\n"); 
		query.append("                                ) AA" ).append("\n"); 
		query.append("                        ) AAA" ).append("\n"); 
		query.append("                ) AAAA" ).append("\n"); 
		query.append("        ) AAAAA" ).append("\n"); 
		query.append("GROUP BY INV_NO" ).append("\n"); 
		query.append("       , VNDR_SEQ" ).append("\n"); 

	}
}