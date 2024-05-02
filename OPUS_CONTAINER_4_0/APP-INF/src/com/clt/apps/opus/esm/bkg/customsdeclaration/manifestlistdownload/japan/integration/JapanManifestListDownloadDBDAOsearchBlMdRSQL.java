/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchBlMdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.09 
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

public class JapanManifestListDownloadDBDAOsearchBlMdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlMd
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchBlMdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchBlMdRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO," ).append("\n"); 
		query.append("       ' ' AS BL_NO_SPLIT," ).append("\n"); 
		query.append("       C.MK_SEQ," ).append("\n"); 
		query.append("       NVL(UPPER(TRIM(DBMS_LOB.SUBSTR(C.MK_DESC, 2000, 1))), 'N/M') AS MK_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BOOKING A," ).append("\n"); 
		query.append("       BKG_BL_MK_DESC C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 

	}
}