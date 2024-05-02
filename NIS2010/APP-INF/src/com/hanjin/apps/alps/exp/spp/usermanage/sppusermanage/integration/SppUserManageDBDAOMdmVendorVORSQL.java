/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageDBDAOMdmVendorVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.09.07 안준상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jsahn
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SppUserManageDBDAOMdmVendorVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mdm vendor search
	  * </pre>
	  */
	public SppUserManageDBDAOMdmVendorVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.exp.spp.usermanage.sppusermanage.integration").append("\n"); 
		query.append("FileName : SppUserManageDBDAOMdmVendorVORSQL").append("\n"); 
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
		query.append("vndr_seq				," ).append("\n"); 
		query.append("vndr_cnt_cd             ," ).append("\n"); 
		query.append("vndr_lgl_eng_nm         ," ).append("\n"); 
		query.append("vndr_locl_lang_nm       ," ).append("\n"); 
		query.append("vndr_abbr_nm            ," ).append("\n"); 
		query.append("lgs_flg                 ," ).append("\n"); 
		query.append("procu_flg               ," ).append("\n"); 
		query.append("team_flg                ," ).append("\n"); 
		query.append("finc_flg                ," ).append("\n"); 
		query.append("blk_flg                 ," ).append("\n"); 
		query.append("inter_co_flg            ," ).append("\n"); 
		query.append("loc_cd                  ," ).append("\n"); 
		query.append("ofc_cd                  ," ).append("\n"); 
		query.append("ceo_nm                  ," ).append("\n"); 
		query.append("rgst_no                 ," ).append("\n"); 
		query.append("tax_id                  ," ).append("\n"); 
		query.append("prnt_cnt_cd             ," ).append("\n"); 
		query.append("prnt_vndr_seq           ," ).append("\n"); 
		query.append("dcgo_hndl_flg           ," ).append("\n"); 
		query.append("svc_scp_cd_nm           ," ).append("\n"); 
		query.append("svc_prd_tp_nm           ," ).append("\n"); 
		query.append("svc_prd_rmk             ," ).append("\n"); 
		query.append("bzct_nm                 ," ).append("\n"); 
		query.append("bztp_nm                 ," ).append("\n"); 
		query.append("gen_pay_term_cd         ," ).append("\n"); 
		query.append("eng_addr                ," ).append("\n"); 
		query.append("locl_lang_addr          ," ).append("\n"); 
		query.append("zip_cd                  ," ).append("\n"); 
		query.append("cntc_pson_nm            ," ).append("\n"); 
		query.append("inv_curr_cd             ," ).append("\n"); 
		query.append("pay_curr_cd             ," ).append("\n"); 
		query.append("pay_mzd_cd              ," ).append("\n"); 
		query.append("usa_edi_cd              ," ).append("\n"); 
		query.append("wo_atch_file_flg        ," ).append("\n"); 
		query.append("wo_edi_use_flg          ," ).append("\n"); 
		query.append("inv_edi_use_flg         ," ).append("\n"); 
		query.append("mty_rro_edi_use_flg     ," ).append("\n"); 
		query.append("blk_vndr_svc_cd         ," ).append("\n"); 
		query.append("subs_co_cd              ," ).append("\n"); 
		query.append("otr_flg                 ," ).append("\n"); 
		query.append("vndr_ofc_cd             ," ).append("\n"); 
		query.append("modi_vndr_seq           ," ).append("\n"); 
		query.append("cre_usr_id              ," ).append("\n"); 
		query.append("cre_dt                  ," ).append("\n"); 
		query.append("upd_usr_id              ," ).append("\n"); 
		query.append("upd_dt                  ," ).append("\n"); 
		query.append("delt_flg                ," ).append("\n"); 
		query.append("eai_evnt_dt             ," ).append("\n"); 
		query.append("rfnd_psdo_cust_cd       ," ).append("\n"); 
		query.append("pay_term_tp_cd          ," ).append("\n"); 
		query.append("chk_de_addr1            ," ).append("\n"); 
		query.append("chk_de_addr2            ," ).append("\n"); 
		query.append("chk_de_addr3            ," ).append("\n"); 
		query.append("chk_de_cty_nm           ," ).append("\n"); 
		query.append("chk_de_ste_cd           ," ).append("\n"); 
		query.append("chk_de_zip_cd           ," ).append("\n"); 
		query.append("chk_de_cnt_cd           ," ).append("\n"); 
		query.append("lu_delt_flg             ," ).append("\n"); 
		query.append("flet_mgmt_ownr_vndr_seq ," ).append("\n"); 
		query.append("cnl_agn_flg             ," ).append("\n"); 
		query.append("cnl_agn_bank_desc" ).append("\n"); 
		query.append("from	mdm_vendor" ).append("\n"); 
		query.append("where   vndr_seq = 		@[vndr_seq]" ).append("\n"); 

	}
}