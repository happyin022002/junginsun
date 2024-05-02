/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.04.29 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Subin
 * @see DAO 참조
 * @since J2EE 1.4
 */

public class UsaManifestListDownloadDBDAOsearchCountryCodeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 국가코드 조회
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchCountryCodeListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("select" ).append("\n"); 
		query.append("cnt_cd," ).append("\n"); 
		query.append("cnt_nm" ).append("\n"); 
		query.append("from mdm_country" ).append("\n"); 
		query.append("order by cnt_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchCountryCodeListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}