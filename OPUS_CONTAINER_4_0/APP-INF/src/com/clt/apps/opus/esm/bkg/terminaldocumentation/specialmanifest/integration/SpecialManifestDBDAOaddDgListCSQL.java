/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialManifestDBDAOaddDgListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.14
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.12.14 이종길
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

public class SpecialManifestDBDAOaddDgListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 위험물 정보들을 신규생성한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOaddDgListCSQL(){
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
		params.put("agent",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eur_dcgo_mrn_polut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mfag_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("out_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_outr_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("emer_cntc_phn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_vsl_lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("aply_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOaddDgListCSQL").append("\n"); 
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
		query.append("  INTO BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("      (EUR_DG_DECL_TP_CD" ).append("\n"); 
		query.append("      ,VSL_CD" ).append("\n"); 
		query.append("      ,SKD_VOY_NO" ).append("\n"); 
		query.append("      ,SKD_DIR_CD" ).append("\n"); 
		query.append("      ,PORT_CD" ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("      ,CNTR_CGO_SEQ" ).append("\n"); 
		query.append("      ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,BL_NO" ).append("\n"); 
		query.append("      ,POL_CD" ).append("\n"); 
		query.append("      ,POD_CD" ).append("\n"); 
		query.append("      ,CELL_PSN_NO" ).append("\n"); 
		query.append("      ,ANR_FWRD_ID" ).append("\n"); 
		query.append("      ,SVC_RQST_NO" ).append("\n"); 
		query.append("      ,ANR_CRR_TP_CD" ).append("\n"); 
		query.append("      ,FDR_SVC_RQST_NO" ).append("\n"); 
		query.append("      ,FDR_VVD_ID" ).append("\n"); 
		query.append("      ,FDR_VSL_NM" ).append("\n"); 
		query.append("      ,FDR_VSL_LLOYD_NO" ).append("\n"); 
		query.append("      ,IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("      ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("      ,IMDG_UN_NO" ).append("\n"); 
		query.append("      ,IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("      ,ANR_SPCL_TP_ID" ).append("\n"); 
		query.append("      ,FLSH_PNT_CDO_TEMP" ).append("\n"); 
		query.append("      ,NET_WGT" ).append("\n"); 
		query.append("      ,GRS_WGT" ).append("\n"); 
		query.append("      ,MFAG_NO" ).append("\n"); 
		query.append("      ,PRP_SHP_NM" ).append("\n"); 
		query.append("      ,HZD_DESC" ).append("\n"); 
		query.append("      ,IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("      ,PCK_QTY" ).append("\n"); 
		query.append("      ,PCK_TP_CD" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,OUT_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,EUR_OUTR_PCK_DESC" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_QTY1" ).append("\n"); 
		query.append("      ,IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append("      ,EUR_INR_PCK_DESC" ).append("\n"); 
		query.append("      ,EMS_NO" ).append("\n"); 
		query.append("      ,ANR_ROLE_DIV_CD" ).append("\n"); 
		query.append("      ,CRE_USR_ID" ).append("\n"); 
		query.append("      ,CRE_DT" ).append("\n"); 
		query.append("      ,UPD_USR_ID" ).append("\n"); 
		query.append("      ,UPD_DT" ).append("\n"); 
		query.append("      ,EUR_PCK_DESC" ).append("\n"); 
		query.append("      ,EUR_DCGO_MRN_POLUT_CD" ).append("\n"); 
		query.append("      ,XTD_STAY_PRMT_NO" ).append("\n"); 
		query.append("      ,DIFF_RMK" ).append("\n"); 
		query.append("      ,CRR_DT" ).append("\n"); 
		query.append("      ,NET_EXPLO_WGT" ).append("\n"); 
		query.append("      ,CGO_OPR_CD" ).append("\n"); 
		query.append("      ,APLY_NO" ).append("\n"); 
		query.append("      ,CNTR_REF_NO" ).append("\n"); 
		query.append("      ,DCGO_REF_NO" ).append("\n"); 
		query.append("      ,EMER_CNTC_PHN_NO" ).append("\n"); 
		query.append("      ,EMER_CNTC_PSON_NM" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append("      ,IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append("      ,HCDG_FLG" ).append("\n"); 
		query.append("      ,EMER_RSPN_GID_NO" ).append("\n"); 
		query.append("      ,SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("      ,SPCL_CGO_SEQ" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("VALUES(@[d_type]" ).append("\n"); 
		query.append("      ,SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("      ,SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("      ,SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("      ,@[port_cd]" ).append("\n"); 
		query.append("      ,@[cntr_no]" ).append("\n"); 
		query.append("      ,(SELECT NVL(MAX(CNTR_CGO_SEQ), 0) + 1 " ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("         WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("           AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("           AND PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("           AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("           AND CNTR_NO    = @[cntr_no]" ).append("\n"); 
		query.append("           AND CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("      ,@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("      ,@[bl_no]" ).append("\n"); 
		query.append("      ,@[pol_cd]" ).append("\n"); 
		query.append("      ,@[pod_cd]" ).append("\n"); 
		query.append("      ,NVL(LPAD(@[cell_psn_no], 7,0 ),(SELECT LPAD(OPF.VSL_BAY_NO || OPF.VSL_ROW_NO || OPF.VSL_TR_NO, 7,0 ) CELL_PSN_NO" ).append("\n"); 
		query.append("                					   FROM OPF_BAY_PLN_LDIS OPF" ).append("\n"); 
		query.append("                                       WHERE 1=1" ).append("\n"); 
		query.append("                                       AND OPF.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                					   AND OPF.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("									   AND OPF.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("             					  	   AND OPF.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("             					  	   AND OPF.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("                					   AND OPF.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("									   AND OPF.CNTR_REF_NO = @[cntr_no]" ).append("\n"); 
		query.append("									   AND ROWNUM = 1))" ).append("\n"); 
		query.append("      ,@[fwrd_id]" ).append("\n"); 
		query.append("      ,@[svc_rqst_no]" ).append("\n"); 
		query.append("      ,@[c_type]" ).append("\n"); 
		query.append("      ,@[fdr_svc_rqst_no]" ).append("\n"); 
		query.append("      ,@[fdr_vvd_id]" ).append("\n"); 
		query.append("      ,@[fdr_vsl_nm]" ).append("\n"); 
		query.append("      ,@[fdr_vsl_lloyd_no]" ).append("\n"); 
		query.append("      ,@[imdg_pck_grp_cd]" ).append("\n"); 
		query.append("      ,@[imdg_clss_cd]" ).append("\n"); 
		query.append("      ,@[imdg_un_no]" ).append("\n"); 
		query.append("      ,@[imdg_un_no_seq]" ).append("\n"); 
		query.append("      ,@[dg_short_nm]" ).append("\n"); 
		query.append("      ,@[flsh_pnt_cdo_temp]" ).append("\n"); 
		query.append("      ,@[net_wgt]" ).append("\n"); 
		query.append("      ,@[grs_wgt]" ).append("\n"); 
		query.append("      ,@[mfag_no]" ).append("\n"); 
		query.append("      ,@[prp_shp_nm]" ).append("\n"); 
		query.append("      ,@[hzd_desc]" ).append("\n"); 
		query.append("      ,@[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append("      ,NVL(@[out_imdg_pck_qty1], 0)" ).append("\n"); 
		query.append("      ,@[pck_tp_cd]" ).append("\n"); 
		query.append("      ,NVL(@[out_imdg_pck_qty1], 0)" ).append("\n"); 
		query.append("      ,@[out_imdg_pck_cd1]" ).append("\n"); 
		query.append("      ,NVL(@[eur_outr_pck_desc],NVL(@[out_imdg_pck_qty1], 0)||' '||(SELECT IMDG_PCK_DESC" ).append("\n"); 
		query.append("                                           FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("                                           WHERE IMDG_PCK_CD = @[out_imdg_pck_cd1]))" ).append("\n"); 
		query.append("      ,NVL(@[in_imdg_pck_qty1], 0)" ).append("\n"); 
		query.append("      ,@[in_imdg_pck_cd1]" ).append("\n"); 
		query.append("      ,@[eur_inr_pck_desc]" ).append("\n"); 
		query.append("      ,@[ems_no]" ).append("\n"); 
		query.append("      ,@[agent]" ).append("\n"); 
		query.append("      ,@[cre_usr_id]   " ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,@[upd_usr_id]" ).append("\n"); 
		query.append("      ,SYSDATE" ).append("\n"); 
		query.append("      ,NVL(@[eur_outr_pck_desc],NVL(@[out_imdg_pck_qty1], 0)||' '||(SELECT IMDG_PCK_DESC" ).append("\n"); 
		query.append("                                           FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("                                           WHERE IMDG_PCK_CD = @[out_imdg_pck_cd1]))" ).append("\n"); 
		query.append("      ,@[eur_dcgo_mrn_polut_cd]" ).append("\n"); 
		query.append("      ,@[xtd_stay_prmt_no]" ).append("\n"); 
		query.append("      ,@[diff_rmk]" ).append("\n"); 
		query.append("      ,TO_DATE(@[crr_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("      ,@[net_explo_wgt]" ).append("\n"); 
		query.append("      ,@[cgo_opr_cd]" ).append("\n"); 
		query.append("      ,@[aply_no]" ).append("\n"); 
		query.append("      ,@[cntr_ref_no]" ).append("\n"); 
		query.append("      ,@[dcgo_ref_no]" ).append("\n"); 
		query.append("      ,@[emer_cntc_phn_no]" ).append("\n"); 
		query.append("      ,@[emer_cntc_pson_nm]" ).append("\n"); 
		query.append("      ,@[imdg_subs_rsk_lbl_cd1]" ).append("\n"); 
		query.append("      ,@[imdg_subs_rsk_lbl_cd2]" ).append("\n"); 
		query.append("      ,@[imdg_subs_rsk_lbl_cd3]" ).append("\n"); 
		query.append("      ,@[imdg_subs_rsk_lbl_cd4]" ).append("\n"); 
		query.append("      ,NVL(@[hcdg_flg],'N')" ).append("\n"); 
		query.append("      ,@[emer_rspn_gid_no]" ).append("\n"); 
		query.append("      ,NVL(@[spcl_cntr_seq], (SELECT NVL(MAX(SPCL_CNTR_SEQ), 0) + 1 " ).append("\n"); 
		query.append("          					  FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("         					  WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("					          AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("						      AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("						      AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("					          AND PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("				              AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("					          AND CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("                              AND CNTR_NO   != @[cntr_no]))" ).append("\n"); 
		query.append("      ,NVL(@[spcl_cgo_seq],  (SELECT NVL(MAX(SPCL_CGO_SEQ), 0) + 1 " ).append("\n"); 
		query.append("          					  FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("         					  WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("					          AND VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("						      AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("						      AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("					          AND PORT_CD    = @[port_cd]" ).append("\n"); 
		query.append("				              AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("					          AND CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("						      AND CNTR_NO    = @[cntr_no]))" ).append("\n"); 
		query.append("      )" ).append("\n"); 

	}
}