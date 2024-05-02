/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RussiaManifestDownloadDBDAORussiaManifestListDetailVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.07
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.07 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaManifestDownloadDBDAORussiaManifestListDetailVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RussiaManifestListDetailVO
	  * </pre>
	  */
	public RussiaManifestDownloadDBDAORussiaManifestListDetailVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration").append("\n"); 
		query.append("FileName : RussiaManifestDownloadDBDAORussiaManifestListDetailVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("  '' AS bkg_cgo_tp_cd" ).append("\n"); 
		query.append(", '' AS bkg_no" ).append("\n"); 
		query.append(", '' AS bl_no" ).append("\n"); 
		query.append(", '' AS cbf" ).append("\n"); 
		query.append(", '' AS cbm" ).append("\n"); 
		query.append(", '' AS cnee_nm" ).append("\n"); 
		query.append(", '' AS cntr_no" ).append("\n"); 
		query.append(", '' AS cntr_seal_no" ).append("\n"); 
		query.append(", '' AS del_cd" ).append("\n"); 
		query.append(", '' AS del_yd_cd" ).append("\n"); 
		query.append(", '' AS group_etd_eta" ).append("\n"); 
		query.append(", '' AS group_pol_pod" ).append("\n"); 
		query.append(", '' AS group_title" ).append("\n"); 
		query.append(", '' AS group_total" ).append("\n"); 
		query.append(", '' AS hd_eta_etd" ).append("\n"); 
		query.append(", '' AS hd_eta_etd_cd" ).append("\n"); 
		query.append(", '' AS hd_mode_type" ).append("\n"); 
		query.append(", '' AS hd_pol_pod" ).append("\n"); 
		query.append(", '' AS hd_pol_pod_cd" ).append("\n"); 
		query.append(", '' AS hd_vvd_cd" ).append("\n"); 
		query.append(", '' AS header" ).append("\n"); 
		query.append(", '' AS kgs" ).append("\n"); 
		query.append(", '' AS lbs" ).append("\n"); 
		query.append(", '' AS meas_qty" ).append("\n"); 
		query.append(", '' AS meas_ut_cd" ).append("\n"); 
		query.append(", '' AS pkg1" ).append("\n"); 
		query.append(", '' AS pkg2" ).append("\n"); 
		query.append(", '' AS pod_cd" ).append("\n"); 
		query.append(", '' AS pod_yd_cd" ).append("\n"); 
		query.append(", '' AS pol_cd" ).append("\n"); 
		query.append(", '' AS pol_yd_cd" ).append("\n"); 
		query.append(", '' AS por_cd" ).append("\n"); 
		query.append(", '' AS rd_cd1" ).append("\n"); 
		query.append(", '' AS rd_cd2" ).append("\n"); 
		query.append(", '' AS seal_no" ).append("\n"); 
		query.append(", '' AS seq_no" ).append("\n"); 
		query.append(", '' AS sh_nm" ).append("\n"); 
		query.append(", '' AS total_kgs" ).append("\n"); 
		query.append(", '' AS total_lbs" ).append("\n"); 
		query.append(", '' AS total_pkg" ).append("\n"); 
		query.append(", '' AS wgt1" ).append("\n"); 
		query.append(", '' AS wgt2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", '' AS tare_wgt" ).append("\n"); 
		query.append(", '' AS total_wgt" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- SORT 안하면 삭제" ).append("\n"); 
		query.append(", '' AS order_by" ).append("\n"); 
		query.append(", '' AS order_by_title" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}