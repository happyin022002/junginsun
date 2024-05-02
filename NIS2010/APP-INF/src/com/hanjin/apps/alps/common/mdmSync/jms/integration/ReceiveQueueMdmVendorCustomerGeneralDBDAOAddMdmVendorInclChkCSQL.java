/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmVendorCustomerGeneralDBDAOAddMdmVendorInclChkCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.06
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.07.06 양봉준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmVendorCustomerGeneralDBDAOAddMdmVendorInclChkCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHK_ 접두어 컬럼을 Insert / update 에 포함시켜 처리한다. MDM019-0001 interface 에서 사용한다.
	  * </pre>
	  */
	public ReceiveQueueMdmVendorCustomerGeneralDBDAOAddMdmVendorInclChkCSQL(){
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
		params.put("locl_lang_addr4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_lang_addr3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_lang_addr2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wo_atch_file_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("modi_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmVendorCustomerGeneralDBDAOAddMdmVendorInclChkCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO mdm_vendor ( vndr_seq ," ).append("\n"); 
		query.append("vndr_cnt_cd ," ).append("\n"); 
		query.append("vndr_lgl_eng_nm ," ).append("\n"); 
		query.append("vndr_abbr_nm ," ).append("\n"); 
		query.append("loc_cd ," ).append("\n"); 
		query.append("ofc_cd ," ).append("\n"); 
		query.append("ceo_nm ," ).append("\n"); 
		query.append("rgst_no ," ).append("\n"); 
		query.append("tax_id ," ).append("\n"); 
		query.append("prnt_cnt_cd ," ).append("\n"); 
		query.append("prnt_vndr_seq ," ).append("\n"); 
		query.append("dcgo_hndl_flg ," ).append("\n"); 
		query.append("svc_scp_cd_nm ," ).append("\n"); 
		query.append("svc_prd_tp_nm ," ).append("\n"); 
		query.append("svc_prd_rmk ," ).append("\n"); 
		query.append("bzct_nm ," ).append("\n"); 
		query.append("bztp_nm ," ).append("\n"); 
		query.append("gen_pay_term_cd ," ).append("\n"); 
		query.append("eng_addr ," ).append("\n"); 
		query.append("locl_lang_addr ," ).append("\n"); 
		query.append("zip_cd ," ).append("\n"); 
		query.append("cntc_pson_nm ," ).append("\n"); 
		query.append("inv_curr_cd ," ).append("\n"); 
		query.append("pay_curr_cd ," ).append("\n"); 
		query.append("pay_mzd_cd ," ).append("\n"); 
		query.append("usa_edi_cd ," ).append("\n"); 
		query.append("wo_atch_file_flg ," ).append("\n"); 
		query.append("wo_edi_use_flg ," ).append("\n"); 
		query.append("inv_edi_use_flg ," ).append("\n"); 
		query.append("mty_rro_edi_use_flg," ).append("\n"); 
		query.append("modi_vndr_seq ," ).append("\n"); 
		query.append("blk_flg ," ).append("\n"); 
		query.append("finc_flg ," ).append("\n"); 
		query.append("team_flg ," ).append("\n"); 
		query.append("inter_co_flg ," ).append("\n"); 
		query.append("lgs_flg ," ).append("\n"); 
		query.append("procu_flg ," ).append("\n"); 
		query.append("otr_flg ," ).append("\n"); 
		query.append("blk_vndr_svc_cd ," ).append("\n"); 
		query.append("subs_co_cd ," ).append("\n"); 
		query.append("vndr_ofc_cd ," ).append("\n"); 
		query.append("cre_usr_id ," ).append("\n"); 
		query.append("cre_dt ," ).append("\n"); 
		query.append("upd_usr_id ," ).append("\n"); 
		query.append("upd_dt ," ).append("\n"); 
		query.append("delt_flg ," ).append("\n"); 
		query.append("eai_evnt_dt ," ).append("\n"); 
		query.append("rfnd_psdo_cust_cd ," ).append("\n"); 
		query.append("pay_term_tp_cd ," ).append("\n"); 
		query.append("vndr_locl_lang_nm ," ).append("\n"); 
		query.append("chk_de_addr1," ).append("\n"); 
		query.append("chk_de_addr2," ).append("\n"); 
		query.append("chk_de_addr3," ).append("\n"); 
		query.append("chk_de_cty_nm," ).append("\n"); 
		query.append("chk_de_ste_cd," ).append("\n"); 
		query.append("chk_de_zip_cd," ).append("\n"); 
		query.append("chk_de_cnt_cd," ).append("\n"); 
		query.append("lu_delt_flg," ).append("\n"); 
		query.append("eai_if_id )" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[vndr_seq] ," ).append("\n"); 
		query.append("@[vndr_cnt_cd] ," ).append("\n"); 
		query.append("@[vndr_lgl_eng_nm] ," ).append("\n"); 
		query.append("@[vndr_abbr_nm] ," ).append("\n"); 
		query.append("@[loc_cd] ," ).append("\n"); 
		query.append("@[ofc_cd] ," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[ceo_nm] , 'UTF8', 'UTF8') ," ).append("\n"); 
		query.append("@[rgst_no] ," ).append("\n"); 
		query.append("@[tax_id] ," ).append("\n"); 
		query.append("@[prnt_cnt_cd] ," ).append("\n"); 
		query.append("@[prnt_vndr_seq] ," ).append("\n"); 
		query.append("@[dcgo_hndl_flg] ," ).append("\n"); 
		query.append("@[svc_scp_cd_nm] ," ).append("\n"); 
		query.append("@[svc_prd_tp_nm] ," ).append("\n"); 
		query.append("@[svc_prd_rmk] ," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[bzct_nm] , 'UTF8', 'UTF8') ," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[bztp_nm] , 'UTF8', 'UTF8') ," ).append("\n"); 
		query.append("@[gen_pay_term_cd] ," ).append("\n"); 
		query.append("@[eng_addr] ," ).append("\n"); 
		query.append("rtrim( HJSEAI_PKG.h_decode(@[locl_lang_addr],'UTF8','UTF8'))||' '||" ).append("\n"); 
		query.append("rtrim( HJSEAI_PKG.h_decode(@[locl_lang_addr2],'UTF8','UTF8'))||' '||" ).append("\n"); 
		query.append("rtrim( HJSEAI_PKG.h_decode(@[locl_lang_addr3],'UTF8','UTF8'))||' '||" ).append("\n"); 
		query.append("rtrim( HJSEAI_PKG.h_decode(@[locl_lang_addr4],'UTF8','UTF8'))," ).append("\n"); 
		query.append("@[zip_cd] ," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[cntc_pson_nm] , 'UTF8', 'UTF8') ," ).append("\n"); 
		query.append("@[inv_curr_cd] ," ).append("\n"); 
		query.append("@[pay_curr_cd] ," ).append("\n"); 
		query.append("@[pay_mzd_cd] ," ).append("\n"); 
		query.append("@[usa_edi_cd] ," ).append("\n"); 
		query.append("@[wo_atch_file_flg] ," ).append("\n"); 
		query.append("@[wo_edi_use_flg] ," ).append("\n"); 
		query.append("@[inv_edi_use_flg] ," ).append("\n"); 
		query.append("@[mty_rro_edi_use_flg]," ).append("\n"); 
		query.append("@[modi_vndr_seq] ," ).append("\n"); 
		query.append("@[blk_flg] ," ).append("\n"); 
		query.append("@[finc_flg] ," ).append("\n"); 
		query.append("@[team_flg] ," ).append("\n"); 
		query.append("@[inter_co_flg] ," ).append("\n"); 
		query.append("@[lgs_flg] ," ).append("\n"); 
		query.append("@[procu_flg] ," ).append("\n"); 
		query.append("@[otr_flg] ," ).append("\n"); 
		query.append("@[blk_vndr_svc_cd] ," ).append("\n"); 
		query.append("@[subs_co_cd] ," ).append("\n"); 
		query.append("@[vndr_ofc_cd] ," ).append("\n"); 
		query.append("@[cre_usr_id] ," ).append("\n"); 
		query.append("to_date(@[cre_dt] , 'yyyymmddhh24miss') ," ).append("\n"); 
		query.append("@[upd_usr_id] ," ).append("\n"); 
		query.append("to_date(@[upd_dt] , 'yyyymmddhh24miss') ," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("sysdate ," ).append("\n"); 
		query.append("@[rfnd_psdo_cust_cd] ," ).append("\n"); 
		query.append("@[pay_term_tp_cd] ," ).append("\n"); 
		query.append("SUBSTR(NVL(HJSEAI_PKG.h_decode(@[vndr_locl_lang_nm], 'UTF8', 'UTF8'), @[vndr_locl_lang_nm]), 1, 100) ," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[chk_de_addr1],'UTF8','UTF8')," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[chk_de_addr2],'UTF8','UTF8')," ).append("\n"); 
		query.append("HJSEAI_PKG.h_decode(@[chk_de_addr3],'UTF8','UTF8')," ).append("\n"); 
		query.append("@[chk_de_cty_nm]," ).append("\n"); 
		query.append("@[chk_de_ste_cd]," ).append("\n"); 
		query.append("@[chk_de_zip_cd]," ).append("\n"); 
		query.append("@[chk_de_cnt_cd]," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("@[eai_if_id])" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}