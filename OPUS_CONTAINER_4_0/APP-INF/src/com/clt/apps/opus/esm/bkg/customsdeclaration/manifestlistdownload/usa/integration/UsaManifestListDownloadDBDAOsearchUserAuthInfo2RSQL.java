/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchUserAuthInfo2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.13
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.11.13 이영헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchUserAuthInfo2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUserAuthInfo2
	  * * History
	  * * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchUserAuthInfo2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchUserAuthInfo2RSQL").append("\n"); 
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
		query.append("SELECT 	A.*" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT 	" ).append("\n"); 
		query.append("	   MAX(AUTH.CNT_CD) CNT_CD" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND AUTH.ACT_ID = 'VVD' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_VVD" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND AUTH.ACT_ID = 'POD' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_POD" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND  AUTH.ACT_ID = 'DEL' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_DEL" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND  AUTH.ACT_ID = 'HUB' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_HUB" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND  AUTH.ACT_ID = 'CSTMS' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_CSTMS" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND  AUTH.ACT_ID = 'FPO' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_FPO" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND  AUTH.ACT_ID = 'MIB' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_MIB" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND  AUTH.ACT_ID = 'PTT' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_PTT" ).append("\n"); 
		query.append("	,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND  AUTH.ACT_ID = 'FTZ' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_FTZ" ).append("\n"); 
		query.append("    ,  SUM(CASE WHEN AUTH.PROC_ID = 'BLI' AND  AUTH.ACT_ID = 'DIV' AND AUTH.CSTMS_AUTH_FLG = 'Y' THEN" ).append("\n"); 
		query.append("	        1" ).append("\n"); 
		query.append("	   ELSE " ).append("\n"); 
		query.append("	        0" ).append("\n"); 
		query.append("	   END) BL_DIV" ).append("\n"); 
		query.append("	,  '' AS MI_HUB" ).append("\n"); 
		query.append("	,  '' AS MI_CSTMS " ).append("\n"); 
		query.append("	,  '' AS USR_ID" ).append("\n"); 
		query.append("	,  '' AS CRE_USR_ID" ).append("\n"); 
		query.append("	,  '' AS CRE_DT" ).append("\n"); 
		query.append("	,  '' AS UPD_USR_ID" ).append("\n"); 
		query.append("	,  '' AS UPD_DT" ).append("\n"); 
		query.append("	,  '' AS USR_NM" ).append("\n"); 
		query.append("	,  '' AS OFC_CD" ).append("\n"); 
		query.append("	,  '' AS COFC_CD" ).append("\n"); 
		query.append("	FROM BKG_CSTMS_COM_USR_AUTH AUTH, COM_USER USR, COM_USER CUSR" ).append("\n"); 
		query.append("	WHERE 1=1 " ).append("\n"); 
		query.append("	  AND AUTH.CNT_CD = NVL(@[cnt_cd],'US')" ).append("\n"); 
		query.append("	  AND AUTH.USR_ID = USR.USR_ID" ).append("\n"); 
		query.append("	  AND AUTH.CRE_USR_ID = CUSR.USR_ID  " ).append("\n"); 
		query.append("	  AND AUTH.USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	  AND USR.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE NOT (A.BL_VVD = 0 AND A.BL_POD = 0 AND A.BL_DEL = 0 AND A.BL_HUB = 0 AND A.BL_CSTMS = 0 AND A.BL_FPO = 0 AND A.BL_MIB = 0 AND A.BL_PTT = 0 )" ).append("\n"); 

	}
}