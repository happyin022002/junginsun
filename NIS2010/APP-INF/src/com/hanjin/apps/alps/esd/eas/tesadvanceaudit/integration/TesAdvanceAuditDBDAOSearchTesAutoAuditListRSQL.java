/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOSearchTesAutoAuditListRSQL.java
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

public class TesAdvanceAuditDBDAOSearchTesAutoAuditListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Audit Batch 대상 목록 조회
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOSearchTesAutoAuditListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOSearchTesAutoAuditListRSQL").append("\n"); 
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
		query.append("		, EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(INV_OFC_CD) AS RHQ_CD" ).append("\n"); 
		query.append("		, INV_CFM_DT" ).append("\n"); 
		query.append("		, TML_INV_TP_CD" ).append("\n"); 
		query.append("		, CALC_COST_GRP_CD" ).append("\n"); 
		query.append("		, VSL_CD " ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, IO_BND_CD " ).append("\n"); 
		query.append("		, TO_CHAR(" ).append("\n"); 
		query.append("			ADD_MONTHS(" ).append("\n"); 
		query.append("				TO_DATE( " ).append("\n"); 
		query.append("					(CASE	WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'IO' THEN MIN_MVMT_GATE_OUT_DT " ).append("\n"); 
		query.append("							WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'DT' AND MIN_MVMT_GATE_IN_DT IS NOT NULL THEN MIN_MVMT_GATE_IN_DT " ).append("\n"); 
		query.append("							WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'DT' AND MIN_MVMT_GATE_IN_DT IS NULL THEN MIN_MVMT_GATE_OUT_DT " ).append("\n"); 
		query.append("							WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'TP' THEN MIN_MVMT_GATE_OUT_DT " ).append("\n"); 
		query.append("							WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'SP' AND MIN_MVMT_GATE_IN_DT IS NOT NULL THEN MIN_MVMT_GATE_IN_DT " ).append("\n"); 
		query.append("							WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'SP' AND MIN_MVMT_GATE_IN_DT IS NULL THEN MIN_MVMT_GATE_OUT_DT " ).append("\n"); 
		query.append("							ELSE (CASE WHEN TO_DATE(TO_PRD_DT, 'YYYYMMDD') - TO_DATE(FM_PRD_DT, 'YYYYMMDD') > 45 THEN TO_CHAR(TO_DATE(TO_PRD_DT, 'YYYYMMDD') - 31, 'YYYYMMDD')" ).append("\n"); 
		query.append("										ELSE FM_PRD_DT" ).append("\n"); 
		query.append("									END)" ).append("\n"); 
		query.append("					END),'YYYYMMDD')" ).append("\n"); 
		query.append("				, -1)" ).append("\n"); 
		query.append("			, 'YYYYMM') AS PRD_YM" ).append("\n"); 
		query.append("		, (CASE WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'IO' THEN MIN_MVMT_GATE_OUT_DT " ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'DT' AND MIN_MVMT_GATE_IN_DT IS NOT NULL THEN MIN_MVMT_GATE_IN_DT " ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'DT' AND MIN_MVMT_GATE_IN_DT IS NULL THEN MIN_MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'TP' THEN MIN_MVMT_GATE_OUT_DT " ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'SP' AND MIN_MVMT_GATE_IN_DT IS NOT NULL THEN MIN_MVMT_GATE_IN_DT " ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'SP' AND MIN_MVMT_GATE_IN_DT IS NULL THEN MIN_MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				ELSE (CASE WHEN TO_DATE(TO_PRD_DT, 'YYYYMMDD') - TO_DATE(FM_PRD_DT, 'YYYYMMDD') > 45 THEN TO_CHAR(TO_DATE(TO_PRD_DT, 'YYYYMMDD') - 31, 'YYYYMMDD')" ).append("\n"); 
		query.append("							ELSE FM_PRD_DT" ).append("\n"); 
		query.append("						END)" ).append("\n"); 
		query.append("			END) AS FM_PRD_DT" ).append("\n"); 
		query.append("		, (CASE WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'IO' THEN MAX_MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'DT' AND MAX_MVMT_GATE_OUT_DT IS NOT NULL THEN MAX_MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'SD' AND STO_DYS_IND_CD = 'DT' AND MAX_MVMT_GATE_IN_DT  IS NOT NULL THEN MAX_MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'TP' THEN MAX_MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'SP' AND MAX_MVMT_GATE_OUT_DT IS NOT NULL THEN MAX_MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				WHEN CALC_TP_CD = 'A' AND CALC_COST_GRP_CD = 'TM' AND TML_CALC_IND_CD = 'SP' AND MAX_MVMT_GATE_IN_DT  IS NOT NULL THEN MAX_MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("				ELSE TO_PRD_DT " ).append("\n"); 
		query.append("			END) AS TO_PRD_DT" ).append("\n"); 
		query.append("FROM	(" ).append("\n"); 
		query.append("		SELECT	  H.INV_NO" ).append("\n"); 
		query.append("				, H.VNDR_SEQ" ).append("\n"); 
		query.append("				, H.INV_OFC_CD" ).append("\n"); 
		query.append("				, TO_CHAR(H.INV_CFM_DT, 'YYYYMMDDHH24MISS') AS INV_CFM_DT" ).append("\n"); 
		query.append("				, H.TML_INV_TP_CD" ).append("\n"); 
		query.append("				, D.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE NULL END) AS VSL_CD" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE NULL END) AS SKD_VOY_NO" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE NULL END) AS SKD_DIR_CD" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE NULL END) AS IO_BND_CD" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN H.FM_PRD_DT ELSE NULL END) AS FM_PRD_DT" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN H.TO_PRD_DT ELSE NULL END) AS TO_PRD_DT" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN TO_CHAR(MIN(MVMT_GATE_IN_DT),'YYYYMMDD') END) AS MIN_MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN TO_CHAR(MAX(MVMT_GATE_IN_DT),'YYYYMMDD') END) AS MAX_MVMT_GATE_IN_DT" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN TO_CHAR(MIN(MVMT_GATE_OUT_DT),'YYYYMMDD') END) AS MIN_MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN TO_CHAR(MAX(MVMT_GATE_OUT_DT),'YYYYMMDD') END) AS MAX_MVMT_GATE_OUT_DT" ).append("\n"); 
		query.append("				, H.STO_DYS_IND_CD" ).append("\n"); 
		query.append("				, H.TML_CALC_IND_CD" ).append("\n"); 
		query.append("				, MIN(D.CALC_TP_CD) AS CALC_TP_CD" ).append("\n"); 
		query.append("		FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("				, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("				, TES_TML_SO_COST C" ).append("\n"); 
		query.append("				, TES_TML_SO_CNTR_LIST E" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} == 'M')-- 실시간(5분) 배치" ).append("\n"); 
		query.append("				, EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		WHERE	H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND		H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND		H.TML_SO_OFC_CTY_CD = E.TML_SO_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("		AND		H.TML_SO_SEQ = E.TML_SO_SEQ(+)" ).append("\n"); 
		query.append("		AND		NVL(H.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("		AND		H.TML_INV_STS_CD <> 'R'" ).append("\n"); 
		query.append("		AND		H.TML_INV_RJCT_STS_CD <> 'RJ'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} == 'A')-- 2시간 배치 -> 1일전으로 수정" ).append("\n"); 
		query.append("		AND		H.INV_CFM_DT BETWEEN TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 1 AND TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} == 'M')-- 실시간(5분) 배치" ).append("\n"); 
		query.append("		AND		H.INV_NO			= X.INV_NO" ).append("\n"); 
		query.append("		AND		H.VNDR_SEQ			= X.INV_VNDR_SEQ" ).append("\n"); 
		query.append("		AND		H.INV_CFM_DT		= X.INV_CFM_DT" ).append("\n"); 
		query.append("		AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE 'X' END) = NVL(X.VSL_CD, 'X')" ).append("\n"); 
		query.append("		AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE 'X' END) = NVL(X.SKD_VOY_NO, 'X')" ).append("\n"); 
		query.append("		AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE 'X' END) = NVL(X.SKD_DIR_CD, 'X')" ).append("\n"); 
		query.append("		AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE 'X' END) = NVL(X.IO_BND_CD, 'X')" ).append("\n"); 
		query.append("		AND		X.BAT_PROG_STS_CD	= 'P'" ).append("\n"); 
		query.append("		AND		X.SUB_SYS_CD		= 'TES'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} == 'E')-- 메뉴얼 기간 배치 (Period로 조회)" ).append("\n"); 
		query.append("		AND		H.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[s_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		AND		NOT EXISTS (SELECT	'X'" ).append("\n"); 
		query.append("							FROM	EAS_TML_AUD X" ).append("\n"); 
		query.append("							WHERE	X.INV_NO			= H.INV_NO" ).append("\n"); 
		query.append("							AND		X.VNDR_SEQ			= H.VNDR_SEQ" ).append("\n"); 
		query.append("							AND		X.INV_CFM_DT		= H.INV_CFM_DT" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD = C.LGS_COST_CD" ).append("\n"); 
		query.append("		AND		C.EAS_AUD_FLG = 'Y'" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} != 'M') -- 실시간 배치가 아닌경우에 심사결과가 있는건은 제외" ).append("\n"); 
		query.append("		AND		NOT EXISTS (SELECT	1" ).append("\n"); 
		query.append("							FROM	EAS_TML_AUD A" ).append("\n"); 
		query.append("							WHERE	A.INV_NO   = H.INV_NO" ).append("\n"); 
		query.append("							AND		A.VNDR_SEQ = H.VNDR_SEQ" ).append("\n"); 
		query.append("							AND		A.INV_CFM_DT = H.INV_CFM_DT" ).append("\n"); 
		query.append("							AND		NVL(A.VSL_CD,'X')     = (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		NVL(A.SKD_VOY_NO,'X') = (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		NVL(A.SKD_DIR_CD,'X') = (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		NVL(A.IO_BND_CD,'X')  = (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE 'X' END)" ).append("\n"); 
		query.append("							AND		A.EXPN_AUD_STS_CD IN ('A', 'P', 'E')" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY H.INV_NO, H.VNDR_SEQ, H.INV_OFC_CD, H.INV_CFM_DT, H.TML_INV_TP_CD, D.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE NULL END)" ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE NULL END) " ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE NULL END) " ).append("\n"); 
		query.append("				, (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE NULL END) " ).append("\n"); 
		query.append("				, H.FM_PRD_DT" ).append("\n"); 
		query.append("				, H.TO_PRD_DT" ).append("\n"); 
		query.append("				, H.STO_DYS_IND_CD" ).append("\n"); 
		query.append("				, H.TML_CALC_IND_CD" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#if(${batch_tp_cd} != 'M') -- 실시간 배치가 아닌경우에 심사결과가 있는건은 제외" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT  DISTINCT A.INV_NO" ).append("\n"); 
		query.append("		, A.VNDR_SEQ" ).append("\n"); 
		query.append("		, EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(H.INV_OFC_CD) AS RHQ_CD" ).append("\n"); 
		query.append("		, TO_CHAR(A.INV_CFM_DT, 'YYYYMMDDHH24MISS') INV_CFM_DT" ).append("\n"); 
		query.append("		, A.TML_INV_TP_CD" ).append("\n"); 
		query.append("		, D.CALC_COST_GRP_CD" ).append("\n"); 
		query.append("		, A.VSL_CD" ).append("\n"); 
		query.append("		, A.SKD_VOY_NO" ).append("\n"); 
		query.append("		, A.SKD_DIR_CD" ).append("\n"); 
		query.append("		, A.IO_BND_CD" ).append("\n"); 
		query.append("		, TO_CHAR(ADD_MONTHS(TO_DATE(A.FM_PRD_DT, 'YYYYMMDD'), -1), 'YYYYMM') AS PRD_YM" ).append("\n"); 
		query.append("		, A.FM_PRD_DT" ).append("\n"); 
		query.append("		, A.TO_PRD_DT" ).append("\n"); 
		query.append("FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("		, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("		, EAS_TML_AUD A" ).append("\n"); 
		query.append("WHERE	A.INV_NO		= H.INV_NO" ).append("\n"); 
		query.append("AND		A.VNDR_SEQ		= H.VNDR_SEQ" ).append("\n"); 
		query.append("AND		A.INV_CFM_DT	= H.INV_CFM_DT" ).append("\n"); 
		query.append("AND		A.VSL_CD		= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE NULL END)" ).append("\n"); 
		query.append("AND		A.SKD_VOY_NO	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE NULL END)" ).append("\n"); 
		query.append("AND		A.SKD_DIR_CD	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE NULL END)" ).append("\n"); 
		query.append("AND		A.IO_BND_CD		= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE NULL END)" ).append("\n"); 
		query.append("AND		H.TML_SO_OFC_CTY_CD 	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND		H.TML_SO_SEQ			= D.TML_SO_SEQ" ).append("\n"); 
		query.append("AND		NVL(H.DELT_FLG, 'N') 	<> 'Y'" ).append("\n"); 
		query.append("AND		H.TML_INV_STS_CD 		<> 'R'" ).append("\n"); 
		query.append("AND		H.TML_INV_RJCT_STS_CD 	<> 'RJ'" ).append("\n"); 
		query.append("AND		(A.BAT_VOL_RSLT_CD	= 'F' OR A.BAT_AMT_RSLT_CD	= 'F' OR A.BAT_ESTM_VOL_RSLT_CD = 'F')" ).append("\n"); 
		query.append("AND		A.CRE_DT > TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 14 --// 14일내에 오류난 내역은 배치 재수행" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}