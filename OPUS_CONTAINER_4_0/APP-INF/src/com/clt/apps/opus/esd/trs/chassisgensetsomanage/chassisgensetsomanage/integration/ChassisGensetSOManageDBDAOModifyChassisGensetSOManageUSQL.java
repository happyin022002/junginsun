/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ChassisGensetSOManageDBDAOModifyChassisGensetSOManageUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisGensetSOManageDBDAOModifyChassisGensetSOManageUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Chassis Genset S/O Modify
	  * f_cmd : MODIFY
	  * </pre>
	  */
	public ChassisGensetSOManageDBDAOModifyChassisGensetSOManageUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_gate_in_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_gate_out_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_instr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.integration").append("\n"); 
		query.append("FileName : ChassisGensetSOManageDBDAOModifyChassisGensetSOManageUSQL").append("\n"); 
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
		query.append("UPDATE trs_trsp_svc_ord" ).append("\n"); 
		query.append("   SET eq_no = @[eq_no]" ).append("\n"); 
		query.append("      ,fm_nod_cd = @[fm_nod_cd]" ).append("\n"); 
		query.append("      ,to_nod_cd = @[to_nod_cd]" ).append("\n"); 
		query.append("      ,inter_rmk = @[inter_rmk]" ).append("\n"); 
		query.append("      ,spcl_instr_rmk = @[spcl_instr_rmk]" ).append("\n"); 
		query.append("      ,trsp_so_sts_cd = 'R'" ).append("\n"); 
		query.append("      ,trsp_so_cmb_seq = @[trsp_so_cmb_seq]" ).append("\n"); 
		query.append("      ,trsp_so_cmb_tp_cd = @[trsp_so_cmb_tp_cd]" ).append("\n"); 
		query.append("      ,cntr_no = @[cntr_no]" ).append("\n"); 
		query.append("      ,cntr_tpsz_cd = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("      ,ref_bkg_no = @[ref_bkg_no]" ).append("\n"); 
		query.append("      ,ref_bl_no = @[ref_bl_no]" ).append("\n"); 
		query.append("      ,org_gate_out_dt = TO_DATE (@[org_gate_out_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("      ,dest_gate_in_dt = TO_DATE (@[dest_gate_in_dt], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("	  ,locl_upd_dt = globaldate_pkg.time_local_ofc_fnc (cre_ofc_cd)	" ).append("\n"); 
		query.append("      ,upd_dt = SYSDATE" ).append("\n"); 
		query.append("      ,upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("	  ,eq_atch_dt = NVL(eq_atch_dt, NVL2(@[eq_no], SYSDATE, NULL)) 	  " ).append("\n"); 
		query.append(" WHERE trsp_so_ofc_cty_cd = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND trsp_so_seq = @[trsp_so_seq]" ).append("\n"); 

	}
}