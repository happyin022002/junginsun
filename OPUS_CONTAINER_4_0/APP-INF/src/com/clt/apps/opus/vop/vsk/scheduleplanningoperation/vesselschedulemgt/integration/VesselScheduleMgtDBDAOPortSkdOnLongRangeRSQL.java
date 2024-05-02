/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOPortSkdOnLongRangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.06 
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

public class VesselScheduleMgtDBDAOPortSkdOnLongRangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 주어진 기간내에서 특정 Lane이나 Vessel에 대한 Port Schedule을 조회한다.(Long Range Inquiry)
	  * 
	  * 2010.08.02
	  * ※ CHM-201005113-01
	  * <MDM LANE SEQUENCE 변경에 따른  Direction 및 스케줄 역전 현상 보완>
	  * Long Range Inquiry 화면에서 조회시 어떤 레인의 Direction Sequence 를 기존의 MDM에서 참조하던 규칙을, Proforma 의 정보를 활용하도록 변경
	  * 
	  * 2010.12.27 CHM-201007036-01 진마리아 Down Excel Format 변경 요청건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOPortSkdOnLongRangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOPortSkdOnLongRangeRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("		T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("	,	T2.PF_SKD_TP_CD" ).append("\n"); 
		query.append("	,	T4.VSL_SVC_TP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, 	T2.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	T2.VSL_CD" ).append("\n"); 
		query.append("	,	T2.SKD_VOY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,   T3.OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("	--,  (SELECT  MAX(PS.OB_CSSM_VOY_NO)" ).append("\n"); 
		query.append("    -- 	FROM    VSK_VSL_PORT_SKD  	PS" ).append("\n"); 
		query.append("    --  	WHERE   PS.VSL_CD         	= T2.VSL_CD" ).append("\n"); 
		query.append("    --  	AND     PS.SKD_VOY_NO     	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("    --  	AND     PS.SKD_DIR_CD     	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("    --  	AND     PS.CLPT_SEQ       	= 1" ).append("\n"); 
		query.append("    --  	)							AS OB_CSSM_VOY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	T2.SKD_DIR_CD" ).append("\n"); 
		query.append("	,	T2.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	T3.VPS_PORT_CD" ).append("\n"); 
		query.append("	,	T3.CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  	,	RANK() OVER (	PARTITION BY T2.VSL_SLAN_CD, T2.PF_SKD_TP_CD, T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD, T3.VPS_PORT_CD " ).append("\n"); 
		query.append("                  		ORDER BY     DECODE(T3.TURN_PORT_IND_CD,'D',9,'V',9,'F',9,1)" ).append("\n"); 
		query.append("									,DECODE(T3.PF_ETB_DT,NULL,9,DECODE(T3.SKD_CNG_STS_CD,'A',9,1))" ).append("\n"); 
		query.append("									,T3.CLPT_SEQ" ).append("\n"); 
		query.append("					)	AS EXCL_ADD_CLPT_IND_SEQ " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	T3.CLPT_SEQ" ).append("\n"); 
		query.append("	,	T3.PORT_SKD_STS_CD" ).append("\n"); 
		query.append("	,	T3.YD_CD" ).append("\n"); 
		query.append("	,	T3.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append("	,	T3.PF_ETA_DT" ).append("\n"); 
		query.append("	,	T3.PF_ETB_DT" ).append("\n"); 
		query.append("	,	T3.PF_ETD_DT" ).append("\n"); 
		query.append("	,	T3.INIT_ETA_DT" ).append("\n"); 
		query.append("	,	T3.INIT_ETB_DT" ).append("\n"); 
		query.append("	,	T3.INIT_ETD_DT" ).append("\n"); 
		query.append("	,	T3.VPS_ETA_DT" ).append("\n"); 
		query.append("	,	T3.VPS_ETB_DT" ).append("\n"); 
		query.append("	,	T3.VPS_ETD_DT" ).append("\n"); 
		query.append("	,	T3.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("	,	T3.TURN_PORT_FLG" ).append("\n"); 
		query.append("	,	T3.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("	,	T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--:2015-07-09:--,	T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	,	CASE WHEN T3.TURN_SKD_VOY_NO IS NOT NULL THEN T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("			 ELSE ''" ).append("\n"); 
		query.append("		END  										AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	T3.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	,	T2.SKD_RMK 									AS VPS_RMK" ).append("\n"); 
		query.append("	,	'' 											AS START_DATE" ).append("\n"); 
		query.append("	,	'' 											AS END_DATE" ).append("\n"); 
		query.append("	,	TO_CHAR(T3.CRE_DT, 'YYYY-MM-DD HH24:MI')	AS CRE_DT" ).append("\n"); 
		query.append("	,	T3.CRE_USR_ID" ).append("\n"); 
		query.append("	,	TO_CHAR(T3.UPD_DT, 'YYYY-MM-DD HH24:MI') 	AS UPD_DT" ).append("\n"); 
		query.append("	,	T3.UPD_USR_ID" ).append("\n"); 
		query.append("	,	(SELECT LOC_NM 		FROM MDM_LOCATION WHERE LOC_CD	= T3.VPS_PORT_CD) PORT_NM" ).append("\n"); 
		query.append("	,	(SELECT VSL_ENG_NM 	FROM MDM_VSL_CNTR WHERE VSL_CD	= T3.VSL_CD		) VSL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM 	(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /* 주어진 조회 기간내에 포함되는 VVD및 그와 연결되는 VVD를 조회한다.*/" ).append("\n"); 
		query.append("    SELECT * FROM (" ).append("\n"); 
		query.append("        SELECT " ).append("\n"); 
		query.append("            DISTINCT" ).append("\n"); 
		query.append("            T1.VSL_CD" ).append("\n"); 
		query.append("            ,DECODE(MOD(Y, 2), 1, SKD_VOY_NO, 0, TURN_SKD_VOY_NO) SKD_VOY_NO" ).append("\n"); 
		query.append("            ,DECODE(MOD(Y, 2), 1, SKD_DIR_CD, 0, TURN_SKD_DIR_CD) SKD_DIR_CD" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT" ).append("\n"); 
		query.append("                T1.*" ).append("\n"); 
		query.append("            FROM(" ).append("\n"); 
		query.append("                SELECT" ).append("\n"); 
		query.append("                    T1.*" ).append("\n"); 
		query.append("                    ,ROW_NUMBER() OVER(PARTITION BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD ORDER BY TURN_SKD_VOY_NO) X" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT " ).append("\n"); 
		query.append("                        T1.VSL_CD" ).append("\n"); 
		query.append("                        ,T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                        ,T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                        ,CASE WHEN T1.VSL_SLAN_DIR_SEQ=1 AND T1.TURN_PORT_IND_CD='D' THEN" ).append("\n"); 
		query.append("                            /* 첫번째 DIR의 경우, TURN_PORT_IND_CD가 'D' 즉, 두번째 DIR의 SKD_VOY_NO를 구한다.*/" ).append("\n"); 
		query.append("                            T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                        WHEN T1.VSL_SLAN_DIR_SEQ=2 AND T1.TURN_PORT_FLG='Y' AND T1.TURN_PORT_IND_CD='Y' THEN" ).append("\n"); 
		query.append("                            /* 두번째 DIR의 경우, TURN_PORT_IND_CD가 'Y' 즉, 이전 VVD의 첫번째 DIR의 SKD_VOY_NO를 구한다.*/" ).append("\n"); 
		query.append("                            T1.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        'XXXX'" ).append("\n"); 
		query.append("                        END TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                        ,CASE WHEN T1.VSL_SLAN_DIR_SEQ=1 AND T1.TURN_PORT_IND_CD='D' THEN" ).append("\n"); 
		query.append("                            /* 첫번째 DIR의 경우, TURN_PORT_IND_CD가 'D' 즉, 두번째 DIR의 SKD_DIR_CD를 구한다.*/" ).append("\n"); 
		query.append("                            T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                        WHEN T1.VSL_SLAN_DIR_SEQ=2 AND T1.TURN_PORT_FLG='Y' AND T1.TURN_PORT_IND_CD='Y' THEN" ).append("\n"); 
		query.append("                            /* 두번째 DIR의 경우, TURN_PORT_IND_CD가 'Y' 즉, 이전 VVD의 첫번째 DIR의 SKD_DIR_CD를 구한다.*/" ).append("\n"); 
		query.append("                            T1.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                        ELSE" ).append("\n"); 
		query.append("                        'XXXX'" ).append("\n"); 
		query.append("                        END TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                        /* VVD별 최소ETB, 최대ETD 계산 */" ).append("\n"); 
		query.append("                        SELECT " ).append("\n"); 
		query.append("                            T2.VSL_CD" ).append("\n"); 
		query.append("                            ,T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                            ,T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,T1.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                            ,T2.VPS_PORT_CD" ).append("\n"); 
		query.append("                            ,T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                            ,T2.CLPT_SEQ" ).append("\n"); 
		query.append("                            ,T2.VPS_ETB_DT" ).append("\n"); 
		query.append("                            ,T2.VPS_ETD_DT" ).append("\n"); 
		query.append("                            ,T2.TURN_PORT_FLG" ).append("\n"); 
		query.append("                            ,T2.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                            ,T2.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                            ,T2.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,FIRST_VALUE(T2.VPS_ETB_DT) OVER(PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY CLPT_SEQ ASC) FIRST_ETB" ).append("\n"); 
		query.append("                            ,FIRST_VALUE(T2.VPS_ETD_DT) OVER(PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY CLPT_SEQ DESC) LAST_ETD" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("								SELECT" ).append("\n"); 
		query.append("									T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("									, T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("									, T1.VSL_CD" ).append("\n"); 
		query.append("									, T1.SKD_VOY_NO" ).append("\n"); 
		query.append("									, T1.SKD_DIR_CD" ).append("\n"); 
		query.append("									/* PF SKD DETAIL 을 이용하여 DIRECTION SEQ를 구함*/" ).append("\n"); 
		query.append("									, DECODE(MIN(PORT_ROTN_SEQ), NULL, ROW_NUMBER() OVER(PARTITION BY VSL_CD, SKD_VOY_NO ORDER BY T1.N1ST_PORT_BRTH_DT), 1, 1, 2) AS VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("								FROM VSK_VSL_SKD T1, VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("								WHERE 1=1" ).append("\n"); 
		query.append("								AND T1.VSL_SLAN_CD  = T2.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("								AND T1.PF_SKD_TP_CD = T2.PF_SVC_TP_CD(+)" ).append("\n"); 
		query.append("								AND T1.SKD_DIR_CD   = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("								#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("								AND T1.VSL_SLAN_CD 	= @[vsl_slan_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("								AND T1.VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("								#end" ).append("\n"); 
		query.append("								GROUP BY T1.VSL_SLAN_CD, T1.PF_SKD_TP_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("							) T1, VSK_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("                        AND T1.VSL_SLAN_CD		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("                        AND T2.SLAN_CD			= @[vsl_slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                        AND T2.VSL_CD			= @[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                        AND T1.VSL_CD			= T2.VSL_CD" ).append("\n"); 
		query.append("                        AND T1.SKD_VOY_NO		= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND T1.SKD_DIR_CD		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("						--AND T3.TURN_PORT_IND_CD!='F'" ).append("\n"); 
		query.append("						--AND T3.TURN_PORT_IND_CD!='D'" ).append("\n"); 
		query.append("                        AND T2.TURN_PORT_IND_CD NOT IN ('V')" ).append("\n"); 
		query.append("                    ) T1" ).append("\n"); 
		query.append("                    WHERE 1=1" ).append("\n"); 
		query.append("					AND TO_DATE(@[start_date], 'YYYY-MM-DD') <= T1.LAST_ETD" ).append("\n"); 
		query.append("					AND TO_DATE(@[end_date], 'YYYY-MM-DD') >= T1.FIRST_ETB" ).append("\n"); 
		query.append("                ) T1" ).append("\n"); 
		query.append("            ) T1" ).append("\n"); 
		query.append("            WHERE X=1" ).append("\n"); 
		query.append("        ) T1" ).append("\n"); 
		query.append("        /* T1에서 TURN_SKD_VOY_NO, TURN_SKD_DIR_CD를 끌어내기 위해 인위적으로 2개 ROW를 갖는 테이블을 조인한다.*/" ).append("\n"); 
		query.append("        ,(SELECT ROWNUM AS Y FROM DUAL CONNECT BY LEVEL <= 2) T2" ).append("\n"); 
		query.append("    ) T1" ).append("\n"); 
		query.append("    WHERE T1.SKD_VOY_NO!='XXXX' AND T1.SKD_DIR_CD!='XXXX'" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append(")T1, (" ).append("\n"); 
		query.append("		SELECT" ).append("\n"); 
		query.append("			T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("			, T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("			, T1.VSL_CD" ).append("\n"); 
		query.append("			, T1.SKD_VOY_NO" ).append("\n"); 
		query.append("			, T1.SKD_DIR_CD" ).append("\n"); 
		query.append("			, MAX(T1.SKD_RMK) AS SKD_RMK" ).append("\n"); 
		query.append("			/* PF SKD DETAIL 을 이용하여 DIRECTION SEQ를 구함*/" ).append("\n"); 
		query.append("			, DECODE(MIN(PORT_ROTN_SEQ), NULL, ROW_NUMBER() OVER(PARTITION BY VSL_CD, SKD_VOY_NO ORDER BY T1.N1ST_PORT_BRTH_DT), 1, 1, 2) AS VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      		, T1.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		FROM VSK_VSL_SKD T1, VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("		WHERE 1=1" ).append("\n"); 
		query.append("		AND T1.VSL_SLAN_CD  = T2.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("		AND T1.PF_SKD_TP_CD = T2.PF_SVC_TP_CD(+)" ).append("\n"); 
		query.append("		AND T1.SKD_DIR_CD   = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("		#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("		AND T1.VSL_SLAN_CD 	= @[vsl_slan_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("		AND T1.VSL_CD 		= @[vsl_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		GROUP BY T1.VSL_SLAN_CD, T1.PF_SKD_TP_CD, T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD, T1.N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append(") T2" ).append("\n"); 
		query.append("	, 	VSK_VSL_PORT_SKD 		T3" ).append("\n"); 
		query.append("	, 	MDM_VSL_SVC_LANE 		T4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 	1 = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("AND 	T2.VSL_SLAN_CD			= @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND 	T2.VSL_CD				= @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND 	T2.VSL_SLAN_CD 			= T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND 	T1.VSL_CD				= T2.VSL_CD" ).append("\n"); 
		query.append("AND 	T1.SKD_VOY_NO			= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	T1.SKD_DIR_CD			= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND 	T2.VSL_CD				= T3.VSL_CD" ).append("\n"); 
		query.append("AND 	T2.SKD_VOY_NO			= T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND 	T2.SKD_DIR_CD			= T3.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--:2015-12-14:--" ).append("\n"); 
		query.append("AND		NVL(T3.VT_ADD_CALL_FLG,'*') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--::2015-08-11:by TOP::--AND 	T3.TURN_PORT_IND_CD		NOT IN ('D','V')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   CASE WHEN T2.VSL_SLAN_DIR_SEQ = 1 THEN " ).append("\n"); 
		query.append("                                        CASE WHEN T3.TURN_PORT_IND_CD NOT IN ('D','V','F') THEN 1" ).append("\n"); 
		query.append("                                             ELSE 0" ).append("\n"); 
		query.append("                                        END" ).append("\n"); 
		query.append("           ELSE" ).append("\n"); 
		query.append("                                        CASE WHEN T3.TURN_PORT_IND_CD NOT IN ('D','V')     THEN 1" ).append("\n"); 
		query.append("                                             ELSE 0" ).append("\n"); 
		query.append("                                        END             " ).append("\n"); 
		query.append("      END                               = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND 	T4.VSL_TP_CD			= 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("----ORDER BY T3.VSL_CD, T3.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY   " ).append("\n"); 
		query.append("      	T2.VSL_SLAN_CD          ASC" ).append("\n"); 
		query.append("    , 	T2.PF_SKD_TP_CD         ASC" ).append("\n"); 
		query.append("    , 	T2.N1ST_PORT_BRTH_DT    ASC" ).append("\n"); 
		query.append("	, 	T2.VSL_CD               ASC" ).append("\n"); 
		query.append("    , 	T2.SKD_VOY_NO           ASC" ).append("\n"); 
		query.append("    , 	T2.VSL_SLAN_DIR_SEQ     ASC" ).append("\n"); 
		query.append("	,	T3.CLPT_SEQ				ASC" ).append("\n"); 

	}
}