/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOsearchManifestVpsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.17
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.02.17 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOsearchManifestVpsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 스리랑카세관 신고용 Manifest Vessel Port Schedule 정보를 조회한다.
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOsearchManifestVpsRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOsearchManifestVpsRSQL").append("\n"); 
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
		query.append("SELECT NVL(TO_CHAR(VPS_ETA_DT,'yyyy-mm-dd'), ' ') vps_ets_dt" ).append("\n"); 
		query.append("	FROM   VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("	WHERE  VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("	AND    SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("	AND    SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("	AND    VPS_PORT_CD    = BKG_GET_BKG_CTMS_CD_FNC('LK','MANI_PORT_CD',1,1)" ).append("\n"); 
		query.append("	AND    NVL(SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("	AND    CLPT_IND_SEQ  = (SELECT  MAX(CLPT_IND_SEQ)" ).append("\n"); 
		query.append("		FROM    VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("		WHERE   VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("		AND     SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("		AND     SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("		AND     VPS_PORT_CD    = BKG_GET_BKG_CTMS_CD_FNC('LK','MANI_PORT_CD',1,1)" ).append("\n"); 
		query.append("		AND     NVL(SKD_CNG_STS_CD,' ') <> 'S')" ).append("\n"); 

	}
}