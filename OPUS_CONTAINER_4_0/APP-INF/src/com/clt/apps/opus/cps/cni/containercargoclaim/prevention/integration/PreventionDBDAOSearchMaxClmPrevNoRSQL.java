/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreventionDBDAOSearchMaxClmPrevNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.01.19 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.prevention.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreventionDBDAOSearchMaxClmPrevNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PRV NO 최대값 취득
	  * </pre>
	  */
	public PreventionDBDAOSearchMaxClmPrevNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.prevention.integration").append("\n"); 
		query.append("FileName : PreventionDBDAOSearchMaxClmPrevNoRSQL").append("\n"); 
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
		query.append("    MAX (CLM_PRVE_NO) CLM_PRVE_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    CNI_CLM_PRVE" ).append("\n"); 

	}
}