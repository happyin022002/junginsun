/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOXptImpLicUSQL.java
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

public class BLDocumentationBLDBDAOXptImpLicUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLDocumentationBLDBDAOXptImpLicUSQL(){
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
		params.put("cgo_ctrl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sam_pck_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : BLDocumentationBLDBDAOXptImpLicUSQL").append("\n"); 
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
		query.append("	#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("   SET CAED_TP_CD               = DECODE(@[caed_tp_cd],'0','',@[caed_tp_cd])," ).append("\n"); 
		query.append("       CAED_PFX_CTNT            = DECODE(@[caed_tp_cd],'CE','P.O.R : CAED','')," ).append("\n"); 
		query.append("       CAED_NO1                 = DECODE(@[caed_tp_cd],'CE',decode(trim(@[caed_no1]), '', '',trim(@[caed_no1])), '')," ).append("\n"); 
		query.append("       CAED_NO2                 = DECODE(@[caed_tp_cd],'CE',decode(trim(@[caed_no2]), '', '',trim(@[caed_no2])), '')," ).append("\n"); 
		query.append("       CAED_NO3                 = DECODE(@[caed_tp_cd],'CE',to_char(decode(trim(@[caed_no3]), '', '',trim(@[caed_no3]))), '')," ).append("\n"); 
		query.append("       G7_EDI_PFX_CTNT          = DECODE(@[caed_tp_cd],'G7','P.O.R : G7 EDI','')," ).append("\n"); 
		query.append("       G7_EDI_NO1               = DECODE(@[caed_tp_cd],'G7',decode(trim(@[g7_edi_no1]), '', '',trim(@[g7_edi_no1])), '')," ).append("\n"); 
		query.append("       G7_EDI_NO2               = DECODE(@[caed_tp_cd],'G7',to_char(decode(trim(@[g7_edi_no2]), '', '',trim(@[g7_edi_no2]))),'')," ).append("\n"); 
		query.append("       MF_SMRY_RPT_PFX_CTNT     = DECODE(@[caed_tp_cd],'SM','P.O.R : SUM','')," ).append("\n"); 
		query.append("       MF_SMRY_RPT_NO           = DECODE(@[caed_tp_cd],'SM',to_char(decode(trim(@[mf_smry_rpt_no]), '', '',trim(@[mf_smry_rpt_no]))), '')," ).append("\n"); 
		query.append("       B13A_XPT_PFX_CTNT        = DECODE(@[caed_tp_cd],'EX','P.O.R : B13A','')," ).append("\n"); 
		query.append("       B13A_XPT_DT              = CASE WHEN @[caed_tp_cd] = 'EX' AND trim(@[b13a_xpt_dt]) IS NOT NULL THEN to_date(@[b13a_xpt_dt],'yyyy/mm/dd hh24:mi') ELSE NULL END," ).append("\n"); 
		query.append("       B13A_XPT_NO1             = DECODE(@[caed_tp_cd],'EX',to_char(decode(trim(@[b13a_xpt_no1]), '', '',trim(@[b13a_xpt_no1]))), '')," ).append("\n"); 
		query.append("       B13A_XPT_NO2             = DECODE(@[caed_tp_cd],'EX',to_char(decode(trim(@[b13a_xpt_no2]), '', '',trim(@[b13a_xpt_no2]))), '')," ).append("\n"); 
		query.append("       CGO_CTRL_PFX_CTNT        = DECODE(@[caed_tp_cd],'IT','P.O.R : In-Bond Cargo','')," ).append("\n"); 
		query.append("       CGO_CTRL_NO              = DECODE(@[caed_tp_cd],'IT',decode(trim(@[cgo_ctrl_no]), '', '',trim(@[cgo_ctrl_no])), '')," ).append("\n"); 
		query.append("       NDR_REF_PFX_CTNT         = DECODE(@[caed_tp_cd],'ND','P.O.R :','')," ).append("\n"); 
		query.append("       NDR_REF_ID               = DECODE(@[caed_tp_cd],'ND',@[ndr_ref_id],'')," ).append("\n"); 
		query.append("       NDR_REF_CTNT             = @[ndr_ref_ctnt]," ).append("\n"); 
		query.append("       upd_usr_id 				= @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 				    = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("	#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD  		= @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'TG')  " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET TG_ECTN_NO               = @[tg_ectn_no],              " ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD  		= @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'NG')  " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET NG_EXS_ENS_NO               = @[ng_exs_ens_no],              " ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD  		= @[cnt_cd]   " ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'BR')   " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET SHPR_TAX_NO               = @[shpr_tax_no]," ).append("\n"); 
		query.append("       CNEE_TAX_NO               = @[cnee_tax_no]," ).append("\n"); 
		query.append("       NTFY_TAX_NO               = @[ntfy_tax_no]," ).append("\n"); 
		query.append("       BRZ_DECL_NO               = @[brz_decl_no]," ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD  		= @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'ID')     " ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET ID_XPT_NO                = @[id_xpt_no]," ).append("\n"); 
		query.append("	   ID_XPT_NO_ISS_DT         = to_date(@[id_xpt_no_iss_dt],'yyyymmdd')," ).append("\n"); 
		query.append("	   ID_OFC_ID         	    = @[id_ofc_cd]," ).append("\n"); 
		query.append("	   ID_DECL_CD         	    = @[id_decl_cd]," ).append("\n"); 
		query.append("       upd_usr_id 		        = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			        = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD  		= @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'IN')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET IDA_IEC_NO                = @[ida_iec_no]," ).append("\n"); 
		query.append("       IDA_SHP_BIL_NO            = @[ida_shp_bil_no]," ).append("\n"); 
		query.append("	   CNTR_NO					 = @[cntr_no]," ).append("\n"); 
		query.append("       IDA_SHP_BIL_ISS_DT        = TO_DATE(REPLACE(@[ida_shp_bil_iss_dt],'-',''),'YYYYMMDD')," ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD  		= @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'MX')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET MX_SHPR_PFX_CTNT			 = decode(NVL(trim(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   MX_SHPR_TAX_ID            = @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   MX_CNEE_PFX_CTNT			 = decode(NVL(trim(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID            = @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   MX_NTFY_PFX_CTNT			 = decode(NVL(trim(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID            = @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'CO')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET MX_SHPR_PFX_CTNT			 = decode(NVL(trim(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   MX_SHPR_TAX_ID            = @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   MX_CNEE_PFX_CTNT			 = decode(NVL(trim(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID            = @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   MX_NTFY_PFX_CTNT			 = decode(NVL(trim(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID            = @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'EC')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET MX_SHPR_PFX_CTNT			 = decode(NVL(trim(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   MX_SHPR_TAX_ID            = @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   MX_CNEE_PFX_CTNT			 = decode(NVL(trim(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID            = @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   MX_NTFY_PFX_CTNT			 = decode(NVL(trim(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID            = @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'PE')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET MX_SHPR_PFX_CTNT			 = decode(NVL(trim(@[mx_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   MX_SHPR_TAX_ID            = @[mx_shpr_tax_id]," ).append("\n"); 
		query.append("	   MX_CNEE_PFX_CTNT			 = decode(NVL(trim(@[mx_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("       MX_CNEE_TAX_ID            = @[mx_cnee_tax_id]," ).append("\n"); 
		query.append("	   MX_NTFY_PFX_CTNT			 = decode(NVL(trim(@[mx_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("       MX_NTFY_TAX_ID            = @[mx_ntfy_tax_id]," ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'TR')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET TR_SHPR_PFX_CTNT			 = decode(NVL(trim(@[tr_shpr_tax_id]), '*'), '*', '', 'SHIPPER TAX ID')," ).append("\n"); 
		query.append("	   TR_SHPR_TAX_ID            = @[tr_shpr_tax_id]," ).append("\n"); 
		query.append("	   TR_CNEE_PFX_CTNT			 = decode(NVL(trim(@[tr_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE TAX ID')," ).append("\n"); 
		query.append("       TR_CNEE_TAX_ID            = @[tr_cnee_tax_id]," ).append("\n"); 
		query.append("	   TR_NTFY_PFX_CTNT			 = decode(NVL(trim(@[tr_ntfy_tax_id]), '*'), '*', '', 'NOTIFY TAX ID')," ).append("\n"); 
		query.append("       TR_NTFY_TAX_ID            = @[tr_ntfy_tax_id]," ).append("\n"); 
		query.append("       upd_usr_id 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			         = sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'IL')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET IL_SHPR_PFX_CTNT			 = DECODE(NVL(TRIM(@[il_shpr_tax_id]), '*'), '*', '', 'SHIPPER VAT ID')," ).append("\n"); 
		query.append("	   IL_SHPR_TAX_ID            = @[il_shpr_tax_id]," ).append("\n"); 
		query.append("	   IL_CNEE_PFX_CTNT			 = DECODE(NVL(TRIM(@[il_cnee_tax_id]), '*'), '*', '', 'CONSIGNEE VAT ID')," ).append("\n"); 
		query.append("       IL_CNEE_TAX_ID            = @[il_cnee_tax_id]," ).append("\n"); 
		query.append("	   IL_NTFY_PFX_CTNT			 = DECODE(NVL(TRIM(@[il_ntfy_tax_id]), '*'), '*', '', 'NOTIFY VAT ID')," ).append("\n"); 
		query.append("       IL_NTFY_TAX_ID            = @[il_ntfy_tax_id]," ).append("\n"); 
		query.append("       UPD_USR_ID 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT 			         = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'LB')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET LB_SHPR_TAX_ID            = @[lb_shpr_tax_id]," ).append("\n"); 
		query.append("	   LB_CNEE_TAX_ID            = @[lb_cnee_tax_id]," ).append("\n"); 
		query.append("	   LB_NTFY_TAX_ID            = @[lb_ntfy_tax_id]," ).append("\n"); 
		query.append("       UPD_USR_ID 		         = @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT 			         = SYSDATE" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD       = @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'KR')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET XPT_LIC_NO       = @[xpt_lic_no]," ).append("\n"); 
		query.append("       PCK_QTY     = @[pck_qty]," ).append("\n"); 
		query.append("       PCK_TP_CD   = @[pck_tp_cd]," ).append("\n"); 
		query.append("       MF_WGT         = @[mf_wgt]," ).append("\n"); 
		query.append("       WGT_UT_CD   = @[wgt_ut_cd]," ).append("\n"); 
		query.append("       DIVD_PCK_QTY     = DECODE(NVL(@[divd_seq], 0), 0, 0, @[pck_qty])," ).append("\n"); 
		query.append("       DIVD_PCK_TP_CD   = DECODE(NVL(@[divd_seq], 0), 0, '', @[pck_tp_cd])," ).append("\n"); 
		query.append("       DIVD_WGT         = DECODE(NVL(@[divd_seq], 0), 0, 0, @[mf_wgt])," ).append("\n"); 
		query.append("       DIVD_WGT_UT_CD   = DECODE(NVL(@[divd_seq], 0), 0, '', @[wgt_ut_cd])," ).append("\n"); 
		query.append("       DIVD_FLG			= DECODE(NVL(@[divd_seq], 0), 0, 'N', 'Y')," ).append("\n"); 
		query.append("       DIVD_SEQ         = @[divd_seq]," ).append("\n"); 
		query.append("       SAM_PCK_ID       = @[sam_pck_id]," ).append("\n"); 
		query.append("       SAM_PCK_QTY      = @[sam_pck_qty]," ).append("\n"); 
		query.append("       SAM_PCK_TP_CD    = @[sam_pck_tp_cd]," ).append("\n"); 
		query.append("       UCR_NO           = @[ucr_no]," ).append("\n"); 
		query.append("       TS_REF_NO        = @[ts_ref_no]," ).append("\n"); 
		query.append("       upd_usr_id 		= @[upd_usr_id]," ).append("\n"); 
		query.append("	   upd_dt 			= sysdate" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD  		= @[cnt_cd]" ).append("\n"); 
		query.append("#elseif(${cnt_cd} == 'US')" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   SET AES_TP_CD                = DECODE(@[aes_tp_cd],'0', '', @[aes_tp_cd])," ).append("\n"); 
		query.append("       AES_INLND_TRNS_PFX_CTNT  = DECODE(@[aes_tp_cd],'AE','AES ITN','')," ).append("\n"); 
		query.append("       AES_INLND_TRNS_NO        = DECODE(@[aes_tp_cd],'AE',decode(trim(@[aes_inlnd_trns_no]), '', '',trim(@[aes_inlnd_trns_no])), '')," ).append("\n"); 
		query.append("       AES_PTA_PFX_CTNT         = DECODE(@[aes_tp_cd],'PA','AESPOST','')," ).append("\n"); 
		query.append("       AES_PTA_NO1              = DECODE(@[aes_tp_cd],'PA',to_char(decode(trim(@[aes_pta_no1]), '', '',trim(@[aes_pta_no1]))), '')," ).append("\n"); 
		query.append("       AES_PTA_NO2              = DECODE(@[aes_tp_cd],'PA',to_char(decode(trim(@[aes_pta_no2]), '', '',trim(@[aes_pta_no2]))),'')," ).append("\n"); 
		query.append("       AES_PTA_DT               = DECODE(@[aes_tp_cd],'PA',decode(trim(@[aes_pta_dt]), '', '', to_date(replace(@[aes_pta_dt],'-',''),'mmddyyyy')),'')," ).append("\n"); 
		query.append("       AES_PTU_PFX_CTNT         = DECODE(@[aes_tp_cd],'PU','AESPOST','')," ).append("\n"); 
		query.append("       AES_PTU_NO               = DECODE(@[aes_tp_cd],'PU',to_char(decode(trim(@[aes_ptu_no]), '', '',trim(@[aes_ptu_no]))), '')," ).append("\n"); 
		query.append("       AES_PTU_DT               = DECODE(@[aes_tp_cd],'PU',decode(trim(@[aes_ptu_dt]), '', '', to_date(replace(@[aes_ptu_dt],'-',''),'mmddyyyy')),'')," ).append("\n"); 
		query.append("       AES_DWN_PFX_CTNT         = DECODE(@[aes_tp_cd],'DN','AESDOWN','')," ).append("\n"); 
		query.append("       AES_DWN_NO               = DECODE(@[aes_tp_cd],'DN',to_char(decode(trim(@[aes_dwn_no]), '', '',trim(@[aes_dwn_no]))), '')," ).append("\n"); 
		query.append("       AES_DWN_DT               = DECODE(@[aes_tp_cd],'DN',decode(trim(@[aes_dwn_dt]), '', '', to_date(replace(@[aes_dwn_dt],'-',''),'mmddyyyy')),'')," ).append("\n"); 
		query.append("       AES_EXPT_ID              = DECODE(@[aes_tp_cd],'EX',@[aes_expt_id],'')," ).append("\n"); 
		query.append("       AES_EXPT_CTNT            = @[aes_expt_ctnt]," ).append("\n"); 
		query.append("	   ENTR_CLSS_TP_CD			= @[entr_clss_tp_cd]," ).append("\n"); 
		query.append("       ENTR_CLSS_RMK			= @[entr_clss_rmk]," ).append("\n"); 
		query.append("       UPD_USR_ID 				= @[upd_usr_id]," ).append("\n"); 
		query.append("	   UPD_DT 				    = sysdate," ).append("\n"); 
		query.append("       AES_TP_PRN_FLG           = NVL(@[aes_tp_prn_flg],'N')," ).append("\n"); 
		query.append("       VIN_CTNT                 = @[vin_ctnt]" ).append("\n"); 
		query.append(" WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("   AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND IO_BND_CD    = @[io_bnd_cd]   " ).append("\n"); 
		query.append("   AND XPT_IMP_SEQ  = @[xpt_imp_seq]" ).append("\n"); 
		query.append("   AND CNT_CD  		= @[cnt_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}