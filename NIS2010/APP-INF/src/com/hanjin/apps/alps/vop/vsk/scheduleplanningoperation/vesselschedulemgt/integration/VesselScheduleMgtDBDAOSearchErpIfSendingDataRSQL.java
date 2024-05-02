/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchErpIfSendingDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
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

public class VesselScheduleMgtDBDAOSearchErpIfSendingDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchErpIfSendingData
	  * -------------------------------------------------------------------------
	  * 2010.11.24 이석준 [CHM-201007341-01] Actual SKD ERP I/F 로직 변경
	  * 2012.12.18 김상수 [CHM-201221884-01] CNTR 진행기준 대상항차 선정기능 보완
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchErpIfSendingDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchErpIfSendingDataRSQL").append("\n"); 
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
		query.append("SELECT  'FNS017-0001'                                                            AS LIFID" ).append("\n"); 
		query.append("        , VSL_CD||SKD_VOY_NO||SKD_DIR_CD||TO_CHAR(SYSDATE,'YYYYMMDD HH24:MI:SS') AS SEQ" ).append("\n"); 
		query.append("        , LINE_CNT                                                               AS TOTAL_COUNT" ).append("\n"); 
		query.append("        , SEQ                                                                    AS ROW_NUM" ).append("\n"); 
		query.append("        , VSL_CD                                                                 AS VSL    " ).append("\n"); 
		query.append("        , SKD_VOY_NO                                                             AS VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD                                                             AS DEP" ).append("\n"); 
		query.append("        , SKD_VOY_TP_CD                                                          AS VOY_TP" ).append("\n"); 
		query.append("        , VSL_SLAN_CD                                                            AS LANE" ).append("\n"); 
		query.append("        , LOAD_QNT" ).append("\n"); 
		query.append("        , SURVEY" ).append("\n"); 
		query.append("        , VESSEL_CHECK" ).append("\n"); 
		query.append("        , LINE_CNT" ).append("\n"); 
		query.append("        , DTL_VSL" ).append("\n"); 
		query.append("        , DTL_VOY_NO" ).append("\n"); 
		query.append("        , DTL_DEP" ).append("\n"); 
		query.append("        , CLPT_SEQ                                                               AS PORT_SEQ" ).append("\n"); 
		query.append("        , VPS_LOC_CD                                                             AS PT" ).append("\n"); 
		query.append("        , TO_CHAR(EST_ARR_DT,'YYYYMMDD')                                         AS EST_ARR_DT" ).append("\n"); 
		query.append("        , TO_CHAR(EST_SAIL_DT,'YYYYMMDD')                                        AS EST_SAIL_DT" ).append("\n"); 
		query.append("        , TO_CHAR(ACT_ARR_DT,'YYYYMMDD')                                         AS ACT_ARR_DT" ).append("\n"); 
		query.append("        , TO_CHAR(ACT_SAIL_DT,'YYYYMMDD')                                        AS ACT_SAIL_DT" ).append("\n"); 
		query.append("        , POSITION" ).append("\n"); 
		query.append("        , TO_CHAR(LOG_RGST,'DDMonRR')                                            AS LOG_RGST" ).append("\n"); 
		query.append("        , TO_CHAR(LOG_UPDT,'DDMonRR')                                            AS LOG_UPDT" ).append("\n"); 
		query.append("        , LOG_USERID" ).append("\n"); 
		query.append("        , SKD_CNG_STS_CD                                                         AS CHANGE_IND" ).append("\n"); 
		query.append("        ,CASE WHEN DELT_FLG = 'C' THEN   /* DELT_FLG = 'C' : 1개 PORT가 있고, SKIP되지 않은 VIRTUAL PORT가 있을 경우..'N' */" ).append("\n"); 
		query.append("                DECODE((" ).append("\n"); 
		query.append("                SELECT  COUNT(*)" ).append("\n"); 
		query.append("                FROM    VSK_VSL_PORT_SKD 		S1" ).append("\n"); 
		query.append("                WHERE   1 = 1" ).append("\n"); 
		query.append("                AND     T21.VSL_CD          	= S1.VSL_CD" ).append("\n"); 
		query.append("                AND     T21.SKD_VOY_NO      	= S1.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND     T21.SKD_DIR_CD      	= S1.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND     'S'                 	<> NVL(S1.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                AND     S1.TURN_PORT_IND_CD 	IN ('D', 'V', 'F'))" ).append("\n"); 
		query.append("                , 0, 'Y', 'N')" ).append("\n"); 
		query.append("            ELSE    DELT_FLG    END                                              AS DEL_MK" ).append("\n"); 
		query.append("        , TURN_PORT_IND_CD                                                       AS TURN_IND" ).append("\n"); 
		query.append("        , H_REMARK" ).append("\n"); 
		query.append("        , D_REMARK" ).append("\n"); 
		query.append("        , NEW_SAIL_DT" ).append("\n"); 
		query.append("        , NEW_ARR_DT" ).append("\n"); 
		query.append("        , SKD_STS_CD                                                             AS SKD_SKD_STAT" ).append("\n"); 
		query.append("        , PORT_SKD_STS_CD                                                        AS VPS_SKD_STAT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , CLPT_IND_SEQ" ).append("\n"); 
		query.append("        , TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("        , TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("        , TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    (SELECT ROW_NUMBER() OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD ORDER BY CLPT_SEQ)      AS SEQ" ).append("\n"); 
		query.append("                ,T1.VSL_CD                                                                                      AS VSL_CD" ).append("\n"); 
		query.append("                ,T1.SKD_VOY_NO                                                                                  AS SKD_VOY_NO" ).append("\n"); 
		query.append("                ,T1.SKD_DIR_CD                                                                                  AS SKD_DIR_CD" ).append("\n"); 
		query.append("                ,(SELECT DECODE(S1.VSL_SVC_TP_CD||DECODE(S2.VSL_OWN_IND_CD, 'O', 'O', 'C')||DECODE(S2.CRR_CD, 'SML', 'H', 'X')," ).append("\n"); 
		query.append("                                    'SOH', 'CJ', 'SCH', 'CV'," ).append("\n"); 
		query.append("                                    'SOX', 'CB', 'SCX', 'CB'," ).append("\n"); 
		query.append("                                    'JOH', 'CJ', 'JCH', 'CV'," ).append("\n"); 
		query.append("                                    'JOX', 'CA', 'JCX', 'CA'," ).append("\n"); 
		query.append("                                    'IOH', 'CI', 'ICH', 'CC'," ).append("\n"); 
		query.append("                                    'IOX', 'CA', 'ICX', 'CA'," ).append("\n"); 
		query.append("                                    'OOH', 'CJ', 'OCH', 'CV'," ).append("\n"); 
		query.append("                                    'OOX', 'CB', 'OCX', 'CB'" ).append("\n"); 
		query.append("                            )                                                                                   AS SKD_VOY_TP_CD" ).append("\n"); 
		query.append("                    FROM    MDM_VSL_SVC_LANE 	S1" ).append("\n"); 
		query.append("						, 	MDM_VSL_CNTR 		S2" ).append("\n"); 
		query.append("                    WHERE   1 = 1" ).append("\n"); 
		query.append("                    AND     S1.VSL_SLAN_CD   	= T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                    AND     S2.VSL_CD        	= T1.VSL_CD" ).append("\n"); 
		query.append("                    AND     S1.VSL_TP_CD     	= 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("                )                                                                                               AS SKD_VOY_TP_CD" ).append("\n"); 
		query.append("                , T1.VSL_SLAN_CD                                                                                AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                , '0'                                                                                           AS LOAD_QNT" ).append("\n"); 
		query.append("                , MAX(DECODE(T2.TURN_PORT_FLG, 'Y', 1, 0)) OVER (PARTITION BY T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD) AS SURVEY" ).append("\n"); 
		query.append("                , 'Y'                                                                                           AS VESSEL_CHECK" ).append("\n"); 
		query.append("                , COUNT(*) OVER ()                                                                              AS LINE_CNT" ).append("\n"); 
		query.append("                , T1.VSL_CD                                                                                     AS DTL_VSL" ).append("\n"); 
		query.append("                , T1.SKD_VOY_NO                                                                                 AS DTL_VOY_NO" ).append("\n"); 
		query.append("                , T1.SKD_DIR_CD                                                                                 AS DTL_DEP" ).append("\n"); 
		query.append("                , T2.CLPT_SEQ   " ).append("\n"); 
		query.append("                , T2.VPS_PORT_CD                                                                                AS VPS_LOC_CD" ).append("\n"); 
		query.append("                , DECODE(T2.PORT_SKD_STS_CD, NULL, T2.VPS_ETA_DT, NULL)                                         AS EST_ARR_DT" ).append("\n"); 
		query.append("                , DECODE(T2.PORT_SKD_STS_CD, NULL, T2.VPS_ETD_DT, 'A', T2.VPS_ETD_DT, NULL)                     AS EST_SAIL_DT" ).append("\n"); 
		query.append("                , DECODE(T2.PORT_SKD_STS_CD, 'A' , T2.VPS_ETA_DT, 'B', T2.VPS_ETA_DT, 'D', T2.VPS_ETA_DT, NULL) AS ACT_ARR_DT" ).append("\n"); 
		query.append("                , DECODE(T2.PORT_SKD_STS_CD, 'B' , T2.VPS_ETD_DT, 'D', T2.VPS_ETD_DT,  NULL)                    AS ACT_SAIL_DT" ).append("\n"); 
		query.append("                , 'N'                                                                                           AS POSITION" ).append("\n"); 
		query.append("                , T2.CRE_DT                                                                                     AS LOG_RGST" ).append("\n"); 
		query.append("                , T2.UPD_DT                                                                                     AS LOG_UPDT" ).append("\n"); 
		query.append("                , T2.CRE_USR_ID                                                                                 AS LOG_USERID" ).append("\n"); 
		query.append("                , T2.SKD_CNG_STS_CD                                                                             AS SKD_CNG_STS_CD" ).append("\n"); 
		query.append("                , DECODE((" ).append("\n"); 
		query.append("                        SELECT  COUNT(*)" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_PORT_SKD 	S1" ).append("\n"); 
		query.append("                        WHERE   1 = 1" ).append("\n"); 
		query.append("                        AND     T1.VSL_CD         	= S1.VSL_CD" ).append("\n"); 
		query.append("                        AND     T1.SKD_VOY_NO     	= S1.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND     T1.SKD_DIR_CD     	= S1.SKD_DIR_CD" ).append("\n"); 
		query.append("                        AND     'S'              	<> NVL(S1.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                        AND     TURN_PORT_IND_CD 	NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("                    ), 0, 'Y', 1, 'C', 'N')                                                                     AS DELT_FLG            /* SKIP & VIRUAL PORT를 제외한 COUNT가 0 이면 삭제 */" ).append("\n"); 
		query.append("                , T2.TURN_PORT_IND_CD                                                                           AS TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                , SUBSTR(T1.SKD_RMK, 1, 400)                                                                    AS H_REMARK" ).append("\n"); 
		query.append("                , SUBSTR(T2.VPS_RMK, 1, 400)                                                                    AS D_REMARK" ).append("\n"); 
		query.append("                , SUBSTR(TO_CHAR(VPS_ETA_DT,'YYYYMMDDHH24MISS'),9,6)                                            AS NEW_ARR_DT" ).append("\n"); 
		query.append("                , SUBSTR(TO_CHAR(VPS_ETD_DT,'YYYYMMDDHH24MISS'),9,6)                                            AS NEW_SAIL_DT" ).append("\n"); 
		query.append("                , T1.SKD_STS_CD                                                                                 AS SKD_STS_CD" ).append("\n"); 
		query.append("                , T2.PORT_SKD_STS_CD                                                                            AS PORT_SKD_STS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                , T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , T2.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                , T2.TURN_SKD_DIR_CD " ).append("\n"); 
		query.append("                , T2.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        FROM    VSK_VSL_SKD         	T1" ).append("\n"); 
		query.append("			, 	VSK_VSL_PORT_SKD    	T2" ).append("\n"); 
		query.append("			,	MDM_VSL_SVC_LANE    	T3" ).append("\n"); 
		query.append("        WHERE   1   = 1" ).append("\n"); 
		query.append("        AND     T1.VSL_CD          		= T2.VSL_CD" ).append("\n"); 
		query.append("        AND     T1.SKD_VOY_NO      		= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("        AND     T1.SKD_DIR_CD      		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("        AND     T1.VSL_SLAN_CD     		= T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("        AND     T1.SKD_STS_CD      		= 'ACT'            /* Activate된 SKD 정보만 ERP에 전송함 */" ).append("\n"); 
		query.append("        AND     T3.VSL_TP_CD       		= 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("        AND     EXISTS    				(SELECT  'Y'" ).append("\n"); 
		query.append("                           				 FROM    AR_ROUT_RNK 		S" ).append("\n"); 
		query.append("                           				 WHERE   T3.VSL_SLAN_CD    	= SUBSTR(S.RLANE_CD, 1, 3)" ).append("\n"); 
		query.append("                           				 AND     S.DELT_FLG        	= 'N'" ).append("\n"); 
		query.append("                           				)" ).append("\n"); 
		query.append("        AND     T1.VSL_CD          		= @[vsl_cd]" ).append("\n"); 
		query.append("        AND     T1.SKD_VOY_NO      		= @[skd_voy_no]" ).append("\n"); 
		query.append("        AND     T1.SKD_DIR_CD      		= @[skd_dir_cd]" ).append("\n"); 
		query.append("        AND     T1.VSL_SLAN_CD     		= @[vsl_slan_cd]" ).append("\n"); 
		query.append("        AND	    EXISTS 					(SELECT 'Y' FROM MDM_VSL_CNTR S WHERE S.VSL_CD = T1.VSL_CD AND S.VSL_CLSS_FLG != 'T')" ).append("\n"); 
		query.append("        ) T21" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* Delete된 SKD은 Ready, Close, Activate별로 전송할 필요 없음. ERP측에서 필터링 하기로 함. */" ).append("\n"); 
		query.append("SELECT 'FNS017-0001'          AS LIFID" ).append("\n"); 
		query.append("        ,@[vsl_cd]||@[skd_voy_no]||@[skd_dir_cd]||TO_CHAR(SYSDATE,'YYYYMMDD HH24:MI:SS') AS SEQ" ).append("\n"); 
		query.append("        ,NULL                 AS TOTAL_COUNT" ).append("\n"); 
		query.append("        ,NULL                 AS ROW_NUM" ).append("\n"); 
		query.append("        ,@[vsl_cd]            AS VSL" ).append("\n"); 
		query.append("        ,@[skd_voy_no]        AS VOY_NO" ).append("\n"); 
		query.append("        ,@[skd_dir_cd]        AS DEP" ).append("\n"); 
		query.append("        ,NULL                 AS VOY_TP" ).append("\n"); 
		query.append("        ,@[vsl_slan_cd]       AS LANE" ).append("\n"); 
		query.append("        ,NULL                 AS LOAD_QNT" ).append("\n"); 
		query.append("        ,NULL                 AS SURVEY" ).append("\n"); 
		query.append("        ,NULL                 AS VESSEL_CHECK" ).append("\n"); 
		query.append("        ,NULL                 AS LINE_CNT" ).append("\n"); 
		query.append("        ,NULL                 AS DTL_VSL" ).append("\n"); 
		query.append("        ,NULL                 AS DTL_VOY_NO" ).append("\n"); 
		query.append("        ,NULL                 AS DTL_DEP" ).append("\n"); 
		query.append("        ,NULL                 AS PORT_SEQ" ).append("\n"); 
		query.append("        ,NULL                 AS PT" ).append("\n"); 
		query.append("        ,NULL                 AS EST_ARR_DT" ).append("\n"); 
		query.append("        ,NULL                 AS EST_SAIL_DT" ).append("\n"); 
		query.append("        ,NULL                 AS ACT_ARR_DT" ).append("\n"); 
		query.append("        ,NULL                 AS ACT_SAIL_DT" ).append("\n"); 
		query.append("        ,NULL                 AS POSITION" ).append("\n"); 
		query.append("        ,NULL                 AS LOG_RGST" ).append("\n"); 
		query.append("        ,NULL                 AS LOG_UPDT" ).append("\n"); 
		query.append("        ,NULL                 AS LOG_USERID" ).append("\n"); 
		query.append("        ,NULL                 AS CHANGE_IND" ).append("\n"); 
		query.append("        ,'D'                  AS DEL_MK" ).append("\n"); 
		query.append("        ,NULL                 AS TURN_IND" ).append("\n"); 
		query.append("        ,NULL                 AS H_REMARK" ).append("\n"); 
		query.append("        ,NULL                 AS D_REMARK" ).append("\n"); 
		query.append("        ,NULL                 AS NEW_SAIL_DT" ).append("\n"); 
		query.append("        ,NULL                 AS NEW_ARR_DT" ).append("\n"); 
		query.append("        ,NULL                 AS SKD_SKD_STAT" ).append("\n"); 
		query.append("        ,NULL                 AS VPS_SKD_STAT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,NULL				  AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("        ,NULL				  AS TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,NULL				  AS TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,NULL				  AS TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM    DUAL" ).append("\n"); 
		query.append("WHERE   EXISTS 				(SELECT   	'Y'" ).append("\n"); 
		query.append("                			 FROM     	AR_ROUT_RNK" ).append("\n"); 
		query.append("                			 WHERE    	SUBSTR(RLANE_CD, 1, 3) = @[vsl_slan_cd]" ).append("\n"); 
		query.append("                			 AND      	DELT_FLG               = 'N')" ).append("\n"); 
		query.append("AND     0 =    				(SELECT  	COUNT(*)" ).append("\n"); 
		query.append("                			 FROM    	VSK_VSL_SKD 			T1" ).append("\n"); 
		query.append("									, 	VSK_VSL_PORT_SKD 		T2" ).append("\n"); 
		query.append("                			 WHERE   	1 = 1" ).append("\n"); 
		query.append("                			 AND     	T1.VSL_CD            	= T2.VSL_CD" ).append("\n"); 
		query.append("                			 AND     	T1.SKD_VOY_NO        	= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                			 AND     	T1.SKD_DIR_CD        	= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("                			 AND     	T1.VSL_CD            	= @[vsl_cd]" ).append("\n"); 
		query.append("                			 AND     	T1.SKD_VOY_NO        	= @[skd_voy_no]" ).append("\n"); 
		query.append("                			 AND     	T1.SKD_DIR_CD        	= @[skd_dir_cd]" ).append("\n"); 
		query.append("                			 AND     	T1.VSL_SLAN_CD       	= @[vsl_slan_cd]" ).append("\n"); 
		query.append("                			 AND     	'S'                 	<> NVL(T2.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("                			 AND     	T2.TURN_PORT_IND_CD 	NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("               				)" ).append("\n"); 
		query.append("AND     EXISTS 				(SELECT 'Y' FROM MDM_VSL_CNTR S WHERE S.VSL_CD = @[vsl_cd] AND S.VSL_CLSS_FLG != 'T')" ).append("\n"); 

	}
}