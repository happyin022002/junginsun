/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleReceiveManagementDBDAOCreateExchangeDetailListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleReceiveManagementDBDAOCreateExchangeDetailListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exchange Detail 데이터 생성
	  * </pre>
	  */
	public ScheduleReceiveManagementDBDAOCreateExchangeDetailListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_port_flg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_arr_dt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_brth_dt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_ind_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_yd_ind_seq_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_dep_dt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_skd_dir_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etb_dt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_clpt_ind_seq_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("turn_port_ind_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.integration").append("\n"); 
		query.append("FileName : ScheduleReceiveManagementDBDAOCreateExchangeDetailListCSQL").append("\n"); 
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
		query.append("INSERT   INTO  VSK_VSL_SKD_XCH_EDI_DTL D" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("                        D.SND_RCV_KND_CD" ).append("\n"); 
		query.append("					,	D.SKD_EDI_RCV_DT" ).append("\n"); 
		query.append("					,	D.SKD_EDI_RCV_SEQ" ).append("\n"); 
		query.append("					,	D.EDI_XCH_LOG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					,	D.VSL_CD_CTNT" ).append("\n"); 
		query.append("					,	D.SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("					,	D.SKD_DIR_CD_CTNT					" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					,	D.VPS_PORT_CD_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					--	::2014-04-20:: --" ).append("\n"); 
		query.append("					,	D.ALLN_PORT_CD_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					,	D.VPS_PORT_NM" ).append("\n"); 
		query.append("					,	D.YD_CD_CTNT" ).append("\n"); 
		query.append("					,	D.CLPT_IND_SEQ_CTNT" ).append("\n"); 
		query.append("					,	D.CLPT_SEQ_CTNT" ).append("\n"); 
		query.append("					,	D.LOC_IND_CD_CTNT" ).append("\n"); 
		query.append("					,	D.CALL_YD_IND_SEQ_CTNT" ).append("\n"); 
		query.append("					,	D.VPS_ETA_DT_CTNT" ).append("\n"); 
		query.append("					,	D.VPS_ETB_DT_CTNT" ).append("\n"); 
		query.append("					,	D.VPS_ETD_DT_CTNT" ).append("\n"); 
		query.append("					,	D.ACT_ARR_DT_CTNT" ).append("\n"); 
		query.append("					,	D.ACT_BRTH_DT_CTNT" ).append("\n"); 
		query.append("					,	D.ACT_DEP_DT_CTNT" ).append("\n"); 
		query.append("					,	D.TURN_PORT_FLG_CTNT" ).append("\n"); 
		query.append("					,	D.TURN_PORT_IND_CD_CTNT" ).append("\n"); 
		query.append("					,	D.TURN_SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("					,	D.TURN_SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("					,	D.TURN_CLPT_IND_SEQ_CTNT" ).append("\n"); 
		query.append("					,	D.CRE_USR_ID" ).append("\n"); 
		query.append("					,	D.CRE_DT" ).append("\n"); 
		query.append("					,	D.UPD_USR_ID" ).append("\n"); 
		query.append("					,	D.UPD_DT" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("VALUES			(		'R'" ).append("\n"); 
		query.append("					,	TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD')" ).append("\n"); 
		query.append("					,	@[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("					,	edi_xch_log_seq.nextval" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					--,	[vsl_cd_ctnt]" ).append("\n"); 
		query.append("					,	(SELECT H.VSL_CD_CTNT" ).append("\n"); 
		query.append("						 FROM   VSK_VSL_SKD_XCH_EDI_HDR H " ).append("\n"); 
		query.append("						 WHERE 	H.SND_RCV_KND_CD		= 'R'" ).append("\n"); 
		query.append("						 AND	H.SKD_EDI_RCV_SEQ		= @[skd_edi_rcv_seq]" ).append("\n"); 
		query.append("						)" ).append("\n"); 
		query.append("					,	@[skd_voy_no_ctnt]" ).append("\n"); 
		query.append("					,	@[skd_dir_cd_ctnt]					" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					--	::2014-04-20:: --" ).append("\n"); 
		query.append("					,	CASE	WHEN (SELECT C.HJS_PORT_CD FROM VSK_VSL_CONV_PORT C WHERE C.ALLN_CO_CD = @[co_cd_ctnt] AND C.ALLN_PORT_CD = @[vps_port_cd_ctnt]) IS NULL THEN @[vps_port_cd_ctnt]" ).append("\n"); 
		query.append("							 	ELSE (SELECT C.HJS_PORT_CD FROM VSK_VSL_CONV_PORT C WHERE C.ALLN_CO_CD = @[co_cd_ctnt] AND C.ALLN_PORT_CD = @[vps_port_cd_ctnt])" ).append("\n"); 
		query.append("						END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					,	@[vps_port_cd_ctnt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					,	@[vps_port_nm]" ).append("\n"); 
		query.append("					,	@[yd_cd_ctnt]" ).append("\n"); 
		query.append("					,	@[clpt_ind_seq_ctnt]" ).append("\n"); 
		query.append("					,	@[clpt_seq_ctnt]" ).append("\n"); 
		query.append("					,	@[loc_ind_cd_ctnt]" ).append("\n"); 
		query.append("					,	@[call_yd_ind_seq_ctnt]" ).append("\n"); 
		query.append("					,	@[vps_eta_dt_ctnt]" ).append("\n"); 
		query.append("					,	@[vps_etb_dt_ctnt]" ).append("\n"); 
		query.append("					,	@[vps_etd_dt_ctnt]" ).append("\n"); 
		query.append("					,	@[act_arr_dt_ctnt]" ).append("\n"); 
		query.append("					,	@[act_brth_dt_ctnt]" ).append("\n"); 
		query.append("					,	@[act_dep_dt_ctnt]" ).append("\n"); 
		query.append("					,	@[turn_port_flg_ctnt]" ).append("\n"); 
		query.append("					,	@[turn_port_ind_cd_ctnt]" ).append("\n"); 
		query.append("					,	@[turn_skd_voy_no_ctnt]" ).append("\n"); 
		query.append("					,	@[turn_skd_dir_cd_ctnt]" ).append("\n"); 
		query.append("					,	@[turn_clpt_ind_seq_ctnt]" ).append("\n"); 
		query.append("					,	'EDI_XCH_USER_ID'         " ).append("\n"); 
		query.append("					,	SYSDATE             " ).append("\n"); 
		query.append("					,	'EDI_XCH_USER_ID'" ).append("\n"); 
		query.append("					,	SYSDATE" ).append("\n"); 
		query.append("				)" ).append("\n"); 

	}
}