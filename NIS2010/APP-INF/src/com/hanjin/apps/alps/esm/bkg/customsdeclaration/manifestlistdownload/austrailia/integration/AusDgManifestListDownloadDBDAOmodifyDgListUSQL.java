/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusDgManifestListDownloadDBDAOmodifyDgListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.20 
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

public class AusDgManifestListDownloadDBDAOmodifyDgListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주 위험물 정보들을 업데이트한다
	  * </pre>
	  */
	public AusDgManifestListDownloadDBDAOmodifyDgListUSQL(){
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
		params.put("out_imdg_pck_qty1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_subs_rsk_lbl_cd3",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("crr_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : AusDgManifestListDownloadDBDAOmodifyDgListUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_DG SET                           " ).append("\n"); 
		query.append("	BL_NO = @[bl_no]                                    " ).append("\n"); 
		query.append(",	POL_CD = @[pol_cd]                                  " ).append("\n"); 
		query.append(",	POD_CD = @[pod_cd]                                  " ).append("\n"); 
		query.append(",	CELL_PSN_NO = DECODE(NVL(@[cell_psn_no], ''), '', '', LPAD(@[cell_psn_no], 7,0 ))" ).append("\n"); 
		query.append(",	ANR_ROLE_DIV_CD = @[agent]                " ).append("\n"); 
		query.append(",	ANR_FWRD_ID = @[fwrd_id]    " ).append("\n"); 
		query.append(",	ANR_CRR_TP_CD = @[c_type]                   " ).append("\n"); 
		query.append(",	FDR_SVC_RQST_NO = @[fdr_svc_rqst_no] " ).append("\n"); 
		query.append(",	FDR_VVD_ID = @[fdr_vvd_id]" ).append("\n"); 
		query.append(",	FDR_VSL_NM = @[fdr_vsl_nm]" ).append("\n"); 
		query.append(",	FDR_VSL_LLOYD_NO = @[fdr_vsl_lloyd_no]" ).append("\n"); 
		query.append(",	IMDG_PCK_GRP_CD = @[imdg_pck_grp_cd]                " ).append("\n"); 
		query.append(",	IMDG_CLSS_CD = @[imdg_clss_cd]                      " ).append("\n"); 
		query.append(",	IMDG_UN_NO = @[imdg_un_no]                          " ).append("\n"); 
		query.append(",	IMDG_UN_NO_SEQ = @[imdg_un_no_seq]" ).append("\n"); 
		query.append(",   ANR_SPCL_TP_ID = @[dg_short_nm]" ).append("\n"); 
		query.append(",	FLSH_PNT_CDO_TEMP = @[flsh_pnt_cdo_temp]            " ).append("\n"); 
		query.append(",	NET_WGT = @[net_wgt]                                " ).append("\n"); 
		query.append(",	GRS_WGT = @[grs_wgt]                                " ).append("\n"); 
		query.append(",	PRP_SHP_NM = @[prp_shp_nm]                          " ).append("\n"); 
		query.append(",	HZD_DESC = @[hzd_desc]                              " ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_QTY1 = NVL(@[out_imdg_pck_qty1], 0)" ).append("\n"); 
		query.append(",	OUT_IMDG_PCK_CD1 = @[out_imdg_pck_cd1]              " ).append("\n"); 
		query.append(",	EMS_NO = @[ems_no]                                  " ).append("\n"); 
		query.append(",	UPD_USR_ID = @[upd_usr_id]                          " ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE " ).append("\n"); 
		query.append(",   PCK_DESC = @[packages]      " ).append("\n"); 
		query.append(",   DCGO_MRN_POLUT_CD = @[dcgo_mrn_polut_cd]  " ).append("\n"); 
		query.append(",   IMDG_LMT_QTY_FLG = @[imdg_lmt_qty_flg]                                    " ).append("\n"); 
		query.append(",	CRR_DT = TO_DATE(@[crr_dt],'YYYY-MM-DD')   " ).append("\n"); 
		query.append(",   IMDG_SUBS_RSK_LBL_CD1 = @[imdg_subs_rsk_lbl_cd1]    " ).append("\n"); 
		query.append(",   IMDG_SUBS_RSK_LBL_CD2 = @[imdg_subs_rsk_lbl_cd2]" ).append("\n"); 
		query.append(",   IMDG_SUBS_RSK_LBL_CD3 = @[imdg_subs_rsk_lbl_cd3]" ).append("\n"); 
		query.append(",   IMDG_SUBS_RSK_LBL_CD4 = @[imdg_subs_rsk_lbl_cd4]" ).append("\n"); 
		query.append(",   NET_EXPLO_WGT = @[net_explo_wgt]                    " ).append("\n"); 
		query.append("WHERE	DG_DECL_TP_CD = @[d_type]                    " ).append("\n"); 
		query.append("AND	VSL_CD = SUBSTR(@[vvd_cd], 1, 4)                  " ).append("\n"); 
		query.append("AND	SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)              " ).append("\n"); 
		query.append("AND	SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)              " ).append("\n"); 
		query.append("AND	PORT_CD = @[port_cd]                              " ).append("\n"); 
		query.append("AND	BL_NO = @[bl_no]                                " ).append("\n"); 
		query.append("AND	CNTR_NO = @[cntr_no]                              " ).append("\n"); 
		query.append("AND	CNTR_CGO_SEQ = @[cntr_cgo_seq]" ).append("\n"); 
		query.append("AND CNT_CD = 'AU'" ).append("\n"); 

	}
}