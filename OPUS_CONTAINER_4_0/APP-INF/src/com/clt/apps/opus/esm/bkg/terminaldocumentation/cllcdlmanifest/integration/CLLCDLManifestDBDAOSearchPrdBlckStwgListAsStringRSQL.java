/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CLLCDLManifestDBDAOSearchPrdBlckStwgListAsStringRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOSearchPrdBlckStwgListAsStringRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public CLLCDLManifestDBDAOSearchPrdBlckStwgListAsStringRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration ").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOSearchPrdBlckStwgListAsStringRSQL").append("\n"); 
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
		query.append("    BKG_JOIN_FNC(CURSOR(" ).append("\n"); 
		query.append("        SELECT DISTINCT BLCK_STWG_CD" ).append("\n"); 
		query.append("          FROM PRD_BLCK_STWG" ).append("\n"); 
		query.append("         WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("         ORDER BY BLCK_STWG_CD" ).append("\n"); 
		query.append("    ),'|') AS BLCK_STWG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}