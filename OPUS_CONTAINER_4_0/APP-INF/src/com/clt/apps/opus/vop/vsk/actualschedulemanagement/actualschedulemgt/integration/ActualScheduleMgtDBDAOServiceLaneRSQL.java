/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOServiceLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.07.21 정진우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Jinwoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOServiceLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOServiceLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOServiceLaneRSQL").append("\n"); 
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
		query.append("SELECT '' AS VSL_SVC_TP_CD" ).append("\n"); 
		query.append(",	'' AS SEQ1" ).append("\n"); 
		query.append(",	'' AS VSL_SLAN_CD1" ).append("\n"); 
		query.append(",	'' AS VSL_SLAN_NM1" ).append("\n"); 
		query.append(",	'' AS SEQ2" ).append("\n"); 
		query.append(",	'' AS VSL_SLAN_CD2" ).append("\n"); 
		query.append(",	'' AS VSL_SLAN_NM2" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}