/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DaoNameDAOGhanaVesselCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GhanaManifestListDownloadDBDAOGhanaVesselCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 가나 세관 Vessel 정보를 불러오기 위한 VO
	  * </pre>
	  */
	public GhanaManifestListDownloadDBDAOGhanaVesselCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration ").append("\n"); 
		query.append("FileName : DaoNameDAOGhanaVesselCondVORSQL").append("\n"); 
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
		query.append("SELECT '' pol_cd" ).append("\n"); 
		query.append("     , '' pod_cd" ).append("\n"); 
		query.append("     , '' vsl_cd" ).append("\n"); 
		query.append("     , '' skd_voy_no" ).append("\n"); 
		query.append("     , '' skd_dir_cd" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}