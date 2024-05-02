/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOInsertRailBillOrderFullCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2012.04.05 윤권영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yun kwon-young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOInsertRailBillOrderFullCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Insert Rail Bill Order (Full Cntr)SQL 문장
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOInsertRailBillOrderFullCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fumg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rail_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_ipi_locl_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvocc_file_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stel_wire_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spnd_err_msg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_xpt_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coi_shp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rout_pln_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inlnd_rout_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_cfm_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_cstms_clr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lst_nod_pln_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_cmb_thru_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_xpt_sys_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cmdt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spnd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prov_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cost_act_grp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcvde_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spnd_lang_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOInsertRailBillOrderFullCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_RAIL_BIL_ORD (" ).append("\n"); 
		query.append("TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(", TRSP_SO_SEQ" ).append("\n"); 
		query.append(", RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append(", TRSP_SO_STS_CD" ).append("\n"); 
		query.append(", TRSP_RAIL_BIL_TP_CD" ).append("\n"); 
		query.append(", COST_ACT_GRP_CD" ).append("\n"); 
		query.append(", FM_NOD_CD" ).append("\n"); 
		query.append(", TO_NOD_CD" ).append("\n"); 
		query.append(", VSL_CD" ).append("\n"); 
		query.append(", SKD_VOY_NO" ).append("\n"); 
		query.append(", SKD_DIR_CD" ).append("\n"); 
		query.append(", SLAN_CD" ).append("\n"); 
		query.append(", ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append(", ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append(", ROUT_SEQ" ).append("\n"); 
		query.append(", ROUT_PLN_CD" ).append("\n"); 
		query.append(", INLND_ROUT_RMK" ).append("\n"); 
		query.append(", EQ_KND_CD" ).append("\n"); 
		query.append(", EQ_NO" ).append("\n"); 
		query.append(", EQ_TPSZ_CD" ).append("\n"); 
		query.append(", TRSP_BND_CD" ).append("\n"); 
		query.append(", BKG_NO" ).append("\n"); 
		query.append(", BL_NO" ).append("\n"); 
		query.append(", BKG_CGO_TP_CD" ).append("\n"); 
		query.append(", CUST_SEQ" ).append("\n"); 
		query.append(", TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(", CNTR_WGT" ).append("\n"); 
		query.append(", WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", CGO_TP_CD" ).append("\n"); 
		query.append(", CMDT_CD" ).append("\n"); 
		query.append(", STND_CMDT_NO" ).append("\n"); 
		query.append(", AUTO_XPT_SYS_CD" ).append("\n"); 
		query.append(", AUTO_XPT_SYS_NO" ).append("\n"); 
		query.append(", COP_NO" ).append("\n"); 
		query.append(", COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(", SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append(", IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append(", IBD_IPI_LOCL_IND_CD" ).append("\n"); 
		query.append(", POR_NOD_CD" ).append("\n"); 
		query.append(", POR_CD" ).append("\n"); 
		query.append(", POL_CD" ).append("\n"); 
		query.append(", POD_CD" ).append("\n"); 
		query.append(", DEL_CD" ).append("\n"); 
		query.append(", DEL_NOD_CD" ).append("\n"); 
		query.append(", POD_NOD_CD" ).append("\n"); 
		query.append(", POL_NOD_CD" ).append("\n"); 
		query.append(", DEL_SCC_CD" ).append("\n"); 
		query.append(", NVOCC_FILE_NO" ).append("\n"); 
		query.append(", CNTR_SEAL_NO" ).append("\n"); 
		query.append(", SHPR_CUST_NM" ).append("\n"); 
		query.append(", BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append(", N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append(", LST_NOD_PLN_DT" ).append("\n"); 
		query.append(", INTER_RMK" ).append("\n"); 
		query.append(", SPCL_INSTR_RMK" ).append("\n"); 
		query.append(", BLK_FLG" ).append("\n"); 
		query.append(", STEL_WIRE_FLG" ).append("\n"); 
		query.append(", COIL_SHP_FLG" ).append("\n"); 
		query.append(", FUMG_FLG" ).append("\n"); 
		query.append(", SPND_ERR_MSG_CD" ).append("\n"); 
		query.append(", SPND_LANG_TP_CD" ).append("\n"); 
		query.append(", SPND_FLG" ).append("\n"); 
		query.append(", SHPR_FAX_NO" ).append("\n"); 
		query.append(", PROV_USR_ID" ).append("\n"); 
		query.append(", PROV_VNDR_SEQ" ).append("\n"); 
		query.append(", PROV_PHN_NO" ).append("\n"); 
		query.append(", PROV_FAX_NO" ).append("\n"); 
		query.append(", PROV_EML" ).append("\n"); 
		query.append(", PROV_CFM_MZD_CD" ).append("\n"); 
		query.append(", ORG_COP_NO" ).append("\n"); 
		query.append(", ORG_COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(", ORG_BKG_NO" ).append("\n"); 
		query.append(", DELT_FLG" ).append("\n"); 
		query.append(", CRE_OFC_CD" ).append("\n"); 
		query.append(", LOG_UPD_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", LOCL_CRE_DT" ).append("\n"); 
		query.append(", LOCL_UPD_DT" ).append("\n"); 
		query.append(", SC_NO" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[trsp_so_ofc_cty_cd]   				 -- TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append(",	@[trsp_so_seq]          				 -- TRSP_SO_SEQ" ).append("\n"); 
		query.append(",	@[rail_cmb_thru_tp_cd]          		 -- RAIL_CMB_THRU_TP_CD" ).append("\n"); 
		query.append(",	@[trsp_so_sts_cd]          				 -- TRSP_SO_STS_CD        (COP:C, MT: M, WRS: W)" ).append("\n"); 
		query.append(",	@[trsp_rail_bil_tp_cd]          		 -- TRSP_RAIL_BIL_TP_CD" ).append("\n"); 
		query.append(",   @[cost_act_grp_cd]						 --COST_ACT_GRP_CD" ).append("\n"); 
		query.append(",	@[fm_nod_cd]          				 	 -- FM_NOD_CD" ).append("\n"); 
		query.append(",	@[to_nod_cd]          				 	 -- TO_NOD_CD" ).append("\n"); 
		query.append(",	@[vsl_cd]          				 		 -- VSL_CD" ).append("\n"); 
		query.append(",	@[skd_voy_no]          				 	 -- SKD_VOY_NO" ).append("\n"); 
		query.append(",	@[skd_dir_cd]          				 	 -- SKD_DIR_CD" ).append("\n"); 
		query.append(",	@[slan_cd]          				 	 -- SLAN_CD" ).append("\n"); 
		query.append(",	@[rout_org_nod_cd]          			 -- ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append(",	@[rout_dest_nod_cd]          			 -- ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append(",	@[rout_seq]          				 	 -- ROUT_SEQ" ).append("\n"); 
		query.append(",	@[rout_pln_cd]          				 -- ROUT_PLN_CD" ).append("\n"); 
		query.append(",	@[inlnd_rout_rmk]          				 -- INLND_ROUT_RMK" ).append("\n"); 
		query.append(",	'U'     				 				 -- EQ_KND_CD" ).append("\n"); 
		query.append(",	@[eq_no]          				 		 -- EQ_NO" ).append("\n"); 
		query.append(",	@[eq_tpsz_cd]          				 	 -- EQ_TPSZ_CD" ).append("\n"); 
		query.append(",	@[trsp_bnd_cd]          				 -- TRSP_BND_CD" ).append("\n"); 
		query.append(",	@[bkg_no]          				 		 -- BKG_NO" ).append("\n"); 
		query.append(",	@[bl_no]          				 		 -- BL_NO" ).append("\n"); 
		query.append(",	@[bkg_cgo_tp_cd]          				 -- BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",	@[cust_seq]          				 	 -- CUST_SEQ" ).append("\n"); 
		query.append(",	'CY'    				 				 -- TRSP_COST_DTL_MOD_CD" ).append("\n"); 
		query.append(",	@[cntr_wgt]          				 	 -- CNTR_WGT" ).append("\n"); 
		query.append(",	@[wgt_meas_ut_cd]          				 -- WGT_MEAS_UT_CD" ).append("\n"); 
		query.append(",	@[pck_tp_cd]          				 	 -- PCK_TP_CD" ).append("\n"); 
		query.append(",	@[pck_qty]          				 	 -- PCK_QTY" ).append("\n"); 
		query.append(",	@[cgo_tp_cd]          				 	 -- CGO_TP_CD" ).append("\n"); 
		query.append(",	@[cmdt_cd]          				 	 -- CMDT_CD" ).append("\n"); 
		query.append(",	@[stnd_cmdt_no]          				 -- STND_CMDT_NO" ).append("\n"); 
		query.append(",	@[auto_xpt_sys_cd]          			 -- AUTO_XPT_SYS_CD" ).append("\n"); 
		query.append(",	@[auto_xpt_sys_no]          			 -- AUTO_XPT_SYS_NO" ).append("\n"); 
		query.append(",	@[cop_no]          				 	  	 -- COP_NO" ).append("\n"); 
		query.append(",	@[cost_act_grp_seq]          			 -- COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",	@[spcl_cgo_cntr_tp_cd]          		 -- SPCL_CGO_CNTR_TP_CD" ).append("\n"); 
		query.append(",	@[ibd_cstms_clr_loc_cd]          		 -- IBD_CSTMS_CLR_LOC_CD" ).append("\n"); 
		query.append(",	@[ibd_ipi_locl_ind_cd]          		 -- IBD_IPI_LOCL_IND_CD" ).append("\n"); 
		query.append(",	@[por_nod_cd]          				 	 -- POR_NOD_CD" ).append("\n"); 
		query.append(",	@[por_cd]          				 		 -- POR_CD" ).append("\n"); 
		query.append(",	@[pol_cd]          				 		 -- POL_CD" ).append("\n"); 
		query.append(",	@[pod_cd]          				 		 -- POD_CD" ).append("\n"); 
		query.append(",	@[del_cd]          				 		 -- DEL_CD" ).append("\n"); 
		query.append(",	@[del_nod_cd]          				 	 -- DEL_NOD_CD" ).append("\n"); 
		query.append(",	@[pod_nod_cd]          				 	 -- POD_NOD_CD" ).append("\n"); 
		query.append(",	@[pol_nod_cd]          				 	 -- POL_NOD_CD" ).append("\n"); 
		query.append(",	@[del_scc_cd]          				 	 -- DEL_SCC_CD" ).append("\n"); 
		query.append(",	@[nvocc_file_no]          				 -- NVOCC_FILE_NO" ).append("\n"); 
		query.append(",	@[cntr_seal_no]          				 -- CNTR_SEAL_NO" ).append("\n"); 
		query.append(",	@[shpr_cust_nm]          				 -- SHPR_CUST_NM" ).append("\n"); 
		query.append(",	@[bkg_rcvde_term_cd]          			 -- BKG_RCVDE_TERM_CD" ).append("\n"); 
		query.append(",	To_DATE(@[n1st_nod_pln_dt], 'YYYYMMDDHH24MISS')           	 -- N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append(",	To_DATE(@[lst_nod_pln_dt], 'YYYYMMDDHH24MISS')           	 -- LST_NOD_PLN_DT" ).append("\n"); 
		query.append(",	@[inter_rmk]           				 	 -- INTER_RMK" ).append("\n"); 
		query.append(",	@[spcl_instr_rmk]           			 -- SPCL_INSTR_RMK" ).append("\n"); 
		query.append(",	@[blk_flg] 			 					 -- BLK_FLG" ).append("\n"); 
		query.append(",	@[stel_wire_flg] 			 			 -- STEL_WIRE_FLG" ).append("\n"); 
		query.append(",	@[coi_shp_flg] 			 				 -- COIL_SHP_FLG" ).append("\n"); 
		query.append(",	@[fumg_flg] 			 				 -- FUMG_FLG" ).append("\n"); 
		query.append(",	@[spnd_err_msg_cd]           			 -- SPND_ERR_MSG_CD" ).append("\n"); 
		query.append(",	@[spnd_lang_tp_cd]           			 -- SPND_LANG_TP_CD" ).append("\n"); 
		query.append(",	@[spnd_flg]           				 	 -- SPND_FLG" ).append("\n"); 
		query.append(",	@[shpr_fax_no]           				 -- SHPR_FAX_NO" ).append("\n"); 
		query.append(",	@[prov_usr_id]           				 -- PROV_USR_ID" ).append("\n"); 
		query.append(",	@[prov_vndr_seq]           				 -- PROV_VNDR_SEQ" ).append("\n"); 
		query.append(",	@[prov_phn_no]           				 -- PROV_PHN_NO" ).append("\n"); 
		query.append(",	@[prov_fax_no]           				 -- PROV_FAX_NO" ).append("\n"); 
		query.append(",	@[prov_eml]           				 	 -- PROV_EML" ).append("\n"); 
		query.append(",	@[prov_cfm_mzd_cd]           			 -- PROV_CFM_MZD_CD" ).append("\n"); 
		query.append(",	@[org_cop_no]           				 -- ORG_COP_NO" ).append("\n"); 
		query.append(",	@[org_cost_act_grp_seq]           		 -- ORG_COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(",	@[org_bkg_no]           				 -- ORG_BKG_NO" ).append("\n"); 
		query.append(",	'N'      				 			 	 -- DELT_FLG        	'N'" ).append("\n"); 
		query.append(",	@[cre_ofc_cd]           				 -- CRE_OFC_CD" ).append("\n"); 
		query.append(",	sysdate									 -- LOG_UPD_DT" ).append("\n"); 
		query.append(",	@[cre_usr_id]           				 -- CRE_USR_ID" ).append("\n"); 
		query.append(",	sysdate	 		 						 -- CRE_DT" ).append("\n"); 
		query.append(",	@[upd_usr_id]           				 -- UPD_USR_ID" ).append("\n"); 
		query.append(",	sysdate     		 					 -- UPD_DT" ).append("\n"); 
		query.append(",globaldate_pkg.time_local_ofc_fnc(@[vndr_seq])  -- LOCL_CRE_DT" ).append("\n"); 
		query.append(",globaldate_pkg.time_local_ofc_fnc(@[vndr_seq])  -- LOCL_UPD_DT" ).append("\n"); 
		query.append(",	@[sc_no]           				 		 -- SC_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}