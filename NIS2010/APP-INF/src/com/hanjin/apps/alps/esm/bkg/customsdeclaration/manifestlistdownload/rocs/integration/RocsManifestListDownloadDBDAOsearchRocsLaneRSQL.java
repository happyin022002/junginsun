/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchRocsLaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.19 
* 1.0 Creation
* ---------------------------------------------------
* History
* 2011.10.19 김보배 [CHM-201113922] [BKG] [ROCS] ADD Lane - 하드코딩 제거, lane 추가 테이블 관리
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchRocsLaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchRocsLane
	  * 2011.10.19 김보배 [CHM-201113922] [BKG] [ROCS] ADD Lane - 하드코딩 제거, lane 추가 테이블 관리
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchRocsLaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchRocsLaneRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	HRD_CDG_ID" ).append("\n"); 
		query.append(",	HRD_CDG_ID_SEQ" ).append("\n"); 
		query.append(",	ATTR_CTNT1" ).append("\n"); 
		query.append(",	ATTR_CTNT2" ).append("\n"); 
		query.append(",	ATTR_CTNT3" ).append("\n"); 
		query.append(",	ATTR_CTNT4" ).append("\n"); 
		query.append(",	ATTR_CTNT5" ).append("\n"); 
		query.append(",	ATTR_CTNT6" ).append("\n"); 
		query.append(",	ATTR_CTNT7" ).append("\n"); 
		query.append(",	ATTR_CTNT8" ).append("\n"); 
		query.append(",	ATTR_CTNT9" ).append("\n"); 
		query.append(",	ATTR_CTNT10" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("WHERE HRD_CDG_ID = 'ROCS_CSTMS_SLAN_CD'" ).append("\n"); 

	}
}