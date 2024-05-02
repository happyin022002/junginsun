/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOIndiaBondListCondVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.03 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaManifestListDownloadDBDAOIndiaBondListCondVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IndiaBondListCondVO 생성을 위해
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOIndiaBondListCondVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
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
		query.append("'' CNT_CD" ).append("\n"); 
		query.append(",'' LOC_CD" ).append("\n"); 
		query.append(",'' WH_CD" ).append("\n"); 
		query.append(",'' CSTMS_CD" ).append("\n"); 
		query.append(",'' WH_NM" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration ").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOIndiaBondListCondVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}