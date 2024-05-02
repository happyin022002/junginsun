/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndonesiaManifestListDownloadDBDAOsearchBkgDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndonesiaManifestListDownloadDBDAOsearchBkgDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 인도네시아 세관에 전송할 Manifest Booking Detail 정보를 조회한다.
	  * </pre>
	  */
	public IndonesiaManifestListDownloadDBDAOsearchBkgDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.integration").append("\n"); 
		query.append("FileName : IndonesiaManifestListDownloadDBDAOsearchBkgDetailRSQL").append("\n"); 
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
		query.append("SELECT	BL_NO," ).append("\n"); 
		query.append("VSL_CD||SKD_VOY_NO||SKD_DIR_CD	VVD," ).append("\n"); 
		query.append("POR_CD	POR_CD," ).append("\n"); 
		query.append("POL_CD	POL_CD," ).append("\n"); 
		query.append("POD_CD	POD_CD," ).append("\n"); 
		query.append("DEL_CD	DEL_CD" ).append("\n"); 
		query.append("FROM 	BKG_BOOKING" ).append("\n"); 
		query.append("WHERE	BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}