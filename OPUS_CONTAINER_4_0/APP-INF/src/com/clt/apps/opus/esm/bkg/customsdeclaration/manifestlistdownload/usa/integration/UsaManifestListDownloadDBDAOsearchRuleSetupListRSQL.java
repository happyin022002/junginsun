/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchRuleSetupListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchRuleSetupListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchRuleSetupListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_imp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frob_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchRuleSetupListRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("	xpt_imp_cd," ).append("\n"); 
		query.append("	bl_tp_cd," ).append("\n"); 
		query.append("	cnt_cd," ).append("\n"); 
		query.append("	loc_cd," ).append("\n"); 
		query.append("	frob_flg," ).append("\n"); 
		query.append("	cstms_div_id," ).append("\n"); 
		query.append("	shpr_nm_flg," ).append("\n"); 
		query.append("	shpr_addr_flg," ).append("\n"); 
		query.append("	shpr_cty_flg," ).append("\n"); 
		query.append("	shpr_ste_flg," ).append("\n"); 
		query.append("	shpr_cnt_flg," ).append("\n"); 
		query.append("	shpr_zip_flg," ).append("\n"); 
		query.append("    shpr_st_nm_flg," ).append("\n"); 
		query.append("    shpr_eori_no_flg," ).append("\n"); 
		query.append("    shpr_phn_flg," ).append("\n"); 
		query.append("    shpr_fax_flg," ).append("\n"); 
		query.append("    shpr_co_rgst_flg," ).append("\n"); 
		query.append("    cnee_nm_flg," ).append("\n"); 
		query.append("    cnee_addr_flg," ).append("\n"); 
		query.append("    cnee_cty_flg," ).append("\n"); 
		query.append("    cnee_ste_flg," ).append("\n"); 
		query.append("    cnee_cnt_flg," ).append("\n"); 
		query.append("    cnee_zip_flg," ).append("\n"); 
		query.append("    cnee_st_nm_flg," ).append("\n"); 
		query.append("    cnee_eori_no_flg," ).append("\n"); 
		query.append("    cnee_phn_flg," ).append("\n"); 
		query.append("    cnee_fax_flg," ).append("\n"); 
		query.append("    cnee_co_rgst_flg," ).append("\n"); 
		query.append("    ntfy_nm_flg," ).append("\n"); 
		query.append("    ntfy_addr_flg," ).append("\n"); 
		query.append("    ntfy_cty_flg," ).append("\n"); 
		query.append("    ntfy_ste_flg," ).append("\n"); 
		query.append("    ntfy_cnt_flg," ).append("\n"); 
		query.append("    ntfy_zip_flg," ).append("\n"); 
		query.append("    ntfy_st_nm_flg," ).append("\n"); 
		query.append("    ntfy_eori_no_flg," ).append("\n"); 
		query.append("    ntfy_phn_flg," ).append("\n"); 
		query.append("    ntfy_fax_flg," ).append("\n"); 
		query.append("    ntfy_co_rgst_flg," ).append("\n"); 
		query.append("    pck_flg," ).append("\n"); 
		query.append("    wgt_flg," ).append("\n"); 
		query.append("    meas_flg," ).append("\n"); 
		query.append("    bl_desc_flg," ).append("\n"); 
		query.append("    bl_mk_flg," ).append("\n"); 
		query.append("    cmdt_hs_cd_flg," ).append("\n"); 
		query.append("	cntr_no_flg," ).append("\n"); 
		query.append("	seal_no_flg," ).append("\n"); 
		query.append("	cntr_pck_flg," ).append("\n"); 
		query.append("	cntr_wgt_flg," ).append("\n"); 
		query.append("	cntr_meas_flg," ).append("\n"); 
		query.append("	cntr_mf_pck_flg," ).append("\n"); 
		query.append("	cntr_mf_wgt_flg," ).append("\n"); 
		query.append("	cntr_mf_meas_flg," ).append("\n"); 
		query.append("	cntr_mf_desc_flg," ).append("\n"); 
		query.append("	cntr_mf_mk_flg," ).append("\n"); 
		query.append("	cntr_mf_cmdt_flg," ).append("\n"); 
		query.append("	cntr_mf_ncm_flg," ).append("\n"); 
		query.append("	xpt_imp_ref_flg1," ).append("\n"); 
		query.append("	xpt_imp_ref_flg2," ).append("\n"); 
		query.append("	xpt_imp_ref_flg3," ).append("\n"); 
		query.append("	xpt_imp_ref_flg4," ).append("\n"); 
		query.append("	xpt_imp_ref_flg5," ).append("\n"); 
		query.append("    xpt_imp_ref_flg6," ).append("\n"); 
		query.append("    xpt_imp_ref_flg7," ).append("\n"); 
		query.append("	delt_flg," ).append("\n"); 
		query.append("	cre_usr_id," ).append("\n"); 
		query.append("	cre_dt," ).append("\n"); 
		query.append("	upd_usr_id," ).append("\n"); 
		query.append("	upd_dt" ).append("\n"); 
		query.append("from bkg_cstms_rule_stup" ).append("\n"); 
		query.append("where 1=1 " ).append("\n"); 
		query.append("and delt_flg = 'N'" ).append("\n"); 
		query.append("and cnt_cd = @[cnt_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("and loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("and frob_flg = @[frob_flg]" ).append("\n"); 
		query.append("#if (${xpt_imp_cd} != '') " ).append("\n"); 
		query.append("and xpt_imp_cd = @[xpt_imp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_tp_cd} != '') " ).append("\n"); 
		query.append("and bl_tp_cd = @[bl_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("order by xpt_imp_cd asc, bl_tp_cd desc" ).append("\n"); 

	}
}