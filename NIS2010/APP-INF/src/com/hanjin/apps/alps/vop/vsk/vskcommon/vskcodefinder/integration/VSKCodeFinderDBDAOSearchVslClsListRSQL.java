/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchVslClsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.12.22 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchVslClsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVslClsList
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchVslClsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration ").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchVslClsListRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("FROM	MDM_VSL_CNTR M" ).append("\n"); 
		query.append("WHERE	CNTR_VSL_CLSS_CAPA IS NOT NULL" ).append("\n"); 
		query.append("AND	CNTR_VSL_CLSS_CAPA > 0" ).append("\n"); 
		query.append("AND	DELT_FLG		= 'N'" ).append("\n"); 
		query.append("ORDER BY CNTR_VSL_CLSS_CAPA" ).append("\n"); 

	}
}