/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanRouteManageDBDAOSaveOceanRouteStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.09.18 김귀진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOSaveOceanRouteStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SaveOceanRouteStatus
	  * </pre>
	  */
	public OceanRouteManageDBDAOSaveOceanRouteStatusRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration ").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOSaveOceanRouteStatusRSQL").append("\n"); 
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
		query.append("'' s_lane_cd" ).append("\n"); 
		query.append(",'' s_lane_tp" ).append("\n"); 
		query.append(",'' s_leg" ).append("\n"); 
		query.append(",'' g_status" ).append("\n"); 
		query.append(",'' s_upd_ind_cd" ).append("\n"); 
		query.append(",'' cre_ofc_cd" ).append("\n"); 
		query.append(",'' cre_usr_id" ).append("\n"); 
		query.append(",'' upd_usr_id" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}