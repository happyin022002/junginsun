/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiOndockRailChargeInvoiceDetailInsert
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailInsertCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_cgst_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_tr_vol_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_pay_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fp_calc_prd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_gst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("semi_auto_calc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_igst_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_cgst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fp_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_cost_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_igst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_sgst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_ugst_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_tr_vol_val",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ovr_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stay_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vol_tr_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_ugst_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("min_wrk_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_sgst_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stk_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvis_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_vol_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("calc_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_gst_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_wrk_dy_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("free_dys",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOMultiOndockRailChargeInvoiceDetailInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_TML_SO_DTL" ).append("\n"); 
		query.append("				(TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("				,TML_SO_SEQ" ).append("\n"); 
		query.append("				,TML_SO_DTL_SEQ" ).append("\n"); 
		query.append("				,CALC_COST_GRP_CD" ).append("\n"); 
		query.append("				,CALC_TP_CD" ).append("\n"); 
		query.append("				,VSL_CD" ).append("\n"); 
		query.append("				,SKD_VOY_NO" ).append("\n"); 
		query.append("				,SKD_DIR_CD" ).append("\n"); 
		query.append("				,FINC_VSL_CD" ).append("\n"); 
		query.append("				,FINC_SKD_VOY_NO" ).append("\n"); 
		query.append("				,FINC_SKD_DIR_CD" ).append("\n"); 
		query.append("				,IOC_CD" ).append("\n"); 
		query.append("				,LANE_CD" ).append("\n"); 
		query.append("				,IO_BND_CD" ).append("\n"); 
		query.append("				,LGS_COST_CD" ).append("\n"); 
		query.append("				,ACCT_CD" ).append("\n"); 
		query.append("				,ATB_DT" ).append("\n"); 
		query.append("				,CNTR_NO" ).append("\n"); 
		query.append("				,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,CALC_VOL_QTY" ).append("\n"); 
		query.append("				,FM_TR_VOL_VAL" ).append("\n"); 
		query.append("				,TO_TR_VOL_VAL" ).append("\n"); 
		query.append("				,RVIS_VOL_QTY" ).append("\n"); 
		query.append("				,DCGO_IND_CD" ).append("\n"); 
		query.append("				,STAY_DYS" ).append("\n"); 
		query.append("				,FREE_DYS" ).append("\n"); 
		query.append("				,OVR_DYS" ).append("\n"); 
		query.append("				,TML_WRK_DY_CD" ).append("\n"); 
		query.append("				,FP_CALC_PRD_CD" ).append("\n"); 
		query.append("				,WRK_DT" ).append("\n"); 
		query.append("				,STK_VOL_QTY" ).append("\n"); 
		query.append("				,FP_TEU_QTY" ).append("\n"); 
		query.append("				,INV_VOL_QTY" ).append("\n"); 
		query.append("				,DIFF_VOL_QTY" ).append("\n"); 
		query.append("				,OVR_VOL_QTY" ).append("\n"); 
		query.append("				,VOL_TR_UT_CD" ).append("\n"); 
		query.append("				,CTRT_RT" ).append("\n"); 
		query.append("				,REF_VNDR_SEQ" ).append("\n"); 
		query.append("				,CALC_AMT" ).append("\n"); 
		query.append("				,INV_AMT" ).append("\n"); 
		query.append("				,TML_CRR_CD" ).append("\n"); 
		query.append("				,TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("				,TML_AGMT_SEQ" ).append("\n"); 
		query.append("				,TML_AGMT_VER_NO" ).append("\n"); 
		query.append("				,CALC_RMK" ).append("\n"); 
		query.append("				,N3PTY_FLG" ).append("\n"); 
		query.append("				,CURR_CD" ).append("\n"); 
		query.append("				,INV_XCH_RT" ).append("\n"); 
		query.append("				,CRE_USR_ID" ).append("\n"); 
		query.append("				,CRE_DT" ).append("\n"); 
		query.append("				,LOCL_CRE_DT" ).append("\n"); 
		query.append("				,UPD_USR_ID" ).append("\n"); 
		query.append("				,UPD_DT" ).append("\n"); 
		query.append("				,LOCL_UPD_DT" ).append("\n"); 
		query.append("				,SEMI_AUTO_CALC_FLG" ).append("\n"); 
		query.append("				,IDA_SAC_CD   --india" ).append("\n"); 
		query.append("				,IDA_PAY_TP_CD" ).append("\n"); 
		query.append("				,IDA_CGST_RTO " ).append("\n"); 
		query.append("				,IDA_CGST_AMT " ).append("\n"); 
		query.append("				,IDA_SGST_RTO " ).append("\n"); 
		query.append("				,IDA_SGST_AMT " ).append("\n"); 
		query.append("				,IDA_IGST_RTO " ).append("\n"); 
		query.append("				,IDA_IGST_AMT " ).append("\n"); 
		query.append("				,IDA_UGST_RTO " ).append("\n"); 
		query.append("				,IDA_UGST_AMT " ).append("\n"); 
		query.append("				,IDA_GST_RTO  " ).append("\n"); 
		query.append("				,IDA_GST_AMT  " ).append("\n"); 
		query.append("				)VALUES" ).append("\n"); 
		query.append("				( @[tml_so_ofc_cty_cd] 			-- tml_so_ofc_cty_cd" ).append("\n"); 
		query.append("				, @[tml_so_seq] 				-- tml_so_seq" ).append("\n"); 
		query.append("				, @[tml_so_dtl_seq] 			-- tml_so_dtl_seq" ).append("\n"); 
		query.append("				, @[calc_cost_grp_cd] 			-- calc_cost_grp_cd" ).append("\n"); 
		query.append("				, @[calc_tp_cd] 				-- calc_tp_cd" ).append("\n"); 
		query.append("				, @[vsl_cd] 					-- vsl_cd" ).append("\n"); 
		query.append("				, @[skd_voy_no] 				-- skd_voy_no" ).append("\n"); 
		query.append("				, @[skd_dir_cd] 				-- skd_dir_cd" ).append("\n"); 
		query.append("				, @[finc_vsl_cd] 				-- finc_vsl_cd" ).append("\n"); 
		query.append("				, @[finc_skd_voy_no] 			-- finc_skd_voy_no" ).append("\n"); 
		query.append("				, @[finc_skd_dir_cd] 			-- finc_skd_dir_cd" ).append("\n"); 
		query.append("				, @[ioc_cd] 					-- ioc_cd" ).append("\n"); 
		query.append("				, @[lane_cd] 					-- lane_cd" ).append("\n"); 
		query.append("				, @[io_bnd_cd] 					-- io_bnd_cd" ).append("\n"); 
		query.append("				, @[lgs_cost_cd] 				-- lgs_cost_cd" ).append("\n"); 
		query.append("				, @[acct_cd] 					-- acct_cd" ).append("\n"); 
		query.append("--2007.01.31 - ATB_DT는 DATE Type임. Date Type으로 들어가야 할 데이타인데 SUBSTR(REPLACE([],'-'),0,8)함수 처리만 되어있음." ).append("\n"); 
		query.append("--			   Date Type으로 맞춰주기 위해 TO_DATE 사용" ).append("\n"); 
		query.append("				,TO_DATE(SUBSTR(REPLACE(@[atb_dt],'-'),0,8),'YYYYMMDD') -- ATB_DT" ).append("\n"); 
		query.append("--		 				,SUBSTR(REPLACE([],'-'),0,8) -- ATB_DT" ).append("\n"); 
		query.append("				, @[cntr_no] 			-- cntr_no" ).append("\n"); 
		query.append("				, @[cntr_tpsz_cd] 			-- cntr_tpsz_cd" ).append("\n"); 
		query.append("				, @[calc_vol_qty] 			-- calc_vol_qty" ).append("\n"); 
		query.append("				, @[fm_tr_vol_val] 			-- fm_tr_vol_val" ).append("\n"); 
		query.append("				, @[to_tr_vol_val] 			-- to_tr_vol_val" ).append("\n"); 
		query.append("				, @[rvis_vol_qty] 			-- rvis_vol_qty" ).append("\n"); 
		query.append("				, @[dcgo_ind_cd] 			-- dcgo_ind_cd" ).append("\n"); 
		query.append("				, @[stay_dys] 			-- stay_dys" ).append("\n"); 
		query.append("				, @[free_dys] 			-- free_dys" ).append("\n"); 
		query.append("				, @[ovr_dys] 			-- ovr_dys" ).append("\n"); 
		query.append("				, @[tml_wrk_dy_cd] 			-- tml_wrk_dy_cd" ).append("\n"); 
		query.append("				, @[fp_calc_prd_cd] 			-- fp_calc_prd_cd" ).append("\n"); 
		query.append("--2007.01.31 sheet에서는 YYYYMMDD형식의 데이타만 넘어오기 때문에 SUBSTR(REPLACE([],'-'),0,8)가 필요 없다." ).append("\n"); 
		query.append("--null값에 대해 SUBSTR(REPLACE([],'-'),0,8)함수 수행시 오류발생하기 때문에 삭제함" ).append("\n"); 
		query.append("--		 				,SUBSTR(REPLACE([],'-'),0,8) -- WRK_DT" ).append("\n"); 
		query.append("				, @[wrk_dt]			-- wrk_dt" ).append("\n"); 
		query.append("				, @[stk_vol_qty] 			-- stk_vol_qty" ).append("\n"); 
		query.append("				, @[fp_teu_qty] 			-- fp_teu_qty" ).append("\n"); 
		query.append("				, @[inv_vol_qty] 			-- inv_vol_qty" ).append("\n"); 
		query.append("				, @[diff_vol_qty] 			-- diff_vol_qty" ).append("\n"); 
		query.append("				, @[ovr_vol_qty] 			-- ovr_vol_qty" ).append("\n"); 
		query.append("				, @[vol_tr_ut_cd] 			-- vol_tr_ut_cd" ).append("\n"); 
		query.append("				, @[ctrt_rt] 				-- ctrt_rt" ).append("\n"); 
		query.append("				, @[ref_vndr_seq] 			-- ref_vndr_seq" ).append("\n"); 
		query.append("				, @[calc_amt] 				-- calc_amt" ).append("\n"); 
		query.append("				, @[inv_amt] 				-- inv_amt" ).append("\n"); 
		query.append("				, @[tml_crr_cd] 			-- tml_crr_cd" ).append("\n"); 
		query.append("				-- CHM-201433039 TES CSR IF의 AGMNT LINK에 대해 Link되어있는 모든 계약서 load (4347-11-27)" ).append("\n"); 
		query.append("				, CASE	WHEN @[calc_tp_cd] = 'M' AND NVL(@[semi_auto_calc_flg], 'N') != 'Y' " ).append("\n"); 
		query.append("							THEN TES_GET_AGMT_VER_FNC(@[yd_cd], @[vndr_seq], @[min_wrk_dt], @[max_wrk_dt], 'A') 		-- tml_agmt_ofc_cty_cd" ).append("\n"); 
		query.append("							ELSE @[tml_agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("				  END" ).append("\n"); 
		query.append("				, CASE	WHEN @[calc_tp_cd] = 'M' AND NVL(@[semi_auto_calc_flg], 'N') != 'Y' " ).append("\n"); 
		query.append("							THEN TES_GET_AGMT_VER_FNC(@[yd_cd], @[vndr_seq], @[min_wrk_dt], @[max_wrk_dt], 'B') 		-- tml_agmt_seq" ).append("\n"); 
		query.append("							ELSE @[tml_agmt_seq]" ).append("\n"); 
		query.append("				  END" ).append("\n"); 
		query.append("				, CASE	WHEN @[calc_tp_cd] = 'M' AND NVL(@[semi_auto_calc_flg], 'N') != 'Y' " ).append("\n"); 
		query.append("							THEN TES_GET_AGMT_VER_FNC(@[yd_cd], @[vndr_seq], @[min_wrk_dt], @[max_wrk_dt], 'C') 		-- tml_agmt_ver_no" ).append("\n"); 
		query.append("							ELSE @[tml_agmt_ver_no]" ).append("\n"); 
		query.append("				  END" ).append("\n"); 
		query.append("				, @[calc_rmk] 				-- calc_rmk" ).append("\n"); 
		query.append("				, @[n3pty_flg] 				-- n3pty_flg" ).append("\n"); 
		query.append("				, @[curr_cd] 				-- curr_cd" ).append("\n"); 
		query.append("				, @[inv_xch_rt] 			-- inv_xch_rt" ).append("\n"); 
		query.append("				, @[cre_usr_id] 			-- cre_usr_id" ).append("\n"); 
		query.append("				, SYSDATE" ).append("\n"); 
		query.append("				, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_cre_dt])" ).append("\n"); 
		query.append("				, @[upd_usr_id] 			-- UPD_USR_ID" ).append("\n"); 
		query.append("				, SYSDATE" ).append("\n"); 
		query.append("				, GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[locl_upd_dt])" ).append("\n"); 
		query.append("     			, @[semi_auto_calc_flg]" ).append("\n"); 
		query.append("				, @[ida_sac_cd]" ).append("\n"); 
		query.append("				, @[ida_pay_tp_cd]" ).append("\n"); 
		query.append("				, @[ida_cgst_rto]" ).append("\n"); 
		query.append("				, @[ida_cgst_amt]" ).append("\n"); 
		query.append("				, @[ida_sgst_rto]" ).append("\n"); 
		query.append("				, @[ida_sgst_amt]" ).append("\n"); 
		query.append("				, @[ida_igst_rto]" ).append("\n"); 
		query.append("				, @[ida_igst_amt]" ).append("\n"); 
		query.append("				, @[ida_ugst_rto]" ).append("\n"); 
		query.append("				, @[ida_ugst_amt]" ).append("\n"); 
		query.append("				, @[ida_gst_rto]" ).append("\n"); 
		query.append("				, @[ida_gst_amt]" ).append("\n"); 
		query.append("				)" ).append("\n"); 

	}
}