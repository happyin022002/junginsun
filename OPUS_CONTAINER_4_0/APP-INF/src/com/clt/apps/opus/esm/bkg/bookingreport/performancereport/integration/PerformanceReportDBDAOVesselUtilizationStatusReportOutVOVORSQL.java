/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOVesselUtilizationStatusReportOutVOVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.08.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOVesselUtilizationStatusReportOutVOVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FOR OUT VO
	  * </pre>
	  */
	public PerformanceReportDBDAOVesselUtilizationStatusReportOutVOVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOVesselUtilizationStatusReportOutVOVORSQL").append("\n"); 
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
		query.append("/* VesselUtilizationStatusReportOut VO*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("' ' AS BEF_TTL" ).append("\n"); 
		query.append(", ' ' AS BSA" ).append("\n"); 
		query.append(", ' ' AS DIS_EUR" ).append("\n"); 
		query.append(", ' ' AS DIS_IPC" ).append("\n"); 
		query.append(", ' ' AS DIS_LOCAL" ).append("\n"); 
		query.append(", ' ' AS DIS_MTY" ).append("\n"); 
		query.append(", ' ' AS DIS_OCN" ).append("\n"); 
		query.append(", ' ' AS DIS_TPS" ).append("\n"); 
		query.append(", ' ' AS DIS_TS" ).append("\n"); 
		query.append(", ' ' AS DIS_TTL" ).append("\n"); 
		query.append(", ' ' AS ETA_DT" ).append("\n"); 
		query.append(", ' ' AS ETD_DT" ).append("\n"); 
		query.append(", ' ' AS F_CMD" ).append("\n"); 
		query.append(", ' ' AS LOAD_IPC" ).append("\n"); 
		query.append(", ' ' AS LOAD_MTY" ).append("\n"); 
		query.append(", ' ' AS LOAD_OCN" ).append("\n"); 
		query.append(", ' ' AS LOD_EUR" ).append("\n"); 
		query.append(", ' ' AS LOD_IPC" ).append("\n"); 
		query.append(", ' ' AS LOD_LOCAL" ).append("\n"); 
		query.append(", ' ' AS LOD_MTY" ).append("\n"); 
		query.append(", ' ' AS LOD_OCN" ).append("\n"); 
		query.append(", ' ' AS LOD_TPS" ).append("\n"); 
		query.append(", ' ' AS LOD_TS" ).append("\n"); 
		query.append(", ' ' AS LOD_TTL" ).append("\n"); 
		query.append(", ' ' AS LAST_PORT_LOADING" ).append("\n"); 
		query.append(", ' ' AS MAX_PORT_SEQ" ).append("\n"); 
		query.append(", ' ' AS MAX_SZ" ).append("\n"); 
		query.append(", ' ' AS NOWBSA" ).append("\n"); 
		query.append(", ' ' AS POL_YD_CD" ).append("\n"); 
		query.append(", ' ' AS PORT_LOD_PCT" ).append("\n"); 
		query.append(", ' ' AS PORT_SEQ" ).append("\n"); 
		query.append(", ' ' AS ROB_EUR" ).append("\n"); 
		query.append(", ' ' AS ROB_IPC" ).append("\n"); 
		query.append(", ' ' AS ROB_LOCAL" ).append("\n"); 
		query.append(", ' ' AS ROB_MTY" ).append("\n"); 
		query.append(", ' ' AS ROB_TOT" ).append("\n"); 
		query.append(", ' ' AS ROB_TPS" ).append("\n"); 
		query.append(", ' ' AS ROB_TS" ).append("\n"); 
		query.append(", ' ' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", ' ' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", ' ' AS SLAN_CD" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_EUR_E" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_EUR_W" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_IPC_E" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_IPC_W" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_LOCAL_E" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_LOCAL_W" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_MTY_E" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_MTY_W" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_OCN_E" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_OCN_W" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_TPS_E" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_TPS_W" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_TS_E" ).append("\n"); 
		query.append(", ' ' AS SUB_TOT_LOD_TS_W" ).append("\n"); 
		query.append(", ' ' AS TOT_BSA_E" ).append("\n"); 
		query.append(", ' ' AS TOT_BSA_W" ).append("\n"); 
		query.append(", ' ' AS UTIL_INDI" ).append("\n"); 
		query.append(", ' ' AS TOT_LIFT_E_PCT" ).append("\n"); 
		query.append(", ' ' AS TOT_LIFT_W_PCT" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_E" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_EUR_E" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_EUR_W" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_IPC_E" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_IPC_W" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_LOCAL_E" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_LOCAL_W" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_MTY_E" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_MTY_W" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_OCN_E" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_OCN_W" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_TPS_E" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_TPS_W" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_TS_E" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_TS_W" ).append("\n"); 
		query.append(", ' ' AS TOT_LOD_W" ).append("\n"); 
		query.append(", ' ' AS TTL_E" ).append("\n"); 
		query.append(", ' ' AS TTL_W" ).append("\n"); 
		query.append(", ' ' AS UTIL_E" ).append("\n"); 
		query.append(", ' ' AS UTIL_E_COLOR" ).append("\n"); 
		query.append(", ' ' AS UTIL_E_PCT" ).append("\n"); 
		query.append(", ' ' AS UTIL_W" ).append("\n"); 
		query.append(", ' ' AS UTIL_W_COLOR" ).append("\n"); 
		query.append(", ' ' AS UTIL_W_PCT" ).append("\n"); 
		query.append(", ' ' AS VPS_ETA_DT" ).append("\n"); 
		query.append(", ' ' AS VPS_ETD_DT" ).append("\n"); 
		query.append(", ' ' AS VPS_PORT_CD" ).append("\n"); 
		query.append(", ' ' AS VSL_CD" ).append("\n"); 
		query.append(", ' ' AS VVD" ).append("\n"); 
		query.append(", ' ' AS VVD_DIS_TOT" ).append("\n"); 
		query.append(", ' ' AS VVD_LOD_TOT" ).append("\n"); 
		query.append(", ' ' AS VVD_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}