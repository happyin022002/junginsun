/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFListOptionVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.07
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2014.10.07 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Won, Jong-Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOCBFListOptionVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CBFListOptionVO 입력
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFListOptionVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("fdo_temp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("apro_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dim_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_n2nd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dim_wdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cdo_temp",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_shpr_ownr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("spcl_cgo_auth_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lmt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_qty_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_mrn_polut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_dp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cgo_grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dim_hgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mlb_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prp_shp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lf_sd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stwg_n1st_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFListOptionVOCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_CNTR (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	BKG_SHPR_OWNR_FLG" ).append("\n"); 
		query.append(",	CRR_CD" ).append("\n"); 
		query.append(",   YD_CD" ).append("\n"); 
		query.append(",   POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	CBF_SMRY_SEQ" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	PRNR_BKG_REF_NO" ).append("\n"); 
		query.append(",	CNTR_SEQ" ).append("\n"); 
		query.append(",	CGO_SEQ" ).append("\n"); 
		query.append(",	SPCL_CGO_SEQ" ).append("\n"); 
		query.append(",   CNTR_NO" ).append("\n"); 
		query.append(",	PRNR_CNTR_REF_NO" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",   POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	MLB_CD" ).append("\n"); 
		query.append(",	CBF_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	CNTR_WGT_GRP_CD" ).append("\n"); 
		query.append(",	FULL_MTY_CD" ).append("\n"); 
		query.append(",	CNTR_QTY" ).append("\n"); 
		query.append(",	CNTR_GRS_WGT" ).append("\n"); 
		query.append(",	CGO_GRS_WGT" ).append("\n"); 
		query.append(",	CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	IMDG_UN_NO" ).append("\n"); 
		query.append(",	IMDG_MRN_POLUT_CD" ).append("\n"); 
		query.append(",	PCK_GRP_CD" ).append("\n"); 
		query.append(",	LMT_QTY_FLG" ).append("\n"); 
		query.append(",	EXPT_QTY_FLG" ).append("\n"); 
		query.append(",	FDO_TEMP" ).append("\n"); 
		query.append(",	CDO_TEMP" ).append("\n"); 
		query.append(",	DIM_LEN" ).append("\n"); 
		query.append(",	DIM_WDT" ).append("\n"); 
		query.append(",	DIM_HGT" ).append("\n"); 
		query.append(",	FWRD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	BKWD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	HGT_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	LF_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	RT_SD_OVR_DIM_LEN" ).append("\n"); 
		query.append(",	CRN_PST_STS_CD" ).append("\n"); 
		query.append(",	STWG_CD" ).append("\n"); 
		query.append(",	STWG_N1ST_RMK" ).append("\n"); 
		query.append(",	STWG_N2ND_RMK" ).append("\n"); 
		query.append(",	SPCL_CGO_AUTH_FLG" ).append("\n"); 
		query.append(",	APRO_REF_NO" ).append("\n"); 
		query.append(",	CBF_RMK" ).append("\n"); 
		query.append(",   CBF_CMDT_NM" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   DCGO_FLG" ).append("\n"); 
		query.append(",   RC_FLG" ).append("\n"); 
		query.append(",   AWK_CGO_FLG" ).append("\n"); 
		query.append(",   BB_CGO_FLG" ).append("\n"); 
		query.append(",   STWG_CGO_FLG" ).append("\n"); 
		query.append(",   CBF_DP_CD" ).append("\n"); 
		query.append(",	PRP_SHP_NM" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	NVL(@[bkg_shpr_ownr_flg],'N')" ).append("\n"); 
		query.append(",	@[crr_cd]" ).append("\n"); 
		query.append(",	@[yd_cd]" ).append("\n"); 
		query.append(",   @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append(",	(SELECT /*+INDEX_DESC(XPKOPF_CGO_BKG_FCAST_CNTR)*/" ).append("\n"); 
		query.append(" NVL(MAX(CBF_SMRY_SEQ)+1,1)" ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST_CNTR X" ).append("\n"); 
		query.append("WHERE X.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND X.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND X.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND X.BKG_SHPR_OWNR_FLG = 'N'" ).append("\n"); 
		query.append("AND X.CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("AND X.YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("AND X.POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq])" ).append("\n"); 
		query.append(",	NVL(@[bkg_no],' ')" ).append("\n"); 
		query.append(",	@[prnr_bkg_ref_no]" ).append("\n"); 
		query.append(",	@[cntr_seq]" ).append("\n"); 
		query.append(",	NVL(@[cgo_seq],0)" ).append("\n"); 
		query.append(",	NVL(@[spcl_cgo_seq],0)" ).append("\n"); 
		query.append(", ''" ).append("\n"); 
		query.append(",	@[prnr_cntr_ref_no]" ).append("\n"); 
		query.append(",	SUBSTR(@[pod_cd],1,5)" ).append("\n"); 
		query.append(",   SUBSTR(@[pod_cd],6,1)" ).append("\n"); 
		query.append(",	@[mlb_cd]" ).append("\n"); 
		query.append(",	NVL(@[cbf_spcl_cgo_cate_cd],0)" ).append("\n"); 
		query.append(",	DECODE(@[cntr_wgt_grp_cd],'Extra Heavy','X','Heavy','H','Medium','M','Light','L','Ultra Light','E',@[cntr_wgt_grp_cd])" ).append("\n"); 
		query.append(",	@[full_mty_cd]" ).append("\n"); 
		query.append(",	NVL(@[cntr_qty],0)" ).append("\n"); 
		query.append(",	NVL(@[cntr_grs_wgt],0)" ).append("\n"); 
		query.append(",	@[cgo_grs_wgt]" ).append("\n"); 
		query.append(",	@[cntr_tpsz_cd]" ).append("\n"); 
		query.append(",	@[imdg_clss_cd]" ).append("\n"); 
		query.append(",	@[imdg_un_no]" ).append("\n"); 
		query.append(",	@[imdg_mrn_polut_cd]" ).append("\n"); 
		query.append(",	DECODE(@[pck_grp_cd],'I','1','II','2','III','3',@[pck_grp_cd])" ).append("\n"); 
		query.append(",	@[lmt_qty_flg]" ).append("\n"); 
		query.append(",	@[expt_qty_flg]" ).append("\n"); 
		query.append(",	@[fdo_temp]" ).append("\n"); 
		query.append(",	@[cdo_temp]" ).append("\n"); 
		query.append(",	@[dim_len]" ).append("\n"); 
		query.append(",	@[dim_wdt]" ).append("\n"); 
		query.append(",	@[dim_hgt]" ).append("\n"); 
		query.append(",	NVL(@[fwrd_ovr_dim_len],0)" ).append("\n"); 
		query.append(",	NVL(@[bkwd_ovr_dim_len],0)" ).append("\n"); 
		query.append(",	NVL(@[hgt_ovr_dim_len],0)" ).append("\n"); 
		query.append(",	NVL(@[lf_sd_ovr_dim_len],0)" ).append("\n"); 
		query.append(",	NVL(@[rt_sd_ovr_dim_len],0)" ).append("\n"); 
		query.append(",	@[crn_pst_sts_cd]" ).append("\n"); 
		query.append(",	@[stwg_cd]" ).append("\n"); 
		query.append(",	@[stwg_n1st_rmk]" ).append("\n"); 
		query.append(",	@[stwg_n2nd_rmk]" ).append("\n"); 
		query.append(",	NVL(@[spcl_cgo_auth_flg],'N')" ).append("\n"); 
		query.append(",	@[apro_ref_no]" ).append("\n"); 
		query.append(",	@[cbf_rmk]" ).append("\n"); 
		query.append(", NVL(@[cbf_cmdt_nm],'')" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	NVL(@[upd_usr_id],' ')" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",   DECODE(@[dcgo_flg],'1','Y','N')" ).append("\n"); 
		query.append(",   DECODE(@[rc_flg],'1','Y','N')" ).append("\n"); 
		query.append(",   DECODE(@[awk_cgo_flg],'1','Y','N')" ).append("\n"); 
		query.append(",   DECODE(@[bb_cgo_flg],'1','Y','N')" ).append("\n"); 
		query.append(",   DECODE(@[stwg_cgo_flg],'1','Y','N')" ).append("\n"); 
		query.append(",   NVL(@[cbf_dp_cd],'N')" ).append("\n"); 
		query.append(",	@[prp_shp_nm]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}