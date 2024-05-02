/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DaoNameDAOGhanaSearchVesselVORSQL.java
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

public class GhanaManifestListDownloadDBDAOGhanaSearchVesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 가나 세관 Vessel 정보를 받아오기 위한 VO
	  * </pre>
	  */
	public GhanaManifestListDownloadDBDAOGhanaSearchVesselVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration").append("\n"); 
		query.append("FileName : DaoNameDAOGhanaSearchVesselVORSQL").append("\n"); 
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
		query.append("SELECT '' vsl_eng_nm" ).append("\n"); 
		query.append("     , '' eta_dt" ).append("\n"); 
		query.append("     , '' etd_dt" ).append("\n"); 
		query.append("	 , '' pol_cd" ).append("\n"); 
		query.append("     , '' pod_cd" ).append("\n"); 
		query.append("     , '' vvd_cd" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}