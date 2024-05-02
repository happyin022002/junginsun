/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EacMgtDBDAOAutoAuditFileVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.19
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.11.19 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CJH
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EacMgtDBDAOAutoAuditFileVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Auto Audit File Attach용 VO
	  * </pre>
	  */
	public EacMgtDBDAOAutoAuditFileVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration").append("\n"); 
		query.append("FileName : EacMgtDBDAOAutoAuditFileVORSQL").append("\n"); 
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
		query.append("SELECT '' ATCH_FILE_LNK_ID" ).append("\n"); 
		query.append("      ,'' ATCH_FILE_LNK_SEQ" ).append("\n"); 
		query.append("      ,'' FILE_SAV_ID" ).append("\n"); 
		query.append("      ,'' CRE_OFC_CD" ).append("\n"); 
		query.append("      ,'' CRE_USR_ID" ).append("\n"); 
		query.append("      ,'' CRE_DT" ).append("\n"); 
		query.append("      ,'' UPD_USR_ID" ).append("\n"); 
		query.append("      ,'' UPD_DT" ).append("\n"); 
		query.append("      ,'' FILE_NM" ).append("\n"); 
		query.append("      ,'' FILE_SIZE" ).append("\n"); 
		query.append("      ,'' FILE_PATH_URL" ).append("\n"); 
		query.append("      ,'' MDL_TP_CD" ).append("\n"); 
		query.append("      ,'' RGST_DT" ).append("\n"); 
		query.append("  FROM DUAL" ).append("\n"); 

	}
}