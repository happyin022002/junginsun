/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GhanaManifestListDownloadDBDAOsearchVesselRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2012.04.25 김보배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GhanaManifestListDownloadDBDAOsearchVesselRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 가나 세관에 적하목록을 신고하기 위해 Vessel 정보를 조회한다.
	  * </pre>
	  */
	public GhanaManifestListDownloadDBDAOsearchVesselRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.integration").append("\n"); 
		query.append("FileName : GhanaManifestListDownloadDBDAOsearchVesselRSQL").append("\n"); 
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
		query.append("SELECT NVL(VS.VSL_ENG_NM,' ')                       AS VSL_ENG_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${pod_cd}!= '')" ).append("\n"); 
		query.append("    	, NVL(TO_CHAR(VP.VPS_ETA_DT,'YYYY-MM-DD'),' ') AS ETA_DT" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("	#if (${pol_cd}!= '') " ).append("\n"); 
		query.append("    	, NVL(TO_CHAR(VP.VPS_ETD_DT,'YYYY-MM-DD'),' ') AS ETD_DT" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" FROM MDM_VSL_CNTR      VS" ).append("\n"); 
		query.append("    , VSK_VSL_PORT_SKD  VP " ).append("\n"); 
		query.append("WHERE VP.VSL_CD        = SUBSTR(@[vvd_cd],1 , 4) " ).append("\n"); 
		query.append("  AND VP.SKD_VOY_NO    = SUBSTR(@[vvd_cd],5 , 4) " ).append("\n"); 
		query.append("  AND VP.SKD_DIR_CD    = SUBSTR(@[vvd_cd],9 , 1) " ).append("\n"); 
		query.append("  AND VS.VSL_CD = VP.VSL_CD" ).append("\n"); 
		query.append("  AND VP.VPS_PORT_CD = NVL(@[pol_cd], @[pod_cd])" ).append("\n"); 

	}
}