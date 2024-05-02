/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CalculateDBDAOPriPrsRoutActCostSimulationCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CalculateDBDAOPriPrsRoutActCostSimulationCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *   Insert
	  * </pre>
	  */
	public CalculateDBDAOPriPrsRoutActCostSimulationCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_dist_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_pol_pod_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nomi_trkr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ut_amt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_dist_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_usd_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ass_bse_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_dist_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_lnk_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_rtn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_fm_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcgo_tz_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_usd_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_grp_tml_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_fm_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_clss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_asgn_calc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_rail_crr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_rail_crr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_trsp_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_calc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_to_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ioc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aft_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_svc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_cs_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_lnk_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_trsp_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_pol_pod_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_estm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("thrp_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_pol_pod_dist",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcgo_tz_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fcgo_tz_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_rail_crr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wtr_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_usd_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inlnd_rout_incl_sttl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_usd_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_auto_cd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_agmt_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcgo_tz_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ra_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("para_to_ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_tz_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("respb_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.calculate.integration").append("\n"); 
		query.append("FileName : CalculateDBDAOPriPrsRoutActCostSimulationCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_PRS_ROUT_ACT_COST (" ).append("\n"); 
		query.append("		ROUT_CS_NO" ).append("\n"); 
		query.append("		, ROUT_CS_CLSS_NO" ).append("\n"); 
		query.append("		, COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("		, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		, COA_COST_SRC_CD" ).append("\n"); 
		query.append("		, STND_COST_CD" ).append("\n"); 
		query.append("		, RA_ACCT_CD" ).append("\n"); 
		query.append("		, COST_UT_AMT_CD" ).append("\n"); 
		query.append("		, COST_SRC_SYS_CD" ).append("\n"); 
		query.append("		, COST_ASS_BSE_CD" ).append("\n"); 
		query.append("		, RAIL_SVC_TP_CD" ).append("\n"); 
		query.append("		, ACT_GRP_CD" ).append("\n"); 
		query.append("		, COST_ACT_GRP_TP_CD" ).append("\n"); 
		query.append("		, VSL_SLAN_CD" ).append("\n"); 
		query.append("		, CTRL_OFC_CD" ).append("\n"); 
		query.append("		, COST_OFC_CD" ).append("\n"); 
		query.append("		, COST_IO_BND_CD" ).append("\n"); 
		query.append("		, N1ST_NOD_CD" ).append("\n"); 
		query.append("		, N1ST_NOD_TP_CD" ).append("\n"); 
		query.append("		, N1ST_ESTM_DT" ).append("\n"); 
		query.append("		, N2ND_NOD_CD" ).append("\n"); 
		query.append("		, N3RD_NOD_CD" ).append("\n"); 
		query.append("		, N4TH_NOD_CD" ).append("\n"); 
		query.append("		, ROUT_TZ_MOD_CD" ).append("\n"); 
		query.append("		, N1ST_POL_POD_DIST" ).append("\n"); 
		query.append("		, N1ST_DIST_UT_CD" ).append("\n"); 
		query.append("		, N2ND_POL_POD_DIST" ).append("\n"); 
		query.append("		, N2ND_DIST_UT_CD" ).append("\n"); 
		query.append("		, N3RD_POL_POD_DIST" ).append("\n"); 
		query.append("		, N3RD_DIST_UT_CD" ).append("\n"); 
		query.append("		, N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("		, N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("		, N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("		, N4TH_VNDR_SEQ" ).append("\n"); 
		query.append("		, CUST_NOMI_TRKR_FLG" ).append("\n"); 
		query.append("		, PRE_NOD_CD" ).append("\n"); 
		query.append("		, PST_NOD_CD" ).append("\n"); 
		query.append("		, PRE_LNK_VNDR_SEQ" ).append("\n"); 
		query.append("		, PST_LNK_VNDR_SEQ" ).append("\n"); 
		query.append("		, FCGO_TZ_DYS" ).append("\n"); 
		query.append("		, FCGO_TZ_HRS" ).append("\n"); 
		query.append("		, MCGO_TZ_DYS" ).append("\n"); 
		query.append("		, MCGO_TZ_HRS" ).append("\n"); 
		query.append("		, CNTR_QTY" ).append("\n"); 
		query.append("		, COST_CATE_CD" ).append("\n"); 
		query.append("		, ESTM_UC_AMT" ).append("\n"); 
		query.append("		, RESPB_UC_AMT" ).append("\n"); 
		query.append("		, LOCL_CURR_CD" ).append("\n"); 
		query.append("		, TRSP_SVC_OFC_CD" ).append("\n"); 
		query.append("		, COST_ASGN_CALC_FLG" ).append("\n"); 
		query.append("		, LGS_COST_CD_CHK_FLG" ).append("\n"); 
		query.append("		, THRP_RT_FLG" ).append("\n"); 
		query.append("		, ACT_GRP_TML_FLG" ).append("\n"); 
		query.append("		, LGS_COST_AUTO_CD_FLG" ).append("\n"); 
		query.append("		, IOC_CD" ).append("\n"); 
		query.append("		, BFR_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, AFT_TRSP_MOD_CD" ).append("\n"); 
		query.append("		, CTRT_RTN_FLG" ).append("\n"); 
		query.append("		, APLY_VNDR_SEQ" ).append("\n"); 
		query.append("		, SCC_CD" ).append("\n"); 
		query.append("		, ECC_CD" ).append("\n"); 
		query.append("		, PARA_FM_SCC_CD" ).append("\n"); 
		query.append("		, PARA_TO_SCC_CD" ).append("\n"); 
		query.append("		, PARA_FM_ECC_CD" ).append("\n"); 
		query.append("		, PARA_TO_ECC_CD" ).append("\n"); 
		query.append("		, N1ST_RAIL_CRR_TP_CD" ).append("\n"); 
		query.append("		, N2ND_RAIL_CRR_TP_CD" ).append("\n"); 
		query.append("		, N3RD_RAIL_CRR_TP_CD" ).append("\n"); 
		query.append("		, ESTM_USD_UC_AMT" ).append("\n"); 
		query.append("		, RESPB_USD_UC_AMT" ).append("\n"); 
		query.append("		, ESTM_USD_TTL_AMT" ).append("\n"); 
		query.append("		, RESPB_USD_TTL_AMT" ).append("\n"); 
		query.append("		, WTR_DE_TERM_CD" ).append("\n"); 
		query.append("		, WTR_RCV_TERM_CD" ).append("\n"); 
		query.append("		, INLND_ROUT_INCL_STTL_FLG" ).append("\n"); 
		query.append("		, N1ST_TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		, N2ND_TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		, N3RD_TRSP_AGMT_SEQ" ).append("\n"); 
		query.append("		, N1ST_TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, N1ST_AGMT_REF_NO" ).append("\n"); 
		query.append("		, N2ND_TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, N2ND_AGMT_REF_NO" ).append("\n"); 
		query.append("		, N3RD_TRSP_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("		, N3RD_AGMT_REF_NO" ).append("\n"); 
		query.append("		, COST_CALC_RMK" ).append("\n"); 
		query.append("		, CRE_USR_ID" ).append("\n"); 
		query.append("		, CRE_DT" ).append("\n"); 
		query.append("		, UPD_USR_ID" ).append("\n"); 
		query.append("		, UPD_DT	" ).append("\n"); 
		query.append("	) VALUES (" ).append("\n"); 
		query.append("		@[rout_cs_no]" ).append("\n"); 
		query.append("		, @[rout_cs_clss_no]" ).append("\n"); 
		query.append("		, @[cost_act_grp_seq]" ).append("\n"); 
		query.append("		, @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("		, @[coa_cost_src_cd]" ).append("\n"); 
		query.append("		, @[stnd_cost_cd]" ).append("\n"); 
		query.append("		, @[ra_acct_cd]" ).append("\n"); 
		query.append("		, @[cost_ut_amt_cd]" ).append("\n"); 
		query.append("		, @[cost_src_sys_cd]" ).append("\n"); 
		query.append("		, @[cost_ass_bse_cd]" ).append("\n"); 
		query.append("		, @[rail_svc_tp_cd]" ).append("\n"); 
		query.append("		, @[act_grp_cd]" ).append("\n"); 
		query.append("		, @[cost_act_grp_tp_cd]" ).append("\n"); 
		query.append("		, @[vsl_slan_cd]" ).append("\n"); 
		query.append("		, @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("		, @[cost_ofc_cd]" ).append("\n"); 
		query.append("		, @[cost_io_bnd_cd]" ).append("\n"); 
		query.append("		, @[n1st_nod_cd]" ).append("\n"); 
		query.append("		, @[n1st_nod_tp_cd]" ).append("\n"); 
		query.append("		, to_date(@[n1st_estm_dt],'yyyymmdd hh:mi:ss')" ).append("\n"); 
		query.append("		, @[n2nd_nod_cd]" ).append("\n"); 
		query.append("		, @[n3rd_nod_cd]" ).append("\n"); 
		query.append("		, @[n4th_nod_cd]" ).append("\n"); 
		query.append("		, @[rout_tz_mod_cd]" ).append("\n"); 
		query.append("		, @[n1st_pol_pod_dist]" ).append("\n"); 
		query.append("		, @[n1st_dist_ut_cd]" ).append("\n"); 
		query.append("		, @[n2nd_pol_pod_dist]" ).append("\n"); 
		query.append("		, @[n2nd_dist_ut_cd]" ).append("\n"); 
		query.append("		, @[n3rd_pol_pod_dist]" ).append("\n"); 
		query.append("		, @[n3rd_dist_ut_cd]" ).append("\n"); 
		query.append("		, @[n1st_vndr_seq]" ).append("\n"); 
		query.append("		, @[n2nd_vndr_seq]" ).append("\n"); 
		query.append("		, @[n3rd_vndr_seq]" ).append("\n"); 
		query.append("		, @[n4th_vndr_seq]" ).append("\n"); 
		query.append("		, @[cust_nomi_trkr_flg]" ).append("\n"); 
		query.append("		, @[pre_nod_cd]" ).append("\n"); 
		query.append("		, @[pst_nod_cd]" ).append("\n"); 
		query.append("		, @[pre_lnk_vndr_seq]" ).append("\n"); 
		query.append("		, @[pst_lnk_vndr_seq]" ).append("\n"); 
		query.append("		, @[fcgo_tz_dys]" ).append("\n"); 
		query.append("		, @[fcgo_tz_hrs]" ).append("\n"); 
		query.append("		, @[mcgo_tz_dys]" ).append("\n"); 
		query.append("		, @[mcgo_tz_hrs]" ).append("\n"); 
		query.append("		, @[cntr_qty]" ).append("\n"); 
		query.append("		, @[cost_cate_cd]" ).append("\n"); 
		query.append("		, @[estm_uc_amt]" ).append("\n"); 
		query.append("		, @[respb_uc_amt]" ).append("\n"); 
		query.append("		, @[locl_curr_cd]" ).append("\n"); 
		query.append("		, @[trsp_svc_ofc_cd]" ).append("\n"); 
		query.append("		, @[cost_asgn_calc_flg]" ).append("\n"); 
		query.append("		, @[lgs_cost_cd_chk_flg]" ).append("\n"); 
		query.append("		, @[thrp_rt_flg]" ).append("\n"); 
		query.append("		, @[act_grp_tml_flg]" ).append("\n"); 
		query.append("		, @[lgs_cost_auto_cd_flg]" ).append("\n"); 
		query.append("		, @[ioc_cd]" ).append("\n"); 
		query.append("		, @[bfr_trsp_mod_cd]" ).append("\n"); 
		query.append("		, @[aft_trsp_mod_cd]" ).append("\n"); 
		query.append("		, @[ctrt_rtn_flg]" ).append("\n"); 
		query.append("		, @[aply_vndr_seq]" ).append("\n"); 
		query.append("		, @[scc_cd]" ).append("\n"); 
		query.append("		, @[ecc_cd]" ).append("\n"); 
		query.append("		, @[para_fm_scc_cd]" ).append("\n"); 
		query.append("		, @[para_to_scc_cd]" ).append("\n"); 
		query.append("		, @[para_fm_ecc_cd]" ).append("\n"); 
		query.append("		, @[para_to_ecc_cd]" ).append("\n"); 
		query.append("		, @[n1st_rail_crr_tp_cd]" ).append("\n"); 
		query.append("		, @[n2nd_rail_crr_tp_cd]" ).append("\n"); 
		query.append("		, @[n3rd_rail_crr_tp_cd]" ).append("\n"); 
		query.append("		, @[estm_usd_uc_amt]" ).append("\n"); 
		query.append("		, @[respb_usd_uc_amt]" ).append("\n"); 
		query.append("		, @[estm_usd_ttl_amt]" ).append("\n"); 
		query.append("		, @[respb_usd_ttl_amt]" ).append("\n"); 
		query.append("		, @[wtr_de_term_cd]" ).append("\n"); 
		query.append("		, @[wtr_rcv_term_cd]" ).append("\n"); 
		query.append("		, @[inlnd_rout_incl_sttl_flg]" ).append("\n"); 
		query.append("		, @[n1st_trsp_agmt_seq]" ).append("\n"); 
		query.append("		, @[n2nd_trsp_agmt_seq]" ).append("\n"); 
		query.append("		, @[n3rd_trsp_agmt_seq]" ).append("\n"); 
		query.append("		, @[n1st_trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("		, @[n1st_agmt_ref_no]" ).append("\n"); 
		query.append("		, @[n2nd_trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("		, @[n2nd_agmt_ref_no]" ).append("\n"); 
		query.append("		, @[n3rd_trsp_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("		, @[n3rd_agmt_ref_no]" ).append("\n"); 
		query.append("		, @[cost_calc_rmk]" ).append("\n"); 
		query.append("		, 'CALC'" ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("		, 'CALC'" ).append("\n"); 
		query.append("		, SYSDATE" ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}