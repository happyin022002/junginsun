/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelManifestListDownloadDBDAOsearchVesselScheduleRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.19 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelManifestListDownloadDBDAOsearchVesselScheduleRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD 가 Israel 을 지나가는 배인지 아닌지 스케쥴 확인
	  * </pre>
	  */
	public IsraelManifestListDownloadDBDAOsearchVesselScheduleRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration").append("\n"); 
		query.append("FileName : IsraelManifestListDownloadDBDAOsearchVesselScheduleRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(1) > 0 THEN 'Y' ELSE 'N' END AS SKD_FLG" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD WHERE 1=1" ).append("\n"); 
		query.append("AND VPS_PORT_CD LIKE 'IL%'" ).append("\n"); 
		query.append("AND VSL_CD = SUBSTR(@[vvd_cd], 1,4)" ).append("\n"); 
		query.append("AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 

	}
}