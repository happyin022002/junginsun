/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvApptRSQL.java
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

public class WorkOrderPreviewEdiDBDAOsearchFlatFileUsvApptRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * APPT
	  * </pre>
	  */
	public WorkOrderPreviewEdiDBDAOsearchFlatFileUsvApptRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewEdiDBDAOsearchFlatFileUsvApptRSQL").append("\n"); 
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
		query.append("'' AS GATE_IN_START" ).append("\n"); 
		query.append(",'' AS GATE_IN_END" ).append("\n"); 
		query.append(",'' AS GATE_IN_FORM" ).append("\n"); 
		query.append(",'' AS GATE_OUT_START" ).append("\n"); 
		query.append(",'' AS GATE_OUT_EDN" ).append("\n"); 
		query.append(",'' AS GATE_OUT_FORM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}