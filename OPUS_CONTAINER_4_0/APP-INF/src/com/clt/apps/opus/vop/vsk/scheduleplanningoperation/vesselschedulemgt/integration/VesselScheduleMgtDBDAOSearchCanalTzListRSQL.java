/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchCanalTzListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.26
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.26 
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

public class VesselScheduleMgtDBDAOSearchCanalTzListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Canal Surchange 조회
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchCanalTzListRSQL(){
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchCanalTzListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("* FROM (" ).append("\n"); 
		query.append("	SELECT" ).append("\n"); 
		query.append("	    T2.BOUND" ).append("\n"); 
		query.append("	    ,T2.VSL_CD || T2.SKD_VOY_NO || T2.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("		,T2.VSL_CD" ).append("\n"); 
		query.append("		,T2.SKD_VOY_NO" ).append("\n"); 
		query.append("		,T2.SKD_DIR_CD" ).append("\n"); 
		query.append("	 	,SUBSTR(BAY_VVD, 1, 5) AS BAY_LOC" ).append("\n"); 
		query.append("	 	,SUBSTR(BAY_VVD, 6, 1) AS BAY_CAL" ).append("\n"); 
		query.append("	    ,T2.VSL_SLAN_CD" ).append("\n"); 
		query.append("	    ,TO_CHAR(T2.VPS_ETA_DT, 'YYYYMMDDHH24MI') AS VPS_ETA_DT" ).append("\n"); 
		query.append("	    ,TO_CHAR(T2.VPS_ETB_DT, 'YYYYMMDDHH24MI') AS VPS_ETB_DT" ).append("\n"); 
		query.append("	    ,TO_CHAR(T2.VPS_ETD_DT, 'YYYYMMDDHH24MI') AS VPS_ETD_DT" ).append("\n"); 
		query.append("	    ,CASE WHEN (T2.CUR_NOON_FLG = 'Y' AND CUR_DEP_FLG = 'Y') AND (T2.VPS_PORT_CD = 'EGSCA') THEN" ).append("\n"); 
		query.append("	        '0' /* 선박의 다음 포트가 EGSCA이고 REPORT가 존재하는 경우(DETAIL을 조회가 가능한 상태)  */" ).append("\n"); 
		query.append("	     ELSE" ).append("\n"); 
		query.append("	        '1' /* DETAIL 조회 불가능 상태 */" ).append("\n"); 
		query.append("	     END DETAIL" ).append("\n"); 
		query.append("	    ,T2.YD_CD" ).append("\n"); 
		query.append("	    ,T2.VPS_PORT_CD" ).append("\n"); 
		query.append("	    ,T2.CLPT_SEQ " ).append("\n"); 
		query.append("	    ,CASE" ).append("\n"); 
		query.append("	        WHEN T2.VPS_PORT_CD = 'PAPCA' THEN (" ).append("\n"); 
		query.append("	            /* PAPCA의 경우 PSO_TGT_VVD.CNL_TZ_BKG_STS_CD 컬럼을 조회하여 BOOKING 상태를 확인한다. */" ).append("\n"); 
		query.append("	            SELECT	DECODE(S.CNL_TZ_BKG_STS_CD, 'B', 'Booked', 'R', 'Ready', 'C', 'Cancel')" ).append("\n"); 
		query.append("	            FROM	PSO_TGT_VVD S" ).append("\n"); 
		query.append("	            WHERE	1=1" ).append("\n"); 
		query.append("	            AND		T2.VSL_CD		= S.VSL_CD" ).append("\n"); 
		query.append("	            AND		T2.SKD_VOY_NO	= S.SKD_VOY_NO" ).append("\n"); 
		query.append("	            AND		T2.SKD_DIR_CD	= S.SKD_DIR_CD" ).append("\n"); 
		query.append("	            AND		S.PSO_BZTP_CD	= '6'" ).append("\n"); 
		query.append("	        )" ).append("\n"); 
		query.append("	        WHEN T2.VPS_PORT_CD = 'EGSCA' THEN" ).append("\n"); 
		query.append("	        (" ).append("\n"); 
		query.append("	            /* EGSCA의 BOOKING 여부" ).append("\n"); 
		query.append("	            1. Booked ==> PSO_CNL_TZ_FEE.CNL_TZ_BZTP_CD = 'E' 이고 PSO_CNL_TZ_FEE.CNL_TZ_PROC_STS_CD = 'Q', 'A', 'P' 인 경우" ).append("\n"); 
		query.append("	            2. Ready ==> PSO_CNL_TZ_FEE.CNL_TZ_BZTP_CD = 'E' 이고 PSO_CNL_TZ_FEE.CNL_TZ_PROC_STS_CD = 'R' 인 경우" ).append("\n"); 
		query.append("	            */" ).append("\n"); 
		query.append("	            SELECT	DECODE(NVL(S2.CNL_TZ_PROC_STS_CD, 'R'), 'Q', 'Booked', 'A', 'Booked', 'P', 'Booked', 'R', 'Ready')" ).append("\n"); 
		query.append("	            FROM	PSO_TGT_VVD S1, PSO_CNL_TZ_FEE S2" ).append("\n"); 
		query.append("	            WHERE	1=1" ).append("\n"); 
		query.append("	            AND		T2.VSL_CD 		= S1.VSL_CD" ).append("\n"); 
		query.append("	            AND		T2.SKD_VOY_NO	= S1.SKD_VOY_NO" ).append("\n"); 
		query.append("	            AND		T2.SKD_DIR_CD	= S1.SKD_DIR_CD" ).append("\n"); 
		query.append("	            AND		S1.PSO_BZTP_CD	= S2.PSO_BZTP_CD	(+)" ).append("\n"); 
		query.append("	            AND		S1.VSL_CD		= S2.VSL_CD			(+)" ).append("\n"); 
		query.append("	            AND		S1.SKD_VOY_NO	= S2.SKD_VOY_NO		(+)" ).append("\n"); 
		query.append("	            AND		S1.SKD_DIR_CD	= S2.SKD_DIR_CD		(+)" ).append("\n"); 
		query.append("	            AND		S1.PSO_BZTP_CD	= '5'" ).append("\n"); 
		query.append("	            AND		'E' 			= S2.CNL_TZ_BZTP_CD	(+)" ).append("\n"); 
		query.append("	            AND		'EGSCA10'		= S2.YD_CD			(+)" ).append("\n"); 
		query.append("	        )" ).append("\n"); 
		query.append("	        END BKG_STS" ).append("\n"); 
		query.append("	    ,CASE" ).append("\n"); 
		query.append("			WHEN T2.VPS_PORT_CD = 'PAPCA' THEN NULL" ).append("\n"); 
		query.append("			ELSE (" ).append("\n"); 
		query.append("				NVL((  SELECT	LMT_TM_SCG_RTO" ).append("\n"); 
		query.append("	        	    	FROM	VSK_PORT_CNL_PASS_COND S" ).append("\n"); 
		query.append("		        	    WHERE	SVC_SCP_BND_CD	= T2.SVC_SCP_BND_CD" ).append("\n"); 
		query.append("	    	        	AND		LOC_CD			= T2.VPS_PORT_CD" ).append("\n"); 
		query.append("		        	    AND		CNL_TZ_SEQ_CD	=" ).append("\n"); 
		query.append("	            	    ( /* 해당 선박으로 INVOICE가 청구된 EGSCA CANAL NET TON를 조회한다. */" ).append("\n"); 
		query.append("			                SELECT CASE WHEN TO_NUMBER(NVL(SUBSTR(MAX(TO_CHAR(S1.RQST_DT, 'YYYYMMDDHH24MI') || S1.SUZ_NET_TONG_WGT ), 13), '0')) >= 70000 THEN" ).append("\n"); 
		query.append("			                    '1'  /* EGSCA CANAL NET TON 이 70000  보다 클 경우 : FIRST COMBO를 이용함 */" ).append("\n"); 
		query.append("			                ELSE" ).append("\n"); 
		query.append("			                    '2' /* EGSCA CANAL NET TON 이 70000  보다 작을 경우 : SECOND COMBO를 이용함 */" ).append("\n"); 
		query.append("			                END IF" ).append("\n"); 
		query.append("	    		            FROM	PSO_CNL_TZ_FEE S1" ).append("\n"); 
		query.append("	            		    WHERE	S1.PSO_BZTP_CD		= '5' /* Canal Transit Business    */" ).append("\n"); 
		query.append("			                AND		S1.CNL_TZ_BZTP_CD	= 'I' /* Inputted invoice at Canal Agency */" ).append("\n"); 
		query.append("			                AND		S1.VSL_CD			= T2.VSL_CD" ).append("\n"); 
		query.append("			                AND		S1.SKD_DIR_CD		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("			                AND		S1.YD_CD			= T2.YD_CD)" ).append("\n"); 
		query.append("			            AND TO_CHAR(T2.VPS_ETA_DT, 'HH24MI')	BETWEEN SCG_FM_LMT_HRMNT" ).append("\n"); 
		query.append("	        		    										AND SCG_TO_LMT_HRMNT), 0)) /* NULL일 경우 SURCHARGE는 0 % 이다 */" ).append("\n"); 
		query.append("			END AS SCG_LMT_ACT_RATIO        " ).append("\n"); 
		query.append("	    ,CASE" ).append("\n"); 
		query.append("			WHEN T2.VPS_PORT_CD = 'PAPCA' THEN NULL" ).append("\n"); 
		query.append("			ELSE (" ).append("\n"); 
		query.append("				ROUND(CASE WHEN CUR_NOON_FLG = 'Y' THEN" ).append("\n"); 
		query.append("			        /* NOON REPORT가 있는 경우 NOON REPORT 의 ETA SPEED 사용 */" ).append("\n"); 
		query.append("			        (   SELECT RMN_AVG_SPD" ).append("\n"); 
		query.append("			            FROM	VSK_NOON_RPT S" ).append("\n"); 
		query.append("			            WHERE	1=1" ).append("\n"); 
		query.append("			            AND		T2.VSL_CD		= S.VSL_CD" ).append("\n"); 
		query.append("			            AND		T2.SKD_VOY_NO	= S.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND		T2.SKD_DIR_CD	= S.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND		T2.NOON_RPT_DT	= S.NOON_RPT_DT)" ).append("\n"); 
		query.append("			    WHEN CUR_DEP_FLG = 'Y' THEN" ).append("\n"); 
		query.append("			        /* NOON REPORTS는 없고, DEPARTURE REPORT가 있는 경우 DEPARTURE REPORT 의 ETA SPEED 사용 */" ).append("\n"); 
		query.append("			        (   SELECT	RMN_AVG_SPD" ).append("\n"); 
		query.append("			            FROM	VSK_DEP_RPT S" ).append("\n"); 
		query.append("			            WHERE	1=1" ).append("\n"); 
		query.append("			            AND		T2.VSL_CD			= S.VSL_CD" ).append("\n"); 
		query.append("			            AND		T2.SKD_VOY_NO		= S.SKD_VOY_NO" ).append("\n"); 
		query.append("			            AND		T2.SKD_DIR_CD		= S.SKD_DIR_CD" ).append("\n"); 
		query.append("			            AND		T2.VPS_PORT_CD		= S.VPS_PORT_CD" ).append("\n"); 
		query.append("			            AND		T2.CLPT_IND_SEQ	= S.CLPT_IND_SEQ)" ).append("\n"); 
		query.append("			    WHEN CUR_NOON_FLG||CUR_DEP_FLG = 'NN' THEN" ).append("\n"); 
		query.append("			        /* 4. NOON & DEPARTURE REPORT가 전혀 입력되지 않은 경우.  */" ).append("\n"); 
		query.append("			        /* 4. 또는 아직 LAST PORT에도 도착하지 않은 경우...기타등등. */" ).append("\n"); 
		query.append("					TO_NUMBER(DECODE(T2.VPS_ETA_DT - PRE_PORT_ETD_DT, 0, NULL," ).append("\n"); 
		query.append("						NVL((   SELECT	STND_DIST" ).append("\n"); 
		query.append("							FROM	VSK_PORT_DIST" ).append("\n"); 
		query.append("							WHERE	FM_LOC_CD = T2.PRE_PORT" ).append("\n"); 
		query.append("			                AND		TO_LOC_CD = T2.VPS_PORT_CD)," ).append("\n"); 
		query.append("							(NVL(T2.PRE_LNK_DIST, 0))" ).append("\n"); 
		query.append("						) / (( T2.VPS_ETA_DT - PRE_PORT_ETD_DT) * 24 )" ).append("\n"); 
		query.append("					))" ).append("\n"); 
		query.append("			    END , 1))" ).append("\n"); 
		query.append("		END AS SCG_LMT_ACT_SPD" ).append("\n"); 
		query.append("	FROM " ).append("\n"); 
		query.append("	/***** T2 START *****/" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT	T1.* " ).append("\n"); 
		query.append("		        ,NVL((  " ).append("\n"); 
		query.append("						SELECT 'Y'" ).append("\n"); 
		query.append("						FROM    VSK_DEP_RPT S1, VSK_VSL_PORT_SKD S2" ).append("\n"); 
		query.append("						WHERE   1 = 1" ).append("\n"); 
		query.append("						AND     T1.VSL_CD       = S1.VSL_CD" ).append("\n"); 
		query.append("						AND     T1.SKD_VOY_NO   = S1.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND     T1.SKD_DIR_CD   = S1.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND     T1.VPS_PORT_CD  = S1.NXT_PORT_CD" ).append("\n"); 
		query.append("						AND     S1.VSL_CD       = S2.VSL_CD" ).append("\n"); 
		query.append("						AND     S1.SKD_VOY_NO   = S2.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND     S1.SKD_DIR_CD   = S2.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND     S1.VPS_PORT_CD  = S2.VPS_PORT_CD" ).append("\n"); 
		query.append("						AND     S1.CLPT_IND_SEQ = S2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("						AND     S2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("		            ), 'N') AS CUR_DEP_FLG" ).append("\n"); 
		query.append("		        ,(  " ).append("\n"); 
		query.append("						SELECT	S1.ACT_DEP_DT" ).append("\n"); 
		query.append("						FROM    VSK_DEP_RPT S1, VSK_VSL_PORT_SKD S2" ).append("\n"); 
		query.append("						WHERE   1 = 1" ).append("\n"); 
		query.append("						AND     T1.VSL_CD       = S1.VSL_CD" ).append("\n"); 
		query.append("						AND     T1.SKD_VOY_NO   = S1.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND     T1.SKD_DIR_CD   = S1.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND     T1.VPS_PORT_CD  = S1.NXT_PORT_CD" ).append("\n"); 
		query.append("						AND     S1.VSL_CD       = S2.VSL_CD" ).append("\n"); 
		query.append("						AND     S1.SKD_VOY_NO   = S2.SKD_VOY_NO" ).append("\n"); 
		query.append("						AND     S1.SKD_DIR_CD   = S2.SKD_DIR_CD" ).append("\n"); 
		query.append("						AND     S1.VPS_PORT_CD  = S2.VPS_PORT_CD" ).append("\n"); 
		query.append("						AND     S1.CLPT_IND_SEQ = S2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("						AND     S2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("		            ) AS ACT_DEP_DT" ).append("\n"); 
		query.append("		        ,NVL((  SELECT	'Y'" ).append("\n"); 
		query.append("		                FROM	VSK_NOON_RPT S" ).append("\n"); 
		query.append("		                WHERE	1 = 1" ).append("\n"); 
		query.append("		                AND		T1.VSL_CD		= S.VSL_CD" ).append("\n"); 
		query.append("		                AND		T1.SKD_VOY_NO	= S.SKD_VOY_NO" ).append("\n"); 
		query.append("		                AND		T1.SKD_DIR_CD	= S.SKD_DIR_CD" ).append("\n"); 
		query.append("		                AND		T1.VPS_PORT_CD	= S.NXT_PORT_CD" ).append("\n"); 
		query.append("		                AND		ROWNUM			= 1" ).append("\n"); 
		query.append("		                ), 'N') AS CUR_NOON_FLG" ).append("\n"); 
		query.append("		        ,(  SELECT	/*+ INDEX_DESC (S XPKVSK_NOON_RPT) */	        " ).append("\n"); 
		query.append("		            		S.NOON_RPT_DT" ).append("\n"); 
		query.append("		            FROM	VSK_NOON_RPT S" ).append("\n"); 
		query.append("		            WHERE	1 = 1" ).append("\n"); 
		query.append("		            AND		T1.VSL_CD		= S.VSL_CD" ).append("\n"); 
		query.append("		            AND		T1.SKD_VOY_NO	= S.SKD_VOY_NO" ).append("\n"); 
		query.append("		            AND		T1.SKD_DIR_CD	= S.SKD_DIR_CD" ).append("\n"); 
		query.append("		            AND		T1.VPS_PORT_CD	= S.NXT_PORT_CD" ).append("\n"); 
		query.append("		            AND		ROWNUM			= 1" ).append("\n"); 
		query.append("		            ) AS NOON_RPT_DT" ).append("\n"); 
		query.append("				,(	SELECT	/*+ INDEX_DESC (S1 XAK12VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("							S1.VPS_PORT_CD || S1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("					FROM	VSK_VSL_PORT_SKD S1" ).append("\n"); 
		query.append("					WHERE	S1.VSL_CD		= T1.VSL_CD" ).append("\n"); 
		query.append("					AND		S1.SKD_VOY_NO	= T1.SKD_VOY_NO" ).append("\n"); 
		query.append("					AND		S1.SKD_DIR_CD	= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("					AND		S1.VPS_ETD_DT  <= T1.VPS_ETD_DT" ).append("\n"); 
		query.append("					AND     T1.VPS_PORT_CD  = 'EGSCA'  " ).append("\n"); 
		query.append("					AND		EXISTS	(" ).append("\n"); 
		query.append("									SELECT	'X'" ).append("\n"); 
		query.append("									FROM	BAY_PLAN S2" ).append("\n"); 
		query.append("									WHERE	S2.VSL_CD		= S1.VSL_CD" ).append("\n"); 
		query.append("									AND		S2.VOY_NO		= S1.SKD_VOY_NO" ).append("\n"); 
		query.append("									AND		S2.DIR_CD		= S1.SKD_DIR_CD" ).append("\n"); 
		query.append("									AND		S2.PORT_CD		= S1.VPS_PORT_CD" ).append("\n"); 
		query.append("									AND		S2.CALL_IND		= S1.CLPT_IND_SEQ" ).append("\n"); 
		query.append("									AND		ROWNUM			= 1" ).append("\n"); 
		query.append("									)											" ).append("\n"); 
		query.append("					AND		ROWNUM		= 1" ).append("\n"); 
		query.append("				) AS BAY_VVD" ).append("\n"); 
		query.append("		    FROM (" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		        SELECT	T1.*" ).append("\n"); 
		query.append("						, LNK_DIST" ).append("\n"); 
		query.append("						, LAG(LNK_DIST) OVER(PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY T1.CLPT_SEQ) PRE_LNK_DIST						" ).append("\n"); 
		query.append("		        FROM (" ).append("\n"); 
		query.append("		            SELECT" ).append("\n"); 
		query.append("		                DECODE(T3.SVC_SCP_BND_CD, 'N', 'North Bound', 'S', 'South Bound') BOUND" ).append("\n"); 
		query.append("		                , T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("		                , T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("		                , T2.VSL_CD" ).append("\n"); 
		query.append("		                , T2.SKD_VOY_NO" ).append("\n"); 
		query.append("		                , T2.SKD_DIR_CD" ).append("\n"); 
		query.append("		                , T2.VPS_PORT_CD" ).append("\n"); 
		query.append("		                , T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("		                , T2.CLPT_SEQ" ).append("\n"); 
		query.append("		                , T2.YD_CD" ).append("\n"); 
		query.append("		                , T2.VPS_ETA_DT" ).append("\n"); 
		query.append("		                , T2.VPS_ETB_DT " ).append("\n"); 
		query.append("		                , T2.VPS_ETD_DT" ).append("\n"); 
		query.append("		                , T2.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("		                , DECODE(T3.SVC_SCP_BND_CD, 'W', 'N', 'E', 'S') AS SVC_SCP_BND_CD" ).append("\n"); 
		query.append("		                , LAG(T2.VPS_PORT_CD) OVER (PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY T2.CLPT_SEQ) AS PRE_PORT" ).append("\n"); 
		query.append("		                , LAG(T2.VPS_ETD_DT ) OVER (PARTITION BY T2.VSL_CD, T2.SKD_VOY_NO, T2.SKD_DIR_CD ORDER BY T2.CLPT_SEQ) AS PRE_PORT_ETD_DT" ).append("\n"); 
		query.append("		            FROM	(	SELECT	T2.*" ).append("\n"); 
		query.append("								FROM 	VSK_VSL_SKD			T1" ).append("\n"); 
		query.append("										, VSK_VSL_PORT_SKD	T2" ).append("\n"); 
		query.append("										, MDM_VSL_CNTR		T3" ).append("\n"); 
		query.append("										, MDM_VSL_SVC_LANE	T4" ).append("\n"); 
		query.append("										, MDM_VENDOR		T5" ).append("\n"); 
		query.append("								WHERE	1=1" ).append("\n"); 
		query.append("								AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("								AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("								AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("	#if (${port_cd} == 'A')" ).append("\n"); 
		query.append("								AND		T2.VPS_PORT_CD IN ('EGSCA', 'PAPCA') /* CANAL */" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("								AND		T2.VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("								AND		T1.VSL_SLAN_CD	= @[vsl_slan_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("								AND		T2.VPS_ETB_DT BETWEEN TO_DATE(@[start_date], 'YYYY-MM-DD') AND TO_DATE(@[end_date], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("								AND		T2.VSL_CD		= T3.VSL_CD" ).append("\n"); 
		query.append("								AND		T3.CRR_CD		= COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("								AND		T1.VSL_SLAN_CD	= T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("								AND		T5.CNL_AGN_FLG	= 'Y'" ).append("\n"); 
		query.append("                                AND     T4.VSL_TP_CD    = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("								AND		T4.CNL_AGN_VNDR_SEQ = T5.VNDR_SEQ" ).append("\n"); 
		query.append("	#if (${vndr_seq} != 'ALL' && ${vndr_seq} != '') " ).append("\n"); 
		query.append("								AND T5.VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("							) T0" ).append("\n"); 
		query.append("							" ).append("\n"); 
		query.append("				            , VSK_VSL_SKD		T1" ).append("\n"); 
		query.append("				            , VSK_VSL_PORT_SKD	T2" ).append("\n"); 
		query.append("				            , MDM_VSL_SVC_LANE_DIR T3" ).append("\n"); 
		query.append("		            WHERE	1=1" ).append("\n"); 
		query.append("		            AND		T0.VSL_CD		= T1.VSL_CD" ).append("\n"); 
		query.append("		            AND		T0.SKD_VOY_NO	= T1.SKD_VOY_NO" ).append("\n"); 
		query.append("		            AND		T0.SKD_DIR_CD	= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("		            AND		T1.VSL_CD		= T2.VSL_CD" ).append("\n"); 
		query.append("		            AND		T1.SKD_VOY_NO	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("		            AND		T1.SKD_DIR_CD	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("		            AND		T1.VSL_SLAN_CD	= T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("		            AND		T1.SKD_DIR_CD	= T3.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("		            AND		T3.SVC_SCP_BND_CD IS NOT NULL" ).append("\n"); 
		query.append("		            AND		NVL(T2.SKD_CNG_STS_CD, ' ') != 'S'" ).append("\n"); 
		query.append("		            ) T1, VSK_PF_SKD_DTL S" ).append("\n"); 
		query.append("		        WHERE	1 = 1" ).append("\n"); 
		query.append("		        AND		S.VSL_SLAN_CD	= T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("		        AND		S.PF_SVC_TP_CD	= T1.PF_SKD_TP_CD" ).append("\n"); 
		query.append("		        AND		S.SKD_DIR_CD	= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("		        AND		S.PORT_CD		= T1.VPS_PORT_CD" ).append("\n"); 
		query.append("		        AND		S.CLPT_SEQ		= T1.CLPT_IND_SEQ	    " ).append("\n"); 
		query.append("		    " ).append("\n"); 
		query.append("		    ) T1" ).append("\n"); 
		query.append("		    WHERE	1=1" ).append("\n"); 
		query.append("	#if (${port_cd} == 'A')" ).append("\n"); 
		query.append("	-- AND		VPS_PORT_CD	IN (SELECT INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL WHERE INTG_CD_ID='CD20068') /* CANAL */" ).append("\n"); 
		query.append("		AND	VPS_PORT_CD	IN ('EGSCA', 'PAPCA') /* CANAL */" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("			AND		VPS_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("		) T2" ).append("\n"); 
		query.append("							" ).append("\n"); 
		query.append("	/***** T2 END *****/" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${surcharge} == 'Y') " ).append("\n"); 
		query.append("AND NVL(SCG_LMT_ACT_RATIO, 0) != 0" ).append("\n"); 
		query.append("#elseif (${surcharge} == 'N') " ).append("\n"); 
		query.append("AND NVL(SCG_LMT_ACT_RATIO, 0) = 0" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BOUND, VPS_ETA_DT" ).append("\n"); 

	}
}