/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchEu1stPortByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.14
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.01.14 김보배
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

public class Eur24ManifestDownloadDBDAOSearchEu1stPortByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchEu1stPortByVvdRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchEu1stPortByVvdRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchEu1stPortByVvdRSQL").append("\n"); 
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
		query.append("SELECT *" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD, SLAN_CD" ).append("\n"); 
		query.append("        ,A.VPS_PORT_CD AS EU_1ST_PORT" ).append("\n"); 
		query.append("        ,A.VPS_PORT_CD" ).append("\n"); 
		query.append("        ,A.EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("        ,A.CLPT_IND_SEQ      AS EU_1ST_PORT_CLPT_SEQ" ).append("\n"); 
		query.append("        ,A.EU_1ST_PORT_YD_CD AS EU_1ST_PORT_NAME" ).append("\n"); 
		query.append("        ,A.EU_1ST_PORT_YD_CD AS SEARCH_EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("		,A.CLPT_SEQ" ).append("\n"); 
		query.append("        , CASE WHEN LAG( EU ) OVER (PARTITION BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD ORDER BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.CLPT_SEQ  ) IS NULL" ).append("\n"); 
		query.append("                AND EU IS NOT NULL " ).append("\n"); 
		query.append("                AND CLPT_SEQ >1" ).append("\n"); 
		query.append("          THEN 'EU1ST' " ).append("\n"); 
		query.append("        END EU_Flag" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("            A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD, SLAN_CD" ).append("\n"); 
		query.append("            ,A.VPS_PORT_CD" ).append("\n"); 
		query.append("            ,A.YD_CD AS EU_1ST_PORT_YD_CD" ).append("\n"); 
		query.append("            ,A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("            , ROW_NUMBER() OVER (PARTITION BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD ORDER BY A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD,A.CLPT_SEQ  ) CLPT_SEQ" ).append("\n"); 
		query.append("            ,B.ATTR_CTNT1 EU" ).append("\n"); 
		query.append("            FROM   VSK_VSL_PORT_SKD A , BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND A.VSL_CD     = SUBSTR(@[p_vvd_cd], 1, 4)" ).append("\n"); 
		query.append("            AND A.SKD_VOY_NO = SUBSTR(@[p_vvd_cd], 5, 4)" ).append("\n"); 
		query.append("            AND A.SKD_DIR_CD = SUBSTR(@[p_vvd_cd], 9, 1)" ).append("\n"); 
		query.append("            AND NVL(SKD_CNG_STS_CD,'X')  <> 'S'" ).append("\n"); 
		query.append("            AND B.CSTMS_DIV_ID(+)='EU_MEMBER_CNT' " ).append("\n"); 
		query.append("            AND B.CNT_CD(+) = 'EU'" ).append("\n"); 
		query.append("            AND SUBSTR(A.VPS_PORT_CD,1,2) = B.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("           ) A" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE EU_FLAG IS NOT NULL" ).append("\n"); 

	}
}