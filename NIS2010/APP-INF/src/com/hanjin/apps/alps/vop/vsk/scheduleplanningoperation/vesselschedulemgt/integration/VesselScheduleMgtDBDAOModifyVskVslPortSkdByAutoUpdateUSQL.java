/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOModifyVskVslPortSkdByAutoUpdateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.06.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOModifyVskVslPortSkdByAutoUpdateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOModifyVskVslPortSkdByAutoUpdateUSQL(){
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
		params.put("org_upd_tgt_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_upd_tgt_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sea_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_upd_tgt_vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_buf_hrs",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOModifyVskVslPortSkdByAutoUpdateUSQL").append("\n"); 
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
		query.append("UPDATE 		VSK_VSL_PORT_SKD	PS" ).append("\n"); 
		query.append("SET			PS.VPS_ETA_DT 		= TO_DATE(@[vps_eta_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	PS.VPS_ETB_DT 		= TO_DATE(@[vps_etb_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	PS.VPS_ETD_DT 		= TO_DATE(@[vps_etd_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("		,	PS.SEA_BUF_HRS 		= @[sea_buf_hrs]" ).append("\n"); 
		query.append("		,	PS.PORT_BUF_HRS 	= @[port_buf_hrs]" ).append("\n"); 
		query.append("		,	PS.UPD_USR_ID 		= @[upd_usr_id]" ).append("\n"); 
		query.append("		,	PS.UPD_DT			= CASE 	WHEN PS.AUTO_SKD_CNG_FLG	= 'Y' THEN PS.UPD_DT" ).append("\n"); 
		query.append("										WHEN PS.VSL_CD||PS.SKD_VOY_NO||PS.SKD_DIR_CD = @[org_upd_tgt_vvd] AND PS.VPS_PORT_CD = @[org_upd_tgt_vps_port_cd] AND PS.CLPT_IND_SEQ = @[org_upd_tgt_clpt_ind_seq] THEN SYSDATE" ).append("\n"); 
		query.append("										ELSE PS.UPD_DT" ).append("\n"); 
		query.append("								  END" ).append("\n"); 
		query.append("		----,	UPD_DT 			= SYSDATE" ).append("\n"); 
		query.append("WHERE		PS.VSL_CD 			= @[vsl_cd]" ).append("\n"); 
		query.append("AND			PS.SKD_VOY_NO 		= @[skd_voy_no]" ).append("\n"); 
		query.append("AND			PS.SKD_DIR_CD 		= @[skd_dir_cd]" ).append("\n"); 
		query.append("AND			PS.VPS_PORT_CD 		= @[vps_port_cd]" ).append("\n"); 
		query.append("AND			PS.CLPT_IND_SEQ 	= @[clpt_ind_seq]" ).append("\n"); 

	}
}