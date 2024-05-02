/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SriLankaManifestListDownloadDBDAOcreVesselRegistNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.27 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LIM JAE TAEK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SriLankaManifestListDownloadDBDAOcreVesselRegistNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Registration No 자동생성
	  * </pre>
	  */
	public SriLankaManifestListDownloadDBDAOcreVesselRegistNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.integration").append("\n"); 
		query.append("FileName : SriLankaManifestListDownloadDBDAOcreVesselRegistNoCSQL").append("\n"); 
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
		query.append("SELECT 'V'||DECODE(SIGN(10 - YY), 1, TO_CHAR(YY), CHR(YY+55))||DECODE(MM,10,'A',11,'B',12,'C', TO_CHAR(MM))||DD||TO_CHAR(SYSDATE,'HH24MISS')  vessel_regist_no" ).append("\n"); 
		query.append("FROM   (SELECT TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),3,2))YY," ).append("\n"); 
		query.append("TO_NUMBER(SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),5,2))MM," ).append("\n"); 
		query.append("SUBSTR(TO_CHAR(SYSDATE,'YYYYMMDD'),7,2) DD" ).append("\n"); 
		query.append("FROM   DUAL)" ).append("\n"); 

	}
}