/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOSearchHistBkgXptImpLicRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOSearchHistBkgXptImpLicRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BookingHistoryMgtDBDAOSearchHistBkgXptImpLicRSQL
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOSearchHistBkgXptImpLicRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divd_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_imp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_ptu_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("caed_no3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("caed_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_tax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("id_xpt_no_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divd_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sam_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_expt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_tax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("id_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g7_edi_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("id_xpt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("caed_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("caed_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_expt_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brz_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_ptu_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_pta_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_pta_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_inlnd_trns_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfy_tax_cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpt_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("id_decl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_ptu_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ndr_ref_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_inlnd_trns_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_smry_rpt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divd_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aus_mf_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnee_tax_cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brz_decl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_pta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sam_pck_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sam_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_tax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_dwn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_ctrl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ndr_ref_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ndr_ref_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g7_edi_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g7_edi_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_ctrl_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_iec_cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divd_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_dwn_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b13a_xpt_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b13a_xpt_no1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b13a_xpt_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("brz_decl_cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("caed_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b13a_xpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_smry_rpt_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_pta_pfx_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ucr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_tax_cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_iec_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aes_dwn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divd_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOSearchHistBkgXptImpLicRSQL").append("\n"); 
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
		query.append("WITH OLD AS" ).append("\n"); 
		query.append("(SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append(", @[io_bnd_cd] IO_BND_CD" ).append("\n"); 
		query.append(", @[xpt_imp_seq] XPT_IMP_SEQ" ).append("\n"); 
		query.append(", @[cnt_cd] CNT_CD" ).append("\n"); 
		query.append(", @[xpt_lic_no] XPT_LIC_NO" ).append("\n"); 
		query.append(", @[ts_ref_no] TS_REF_NO" ).append("\n"); 
		query.append(", @[pck_qty] PCK_QTY" ).append("\n"); 
		query.append(", @[pck_tp_cd] PCK_TP_CD" ).append("\n"); 
		query.append(", @[mf_wgt] MF_WGT" ).append("\n"); 
		query.append(", @[wgt_ut_cd] WGT_UT_CD" ).append("\n"); 
		query.append(", @[divd_flg] DIVD_FLG" ).append("\n"); 
		query.append(", @[divd_seq] DIVD_SEQ" ).append("\n"); 
		query.append(", @[divd_pck_qty] DIVD_PCK_QTY" ).append("\n"); 
		query.append(", @[divd_pck_tp_cd] DIVD_PCK_TP_CD" ).append("\n"); 
		query.append(", @[divd_wgt] DIVD_WGT" ).append("\n"); 
		query.append(", @[divd_wgt_ut_cd] DIVD_WGT_UT_CD" ).append("\n"); 
		query.append(", @[sam_pck_id] SAM_PCK_ID" ).append("\n"); 
		query.append(", @[sam_pck_qty] SAM_PCK_QTY" ).append("\n"); 
		query.append(", @[sam_pck_tp_cd] SAM_PCK_TP_CD" ).append("\n"); 
		query.append(", @[ucr_no] UCR_NO" ).append("\n"); 
		query.append(", @[aus_mf_ref_no] AUS_MF_REF_NO" ).append("\n"); 
		query.append(", @[aes_tp_cd] AES_TP_CD" ).append("\n"); 
		query.append(", @[aes_inlnd_trns_pfx_ctnt] AES_INLND_TRNS_PFX_CTNT" ).append("\n"); 
		query.append(", @[aes_inlnd_trns_no] AES_INLND_TRNS_NO" ).append("\n"); 
		query.append(", @[aes_pta_pfx_ctnt] AES_PTA_PFX_CTNT" ).append("\n"); 
		query.append(", @[aes_pta_no1] AES_PTA_NO1" ).append("\n"); 
		query.append(", @[aes_pta_no2] AES_PTA_NO2" ).append("\n"); 
		query.append(", @[aes_pta_dt] AES_PTA_DT" ).append("\n"); 
		query.append(", @[aes_ptu_pfx_ctnt] AES_PTU_PFX_CTNT" ).append("\n"); 
		query.append(", @[aes_ptu_no] AES_PTU_NO" ).append("\n"); 
		query.append(", @[aes_ptu_dt] AES_PTU_DT" ).append("\n"); 
		query.append(", @[aes_dwn_pfx_ctnt] AES_DWN_PFX_CTNT" ).append("\n"); 
		query.append(", @[aes_dwn_no] AES_DWN_NO" ).append("\n"); 
		query.append(", @[aes_dwn_dt] AES_DWN_DT" ).append("\n"); 
		query.append(", @[aes_expt_id] AES_EXPT_ID" ).append("\n"); 
		query.append(", @[aes_expt_ctnt] AES_EXPT_CTNT" ).append("\n"); 
		query.append(", @[shpr_tax_no] SHPR_TAX_NO" ).append("\n"); 
		query.append(", @[shpr_tax_cpy_desc_flg] SHPR_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(", @[cnee_tax_no] CNEE_TAX_NO" ).append("\n"); 
		query.append(", @[cnee_tax_cpy_desc_flg] CNEE_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(", @[ntfy_tax_no] NTFY_TAX_NO" ).append("\n"); 
		query.append(", @[ntfy_tax_cpy_desc_flg] NTFY_TAX_CPY_DESC_FLG" ).append("\n"); 
		query.append(", @[brz_decl_no] BRZ_DECL_NO" ).append("\n"); 
		query.append(", @[brz_decl_cpy_desc_flg] BRZ_DECL_CPY_DESC_FLG" ).append("\n"); 
		query.append(", @[brz_cmdt_cd] BRZ_CMDT_CD" ).append("\n"); 
		query.append(", @[id_decl_cd] ID_DECL_CD" ).append("\n"); 
		query.append(", @[id_xpt_no] ID_XPT_NO" ).append("\n"); 
		query.append(", @[id_xpt_no_iss_dt] ID_XPT_NO_ISS_DT" ).append("\n"); 
		query.append(", @[id_ofc_cd] ID_OFC_CD" ).append("\n"); 
		query.append(", @[ida_iec_no] IDA_IEC_NO" ).append("\n"); 
		query.append(", @[ida_iec_cpy_desc_flg] IDA_IEC_CPY_DESC_FLG" ).append("\n"); 
		query.append(", @[caed_tp_cd] CAED_TP_CD" ).append("\n"); 
		query.append(", @[caed_pfx_ctnt] CAED_PFX_CTNT" ).append("\n"); 
		query.append(", @[caed_no1] CAED_NO1" ).append("\n"); 
		query.append(", @[caed_no2] CAED_NO2" ).append("\n"); 
		query.append(", @[caed_no3] CAED_NO3" ).append("\n"); 
		query.append(", @[g7_edi_pfx_ctnt] G7_EDI_PFX_CTNT" ).append("\n"); 
		query.append(", @[g7_edi_no1] G7_EDI_NO1" ).append("\n"); 
		query.append(", @[g7_edi_no2] G7_EDI_NO2" ).append("\n"); 
		query.append(", @[b13a_xpt_pfx_ctnt] B13A_XPT_PFX_CTNT" ).append("\n"); 
		query.append(", @[b13a_xpt_dt] B13A_XPT_DT" ).append("\n"); 
		query.append(", @[b13a_xpt_no1] B13A_XPT_NO1" ).append("\n"); 
		query.append(", @[b13a_xpt_no2] B13A_XPT_NO2" ).append("\n"); 
		query.append(", @[mf_smry_rpt_pfx_ctnt] MF_SMRY_RPT_PFX_CTNT" ).append("\n"); 
		query.append(", @[mf_smry_rpt_no] MF_SMRY_RPT_NO" ).append("\n"); 
		query.append(", @[cgo_ctrl_pfx_ctnt] CGO_CTRL_PFX_CTNT" ).append("\n"); 
		query.append(", @[cgo_ctrl_no] CGO_CTRL_NO" ).append("\n"); 
		query.append(", @[ndr_ref_pfx_ctnt] NDR_REF_PFX_CTNT" ).append("\n"); 
		query.append(", @[ndr_ref_id] NDR_REF_ID" ).append("\n"); 
		query.append(", @[ndr_ref_ctnt] NDR_REF_CTNT" ).append("\n"); 
		query.append("FROM DUAL)" ).append("\n"); 
		query.append("SELECT HIS_CATE_NM" ).append("\n"); 
		query.append("     , PRE_CTNT" ).append("\n"); 
		query.append("     , CRNT_CTNT" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT DECODE(OLD.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||' INFORMATION-KOREA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.XPT_LIC_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.TS_REF_NO||" ).append("\n"); 
		query.append("                  '/PACKAGE:@['||OLD.PCK_QTY||' '||OLD.PCK_TP_CD||" ).append("\n"); 
		query.append("                  '/WEIGHT:@['||OLD.MF_WGT||' '||OLD.WGT_UT_CD||" ).append("\n"); 
		query.append("                  '/UCR:@['||OLD.UCR_NO PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.XPT_LIC_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.TS_REF_NO||" ).append("\n"); 
		query.append("                  '/PACKAGE:@['||NOW.PCK_QTY||' '||NOW.PCK_TP_CD||" ).append("\n"); 
		query.append("                  '/WEIGHT:@['||NOW.MF_WGT||' '||NOW.WGT_UT_CD||" ).append("\n"); 
		query.append("                  '/UCR:@['||NOW.UCR_NO CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD   (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.XPT_IMP_SEQ (+) = OLD.XPT_IMP_SEQ" ).append("\n"); 
		query.append("           AND OLD.CNT_CD          = 'KR'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(OLD.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||'-USA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , TRIM(" ).append("\n"); 
		query.append("                  DECODE(OLD.AES_INLND_TRNS_NO, '','','AES ITN:')||OLD.AES_INLND_TRNS_NO||" ).append("\n"); 
		query.append("                  DECODE(OLD.AES_PTA_NO1, '','','PTA:')||OLD.AES_PTA_NO1||' '||OLD.AES_PTA_NO2||' '||TO_CHAR(TO_DATE(OLD.AES_PTA_DT, 'YYYY-MM-DD HH24:MI:SS'),'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(OLD.AES_PTU_NO, '','','PTU:')||OLD.AES_PTU_NO||' '||TO_CHAR(TO_DATE(OLD.AES_PTU_DT, 'YYYY-MM-DD HH24:MI:SS'),'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(OLD.AES_DWN_NO, '','','DOWN:')||OLD.AES_DWN_NO||' '||TO_CHAR(TO_DATE(OLD.AES_DWN_DT, 'YYYY-MM-DD HH24:MI:SS'),'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(OLD.AES_EXPT_ID, '','','EXCEPTION:')||(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                                 WHERE INTG_CD_ID = 'CD02570'" ).append("\n"); 
		query.append("                                                                   AND INTG_CD_VAL_CTNT = OLD.AES_EXPT_ID)||" ).append("\n"); 
		query.append("                  DECODE(OLD.AES_EXPT_CTNT, '','','EXCEPTION:')||' '||OLD.AES_EXPT_CTNT) PRE_CTNT " ).append("\n"); 
		query.append("                , TRIM(" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_INLND_TRNS_NO, '','','AES ITN:')||NOW.AES_INLND_TRNS_NO|| " ).append("\n"); 
		query.append("                  DECODE(NOW.AES_PTA_NO1, '','','PTA:')||NOW.AES_PTA_NO1||' '||NOW.AES_PTA_NO2||' '||TO_CHAR(NOW.AES_PTA_DT,'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_PTU_NO, '','','PTU:')||NOW.AES_PTU_NO||' '||TO_CHAR(NOW.AES_PTU_DT,'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_DWN_NO, '','','DOWN:')||NOW.AES_DWN_NO||' '||TO_CHAR(NOW.AES_DWN_DT,'MM-DD-YYYY')||" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_EXPT_ID, '','','EXCEPTION:')||(SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("                                                                  FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("                                                                 WHERE INTG_CD_ID = 'CD02570'" ).append("\n"); 
		query.append("                                                                   AND INTG_CD_VAL_CTNT = NOW.AES_EXPT_ID)||" ).append("\n"); 
		query.append("                  DECODE(NOW.AES_EXPT_CTNT, '','','EXCEPTION:')||' '||NOW.AES_EXPT_CTNT) CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD   (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.XPT_IMP_SEQ (+) = OLD.XPT_IMP_SEQ" ).append("\n"); 
		query.append("           AND OLD.CNT_CD          = 'US'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(OLD.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||' INFORMATION-INDONESIA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.ID_DECL_CD||" ).append("\n"); 
		query.append("                  '/'||OLD.ID_XPT_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.ID_XPT_NO_ISS_DT||" ).append("\n"); 
		query.append("                  '/'||OLD.ID_OFC_CD PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.ID_DECL_CD||" ).append("\n"); 
		query.append("                  '/'||NOW.ID_XPT_NO||" ).append("\n"); 
		query.append("                  '/'||TO_CHAR(NOW.ID_XPT_NO_ISS_DT, 'YYYY-MM-DD HH24:MI:SS')||" ).append("\n"); 
		query.append("                  '/'||NOW.ID_OFC_ID CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD   (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.XPT_IMP_SEQ (+) = OLD.XPT_IMP_SEQ" ).append("\n"); 
		query.append("           AND OLD.CNT_CD          = 'ID'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(OLD.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||' INFORMATION-INDIA' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.IDA_IEC_NO PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.IDA_IEC_NO CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD   (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.XPT_IMP_SEQ (+) = OLD.XPT_IMP_SEQ" ).append("\n"); 
		query.append("           AND OLD.CNT_CD          = 'IN'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(OLD.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||' INFORMATION-BRAZIL' HIS_CATE_NM" ).append("\n"); 
		query.append("                , OLD.SHPR_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.CNEE_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.NTFY_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||OLD.BRZ_DECL_NO PRE_CTNT" ).append("\n"); 
		query.append("                , NOW.SHPR_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.CNEE_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.NTFY_TAX_NO||" ).append("\n"); 
		query.append("                  '/'||NOW.BRZ_DECL_NO CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD   (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.XPT_IMP_SEQ (+) = OLD.XPT_IMP_SEQ" ).append("\n"); 
		query.append("           AND OLD.CNT_CD          = 'BR'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT DECODE(OLD.IO_BND_CD, 'O', 'EXPORT', 'IMPORT')||'-CANADA' HIS_CATE_NM" ).append("\n"); 
		query.append("              ,TRIM(" ).append("\n"); 
		query.append("                 DECODE(OLD.CAED_NO1, '','','CAED:')||OLD.CAED_NO1||OLD.CAED_NO2||OLD.CAED_NO3||" ).append("\n"); 
		query.append("                 DECODE(OLD.G7_EDI_NO1, '','','G7 EDI:')||OLD.G7_EDI_NO1||OLD.G7_EDI_NO2||" ).append("\n"); 
		query.append("                 DECODE(OLD.B13A_XPT_NO1, '','','B13A:')||TO_CHAR(TO_DATE(OLD.B13A_XPT_DT, 'YYYYMMDDHH24MI'),'YYYYMMDDHH24MI')||' '||OLD.B13A_XPT_NO1||OLD.B13A_XPT_NO2||" ).append("\n"); 
		query.append("                 DECODE(OLD.MF_SMRY_RPT_NO, '','','SUM:')||OLD.MF_SMRY_RPT_NO||" ).append("\n"); 
		query.append("                 DECODE(OLD.CGO_CTRL_NO, '','','IN-TRANSIT:')||OLD.CGO_CTRL_NO||" ).append("\n"); 
		query.append("                 DECODE(OLD.NDR_REF_ID, '','','NDR:')||OLD.NDR_REF_ID) PRE_CTNT" ).append("\n"); 
		query.append("              ,TRIM(" ).append("\n"); 
		query.append("                 DECODE(NOW.CAED_NO1, '','','CAED:')||NOW.CAED_NO1||NOW.CAED_NO2||NOW.CAED_NO3||" ).append("\n"); 
		query.append("                 DECODE(NOW.G7_EDI_NO1, '','','G7 EDI:')||NOW.G7_EDI_NO1||NOW.G7_EDI_NO2||" ).append("\n"); 
		query.append("                 DECODE(NOW.B13A_XPT_NO1, '','','B13A:')||TO_CHAR(NOW.B13A_XPT_DT, 'YYYYMMDDHH24MI')||' '||NOW.B13A_XPT_NO1||NOW.B13A_XPT_NO2||" ).append("\n"); 
		query.append("                 DECODE(NOW.MF_SMRY_RPT_NO, '','','SUM:')||NOW.MF_SMRY_RPT_NO||" ).append("\n"); 
		query.append("                 DECODE(NOW.CGO_CTRL_NO, '','','IN-TRANSIT:')||NOW.CGO_CTRL_NO||" ).append("\n"); 
		query.append("                 DECODE(NOW.NDR_REF_ID, '','','NDR:')||NOW.NDR_REF_ID) CRNT_CTNT" ).append("\n"); 
		query.append("          FROM OLD" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC_HIS NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("	       AND NOW.CORR_NO     (+) = 'TMP0000001' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             , BKG_XPT_IMP_LIC NOW" ).append("\n"); 
		query.append("         WHERE NOW.BKG_NO      (+) = OLD.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           AND NOW.IO_BND_CD   (+) = OLD.IO_BND_CD" ).append("\n"); 
		query.append("           AND NOW.XPT_IMP_SEQ (+) = OLD.XPT_IMP_SEQ" ).append("\n"); 
		query.append("           AND OLD.CNT_CD          = 'CA'" ).append("\n"); 
		query.append("    )    " ).append("\n"); 
		query.append(" WHERE NVL(TRIM(PRE_CTNT), ' ') <> NVL(TRIM(CRNT_CTNT), ' ')" ).append("\n"); 

	}
}