/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageDBDAOMnrPartnerVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.08.13 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SppUserManageDBDAOMnrPartnerVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SppUserManageDBDAOMnrPartnerVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_ptal_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration").append("\n"); 
		query.append("FileName : SppUserManageDBDAOMnrPartnerVORSQL").append("\n"); 
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
		query.append("select	mnr_prnr_cre_seq			," ).append("\n"); 
		query.append("ctrl_ofc_cd                 ," ).append("\n"); 
		query.append("mnr_grp_tp_cd               ," ).append("\n"); 
		query.append("mnr_prnr_tp_cd              ," ).append("\n"); 
		query.append("mnr_prnr_knd_cd             ," ).append("\n"); 
		query.append("mnr_prnr_knd_dtl_cd         ," ).append("\n"); 
		query.append("mnr_prnr_sts_cd             ," ).append("\n"); 
		query.append("mnr_prnr_cnt_cd             ," ).append("\n"); 
		query.append("mnr_prnr_seq                ," ).append("\n"); 
		query.append("edi_id                      ," ).append("\n"); 
		query.append("sp_ptal_id                  ," ).append("\n"); 
		query.append("sp_ptal_pwd                 ," ).append("\n"); 
		query.append("mnr_prnr_lgl_eng_nm         ," ).append("\n"); 
		query.append("mnr_prnr_locl_lang_nm       ," ).append("\n"); 
		query.append("mnr_prnr_addr               ," ).append("\n"); 
		query.append("mnr_bil_to_nm               ," ).append("\n"); 
		query.append("eff_dt                      ," ).append("\n"); 
		query.append("exp_dt                      ," ).append("\n"); 
		query.append("bank_nm                     ," ).append("\n"); 
		query.append("bank_acct_no                ," ).append("\n"); 
		query.append("pay_mzd_cd                  ," ).append("\n"); 
		query.append("pay_term_dys                ," ).append("\n"); 
		query.append("zip_cd                      ," ).append("\n"); 
		query.append("ownr_nm                     ," ).append("\n"); 
		query.append("bzct_nm                     ," ).append("\n"); 
		query.append("bztp_nm                     ," ).append("\n"); 
		query.append("bzet_addr					," ).append("\n"); 
		query.append("biz_rgst_no                 ," ).append("\n"); 
		query.append("mnr_shop_flg                ," ).append("\n"); 
		query.append("mnr_payr_cnt_cd             ," ).append("\n"); 
		query.append("mnr_payr_seq                ," ).append("\n"); 
		query.append("mnr_prnr_capi_amt           ," ).append("\n"); 
		query.append("empe_knt                    ," ).append("\n"); 
		query.append("dpt_desc                    ," ).append("\n"); 
		query.append("mnr_prnr_abbr_nm            ," ).append("\n"); 
		query.append("intl_phn_no                 ," ).append("\n"); 
		query.append("phn_no                      ," ).append("\n"); 
		query.append("intl_fax_no                 ," ).append("\n"); 
		query.append("fax_no                      ," ).append("\n"); 
		query.append("mnr_prnr_eml                ," ).append("\n"); 
		query.append("mnr_prnr_rmk                ," ).append("\n"); 
		query.append("trsm_mod_cd                 ," ).append("\n"); 
		query.append("file_seq                    ," ).append("\n"); 
		query.append("cre_usr_id                  ," ).append("\n"); 
		query.append("cre_dt                      ," ).append("\n"); 
		query.append("upd_usr_id                  ," ).append("\n"); 
		query.append("upd_dt" ).append("\n"); 
		query.append("from 	mnr_partner" ).append("\n"); 
		query.append("where sp_ptal_id = 		@[sp_ptal_id]" ).append("\n"); 

	}
}