/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiManifestListDownloadDBDAODubaiManifestListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.26 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DubaiManifestListDownloadDBDAODubaiManifestListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DubaiManifestListCondVO
	  * </pre>
	  */
	public DubaiManifestListDownloadDBDAODubaiManifestListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.integration").append("\n"); 
		query.append("FileName : DubaiManifestListDownloadDBDAODubaiManifestListCondVORSQL").append("\n"); 
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
		query.append("SELECT '' DATA_TYPE" ).append("\n"); 
		query.append(",'' VVD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' CGO_TYPE" ).append("\n"); 
		query.append(",'' CGO_CODE" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append(",'' ETA_DT" ).append("\n"); 
		query.append(",'' ROTN_NO" ).append("\n"); 
		query.append(",'' INSTL_NO" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' MRN_NO" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}