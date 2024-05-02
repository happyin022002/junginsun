/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchEU24ENSPOFEbyVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.06.28 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchEU24ENSPOFEbyVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchEU24ENSPOFEbyVVDRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchEU24ENSPOFEbyVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchEU24ENSPOFEbyVVDRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  SKD.EU_1ST_PORT_YD_CD AS SEARCH_EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append(", DECODE(SKD.VSL_CD, NULL, NULL, NVL( ENS.CSTMS_YD_CD,SKD.EU_1ST_PORT_YD_CD))   AS EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append(", DECODE(SKD.VSL_CD, NULL, NULL, NVL( ENS.CLPT_IND_SEQ,SKD.CLPT_IND_SEQ))       AS EU_1ST_PORT_CLPT_SEQ" ).append("\n"); 
		query.append(", DECODE(ENS.CSTMS_YD_CD, SKD.EU_1ST_PORT_YD_CD, SKD.EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("                        , NULL, SKD.EU_1ST_PORT_YD_CD                      " ).append("\n"); 
		query.append("                        , ENS.CSTMS_YD_CD ||'('|| SKD.EU_1ST_PORT_YD_CD ||')')  AS EU_1ST_PORT_NAME" ).append("\n"); 
		query.append(", SKD.RN" ).append("\n"); 
		query.append(", ENS.RN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${p_bl_no} != '')" ).append("\n"); 
		query.append(",( SELECT MVMT_REF_NO FROM BKG_CSTMS_EUR_BL WHERE VSL_CD = ENS.VSL_CD AND  SKD_VOY_NO = ENS.SKD_VOY_NO AND SKD_DIR_CD = ENS.SKD_DIR_CD AND CSTMS_YD_CD = ENS.CSTMS_YD_CD AND BL_NO = @[p_bl_no]) AS EDI_MRN" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT SKD.* " ).append("\n"); 
		query.append("     , ROW_NUMBER () OVER ( ORDER BY CLPT_SEQ) RN" ).append("\n"); 
		query.append("  FROM (SELECT A.VSL_CD" ).append("\n"); 
		query.append("             , A.SKD_VOY_NO" ).append("\n"); 
		query.append("             , A.SKD_DIR_CD" ).append("\n"); 
		query.append("             , SLAN_CD" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD AS EU_1ST_PORT" ).append("\n"); 
		query.append("             , A.VPS_PORT_CD" ).append("\n"); 
		query.append("             , A.EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("             , A.CLPT_SEQ" ).append("\n"); 
		query.append("             , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             , CASE WHEN LAG( EU ) OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                         ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) IS NULL" ).append("\n"); 
		query.append("                     AND EU IS NOT NULL" ).append("\n"); 
		query.append("                     AND CLPT_SEQ >1 " ).append("\n"); 
		query.append("                    THEN 'EU1ST'" ).append("\n"); 
		query.append("                END EU_FLAG" ).append("\n"); 
		query.append("          FROM (SELECT A.VSL_CD " ).append("\n"); 
		query.append("                     , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                     , SLAN_CD " ).append("\n"); 
		query.append("                     , A.VPS_PORT_CD " ).append("\n"); 
		query.append("                     , A.YD_CD          AS EU_1ST_PORT_YD_CD " ).append("\n"); 
		query.append("                     , ROW_NUMBER() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD" ).append("\n"); 
		query.append("                                          ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) AS CLPT_SEQ" ).append("\n"); 
		query.append("                     , A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , B.ATTR_CTNT1 EU" ).append("\n"); 
		query.append("                 FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                    , BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                  AND A.VSL_CD = SUBSTR(@[p_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                  AND A.SKD_VOY_NO = SUBSTR(@[p_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                  AND A.SKD_DIR_CD = SUBSTR(@[p_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                  AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("                  AND B.CSTMS_DIV_ID(+)='EU_MEMBER_CNT'" ).append("\n"); 
		query.append("                  AND B.CNT_CD(+) = 'EU'" ).append("\n"); 
		query.append("                  AND SUBSTR(A.VPS_PORT_CD, 1, 2) = B.ATTR_CTNT1(+) ) A ) SKD" ).append("\n"); 
		query.append("         WHERE SKD.EU_FLAG IS NOT NULL" ).append("\n"); 
		query.append(") SKD" ).append("\n"); 
		query.append("FULL OUTER JOIN " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.*" ).append("\n"); 
		query.append("     , ROW_NUMBER() OVER ( ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) RN" ).append("\n"); 
		query.append(" FROM (SELECT DISTINCT A.VSL_CD" ).append("\n"); 
		query.append("            , A.SKD_VOY_NO" ).append("\n"); 
		query.append("            , A.SKD_DIR_CD" ).append("\n"); 
		query.append("            , A.CSTMS_PORT_CD " ).append("\n"); 
		query.append("            , A.CSTMS_YD_CD " ).append("\n"); 
		query.append("            , B.CLPT_SEQ" ).append("\n"); 
		query.append("            , A.CSTMS_CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("         FROM BKG_CSTMS_EUR_BL A " ).append("\n"); 
		query.append("            , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A.VSL_CD= B.VSL_CD(+) " ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("          AND A.CSTMS_PORT_CD = B.VPS_PORT_CD(+) " ).append("\n"); 
		query.append("          AND A.CSTMS_YD_CD = B.YD_CD(+)" ).append("\n"); 
		query.append("          AND A.CSTMS_CLPT_IND_SEQ = B.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("          AND B.CLPT_IND_SEQ(+) = 1" ).append("\n"); 
		query.append("          AND A.VSL_CD = SUBSTR(@[p_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("          AND A.SKD_VOY_NO = SUBSTR(@[p_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("          AND A.SKD_DIR_CD = SUBSTR(@[p_vvd_cd], 9, 1) " ).append("\n"); 
		query.append("      ) A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("      AND CLPT_IND_SEQ IS NOT NULL -- 현재 Double Pofe를 방지하기 위해서 임시로 들어간 로직 후에 삭제 예정" ).append("\n"); 
		query.append(") ENS  -- ENS 내역" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("ON (SKD.VSL_CD = ENS.VSL_CD" ).append("\n"); 
		query.append("    AND SKD.SKD_VOY_NO = ENS.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND SKD.SKD_DIR_CD = ENS.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND SKD.RN = ENS.RN" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}