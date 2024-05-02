/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoDtlLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoDtlLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INSERT
	  * SCG_PRNR_SPCL_CGO_DTL_LOG
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoDtlLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_spcl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n1st_imdg_pck_qty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_sts_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_cgo_unmap_dtl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n7th_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n1st_imdg_pck_qty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_dmy_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n8th_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_explo_wgt_ut_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_add_segr_grp_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iso_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_dtl_sts_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_mrn_polut_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_ppr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("psa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n1st_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n5th_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n1st_imdg_pck_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n1st_imdg_pck_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mfag_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4th_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_stwg_rqst_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt_ut_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty_flg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_temp_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_expt_qty_flg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rsd_flg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_tec_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("esp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_amdt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_pson_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flsh_pnt_ut_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_n1st_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_n1st_imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n6th_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n1st_imdg_pck_qty_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ems_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt_ut_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("intmd_n1st_imdg_pck_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_sub_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_explo_wgt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_segr_grp_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_mrn_polut_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoDtlLogCSQL").append("\n"); 
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
		query.append("INSERT INTO	SCG_PRNR_SPCL_CGO_DTL_LOG" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	  TRSM_BND_CD" ).append("\n"); 
		query.append("	, TRSM_DT" ).append("\n"); 
		query.append("	, SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("	, PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("	, PRNR_SPCL_CGO_SUB_SEQ" ).append("\n"); 
		query.append("	, CNTR_REF_NO" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD_CTNT" ).append("\n"); 
		query.append("	, ISO_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, EDI_ITM_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, DCGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, DCGO_STS_CD_CTNT" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	, DCGO_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, MVMT_SPCL_TP_CD" ).append("\n"); 
		query.append("	, OUT_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("	, OUT_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("	, OUT_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("	, INTMD_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("	, INTMD_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("	, INTMD_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("	, IN_N1ST_IMDG_PCK_CD_CTNT" ).append("\n"); 
		query.append("	, IN_N1ST_IMDG_PCK_QTY_CTNT" ).append("\n"); 
		query.append("	, IN_N1ST_IMDG_PCK_DESC" ).append("\n"); 
		query.append("	, HZD_DESC" ).append("\n"); 
		query.append("	, PRP_SHP_NM" ).append("\n"); 
		query.append("	, IMDG_TEC_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, IMDG_AMDT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, IMDG_CLSS_CD_CTNT" ).append("\n"); 
		query.append("	, IMDG_PPR_NO" ).append("\n"); 
		query.append("	, IMDG_UN_NO_CTNT" ).append("\n"); 
		query.append("	, IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("	, CFR_FLG" ).append("\n"); 
		query.append("	, CFR_NO" ).append("\n"); 
		query.append("	, FLSH_PNT_UT_CD_CTNT" ).append("\n"); 
		query.append("	, FLSH_PNT_TEMP_CTNT" ).append("\n"); 
		query.append("	, IMDG_PCK_GRP_CD_CTNT" ).append("\n"); 
		query.append("	, EMS_NO" ).append("\n"); 
		query.append("	, MFAG_NO" ).append("\n"); 
		query.append("	, ESP_NO" ).append("\n"); 
		query.append("	, IMDG_MRN_POLUT_FLG" ).append("\n"); 
		query.append("	, IMDG_MRN_POLUT_CD_CTNT" ).append("\n"); 
		query.append("	, IMDG_LMT_QTY_FLG_CTNT" ).append("\n"); 
		query.append("	, IMDG_EXPT_QTY_FLG_CTNT" ).append("\n"); 
		query.append("	, GRS_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("	, GRS_WGT_CTNT" ).append("\n"); 
		query.append("	, NET_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("	, NET_WGT_CTNT" ).append("\n"); 
		query.append("	, PCK_TP_CD_CTNT" ).append("\n"); 
		query.append("	, PCK_QTY_CTNT" ).append("\n"); 
		query.append("	, DIFF_RMK" ).append("\n"); 
		query.append("	, EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("	, EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("	, PSA_NO" ).append("\n"); 
		query.append("	, SPCL_STWG_RQST_DESC" ).append("\n"); 
		query.append("	, RSD_FLG_CTNT" ).append("\n"); 
		query.append("    , NET_EXPLO_WGT_UT_CD_CTNT" ).append("\n"); 
		query.append("    , NET_EXPLO_WGT_CTNT" ).append("\n"); 
		query.append("    , CNTR_DMY_REF_NO" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("	,	N1ST_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	,	N2ND_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	,	N3RD_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	,	N4TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	,	N5TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	,	N6TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	,	N7TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	,	N8TH_IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	EDI_CGO_UNMAP_DTL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--::2015-10-22::--" ).append("\n"); 
		query.append("	,	DCGO_DTL_STS_CD_CTNT" ).append("\n"); 
		query.append("	,	IMDG_ADD_SEGR_GRP_NO_CTNT" ).append("\n"); 
		query.append("	,	IMDG_SEGR_GRP_NO_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	CTRL_TEMP_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("  SELECT @[trsm_bnd_cd]" ).append("\n"); 
		query.append("	   , TO_DATE(@[trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("	   , @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("	   , @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , CASE 	WHEN @[prnr_spcl_cgo_sub_seq] IS NOT NULL THEN TO_NUMBER(@[prnr_spcl_cgo_sub_seq])" ).append("\n"); 
		query.append("				ELSE" ).append("\n"); 
		query.append("	   				(	SELECT 	NVL(MAX(PRNR_SPCL_CGO_SUB_SEQ),0) + 1 " ).append("\n"); 
		query.append("       					FROM 	SCG_PRNR_SPCL_CGO_DTL_LOG" ).append("\n"); 
		query.append("       					WHERE 	TRSM_BND_CD       			= @[trsm_bnd_cd]" ).append("\n"); 
		query.append("       					AND 	TRSM_DT           			= TO_DATE(@[trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("       					AND 	SPCL_CGO_CATE_CD  			= @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("       					AND 	PRNR_SPCL_CGO_SEQ 			= @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("       				)" ).append("\n"); 
		query.append("		 END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[cntr_ref_no]" ).append("\n"); 
		query.append("	   , @[cntr_tpsz_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[iso_cntr_tpsz_cd]" ).append("\n"); 
		query.append("	   , @[cgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[edi_itm_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[dcgo_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[dcgo_sts_cd_ctnt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[dcgo_ref_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[mvmt_spcl_tp_cd]" ).append("\n"); 
		query.append("	   , @[out_n1st_imdg_pck_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[out_n1st_imdg_pck_qty_ctnt]" ).append("\n"); 
		query.append("	   , @[out_n1st_imdg_pck_desc]" ).append("\n"); 
		query.append("	   , @[intmd_n1st_imdg_pck_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[intmd_n1st_imdg_pck_qty_ctnt]" ).append("\n"); 
		query.append("	   , @[intmd_n1st_imdg_pck_desc]" ).append("\n"); 
		query.append("	   , @[in_n1st_imdg_pck_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[in_n1st_imdg_pck_qty_ctnt]" ).append("\n"); 
		query.append("	   , @[in_n1st_imdg_pck_desc]" ).append("\n"); 
		query.append("	   , @[hzd_desc]" ).append("\n"); 
		query.append("	   , @[prp_shp_nm]" ).append("\n"); 
		query.append("	   , @[imdg_tec_nm]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[imdg_amdt_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[imdg_clss_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[imdg_ppr_no]" ).append("\n"); 
		query.append("	   , @[imdg_un_no_ctnt]" ).append("\n"); 
		query.append("	   , @[imdg_un_no_seq]" ).append("\n"); 
		query.append("	   , @[cfr_flg]" ).append("\n"); 
		query.append("	   , @[cfr_no]" ).append("\n"); 
		query.append("	   , @[flsh_pnt_ut_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[flsh_pnt_temp_ctnt]" ).append("\n"); 
		query.append("	   , @[imdg_pck_grp_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[ems_no]" ).append("\n"); 
		query.append("	   , @[mfag_no]" ).append("\n"); 
		query.append("	   , @[esp_no]" ).append("\n"); 
		query.append("	   , @[imdg_mrn_polut_flg]" ).append("\n"); 
		query.append("	   , @[imdg_mrn_polut_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[imdg_lmt_qty_flg_ctnt]" ).append("\n"); 
		query.append("	   , @[imdg_expt_qty_flg_ctnt]" ).append("\n"); 
		query.append("	   , @[grs_wgt_ut_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[grs_wgt_ctnt]" ).append("\n"); 
		query.append("	   , @[net_wgt_ut_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[net_wgt_ctnt]" ).append("\n"); 
		query.append("	   , @[pck_tp_cd_ctnt]" ).append("\n"); 
		query.append("	   , @[pck_qty_ctnt]" ).append("\n"); 
		query.append("	   , @[diff_rmk]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , SUBSTR(@[emer_cntc_phn_no],1,100)" ).append("\n"); 
		query.append("	   --, [emer_cntc_phn_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	   , @[emer_cntc_pson_nm]" ).append("\n"); 
		query.append("	   , @[psa_no]" ).append("\n"); 
		query.append("	   , @[spcl_stwg_rqst_desc]" ).append("\n"); 
		query.append("	   , @[rsd_flg_ctnt]" ).append("\n"); 
		query.append("       , @[net_explo_wgt_ut_cd_ctnt]" ).append("\n"); 
		query.append("       , @[net_explo_wgt_ctnt]" ).append("\n"); 
		query.append("       , @[cntr_dmy_ref_no]" ).append("\n"); 
		query.append("	   , @[cre_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("	   , @[upd_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	@[imdg_comp_grp_cd]           " ).append("\n"); 
		query.append("	,	@[n1st_imdg_subs_rsk_lbl_cd]  " ).append("\n"); 
		query.append("	,	@[n2nd_imdg_subs_rsk_lbl_cd]  " ).append("\n"); 
		query.append("	,	@[n3rd_imdg_subs_rsk_lbl_cd]  " ).append("\n"); 
		query.append("	,	@[n4th_imdg_subs_rsk_lbl_cd]  " ).append("\n"); 
		query.append("	,	@[n5th_imdg_subs_rsk_lbl_cd]  " ).append("\n"); 
		query.append("	,	@[n6th_imdg_subs_rsk_lbl_cd]  " ).append("\n"); 
		query.append("	,	@[n7th_imdg_subs_rsk_lbl_cd]  " ).append("\n"); 
		query.append("	,	@[n8th_imdg_subs_rsk_lbl_cd]  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	@[edi_cgo_unmap_dtl_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	--::2015-10-22::--" ).append("\n"); 
		query.append("	,	@[dcgo_dtl_sts_cd_ctnt]" ).append("\n"); 
		query.append("	,	@[imdg_add_segr_grp_no_ctnt]" ).append("\n"); 
		query.append("	,	@[imdg_segr_grp_no_ctnt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,	@[ctrl_temp_ctnt]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 

	}
}