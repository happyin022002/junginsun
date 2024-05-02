/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOVvdBkgStsVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.18 
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

public class VesselScheduleMgtDBDAOVvdBkgStsVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신규로 생성한 VVD에 대해서 이미 등록되여 있고, Booking 시스템 및 Senator 시스템에 사용 중인지 확인한다.
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOVvdBkgStsVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOVvdBkgStsVORSQL").append("\n"); 
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
		query.append("SimulationVvdCheckVO.java" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("'' VSL_CD" ).append("\n"); 
		query.append(",'' SKD_VOY_NO" ).append("\n"); 
		query.append(",'' START_DATE" ).append("\n"); 
		query.append(",'' END_DATE" ).append("\n"); 
		query.append(",'' VSL_CNT" ).append("\n"); 
		query.append(",'' VOY_NO_TYPE" ).append("\n"); 
		query.append(",'' SKD_DIR_CD_1" ).append("\n"); 
		query.append(",'' SKD_DIR_CD_2" ).append("\n"); 
		query.append(",'' DURATION" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT VSL_SLAN_CD," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       CASE WHEN BKG_STATUS IS NULL AND ACT_SKD_KNT > 0 THEN 'ACT SKED' ELSE BKG_STATUS END BKG_STATUS," ).append("\n"); 
		query.append("       VIR_BKG_STATUS," ).append("\n"); 
		query.append("       TO_CHAR(VPS_ETA_DT, 'YYYYMMDD') START_ETA," ).append("\n"); 
		query.append("       CASE WHEN ROUND(VPS_ETA_DT - SYSDATE) < 3 AND BKG_STATUS = 'Booking' THEN " ).append("\n"); 
		query.append("            /* VPS_ETA_DT가 시스템시간 3일 이내이고, booking이 걸려있는 VVD면 삭제불가 */" ).append("\n"); 
		query.append("            'NO' " ).append("\n"); 
		query.append("            WHEN RUSE_PROHI_FLG = 'Y' THEN" ).append("\n"); 
		query.append("            /* 재무VVD에 등록된 VVD면 삭제불가 */" ).append("\n"); 
		query.append("            'NO'" ).append("\n"); 
		query.append("            ELSE 'YES' " ).append("\n"); 
		query.append("        END AS UPDATE_FLAG" ).append("\n"); 
		query.append("       ,TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("       ,RUSE_PROHI_FLG" ).append("\n"); 
		query.append("       , CASE WHEN ACT_SKD_KNT = 0 THEN 'N'" ).append("\n"); 
		query.append("              ELSE 'Y'" ).append("\n"); 
		query.append("         END  ACT_SKD_INPUT_FLG" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("	    SELECT" ).append("\n"); 
		query.append("	           T1.VSL_SLAN_CD," ).append("\n"); 
		query.append("	T1.VSL_CD," ).append("\n"); 
		query.append("	T1.SKD_VOY_NO," ).append("\n"); 
		query.append("	T1.SKD_DIR_CD, " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("		SELECT 'Booking'" ).append("\n"); 
		query.append("		FROM BKG_VVD B, BKG_BOOKING A" ).append("\n"); 
		query.append("		WHERE B.VSL_CD = T1.VSL_CD" ).append("\n"); 
		query.append("		AND B.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND B.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("		--AND A.BKG_NO_SPLIT = B.BKG_NO_SPLIT" ).append("\n"); 
		query.append("		AND A.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("		AND ROWNUM = 1" ).append("\n"); 
		query.append("	) BKG_STATUS, " ).append("\n"); 
		query.append("	DECODE(" ).append("\n"); 
		query.append("	    (SELECT" ).append("\n"); 
		query.append("    	--CASE WHEN VPS_ETA_DT > TO_DATE('20090709', 'YYYYMMDD') + 3 THEN '1'" ).append("\n"); 
		query.append("	    CASE WHEN VPS_ETA_DT > SYSDATE + 3 THEN '1'" ).append("\n"); 
		query.append("    	ELSE '2'" ).append("\n"); 
		query.append("	    END" ).append("\n"); 
		query.append("	    FROM VSK_VSL_PORT_SKD A, BKG_VVD B, BKG_BOOKING C" ).append("\n"); 
		query.append("	    WHERE T1.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("	    AND T1.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("	    AND T1.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("	    AND B.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("	    AND B.SKD_VOY_NO = A.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("	    AND B.SKD_DIR_CD = A.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	    AND B.POD_CD = A.VPS_PORT_CD" ).append("\n"); 
		query.append("	    AND A.TURN_PORT_FLG = 'Y'" ).append("\n"); 
		query.append("	    AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("	    AND C.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("	    AND ROWNUM=1), NULL, T1.SKD_STS_CD, '1', 'BKG', '2', 'BKGNOD'" ).append("\n"); 
		query.append("	) VIR_BKG_STATUS," ).append("\n"); 
		query.append("	VPS_ETA_DT, " ).append("\n"); 
		query.append("	ROUND(VPS_ETA_DT - SYSDATE)" ).append("\n"); 
		query.append("	,T2.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("	,T2.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("	,T1.RUSE_PROHI_FLG" ).append("\n"); 
		query.append("    ,(SELECT COUNT(1)" ).append("\n"); 
		query.append("   		FROM VSK_ACT_PORT_SKD AK" ).append("\n"); 
		query.append("   	   WHERE 1 = 1" ).append("\n"); 
		query.append("   		 AND ( AK.VSL_CD         = T1.VSL_CD" ).append("\n"); 
		query.append("               AND AK.SKD_VOY_NO = T1.SKD_VOY_NO" ).append("\n"); 
		query.append("               AND AK.SKD_DIR_CD = T1.SKD_DIR_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("           	 OR" ).append("\n"); 
		query.append("           	 ( AK.VSL_CD          = T2.VSL_CD" ).append("\n"); 
		query.append("               AND  AK.SKD_VOY_NO = T2.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("               AND  AK.SKD_DIR_CD = T2.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("           	 )" ).append("\n"); 
		query.append("    	 ) ACT_SKD_KNT" ).append("\n"); 
		query.append("    FROM VSK_VSL_SKD T1, VSK_VSL_PORT_SKD T2, MDM_VSL_SVC_LANE_DIR T3" ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND T1.VSL_CD = T2.VSL_CD(+)" ).append("\n"); 
		query.append("    AND T1.SKD_VOY_NO = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("    AND T1.VSL_SLAN_CD = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("    AND T1.SKD_DIR_CD = T3.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("    AND T2.CLPT_SEQ(+) = 1" ).append("\n"); 
		query.append("	AND (T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("#foreach(${param} in ${tgtVvd})" ).append("\n"); 
		query.append("	#if($velocityCount < $tgtVvd.size())" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}')," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("    ORDER BY T1.VSL_CD, T1.SKD_VOY_NO, VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}