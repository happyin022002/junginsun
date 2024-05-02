/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementDBDAOCheckVslSkdCngNotificationTransmitByEstRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.20
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.20 
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

public class ScheduleNotificationManagementDBDAOCheckVslSkdCngNotificationTransmitByEstRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule ETA/ETB/ETD 변경에 따른 전송이력내역중 동일이력체크
	  * </pre>
	  */
	public ScheduleNotificationManagementDBDAOCheckVslSkdCngNotificationTransmitByEstRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleNotificationManagementDBDAOCheckVslSkdCngNotificationTransmitByEstRSQL").append("\n"); 
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
		query.append("SELECT    COUNT(1)                   EXIST_KNT" ).append("\n"); 
		query.append("FROM      VSK_VSL_SKD_NTFC_TRSM_LOG  X" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       X.NTFC_TRSM_TP_CD          = 'ET'" ).append("\n"); 
		query.append("AND       X.VSL_CD                   = @[vsl_cd]      " ).append("\n"); 
		query.append("AND       X.SKD_VOY_NO               = @[skd_voy_no]  " ).append("\n"); 
		query.append("AND       X.SKD_DIR_CD               = @[skd_dir_cd]  " ).append("\n"); 
		query.append("AND       X.VPS_PORT_CD              = @[vps_port_cd] " ).append("\n"); 
		query.append("AND       X.CLPT_IND_SEQ             = @[clpt_ind_seq]" ).append("\n"); 
		query.append("AND       X.USR_ID                   = @[usr_id]      " ).append("\n"); 
		query.append("AND       X.VPS_ETA_DT               = TO_DATE(@[vps_eta_dt], 'YYYY-MM-DD HH24:MI')  " ).append("\n"); 
		query.append("AND       X.VPS_ETB_DT               = TO_DATE(@[vps_etb_dt], 'YYYY-MM-DD HH24:MI')  " ).append("\n"); 
		query.append("AND       X.VPS_ETD_DT               = TO_DATE(@[vps_etd_dt], 'YYYY-MM-DD HH24:MI')  " ).append("\n"); 
		query.append("AND       X.NTFC_TRSM_HIS_SEQ        = (SELECT    MAX(XX.NTFC_TRSM_HIS_SEQ)" ).append("\n"); 
		query.append("                                        FROM      VSK_VSL_SKD_NTFC_TRSM_LOG XX" ).append("\n"); 
		query.append("                                        WHERE     1 = 1" ).append("\n"); 
		query.append("                                        AND       XX.VSL_CD                 = X.VSL_CD" ).append("\n"); 
		query.append("                                        AND       XX.SKD_VOY_NO             = X.SKD_VOY_NO" ).append("\n"); 
		query.append("                                        AND       XX.SKD_DIR_CD             = X.SKD_DIR_CD" ).append("\n"); 
		query.append("                                        AND       XX.VPS_PORT_CD            = X.VPS_PORT_CD" ).append("\n"); 
		query.append("                                        AND       XX.CLPT_IND_SEQ           = X.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                        AND       XX.USR_ID                 = X.USR_ID" ).append("\n"); 
		query.append("                                        AND       XX.NTFC_TRSM_TP_CD        = X.NTFC_TRSM_TP_CD" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 

	}
}