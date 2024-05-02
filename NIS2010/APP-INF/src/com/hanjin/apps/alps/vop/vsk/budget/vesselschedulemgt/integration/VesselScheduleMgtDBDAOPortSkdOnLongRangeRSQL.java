/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOPortSkdOnLongRangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.22 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
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
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
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
		query.append("T2.VSL_SLAN_CD" ).append("\n"); 
		query.append(",T2.PF_SKD_TP_CD" ).append("\n"); 
		query.append(",T4.VSL_SVC_TP_CD" ).append("\n"); 
		query.append(",T2.VSL_CD" ).append("\n"); 
		query.append(",T2.SKD_VOY_NO" ).append("\n"); 
		query.append(",T2.SKD_DIR_CD" ).append("\n"); 
		query.append(",T2.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append(",T3.VPS_PORT_CD" ).append("\n"); 
		query.append(",T3.CLPT_IND_SEQ" ).append("\n"); 
		query.append(",T3.CLPT_SEQ" ).append("\n"); 
		query.append(",T3.PORT_SKD_STS_CD" ).append("\n"); 
		query.append(",T3.YD_CD" ).append("\n"); 
		query.append(",T3.CALL_YD_IND_SEQ" ).append("\n"); 
		query.append(",T3.PF_ETA_DT" ).append("\n"); 
		query.append(",T3.PF_ETB_DT" ).append("\n"); 
		query.append(",T3.PF_ETD_DT" ).append("\n"); 
		query.append(",T3.INIT_ETA_DT" ).append("\n"); 
		query.append(",T3.INIT_ETB_DT" ).append("\n"); 
		query.append(",T3.INIT_ETD_DT" ).append("\n"); 
		query.append(",T3.VPS_ETA_DT" ).append("\n"); 
		query.append(",T3.VPS_ETB_DT" ).append("\n"); 
		query.append(",T3.VPS_ETD_DT" ).append("\n"); 
		query.append(",T3.SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",T3.TURN_PORT_FLG" ).append("\n"); 
		query.append(",T3.TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",T3.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append(",T3.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append(",T3.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",T2.SKD_RMK AS VPS_RMK" ).append("\n"); 
		query.append(",'' AS START_DATE" ).append("\n"); 
		query.append(",'' AS END_DATE" ).append("\n"); 
		query.append(",TO_CHAR(T3.CRE_DT, 'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append(",T3.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(T3.UPD_DT, 'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append(",T3.UPD_USR_ID" ).append("\n"); 
		query.append(",(SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD=T3.VPS_PORT_CD) PORT_NM" ).append("\n"); 
		query.append(",(SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD=T3.VSL_CD) VSL_ENG_NM" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
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
		query.append("								FROM VSK_BUD_VSL_SKD T1, VSK_BUD_PF_SKD_DTL T2" ).append("\n"); 
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
		query.append("							) T1, VSK_BUD_VSL_PORT_SKD T2" ).append("\n"); 
		query.append("                        WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("                        AND T1.VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("                        AND T2.SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${vsl_cd} != '')" ).append("\n"); 
		query.append("                        AND T2.VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("                        AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("                        AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("                        AND T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("						--AND T3.TURN_PORT_IND_CD!='F'" ).append("\n"); 
		query.append("						--AND T3.TURN_PORT_IND_CD!='D'" ).append("\n"); 
		query.append("                        AND T2.TURN_PORT_IND_CD!='V'" ).append("\n"); 
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
		query.append("		FROM VSK_BUD_VSL_SKD T1, VSK_BUD_PF_SKD_DTL T2" ).append("\n"); 
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
		query.append(") T2, VSK_BUD_VSL_PORT_SKD T3, MDM_VSL_SVC_LANE T4" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append("AND T2.VSL_SLAN_CD=@[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND T2.VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND T2.VSL_SLAN_CD = T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD=T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO=T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD=T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T2.VSL_CD=T3.VSL_CD" ).append("\n"); 
		query.append("AND T2.SKD_VOY_NO=T3.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T2.SKD_DIR_CD=T3.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T3.TURN_PORT_IND_CD!='D'" ).append("\n"); 
		query.append("AND T3.TURN_PORT_IND_CD!='V'" ).append("\n"); 
		query.append("AND T4.VSL_TP_CD='C' /*컨테이너선*/" ).append("\n"); 
		query.append("ORDER BY T3.VSL_CD, T3.SKD_VOY_NO, T2.VSL_SLAN_DIR_SEQ, T3.CLPT_SEQ" ).append("\n"); 

	}
}