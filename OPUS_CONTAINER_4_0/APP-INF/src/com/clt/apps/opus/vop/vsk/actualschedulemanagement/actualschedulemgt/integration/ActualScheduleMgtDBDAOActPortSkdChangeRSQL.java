/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOActPortSkdChangeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.12.03 정진우
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

public class ActualScheduleMgtDBDAOActPortSkdChangeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOActPortSkdChangeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOActPortSkdChangeRSQL").append("\n"); 
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
		query.append("SELECT	'' AS ATA_CHK" ).append("\n"); 
		query.append(", '' AS ATB_CHK" ).append("\n"); 
		query.append(", '' AS ATD_CHK" ).append("\n"); 
		query.append(", '' AS USR_CHK" ).append("\n"); 
		query.append(", '' AS ATA_LOC_TIME" ).append("\n"); 
		query.append(", '' AS ATB_LOC_TIME" ).append("\n"); 
		query.append(", '' AS ATD_LOC_TIME" ).append("\n"); 
		query.append(", '' AS ALL_CHK" ).append("\n"); 
		query.append(", '' AS BKG_CHK" ).append("\n"); 
		query.append(", '' AS BKG_VRT_CHK" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}