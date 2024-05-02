/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AustraliaManifestListDownloadDBDAOsearchAusSeacrSumRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AustraliaManifestListDownloadDBDAOsearchAusSeacrSumRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AustraliaManifestListDownloadDBDAOsearchAusSeacrSumRSQL(){
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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_div",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration").append("\n"); 
		query.append("FileName : AustraliaManifestListDownloadDBDAOsearchAusSeacrSumRSQL").append("\n"); 
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
		query.append("SELECT BV.POD_CD," ).append("\n"); 
		query.append("  COUNT(*) AS BL_CNT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_AUS_SND_LOG SNDLOG" ).append("\n"); 
		query.append("    WHERE (SNDLOG.BL_NO," ).append("\n"); 
		query.append("          SNDLOG.MSG_SND_NO) IN (" ).append("\n"); 
		query.append("        SELECT DISTINCT BL_NO," ).append("\n"); 
		query.append("          MAX(MSG_SND_NO) OVER (PARTITION BY BL_NO) AS MSG_SND_NO" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_AUS_SND_LOG" ).append("\n"); 
		query.append("        WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("          AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("          AND AUS_SND_LOG_ID = @[search_div])" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                  AND BL_NO = @[bl_no] " ).append("\n"); 
		query.append("#end ) AS SENT_CNT ," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_AUS_SND_LOG SNDLOG" ).append("\n"); 
		query.append("    WHERE (SNDLOG.BL_NO," ).append("\n"); 
		query.append("          SNDLOG.MSG_SND_NO) IN (" ).append("\n"); 
		query.append("        SELECT DISTINCT BL_NO," ).append("\n"); 
		query.append("          MAX(MSG_SND_NO) OVER (PARTITION BY BL_NO) AS MSG_SND_NO" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_AUS_SND_LOG" ).append("\n"); 
		query.append("        WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("          AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("          AND AUS_SND_LOG_ID = @[search_div])" ).append("\n"); 
		query.append("      AND LOG_FLG = 'Y'" ).append("\n"); 
		query.append("      AND CSTMS_RQST_FLG = 'N'" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end) AS SENT_ACC_CNT," ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT COUNT(*)" ).append("\n"); 
		query.append("    FROM BKG_CSTMS_AUS_SND_LOG SNDLOG" ).append("\n"); 
		query.append("    WHERE (SNDLOG.BL_NO," ).append("\n"); 
		query.append("          SNDLOG.MSG_SND_NO) IN (" ).append("\n"); 
		query.append("        SELECT DISTINCT BL_NO," ).append("\n"); 
		query.append("          MAX(MSG_SND_NO) OVER (PARTITION BY BL_NO) AS MSG_SND_NO" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_AUS_SND_LOG" ).append("\n"); 
		query.append("        WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("          AND POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("          AND AUS_SND_LOG_ID = @[search_div])" ).append("\n"); 
		query.append("      AND LOG_FLG = 'Y'" ).append("\n"); 
		query.append("      AND CSTMS_RQST_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("                  AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end) AS SENT_ERR_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD BV," ).append("\n"); 
		query.append("       BKG_BOOKING BB" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BV.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("   AND BB.BKG_STS_CD NOT IN ('S', 'X')" ).append("\n"); 
		query.append("   AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND BB.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${in_transit} == 'Y')" ).append("\n"); 
		query.append("   AND ((BV.POD_CD = @[pod_cd] AND" ).append("\n"); 
		query.append("         BV.POD_CD <> BB.POD_CD AND" ).append("\n"); 
		query.append("         SUBSTR(BB.POD_CD, 1, 2) <> 'AU') OR" ).append("\n"); 
		query.append("        (BV.POD_CD IN (SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                        WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                          AND CLPT_SEQ > (SELECT CLPT_SEQ" ).append("\n"); 
		query.append("                                            FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                           WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                             AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                             AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                             AND VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("                                             AND CLPT_IND_SEQ = '1'))" ).append("\n"); 
		query.append("         AND BV.POL_cd <> @[pod_cd]" ).append("\n"); 
		query.append("         AND SUBSTR(BB.POD_CD, 1, 2) <> 'AU')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND BV.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("   AND BB.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY BV.POD_CD" ).append("\n"); 

	}
}