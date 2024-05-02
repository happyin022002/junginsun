/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PreventionCondDAORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.12 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PreventionCondDAORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PreventionCond
	  * </pre>
	  */
	public PreventionCondDAORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.containercargoclaim.prevention.vo").append("\n"); 
		query.append("FileName : PreventionCondDAORSQL").append("\n"); 
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
		query.append("    '' COND_SEARCH_TEXT" ).append("\n"); 
		query.append("  , '' CLM_PRVE_DIV_CD" ).append("\n"); 
		query.append("  , '' CRE_DT_START" ).append("\n"); 
		query.append("  , '' CRE_DT_END" ).append("\n"); 
		query.append("  , '' CLM_AREA_CD" ).append("\n"); 
		query.append("  , '' CRE_OFC_CD" ).append("\n"); 
		query.append("  , '' CRE_USR_ID" ).append("\n"); 
		query.append("  , '' CUR_DT" ).append("\n"); 
		query.append("  , '' CLM_PRVE_NO" ).append("\n"); 
		query.append("  , '' USR_ROLES" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    DUAL" ).append("\n"); 

	}
}