/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PartnerDBDAOAddVndrRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.11 
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

public class PartnerDBDAOAddVndrRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력된 Vendor 정보를 요청한다.
	  * </pre>
	  */
	public PartnerDBDAOAddVndrRqstCSQL(){
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
		params.put("vndr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lu_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_de_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_edi_use_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rgst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_scp_cd_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_abbr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.bcm.ccd.commoncode.partner.integration").append("\n"); 
		query.append("FileName : PartnerDBDAOAddVndrRqstCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_VNDR_RQST(" ).append("\n"); 
		query.append("			 RQST_NO" ).append("\n"); 
		query.append("            ,VNDR_SEQ" ).append("\n"); 
		query.append("            ,VNDR_CNT_CD" ).append("\n"); 
		query.append("            ,VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("            ,VNDR_LOCL_LANG_NM" ).append("\n"); 
		query.append("            ,VNDR_ABBR_NM" ).append("\n"); 
		query.append("            ,LGS_FLG" ).append("\n"); 
		query.append("            ,PROCU_FLG" ).append("\n"); 
		query.append("            ,FINC_FLG" ).append("\n"); 
		query.append("            ,TEAM_FLG" ).append("\n"); 
		query.append("            ,INTER_CO_FLG" ).append("\n"); 
		query.append("            ,OTR_FLG" ).append("\n"); 
		query.append("            ,LOC_CD" ).append("\n"); 
		query.append("            ,OFC_CD" ).append("\n"); 
		query.append("            ,RGST_NO" ).append("\n"); 
		query.append("            ,TAX_ID" ).append("\n"); 
		query.append("            ,GEN_PAY_TERM_CD" ).append("\n"); 
		query.append("            ,PAY_TERM_TP_CD" ).append("\n"); 
		query.append("            ,PAY_MZD_CD" ).append("\n"); 
		query.append("            ,PRNT_CNT_CD" ).append("\n"); 
		query.append("            ,PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("            ,INV_CURR_CD" ).append("\n"); 
		query.append("            ,CNTC_PSON_NM" ).append("\n"); 
		query.append("            ,CEO_NM" ).append("\n"); 
		query.append("            ,BZCT_NM" ).append("\n"); 
		query.append("            ,BZTP_NM" ).append("\n"); 
		query.append("            ,USA_EDI_CD" ).append("\n"); 
		query.append("            ,SVC_SCP_CD_NM" ).append("\n"); 
		query.append("            ,SVC_PRD_TP_NM" ).append("\n"); 
		query.append("            ,SVC_PRD_RMK" ).append("\n"); 
		query.append("            ,DCGO_HNDL_FLG" ).append("\n"); 
		query.append("            ,MTY_RRO_EDI_USE_FLG" ).append("\n"); 
		query.append("            ,WO_ATCH_FILE_FLG" ).append("\n"); 
		query.append("            ,WO_EDI_USE_FLG" ).append("\n"); 
		query.append("            ,INV_EDI_USE_FLG" ).append("\n"); 
		query.append("            ,RFND_PSDO_CUST_CD" ).append("\n"); 
		query.append("            ,VNDR_OFC_CD" ).append("\n"); 
		query.append("            ,SUBS_CO_CD" ).append("\n"); 
		query.append("            ,ENG_ADDR" ).append("\n"); 
		query.append("            ,ZIP_CD" ).append("\n"); 
		query.append("            ,LOCL_LANG_ADDR" ).append("\n"); 
		query.append("            ,CHK_DE_ADDR1" ).append("\n"); 
		query.append("            ,CHK_DE_ADDR2" ).append("\n"); 
		query.append("            ,CHK_DE_ADDR3" ).append("\n"); 
		query.append("            ,CHK_DE_CTY_NM" ).append("\n"); 
		query.append("            ,CHK_DE_STE_CD" ).append("\n"); 
		query.append("            ,CHK_DE_ZIP_CD" ).append("\n"); 
		query.append("            ,CHK_DE_CNT_CD" ).append("\n"); 
		query.append("            ,LU_DELT_FLG" ).append("\n"); 
		query.append("            ,DELT_FLG" ).append("\n"); 
		query.append("            ,MODI_VNDR_CD" ).append("\n"); 
		query.append("            ,CRE_USR_ID" ).append("\n"); 
		query.append("            ,CRE_DT" ).append("\n"); 
		query.append("            ,UPD_USR_ID" ).append("\n"); 
		query.append("            ,UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("    VALUES(  @[rqst_no]" ).append("\n"); 
		query.append("			,@[vndr_seq]" ).append("\n"); 
		query.append("            ,@[vndr_cnt_cd]" ).append("\n"); 
		query.append("            ,@[vndr_lgl_eng_nm]" ).append("\n"); 
		query.append("            ,@[vndr_locl_lang_nm]" ).append("\n"); 
		query.append("            ,@[vndr_abbr_nm]" ).append("\n"); 
		query.append("            ,@[lgs_flg]" ).append("\n"); 
		query.append("            ,@[procu_flg]" ).append("\n"); 
		query.append("            ,@[finc_flg]" ).append("\n"); 
		query.append("            ,@[team_flg]" ).append("\n"); 
		query.append("            ,@[inter_co_flg]" ).append("\n"); 
		query.append("            ,@[otr_flg]" ).append("\n"); 
		query.append("            ,@[loc_cd]" ).append("\n"); 
		query.append("            ,@[ofc_cd]" ).append("\n"); 
		query.append("            ,@[rgst_no]" ).append("\n"); 
		query.append("            ,@[tax_id]" ).append("\n"); 
		query.append("            ,@[gen_pay_term_cd]" ).append("\n"); 
		query.append("            ,@[pay_term_tp_cd]" ).append("\n"); 
		query.append("            ,@[pay_mzd_cd]" ).append("\n"); 
		query.append("            ,(SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[prnt_vndr_seq])" ).append("\n"); 
		query.append("            ,@[prnt_vndr_seq]" ).append("\n"); 
		query.append("            ,@[inv_curr_cd]" ).append("\n"); 
		query.append("            ,@[cntc_pson_nm]" ).append("\n"); 
		query.append("            ,@[ceo_nm]" ).append("\n"); 
		query.append("            ,@[bzct_nm]" ).append("\n"); 
		query.append("            ,@[bztp_nm]" ).append("\n"); 
		query.append("            ,@[usa_edi_cd]" ).append("\n"); 
		query.append("            ,@[svc_scp_cd_nm]" ).append("\n"); 
		query.append("            ,@[svc_prd_tp_nm]" ).append("\n"); 
		query.append("            ,@[svc_prd_rmk]" ).append("\n"); 
		query.append("            ,@[dcgo_hndl_flg]" ).append("\n"); 
		query.append("            ,@[mty_rro_edi_use_flg]" ).append("\n"); 
		query.append("            ,@[wo_atch_file_flg]" ).append("\n"); 
		query.append("            ,@[wo_edi_use_flg]" ).append("\n"); 
		query.append("            ,@[inv_edi_use_flg]" ).append("\n"); 
		query.append("            ,@[rfnd_psdo_cust_cd]" ).append("\n"); 
		query.append("            ,@[vndr_ofc_cd]" ).append("\n"); 
		query.append("            ,@[subs_co_cd]" ).append("\n"); 
		query.append("            ,@[eng_addr]" ).append("\n"); 
		query.append("            ,@[zip_cd]" ).append("\n"); 
		query.append("            ,@[locl_lang_addr]" ).append("\n"); 
		query.append("            ,@[chk_de_addr1]" ).append("\n"); 
		query.append("            ,@[chk_de_addr2]" ).append("\n"); 
		query.append("            ,@[chk_de_addr3]" ).append("\n"); 
		query.append("            ,@[chk_de_cty_nm]" ).append("\n"); 
		query.append("            ,@[chk_de_ste_cd]" ).append("\n"); 
		query.append("            ,@[chk_de_zip_cd]" ).append("\n"); 
		query.append("            ,@[chk_de_cnt_cd]" ).append("\n"); 
		query.append("            ,@[lu_delt_flg]" ).append("\n"); 
		query.append("            ,@[delt_flg]" ).append("\n"); 
		query.append("            ,@[modi_vndr_cd]" ).append("\n"); 
		query.append("            ,@[cre_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            ,@[upd_usr_id]" ).append("\n"); 
		query.append("            ,SYSDATE" ).append("\n"); 
		query.append("            )" ).append("\n"); 

	}
}