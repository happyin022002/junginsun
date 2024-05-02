/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : JapanManifestListDownloadDBDAOsearchDorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
	  * 
	  * </pre>
	  */
	public JapanManifestListDownloadDBDAOsearchDorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration").append("\n"); 
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
		query.append("SELECT NVL(C.BL_NO, ' ') AS BL_NO," ).append("\n"); 
		query.append("       NVL(A.JP_DO_ID, A.DO_NO) AS DO_NO," ).append("\n"); 
		query.append("       B.CY_OPR_ID AS CY_OPR_CD," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       D.EVNT_USR_ID," ).append("\n"); 
		query.append("       D.EVNT_OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_DO A," ).append("\n"); 
		query.append("       BKG_CSTMS_JP_BL B," ).append("\n"); 
		query.append("       BKG_BOOKING C," ).append("\n"); 
		query.append("       BKG_JP_DO_IF D" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND D.JP_DO_SND_STS_CD = 'R'" ).append("\n"); 
		query.append("   AND C.BL_NO = B.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" GROUP BY NVL(C.BL_NO, ' ')," ).append("\n"); 
		query.append("       NVL(A.JP_DO_ID, A.DO_NO)," ).append("\n"); 
		query.append("       B.CY_OPR_ID," ).append("\n"); 
		query.append("       A.BKG_NO," ).append("\n"); 
		query.append("       D.EVNT_USR_ID," ).append("\n"); 
		query.append("       D.EVNT_OFC_CD" ).append("\n"); 

	}
}