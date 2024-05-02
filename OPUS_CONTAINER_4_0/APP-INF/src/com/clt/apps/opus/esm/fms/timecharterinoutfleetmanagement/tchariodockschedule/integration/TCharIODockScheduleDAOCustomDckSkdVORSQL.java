/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODockScheduleDAOCustomDckSkdVORSQL.java
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

public class TCharIODockScheduleDAOCustomDckSkdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharIODockScheduleDAOCustomDckSkdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration").append("\n"); 
		query.append("FileName : TCharIODockScheduleDAOCustomDckSkdVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("vsl_cd," ).append("\n"); 
		query.append("dck_sel_cd," ).append("\n"); 
		query.append("dck_seq," ).append("\n"); 
		query.append("to_char(dck_fm_dt,'yyyymmdd') dck_fm_dt," ).append("\n"); 
		query.append("to_char(dck_fm_dt,'hh24mi') dck_fm_dt_time," ).append("\n"); 
		query.append("to_char(dck_to_dt,'yyyymmdd') dck_to_dt," ).append("\n"); 
		query.append("to_char(dck_to_dt,'hh24mi') dck_to_dt_time," ).append("\n"); 
		query.append("dck_dur_dys," ).append("\n"); 
		query.append("'Days' dck_dur_dys_days," ).append("\n"); 
		query.append("flet_dck_svey_tp_cd," ).append("\n"); 
		query.append("flet_dck_sts_cd," ).append("\n"); 
		query.append("phs_out_dt," ).append("\n"); 
		query.append("phs_out_port_cd," ).append("\n"); 
		query.append("phs_in_dt," ).append("\n"); 
		query.append("phs_in_port_cd," ).append("\n"); 
		query.append("dck_loc_cd," ).append("\n"); 
		query.append("cre_usr_id," ).append("\n"); 
		query.append("upd_usr_id," ).append("\n"); 
		query.append("yd_seq," ).append("\n"); 
		query.append("yd_seq," ).append("\n"); 
		query.append("(select fs.shp_yd_nm" ).append("\n"); 
		query.append("from fms_shp_yd fs" ).append("\n"); 
		query.append("where fs.yd_seq = fd.yd_seq" ).append("\n"); 
		query.append("and rownum = 1) shp_yd_nm" ).append("\n"); 
		query.append("from fms_dck_skd fd" ).append("\n"); 
		query.append("where	vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("and	dck_sel_cd = @[dck_sel_cd]" ).append("\n"); 

	}
}