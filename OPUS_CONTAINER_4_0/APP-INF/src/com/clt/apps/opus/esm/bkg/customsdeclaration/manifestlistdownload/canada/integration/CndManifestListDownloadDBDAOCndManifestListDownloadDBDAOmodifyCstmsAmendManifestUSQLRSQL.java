/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOCndManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOCndManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOCndManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOCndManifestListDownloadDBDAOmodifyCstmsAmendManifestUSQLRSQL").append("\n"); 
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
		query.append("       '' AS TOTAL" ).append("\n"); 
		query.append("      ,'' AS VSL_CD" ).append("\n"); 
		query.append("      ,'' AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("      ,'' AS SKD_VOY_NO" ).append("\n"); 
		query.append("      ,'' AS BL_NO" ).append("\n"); 
		query.append("      ,'' AS SKD_DIR_CD" ).append("\n"); 
		query.append("      ,'' AS POD_CD" ).append("\n"); 
		query.append("      ,'' AS BKG_NO" ).append("\n"); 
		query.append("      ,'' AS POL_CD" ).append("\n"); 
		query.append("      ,'' AS SHEET_ID" ).append("\n"); 
		query.append("      ,'' AS BL_NOS" ).append("\n"); 
		query.append("      ,'' AS PAGE_NO" ).append("\n"); 
		query.append("      ,'' AS CUSTOMS" ).append("\n"); 
		query.append("      ,'' AS CLPT_SEQ" ).append("\n"); 
		query.append(" FROM DUAL" ).append("\n"); 

	}
}