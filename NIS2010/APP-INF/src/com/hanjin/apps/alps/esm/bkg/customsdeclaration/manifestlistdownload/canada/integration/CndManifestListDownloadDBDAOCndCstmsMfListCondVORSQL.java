/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOCndCstmsMfListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.12.15 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOCndCstmsMfListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 다운로드 (0210) 조회조건
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOCndCstmsMfListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOCndCstmsMfListCondVORSQL").append("\n"); 
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
		query.append("'' AS TOTAL" ).append("\n"); 
		query.append(",'' AS VSL_CD" ).append("\n"); 
		query.append(",'' AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",'' AS SKD_VOY_NO" ).append("\n"); 
		query.append(",'' AS BL_NO" ).append("\n"); 
		query.append(",'' AS SKD_DIR_CD" ).append("\n"); 
		query.append(",'' AS POD_CD" ).append("\n"); 
		query.append(",'' AS BKG_NO" ).append("\n"); 
		query.append(",'' AS POL_CD" ).append("\n"); 
		query.append(",'' AS SHEET_ID" ).append("\n"); 
		query.append(",'' AS BL_NOS" ).append("\n"); 
		query.append(",'' AS PAGE_NO" ).append("\n"); 
		query.append(",'' AS CUSTOMS" ).append("\n"); 
		query.append(",'' AS CLPT_SEQ" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}