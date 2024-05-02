/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CustRequestDBDAOModifyCustRqstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.22
*@LastModifier : 
*@LastVersion : 1.0
* 2017.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustRequestDBDAOModifyCustRqstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer rqst update
	  * </pre>
	  */
	public CustRequestDBDAOModifyCustRqstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bzet_addr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvocc_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grp_indiv_div",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_alt_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_alt_msg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rvis_cntr_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvocc_bd_st_eff_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crnt_vol_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nvocc_hjs_scac_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_alt_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sam.custmanage.custrequest.integration").append("\n"); 
		query.append("FileName : CustRequestDBDAOModifyCustRqstUSQL").append("\n"); 
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
		query.append("UPDATE MDM_CUSTOMER_RQST" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("   CUST_LGL_ENG_NM                     = UPPER(@[cust_lgl_eng_nm])" ).append("\n"); 
		query.append(",  GRP_INDIV_DIV                       = NVL(@[grp_indiv_div],'I')" ).append("\n"); 
		query.append(",  BZET_ADDR                           = @[bzet_addr]" ).append("\n"); 
		query.append(",  CUST_RGST_NO                        = @[cust_rgst_no]                                                          " ).append("\n"); 
		query.append(",  NMD_CUST_FLG                        = NVL(@[nmd_cust_flg],'N')" ).append("\n"); 
		query.append(",  LOC_CD                              = @[loc_cd]                                                                " ).append("\n"); 
		query.append(",  OFC_CD                              = @[ofc_cd]                                                                " ).append("\n"); 
		query.append(",  SREP_CD                             = @[srep_cd]                                                               " ).append("\n"); 
		query.append(",  RVIS_CNTR_CUST_TP_CD                = @[rvis_cntr_cust_tp_cd]                                                  " ).append("\n"); 
		query.append(",  CTS_NO                              = @[cts_no]                                                                " ).append("\n"); 
		query.append(",  CUST_GRP_ID                         = @[cust_grp_id]                                                           " ).append("\n"); 
		query.append(",  PRF_SVC_DESC                        = @[prf_svc_desc]                                                          " ).append("\n"); 
		query.append(",  PRF_SVC_DTL_DESC                    = @[prf_svc_dtl_desc]                                                      " ).append("\n"); 
		query.append(",  INTL_PHN_NO 	                       = @[intl_phn_no]" ).append("\n"); 
		query.append(",  PHN_NO                              = @[phn_no]" ).append("\n"); 
		query.append(",  INTL_FAX_NO                         = @[intl_fax_no]" ).append("\n"); 
		query.append(",  FAX_NO                              = @[fax_no]" ).append("\n"); 
		query.append(",  CUST_EML                            = @[cust_eml]" ).append("\n"); 
		query.append(",  CUST_URL                            = @[cust_url]" ).append("\n"); 
		query.append(",  CMPT_DESC                           = @[cmpt_desc]                                                             " ).append("\n"); 
		query.append(",  SPCL_REQ_DESC                       = @[spcl_req_desc]                                                         " ).append("\n"); 
		query.append(",  PRF_CNTR_TPSZ_CD                    = @[prf_cntr_tpsz_cd]                                                      " ).append("\n"); 
		query.append(",  CRNT_VOL_KNT                        = @[crnt_vol_knt]                                                          " ).append("\n"); 
		query.append(",  NEW_KEY_ACCT_FLG                    = @[new_key_acct_flg]                                                      " ).append("\n"); 
		query.append(",  RGN_ACCT_FLG                        = @[rgn_acct_flg]                                                          " ).append("\n"); 
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
		query.append(",  NVOCC_BD_END_EFF_DT                 = TO_CHAR(TO_DATE(@[nvocc_bd_end_eff_dt], 'YYYY-MM-DD'), 'YYYYMMDD') " ).append("\n"); 
		query.append(",  OTI_ORZ_NO                          = @[oti_orz_no]" ).append("\n"); 
		query.append(",  FRT_FWRD_FMC_NO                     = @[frt_fwrd_fmc_no]                                                       " ).append("\n"); 
		query.append(",  UPD_USR_ID                          = @[upd_usr_id]                                                            " ).append("\n"); 
		query.append(",  UPD_DT                              = sysdate                                                                  " ).append("\n"); 
		query.append(",  DELT_FLG                            = NVL(@[delt_flg],'N')" ).append("\n"); 
		query.append(",  CUST_CNT_CD                         = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append(",  CUST_SEQ                            = SUBSTR(@[cust_cd],3,6)" ).append("\n"); 
		query.append("WHERE  MDM_CUSTOMER_RQST_SEQ = @[rqst_no]" ).append("\n"); 

	}
}