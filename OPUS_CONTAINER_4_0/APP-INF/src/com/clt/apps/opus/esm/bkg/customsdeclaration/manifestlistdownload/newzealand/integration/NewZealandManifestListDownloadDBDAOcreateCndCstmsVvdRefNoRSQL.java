/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NewZealandManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NewZealandManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.integration").append("\n"); 
		query.append("FileName : NewZealandManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL").append("\n"); 
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
		query.append(" WHERE CVY_REF_NO LIKE '9525' || '%'" ).append("\n"); 

	}
}