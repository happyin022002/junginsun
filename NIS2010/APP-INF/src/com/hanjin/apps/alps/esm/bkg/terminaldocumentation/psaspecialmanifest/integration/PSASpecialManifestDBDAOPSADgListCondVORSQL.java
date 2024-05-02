/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOPSADgListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.06
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.06 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOPSADgListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSADgListCondVO 생성을 위해 사용
	  * </pre>
	  */
	public PSASpecialManifestDBDAOPSADgListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOPSADgListCondVORSQL").append("\n"); 
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
		query.append("     '' VVD_CD" ).append("\n"); 
		query.append("    ,'' PORT_CD" ).append("\n"); 
		query.append("    ,'' D_TYPE -- Declaration Type" ).append("\n"); 
		query.append("	,'' BAY_PLN_ID" ).append("\n"); 
		query.append("	,'' FRM_VSL_CD" ).append("\n"); 
		query.append("	,'' FRM_BRTH_YD_CD" ).append("\n"); 
		query.append("	,'' FRM_FWRD_CD" ).append("\n"); 
		query.append("    ,'' FRM_IMDG_UN_NO" ).append("\n"); 
		query.append("	,'' OFC_CD" ).append("\n"); 
		query.append("    ,'' SEARCH_TYPE" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	,'' UI_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,'' BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' DG_LIST_COPY_FLAG" ).append("\n"); 
		query.append("	,'' BARGE_FLAG" ).append("\n"); 
		query.append("	,'' APPEND_FLAG" ).append("\n"); 
		query.append("	,'' p_bound_cd" ).append("\n"); 
		query.append("	,'' p_pol_cd" ).append("\n"); 
		query.append("	,'' p_pod_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}