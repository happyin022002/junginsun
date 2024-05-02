/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmHdrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.29 
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

public class ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmHdrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddScgPrnrSpclCgoTrsmHdr
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmHdrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("auto_upd_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcvr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_knd_corr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bnd_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_if_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_rslt_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_hdr_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_locl_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flt_file_conv_rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_full_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mapg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cre_locl_dt_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_bnd_cssm_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_unmap_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOAddScgPrnrSpclCgoTrsmHdrCSQL").append("\n"); 
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
		query.append("INSERT INTO " ).append("\n"); 
		query.append("       SCG_PRNR_SPCL_CGO_TRSM_HDR" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	  TRSM_BND_CD" ).append("\n"); 
		query.append("	, TRSM_DT" ).append("\n"); 
		query.append("	, SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("	, PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("	, TRSM_MZD_CD" ).append("\n"); 
		query.append("	, EDI_SNDR_ID" ).append("\n"); 
		query.append("	, EDI_RCVR_ID" ).append("\n"); 
		query.append("	, FLT_FILE_REF_NO" ).append("\n"); 
		query.append("	, EDI_MSG_ID" ).append("\n"); 
		query.append("	, EDI_IF_ID" ).append("\n"); 
		query.append("	, RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("	, CGO_OPR_CD" ).append("\n"); 
		query.append("	, EML_SND_NO" ).append("\n"); 
		query.append("	, SLAN_CD" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, EDI_HDR_MSG" ).append("\n"); 
		query.append("	, BKG_REF_NO" ).append("\n"); 
		query.append("	, BKG_CRE_LOCL_DT" ).append("\n"); 
		query.append("	, BKG_CRE_LOCL_DT_CTNT" ).append("\n"); 
		query.append("	, EDI_MSG_STS_CD" ).append("\n"); 
		query.append("	, EDI_MSG_REF_NO" ).append("\n"); 
		query.append("	, CALL_SGN_NO" ).append("\n"); 
		query.append("	, LLOYD_NO" ).append("\n"); 
		query.append("	, VSL_ENG_FULL_NM" ).append("\n"); 
		query.append("	, SHP_CALL_NO" ).append("\n"); 
		query.append("	, IN_BND_CSSM_VOY_NO" ).append("\n"); 
		query.append("	, OUT_BND_CSSM_VOY_NO" ).append("\n"); 
		query.append("	, POR_CD" ).append("\n"); 
		query.append("	, POR_YD_CD" ).append("\n"); 
		query.append("	, POR_NM" ).append("\n"); 
		query.append("	, POL_CD" ).append("\n"); 
		query.append("	, POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, POL_YD_CD" ).append("\n"); 
		query.append("	, POL_NM" ).append("\n"); 
		query.append("	, POD_CD" ).append("\n"); 
		query.append("	, POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, POD_YD_CD" ).append("\n"); 
		query.append("	, POD_NM" ).append("\n"); 
		query.append("	, DEL_CD" ).append("\n"); 
		query.append("	, DEL_YD_CD" ).append("\n"); 
		query.append("	, DEL_NM" ).append("\n"); 
		query.append("	, FLT_FILE_CONV_RSLT_CD" ).append("\n"); 
		query.append("	, AUTO_UPD_RSLT_CD" ).append("\n"); 
		query.append("	, APLY_RSLT_RMK" ).append("\n"); 
		query.append("	, LST_TRSM_STS_CD" ).append("\n"); 
		query.append("	, MAPG_CRR_CD" ).append("\n"); 
		query.append("	, MAPG_BKG_REF_NO" ).append("\n"); 
		query.append("	, MAPG_SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("    , CRE_OFC_CD" ).append("\n"); 
		query.append("    , UPD_OFC_CD" ).append("\n"); 
		query.append("    , ERR_KND_CD" ).append("\n"); 
		query.append("    , ERR_KND_CORR_CD" ).append("\n"); 
		query.append("    , CTRL_REF_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	, EDI_UNMAP_KND_CD" ).append("\n"); 
		query.append("	)	" ).append("\n"); 
		query.append("  SELECT @[trsm_bnd_cd]" ).append("\n"); 
		query.append("	   , TO_DATE(@[trsm_dt],'yyyy-MM-dd')" ).append("\n"); 
		query.append("	   , @[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("	   , @[prnr_spcl_cgo_seq]" ).append("\n"); 
		query.append("	   , @[trsm_mzd_cd]" ).append("\n"); 
		query.append("	   , @[edi_sndr_id]" ).append("\n"); 
		query.append("	   , @[edi_rcvr_id]" ).append("\n"); 
		query.append("	   , @[flt_file_ref_no]" ).append("\n"); 
		query.append("	   , @[edi_msg_id]" ).append("\n"); 
		query.append("	   , @[edi_if_id]" ).append("\n"); 
		query.append("	   , @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("	   , @[cgo_opr_cd]" ).append("\n"); 
		query.append("	   , @[eml_snd_no]" ).append("\n"); 
		query.append("	   , @[slan_cd]" ).append("\n"); 
		query.append("	   , @[vsl_cd]" ).append("\n"); 
		query.append("	   , @[skd_voy_no]" ).append("\n"); 
		query.append("	   , @[skd_dir_cd]" ).append("\n"); 
		query.append("	   , @[edi_hdr_msg]" ).append("\n"); 
		query.append("	   , @[bkg_ref_no]" ).append("\n"); 
		query.append("	   , TO_DATE(@[bkg_cre_locl_dt], 'YYYYMMDD HH24MISS')" ).append("\n"); 
		query.append("	   , @[bkg_cre_locl_dt_ctnt]" ).append("\n"); 
		query.append("	   , @[edi_msg_sts_cd]" ).append("\n"); 
		query.append("	   , @[edi_msg_ref_no]" ).append("\n"); 
		query.append("	   , @[call_sgn_no]" ).append("\n"); 
		query.append("	   , @[lloyd_no]" ).append("\n"); 
		query.append("	   , @[vsl_eng_full_nm]" ).append("\n"); 
		query.append("	   , @[shp_call_no]" ).append("\n"); 
		query.append("	   , @[in_bnd_cssm_voy_no]" ).append("\n"); 
		query.append("	   , @[out_bnd_cssm_voy_no]" ).append("\n"); 
		query.append("	   , @[por_cd]" ).append("\n"); 
		query.append("	   , @[por_yd_cd]" ).append("\n"); 
		query.append("	   , @[por_nm]" ).append("\n"); 
		query.append("	   , @[pol_cd]" ).append("\n"); 
		query.append("	   , @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("	   , @[pol_yd_cd]" ).append("\n"); 
		query.append("	   , @[pol_nm]" ).append("\n"); 
		query.append("	   , @[pod_cd]" ).append("\n"); 
		query.append("	   , @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("	   , @[pod_yd_cd]" ).append("\n"); 
		query.append("	   , @[pod_nm]" ).append("\n"); 
		query.append("	   , @[del_cd]" ).append("\n"); 
		query.append("	   , @[del_yd_cd]" ).append("\n"); 
		query.append("	   , @[del_nm]" ).append("\n"); 
		query.append("	   , @[flt_file_conv_rslt_cd]" ).append("\n"); 
		query.append("	   , @[auto_upd_rslt_cd]" ).append("\n"); 
		query.append("	   , @[aply_rslt_rmk]" ).append("\n"); 
		query.append("	   , @[lst_trsm_sts_cd]" ).append("\n"); 
		query.append("	   , @[mapg_crr_cd]" ).append("\n"); 
		query.append("	   , @[mapg_bkg_ref_no]" ).append("\n"); 
		query.append("	   , @[mapg_spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("	   , @[cre_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("	   , @[upd_usr_id]" ).append("\n"); 
		query.append("	   , SYSDATE" ).append("\n"); 
		query.append("       , @[cre_ofc_cd]" ).append("\n"); 
		query.append("	   , @[upd_ofc_cd]" ).append("\n"); 
		query.append("       , @[err_knd_cd]" ).append("\n"); 
		query.append("       , @[err_knd_corr_cd]" ).append("\n"); 
		query.append("       , @[ctrl_ref_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , @[edi_unmap_knd_cd]" ).append("\n"); 
		query.append("   FROM DUAL" ).append("\n"); 

	}
}