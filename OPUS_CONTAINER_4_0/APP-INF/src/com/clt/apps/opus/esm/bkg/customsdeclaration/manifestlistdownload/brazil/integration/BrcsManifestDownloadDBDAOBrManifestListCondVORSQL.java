/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BrcsManifestDownloadDBDAOBrManifestListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsManifestDownloadDBDAOBrManifestListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BrManifestListCondVO 생성을 위해 사용함
	  * </pre>
	  */
	public BrcsManifestDownloadDBDAOBrManifestListCondVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration ").append("\n"); 
		query.append("FileName : BrcsManifestDownloadDBDAOBrManifestListCondVORSQL").append("\n"); 
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
		query.append("''POD_CD" ).append("\n"); 
		query.append(",''POL_CD" ).append("\n"); 
		query.append(",''BRZ_CMDT_CD" ).append("\n"); 
		query.append(",''ERROR_TYPE" ).append("\n"); 
		query.append(",''VVD_CD" ).append("\n"); 
		query.append(",''IO_TYPE" ).append("\n"); 
		query.append(",''IS_HIDDEN_RATE" ).append("\n"); 
		query.append(",''BKG_CGO_TP_CD" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}