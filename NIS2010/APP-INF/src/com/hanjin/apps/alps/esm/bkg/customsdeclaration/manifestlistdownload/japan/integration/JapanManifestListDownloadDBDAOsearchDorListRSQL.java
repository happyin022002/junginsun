/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchDorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanManifestListDownloadDBDAOsearchDorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchDorList
	  * 1. 2010.12.17 이수진 [CHM-201007493] SEA-NACCS DOR User ID 표시 추가 및 검색 기능 개선 요청		 
	  *    작업내용 : User ID, Office Code 속성 추가
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchDorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
		query.append("FileName : JapanManifestListDownloadDBDAOsearchDorListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(C.BL_NO,' ') BL_NO" ).append("\n"); 
		query.append(", NVL(A.JP_DO_ID,A.DO_NO) DO_NO" ).append("\n"); 
		query.append(", B.CY_OPR_ID CY_OPR_CD" ).append("\n"); 
		query.append(",	A.BKG_NO BKG_NO" ).append("\n"); 
		query.append(",	D.EVNT_USR_ID EVNT_USR_ID" ).append("\n"); 
		query.append(",	D.EVNT_OFC_CD EVNT_OFC_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_DO A" ).append("\n"); 
		query.append(", BKG_CSTMS_JP_BL B" ).append("\n"); 
		query.append(", BKG_BOOKING C" ).append("\n"); 
		query.append(", BKG_JP_DO_IF D" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND    A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND    D.JP_DO_SND_STS_CD = 'R'" ).append("\n"); 
		query.append("AND    C.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("GROUP BY NVL(C.BL_NO,' '), NVL(A.JP_DO_ID,A.DO_NO), B.CY_OPR_ID, A.BKG_NO, D.EVNT_USR_ID, D.EVNT_OFC_CD" ).append("\n"); 

	}
}