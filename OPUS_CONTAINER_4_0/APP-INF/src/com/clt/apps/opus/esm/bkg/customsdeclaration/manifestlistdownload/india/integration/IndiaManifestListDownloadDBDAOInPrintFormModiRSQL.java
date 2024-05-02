/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaManifestListDownloadDBDAOInPrintFormModiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.17 경종윤
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

public class IndiaManifestListDownloadDBDAOInPrintFormModiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * InPrintFormModiVO 생성을 위해서 사용
	  * </pre>
	  */
	public IndiaManifestListDownloadDBDAOInPrintFormModiRSQL(){
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
		query.append("'' OFC_CD" ).append("\n"); 
		query.append(",'' HDR_CTNT" ).append("\n"); 
		query.append(",'' FTR_CTNT" ).append("\n"); 
		query.append(",'' DECL_ADDR" ).append("\n"); 
		query.append(",'' BOD_CTNT" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' CRE_DT" ).append("\n"); 
		query.append(",'' UPD_USR_ID" ).append("\n"); 
		query.append(",'' UPD_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.india.integration ").append("\n"); 
		query.append("FileName : IndiaManifestListDownloadDBDAOInPrintFormModiRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}