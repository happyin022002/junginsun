/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchIBBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchIBBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchIBBkgInfo
	  * </pre>
	  */
	public KorManifestListDBDAOsearchIBBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchIBBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG.BKG_NO BKG_BKG_NO" ).append("\n"); 
		query.append("     , VVD.POL_CD VVD_POL_CD" ).append("\n"); 
		query.append("     , VVD.POD_CD VVD_POD_CD" ).append("\n"); 
		query.append("     , NVL(VVD.SLAN_CD,' ') VVD_SLAN_CD" ).append("\n"); 
		query.append("     , BKG.POD_CD BKG_POD_CD" ).append("\n"); 
		query.append("     , NVL(BKG.BKG_CGO_TP_CD,' ') BKG_CGO_TP_CD" ).append("\n"); 
		query.append("     , SUBSTR(BKG.REP_CMDT_CD,1,2) BKG_REP_CMDT_CD" ).append("\n"); 
		query.append("     , NVL(BKG.BKG_STS_CD,' ') BKG_STS_CD" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD, BKG_BOOKING BKG" ).append("\n"); 
		query.append(" WHERE VVD.VSL_CD        = @[vvd_vsl_cd]" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO    = @[vvd_skd_voy_no]" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD    = @[vvd_skd_dir_cd]" ).append("\n"); 
		query.append("   AND VVD.POD_CD        = @[vvd_pod_cd]" ).append("\n"); 
		query.append("   AND VVD.BKG_NO        = BKG.BKG_NO" ).append("\n"); 
		query.append("   AND BKG.BKG_CGO_TP_CD <> 'PP'" ).append("\n"); 

	}
}