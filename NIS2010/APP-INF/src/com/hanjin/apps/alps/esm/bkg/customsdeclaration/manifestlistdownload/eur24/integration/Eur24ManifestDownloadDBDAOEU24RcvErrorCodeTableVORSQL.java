/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEU24RcvErrorCodeTableVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.12.20 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOEU24RcvErrorCodeTableVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EU24RcvErrorCodeTableVO
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEU24RcvErrorCodeTableVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEU24RcvErrorCodeTableVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'' AS CNT_CD" ).append("\n"); 
		query.append(",'' AS P_CNT_CD" ).append("\n"); 
		query.append(",'' AS EU24_ERR_CD" ).append("\n"); 
		query.append(",'' AS ERROR_CODE" ).append("\n"); 
		query.append(",'' AS ERROR_DESCRIPTION" ).append("\n"); 
		query.append(",'' AS REMARK" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}