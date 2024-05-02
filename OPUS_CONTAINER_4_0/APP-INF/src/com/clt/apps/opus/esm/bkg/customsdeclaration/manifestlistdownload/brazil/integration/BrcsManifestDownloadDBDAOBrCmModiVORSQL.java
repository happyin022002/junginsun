/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BrcsManifestDownloadDBDAOBrCmModiVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.17
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsManifestDownloadDBDAOBrCmModiVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BrCmModiVO 생성을 위해 사용
	  * </pre>
	  */
	public BrcsManifestDownloadDBDAOBrCmModiVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration").append("\n"); 
		query.append("FileName : BrcsManifestDownloadDBDAOBrCmModiVORSQL").append("\n"); 
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
		query.append("     '' IF_FLAG" ).append("\n"); 
		query.append("    ,'' UPD_DT" ).append("\n"); 
		query.append("    ,'' BRZ_CMDT_CD" ).append("\n"); 
		query.append("    ,'' NCM_NO" ).append("\n"); 
		query.append("    ,'' SHPR_TAX_NO" ).append("\n"); 
		query.append("    ,'' CNEE_TAX_NO" ).append("\n"); 
		query.append("    ,'' NTFY_TAX_NO" ).append("\n"); 
		query.append("    ,'' OB_SHPR_TAX_NO" ).append("\n"); 
		query.append("    ,'' OB_CNEE_TAX_NO" ).append("\n"); 
		query.append("    ,'' OB_NTFY_TAX_NO" ).append("\n"); 
		query.append("    ,'' CRE_DT" ).append("\n"); 
		query.append("    ,'' BRZ_DECL_NO" ).append("\n"); 
		query.append("    ,'' OB_BRZ_DECL_NO" ).append("\n"); 
		query.append("    ,'' BL_NO" ).append("\n"); 
		query.append("    ,'' KEY_BL_NO" ).append("\n"); 
		query.append("    ,'' CNTR_MF_SEQ" ).append("\n"); 
		query.append("    ,'' BL_NO_CHK" ).append("\n"); 
		query.append("    ,'' CRE_USR_ID" ).append("\n"); 
		query.append("    ,'' CNTR_NO" ).append("\n"); 
		query.append("    ,'' BL_NO_TP" ).append("\n"); 
		query.append("    ,'' UPD_USR_ID" ).append("\n"); 
		query.append("    ,'' BKG_NO" ).append("\n"); 
		query.append("    ,'' IO_TYPE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}