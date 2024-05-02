/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelManifestListDownloadDBDAOIsraelManifestListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.16
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.16 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelManifestListDownloadDBDAOIsraelManifestListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IsraelManifestListCondVO
	  * </pre>
	  */
	public IsraelManifestListDownloadDBDAOIsraelManifestListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration").append("\n"); 
		query.append("FileName : IsraelManifestListDownloadDBDAOIsraelManifestListCondVORSQL").append("\n"); 
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
		query.append("SELECT ' ' vvd_cd" ).append("\n"); 
		query.append("	 , ' ' pol_cd" ).append("\n"); 
		query.append("	 , ' ' pod_cd" ).append("\n"); 
		query.append("	 , ' ' bl_no" ).append("\n"); 
		query.append("	 , ' ' skd_flg" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}