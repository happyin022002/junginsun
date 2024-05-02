/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PakistanManifestListDownloadDBDAOPakistanVesselVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.23
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.07.23 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PakistanManifestListDownloadDBDAOPakistanVesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PakistanVesselVO
	  * </pre>
	  */
	public PakistanManifestListDownloadDBDAOPakistanVesselVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.integration ").append("\n"); 
		query.append("FileName : PakistanManifestListDownloadDBDAOPakistanVesselVORSQL").append("\n"); 
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
		query.append("SELECT '' vsl_eng_nm" ).append("\n"); 
		query.append("     , '' call_sgn_no" ).append("\n"); 
		query.append("     , '' eta_dt" ).append("\n"); 
		query.append("     , '' etd_dt" ).append("\n"); 
		query.append("	 , '' pol_cd" ).append("\n"); 
		query.append("     , '' pod_cd" ).append("\n"); 
		query.append("     , '' vvd_cd" ).append("\n"); 
		query.append("FROM dual" ).append("\n"); 

	}
}