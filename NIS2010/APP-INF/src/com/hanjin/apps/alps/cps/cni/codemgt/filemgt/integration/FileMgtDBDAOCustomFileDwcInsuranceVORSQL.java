/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : FileMgtDBDAOCustomFileDwcInsuranceVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2010.01.13 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt.filemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FileMgtDBDAOCustomFileDwcInsuranceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Dry Wet Claim & Insurance File
	  * </pre>
	  */
	public FileMgtDBDAOCustomFileDwcInsuranceVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.codemgt.filemgt.integration").append("\n"); 
		query.append("FileName : FileMgtDBDAOCustomFileDwcInsuranceVORSQL").append("\n"); 
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
		query.append("	'' CLM_FILE_SEQ" ).append("\n"); 
		query.append(",	'' CLM_FILE_TP_CD" ).append("\n"); 
		query.append(",	'' CLM_BZTP_CD" ).append("\n"); 
		query.append(",	'' FILE_SAV_ID" ).append("\n"); 
		query.append(",	'' FILE_NM" ).append("\n"); 
		query.append(",	'' FILE_DESC" ).append("\n"); 
		query.append(",	'' DW_CLM_NO" ).append("\n"); 
		query.append(",   '' FILE_DOWNLOAD" ).append("\n"); 
		query.append(",	'' INSUR_TP_CD" ).append("\n"); 
		query.append(",	'' INSUR_PLCY_YR" ).append("\n"); 
		query.append(",	'' INSUR_CLM_PTY_NO" ).append("\n"); 
		query.append(",	'' INST_INSUR_TP_CD" ).append("\n"); 
		query.append(",	'' INST_INSUR_PLCY_YR" ).append("\n"); 
		query.append(",	'' INST_PRM_INSUR_TP_CD" ).append("\n"); 
		query.append(",	'' CGO_CLM_REF_NO" ).append("\n"); 
		query.append(",	'' CLM_FILE_DP_SEQ" ).append("\n"); 
		query.append(",	'' CRE_USR_ID" ).append("\n"); 
		query.append(",	'' CRE_DT" ).append("\n"); 
		query.append(",	'' UPD_USR_ID" ).append("\n"); 
		query.append(",	'' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}