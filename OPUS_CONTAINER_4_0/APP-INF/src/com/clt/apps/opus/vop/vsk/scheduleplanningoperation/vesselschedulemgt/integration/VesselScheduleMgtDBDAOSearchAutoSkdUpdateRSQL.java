/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchAutoSkdUpdateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchAutoSkdUpdateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchAutoSkdUpdateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchAutoSkdUpdateRSQL").append("\n"); 
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
		query.append("SELECT  T31.LVL, T31.VSL_CD, T31.SKD_VOY_NO, T31.SKD_DIR_CD" ).append("\n"); 
		query.append("        , T31.VPS_PORT_CD, T31.CLPT_IND_SEQ, T31.CLPT_SEQ" ).append("\n"); 
		query.append("		, T31.YD_CD, T31.SLAN_CD, T31.ACT_INP_FLG" ).append("\n"); 
		query.append("        , TO_CHAR(T31.PF_ETA_DT, 'YYYYMMDDHH24MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("		, TO_CHAR(T31.PF_ETB_DT, 'YYYYMMDDHH24MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("		, TO_CHAR(T31.PF_ETD_DT, 'YYYYMMDDHH24MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T31.INIT_ETA_DT, 'YYYYMMDDHH24MI') AS INIT_ETA_DT" ).append("\n"); 
		query.append("		, TO_CHAR(T31.INIT_ETB_DT, 'YYYYMMDDHH24MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("		, TO_CHAR(T31.INIT_ETD_DT, 'YYYYMMDDHH24MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("        , TO_CHAR(T31.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("		, TO_CHAR(T31.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("		, TO_CHAR(T31.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("        , T31.TURN_PORT_FLG, T31.TURN_PORT_IND_CD, T31.TURN_SKD_VOY_NO, T31.TURN_SKD_DIR_CD, T31.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("		, NVL(T31.PORT_BUF_HRS, T32.PORT_BUF_HRS) AS PORT_BUF_HRS" ).append("\n"); 
		query.append("		, NVL(T31.SEA_BUF_HRS, T32.SEA_BUF_HRS) AS SEA_BUF_HRS" ).append("\n"); 
		query.append("        , T31.VSL_SLAN_CD, T31.PF_SKD_TP_CD" ).append("\n"); 
		query.append("		, T31.AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("        , T32.MNVR_IN_HRS, T32.ACT_WRK_HRS, T32.MNVR_OUT_HRS, T32.TZTM_HRS" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("            SELECT GMT_HRS/60.0 FROM MDM_LOCATION" ).append("\n"); 
		query.append("             WHERE LOC_CD = T31.VPS_PORT_CD" ).append("\n"); 
		query.append("          ) AS GMT_HRS" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  T21.LVL, T21.VSL_CD, T21.SKD_VOY_NO, T21.SKD_DIR_CD" ).append("\n"); 
		query.append("                , T22.VPS_PORT_CD, T22.CLPT_IND_SEQ, T22.CLPT_SEQ" ).append("\n"); 
		query.append("				, T22.YD_CD, T22.SLAN_CD, T22.ACT_INP_FLG" ).append("\n"); 
		query.append("                , T22.PF_ETA_DT, T22.PF_ETB_DT, T22.PF_ETD_DT" ).append("\n"); 
		query.append("                , T22.INIT_ETA_DT, T22.INIT_ETB_DT, T22.INIT_ETD_DT" ).append("\n"); 
		query.append("                , T22.VPS_ETA_DT, T22.VPS_ETB_DT, T22.VPS_ETD_DT" ).append("\n"); 
		query.append("                , T22.TURN_PORT_FLG, T22.TURN_PORT_IND_CD, T22.TURN_SKD_VOY_NO, T22.TURN_SKD_DIR_CD, T22.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				, T22.PORT_BUF_HRS, T22.SEA_BUF_HRS" ).append("\n"); 
		query.append("				, T22.AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("                -- auto update 당일 체크 로직 주석 " ).append("\n"); 
		query.append("                -- ACT_AUTO_UPDATE일경우 다음 PORT의 시간 계산을 하지 않음" ).append("\n"); 
		query.append("                -- 2015.01.08  DONGSOO 주석 처리함 " ).append("\n"); 
		query.append("                /*" ).append("\n"); 
		query.append("				, CASE WHEN T22.AUTO_SKD_CNG_FLG = 'Y' " ).append("\n"); 
		query.append("							OR (TO_CHAR(T22.UPD_DT, 'YYYYMMDD') = TO_CHAR(SYSDATE, 'YYYYMMDD') AND T22.UPD_USR_ID != 'ACT_AUTO_UPDATE') " ).append("\n"); 
		query.append("					   THEN 'Y' " ).append("\n"); 
		query.append("					   ELSE 'N' " ).append("\n"); 
		query.append("				  END AS AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("	             */" ).append("\n"); 
		query.append("                , T23.VSL_SLAN_CD" ).append("\n"); 
		query.append("                , T23.PF_SKD_TP_CD" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                SELECT  LEVEL AS LVL" ).append("\n"); 
		query.append("                        , T11.VSL_CD, T11.SKD_VOY_NO, T11.SKD_DIR_CD" ).append("\n"); 
		query.append("                        , T11.TURN_SKD_VOY_NO, T11.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM    (" ).append("\n"); 
		query.append("                        SELECT  DISTINCT" ).append("\n"); 
		query.append("                                T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                , T1.TURN_SKD_VOY_NO, T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("                        WHERE   T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                        AND     T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("                        AND     T1.TURN_SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND     T1.TURN_SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND     T1.TURN_PORT_IND_CD IN ('F', 'V', 'D')" ).append("\n"); 
		query.append("                        AND     T2.TURN_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("                        ) T11" ).append("\n"); 
		query.append("                START WITH SKD_VOY_NO = @[skd_voy_no] AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                CONNECT BY 		PRIOR TURN_SKD_VOY_NO = SKD_VOY_NO " ).append("\n"); 
		query.append("							AND PRIOR TURN_SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("							AND	PRIOR VSL_CD		  = VSL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  DISTINCT 1 AS LVL" ).append("\n"); 
		query.append("                        , VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                        , TURN_SKD_VOY_NO, TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD T3" ).append("\n"); 
		query.append("                WHERE   VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("				AND 	SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("				AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                AND     1 = NVL(" ).append("\n"); 
		query.append("                                   (SELECT 2 " ).append("\n"); 
		query.append("                                    FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                                    WHERE VSL_CD = T3.VSL_CD" ).append("\n"); 
		query.append("                                    AND SKD_VOY_NO = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    AND SKD_DIR_CD = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                    AND (TURN_PORT_FLG = 'Y' OR TURN_PORT_IND_CD IN ('F', 'V', 'D')) AND ROWNUM = 1)" ).append("\n"); 
		query.append("                            , 1)            /* Turnning 이 없을 경우 입력한 Port 및 그 이후의 Port 를 조회하기 위해 */" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("                SELECT  DISTINCT 2 AS LVL" ).append("\n"); 
		query.append("                        , VSL_CD, TURN_SKD_VOY_NO AS SKD_VOY_NO, TURN_SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                        , '' AS TURN_SKD_VOY_NO, '' AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD T4" ).append("\n"); 
		query.append("                WHERE   VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("				AND 	SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("				AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("				AND     TURN_PORT_IND_CD IN ('F', 'V', 'D')" ).append("\n"); 
		query.append("                AND     1 = NVL(" ).append("\n"); 
		query.append("                                   (SELECT 2 " ).append("\n"); 
		query.append("                                    FROM VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                                    WHERE VSL_CD = T4.VSL_CD" ).append("\n"); 
		query.append("                                    AND SKD_VOY_NO = T4.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                    AND SKD_DIR_CD = T4.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                    AND TURN_PORT_IND_CD IN ('F', 'V', 'D')" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1)" ).append("\n"); 
		query.append("                            , 1)            /* Virtual 의 Virtual 이 없을 경우 입력한 Port 이후의 Port 를 조회하기 위해 */" ).append("\n"); 
		query.append("                ) T21, VSK_VSL_PORT_SKD T22, VSK_VSL_SKD T23" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     T21.VSL_CD = T23.VSL_CD" ).append("\n"); 
		query.append("        AND     T21.SKD_VOY_NO = T23.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T21.SKD_DIR_CD = T23.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     T21.VSL_CD       = T22.VSL_CD" ).append("\n"); 
		query.append("        AND     T21.SKD_VOY_NO   = T22.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T21.SKD_DIR_CD   = T22.SKD_DIR_CD" ).append("\n"); 
		query.append("--        AND     T22.AUTO_SKD_CNG_FLG   = 'N'                                    	/* 스케줄 고정 PORT 제외(주석처리 - 스케줄 고정 PORT 조회되어야 함) */" ).append("\n"); 
		query.append("        AND     (T22.SKD_CNG_STS_CD IS NULL OR T22.SKD_CNG_STS_CD != 'S')       	/* SKIP 제외 */" ).append("\n"); 
		query.append("        AND     (LVL = 1 AND TURN_PORT_IND_CD NOT IN ('F', 'V', 'D') OR LVL = 2)	/* 마지막 VVD 만 Virtual 조회 */" ).append("\n"); 
		query.append("        AND     (" ).append("\n"); 
		query.append("                    (T21.LVL = 1 AND T22.CLPT_SEQ >= (" ).append("\n"); 
		query.append("                                                        SELECT  CLPT_SEQ" ).append("\n"); 
		query.append("                                                        FROM    VSK_VSL_PORT_SKD " ).append("\n"); 
		query.append("                                                        WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("                                                        AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                        AND     SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                        AND     VPS_PORT_CD = @[vps_port_cd]" ).append("\n"); 
		query.append("                                                        AND     CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                    ) OR T21.LVL > 1" ).append("\n"); 
		query.append("                )                   /* 입력한 VVD 부터 나오도록 찾는다.(START PORT) */" ).append("\n"); 
		query.append("        AND     T21.LVL <=  2     	/* 입력한 VVD 다음 Direction 까지만 나오도록 찾는다.(END PORT) */" ).append("\n"); 
		query.append("        ) T31, (" ).append("\n"); 
		query.append("                SELECT	T1.VSL_SLAN_CD, T1.PF_SVC_TP_CD, T1.PORT_CD, DECODE(VIRT_FLG, 'V', T1.DIR_CD2, T2.SKD_DIR_CD) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                        , T1.CLPT_SEQ, T2.PORT_ROTN_SEQ, T2.YD_CD, CALL_YD_IND_SEQ, TURN_PORT_FLG, TURN_PORT_IND_CD, ETB_DY_CD, ETB_DY_NO" ).append("\n"); 
		query.append("    					, ETB_TM_HRMNT, ETD_DY_CD, ETD_DY_NO, ETD_TM_HRMNT, LNK_DIST, LNK_SPD, TZTM_HRS" ).append("\n"); 
		query.append("    					, SEA_BUF_HRS, SEA_BUF_SPD, MNVR_IN_HRS, MNVR_OUT_HRS" ).append("\n"); 
		query.append("    					, IB_IPCGO_QTY, IB_OCN_CGO_QTY, OB_IPCGO_QTY" ).append("\n"); 
		query.append("    					, OB_OCN_CGO_QTY, TML_PROD_QTY, CRN_KNT, ACT_WRK_HRS, PORT_BUF_HRS, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("    			FROM	(" ).append("\n"); 
		query.append("                        SELECT 	NVL(T3.VSL_SLAN_CD	, T1.VSL_SLAN_CD	) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                                , NVL(T3.PF_SVC_TP_CD	, T1.PF_SVC_TP_CD	) AS PF_SVC_TP_CD" ).append("\n"); 
		query.append("                                , NVL(T3.PORT_CD		, T1.PORT_CD		) AS PORT_CD" ).append("\n"); 
		query.append("                                , DECODE(T3.SKD_DIR_CD, NULL, (	SELECT	S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                            									FROM	MDM_VSL_SVC_LANE_DIR S" ).append("\n"); 
		query.append("                            									WHERE	1 = 1" ).append("\n"); 
		query.append("                            									AND		T1.VSL_SLAN_CD	= S.VSL_SLAN_CD" ).append("\n"); 
		query.append("                            									AND		T1.SKD_DIR_CD	!= S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                            									AND		S.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("                            									AND		ROWNUM			= 1" ).append("\n"); 
		query.append("                            								  ), T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                                  ) AS SKD_DIR_CD" ).append("\n"); 
		query.append("                                , DECODE(T3.CLPT_SEQ, NULL, (   SELECT	T1.CLPT_SEQ" ).append("\n"); 
		query.append("                            									FROM	VSK_PF_SKD_DTL M" ).append("\n"); 
		query.append("                            									WHERE	1 = 1" ).append("\n"); 
		query.append("                            									AND		T1.VSL_SLAN_CD	= M.VSL_SLAN_CD" ).append("\n"); 
		query.append("                            									AND		T1.PF_SVC_TP_CD	= M.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                            									AND		T1.SKD_DIR_CD	= (" ).append("\n"); 
		query.append("                                                        									SELECT	S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                        									FROM	MDM_VSL_SVC_LANE_DIR S" ).append("\n"); 
		query.append("                                                        									WHERE	1 = 1" ).append("\n"); 
		query.append("                                                        									AND		T1.VSL_SLAN_CD	= S.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                        									AND		T1.SKD_DIR_CD	=S.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                        									AND		S.DELT_FLG		= 'N'" ).append("\n"); 
		query.append("    								                                                      )" ).append("\n"); 
		query.append("                                								AND		T1.PORT_CD		= M.PORT_CD" ).append("\n"); 
		query.append("                                								AND		T1.CLPT_SEQ		= M.CLPT_SEQ" ).append("\n"); 
		query.append("                                								AND     M.TURN_PORT_IND_CD != 'F'" ).append("\n"); 
		query.append("                                								), T1.CLPT_SEQ" ).append("\n"); 
		query.append("                                  ) AS CLPT_SEQ" ).append("\n"); 
		query.append("                                , DECODE(T3.SKD_DIR_CD, NULL, 'V', 'N') AS VIRT_FLG" ).append("\n"); 
		query.append("                                , T1.SKD_DIR_CD AS DIR_CD2" ).append("\n"); 
		query.append("    					FROM  	VSK_PF_CALL_PORT T1, MDM_VSL_SVC_LANE_DIR T2, VSK_PF_SKD_DTL T3" ).append("\n"); 
		query.append("    					WHERE  	1	= 1" ).append("\n"); 
		query.append("    					AND		T1.VSL_SLAN_CD	= T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("    					AND		T1.SKD_DIR_CD	= T2.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("    					AND		T1.VSL_SLAN_CD	= T3.VSL_SLAN_CD 	(+)" ).append("\n"); 
		query.append("    					AND		T1.PF_SVC_TP_CD	= T3.PF_SVC_TP_CD	(+)" ).append("\n"); 
		query.append("    					AND		T1.SKD_DIR_CD	= T3.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("    					AND		T1.PORT_CD		= T3.PORT_CD		(+)" ).append("\n"); 
		query.append("    					AND		T1.CLPT_SEQ		= T3.CLPT_SEQ		(+)" ).append("\n"); 
		query.append("    					AND     T3.TURN_PORT_IND_CD(+) != 'F'" ).append("\n"); 
		query.append("    --					AND		T1.VSL_SLAN_CD 	= 'CNX'" ).append("\n"); 
		query.append("    --					AND		T1.PF_SVC_TP_CD = '4002'" ).append("\n"); 
		query.append("    					) T1, VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("    			WHERE 1 = 1" ).append("\n"); 
		query.append("    			AND  T1.VSL_SLAN_CD = T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("    			AND  T1.PF_SVC_TP_CD = T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("    			AND  T1.PORT_CD  = T2.PORT_CD" ).append("\n"); 
		query.append("    			AND  T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    			AND  T1.CLPT_SEQ  = T2.CLPT_SEQ" ).append("\n"); 
		query.append("               ) T32" ).append("\n"); 
		query.append("WHERE   1 = 1" ).append("\n"); 
		query.append("AND     T31.VSL_SLAN_CD  = T32.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("AND     T31.PF_SKD_TP_CD = T32.PF_SVC_TP_CD(+)" ).append("\n"); 
		query.append("AND     T31.SKD_DIR_CD   = T32.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     T31.VPS_PORT_CD  = T32.PORT_CD (+)" ).append("\n"); 
		query.append("AND     T31.CLPT_IND_SEQ = T32.CLPT_SEQ(+)" ).append("\n"); 
		query.append("ORDER BY T31.LVL, T31.CLPT_SEQ" ).append("\n"); 

	}
}