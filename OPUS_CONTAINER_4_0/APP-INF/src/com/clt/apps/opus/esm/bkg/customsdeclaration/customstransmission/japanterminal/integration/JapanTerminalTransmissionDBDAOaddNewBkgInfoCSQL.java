/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOaddNewBkgInfoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOaddNewBkgInfoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addNewBkgInfo
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOaddNewBkgInfoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_fwrd_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snaccs_tml_edi_sts_cng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jp_tml_vsl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_fwrd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("snaccs_tml_edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_ntfy_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_fwrd_cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mcntr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty4",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("snaccs_tml_edi_cgo_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dry_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_vol_qty3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_vol_qty2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_skd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("soc_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd2",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("shpr_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snaccs_tml_edi_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_cntr_pre_clng_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snaccs_tml_edi_stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fnl_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shpr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOaddNewBkgInfoCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_TML_EDI_JP_BL (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       BKG_SKD_SEQ," ).append("\n"); 
		query.append("       BKG_SKD_DELT_FLG," ).append("\n"); 
		query.append("       SNACCS_TML_EDI_STS_CD," ).append("\n"); 
		query.append("       EDI_SND_DT," ).append("\n"); 
		query.append("       EDI_SND_OFC_CD," ).append("\n"); 
		query.append("       EDI_SND_USR_ID," ).append("\n"); 
		query.append("       VSL_CD," ).append("\n"); 
		query.append("       SKD_VOY_NO," ).append("\n"); 
		query.append("       SKD_DIR_CD," ).append("\n"); 
		query.append("       JP_TML_VSL_NO," ).append("\n"); 
		query.append("       POL_CD," ).append("\n"); 
		query.append("       POL_YD_CD," ).append("\n"); 
		query.append("       POR_CD," ).append("\n"); 
		query.append("       POR_YD_CD," ).append("\n"); 
		query.append("       OTR_NTFY_YD_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD1," ).append("\n"); 
		query.append("       CNTR_VOL_QTY1," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD2," ).append("\n"); 
		query.append("       CNTR_VOL_QTY2," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD3," ).append("\n"); 
		query.append("       CNTR_VOL_QTY3," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD4," ).append("\n"); 
		query.append("       CNTR_VOL_QTY4," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD5," ).append("\n"); 
		query.append("       CNTR_VOL_QTY5," ).append("\n"); 
		query.append("       PRT_FLG," ).append("\n"); 
		query.append("       CALL_SGN_NO," ).append("\n"); 
		query.append("       VSL_ENG_NM," ).append("\n"); 
		query.append("       BKG_CRE_DT," ).append("\n"); 
		query.append("       ETD_DT," ).append("\n"); 
		query.append("       SHPR_CNT_CD," ).append("\n"); 
		query.append("       SHPR_CUST_SEQ," ).append("\n"); 
		query.append("       SHPR_CUST_NM," ).append("\n"); 
		query.append("       FRT_FWRD_CNT_CD," ).append("\n"); 
		query.append("       FRT_FWRD_CUST_SEQ," ).append("\n"); 
		query.append("       FRT_FWRD_CUST_NM," ).append("\n"); 
		query.append("       SNACCS_TML_EDI_RCV_TERM_CD," ).append("\n"); 
		query.append("       POD_CD," ).append("\n"); 
		query.append("       DEL_CD," ).append("\n"); 
		query.append("       SNACCS_TML_EDI_DE_TERM_CD," ).append("\n"); 
		query.append("       FNL_DEST_CD," ).append("\n"); 
		query.append("       FNL_DEST_NM," ).append("\n"); 
		query.append("       SNACCS_TML_EDI_CGO_TP_CD," ).append("\n"); 
		query.append("       SNACCS_TML_EDI_CGO_KND_CD," ).append("\n"); 
		query.append("       PCK_TP_CD," ).append("\n"); 
		query.append("       CMDT_NM," ).append("\n"); 
		query.append("       XTER_RMK," ).append("\n"); 
		query.append("       PCK_QTY," ).append("\n"); 
		query.append("       TTL_PCK_TP_CD," ).append("\n"); 
		query.append("       GRS_WGT," ).append("\n"); 
		query.append("       WGT_UT_CD," ).append("\n"); 
		query.append("       MEAS_QTY," ).append("\n"); 
		query.append("       MEAS_UT_CD," ).append("\n"); 
		query.append("       SNACCS_TML_EDI_STWG_CD," ).append("\n"); 
		query.append("       STWG_RMK," ).append("\n"); 
		query.append("       BLCK_STWG_CD," ).append("\n"); 
		query.append("       DRY_CGO_FLG," ).append("\n"); 
		query.append("       MCNTR_FLG," ).append("\n"); 
		query.append("       SOC_FLG," ).append("\n"); 
		query.append("       RF_CNTR_PRE_CLNG_FLG," ).append("\n"); 
		query.append("       DCGO_FLG," ).append("\n"); 
		query.append("       AWK_CGO_FLG," ).append("\n"); 
		query.append("       BB_CGO_FLG," ).append("\n"); 
		query.append("       RD_CGO_FLG," ).append("\n"); 
		query.append("       SNACCS_TML_EDI_STS_CNG_FLG," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       @[bkg_no]," ).append("\n"); 
		query.append("       @[bkg_skd_seq]," ).append("\n"); 
		query.append("       @[bkg_skd_delt_flg]," ).append("\n"); 
		query.append("       @[snaccs_tml_edi_sts_cd]," ).append("\n"); 
		query.append("       @[edi_snd_dt]," ).append("\n"); 
		query.append("       @[edi_snd_ofc_cd]," ).append("\n"); 
		query.append("       @[edi_snd_usr_id]," ).append("\n"); 
		query.append("       @[vsl_cd]," ).append("\n"); 
		query.append("       @[skd_voy_no]," ).append("\n"); 
		query.append("       @[skd_dir_cd]," ).append("\n"); 
		query.append("       @[jp_tml_vsl_no]," ).append("\n"); 
		query.append("       @[pol_cd]," ).append("\n"); 
		query.append("       @[pol_yd_cd]," ).append("\n"); 
		query.append("       @[por_cd]," ).append("\n"); 
		query.append("       @[por_yd_cd]," ).append("\n"); 
		query.append("       @[otr_ntfy_yd_cd]," ).append("\n"); 
		query.append("       @[cntr_tpsz_cd1]," ).append("\n"); 
		query.append("       @[cntr_vol_qty1]," ).append("\n"); 
		query.append("       @[cntr_tpsz_cd2]," ).append("\n"); 
		query.append("       @[cntr_vol_qty2]," ).append("\n"); 
		query.append("       @[cntr_tpsz_cd3]," ).append("\n"); 
		query.append("       @[cntr_vol_qty3]," ).append("\n"); 
		query.append("       @[cntr_tpsz_cd4]," ).append("\n"); 
		query.append("       @[cntr_vol_qty4]," ).append("\n"); 
		query.append("       @[cntr_tpsz_cd5]," ).append("\n"); 
		query.append("       @[cntr_vol_qty5]," ).append("\n"); 
		query.append("       @[prt_flg]," ).append("\n"); 
		query.append("       @[call_sgn_no]," ).append("\n"); 
		query.append("       @[vsl_eng_nm]," ).append("\n"); 
		query.append("       TO_DATE(@[bkg_cre_dt], 'YYYY/MM/DD HH24:MI:SS')," ).append("\n"); 
		query.append("       TO_DATE(@[etd_dt], 'YYYY/MM/DD HH24:MI:SS')," ).append("\n"); 
		query.append("       @[shpr_cnt_cd]," ).append("\n"); 
		query.append("       @[shpr_cust_seq]," ).append("\n"); 
		query.append("       @[shpr_cust_nm]," ).append("\n"); 
		query.append("       @[frt_fwrd_cnt_cd]," ).append("\n"); 
		query.append("       @[frt_fwrd_cust_seq]," ).append("\n"); 
		query.append("       @[frt_fwrd_cust_nm]," ).append("\n"); 
		query.append("       @[rcv_term_cd]," ).append("\n"); 
		query.append("       @[pod_cd]," ).append("\n"); 
		query.append("       @[del_cd]," ).append("\n"); 
		query.append("       @[de_term_cd]," ).append("\n"); 
		query.append("       @[fnl_dest_cd]," ).append("\n"); 
		query.append("       @[fnl_dest_nm]," ).append("\n"); 
		query.append("       @[snaccs_tml_edi_cgo_tp_cd]," ).append("\n"); 
		query.append("       @[snaccs_tml_edi_cgo_knd_cd]," ).append("\n"); 
		query.append("       @[pck_tp_cd]," ).append("\n"); 
		query.append("       @[cmdt_nm]," ).append("\n"); 
		query.append("       @[xter_rmk]," ).append("\n"); 
		query.append("       REPLACE(NVL(@[pck_qty], 0), ',', '')," ).append("\n"); 
		query.append("       @[ttl_pck_tp_cd]," ).append("\n"); 
		query.append("       REPLACE(NVL(@[grs_wgt], 0), ',', '')," ).append("\n"); 
		query.append("       @[wgt_ut_cd]," ).append("\n"); 
		query.append("       REPLACE(NVL(@[meas_qty], 0), ',', '')," ).append("\n"); 
		query.append("       @[meas_ut_cd]," ).append("\n"); 
		query.append("       @[snaccs_tml_edi_stwg_cd]," ).append("\n"); 
		query.append("       @[stwg_rmk]," ).append("\n"); 
		query.append("       @[blck_stwg_cd]," ).append("\n"); 
		query.append("       @[dry_cgo_flg]," ).append("\n"); 
		query.append("       @[mcntr_flg]," ).append("\n"); 
		query.append("       @[soc_flg]," ).append("\n"); 
		query.append("       @[rf_cntr_pre_clng_flg]," ).append("\n"); 
		query.append("       @[dcgo_flg]," ).append("\n"); 
		query.append("       @[awk_cgo_flg]," ).append("\n"); 
		query.append("       @[bb_cgo_flg]," ).append("\n"); 
		query.append("       @[rd_cgo_flg]," ).append("\n"); 
		query.append("       @[snaccs_tml_edi_sts_cng_flg]," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE," ).append("\n"); 
		query.append("       @[cre_usr_id]," ).append("\n"); 
		query.append("       SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}