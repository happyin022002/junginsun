/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchMdmYardTmlcodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.10.06 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchMdmYardTmlcodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOSearchMdmYardTmlcodeRSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchMdmYardTmlcodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchMdmYardTmlcodeRSQL").append("\n"); 
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
		query.append("/* customsSetupVO */" ).append("\n"); 
		query.append("SELECT A.YD_CD" ).append("\n"); 
		query.append("FROM MDM_YARD A, MDM_LOCATION B" ).append("\n"); 
		query.append("WHERE 1 = 1 AND A.LOC_CD = B.LOC_CD" ).append("\n"); 
		query.append("AND A.LOC_CD LIKE @[p_port]|| '%'" ).append("\n"); 
		query.append("AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}