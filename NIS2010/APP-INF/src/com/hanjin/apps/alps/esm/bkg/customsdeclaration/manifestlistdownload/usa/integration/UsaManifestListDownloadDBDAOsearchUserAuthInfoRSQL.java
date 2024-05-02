/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOsearchUserAuthInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOsearchUserAuthInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOsearchUserAuthInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOsearchUserAuthInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("USR_ID" ).append("\n"); 
		query.append(",	USR_NM" ).append("\n"); 
		query.append(",	CNT_CD" ).append("\n"); 
		query.append(",	OFC_CD" ).append("\n"); 
		query.append(",    CASE WHEN USR_ID IN ('SDS_KOR', '110804', 'EDI_KOR', '110039', '110035', '04900013', '03191005', '03206014', '03206015', '03206030') THEN 'Y' ELSE 'N' END OFM_AUTH" ).append("\n"); 
		query.append(",   (SELECT COUNT(USR_ID) FROM BKG_CSTMS_COM_USR_AUTH WHERE USR_ID = A.USR_ID AND CSTMS_AUTH_FLG = 'Y') AUTH_COUNT" ).append("\n"); 
		query.append("FROM COM_USER A" ).append("\n"); 
		query.append("WHERE	USR_ID = @[usr_id]" ).append("\n"); 

	}
}