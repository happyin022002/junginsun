/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanmanifestListDownloadDBDAOsearchVslCallsignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanmanifestListDownloadDBDAOsearchVslCallsignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVslCallsign
	  * </pre>
	  */
	public JapanmanifestListDownloadDBDAOsearchVslCallsignRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("CALL_SGN_NO" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD = @[in_vsl_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration ").append("\n"); 
		query.append("FileName : JapanmanifestListDownloadDBDAOsearchVslCallsignRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}