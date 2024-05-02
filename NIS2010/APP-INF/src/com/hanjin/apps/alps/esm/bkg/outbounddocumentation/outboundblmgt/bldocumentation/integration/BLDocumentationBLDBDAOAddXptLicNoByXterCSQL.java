/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOAddXptLicNoByXterCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOAddXptLicNoByXterCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * eBkg에서 Export Licens number를 저장한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOAddXptLicNoByXterCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_shpr_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tr_ntfy_tax_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("il_cnee_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnee_tax_cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_ctrl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aes_inlnd_trns_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mx_cnee_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sam_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("il_ntfy_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lb_shpr_tax_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("b13a_xpt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("br_cnee_tax_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("il_shpr_tax_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g7_edi_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vin_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lb_cnee_tax_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mx_ntfy_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brz_decl_cpy_desc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("caed_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tr_cnee_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("brz_decl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sam_pck_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("divd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mf_smry_rpt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lb_ntfy_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mx_shpr_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sam_pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tr_shpr_tax_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("caed_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("br_ntfy_tax_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOAddXptLicNoByXterCSQL").append("\n"); 
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
		query.append("#if (${cnt_cd} == 'CA')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       CAED_TP_CD," ).append("\n"); 
		query.append("       CAED_PFX_CTNT," ).append("\n"); 
		query.append("       CAED_NO1," ).append("\n"); 
		query.append("       CAED_NO2," ).append("\n"); 
		query.append("       CAED_NO3," ).append("\n"); 
		query.append("       G7_EDI_PFX_CTNT," ).append("\n"); 
		query.append("       G7_EDI_NO1," ).append("\n"); 
		query.append("       G7_EDI_NO2," ).append("\n"); 
		query.append("       MF_SMRY_RPT_PFX_CTNT," ).append("\n"); 
		query.append("       MF_SMRY_RPT_NO," ).append("\n"); 
		query.append("       B13A_XPT_PFX_CTNT," ).append("\n"); 
		query.append("       B13A_XPT_DT," ).append("\n"); 
		query.append("       B13A_XPT_NO1," ).append("\n"); 
		query.append("       B13A_XPT_NO2," ).append("\n"); 
		query.append("       CGO_CTRL_PFX_CTNT," ).append("\n"); 
		query.append("       CGO_CTRL_NO," ).append("\n"); 
		query.append("       NDR_REF_PFX_CTNT," ).append("\n"); 
		query.append("       NDR_REF_ID," ).append("\n"); 
		query.append("       NDR_REF_CTNT," ).append("\n"); 
		query.append("	   PCK_QTY," ).append("\n"); 
		query.append("	   DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   SAM_PCK_QTY," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       'O'," ).append("\n"); 
		query.append("       NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC WHERE BKG_NO = @[bkg_no] AND IO_BND_CD = 'O'), 0) + 1," ).append("\n"); 
		query.append("       'CA'," ).append("\n"); 
		query.append("	   @[caed_tp_cd]," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'CE', 'P.O.R : CAED', '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'CE', decode(trim(@[caed_ctnt]), '', '', substr(trim(@[caed_ctnt]),  1, 6)), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'CE', decode(trim(@[caed_ctnt]), '', '', substr(trim(@[caed_ctnt]),  8, 6)), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'CE', decode(trim(@[caed_ctnt]), '', '', substr(trim(@[caed_ctnt]), 15, 11)), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'G7', 'P.O.R : G7 EDI', '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'G7', decode(trim(@[g7_edi_ctnt]), '', '', substr(trim(@[g7_edi_ctnt]), 1,  6)), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'G7', decode(trim(@[g7_edi_ctnt]), '', '', substr(trim(@[g7_edi_ctnt]), 8, 11)), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'SM', 'P.O.R : SUM', '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'SM', decode(trim(@[mf_smry_rpt_no]), '', '', trim(@[mf_smry_rpt_no])), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'EX', 'P.O.R : B13A', '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'EX', decode(trim(@[b13a_xpt_ctnt]), '', '', to_date(substr(@[b13a_xpt_ctnt], 1, 16), 'yyyy/mm/dd hh24:mi')), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'EX', decode(trim(@[b13a_xpt_ctnt]), '', '', substr(trim(@[b13a_xpt_ctnt]), 18, 3)), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'EX', decode(trim(@[b13a_xpt_ctnt]), '', '', substr(trim(@[b13a_xpt_ctnt]), 23, 6)), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'IT', 'P.O.R : In-Bond Cargo', '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'IT', decode(trim(@[cgo_ctrl_no]), '', '', trim(@[cgo_ctrl_no])), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'ND', 'P.O.R :', '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd], 'ND', @[ndr_ref_id], '')," ).append("\n"); 
		query.append("       @[ndr_ref_ctnt]," ).append("\n"); 
		query.append("	   0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'MX')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("	   MX_SHPR_PFX_CTNT," ).append("\n"); 
		query.append("       MX_SHPR_TAX_ID," ).append("\n"); 
		query.append("	   MX_CNEE_PFX_CTNT," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID," ).append("\n"); 
		query.append("	   MX_NTFY_PFX_CTNT," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("	   DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   SAM_PCK_QTY," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        select case " ).append("\n"); 
		query.append("                    when SUBSTR(POR_CD,1,2) in ('MX','PE','EC','CO') then 'O'" ).append("\n"); 
		query.append("                    when SUBSTR(POL_CD,1,2) in ('MX','PE','EC','CO') then 'O'" ).append("\n"); 
		query.append("                    else 'I'" ).append("\n"); 
		query.append("               end" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("       ),   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        select case " ).append("\n"); 
		query.append("                    when SUBSTR(POR_CD,1,2) in ('MX','PE','EC','CO') then 'O'" ).append("\n"); 
		query.append("                    when SUBSTR(POL_CD,1,2) in ('MX','PE','EC','CO') then 'O'" ).append("\n"); 
		query.append("                    else 'I'" ).append("\n"); 
		query.append("               end" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("       ),  " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no] AND IO_BND_CD = " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            select case " ).append("\n"); 
		query.append("                                        when SUBSTR(POR_CD,1,2) in ('MX','PE','EC','CO') then 'O'" ).append("\n"); 
		query.append("                                        when SUBSTR(POL_CD,1,2) in ('MX','PE','EC','CO') then 'O'" ).append("\n"); 
		query.append("                                        else 'I'" ).append("\n"); 
		query.append("                                   end" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING" ).append("\n"); 
		query.append("                            WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("							  AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("            ), 0) + 1," ).append("\n"); 
		query.append("       --'MX'," ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("            select case " ).append("\n"); 
		query.append("                   when SUBSTR(POR_CD,1,2) in ('MX','PE','EC','CO') then SUBSTR(POR_CD,1,2)" ).append("\n"); 
		query.append("                   when SUBSTR(POL_CD,1,2) in ('MX','PE','EC','CO') then SUBSTR(POL_CD,1,2)" ).append("\n"); 
		query.append("				   when SUBSTR(POD_CD,1,2) in ('MX','PE','EC','CO') then SUBSTR(POD_CD,1,2)" ).append("\n"); 
		query.append("                   when SUBSTR(DEL_CD,1,2) in ('MX','PE','EC','CO') then SUBSTR(DEL_CD,1,2)" ).append("\n"); 
		query.append("                   else 'MX'" ).append("\n"); 
		query.append("                   end" ).append("\n"); 
		query.append("              FROM BKG_BOOKING" ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("			   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       )," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("	   @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("	   @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'TR')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("	   TR_SHPR_PFX_CTNT," ).append("\n"); 
		query.append("       TR_SHPR_TAX_ID," ).append("\n"); 
		query.append("	   TR_CNEE_PFX_CTNT," ).append("\n"); 
		query.append("       TR_CNEE_TAX_ID," ).append("\n"); 
		query.append("	   TR_NTFY_PFX_CTNT," ).append("\n"); 
		query.append("       TR_NTFY_TAX_ID," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("	   DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   SAM_PCK_QTY," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        select case " ).append("\n"); 
		query.append("                    when SUBSTR(POD_CD,1,2) in ('TR') then 'I'" ).append("\n"); 
		query.append("                    when SUBSTR(DEL_CD,1,2) in ('TR') then 'I'" ).append("\n"); 
		query.append("                    else 'O'" ).append("\n"); 
		query.append("               end" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ),   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no] AND IO_BND_CD = " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            select case " ).append("\n"); 
		query.append("                                       when SUBSTR(POD_CD,1,2) in ('TR') then 'I'" ).append("\n"); 
		query.append("                                       when SUBSTR(DEL_CD,1,2) in ('TR') then 'I'" ).append("\n"); 
		query.append("                                       else 'O'" ).append("\n"); 
		query.append("                                   end" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING" ).append("\n"); 
		query.append("                            WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("							  AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("            ), 0) + 1," ).append("\n"); 
		query.append("       --'MX'," ).append("\n"); 
		query.append("       'TR'," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[tr_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   @[tr_shpr_tax_id]," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[tr_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("	   @[tr_cnee_tax_id]," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[tr_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("	   @[tr_ntfy_tax_id]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'IL')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("	   IL_SHPR_PFX_CTNT," ).append("\n"); 
		query.append("       IL_SHPR_TAX_ID," ).append("\n"); 
		query.append("	   IL_CNEE_PFX_CTNT," ).append("\n"); 
		query.append("       IL_CNEE_TAX_ID," ).append("\n"); 
		query.append("	   IL_NTFY_PFX_CTNT," ).append("\n"); 
		query.append("       IL_NTFY_TAX_ID," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("	   DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   SAM_PCK_QTY," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        select case " ).append("\n"); 
		query.append("                    when SUBSTR(POD_CD,1,2) in ('IL') then 'I'" ).append("\n"); 
		query.append("                    when SUBSTR(DEL_CD,1,2) in ('IL') then 'I'" ).append("\n"); 
		query.append("                    else 'O'" ).append("\n"); 
		query.append("               end" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ),   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no] AND IO_BND_CD = " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            select case " ).append("\n"); 
		query.append("                                       when SUBSTR(POD_CD,1,2) in ('IL') then 'I'" ).append("\n"); 
		query.append("                                       when SUBSTR(DEL_CD,1,2) in ('IL') then 'I'" ).append("\n"); 
		query.append("                                       else 'O'" ).append("\n"); 
		query.append("                                   end" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING" ).append("\n"); 
		query.append("                            WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("							  AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("            ), 0) + 1," ).append("\n"); 
		query.append("       'IL'," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[il_shpr_tax_id]), '*'), '*', '', 'SHIPPER VAT ID')," ).append("\n"); 
		query.append("	   @[il_shpr_tax_id]," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[il_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE VAT ID')," ).append("\n"); 
		query.append("	   @[il_cnee_tax_id]," ).append("\n"); 
		query.append("	   DECODE(NVL(TRIM(@[il_ntfy_tax_id]), '*'), '*', '', 'NOTIFY VAT ID')," ).append("\n"); 
		query.append("	   @[il_ntfy_tax_id]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'LB')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       LB_SHPR_TAX_ID," ).append("\n"); 
		query.append("       LB_CNEE_TAX_ID," ).append("\n"); 
		query.append("       LB_NTFY_TAX_ID," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("	   DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   SAM_PCK_QTY," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("        SELECT CASE " ).append("\n"); 
		query.append("                    WHEN SUBSTR(POD_CD,1,2) IN ('LB') THEN 'I'" ).append("\n"); 
		query.append("                    WHEN SUBSTR(DEL_CD,1,2) IN ('LB') THEN 'I'" ).append("\n"); 
		query.append("                    ELSE 'O'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ),   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no] AND IO_BND_CD = " ).append("\n"); 
		query.append("                        (" ).append("\n"); 
		query.append("                            SELECT CASE " ).append("\n"); 
		query.append("                                       WHEN SUBSTR(POD_CD,1,2) IN ('LB') THEN 'I'" ).append("\n"); 
		query.append("                                       WHEN SUBSTR(DEL_CD,1,2) IN ('LB') THEN 'I'" ).append("\n"); 
		query.append("                                       ELSE 'O'" ).append("\n"); 
		query.append("                                   END" ).append("\n"); 
		query.append("                            FROM BKG_BOOKING" ).append("\n"); 
		query.append("                            WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("							  AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("            ), 0) + 1," ).append("\n"); 
		query.append("       'LB'," ).append("\n"); 
		query.append("	   @[lb_shpr_tax_id]," ).append("\n"); 
		query.append("	   @[lb_cnee_tax_id]," ).append("\n"); 
		query.append("	   @[lb_ntfy_tax_id]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("	   @[usr_id]," ).append("\n"); 
		query.append("	   SYSDATE" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'KR')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       CNT_CD," ).append("\n"); 
		query.append("       XPT_LIC_NO," ).append("\n"); 
		query.append("       TS_REF_NO," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       MF_WGT," ).append("\n"); 
		query.append("       WGT_UT_CD," ).append("\n"); 
		query.append("       DIVD_FLG," ).append("\n"); 
		query.append("       DIVD_SEQ," ).append("\n"); 
		query.append("       DIVD_PCK_QTY," ).append("\n"); 
		query.append("       DIVD_PCK_TP_CD," ).append("\n"); 
		query.append("       DIVD_WGT," ).append("\n"); 
		query.append("       DIVD_WGT_UT_CD," ).append("\n"); 
		query.append("       SAM_PCK_ID," ).append("\n"); 
		query.append("       SAM_PCK_QTY," ).append("\n"); 
		query.append("       SAM_PCK_TP_CD," ).append("\n"); 
		query.append("       UCR_NO," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       'O'," ).append("\n"); 
		query.append("       NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC WHERE BKG_NO = @[bkg_no] AND IO_BND_CD = 'O'), 0) + 1," ).append("\n"); 
		query.append("       'KR'," ).append("\n"); 
		query.append("       @[xpt_lic_no]," ).append("\n"); 
		query.append("       @[ts_ref_no]," ).append("\n"); 
		query.append("       @[pck_qty]," ).append("\n"); 
		query.append("       @[pck_tp_cd]," ).append("\n"); 
		query.append("       @[mf_wgt]," ).append("\n"); 
		query.append("       @[wgt_ut_cd]," ).append("\n"); 
		query.append("       DECODE(NVL(@[divd_seq], 0), 0, 'N', 'Y')," ).append("\n"); 
		query.append("       @[divd_seq]," ).append("\n"); 
		query.append("       DECODE(NVL(@[divd_seq], 0), 0, 0, @[pck_qty])," ).append("\n"); 
		query.append("       DECODE(NVL(@[divd_seq], 0), 0, '', @[pck_tp_cd])," ).append("\n"); 
		query.append("       DECODE(NVL(@[divd_seq], 0), 0, 0, @[mf_wgt])," ).append("\n"); 
		query.append("       DECODE(NVL(@[divd_seq], 0), 0, '', @[wgt_ut_cd])," ).append("\n"); 
		query.append("       @[sam_pck_seq]," ).append("\n"); 
		query.append("       @[sam_pck_qty]," ).append("\n"); 
		query.append("       @[sam_pck_tp_cd]," ).append("\n"); 
		query.append("       @[ucr_no]," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'US')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       AES_TP_CD," ).append("\n"); 
		query.append("       AES_INLND_TRNS_PFX_CTNT," ).append("\n"); 
		query.append("       AES_INLND_TRNS_NO," ).append("\n"); 
		query.append("       AES_PTA_PFX_CTNT," ).append("\n"); 
		query.append("       AES_PTA_NO1," ).append("\n"); 
		query.append("       AES_PTA_NO2," ).append("\n"); 
		query.append("       AES_PTA_DT," ).append("\n"); 
		query.append("       AES_PTU_PFX_CTNT," ).append("\n"); 
		query.append("       AES_PTU_NO," ).append("\n"); 
		query.append("       AES_PTU_DT," ).append("\n"); 
		query.append("       AES_DWN_PFX_CTNT," ).append("\n"); 
		query.append("       AES_DWN_NO," ).append("\n"); 
		query.append("       AES_DWN_DT," ).append("\n"); 
		query.append("       AES_EXPT_ID," ).append("\n"); 
		query.append("       AES_EXPT_CTNT," ).append("\n"); 
		query.append("	   PCK_QTY," ).append("\n"); 
		query.append("	   DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   SAM_PCK_QTY," ).append("\n"); 
		query.append("       VIN_CTNT," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       'O'," ).append("\n"); 
		query.append("       NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC WHERE BKG_NO = @[bkg_no] AND IO_BND_CD = 'O'), 0) + 1," ).append("\n"); 
		query.append("       'US'," ).append("\n"); 
		query.append("	   @[aes_tp_cd]," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'AE', 'AES ITN', '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'AE', decode(trim(@[aes_inlnd_trns_no]), '', '',trim(@[aes_inlnd_trns_no])), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'PA', 'AESPOST', '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'PA', to_char(decode(trim(@[aes_pta_no1]), '', '',trim(@[aes_pta_no1]))), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'PA', to_char(decode(trim(@[aes_pta_no2]), '', '',trim(@[aes_pta_no2]))), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'PA', decode(trim(@[aes_pta_dt]), '', '', to_date(replace(@[aes_pta_dt],'-', ''),'mmddyyyy')), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'PU', 'AESPOST', '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'PU', to_char(decode(trim(@[aes_ptu_no]), '', '',trim(@[aes_ptu_no]))), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'PU', decode(trim(@[aes_ptu_dt]), '', '', to_date(replace(@[aes_ptu_dt],'-', ''),'mmddyyyy')), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'DN', 'AESDOWN', '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'DN', to_char(decode(trim(@[aes_dwn_no]), '', '',trim(@[aes_dwn_no]))), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'DN', decode(trim(@[aes_dwn_dt]), '', '', to_date(replace(@[aes_dwn_dt],'-', ''),'mmddyyyy')), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd], 'EX', @[aes_expt_id], '')," ).append("\n"); 
		query.append("       @[aes_expt_ctnt]," ).append("\n"); 
		query.append("	   0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[vin_ctnt]," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'BR')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("	   CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       SHPR_TAX_NO," ).append("\n"); 
		query.append("       CNEE_TAX_NO," ).append("\n"); 
		query.append("       NTFY_TAX_NO," ).append("\n"); 
		query.append("       BRZ_DECL_NO, " ).append("\n"); 
		query.append("       SHPR_TAX_CPY_DESC_FLG, " ).append("\n"); 
		query.append("       CNEE_TAX_CPY_DESC_FLG, " ).append("\n"); 
		query.append("       NTFY_TAX_CPY_DESC_FLG, " ).append("\n"); 
		query.append("       BRZ_DECL_CPY_DESC_FLG," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("	   DIVD_FLG," ).append("\n"); 
		query.append("	   DIVD_PCK_QTY," ).append("\n"); 
		query.append("	   SAM_PCK_QTY," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("	   'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ( SELECT CASE " ).append("\n"); 
		query.append("                WHEN SUBSTR(POD_CD,1,2) IN ('BR') THEN 'I'" ).append("\n"); 
		query.append("                WHEN SUBSTR(DEL_CD,1,2) IN ('BR') THEN 'I'" ).append("\n"); 
		query.append("                ELSE 'O'" ).append("\n"); 
		query.append("                END" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     ),   " ).append("\n"); 
		query.append("      NVL((SELECT MAX(XPT_IMP_SEQ) FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("              AND IO_BND_CD = ( SELECT CASE " ).append("\n"); 
		query.append("                                       WHEN SUBSTR(POD_CD,1,2) IN ('BR') THEN 'I'" ).append("\n"); 
		query.append("                                       WHEN SUBSTR(DEL_CD,1,2) IN ('BR') THEN 'I'" ).append("\n"); 
		query.append("                                       ELSE 'O'" ).append("\n"); 
		query.append("                                       END" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING" ).append("\n"); 
		query.append("                                WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("							    AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("            ), 0) + 1," ).append("\n"); 
		query.append("       'BR'," ).append("\n"); 
		query.append("	   @[br_shpr_tax_id],   " ).append("\n"); 
		query.append("	   @[br_cnee_tax_id],   " ).append("\n"); 
		query.append("	   @[br_ntfy_tax_id],   " ).append("\n"); 
		query.append("       @[brz_decl_no], " ).append("\n"); 
		query.append("       @[shpr_tax_cpy_desc_flg], " ).append("\n"); 
		query.append("       @[cnee_tax_cpy_desc_flg], " ).append("\n"); 
		query.append("       @[ntfy_tax_cpy_desc_flg], " ).append("\n"); 
		query.append("       @[brz_decl_cpy_desc_flg]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("	   @[usr_id]," ).append("\n"); 
		query.append("	   SYSDATE" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}