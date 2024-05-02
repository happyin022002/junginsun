/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOLoadWgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.04
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.11.04 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOLoadWgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOLoadWgtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOLoadWgtRSQL").append("\n"); 
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
		query.append("'' AS VSL_CD" ).append("\n"); 
		query.append(", '' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS VPS_ETA_DT" ).append("\n"); 
		query.append(", '' AS VPS_ETD_DT" ).append("\n"); 
		query.append(", '' AS CALL_IND_CD" ).append("\n"); 
		query.append(", '' AS POST_TYPE" ).append("\n"); 
		query.append(", '' AS VPS_PORT_CD" ).append("\n"); 
		query.append(", '' AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(", '' AS LOC_CD" ).append("\n"); 
		query.append(", '' AS CONSTANT" ).append("\n"); 
		query.append(", '' AS FUEL_OIL" ).append("\n"); 
		query.append(", '' AS DIESEL_OIL" ).append("\n"); 
		query.append(", '' AS FRESH_WATER" ).append("\n"); 
		query.append(", '' AS BALLAST" ).append("\n"); 
		query.append(", '' AS DISPLACEMENT" ).append("\n"); 
		query.append(", '' AS CARGO_WEIGHT" ).append("\n"); 
		query.append(", '' AS WGT_PORT_CD" ).append("\n"); 
		query.append(", '' AS WGT_VSL_CD" ).append("\n"); 
		query.append(", '' AS WGT_SKD_VOY_NO" ).append("\n"); 
		query.append(", '' AS WGT_SKD_DIR_CD" ).append("\n"); 
		query.append(", '' AS WGT_CLPT_IND_SEQ" ).append("\n"); 
		query.append(", '' AS LEFT_TITLE" ).append("\n"); 
		query.append(", '' AS COL01" ).append("\n"); 
		query.append(", '' AS COL02" ).append("\n"); 
		query.append(", '' AS COL03" ).append("\n"); 
		query.append(", '' AS COL04" ).append("\n"); 
		query.append(", '' AS COL05" ).append("\n"); 
		query.append(", '' AS COL06" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}