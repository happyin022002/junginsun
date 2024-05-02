/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : NewZealandManifestListDownloadDBDAOsearchCstmsMfListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandManifestListDownloadDBDAOsearchCstmsMfListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandManifestListDownloadDBDAOsearchCstmsMfListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandManifestListDownloadDBDAOsearchCstmsMfListRSQL").append("\n"); 
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
		query.append("SELECT A.POL_CD AS POL," ).append("\n"); 
		query.append("       C.VPS_ETD_DT AS POL_ATD," ).append("\n"); 
		query.append("       A.POD_CD AS POD," ).append("\n"); 
		query.append("       DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, 'N', 'Y'), 'Y') AS BDR," ).append("\n"); 
		query.append("       DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, NULL, TO_CHAR(D.TRNK_MNL_BDR_DT, 'YYYY-MM-DD HH24:MI')), TO_CHAR(D.TRNK_AUTO_BDR_DT, 'YYYY-MM-DD HH24:MI')) AS BDR_DATE," ).append("\n"); 
		query.append("       COUNT(DISTINCT B.BKG_NO) AS BL," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("         WHERE (BL_NO, MSG_SND_NO) IN (SELECT BL_NO," ).append("\n"); 
		query.append("                                              MAX(MSG_SND_NO) OVER(PARTITION BY BL_NO, POL_CD, POD_CD)" ).append("\n"); 
		query.append("                                         FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("                                        WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("            AND POD_CD = A.POD_CD" ).append("\n"); 
		query.append("            AND POL_CD = A.POL_CD" ).append("\n"); 
		query.append(") AS DNLD," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("         WHERE (BL_NO, MSG_SND_NO) IN (SELECT BL_NO," ).append("\n"); 
		query.append("                                              MAX(MSG_SND_NO) OVER(PARTITION BY BL_NO, POL_CD, POD_CD)" ).append("\n"); 
		query.append("                                         FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("                                        WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("           AND POD_CD = A.POD_CD" ).append("\n"); 
		query.append("           AND POL_CD = A.POL_CD" ).append("\n"); 
		query.append("           AND CSTMS_RQST_FLG = 'N') AS ACPT," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("         WHERE (BL_NO, MSG_SND_NO) IN (SELECT BL_NO," ).append("\n"); 
		query.append("                                              MAX(MSG_SND_NO) OVER(PARTITION BY BL_NO, POL_CD, POD_CD)" ).append("\n"); 
		query.append("                                         FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("                                        WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                          AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                          AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("           AND POD_CD = A.POD_CD" ).append("\n"); 
		query.append("           AND POL_CD = A.POL_CD" ).append("\n"); 
		query.append("           AND CSTMS_RQST_FLG = 'Y') AS DIFF," ).append("\n"); 
		query.append("       COUNT(DISTINCT H.CNTR_NO) AS CNTR," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("         WHERE (CNTR_NO, MSG_SND_NO) IN (SELECT CNTR_NO," ).append("\n"); 
		query.append("                                                MAX(MSG_SND_NO) OVER(PARTITION BY CNTR_NO, POL_CD, POD_CD)" ).append("\n"); 
		query.append("                                           FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("                                          WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("           AND POD_CD = A.POD_CD" ).append("\n"); 
		query.append("           AND POL_CD = A.POL_CD" ).append("\n"); 
		query.append(") AS CNTR_DNLD," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("         WHERE (CNTR_NO, MSG_SND_NO) IN (SELECT CNTR_NO," ).append("\n"); 
		query.append("                                                 MAX(MSG_SND_NO) OVER(PARTITION BY CNTR_NO, POL_CD, POD_CD)" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("                                           WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                             AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                             AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("           AND POD_CD = A.POD_CD" ).append("\n"); 
		query.append("           AND POL_CD = A.POL_CD" ).append("\n"); 
		query.append("           AND CSTMS_RQST_FLG = 'N') AS CNTR_ACPT," ).append("\n"); 
		query.append("       (SELECT COUNT(*)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("         WHERE (CNTR_NO, MSG_SND_NO) IN (SELECT CNTR_NO," ).append("\n"); 
		query.append("                                                MAX(MSG_SND_NO) OVER(PARTITION BY CNTR_NO, POL_CD, POD_CD)" ).append("\n"); 
		query.append("                                           FROM BKG_CSTMS_NZL_SND_LOG" ).append("\n"); 
		query.append("                                          WHERE VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                            AND SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                            AND SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("										)" ).append("\n"); 
		query.append("           AND POD_CD = A.POD_CD" ).append("\n"); 
		query.append("           AND POL_CD = A.POL_CD" ).append("\n"); 
		query.append("           AND CSTMS_RQST_FLG = 'Y') AS CNTR_DIFF" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD A," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD C," ).append("\n"); 
		query.append("       BKG_VVD_BDR_LOG D," ).append("\n"); 
		query.append("       BKG_CONTAINER H" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.VSL_CD = SUBSTR( @[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND A.SKD_VOY_NO = SUBSTR( @[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND A.SKD_DIR_CD = SUBSTR( @[vvd], 9, 1) " ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("   AND A.POL_CD = @[pol_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND A.POD_CD LIKE @[pod] || '%'" ).append("\n"); 
		query.append("   AND B.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD IN ('F', 'P')" ).append("\n"); 
		query.append("   AND C.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("   AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND C.VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("   AND C.CLPT_IND_SEQ = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND D.VSL_CD(+) = A.VSL_CD" ).append("\n"); 
		query.append("   AND D.SKD_VOY_NO(+) = A.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND D.SKD_DIR_CD(+) = A.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND D.POL_CLPT_IND_SEQ(+) = A.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND D.POD_CLPT_IND_SEQ(+) = A.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND D.POL_CD(+) = A.POL_CD" ).append("\n"); 
		query.append("   AND D.POD_CD(+) = A.POD_CD" ).append("\n"); 
		query.append("   AND H.BKG_NO(+) = B.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY A.POL_CD," ).append("\n"); 
		query.append("       C.VPS_ETD_DT," ).append("\n"); 
		query.append("       A.POD_CD," ).append("\n"); 
		query.append("       DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, 'N', 'Y'), 'Y')," ).append("\n"); 
		query.append("       DECODE(D.TRNK_AUTO_BDR_DT, NULL, DECODE(D.TRNK_MNL_BDR_DT, NULL, NULL, TO_CHAR(D.TRNK_MNL_BDR_DT, 'YYYY-MM-DD HH24:MI')), TO_CHAR(D.TRNK_AUTO_BDR_DT, 'YYYY-MM-DD HH24:MI'))" ).append("\n"); 

	}
}