/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : AssetDBDAOAddContainerVesselIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2018.04.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.asset.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetDBDAOAddContainerVesselIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Vessel 정보 및 처리상태를 다른 시스템으로 전송하기 위해 저장한다.
	  * </pre>
	  */
	public AssetDBDAOAddContainerVesselIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clss_no_rgst_area_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crw_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_vsl_opr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpl_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("madn_voy_suz_net_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgt_shp_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_rgst_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clz_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_gt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("max_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_hgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dwt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_delt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bwthst_mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bld_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecom_insf_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_rcpt_max_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ocedi_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tlx_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rf_rcpt_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_teu_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_kel_ly_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lbp_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnr_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("piclb_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fbd_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dzn_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_op_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_htch_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_hl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bwthst_bhp_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bwthst_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loa_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pnm_net_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnr_mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_rgst_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bld_area_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_lnch_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ocedi_insf_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnr_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_rpm_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_tong_certi_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_bldr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pnm_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frsh_wtr_capa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mn_eng_mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_edi_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cntr_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecn_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blst_tnk_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bwthst_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_rgst_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smr_drft_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gnr_bhp_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_own_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_bhp_pwr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frsh_wtr_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_dpth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_svc_spd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecom_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("suz_gt_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_csm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mn_eng_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("suz_net_tong_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_locl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_hld_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.asset.integration").append("\n"); 
		query.append("FileName : AssetDBDAOAddContainerVesselIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_VSL_CNTR_IF(" ).append("\n"); 
		query.append("             VSL_CNTR_IF_SEQ" ).append("\n"); 
		query.append("            ,VSL_CD" ).append("\n"); 
		query.append("            ,VSL_CLSS_FLG" ).append("\n"); 
		query.append("            ,VSL_ENG_NM" ).append("\n"); 
		query.append("            ,VSL_LOCL_NM" ).append("\n"); 
		query.append("            ,FOIL_CAPA" ).append("\n"); 
		query.append("            ,DOIL_CAPA" ).append("\n"); 
		query.append("            ,FRSH_WTR_CAPA" ).append("\n"); 
		query.append("            ,CALL_SGN_NO" ).append("\n"); 
		query.append("            ,RGST_NO" ).append("\n"); 
		query.append("            ,PHN_NO" ).append("\n"); 
		query.append("            ,FAX_NO" ).append("\n"); 
		query.append("            ,TLX_NO" ).append("\n"); 
		query.append("            ,VSL_EML" ).append("\n"); 
		query.append("            ,PICLB_DESC" ).append("\n"); 
		query.append("            ,RGST_PORT_CD" ).append("\n"); 
		query.append("            ,CLSS_NO_RGST_AREA_NM" ).append("\n"); 
		query.append("            ,VSL_CLSS_NO" ).append("\n"); 
		query.append("            ,VSL_BLDR_NM" ).append("\n"); 
		query.append("            ,LOA_LEN" ).append("\n"); 
		query.append("            ,LBP_LEN" ).append("\n"); 
		query.append("            ,VSL_WDT" ).append("\n"); 
		query.append("            ,VSL_DPTH" ).append("\n"); 
		query.append("            ,SMR_DRFT_HGT" ).append("\n"); 
		query.append("            ,DWT_WGT" ).append("\n"); 
		query.append("            ,LGT_SHP_TONG_WGT" ).append("\n"); 
		query.append("            ,GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("            ,NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("            ,PNM_GT_WGT" ).append("\n"); 
		query.append("            ,PNM_NET_TONG_WGT" ).append("\n"); 
		query.append("            ,SUZ_GT_WGT" ).append("\n"); 
		query.append("            ,SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("            ,MN_ENG_MKR_NM" ).append("\n"); 
		query.append("            ,MN_ENG_TP_DESC" ).append("\n"); 
		query.append("            ,MN_ENG_BHP_PWR" ).append("\n"); 
		query.append("            ,VSL_OWN_IND_CD" ).append("\n"); 
		query.append("            ,VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("            ,VSL_BLD_CD" ).append("\n"); 
		query.append("            ,CRR_CD" ).append("\n"); 
		query.append("            ,FDR_DIV_CD" ).append("\n"); 
		query.append("            ,VSL_SVC_SPD" ).append("\n"); 
		query.append("            ,MAX_SPD" ).append("\n"); 
		query.append("            ,ECN_SPD" ).append("\n"); 
		query.append("            ,CRW_KNT" ).append("\n"); 
		query.append("            ,CNTR_DZN_CAPA" ).append("\n"); 
		query.append("            ,CNTR_OP_CAPA" ).append("\n"); 
		query.append("            ,CNTR_PNM_CAPA" ).append("\n"); 
		query.append("            ,CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("            ,RF_RCPT_KNT" ).append("\n"); 
		query.append("            ,RF_RCPT_MAX_KNT" ).append("\n"); 
		query.append("            ,FBD_CAPA" ).append("\n"); 
		query.append("            ,DPL_CAPA" ).append("\n"); 
		query.append("            ,BLST_TNK_CAPA" ).append("\n"); 
		query.append("            ,FOIL_CSM" ).append("\n"); 
		query.append("            ,DOIL_CSM" ).append("\n"); 
		query.append("            ,FRSH_WTR_CSM" ).append("\n"); 
		query.append("            ,MN_ENG_RPM_PWR" ).append("\n"); 
		query.append("            ,GNR_RPM_PWR" ).append("\n"); 
		query.append("            ,VSL_HGT" ).append("\n"); 
		query.append("            ,RGST_DT" ).append("\n"); 
		query.append("            ,VSL_EDI_NM" ).append("\n"); 
		query.append("            ,CO_CD" ).append("\n"); 
		query.append("            ,VSL_CLZ_DT" ).append("\n"); 
		query.append("            ,VSL_CRE_OFC_CD" ).append("\n"); 
		query.append("            ,VSL_DELT_OFC_CD" ).append("\n"); 
		query.append("            ,VSL_BLD_AREA_NM" ).append("\n"); 
		query.append("            ,GNR_MKR_NM" ).append("\n"); 
		query.append("            ,GNR_TP_DESC" ).append("\n"); 
		query.append("            ,GNR_BHP_PWR" ).append("\n"); 
		query.append("            ,BWTHST_MKR_NM" ).append("\n"); 
		query.append("            ,BWTHST_TP_DESC" ).append("\n"); 
		query.append("            ,BWTHST_BHP_PWR" ).append("\n"); 
		query.append("            ,BWTHST_RPM_PWR" ).append("\n"); 
		query.append("            ,LLOYD_NO" ).append("\n"); 
		query.append("            ,VSL_LNCH_DT" ).append("\n"); 
		query.append("            ,VSL_DE_DT" ).append("\n"); 
		query.append("            ,VSL_KEL_LY_DT" ).append("\n"); 
		query.append("            ,VSL_HL_NO" ).append("\n"); 
		query.append("            ,TTL_TEU_KNT" ).append("\n"); 
		query.append("            ,VSL_HTCH_KNT" ).append("\n"); 
		query.append("            ,VSL_HLD_KNT" ).append("\n"); 
		query.append("            ,VSL_RMK" ).append("\n"); 
		query.append("            ,INTL_TONG_CERTI_FLG" ).append("\n"); 
		query.append("            ,MADN_VOY_SUZ_NET_TONG_WGT" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,EAI_EVNT_DT" ).append("\n"); 
		query.append("            ,EAI_IF_ID" ).append("\n"); 
		query.append("            ,MODI_VSL_CD" ).append("\n"); 
		query.append("            ,ECOM_INSF_ID" ).append("\n"); 
		query.append("            ,ECOM_INSF_DV_CD" ).append("\n"); 
		query.append("            ,OCEDI_INSF_ID" ).append("\n"); 
		query.append("            ,OCEDI_INSF_DV_CD" ).append("\n"); 
		query.append("            ,MODI_VSL_OPR_TP_CD" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES(  @[vsl_cntr_if_seq]" ).append("\n"); 
		query.append("            ,@[vsl_cd]" ).append("\n"); 
		query.append("            ,@[vsl_clss_flg]" ).append("\n"); 
		query.append("            ,@[vsl_eng_nm]" ).append("\n"); 
		query.append("            ,@[vsl_locl_nm]" ).append("\n"); 
		query.append("            ,@[foil_capa]" ).append("\n"); 
		query.append("            ,@[doil_capa]" ).append("\n"); 
		query.append("            ,@[frsh_wtr_capa]" ).append("\n"); 
		query.append("            ,@[call_sgn_no]" ).append("\n"); 
		query.append("            ,@[rgst_no]" ).append("\n"); 
		query.append("            ,@[phn_no]" ).append("\n"); 
		query.append("            ,@[fax_no]" ).append("\n"); 
		query.append("            ,@[tlx_no]" ).append("\n"); 
		query.append("            ,@[vsl_eml]" ).append("\n"); 
		query.append("            ,@[piclb_desc]" ).append("\n"); 
		query.append("            ,@[rgst_port_cd]" ).append("\n"); 
		query.append("            ,@[clss_no_rgst_area_nm]" ).append("\n"); 
		query.append("            ,@[vsl_clss_no]" ).append("\n"); 
		query.append("            ,@[vsl_bldr_nm]" ).append("\n"); 
		query.append("            ,@[loa_len]" ).append("\n"); 
		query.append("            ,@[lbp_len]" ).append("\n"); 
		query.append("            ,@[vsl_wdt]" ).append("\n"); 
		query.append("            ,@[vsl_dpth]" ).append("\n"); 
		query.append("            ,@[smr_drft_hgt]" ).append("\n"); 
		query.append("            ,@[dwt_wgt]" ).append("\n"); 
		query.append("            ,@[lgt_shp_tong_wgt]" ).append("\n"); 
		query.append("            ,@[grs_rgst_tong_wgt]" ).append("\n"); 
		query.append("            ,@[net_rgst_tong_wgt]" ).append("\n"); 
		query.append("            ,@[pnm_gt_wgt]" ).append("\n"); 
		query.append("            ,@[pnm_net_tong_wgt]" ).append("\n"); 
		query.append("            ,@[suz_gt_wgt]" ).append("\n"); 
		query.append("            ,@[suz_net_tong_wgt]" ).append("\n"); 
		query.append("            ,@[mn_eng_mkr_nm]" ).append("\n"); 
		query.append("            ,@[mn_eng_tp_desc]" ).append("\n"); 
		query.append("            ,@[mn_eng_bhp_pwr]" ).append("\n"); 
		query.append("            ,@[vsl_own_ind_cd]" ).append("\n"); 
		query.append("            ,@[vsl_rgst_cnt_cd]" ).append("\n"); 
		query.append("            ,@[vsl_bld_cd]" ).append("\n"); 
		query.append("            ,@[crr_cd]" ).append("\n"); 
		query.append("            ,@[fdr_div_cd]" ).append("\n"); 
		query.append("            ,@[vsl_svc_spd]" ).append("\n"); 
		query.append("            ,@[max_spd]" ).append("\n"); 
		query.append("            ,@[ecn_spd]" ).append("\n"); 
		query.append("            ,@[crw_knt]" ).append("\n"); 
		query.append("            ,@[cntr_dzn_capa]" ).append("\n"); 
		query.append("            ,@[cntr_op_capa]" ).append("\n"); 
		query.append("            ,@[cntr_pnm_capa]" ).append("\n"); 
		query.append("            ,@[cntr_vsl_clss_capa]" ).append("\n"); 
		query.append("            ,@[rf_rcpt_knt]" ).append("\n"); 
		query.append("            ,@[rf_rcpt_max_knt]" ).append("\n"); 
		query.append("            ,@[fbd_capa]" ).append("\n"); 
		query.append("            ,@[dpl_capa]" ).append("\n"); 
		query.append("            ,@[blst_tnk_capa]" ).append("\n"); 
		query.append("            ,@[foil_csm]" ).append("\n"); 
		query.append("            ,@[doil_csm]" ).append("\n"); 
		query.append("            ,@[frsh_wtr_csm]" ).append("\n"); 
		query.append("            ,@[mn_eng_rpm_pwr]" ).append("\n"); 
		query.append("            ,@[gnr_rpm_pwr]" ).append("\n"); 
		query.append("            ,@[vsl_hgt]" ).append("\n"); 
		query.append("            ,TO_DATE(@[rgst_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("            ,@[vsl_edi_nm]" ).append("\n"); 
		query.append("            ,@[co_cd]" ).append("\n"); 
		query.append("			,TRIM(REPLACE(@[vsl_clz_dt], '-', ''))" ).append("\n"); 
		query.append("            ,@[vsl_cre_ofc_cd]" ).append("\n"); 
		query.append("            ,@[vsl_delt_ofc_cd]" ).append("\n"); 
		query.append("            ,@[vsl_bld_area_nm]" ).append("\n"); 
		query.append("            ,@[gnr_mkr_nm]" ).append("\n"); 
		query.append("            ,@[gnr_tp_desc]" ).append("\n"); 
		query.append("            ,@[gnr_bhp_pwr]" ).append("\n"); 
		query.append("            ,@[bwthst_mkr_nm]" ).append("\n"); 
		query.append("            ,@[bwthst_tp_desc]" ).append("\n"); 
		query.append("            ,@[bwthst_bhp_pwr]" ).append("\n"); 
		query.append("            ,@[bwthst_rpm_pwr]" ).append("\n"); 
		query.append("            ,@[lloyd_no]" ).append("\n"); 
		query.append("            ,TO_DATE(@[vsl_lnch_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("            ,TO_DATE(@[vsl_de_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("            ,TO_DATE(@[vsl_kel_ly_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("            ,@[vsl_hl_no]" ).append("\n"); 
		query.append("            ,@[ttl_teu_knt]" ).append("\n"); 
		query.append("            ,@[vsl_htch_knt]" ).append("\n"); 
		query.append("            ,@[vsl_hld_knt]" ).append("\n"); 
		query.append("            ,@[vsl_rmk]" ).append("\n"); 
		query.append("            ,@[intl_tong_certi_flg]" ).append("\n"); 
		query.append("            ,@[madn_voy_suz_net_tong_wgt]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[delt_flg]" ).append("\n"); 
		query.append("            ,TO_DATE(@[eai_evnt_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("            ,@[eai_if_id]" ).append("\n"); 
		query.append("            ,@[modi_vsl_cd]" ).append("\n"); 
		query.append("            ,@[ecom_insf_id]" ).append("\n"); 
		query.append("            ,@[ecom_insf_dv_cd]" ).append("\n"); 
		query.append("            ,@[ocedi_insf_id]" ).append("\n"); 
		query.append("            ,@[ocedi_insf_dv_cd]" ).append("\n"); 
		query.append("            ,@[modi_vsl_opr_tp_cd]" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}