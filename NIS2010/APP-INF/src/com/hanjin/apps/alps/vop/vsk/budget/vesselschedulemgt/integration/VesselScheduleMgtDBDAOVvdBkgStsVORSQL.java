/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOVvdBkgStsVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

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
	  * 신규로 생성한 VVD에 대해서 이미 등록되여 사용 중인지 확인한다.
	  * 
	  * * History
	  * * 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOVvdBkgStsVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.integration").append("\n"); 
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
		query.append("SELECT      XX.LRS_KIND_CD" ).append("\n"); 
		query.append("        ,   XX.VSL_SLAN_CD" ).append("\n"); 
		query.append("        ,   XX.VSL_CD" ).append("\n"); 
		query.append("        ,   XX.SKD_VOY_NO" ).append("\n"); 
		query.append("        ,   XX.SKD_DIR_CD" ).append("\n"); 
		query.append("        ,   CASE WHEN XX.LRS_KIND_CD = 'BUD' THEN XX.BKG_STATUS" ).append("\n"); 
		query.append("                 ELSE 'Exist in LIVE'" ).append("\n"); 
		query.append("            END  AS BKG_STATUS" ).append("\n"); 
		query.append("        ,   XX.VIR_BKG_STATUS" ).append("\n"); 
		query.append("        ,   TO_CHAR(XX.VPS_ETA_DT, 'YYYYMMDD') START_ETA" ).append("\n"); 
		query.append("        ,   CASE WHEN XX.LRS_KIND_CD = 'LIVE' THEN  'YES'" ).append("\n"); 
		query.append("                 ELSE 'YES'" ).append("\n"); 
		query.append("            END  AS UPDATE_FLAG" ).append("\n"); 
		query.append("        ,   XX.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("        ,   XX.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("        ,   XX.RUSE_PROHI_FLG" ).append("\n"); 
		query.append("FROM        (" ).append("\n"); 
		query.append("            SELECT    X.LRS_KIND_CD" ).append("\n"); 
		query.append("                  ,   X.VSL_SLAN_CD" ).append("\n"); 
		query.append("                  ,   X.VSL_CD" ).append("\n"); 
		query.append("                  ,   X.SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,   X.SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,   X.BKG_STATUS" ).append("\n"); 
		query.append("                  ,   X.VIR_BKG_STATUS" ).append("\n"); 
		query.append("                  ,   X.VPS_ETA_DT" ).append("\n"); 
		query.append("                  ----,   ROUND(VPS_ETA_DT - SYSDATE)" ).append("\n"); 
		query.append("                  ,   X.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                  ,   X.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                  ,   X.RUSE_PROHI_FLG" ).append("\n"); 
		query.append("                  ,   X.VSL_SLAN_DIR_SEQ " ).append("\n"); 
		query.append("                  ,   RANK() OVER (PARTITION BY X.VSL_CD, X.SKD_VOY_NO, X.SKD_DIR_CD ORDER BY X.LRS_SEQ DESC) AS VVD_DUP_KNT" ).append("\n"); 
		query.append("            FROM      (" ).append("\n"); 
		query.append("                      --====================================================================" ).append("\n"); 
		query.append("                      SELECT    'BUD'           AS LRS_KIND_CD" ).append("\n"); 
		query.append("                            ,   '1'             AS LRS_SEQ" ).append("\n"); 
		query.append("                            ,   T1.VSL_SLAN_CD" ).append("\n"); 
		query.append("                            ,   T1.VSL_CD" ).append("\n"); 
		query.append("                            ,   T1.SKD_VOY_NO" ).append("\n"); 
		query.append("                            ,   T1.SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,   'X' BKG_STATUS" ).append("\n"); 
		query.append("                            ,   T1.SKD_STS_CD VIR_BKG_STATUS" ).append("\n"); 
		query.append("                            ,   VPS_ETA_DT" ).append("\n"); 
		query.append("                            ----,   ROUND(VPS_ETA_DT - SYSDATE)" ).append("\n"); 
		query.append("                            ,   T2.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                            ,   T2.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,   T1.RUSE_PROHI_FLG" ).append("\n"); 
		query.append("                            ,   T3.VSL_SLAN_DIR_SEQ                  " ).append("\n"); 
		query.append("                        FROM    VSK_BUD_VSL_SKD       T1" ).append("\n"); 
		query.append("                             ,  VSK_BUD_VSL_PORT_SKD  T2" ).append("\n"); 
		query.append("                             ,  MDM_VSL_SVC_LANE_DIR  T3" ).append("\n"); 
		query.append("                        WHERE   1 = 1" ).append("\n"); 
		query.append("                        AND     T1.VSL_CD             = T2.VSL_CD(+)" ).append("\n"); 
		query.append("                        AND     T1.SKD_VOY_NO         = T2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                        AND     T1.SKD_DIR_CD         = T2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                        AND     T1.VSL_SLAN_CD        = T3.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        AND     T1.SKD_DIR_CD         = T3.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                        AND     T2.CLPT_SEQ(+)        = 1" ).append("\n"); 
		query.append("                        AND     (T1.VSL_CD, T1.SKD_VOY_NO, T1.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("#foreach(${param} in ${tgtVvd})" ).append("\n"); 
		query.append("	#if($velocityCount < $tgtVvd.size())" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}')," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                      -------------------------------------------------------------  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                      UNION ALL" ).append("\n"); 
		query.append("                      " ).append("\n"); 
		query.append("                      -------------------------------------------------------------              " ).append("\n"); 
		query.append("                      SELECT    'LIVE'           AS LRS_KIND_CD" ).append("\n"); 
		query.append("                            ,   '2'             AS LRS_SEQ                      " ).append("\n"); 
		query.append("                            ,   VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                            ,   VS.VSL_CD" ).append("\n"); 
		query.append("                            ,   VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                            ,   VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,   'X' BKG_STATUS" ).append("\n"); 
		query.append("                            ,   VS.SKD_STS_CD VIR_BKG_STATUS" ).append("\n"); 
		query.append("                            ,   VPS_ETA_DT" ).append("\n"); 
		query.append("                            ----,   ROUND(VPS_ETA_DT - SYSDATE)" ).append("\n"); 
		query.append("                            ,   PS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                            ,   PS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                            ,   VS.RUSE_PROHI_FLG" ).append("\n"); 
		query.append("                            ,   SL.VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("                        FROM    VSK_VSL_SKD       VS" ).append("\n"); 
		query.append("                             ,  VSK_VSL_PORT_SKD  PS" ).append("\n"); 
		query.append("                             ,  MDM_VSL_SVC_LANE_DIR  SL" ).append("\n"); 
		query.append("                        WHERE   1 = 1" ).append("\n"); 
		query.append("                        AND     VS.VSL_CD             = PS.VSL_CD(+)" ).append("\n"); 
		query.append("                        AND     VS.SKD_VOY_NO         = PS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                        AND     VS.SKD_DIR_CD         = PS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                        AND     VS.VSL_SLAN_CD        = SL.VSL_SLAN_CD" ).append("\n"); 
		query.append("                        AND     VS.SKD_DIR_CD         = SL.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                        AND     PS.CLPT_SEQ(+)        = 1" ).append("\n"); 
		query.append("                        AND     (VS.VSL_CD, VS.SKD_VOY_NO, VS.SKD_DIR_CD) IN (" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("#foreach(${param} in ${tgtVvd})" ).append("\n"); 
		query.append("	#if($velocityCount < $tgtVvd.size())" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}')," ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		('${param.vslCd}', '${param.skdVoyNo}', '${param.skdDirCd}')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("                      --====================================================================" ).append("\n"); 
		query.append("                      ) X     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            ) XX" ).append("\n"); 
		query.append("WHERE       XX.VVD_DUP_KNT = 1            " ).append("\n"); 
		query.append("ORDER BY    XX.VSL_CD" ).append("\n"); 
		query.append("      ,     XX.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,     XX.VSL_SLAN_DIR_SEQ" ).append("\n"); 

	}
}