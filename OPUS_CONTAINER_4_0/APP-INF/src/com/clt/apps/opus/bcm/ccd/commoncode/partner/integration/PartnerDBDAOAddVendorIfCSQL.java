/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PartnerDBDAOAddVendorIfCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.04 
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

public class PartnerDBDAOAddVendorIfCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vendor 정보를 다른 시스템(EAI)으로 전송하기 위해 저장한다.
	  * </pre>
	  */
	public PartnerDBDAOAddVendorIfCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("intl_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_de_zip_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_lang_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_lgl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ocedi_insf_dv_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntc_pnt_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ceo_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eng_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lgs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("blk_vndr_svc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_prd_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_atch_file_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("modi_vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("finc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_edi_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ocedi_insf_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfnd_psdo_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("team_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_de_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_de_addr1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_hndl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_locl_lang_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_prd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_addr2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_addr3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_term_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tax_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnt_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_rro_edi_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rail_vndr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_pay_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_co_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chk_de_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_edi_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("procu_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intl_fax_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOAddVendorIfCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_VENDOR_IF(" ).append("\n"); 
		query.append("             VNDR_IF_SEQ" ).append("\n"); 
		query.append("            ,VNDR_SEQ" ).append("\n"); 
		query.append("            ,VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("            ,VNDR_LOCL_LANG_NM" ).append("\n"); 
		query.append("            ,VNDR_ABBR_NM" ).append("\n"); 
		query.append("            ,LGS_FLG" ).append("\n"); 
		query.append("            ,PROCU_FLG" ).append("\n"); 
		query.append("            ,TEAM_FLG" ).append("\n"); 
		query.append("            ,FINC_FLG" ).append("\n"); 
		query.append("            ,BLK_FLG" ).append("\n"); 
		query.append("            ,INTER_CO_FLG" ).append("\n"); 
		query.append("            ,RAIL_VNDR_FLG" ).append("\n"); 
		query.append("            ,LOC_CD" ).append("\n"); 
		query.append("            ,OFC_CD" ).append("\n"); 
		query.append("            ,CEO_NM" ).append("\n"); 
		query.append("            ,RGST_NO" ).append("\n"); 
		query.append("            ,TAX_ID" ).append("\n"); 
		query.append("            ,PRNT_CNT_CD" ).append("\n"); 
		query.append("            ,PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("            ,DCGO_HNDL_FLG" ).append("\n"); 
		query.append("            ,SVC_SCP_CD_NM" ).append("\n"); 
		query.append("            ,SVC_PRD_TP_NM" ).append("\n"); 
		query.append("            ,SVC_PRD_RMK" ).append("\n"); 
		query.append("            ,BZCT_NM" ).append("\n"); 
		query.append("            ,BZTP_NM" ).append("\n"); 
		query.append("            ,GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("            ,ENG_ADDR" ).append("\n"); 
		query.append("            ,LOCL_LANG_ADDR" ).append("\n"); 
		query.append("            ,ZIP_CD" ).append("\n"); 
		query.append("            ,CNTC_PSON_NM" ).append("\n"); 
		query.append("            ,INV_CURR_CD" ).append("\n"); 
		query.append("            ,PAY_CURR_CD" ).append("\n"); 
		query.append("            ,PAY_MZD_CD" ).append("\n"); 
		query.append("            ,USA_EDI_CD" ).append("\n"); 
		query.append("            ,WO_ATCH_FILE_FLG" ).append("\n"); 
		query.append("            ,WO_EDI_USE_FLG" ).append("\n"); 
		query.append("            ,INV_EDI_USE_FLG" ).append("\n"); 
		query.append("            ,MTY_RRO_EDI_USE_FLG" ).append("\n"); 
		query.append("            ,BLK_VNDR_SVC_CD" ).append("\n"); 
		query.append("            ,SUBS_CO_CD" ).append("\n"); 
		query.append("            ,OTR_FLG" ).append("\n"); 
		query.append("            ,VNDR_OFC_CD" ).append("\n"); 
		query.append("            ,RFND_PSDO_CUST_CD" ).append("\n"); 
		query.append("            ,PAY_TERM_TP_CD" ).append("\n"); 
		query.append("            ,MODI_VNDR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,INTL_PHN_NO" ).append("\n"); 
		query.append("			,PHN_NO" ).append("\n"); 
		query.append("			,INTL_FAX_NO" ).append("\n"); 
		query.append("			,FAX_NO" ).append("\n"); 
		query.append("			,VNDR_EML" ).append("\n"); 
		query.append("			,PRMRY_CHK_FLG" ).append("\n"); 
		query.append("			,CNTC_PNT_DELT_FLG" ).append("\n"); 
		query.append("			,CNTC_DIV_CD" ).append("\n"); 
		query.append("			,CHK_DE_ADDR1" ).append("\n"); 
		query.append("			,CHK_DE_ADDR2" ).append("\n"); 
		query.append("			,CHK_DE_ADDR3" ).append("\n"); 
		query.append("			,CHK_DE_CNT_CD" ).append("\n"); 
		query.append("			,CHK_DE_STE_CD " ).append("\n"); 
		query.append("			,CHK_DE_CTY_NM" ).append("\n"); 
		query.append("			,CHK_DE_ZIP_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,R3_INSF_ID" ).append("\n"); 
		query.append("            ,R3_INSF_DV_CD" ).append("\n"); 
		query.append("            ,OCEDI_INSF_ID" ).append("\n"); 
		query.append("            ,OCEDI_INSF_DV_CD" ).append("\n"); 
		query.append("			,OPEDI_INSF_ID" ).append("\n"); 
		query.append("			,OPEDI_INSF_DV_CD" ).append("\n"); 
		query.append("            ,SAP_ID" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES(  @[vndr_if_seq]" ).append("\n"); 
		query.append("            ,@[vndr_seq]" ).append("\n"); 
		query.append("            ,@[vndr_cnt_cd]" ).append("\n"); 
		query.append("            ,@[vndr_lgl_eng_nm]" ).append("\n"); 
		query.append("            ,@[vndr_locl_lang_nm]" ).append("\n"); 
		query.append("            ,@[vndr_abbr_nm]" ).append("\n"); 
		query.append("            ,@[lgs_flg]" ).append("\n"); 
		query.append("            ,@[procu_flg]" ).append("\n"); 
		query.append("            ,@[team_flg]" ).append("\n"); 
		query.append("            ,@[finc_flg]" ).append("\n"); 
		query.append("            ,@[blk_flg]" ).append("\n"); 
		query.append("            ,@[inter_co_flg]" ).append("\n"); 
		query.append("            ,@[rail_vndr_flg]" ).append("\n"); 
		query.append("            ,@[loc_cd]" ).append("\n"); 
		query.append("            ,@[ofc_cd]" ).append("\n"); 
		query.append("            ,@[ceo_nm]" ).append("\n"); 
		query.append("            ,@[rgst_no]" ).append("\n"); 
		query.append("            ,@[tax_id]" ).append("\n"); 
		query.append("            ,@[prnt_cnt_cd]" ).append("\n"); 
		query.append("            ,@[prnt_vndr_seq]" ).append("\n"); 
		query.append("            ,@[dcgo_hndl_flg]" ).append("\n"); 
		query.append("            ,@[svc_scp_cd_nm]" ).append("\n"); 
		query.append("            ,@[svc_prd_tp_nm]" ).append("\n"); 
		query.append("            ,@[svc_prd_rmk]" ).append("\n"); 
		query.append("            ,@[bzct_nm]" ).append("\n"); 
		query.append("            ,@[bztp_nm]" ).append("\n"); 
		query.append("            ,@[gen_pay_term_cd]" ).append("\n"); 
		query.append("            ,@[eng_addr]" ).append("\n"); 
		query.append("            ,@[locl_lang_addr]" ).append("\n"); 
		query.append("            ,@[zip_cd]" ).append("\n"); 
		query.append("            ,@[cntc_pson_nm]" ).append("\n"); 
		query.append("            ,@[inv_curr_cd]" ).append("\n"); 
		query.append("            ,@[pay_curr_cd]" ).append("\n"); 
		query.append("            ,@[pay_mzd_cd]" ).append("\n"); 
		query.append("            ,@[usa_edi_cd]" ).append("\n"); 
		query.append("            ,@[wo_atch_file_flg]" ).append("\n"); 
		query.append("            ,@[wo_edi_use_flg]" ).append("\n"); 
		query.append("            ,@[inv_edi_use_flg]" ).append("\n"); 
		query.append("            ,@[mty_rro_edi_use_flg]" ).append("\n"); 
		query.append("            ,@[blk_vndr_svc_cd]" ).append("\n"); 
		query.append("            ,@[subs_co_cd]" ).append("\n"); 
		query.append("            ,@[otr_flg]" ).append("\n"); 
		query.append("            ,@[vndr_ofc_cd]" ).append("\n"); 
		query.append("            ,@[rfnd_psdo_cust_cd]" ).append("\n"); 
		query.append("            ,@[pay_term_tp_cd]" ).append("\n"); 
		query.append("            ,@[modi_vndr_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,@[intl_phn_no]" ).append("\n"); 
		query.append("			,@[phn_no]" ).append("\n"); 
		query.append("			,@[intl_fax_no]" ).append("\n"); 
		query.append("			,@[fax_no]" ).append("\n"); 
		query.append("			,@[vndr_eml]" ).append("\n"); 
		query.append("			,@[prmry_chk_flg]" ).append("\n"); 
		query.append("			,@[cntc_pnt_delt_flg]" ).append("\n"); 
		query.append("			,@[cntc_div_cd]" ).append("\n"); 
		query.append("			,@[chk_de_addr1]" ).append("\n"); 
		query.append("			,@[chk_de_addr2]" ).append("\n"); 
		query.append("			,@[chk_de_addr3]" ).append("\n"); 
		query.append("			,@[chk_de_cnt_cd]" ).append("\n"); 
		query.append("			,@[chk_de_ste_cd]" ).append("\n"); 
		query.append("			,@[chk_de_cty_nm]" ).append("\n"); 
		query.append("			,@[chk_de_zip_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[delt_flg]" ).append("\n"); 
		query.append("            ,@[r3_insf_id]" ).append("\n"); 
		query.append("            ,@[r3_insf_dv_cd]" ).append("\n"); 
		query.append("            ,@[ocedi_insf_id]" ).append("\n"); 
		query.append("            ,@[ocedi_insf_dv_cd]" ).append("\n"); 
		query.append("			,@[opedi_insf_id]" ).append("\n"); 
		query.append("			,@[opedi_insf_dv_cd]" ).append("\n"); 
		query.append("            ,'G5'||(SELECT CNT_CD" ).append("\n"); 
		query.append("                FROM MDM_LOCATION" ).append("\n"); 
		query.append("               WHERE LOC_CD = (SELECT LOC_CD" ).append("\n"); 
		query.append("                                 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                WHERE OFC_CD = @[ofc_cd]))||@[vndr_seq]" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}