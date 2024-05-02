/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODockScheduleDAOCustomDckSkdVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharIODockScheduleDAOCustomDckSkdVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharIODockScheduleDAOCustomDckSkdVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phs_in_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phs_in_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dck_sel_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_dck_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dck_fm_dt_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dck_to_dt_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_dck_svey_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dck_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phs_out_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dck_dur_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phs_out_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dck_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dck_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration").append("\n"); 
		query.append("FileName : TCharIODockScheduleDAOCustomDckSkdVOCSQL").append("\n"); 
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
		query.append("insert into fms_dck_skd (" ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("dck_sel_cd," ).append("\n"); 
		query.append("dck_seq," ).append("\n"); 
		query.append("dck_fm_dt," ).append("\n"); 
		query.append("dck_to_dt," ).append("\n"); 
		query.append("dck_dur_dys," ).append("\n"); 
		query.append("flet_dck_svey_tp_cd," ).append("\n"); 
		query.append("flet_dck_sts_cd," ).append("\n"); 
		query.append("phs_out_dt," ).append("\n"); 
		query.append("phs_out_port_cd," ).append("\n"); 
		query.append("phs_in_dt," ).append("\n"); 
		query.append("phs_in_port_cd," ).append("\n"); 
		query.append("dck_loc_cd," ).append("\n"); 
		query.append("yd_seq," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("cre_dt," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append(") values(" ).append("\n"); 
		query.append("@[vsl_cd]," ).append("\n"); 
		query.append("@[dck_sel_cd]," ).append("\n"); 
		query.append("FMS_DCK_SEQ.nextval," ).append("\n"); 
		query.append("to_date(@[dck_fm_dt]||@[dck_fm_dt_time],'yyyymmddhh24mi')," ).append("\n"); 
		query.append("to_date(@[dck_to_dt]||@[dck_to_dt_time],'yyyymmddhh24mi')," ).append("\n"); 
		query.append("@[dck_dur_dys]," ).append("\n"); 
		query.append("@[flet_dck_svey_tp_cd]," ).append("\n"); 
		query.append("@[flet_dck_sts_cd]," ).append("\n"); 
		query.append("@[phs_out_dt]," ).append("\n"); 
		query.append("@[phs_out_port_cd]," ).append("\n"); 
		query.append("@[phs_in_dt]," ).append("\n"); 
		query.append("@[phs_in_port_cd]," ).append("\n"); 
		query.append("@[dck_loc_cd]," ).append("\n"); 
		query.append("@[yd_seq]," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}