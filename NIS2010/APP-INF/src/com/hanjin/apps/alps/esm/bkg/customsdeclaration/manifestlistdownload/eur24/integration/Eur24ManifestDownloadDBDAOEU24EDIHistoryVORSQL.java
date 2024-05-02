/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEU24EDIHistoryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.30
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.12.30 김경섭
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

public class Eur24ManifestDownloadDBDAOEU24EDIHistoryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select 
	  * '' vvd
	  * ,'' cvy_ref_no
	  * from dual
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEU24EDIHistoryVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEU24EDIHistoryVORSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("' ' AS P_VVD" ).append("\n"); 
		query.append(", ' ' AS VVD" ).append("\n"); 
		query.append(", ' ' AS P_VVD" ).append("\n"); 
		query.append(", ' ' AS P_VSL_CD" ).append("\n"); 
		query.append(", ' ' AS P_SKD_VOY_NO" ).append("\n"); 
		query.append(", ' ' AS P_SKD_DIR_CD" ).append("\n"); 
		query.append(", ' ' AS P_CSTMS_PORT_CD" ).append("\n"); 
		query.append(", ' ' AS P_BL_NO" ).append("\n"); 
		query.append(", ' ' AS VSL_CD" ).append("\n"); 
		query.append(", ' ' AS SKD_VOY_NO" ).append("\n"); 
		query.append(", ' ' AS SKD_DIR_CD" ).append("\n"); 
		query.append(", ' ' AS CSTMS_PORT_CD" ).append("\n"); 
		query.append(", ' ' AS BL_NO" ).append("\n"); 
		query.append(", ' ' AS MSG_SND_NO" ).append("\n"); 
		query.append(", ' ' AS TYPE_CD" ).append("\n"); 
		query.append(", ' ' AS LOCAL_TIME" ).append("\n"); 
		query.append(", ' ' AS GMT_TIME" ).append("\n"); 
		query.append(", ' ' AS MSG_TYPE" ).append("\n"); 
		query.append(", ' ' AS RESULT" ).append("\n"); 
		query.append(", ' ' AS BY_ID" ).append("\n"); 
		query.append(", ' ' AS BY_OFC_CD" ).append("\n"); 
		query.append(", ' ' AS BY_NAME" ).append("\n"); 
		query.append(", ' ' AS RCV_MSG" ).append("\n"); 
		query.append(", ' ' AS MSG_IMG" ).append("\n"); 
		query.append(", ' ' AS MRN_NO" ).append("\n"); 
		query.append(", ' ' AS EDI_RCV_DT" ).append("\n"); 
		query.append(", ' ' AS EDI_RCV_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}