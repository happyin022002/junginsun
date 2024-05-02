/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialManifestDBDAODgListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAODgListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgListCondVO 생성을 위해 사용
	  * </pre>
	  */
	public SpecialManifestDBDAODgListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAODgListCondVORSQL").append("\n"); 
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
		query.append("'' VVD_CD" ).append("\n"); 
		query.append(",'' PORT_CD" ).append("\n"); 
		query.append(",'' D_TYPE -- Declaration Type" ).append("\n"); 
		query.append(",'' BAY_PLN_ID" ).append("\n"); 
		query.append(",'' FRM_VSL_CD" ).append("\n"); 
		query.append(",'' FRM_BRTH_YD_CD" ).append("\n"); 
		query.append(",'' FRM_FWRD_CD" ).append("\n"); 
		query.append(",'' FRM_IMDG_UN_NO" ).append("\n"); 
		query.append(",'' OFC_CD" ).append("\n"); 
		query.append(",'' SEARCH_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' UI_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",'' DG_LIST_COPY_FLAG" ).append("\n"); 
		query.append(",'' BARGE_FLAG" ).append("\n"); 
		query.append(",'' APPEND_FLAG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}