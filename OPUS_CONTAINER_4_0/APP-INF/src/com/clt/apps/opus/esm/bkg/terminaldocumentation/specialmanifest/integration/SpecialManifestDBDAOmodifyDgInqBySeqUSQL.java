/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOmodifyDgInqBySeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.14
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.01.14 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOmodifyDgInqBySeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 위험물 정보들을 저장한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOmodifyDgInqBySeqUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_svc_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agent",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("net_explo_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dg_short_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("net_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_lmt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwrd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flsh_pnt_cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xtd_stay_prmt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fdr_vsl_lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eur_dcgo_mrn_polut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("emer_rspn_gid_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hcdg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cell_psn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_inr_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_vvd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOmodifyDgInqBySeqUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("   SET CNTR_TPSZ_CD          = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("      ,DCGO_REF_NO           = @[dcgo_ref_no]" ).append("\n"); 
		query.append("      ,CELL_PSN_NO           = LPAD(@[cell_psn_no], 7,0)" ).append("\n"); 
		query.append("      ,IMDG_CLSS_CD          = @[imdg_clss_cd]" ).append("\n"); 
		query.append("      ,EMER_CNTC_PHN_NO      = @[emer_cntc_phn_no]" ).append("\n"); 
		query.append("      ,EMER_CNTC_PSON_NM     = @[emer_cntc_pson_nm]" ).append("\n"); 
		query.append("      ,IMDG_UN_NO            = @[imdg_un_no]" ).append("\n"); 
		query.append("      ,IMDG_UN_NO_SEQ        = @[imdg_un_no_seq]" ).append("\n"); 
		query.append("      ,FLSH_PNT_CDO_TEMP     = @[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append("      ,IMDG_PCK_GRP_CD       = @[imdg_pck_grp_cd]" ).append("\n"); 
		query.append("      ,EUR_DCGO_MRN_POLUT_CD = @[eur_dcgo_mrn_polut_cd]" ).append("\n"); 
		query.append("      ,IMDG_LMT_QTY_FLG      = @[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append("      ,EMS_NO                = @[ems_no]" ).append("\n"); 
		query.append("      ,NET_WGT               = @[net_wgt]" ).append("\n"); 
		query.append("      ,GRS_WGT               = @[grs_wgt]" ).append("\n"); 
		query.append("      ,NET_EXPLO_WGT         = @[net_explo_wgt]" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_QTY1     = NVL(@[out_imdg_pck_qty1], 0)" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_CD1      = @[out_imdg_pck_cd1]" ).append("\n"); 
		query.append("      ,EUR_OUTR_PCK_DESC     = NVL(@[out_imdg_pck_qty1], 0)||' '||(SELECT IMDG_PCK_DESC" ).append("\n"); 
		query.append("                                                                   FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("                                                                   WHERE IMDG_PCK_CD = @[out_imdg_pck_cd1])" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_QTY1     = NVL(@[in_imdg_pck_qty1], 0)" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_CD1      = @[in_imdg_pck_cd1]" ).append("\n"); 
		query.append("      ,EUR_INR_PCK_DESC     = @[eur_inr_pck_desc]" ).append("\n"); 
		query.append("      ,HZD_DESC              = @[hzd_desc]" ).append("\n"); 
		query.append("      ,PRP_SHP_NM            = @[prp_shp_nm]" ).append("\n"); 
		query.append("      ,HCDG_FLG              = NVL(@[hcdg_flg], 'N')" ).append("\n"); 
		query.append("      ,MFAG_NO               = @[mfag_no]" ).append("\n"); 
		query.append("      ,XTD_STAY_PRMT_NO      = @[xtd_stay_prmt_no]" ).append("\n"); 
		query.append("      ,DIFF_RMK              = @[diff_rmk]" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD1 = @[imdg_subs_rsk_lbl_cd1]" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD2 = @[imdg_subs_rsk_lbl_cd2]" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD3 = @[imdg_subs_rsk_lbl_cd3]" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD4 = @[imdg_subs_rsk_lbl_cd4]" ).append("\n"); 
		query.append("      ,EMER_RSPN_GID_NO      = @[emer_rspn_gid_no]" ).append("\n"); 
		query.append("      ,ANR_ROLE_DIV_CD       = @[agent]" ).append("\n"); 
		query.append("      ,ANR_FWRD_ID           = @[fwrd_id]" ).append("\n"); 
		query.append("      ,ANR_CRR_TP_CD         = @[c_type]" ).append("\n"); 
		query.append("      ,ANR_SPCL_TP_ID        = @[dg_short_nm]" ).append("\n"); 
		query.append("      ,FDR_SVC_RQST_NO       = @[fdr_svc_rqst_no]" ).append("\n"); 
		query.append("      ,FDR_VVD_ID            = @[fdr_vvd_id]" ).append("\n"); 
		query.append("      ,FDR_VSL_NM            = @[fdr_vsl_nm]" ).append("\n"); 
		query.append("      ,FDR_VSL_LLOYD_NO      = @[fdr_vsl_lloyd_no]" ).append("\n"); 
		query.append("      ,CRR_DT                = TO_DATE(@[crr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("      ,UPD_DT                = SYSDATE" ).append("\n"); 
		query.append("      ,UPD_USR_ID            = @[upd_usr_id]" ).append("\n"); 
		query.append(" WHERE EUR_DG_DECL_TP_CD     = @[d_type]" ).append("\n"); 
		query.append("   AND VSL_CD                = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO            = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD            = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND PORT_CD               = @[port_cd]" ).append("\n"); 
		query.append("   AND BL_NO                 = @[bl_no]" ).append("\n"); 
		query.append("#if (${save_type} == '1')" ).append("\n"); 
		query.append("   AND CNTR_NO               = @[cntr_no]" ).append("\n"); 
		query.append("   AND CNTR_CGO_SEQ          = @[cntr_cgo_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}