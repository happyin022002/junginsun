/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOPSASendHistoryCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.18
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.10.18 박성진
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

public class PSASpecialManifestDBDAOPSASendHistoryCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSASendHistoryCondVO 생성을 위해 사용
	  * </pre>
	  */
	public PSASpecialManifestDBDAOPSASendHistoryCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n"); 
		query.append("FileName : PSASpecialManifestDBDAOPSASendHistoryCondVORSQL").append("\n"); 
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
		query.append("    '' D_TYPE" ).append("\n"); 
		query.append("    ,'' VVD_CD" ).append("\n"); 
		query.append("    ,'' PORT_CD" ).append("\n"); 
		query.append("    ,'' SND_DT_FROM" ).append("\n"); 
		query.append("    ,'' SND_DT_TO" ).append("\n"); 
		query.append("    ,'' BL_NO" ).append("\n"); 
		query.append("    ,'' CNTR_NO" ).append("\n"); 
		query.append("    ,'' MSG_TYPE" ).append("\n"); 
		query.append("	,'' CALL_GUBUN" ).append("\n"); 
		query.append("	,'' RCV_DATA" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}