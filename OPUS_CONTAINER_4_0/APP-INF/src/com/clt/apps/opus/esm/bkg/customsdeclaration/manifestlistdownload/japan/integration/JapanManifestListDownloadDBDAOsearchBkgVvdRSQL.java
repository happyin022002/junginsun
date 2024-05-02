/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.21 
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

public class JapanManifestListDownloadDBDAOsearchBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgVvd
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchBkgVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchBkgVvdRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("       POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${pst_pre_div} == 'PREV')" ).append("\n"); 
		query.append("   AND (BKG_NO," ).append("\n"); 
		query.append("        POD_CD) IN (SELECT BKG_NO," ).append("\n"); 
		query.append("                           POL_CD" ).append("\n"); 
		query.append("                      FROM BKG_VVD" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                       AND POD_CD = @[pod_cd])" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND POL_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("   AND POD_CD LIKE 'JP%'" ).append("\n"); 

	}
}