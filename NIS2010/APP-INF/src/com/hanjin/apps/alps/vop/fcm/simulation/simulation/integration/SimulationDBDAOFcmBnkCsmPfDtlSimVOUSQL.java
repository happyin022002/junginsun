/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SimulationDBDAOFcmBnkCsmPfDtlSimVOUSQL.java
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

public class SimulationDBDAOFcmBnkCsmPfDtlSimVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FCM_BNK_CSM_PF_DTL_SIM 테이블 수정
	  * </pre>
	  */
	public SimulationDBDAOFcmBnkCsmPfDtlSimVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_buf_ttl_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_sea_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_port_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_ttl_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_sea_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_mnvr_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_buf_sea_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_min_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_max_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_gnr_port_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sim_gnr_sea_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_run_aux_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_buf_sea_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sim_buf_gnr_foil_csm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.fcm.simulation.simulation.integration").append("\n"); 
		query.append("FileName : SimulationDBDAOFcmBnkCsmPfDtlSimVOUSQL").append("\n"); 
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
		query.append("UPDATE FCM_BNK_CSM_PF_DTL_SIM" ).append("\n"); 
		query.append("SET                   " ).append("\n"); 
		query.append("vsl_clss_cd               = @[vsl_clss_cd]              " ).append("\n"); 
		query.append(",sim_max_spd               = @[sim_max_spd]              " ).append("\n"); 
		query.append(",sim_min_spd               = @[sim_min_spd]              " ).append("\n"); 
		query.append(",sim_run_aux_spd           = @[sim_run_aux_spd]              " ).append("\n"); 
		query.append(",sim_sea_spd               = @[sim_sea_spd]              " ).append("\n"); 
		query.append(",sim_sea_foil_csm_wgt      = @[sim_sea_foil_csm_wgt]     " ).append("\n"); 
		query.append(",sim_mnvr_foil_csm_wgt     = @[sim_mnvr_foil_csm_wgt]    " ).append("\n"); 
		query.append(",sim_port_foil_csm_wgt     = @[sim_port_foil_csm_wgt]    " ).append("\n"); 
		query.append(",sim_gnr_port_foil_csm_wgt = @[sim_gnr_port_foil_csm_wgt]" ).append("\n"); 
		query.append(",sim_gnr_sea_foil_csm_wgt  = @[sim_gnr_sea_foil_csm_wgt] " ).append("\n"); 
		query.append(",sim_ttl_foil_csm_wgt      = @[sim_ttl_foil_csm_wgt]     " ).append("\n"); 
		query.append(",sim_buf_sea_spd           = @[sim_buf_sea_spd]          " ).append("\n"); 
		query.append(",sim_buf_sea_foil_csm_wgt  = @[sim_buf_sea_foil_csm_wgt] " ).append("\n"); 
		query.append(",sim_buf_gnr_foil_csm_wgt  = @[sim_buf_gnr_foil_csm_wgt] " ).append("\n"); 
		query.append(",sim_buf_ttl_foil_csm_wgt  = @[sim_buf_ttl_foil_csm_wgt]                   " ).append("\n"); 
		query.append(",upd_usr_id                = @[upd_usr_id]               " ).append("\n"); 
		query.append(",upd_dt                    = sysdate     " ).append("\n"); 
		query.append("WHERE vsl_slan_cd =@[vsl_slan_cd]" ).append("\n"); 
		query.append("AND pf_svc_tp_cd =@[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND bnk_csm_sim_no =@[bnk_csm_sim_no]" ).append("\n"); 
		query.append("AND vsl_clss_cd =@[vsl_clss_cd]    " ).append("\n"); 
		query.append("AND port_cd =@[port_cd]" ).append("\n"); 
		query.append("AND skd_dir_cd =@[skd_dir_cd]" ).append("\n"); 
		query.append("AND clpt_seq =@[clpt_seq]" ).append("\n"); 

	}
}