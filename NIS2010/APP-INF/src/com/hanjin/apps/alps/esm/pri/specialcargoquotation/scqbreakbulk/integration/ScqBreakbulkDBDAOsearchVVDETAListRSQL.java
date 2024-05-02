/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScqBreakbulkDBDAOsearchVVDETAListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.26 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SongHoJin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScqBreakbulkDBDAOsearchVVDETAListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Lane 및 POL 기준으로 대상 VVD 와 ETA DT 를 조회
	  * </pre>
	  */
	public ScqBreakbulkDBDAOsearchVVDETAListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scq_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.integration").append("\n"); 
		query.append("FileName : ScqBreakbulkDBDAOsearchVVDETAListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT CD, NM" ).append("\n"); 
		query.append("FROM	" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT  VVD_CD AS CD, TO_CHAR ( VPS_ETA_DT, 'YYYY-MM-DD HH24:MI' ) AS NM" ).append("\n"); 
		query.append("		FROM    PRI_SCQ_BB_MN " ).append("\n"); 
		query.append("		WHERE	SCQ_RQST_NO = @[scq_rqst_no]" ).append("\n"); 
		query.append("		AND		SCQ_VER_NO  = @[scq_ver_no]" ).append("\n"); 
		query.append("		UNION   ALL" ).append("\n"); 
		query.append("		SELECT	T2.VSL_CD||T2.SKD_VOY_NO ||T2.SKD_DIR_CD      AS CD" ).append("\n"); 
		query.append("			,   TO_CHAR (T3.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') AS NM" ).append("\n"); 
		query.append("		FROM 	(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				/* 주어진 조회 기간내에 포함되는 VVD및 그와 연결되는 VVD를 조회한다.*/" ).append("\n"); 
		query.append("				SELECT 	*" ).append("\n"); 
		query.append("				FROM 	(" ).append("\n"); 
		query.append("						SELECT 	DISTINCT" ).append("\n"); 
		query.append("								T1.VSL_CD" ).append("\n"); 
		query.append("							,	DECODE(MOD(Y, 2), 1, SKD_VOY_NO, 0, TURN_SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append("							,	DECODE(MOD(Y, 2), 1, SKD_DIR_CD, 0, TURN_SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("						FROM 	(" ).append("\n"); 
		query.append("								SELECT	T1.*" ).append("\n"); 
		query.append("								FROM	(" ).append("\n"); 
		query.append("										SELECT	T1.*" ).append("\n"); 
		query.append("											,	ROW_NUMBER() OVER(PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD ORDER BY TURN_SKD_VOY_NO) X" ).append("\n"); 
		query.append("										FROM 	(" ).append("\n"); 
		query.append("												SELECT 		T1.VSL_CD" ).append("\n"); 
		query.append("														,	T1.SKD_VOY_NO" ).append("\n"); 
		query.append("														,	T1.SKD_DIR_CD" ).append("\n"); 
		query.append("														,	CASE 	WHEN T1.VSL_SLAN_DIR_SEQ=1 AND T1.TURN_PORT_IND_CD = 'D' THEN T1.TURN_SKD_VOY_NO							/* 첫번째 DIR의 경우, TURN_PORT_IND_CD가 'D' 즉, 두번째 DIR의 SKD_VOY_NO를 구한다.*/" ).append("\n"); 
		query.append("																	WHEN T1.VSL_SLAN_DIR_SEQ=2 AND T1.TURN_PORT_FLG    = 'Y' AND T1.TURN_PORT_IND_CD='Y' THEN T1.TURN_SKD_VOY_NO /* 두번째 DIR의 경우, TURN_PORT_IND_CD가 'Y' 즉, 이전 VVD의 첫번째 DIR의 SKD_VOY_NO를 구한다.*/" ).append("\n"); 
		query.append("																	ELSE 'XXXX'" ).append("\n"); 
		query.append("															END 	TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("														,	CASE 	WHEN T1.VSL_SLAN_DIR_SEQ=1 AND T1.TURN_PORT_IND_CD = 'D' THEN T1.TURN_SKD_DIR_CD 							/* 첫번째 DIR의 경우, TURN_PORT_IND_CD가 'D' 즉, 두번째 DIR의 SKD_DIR_CD를 구한다.*/" ).append("\n"); 
		query.append("																	WHEN T1.VSL_SLAN_DIR_SEQ=2 AND T1.TURN_PORT_FLG='Y' AND T1.TURN_PORT_IND_CD='Y' THEN T1.TURN_SKD_DIR_CD 	/* 두번째 DIR의 경우, TURN_PORT_IND_CD가 'Y' 즉, 이전 VVD의 첫번째 DIR의 SKD_DIR_CD를 구한다.*/" ).append("\n"); 
		query.append("																	ELSE 'XXXX'" ).append("\n"); 
		query.append("															END 	TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("												FROM 		(" ).append("\n"); 
		query.append("															/* VVD별 최소ETB, 최대ETD 계산 */" ).append("\n"); 
		query.append("															SELECT" ).append("\n"); 
		query.append("																		T2.VSL_CD" ).append("\n"); 
		query.append("																	,	T2.SKD_VOY_NO" ).append("\n"); 
		query.append("																	,	T2.SKD_DIR_CD" ).append("\n"); 
		query.append("																	,	T1.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("																	,	T2.VPS_PORT_CD" ).append("\n"); 
		query.append("																	,	T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("																	,	T2.CLPT_SEQ" ).append("\n"); 
		query.append("																	,	T2.VPS_ETB_DT" ).append("\n"); 
		query.append("																	,	T2.VPS_ETD_DT" ).append("\n"); 
		query.append("																	,	T2.TURN_PORT_FLG" ).append("\n"); 
		query.append("																	,	T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("																	,	T2.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("																	,	T2.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("																	,	FIRST_VALUE(T2.VPS_ETB_DT) OVER(PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY CLPT_SEQ ASC) FIRST_ETB" ).append("\n"); 
		query.append("																	,	FIRST_VALUE(T2.VPS_ETD_DT) OVER(PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY CLPT_SEQ DESC) LAST_ETD" ).append("\n"); 
		query.append("															FROM 		(" ).append("\n"); 
		query.append("																		SELECT" ).append("\n"); 
		query.append("																					T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("																				, 	T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("																				, 	T1.VSL_CD" ).append("\n"); 
		query.append("																				, 	T1.SKD_VOY_NO" ).append("\n"); 
		query.append("																				, 	T1.SKD_DIR_CD" ).append("\n"); 
		query.append("																					/* PF SKD DETAIL 을 이용하여 DIRECTION SEQ를 구함*/" ).append("\n"); 
		query.append("																				, 	DECODE(MIN(PORT_ROTN_SEQ), NULL, ROW_NUMBER() OVER(PARTITION BY VSL_CD, SKD_VOY_NO ORDER BY T1.N1ST_PORT_BRTH_DT), 1, 1, 2) AS VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("																		FROM 		VSK_VSL_SKD 	T1" ).append("\n"); 
		query.append("																				, 	VSK_PF_SKD_DTL 	T2" ).append("\n"); 
		query.append("																		WHERE 		1 = 1" ).append("\n"); 
		query.append("																		AND 		T1.VSL_SLAN_CD  = T2.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("																		AND 		T1.PF_SKD_TP_CD = T2.PF_SVC_TP_CD(+)" ).append("\n"); 
		query.append("																		AND 		T1.SKD_DIR_CD   = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("																		AND 		T1.VSL_SLAN_CD 	= @[lane_cd]" ).append("\n"); 
		query.append("																		GROUP BY 	T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("																				, 	T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("																				, 	T1.VSL_CD" ).append("\n"); 
		query.append("																				, 	T1.SKD_VOY_NO" ).append("\n"); 
		query.append("																				,	T1.SKD_DIR_CD" ).append("\n"); 
		query.append("																				, 	T1.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("																		) T1" ).append("\n"); 
		query.append("																	, 	VSK_VSL_PORT_SKD 		T2" ).append("\n"); 
		query.append("																		WHERE 		1 = 1" ).append("\n"); 
		query.append("																		AND T1.VSL_SLAN_CD		= @[lane_cd]" ).append("\n"); 
		query.append("																		AND T2.SLAN_CD			= @[lane_cd]" ).append("\n"); 
		query.append("																		AND T1.VSL_CD			= T2.VSL_CD" ).append("\n"); 
		query.append("																		AND T1.SKD_VOY_NO		= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("																		AND T1.SKD_DIR_CD		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("																		AND T2.TURN_PORT_IND_CD	!= 'V'" ).append("\n"); 
		query.append("														   ) T1" ).append("\n"); 
		query.append("													WHERE 	1 = 1" ).append("\n"); 
		query.append("													AND 	SYSDATE - 30 <= T1.LAST_ETD" ).append("\n"); 
		query.append("													AND 	SYSDATE + 90 >= T1.FIRST_ETB" ).append("\n"); 
		query.append("													/*" ).append("\n"); 
		query.append("													AND 	TO_DATE('2013-07-01', 'YYYY-MM-DD') <= T1.LAST_ETD" ).append("\n"); 
		query.append("													AND 	TO_DATE('2013-09-30', 'YYYY-MM-DD') >= T1.FIRST_ETB" ).append("\n"); 
		query.append("													*/" ).append("\n"); 
		query.append("													) T1" ).append("\n"); 
		query.append("											) T1" ).append("\n"); 
		query.append("										WHERE X = 1" ).append("\n"); 
		query.append("										) T1" ).append("\n"); 
		query.append("										/* T1에서 TURN_SKD_VOY_NO, TURN_SKD_DIR_CD를 끌어내기 위해 인위적으로 2개 ROW를 갖는 테이블을 조인한다.*/" ).append("\n"); 
		query.append("									,	(SELECT ROWNUM AS Y FROM DUAL CONNECT BY LEVEL <= 2) T2" ).append("\n"); 
		query.append("								) T1" ).append("\n"); 
		query.append("						WHERE 	T1.SKD_VOY_NO 	!= 'XXXX'" ).append("\n"); 
		query.append("						AND 	T1.SKD_DIR_CD	!= 'XXXX'" ).append("\n"); 
		query.append("						)T1" ).append("\n"); 
		query.append("					, 	(" ).append("\n"); 
		query.append("						SELECT" ).append("\n"); 
		query.append("									T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("								, 	T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("								, 	T1.VSL_CD" ).append("\n"); 
		query.append("								, 	T1.SKD_VOY_NO" ).append("\n"); 
		query.append("								, 	T1.SKD_DIR_CD" ).append("\n"); 
		query.append("								, 	MAX(T1.SKD_RMK) AS SKD_RMK" ).append("\n"); 
		query.append("									/* PF SKD DETAIL 을 이용하여 DIRECTION SEQ를 구함*/" ).append("\n"); 
		query.append("								, 	DECODE(MIN(PORT_ROTN_SEQ), NULL, ROW_NUMBER() OVER(PARTITION BY VSL_CD, SKD_VOY_NO ORDER BY T1.N1ST_PORT_BRTH_DT), 1, 1, 2) AS VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("								,	T1.ACT_CRR_CD" ).append("\n"); 
		query.append("							FROM 	VSK_VSL_SKD 	T1" ).append("\n"); 
		query.append("								, 	VSK_PF_SKD_DTL 	T2" ).append("\n"); 
		query.append("							WHERE 	1 = 1" ).append("\n"); 
		query.append("							AND 	T1.VSL_SLAN_CD  = T2.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("							AND 	T1.PF_SKD_TP_CD = T2.PF_SVC_TP_CD(+)" ).append("\n"); 
		query.append("							AND 	T1.SKD_DIR_CD   = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("							AND 	T1.VSL_SLAN_CD 	= @[lane_cd]" ).append("\n"); 
		query.append("							GROUP BY T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("								, 	T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("								, 	T1.VSL_CD" ).append("\n"); 
		query.append("								, 	T1.SKD_VOY_NO" ).append("\n"); 
		query.append("								, 	T1.SKD_DIR_CD" ).append("\n"); 
		query.append("								, 	T1.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("								,	T1.ACT_CRR_CD" ).append("\n"); 
		query.append("						) T2" ).append("\n"); 
		query.append("					, 	VSK_VSL_PORT_SKD T3" ).append("\n"); 
		query.append("					, 	MDM_VSL_SVC_LANE T4" ).append("\n"); 
		query.append("				WHERE 	1 = 1" ).append("\n"); 
		query.append("				AND 	T2.VSL_SLAN_CD	= @[lane_cd]" ).append("\n"); 
		query.append("				AND 	T2.VSL_SLAN_CD 			=  T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("				AND 	T1.VSL_CD				=  T2.VSL_CD" ).append("\n"); 
		query.append("				AND 	T1.SKD_VOY_NO			=  T2.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND 	T1.SKD_DIR_CD			=  T2.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND 	T2.VSL_CD				=  T3.VSL_CD" ).append("\n"); 
		query.append("				AND 	T2.SKD_VOY_NO			=  T3.SKD_VOY_NO" ).append("\n"); 
		query.append("				AND 	T2.SKD_DIR_CD			=  T3.SKD_DIR_CD" ).append("\n"); 
		query.append("				AND 	T3.TURN_PORT_IND_CD		!= 'D'" ).append("\n"); 
		query.append("				AND 	T3.TURN_PORT_IND_CD		!= 'V'" ).append("\n"); 
		query.append("				AND 	T4.VSL_TP_CD			=  'C' 	/*컨테이너선*/" ).append("\n"); 
		query.append("				AND     T3.VPS_PORT_CD          = @[pol_cd]" ).append("\n"); 
		query.append("				AND     T3.CLPT_IND_SEQ         =" ).append("\n"); 
		query.append("						  ( SELECT  MIN ( X.CLPT_IND_SEQ )" ).append("\n"); 
		query.append("							FROM    VSK_VSL_PORT_SKD X" ).append("\n"); 
		query.append("							WHERE   X.VSL_CD = T3.VSL_CD" ).append("\n"); 
		query.append("							AND     X.SKD_VOY_NO = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("							AND     X.SKD_DIR_CD = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("							AND     X.VPS_PORT_CD = T3.VPS_PORT_CD )" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("	ORDER BY NM, CD" ).append("\n"); 

	}
}