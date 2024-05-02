/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchCstmsJpWhRoutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.14 
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

public class JapanManifestListDownloadDBDAOsearchCstmsJpWhRoutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchCstmsJpWhRoutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchCstmsJpWhRoutRSQL").append("\n"); 
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
		query.append("SELECT CSTMS_CD," ).append("\n"); 
		query.append("       EXP_DT," ).append("\n"); 
		query.append("       APRO_NO," ).append("\n"); 
		query.append("       TRSP_MOD_CD," ).append("\n"); 
		query.append("       CSTMS_CD1," ).append("\n"); 
		query.append("       CSTMS_CD2," ).append("\n"); 
		query.append("       CSTMS_CD3," ).append("\n"); 
		query.append("       CSTMS_CD4," ).append("\n"); 
		query.append("       CSTMS_CD5," ).append("\n"); 
		query.append("       CSTMS_CD AS ORG_CSTMS_CD," ).append("\n"); 
		query.append("       EXP_DT AS ORG_EXP_DT," ).append("\n"); 
		query.append("       APRO_NO AS ORG_APRO_NO," ).append("\n"); 
		query.append("       TRSP_MOD_CD AS ORG_TRSP_MOD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_WH_ROUT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE CSTMS_CD LIKE @[cstms_cd]||'%'" ).append("\n"); 

	}
}