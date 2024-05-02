/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25 
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecial
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("void_20ft_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cbf_spcl_smry_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blck_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bb_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdl_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_rev_mcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usd_bkg_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialUSQL").append("\n"); 
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
		query.append("UPDATE OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("SET    CNTR_TPSZ_CD			= NVL(@[cntr_tpsz_cd]		, CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("		, DCGO_FLG          = NVL(@[dcgo_flg]			, DCGO_FLG)" ).append("\n"); 
		query.append("		, RC_FLG            = DECODE(DCGO_FLG, 'Y', DECODE(NVL(@[cargo_type], RC_FLG)		, 'R', 'Y', 'N'), DECODE(@[cargo_type], 'T', '', 'Y', 'Y', RC_FLG))" ).append("\n"); 
		query.append("		, AWK_CGO_FLG       = DECODE(DCGO_FLG, 'Y', DECODE(NVL(@[cargo_type], AWK_CGO_FLG)	, 'A', 'Y', 'N'), AWK_CGO_FLG)" ).append("\n"); 
		query.append("		, BB_CGO_FLG        = NVL(@[bb_cgo_flg]         , BB_CGO_FLG)" ).append("\n"); 
		query.append("		, BDL_CGO_FLG       = NVL(@[bdl_cgo_flg]        , BDL_CGO_FLG)" ).append("\n"); 
		query.append("		, STWG_CGO_FLG      = NVL(@[stwg_cgo_flg]       , STWG_CGO_FLG)" ).append("\n"); 
		query.append("		--, MTY_BKG_FLG       = NVL([mty_bkg_flg]        , MTY_BKG_FLG)" ).append("\n"); 
		query.append("		, MTY_BKG_FLG       = DECODE(DCGO_FLG, 'Y', DECODE(NVL(@[cargo_type], MTY_BKG_FLG)	, 'E', 'Y', 'N'), MTY_BKG_FLG)" ).append("\n"); 
		query.append("		, CRN_PST_STS_CD    = @[crn_pst_sts_cd]" ).append("\n"); 
		query.append("		, IMDG_UN_NO        = NVL(@[imdg_un_no]         , IMDG_UN_NO)" ).append("\n"); 
		query.append("		, IMDG_CLSS_CD      = NVL(@[imdg_clss_cd]       , IMDG_CLSS_CD)" ).append("\n"); 
		query.append("		, MRN_POLUT_FLG     = NVL(@[mrn_polut_flg]      , MRN_POLUT_FLG)" ).append("\n"); 
		query.append("		, CNTR_QTY          = NVL(@[cntr_qty]           , CNTR_QTY)" ).append("\n"); 
		query.append("		, STWG_CD           = @[stwg_cd]" ).append("\n"); 
		query.append("		, FWRD_OVR_DIM_LEN  = NVL(@[fwrd_ovr_dim_len]   , '0')" ).append("\n"); 
		query.append("		, BKWD_OVR_DIM_LEN  = NVL(@[bkwd_ovr_dim_len]   , '0')" ).append("\n"); 
		query.append("		, HGT_OVR_DIM_LEN   = NVL(@[hgt_ovr_dim_len]    , '0')" ).append("\n"); 
		query.append("		, LF_SD_OVR_DIM_LEN = NVL(@[lf_sd_ovr_dim_len]  , '0')" ).append("\n"); 
		query.append("		, RT_SD_OVR_DIM_LEN = NVL(@[rt_sd_ovr_dim_len]  , '0')" ).append("\n"); 
		query.append("		, CBF_RMK           = @[cbf_rmk]" ).append("\n"); 
		query.append("		, IMDG_LMT_QTY_FLG  = NVL(@[imdg_lmt_qty_flg]   , IMDG_LMT_QTY_FLG)" ).append("\n"); 
		query.append("		, USD_BKG_TTL_QTY   = NVL(@[usd_bkg_ttl_qty]    , '0')" ).append("\n"); 
		query.append("		, VOID_20FT_QTY     = NVL(@[void_20ft_qty]      , '0')" ).append("\n"); 
		query.append("	    , UPD_USR_ID 		= @[upd_usr_id]" ).append("\n"); 
		query.append("	    , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("   		, POD_CD = ( SELECT NVL(ISO_PORT_CD,PORT_CD) FROM STO_CD_PORT" ).append("\n"); 
		query.append("                      WHERE PORT_CD = @[pod_nm] " ).append("\n"); 
		query.append("                        AND ROWNUM  = 1  )" ).append("\n"); 
		query.append("   		, BLCK_STWG_CD 			= SUBSTR(@[pod_nm],3,4)" ).append("\n"); 
		query.append("		, PRCT_FLG     			= NVL(@[prct_flg]      			, PRCT_FLG)" ).append("\n"); 
		query.append("		, IMDG_SUBS_RSK_LBL_CD  = NVL(@[imdg_subs_rsk_lbl_cd]   , IMDG_SUBS_RSK_LBL_CD)" ).append("\n"); 
		query.append("		, BKG_REV_MCGO_FLG		= @[bkg_rev_mcgo_flg] " ).append("\n"); 
		query.append(" WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND YD_CD = @[yd_cd]" ).append("\n"); 
		query.append("   AND POL_CLPT_IND_SEQ = @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("   AND CRR_CD     = @[crr_cd]" ).append("\n"); 
		query.append("   AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND BLCK_STWG_CD = @[blck_stwg_cd]" ).append("\n"); 
		query.append("   AND CBF_SPCL_SMRY_SEQ = @[cbf_spcl_smry_seq]" ).append("\n"); 

	}
}