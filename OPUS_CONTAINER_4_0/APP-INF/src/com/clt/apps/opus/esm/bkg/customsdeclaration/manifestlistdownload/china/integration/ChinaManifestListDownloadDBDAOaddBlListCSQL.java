/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOaddBlListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOaddBlListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addBlList
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOaddBlListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("frt_term_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_pod_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_rout_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_cstms_trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chn_mf_snd_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rc_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOaddBlListCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_CHN_BL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (BKG_NO," ).append("\n"); 
		query.append("        BL_NO," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        PORT_CD," ).append("\n"); 
		query.append("        BKG_POL_CD," ).append("\n"); 
		query.append("        BKG_POD_CD," ).append("\n"); 
		query.append("        POR_CD," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        POD_CD," ).append("\n"); 
		query.append("        DEL_CD," ).append("\n"); 
		query.append("        BL_ISS_DT," ).append("\n"); 
		query.append("        BL_OBRD_DT," ).append("\n"); 
		query.append("        CHN_CSTMS_TRSP_MOD_CD," ).append("\n"); 
		query.append("        RCV_TERM_CD," ).append("\n"); 
		query.append("        DE_TERM_CD," ).append("\n"); 
		query.append("        FRT_TERM_CD," ).append("\n"); 
		query.append("        CSTMS_DESC," ).append("\n"); 
		query.append("        PCK_QTY," ).append("\n"); 
		query.append("        PCK_TP_CD," ).append("\n"); 
		query.append("        ACT_WGT," ).append("\n"); 
		query.append("        WGT_UT_CD," ).append("\n"); 
		query.append("        MEAS_QTY," ).append("\n"); 
		query.append("        MEAS_UT_CD," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        --MF_SND_DT," ).append("\n"); 
		query.append("        --MF_SND_USR_ID," ).append("\n"); 
		query.append("        BKG_CGO_TP_CD," ).append("\n"); 
		query.append("        DCGO_FLG," ).append("\n"); 
		query.append("        RC_FLG," ).append("\n"); 
		query.append("        BL_ISS_OFC_CD," ).append("\n"); 
		query.append("        CHN_MF_SND_IND_CD," ).append("\n"); 
		query.append("        BL_POD_ETA_DT," ).append("\n"); 
		query.append("        POD_ROUT_DESC," ).append("\n"); 
		query.append("        POD_YD_CD," ).append("\n"); 
		query.append("        BKG_VSL_CD," ).append("\n"); 
		query.append("        BKG_SKD_VOY_NO," ).append("\n"); 
		query.append("        BKG_SKD_DIR_CD)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES (@[bkg_no]," ).append("\n"); 
		query.append("        @[bl_no]," ).append("\n"); 
		query.append("        @[vsl_cd]," ).append("\n"); 
		query.append("        @[skd_voy_no]," ).append("\n"); 
		query.append("        @[skd_dir_cd]," ).append("\n"); 
		query.append("        @[port_cd]," ).append("\n"); 
		query.append("        @[bkg_pol_cd]," ).append("\n"); 
		query.append("        @[bkg_pod_cd]," ).append("\n"); 
		query.append("        @[por_cd]," ).append("\n"); 
		query.append("        @[pol_cd]," ).append("\n"); 
		query.append("        @[pod_cd]," ).append("\n"); 
		query.append("        @[del_cd]," ).append("\n"); 
		query.append("        TO_DATE(TRIM(@[bl_iss_dt]), 'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("        TO_DATE(TRIM(@[bl_obrd_dt]), 'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("        @[chn_cstms_trsp_mod_cd]," ).append("\n"); 
		query.append("        @[rcv_term_cd]," ).append("\n"); 
		query.append("        @[de_term_cd]," ).append("\n"); 
		query.append("        DECODE(@[frt_term_cd], ' ', null, @[frt_term_cd])," ).append("\n"); 
		query.append("        @[cstms_desc]," ).append("\n"); 
		query.append("        NVL(@[pck_qty], 0)," ).append("\n"); 
		query.append("        @[pck_tp_cd]," ).append("\n"); 
		query.append("        NVL(@[act_wgt], 0)," ).append("\n"); 
		query.append("        DECODE(@[wgt_ut_cd], ' ', null, @[wgt_ut_cd])," ).append("\n"); 
		query.append("        NVL(@[meas_qty], 0)," ).append("\n"); 
		query.append("        DECODE(@[meas_ut_cd], ' ', null, @[meas_ut_cd])," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[upd_usr_id]," ).append("\n"); 
		query.append("        --NULL," ).append("\n"); 
		query.append("        --NULL," ).append("\n"); 
		query.append("        @[bkg_cgo_tp_cd]," ).append("\n"); 
		query.append("        NVL(@[dcgo_flg], 'N')," ).append("\n"); 
		query.append("        NVL(@[rc_flg], 'N')," ).append("\n"); 
		query.append("        @[bl_iss_ofc_cd]," ).append("\n"); 
		query.append("        @[chn_mf_snd_ind_cd]," ).append("\n"); 
		query.append("        TO_DATE(@[bl_pod_eta_dt], 'YYYYMMDD HH24MISS')," ).append("\n"); 
		query.append("        @[pod_rout_desc]," ).append("\n"); 
		query.append("        @[pod_yd_cd]," ).append("\n"); 
		query.append("        @[bkg_vsl_cd]," ).append("\n"); 
		query.append("        @[bkg_skd_voy_no]," ).append("\n"); 
		query.append("        @[bkg_skd_dir_cd])" ).append("\n"); 

	}
}