/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusDgManifestListDownloadDBDAOaddDgListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusDgManifestListDownloadDBDAOaddDgListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주 위험물 정보들을 신규생성한다
	  * </pre>
	  */
	public AusDgManifestListDownloadDBDAOaddDgListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("imdg_pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("out_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwrd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_lmt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_subs_rsk_lbl_cd3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("svc_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_mrn_polut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dg_short_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("packages",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_imdg_pck_cd1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ems_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fdr_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("c_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
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
		params.put("fdr_vvd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cell_psn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hzd_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration").append("\n"); 
		query.append("FileName : AusDgManifestListDownloadDBDAOaddDgListCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_DG " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	CNT_CD" ).append("\n"); 
		query.append(",	DG_DECL_TP_CD				                                    " ).append("\n"); 
		query.append(",	VSL_CD                                                      " ).append("\n"); 
		query.append(",	SKD_VOY_NO                                                  " ).append("\n"); 
		query.append(",	SKD_DIR_CD                                                  " ).append("\n"); 
		query.append(",	PORT_CD                                                     " ).append("\n"); 
		query.append(",	CNTR_NO                                                     " ).append("\n"); 
		query.append(",	CNTR_CGO_SEQ " ).append("\n"); 
		query.append(",   CNTR_TPSZ_CD                                               " ).append("\n"); 
		query.append(",	BL_NO                                                       " ).append("\n"); 
		query.append(",	POL_CD                                                      " ).append("\n"); 
		query.append(",	POD_CD                                                      " ).append("\n"); 
		query.append(",	CELL_PSN_NO                                                 " ).append("\n"); 
		query.append(",	ANR_FWRD_ID                                                 " ).append("\n"); 
		query.append(",	SVC_RQST_NO  " ).append("\n"); 
		query.append(",	ANR_CRR_TP_CD                                               " ).append("\n"); 
		query.append(",	FDR_SVC_RQST_NO" ).append("\n"); 
		query.append(",	FDR_VVD_ID" ).append("\n"); 
		query.append(",	FDR_VSL_NM" ).append("\n"); 
		query.append(",	FDR_VSL_LLOYD_NO                                           " ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD                                             " ).append("\n"); 
		query.append(",	IMDG_CLSS_CD                                                " ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",   IMDG_UN_NO_SEQ                                                  " ).append("\n"); 
		query.append(",	ANR_SPCL_TP_ID                                              " ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP                                           " ).append("\n"); 
		query.append(",	NET_WGT                                                     " ).append("\n"); 
		query.append(",	GRS_WGT                                                     " ).append("\n"); 
		query.append(",	PRP_SHP_NM                                                  " ).append("\n"); 
		query.append(",	HZD_DESC                                                    " ).append("\n"); 
		query.append(",	IMDG_LMT_QTY_FLG                                            " ).append("\n"); 
		query.append(",	PCK_QTY                                                     " ).append("\n"); 
		query.append(",	PCK_TP_CD                                                   " ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY1                                           " ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD1  " ).append("\n"); 
		query.append(",   OUTR_PCK_DESC                                          " ).append("\n"); 
		query.append(",	IN_IMDG_PCK_QTY1                                           " ).append("\n"); 
		query.append(",	IN_IMDG_PCK_CD1" ).append("\n"); 
		query.append(",   INR_PCK_DESC" ).append("\n"); 
		query.append(",	EMS_NO  " ).append("\n"); 
		query.append(",   ANR_ROLE_DIV_CD                                                    " ).append("\n"); 
		query.append(",	CRE_USR_ID                                                  " ).append("\n"); 
		query.append(",	CRE_DT                                                      " ).append("\n"); 
		query.append(",	UPD_USR_ID                                                  " ).append("\n"); 
		query.append(",	UPD_DT   " ).append("\n"); 
		query.append(",   PCK_DESC " ).append("\n"); 
		query.append(",   DCGO_MRN_POLUT_CD    " ).append("\n"); 
		query.append(",	CRR_DT" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD1" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD2" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD3" ).append("\n"); 
		query.append(",	IMDG_SUBS_RSK_LBL_CD4" ).append("\n"); 
		query.append(",   NET_EXPLO_WGT                                                " ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	'AU' " ).append("\n"); 
		query.append(",	@[d_type]              " ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append(",	SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append(",	@[port_cd]             " ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",   @[cntr_cgo_seq]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]               " ).append("\n"); 
		query.append(",	@[bl_no]               " ).append("\n"); 
		query.append(",	@[pol_cd]              " ).append("\n"); 
		query.append(",	@[pod_cd]              " ).append("\n"); 
		query.append(",	DECODE(NVL(@[cell_psn_no], ''), '', '', LPAD(@[cell_psn_no], 7,0 ))" ).append("\n"); 
		query.append(",	@[fwrd_id]             " ).append("\n"); 
		query.append(",	@[svc_rqst_no]" ).append("\n"); 
		query.append(",   @[c_type]         " ).append("\n"); 
		query.append(",	@[fdr_svc_rqst_no] " ).append("\n"); 
		query.append(",   @[fdr_vvd_id]" ).append("\n"); 
		query.append(",   @[fdr_vsl_nm]" ).append("\n"); 
		query.append(",   @[fdr_vsl_lloyd_no]" ).append("\n"); 
		query.append(",	@[imdg_pck_grp_cd]     " ).append("\n"); 
		query.append(",	@[imdg_clss_cd]        " ).append("\n"); 
		query.append(",	@[imdg_un_no]" ).append("\n"); 
		query.append(",	@[imdg_un_no_seq]" ).append("\n"); 
		query.append(",	@[dg_short_nm]" ).append("\n"); 
		query.append(",	@[flsh_pnt_cdo_temp]   " ).append("\n"); 
		query.append(",	@[net_wgt]             " ).append("\n"); 
		query.append(",	@[grs_wgt]             " ).append("\n"); 
		query.append(",	@[prp_shp_nm]          " ).append("\n"); 
		query.append(",	@[hzd_desc]            " ).append("\n"); 
		query.append(",	@[imdg_lmt_qty_flg]    " ).append("\n"); 
		query.append(",	NVL(@[pck_qty], 0)             " ).append("\n"); 
		query.append(",	@[pck_tp_cd]           " ).append("\n"); 
		query.append(",	NVL(@[out_imdg_pck_qty1], 0)  " ).append("\n"); 
		query.append(",	@[out_imdg_pck_cd1]    " ).append("\n"); 
		query.append(",	@[out_pck_desc]    " ).append("\n"); 
		query.append(",	NVL(@[in_imdg_pck_qty1], 0)  " ).append("\n"); 
		query.append(",	@[in_imdg_pck_cd1] " ).append("\n"); 
		query.append(",	@[in_pck_desc]       " ).append("\n"); 
		query.append(",	@[ems_no] " ).append("\n"); 
		query.append(",	@[agent] " ).append("\n"); 
		query.append(",	@[cre_usr_id]          " ).append("\n"); 
		query.append(",	SYSDATE                " ).append("\n"); 
		query.append(",	@[upd_usr_id]          " ).append("\n"); 
		query.append(",	SYSDATE  " ).append("\n"); 
		query.append(",   @[packages] " ).append("\n"); 
		query.append(",   @[dcgo_mrn_polut_cd]         " ).append("\n"); 
		query.append(",   TO_DATE(@[crr_dt],'YYYY-MM-DD')     " ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd1]    " ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd2]    " ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd3]    " ).append("\n"); 
		query.append(",	@[imdg_subs_rsk_lbl_cd4]    " ).append("\n"); 
		query.append(",	@[net_explo_wgt]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}