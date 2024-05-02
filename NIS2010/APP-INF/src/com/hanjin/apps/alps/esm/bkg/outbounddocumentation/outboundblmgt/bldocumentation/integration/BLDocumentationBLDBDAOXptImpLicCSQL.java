/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOXptImpLicCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.27
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.27 
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

public class BLDocumentationBLDBDAOXptImpLicCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationBLDBDAOXptImpLicCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("tr_ntfy_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ntfy_tax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aes_tp_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("caed_no2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("caed_no3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("entr_clss_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ng_exs_ens_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mx_cnee_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("il_ntfy_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_tax_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("b13a_xpt_no1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("il_shpr_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vin_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lb_cnee_tax_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("aes_dwn_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("b13a_xpt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_shp_bil_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sam_pck_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("xpt_imp_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("id_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("entr_clss_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tg_ectn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ndr_ref_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_shp_bil_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("caed_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g7_edi_no2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOXptImpLicCSQL").append("\n"); 
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
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'CA'," ).append("\n"); 
		query.append("	   DECODE(@[caed_tp_cd],'0','',@[caed_tp_cd])," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'CE','P.O.R : CAED','')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'CE',decode(trim(@[caed_no1]), '', '',trim(@[caed_no1])), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'CE',decode(trim(@[caed_no2]), '', '',trim(@[caed_no2])), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'CE',to_char(decode(trim(@[caed_no3]), '', '',trim(@[caed_no3]))), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'G7','P.O.R : G7 EDI','')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'G7',decode(trim(@[g7_edi_no1]), '', '',trim(@[g7_edi_no1])), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'G7',to_char(decode(trim(@[g7_edi_no2]), '', '',trim(@[g7_edi_no2]))),'')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'SM','P.O.R : SUM','')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'SM',to_char(decode(trim(@[mf_smry_rpt_no]), '', '',trim(@[mf_smry_rpt_no]))), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'EX','P.O.R : B13A','')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'EX',decode(trim(@[b13a_xpt_dt]), '', '', to_date(@[b13a_xpt_dt],'yyyy/mm/dd hh24:mi')),'')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'EX',to_char(decode(trim(@[b13a_xpt_no1]), '', '',trim(@[b13a_xpt_no1]))), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'EX',to_char(decode(trim(@[b13a_xpt_no2]), '', '',trim(@[b13a_xpt_no2]))), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'IT','P.O.R : In-Bond Cargo','')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'IT',decode(trim(@[cgo_ctrl_no]), '', '',trim(@[cgo_ctrl_no])), '')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'ND','P.O.R :','')," ).append("\n"); 
		query.append("       DECODE(@[caed_tp_cd],'ND',@[ndr_ref_id],'')," ).append("\n"); 
		query.append("       @[ndr_ref_ctnt]," ).append("\n"); 
		query.append("	   0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'TG')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       TG_ECTN_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'TG'," ).append("\n"); 
		query.append("	   @[tg_ectn_no],       " ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'NG')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       NG_EXS_ENS_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'NG'," ).append("\n"); 
		query.append("	   @[ng_exs_ens_no],       " ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'BR')  " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       SHPR_TAX_NO," ).append("\n"); 
		query.append("	   CNEE_TAX_NO," ).append("\n"); 
		query.append("       NTFY_TAX_NO," ).append("\n"); 
		query.append("       BRZ_DECL_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'BR'," ).append("\n"); 
		query.append("	   @[shpr_tax_no]," ).append("\n"); 
		query.append("       @[cnee_tax_no]," ).append("\n"); 
		query.append("       @[ntfy_tax_no]," ).append("\n"); 
		query.append("       @[brz_decl_no]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'ID')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("       ID_XPT_NO," ).append("\n"); 
		query.append("	   ID_XPT_NO_ISS_DT," ).append("\n"); 
		query.append("	   ID_OFC_ID," ).append("\n"); 
		query.append("	   ID_DECL_CD," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd],       " ).append("\n"); 
		query.append("       NVL((SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("              FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("               AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("              FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("             WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("               AND IO_BND_CD = @[io_bnd_cd]), @[xpt_imp_seq])," ).append("\n"); 
		query.append("       'ID'," ).append("\n"); 
		query.append("	   @[id_xpt_no]," ).append("\n"); 
		query.append("	   to_date(@[id_xpt_no_iss_dt],'yyyymmdd')," ).append("\n"); 
		query.append("	   @[id_ofc_cd]," ).append("\n"); 
		query.append("	   @[id_decl_cd]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'IN')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("	   CNT_CD," ).append("\n"); 
		query.append("	   CNTR_NO," ).append("\n"); 
		query.append("       IDA_IEC_NO," ).append("\n"); 
		query.append("       IDA_SHP_BIL_NO," ).append("\n"); 
		query.append("       IDA_SHP_BIL_ISS_DT," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd],       " ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'IN'," ).append("\n"); 
		query.append("	   @[cntr_no]," ).append("\n"); 
		query.append("	   @[ida_iec_no]," ).append("\n"); 
		query.append("       @[ida_shp_bil_no]," ).append("\n"); 
		query.append("       TO_DATE(REPLACE(@[ida_shp_bil_iss_dt],'-',''),'YYYYMMDD')," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'MX')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("        'MX',		" ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("	   @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("	   @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'CO')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'CO'," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("	   @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("	   @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'EC')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'EC'," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("	   @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("	   @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'PE')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'PE'," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("	   @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   decode(NVL(trim(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("	   @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   ) " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'TR')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       CNT_CD," ).append("\n"); 
		query.append("       TR_SHPR_PFX_CTNT," ).append("\n"); 
		query.append("       TR_SHPR_TAX_ID," ).append("\n"); 
		query.append("       TR_CNEE_PFX_CTNT," ).append("\n"); 
		query.append("       TR_CNEE_TAX_ID," ).append("\n"); 
		query.append("       TR_NTFY_PFX_CTNT," ).append("\n"); 
		query.append("       TR_NTFY_TAX_ID," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       DIVD_FLG," ).append("\n"); 
		query.append("       DIVD_PCK_QTY," ).append("\n"); 
		query.append("       SAM_PCK_QTY," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("        'TR',                 " ).append("\n"); 
		query.append("        decode(NVL(trim(@[tr_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("        @[tr_shpr_tax_id]," ).append("\n"); 
		query.append("        decode(NVL(trim(@[tr_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("        @[tr_cnee_tax_id]," ).append("\n"); 
		query.append("        decode(NVL(trim(@[tr_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("        @[tr_ntfy_tax_id]," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        'N'," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        sysdate," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        sysdate" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'IL')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       CNT_CD," ).append("\n"); 
		query.append("       IL_SHPR_PFX_CTNT," ).append("\n"); 
		query.append("       IL_SHPR_TAX_ID," ).append("\n"); 
		query.append("       IL_CNEE_PFX_CTNT," ).append("\n"); 
		query.append("       IL_CNEE_TAX_ID," ).append("\n"); 
		query.append("       IL_NTFY_PFX_CTNT," ).append("\n"); 
		query.append("       IL_NTFY_TAX_ID," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       DIVD_FLG," ).append("\n"); 
		query.append("       DIVD_PCK_QTY," ).append("\n"); 
		query.append("       SAM_PCK_QTY," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("        'IL',                 " ).append("\n"); 
		query.append("        DECODE(NVL(TRIM(@[il_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("        @[il_shpr_tax_id]," ).append("\n"); 
		query.append("        DECODE(NVL(TRIM(@[il_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("        @[il_cnee_tax_id]," ).append("\n"); 
		query.append("        DECODE(NVL(TRIM(@[il_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("        @[il_ntfy_tax_id]," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        'N'," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'LB')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       IO_BND_CD," ).append("\n"); 
		query.append("       XPT_IMP_SEQ," ).append("\n"); 
		query.append("       CNT_CD," ).append("\n"); 
		query.append("       LB_SHPR_TAX_ID," ).append("\n"); 
		query.append("       LB_CNEE_TAX_ID," ).append("\n"); 
		query.append("       LB_NTFY_TAX_ID," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       DIVD_FLG," ).append("\n"); 
		query.append("       DIVD_PCK_QTY," ).append("\n"); 
		query.append("       SAM_PCK_QTY," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("        'LB',                 " ).append("\n"); 
		query.append("        @[lb_shpr_tax_id]," ).append("\n"); 
		query.append("        @[lb_cnee_tax_id]," ).append("\n"); 
		query.append("        @[lb_ntfy_tax_id]," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        'N'," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        0," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'KR')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
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
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("       @[upd_usr_id]," ).append("\n"); 
		query.append("       sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'US')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC_HIS (" ).append("\n"); 
		query.append("       CORR_NO," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO BKG_XPT_IMP_LIC (" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
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
		query.append("       ENTR_CLSS_TP_CD," ).append("\n"); 
		query.append("       ENTR_CLSS_RMK," ).append("\n"); 
		query.append("	   AES_TP_PRN_FLG," ).append("\n"); 
		query.append("       VIN_CTNT," ).append("\n"); 
		query.append("	   CRE_USR_ID," ).append("\n"); 
		query.append("	   CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("	   UPD_DT" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("       VALUES (" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("       'TMP0000001'," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[io_bnd_cd]," ).append("\n"); 
		query.append("       (SELECT NVL(MAX(XPT_IMP_SEQ),0)+1 " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC_HIS " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("           AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("          FROM BKG_XPT_IMP_LIC " ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("#end      " ).append("\n"); 
		query.append("           AND IO_BND_CD = @[io_bnd_cd])," ).append("\n"); 
		query.append("       'US'," ).append("\n"); 
		query.append("	   DECODE(@[aes_tp_cd],'0','',@[aes_tp_cd])," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'AE','AES ITN','')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'AE',decode(trim(@[aes_inlnd_trns_no]), '', '',trim(@[aes_inlnd_trns_no])), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'PA','AESPOST','')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'PA',to_char(decode(trim(@[aes_pta_no1]), '', '',trim(@[aes_pta_no1]))), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'PA',to_char(decode(trim(@[aes_pta_no2]), '', '',trim(@[aes_pta_no2]))),'')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'PA',decode(trim(@[aes_pta_dt]), '', '', to_date(replace(@[aes_pta_dt],'-',''),'mmddyyyy')),'')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'PU','AESPOST','')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'PU',to_char(decode(trim(@[aes_ptu_no]), '', '',trim(@[aes_ptu_no]))), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'PU',decode(trim(@[aes_ptu_dt]), '', '', to_date(replace(@[aes_ptu_dt],'-',''),'mmddyyyy')),'')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'DN','AESDOWN','')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'DN',to_char(decode(trim(@[aes_dwn_no]), '', '',trim(@[aes_dwn_no]))), '')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'DN',decode(trim(@[aes_dwn_dt]), '', '', to_date(replace(@[aes_dwn_dt],'-',''),'mmddyyyy')),'')," ).append("\n"); 
		query.append("       DECODE(@[aes_tp_cd],'EX',@[aes_expt_id],'')," ).append("\n"); 
		query.append("       @[aes_expt_ctnt]," ).append("\n"); 
		query.append("	   0," ).append("\n"); 
		query.append("	   'N'," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("       0," ).append("\n"); 
		query.append("	   @[entr_clss_tp_cd]," ).append("\n"); 
		query.append("	   @[entr_clss_rmk]," ).append("\n"); 
		query.append("	   NVL(@[aes_tp_prn_flg],'N')," ).append("\n"); 
		query.append("       @[vin_ctnt]," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       sysdate," ).append("\n"); 
		query.append("	   @[upd_usr_id]," ).append("\n"); 
		query.append("	   sysdate" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}