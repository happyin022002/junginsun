/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.06
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * createCndCstmsVvdRefNo
	  * </pre>
	  */
	public CndExpManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndExpManifestListDownloadDBDAOcreateCndCstmsVvdRefNoRSQL").append("\n"); 
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
		query.append("   FROM BKG_CSTMS_CND_XPT_VSL" ).append("\n"); 
		query.append(" WHERE CVY_REF_NO LIKE '918P' || '%' " ).append("\n"); 

	}
}