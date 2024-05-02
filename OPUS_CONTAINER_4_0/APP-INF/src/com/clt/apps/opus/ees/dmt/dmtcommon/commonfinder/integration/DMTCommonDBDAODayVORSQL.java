/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DMTCommonDBDAODayVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCommonDBDAODayVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 날짜 비교를 위해서 사용하는 VO 객체
	  * </pre>
	  */
	public DMTCommonDBDAODayVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration ").append("\n"); 
		query.append("FileName : DMTCommonDBDAODayVORSQL").append("\n"); 
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
		query.append("SELECT	'' FROM_DT" ).append("\n"); 
		query.append(",	'' TO_DT" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 

	}
}