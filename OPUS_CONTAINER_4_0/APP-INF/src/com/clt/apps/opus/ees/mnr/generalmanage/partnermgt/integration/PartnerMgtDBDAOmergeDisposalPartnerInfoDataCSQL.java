/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerMgtDBDAOmergeDisposalPartnerInfoDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PartnerMgtDBDAOmergeDisposalPartnerInfoDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PartnerMgtDBDAOmergeDisposalPartnerInfoDataCSQL
	  * </pre>
	  */
	public PartnerMgtDBDAOmergeDisposalPartnerInfoDataCSQL(){
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
		params.put("trsm_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bztp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_acct_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_prnr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_swift_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_prnr_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_knd_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ownr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cre_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pay_term_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_bil_to_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_payr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_prnr_capi_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dpt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzct_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bank_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_payr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.integration").append("\n"); 
		query.append("FileName : PartnerMgtDBDAOmergeDisposalPartnerInfoDataCSQL").append("\n"); 
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
		query.append("MERGE INTO MNR_PARTNER A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("   ON (MNR_PRNR_CRE_SEQ = @[mnr_prnr_cre_seq])" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append(" UPDATE " ).append("\n"); 
		query.append("     SET A.CTRL_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("        ,A.MNR_GRP_TP_CD = @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_TP_CD = DECODE(@[mnr_grp_tp_cd],'RPR','S','B')" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_KND_CD = @[mnr_prnr_knd_cd]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_KND_DTL_CD = @[mnr_prnr_knd_dtl_cd]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_STS_CD = @[mnr_prnr_sts_cd]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_CNT_CD = @[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_SEQ = @[mnr_prnr_seq]" ).append("\n"); 
		query.append("        ,A.EDI_ID = @[edi_id]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_LGL_ENG_NM = @[mnr_prnr_lgl_eng_nm]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_LOCL_LANG_NM = @[mnr_prnr_locl_lang_nm]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_ADDR = @[mnr_prnr_addr]" ).append("\n"); 
		query.append("        ,A.BZET_ADDR = @[bzet_addr]" ).append("\n"); 
		query.append("        ,A.MNR_BIL_TO_NM = @[mnr_bil_to_nm]" ).append("\n"); 
		query.append("        ,A.EFF_DT = TO_DATE(@[eff_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("        ,A.EXP_DT = TO_DATE(@[exp_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("        ,A.BANK_NM = @[bank_nm]" ).append("\n"); 
		query.append("        ,A.BANK_ACCT_NO = @[bank_acct_no]" ).append("\n"); 
		query.append("        ,A.PAY_MZD_CD = @[pay_mzd_cd]" ).append("\n"); 
		query.append("        ,A.PAY_TERM_DYS = @[pay_term_dys]" ).append("\n"); 
		query.append("        ,A.ZIP_CD = @[zip_cd]" ).append("\n"); 
		query.append("        ,A.OWNR_NM = @[ownr_nm]" ).append("\n"); 
		query.append("        ,A.BZCT_NM = @[bzct_nm]" ).append("\n"); 
		query.append("        ,A.BZTP_NM = @[bztp_nm]" ).append("\n"); 
		query.append("        ,A.BIZ_RGST_NO = @[biz_rgst_no]" ).append("\n"); 
		query.append("        ,A.MNR_SHOP_FLG = @[mnr_shop_flg]" ).append("\n"); 
		query.append("        ,A.MNR_PAYR_CNT_CD = @[mnr_payr_cnt_cd]" ).append("\n"); 
		query.append("        ,A.MNR_PAYR_SEQ = @[mnr_payr_seq]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_CAPI_AMT = @[mnr_prnr_capi_amt]" ).append("\n"); 
		query.append("        ,A.EMPE_KNT = @[empe_knt]" ).append("\n"); 
		query.append("        ,A.DPT_DESC = @[dpt_desc]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_ABBR_NM = @[mnr_prnr_abbr_nm]" ).append("\n"); 
		query.append("        ,A.INTL_PHN_NO = @[intl_phn_no]" ).append("\n"); 
		query.append("        ,A.PHN_NO = @[phn_no]" ).append("\n"); 
		query.append("        ,A.INTL_FAX_NO = @[intl_fax_no]" ).append("\n"); 
		query.append("        ,A.FAX_NO = @[fax_no]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_EML = @[mnr_prnr_eml]" ).append("\n"); 
		query.append("        ,A.MNR_PRNR_RMK = @[mnr_prnr_rmk]" ).append("\n"); 
		query.append("        ,A.TRSM_MOD_CD = @[trsm_mod_cd]" ).append("\n"); 
		query.append("        ,A.FILE_SEQ = @[file_seq]" ).append("\n"); 
		query.append("        ,A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("        ,A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("        ,A.MNR_SWIFT_NO = @[mnr_swift_no]" ).append("\n"); 
		query.append("WHERE A.MNR_PRNR_CRE_SEQ = @[mnr_prnr_cre_seq]" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT(" ).append("\n"); 
		query.append("         MNR_PRNR_CRE_SEQ" ).append("\n"); 
		query.append("        ,CTRL_OFC_CD" ).append("\n"); 
		query.append("        ,MNR_GRP_TP_CD" ).append("\n"); 
		query.append("        ,MNR_PRNR_TP_CD" ).append("\n"); 
		query.append("        ,MNR_PRNR_KND_CD" ).append("\n"); 
		query.append("        ,MNR_PRNR_KND_DTL_CD" ).append("\n"); 
		query.append("        ,MNR_PRNR_STS_CD" ).append("\n"); 
		query.append("        ,MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,MNR_PRNR_SEQ" ).append("\n"); 
		query.append("        ,EDI_ID" ).append("\n"); 
		query.append("        ,MNR_PRNR_LGL_ENG_NM" ).append("\n"); 
		query.append("        ,MNR_PRNR_LOCL_LANG_NM" ).append("\n"); 
		query.append("        ,MNR_PRNR_ADDR" ).append("\n"); 
		query.append("        ,BZET_ADDR" ).append("\n"); 
		query.append("        ,MNR_BIL_TO_NM" ).append("\n"); 
		query.append("        ,EFF_DT" ).append("\n"); 
		query.append("        ,EXP_DT" ).append("\n"); 
		query.append("        ,BANK_NM" ).append("\n"); 
		query.append("        ,BANK_ACCT_NO" ).append("\n"); 
		query.append("        ,PAY_MZD_CD" ).append("\n"); 
		query.append("        ,PAY_TERM_DYS" ).append("\n"); 
		query.append("        ,ZIP_CD" ).append("\n"); 
		query.append("        ,OWNR_NM" ).append("\n"); 
		query.append("        ,BZCT_NM" ).append("\n"); 
		query.append("        ,BZTP_NM" ).append("\n"); 
		query.append("        ,BIZ_RGST_NO" ).append("\n"); 
		query.append("        ,MNR_SHOP_FLG" ).append("\n"); 
		query.append("        ,MNR_PAYR_CNT_CD" ).append("\n"); 
		query.append("        ,MNR_PAYR_SEQ" ).append("\n"); 
		query.append("        ,MNR_PRNR_CAPI_AMT" ).append("\n"); 
		query.append("        ,EMPE_KNT" ).append("\n"); 
		query.append("        ,DPT_DESC" ).append("\n"); 
		query.append("        ,MNR_PRNR_ABBR_NM" ).append("\n"); 
		query.append("        ,INTL_PHN_NO" ).append("\n"); 
		query.append("        ,PHN_NO" ).append("\n"); 
		query.append("        ,INTL_FAX_NO" ).append("\n"); 
		query.append("        ,FAX_NO" ).append("\n"); 
		query.append("        ,MNR_PRNR_EML" ).append("\n"); 
		query.append("        ,MNR_PRNR_RMK" ).append("\n"); 
		query.append("        ,TRSM_MOD_CD" ).append("\n"); 
		query.append("        ,FILE_SEQ" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,MNR_SWIFT_NO" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("            @[mnr_prnr_cre_seq] " ).append("\n"); 
		query.append("           ,@[ctrl_ofc_cd]" ).append("\n"); 
		query.append("           ,@[mnr_grp_tp_cd]" ).append("\n"); 
		query.append("           ,DECODE(@[mnr_grp_tp_cd],'RPR','S','B')" ).append("\n"); 
		query.append("           ,@[mnr_prnr_knd_cd]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_knd_dtl_cd]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_sts_cd]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_seq]" ).append("\n"); 
		query.append("           ,@[edi_id]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_lgl_eng_nm]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_locl_lang_nm]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_addr]" ).append("\n"); 
		query.append("           ,@[bzet_addr]" ).append("\n"); 
		query.append("           ,@[mnr_bil_to_nm]" ).append("\n"); 
		query.append("           ,TO_DATE(@[eff_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,TO_DATE(@[exp_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,@[bank_nm]" ).append("\n"); 
		query.append("           ,@[bank_acct_no]" ).append("\n"); 
		query.append("           ,@[pay_mzd_cd]" ).append("\n"); 
		query.append("           ,@[pay_term_dys]" ).append("\n"); 
		query.append("           ,@[zip_cd]" ).append("\n"); 
		query.append("           ,@[ownr_nm]" ).append("\n"); 
		query.append("           ,@[bzct_nm]" ).append("\n"); 
		query.append("           ,@[bztp_nm]" ).append("\n"); 
		query.append("           ,@[biz_rgst_no]" ).append("\n"); 
		query.append("           ,@[mnr_shop_flg]" ).append("\n"); 
		query.append("           ,@[mnr_payr_cnt_cd]" ).append("\n"); 
		query.append("           ,@[mnr_payr_seq]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_capi_amt]" ).append("\n"); 
		query.append("           ,@[empe_knt]" ).append("\n"); 
		query.append("           ,@[dpt_desc]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_abbr_nm]" ).append("\n"); 
		query.append("           ,@[intl_phn_no]" ).append("\n"); 
		query.append("           ,@[phn_no]" ).append("\n"); 
		query.append("           ,@[intl_fax_no]" ).append("\n"); 
		query.append("           ,@[fax_no]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_eml]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_rmk]" ).append("\n"); 
		query.append("           ,@[trsm_mod_cd]" ).append("\n"); 
		query.append("           ,@[file_seq]" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,SYSDATE" ).append("\n"); 
		query.append("           ,@[mnr_swift_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}