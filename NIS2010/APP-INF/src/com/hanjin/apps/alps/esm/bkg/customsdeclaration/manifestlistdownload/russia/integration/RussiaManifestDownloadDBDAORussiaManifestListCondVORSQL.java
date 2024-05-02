/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RussiaManifestDownloadDBDAORussiaManifestListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.07.04 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaManifestDownloadDBDAORussiaManifestListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RussiaManifestListCondVO
	  * </pre>
	  */
	public RussiaManifestDownloadDBDAORussiaManifestListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration").append("\n"); 
		query.append("FileName : RussiaManifestDownloadDBDAORussiaManifestListCondVORSQL").append("\n"); 
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
		query.append("  '' AS mode_type" ).append("\n"); 
		query.append(", '' AS vvd_cd" ).append("\n"); 
		query.append(", '' AS pol_cd" ).append("\n"); 
		query.append(", '' AS pol_yd_cd" ).append("\n"); 
		query.append(", '' AS pod_cd" ).append("\n"); 
		query.append(", '' AS pod_yd_cd" ).append("\n"); 
		query.append(", '' AS cargo_type" ).append("\n"); 
		query.append(", '' AS cargo_route" ).append("\n"); 
		query.append(", '' AS br_por_cd" ).append("\n"); 
		query.append(", '' AS br_pol_cd" ).append("\n"); 
		query.append(", '' AS br_pod_cd" ).append("\n"); 
		query.append(", '' AS br_del_cd" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- sort 기능 빼게 되면 삭제" ).append("\n"); 
		query.append(", '' AS order_by_title" ).append("\n"); 
		query.append(", '' AS order_by" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}