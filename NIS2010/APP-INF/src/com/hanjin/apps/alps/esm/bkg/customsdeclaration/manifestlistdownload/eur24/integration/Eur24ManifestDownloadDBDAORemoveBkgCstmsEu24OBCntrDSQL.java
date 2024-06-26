/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCntrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.16
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.06.16 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCntrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCntrDSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCntrDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAORemoveBkgCstmsEu24OBCntrDSQL").append("\n"); 
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
		query.append("DELETE BKG_CSTMS_EUR_IO_CNTR" ).append("\n"); 
		query.append("WHERE (BND_TP_CD,VSL_CD, SKD_VOY_NO, SKD_DIR_CD,  BL_NO, CSTMS_PORT_CD)" ).append("\n"); 
		query.append("IN ( SELECT 'O' " ).append("\n"); 
		query.append("          , BKG_GET_TOKEN_FNC(COLUMN_VALUE,1)" ).append("\n"); 
		query.append("          , BKG_GET_TOKEN_FNC(COLUMN_VALUE,2)" ).append("\n"); 
		query.append("          , BKG_GET_TOKEN_FNC(COLUMN_VALUE,3)" ).append("\n"); 
		query.append("          , BKG_GET_TOKEN_FNC(COLUMN_VALUE,4)" ).append("\n"); 
		query.append("          , BKG_GET_TOKEN_FNC(COLUMN_VALUE,5)" ).append("\n"); 
		query.append("    FROM TABLE(BKG_SPLIT_CLOB_FNC(${cntr_list},'@'))" ).append("\n"); 
		query.append("    WHERE COLUMN_VALUE IS NOT NULL" ).append("\n"); 
		query.append("    ) " ).append("\n"); 

	}
}