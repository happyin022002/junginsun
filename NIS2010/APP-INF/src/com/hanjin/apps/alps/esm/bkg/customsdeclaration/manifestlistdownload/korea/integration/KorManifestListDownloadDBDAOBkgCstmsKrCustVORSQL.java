/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestListDownloadDBDAOBkgCstmsKrCustVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.07 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDownloadDBDAOBkgCstmsKrCustVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCstmsKrCustVO 생성을 위해 사용
	  * </pre>
	  */
	public KorManifestListDownloadDBDAOBkgCstmsKrCustVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDownloadDBDAOBkgCstmsKrCustVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	'' vsl_cd" ).append("\n"); 
		query.append("	,'' bkg_cgo_tp" ).append("\n"); 
		query.append("	,'' cust_addr" ).append("\n"); 
		query.append("	,'' kcd_tp" ).append("\n"); 
		query.append("	,'' expt_kcd_tp" ).append("\n"); 
		query.append("	,'' kt_seq" ).append("\n"); 
		query.append("	,'' username" ).append("\n"); 
		query.append("	,'' bkg_no" ).append("\n"); 
		query.append("	,'' cust_cd" ).append("\n"); 
		query.append("	,'' cnt_cd" ).append("\n"); 
		query.append("	,'' bcs_tp" ).append("\n"); 
		query.append("	,'' ob_type" ).append("\n"); 
		query.append("	,'' cust_name" ).append("\n"); 
		query.append("	,'' kt_port" ).append("\n"); 
		query.append("	,'' cust_tel" ).append("\n"); 
		query.append("	,'' in_bound" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}