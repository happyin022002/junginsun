/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOZoneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOZoneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public LocationDBDAOZoneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOZoneVORSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("'ZN_CD' ZN_CD," ).append("\n"); 
		query.append("'ZN_NM' ZN_NM," ).append("\n"); 
		query.append("'CGO_HNDL_TM_HRS' CGO_HNDL_TM_HRS," ).append("\n"); 
		query.append("'TZTM_HRS' TZTM_HRS," ).append("\n"); 
		query.append("'REP_YD_CD' REP_YD_CD," ).append("\n"); 
		query.append("'LNK_DIST' LNK_DIST," ).append("\n"); 
		query.append("'DIST_UT_CD' DIST_UT_CD," ).append("\n"); 
		query.append("'DELT_FLG' DELT_FLG," ).append("\n"); 
		query.append("'USR_ID' USR_ID," ).append("\n"); 
		query.append("'LOC_CD' LOC_CD" ).append("\n"); 
		query.append("FROM DUAL  " ).append("\n"); 

	}
}