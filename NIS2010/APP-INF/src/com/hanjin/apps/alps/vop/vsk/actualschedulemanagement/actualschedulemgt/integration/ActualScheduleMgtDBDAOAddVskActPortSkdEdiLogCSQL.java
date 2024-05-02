/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOAddVskActPortSkdEdiLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.19 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOAddVskActPortSkdEdiLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Actual SKD EDI 내용을 저장한다.
	  * ---------------------------------------------------------------------
	  * 2011.10.17 진마리아 CHM-201113948 Vessel sked EDI의 VVD mapping을 위해 F/F 수정 (Segment추가) (UAX)
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOAddVskActPortSkdEdiLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_proc_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcvr_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_act_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mtch_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_skd_dir_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_msg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sndr_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOAddVskActPortSkdEdiLogCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_ACT_PORT_SKD_EDI_LOG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	RCV_DT" ).append("\n"); 
		query.append("	, RCV_SEQ" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, VPS_PORT_CD" ).append("\n"); 
		query.append("	, CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, YD_CD" ).append("\n"); 
		query.append("	, ACT_ARR_DT" ).append("\n"); 
		query.append("	, ACT_BRTH_DT" ).append("\n"); 
		query.append("	, ACT_DEP_DT" ).append("\n"); 
		query.append("	, SCS_FLG" ).append("\n"); 
		query.append("	, RSLT_MSG" ).append("\n"); 
		query.append("	, SNDR_TRD_PRNR_ID" ).append("\n"); 
		query.append("	, RCVR_TRD_PRNR_ID" ).append("\n"); 
		query.append("	, EDI_MSG_TP_ID" ).append("\n"); 
		query.append("	, EDI_MSG_PROC_ID" ).append("\n"); 
		query.append("	, EDI_VSL_NM" ).append("\n"); 
		query.append("	, EDI_SKD_VOY_NO" ).append("\n"); 
		query.append("	, EDI_SKD_DIR_NM" ).append("\n"); 
		query.append("	, EDI_ACT_ARR_DT" ).append("\n"); 
		query.append("	, EDI_ACT_BRTH_DT" ).append("\n"); 
		query.append("	, EDI_ACT_DEP_DT" ).append("\n"); 
		query.append("	, LLOYD_NO" ).append("\n"); 
		query.append("	, CALL_SGN_NO" ).append("\n"); 
		query.append("	, SHP_CALL_NO" ).append("\n"); 
		query.append("	, MTCH_MOD_CD" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	TO_DATE(@[rcv_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, @[rcv_seq]" ).append("\n"); 
		query.append("	, @[vsl_cd]" ).append("\n"); 
		query.append("	, @[skd_voy_no]" ).append("\n"); 
		query.append("	, @[skd_dir_cd]" ).append("\n"); 
		query.append("	, @[vps_port_cd]" ).append("\n"); 
		query.append("	, @[clpt_ind_seq]" ).append("\n"); 
		query.append("	, @[yd_cd]" ).append("\n"); 
		query.append("	, TO_DATE(@[act_arr_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, TO_DATE(@[act_brth_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, TO_DATE(@[act_dep_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, 'N'" ).append("\n"); 
		query.append("	, @[rslt_msg]" ).append("\n"); 
		query.append("	, @[sndr_trd_prnr_id]" ).append("\n"); 
		query.append("	, @[rcvr_trd_prnr_id]" ).append("\n"); 
		query.append("	, @[edi_msg_tp_id]" ).append("\n"); 
		query.append("	, @[edi_msg_proc_id]" ).append("\n"); 
		query.append("	, @[edi_vsl_nm]" ).append("\n"); 
		query.append("	, @[edi_skd_voy_no]" ).append("\n"); 
		query.append("	, @[edi_skd_dir_nm]" ).append("\n"); 
		query.append("	, TO_DATE(@[edi_act_arr_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, TO_DATE(@[edi_act_brth_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, TO_DATE(@[edi_act_dep_dt], 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, @[lloyd_no]" ).append("\n"); 
		query.append("	, @[call_sgn_no]" ).append("\n"); 
		query.append("	, @[shp_call_no]" ).append("\n"); 
		query.append("	, @[mtch_mod_cd]" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}