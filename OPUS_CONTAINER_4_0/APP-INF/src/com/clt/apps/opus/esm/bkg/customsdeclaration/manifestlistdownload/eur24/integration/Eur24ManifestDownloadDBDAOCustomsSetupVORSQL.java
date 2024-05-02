/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOCustomsSetupVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.28
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2011.09.28 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOCustomsSetupVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOCustomsSetupVORSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOCustomsSetupVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOCustomsSetupVORSQL").append("\n"); 
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
		query.append("/* CustomsSetup	VO */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("  ' ' AS P_CNT_CD" ).append("\n"); 
		query.append(", ' ' AS P_PORT" ).append("\n"); 
		query.append(", ' ' AS P_TML" ).append("\n"); 
		query.append(", ' ' AS P_CSTMS_CD" ).append("\n"); 
		query.append(", ' ' AS PORT_CD" ).append("\n"); 
		query.append(", ' ' AS PORT_NM" ).append("\n"); 
		query.append(", ' ' AS PORTS_CD" ).append("\n"); 
		query.append(", ' ' AS TML_CD" ).append("\n"); 
		query.append(", ' ' AS TMLS_CD" ).append("\n"); 
		query.append(", ' ' AS CNT_CD" ).append("\n"); 
		query.append(", ' ' AS YD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS N1ST_EUR_PORT_FLG" ).append("\n"); 
		query.append(", ' ' AS CUSTOMS_CD" ).append("\n"); 
		query.append(", ' ' AS CRE_USR_ID" ).append("\n"); 
		query.append(", ' ' AS CRE_DT" ).append("\n"); 
		query.append(", ' ' AS UPD_USR_ID" ).append("\n"); 
		query.append(", ' ' AS UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS SVC_EXS_YN" ).append("\n"); 
		query.append(", ' ' AS SVC_ENS_YN" ).append("\n"); 
		query.append(", ' ' AS SVC_AN_YN" ).append("\n"); 
		query.append(", ' ' AS SVC_DR_YN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", ' ' AS CT_NAME" ).append("\n"); 
		query.append(", ' ' AS CT_POSITION" ).append("\n"); 
		query.append(", ' ' AS CT_EMAIL" ).append("\n"); 
		query.append(", ' ' AS CT_TEL" ).append("\n"); 
		query.append(", ' ' AS CT_FAX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}