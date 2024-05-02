/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContinentDBDAOContinentVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.15
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.07.15 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.continent.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO MI JIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContinentDBDAOContinentVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContinentDBDAOContinentVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.primasterdata.continent.integration").append("\n"); 
		query.append("FileName : ContinentDBDAOContinentVORSQL").append("\n"); 
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
		query.append("SELECT '' AS CONTI_CD" ).append("\n"); 
		query.append("      ,'' AS SCONTI_CD " ).append("\n"); 
		query.append("	  ,'' AS SCONTI_NM " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}