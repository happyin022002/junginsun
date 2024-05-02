/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationTransmitLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.19 
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

public class ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationTransmitLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule Change Notification 개인별설정에 따른 전송대상데이터 VSK_VSL_SKD_NTFC_TRSM_LOG 파일에 저장
	  * </pre>
	  */
	public ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationTransmitLogCSQL(){
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
		params.put("vps_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcvr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_skp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_rvs_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_etb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfc_trsm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pair_rvs_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ScheduleNotificationManagementDBDAOCreateVslSkdCngNotificationTransmitLogCSQL").append("\n"); 
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
		query.append("INSERT   INTO VSK_VSL_SKD_NTFC_TRSM_LOG" ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("                 VSL_CD" ).append("\n"); 
		query.append("              ,  SKD_VOY_NO" ).append("\n"); 
		query.append("              ,  SKD_DIR_CD" ).append("\n"); 
		query.append("              ,  VPS_PORT_CD" ).append("\n"); 
		query.append("              ,  CLPT_IND_SEQ" ).append("\n"); 
		query.append("              ,  USR_ID" ).append("\n"); 
		query.append("              ,  NTFC_TRSM_HIS_SEQ" ).append("\n"); 
		query.append("              --------------------------------------------" ).append("\n"); 
		query.append("              ,  VVD_HIS_SEQ" ).append("\n"); 
		query.append("              ,  HIS_DTL_SEQ" ).append("\n"); 
		query.append("              ,  VSL_SLAN_CD" ).append("\n"); 
		query.append("              ,  TRSM_MZD_CD" ).append("\n"); 
		query.append("              ,  NTFC_TRSM_TP_CD" ).append("\n"); 
		query.append("              ,  PF_ETA_DT" ).append("\n"); 
		query.append("              ,  PF_ETB_DT" ).append("\n"); 
		query.append("              ,  PF_ETD_DT" ).append("\n"); 
		query.append("              ,  VPS_ETA_DT" ).append("\n"); 
		query.append("              ,  VPS_ETB_DT" ).append("\n"); 
		query.append("              ,  VPS_ETD_DT" ).append("\n"); 
		query.append("              ,  PORT_SKP_TP_CD" ).append("\n"); 
		query.append("              ,  BFR_YD_CD" ).append("\n"); 
		query.append("              ,  CRNT_YD_CD" ).append("\n"); 
		query.append("              ,  PAIR_RVS_PORT_CD" ).append("\n"); 
		query.append("              ,  PAIR_RVS_CLPT_IND_SEQ" ).append("\n"); 
		query.append("              --------------------------------------------" ).append("\n"); 
		query.append("			  ,  RCVR_EML" ).append("\n"); 
		query.append("			  ,  SNDR_EML" ).append("\n"); 
		query.append("			  ,  EML_SND_NO" ).append("\n"); 
		query.append("			  ,  TRSM_DT" ).append("\n"); 
		query.append("              -------------------------------------------- " ).append("\n"); 
		query.append("              ,	 CRE_USR_ID" ).append("\n"); 
		query.append("              ,	 CRE_DT" ).append("\n"); 
		query.append("              ,	 UPD_USR_ID" ).append("\n"); 
		query.append("              ,	 UPD_DT" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("VALUES       (" ).append("\n"); 
		query.append("			     @[vsl_cd] 							/* PK.VSL_CD				*/           " ).append("\n"); 
		query.append("              ,  @[skd_voy_no]                      /* PK.SKD_VOY_NO            */" ).append("\n"); 
		query.append("              ,  @[skd_dir_cd]                      /* PK.SKD_DIR_CD            */" ).append("\n"); 
		query.append("              ,  @[vps_port_cd]                     /* PK.VPS_PORT_CD           */" ).append("\n"); 
		query.append("              ,  @[clpt_ind_seq]                    /* PK.CLPT_IND_SEQ          */" ).append("\n"); 
		query.append("              ,  @[usr_id]                          /* PK.USR_ID                */" ).append("\n"); 
		query.append("              ,  VSK_NTFC_TRSM_HIS_SEQ.NEXTVAL      /* PK.NTFC_TRSM_HIS_SEQ     */" ).append("\n"); 
		query.append("              --------------------------------------------------------------------" ).append("\n"); 
		query.append("              ,  @[vvd_his_seq]						/* VVD_HIS_SEQ				*/" ).append("\n"); 
		query.append("              ,  @[his_dtl_seq]                     /* HIS_DTL_SEQ              */" ).append("\n"); 
		query.append("              ,  @[vsl_slan_cd]                     /* VSL_SLAN_CD              */" ).append("\n"); 
		query.append("              ,  'EML'                              /* TRSM_MZD_CD              */" ).append("\n"); 
		query.append("              ,  @[ntfc_trsm_tp_cd]" ).append("\n"); 
		query.append("              ,  TO_DATE(@[pf_eta_dt]	,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              ,  TO_DATE(@[pf_etb_dt]	,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              ,  TO_DATE(@[pf_etd_dt]	,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              ,  TO_DATE(@[vps_eta_dt]	,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              ,  TO_DATE(@[vps_etb_dt]	,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              ,  TO_DATE(@[vps_etd_dt]	,'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("              ,  @[port_skp_tp_cd]" ).append("\n"); 
		query.append("              ,  @[bfr_yd_cd]" ).append("\n"); 
		query.append("              ,  @[crnt_yd_cd]" ).append("\n"); 
		query.append("              ,  @[pair_rvs_port_cd]" ).append("\n"); 
		query.append("              ,  @[pair_rvs_clpt_ind_seq]" ).append("\n"); 
		query.append("              --------------------------------------------" ).append("\n"); 
		query.append("			  ,  @[rcvr_eml]" ).append("\n"); 
		query.append("			  ,  @[sndr_eml]" ).append("\n"); 
		query.append("			  ,  @[eml_snd_no]" ).append("\n"); 
		query.append("			  ,  SYSDATE							/* TRSM_DT  				*/" ).append("\n"); 
		query.append("              -------------------------------------------- " ).append("\n"); 
		query.append("              ,  SUBSTR(NVL(@[his_cre_usr_id],'NO_ACCOUNT_USER_ID'),1,20)	/* CRE_USR_ID */" ).append("\n"); 
		query.append("              ,  SYSDATE                            /* CRE_DT                   */" ).append("\n"); 
		query.append("              ,  SUBSTR(NVL(@[his_cre_usr_id],'NO_ACCOUNT_USER_ID'),1,20)	/* UPD_USR_ID */" ).append("\n"); 
		query.append("              ,  SYSDATE                            /* UPD_DT                   */" ).append("\n"); 
		query.append("                  " ).append("\n"); 
		query.append("              )" ).append("\n"); 

	}
}