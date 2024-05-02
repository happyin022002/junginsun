/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrcsManifestDownloadDBDAOBrHsCdCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsManifestDownloadDBDAOBrHsCdCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BrHsCdCondVO 생성을 위해
	  * </pre>
	  */
	public BrcsManifestDownloadDBDAOBrHsCdCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration").append("\n"); 
		query.append("FileName : BrcsManifestDownloadDBDAOBrHsCdCondVORSQL").append("\n"); 
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
		query.append("    '' brz_cmdt_cd" ).append("\n"); 
		query.append("    ,'' cmdt_desc" ).append("\n"); 
		query.append("    ,'' cnt_cd" ).append("\n"); 
		query.append("    ,'' act_flg" ).append("\n"); 
		query.append("    ,'' countryCode" ).append("\n"); 
		query.append("    ,'' page_gubun" ).append("\n"); 
		query.append("	,'' del_check" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}