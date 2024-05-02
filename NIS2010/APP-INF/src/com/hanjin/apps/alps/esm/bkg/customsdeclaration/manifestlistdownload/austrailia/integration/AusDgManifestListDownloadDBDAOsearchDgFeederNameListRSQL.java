/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AusDgManifestListDownloadDBDAOsearchDgFeederNameListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AusDgManifestListDownloadDBDAOsearchDgFeederNameListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 호주 DG팝업, 위험물 Feeder Name, Lloyd No를 조회한다.
	  * </pre>
	  */
	public AusDgManifestListDownloadDBDAOsearchDgFeederNameListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.integration.temp").append("\n"); 
		query.append("FileName : AusDgManifestListDownloadDBDAOsearchDgFeederNameListRSQL").append("\n"); 
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
		query.append("SELECT ATTR_CTNT1 FEEDER_LLOYD_NO, ATTR_CTNT2 FEEDER_NAME, TRIM(ATTR_CTNT2) || '/' || TRIM(ATTR_CTNT1) DISPLAY" ).append("\n"); 
		query.append(" FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD = 'BE'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = 'EUR_DG_ANR_BARGE'" ).append("\n"); 
		query.append("ORDER BY CSTMS_DIV_ID_SEQ    " ).append("\n"); 

	}
}