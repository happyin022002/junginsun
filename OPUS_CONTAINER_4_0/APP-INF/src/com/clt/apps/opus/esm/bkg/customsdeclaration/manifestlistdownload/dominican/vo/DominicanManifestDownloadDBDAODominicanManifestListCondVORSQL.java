/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DominicanManifestDownloadDBDAODominicanManifestListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DominicanManifestDownloadDBDAODominicanManifestListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DominicanManifestListCondVO 생성을 위한 쿼리
	  * </pre>
	  */
	public DominicanManifestDownloadDBDAODominicanManifestListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dominican.vo ").append("\n"); 
		query.append("FileName : DominicanManifestDownloadDBDAODominicanManifestListCondVORSQL").append("\n"); 
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
		query.append("SELECT '' VVD" ).append("\n"); 
		query.append("	   , '' POD_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}