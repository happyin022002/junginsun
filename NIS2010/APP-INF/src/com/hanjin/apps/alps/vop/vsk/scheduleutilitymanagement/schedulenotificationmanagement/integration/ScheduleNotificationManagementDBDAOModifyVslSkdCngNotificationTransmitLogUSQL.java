/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementDBDAOModifyVslSkdCngNotificationTransmitLogUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleNotificationManagementDBDAOModifyVslSkdCngNotificationTransmitLogUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule Change Notification 개인별설정에 따른 전송대상데이터 VSK_VSL_SKD_NTFC_TRSM_LOG 에 저장하고
	  * e-Mail 발송이후 발송결과 Update
	  * </pre>
	  */
	public ScheduleNotificationManagementDBDAOModifyVslSkdCngNotificationTransmitLogUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration ").append("\n"); 
		query.append("FileName : ScheduleNotificationManagementDBDAOModifyVslSkdCngNotificationTransmitLogUSQL").append("\n"); 
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
		query.append("select * from dual" ).append("\n"); 

	}
}