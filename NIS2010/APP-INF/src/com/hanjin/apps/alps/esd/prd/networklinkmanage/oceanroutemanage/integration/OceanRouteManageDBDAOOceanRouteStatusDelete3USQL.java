/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OceanRouteManageDBDAOOceanRouteStatusDelete3USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OceanRouteManageDBDAOOceanRouteStatusDelete3USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OceanRouteStatusDelete3
	  * </pre>
	  */
	public OceanRouteManageDBDAOOceanRouteStatusDelete3USQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.integration").append("\n"); 
		query.append("FileName : OceanRouteManageDBDAOOceanRouteStatusDelete3USQL").append("\n"); 
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
		query.append("UPDATE PRD_OCN_ROUT " ).append("\n"); 
		query.append("SET upd_ind_cd = 'D', " ).append("\n"); 
		query.append("	upd_ofc_cd = @[cre_ofc_cd] ,  " ).append("\n"); 
		query.append("	upd_usr_id = @[upd_usr_id] ,  " ).append("\n"); 
		query.append("	ocn_rout_upd_dt = SYSDATE, " ).append("\n"); 
		query.append("	ocn_rout_rmk = 'Deleted By Lane Status.',  " ).append("\n"); 
		query.append("	ocn_rout_delt_rmk = sysdate||' '||@[upd_usr_id] ||' : Deleted By Lane Status.' " ).append("\n"); 
		query.append("WHERE (   n1st_lane_cd = @[s_lane_cd]  " ).append("\n"); 
		query.append("	 OR n2nd_lane_cd = @[s_lane_cd]  " ).append("\n"); 
		query.append("	 OR n3rd_lane_cd = @[s_lane_cd]  " ).append("\n"); 
		query.append("	 OR n4th_lane_cd = @[s_lane_cd]  " ).append("\n"); 
		query.append("	) " ).append("\n"); 
		query.append("AND upd_ind_cd <> 'D'" ).append("\n"); 

	}
}