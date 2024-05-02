/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOCanalAgencyLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.03.21 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAOCanalAgencyLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOCanalAgencyLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOCanalAgencyLaneRSQL").append("\n"); 
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
		query.append("SELECT	'' AS VSL_SLAN_CD" ).append("\n"); 
		query.append("		, '' AS VSL_SLAN_NM" ).append("\n"); 
		query.append("		, '' AS CNL_AGN_VNDR_SEQ" ).append("\n"); 
		query.append("		, '' AS NORTH_DIR" ).append("\n"); 
		query.append("		, '' AS SOUTH_DIR" ).append("\n"); 
		query.append("		, '' AS BOUND1" ).append("\n"); 
		query.append("		, '' AS BOUND2" ).append("\n"); 
		query.append("		, '' AS UPD_USR_ID" ).append("\n"); 
		query.append("		, '' AS UPD_DT" ).append("\n"); 
		query.append("		, '' AS VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("		, '' AS VSL_SLAN_DIR_SEQ" ).append("\n"); 
		query.append("		, '' AS SVC_SCP_BND_CD" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}