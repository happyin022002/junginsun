/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BrcsManifestDownloadDBDAOBrManifestListCondRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.16 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsManifestDownloadDBDAOBrManifestListCondRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BrManifestListCondVO 생성
	  * </pre>
	  */
	public BrcsManifestDownloadDBDAOBrManifestListCondRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("'' pod_cd" ).append("\n"); 
		query.append(",'' pol_cd" ).append("\n"); 
		query.append(",'' vvd_cd" ).append("\n"); 
		query.append(",'' io_type" ).append("\n"); 
		query.append(",'' error_type" ).append("\n"); 
		query.append(",'' is_hidden_rate" ).append("\n"); 
		query.append(",'' brz_cmdt_cd" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.brazil.integration ").append("\n"); 
		query.append("FileName : BrcsManifestDownloadDBDAOBrManifestListCondRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}