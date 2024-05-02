/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserSetupMgtDBDAOBkgUsrDfltSetVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UserSetupMgtDBDAOBkgUsrDfltSetVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public UserSetupMgtDBDAOBkgUsrDfltSetVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("auto_edi_hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drft_bl_mrn_no_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_cgor_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cct_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("an_prn_rt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwrd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_cct_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("an_rcv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_cstms_cct_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcntr_rlse_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drft_wbl_rcv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_ntc_rcv_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("an_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rlse_ord_rcv_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rtn_cct_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_bl_ridr_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_bl_face_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dot_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srnd_ntc_rcv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prn_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rct_ntc_rcv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_prn_chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_cct_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drft_bl_xch_rt_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trnk_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drft_bl_call_sgn_dp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drft_bl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration").append("\n"); 
		query.append("FileName : UserSetupMgtDBDAOBkgUsrDfltSetVOCSQL").append("\n"); 
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
		query.append("INSERT INTO bkg_usr_dflt_set (" ).append("\n"); 
		query.append("	usr_id" ).append("\n"); 
		query.append(",	trnk_vsl_cd" ).append("\n"); 
		query.append(",	trnk_skd_voy_no" ).append("\n"); 
		query.append(",	trnk_skd_dir_cd" ).append("\n"); 
		query.append(",	bkg_cgo_tp_cd" ).append("\n"); 
		query.append(",	rcv_term_cd" ).append("\n"); 
		query.append(",	de_term_cd" ).append("\n"); 
		query.append(",	por_cd" ).append("\n"); 
		query.append(",	pol_cd" ).append("\n"); 
		query.append(",	full_rtn_yd_cd" ).append("\n"); 
		query.append(",	mty_pkup_yd_cd" ).append("\n"); 
		query.append(",	wgt_ut_cd" ).append("\n"); 
		query.append(",	meas_ut_cd" ).append("\n"); 
		query.append(",	cntr_tpsz_cd" ).append("\n"); 
		query.append(",	pre_vsl_cd" ).append("\n"); 
		query.append(",	pre_skd_voy_no" ).append("\n"); 
		query.append(",	pre_skd_dir_cd" ).append("\n"); 
		query.append(",	fwrd_flg" ).append("\n"); 
		query.append(",	rtn_cct_dp_flg" ).append("\n"); 
		query.append(",	tml_cct_dp_flg" ).append("\n"); 
		query.append(",	doc_cct_dp_flg" ).append("\n"); 
		query.append(",	xpt_cstms_cct_dp_flg" ).append("\n"); 
		query.append(",	rail_cct_dp_flg" ).append("\n"); 
		query.append(",	prn_bl_tp_cd" ).append("\n"); 
		query.append(",	prn_chg_tp_cd" ).append("\n"); 
		query.append(",	prn_cntr_tp_cd" ).append("\n"); 
		query.append(",	prn_bl_face_knt" ).append("\n"); 
		query.append(",	prn_bl_ridr_knt" ).append("\n"); 
		query.append(",	dflt_eml" ).append("\n"); 
		query.append(",	dflt_phn_no" ).append("\n"); 
		query.append(",	dflt_fax_no" ).append("\n"); 
		query.append(",	an_prn_rt_flg" ).append("\n"); 
		query.append(",	an_rmk" ).append("\n"); 
		query.append(",	dot_prn_flg" ).append("\n"); 
		query.append(",	drft_bl_xch_rt_dp_flg" ).append("\n"); 
		query.append(",	drft_bl_call_sgn_dp_flg" ).append("\n"); 
		query.append(",	drft_bl_mrn_no_dp_flg" ).append("\n"); 
		query.append(",	drft_bl_rmk" ).append("\n"); 
		query.append(",	cre_usr_id" ).append("\n"); 
		query.append(",	cre_dt" ).append("\n"); 
		query.append(",	upd_usr_id" ).append("\n"); 
		query.append(",	upd_dt" ).append("\n"); 
		query.append(",	AUTO_EDI_HLD_FLG" ).append("\n"); 
		query.append(",   bkg_rct_ntc_rcv_flg" ).append("\n"); 
		query.append(",   mty_rlse_ord_rcv_flg" ).append("\n"); 
		query.append(",   tro_ntc_rcv_flg" ).append("\n"); 
		query.append(",   drft_wbl_rcv_flg" ).append("\n"); 
		query.append(",   srnd_ntc_rcv_flg" ).append("\n"); 
		query.append(",   an_rcv_flg" ).append("\n"); 
		query.append(",	eur_cgor_flg" ).append("\n"); 
		query.append(",	fcntr_rlse_flg" ).append("\n"); 
		query.append(",   bl_prn_chg_tp_cd" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[usr_id]" ).append("\n"); 
		query.append(",	@[trnk_vsl_cd]" ).append("\n"); 
		query.append(",	@[trnk_skd_voy_no]" ).append("\n"); 
		query.append(",	@[trnk_skd_dir_cd]" ).append("\n"); 
		query.append(",	@[bkg_cgo_tp_cd]" ).append("\n"); 
		query.append(",	@[rcv_term_cd]" ).append("\n"); 
		query.append(",	@[de_term_cd]" ).append("\n"); 
		query.append(",	@[por_cd]" ).append("\n"); 
		query.append(",	@[pol_cd]" ).append("\n"); 
		query.append(",	@[full_rtn_yd_cd]" ).append("\n"); 
		query.append(",	@[mty_pkup_yd_cd]" ).append("\n"); 
		query.append(",	@[wgt_ut_cd]" ).append("\n"); 
		query.append(",	@[meas_ut_cd]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[pre_vsl_cd]" ).append("\n"); 
		query.append(",	@[pre_skd_voy_no]" ).append("\n"); 
		query.append(",	@[pre_skd_dir_cd]" ).append("\n"); 
		query.append(",	@[fwrd_flg]" ).append("\n"); 
		query.append(",	@[rtn_cct_dp_flg]" ).append("\n"); 
		query.append(",	@[tml_cct_dp_flg]" ).append("\n"); 
		query.append(",	@[doc_cct_dp_flg]" ).append("\n"); 
		query.append(",	@[xpt_cstms_cct_dp_flg]" ).append("\n"); 
		query.append(",	@[rail_cct_dp_flg]" ).append("\n"); 
		query.append(",	@[prn_bl_tp_cd]" ).append("\n"); 
		query.append(",	@[prn_chg_tp_cd]" ).append("\n"); 
		query.append(",	@[prn_cntr_tp_cd]" ).append("\n"); 
		query.append(",	@[prn_bl_face_knt]" ).append("\n"); 
		query.append(",	@[prn_bl_ridr_knt]" ).append("\n"); 
		query.append(",	@[dflt_eml]" ).append("\n"); 
		query.append(",	@[dflt_phn_no]" ).append("\n"); 
		query.append(",	@[dflt_fax_no]" ).append("\n"); 
		query.append(",	@[an_prn_rt_flg]" ).append("\n"); 
		query.append(",	@[an_rmk]" ).append("\n"); 
		query.append(",	@[dot_prn_flg]" ).append("\n"); 
		query.append(",	@[drft_bl_xch_rt_dp_flg]" ).append("\n"); 
		query.append(",	@[drft_bl_call_sgn_dp_flg]" ).append("\n"); 
		query.append(",	@[drft_bl_mrn_no_dp_flg]" ).append("\n"); 
		query.append(",	@[drft_bl_rmk]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[auto_edi_hld_flg]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[bkg_rct_ntc_rcv_flg]" ).append("\n"); 
		query.append(",	@[mty_rlse_ord_rcv_flg]" ).append("\n"); 
		query.append(",	@[tro_ntc_rcv_flg]" ).append("\n"); 
		query.append(",	@[drft_wbl_rcv_flg]" ).append("\n"); 
		query.append(",	@[srnd_ntc_rcv_flg]" ).append("\n"); 
		query.append(",	@[an_rcv_flg]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",	@[eur_cgor_flg]" ).append("\n"); 
		query.append(",	@[fcntr_rlse_flg]" ).append("\n"); 
		query.append(",   @[bl_prn_chg_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}