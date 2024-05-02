/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEur24BlInfoCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOEur24BlInfoCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOEur24BlInfoCondVORSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEur24BlInfoCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEur24BlInfoCondVORSQL").append("\n"); 
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
		query.append("/* Eur24BlInfoCond VO  BlInfoCondVO" ).append("\n"); 
		query.append("import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlInfoCondVO;" ).append("\n"); 
		query.append("*/" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  ' ' as vvd" ).append("\n"); 
		query.append(", ' ' as cntr_no" ).append("\n"); 
		query.append(", ' ' as bl_no" ).append("\n"); 
		query.append(", ' ' as cstms_yd_cd" ).append("\n"); 
		query.append(", ' ' as upd_usr_id" ).append("\n"); 
		query.append(", ' ' as cre_usr_id" ).append("\n"); 
		query.append(", ' ' as mrn_flg" ).append("\n"); 
		query.append(", ' ' as mvmt_ref_no" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}