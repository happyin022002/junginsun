/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOOpfPrnrEdiCgoBkgFcastCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOOpfPrnrEdiCgoBkgFcastCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 타사 CLL EDI 수신 정보를 테이블에 저장한다..
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOOpfPrnrEdiCgoBkgFcastCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_sd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwrd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkwd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("iso_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_polut_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prct_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hgt_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crn_pst_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stwg_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lf_sd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOOpfPrnrEdiCgoBkgFcastCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_PRNR_EDI_CGO_BKG_FCAST" ).append("\n"); 
		query.append("(     EDI_RCV_DT" ).append("\n"); 
		query.append("	, EDI_SND_ID" ).append("\n"); 
		query.append("	, EDI_SEQ" ).append("\n"); 
		query.append("	, EDI_POL_YD_CD" ).append("\n"); 
		query.append("	, CRR_NM" ).append("\n"); 
		query.append("	, EDI_VSL_NM" ).append("\n"); 
		query.append("	, EDI_POD_CD" ).append("\n"); 
		query.append("	, ISO_CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, ETA_DT" ).append("\n"); 
		query.append("	, ETD_DT" ).append("\n"); 
		query.append("	, VSL_CD" ).append("\n"); 
		query.append("	, SKD_VOY_NO" ).append("\n"); 
		query.append("	, SKD_DIR_CD" ).append("\n"); 
		query.append("	, YD_CD" ).append("\n"); 
		query.append("	, POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("	, CRR_CD" ).append("\n"); 
		query.append("	, POD_CD" ).append("\n"); 
		query.append("	, EDI_BL_NO" ).append("\n"); 
		query.append("	, CNTR_NO" ).append("\n"); 
		query.append("	, CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	, TTL_WGT" ).append("\n"); 
		query.append("	, CNTR_WGT_UT_CD" ).append("\n"); 
		query.append("	, DCGO_FLG" ).append("\n"); 
		query.append("	, RC_FLG" ).append("\n"); 
		query.append("	, AWK_CGO_FLG" ).append("\n"); 
		query.append("	, BB_CGO_FLG" ).append("\n"); 
		query.append("	, STWG_CGO_FLG" ).append("\n"); 
		query.append("	, MTY_BKG_FLG" ).append("\n"); 
		query.append("	, CRN_PST_STS_CD" ).append("\n"); 
		query.append("	, IMDG_UN_NO" ).append("\n"); 
		query.append("	, IMDG_CLSS_CD" ).append("\n"); 
		query.append("	, MRN_POLUT_FLG" ).append("\n"); 
		query.append("	, STWG_CD" ).append("\n"); 
		query.append("	, FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append("	, BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append("	, HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append("	, LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("	, RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append("	, IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append("	, IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("	, PRCT_FLG" ).append("\n"); 
		query.append("	, IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append("	, CBF_RMK" ).append("\n"); 
		query.append("	, UPLD_DT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append("    , VGM_WGT" ).append("\n"); 
		query.append("    , VGM_WGT_UT_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("	TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("	, @[edi_snd_id]" ).append("\n"); 
		query.append("	, NVL((SELECT MAX(EDI_SEQ) FROM OPF_PRNR_EDI_CGO_BKG_FCAST),0) + 1" ).append("\n"); 
		query.append("	, @[edi_pol_yd_cd]" ).append("\n"); 
		query.append("	, @[crr_nm]" ).append("\n"); 
		query.append("	, @[edi_vsl_nm]" ).append("\n"); 
		query.append("	, @[edi_pod_cd]" ).append("\n"); 
		query.append("	, @[iso_cntr_tpsz_cd]" ).append("\n"); 
		query.append("	, TO_DATE(@[eta_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, TO_DATE(@[etd_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("	, @[vsl_cd]" ).append("\n"); 
		query.append("	, @[skd_voy_no]" ).append("\n"); 
		query.append("	, @[skd_dir_cd]" ).append("\n"); 
		query.append("	, @[yd_cd]" ).append("\n"); 
		query.append("	, @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("	, @[crr_cd]" ).append("\n"); 
		query.append("	, @[pod_cd]" ).append("\n"); 
		query.append("	, @[edi_bl_no]" ).append("\n"); 
		query.append("	, @[cntr_no]" ).append("\n"); 
		query.append("	, @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("	, @[ttl_wgt]" ).append("\n"); 
		query.append("	, @[cntr_wgt_ut_cd]" ).append("\n"); 
		query.append("	, @[dcgo_flg]" ).append("\n"); 
		query.append("	, @[rc_flg]" ).append("\n"); 
		query.append("	, @[awk_cgo_flg]" ).append("\n"); 
		query.append("	, @[bb_cgo_flg]" ).append("\n"); 
		query.append("	, @[stwg_cgo_flg]" ).append("\n"); 
		query.append("	, @[mty_bkg_flg]" ).append("\n"); 
		query.append("	, @[crn_pst_sts_cd]" ).append("\n"); 
		query.append("	, @[imdg_un_no]" ).append("\n"); 
		query.append("	, @[imdg_clss_cd]" ).append("\n"); 
		query.append("	, @[mrn_polut_flg]" ).append("\n"); 
		query.append("	, @[stwg_cd]" ).append("\n"); 
		query.append("	, @[fwrd_ovr_dim_len]" ).append("\n"); 
		query.append("	, @[bkwd_ovr_dim_len]" ).append("\n"); 
		query.append("	, @[hgt_ovr_dim_len]" ).append("\n"); 
		query.append("	, @[lf_sd_ovr_dim_len]" ).append("\n"); 
		query.append("	, @[rt_sd_ovr_dim_len]" ).append("\n"); 
		query.append("	, @[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append("	, @[imdg_subs_rsk_lbl_cd]" ).append("\n"); 
		query.append("	, @[prct_flg]" ).append("\n"); 
		query.append("	, @[imdg_pck_grp_cd]" ).append("\n"); 
		query.append("	, @[cbf_rmk]" ).append("\n"); 
		query.append("	, @[upld_dt]" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[upd_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("    , @[vgm_wgt]" ).append("\n"); 
		query.append("    , @[vgm_wgt_ut_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}