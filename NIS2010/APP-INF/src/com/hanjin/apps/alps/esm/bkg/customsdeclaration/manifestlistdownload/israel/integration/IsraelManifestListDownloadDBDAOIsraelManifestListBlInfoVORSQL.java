/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelManifestListDownloadDBDAOIsraelManifestListBlInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.19 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelManifestListDownloadDBDAOIsraelManifestListBlInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IsraelManifestListBlInfoVO
	  * </pre>
	  */
	public IsraelManifestListDownloadDBDAOIsraelManifestListBlInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration").append("\n"); 
		query.append("FileName : IsraelManifestListDownloadDBDAOIsraelManifestListBlInfoVORSQL").append("\n"); 
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
		query.append("SELECT ' ' bl_no" ).append("\n"); 
		query.append("     , ' ' bkg_no" ).append("\n"); 
		query.append("     , ' ' dt_seq" ).append("\n"); 
		query.append("     , ' ' cntr_no" ).append("\n"); 
		query.append("     , ' ' bkg_cgo_tp_cd" ).append("\n"); 
		query.append("     , ' ' pol_cd" ).append("\n"); 
		query.append("     , ' ' pod_cd" ).append("\n"); 
		query.append("     , ' ' b_pol_cd" ).append("\n"); 
		query.append("     , ' ' b_pod_cd" ).append("\n"); 
		query.append("     , ' ' del_cd" ).append("\n"); 
		query.append("     , ' ' il_eta" ).append("\n"); 
		query.append("     , ' ' pck_qty" ).append("\n"); 
		query.append("     , ' ' pck_tp_cd" ).append("\n"); 
		query.append("     , ' ' sh_nm" ).append("\n"); 
		query.append("     , ' ' sh_ad" ).append("\n"); 
		query.append("     , ' ' cnee_nm" ).append("\n"); 
		query.append("     , ' ' cnee_ad" ).append("\n"); 
		query.append("     , ' ' ntfy_nm" ).append("\n"); 
		query.append("     , ' ' ntfy_ad" ).append("\n"); 
		query.append("     , ' ' vsl_callsign" ).append("\n"); 
		query.append("     , ' ' vsl_lloydcode" ).append("\n"); 
		query.append("     , ' ' vsl_fullname" ).append("\n"); 
		query.append("     , ' ' eta" ).append("\n"); 
		query.append("     , ' ' etd" ).append("\n"); 
		query.append("     , ' ' slan_cd" ).append("\n"); 
		query.append("     , ' ' cust_to_ord_flg" ).append("\n"); 
		query.append("     , ' ' err_yn" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}