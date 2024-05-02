/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Jp24ManifestListDownloadDBDAOSearchOrgBlForBllRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Jp24ManifestListDownloadDBDAOSearchOrgBlForBllRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public Jp24ManifestListDownloadDBDAOSearchOrgBlForBllRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration").append("\n"); 
		query.append("FileName : Jp24ManifestListDownloadDBDAOSearchOrgBlForBllRSQL").append("\n"); 
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
		query.append("SELECT ADVBL.BL_NO," ).append("\n"); 
		query.append("       ADVBL.VSL_CD||ADVBL.SKD_VOY_NO||ADVBL.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       ADVBL.POL_CD," ).append("\n"); 
		query.append("       ADVBL.POD_CD," ).append("\n"); 
		query.append("       ADVBL.PCK_QTY," ).append("\n"); 
		query.append("       ADVBL.GRS_WGT," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_ADV_JP_SND_LOG) */" ).append("\n"); 
		query.append("               SND.JP_SND_LOG_ID" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE ADVBL.BL_NO = SND.BL_NO(+)" ).append("\n"); 
		query.append("           AND SND.JP_SND_LOG_ID(+) NOT LIKE 'BLL%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS A_S_TYPE," ).append("\n"); 
		query.append("       (SELECT /*+ INDEX_DESC(SND XAK1BKG_CSTMS_ADV_JP_SND_LOG) */" ).append("\n"); 
		query.append("               TO_CHAR(SND.SND_DT, 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_JP_SND_LOG SND" ).append("\n"); 
		query.append("         WHERE ADVBL.BL_NO = SND.BL_NO(+)" ).append("\n"); 
		query.append("           AND SND.JP_SND_LOG_ID(+) NOT LIKE 'BLL%'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS S_DT," ).append("\n"); 
		query.append("       DECODE(RLT.SND_STS_CD, 'N', 'New', 'D', 'Delete', '') AS BLL_SND_STS_CD," ).append("\n"); 
		query.append("       TO_CHAR(RLT.SND_DT, 'YYYY-MM-DD HH24:MI') AS BLL_SND_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_JP_BL ADVBL," ).append("\n"); 
		query.append("       BKG_CSTMS_ADV_JP_BL_RLT RLT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE ADVBL.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("   AND RLT.BL_NO(+) = ADVBL.BL_NO" ).append("\n"); 
		query.append("   AND RLT.SND_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}