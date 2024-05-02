/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TCharterIOContractDAOFmsContractUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.13
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.13 
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

public class TCharterIOContractDAOFmsContractUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TCharterIOContractDAOFmsContractUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rde_ntc_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("decl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("low_sulp_gas_oil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rde_rng_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_foil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("foil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ddwt_cgo_capa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("low_sulp_foil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bor_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_doil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_low_sulp_foil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_olay_comm_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_bld_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_fact_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shp_spd_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oa_rsv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_doc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("low_sulp_gas_oil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_low_sulp_foil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nrt_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flet_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_brog_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_gmt_lmt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("low_sulp_foil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_doc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acmm_rt_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_doil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOContractDAOFmsContractUSQL").append("\n"); 
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
		query.append("UPDATE FMS_CONTRACT SET " ).append("\n"); 
		query.append("	   VSL_CD = @[vsl_cd]," ).append("\n"); 
		query.append("	   FLET_CTRT_TP_CD = @[flet_ctrt_tp_cd]," ).append("\n"); 
		query.append("	   VNDR_SEQ = @[vndr_seq]," ).append("\n"); 
		query.append("	   CUST_CNT_CD = DECODE(@[flet_ctrt_tp_cd],'TO', @[cust_cnt_cd], CUST_CNT_CD)," ).append("\n"); 
		query.append("	   CUST_SEQ = DECODE(@[flet_ctrt_tp_cd],'TO',@[cust_seq], CUST_SEQ)," ).append("\n"); 
		query.append("	   VSL_CNT_CD = @[vsl_cnt_cd]," ).append("\n"); 
		query.append("	   FLET_CTRT_FACT_CD = @[flet_ctrt_fact_cd]," ).append("\n"); 
		query.append("	   CP_DT = @[cp_dt]," ).append("\n"); 
		query.append("	   EFF_DT = TO_DATE(@[eff_dt],'YYYYMMDDHH24:MI')," ).append("\n"); 
		query.append("	   EXP_DT = TO_DATE(@[exp_dt],'YYYYMMDDHH24:MI')," ).append("\n"); 
		query.append("	   DECL_FLG = DECODE(@[decl_flg],NULL,'N','Y')," ).append("\n"); 
		query.append("	   ACMM_RT_AMT = DECODE(@[acmm_rt_amt],'0',NULL,@[acmm_rt_amt])," ).append("\n"); 
		query.append("	   FLET_BROG_RT_AMT = DECODE(@[flet_brog_rt_amt],'0',NULL,@[flet_brog_rt_amt])," ).append("\n"); 
		query.append("	   FLET_OLAY_COMM_RT_AMT = @[flet_olay_comm_rt_amt]," ).append("\n"); 
		query.append("	   OA_RSV_AMT = @[oa_rsv_amt]," ).append("\n"); 
		query.append("	   OA_RSV_CURR_CD = @[oa_rsv_curr_cd]," ).append("\n"); 
		query.append("	   ACT_FOIL_BOD_QTY = @[act_foil_bod_qty]," ).append("\n"); 
		query.append("	   ACT_DOIL_BOD_QTY = @[act_doil_bod_qty]," ).append("\n"); 
		query.append("	   ACT_FOIL_BOR_QTY = @[act_foil_bor_qty]," ).append("\n"); 
		query.append("	   ACT_DOIL_BOR_QTY = @[act_doil_bor_qty]," ).append("\n"); 
		query.append("	   FOIL_BOD_OUT_PRC = @[foil_bod_out_prc]," ).append("\n"); 
		query.append("	   DOIL_BOD_OUT_PRC = @[doil_bod_out_prc]," ).append("\n"); 
		query.append("	   FOIL_BOR_OUT_PRC = @[foil_bor_out_prc]," ).append("\n"); 
		query.append("	   DOIL_BOR_OUT_PRC = @[doil_bor_out_prc]," ).append("\n"); 
		query.append("	   VSL_BLD_DT = @[vsl_bld_dt]," ).append("\n"); 
		query.append("	   VSL_DZND_CAPA = @[vsl_dznd_capa]," ).append("\n"); 
		query.append("	   BSE_14TON_VSL_CAPA = @[bse_14ton_vsl_capa]," ).append("\n"); 
		query.append("	   DDWT_CGO_CAPA_QTY = @[ddwt_cgo_capa_qty]," ).append("\n"); 
		query.append("	   GRS_WGT = @[grs_wgt]," ).append("\n"); 
		query.append("	   NRT_WGT = @[nrt_wgt]," ).append("\n"); 
		query.append("	   CHTR_PRD_OPT_CTNT = @[chtr_prd_opt_ctnt]," ).append("\n"); 
		query.append("	   RDE_RNG_CTNT = @[rde_rng_ctnt]," ).append("\n"); 
		query.append("	   RDE_NTC_CTNT = @[rde_ntc_ctnt]," ).append("\n"); 
		query.append("	   RF_CNTR_PLG_QTY = @[rf_cntr_plg_qty]," ).append("\n"); 
		query.append("	   GR_FLG = @[gr_flg]," ).append("\n"); 
		query.append("	   SHP_SPD_QTY = @[shp_spd_qty]," ).append("\n"); 
		query.append("	   FLET_GMT_LMT_CD = @[flet_gmt_lmt_cd]," ).append("\n"); 
		query.append("	   BOD_PORT_CD = @[bod_port_cd]," ).append("\n"); 
		query.append("       BOR_PORT_CD = @[bor_port_cd]," ).append("\n"); 
		query.append("	   UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT = SYSDATE," ).append("\n"); 
		query.append("       OWNR_SEQ = DECODE(@[ownr_seq], 0, NULL, @[ownr_seq])," ).append("\n"); 
		query.append("	   AGMT_DOC_NO = @[agmt_doc_no]," ).append("\n"); 
		query.append("       AGMT_DOC_DESC = 	@[agmt_doc_desc]," ).append("\n"); 
		query.append("	   ACT_LOW_SULP_FOIL_BOD_QTY = @[act_low_sulp_foil_bod_qty]," ).append("\n"); 
		query.append("       ACT_LOW_SULP_GAS_OIL_BOD_QTY = @[act_low_sulp_gas_oil_bod_qty]," ).append("\n"); 
		query.append("       ACT_LOW_SULP_FOIL_BOR_QTY = @[act_low_sulp_foil_bor_qty]," ).append("\n"); 
		query.append("       ACT_LOW_SULP_GAS_OIL_BOR_QTY = @[act_low_sulp_gas_oil_bor_qty]," ).append("\n"); 
		query.append("       LOW_SULP_FOIL_BOD_OUT_PRC = @[low_sulp_foil_bod_out_prc]," ).append("\n"); 
		query.append("       LOW_SULP_GAS_OIL_BOD_OUT_PRC = @[low_sulp_gas_oil_bod_out_prc]," ).append("\n"); 
		query.append("       LOW_SULP_FOIL_BOR_OUT_PRC = @[low_sulp_foil_bor_out_prc]," ).append("\n"); 
		query.append("       LOW_SULP_GAS_OIL_BOR_OUT_PRC = @[low_sulp_gas_oil_bor_out_prc]" ).append("\n"); 
		query.append(" WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 

	}
}