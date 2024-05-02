/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchActVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.04.08 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchActVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UsaContainerManifestListVO
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchActVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchActVvdRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(VSL_CD || SKD_VOY_NO || ACT_FILE_SKD_DIR_CD), " ).append("\n"); 
		query.append("           SUBSTR(@[vvd], 1, 8) || DECODE(SUBSTR(@[vvd], 9), 'E', 'W', 'W', 'E')) AS VVD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_BL" ).append("\n"); 
		query.append(" WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("   AND VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd], 9)" ).append("\n"); 
		query.append("   AND CSTMS_POL_CD = @[pol]" ).append("\n"); 
		query.append("   AND ACT_FILE_SKD_DIR_CD IS NOT NULL" ).append("\n"); 

	}
}