/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOGetAdvJpVslByCallsignRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.03.21 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOGetAdvJpVslByCallsignRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOGetAdvJpVslByCallsignRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOGetAdvJpVslByCallsignRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_SS(SKD XPKBKG_CSTMS_ADV_JP_VSL_SKD) */" ).append("\n"); 
		query.append("       SKD.VSL_CD," ).append("\n"); 
		query.append("       SKD.JO_CD1 AS RLX_DIV," ).append("\n"); 
		query.append("       (SELECT A.POL_CD" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_SND_LOG A" ).append("\n"); 
		query.append("         WHERE A.JP_SND_LOG_ID = 'ATD'" ).append("\n"); 
		query.append("           AND A.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND A.SND_DT = (SELECT MAX(SND_DT)" ).append("\n"); 
		query.append("                             FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n"); 
		query.append("                            WHERE SND.JP_SND_LOG_ID = 'ATD'" ).append("\n"); 
		query.append("                              AND SND.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("                              AND SND.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                              AND SND.SKD_DIR_CD = @[skd_dir_cd])) AS POL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_VSL_SKD SKD" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" WHERE SKD.CALL_SGN_NO = @[call_sgn_no]" ).append("\n"); 
		query.append("   AND SKD.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}