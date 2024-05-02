/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchDepartureTimeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.04.15 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sang-Soo KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchDepartureTimeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchDepartureTimeRSQL(){
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchDepartureTimeRSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(SKD.VPS_ETD_DT, 'YYYY-MM-DD') AS ETD_DATE," ).append("\n"); 
		query.append("       TO_CHAR(SKD.VPS_ETD_DT, 'HH24:MI') AS ETD_TIME," ).append("\n"); 
		query.append("       DECODE(JPSKD.JO_CD1, 'Y', '1', '') AS RLX_DIV" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_VSL_SKD JPSKD," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE JPSKD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND JPSKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND JPSKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND JPSKD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("   and JPSKD.VSL_CD = SKD.VSL_CD(+)" ).append("\n"); 
		query.append("   AND JPSKD.SKD_VOY_NO = SKD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND JPSKD.SKD_DIR_CD = SKD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND JPSKD.POL_CD = SKD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND SKD.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}