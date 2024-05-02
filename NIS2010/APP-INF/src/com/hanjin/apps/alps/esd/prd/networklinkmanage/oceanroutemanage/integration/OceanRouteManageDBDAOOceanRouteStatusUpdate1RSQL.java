/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OceanRouteManageDBDAOOceanRouteStatusUpdate1RSQL.java
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

public class OceanRouteManageDBDAOOceanRouteStatusUpdate1RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OceanRouteStatusUpdate1
	  * </pre>
	  */
	public OceanRouteManageDBDAOOceanRouteStatusUpdate1RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lane_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration ").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOOceanRouteStatusUpdate1RSQL").append("\n"); 
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
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM prd_svc_lane" ).append("\n"); 
		query.append("WHERE vsl_slan_cd = @[s_lane_cd]" ).append("\n"); 
		query.append("AND pctl_svc_tp_cd = @[s_lane_tp]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}