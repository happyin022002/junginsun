/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchVvdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchVvdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgCstmsChnVvdVO
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchVvdInfoRSQL(){
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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n"); 
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchVvdInfoRSQL").append("\n"); 
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
		query.append("SELECT VSL_INFO.VVD," ).append("\n"); 
		query.append("       V.CALL_SGN_NO," ).append("\n"); 
		query.append("       VSL_INFO.PRE_PORT," ).append("\n"); 
		query.append("       VSL_INFO.NXT_PORT," ).append("\n"); 
		query.append("       TO_CHAR(VSL_INFO.VPS_ETA_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(VSL_INFO.VPS_ETD_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETD_DT," ).append("\n"); 
		query.append("       TO_CHAR(VSL_INFO.VPS_ETB_DT, 'YYYY-MM-DD HH24:MI') AS VPS_ETB_DT," ).append("\n"); 
		query.append("       V.VSL_ENG_NM," ).append("\n"); 
		query.append("       DECODE(VSL_INFO.VPS_ETA_DT, VSL_INFO.VVD2_ETA, 'Y', 'N')||TO_CHAR(VSL_INFO.VVD2_ETA, 'YYYY-MM-DD HH24:MI') AS DL_CHK_FLG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM MDM_VSL_CNTR V," ).append("\n"); 
		query.append("       (SELECT VPS.VSL_CD AS VSL," ).append("\n"); 
		query.append("               VPS.VSL_CD||VPS.SKD_VOY_NO||VPS.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("               VPS2.VPS_PORT_CD AS PRE_PORT," ).append("\n"); 
		query.append("               VPS3.VPS_PORT_CD AS NXT_PORT," ).append("\n"); 
		query.append("               VPS.VPS_ETA_DT," ).append("\n"); 
		query.append("               VPS.VPS_ETD_DT," ).append("\n"); 
		query.append("               VPS.VPS_ETB_DT," ).append("\n"); 
		query.append("               NVL((SELECT VPS_ETA_DT" ).append("\n"); 
		query.append("                      FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                     WHERE VSL_CD = SUBSTR(@[vvd2], 1, 4)" ).append("\n"); 
		query.append("                       AND SKD_VOY_NO = SUBSTR(@[vvd2], 5, 4)" ).append("\n"); 
		query.append("                       AND SKD_DIR_CD = SUBSTR(@[vvd2], 9, 1)" ).append("\n"); 
		query.append("                       AND VPS_PORT_CD = @[loc_cd]" ).append("\n"); 
		query.append("                       AND NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("                       AND (CLPT_IND_SEQ = '1' OR CLPT_IND_SEQ = '2')" ).append("\n"); 
		query.append("                       AND ROWNUM = 1), '') AS VVD2_ETA" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD VPS," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD VPS2," ).append("\n"); 
		query.append("               VSK_VSL_PORT_SKD VPS3" ).append("\n"); 
		query.append("         WHERE VPS.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND VPS.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND VPS.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           AND VPS.VPS_PORT_CD = @[loc_cd]" ).append("\n"); 
		query.append("           AND NVL(VPS.SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("           AND (VPS.CLPT_IND_SEQ = '1' OR VPS.CLPT_IND_SEQ = '2')" ).append("\n"); 
		query.append("           AND VPS.VSL_CD = VPS2.VSL_CD(+)" ).append("\n"); 
		query.append("           AND VPS.SKD_VOY_NO = VPS2.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND VPS.SKD_DIR_CD = VPS2.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND VPS.CLPT_SEQ - 1 = VPS2.CLPT_SEQ(+)" ).append("\n"); 
		query.append("           AND VPS.VSL_CD = VPS3.VSL_CD(+)" ).append("\n"); 
		query.append("           AND VPS.SKD_VOY_NO = VPS3.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND VPS.SKD_DIR_CD = VPS3.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND VPS.CLPT_SEQ + 1 = VPS3.CLPT_SEQ(+)" ).append("\n"); 
		query.append("         ORDER BY VPS.CLPT_SEQ DESC ) VSL_INFO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VSL_INFO.VSL = V.VSL_CD" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}