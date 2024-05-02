/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOEacFileOutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.01.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOEacFileOutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EAC File 첨부 내역을 조회
	  * </pre>
	  */
	public EacMgtDBDAOEacFileOutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOEacFileOutRSQL").append("\n"); 
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
		query.append("SELECT '' EAC_CMPL_CD" ).append("\n"); 
		query.append("      ,'' FILE_NM" ).append("\n"); 
		query.append("      ,'' FILE_SIZE" ).append("\n"); 
		query.append("      ,'' RGST_DT" ).append("\n"); 
		query.append("      ,'' EAC_NO" ).append("\n"); 
		query.append("      ,'' EAC_FILE_SEQ" ).append("\n"); 
		query.append("      ,'' FILE_SAV_ID" ).append("\n"); 
		query.append("      ,'' FILE_PATH_DESC" ).append("\n"); 
		query.append("      ,'' CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' RGST_OFC_CD" ).append("\n"); 
		query.append("      ,'' UPD_USR_ID" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}