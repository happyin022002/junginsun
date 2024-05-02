/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementDBDAOSearchVslSkdCngNotificationSetupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.06 
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

public class ScheduleNotificationManagementDBDAOSearchVslSkdCngNotificationSetupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자별 Vessel Schedule Notification 수신을 위한 기본정보 세팅정보 조회
	  * </pre>
	  */
	public ScheduleNotificationManagementDBDAOSearchVslSkdCngNotificationSetupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleNotificationManagementDBDAOSearchVslSkdCngNotificationSetupListRSQL").append("\n"); 
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
		query.append("SELECT      X.USR_ID" ).append("\n"); 
		query.append("        ,   X.VSL_SLAN_CD" ).append("\n"); 
		query.append("        ,   X.SKD_DIR_CD||' - '||X.VPS_PORT_CD       AS DIR_PORT_DESC" ).append("\n"); 
		query.append("        ,   X.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,   X.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,   X.VSL_SLAN_CD							 AS ORG_VSL_SLAN_CD" ).append("\n"); 
		query.append("        ,   X.VPS_PORT_CD							 AS	ORG_VPS_PORT_CD" ).append("\n"); 
		query.append("        ,   X.SKD_DIR_CD							 AS ORG_SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,   X.ETA_DLAY_FM_HRS" ).append("\n"); 
		query.append("        ,   X.ETA_DLAY_TO_HRS" ).append("\n"); 
		query.append("		,	'<'										 AS ETA_DLAY_FM_MARK" ).append("\n"); 
		query.append("		,	'PFS'									 AS ETA_DLAY_FIXMARK" ).append("\n"); 
		query.append("		,	'<'										 AS ETA_DLAY_TO_MARK" ).append("\n"); 
		query.append("		        " ).append("\n"); 
		query.append("        ,   X.ETB_DLAY_FM_HRS" ).append("\n"); 
		query.append("        ,   X.ETB_DLAY_TO_HRS" ).append("\n"); 
		query.append("		,	'<'										 AS ETB_DLAY_FM_MARK" ).append("\n"); 
		query.append("		,	'PFS'									 AS ETB_DLAY_FIXMARK" ).append("\n"); 
		query.append("		,	'<'										 AS ETB_DLAY_TO_MARK" ).append("\n"); 
		query.append("		        " ).append("\n"); 
		query.append("        ,   X.ETD_DLAY_FM_HRS" ).append("\n"); 
		query.append("        ,   X.ETD_DLAY_TO_HRS" ).append("\n"); 
		query.append("		,	'<'										 AS ETD_DLAY_FM_MARK" ).append("\n"); 
		query.append("		,	'PFS'									 AS ETD_DLAY_FIXMARK" ).append("\n"); 
		query.append("		,	'<'										 AS ETD_DLAY_TO_MARK" ).append("\n"); 
		query.append("		        " ).append("\n"); 
		query.append("        ,   DECODE(X.SKP_CLPT_TGT_FLG,'Y','1','0')   AS SKP_CLPT_TGT_FLG " ).append("\n"); 
		query.append("        ,   DECODE(X.RVS_CLPT_TGT_FLG,'Y','1','0')   AS RVS_CLPT_TGT_FLG" ).append("\n"); 
		query.append("        ,   DECODE(X.APLY_FLG,'Y','1','0')           AS APLY_FLG" ).append("\n"); 
		query.append("        ,   X.CRE_USR_ID" ).append("\n"); 
		query.append("        ,   X.CRE_DT" ).append("\n"); 
		query.append("        ,   X.UPD_USR_ID" ).append("\n"); 
		query.append("        ,   TO_CHAR(X.UPD_DT,'YYYY-MM-DD HH24:MI')	 AS UPD_DT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,   ''                                       AS LOGIN_USR_ID" ).append("\n"); 
		query.append("		,	''									     AS LANE_CD" ).append("\n"); 
		query.append("		,	''									     AS SLAN_CD" ).append("\n"); 
		query.append("		,	''										 AS PORT_CD" ).append("\n"); 
		query.append("		,	'N'										 AS PK_MODI_FLG" ).append("\n"); 
		query.append("FROM        VSK_VSL_SKD_NTFC_STUP   X" ).append("\n"); 
		query.append("WHERE       1 = 1" ).append("\n"); 
		query.append("AND         X.USR_ID                = @[login_usr_id]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${lane_cd} != '') " ).append("\n"); 
		query.append("AND			X.VSL_SLAN_CD			= @[lane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${port_cd} != '') " ).append("\n"); 
		query.append("AND			X.VPS_PORT_CD			= @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY	X.SKD_DIR_CD	ASC" ).append("\n"); 
		query.append("		,	X.VPS_PORT_CD	ASC" ).append("\n"); 

	}
}