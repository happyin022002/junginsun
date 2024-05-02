/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCNoteConversionProposalDBDAOPriScNoteConvVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCNoteConversionProposalDBDAOPriScNoteConvVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SCNoteConversionProposalDBDAOPriScNoteConvVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_max_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_org_via_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dest_via_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_org_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dest_loc_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_org_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_mst_hbl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_org_via_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_act_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dest_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_org_loc_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dest_via_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_scg_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_org_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_esvc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ts_port_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cmdt_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_min_cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_io_ga_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_prc_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_por_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_dir_call_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_prc_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_act_cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_prc_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dest_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ts_port_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_rule_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_usa_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cnl_tz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_org_via_loc_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dest_via_loc_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_cmdt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_mapg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("note_conv_rule_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rule_appl_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_cmdt_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conv_dest_loc_def_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_appl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration").append("\n"); 
		query.append("FileName : SCNoteConversionProposalDBDAOPriScNoteConvVOUSQL").append("\n"); 
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
		query.append("UPDATE PRI_SC_NOTE_CONV SET" ).append("\n"); 
		query.append("	  CHG_RULE_TP_CD			= @[chg_rule_tp_cd]" ).append("\n"); 
		query.append("	, NOTE_CONV_CHG_CD			= @[note_conv_chg_cd]" ).append("\n"); 
		query.append("	, NOTE_CONV_RULE_CD			= @[note_conv_rule_cd]" ).append("\n"); 
		query.append("	, EFF_DT					= TO_DATE(@[eff_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	, EXP_DT					= TO_DATE(NVL(@[exp_dt],'99991231'), 'YYYYMMDD')" ).append("\n"); 
		query.append("	, RT_APPL_TP_CD				= @[rt_appl_tp_cd]" ).append("\n"); 
		query.append("	, RT_OP_CD					= @[rt_op_cd]" ).append("\n"); 
		query.append("	, CURR_CD					= @[curr_cd]" ).append("\n"); 
		query.append("	, FRT_RT_AMT				= @[frt_rt_amt]" ).append("\n"); 
		query.append("	, PAY_TERM_CD				= @[pay_term_cd]" ).append("\n"); 
		query.append("	, GEN_SPCL_RT_TP_CD			= @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("	, BKG_RAT_UT_CD				= @[bkg_rat_ut_cd]" ).append("\n"); 
		query.append("	, BKG_PRC_CGO_TP_CD			= @[bkg_prc_cgo_tp_cd]" ).append("\n"); 
		query.append("	, BKG_IMDG_CLSS_CD			= @[bkg_imdg_clss_cd]" ).append("\n"); 
		query.append("	, BKG_CMDT_TP_CD			= @[bkg_cmdt_tp_cd]" ).append("\n"); 
		query.append("	, BKG_CMDT_DEF_CD			= @[bkg_cmdt_def_cd]" ).append("\n"); 
		query.append("	, BKG_SCG_GRP_CMDT_CD		= @[bkg_scg_grp_cmdt_cd]" ).append("\n"); 
		query.append("	, BKG_USA_SVC_MOD_CD		= @[bkg_usa_svc_mod_cd]" ).append("\n"); 
		query.append("	, BKG_POR_TP_CD				= @[bkg_por_tp_cd]" ).append("\n"); 
		query.append("	, BKG_POR_DEF_CD			= DECODE(@[bkg_por_tp_cd], 'T', @[bkg_por_cnt_cd]||@[bkg_por_def_cd], @[bkg_por_def_cd])" ).append("\n"); 
		query.append("	, BKG_POL_TP_CD				= @[bkg_pol_tp_cd]" ).append("\n"); 
		query.append("	, BKG_POL_DEF_CD			= DECODE(@[bkg_pol_tp_cd], 'T', @[bkg_pol_cnt_cd]||@[bkg_pol_def_cd], @[bkg_pol_def_cd])" ).append("\n"); 
		query.append("	, BKG_POD_TP_CD				= @[bkg_pod_tp_cd]" ).append("\n"); 
		query.append("	, BKG_POD_DEF_CD			= DECODE(@[bkg_pod_tp_cd], 'T', @[bkg_pod_cnt_cd]||@[bkg_pod_def_cd], @[bkg_pod_def_cd])" ).append("\n"); 
		query.append("	, BKG_DEL_TP_CD				= @[bkg_del_tp_cd]" ).append("\n"); 
		query.append("	, BKG_DEL_DEF_CD			= DECODE(@[bkg_del_tp_cd], 'T', @[bkg_del_cnt_cd]||@[bkg_del_def_cd], @[bkg_del_def_cd])" ).append("\n"); 
		query.append("	, BKG_ORG_TRSP_MOD_CD		= @[bkg_org_trsp_mod_cd]" ).append("\n"); 
		query.append("	, BKG_DEST_TRSP_MOD_CD		= @[bkg_dest_trsp_mod_cd]" ).append("\n"); 
		query.append("	, BKG_RCV_TERM_CD			= @[bkg_rcv_term_cd]" ).append("\n"); 
		query.append("	, BKG_DE_TERM_CD			= @[bkg_de_term_cd]" ).append("\n"); 
		query.append("	, BKG_SLAN_CD				= @[bkg_slan_cd]" ).append("\n"); 
		query.append("	, BKG_VSL_CD				= @[bkg_vsl_cd]" ).append("\n"); 
		query.append("	, BKG_SKD_VOY_NO			= @[bkg_skd_voy_no]" ).append("\n"); 
		query.append("	, BKG_SKD_DIR_CD			= @[bkg_skd_dir_cd]" ).append("\n"); 
		query.append("	, BKG_SOC_FLG				= @[bkg_soc_flg]" ).append("\n"); 
		query.append("	, BKG_ACT_CUST_CNT_CD		= @[bkg_act_cust_cnt_cd]" ).append("\n"); 
		query.append("	, BKG_ACT_CUST_SEQ			= @[bkg_act_cust_seq]" ).append("\n"); 
		query.append("	, BKG_TS_PORT_TP_CD			= @[bkg_ts_port_tp_cd]" ).append("\n"); 
		query.append("	, BKG_TS_PORT_DEF_CD		= @[bkg_ts_port_def_cd]" ).append("\n"); 
		query.append("	, BKG_DIR_CALL_FLG			= @[bkg_dir_call_flg]" ).append("\n"); 
		query.append("	, BKG_MST_HBL_TP_CD			= @[bkg_mst_hbl_tp_cd]" ).append("\n"); 
		query.append("	, CONV_RAT_UT_CD			= @[conv_rat_ut_cd]" ).append("\n"); 
		query.append("	, CONV_PRC_CGO_TP_CD		= @[conv_prc_cgo_tp_cd]" ).append("\n"); 
		query.append("	, CONV_CMDT_TP_CD			= @[conv_cmdt_tp_cd]" ).append("\n"); 
		query.append("	, CONV_CMDT_DEF_CD			= @[conv_cmdt_def_cd]" ).append("\n"); 
		query.append("	, CONV_ORG_LOC_TP_CD		= @[conv_org_loc_tp_cd]" ).append("\n"); 
		query.append("	, CONV_ORG_LOC_DEF_CD		= DECODE(@[conv_org_loc_tp_cd], 'T', @[conv_org_loc_cnt_cd]||@[conv_org_loc_def_cd], @[conv_org_loc_def_cd])" ).append("\n"); 
		query.append("	, CONV_ORG_VIA_LOC_TP_CD	= @[conv_org_via_loc_tp_cd]" ).append("\n"); 
		query.append("	, CONV_ORG_VIA_LOC_DEF_CD	= DECODE(@[conv_org_via_loc_tp_cd], 'T', @[conv_org_via_loc_cnt_cd]||@[conv_org_via_loc_def_cd], @[conv_org_via_loc_def_cd])" ).append("\n"); 
		query.append("	, CONV_DEST_VIA_LOC_TP_CD	= @[conv_dest_via_loc_tp_cd]" ).append("\n"); 
		query.append("	, CONV_DEST_VIA_LOC_DEF_CD	= DECODE(@[conv_dest_via_loc_tp_cd], 'T', @[conv_dest_via_loc_cnt_cd]||@[conv_dest_via_loc_def_cd], @[conv_dest_via_loc_def_cd])" ).append("\n"); 
		query.append("	, CONV_DEST_LOC_TP_CD		= @[conv_dest_loc_tp_cd]" ).append("\n"); 
		query.append("	, CONV_DEST_LOC_DEF_CD		= DECODE(@[conv_dest_loc_tp_cd], 'T', @[conv_dest_loc_cnt_cd]||@[conv_dest_loc_def_cd], @[conv_dest_loc_def_cd])" ).append("\n"); 
		query.append("	, CONV_PRC_RCV_TERM_CD		= @[conv_prc_rcv_term_cd]" ).append("\n"); 
		query.append("	, CONV_PRC_DE_TERM_CD		= @[conv_prc_de_term_cd]" ).append("\n"); 
		query.append("	, UPD_USR_ID				= @[upd_usr_id]" ).append("\n"); 
		query.append("	, UPD_DT					= sysdate" ).append("\n"); 
		query.append("	, NOTE_HDR_SEQ				= @[note_hdr_seq]" ).append("\n"); 
		query.append("	, RULE_APPL_CHG_TP_CD		= @[rule_appl_chg_tp_cd]" ).append("\n"); 
		query.append("	, BKG_IO_GA_CD				= @[bkg_io_ga_cd]" ).append("\n"); 
		query.append("	, BKG_CNL_TZ_CD				= @[bkg_cnl_tz_cd]" ).append("\n"); 
		query.append("	, BKG_ESVC_TP_CD			= @[bkg_esvc_tp_cd]" ).append("\n"); 
		query.append("	, BKG_MIN_CGO_WGT			= @[bkg_min_cgo_wgt]" ).append("\n"); 
		query.append("	, BKG_MAX_CGO_WGT			= @[bkg_max_cgo_wgt]" ).append("\n"); 
		query.append("WHERE NOTE_CONV_MAPG_ID	= @[note_conv_mapg_id]" ).append("\n"); 
		query.append("  AND NOTE_CONV_SEQ		= @[note_conv_seq]" ).append("\n"); 

	}
}