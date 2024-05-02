/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PartnerDBDAOAddCustInfoIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerDBDAOAddCustInfoIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 정보 및 처리상태를 다른 시스템으로 전송하기 위해 저장한다.
	  * </pre>
	  */
	public PartnerDBDAOAddCustInfoIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("key_acct_mgr_usr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvocc_bd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("r3_insf_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("indus_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subs_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_acct_st_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empe_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ecom_insf_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_if_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("r3_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opedi_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_fmc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("indiv_corp_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_req_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rail_road_prio_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nmd_cust_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvocc_bd_end_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_svc_dtl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cts_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_svc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzet_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvocc_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("capi_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opedi_insf_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("capi_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cntc_pnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prmry_chk_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_acct_mgr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("addr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_rep_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("key_acct_end_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("modi_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mlt_trd_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vbs_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ste_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvocc_bd_st_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_cust_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvocc_co_scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crnt_vol_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_url",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvocc_bd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_addr4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nbs_clss_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prf_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_delt_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nbs_clss_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_sts_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nbs_clss_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fndt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOAddCustInfoIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CUSTOMER_IF(" ).append("\n"); 
		query.append("             CUST_IF_SEQ" ).append("\n"); 
		query.append("            ,CUST_CNT_CD  " ).append("\n"); 
		query.append("            ,CUST_SEQ" ).append("\n"); 
		query.append("            ,CUST_GRP_ID" ).append("\n"); 
		query.append("            ,CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("            ,CUST_LOCL_LANG_NM" ).append("\n"); 
		query.append("            ,CUST_ABBR_NM" ).append("\n"); 
		query.append("            ,CNTR_CUST_TP_CD" ).append("\n"); 
		query.append("            ,INDIV_CORP_DIV_CD" ).append("\n"); 
		query.append("            ,OFC_CD" ).append("\n"); 
		query.append("            ,FNDT_DT" ).append("\n"); 
		query.append("            ,CUST_RGST_NO" ).append("\n"); 
		query.append("            ,FINC_STS_LVL_CD" ).append("\n"); 
		query.append("            ,LOC_CD" ).append("\n"); 
		query.append("            ,CAPI_CURR_CD" ).append("\n"); 
		query.append("            ,CAPI_AMT" ).append("\n"); 
		query.append("            ,LSTK_FLG" ).append("\n"); 
		query.append("            ,EMPE_KNT" ).append("\n"); 
		query.append("            ,VNDR_SEQ" ).append("\n"); 
		query.append("            ,CUST_RMK" ).append("\n"); 
		query.append("            ,VBS_CLSS_CD" ).append("\n"); 
		query.append("            ,NBS_CLSS_CD1" ).append("\n"); 
		query.append("            ,NBS_CLSS_CD2" ).append("\n"); 
		query.append("            ,NBS_CLSS_CD3" ).append("\n"); 
		query.append("            ,NVOCC_CO_SCAC_CD" ).append("\n"); 
		query.append("            ,NVOCC_BD_NO" ).append("\n"); 
		query.append("            ,NVOCC_LIC_NO" ).append("\n"); 
		query.append("            ,NVOCC_BD_AMT" ).append("\n"); 
		query.append("            ,NVOCC_BD_ST_EFF_DT" ).append("\n"); 
		query.append("            ,NVOCC_BD_END_EFF_DT" ).append("\n"); 
		query.append("            ,INDUS_DESC" ).append("\n"); 
		query.append("            ,CRNT_VOL_KNT" ).append("\n"); 
		query.append("            ,CMPT_DESC" ).append("\n"); 
		query.append("            ,SPCL_REQ_DESC" ).append("\n"); 
		query.append("            ,PRF_SVC_DESC" ).append("\n"); 
		query.append("            ,PRF_SVC_DTL_DESC" ).append("\n"); 
		query.append("            ,PRF_GRP_CMDT_CD" ).append("\n"); 
		query.append("            ,PRF_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("            ,PRF_REP_CMDT_CD" ).append("\n"); 
		query.append("            ,SREP_CD" ).append("\n"); 
		query.append("            ,CTS_NO" ).append("\n"); 
		query.append("            ,FRT_FWRD_FMC_NO" ).append("\n"); 
		query.append("            ,KEY_ACCT_FLG" ).append("\n"); 
		query.append("            ,KEY_ACCT_ST_EFF_DT" ).append("\n"); 
		query.append("            ,KEY_ACCT_END_EFF_DT" ).append("\n"); 
		query.append("            ,SUBS_CO_CD" ).append("\n"); 
		query.append("            ,KEY_ACCT_MGR_USR_ID" ).append("\n"); 
		query.append("            ,KEY_ACCT_MGR_USR_NM" ).append("\n"); 
		query.append("            ,SLS_DELT_EFF_DT" ).append("\n"); 
		query.append("            ,NMD_CUST_FLG" ).append("\n"); 
		query.append("            ,MLT_TRD_ACCT_FLG" ).append("\n"); 
		query.append("            ,CUST_DIV_CD" ).append("\n"); 
		query.append("            ,MODI_CUST_CD" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,R3_INSF_ID         " ).append("\n"); 
		query.append("            ,R3_INSF_DV_CD" ).append("\n"); 
		query.append("            ,ECOM_INSF_ID" ).append("\n"); 
		query.append("            ,ECOM_INSF_DV_CD" ).append("\n"); 
		query.append("	        ,ADDR_TP_CD" ).append("\n"); 
		query.append("	        ,ADDR_SEQ" ).append("\n"); 
		query.append("			,PRMRY_CHK_FLG" ).append("\n"); 
		query.append("			,BZET_NM" ).append("\n"); 
		query.append("			,BZET_ADDR" ).append("\n"); 
		query.append("			,CTY_NM" ).append("\n"); 
		query.append("			,STE_CD" ).append("\n"); 
		query.append("			,ZIP_CD" ).append("\n"); 
		query.append("			,CNTC_EML" ).append("\n"); 
		query.append("			,CNTC_PSON_NM" ).append("\n"); 
		query.append("			,BZET_RMK" ).append("\n"); 
		query.append("			,LOCL_ADDR1" ).append("\n"); 
		query.append("			,LOCL_ADDR2" ).append("\n"); 
		query.append("			,LOCL_ADDR3" ).append("\n"); 
		query.append("			,LOCL_ADDR4" ).append("\n"); 
		query.append("			,CNT_CD" ).append("\n"); 
		query.append("	        ,CUST_CNTC_PNT_SEQ" ).append("\n"); 
		query.append("	        ,CUST_EML" ).append("\n"); 
		query.append("	        ,CUST_URL" ).append("\n"); 
		query.append("	        ,INTL_PHN_NO" ).append("\n"); 
		query.append("	        ,PHN_NO" ).append("\n"); 
		query.append("	        ,INTL_FAX_NO" ).append("\n"); 
		query.append("	        ,FAX_NO" ).append("\n"); 
		query.append("			,OPEDI_INSF_ID" ).append("\n"); 
		query.append("			,OPEDI_INSF_DV_CD" ).append("\n"); 
		query.append("            ,RAIL_ROAD_PRIO_FLG" ).append("\n"); 
		query.append("            ,MODI_CUST_CD2" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES(  @[cust_if_seq]" ).append("\n"); 
		query.append("            ,@[cust_cnt_cd]" ).append("\n"); 
		query.append("            ,@[cust_seq]" ).append("\n"); 
		query.append("            ,@[cust_grp_id]" ).append("\n"); 
		query.append("            ,@[cust_lgl_eng_nm]" ).append("\n"); 
		query.append("            ,@[cust_locl_lang_nm]" ).append("\n"); 
		query.append("            ,@[cust_abbr_nm]" ).append("\n"); 
		query.append("            ,@[cntr_cust_tp_cd]" ).append("\n"); 
		query.append("            ,@[indiv_corp_div_cd]" ).append("\n"); 
		query.append("            ,@[ofc_cd]" ).append("\n"); 
		query.append("            ,TO_CHAR(TO_DATE(@[fndt_dt], 'YYYY-MM-DD'), 'YYYYMMDD')" ).append("\n"); 
		query.append("            ,@[cust_rgst_no]" ).append("\n"); 
		query.append("            ,@[finc_sts_lvl_cd]" ).append("\n"); 
		query.append("            ,@[loc_cd]" ).append("\n"); 
		query.append("            ,@[capi_curr_cd]" ).append("\n"); 
		query.append("            ,@[capi_amt]" ).append("\n"); 
		query.append("            ,@[lstk_flg]" ).append("\n"); 
		query.append("            ,@[empe_knt]" ).append("\n"); 
		query.append("            ,@[vndr_seq]" ).append("\n"); 
		query.append("            ,@[cust_rmk]" ).append("\n"); 
		query.append("            ,@[vbs_clss_cd]" ).append("\n"); 
		query.append("            ,@[nbs_clss_cd1]" ).append("\n"); 
		query.append("            ,@[nbs_clss_cd2]" ).append("\n"); 
		query.append("            ,@[nbs_clss_cd3]" ).append("\n"); 
		query.append("            ,@[nvocc_co_scac_cd]" ).append("\n"); 
		query.append("            ,@[nvocc_bd_no]" ).append("\n"); 
		query.append("            ,@[nvocc_lic_no]" ).append("\n"); 
		query.append("            ,@[nvocc_bd_amt]" ).append("\n"); 
		query.append("            ,TO_CHAR(TO_DATE(@[nvocc_bd_st_eff_dt], 'YYYY-MM-DD'), 'YYYYMMDD')" ).append("\n"); 
		query.append("            ,TO_CHAR(TO_DATE(@[nvocc_bd_end_eff_dt], 'YYYY-MM-DD'), 'YYYYMMDD')" ).append("\n"); 
		query.append("            ,@[indus_desc]" ).append("\n"); 
		query.append("            ,@[crnt_vol_knt]" ).append("\n"); 
		query.append("            ,@[cmpt_desc]" ).append("\n"); 
		query.append("            ,@[spcl_req_desc]" ).append("\n"); 
		query.append("            ,@[prf_svc_desc]" ).append("\n"); 
		query.append("            ,@[prf_svc_dtl_desc]" ).append("\n"); 
		query.append("            ,@[prf_grp_cmdt_cd]" ).append("\n"); 
		query.append("            ,@[prf_cntr_tpsz_cd]" ).append("\n"); 
		query.append("            ,@[prf_rep_cmdt_cd]" ).append("\n"); 
		query.append("            ,@[srep_cd]" ).append("\n"); 
		query.append("            ,@[cts_no]" ).append("\n"); 
		query.append("            ,@[frt_fwrd_fmc_no]" ).append("\n"); 
		query.append("            ,@[key_acct_flg]" ).append("\n"); 
		query.append("            ,TO_DATE(@[key_acct_st_eff_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            ,TO_DATE(@[key_acct_end_eff_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("            ,@[subs_co_cd]" ).append("\n"); 
		query.append("            ,@[key_acct_mgr_usr_id]" ).append("\n"); 
		query.append("            ,@[key_acct_mgr_usr_nm]" ).append("\n"); 
		query.append("            ,TO_CHAR(TO_DATE(@[sls_delt_eff_dt], 'YYYY-MM-DD'), 'YYYYMMDD')" ).append("\n"); 
		query.append("            ,@[nmd_cust_flg]" ).append("\n"); 
		query.append("            ,@[mlt_trd_acct_flg]" ).append("\n"); 
		query.append("            ,@[cust_div_cd]" ).append("\n"); 
		query.append("            ,@[modi_cust_cd]" ).append("\n"); 
		query.append("			,NVL((SELECT CRE_USR_ID" ).append("\n"); 
		query.append("			     FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("			     WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("			     AND CUST_SEQ = @[cust_seq]),@[cre_usr_id])" ).append("\n"); 
		query.append("			,NVL((SELECT CRE_DT" ).append("\n"); 
		query.append("			     FROM MDM_CUSTOMER " ).append("\n"); 
		query.append("			     WHERE CUST_CNT_CD = @[cust_cnt_cd]" ).append("\n"); 
		query.append("			     AND CUST_SEQ = @[cust_seq]),SYSDATE)" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[delt_flg]" ).append("\n"); 
		query.append("            ,@[r3_insf_id]" ).append("\n"); 
		query.append("            ,@[r3_insf_dv_cd]" ).append("\n"); 
		query.append("            ,@[ecom_insf_id]" ).append("\n"); 
		query.append("            ,@[ecom_insf_dv_cd]" ).append("\n"); 
		query.append("	        ,@[addr_tp_cd]" ).append("\n"); 
		query.append("	        ,@[addr_seq]" ).append("\n"); 
		query.append("			,@[prmry_chk_flg]" ).append("\n"); 
		query.append("			,@[bzet_nm]" ).append("\n"); 
		query.append("			,@[bzet_addr]" ).append("\n"); 
		query.append("			,@[cty_nm]" ).append("\n"); 
		query.append("			,@[ste_cd]" ).append("\n"); 
		query.append("			,@[zip_cd]" ).append("\n"); 
		query.append("			,@[cntc_eml]" ).append("\n"); 
		query.append("			,@[cntc_pson_nm]" ).append("\n"); 
		query.append("			,@[bzet_rmk]" ).append("\n"); 
		query.append("			,@[locl_addr1]" ).append("\n"); 
		query.append("			,@[locl_addr2]" ).append("\n"); 
		query.append("			,@[locl_addr3]" ).append("\n"); 
		query.append("			,@[locl_addr4]" ).append("\n"); 
		query.append("			,@[cnt_cd]" ).append("\n"); 
		query.append("	        ,@[cust_cntc_pnt_seq]" ).append("\n"); 
		query.append("	        ,@[cust_eml]" ).append("\n"); 
		query.append("	        ,@[cust_url]" ).append("\n"); 
		query.append("	        ,@[intl_phn_no]" ).append("\n"); 
		query.append("	        ,@[phn_no]" ).append("\n"); 
		query.append("	        ,@[intl_fax_no]" ).append("\n"); 
		query.append("	        ,@[fax_no]" ).append("\n"); 
		query.append("	        ,@[opedi_insf_id]" ).append("\n"); 
		query.append("	        ,@[opedi_insf_dv_cd]" ).append("\n"); 
		query.append("            ,@[rail_road_prio_flg]" ).append("\n"); 
		query.append("            ,@[modi_cust_cd2]" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}