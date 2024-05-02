/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AncsManifestListDownloadDBDAOAncsVesselArrivalVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsManifestListDownloadDBDAOAncsVesselArrivalVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AncsVesselArrivalVO 생성을 위해 사용
	  * </pre>
	  */
	public AncsManifestListDownloadDBDAOAncsVesselArrivalVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.integration").append("\n"); 
		query.append("FileName : AncsManifestListDownloadDBDAOAncsVesselArrivalVORSQL").append("\n"); 
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
		query.append("     '' USER_DATE" ).append("\n"); 
		query.append("    ,'' ETA_CALL_DATE" ).append("\n"); 
		query.append("    ,'' BERTH_CODE" ).append("\n"); 
		query.append("    ,'' BKG_TTL" ).append("\n"); 
		query.append("    ,'' REMARK" ).append("\n"); 
		query.append("    ,'' VSL_FLAG" ).append("\n"); 
		query.append("    ,'' LLOYD_TYPE" ).append("\n"); 
		query.append("    ,'' VSL_NAME" ).append("\n"); 
		query.append("    ,'' CRSREP" ).append("\n"); 
		query.append("    ,'' LAST_EDI" ).append("\n"); 
		query.append("    ,'' SSR_NO" ).append("\n"); 
		query.append("    ,'' VVD" ).append("\n"); 
		query.append("    ,'' DEMDET_FREE_TIME" ).append("\n"); 
		query.append("    ,'' LLOYD_NO" ).append("\n"); 
		query.append("    ,'' DNLD_TTL" ).append("\n"); 
		query.append("    ,'' USER_ID" ).append("\n"); 
		query.append("    ,'' PRV_PROT" ).append("\n"); 
		query.append("    ,'' POD" ).append("\n"); 
		query.append("    ,'' SLAN_CD" ).append("\n"); 
		query.append("    ,'' OLD_SSR_NO" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}