/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmYardDBDAOMdmYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 김준호
*@LastVersion : 1.0
* 2010.02.24 김준호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jun-Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmYardDBDAOMdmYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MdmYard
	  * </pre>
	  */
	public ReceiveQueueMdmYardDBDAOMdmYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmYardDBDAOMdmYardRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("dry_avg_dwll_hrs	   ,dry_min_dwll_hrs	   ,dry_yd_ft_hrs		   ," ).append("\n"); 
		query.append("rf_avg_dwll_hrs		   ,rf_min_dwll_hrs		   ,rf_yd_ft_hrs		   ," ).append("\n"); 
		query.append("yd_locl_lang_nm		   ,yd_locl_lang_addr	   ," ).append("\n"); 
		query.append("yd_cd                  ,yd_nm                  ,loc_cd                 ," ).append("\n"); 
		query.append("n1st_vndr_cnt_cd       ,n1st_vndr_seq          ,n2nd_vndr_cnt_cd       ," ).append("\n"); 
		query.append("n2nd_vndr_seq          ,n3rd_vndr_cnt_cd       ,n3rd_vndr_seq          ," ).append("\n"); 
		query.append("ofc_cd                 ," ).append("\n"); 
		query.append("yd_chr_cd              ,yd_fcty_tp_mrn_tml_flg ,yd_fcty_tp_cy_flg      ," ).append("\n"); 
		query.append("yd_fcty_tp_cfs_flg     ,yd_fcty_tp_rail_rmp_flg,yd_oshp_cd             ," ).append("\n"); 
		query.append("bd_yd_flg              ,onf_hir_yd_flg         ," ).append("\n"); 
		query.append("rep_zn_cd              ,yd_addr                ,zip_cd                 ," ).append("\n"); 
		query.append("intl_phn_no            ,phn_no                 ,fax_no                 ," ).append("\n"); 
		query.append("yd_pic_nm              ,yd_ceo_nm              ,gate_opn_hrmnt         ," ).append("\n"); 
		query.append("gate_clz_hrmnt         ,hol_gate_opn_hrmnt     ,hol_gate_clz_hrmnt     ," ).append("\n"); 
		query.append("sun_gate_opn_hrmnt     ,sun_gate_clz_hrmnt     ,sat_gate_opn_hrmnt     ," ).append("\n"); 
		query.append("sat_gate_clz_hrmnt     ,yd_cgo_clz_hrmnt_msg   ,yd_rmk                 ," ).append("\n"); 
		query.append("brth_no                ,yd_brth_len            ,yd_brth_alng_sd_desc   ," ).append("\n"); 
		query.append("yd_brth_dpth_chnl_knt  ,yd_ttl_spc             ,yd_act_spc             ," ).append("\n"); 
		query.append("yd_hjs_spc             ,yd_hndl_capa           ,yd_rf_rcpt_440v_knt    ," ).append("\n"); 
		query.append("yd_rf_rcpt_220v_knt    ,yd_rf_rcpt_dul_knt     ,yd_op_sys_cd           ," ).append("\n"); 
		query.append("yd_inrl_flg            ,yd_cfs_spc             ,mnr_shop_flg           ," ).append("\n"); 
		query.append("yd_hndl_yr             ,yd_ttl_vol_teu_knt     ,yd_ttl_vol_bx_knt      ," ).append("\n"); 
		query.append("yd_hjs_vol_teu_knt     ,yd_hjs_vol_bx_knt      ,yd_pst_pgc_knt         ," ).append("\n"); 
		query.append("yd_pgc_knt             ,trstr_knt              ,frk_knt                ," ).append("\n"); 
		query.append("yd_strdl_crr_knt       ,yd_trct_knt            ,yd_top_lft_knt         ," ).append("\n"); 
		query.append("tml_chss_knt           ,eir_svc_flg            ,tml_prod_knt           ," ).append("\n"); 
		query.append("yd_cstms_no            ,yd_fcty_tp_psdo_yd_flg ,yd_eml                 ," ).append("\n"); 
		query.append("dem_ib_clt_flg         ,dem_ob_clt_flg         ,bkg_pod_yd_flg         ," ).append("\n"); 
		query.append("yd_fcty_tp_brg_rmp_flg ,bfr_ofc_cd             ,bfr_ofc_cng_dt         ," ).append("\n"); 
		query.append("modi_yd_cd             ,dmdt_ofc_cd            ,cre_usr_id             ," ).append("\n"); 
		query.append("cre_dt                 ,upd_usr_id             ,upd_dt                 ," ).append("\n"); 
		query.append("delt_flg               ,rep_yd_tp_cd           ,HUB_YD_FLG	       ," ).append("\n"); 
		query.append("eai_evnt_dt            ,yd_locl_lang_nm        ,yd_locl_lang_addr  ," ).append("\n"); 
		query.append("dry_avg_dwll_hrs       ,dry_min_dwll_hrs       ,dry_yd_ft_hrs" ).append("\n"); 
		query.append("from mdm_yard" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("rownum  = 1" ).append("\n"); 

	}
}