/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementDBDAOSelectPositionPollingDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselPositionPollingManagementDBDAOSelectPositionPollingDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectPositionPollingDetail
	  * </pre>
	  */
	public VesselPositionPollingManagementDBDAOSelectPositionPollingDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.integration").append("\n"); 
		query.append("FileName : VesselPositionPollingManagementDBDAOSelectPositionPollingDetailRSQL").append("\n"); 
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
		query.append("SELECT    '' AS RCV_DT" ).append("\n"); 
		query.append("        ,'' AS DLY_RCV_SEQ" ).append("\n"); 
		query.append("        ,'' AS IF_RCV_SEQ" ).append("\n"); 
		query.append("        ,'' AS PLNG_GEN_GDT" ).append("\n"); 
		query.append("        ,'' AS PLNG_GEN_LOCL_DT" ).append("\n"); 
		query.append("        ,'' AS VSL_CD" ).append("\n"); 
		query.append("        ,'' AS VSL_ENG_NM" ).append("\n"); 
		query.append("        ,'' AS CALL_SGN_NO" ).append("\n"); 
		query.append("        ,'' AS LLOYD_NO" ).append("\n"); 
		query.append("        ,'' AS SKD_VOY_NO" ).append("\n"); 
		query.append("        ,'' AS SKD_DIR_CD" ).append("\n"); 
		query.append("        ,'' AS VSL_LAT" ).append("\n"); 
		query.append("        ,'' AS VSL_LON" ).append("\n"); 
		query.append("        ,'' AS VSL_SPD" ).append("\n"); 
		query.append("        ,'' AS VSL_PROG_DIR_CTNT" ).append("\n"); 
		query.append("        ,'' AS PLNG_GEN_DIFF_HRS" ).append("\n"); 
		query.append("        ,'' AS VSL_PRE_LAT" ).append("\n"); 
		query.append("        ,'' AS VSL_PRE_LON " ).append("\n"); 
		query.append("        ,'' AS VSL_PLNG_DIST" ).append("\n"); 
		query.append("        ,'' AS VSL_PRE_SPD" ).append("\n"); 
		query.append("        ,'' AS VSL_PRE_PROG_DIR_CTNT" ).append("\n"); 
		query.append("        ,'' AS CRE_USR_ID" ).append("\n"); 
		query.append("        ,'' AS CRE_DT" ).append("\n"); 
		query.append("        ,'' AS UPD_USR_ID" ).append("\n"); 
		query.append("        ,'' AS UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}