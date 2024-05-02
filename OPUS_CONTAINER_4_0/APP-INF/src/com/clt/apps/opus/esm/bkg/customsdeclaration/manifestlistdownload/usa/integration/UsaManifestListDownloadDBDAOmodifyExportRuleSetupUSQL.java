/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyExportRuleSetupUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.17
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2012.01.17 김태경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyExportRuleSetupUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyExportRuleSetupUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_phn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seal_no_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_fax_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_meas_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_ncm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_zip_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_co_rgst_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_eori_no_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_cnt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_pck_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_addr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_wgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_eori_no_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_zip_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_phn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_cty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_ste_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_nm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_fax_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_eori_no_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cnt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_meas_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_co_rgst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_cmdt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_nm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_cty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_mk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_phn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_mk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_nm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_ste_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_pck_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_zip_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_addr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frob_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hs_cd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_st_nm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_st_nm_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xpt_imp_ref_flg1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_imp_ref_flg2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_imp_ref_flg3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_imp_ref_flg4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_co_rgst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_imp_ref_flg5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_imp_ref_flg6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_addr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_ste_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_fax_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_st_nm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyExportRuleSetupUSQL").append("\n"); 
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
		query.append("update bkg_cstms_rule_stup set " ).append("\n"); 
		query.append("	ntfy_cnt_flg = DECODE(NVL(@[ntfy_cnt_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_zip_flg = DECODE(NVL(@[ntfy_zip_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_st_nm_flg = DECODE(NVL(@[ntfy_st_nm_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_eori_no_flg = DECODE(NVL(@[ntfy_eori_no_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_phn_flg = DECODE(NVL(@[ntfy_phn_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_fax_flg = DECODE(NVL(@[ntfy_fax_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_co_rgst_flg = DECODE(NVL(@[ntfy_co_rgst_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	pck_flg = DECODE(NVL(@[pck_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	wgt_flg = DECODE(NVL(@[wgt_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	meas_flg = DECODE(NVL(@[meas_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	bl_desc_flg = DECODE(NVL(@[bl_desc_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	bl_mk_flg = DECODE(NVL(@[bl_mk_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_no_flg = DECODE(NVL(@[cntr_no_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	seal_no_flg = DECODE(NVL(@[seal_no_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_pck_flg = DECODE(NVL(@[cntr_pck_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_wgt_flg = DECODE(NVL(@[cntr_wgt_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_meas_flg = DECODE(NVL(@[cntr_meas_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_mf_pck_flg = DECODE(NVL(@[cntr_mf_pck_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_mf_wgt_flg = DECODE(NVL(@[cntr_mf_wgt_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_mf_meas_flg = DECODE(NVL(@[cntr_mf_meas_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_mf_desc_flg = DECODE(NVL(@[cntr_mf_desc_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_mf_mk_flg = DECODE(NVL(@[cntr_mf_mk_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_mf_cmdt_flg = DECODE(NVL(@[cntr_mf_cmdt_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cntr_mf_ncm_flg = DECODE(NVL(@[cntr_mf_ncm_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	xpt_imp_ref_flg1 = DECODE(NVL(@[xpt_imp_ref_flg1],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	xpt_imp_ref_flg2 = DECODE(NVL(@[xpt_imp_ref_flg2],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	xpt_imp_ref_flg3 = DECODE(NVL(@[xpt_imp_ref_flg3],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	xpt_imp_ref_flg4 = DECODE(NVL(@[xpt_imp_ref_flg4],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	xpt_imp_ref_flg5 = DECODE(NVL(@[xpt_imp_ref_flg5],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	xpt_imp_ref_flg6 = DECODE(NVL(@[xpt_imp_ref_flg6],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	delt_flg = 'N'," ).append("\n"); 
		query.append("	upd_usr_id = @[upd_usr_id]," ).append("\n"); 
		query.append("	upd_dt = sysdate," ).append("\n"); 
		query.append("	shpr_nm_flg = DECODE(NVL(@[shpr_nm_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_addr_flg = DECODE(NVL(@[shpr_addr_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_cty_flg = DECODE(NVL(@[shpr_cty_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_ste_flg = DECODE(NVL(@[shpr_ste_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_cnt_flg = DECODE(NVL(@[shpr_cnt_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_zip_flg = DECODE(NVL(@[shpr_zip_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_st_nm_flg = DECODE(NVL(@[shpr_st_nm_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_eori_no_flg = DECODE(NVL(@[shpr_eori_no_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_phn_flg = DECODE(NVL(@[shpr_phn_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_fax_flg = DECODE(NVL(@[shpr_fax_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	shpr_co_rgst_flg = DECODE(NVL(@[shpr_co_rgst_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_nm_flg = DECODE(NVL(@[cnee_nm_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_addr_flg = DECODE(NVL(@[cnee_addr_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_cty_flg = DECODE(NVL(@[cnee_cty_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_ste_flg = DECODE(NVL(@[cnee_ste_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_cnt_flg = DECODE(NVL(@[cnee_cnt_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_zip_flg = DECODE(NVL(@[cnee_zip_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_st_nm_flg = DECODE(NVL(@[cnee_st_nm_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_eori_no_flg = DECODE(NVL(@[cnee_eori_no_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_phn_flg = DECODE(NVL(@[cnee_phn_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_fax_flg = DECODE(NVL(@[cnee_fax_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cnee_co_rgst_flg = DECODE(NVL(@[cnee_co_rgst_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_nm_flg = DECODE(NVL(@[ntfy_nm_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_addr_flg = DECODE(NVL(@[ntfy_addr_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_cty_flg = DECODE(NVL(@[ntfy_cty_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	ntfy_ste_flg = DECODE(NVL(@[ntfy_ste_flg],'N'), 1, 'Y', 'N')," ).append("\n"); 
		query.append("	cmdt_hs_cd_flg = DECODE(NVL(@[cmdt_hs_cd_flg],'N'), 1, 'Y', 'N')" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and	xpt_imp_cd = @[xpt_imp_cd]	" ).append("\n"); 
		query.append("and cnt_cd = NVL(@[cnt_cd],'US')" ).append("\n"); 
		query.append("and	loc_cd = @[loc_cd]" ).append("\n"); 
		query.append("and	frob_flg = @[frob_flg]" ).append("\n"); 
		query.append("and	bl_tp_cd = @[bl_tp_cd]" ).append("\n"); 
		query.append("and	cstms_div_id = NVL(@[cstms_div_id],'CTM')" ).append("\n"); 

	}
}