/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationDBDAOFcmBnkCsmPfDtlSimVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.02
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.02 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SimulationDBDAOFcmBnkCsmPfDtlSimVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM_BNK_CSM_PF_DTL_SIM 테이블 조회
	  * </pre>
	  */
	public SimulationDBDAOFcmBnkCsmPfDtlSimVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnk_csm_sim_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOFcmBnkCsmPfDtlSimVORSQL").append("\n"); 
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
		query.append("/*" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' ROW_SEQ," ).append("\n"); 
		query.append("'' SIM_MNVR_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' SIM_BUF_SEA_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' CRE_DT," ).append("\n"); 
		query.append("'' BNK_CSM_SIM_NO," ).append("\n"); 
		query.append("'' VSL_SLAN_CD," ).append("\n"); 
		query.append("'' SIM_SEA_SPD," ).append("\n"); 
		query.append("'' VSL_CLSS_CD," ).append("\n"); 
		query.append("'' CLPT_SEQ," ).append("\n"); 
		query.append("'' SIM_PORT_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' SIM_GNR_SEA_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' PF_SVC_TP_CD," ).append("\n"); 
		query.append("'' PORT_CD," ).append("\n"); 
		query.append("'' UPD_USR_ID," ).append("\n"); 
		query.append("'' SIM_SEA_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' UPD_DT," ).append("\n"); 
		query.append("'' SIM_MAX_SPD," ).append("\n"); 
		query.append("'' SIM_BUF_TTL_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' SIM_BUF_GNR_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' SKD_DIR_CD," ).append("\n"); 
		query.append("'' SIM_GNR_PORT_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' CRE_USR_ID," ).append("\n"); 
		query.append("'' YD_CD," ).append("\n"); 
		query.append("'' SIM_RUN_AUX_SPD," ).append("\n"); 
		query.append("'' SIM_MIN_SPD," ).append("\n"); 
		query.append("'' SIM_TTL_FOIL_CSM_WGT," ).append("\n"); 
		query.append("'' SIM_BUF_SEA_SPD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROW_NUMBER() OVER (ORDER BY PORT_ROTN_SEQ ASC) AS ROW_SEQ" ).append("\n"); 
		query.append(",T1.vsl_slan_cd" ).append("\n"); 
		query.append(",T1.pf_svc_tp_cd" ).append("\n"); 
		query.append(",T1.BNK_CSM_SIM_NO" ).append("\n"); 
		query.append(",T1.port_cd" ).append("\n"); 
		query.append(",T1.skd_dir_cd" ).append("\n"); 
		query.append(",T1.clpt_seq" ).append("\n"); 
		query.append(",T1.yd_cd" ).append("\n"); 
		query.append(",T1.vsl_clss_cd" ).append("\n"); 
		query.append(",sim_max_spd" ).append("\n"); 
		query.append(",sim_min_spd" ).append("\n"); 
		query.append(",SIM_RUN_AUX_SPD" ).append("\n"); 
		query.append(",sim_sea_spd" ).append("\n"); 
		query.append(",sim_sea_foil_csm_wgt" ).append("\n"); 
		query.append(",sim_mnvr_foil_csm_wgt" ).append("\n"); 
		query.append(",sim_port_foil_csm_wgt" ).append("\n"); 
		query.append(",sim_gnr_port_foil_csm_wgt" ).append("\n"); 
		query.append(",sim_gnr_sea_foil_csm_wgt" ).append("\n"); 
		query.append(",sim_ttl_foil_csm_wgt" ).append("\n"); 
		query.append(",sim_buf_sea_spd" ).append("\n"); 
		query.append(",sim_buf_sea_foil_csm_wgt" ).append("\n"); 
		query.append(",sim_buf_gnr_foil_csm_wgt" ).append("\n"); 
		query.append(",sim_buf_ttl_foil_csm_wgt" ).append("\n"); 
		query.append("FROM FCM_BNK_CSM_PF_DTL_SIM T1,VSK_PF_SKD_DTL T2" ).append("\n"); 
		query.append("WHERE T1.vsl_slan_cd =@[vsl_slan_cd]" ).append("\n"); 
		query.append("AND T1.pf_svc_tp_cd =@[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND T1.BNK_CSM_SIM_NO =@[bnk_csm_sim_no]" ).append("\n"); 
		query.append("AND T1.vsl_clss_cd =@[vsl_clss_cd]" ).append("\n"); 
		query.append("AND T1.VSL_SLAN_CD=T2.VSL_SLAN_CD  " ).append("\n"); 
		query.append("AND T1.PF_SVC_TP_CD=T2.PF_SVC_TP_CD" ).append("\n"); 
		query.append("AND T1.PORT_CD =T2.PORT_CD" ).append("\n"); 
		query.append("AND T1.PORT_CD =T2.PORT_CD" ).append("\n"); 
		query.append("AND T1.skd_dir_cd=T2.skd_dir_cd" ).append("\n"); 
		query.append("ORDER BY T2.PORT_ROTN_SEQ" ).append("\n"); 

	}
}