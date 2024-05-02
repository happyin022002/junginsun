/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmYardDBDAOAddMdmYardCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 이상용
*@LastVersion : 1.0
* 2010.10.12 이상용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SangYong Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmYardDBDAOAddMdmYardCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddMdmYard
	  * 2010.10.11 이상용 [CHM-201006405-01] MDM_YARD 데이터 생성시  RF_AVG_DWLL_HRS, RF_MIN_DWLL_HRS, DRY_AVG_DWLL_HRS, DRY_MIN_DWLL_HRS 컬럼의  Default 값 설정(6,3,6,3)
	  * </pre>
	  */
	public ReceiveQueueMdmYardDBDAOAddMdmYardCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("onf_hir_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_ceo_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_prod_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hol_gate_clz_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_hjs_spc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_hndl_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_ttl_vol_teu_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sun_gate_opn_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_clz_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_rf_rcpt_440v_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_hndl_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_rf_rcpt_dul_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_top_lft_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hol_gate_opn_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("zip_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_hjs_vol_teu_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_trct_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_opn_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_locl_lang_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brth_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sat_gate_clz_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_psdo_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dry_yd_ft_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_rail_rmp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_oshp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cstms_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eir_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_pic_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_brg_rmp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_chss_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bfr_ofc_cng_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_ttl_vol_bx_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_zn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trstr_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cgo_clz_hrmnt_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_pgc_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_yd_ft_hrs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_brth_dpth_chnl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_cfs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_inrl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_ib_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sun_gate_clz_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_brth_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_chr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_cy_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_brth_alng_sd_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cfs_spc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_pst_pgc_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frk_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_strdl_crr_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sat_gate_opn_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_op_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_rf_rcpt_220v_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_fcty_tp_mrn_tml_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_hjs_vol_bx_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_act_spc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bfr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_shop_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dem_ob_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_ttl_spc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmYardDBDAOAddMdmYardCSQL").append("\n"); 
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
		query.append("INSERT INTO mdm_yard (" ).append("\n"); 
		query.append("				rf_yd_ft_hrs		   ," ).append("\n"); 
		query.append("				yd_cd                  ,yd_nm                  ,loc_cd                 ,	" ).append("\n"); 
		query.append("			 	n1st_vndr_cnt_cd       ,n1st_vndr_seq          ,n2nd_vndr_cnt_cd       ,	" ).append("\n"); 
		query.append("			 	n2nd_vndr_seq          ,n3rd_vndr_cnt_cd       ,n3rd_vndr_seq          ,	" ).append("\n"); 
		query.append("			 	ofc_cd                 ,													" ).append("\n"); 
		query.append("			 	yd_chr_cd              ,yd_fcty_tp_mrn_tml_flg ,yd_fcty_tp_cy_flg      ,	" ).append("\n"); 
		query.append("			 	yd_fcty_tp_cfs_flg     ,yd_fcty_tp_rail_rmp_flg,yd_oshp_cd             ,	" ).append("\n"); 
		query.append("			 	bd_yd_flg              ,onf_hir_yd_flg         ,	" ).append("\n"); 
		query.append("			 	rep_zn_cd              ,yd_addr                ,zip_cd                 ,	" ).append("\n"); 
		query.append("			 	intl_phn_no            ,phn_no                 ,fax_no                 ,	" ).append("\n"); 
		query.append("			 	yd_pic_nm              ,yd_ceo_nm              ,gate_opn_hrmnt         ,	" ).append("\n"); 
		query.append("			 	gate_clz_hrmnt         ,hol_gate_opn_hrmnt     ,hol_gate_clz_hrmnt     ,	" ).append("\n"); 
		query.append("			 	sun_gate_opn_hrmnt     ,sun_gate_clz_hrmnt     ,sat_gate_opn_hrmnt     ,	" ).append("\n"); 
		query.append("			 	sat_gate_clz_hrmnt     ,yd_cgo_clz_hrmnt_msg   ,yd_rmk                 ,	" ).append("\n"); 
		query.append("			 	brth_no                ,yd_brth_len            ,yd_brth_alng_sd_desc   ,	" ).append("\n"); 
		query.append("			 	yd_brth_dpth_chnl_knt  ,yd_ttl_spc             ,yd_act_spc             ,	" ).append("\n"); 
		query.append("			 	yd_hjs_spc             ,yd_hndl_capa           ,yd_rf_rcpt_440v_knt    ,	" ).append("\n"); 
		query.append("			 	yd_rf_rcpt_220v_knt    ,yd_rf_rcpt_dul_knt     ,yd_op_sys_cd           ,	" ).append("\n"); 
		query.append("			 	yd_inrl_flg            ,yd_cfs_spc             ,mnr_shop_flg           ,	" ).append("\n"); 
		query.append("			 	yd_hndl_yr             ,yd_ttl_vol_teu_knt     ,yd_ttl_vol_bx_knt      ,	" ).append("\n"); 
		query.append("			 	yd_hjs_vol_teu_knt     ,yd_hjs_vol_bx_knt      ,yd_pst_pgc_knt         ,	" ).append("\n"); 
		query.append("			 	yd_pgc_knt             ,trstr_knt              ,frk_knt                ,	" ).append("\n"); 
		query.append("			 	yd_strdl_crr_knt       ,yd_trct_knt            ,yd_top_lft_knt         ,	" ).append("\n"); 
		query.append("			 	tml_chss_knt           ,eir_svc_flg            ,tml_prod_knt           ,	" ).append("\n"); 
		query.append("			 	yd_cstms_no            ,yd_fcty_tp_psdo_yd_flg ,yd_eml                 ,	" ).append("\n"); 
		query.append("			 	dem_ib_clt_flg         ,dem_ob_clt_flg         ,bkg_pod_yd_flg         ,	" ).append("\n"); 
		query.append("			 	yd_fcty_tp_brg_rmp_flg ,bfr_ofc_cd             ,bfr_ofc_cng_dt         ,	" ).append("\n"); 
		query.append("			 	modi_yd_cd             ,dmdt_ofc_cd            ,cre_usr_id             ,	" ).append("\n"); 
		query.append("			 	cre_dt                 ,upd_usr_id             ,upd_dt                 ,	" ).append("\n"); 
		query.append("			 	delt_flg               ,rep_yd_tp_cd           ,HUB_YD_FLG			   ,   	 " ).append("\n"); 
		query.append("			 	eai_evnt_dt            ,yd_locl_lang_nm        ,yd_locl_lang_addr 	   ," ).append("\n"); 
		query.append("			    dry_avg_dwll_hrs       ,dry_min_dwll_hrs       ,dry_yd_ft_hrs		   ," ).append("\n"); 
		query.append("			    RF_AVG_DWLL_HRS        ,RF_MIN_DWLL_HRS        ,eai_if_id								" ).append("\n"); 
		query.append("			  )                                                                  			" ).append("\n"); 
		query.append("			  VALUES  (																		" ).append("\n"); 
		query.append("			    @[rf_yd_ft_hrs] " ).append("\n"); 
		query.append("			   ,@[yd_cd] ,@[yd_nm] ,@[loc_cd] ,@[n1st_vndr_cnt_cd] ,@[n1st_vndr_seq] ,@[n2nd_vndr_cnt_cd] ,@[n2nd_vndr_seq] ,@[n3rd_vndr_cnt_cd] ,@[n3rd_vndr_seq] ,@[ofc_cd] " ).append("\n"); 
		query.append("			   ,@[yd_chr_cd] ,@[yd_fcty_tp_mrn_tml_flg] ,@[yd_fcty_tp_cy_flg] ,@[yd_fcty_tp_cfs_flg] ,@[yd_fcty_tp_rail_rmp_flg] ,@[yd_oshp_cd] ,@[bd_yd_flg] ,@[onf_hir_yd_flg] ,@[rep_zn_cd] ,@[yd_addr] " ).append("\n"); 
		query.append("			   ,@[zip_cd] ,@[intl_phn_no] ,@[phn_no] ,@[fax_no] ,@[yd_pic_nm] ,@[yd_ceo_nm] ,@[gate_opn_hrmnt] ,@[gate_clz_hrmnt] ,@[hol_gate_opn_hrmnt] ,@[hol_gate_clz_hrmnt] " ).append("\n"); 
		query.append("			   ,@[sun_gate_opn_hrmnt] ,@[sun_gate_clz_hrmnt] ,@[sat_gate_opn_hrmnt] ,@[sat_gate_clz_hrmnt] ,@[yd_cgo_clz_hrmnt_msg] ,@[yd_rmk] ,@[brth_no] ,@[yd_brth_len] ,@[yd_brth_alng_sd_desc] ,@[yd_brth_dpth_chnl_knt] " ).append("\n"); 
		query.append("			   ,@[yd_ttl_spc] ,@[yd_act_spc] ,@[yd_hjs_spc] ,@[yd_hndl_capa] ,@[yd_rf_rcpt_440v_knt] ,@[yd_rf_rcpt_220v_knt] ,@[yd_rf_rcpt_dul_knt] ,@[yd_op_sys_cd] ,@[yd_inrl_flg] ,@[yd_cfs_spc] " ).append("\n"); 
		query.append("			   ,@[mnr_shop_flg] ,@[yd_hndl_yr] ,@[yd_ttl_vol_teu_knt] ,@[yd_ttl_vol_bx_knt] ,@[yd_hjs_vol_teu_knt] ,@[yd_hjs_vol_bx_knt] ,@[yd_pst_pgc_knt] ,@[yd_pgc_knt] ,@[trstr_knt] ,@[frk_knt] " ).append("\n"); 
		query.append("			   ,@[yd_strdl_crr_knt] ,@[yd_trct_knt] ,@[yd_top_lft_knt] ,@[tml_chss_knt] ,@[eir_svc_flg] ,@[tml_prod_knt] ,@[yd_cstms_no] ,@[yd_fcty_tp_psdo_yd_flg] ,@[yd_eml] ,@[dem_ib_clt_flg] " ).append("\n"); 
		query.append("			   ,@[dem_ob_clt_flg] ,@[bkg_pod_yd_flg] ,@[yd_fcty_tp_brg_rmp_flg] ,@[bfr_ofc_cd] ,to_date(@[bfr_ofc_cng_dt] ,'yyyymmddhh24miss'),@[modi_yd_cd] ,@[dmdt_ofc_cd] ,@[cre_usr_id] ,to_date(@[cre_dt] ,'yyyymmddhh24miss'),@[upd_usr_id] " ).append("\n"); 
		query.append("			   ,to_date(@[upd_dt] ,'yyyymmddhh24miss'),@[delt_flg]" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("#if(${yd_fcty_tp_psdo_yd_flg} == 'Y')			   " ).append("\n"); 
		query.append("			   ,'P' " ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_mrn_tml_flg}=='Y')" ).append("\n"); 
		query.append("				,'M'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_brg_rmp_flg} =='Y')" ).append("\n"); 
		query.append("				,'B'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_rail_rmp_flg} =='Y')" ).append("\n"); 
		query.append("				,'R'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_cy_flg} =='Y')" ).append("\n"); 
		query.append("				,'Y'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_cfs_flg} =='Y')" ).append("\n"); 
		query.append("				,'S'" ).append("\n"); 
		query.append("#elseif(${yd_fcty_tp_psdo_yd_flg} !='Y' &&" ).append("\n"); 
		query.append("		${yd_fcty_tp_mrn_tml_flg} !='Y' &&" ).append("\n"); 
		query.append("		${yd_fcty_tp_brg_rmp_flg} !='Y' &&" ).append("\n"); 
		query.append("		${yd_fcty_tp_rail_rmp_flg} !='Y' &&" ).append("\n"); 
		query.append("		${yd_fcty_tp_cy_flg} !='Y' &&" ).append("\n"); 
		query.append("		${yd_fcty_tp_cfs_flg} !='Y' )" ).append("\n"); 
		query.append("				,'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			   ,@[hub_yd_flg] , to_date(@[eai_evnt_dt] ,'yyyymmddhh24miss')" ).append("\n"); 
		query.append("			   ,@[yd_locl_lang_nm],@[yd_locl_lang_addr]" ).append("\n"); 
		query.append("			   ,6,3,@[dry_yd_ft_hrs]" ).append("\n"); 
		query.append("			   ,6,3,@[eai_if_id]" ).append("\n"); 
		query.append("			   )" ).append("\n"); 

	}
}