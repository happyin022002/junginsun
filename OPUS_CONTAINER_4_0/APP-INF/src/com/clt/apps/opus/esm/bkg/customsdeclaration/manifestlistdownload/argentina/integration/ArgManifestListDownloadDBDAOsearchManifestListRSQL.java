/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ArgManifestListDownloadDBDAOsearchManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.05.20 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ArgManifestListDownloadDBDAOsearchManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchManifestList
	  * </pre>
	  */
	public ArgManifestListDownloadDBDAOsearchManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.argentina.integration").append("\n"); 
		query.append("FileName : ArgManifestListDownloadDBDAOsearchManifestListRSQL").append("\n"); 
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
		query.append("SELECT MAIN2.*" ).append("\n"); 
		query.append("      ,NVL(IN_TZ_FLG,TS_IND) AS IN_TZ_FLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT MAIN.*" ).append("\n"); 
		query.append("      , (SELECT CASE WHEN MAX(V2) >=2 THEN 'S'" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("                 END TS_IND" ).append("\n"); 
		query.append("           FROM (SELECT LEVEL SEQ" ).append("\n"); 
		query.append("		   FROM   DUAL" ).append("\n"); 
		query.append("		   CONNECT BY LEVEL <= 5" ).append("\n"); 
		query.append("		   ) V1) TS_IND" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT SUM(SEQ) OVER (ORDER BY BL_NO) ROW_SEQ" ).append("\n"); 
		query.append("      ,TB.*" ).append("\n"); 
		query.append("      ,NVL((SELECT 'Y'  " ).append("\n"); 
		query.append("            FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("            WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("            AND CSTMS_DIV_ID = 'NA_STAFF'" ).append("\n"); 
		query.append("            AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("            AND ATTR_CTNT1 = @[upd_usr_id]" ).append("\n"); 
		query.append("            AND ROWNUM = 1), 'N') AS NA_STF_FLG" ).append("\n"); 
		query.append("	,(SELECT MAX(ROWNUM) SEQ" ).append("\n"); 
		query.append("	  FROM BKG_VVD VVD, VSK_VSL_PORT_SKD VPS_ETA, VSK_VSL_PORT_SKD VPS_ETD, BKG_BOOKING BKG" ).append("\n"); 
		query.append("	  WHERE VVD.VSL_CD     = VPS_ETD.VSL_CD(+)" ).append("\n"); 
		query.append("	  AND VVD.SKD_VOY_NO = VPS_ETD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("	  AND VVD.SKD_DIR_CD = VPS_ETD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("	  AND VVD.POL_CD     = VPS_ETD.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("	  AND NVL(VVD.POL_CLPT_IND_SEQ,1) = VPS_ETD.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("      AND VVD.VSL_CD     = VPS_ETA.VSL_CD(+)" ).append("\n"); 
		query.append("	  AND VVD.SKD_VOY_NO = VPS_ETA.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("	  AND VVD.SKD_DIR_CD = VPS_ETA.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("      AND VVD.POD_CD     = VPS_ETA.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("	  AND NVL(VVD.POD_CLPT_IND_SEQ,1) = VPS_ETA.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("      AND VVD.BKG_NO     = TB.BKG_NO" ).append("\n"); 
		query.append("      AND BKG.BKG_NO     = VVD.BKG_NO) V2" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT DECODE(LAG(A.BL_NO) OVER (ORDER BY A.BL_NO), A.BL_NO, 0, 1) AS SEQ" ).append("\n"); 
		query.append("      ,A.*" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT DECODE(BL.BL_NO, NULL, 'N', 'Y') AS DOWN_YN" ).append("\n"); 
		query.append("      ,BKG.BKG_NO" ).append("\n"); 
		query.append("      ,BKG.BL_NO" ).append("\n"); 
		query.append("      ,CNT.CNTR_NO" ).append("\n"); 
		query.append("      ,VVD.POL_YD_CD" ).append("\n"); 
		query.append("      ,VVD.POL_CD" ).append("\n"); 
		query.append("      ,VVD.POD_CD" ).append("\n"); 
		query.append("      ,VVD.POD_YD_CD" ).append("\n"); 
		query.append("      ,BKG.DEL_CD" ).append("\n"); 
		query.append("      ,VVD.VSL_CD" ).append("\n"); 
		query.append("      ,VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("      ,VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(LOG.SND_DT, 'YYYY-MM-DD HH24:MI') AS SND_DT" ).append("\n"); 
		query.append("      ,LOG.CRE_USR_ID" ).append("\n"); 
		query.append("      ,VSL.VSL_ENG_NM" ).append("\n"); 
		query.append("      ,VSL.LLOYD_NO" ).append("\n"); 
		query.append("      ,VSL.CALL_SGN_NO" ).append("\n"); 
		query.append("      ,TO_CHAR(SKD.VPS_ETA_DT,'YYYY-MM-DD HH24:MI') AS ETA_DT" ).append("\n"); 
		query.append("      ,TO_CHAR(SKD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') AS ETD_DT" ).append("\n"); 
		query.append("      ,@[mode_type] AS MODE_TYPE" ).append("\n"); 
		query.append("      ,ROW_NUMBER() OVER (PARTITION BY CNT.BKG_NO, CNT.CNTR_NO  ORDER BY LOG.SND_DT DESC) AS RNUM" ).append("\n"); 
		query.append("      ,BL.IN_TZ_FLG AS IN_TZ_FLG" ).append("\n"); 
		query.append("  FROM BKG_BOOKING           BKG" ).append("\n"); 
		query.append("      ,BKG_VVD               VVD" ).append("\n"); 
		query.append("      ,BKG_CONTAINER         CNT" ).append("\n"); 
		query.append("      ,VSK_VSL_PORT_SKD      SKD" ).append("\n"); 
		query.append("      ,MDM_VSL_CNTR          VSL" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ARG_BL      BL" ).append("\n"); 
		query.append("      ,BKG_CSTMS_ARG_SND_LOG LOG" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO       = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("   AND BKG.BKG_NO       = CNT.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO   = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD   = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND BKG.BL_NO        = BL.BL_NO(+)" ).append("\n"); 
		query.append("   AND BL.BL_NO         = LOG.BL_NO(+)" ).append("\n"); 
		query.append("   AND LOG.IO_BND_CD(+) = @[mode_type]" ).append("\n"); 
		query.append("   AND SKD.VSL_CD       = VSL.VSL_CD" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("   AND BKG.BL_NO        = @[bl_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO   = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD   = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    #if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND VVD.POD_CD       = @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND VVD.POL_CD       = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pod_yd_cd} != '') " ).append("\n"); 
		query.append("   AND VVD.POD_YD_CD    = @[pod_yd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${pol_yd_cd} != '') " ).append("\n"); 
		query.append("   AND VVD.POL_YD_CD    = @[pol_yd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#if (${mode_type} == 'I')" ).append("\n"); 
		query.append("   AND VVD.POD_CD       = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVD.POD_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VVD.POL_CD       = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) A" ).append("\n"); 
		query.append(" WHERE RNUM = 1" ).append("\n"); 
		query.append(") TB" ).append("\n"); 
		query.append(")MAIN)MAIN2" ).append("\n"); 

	}
}