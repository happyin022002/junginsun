/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchCstmsOfficeIdByportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchCstmsOfficeIdByportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_CSTMS_EUR_CD_STUP에서 port_cd로 TML_CD검색
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchCstmsOfficeIdByportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchCstmsOfficeIdByportRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("  PORT_CD RVIS_N1ST_CLPT_CD," ).append("\n"); 
		query.append("  --SUBSTR(TML_CD, LENGTH(PORT_CD), 2) TML_CD," ).append("\n"); 
		query.append("  TML_CD," ).append("\n"); 
		query.append("  EUR_CSTMS_OFC_ID N1ST_PORT_OFC_CD_NEW" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_CD_STUP" ).append("\n"); 
		query.append("WHERE PORT_CD = @[port_cd]" ).append("\n"); 

	}
}