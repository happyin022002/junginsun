/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationSetupListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.22 
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

public class ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationSetupListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 사용자별 Vessel Schedule Notification 대상기본 Setup 데이터 생성
	  * </pre>
	  */
	public ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationSetupListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dlay_to_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dlay_fm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dlay_fm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_dlay_to_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rvs_clpt_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dlay_fm_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dlay_to_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aply_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skp_clpt_tgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.schedulenotificationmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationSetupListCSQL").append("\n"); 
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
		query.append("MERGE INTO   VSK_VSL_SKD_NTFC_STUP   X                          " ).append("\n"); 
		query.append("USING        (SELECT    NVL(@[upd_usr_id],@[login_usr_id]) AS LOGIN_USR_ID            " ).append("\n"); 
		query.append("                     ,  @[vsl_slan_cd]          AS VSL_SLAN_CD             " ).append("\n"); 
		query.append("                     ,  @[vps_port_cd]          AS VPS_PORT_CD             " ).append("\n"); 
		query.append("                     ,  @[skd_dir_cd]           AS SKD_DIR_CD              " ).append("\n"); 
		query.append("              FROM       DUAL                                   " ).append("\n"); 
		query.append("             ) Y                                                " ).append("\n"); 
		query.append("ON           (                                                  " ).append("\n"); 
		query.append("             X.USR_ID                = Y.LOGIN_USR_ID           " ).append("\n"); 
		query.append("AND          X.VSL_SLAN_CD           = Y.VSL_SLAN_CD            " ).append("\n"); 
		query.append("AND          X.SKD_DIR_CD            = Y.SKD_DIR_CD             " ).append("\n"); 
		query.append("AND          X.VPS_PORT_CD           = Y.VPS_PORT_CD            " ).append("\n"); 
		query.append("             )                                                  " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN                                           " ).append("\n"); 
		query.append("             INSERT                                         " ).append("\n"); 
		query.append("                       (    USR_ID                                                 " ).append("\n"); 
		query.append("                        ,   VSL_SLAN_CD        " ).append("\n"); 
		query.append("                        ,   VPS_PORT_CD        " ).append("\n"); 
		query.append("                        ,   SKD_DIR_CD         " ).append("\n"); 
		query.append("                        ,   ETA_DLAY_FM_HRS    " ).append("\n"); 
		query.append("                        ,   ETA_DLAY_TO_HRS    " ).append("\n"); 
		query.append("                        ,   ETB_DLAY_FM_HRS    " ).append("\n"); 
		query.append("                        ,   ETB_DLAY_TO_HRS    " ).append("\n"); 
		query.append("                        ,   ETD_DLAY_FM_HRS    " ).append("\n"); 
		query.append("                        ,   ETD_DLAY_TO_HRS    " ).append("\n"); 
		query.append("                        ,   SKP_CLPT_TGT_FLG     " ).append("\n"); 
		query.append("                        ,   RVS_CLPT_TGT_FLG     " ).append("\n"); 
		query.append("                        ,   APLY_FLG                                                 " ).append("\n"); 
		query.append("                        ,   CRE_USR_ID                                             " ).append("\n"); 
		query.append("                        ,   CRE_DT             " ).append("\n"); 
		query.append("                        ,   UPD_USR_ID     " ).append("\n"); 
		query.append("                        ,   UPD_DT " ).append("\n"); 
		query.append("                        )        " ).append("\n"); 
		query.append("             VALUES    (    NVL(@[upd_usr_id],@[login_usr_id]) /* USR_ID            */                                       " ).append("\n"); 
		query.append("                        ,   @[vsl_slan_cd]       /* VSL_SLAN_CD      */  " ).append("\n"); 
		query.append("                        ,   @[vps_port_cd]       /* VPS_PORT_CD      */  " ).append("\n"); 
		query.append("                        ,   @[skd_dir_cd]        /* SKD_DIR_CD       */  " ).append("\n"); 
		query.append("                        ,   @[eta_dlay_fm_hrs]   /* ETA_DLAY_FM_HRS  */  " ).append("\n"); 
		query.append("                        ,   @[eta_dlay_to_hrs]   /* ETA_DLAY_TO_HRS  */  " ).append("\n"); 
		query.append("                        ,   @[etb_dlay_fm_hrs]   /* ETB_DLAY_FM_HRS  */  " ).append("\n"); 
		query.append("                        ,   @[etb_dlay_to_hrs]   /* ETB_DLAY_TO_HRS  */  " ).append("\n"); 
		query.append("                        ,   @[etd_dlay_fm_hrs]   /* ETD_DLAY_FM_HRS  */  " ).append("\n"); 
		query.append("                        ,   @[etd_dlay_to_hrs]   /* ETD_DLAY_TO_HRS  */  " ).append("\n"); 
		query.append("                        ,   DECODE(@[skp_clpt_tgt_flg],'1','Y','N')  /* SKP_CLPT_TGT_FLG */    " ).append("\n"); 
		query.append("                        ,   DECODE(@[rvs_clpt_tgt_flg],'1','Y','N')  /* RVS_CLPT_TGT_FLG */    " ).append("\n"); 
		query.append("                        ,   DECODE(@[aply_flg],'1','Y','N')          /* APLY_FLG         */                                        " ).append("\n"); 
		query.append("                        ,   @[login_usr_id]      /* CRE_USR_ID       */                                      " ).append("\n"); 
		query.append("                        ,   SYSDATE              /* CRE_DT           */  " ).append("\n"); 
		query.append("                        ,   @[login_usr_id]      /* UPD_USR_ID       */" ).append("\n"); 
		query.append("                        ,   SYSDATE              /* UPD_DT           */   " ).append("\n"); 
		query.append("                       )                                        " ).append("\n"); 
		query.append("WHEN MATCHED THEN                                               " ).append("\n"); 
		query.append("             UPDATE                                             " ).append("\n"); 
		query.append("             SET       X.ETA_DLAY_FM_HRS  = @[eta_dlay_fm_hrs]                    " ).append("\n"); 
		query.append("                   ,   X.ETA_DLAY_TO_HRS  = @[eta_dlay_to_hrs]                    " ).append("\n"); 
		query.append("                   ,   X.ETB_DLAY_FM_HRS  = @[etb_dlay_fm_hrs]                    " ).append("\n"); 
		query.append("                   ,   X.ETB_DLAY_TO_HRS  = @[etb_dlay_to_hrs]                    " ).append("\n"); 
		query.append("                   ,   X.ETD_DLAY_FM_HRS  = @[etd_dlay_fm_hrs]                    " ).append("\n"); 
		query.append("                   ,   X.ETD_DLAY_TO_HRS  = @[etd_dlay_to_hrs]                    " ).append("\n"); 
		query.append("                   ,   X.SKP_CLPT_TGT_FLG = DECODE(@[skp_clpt_tgt_flg],'1','Y','N')                    " ).append("\n"); 
		query.append("                   ,   X.RVS_CLPT_TGT_FLG = DECODE(@[rvs_clpt_tgt_flg],'1','Y','N')                    " ).append("\n"); 
		query.append("                   ,   X.APLY_FLG         = DECODE(@[aply_flg],'1','Y','N')                    " ).append("\n"); 
		query.append("                   ,   X.UPD_USR_ID       = NVL(@[upd_usr_id],@[login_usr_id])                    " ).append("\n"); 
		query.append("                   ,   X.UPD_DT           = SYSDATE" ).append("\n"); 

	}
}