/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOEur24RcvMsgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.21
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.12.21 김경섭
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

public class Eur24ManifestDownloadDBDAOEur24RcvMsgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24ManifestDownloadDBDAOEur24RcvMsgVORSQL
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOEur24RcvMsgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOEur24RcvMsgVORSQL").append("\n"); 
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
		query.append("/* 	VO */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("' ' AS RJCT_RSN_RMK" ).append("\n"); 
		query.append(", ' ' AS EUR_CSTMS_RJCT_CD" ).append("\n"); 
		query.append(", ' ' AS EDI_RCV_MSG_CTNT" ).append("\n"); 
		query.append(", ' ' AS ACK_RCV_STS_CD" ).append("\n"); 
		query.append(", ' ' AS COLUMN1" ).append("\n"); 
		query.append(", ' ' AS REMARK1" ).append("\n"); 
		query.append(", ' ' AS ERR_IMG" ).append("\n"); 
		query.append(", ' ' AS ERR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}