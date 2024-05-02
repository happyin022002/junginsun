/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TesAdvanceAuditDBDAOSearchVvdQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
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

public class TesAdvanceAuditDBDAOSearchVvdQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Batch VVD Quantity 조회
	  * </pre>
	  */
	public TesAdvanceAuditDBDAOSearchVvdQtyRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration").append("\n"); 
		query.append("FileName : TesAdvanceAuditDBDAOSearchVvdQtyRSQL").append("\n"); 
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
		query.append("WITH ESTM_VVD AS (" ).append("\n"); 
		query.append("	SELECT	H.YD_CD, D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, C.CNTR_STY_CD, D.IO_BND_CD, NVL(E.TS_FLG, 'N') TS_FLG" ).append("\n"); 
		query.append("	FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("		, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("		, TES_TML_SO_COST C" ).append("\n"); 
		query.append("		, EAS_TML_AUTO_AUD_CRTE E" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("		, EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	WHERE	H.TML_SO_OFC_CTY_CD		= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND		H.TML_SO_SEQ			= D.TML_SO_SEQ" ).append("\n"); 
		query.append("	AND		D.LGS_COST_CD			= C.LGS_COST_CD" ).append("\n"); 
		query.append("	AND		D.LGS_COST_CD			= E.LGS_COST_CD" ).append("\n"); 
		query.append("	AND		EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(H.INV_OFC_CD) = E.AUD_OFC_CD" ).append("\n"); 
		query.append("	AND		H.TML_INV_TP_CD			= 'TM'" ).append("\n"); 
		query.append("	AND		NVL(H.DELT_FLG, 'N')	<> 'Y'" ).append("\n"); 
		query.append("	AND		H.TML_INV_STS_CD		<> 'R'" ).append("\n"); 
		query.append("	AND		H.TML_INV_RJCT_STS_CD	<> 'RJ'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- 2시간 배치 -> 1일전으로 수정" ).append("\n"); 
		query.append("	#if(${batch_tp_cd} == 'A')" ).append("\n"); 
		query.append("	AND		H.INV_CFM_DT BETWEEN TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 1 AND TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- 실시간(5분) 배치" ).append("\n"); 
		query.append("	#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("	AND		H.INV_NO			= X.INV_NO" ).append("\n"); 
		query.append("	AND		H.VNDR_SEQ			= X.INV_VNDR_SEQ" ).append("\n"); 
		query.append("	AND		H.INV_CFM_DT		= X.INV_CFM_DT" ).append("\n"); 
		query.append("	AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE 'X' END) = NVL(X.VSL_CD, 'X')" ).append("\n"); 
		query.append("	AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE 'X' END) = NVL(X.SKD_VOY_NO, 'X')" ).append("\n"); 
		query.append("	AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE 'X' END) = NVL(X.SKD_DIR_CD, 'X')" ).append("\n"); 
		query.append("	AND		(CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE 'X' END) = NVL(X.IO_BND_CD, 'X')" ).append("\n"); 
		query.append("	AND		X.BAT_PROG_STS_CD	= 'P'" ).append("\n"); 
		query.append("	AND		X.SUB_SYS_CD		= 'TES'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	-- 메뉴얼 기간 배치 (Period로 조회)" ).append("\n"); 
		query.append("	#if(${batch_tp_cd} == 'E')" ).append("\n"); 
		query.append("	AND		H.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[s_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("	AND		NOT EXISTS (SELECT	'X'" ).append("\n"); 
		query.append("						FROM	EAS_TML_AUD X" ).append("\n"); 
		query.append("						WHERE	X.INV_NO			= H.INV_NO" ).append("\n"); 
		query.append("						AND		X.VNDR_SEQ			= H.VNDR_SEQ" ).append("\n"); 
		query.append("						AND		X.INV_CFM_DT		= H.INV_CFM_DT" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	GROUP BY H.YD_CD, D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, C.CNTR_STY_CD, D.IO_BND_CD, NVL(E.TS_FLG, 'N')" ).append("\n"); 
		query.append("	UNION " ).append("\n"); 
		query.append("	SELECT	H.YD_CD, D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, C.CNTR_STY_CD, D.IO_BND_CD, NVL(E.TS_FLG, 'N') TS_FLG" ).append("\n"); 
		query.append("	FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("		, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("		, EAS_TML_AUD A" ).append("\n"); 
		query.append("		, TES_TML_SO_COST C" ).append("\n"); 
		query.append("		, EAS_TML_AUTO_AUD_CRTE E" ).append("\n"); 
		query.append("	WHERE	A.INV_NO	= H.INV_NO" ).append("\n"); 
		query.append("	AND	A.VNDR_SEQ	= H.VNDR_SEQ" ).append("\n"); 
		query.append("	AND	A.INV_CFM_DT	= H.INV_CFM_DT" ).append("\n"); 
		query.append("	AND	A.VSL_CD	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.VSL_CD ELSE NULL END)" ).append("\n"); 
		query.append("	AND	A.SKD_VOY_NO	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_VOY_NO ELSE NULL END)" ).append("\n"); 
		query.append("	AND	A.SKD_DIR_CD	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.SKD_DIR_CD ELSE NULL END)" ).append("\n"); 
		query.append("	AND	A.IO_BND_CD	= (CASE WHEN H.TML_INV_TP_CD = 'TM' THEN D.IO_BND_CD ELSE NULL END)" ).append("\n"); 
		query.append("	AND	A.FM_PRD_DT	= (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN H.FM_PRD_DT ELSE NULL END)" ).append("\n"); 
		query.append("	AND	A.TO_PRD_DT	= (CASE WHEN H.TML_INV_TP_CD IN ('ST', 'OF') THEN H.TO_PRD_DT ELSE NULL END)" ).append("\n"); 
		query.append("	AND	H.TML_SO_OFC_CTY_CD	= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	AND	H.TML_SO_SEQ		= D.TML_SO_SEQ" ).append("\n"); 
		query.append("	AND	D.LGS_COST_CD		= C.LGS_COST_CD" ).append("\n"); 
		query.append("	AND	D.LGS_COST_CD		= E.LGS_COST_CD" ).append("\n"); 
		query.append("	AND	EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(H.INV_OFC_CD) = E.AUD_OFC_CD" ).append("\n"); 
		query.append("	AND	(A.BAT_VOL_RSLT_CD = 'F' OR A.BAT_AMT_RSLT_CD = 'F' OR A.BAT_ESTM_VOL_RSLT_CD = 'F')" ).append("\n"); 
		query.append("	AND	A.CRE_DT > TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 14 --// 14일내에 오류난 내역은 배치 재수행" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	, SRC_M AS (" ).append("\n"); 
		query.append("		-- 실항차 물량 집계" ).append("\n"); 
		query.append("		SELECT	  AA.YD_CD" ).append("\n"); 
		query.append("			, AA.VSL_CD" ).append("\n"); 
		query.append("			, AA.SKD_VOY_NO" ).append("\n"); 
		query.append("			, AA.SKD_DIR_CD            " ).append("\n"); 
		query.append("			, AA.IO_BND_CD" ).append("\n"); 
		query.append("			, AA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("			, NVL(TRIM(AA.TS_FLG), 'N') AS TS_FLG" ).append("\n"); 
		query.append("			, AA.FULL_MTY_CD" ).append("\n"); 
		query.append("			, AA.CNTR_TTL_QTY" ).append("\n"); 
		query.append("			, TO_NUMBER(BKG_GET_TOKEN_FNC(AA.SPE_QTY,1)) AS DCGO_QTY" ).append("\n"); 
		query.append("			, TO_NUMBER(BKG_GET_TOKEN_FNC(AA.SPE_QTY,2)) AS RC_QTY" ).append("\n"); 
		query.append("			, TO_NUMBER(BKG_GET_TOKEN_FNC(AA.SPE_QTY,3)) AS DG_RC_QTY" ).append("\n"); 
		query.append("			, TO_NUMBER(BKG_GET_TOKEN_FNC(AA.SPE_QTY,4)) AS AWK_CGO_QTY" ).append("\n"); 
		query.append("			, TO_NUMBER(BKG_GET_TOKEN_FNC(AA.SPE_QTY,5)) AS BB_CGO_QTY" ).append("\n"); 
		query.append("			, TO_NUMBER(BKG_GET_TOKEN_FNC(AA.SPE_QTY,6)) AS AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("			, TO_NUMBER(BKG_GET_TOKEN_FNC(AA.SPE_QTY,7)) AS HNGR_CGO_QTY" ).append("\n"); 
		query.append("			, TO_NUMBER(BKG_GET_TOKEN_FNC(AA.SPE_QTY,8)) AS CFS_CGO_QTY" ).append("\n"); 
		query.append("		FROM	(" ).append("\n"); 
		query.append("			SELECT	/*+ USE_HASH (A B) */" ).append("\n"); 
		query.append("				  A.YD_CD" ).append("\n"); 
		query.append("				, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, A.FULL_MTY_CD" ).append("\n"); 
		query.append("				, 'O' AS IO_BND_CD" ).append("\n"); 
		query.append("				, A.TS_FLG" ).append("\n"); 
		query.append("				, A.VSL_CD" ).append("\n"); 
		query.append("				, A.SKD_VOY_NO" ).append("\n"); 
		query.append("				, A.SKD_DIR_CD" ).append("\n"); 
		query.append("				, SUM(A.OB_QTY) AS CNTR_TTL_QTY" ).append("\n"); 
		query.append("				, (SELECT SUM(CASE WHEN Z.DCGO_FLG = 'Y' AND Z.RC_FLG = 'N' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("                                   ||','||SUM(CASE WHEN Z.DCGO_FLG = 'N' AND Z.RC_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("                                   ||','||SUM(CASE WHEN Z.DCGO_FLG = 'Y' AND Z.RC_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("                                   ||','||SUM(CASE WHEN Z.AWK_CGO_FLG = 'Y' AND Z.BB_CGO_FLG = 'N' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("                                   ||','||SUM(CASE WHEN Z.AWK_CGO_FLG = 'N' AND Z.BB_CGO_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("                                   ||','||SUM(CASE WHEN Z.AWK_CGO_FLG = 'Y' AND Z.BB_CGO_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("                                   ||','||SUM(CASE WHEN Z.HNGR_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("                                   ||','||SUM(CASE WHEN Y.RCV_TERM_CD = 'S' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("				  FROM	BKG_VVD X" ).append("\n"); 
		query.append("					, BKG_BOOKING Y" ).append("\n"); 
		query.append("					, BKG_CONTAINER Z" ).append("\n"); 
		query.append("				WHERE	X.BKG_NO	= Y.BKG_NO" ).append("\n"); 
		query.append("                                AND	X.BKG_NO	= Z.BKG_NO" ).append("\n"); 
		query.append("                                AND	X.VSL_CD	= A.VSL_CD" ).append("\n"); 
		query.append("                                AND	X.SKD_VOY_NO	= A.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND	X.SKD_DIR_CD	= A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND	Y.POL_CD	= SUBSTR(A.YD_CD, 1,5)" ).append("\n"); 
		query.append("                                AND	Z.CNTR_TPSZ_CD	= A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				) AS SPE_QTY" ).append("\n"); 
		query.append("			FROM	CIM_PORT_MTCH_BAK_SMRY A" ).append("\n"); 
		query.append("				, ESTM_VVD B" ).append("\n"); 
		query.append("			WHERE	A.YD_CD		= B.YD_CD" ).append("\n"); 
		query.append("			AND	A.VSL_CD	= B.VSL_CD" ).append("\n"); 
		query.append("			AND	A.SKD_VOY_NO	= B.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND	A.SKD_DIR_CD	= B.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND	A.FULL_MTY_CD	= B.CNTR_STY_CD" ).append("\n"); 
		query.append("			AND	(CASE WHEN A.FULL_MTY_CD = 'F' AND NVL(A.TS_FLG,'N') = 'N' AND TRIM(A.INLND_SVC_MOD_CD) IS NOT NULL THEN A.FULL_MTY_CD" ).append("\n"); 
		query.append("					WHEN A.FULL_MTY_CD = 'F' AND NVL(A.TS_FLG,'N') = 'Y' THEN A.FULL_MTY_CD" ).append("\n"); 
		query.append("					WHEN A.FULL_MTY_CD = 'M' THEN A.FULL_MTY_CD" ).append("\n"); 
		query.append("				END) = A.FULL_MTY_CD" ).append("\n"); 
		query.append("			AND	A.TS_FLG	= B.TS_FLG" ).append("\n"); 
		query.append("			AND	B.IO_BND_CD	= CASE WHEN A.OB_QTY > 0 THEN 'O' END" ).append("\n"); 
		query.append("			AND	A.TGT_MVMT_DT BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS'), -6), 'YYYYMMDD') AND TO_CHAR(TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("			GROUP BY A.YD_CD" ).append("\n"); 
		query.append("				, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, A.FULL_MTY_CD" ).append("\n"); 
		query.append("				, A.TS_FLG" ).append("\n"); 
		query.append("				, A.VSL_CD" ).append("\n"); 
		query.append("				, A.SKD_VOY_NO" ).append("\n"); 
		query.append("				, A.SKD_DIR_CD" ).append("\n"); 
		query.append("			UNION ALL" ).append("\n"); 
		query.append("			SELECT	/*+ USE_HASH (A B) */" ).append("\n"); 
		query.append("				  A.YD_CD" ).append("\n"); 
		query.append("				, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, A.FULL_MTY_CD" ).append("\n"); 
		query.append("				, 'I' AS IO_BND_CD" ).append("\n"); 
		query.append("				, A.TS_FLG" ).append("\n"); 
		query.append("				, A.VSL_CD" ).append("\n"); 
		query.append("				, A.SKD_VOY_NO" ).append("\n"); 
		query.append("				, A.SKD_DIR_CD" ).append("\n"); 
		query.append("				, SUM(A.IB_QTY) AS CNTR_TTL_QTY" ).append("\n"); 
		query.append("				,(SELECT SUM(CASE WHEN Z.DCGO_FLG = 'Y' AND Z.RC_FLG = 'N' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("					||','||SUM(CASE WHEN Z.DCGO_FLG = 'N' AND Z.RC_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("					||','||SUM(CASE WHEN Z.DCGO_FLG = 'Y' AND Z.RC_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("					||','||SUM(CASE WHEN Z.AWK_CGO_FLG = 'Y' AND Z.BB_CGO_FLG = 'N' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("					||','||SUM(CASE WHEN Z.AWK_CGO_FLG = 'N' AND Z.BB_CGO_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("					||','||SUM(CASE WHEN Z.AWK_CGO_FLG = 'Y' AND Z.BB_CGO_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("					||','||SUM(CASE WHEN Z.HNGR_FLG = 'Y' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("					||','||SUM(CASE WHEN Y.RCV_TERM_CD = 'S' THEN 1 ELSE 0 END)" ).append("\n"); 
		query.append("				FROM	BKG_VVD X" ).append("\n"); 
		query.append("					, BKG_BOOKING Y" ).append("\n"); 
		query.append("					, BKG_CONTAINER Z" ).append("\n"); 
		query.append("				WHERE	X.BKG_NO	= Y.BKG_NO" ).append("\n"); 
		query.append("				AND	X.BKG_NO	= Z.BKG_NO" ).append("\n"); 
		query.append("				AND	X.VSL_CD	= A.VSL_CD" ).append("\n"); 
		query.append("				AND	X.SKD_VOY_NO	= A.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND	X.SKD_DIR_CD	= A.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND	Y.POD_CD	= SUBSTR(A.YD_CD, 1,5)" ).append("\n"); 
		query.append("				AND	Z.CNTR_TPSZ_CD	= A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				) AS SPE_QTY" ).append("\n"); 
		query.append("			FROM	CIM_PORT_MTCH_BAK_SMRY A" ).append("\n"); 
		query.append("				, ESTM_VVD B" ).append("\n"); 
		query.append("			WHERE	A.YD_CD      = B.YD_CD" ).append("\n"); 
		query.append("			AND	A.VSL_CD     = B.VSL_CD" ).append("\n"); 
		query.append("			AND	A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("			AND	A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("			AND	A.FULL_MTY_CD = B.CNTR_STY_CD" ).append("\n"); 
		query.append("			AND	(CASE WHEN A.FULL_MTY_CD = 'F' AND NVL(A.TS_FLG,'N') = 'N' AND TRIM(A.INLND_SVC_MOD_CD) IS NOT NULL THEN A.FULL_MTY_CD" ).append("\n"); 
		query.append("                                      WHEN A.FULL_MTY_CD = 'F' AND NVL(A.TS_FLG,'N') = 'Y' THEN A.FULL_MTY_CD" ).append("\n"); 
		query.append("                                      WHEN A.FULL_MTY_CD = 'M' THEN A.FULL_MTY_CD" ).append("\n"); 
		query.append("				END) = A.FULL_MTY_CD" ).append("\n"); 
		query.append("			AND	A.TS_FLG = B.TS_FLG" ).append("\n"); 
		query.append("			AND	B.IO_BND_CD = CASE WHEN A.IB_QTY > 0 THEN 'I' END" ).append("\n"); 
		query.append("			AND	A.TGT_MVMT_DT BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS'), -6), 'YYYYMMDD') AND TO_CHAR(TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS'), 'YYYYMMDD')" ).append("\n"); 
		query.append("			GROUP BY  A.YD_CD" ).append("\n"); 
		query.append("				, A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, A.FULL_MTY_CD" ).append("\n"); 
		query.append("				, A.TS_FLG" ).append("\n"); 
		query.append("				, A.VSL_CD" ).append("\n"); 
		query.append("				, A.SKD_VOY_NO" ).append("\n"); 
		query.append("				, A.SKD_DIR_CD" ).append("\n"); 
		query.append("			) AA" ).append("\n"); 
		query.append("		UNION ALL" ).append("\n"); 
		query.append("		-- 공통항차 물량 집계" ).append("\n"); 
		query.append("		SELECT	  H.YD_CD" ).append("\n"); 
		query.append("				, D.VSL_CD" ).append("\n"); 
		query.append("				, D.SKD_VOY_NO" ).append("\n"); 
		query.append("				, D.SKD_DIR_CD" ).append("\n"); 
		query.append("				, D.IO_BND_CD" ).append("\n"); 
		query.append("				, NVL(D.CNTR_TPSZ_CD, 'XX') AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				, NVL(TRIM(E.TS_FLG), 'N') AS TS_FLG" ).append("\n"); 
		query.append("				, C.CNTR_STY_CD AS FULL_MTY_CD" ).append("\n"); 
		query.append("				, SUM(D.RVIS_VOL_QTY) AS CNTR_TTL_QTY" ).append("\n"); 
		query.append("				, SUM((CASE WHEN DECODE(D.DCGO_IND_CD, 'N', 'N', 'Y') = 'Y' AND D.RC_FLG = 'N' THEN D.RVIS_VOL_QTY ELSE 0 END)) AS DCGO_QTY" ).append("\n"); 
		query.append("				, SUM((CASE WHEN DECODE(D.DCGO_IND_CD, 'N', 'N', 'Y') = 'N' AND D.RC_FLG = 'Y' THEN D.RVIS_VOL_QTY ELSE 0 END)) AS RC_QTY" ).append("\n"); 
		query.append("				, SUM((CASE WHEN DECODE(D.DCGO_IND_CD, 'N', 'N', 'Y') = 'Y' AND D.RC_FLG = 'Y' THEN D.RVIS_VOL_QTY ELSE 0 END)) AS DG_RC_QTY" ).append("\n"); 
		query.append("				, SUM((CASE WHEN E.SPCL_CGO_TP_CALC_CD = 'AK' THEN D.RVIS_VOL_QTY ELSE 0 END)) AS AWK_CGO_QTY" ).append("\n"); 
		query.append("				, SUM((CASE WHEN E.SPCL_CGO_TP_CALC_CD = 'BB' THEN D.RVIS_VOL_QTY ELSE 0 END)) AS BB_CGO_QTY" ).append("\n"); 
		query.append("				, SUM((CASE WHEN E.SPCL_CGO_TP_CALC_CD = 'BA' THEN D.RVIS_VOL_QTY ELSE 0 END)) AS AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("				, SUM((CASE WHEN E.SPCL_CGO_TP_CALC_CD = 'GH' THEN D.RVIS_VOL_QTY ELSE 0 END)) AS HNGR_CGO_QTY" ).append("\n"); 
		query.append("				, SUM((CASE WHEN E.SPCL_CGO_TP_CALC_CD = 'CF' THEN D.RVIS_VOL_QTY ELSE 0 END)) AS CFS_CGO_QTY" ).append("\n"); 
		query.append("		FROM	TES_TML_SO_HDR H" ).append("\n"); 
		query.append("				, TES_TML_SO_DTL D" ).append("\n"); 
		query.append("				, TES_TML_SO_COST C" ).append("\n"); 
		query.append("				, EAS_TML_AUTO_AUD_CRTE E" ).append("\n"); 
		query.append("				#if(${batch_tp_cd} == 'M')" ).append("\n"); 
		query.append("				, EAS_AUTO_AUD_BAT X" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("		WHERE	H.TML_SO_OFC_CTY_CD		= D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("		AND		H.TML_SO_SEQ			= D.TML_SO_SEQ" ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD			= C.LGS_COST_CD                   " ).append("\n"); 
		query.append("		AND		D.LGS_COST_CD			= E.LGS_COST_CD" ).append("\n"); 
		query.append("		AND		EAS_EXPN_AUD_PKG.GET_RHQ_OFC_CD(H.INV_OFC_CD) = E.AUD_OFC_CD" ).append("\n"); 
		query.append("		AND		H.TML_INV_TP_CD			= 'TM'" ).append("\n"); 
		query.append("		AND		NVL(H.DELT_FLG, 'N')	<> 'Y'" ).append("\n"); 
		query.append("		AND		H.TML_INV_STS_CD		<> 'R'" ).append("\n"); 
		query.append("		AND		H.TML_INV_RJCT_STS_CD	<> 'RJ'" ).append("\n"); 
		query.append("		AND		D.VSL_CD				= 'CNTC'" ).append("\n"); 
		query.append("		AND		D.SKD_VOY_NO IN (SELECT X.SKD_VOY_NO FROM ESTM_VVD X WHERE X.VSL_CD = 'CNTC' GROUP BY X.SKD_VOY_NO)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- 2시간 배치 -> 1일전으로 수정" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} == 'A')" ).append("\n"); 
		query.append("		AND		H.INV_CFM_DT BETWEEN TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS') - 1 AND TO_DATE(@[to_datetime], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- 실시간(5분) 배치" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} == 'M')" ).append("\n"); 
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
		query.append("		-- 메뉴얼 기간 배치 (Period로 조회)" ).append("\n"); 
		query.append("		#if(${batch_tp_cd} == 'E')" ).append("\n"); 
		query.append("		AND		H.INV_CFM_DT BETWEEN TO_DATE(@[s_fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[s_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("		AND		NOT EXISTS (SELECT	'X'" ).append("\n"); 
		query.append("							FROM	EAS_TML_AUD X" ).append("\n"); 
		query.append("							WHERE	X.INV_NO			= H.INV_NO" ).append("\n"); 
		query.append("							AND		X.VNDR_SEQ			= H.VNDR_SEQ" ).append("\n"); 
		query.append("							AND		X.INV_CFM_DT		= H.INV_CFM_DT" ).append("\n"); 
		query.append("							)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		GROUP BY  H.YD_CD" ).append("\n"); 
		query.append("			, D.VSL_CD" ).append("\n"); 
		query.append("			, D.SKD_VOY_NO" ).append("\n"); 
		query.append("			, D.SKD_DIR_CD" ).append("\n"); 
		query.append("			, D.IO_BND_CD" ).append("\n"); 
		query.append("			, NVL(D.CNTR_TPSZ_CD, 'XX')" ).append("\n"); 
		query.append("			, NVL(TRIM(E.TS_FLG), 'N')" ).append("\n"); 
		query.append("			, C.CNTR_STY_CD " ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	SELECT	  YD_CD" ).append("\n"); 
		query.append("		, VSL_CD" ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, IO_BND_CD" ).append("\n"); 
		query.append("		, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, TS_FLG" ).append("\n"); 
		query.append("		, FULL_MTY_CD" ).append("\n"); 
		query.append("		, CNTR_TTL_QTY" ).append("\n"); 
		query.append("		, DCGO_QTY" ).append("\n"); 
		query.append("		, RC_QTY" ).append("\n"); 
		query.append("		, DG_RC_QTY" ).append("\n"); 
		query.append("		, AWK_CGO_QTY" ).append("\n"); 
		query.append("		, BB_CGO_QTY" ).append("\n"); 
		query.append("		, AWK_BB_CGO_QTY" ).append("\n"); 
		query.append("		, HNGR_CGO_QTY" ).append("\n"); 
		query.append("		, CFS_CGO_QTY" ).append("\n"); 
		query.append("		, 'BATCH' AS CRE_USR_ID" ).append("\n"); 
		query.append("		, SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("		, 'BATCH' AS UPD_USR_ID" ).append("\n"); 
		query.append("		, SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("	FROM	SRC_M" ).append("\n"); 
		query.append("	WHERE	CNTR_TPSZ_CD <> 'XX'" ).append("\n"); 
		query.append("	UNION ALL" ).append("\n"); 
		query.append("	SELECT	  YD_CD" ).append("\n"); 
		query.append("		, VSL_CD" ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, IO_BND_CD" ).append("\n"); 
		query.append("		, 'XX' AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, TS_FLG" ).append("\n"); 
		query.append("		, FULL_MTY_CD" ).append("\n"); 
		query.append("		, SUM(CNTR_TTL_QTY)" ).append("\n"); 
		query.append("		, SUM(DCGO_QTY)" ).append("\n"); 
		query.append("		, SUM(RC_QTY)" ).append("\n"); 
		query.append("		, SUM(DG_RC_QTY)" ).append("\n"); 
		query.append("		, SUM(AWK_CGO_QTY)" ).append("\n"); 
		query.append("		, SUM(BB_CGO_QTY)" ).append("\n"); 
		query.append("		, SUM(AWK_BB_CGO_QTY)" ).append("\n"); 
		query.append("		, SUM(HNGR_CGO_QTY)" ).append("\n"); 
		query.append("		, SUM(CFS_CGO_QTY)" ).append("\n"); 
		query.append("		, 'BATCH' AS CRE_USR_ID" ).append("\n"); 
		query.append("		, SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("		, 'BATCH' AS UPD_USR_ID" ).append("\n"); 
		query.append("		, SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("	FROM	SRC_M" ).append("\n"); 
		query.append("	GROUP BY  YD_CD" ).append("\n"); 
		query.append("		, VSL_CD" ).append("\n"); 
		query.append("		, SKD_VOY_NO" ).append("\n"); 
		query.append("		, SKD_DIR_CD" ).append("\n"); 
		query.append("		, IO_BND_CD" ).append("\n"); 
		query.append("		, TS_FLG" ).append("\n"); 
		query.append("		, FULL_MTY_CD" ).append("\n"); 

	}
}