/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrHeaderVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.12.20 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrHeaderVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TdrHeader Ins
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrHeaderVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("con",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("berth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("supply_sulphur_do",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("remark",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rob_fo_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("next_port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gm_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("draft_fwd_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("info",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_work",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gross_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gross_gang",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("displ_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ballast_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rob_fw_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_fo_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwt_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_fw_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gross_gc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dwt_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pilot_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tdr_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tug_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anchor_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ballast_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nis_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sulphur_do_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gross_work",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_fw_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("commence",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_time",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rob_do_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sulphur_do_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lose_hr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hatch",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_do_dep",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tug_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_user",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("supply_sulphur_fo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rob_fo_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tdr_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gm_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pilot_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("draft_aft_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_gang",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("complete",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rob_fw_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sulphur_fo_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sulphur_fo_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_fo_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anchor_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("draft_aft_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bunker_do_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("update_sys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_gc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_canal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("displ_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unberth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("draft_fwd_arr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rob_do_dep",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_tml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrHeaderVOCSQL").append("\n"); 
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
		query.append("INSERT INTO TDR_HEADER (" ).append("\n"); 
		query.append("	SULPHUR_FO_ARR" ).append("\n"); 
		query.append(",	SULPHUR_FO_DEP" ).append("\n"); 
		query.append(",	SULPHUR_DO_ARR" ).append("\n"); 
		query.append(",	SULPHUR_DO_DEP" ).append("\n"); 
		query.append(",	SUPPLY_SULPHUR_FO" ).append("\n"); 
		query.append(",	SUPPLY_SULPHUR_DO" ).append("\n"); 
		query.append(",	UPDATE_SYS" ).append("\n"); 
		query.append(",	TUG_ARR" ).append("\n"); 
		query.append(",	TUG_DEP" ).append("\n"); 
		query.append(",	ETA" ).append("\n"); 
		query.append(",	ETA_CANAL" ).append("\n"); 
		query.append(",	INFO" ).append("\n"); 
		query.append(",	UPDATE_USER" ).append("\n"); 
		query.append(",	UPDATE_TIME" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	VOY_NO" ).append("\n"); 
		query.append(",	DIR_CD" ).append("\n"); 
		query.append(",	PORT_CD" ).append("\n"); 
		query.append(",	CALL_IND" ).append("\n"); 
		query.append(",	TML_CD" ).append("\n"); 
		query.append(",	TDR_DATE" ).append("\n"); 
		query.append(",	TDR_USER" ).append("\n"); 
		query.append(",	NIS_DATE" ).append("\n"); 
		query.append(",	COMMENCE" ).append("\n"); 
		query.append(",	COMPLETE" ).append("\n"); 
		query.append(",	GROSS_WORK" ).append("\n"); 
		query.append(",	NET_WORK" ).append("\n"); 
		query.append(",	LOSE_HR" ).append("\n"); 
		query.append(",	GROSS_GANG" ).append("\n"); 
		query.append(",	NET_GANG" ).append("\n"); 
		query.append(",	MVS" ).append("\n"); 
		query.append(",	NET_TML" ).append("\n"); 
		query.append(",	GROSS_TML" ).append("\n"); 
		query.append(",	NET_GC" ).append("\n"); 
		query.append(",	GROSS_GC" ).append("\n"); 
		query.append(",	REMARK" ).append("\n"); 
		query.append(",	HATCH" ).append("\n"); 
		query.append(",	CON" ).append("\n"); 
		query.append(",	PILOT_ARR" ).append("\n"); 
		query.append(",	PILOT_DEP" ).append("\n"); 
		query.append(",	ANCHOR_ARR" ).append("\n"); 
		query.append(",	ANCHOR_DEP" ).append("\n"); 
		query.append(",	BERTH" ).append("\n"); 
		query.append(",	UNBERTH" ).append("\n"); 
		query.append(",	DRAFT_FWD_ARR" ).append("\n"); 
		query.append(",	DRAFT_FWD_DEP" ).append("\n"); 
		query.append(",	DRAFT_AFT_ARR" ).append("\n"); 
		query.append(",	DRAFT_AFT_DEP" ).append("\n"); 
		query.append(",	BALLAST_ARR" ).append("\n"); 
		query.append(",	BALLAST_DEP" ).append("\n"); 
		query.append(",	ROB_FO_ARR" ).append("\n"); 
		query.append(",	ROB_FO_DEP" ).append("\n"); 
		query.append(",	ROB_DO_ARR" ).append("\n"); 
		query.append(",	ROB_DO_DEP" ).append("\n"); 
		query.append(",	ROB_FW_ARR" ).append("\n"); 
		query.append(",	ROB_FW_DEP" ).append("\n"); 
		query.append(",	BUNKER_FO_ARR" ).append("\n"); 
		query.append(",	BUNKER_FO_DEP" ).append("\n"); 
		query.append(",	BUNKER_DO_ARR" ).append("\n"); 
		query.append(",	BUNKER_DO_DEP" ).append("\n"); 
		query.append(",	BUNKER_FW_ARR" ).append("\n"); 
		query.append(",	BUNKER_FW_DEP" ).append("\n"); 
		query.append(",	DWT_ARR" ).append("\n"); 
		query.append(",	DWT_DEP" ).append("\n"); 
		query.append(",	DISPL_ARR" ).append("\n"); 
		query.append(",	DISPL_DEP" ).append("\n"); 
		query.append(",	GM_ARR" ).append("\n"); 
		query.append(",	GM_DEP" ).append("\n"); 
		query.append(",   NEXT_PORT" ).append("\n"); 
		query.append(",   UPD_SYS_CD" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[sulphur_fo_arr]" ).append("\n"); 
		query.append(",	@[sulphur_fo_dep]" ).append("\n"); 
		query.append(",	@[sulphur_do_arr]" ).append("\n"); 
		query.append(",	@[sulphur_do_dep]" ).append("\n"); 
		query.append(",	@[supply_sulphur_fo]" ).append("\n"); 
		query.append(",	@[supply_sulphur_do]" ).append("\n"); 
		query.append(",	@[update_sys]" ).append("\n"); 
		query.append(",	@[tug_arr]" ).append("\n"); 
		query.append(",	@[tug_dep]" ).append("\n"); 
		query.append(",	TO_DATE(@[eta],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[eta_canal],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[info]" ).append("\n"); 
		query.append(",	@[update_user]" ).append("\n"); 
		query.append(",	TO_DATE(@[update_time],'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[voy_no]" ).append("\n"); 
		query.append(",	@[dir_cd]" ).append("\n"); 
		query.append(",	@[port_cd]" ).append("\n"); 
		query.append(",	@[call_ind]" ).append("\n"); 
		query.append(",	@[tml_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[tdr_date],'YYYYMMDD')" ).append("\n"); 
		query.append(",	@[tdr_user]" ).append("\n"); 
		query.append(",	TO_DATE(@[nis_date],'YYYYMMDD')" ).append("\n"); 
		query.append(",	TO_DATE(@[commence],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[complete],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[gross_work]" ).append("\n"); 
		query.append(",	@[net_work]" ).append("\n"); 
		query.append(",	@[lose_hr]" ).append("\n"); 
		query.append(",	@[gross_gang]" ).append("\n"); 
		query.append(",	@[net_gang]" ).append("\n"); 
		query.append(",	@[mvs]" ).append("\n"); 
		query.append(",	@[net_tml]" ).append("\n"); 
		query.append(",	@[gross_tml]" ).append("\n"); 
		query.append(",	@[net_gc]" ).append("\n"); 
		query.append(",	@[gross_gc]" ).append("\n"); 
		query.append(",	@[remark]" ).append("\n"); 
		query.append(",	@[hatch]" ).append("\n"); 
		query.append(",	@[con]" ).append("\n"); 
		query.append(",	TO_DATE(@[pilot_arr],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[pilot_dep],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[anchor_arr],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[anchor_dep],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[berth],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	TO_DATE(@[unberth],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",	@[draft_fwd_arr]" ).append("\n"); 
		query.append(",	@[draft_fwd_dep]" ).append("\n"); 
		query.append(",	@[draft_aft_arr]" ).append("\n"); 
		query.append(",	@[draft_aft_dep]" ).append("\n"); 
		query.append(",	@[ballast_arr]" ).append("\n"); 
		query.append(",	@[ballast_dep]" ).append("\n"); 
		query.append(",	@[rob_fo_arr]" ).append("\n"); 
		query.append(",	@[rob_fo_dep]" ).append("\n"); 
		query.append(",	@[rob_do_arr]" ).append("\n"); 
		query.append(",	@[rob_do_dep]" ).append("\n"); 
		query.append(",	@[rob_fw_arr]" ).append("\n"); 
		query.append(",	@[rob_fw_dep]" ).append("\n"); 
		query.append(",	@[bunker_fo_arr]" ).append("\n"); 
		query.append(",	@[bunker_fo_dep]" ).append("\n"); 
		query.append(",	@[bunker_do_arr]" ).append("\n"); 
		query.append(",	@[bunker_do_dep]" ).append("\n"); 
		query.append(",	@[bunker_fw_arr]" ).append("\n"); 
		query.append(",	@[bunker_fw_dep]" ).append("\n"); 
		query.append(",	@[dwt_arr]" ).append("\n"); 
		query.append(",	@[dwt_dep]" ).append("\n"); 
		query.append(",	@[displ_arr]" ).append("\n"); 
		query.append(",	@[displ_dep]" ).append("\n"); 
		query.append(",	@[gm_arr]" ).append("\n"); 
		query.append(",	@[gm_dep]" ).append("\n"); 
		query.append(",	@[next_port]" ).append("\n"); 
		query.append(",   'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}