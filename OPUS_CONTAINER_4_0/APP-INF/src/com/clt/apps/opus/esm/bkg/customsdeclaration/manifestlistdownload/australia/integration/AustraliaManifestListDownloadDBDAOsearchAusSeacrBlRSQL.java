/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AustraliaManifestListDownloadDBDAOsearchAusSeacrBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.22 
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

public class AustraliaManifestListDownloadDBDAOsearchAusSeacrBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AustraliaManifestListDownloadDBDAOsearchAusSeacrBlRSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("search_div",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration").append("\n"); 
		query.append("FileName : AustraliaManifestListDownloadDBDAOsearchAusSeacrBlRSQL").append("\n"); 
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
		query.append("SELECT BB.BL_NO," ).append("\n"); 
		query.append("       BB.BKG_NO," ).append("\n"); 
		query.append("       BV.POL_CD AS VVD_POL," ).append("\n"); 
		query.append("       BV.POD_CD AS VVD_POD," ).append("\n"); 
		query.append("       BB.POD_CD AS BKG_POD," ).append("\n"); 
		query.append("       BB.DEL_CD AS BKG_DEL," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_AUS_SND_LOG) */" ).append("\n"); 
		query.append("          TO_CHAR(SND.SND_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_AUS_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE SND.BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("           AND SND.AUS_SND_LOG_ID = @[search_div]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS SND_DT," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_AUS_SND_LOG) */" ).append("\n"); 
		query.append("               CASE" ).append("\n"); 
		query.append("                  WHEN LOG_FLG = 'N' THEN 'SENDING'" ).append("\n"); 
		query.append("                  WHEN CSTMS_RQST_FLG = 'Y' THEN 'ERROR'" ).append("\n"); 
		query.append("                  ELSE 'SUCCESS'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_AUS_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE SND.BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("           AND SND.AUS_SND_LOG_ID = @[search_div]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS RCV_RSLT," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_AUS_SND_LOG) */" ).append("\n"); 
		query.append("               SND.EDI_REF_ID" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_AUS_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE SND.BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("           AND SND.AUS_SND_LOG_ID = @[search_div]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS EDI_REF_ID" ).append("\n"); 
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

	}
}