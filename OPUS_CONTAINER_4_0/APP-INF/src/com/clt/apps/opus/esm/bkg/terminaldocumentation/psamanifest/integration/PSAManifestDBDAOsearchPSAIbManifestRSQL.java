/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PSAManifestDBDAOsearchPSAIbManifestRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSAManifestDBDAOsearchPSAIbManifestRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public PSAManifestDBDAOsearchPSAIbManifestRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.integration").append("\n"); 
		query.append("FileName : PSAManifestDBDAOsearchPSAIbManifestRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       CASE" ).append("\n"); 
		query.append("          WHEN BL_RDY_OFC_CD IS NOT NULL AND BL_RDY_USR_ID IS NOT NULL AND BL_RDY_DT IS NOT NULL" ).append("\n"); 
		query.append("             THEN 'Y'" ).append("\n"); 
		query.append("          ELSE 'Y'" ).append("\n"); 
		query.append("       END AS READY," ).append("\n"); 
		query.append("--       NVL(ISS.BL_RDY_FLG, 'N') AS READY, " ).append("\n"); 
		query.append("       B.POR_CD," ).append("\n"); 
		query.append("       B.POL_CD," ).append("\n"); 
		query.append("       B.POD_CD," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       DECODE(V.POD_CD, B.POD_CD, 'L', 'T') AS TS_IND," ).append("\n"); 
		query.append("       B.RC_FLG," ).append("\n"); 
		query.append("       B.DCGO_FLG," ).append("\n"); 
		query.append("       B.AWK_CGO_FLG," ).append("\n"); 
		query.append("       B.BB_CGO_FLG," ).append("\n"); 
		query.append("       B.RD_CGO_FLG," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_SGP_SND_LOG) */" ).append("\n"); 
		query.append("               TO_CHAR(SND.SND_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_SGP_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE B.BL_NO = SND.BL_NO" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS SND_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD V," ).append("\n"); 
		query.append("       BKG_BOOKING B," ).append("\n"); 
		query.append("       BKG_CONTAINER C," ).append("\n"); 
		query.append("       BKG_BL_DOC BD," ).append("\n"); 
		query.append("       BKG_CSTMS_PCK_TP_CONV CNV," ).append("\n"); 
		query.append("       BKG_BL_ISS ISS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE V.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND V.POD_CD = 'SGSIN'" ).append("\n"); 
		query.append("   AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("   AND B.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("   AND V.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND V.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND V.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("   AND BD.PCK_TP_CD = CNV.PCK_TP_CD(+)" ).append("\n"); 
		query.append("   AND CNV.CNT_CD(+) = 'SG'" ).append("\n"); 
		query.append("   AND B.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 

	}
}