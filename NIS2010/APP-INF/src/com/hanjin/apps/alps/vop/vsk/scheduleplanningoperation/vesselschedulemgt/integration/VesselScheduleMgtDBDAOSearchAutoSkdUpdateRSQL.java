/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchAutoSkdUpdateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * Actual SKD 생성에 의한 Auto Update 대상 SKD을 조회한다.
	  * ----------------------------------------------------------------
	  * 2010.10.18 유혁 CHM-201006456-01 SKD Auto Update 기능 보완
	  * 2011.01.24 이석준 CHM-201108237-01 Actual Schedule update시 해당 항차 다음의 3
	  * 항차까지 update될 수 있도록 logic 수정
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS LVL" ).append("\n"); 
		query.append(",'' AS VSL_CD" ).append("\n"); 
		query.append(",'' AS SKD_VOY_NO" ).append("\n"); 
		query.append(",'' AS SKD_DIR_CD" ).append("\n"); 
		query.append(",'' AS VPS_PORT_CD" ).append("\n"); 
		query.append(",'' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(",'' AS CLPT_SEQ" ).append("\n"); 
		query.append(",'' AS YD_CD" ).append("\n"); 
		query.append(",'' AS SLAN_CD" ).append("\n"); 
		query.append(",'' AS ACT_INP_FLG" ).append("\n"); 
		query.append(",'' AS PF_ETA_DT" ).append("\n"); 
		query.append(",'' AS PF_ETB_DT" ).append("\n"); 
		query.append(",'' AS PF_ETD_DT" ).append("\n"); 
		query.append(",'' AS INIT_ETA_DT" ).append("\n"); 
		query.append(",'' AS INIT_ETB_DT" ).append("\n"); 
		query.append(",'' AS INIT_ETD_DT" ).append("\n"); 
		query.append(",'' AS VPS_ETA_DT" ).append("\n"); 
		query.append(",'' AS VPS_ETB_DT" ).append("\n"); 
		query.append(",'' AS VPS_ETD_DT" ).append("\n"); 
		query.append(",'' AS TURN_PORT_FLG" ).append("\n"); 
		query.append(",'' AS TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",'' AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(",'' AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(",'' AS TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",'' AS VSL_SLAN_CD" ).append("\n"); 
		query.append(",'' AS PF_SKD_TP_CD" ).append("\n"); 
		query.append(",'' AS AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append(",'' AS GMT_HRS" ).append("\n"); 
		query.append(",'' AS LNK_DIST" ).append("\n"); 
		query.append(",'' AS LNK_SPD " ).append("\n"); 
		query.append(",'' AS TZTM_HRS" ).append("\n"); 
		query.append(",'' AS SEA_BUF_HRS " ).append("\n"); 
		query.append(",'' AS MNVR_IN_HRS " ).append("\n"); 
		query.append(",'' AS MNVR_OUT_HRS" ).append("\n"); 
		query.append(",'' AS ACT_WRK_HRS" ).append("\n"); 
		query.append(",'' AS PORT_BUF_HRS" ).append("\n"); 
		query.append(",'' AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",'' AS VSL_DLAY_RSN_CD" ).append("\n"); 
		query.append(",'' AS VSL_DLAY_RSN_DESC" ).append("\n"); 
		query.append(",'' AS VSL_DLAY_RSN_LOC_CD" ).append("\n"); 
		query.append(",'' AS CRE_USR_ID" ).append("\n"); 
		query.append(",'' AS UPD_USR_ID" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("    T31.LVL" ).append("\n"); 
		query.append("    , T31.VSL_CD" ).append("\n"); 
		query.append("    , T31.SKD_VOY_NO" ).append("\n"); 
		query.append("    , T31.SKD_DIR_CD" ).append("\n"); 
		query.append("    , T31.VPS_PORT_CD" ).append("\n"); 
		query.append("    , T31.CLPT_IND_SEQ" ).append("\n"); 
		query.append("    , T31.CLPT_SEQ" ).append("\n"); 
		query.append("    , T31.YD_CD" ).append("\n"); 
		query.append("    , T31.SLAN_CD" ).append("\n"); 
		query.append("    , T31.ACT_INP_FLG" ).append("\n"); 
		query.append("    , TO_CHAR(T31.PF_ETA_DT, 'YYYYMMDDHH24MI') AS PF_ETA_DT" ).append("\n"); 
		query.append("    , TO_CHAR(T31.PF_ETB_DT, 'YYYYMMDDHH24MI') AS PF_ETB_DT" ).append("\n"); 
		query.append("    , TO_CHAR(T31.PF_ETD_DT, 'YYYYMMDDHH24MI') AS PF_ETD_DT" ).append("\n"); 
		query.append("    , TO_CHAR(T31.INIT_ETA_DT, 'YYYYMMDDHH24MI') AS INIT_ETA_DT" ).append("\n"); 
		query.append("    , TO_CHAR(T31.INIT_ETB_DT, 'YYYYMMDDHH24MI') AS INIT_ETB_DT" ).append("\n"); 
		query.append("    , TO_CHAR(T31.INIT_ETD_DT, 'YYYYMMDDHH24MI') AS INIT_ETD_DT" ).append("\n"); 
		query.append("    , TO_CHAR(T31.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("    , TO_CHAR(T31.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("    , TO_CHAR(T31.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("    , T31.TURN_PORT_FLG, T31.TURN_PORT_IND_CD, T31.TURN_SKD_VOY_NO, T31.TURN_SKD_DIR_CD, T31.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    , T31.VSL_SLAN_CD, T31.PF_SKD_TP_CD" ).append("\n"); 
		query.append("    , T31.AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("    , (" ).append("\n"); 
		query.append("          SELECT GMT_HRS/60.0 FROM MDM_LOCATION" ).append("\n"); 
		query.append("          WHERE LOC_CD = T31.VPS_PORT_CD" ).append("\n"); 
		query.append("      ) AS GMT_HRS" ).append("\n"); 
		query.append("    , NVL(T32. LNK_DIST    , T31.LNK_DIST    ) AS LNK_DIST    " ).append("\n"); 
		query.append("    , NVL(T32. LNK_SPD     , T31.LNK_SPD     ) AS LNK_SPD     " ).append("\n"); 
		query.append("    , NVL(T32. TZTM_HRS    , T31.TZTM_HRS    ) AS TZTM_HRS    " ).append("\n"); 
		query.append("    , NVL(T32. SEA_BUF_HRS , T31.SEA_BUF_HRS ) AS SEA_BUF_HRS " ).append("\n"); 
		query.append("    , NVL(T32. MNVR_IN_HRS , T31.MNVR_IN_HRS ) AS MNVR_IN_HRS " ).append("\n"); 
		query.append("    , NVL(T32. MNVR_OUT_HRS, T31.MNVR_OUT_HRS) AS MNVR_OUT_HRS" ).append("\n"); 
		query.append("    , NVL(T32. ACT_WRK_HRS , T31.PORT_WRK_HRS) AS ACT_WRK_HRS" ).append("\n"); 
		query.append("    , NVL(T32. PORT_BUF_HRS, T31.PORT_BUF_HRS) AS PORT_BUF_HRS" ).append("\n"); 
		query.append("FROM    ( " ).append("\n"); 
		query.append("        SELECT  T21.LVL, T21.VSL_CD, T21.SKD_VOY_NO, T21.SKD_DIR_CD" ).append("\n"); 
		query.append("                , T22.VPS_PORT_CD, T22.CLPT_IND_SEQ, T22.CLPT_SEQ" ).append("\n"); 
		query.append("				, T22.YD_CD, T22.SLAN_CD, T22.ACT_INP_FLG" ).append("\n"); 
		query.append("                , T22.PF_ETA_DT, T22.PF_ETB_DT, T22.PF_ETD_DT" ).append("\n"); 
		query.append("                , T22.INIT_ETA_DT, T22.INIT_ETB_DT, T22.INIT_ETD_DT" ).append("\n"); 
		query.append("                , T22.VPS_ETA_DT, T22.VPS_ETB_DT, T22.VPS_ETD_DT" ).append("\n"); 
		query.append("                , T22.TURN_PORT_FLG, T22.TURN_PORT_IND_CD, T22.TURN_SKD_VOY_NO, T22.TURN_SKD_DIR_CD, T22.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("				, T22.PORT_BUF_HRS, T22.SEA_BUF_HRS" ).append("\n"); 
		query.append("				--, T22.AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("                , T22.LNK_DIST" ).append("\n"); 
		query.append("                , T22.LNK_SPD" ).append("\n"); 
		query.append("                , T22.TZTM_HRS" ).append("\n"); 
		query.append("                , T22.MNVR_IN_HRS" ).append("\n"); 
		query.append("                , T22.MNVR_OUT_HRS" ).append("\n"); 
		query.append("                , T22.PORT_WRK_HRS" ).append("\n"); 
		query.append("                , CASE WHEN T22.AUTO_SKD_CNG_FLG = 'Y' " ).append("\n"); 
		query.append("							OR (TO_CHAR(T22.UPD_DT, 'YYYYMMDD') = TO_CHAR(SYSDATE, 'YYYYMMDD') AND T22.UPD_USR_ID != 'ACT_AUTO_UPDATE') /* 자동 UPDATE 된 건은 당일 계속 UPDATE 되도록*/" ).append("\n"); 
		query.append("					   THEN 'Y' " ).append("\n"); 
		query.append("					   ELSE 'N' " ).append("\n"); 
		query.append("				  END AS AUTO_SKD_CNG_FLG" ).append("\n"); 
		query.append("                , T23.VSL_SLAN_CD, T23.PF_SKD_TP_CD" ).append("\n"); 
		query.append("        FROM    (" ).append("\n"); 
		query.append("                /* >>> 해당 VVD 부터 TURNING으로 계속 연결된 VVD 목록. 즉 TURNING 정보를 가지는 VVD만 조회됨 */" ).append("\n"); 
		query.append("				SELECT  LEVEL AS LVL" ).append("\n"); 
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
		query.append("                CONNECT BY PRIOR TURN_SKD_VOY_NO = SKD_VOY_NO AND PRIOR TURN_SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("				/* <<<*/" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("				/* >>> 해당 VVD가 앞뒤로 모두 없을 경우, 해당 VVD 조회 */" ).append("\n"); 
		query.append("                SELECT  DISTINCT 1 AS LVL" ).append("\n"); 
		query.append("                        , VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                        , TURN_SKD_VOY_NO, TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD T3" ).append("\n"); 
		query.append("                WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("				AND 	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("				AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                AND     1 = NVL(" ).append("\n"); 
		query.append("                                   (SELECT 2" ).append("\n"); 
		query.append("                                    FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                    WHERE VSL_CD = T3.VSL_CD" ).append("\n"); 
		query.append("                                    AND SKD_VOY_NO = T3.SKD_VOY_NO" ).append("\n"); 
		query.append("                                    AND SKD_DIR_CD = T3.SKD_DIR_CD" ).append("\n"); 
		query.append("                                    AND (TURN_PORT_FLG = 'Y' OR TURN_PORT_IND_CD IN ('F', 'V', 'D')) AND ROWNUM = 1)" ).append("\n"); 
		query.append("                            , 1)" ).append("\n"); 
		query.append("				/* <<<*/" ).append("\n"); 
		query.append("                UNION ALL" ).append("\n"); 
		query.append("				/* >>> 해당 VVD가 앞만 있을 경우, 해당 VVD 조회 */" ).append("\n"); 
		query.append("				SELECT  DISTINCT 1 AS LVL" ).append("\n"); 
		query.append("                        , VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                        , '' TURN_SKD_VOY_NO, '' TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD T" ).append("\n"); 
		query.append("                WHERE   VSL_CD = @[vsl_cd] " ).append("\n"); 
		query.append("				AND 	SKD_VOY_NO = @[skd_voy_no] " ).append("\n"); 
		query.append("				AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("				AND     TURN_PORT_FLG='Y'" ).append("\n"); 
		query.append("				AND     1 = NVL(" ).append("\n"); 
		query.append("									(SELECT 2" ).append("\n"); 
		query.append("									 FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("									 WHERE VSL_CD = T.VSL_CD" ).append("\n"); 
		query.append("									 AND SKD_VOY_NO = T.SKD_VOY_NO" ).append("\n"); 
		query.append("									 AND SKD_DIR_CD = T.SKD_DIR_CD" ).append("\n"); 
		query.append("									 AND TURN_PORT_IND_CD IN ('F', 'V', 'D') AND ROWNUM = 1)" ).append("\n"); 
		query.append("							, 1)" ).append("\n"); 
		query.append("				/* <<<*/" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				/* >>> 해당 VVD에 연결된 다음 VVD가 뒤가 없을 경우, 다음 VVD 조회 */" ).append("\n"); 
		query.append("				SELECT  DISTINCT 2 AS LVL" ).append("\n"); 
		query.append("                        , VSL_CD, TURN_SKD_VOY_NO AS SKD_VOY_NO, TURN_SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                        , '' AS TURN_SKD_VOY_NO, '' AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD T4" ).append("\n"); 
		query.append("                WHERE   VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("				AND 	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("				AND 	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("				AND     TURN_PORT_IND_CD IN ('F', 'V', 'D')" ).append("\n"); 
		query.append("                AND     1 = NVL(" ).append("\n"); 
		query.append("                                   (SELECT 2" ).append("\n"); 
		query.append("                                    FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                    WHERE VSL_CD = T4.VSL_CD" ).append("\n"); 
		query.append("                                    AND SKD_VOY_NO = T4.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                    AND SKD_DIR_CD = T4.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                    AND TURN_PORT_IND_CD IN ('F', 'V', 'D')" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1)" ).append("\n"); 
		query.append("                            , 1)" ).append("\n"); 
		query.append("				/* <<< */" ).append("\n"); 
		query.append("				UNION ALL" ).append("\n"); 
		query.append("				/* >>> 해당 VVD에 연결된 다다음 VVD가 뒤가 없을 경우, 다다음 VVD 조회 */" ).append("\n"); 
		query.append("				SELECT  DISTINCT 3 AS LVL" ).append("\n"); 
		query.append("                        , VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                        , '' AS TURN_SKD_VOY_NO, '' AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("				FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("				WHERE 1=1" ).append("\n"); 
		query.append("				AND (VSL_CD, TURN_SKD_VOY_NO, TURN_SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("					SELECT VSL_CD, TURN_SKD_VOY_NO AS SKD_VOY_NO, TURN_SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("					FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("					AND VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("					AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("					AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("					AND TURN_PORT_IND_CD IN ('V', 'F')" ).append("\n"); 
		query.append("					AND ROWNUM=1" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("				AND (VSL_CD, SKD_VOY_NO, SKD_DIR_CD) NOT IN ((@[vsl_cd], @[skd_voy_no], @[skd_dir_cd]))" ).append("\n"); 
		query.append("				AND TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("				/* <<< */" ).append("\n"); 
		query.append("                ) T21, VSK_VSL_PORT_SKD T22, VSK_VSL_SKD T23" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     T21.VSL_CD = T23.VSL_CD" ).append("\n"); 
		query.append("        AND     T21.SKD_VOY_NO = T23.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T21.SKD_DIR_CD = T23.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     T21.VSL_CD       = T22.VSL_CD" ).append("\n"); 
		query.append("        AND     T21.SKD_VOY_NO   = T22.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T21.SKD_DIR_CD   = T22.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     (T22.SKD_CNG_STS_CD IS NULL OR T22.SKD_CNG_STS_CD != 'S')       	/* SKIP 제외 */" ).append("\n"); 
		query.append("        AND     ((LVL = 1 OR LVL = 2) AND TURN_PORT_IND_CD NOT IN ('F', 'V', 'D') OR LVL = 3)	/* 마지막 VVD 만 Virtual 조회 */" ).append("\n"); 
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
		query.append("        AND     T21.LVL <=  3     	/* 입력한 VVD 다음 다음 Direction 까지만 나오도록 찾는다.(END PORT) */" ).append("\n"); 
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