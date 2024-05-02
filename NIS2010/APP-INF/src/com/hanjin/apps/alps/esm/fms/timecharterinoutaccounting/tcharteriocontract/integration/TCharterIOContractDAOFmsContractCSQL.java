/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : TCharterIOContractDAOFmsContractCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2018.02.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOContractDAOFmsContractCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 용대선 계약서 생성 업무에서 사용자가 선박,vendor을 선택하고 
	  * 계약 타입(용선, 대선, 사선)을 결정하고, 계약 fact(actual, psudo)를 입력한
	  * 정보를 생성한다. 
	  *  << IT Arch 정윤태 2009/02/10>>
	  * 
	  * 2013.05.24 이영두 [CHM-201324825] Customer Code Logic 변경 및 Agreement Pop up 변경
	  * </pre>
	  */
	public TCharterIOContractDAOFmsContractCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_14ton_vsl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("low_sulp_gas_oil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chtr_prd_opt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dznd_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_foil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nrt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("decl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_gmt_lmt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_doil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_cntr_plg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oa_rsv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("gr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("low_sulp_foil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_fact_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_low_sulp_gas_oil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_low_sulp_gas_oil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddwt_cgo_capa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_low_sulp_foil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_spd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("low_sulp_gas_oil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rde_ntc_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_foil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_olay_comm_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bld_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rde_rng_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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
		params.put("bor_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("oa_rsv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("low_sulp_foil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_brog_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_low_sulp_foil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_doil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOFmsContractCSQL").append("\n"); 
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
		query.append("insert into fms_contract (" ).append("\n"); 
		query.append("	flet_ctrt_no," ).append("\n"); 
		query.append("	vsl_cd," ).append("\n"); 
		query.append("	flet_ctrt_tp_cd," ).append("\n"); 
		query.append("	vndr_seq," ).append("\n"); 
		query.append("	cust_cnt_cd," ).append("\n"); 
		query.append("	cust_seq," ).append("\n"); 
		query.append("	vsl_cnt_cd," ).append("\n"); 
		query.append("	flet_ctrt_fact_cd," ).append("\n"); 
		query.append("	cp_dt," ).append("\n"); 
		query.append("	eff_dt," ).append("\n"); 
		query.append("	exp_dt," ).append("\n"); 
		query.append("    flet_gmt_lmt_cd," ).append("\n"); 
		query.append("	decl_flg," ).append("\n"); 
		query.append("	acmm_rt_amt," ).append("\n"); 
		query.append("	flet_brog_rt_amt," ).append("\n"); 
		query.append("	flet_olay_comm_rt_amt," ).append("\n"); 
		query.append("	oa_rsv_amt," ).append("\n"); 
		query.append("	oa_rsv_curr_cd," ).append("\n"); 
		query.append("	act_foil_bod_qty," ).append("\n"); 
		query.append("	act_doil_bod_qty," ).append("\n"); 
		query.append("	act_foil_bor_qty," ).append("\n"); 
		query.append("	act_doil_bor_qty,                                                         " ).append("\n"); 
		query.append("	foil_bod_out_prc," ).append("\n"); 
		query.append("	doil_bod_out_prc," ).append("\n"); 
		query.append("	foil_bor_out_prc," ).append("\n"); 
		query.append("	doil_bor_out_prc," ).append("\n"); 
		query.append("	bod_port_cd," ).append("\n"); 
		query.append("	bor_port_cd," ).append("\n"); 
		query.append("	vsl_bld_dt," ).append("\n"); 
		query.append("	vsl_dznd_capa," ).append("\n"); 
		query.append("	bse_14ton_vsl_capa," ).append("\n"); 
		query.append("	ddwt_cgo_capa_qty," ).append("\n"); 
		query.append("	grs_wgt," ).append("\n"); 
		query.append("	nrt_wgt," ).append("\n"); 
		query.append("	chtr_prd_opt_ctnt," ).append("\n"); 
		query.append("	rde_rng_ctnt," ).append("\n"); 
		query.append("	rde_ntc_ctnt," ).append("\n"); 
		query.append("	rf_cntr_plg_qty," ).append("\n"); 
		query.append("	gr_flg," ).append("\n"); 
		query.append("	shp_spd_qty," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("	upd_dt," ).append("\n"); 
		query.append("    OWNR_SEQ," ).append("\n"); 
		query.append("    ACT_LOW_SULP_FOIL_BOD_QTY,   " ).append("\n"); 
		query.append("	ACT_LOW_SULP_GAS_OIL_BOD_QTY," ).append("\n"); 
		query.append("	ACT_LOW_SULP_FOIL_BOR_QTY,   " ).append("\n"); 
		query.append("	ACT_LOW_SULP_GAS_OIL_BOR_QTY," ).append("\n"); 
		query.append("	LOW_SULP_FOIL_BOD_OUT_PRC,   " ).append("\n"); 
		query.append("	LOW_SULP_GAS_OIL_BOD_OUT_PRC," ).append("\n"); 
		query.append("	LOW_SULP_FOIL_BOR_OUT_PRC,   " ).append("\n"); 
		query.append("	LOW_SULP_GAS_OIL_BOR_OUT_PRC" ).append("\n"); 
		query.append(") values( " ).append("\n"); 
		query.append("	@[flet_ctrt_no]," ).append("\n"); 
		query.append("	@[vsl_cd]," ).append("\n"); 
		query.append("	@[flet_ctrt_tp_cd]," ).append("\n"); 
		query.append("	decode(@[flet_ctrt_tp_cd],'TO',NULL,@[vndr_seq])," ).append("\n"); 
		query.append("	@[cust_cnt_cd]," ).append("\n"); 
		query.append("	decode(@[flet_ctrt_tp_cd],'TO',@[cust_seq],NULL)," ).append("\n"); 
		query.append("	@[vsl_cnt_cd]," ).append("\n"); 
		query.append("	@[flet_ctrt_fact_cd]," ).append("\n"); 
		query.append("	@[cp_dt]," ).append("\n"); 
		query.append("	to_date(@[eff_dt],'yyyymmddhh24:mi')," ).append("\n"); 
		query.append("	to_date(@[exp_dt],'yyyymmddhh24:mi')," ).append("\n"); 
		query.append("    @[flet_gmt_lmt_cd]," ).append("\n"); 
		query.append("	decode(@[decl_flg],NULL,'N','Y')," ).append("\n"); 
		query.append("	decode(@[acmm_rt_amt],'0',NULL,@[acmm_rt_amt])," ).append("\n"); 
		query.append("	decode(@[flet_brog_rt_amt],'0',NULL,@[flet_brog_rt_amt])," ).append("\n"); 
		query.append("	@[flet_olay_comm_rt_amt]," ).append("\n"); 
		query.append("	@[oa_rsv_amt]," ).append("\n"); 
		query.append("	@[oa_rsv_curr_cd]," ).append("\n"); 
		query.append("	@[act_foil_bod_qty]," ).append("\n"); 
		query.append("	@[act_doil_bod_qty]," ).append("\n"); 
		query.append("	@[act_foil_bor_qty]," ).append("\n"); 
		query.append("	@[act_doil_bor_qty]," ).append("\n"); 
		query.append("	@[foil_bod_out_prc]," ).append("\n"); 
		query.append("	@[doil_bod_out_prc]," ).append("\n"); 
		query.append("	@[foil_bor_out_prc]," ).append("\n"); 
		query.append("	@[doil_bor_out_prc]," ).append("\n"); 
		query.append("	@[bod_port_cd]," ).append("\n"); 
		query.append("	@[bor_port_cd]," ).append("\n"); 
		query.append("	@[vsl_bld_dt]," ).append("\n"); 
		query.append("	@[vsl_dznd_capa]," ).append("\n"); 
		query.append("	@[bse_14ton_vsl_capa]," ).append("\n"); 
		query.append("	@[ddwt_cgo_capa_qty]," ).append("\n"); 
		query.append("	@[grs_wgt]," ).append("\n"); 
		query.append("	@[nrt_wgt]," ).append("\n"); 
		query.append("	@[chtr_prd_opt_ctnt]," ).append("\n"); 
		query.append("	@[rde_rng_ctnt]," ).append("\n"); 
		query.append("	@[rde_ntc_ctnt]," ).append("\n"); 
		query.append("	@[rf_cntr_plg_qty]," ).append("\n"); 
		query.append("	@[gr_flg]," ).append("\n"); 
		query.append("	@[shp_spd_qty]," ).append("\n"); 
		query.append("	@[cre_usr_id]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("    decode(@[ownr_seq], 0, NULL, @[ownr_seq])," ).append("\n"); 
		query.append("	@[act_low_sulp_foil_bod_qty],     " ).append("\n"); 
		query.append("	@[act_low_sulp_gas_oil_bod_qty],  " ).append("\n"); 
		query.append("	@[act_low_sulp_foil_bor_qty],     " ).append("\n"); 
		query.append("	@[act_low_sulp_gas_oil_bor_qty],  " ).append("\n"); 
		query.append("	@[low_sulp_foil_bod_out_prc],     " ).append("\n"); 
		query.append("	@[low_sulp_gas_oil_bod_out_prc],  " ).append("\n"); 
		query.append("	@[low_sulp_foil_bor_out_prc],     " ).append("\n"); 
		query.append("	@[low_sulp_gas_oil_bor_out_prc]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}