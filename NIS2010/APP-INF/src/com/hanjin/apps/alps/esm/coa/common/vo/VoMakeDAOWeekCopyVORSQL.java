/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VoMakeDAOWeekCopyVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.19
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2014.06.19 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.common.vo;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Duk Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VoMakeDAOWeekCopyVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public VoMakeDAOWeekCopyVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.common.vo").append("\n"); 
		query.append("FileName : VoMakeDAOWeekCopyVORSQL").append("\n"); 
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
		query.append("      	'' AS F_SRC_WEEK,                                   " ).append("\n"); 
		query.append("		'' AS F_TAR_WEEK,                               " ).append("\n"); 
		query.append("		'' AS USR_ID," ).append("\n"); 
		query.append("		'' AS RLANE_CD                     " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}