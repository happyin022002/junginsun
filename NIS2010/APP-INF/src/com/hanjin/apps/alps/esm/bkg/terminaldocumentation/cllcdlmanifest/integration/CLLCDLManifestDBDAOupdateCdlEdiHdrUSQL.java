/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CLLCDLManifestDBDAOupdateCdlEdiHdrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.10
*@LastModifier : 
*@LastVersion : 1.0
* 2012.09.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOupdateCdlEdiHdrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updateCdlEdiHdr
	  * </pre>
	  */
	public CLLCDLManifestDBDAOupdateCdlEdiHdrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n"); 
		query.append("FileName : CLLCDLManifestDBDAOupdateCdlEdiHdrUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_TML_EDI_GEN_TMP" ).append("\n"); 
		query.append("SET TML_EDI_CTNT = (SELECT REPLACE(TML_EDI_CTNT, 'BRAC:O', 'BRAC:A')" ).append("\n"); 
		query.append("					FROM BKG_CSTMS_TML_EDI_GEN_TMP" ).append("\n"); 
		query.append("					WHERE N1ST_EDI_GEN_ORD_NO = 0)" ).append("\n"); 
		query.append("WHERE N1ST_EDI_GEN_ORD_NO = 0" ).append("\n"); 

	}
}