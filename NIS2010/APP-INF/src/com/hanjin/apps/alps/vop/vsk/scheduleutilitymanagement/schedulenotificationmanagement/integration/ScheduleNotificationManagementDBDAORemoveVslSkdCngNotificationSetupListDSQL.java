/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementDBDAORemoveVslSkdCngNotificationSetupListDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleNotificationManagementDBDAORemoveVslSkdCngNotificationSetupListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule Delay Notice 기본정보 Setup 삭제처리
	  * </pre>
	  */
	public ScheduleNotificationManagementDBDAORemoveVslSkdCngNotificationSetupListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("login_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleNotificationManagementDBDAORemoveVslSkdCngNotificationSetupListDSQL").append("\n"); 
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
		query.append("DELETE  FROM   	VSK_VSL_SKD_NTFC_STUP   X" ).append("\n"); 
		query.append("WHERE			X.USR_ID				= NVL(@[upd_usr_id],@[login_usr_id])" ).append("\n"); 
		query.append("AND				X.VSL_SLAN_CD			= @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND				X.SKD_DIR_CD			= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND				X.VPS_PORT_CD			= @[vps_port_cd]" ).append("\n"); 

	}
}