/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearch1stEUvvdByBLRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.17
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.06.17 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearch1stEUvvdByBLRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearch1stEUvvdByBLRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearch1stEUvvdByBLRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearch1stEUvvdByBLRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD,SKD_VOY_NO,SKD_DIR_CD,SLAN_CD,EU_1ST_PORT,EU_1ST_PORT_YD_CD, POL, POL_YD_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("         A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD, SLAN_CD" ).append("\n"); 
		query.append("        ,A.VPS_PORT_CD AS EU_1ST_PORT" ).append("\n"); 
		query.append("        ,A.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,A.EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("		,A.CLPT_SEQ" ).append("\n"); 
		query.append("        , POL, POL_YD_CD" ).append("\n"); 
		query.append("        , A.VSL_PRE_PST_CD, A.VSL_SEQ" ).append("\n"); 
		query.append("        , CASE WHEN LAG( EU ) OVER (PARTITION BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD ORDER BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.CLPT_SEQ  ) IS NULL" ).append("\n"); 
		query.append("                    AND EU IS NOT NULL " ).append("\n"); 
		query.append("                    AND CLPT_SEQ >1" ).append("\n"); 
		query.append("              THEN 'EU1ST' " ).append("\n"); 
		query.append("          END EU_Flag" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                 A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD, A.SLAN_CD" ).append("\n"); 
		query.append("                ,A.VPS_PORT_CD" ).append("\n"); 
		query.append("                ,A.YD_CD AS EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("                ,ROW_NUMBER() OVER (PARTITION BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD ORDER BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.CLPT_SEQ  ) CLPT_SEQ" ).append("\n"); 
		query.append("                ,B.ATTR_CTNT1 EU" ).append("\n"); 
		query.append("                ,D.POL_CD                AS POL" ).append("\n"); 
		query.append("                ,SUBSTR(D.POL_YD_CD, -2) AS POL_YD_CD" ).append("\n"); 
		query.append("                , D.VSL_PRE_PST_CD, D.VSL_SEQ" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD A1" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD A2" ).append("\n"); 
		query.append("             , BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("             , BKG_BOOKING C" ).append("\n"); 
		query.append("             , BKG_VVD D" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND C.BL_NO = @[p_bl_no]" ).append("\n"); 
		query.append("           AND C.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("           AND D.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("           AND D.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND D.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND NVL(a.SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("           AND B.CSTMS_DIV_ID(+)='EU_MEMBER_CNT'" ).append("\n"); 
		query.append("           AND B.CNT_CD(+) = 'EU'" ).append("\n"); 
		query.append("           AND SUBSTR(A.VPS_PORT_CD,1,2) = B.ATTR_CTNT1(+) " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        AND A.SLAN_CD <> 'GSE'" ).append("\n"); 
		query.append("		AND D.VSL_CD      = A2.VSL_CD" ).append("\n"); 
		query.append("		AND D.SKD_VOY_NO  = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND D.SKD_DIR_CD  = A2.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND D.POD_CD 		= A2.VPS_PORT_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		AND D.VSL_CD      = A1.VSL_CD" ).append("\n"); 
		query.append("		AND D.SKD_VOY_NO  = A1.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND D.SKD_DIR_CD  = A1.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND D.POL_CD 		= A1.VPS_PORT_CD" ).append("\n"); 
		query.append("		AND A.CLPT_SEQ BETWEEN A1.CLPT_SEQ AND  A2.CLPT_SEQ  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	 ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE EU_FLAG IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY VSL_PRE_PST_CD, VSL_SEQ" ).append("\n"); 

	}
}