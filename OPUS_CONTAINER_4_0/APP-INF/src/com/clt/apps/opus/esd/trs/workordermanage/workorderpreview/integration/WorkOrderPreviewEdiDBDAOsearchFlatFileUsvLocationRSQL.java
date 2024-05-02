/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewEdiDBDAOsearchFlatFileUsvLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Location
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileUsvLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvLocationRSQL").append("\n"); 
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
		query.append("SELECT '' as STOP_LOC" ).append("\n"); 
		query.append("      ,'' as STOP_REF" ).append("\n"); 
		query.append("      ,'' as STOP_ADD1" ).append("\n"); 
		query.append("      ,'' as STOP_ADD2" ).append("\n"); 
		query.append("      ,'' as STOP_CITY" ).append("\n"); 
		query.append("      ,'' as STOP_STATE" ).append("\n"); 
		query.append("      ,'' as STOP_CNT" ).append("\n"); 
		query.append("      ,'' as STOP_POSTAL" ).append("\n"); 
		query.append("      ,'' as STOP_TZ" ).append("\n"); 
		query.append("      ,'' as STOP_CONTACT_NM" ).append("\n"); 
		query.append("      ,'' as STOP_CONTACT_TE" ).append("\n"); 
		query.append("      ,'' as \"COMMENT\"" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}