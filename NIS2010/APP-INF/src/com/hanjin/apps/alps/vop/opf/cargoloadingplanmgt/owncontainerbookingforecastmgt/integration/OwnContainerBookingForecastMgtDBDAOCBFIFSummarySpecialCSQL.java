/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.05 
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

public class OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecial
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialCSQL(){
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
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fwrd_ovr_dim_len",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prct_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mty_bkg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cbf_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOCBFIFSummarySpecialCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_CGO_BKG_FCAST_SPCL_SMRY	(VSL_CD" ).append("\n"); 
		query.append("                                        , SKD_VOY_NO" ).append("\n"); 
		query.append("                                        , SKD_DIR_CD" ).append("\n"); 
		query.append("                                        , YD_CD" ).append("\n"); 
		query.append("                                        , POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                        , CRR_CD" ).append("\n"); 
		query.append("                                        , POD_CD" ).append("\n"); 
		query.append("                                        , BLCK_STWG_CD" ).append("\n"); 
		query.append("                                        , CBF_SPCL_SMRY_SEQ" ).append("\n"); 
		query.append("                                        , CNTR_TPSZ_CD		" ).append("\n"); 
		query.append("                                        , DCGO_FLG              " ).append("\n"); 
		query.append("                                        , RC_FLG                " ).append("\n"); 
		query.append("                                        , AWK_CGO_FLG           " ).append("\n"); 
		query.append("                                        , BB_CGO_FLG            " ).append("\n"); 
		query.append("                                        , BDL_CGO_FLG           " ).append("\n"); 
		query.append("                                        , STWG_CGO_FLG          " ).append("\n"); 
		query.append("                                        , MTY_BKG_FLG           " ).append("\n"); 
		query.append("                                        , CRN_PST_STS_CD        " ).append("\n"); 
		query.append("                                        , IMDG_UN_NO            " ).append("\n"); 
		query.append("                                        , IMDG_CLSS_CD          " ).append("\n"); 
		query.append("                                        , MRN_POLUT_FLG" ).append("\n"); 
		query.append("                                        , CNTR_QTY              " ).append("\n"); 
		query.append("                                        , STWG_CD               " ).append("\n"); 
		query.append("                                        , FWRD_OVR_DIM_LEN      " ).append("\n"); 
		query.append("                                        , BKWD_OVR_DIM_LEN      " ).append("\n"); 
		query.append("                                        , HGT_OVR_DIM_LEN       " ).append("\n"); 
		query.append("                                        , LF_SD_OVR_DIM_LEN     " ).append("\n"); 
		query.append("                                        , RT_SD_OVR_DIM_LEN     " ).append("\n"); 
		query.append("                                        , CBF_RMK               " ).append("\n"); 
		query.append("                                        , IMDG_LMT_QTY_FLG      " ).append("\n"); 
		query.append("                                        , USD_BKG_TTL_QTY       " ).append("\n"); 
		query.append("                                        , VOID_20FT_QTY " ).append("\n"); 
		query.append("										, PRCT_FLG" ).append("\n"); 
		query.append("										, IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("										, BKG_REV_MCGO_FLG" ).append("\n"); 
		query.append("                                        , CRE_USR_ID" ).append("\n"); 
		query.append("                                        , CRE_DT" ).append("\n"); 
		query.append("                                        , UPD_USR_ID" ).append("\n"); 
		query.append("                                        , UPD_DT" ).append("\n"); 
		query.append("                                        )" ).append("\n"); 
		query.append("VALUES(@[vsl_cd]" ).append("\n"); 
		query.append("        , @[skd_voy_no]" ).append("\n"); 
		query.append("        , @[skd_dir_cd]" ).append("\n"); 
		query.append("        , @[yd_cd]" ).append("\n"); 
		query.append("        , @[pol_clpt_ind_seq]" ).append("\n"); 
		query.append("        , @[crr_cd]" ).append("\n"); 
		query.append("        --, [pod_cd]" ).append("\n"); 
		query.append("         ,DECODE(@[blck_stwg_cd],'SH1','CNSHA','SH2','CNSHA','PU1' ,'KRPUS'," ).append("\n"); 
		query.append("             NVL((SELECT LOC_CD" ).append("\n"); 
		query.append("                    FROM MDM_LOCATION WHERE LOC_CD = @[pod_cd] ) ,  " ).append("\n"); 
		query.append("                 (SELECT ISO_PORT_CD  FROM STO_CD_PORT" ).append("\n"); 
		query.append("                    WHERE PORT_CD = @[pod_cd])   ))" ).append("\n"); 
		query.append("        , @[blck_stwg_cd]" ).append("\n"); 
		query.append("		, @[cbf_spcl_smry_seq]" ).append("\n"); 
		query.append("		/*" ).append("\n"); 
		query.append("        , ( SELECT NVL(MAX(CBF_SPCL_SMRY_SEQ),0)+1" ).append("\n"); 
		query.append("			FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("			WHERE VSL_CD     = [vsl_cd]" ).append("\n"); 
		query.append("		    AND SKD_VOY_NO = [skd_voy_no]" ).append("\n"); 
		query.append("		    AND SKD_DIR_CD = [skd_dir_cd]" ).append("\n"); 
		query.append("		    AND YD_CD = [yd_cd]" ).append("\n"); 
		query.append("		    AND POL_CLPT_IND_SEQ = [pol_clpt_ind_seq]" ).append("\n"); 
		query.append("		    AND CRR_CD     = [crr_cd]" ).append("\n"); 
		query.append("		    AND POD_CD = [pod_cd]" ).append("\n"); 
		query.append("		    AND BLCK_STWG_CD = [blck_stwg_cd])" ).append("\n"); 
		query.append("		*/" ).append("\n"); 
		query.append("        , @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("        , @[dcgo_flg]" ).append("\n"); 
		query.append("        --, [rc_flg]" ).append("\n"); 
		query.append("        --, [awk_cgo_flg]" ).append("\n"); 
		query.append("		--, DECODE([dcgo_flg], 'Y', DECODE([cargo_type], 'R', 'Y',[rc_flg]), [rc_flg])" ).append("\n"); 
		query.append("		, DECODE(@[dcgo_flg], 'Y', DECODE(@[cargo_type], 'R', 'Y',@[rc_flg]), DECODE(@[cargo_type], 'T', '',@[cargo_type]))" ).append("\n"); 
		query.append("		, DECODE(@[dcgo_flg], 'Y', DECODE(@[cargo_type], 'A', 'Y',@[awk_cgo_flg]), @[awk_cgo_flg])" ).append("\n"); 
		query.append("        , @[bb_cgo_flg]" ).append("\n"); 
		query.append("        , @[bdl_cgo_flg]" ).append("\n"); 
		query.append("        , @[stwg_cgo_flg]" ).append("\n"); 
		query.append("        , @[mty_bkg_flg]" ).append("\n"); 
		query.append("        , @[crn_pst_sts_cd]" ).append("\n"); 
		query.append("        , @[imdg_un_no]" ).append("\n"); 
		query.append("        , @[imdg_clss_cd]" ).append("\n"); 
		query.append("        , @[mrn_polut_flg]" ).append("\n"); 
		query.append("        , @[cntr_qty]" ).append("\n"); 
		query.append("        , @[stwg_cd]" ).append("\n"); 
		query.append("        , @[fwrd_ovr_dim_len]" ).append("\n"); 
		query.append("        , @[bkwd_ovr_dim_len]" ).append("\n"); 
		query.append("        , @[hgt_ovr_dim_len]" ).append("\n"); 
		query.append("        , @[lf_sd_ovr_dim_len]" ).append("\n"); 
		query.append("        , @[rt_sd_ovr_dim_len]" ).append("\n"); 
		query.append("        , @[cbf_rmk]" ).append("\n"); 
		query.append("        , @[imdg_lmt_qty_flg]" ).append("\n"); 
		query.append("        , @[usd_bkg_ttl_qty]" ).append("\n"); 
		query.append("        , @[void_20ft_qty]" ).append("\n"); 
		query.append("        , @[prct_flg]" ).append("\n"); 
		query.append("        , @[imdg_subs_rsk_lbl_cd]" ).append("\n"); 
		query.append("        , @[bkg_rev_mcgo_flg]" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}