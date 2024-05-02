/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VSKCodeFinderDBDAOSearchVslDznCapaListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2010.01.11 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOSearchVslDznCapaListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVslDznCapaList
	  * </pre>
	  */
	public VSKCodeFinderDBDAOSearchVslDznCapaListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.integration ").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOSearchVslDznCapaListRSQL").append("\n"); 
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
		query.append("SELECT	DISTINCT VSL_DZND_CAPA AS CNTR_DZN_CAPA" ).append("\n"); 
		query.append("FROM	FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE	VSL_DZND_CAPA IS NOT NULL" ).append("\n"); 
		query.append("AND		VSL_DZND_CAPA	> 0" ).append("\n"); 
		query.append("ORDER BY VSL_DZND_CAPA" ).append("\n"); 

	}
}