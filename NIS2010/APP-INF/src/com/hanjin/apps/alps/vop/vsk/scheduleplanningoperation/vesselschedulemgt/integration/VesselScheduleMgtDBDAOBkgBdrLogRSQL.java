/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOBkgBdrLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.12.23 정진우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOBkgBdrLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOBkgBdrLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOBkgBdrLogRSQL").append("\n"); 
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
		query.append("SELECT	''			AS VSL_CD" ).append("\n"); 
		query.append(", ''		AS SKD_VOY_NO" ).append("\n"); 
		query.append(", ''		AS SKD_DIR_CD" ).append("\n"); 
		query.append(", ''		AS VPS_PORT_CD" ).append("\n"); 
		query.append(", ''		AS CLPT_IND_SEQ" ).append("\n"); 
		query.append(", ''		AS PORT_SKD_STS_CD" ).append("\n"); 
		query.append(", ''		AS DEL_FLAG" ).append("\n"); 
		query.append("FROM	VSK_VSL_PORT_SKD T1" ).append("\n"); 
		query.append("WHERE	ROWNUM = 1" ).append("\n"); 

	}
}