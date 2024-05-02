/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOaddJpcusBlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOaddJpcusBlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addJpcusBl
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOaddJpcusBlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_ts_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pre_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pst_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bdr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pst_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_split_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_por_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pst_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_rly_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pre_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("split_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pst_rly_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOaddJpcusBlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_JP_BL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       (CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        BL_NO," ).append("\n"); 
		query.append("        BL_SPLIT_NO," ).append("\n"); 
		query.append("        VSL_CD," ).append("\n"); 
		query.append("        SKD_VOY_NO," ).append("\n"); 
		query.append("        SKD_DIR_CD," ).append("\n"); 
		query.append("        POL_CD," ).append("\n"); 
		query.append("        POD_CD," ).append("\n"); 
		query.append("        BKG_POR_CD," ).append("\n"); 
		query.append("        BKG_POL_CD," ).append("\n"); 
		query.append("        BKG_DEL_CD," ).append("\n"); 
		query.append("        PST_RLY_POD_CD," ).append("\n"); 
		query.append("        PST_VSL_CD," ).append("\n"); 
		query.append("        PST_SKD_VOY_NO," ).append("\n"); 
		query.append("        PST_SKD_DIR_CD," ).append("\n"); 
		query.append("        PCK_QTY," ).append("\n"); 
		query.append("        PCK_TP_CD," ).append("\n"); 
		query.append("        GRS_WGT," ).append("\n"); 
		query.append("        WGT_UT_CD," ).append("\n"); 
		query.append("        MEAS_QTY," ).append("\n"); 
		query.append("        MEAS_UT_CD," ).append("\n"); 
		query.append("        RCV_TERM_CD," ).append("\n"); 
		query.append("        DE_TERM_CD," ).append("\n"); 
		query.append("        DCGO_FLG," ).append("\n"); 
		query.append("        BDR_FLG," ).append("\n"); 
		query.append("        BDR_DT," ).append("\n"); 
		query.append("        CA_DT," ).append("\n"); 
		query.append("        CA_NO," ).append("\n"); 
		query.append("        JP_BL_STS_CD," ).append("\n"); 
		query.append("        IF_DT," ).append("\n"); 
		query.append("        LOCL_TS_IND_CD," ).append("\n"); 
		query.append("        JP_CSTMS_TRNS_CD," ).append("\n"); 
		query.append("        FULL_MTY_CD," ).append("\n"); 
		query.append("        SPLIT_FLG," ).append("\n"); 
		query.append("        LMT_NO," ).append("\n"); 
		query.append("        PRE_RLY_PORT_CD," ).append("\n"); 
		query.append("        PRE_VSL_CD," ).append("\n"); 
		query.append("        PRE_SKD_VOY_NO," ).append("\n"); 
		query.append("        PRE_SKD_DIR_CD" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("VALUES (@[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[cre_usr_id]," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[bl_no]," ).append("\n"); 
		query.append("        DECODE(@[bl_split_no], '  ', '  ', LPAD(TO_CHAR(NVL((@[bl_split_no]), 0)), 2, 0))," ).append("\n"); 
		query.append("        @[vsl_cd]," ).append("\n"); 
		query.append("        @[skd_voy_no]," ).append("\n"); 
		query.append("        @[skd_dir_cd]," ).append("\n"); 
		query.append("        @[pol_cd]," ).append("\n"); 
		query.append("        @[pod_cd]," ).append("\n"); 
		query.append("        @[bkg_por_cd]," ).append("\n"); 
		query.append("        @[bkg_pol_cd]," ).append("\n"); 
		query.append("        @[bkg_del_cd]," ).append("\n"); 
		query.append("        @[pst_rly_pod_cd]," ).append("\n"); 
		query.append("        @[pst_vsl_cd]," ).append("\n"); 
		query.append("        @[pst_skd_voy_no]," ).append("\n"); 
		query.append("        @[pst_skd_dir_cd]," ).append("\n"); 
		query.append("        REPLACE(NVL(@[pck_qty], 0), ',', '')," ).append("\n"); 
		query.append("        @[pck_tp_cd]," ).append("\n"); 
		query.append("        REPLACE(NVL(@[grs_wgt], 0), ',', '')," ).append("\n"); 
		query.append("        @[wgt_ut_cd]," ).append("\n"); 
		query.append("        REPLACE(NVL(@[meas_qty], 0), ',', '')," ).append("\n"); 
		query.append("        @[meas_ut_cd]," ).append("\n"); 
		query.append("        @[rcv_term_cd]," ).append("\n"); 
		query.append("        @[de_term_cd]," ).append("\n"); 
		query.append("        NVL(@[dcgo_flg], 'N')," ).append("\n"); 
		query.append("        NVL(@[bdr_flg], 'N')," ).append("\n"); 
		query.append("        TO_DATE(@[bdr_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("        TO_DATE(@[ca_dt], 'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("        @[ca_no]," ).append("\n"); 
		query.append("        'A'," ).append("\n"); 
		query.append("        SYSDATE," ).append("\n"); 
		query.append("        @[locl_ts_ind_cd]," ).append("\n"); 
		query.append("        DECODE(@[locl_ts_ind_cd], 'T', 'TRS', NULL)," ).append("\n"); 
		query.append("        NVL(@[full_mty_cd], 'F')," ).append("\n"); 
		query.append("        NVL(@[split_flg], 'N')," ).append("\n"); 
		query.append("        DECODE(@[locl_ts_ind_cd], 'T', '30')," ).append("\n"); 
		query.append("        @[pre_rly_port_cd]," ).append("\n"); 
		query.append("        @[pre_vsl_cd]," ).append("\n"); 
		query.append("        @[pre_skd_voy_no]," ).append("\n"); 
		query.append("        @[pre_skd_dir_cd]" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}