/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgXterVrfdWgtRqstCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.05
*@LastModifier : 윤용상
*@LastVersion : 1.0
* 2016.08.05 윤용상
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YOON Yong-Sang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOaddBkgXterVrfdWgtRqstCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgXterVrfdWgtRqstCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_via_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upld_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_dtmn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_cntr_seal_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rjct_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upld_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upld_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_vgm_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_doc_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_mzd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_bkg_rqst_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_cntc_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_si_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vgm_vrfy_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smt_addr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOaddBkgXterVrfdWgtRqstCSQL").append("\n"); 
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
		query.append("  INTO BKG_XTER_VRFD_WGT_RQST ( XTER_SNDR_ID, XTER_VGM_RQST_NO, XTER_VGM_SEQ, CNTR_NO, CNTR_TPSZ_CD, BKG_NO, XTER_RQST_VIA_CD, VGM_UPLD_STS_CD, UPLD_USR_ID, UPLD_DT, UPLD_GDT, RJCT_RSN_RMK, RQST_DT, RQST_DELT_FLG, CUST_ID, VGM_WGT, VGM_WGT_UT_CD, VGM_VRFY_DT, VGM_DTMN_DT, XTER_BKG_RQST_REF_NO, XTER_SI_REF_NO, VGM_MZD_TP_CD, XTER_CNTR_SEAL_NO, VGM_EDI_TP_CD, SMT_DT, SMT_NM, SMT_ADDR, SMT_CNTC_DESC, SMT_EML, SMT_PHN_NO, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, vgm_doc_id )" ).append("\n"); 
		query.append("VALUES ( @[xter_sndr_id]," ).append("\n"); 
		query.append("               @[xter_vgm_rqst_no]," ).append("\n"); 
		query.append("               (select nvl(max(xter_vgm_seq) + 1, 1) from bkg_xter_vrfd_wgt_rqst where xter_sndr_id = @[xter_sndr_id] and xter_vgm_rqst_no = @[xter_vgm_rqst_no] and cntr_no = UPPER(@[cntr_no]))," ).append("\n"); 
		query.append("               UPPER(@[cntr_no])," ).append("\n"); 
		query.append("               @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("               UPPER(@[bkg_no])," ).append("\n"); 
		query.append("               nvl(@[xter_rqst_via_cd], decode(@[xter_sndr_id], 'CARGOSMART', 'CSM'," ).append("\n"); 
		query.append("                            'INTTRA', 'INT'," ).append("\n"); 
		query.append("							'INTTRANG2', 'INT'," ).append("\n"); 
		query.append("                            'GTNEXUS', 'GTN'," ).append("\n"); 
		query.append("                            'DAKOSY', 'DAK', 'SEANACCS', 'SEA'," ).append("\n"); 
		query.append("							'EDI'))," ).append("\n"); 
		query.append("               'N'," ).append("\n"); 
		query.append("               @[upld_usr_id]," ).append("\n"); 
		query.append("               to_date(@[upld_dt], 'yyyyMMddhh24miss')," ).append("\n"); 
		query.append("               @[upld_gdt]," ).append("\n"); 
		query.append("               @[rjct_rsn_rmk]," ).append("\n"); 
		query.append("               sysdate," ).append("\n"); 
		query.append("               'N'," ).append("\n"); 
		query.append("               @[cust_id]," ).append("\n"); 
		query.append("               @[vgm_wgt]," ).append("\n"); 
		query.append("               @[vgm_wgt_ut_cd]," ).append("\n"); 
		query.append("               to_date(@[vgm_vrfy_dt], 'yyyyMMddhh24miss')," ).append("\n"); 
		query.append("               to_date(@[vgm_dtmn_dt], 'yyyyMMddhh24miss')," ).append("\n"); 
		query.append("               @[xter_bkg_rqst_ref_no]," ).append("\n"); 
		query.append("               @[xter_si_ref_no]," ).append("\n"); 
		query.append("               @[vgm_mzd_tp_cd]," ).append("\n"); 
		query.append("               @[xter_cntr_seal_no]," ).append("\n"); 
		query.append("               @[vgm_edi_tp_cd]," ).append("\n"); 
		query.append("               to_date(@[smt_dt], 'yyyyMMddhh24miss')," ).append("\n"); 
		query.append("               @[smt_nm]," ).append("\n"); 
		query.append("               @[smt_addr]," ).append("\n"); 
		query.append("               @[smt_cntc_desc]," ).append("\n"); 
		query.append("               @[smt_eml]," ).append("\n"); 
		query.append("               @[smt_phn_no]," ).append("\n"); 
		query.append("               @[cre_usr_id]," ).append("\n"); 
		query.append("               sysdate," ).append("\n"); 
		query.append("               @[upd_usr_id]," ).append("\n"); 
		query.append("               sysdate, @[vgm_doc_id] )" ).append("\n"); 

	}
}