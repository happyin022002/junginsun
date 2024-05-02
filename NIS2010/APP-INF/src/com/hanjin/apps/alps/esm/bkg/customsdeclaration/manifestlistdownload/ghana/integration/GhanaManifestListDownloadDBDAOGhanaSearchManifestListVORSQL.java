/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DaoNameDAOGhanaSearchManifestListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GhanaManifestListDownloadDBDAOGhanaSearchManifestListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 가나 세관 BKG Manifest 정보를 위한 VO
	  * </pre>
	  */
	public GhanaManifestListDownloadDBDAOGhanaSearchManifestListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration").append("\n"); 
		query.append("FileName : DaoNameDAOGhanaSearchManifestListVORSQL").append("\n"); 
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
		query.append("SELECT '' vvd_number" ).append("\n"); 
		query.append("     , '' bkg_no" ).append("\n"); 
		query.append("     , '' bl_no" ).append("\n"); 
		query.append("     , '' mfsnd_code" ).append("\n"); 
		query.append("     , '' term_cd" ).append("\n"); 
		query.append("     , '' ghtem_cd" ).append("\n"); 
		query.append("     , '' por_cd" ).append("\n"); 
		query.append("     , '' bv_pol_cd" ).append("\n"); 
		query.append("     , '' bv_pod_cd" ).append("\n"); 
		query.append("     , '' del_cd" ).append("\n"); 
		query.append("     , '' act_wgt" ).append("\n"); 
		query.append("     , '' wgt_ut_cd" ).append("\n"); 
		query.append("     , '' pck_qty" ).append("\n"); 
		query.append("     , '' vvd_cd" ).append("\n"); 
		query.append("     , '' frt_term_cd" ).append("\n"); 
		query.append("     , '' hot_de_flg" ).append("\n"); 
		query.append("     , '' rc_flg" ).append("\n"); 
		query.append("     , '' mf_snd_dt" ).append("\n"); 
		query.append("     , '' total_bl" ).append("\n"); 
		query.append("     , '' pol_cd" ).append("\n"); 
		query.append("     , '' pod_cd" ).append("\n"); 
		query.append("     , '' bl_tp_cd" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}