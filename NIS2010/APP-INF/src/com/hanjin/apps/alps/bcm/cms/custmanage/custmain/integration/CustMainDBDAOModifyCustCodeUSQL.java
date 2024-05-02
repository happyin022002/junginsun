/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustMainDBDAOModifyCustCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.07
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustMainDBDAOModifyCustCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Main update
	  * </pre>
	  */
	public CustMainDBDAOModifyCustCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("nbs_clss_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_alt_msg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("oti_orz_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prf_svc_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_pan_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rvis_cntr_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("co_chn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("subs_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_key_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_acct_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvocc_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_spcl_ecn_zn_ut_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_cust_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("id_npwp_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_alt_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_alt_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_gst_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_alt_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vbs_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvocc_bd_st_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_co_type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvocc_hjs_scac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_chn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nvocc_bd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custmain.integration").append("\n"); 
		query.append("FileName : CustMainDBDAOModifyCustCodeUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CUSTOMER" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("   CUST_LGL_ENG_NM                     = UPPER(@[cust_lgl_eng_nm])" ).append("\n"); 
		query.append(",  CUST_LOCL_LANG_NM                   = @[cust_locl_lang_nm]                                                     " ).append("\n"); 
		query.append(",  CUST_ABBR_NM                        = @[cust_abbr_nm]                                                          " ).append("\n"); 
		query.append(",  CUST_RGST_NO                        = @[cust_rgst_no]                                                          " ).append("\n"); 
		query.append(",  NMD_CUST_FLG                        = NVL(@[nmd_cust_flg],'N')" ).append("\n"); 
		query.append(",  LOC_CD                              = @[loc_cd]                                                                " ).append("\n"); 
		query.append(",  OFC_CD                              = @[ofc_cd]                                                                " ).append("\n"); 
		query.append(",  SREP_CD                             = @[srep_cd]                                                               " ).append("\n"); 
		query.append(",  INDIV_CORP_DIV_CD                   = @[indiv_corp_div_cd]                                                     " ).append("\n"); 
		query.append(",  RVIS_CNTR_CUST_TP_CD                = @[rvis_cntr_cust_tp_cd]                                                  " ).append("\n"); 
		query.append(",  CTS_NO                              = @[cts_no]                                                                " ).append("\n"); 
		query.append(",  CUST_GRP_ID                         = @[cust_grp_id]                                                           " ).append("\n"); 
		query.append(",  VBS_CLSS_CD                         = @[vbs_clss_cd]                                                           " ).append("\n"); 
		query.append(",  NBS_CLSS_CD1                        = @[nbs_clss_cd1]                                                          " ).append("\n"); 
		query.append(",  NBS_CLSS_CD2                        = @[nbs_clss_cd2]                                                          " ).append("\n"); 
		query.append(",  NBS_CLSS_CD3                        = @[nbs_clss_cd3]                                                          " ).append("\n"); 
		query.append(",  INDUS_DESC                          = @[indus_desc]                                                            " ).append("\n"); 
		query.append(",  PRF_SVC_DESC                        = @[prf_svc_desc]                                                          " ).append("\n"); 
		query.append(",  PRF_SVC_DTL_DESC                    = @[prf_svc_dtl_desc]                                                      " ).append("\n"); 
		query.append(",  CMPT_DESC                           = @[cmpt_desc]                                                             " ).append("\n"); 
		query.append(",  SPCL_REQ_DESC                       = @[spcl_req_desc]                                                         " ).append("\n"); 
		query.append(",  PRF_CNTR_TPSZ_CD                    = @[prf_cntr_tpsz_cd]                                                      " ).append("\n"); 
		query.append(",  CRNT_VOL_KNT                        = @[crnt_vol_knt]                                                          " ).append("\n"); 
		query.append(",  NEW_KEY_ACCT_FLG                    = NVL(@[new_key_acct_flg],'N')" ).append("\n"); 
		query.append(",  RGN_ACCT_FLG                        = NVL(@[rgn_acct_flg],'N')" ).append("\n"); 
		query.append(",  CUST_RMK                            = @[cust_rmk]                                                              " ).append("\n"); 
		query.append(",  BKG_ALT_RSN                         = @[bkg_alt_rsn]                                                           " ).append("\n"); 
		query.append(",  bkg_alt_fm_dt                       = TO_DATE(@[bkg_alt_fm_dt], 'YYYY-MM-DD')                                  " ).append("\n"); 
		query.append(",  bkg_alt_to_dt                       = TO_DATE(@[bkg_alt_to_dt], 'YYYY-MM-DD')                                  " ).append("\n"); 
		query.append(",  BKG_ALT_MSG                         = @[bkg_alt_msg]                                                           " ).append("\n"); 
		query.append(",  NVOCC_HJS_SCAC_CD                   = @[nvocc_hjs_scac_cd]                                                     " ).append("\n"); 
		query.append(",  NVOCC_BD_NO                         = @[nvocc_bd_no]                                                           " ).append("\n"); 
		query.append(",  NVOCC_LIC_NO                        = @[nvocc_lic_no]                                                          " ).append("\n"); 
		query.append(",  NVOCC_BD_AMT                        = @[nvocc_bd_amt]                                                          " ).append("\n"); 
		query.append(",  NVOCC_BD_ST_EFF_DT                  = TO_CHAR(TO_DATE(@[nvocc_bd_st_eff_dt], 'YYYY-MM-DD'), 'YYYYMMDD')        " ).append("\n"); 
		query.append(",  NVOCC_BD_END_EFF_DT                 = TO_CHAR(TO_DATE(@[nvocc_bd_end_eff_dt], 'YYYY-MM-DD'), 'YYYYMMDD')  " ).append("\n"); 
		query.append(",  SLS_DELT_EFF_DT                     = REPLACE(@[sls_delt_eff_dt],'-','')" ).append("\n"); 
		query.append(",  OTI_ORZ_NO                          = @[oti_orz_no]" ).append("\n"); 
		query.append(",  FRT_FWRD_FMC_NO                     = @[frt_fwrd_fmc_no]                                                       " ).append("\n"); 
		query.append(",  ida_pan_no                          = @[ida_pan_no]                                                            " ).append("\n"); 
		query.append(",  ida_gst_rgst_no                     = @[ida_gst_rgst_no]                                                       " ).append("\n"); 
		query.append(",  IDA_SPCL_ECN_ZN_UT_FLG              = @[ida_spcl_ecn_zn_ut_flg]   " ).append("\n"); 
		query.append(",  IDA_CO_TYPE_CD					   = @[ida_co_type_cd]" ).append("\n"); 
		query.append(",  IDA_CUST_EML                        = @[ida_cust_eml]" ).append("\n"); 
		query.append(",  SUBS_CO_CD                          = @[subs_co_cd]" ).append("\n"); 
		query.append(",  UPD_USR_ID                          = @[upd_usr_id]" ).append("\n"); 
		query.append(",  UPD_DT                              = sysdate" ).append("\n"); 
		query.append(",  DELT_FLG                            = nvl(@[delt_flg],'N')" ).append("\n"); 
		query.append(",  VNDR_SEQ                            = @[vndr_seq]" ).append("\n"); 
		query.append(",  CO_CHN_TP_CD                        = @[co_chn_tp_cd]" ).append("\n"); 
		query.append(",  CO_CHN_NO                           = @[co_chn_no]" ).append("\n"); 
		query.append(",  ID_NPWP_RGST_NO					   = @[id_npwp_rgst_no]" ).append("\n"); 
		query.append("WHERE  CUST_CNT_CD    = @[cust_cnt_cd]" ).append("\n"); 
		query.append("AND CUST_SEQ          = @[cust_seq]" ).append("\n"); 

	}
}