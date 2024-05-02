/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RussiaManifestDownloadDBDAOModifyCntrInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.09
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.11.09 김보배
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

public class RussiaManifestDownloadDBDAOModifyCntrInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrInfoVO
	  * </pre>
	  */
	public RussiaManifestDownloadDBDAOModifyCntrInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration").append("\n"); 
		query.append("FileName : RussiaManifestDownloadDBDAOModifyCntrInfoVORSQL").append("\n"); 
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
		query.append("  '' AS bkg_no" ).append("\n"); 
		query.append(", '' AS cntr_no" ).append("\n"); 
		query.append(", '' AS wgt1" ).append("\n"); 
		query.append(", '' AS wgt2" ).append("\n"); 
		query.append(", '' AS tare_wgt" ).append("\n"); 
		query.append(", '' AS total_wgt" ).append("\n"); 
		query.append(", '' AS cre_usr_id" ).append("\n"); 
		query.append(", '' AS cre_dt" ).append("\n"); 
		query.append(", '' AS upd_usr_id" ).append("\n"); 
		query.append(", '' AS upd_dt" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}