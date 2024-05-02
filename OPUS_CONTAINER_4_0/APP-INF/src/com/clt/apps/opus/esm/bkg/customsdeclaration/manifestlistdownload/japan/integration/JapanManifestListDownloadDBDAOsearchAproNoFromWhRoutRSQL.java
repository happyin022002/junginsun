/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchAproNoFromWhRoutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchAproNoFromWhRoutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchAproNoFromWhRoutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_bnd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchAproNoFromWhRoutRSQL").append("\n"); 
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
		query.append("SELECT APRO_NO," ).append("\n"); 
		query.append("       @[del_bnd] AS CSTMS_CD," ).append("\n"); 
		query.append("       (SELECT WH_NM" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_JP_WH" ).append("\n"); 
		query.append("         WHERE CSTMS_CD = @[del_bnd]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS WH_NM," ).append("\n"); 
		query.append("       TRSP_MOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_WH_ROUT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE CSTMS_CD = @[pod_bnd]" ).append("\n"); 
		query.append("   AND (CSTMS_CD1 = @[del_bnd] OR" ).append("\n"); 
		query.append("        CSTMS_CD2 = @[del_bnd] OR" ).append("\n"); 
		query.append("        CSTMS_CD3 = @[del_bnd] OR" ).append("\n"); 
		query.append("        CSTMS_CD4 = @[del_bnd] OR" ).append("\n"); 
		query.append("        CSTMS_CD5 = @[del_bnd])" ).append("\n"); 

	}
}