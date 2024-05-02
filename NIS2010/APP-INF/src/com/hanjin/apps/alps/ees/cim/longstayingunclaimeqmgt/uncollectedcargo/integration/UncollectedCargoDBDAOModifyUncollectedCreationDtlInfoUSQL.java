/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UncollectedCargoDBDAOModifyUncollectedCreationDtlInfoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UncollectedCargoDBDAOModifyUncollectedCreationDtlInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UncollectedCreation Detail 데이타 update 
	  * </pre>
	  */
	public UncollectedCargoDBDAOModifyUncollectedCreationDtlInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cgo_n3rd_ntc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_otr_cost_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_obl_hld_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_piclb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_dmdt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_insur_cvr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_crnt_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_ctrt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_piclb_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cgo_fnl_ntc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cgo_n1st_ntc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_ttl_vol_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aban_ltr_shpr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_inv_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_otr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fact_fnd_act_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_dmdt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_crnt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kntr_ofc_opin_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_otr_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cgo_loc_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hndl_ofc_opin_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cgo_n2nd_ntc_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_crnt_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_oft_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_crnt_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_sto_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_cgo_ntc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uc_disp_opt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_sto_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_rcvr_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aban_ltr_cnee_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration").append("\n"); 
		query.append("FileName : UncollectedCargoDBDAOModifyUncollectedCreationDtlInfoUSQL").append("\n"); 
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
		query.append("UPDATE	CIM_UC_CGO_DTL" ).append("\n"); 
		query.append("SET	" ).append("\n"); 
		query.append("		ctrt_ttl_vol_ctnt 		=	@[ctrt_ttl_vol_ctnt]" ).append("\n"); 
		query.append("		, uc_ctrt_rmk 			=	@[uc_ctrt_rmk]" ).append("\n"); 
		query.append("		, uc_rsn_cd 			=	@[uc_rsn_cd]" ).append("\n"); 
		query.append("		, uc_inv_amt 			=	@[uc_inv_amt]" ).append("\n"); 
		query.append("		, uc_inv_curr_cd 		=	@[uc_inv_curr_cd]" ).append("\n"); 
		query.append("		, uc_inv_xch_rt 		=	@[uc_inv_xch_rt]" ).append("\n"); 
		query.append("		, uc_inv_usd_amt 		=	@[uc_inv_usd_amt]" ).append("\n"); 
		query.append("		, uc_crnt_amt 			=	@[uc_crnt_amt]" ).append("\n"); 
		query.append("		, uc_crnt_curr_cd 		=	@[uc_crnt_curr_cd]" ).append("\n"); 
		query.append("		, uc_crnt_xch_rt 		=	@[uc_crnt_xch_rt]" ).append("\n"); 
		query.append("		, uc_crnt_usd_amt 		=	@[uc_crnt_usd_amt]" ).append("\n"); 
		query.append("		, uc_obl_hld_cd 		=	@[uc_obl_hld_cd]" ).append("\n"); 
		query.append("		, uc_piclb_cd 			=	@[uc_piclb_cd]" ).append("\n"); 
		query.append("		, uc_piclb_ref_no 		=	@[uc_piclb_ref_no]" ).append("\n"); 
		query.append("		, uc_disp_opt_cd 		=	@[uc_disp_opt_cd]" ).append("\n"); 
		query.append("		, aban_ltr_shpr_dt 		=	@[aban_ltr_shpr_dt]" ).append("\n"); 
		query.append("		, aban_ltr_cnee_dt 		=	@[aban_ltr_cnee_dt]" ).append("\n"); 
		query.append("		, uc_cgo_loc_nm 		=	@[uc_cgo_loc_nm]" ).append("\n"); 
		query.append("		, uc_cgo_n1st_ntc_dt 	=	TO_DATE(@[uc_cgo_n1st_ntc_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("		, uc_cgo_n2nd_ntc_dt 	=	TO_DATE(@[uc_cgo_n2nd_ntc_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("		, uc_cgo_n3rd_ntc_dt	=	TO_DATE(@[uc_cgo_n3rd_ntc_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("		, uc_cgo_fnl_ntc_dt 	=	TO_DATE(@[uc_cgo_fnl_ntc_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("		, uc_cgo_ntc_rmk 		=	@[uc_cgo_ntc_rmk]" ).append("\n"); 
		query.append("		, ots_oft_amt 			=	@[ots_oft_amt]" ).append("\n"); 
		query.append("		, ots_otr_amt 			=	@[ots_otr_amt]" ).append("\n"); 
		query.append("		, ots_dmdt_amt 			=	@[ots_dmdt_amt]" ).append("\n"); 
		query.append("		, ots_dmdt_dt 			=	@[ots_dmdt_dt]" ).append("\n"); 
		query.append("		, ots_sto_amt 			=	@[ots_sto_amt]" ).append("\n"); 
		query.append("		, ots_sto_dt 			=	@[ots_sto_dt]" ).append("\n"); 
		query.append("		, ots_otr_cost_amt 		=	@[ots_otr_cost_amt]" ).append("\n"); 
		query.append("		, ots_otr_cost_dt 		=	@[ots_otr_cost_dt]" ).append("\n"); 
		query.append("		, ots_rcvr_amt 			=	@[ots_rcvr_amt]" ).append("\n"); 
		query.append("		, ots_insur_cvr_amt 	=	@[ots_insur_cvr_amt]" ).append("\n"); 
		query.append("		, ots_rmk 				=	@[ots_rmk]" ).append("\n"); 
		query.append("		, fact_fnd_act_desc 	=	@[fact_fnd_act_desc]" ).append("\n"); 
		query.append("		, hndl_ofc_opin_desc 	=	@[hndl_ofc_opin_desc]" ).append("\n"); 
		query.append("		, kntr_ofc_opin_desc 	=	@[kntr_ofc_opin_desc]" ).append("\n"); 
		query.append("		, upd_usr_id 			=	@[upd_usr_id]" ).append("\n"); 
		query.append("		, upd_dt 				=	SYSDATE" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("		AND	uc_cs_no 			=	@[uc_cs_no]" ).append("\n"); 
		query.append("		AND bl_no				= 	@[bl_no]" ).append("\n"); 

	}
}