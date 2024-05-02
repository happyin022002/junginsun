/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOmodifyBkgCstmsAdvBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.23 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Min Jeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOmodifyBkgCstmsAdvBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyBkgCstmsAdvBl
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOmodifyBkgCstmsAdvBlUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ibd_loc_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_file_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_tz_yd_zip_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_addr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ams_pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_tz_yd_cty_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_ste_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_tz_yd_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_tz_yd_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_tz_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("MERGE INTO BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (" ).append("\n"); 
		query.append("CNT_CD = 'CA'" ).append("\n"); 
		query.append("AND  BL_NO = @[bl_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET UPD_DT = SYSDATE" ).append("\n"); 
		query.append(",UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",CSTMS_TRSM_STS_CD = @[cstms_trsm_sts_cd]" ).append("\n"); 
		query.append("#if (${mf_sts_cd} != '')" ).append("\n"); 
		query.append(",MF_STS_CD = @[mf_sts_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",TRSP_TP_ID = @[trsp_tp_id]" ).append("\n"); 
		query.append(",FULL_MTY_CD = @[full_mty_cd]" ).append("\n"); 
		query.append(",DEL_CD = @[del_cd]" ).append("\n"); 
		query.append(",PCK_QTY = TO_NUMBER(REPLACE(@[pck_qty],',',''))" ).append("\n"); 
		query.append(",AMS_PCK_TP_CD = @[ams_pck_tp_cd]" ).append("\n"); 
		query.append(",CGO_WGT = TO_NUMBER(REPLACE(@[cgo_wgt],',',''))" ).append("\n"); 
		query.append(",WGT_UT_CD = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",HUB_LOC_CD = @[hub_loc_cd]" ).append("\n"); 
		query.append(",IBD_LOC_GDS_DESC = @[ibd_loc_gds_desc]" ).append("\n"); 
		query.append(",IN_TZ_YD_CD = @[in_tz_yd_cd]" ).append("\n"); 
		query.append(",IN_TZ_YD_ZIP_ID = @[in_tz_yd_zip_id]" ).append("\n"); 
		query.append(",IN_TZ_YD_NM     = @[in_tz_yd_nm]" ).append("\n"); 
		query.append(",IN_TZ_YD_ADDR   = @[in_tz_yd_addr]" ).append("\n"); 
		query.append(",IN_TZ_YD_CTY_NM = @[in_tz_yd_cty_nm]" ).append("\n"); 
		query.append(",IN_TZ_YD_STE_CD = @[in_tz_yd_ste_cd]" ).append("\n"); 
		query.append(",IN_TZ_YD_CNT_CD = @[in_tz_yd_cnt_cd]" ).append("\n"); 
		query.append(",DIFF_RMK        = @[diff_rmk]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (" ).append("\n"); 
		query.append("CNT_CD" ).append("\n"); 
		query.append(",BL_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",CSTMS_FILE_TP_CD" ).append("\n"); 
		query.append(",VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",CSTMS_POL_CD" ).append("\n"); 
		query.append(",CSTMS_POD_CD" ).append("\n"); 
		query.append(",POR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",DEL_CD" ).append("\n"); 
		query.append(",HUB_LOC_CD" ).append("\n"); 
		query.append(",MF_STS_CD" ).append("\n"); 
		query.append(",PCK_QTY" ).append("\n"); 
		query.append(",AMS_PCK_TP_CD" ).append("\n"); 
		query.append(",CGO_WGT" ).append("\n"); 
		query.append(",WGT_UT_CD" ).append("\n"); 
		query.append(",TRSP_TP_ID" ).append("\n"); 
		query.append(",FULL_MTY_CD" ).append("\n"); 
		query.append(",IBD_LOC_GDS_DESC" ).append("\n"); 
		query.append(",IN_TZ_YD_CD" ).append("\n"); 
		query.append(",IN_TZ_YD_ZIP_ID" ).append("\n"); 
		query.append(",IN_TZ_YD_NM" ).append("\n"); 
		query.append(",IN_TZ_YD_ADDR" ).append("\n"); 
		query.append(",IN_TZ_YD_CTY_NM" ).append("\n"); 
		query.append(",IN_TZ_YD_STE_CD" ).append("\n"); 
		query.append(",IN_TZ_YD_CNT_CD" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("'CA'" ).append("\n"); 
		query.append(",@[bl_no]" ).append("\n"); 
		query.append(",'  '" ).append("\n"); 
		query.append(",@[cstms_file_tp_cd]" ).append("\n"); 
		query.append(",@[vsl_cd]" ).append("\n"); 
		query.append(",@[skd_voy_no]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[pod_cd]" ).append("\n"); 
		query.append(",@[por_cd]" ).append("\n"); 
		query.append(",@[pol_cd]" ).append("\n"); 
		query.append(",@[pod_cd]" ).append("\n"); 
		query.append(",@[del_cd]" ).append("\n"); 
		query.append(",@[hub_loc_cd]" ).append("\n"); 
		query.append(",'A'" ).append("\n"); 
		query.append(",TO_NUMBER(REPLACE(@[pck_qty],',',''))" ).append("\n"); 
		query.append(",@[ams_pck_tp_cd]" ).append("\n"); 
		query.append(",TO_NUMBER(REPLACE(@[cgo_wgt],',',''))" ).append("\n"); 
		query.append(",@[wgt_ut_cd]" ).append("\n"); 
		query.append(",@[trsp_tp_id]" ).append("\n"); 
		query.append(",@[full_mty_cd]" ).append("\n"); 
		query.append(",@[ibd_loc_gds_desc]" ).append("\n"); 
		query.append(",@[in_tz_yd_cd]" ).append("\n"); 
		query.append(",@[in_tz_yd_zip_id]" ).append("\n"); 
		query.append(",@[in_tz_yd_nm]" ).append("\n"); 
		query.append(",@[in_tz_yd_addr]" ).append("\n"); 
		query.append(",@[in_tz_yd_cty_nm]" ).append("\n"); 
		query.append(",@[in_tz_yd_ste_cd]" ).append("\n"); 
		query.append(",@[in_tz_yd_cnt_cd]" ).append("\n"); 
		query.append(",@[diff_rmk]" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOmodifyBkgCstmsAdvBlUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}