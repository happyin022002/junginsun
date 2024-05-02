/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CollectionSummaryDBDAOsearchOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CollectionSummaryDBDAOsearchOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Combo box Office List 조회
	  * </pre>
	  */
	public CollectionSummaryDBDAOsearchOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.integration").append("\n"); 
		query.append("FileName : CollectionSummaryDBDAOsearchOfcRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  DISTINCT OFC_CD " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("  MDM_ORGANIZATION" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("  NVL (DELT_FLG, ' ') <> 'Y'" ).append("\n"); 
		query.append("  ORDER BY OFC_CD " ).append("\n"); 

	}
}