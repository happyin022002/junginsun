/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VesselReportDBDAOSearchEdi324SendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.16
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.02.16 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chae Change Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselReportDBDAOSearchEdi324SendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 화면에서 받는 VO 생성
	  * </pre>
	  */
	public VesselReportDBDAOSearchEdi324SendRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.vesselreport.integration").append("\n"); 
		query.append("FileName : VesselReportDBDAOSearchEdi324SendRSQL").append("\n"); 
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
		query.append("select 'BKG_NO'" ).append("\n"); 
		query.append(",'VSL_CD'" ).append("\n"); 
		query.append(",'SKD_VOY_NO'" ).append("\n"); 
		query.append(",'SKD_DIR_CD'" ).append("\n"); 
		query.append(",'BL_NO'" ).append("\n"); 
		query.append(",'COP_NO'" ).append("\n"); 
		query.append(",'VNDR_SEQ'" ).append("\n"); 
		query.append(",'CNTR_NO'" ).append("\n"); 
		query.append(",'CRE_USR_ID'" ).append("\n"); 
		query.append(",'UPD_USR_ID'" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}