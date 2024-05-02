/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : LocationDBDAOAddYardIbisIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LocationDBDAOAddYardIbisIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public LocationDBDAOAddYardIbisIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bd_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_co_vol_bx_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hol_gate_clz_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sat_gate_clz_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_fcty_tp_mrn_tml_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dem_ib_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_rf_rcpt_220v_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("gate_opn_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_scc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("modi_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rep_zn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sun_gate_opn_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_lon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_lat",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_locl_lang_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cgo_clz_hrmnt_msg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_strdl_crr_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_prod_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pod_yd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eir_svc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rep_yd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_oshp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_co_vol_teu_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_top_lft_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_trct_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_brth_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_rf_rcpt_440v_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_pst_pgc_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tml_chss_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_ttl_spc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_fcty_tp_rail_rmp_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.location.integration").append("\n"); 
		query.append("FileName : LocationDBDAOAddYardIbisIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_YARD_IBIS_IF( " ).append("\n"); 
		query.append("             YD_IBIS_IF_SEQ" ).append("\n"); 
		query.append("            ,YD_CD" ).append("\n"); 
		query.append("            ,YD_NM" ).append("\n"); 
		query.append("            ,LOC_CD" ).append("\n"); 
		query.append("            ,EQ_SCC_CD" ).append("\n"); 
		query.append("            ,N1ST_VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,N1ST_VNDR_SEQ" ).append("\n"); 
		query.append("            ,OFC_CD" ).append("\n"); 
		query.append("            ,YD_CHR_CD" ).append("\n"); 
		query.append("            ,YD_FCTY_TP_MRN_TML_FLG" ).append("\n"); 
		query.append("            ,YD_FCTY_TP_CY_FLG" ).append("\n"); 
		query.append("            ,YD_FCTY_TP_CFS_FLG" ).append("\n"); 
		query.append("            ,YD_FCTY_TP_RAIL_RMP_FLG" ).append("\n"); 
		query.append("            ,YD_OSHP_CD" ).append("\n"); 
		query.append("            ,BD_YD_FLG" ).append("\n"); 
		query.append("            ,REP_ZN_CD" ).append("\n"); 
		query.append("            ,YD_ADDR" ).append("\n"); 
		query.append("            ,ZIP_CD" ).append("\n"); 
		query.append("            ,INTL_PHN_NO" ).append("\n"); 
		query.append("            ,PHN_NO" ).append("\n"); 
		query.append("            ,FAX_NO" ).append("\n"); 
		query.append("            ,YD_PIC_NM" ).append("\n"); 
		query.append("            ,YD_CEO_NM" ).append("\n"); 
		query.append("            ,GATE_OPN_HRMNT" ).append("\n"); 
		query.append("            ,GATE_CLZ_HRMNT" ).append("\n"); 
		query.append("            ,HOL_GATE_OPN_HRMNT" ).append("\n"); 
		query.append("            ,HOL_GATE_CLZ_HRMNT" ).append("\n"); 
		query.append("            ,SUN_GATE_OPN_HRMNT" ).append("\n"); 
		query.append("            ,SUN_GATE_CLZ_HRMNT" ).append("\n"); 
		query.append("            ,SAT_GATE_OPN_HRMNT" ).append("\n"); 
		query.append("            ,SAT_GATE_CLZ_HRMNT" ).append("\n"); 
		query.append("            ,YD_CGO_CLZ_HRMNT_MSG" ).append("\n"); 
		query.append("            ,YD_RMK" ).append("\n"); 
		query.append("            ,BRTH_NO" ).append("\n"); 
		query.append("            ,YD_BRTH_LEN" ).append("\n"); 
		query.append("            ,YD_BRTH_DPTH_CHNL_KNT" ).append("\n"); 
		query.append("            ,YD_TTL_SPC" ).append("\n"); 
		query.append("            ,YD_ACT_SPC" ).append("\n"); 
		query.append("            ,YD_HNDL_CAPA" ).append("\n"); 
		query.append("            ,YD_RF_RCPT_440V_KNT" ).append("\n"); 
		query.append("            ,YD_RF_RCPT_220V_KNT" ).append("\n"); 
		query.append("            ,YD_RF_RCPT_DUL_KNT" ).append("\n"); 
		query.append("            ,YD_OP_SYS_CD" ).append("\n"); 
		query.append("            ,YD_INRL_FLG" ).append("\n"); 
		query.append("            ,YD_CFS_SPC" ).append("\n"); 
		query.append("            ,MNR_SHOP_FLG" ).append("\n"); 
		query.append("            ,YD_HNDL_YR" ).append("\n"); 
		query.append("            ,YD_TTL_VOL_TEU_KNT" ).append("\n"); 
		query.append("            ,YD_TTL_VOL_BX_KNT" ).append("\n"); 
		query.append("            ,YD_CO_VOL_TEU_KNT" ).append("\n"); 
		query.append("            ,YD_CO_VOL_BX_KNT" ).append("\n"); 
		query.append("            ,YD_PST_PGC_KNT" ).append("\n"); 
		query.append("            ,YD_PGC_KNT" ).append("\n"); 
		query.append("            ,TRSTR_KNT" ).append("\n"); 
		query.append("            ,FRK_KNT" ).append("\n"); 
		query.append("            ,YD_STRDL_CRR_KNT" ).append("\n"); 
		query.append("            ,YD_TRCT_KNT" ).append("\n"); 
		query.append("            ,YD_TOP_LFT_KNT" ).append("\n"); 
		query.append("            ,TML_CHSS_KNT" ).append("\n"); 
		query.append("            ,EIR_SVC_FLG" ).append("\n"); 
		query.append("            ,TML_PROD_KNT" ).append("\n"); 
		query.append("            ,YD_CSTMS_NO" ).append("\n"); 
		query.append("            ,YD_FCTY_TP_PSDO_YD_FLG" ).append("\n"); 
		query.append("            ,YD_EML" ).append("\n"); 
		query.append("            ,DEM_IB_CLT_FLG" ).append("\n"); 
		query.append("            ,DEM_OB_CLT_FLG" ).append("\n"); 
		query.append("            ,BKG_POD_YD_FLG" ).append("\n"); 
		query.append("            ,N2ND_VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,N2ND_VNDR_SEQ" ).append("\n"); 
		query.append("            ,N3RD_VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,N3RD_VNDR_SEQ" ).append("\n"); 
		query.append("            ,DMDT_OFC_CD" ).append("\n"); 
		query.append("            ,REP_YD_TP_CD" ).append("\n"); 
		query.append("            ,HUB_YD_FLG" ).append("\n"); 
		query.append("            ,YD_LOCL_LANG_NM" ).append("\n"); 
		query.append("            ,YD_LOCL_LANG_ADDR" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("			,MODI_YD_CD" ).append("\n"); 
		query.append("            ,IF_MNPL_CD" ).append("\n"); 
		query.append("            ,YD_LAT" ).append("\n"); 
		query.append("            ,YD_LON" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES(  MDM_YARD_IBIS_IF_SEQ.NEXTVAL" ).append("\n"); 
		query.append("            ,@[yd_cd]" ).append("\n"); 
		query.append("            ,@[yd_nm]" ).append("\n"); 
		query.append("            ,SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("            ,@[eq_scc_cd]" ).append("\n"); 
		query.append("            ,(SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[n1st_vndr_seq])" ).append("\n"); 
		query.append("            ,@[n1st_vndr_seq]" ).append("\n"); 
		query.append("            ,@[ofc_cd]" ).append("\n"); 
		query.append("            ,@[yd_chr_cd]" ).append("\n"); 
		query.append("            ,NVL(@[yd_fcty_tp_mrn_tml_flg], 'N')" ).append("\n"); 
		query.append("            ,NVL(@[yd_fcty_tp_cy_flg], 'N')" ).append("\n"); 
		query.append("            ,NVL(@[yd_fcty_tp_cfs_flg], 'N')" ).append("\n"); 
		query.append("            ,NVL(@[yd_fcty_tp_rail_rmp_flg], 'N')" ).append("\n"); 
		query.append("            ,@[yd_oshp_cd]" ).append("\n"); 
		query.append("            ,@[bd_yd_flg]" ).append("\n"); 
		query.append("            ,@[rep_zn_cd]" ).append("\n"); 
		query.append("            ,@[yd_addr]" ).append("\n"); 
		query.append("            ,@[zip_cd]" ).append("\n"); 
		query.append("            ,@[intl_phn_no]" ).append("\n"); 
		query.append("            ,@[phn_no]" ).append("\n"); 
		query.append("            ,@[fax_no]" ).append("\n"); 
		query.append("            ,@[yd_pic_nm]" ).append("\n"); 
		query.append("            ,@[yd_ceo_nm]" ).append("\n"); 
		query.append("            ,@[gate_opn_hrmnt]" ).append("\n"); 
		query.append("            ,@[gate_clz_hrmnt]" ).append("\n"); 
		query.append("            ,@[hol_gate_opn_hrmnt]" ).append("\n"); 
		query.append("            ,@[hol_gate_clz_hrmnt]" ).append("\n"); 
		query.append("            ,@[sun_gate_opn_hrmnt]" ).append("\n"); 
		query.append("            ,@[sun_gate_clz_hrmnt]" ).append("\n"); 
		query.append("            ,@[sat_gate_opn_hrmnt]" ).append("\n"); 
		query.append("            ,@[sat_gate_clz_hrmnt]" ).append("\n"); 
		query.append("            ,@[yd_cgo_clz_hrmnt_msg]" ).append("\n"); 
		query.append("            ,@[yd_rmk]" ).append("\n"); 
		query.append("            ,@[brth_no]" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_brth_len], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_brth_dpth_chnl_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_ttl_spc], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_act_spc], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_hndl_capa], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_rf_rcpt_440v_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_rf_rcpt_220v_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_rf_rcpt_dul_knt], ',', '')" ).append("\n"); 
		query.append("            ,@[yd_op_sys_cd]" ).append("\n"); 
		query.append("            ,@[yd_inrl_flg]" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_cfs_spc], ',', '')" ).append("\n"); 
		query.append("            ,@[mnr_shop_flg]" ).append("\n"); 
		query.append("            ,@[yd_hndl_yr]" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_ttl_vol_teu_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_ttl_vol_bx_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_co_vol_teu_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_co_vol_bx_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_pst_pgc_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_pgc_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[trstr_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[frk_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_strdl_crr_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_trct_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[yd_top_lft_knt], ',', '')" ).append("\n"); 
		query.append("            ,REPLACE(@[tml_chss_knt], ',', '')" ).append("\n"); 
		query.append("            ,@[eir_svc_flg]" ).append("\n"); 
		query.append("            ,REPLACE(@[tml_prod_knt], ',', '')" ).append("\n"); 
		query.append("            ,@[yd_cstms_no]" ).append("\n"); 
		query.append("            ,NVL(@[yd_fcty_tp_psdo_yd_flg], 'N')" ).append("\n"); 
		query.append("            ,@[yd_eml]" ).append("\n"); 
		query.append("            ,@[dem_ib_clt_flg]" ).append("\n"); 
		query.append("            ,@[dem_ob_clt_flg]" ).append("\n"); 
		query.append("            ,@[bkg_pod_yd_flg]" ).append("\n"); 
		query.append("            ,(SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[n2nd_vndr_seq])" ).append("\n"); 
		query.append("            ,@[n2nd_vndr_seq]" ).append("\n"); 
		query.append("            ,(SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[n3rd_vndr_seq])" ).append("\n"); 
		query.append("            ,@[n3rd_vndr_seq]" ).append("\n"); 
		query.append("            ,@[dmdt_ofc_cd]" ).append("\n"); 
		query.append("            ,@[rep_yd_tp_cd]" ).append("\n"); 
		query.append("            ,@[hub_yd_flg]" ).append("\n"); 
		query.append("            ,@[yd_locl_lang_nm]" ).append("\n"); 
		query.append("            ,@[yd_locl_lang_addr]" ).append("\n"); 
		query.append("            ,@[delt_flg]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("			,@[modi_yd_cd]" ).append("\n"); 
		query.append("            ,@[ecom_insf_dv_cd]" ).append("\n"); 
		query.append("            ,@[yd_lat]" ).append("\n"); 
		query.append("            ,@[yd_lon]" ).append("\n"); 
		query.append("         ) " ).append("\n"); 

	}
}