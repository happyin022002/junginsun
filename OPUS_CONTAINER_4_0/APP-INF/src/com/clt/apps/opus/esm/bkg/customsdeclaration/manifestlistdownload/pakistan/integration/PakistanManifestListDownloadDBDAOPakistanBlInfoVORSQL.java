/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PakistanManifestListDownloadDBDAOPakistanBlInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.31
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.08.31 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PakistanManifestListDownloadDBDAOPakistanBlInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PakistanBlInfoVO
	  * </pre>
	  */
	public PakistanManifestListDownloadDBDAOPakistanBlInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration").append("\n"); 
		query.append("FileName : PakistanManifestListDownloadDBDAOPakistanBlInfoVORSQL").append("\n"); 
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
		query.append("SELECT '' chg_cd" ).append("\n"); 
		query.append("     , '' rat_ut_cd" ).append("\n"); 
		query.append("     , '' curr_cd" ).append("\n"); 
		query.append("     , '' frt_term_cd" ).append("\n"); 
		query.append("     , '' chg_amt" ).append("\n"); 
		query.append("     , '' total_bl" ).append("\n"); 
		query.append("     , '' vsl_cd" ).append("\n"); 
		query.append("     , '' skd_voy_no" ).append("\n"); 
		query.append("     , '' skd_dir_cd" ).append("\n"); 
		query.append("     , '' vvd_nm" ).append("\n"); 
		query.append("     , '' voy_cd" ).append("\n"); 
		query.append("     , '' bkg_no" ).append("\n"); 
		query.append("     , '' bl_no" ).append("\n"); 
		query.append("     , '' shpr_nm" ).append("\n"); 
		query.append("     , '' shpr_addr" ).append("\n"); 
		query.append("     , '' cnee_nm" ).append("\n"); 
		query.append("     , '' cnee_addr" ).append("\n"); 
		query.append("     , '' ntfy_nm" ).append("\n"); 
		query.append("     , '' ntfy_addr" ).append("\n"); 
		query.append("     , '' a_ntfy_nm" ).append("\n"); 
		query.append("     , '' a_ntfy_addr" ).append("\n"); 
		query.append("     , '' pol_cd" ).append("\n"); 
		query.append("     , '' pod_cd" ).append("\n"); 
		query.append("     , '' del_cd" ).append("\n"); 
		query.append("     , '' last_port" ).append("\n"); 
		query.append("     , '' ts_port1" ).append("\n"); 
		query.append("     , '' ts_vvd1" ).append("\n"); 
		query.append("     , '' ts_port2" ).append("\n"); 
		query.append("     , '' ts_vvd2" ).append("\n"); 
		query.append("     , '' rd_term_cd" ).append("\n"); 
		query.append("     , '' obl_iss_dt" ).append("\n"); 
		query.append("     , '' cstms_desc" ).append("\n"); 
		query.append("     , '' mk_desc" ).append("\n"); 
		query.append("     , '' cmdt_desc" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}