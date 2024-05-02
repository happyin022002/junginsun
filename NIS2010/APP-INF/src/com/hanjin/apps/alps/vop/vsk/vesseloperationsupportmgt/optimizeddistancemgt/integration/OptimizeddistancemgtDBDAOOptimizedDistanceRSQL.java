/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OptimizeddistancemgtDBDAOOptimizedDistanceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OptimizeddistancemgtDBDAOOptimizedDistanceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vo를 생성한다.
	  * </pre>
	  */
	public OptimizeddistancemgtDBDAOOptimizedDistanceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.optimizeddistancemgt.integration").append("\n"); 
		query.append("FileName : OptimizeddistancemgtDBDAOOptimizedDistanceRSQL").append("\n"); 
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
		query.append("SELECT   '' AS FM_YD_CD" ).append("\n"); 
		query.append("       , '' AS SHEET_TO_PORT_CD" ).append("\n"); 
		query.append("	   , '' AS SHEET_FM_PORT_CD" ).append("\n"); 
		query.append("       , '' AS FM_YD_GRP_CD" ).append("\n"); 
		query.append("       , '' AS SHEET_TO_YD_GRP_CD" ).append("\n"); 
		query.append("	   , '' AS SHEET_FM_YD_GRP_CD" ).append("\n"); 
		query.append("       , '' AS GMT_TD_HRS" ).append("\n"); 
		query.append("       , '' AS STND_DIST  " ).append("\n"); 
		query.append("       , '' AS OPMZ_DIST  " ).append("\n"); 
		query.append("       , '' AS VMS_AVG_DIST " ).append("\n"); 
		query.append("       , '' AS VMS_SHTG_DIST" ).append("\n"); 
		query.append("       , '' AS RNG_MAX_DIST" ).append("\n"); 
		query.append("       , '' AS RNG_MIN_DIST" ).append("\n"); 
		query.append("       , '' AS UPD_USR_ID" ).append("\n"); 
		query.append("       , '' AS UPD_DT" ).append("\n"); 
		query.append("       , '' AS FM_PORT_CD" ).append("\n"); 
		query.append("       , '' AS FM_YD_GRP_ID    " ).append("\n"); 
		query.append("       , '' AS TO_PORT_CD" ).append("\n"); 
		query.append("       , '' AS TO_YD_GRP_ID" ).append("\n"); 
		query.append("       , '' AS FM_DATE " ).append("\n"); 
		query.append("       , '' AS TO_DATE" ).append("\n"); 
		query.append("	   , '' AS USR_ID" ).append("\n"); 
		query.append("	   , '' AS PORT_CD" ).append("\n"); 
		query.append("	   , '' AS TO_YD_GRP_CD" ).append("\n"); 
		query.append("	   , '' AS AVG_SLP_RT" ).append("\n"); 
		query.append("	   , '' AS SLP_KNT" ).append("\n"); 
		query.append("	   , '' AS VAR_SLP_RT" ).append("\n"); 
		query.append("	   , '' AS PRE_SHEET_TO_YD_GRP_CD" ).append("\n"); 
		query.append("	   , '' AS PRE_SHEET_FM_YD_GRP_CD" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 

	}
}