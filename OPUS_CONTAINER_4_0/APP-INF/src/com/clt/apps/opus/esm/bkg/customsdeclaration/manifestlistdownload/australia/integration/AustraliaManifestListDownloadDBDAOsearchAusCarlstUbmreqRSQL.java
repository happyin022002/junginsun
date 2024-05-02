/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AustraliaManifestListDownloadDBDAOsearchAusCarlstUbmreqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.14 
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

public class AustraliaManifestListDownloadDBDAOsearchAusCarlstUbmreqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AustraliaManifestListDownloadDBDAOsearchAusCarlstUbmreqRSQL(){
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
		params.put("search_div",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.integration").append("\n"); 
		query.append("FileName : AustraliaManifestListDownloadDBDAOsearchAusCarlstUbmreqRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT MAX(BKG.BKG_NO) OVER (PARTITION BY CNTR.CNTR_NO) AS BKG_NO," ).append("\n"); 
		query.append("       CNTR.CNTR_NO," ).append("\n"); 
		query.append("       BKG.DE_TERM_CD," ).append("\n"); 
		query.append("       VVD.POL_CD AS VVD_POL," ).append("\n"); 
		query.append("       VVD.POD_CD AS VVD_POD," ).append("\n"); 
		query.append("       BKG.POD_CD AS BKG_POD,  " ).append("\n"); 
		query.append("       BKG.DEL_CD AS BKG_DEL," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_AUS_SND_LOG) */" ).append("\n"); 
		query.append("               TO_CHAR(SND.SND_DT, 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_AUS_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE SND.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("           AND SND.AUS_SND_LOG_ID = @[search_div]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS SND_DT," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_AUS_SND_LOG) */" ).append("\n"); 
		query.append("#if (${search_div} == 'UBMREQ')" ).append("\n"); 
		query.append("               CASE WHEN LOG_FLG = 'N' THEN 'Sending'" ).append("\n"); 
		query.append("                    WHEN CSTMS_RQST_FLG = 'Y' THEN 'Error'" ).append("\n"); 
		query.append("                    ELSE 'Success'" ).append("\n"); 
		query.append("               END" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("               DECODE(CSTMS_RQST_FLG, 'Y', 'Error', 'Success')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_AUS_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE SND.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("           AND SND.AUS_SND_LOG_ID = @[search_div]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS RCV_RSLT," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_AUS_SND_LOG) */" ).append("\n"); 
		query.append("               SND.EDI_REF_ID" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_AUS_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE SND.CNTR_NO = CNTR.CNTR_NO" ).append("\n"); 
		query.append("           AND SND.AUS_SND_LOG_ID = @[search_div]" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS EDI_REF_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD," ).append("\n"); 
		query.append("       BKG_CONTAINER CNTR," ).append("\n"); 
		query.append("       BKG_BOOKING BKG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("   AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("   AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD NOT IN ('S', 'X')" ).append("\n"); 
		query.append("#if (${search_div} == 'UBMREQ')" ).append("\n"); 
		query.append("   AND BKG.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND BKG.BKG_CGO_TP_CD != 'F'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("   AND BKG.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND CNTR.BKG_NO = BKG.BKG_NO" ).append("\n"); 

	}
}