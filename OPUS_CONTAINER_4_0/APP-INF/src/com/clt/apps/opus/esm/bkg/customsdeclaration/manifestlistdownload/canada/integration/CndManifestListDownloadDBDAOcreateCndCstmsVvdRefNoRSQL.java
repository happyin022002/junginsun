/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.03.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM MINJUNG
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * createCndCstmsVvdRefNo
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(SUBSTR(CVY_REF_NO, 7, 4)),0) as ref_no" ).append("\n"); 
		query.append("   FROM BKG_CSTMS_CND_VSL" ).append("\n"); 
		query.append(" WHERE CVY_REF_NO LIKE '9165' || '%'" ).append("\n"); 

	}
}