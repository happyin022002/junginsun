/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchCstmsJpWhRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.29 
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

public class JapanManifestListDownloadDBDAOsearchCstmsJpWhRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchCstmsJpWhRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wh_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchCstmsJpWhRSQL").append("\n"); 
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
		query.append("SELECT YD_CD," ).append("\n"); 
		query.append("       CSTMS_CD," ).append("\n"); 
		query.append("       WH_NM," ).append("\n"); 
		query.append("       YD_CD AS ORG_YD_CD," ).append("\n"); 
		query.append("       CSTMS_CD AS ORG_CSTMS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_JP_WH" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${yd_cd} != '')" ).append("\n"); 
		query.append("   AND YD_CD LIKE @[yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cstms_cd} != '')" ).append("\n"); 
		query.append("   AND CSTMS_CD LIKE @[cstms_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${wh_nm} != '')" ).append("\n"); 
		query.append("   AND WH_NM LIKE @[wh_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}